package com.zzk.domain;

//租房信息表结构
public class Rent {
    int id;//房屋编号
    String username;//用户名
    String location;//房屋所在城市
    int price;//价格
    String information;//房屋信息
    String mark;//如果房屋被租则显示租客姓名，否则为null
    String time;//出租信息发布时间
    String rentedTime;//如果房屋被租则显示交易时间，否则为null

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

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRentedTime() {
        return rentedTime;
    }

    public void setRentedTime(String rentedTime) {
        this.rentedTime = rentedTime;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", location='" + location + '\'' +
                ", price=" + price +
                ", information='" + information + '\'' +
                ", mark='" + mark + '\'' +
                ", time='" + time + '\'' +
                ", rentedTime='" + rentedTime + '\'' +
                '}';
    }
}
