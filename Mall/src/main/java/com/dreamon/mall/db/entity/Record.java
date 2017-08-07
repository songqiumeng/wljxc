package com.dreamon.mall.db.entity;

import com.dreamon.mall.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by qiumengsong on 2017/8/6.
 */
@Entity
@Table(name = "wljxc_record")
public class Record extends BaseEntity {

    public Record(int userid, int goodid, int orderid, int state, String goodname, String goodtype, String addtime) {
        this.userid = userid;
        this.goodid = goodid;
        this.orderid = orderid;
        this.state = state;
        this.goodname = goodname;
        this.goodtype = goodtype;
        this.addtime = addtime;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", userid=" + userid +
                ", goodid=" + goodid +
                ", orderid=" + orderid +
                ", state=" + state +
                ", goodname='" + goodname + '\'' +
                ", goodtype='" + goodtype + '\'' +
                ", addtime='" + addtime + '\'' +
                '}';
    }

    static {
        String[] indexes = {"id", "userid", "goodid", "orderid", "state", "goodname",
                "goodtype", "addtime"
        };
        for (String index :
                indexes) {
            column.add(index);
        }

    }

    public Record() {
    }

    public Record(int id, int userid, int goodid, int orderid, int state, String goodname, String goodtype, String addtime) {
        this.id = id;
        this.userid = userid;
        this.goodid = goodid;
        this.orderid = orderid;
        this.state = state;
        this.goodname = goodname;
        this.goodtype = goodtype;
        this.addtime = addtime;
    }

    @Id
    private int id;
    private int userid;
    private int goodid;
    private int orderid;
    private int state;
    private String goodname;
    private String goodtype;
    private String addtime;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getGoodid() {
        return goodid;
    }

    public void setGoodid(int goodid) {
        this.goodid = goodid;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname;
    }

    public String getGoodtype() {
        return goodtype;
    }

    public void setGoodtype(String goodtype) {
        this.goodtype = goodtype;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }
}
