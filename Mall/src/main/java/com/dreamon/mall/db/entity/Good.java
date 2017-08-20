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
@Table(name = "wljxc_good")
public class Good extends BaseEntity {

    static {
        String[] indexes = {"id","number","goodtype","store","viewprice","inprice",
                "userid","storeid","monthnumber","totalnumber","commentnumber",
                "good","meddile","bad",
                "instore","outstore","request","aveprice",
                "comprice","lrl","name","guige","txm","content","typelist","cpbh",
                "cpxlh","xsdw","package","uptime","isdelete"
        };
        for (String index :
                indexes) {
            column.add(index);
        }
    }

    @Id
    private int id;
    private int number;
    private int goodtype;
    private int store;
    private int viewprice;
    private int inprice;
    private int userid;
    private int storeid;
    private int monthnumber;
    private int totalnumber;
    private int commentnumber;
    private int good;
    private int meddile;
    private int bad;
    private int instore;
    private int outstore;
    private int request;
    private double aveprice;
    private double comprice;
    private double lrl;
    private String name;
    private String guige;
    private String txm;
    private String content;
    private String typelist;
    private String cpbh;
    private String cpxlh;
    private String xsdw;
    private String pacKage;

    public Good() {
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", number=" + number +
                ", goodtype=" + goodtype +
                ", store=" + store +
                ", viewprice=" + viewprice +
                ", inprice=" + inprice +
                ", userid=" + userid +
                ", storeid=" + storeid +
                ", monthnumber=" + monthnumber +
                ", totalnumber=" + totalnumber +
                ", commentnumber=" + commentnumber +
                ", good=" + good +
                ", meddile=" + meddile +
                ", bad=" + bad +
                ", instore=" + instore +
                ", outstore=" + outstore +
                ", request=" + request +
                ", aveprice=" + aveprice +
                ", comprice=" + comprice +
                ", lrl=" + lrl +
                ", name='" + name + '\'' +
                ", guige='" + guige + '\'' +
                ", txm='" + txm + '\'' +
                ", content='" + content + '\'' +
                ", typelist='" + typelist + '\'' +
                ", cpbh='" + cpbh + '\'' +
                ", cpxlh='" + cpxlh + '\'' +
                ", xsdw='" + xsdw + '\'' +
                ", pacKage='" + pacKage + '\'' +
                ", uptime=" + uptime +
                '}';
    }

    public Good(int number, int goodtype, int store, int viewprice, int inprice, int userid, int storeid, int monthnumber, int totalnumber, int commentnumber, int good, int meddile, int bad, int instore, int outstore, int request, double aveprice, double comprice, double lrl, String name, String guige, String txm, String content, String typelist, String cpbh, String cpxlh, String xsdw, String pacKage, Timestamp uptime) {
        this.number = number;
        this.goodtype = goodtype;
        this.store = store;
        this.viewprice = viewprice;
        this.inprice = inprice;
        this.userid = userid;
        this.storeid = storeid;
        this.monthnumber = monthnumber;
        this.totalnumber = totalnumber;
        this.commentnumber = commentnumber;
        this.good = good;
        this.meddile = meddile;
        this.bad = bad;
        this.instore = instore;
        this.outstore = outstore;
        this.request = request;
        this.aveprice = aveprice;
        this.comprice = comprice;
        this.lrl = lrl;
        this.name = name;
        this.guige = guige;
        this.txm = txm;
        this.content = content;
        this.typelist = typelist;
        this.cpbh = cpbh;
        this.cpxlh = cpxlh;
        this.xsdw = xsdw;
        this.pacKage = pacKage;
        this.uptime = uptime;
    }

    public Good(int id, int number, int goodtype, int store, int viewprice, int inprice, int userid, int storeid, int monthnumber, int totalnumber, int commentnumber, int good, int meddile, int bad, int instore, int outstore, int request, double aveprice, double comprice, double lrl, String name, String guige, String txm, String content, String typelist, String cpbh, String cpxlh, String xsdw, String pacKage, Timestamp uptime) {
        this.id = id;
        this.number = number;
        this.goodtype = goodtype;
        this.store = store;
        this.viewprice = viewprice;
        this.inprice = inprice;
        this.userid = userid;
        this.storeid = storeid;
        this.monthnumber = monthnumber;
        this.totalnumber = totalnumber;
        this.commentnumber = commentnumber;
        this.good = good;
        this.meddile = meddile;
        this.bad = bad;
        this.instore = instore;
        this.outstore = outstore;
        this.request = request;
        this.aveprice = aveprice;
        this.comprice = comprice;
        this.lrl = lrl;
        this.name = name;
        this.guige = guige;
        this.txm = txm;
        this.content = content;
        this.typelist = typelist;
        this.cpbh = cpbh;
        this.cpxlh = cpxlh;
        this.xsdw = xsdw;
        this.pacKage = pacKage;
        this.uptime = uptime;
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

    public int getGoodtype() {
        return goodtype;
    }

    public void setGoodtype(int goodtype) {
        this.goodtype = goodtype;
    }

    public int getStore() {
        return store;
    }

    public void setStore(int store) {
        this.store = store;
    }

    public int getViewprice() {
        return viewprice;
    }

    public void setViewprice(int viewprice) {
        this.viewprice = viewprice;
    }

    public int getInprice() {
        return inprice;
    }

    public void setInprice(int inprice) {
        this.inprice = inprice;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getStoreid() {
        return storeid;
    }

    public void setStoreid(int storeid) {
        this.storeid = storeid;
    }

    public int getMonthnumber() {
        return monthnumber;
    }

    public void setMonthnumber(int monthnumber) {
        this.monthnumber = monthnumber;
    }

    public int getTotalnumber() {
        return totalnumber;
    }

    public void setTotalnumber(int totalnumber) {
        this.totalnumber = totalnumber;
    }

    public int getCommentnumber() {
        return commentnumber;
    }

    public void setCommentnumber(int commentnumber) {
        this.commentnumber = commentnumber;
    }

    public int getGood() {
        return good;
    }

    public void setGood(int good) {
        this.good = good;
    }

    public int getMeddile() {
        return meddile;
    }

    public void setMeddile(int meddile) {
        this.meddile = meddile;
    }

    public int getBad() {
        return bad;
    }

    public void setBad(int bad) {
        this.bad = bad;
    }

    public int getInstore() {
        return instore;
    }

    public void setInstore(int instore) {
        this.instore = instore;
    }

    public int getOutstore() {
        return outstore;
    }

    public void setOutstore(int outstore) {
        this.outstore = outstore;
    }

    public int getRequest() {
        return request;
    }

    public void setRequest(int request) {
        this.request = request;
    }

    public double getAveprice() {
        return aveprice;
    }

    public void setAveprice(double aveprice) {
        this.aveprice = aveprice;
    }

    public double getComprice() {
        return comprice;
    }

    public void setComprice(double comprice) {
        this.comprice = comprice;
    }

    public double getLrl() {
        return lrl;
    }

    public void setLrl(double lrl) {
        this.lrl = lrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGuige() {
        return guige;
    }

    public void setGuige(String guige) {
        this.guige = guige;
    }

    public String getTxm() {
        return txm;
    }

    public void setTxm(String txm) {
        this.txm = txm;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTypelist() {
        return typelist;
    }

    public void setTypelist(String typelist) {
        this.typelist = typelist;
    }

    public String getCpbh() {
        return cpbh;
    }

    public void setCpbh(String cpbh) {
        this.cpbh = cpbh;
    }

    public String getCpxlh() {
        return cpxlh;
    }

    public void setCpxlh(String cpxlh) {
        this.cpxlh = cpxlh;
    }

    public String getXsdw() {
        return xsdw;
    }

    public void setXsdw(String xsdw) {
        this.xsdw = xsdw;
    }

    public String getPacKage() {
        return pacKage;
    }

    public void setPacKage(String pacKage) {
        this.pacKage = pacKage;
    }

    public Timestamp getUptime() {
        return uptime;
    }

    public void setUptime(Timestamp uptime) {
        this.uptime = uptime;
    }

    private Timestamp uptime;

    public HashMap<String,String> toHashMap(){
        HashMap<String,String> line = new HashMap<String, String>();
        line.put("id",getId() + "");
        line.put("name",getName());
        line.put("goodtype",getGoodtype() + "");
        line.put("store",getStore() + "");
        line.put("guige",getGuige());
        line.put("txm",getTxm());
        line.put("viewprice",getViewprice() + "");
        line.put("inprice",getInprice() + "");
        line.put("other","");//TODO 缺少other字段
        line.put("storeid",getStoreid() + "");
        line.put("content",getContent());
        line.put("typelist",getTypelist());
        line.put("monthnumber",getMonthnumber()+"");
        line.put("totalnumber",getTotalnumber()+"");
        line.put("commontnumber",getCommentnumber() + "");
        line.put("good",getGood()+"");
        line.put("meddile",getMeddile() + "");
        line.put("bad",getBad() + "");
        line.put("cpbh",getCpbh());
        line.put("cpxlh",getCpxlh());
        line.put("xsdw",getXsdw());
        line.put("package",getPacKage());
        line.put("color","");//TODO 缺少颜色
        line.put("uptime",getUptime().toString() );
        line.put("lrl",getLrl() + "");
        line.put("aveprice",getAveprice() + "");
        line.put("comprice",getComprice() + "");
        line.put("instore",getInstore() + "");
        line.put("outstore",getOutstore() + "");
        line.put("request",getRequest() + "");
        return line;
    }


}
