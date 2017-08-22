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
@Table(name = "wljxc_goodtype")
public class GoodType extends BaseEntity {

    static {
        String[] indexes = {"id","name","number","level","parent","typeimg","isdelete"
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
    private int typeimg;

    public GoodType(int id, String name, int number, int level, int parent, int typeimg) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.level = level;
        this.parent = parent;
        this.typeimg = typeimg;
    }

    public GoodType(String name, int number, int level, int parent, int typeimg) {
        this.name = name;
        this.number = number;
        this.level = level;
        this.parent = parent;
        this.typeimg = typeimg;
    }

    public GoodType() {
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

    @Override
    public String toString() {
        return "GoodType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", level=" + level +
                ", parent=" + parent +
                ", typeimg=" + typeimg +
                '}';
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

    public int getTypeimg() {
        return typeimg;
    }

    public void setTypeimg(int typeimg) {
        this.typeimg = typeimg;
    }

    @Override
    public HashMap<String, String> toHashMap() {
        HashMap<String, String> line = new HashMap<String, String>();
        line.put("id",getId()+"");
        line.put("name",getName());
        line.put("number",getNumber()+"");
        line.put("level",getLevel()+"");
        line.put("parent",getParent()+"");
        line.put("typeimg",getTypeimg()+"");
        return line;
    }
}
