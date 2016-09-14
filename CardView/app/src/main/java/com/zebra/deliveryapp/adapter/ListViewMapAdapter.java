/*
package com.zebra.deliveryapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zebra.deliveryapp.CustomerOrderToMap;
import com.zebra.deliveryapp.R;
import com.zebra.deliveryapp.database.Product;

import java.util.ArrayList;
import java.util.List;

*/
/**
 * Created by rhtv43 on 9/12/2016.
 *//*

public class ListViewMapAdapter extends RecyclerView.Adapter<ListViewAdapter.MyViewHolder> {

    Context mContext;
    LayoutInflater inflater;
    private List<Product> CustomerItemlist = null;
    private ArrayList<Product> productList;

    public class MyViewHolder1 extends RecyclerView.ViewHolder {
        TextView productID;
        TextView productName;
        TextView address;
        TextView contact;
        TextView btAddress;
        TextView shipment;;
        private CardView cardView;

        public MyViewHolder1(View view) {
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

    public ListViewMapAdapter(Context context, List<Product> CustomerItemlist) {
        mContext = context;
        this.CustomerItemlist = CustomerItemlist;
        inflater = LayoutInflater.from(mContext);
        this.productList = new ArrayList<Product>();
        this.productList.addAll(CustomerItemlist);
    }
    
    @Override
    public MyViewHolder1 onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.delivery_map_customer_order, parent, false);

        return new MyViewHolder1(itemView);
    }

    @Override
    public void onBindViewHolder(ListViewAdapter.MyViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.productID.setText(CustomerItemlist.get(position).getPid());
        holder.productName.setText(CustomerItemlist.get(position).getName());
        holder.address.setText(CustomerItemlist.get(position).getAddress());
        holder.contact.setText(CustomerItemlist.get(position).getMobile());
        holder.btAddress.setText(CustomerItemlist.get(position).getBtAddress());
        holder.shipment.setText(CustomerItemlist.get(position).getShipment());

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
*/
