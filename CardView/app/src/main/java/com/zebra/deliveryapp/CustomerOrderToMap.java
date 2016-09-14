package com.zebra.deliveryapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.zebra.deliveryapp.database.Product;

import java.util.ArrayList;
import java.util.List;


public class CustomerOrderToMap extends FragmentActivity implements GoogleMap.OnMarkerClickListener,OnMapReadyCallback {
    private static final LatLng PERTH = new LatLng(-31.952854, 115.857342);
    private static final LatLng SYDNEY = new LatLng(-33.87365, 151.20689);
    private static final LatLng BRISBANE = new LatLng(-27.47093, 153.0235);

    private Marker mPerth;
    private Marker mSydney;
    private Marker mBrisbane;
    private int pos;
    private GoogleMap mMap;

    /*Context mContext;
    LayoutInflater inflater;
    private List<Product> CustomerItemlist = null;
    private ArrayList<Product> productList;

    public CustomerOrderToMap(Context context, List<Product> CustomerItemlist) {
        mContext = context;
        this.CustomerItemlist = CustomerItemlist;
        inflater = LayoutInflater.from(mContext);
        this.productList = new ArrayList<Product>();
        this.productList.addAll(CustomerItemlist);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery_map_customer_order);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    //    mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
    //    mMap = ((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapViewFull)).getMap();

        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {
            pos = mBundle.getInt("Position");
        }
        initSelectedListItemDetails(pos);
    }

    private void initSelectedListItemDetails(int pos) {

    }

    /*public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView productID;
        TextView productName;
        TextView address;
        TextView contact;
        TextView btAddress;
        TextView shipment;;
        private CardView cardView;

        public MyViewHolder(View view) {
            super(view);
            productID = (TextView) view.findViewById(R.id.order_id);
            productName = (TextView) view.findViewById(R.id.product_name);
            address = (TextView) view.findViewById(R.id.address);
            contact = (TextView) view.findViewById(R.id.contact_no);
            btAddress = (TextView) view.findViewById(R.id.bt_address);
            shipment = (TextView) view.findViewById(R.id.shipment);
            cardView = (CardView) view.findViewById(R.id.map_card_view);
        }
    }
*/
    @Override
    public void onMapReady(GoogleMap map) {
        mMap = map;

        // Add some markers to the map, and add a data object to each marker.
        mPerth = mMap.addMarker(new MarkerOptions()
                .position(PERTH)
                .title("Perth"));
      //  mPerth.set(0);

        mSydney = mMap.addMarker(new MarkerOptions()
                .position(SYDNEY)
                .title("Sydney"));
     //   mSydney.setTag(0);

        mBrisbane = mMap.addMarker(new MarkerOptions()
                .position(BRISBANE)
                .title("Brisbane"));
     //   mBrisbane.setTag(0);

        // Set a listener for marker click.
        mMap.setOnMarkerClickListener(this);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }
}
