package com.dreamon.mall.db.entity;

import com.dreamon.mall.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.HashMap;

/**
 * Created by qiumengsong on 2017/8/6.
 */
@Table(name = "wljxc_store")
@Entity
public class Store extends BaseEntity {


    static {
        String[] indexes = {"id","number","userid","level","headimg","isgood",
                "hascut","hastip","score","total","locationX","locationY","name","contact",
                "phone","other","keyword"
        };
        for (String index :
                indexes) {
            column.add(index);
        }
    }

    public Store(int number, int userid, int level, int headimg, int isgood, int hascut, int hastip, int score, int total, double locationX, double locationY, String name, String contact, String phone, String other, String keyword) {
        this.number = number;
        this.userid = userid;
        this.level = level;
        this.headimg = headimg;
        this.isgood = isgood;
        this.hascut = hascut;
        this.hastip = hastip;
        this.score = score;
        this.total = total;
        this.locationX = locationX;
        this.locationY = locationY;
        this.name = name;
        this.contact = contact;
        this.phone = phone;
        this.other = other;
        this.keyword = keyword;
    }

    public Store() {
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", number=" + number +
                ", userid=" + userid +
                ", level=" + level +
                ", headimg=" + headimg +
                ", isgood=" + isgood +
                ", hascut=" + hascut +
                ", hastip=" + hastip +
                ", score=" + score +
                ", total=" + total +
                ", locationX=" + locationX +
                ", locationY=" + locationY +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", phone='" + phone + '\'' +
                ", other='" + other + '\'' +
                ", keyword='" + keyword + '\'' +
                '}';
    }

    public Store(int id, int number, int userid, int level, int headimg, int isgood, int hascut, int hastip, int score, int total, double locationX, double locationY, String name, String contact, String phone, String other, String keyword) {
        this.id = id;
        this.number = number;
        this.userid = userid;
        this.level = level;
        this.headimg = headimg;
        this.isgood = isgood;
        this.hascut = hascut;
        this.hastip = hastip;
        this.score = score;
        this.total = total;
        this.locationX = locationX;
        this.locationY = locationY;
        this.name = name;
        this.contact = contact;
        this.phone = phone;
        this.other = other;
        this.keyword = keyword;
    }

    @Id
    private int id;
    private int number;
    private int userid;
    private int level;
    private int headimg;
    private int isgood;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHeadimg() {
        return headimg;
    }

    public void setHeadimg(int headimg) {
        this.headimg = headimg;
    }

    public int getIsgood() {
        return isgood;
    }

    public void setIsgood(int isgood) {
        this.isgood = isgood;
    }

    public int getHascut() {
        return hascut;
    }

    public void setHascut(int hascut) {
        this.hascut = hascut;
    }

    public int getHastip() {
        return hastip;
    }

    public void setHastip(int hastip) {
        this.hastip = hastip;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public double getLocationX() {
        return locationX;
    }

    public void setLocationX(double locationX) {
        this.locationX = locationX;
    }

    public double getLocationY() {
        return locationY;
    }

    public void setLocationY(double locationY) {
        this.locationY = locationY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    private int hascut;
    private int hastip;
    private int score;
    private int total;
    private double locationX;
    private double locationY;
    private String name;
    private String contact;
    private String phone;
    private String other;
    private String keyword;

    @Override
    public HashMap<String, String> toHashMap() {
        HashMap<String, String> line = new HashMap<String, String>();
        line.put("id",getId()+"");
        line.put("number",getNumber()+"");
        line.put("userid",getUserid()+"");
        line.put("level",getLevel()+"");
        line.put("headimg",getHeadimg()+"");
        line.put("isgood",getIsgood()+"");
        line.put("hascut",getHascut()+"");
        line.put("hastip",getHastip()+"");
        line.put("score",getScore()+"");
        line.put("total",getTotal()+"");
        line.put("locationX",getLocationX()+"");
        line.put("locationY",getLocationY()+"");
        line.put("name",getName());
        line.put("contact",getContact());
        line.put("phone",getPhone());
        line.put("other",getOther());
        line.put("keyword",getKeyword());
        return line;
    }
}
