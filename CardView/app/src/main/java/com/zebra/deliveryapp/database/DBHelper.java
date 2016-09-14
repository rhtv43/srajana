package com.zebra.deliveryapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VMD763 on 9/2/2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    private final String TAG = DBHelper.this.getClass().getSimpleName();
    private static DBHelper instance = null;

    public DBHelper(Context context) {
        super(context, DBContracts.DATABASE_NAME, null, DBContracts.DATABASE_VERSION);
    }

    public static DBHelper getInstance(Context context) {
        if(instance == null) {
            instance = new DBHelper(context);
        }
        return  instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(DBContracts.CREATE_TABLE_PRODUCT);
            db.execSQL(DBContracts.CREATE_TABLE_ORDER);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL(DBContracts.DROP_TABLE_PRODUCT);
            db.execSQL(DBContracts.DROP_TABLE_ORDER);
            onCreate(db);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
        }
    }

    public void addProduct(Product product) {
        Log.d("santosh" , "addProduct1 ");
        SQLiteDatabase db = getWritableDatabase();
        Log.d("santosh" , "addProduct2");
        ContentValues values = new ContentValues();
        Log.d("santosh" , "addProduct3 ");
        values.put(DBContracts.KEY_PRODUCT_ID, product.getPid());
        Log.d("santosh" , "addProduct4 ");
        values.put(DBContracts.KEY_PRODUCT_PRODUCT_NAME, product.getName());
        Log.d("santosh" , "addProduct5 ");
        values.put(DBContracts.KEY_PRODUCT_ADDRESS, product.getAddress());
        Log.d("santosh" , "addProduct6 ");
        values.put(DBContracts.KEY_PRODUCT_MOBILE, product.getMobile());
        Log.d("santosh" , "addProduct7 ");
        values.put(DBContracts.KEY_PRODUCT_BT_ADDRESS, product.getBtAddress());
        Log.d("santosh" , "addProduct8 ");
        values.put(DBContracts.KEY_PRODUCT_SHIPMENT, product.getShipment());
        Log.d("santosh" , "addProduct9 ");

        // Inserting Row
        db.insert(DBContracts.TABLE_PRODUCT, null, values);
        Log.d("santosh" , "addProduct10 ");
        // Closing database connection
        db.close();
        Log.d("santosh" , "addProduct2 ");
    }

    public Product getProduct(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(DBContracts.TABLE_PRODUCT, null, DBContracts.KEY_PRODUCT_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Product product = new Product(cursor.getString(cursor.getColumnIndex(DBContracts.KEY_PRODUCT_ID)),
                cursor.getString(cursor.getColumnIndex(DBContracts.KEY_PRODUCT_PRODUCT_NAME)),
                cursor.getString(cursor.getColumnIndex(DBContracts.KEY_PRODUCT_ADDRESS)),
                cursor.getString(cursor.getColumnIndex(DBContracts.KEY_PRODUCT_MOBILE)),
                cursor.getString(cursor.getColumnIndex(DBContracts.KEY_PRODUCT_BT_ADDRESS)),
                cursor.getString(cursor.getColumnIndex(DBContracts.KEY_PRODUCT_SHIPMENT)));
        return product;
    }

    public List<Product> getAllProducts() {
        Log.d("santosh" , "getAllProducts1 ");
        List<Product> productsList = new ArrayList<Product>();
        String selectQuery = "SELECT  * FROM " + DBContracts.TABLE_PRODUCT;

        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Product product = new Product(cursor.getString(cursor.getColumnIndex(DBContracts.KEY_PRODUCT_ID)),
                        cursor.getString(cursor.getColumnIndex(DBContracts.KEY_PRODUCT_PRODUCT_NAME)),
                        cursor.getString(cursor.getColumnIndex(DBContracts.KEY_PRODUCT_ADDRESS)),
                        cursor.getString(cursor.getColumnIndex(DBContracts.KEY_PRODUCT_MOBILE)),
                        cursor.getString(cursor.getColumnIndex(DBContracts.KEY_PRODUCT_BT_ADDRESS)),
                        cursor.getString(cursor.getColumnIndex(DBContracts.KEY_PRODUCT_SHIPMENT)));
                productsList.add(product);
            } while (cursor.moveToNext());
        }
        Log.d("santosh" , "getAllProducts2 ");
        return productsList;
    }

    public int getProductsCount() {
        int toret = -1;
        String countQuery = "SELECT  * FROM " + DBContracts.TABLE_PRODUCT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        if(cursor != null) {
            toret = cursor.getCount();
        }
        cursor.close();

        return toret;
    }

    public void addOrder(Order order) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBContracts.KEY_ORDER_ID, order.getOrderId());
        values.put(DBContracts.KEY_ORDER_CUSTOMER_NAME, order.getCustomerName());
        values.put(DBContracts.KEY_ORDER_COUNT, order.getProductCount());
        values.put(DBContracts.KEY_ORDER_DATE, order.getOrderDate());

        // Inserting Row
        db.insert(DBContracts.TABLE_ORDER, null, values);
        // Closing database connection
        db.close();
    }

    public Order getOrder(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(DBContracts.TABLE_ORDER, null, DBContracts.KEY_ORDER_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Order order = new Order(cursor.getString(cursor.getColumnIndex(DBContracts.KEY_PRODUCT_ID)),
                cursor.getString(cursor.getColumnIndex(DBContracts.KEY_ORDER_CUSTOMER_NAME)),
                cursor.getString(cursor.getColumnIndex(DBContracts.KEY_ORDER_COUNT)),
                cursor.getString(cursor.getColumnIndex(DBContracts.KEY_ORDER_DATE)));
        return order;
    }

    public List<Order> getAllOrders() {
        List<Order> orderList = new ArrayList<Order>();
        String selectQuery = "SELECT  * FROM " + DBContracts.TABLE_ORDER;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Order order = new Order(cursor.getString(cursor.getColumnIndex(DBContracts.KEY_PRODUCT_ID)),
                        cursor.getString(cursor.getColumnIndex(DBContracts.KEY_ORDER_CUSTOMER_NAME)),
                        cursor.getString(cursor.getColumnIndex(DBContracts.KEY_ORDER_COUNT)),
                        cursor.getString(cursor.getColumnIndex(DBContracts.KEY_ORDER_DATE)));
                orderList.add(order);
            } while (cursor.moveToNext());
        }

        return orderList;
    }

    public int getOredrsCount() {
        int toret = -1;
        String countQuery = "SELECT  * FROM " + DBContracts.TABLE_ORDER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        if(cursor != null) {
            toret = cursor.getCount();
        }
        cursor.close();

        return toret;
    }
}
