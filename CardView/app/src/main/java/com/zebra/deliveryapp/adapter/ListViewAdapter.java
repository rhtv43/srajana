package com.zebra.deliveryapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import com.zebra.deliveryapp.CustomerOrderToMap;
import com.zebra.deliveryapp.R;
import com.zebra.deliveryapp.database.Product;

/**
 * Created by CQJG67 on 8/29/2016.
 */
public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.MyViewHolder> {
    Context mContext;
    LayoutInflater inflater;
    private List<Product> CustomerItemlist = null;
    private ArrayList<Product> productList;


    public class MyViewHolder extends RecyclerView.ViewHolder {
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
            cardView = (CardView) view.findViewById(R.id.card_view);
        }
    }


    public ListViewAdapter(Context context, List<Product> CustomerItemlist) {
        mContext = context;
        this.CustomerItemlist = CustomerItemlist;
        inflater = LayoutInflater.from(mContext);
        this.productList = new ArrayList<Product>();
        this.productList.addAll(CustomerItemlist);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.screendeliveryassitent_listview_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Product product = productList.get(position);
        holder.productID.setText(CustomerItemlist.get(position).getPid());
        holder.productName.setText(CustomerItemlist.get(position).getName());
        holder.address.setText(CustomerItemlist.get(position).getAddress());
        holder.contact.setText(CustomerItemlist.get(position).getMobile());
        holder.btAddress.setText(CustomerItemlist.get(position).getBtAddress());
        holder.shipment.setText(CustomerItemlist.get(position).getShipment());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(mContext, CustomerOrderToMap.class);
                mIntent.putExtra("Position", position);
                mContext.startActivity(mIntent);

            }
        });
    }



    @Override
    public int getItemCount() {
        return productList.size();
    }
}
