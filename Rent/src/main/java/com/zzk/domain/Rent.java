package com.zzk.domain;

import java.util.Date;

public class Rent {
    int id;
    String username;
    String location;
    int price;
    String information;
    int mark;
    Date time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", location='" + location + '\'' +
                ", price=" + price +
                ", information='" + information + '\'' +
                ", mark=" + mark +
                ", time=" + time +
                '}';
    }
}
