package com.zebra.deliveryapp.database;

/**
 * Created by VMD763 on 9/2/2016.
 */
public class Product {

    private String pid;
    private String name;
    private String address;
    private String mobile;
    private String btAddress;
    private String shipment;

    public Product(String pid, String name, String address, String mobile, String btAddress, String shipment) {
        this.pid = pid;
        this.name = name;
        this.address = address;
        this.mobile = mobile;
        this.btAddress = btAddress;
        this.shipment = shipment;
    }

    public String getPid() {
        return pid;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getMobile() {
        return mobile;
    }

    public String getBtAddress() {
        return btAddress;
    }

    public String getShipment() {
        return shipment;
    }
}
