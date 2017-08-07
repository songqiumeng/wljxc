package com.dreamon.mall.db.entity;

import com.dreamon.mall.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by qiumengsong on 2017/8/6.
 */
@Entity
@Table(name = "wljxc_goodtype")
public class GoodType extends BaseEntity {

    static {
        String[] indexes = {"id","name","number","level","parent"
        };
        for (String index :
                indexes) {
            column.add(index);
        }
    }

    @Id
    private int id ;
    private String name;
    private int number;
    private int level;
    private int parent;

    @Override
    public String toString() {
        return "GoodType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", level=" + level +
                ", parent=" + parent +
                '}';
    }

    public GoodType(String name, int number, int level, int parent) {
        this.name = name;
        this.number = number;
        this.level = level;
        this.parent = parent;
    }

    public GoodType() {

    }

    public GoodType(int id, String name, int number, int level, int parent) {

        this.id = id;
        this.name = name;
        this.number = number;
        this.level = level;
        this.parent = parent;
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

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }
}
