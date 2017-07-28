package com.dreamon.mall.db.entity;

import com.dreamon.mall.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by qiumengsong on 2017/7/28.
 */
@Entity
@Table(name = "test")
public class Demo extends BaseEntity{

    @Id
    private int id;
    private String name;
    private String password;

    public Demo(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Demo() {
    }

    public Demo(String name, String password) {
        this.name = name;
        this.password = password;
    }


    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean checkIndex(String index) {
        return true;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
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
}
