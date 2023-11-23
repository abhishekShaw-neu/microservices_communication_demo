package com.example.employeeaddressservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "lane_1")
    private String lane_1;

    @Column(name = "lane_2")
    private String lane_2;

    @Column(name = "state")
    private String state;

    @Column(name = "zip")
    private String zip;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLane_1() {
        return lane_1;
    }

    public void setLane_1(String lane_1) {
        this.lane_1 = lane_1;
    }

    public String getLane_2() {
        return lane_2;
    }

    public void setLane_2(String lane_2) {
        this.lane_2 = lane_2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }


}
