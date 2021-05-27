package com.zzk.domain;

import java.util.Date;

public class Tenant {
    int id;
    String username;
    String location;
    int expectedPrice;
    String expectedInformation;
    String time;

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
