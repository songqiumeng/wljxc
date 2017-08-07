package com.dreamon.mall.db.entity;

import com.dreamon.mall.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by qiumengsong on 2017/8/6.
 */
@Entity
@Table(name = "wljxc_shoppingcar")
public class ShoppingCar extends BaseEntity {

    static {
        String[] indexes = {"id","goodid","price","number","userid","viewprice",
                "ispaid","hastip","name","addtime"
        };
        for (String index :
                indexes) {
            column.add(index);
        }
    }

    @Id
    private int id;
    private int goodid;
    private int price;
    private int number;
    private int userid;
    private int viewprice;
    private int ispaid;
    private int hastip;
    private String name;
    private Timestamp addtime;

    @Override
    public String toString() {
        return "ShoppingCar{" +
                "id=" + id +
                ", goodid=" + goodid +
                ", price=" + price +
                ", number=" + number +
                ", userid=" + userid +
                ", viewprice=" + viewprice +
                ", ispaid=" + ispaid +
                ", hastip=" + hastip +
                ", name='" + name + '\'' +
                ", addtime=" + addtime +
                '}';
    }

    public ShoppingCar(int goodid, int price, int number, int userid, int viewprice, int ispaid, int hastip, String name, Timestamp addtime) {
        this.goodid = goodid;
        this.price = price;
        this.number = number;
        this.userid = userid;
        this.viewprice = viewprice;
        this.ispaid = ispaid;
        this.hastip = hastip;
        this.name = name;
        this.addtime = addtime;
    }

    public ShoppingCar(int id, int goodid, int price, int number, int userid, int viewprice, int ispaid, int hastip, String name, Timestamp addtime) {
        this.id = id;
        this.goodid = goodid;
        this.price = price;
        this.number = number;
        this.userid = userid;
        this.viewprice = viewprice;
        this.ispaid = ispaid;
        this.hastip = hastip;
        this.name = name;
        this.addtime = addtime;
    }

    public ShoppingCar() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getGoodid() {
        return goodid;
    }

    public void setGoodid(int goodid) {
        this.goodid = goodid;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getViewprice() {
        return viewprice;
    }

    public void setViewprice(int viewprice) {
        this.viewprice = viewprice;
    }

    public int getIspaid() {
        return ispaid;
    }

    public void setIspaid(int ispaid) {
        this.ispaid = ispaid;
    }

    public int getHastip() {
        return hastip;
    }

    public void setHastip(int hastip) {
        this.hastip = hastip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getAddtime() {
        return addtime;
    }

    public void setAddtime(Timestamp addtime) {
        this.addtime = addtime;
    }
}
