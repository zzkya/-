package com.zzk.domain;

import java.util.Date;

public class Tenant {
    int id;
    String username;
    int expectedPrice;
    String expectedInformation;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", expectedPrice=" + expectedPrice +
                ", expectedInformation='" + expectedInformation + '\'' +
                ", time=" + time +
                '}';
    }
}
