package com.dreamon.mall.db.entity;

import com.dreamon.mall.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.HashMap;

/**
 * Created by qiumengsong on 2017/8/6.
 */
@Entity
@Table(name = "wljxc_goodimg")
public class GoodImg extends BaseEntity {

    static {
        String[] indexes = {"id","goodid","imgid"};
        for (String index :
                indexes) {
            column.add(index);
        }
    }

    public GoodImg() {
    }

    @Override
    public String toString() {
        return "GoodImg{" +
                "id=" + id +
                ", goodid=" + goodid +
                ", imgid=" + imgid +
                '}';
    }

    @Id
    private int id ;
    private int goodid;
    private int imgid;

    public GoodImg(int id, int goodid, int imgid) {
        this.id = id;
        this.goodid = goodid;
        this.imgid = imgid;
    }

    public GoodImg(int goodid, int imgid) {
        this.goodid = goodid;
        this.imgid = imgid;
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

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }

    @Override
    public HashMap<String, String> toHashMap() {
        HashMap<String, String> line = new HashMap<String, String>();
        line.put("id",getId()+"");
        line.put("goodid",getGoodid()+"");
        line.put("imgid",getImgid()+"");
        return line;
    }
}
