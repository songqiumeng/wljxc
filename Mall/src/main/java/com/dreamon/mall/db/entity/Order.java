package com.dreamon.mall.db.entity;

import com.dreamon.mall.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.HashMap;

/**
 * Created by qiumengsong on 2017/8/6.
 */
@Entity
@Table(name = "wljxc_order")
public class Order extends BaseEntity {

    static {
        String[] indexes = {"id","number","userid","shopid","goodnumber","viewprice",
                "price","state","addtime"
        };
        for (String index :
                indexes) {
            column.add(index);
        }
    }

    @Id
    private int id;
    private int number;
    private int userid;
    private int shopid;
    private int goodnumber;
    private int viewprice;

    public Order() {
    }

    public Order(int number, int userid, int shopid, int goodnumber, int viewprice, int price, int state, Timestamp addtime) {
        this.number = number;
        this.userid = userid;
        this.shopid = shopid;
        this.goodnumber = goodnumber;
        this.viewprice = viewprice;
        this.price = price;
        this.state = state;
        this.addtime = addtime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", number=" + number +
                ", userid=" + userid +
                ", shopid=" + shopid +
                ", goodnumber=" + goodnumber +
                ", viewprice=" + viewprice +
                ", price=" + price +
                ", state=" + state +
                ", addtime=" + addtime +
                '}';
    }

    private int price;
    private int state;
    private Timestamp addtime;

    public Order(int id, int number, int userid, int shopid, int goodnumber, int viewprice, int price, int state, Timestamp addtime) {
        this.id = id;
        this.number = number;
        this.userid = userid;
        this.shopid = shopid;
        this.goodnumber = goodnumber;
        this.viewprice = viewprice;
        this.price = price;
        this.state = state;
        this.addtime = addtime;
    }

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

    public int getShopid() {
        return shopid;
    }

    public void setShopid(int shopid) {
        this.shopid = shopid;
    }

    public int getGoodnumber() {
        return goodnumber;
    }

    public void setGoodnumber(int goodnumber) {
        this.goodnumber = goodnumber;
    }

    public int getViewprice() {
        return viewprice;
    }

    public void setViewprice(int viewprice) {
        this.viewprice = viewprice;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Timestamp getAddtime() {
        return addtime;
    }

    public void setAddtime(Timestamp addtime) {
        this.addtime = addtime;
    }

    @Override
    public HashMap<String, String> toHashMap() {
        HashMap<String, String> line = new HashMap<String, String>();
        line.put("id",getId()+"");
        line.put("number",getNumber()+"");
        line.put("userid",getUserid()+"");
        line.put("shopid",getShopid()+"");
        line.put("goodnumber",getGoodnumber()+"");
        line.put("viewprice",getViewprice()+"");
        line.put("price",getPrice()+"");
        line.put("state",getState()+"");
        line.put("addtime",getAddtime()+"");
        return line;
    }
}
