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
@Table(name = "wljxc_img")
public class Img extends BaseEntity {
    static {
        String[] indexes = {"id","path","url","name"
        };
        for (String index :
                indexes) {
            column.add(index);
        }
    }

    public Img() {

    }

    @Id
    private int id;
    private String path;
    private String url;
    private String name;

    public Img(int id, String path, String url, String name) {
        this.id = id;
        this.path = path;
        this.url = url;
        this.name = name;
    }

    public Img(String path, String url, String name) {
        this.path = path;
        this.url = url;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Img{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int getId() {
        return id;

    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public HashMap<String, String> toHashMap() {
        HashMap<String, String> line = new HashMap<String, String>();
        line.put("id",getId()+"");
        line.put("path",getPath());
        line.put("url",getUrl());
        line.put("name",getName());
        return line;
    }
}
