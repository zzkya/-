package com.zzk.domain;

import java.util.Date;

//求租信息
public class Tenant {
    int id;//信息id
    String username;//用户名
    String location;//期望地点
    int expectedPrice;//期望价格
    String expectedInformation;//期望房屋信息
    String time;//发布时间

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

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

    public int getExpectedPrice() {
        return expectedPrice;
    }

    public void setExpectedPrice(int expectedPrice) {
        this.expectedPrice = expectedPrice;
    }

    public String getExpectedInformation() {
        return expectedInformation;
    }

    public void setExpectedInformation(String expectedInformation) {
        this.expectedInformation = expectedInformation;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", location='" + location + '\'' +
                ", expectedPrice=" + expectedPrice +
                ", expectedInformation='" + expectedInformation + '\'' +
                ", time=" + time +
                '}';
    }
}
