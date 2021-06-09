package com.zzk.domain;

//中介审核信息
public class Review {
    String username;//请求成为中介的用户名
    String apply;//申请信息
    int mark;//1是审核通过，0是还未进行审核

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getApply() {
        return apply;
    }

    public void setApply(String apply) {
        this.apply = apply;
    }

    @Override
    public String toString() {
        return "Review{" +
                "username='" + username + '\'' +
                ", apply='" + apply + '\'' +
                ", mark=" + mark +
                '}';
    }
}
