package com.zzk.domain;

public class Review {
    String username;
    String apply;
    int mark;

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
