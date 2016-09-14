package com.zebra.deliveryapp.database;

/**
 * Created by VMD763 on 9/8/2016.
 */
public class Order {

    private String orderId;
    private String customerName;
    private String productCount;
    private String orderDate;

    public Order(String orderId, String customerName, String productCount, String orderDate) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.productCount = productCount;
        this.orderDate = orderDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductCount() {
        return productCount;
    }

    public void setProductCount(String productCount) {
        this.productCount = productCount;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
