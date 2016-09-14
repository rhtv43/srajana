package com.zebra.deliveryapp.database;

/**
 * Created by VMD763 on 9/2/2016.
 */
public class DBContracts {

    // Database Version
    public static final int DATABASE_VERSION = 1;

    // Database Name
    public static final String DATABASE_NAME = "smartDelivery";

    // Table Names
    public static final String TABLE_PRODUCT = "product";
    public static final String TABLE_ORDER = "order";

    // Common column names for product table
    public static final String KEY_PRODUCT_ID="id";
    public static final String KEY_PRODUCT_PRODUCT_NAME = "name";
    public static final String KEY_PRODUCT_ADDRESS = "address";
    public static final String KEY_PRODUCT_MOBILE = "mobile";
    public static final String KEY_PRODUCT_BT_ADDRESS = "addr";
    public static final String KEY_PRODUCT_SHIPMENT = "shipment";

    // Common column names for order table
    public static final String KEY_ORDER_ID="id";
    public static final String KEY_ORDER_CUSTOMER_NAME = "customerName";
    public static final String KEY_ORDER_COUNT = "count";
    public static final String KEY_ORDER_DATE = "date";


    public static final String CREATE_TABLE_PRODUCT = "CREATE TABLE " + TABLE_PRODUCT + "(" +
            KEY_PRODUCT_ID + " INTEGER PRIMARY KEY," +
            KEY_PRODUCT_PRODUCT_NAME + " TEXT," +
            KEY_PRODUCT_ADDRESS + " TEXT," +
            KEY_PRODUCT_MOBILE + " TEXT," +
            KEY_PRODUCT_BT_ADDRESS + " TEXT," +
            KEY_PRODUCT_SHIPMENT + " TEXT" + ")";

    public static final String DROP_TABLE_PRODUCT = "DROP TABLE IF EXISTS " + TABLE_PRODUCT;

    public static final String CREATE_TABLE_ORDER = "CREATE TABLE " + TABLE_ORDER + "(" +
            KEY_ORDER_ID + " INTEGER PRIMARY KEY," +
            KEY_ORDER_CUSTOMER_NAME + " TEXT," +
            KEY_ORDER_COUNT + " TEXT," +
            KEY_ORDER_DATE + " TEXT" + ")";

    public static final String DROP_TABLE_ORDER = "DROP TABLE IF EXISTS " + TABLE_ORDER;
}
