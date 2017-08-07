package com.dreamon.mall.service.entity;

/**
 * Created by qiumengsong on 2017/8/7.
 */
public class NumberEntity {

    private String preWord;
    private int first;
    private int meddile;
    private int tail;

    public NumberEntity(int first, int meddile, String preWord, int tail) {
        this.first = first;
        this.meddile = meddile;
        this.preWord = preWord;
        this.tail = tail;
    }

    public NumberEntity() {
        this(0,0,"",0);
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getMeddile() {
        return meddile;
    }

    public void setMeddile(int meddile) {
        this.meddile = meddile;
    }

    public String getPreWord() {
        return preWord;
    }

    public void setPreWord(String preWord) {
        this.preWord = preWord;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    @Override
    public String toString() {
        return preWord + first + meddile + tail;
    }

}
