package com.dreamon.mall.db.entity;

import com.dreamon.mall.base.BaseEntity;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by qiumengsong on 2017/7/27.
 */
@Entity
@Table(name = "wljxc_userinfo")
public class Userinfo extends BaseEntity {

    static {
        String[] indexes = {"id","number","name","password","realname",
                "nickname","state","type","address","phone","email"
                ,"contact","totalLimit","useLimit","headImg"
        };
        for (String index :
                indexes) {
            column.add(index);
        }
    }

    @Id
    private int id;
    private int number;
    private String name;
    private String password;
    private String realname;
    private String nickname;
    private int state;
    private int type;
    private String address;
    private String phone;
    private String email;
    private String contact;
    private int totalLimit;
    private int useLimit;
    private int headImg;
    private String headImgUrl;

    public Userinfo(String name, String password) {
        this(0,name,password,"","",0,0,"未填写",name,"","",0,0,0,"");
    }

    public Userinfo(int id, int number, String name, String password, String realname, String nickname, int state, int type, String address, String phone, String email, String contact, int totalLimit, int useLimit, int headImg, String headImgUrl) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.password = password;
        this.realname = realname;
        this.nickname = nickname;
        this.state = state;
        this.type = type;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.contact = contact;
        this.totalLimit = totalLimit;
        this.useLimit = useLimit;
        this.headImg = headImg;
        this.headImgUrl = headImgUrl;
    }

    public Userinfo(int number, String name, String password, String realname, String nickname, int state, int type, String address, String phone, String email, String contact, int totalLimit, int useLimit, int headImg, String headImgUrl) {
        this.number = number;
        this.name = name;
        this.password = password;
        this.realname = realname;
        this.nickname = nickname;
        this.state = state;
        this.type = type;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.contact = contact;
        this.totalLimit = totalLimit;
        this.useLimit = useLimit;
        this.headImg = headImg;
        this.headImgUrl = headImgUrl;
    }

    public Userinfo() {
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getTotalLimit() {
        return totalLimit;
    }

    public void setTotalLimit(int totalLimit) {
        this.totalLimit = totalLimit;
    }

    public int getUseLimit() {
        return useLimit;
    }

    public void setUseLimit(int useLimit) {
        this.useLimit = useLimit;
    }

    public int getHeadImg() {
        return headImg;
    }

    public void setHeadImg(int headImg) {
        this.headImg = headImg;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    @Override
    public String toString() {
        return "Userinfo{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                ", nickname='" + nickname + '\'' +
                ", state=" + state +
                ", type=" + type +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", totalLimit=" + totalLimit +
                ", useLimit=" + useLimit +
                ", headImg=" + headImg +
                ", headImgUrl='" + headImgUrl + '\'' +
                '}';
    }

    @Override
    public HashMap<String, String> toHashMap() {
        HashMap<String, String> line = new HashMap<String, String>();
        line.put("id",getId()+"");
        line.put("number",getNumber()+"");
        line.put("name",getName());
        line.put("password",getPassword());
        line.put("realname",getRealname());
        line.put("nickname",getNickname());
        line.put("state",getState()+"");
        line.put("type",getType()+"");
        line.put("address",getAddress());
        line.put("phone",getPhone());
        line.put("email",getEmail());
        line.put("contact",getContact());
        line.put("totalLimit",getTotalLimit()+"");
        line.put("useLimit",getUseLimit()+"");
        line.put("headImg",getHeadImg()+"");
        line.put("headImgUrl",getHeadImgUrl());
        return line;
    }
}
