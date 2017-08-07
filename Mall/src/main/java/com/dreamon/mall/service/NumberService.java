package com.dreamon.mall.service;

import com.dreamon.mall.service.entity.NumberEntity;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by qiumengsong on 2017/8/7.
 */
@Component
public class NumberService {

    private final int numberLength;
    private final int numberModel;
    private Random random = new Random();

    public NumberService(int numberLength,int numberModel) {
        this.numberLength = numberLength;
        this.numberModel = numberModel;
    }

    /**
     * 带英语前缀,用于商品编号
     */
    public static final int NUMBER_WITH_WORD = 1;
    /**
     * 不带英语前缀
     */
    public static final int NUMBER_ONLY = 0;

    /**
     * 获取编号
     * @param id
     * @return
     */
    public String getNumber(int id){
        NumberEntity entity = new NumberEntity();
        int idLength = getIdLength(id);
        if (idLength > numberLength){
            return id + "";
        }
        entity.setTail(id);
        entity.setFirst(idLength);
        entity.setMeddile(getRandom(numberLength-idLength-1));
        return entity.toString();
    }

    private int getIdLength(int id){
        return (""+id).length();
    }


    @Deprecated
    private int getRandom2(int length){
        String time = System.currentTimeMillis() + "";
        return Integer.parseInt(time.substring(time.length()-length ,time.length()));
    }

//    public static void main(String[] args){
//        NumberService service = new NumberService(0);
//        System.out.println();
//
//        Random random = new Random();
//
//        long start = System.currentTimeMillis();
//        for (int i=0 ;i<100000;i++){
//            service.getRandom(5);
//            if (i % 10000 == 0){
//                System.out.println("10000执行完毕");
//            }
//        }
//        long end = System.currentTimeMillis();
//        System.out.println("用时:"+(end - start));
//
//        for (int i=0 ;i<100000;i++){
//            service.getRandom2(5);
//            if (i % 10000 == 0){
//                System.out.println("10000执行完毕");
//            }
//        }
//        start = System.currentTimeMillis();
//        System.out.println("用时:"+(start - end));
//    }

    private int getRandom(int length){
        int result = 0;
        for (int i = 0;i<length ;i++){
            result = (result * 10) + (random.nextInt(9) + 1);
        }
        return result;
    }

}
