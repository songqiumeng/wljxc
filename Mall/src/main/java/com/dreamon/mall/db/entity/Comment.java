package com.dreamon.mall.db.entity;

import com.dreamon.mall.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by qiumengsong on 2017/8/6.
 */
@Entity
@Table(name = "wljxc_comment")
public class Comment extends BaseEntity {

    static {
        String[] indexes = {"id","userid","goodid","score","type","comment",
                "response","other"
        };
        for (String index :
                indexes) {
            column.add(index);
        }
    }

    @Id
    private int id;
    private int userid;
    private int goodid;
    private int score;
    private int type;
    private String comment;
    private String response;
    private String other;

    public Comment() {
    }

    public Comment(int userid, int goodid, int score, int type, String comment, String response, String other) {
        this.userid = userid;
        this.goodid = goodid;
        this.score = score;
        this.type = type;

        this.comment = comment;
        this.response = response;
        this.other = other;
    }

    public Comment(int id, int userid, int goodid, int score, int type, String comment, String response, String other) {
        this.id = id;
        this.userid = userid;
        this.goodid = goodid;
        this.score = score;
        this.type = type;
        this.comment = comment;
        this.response = response;
        this.other = other;
    }

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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getOther() {
        return other;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", userid=" + userid +
                ", goodid=" + goodid +
                ", score=" + score +
                ", type=" + type +
                ", comment='" + comment + '\'' +
                ", response='" + response + '\'' +
                ", other='" + other + '\'' +
                '}';
    }

    public void setOther(String other) {
        this.other = other;
    }
}
