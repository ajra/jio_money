package com.jiomoney.snapbizz.ui.billing.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jiomoney.snapbizz.R;
import com.jiomoney.snapbizz.ui.billing.model.BillingCheckOutPojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by araja on 6/10/16.
 */

public class BillingCheckoutAdapter extends RecyclerView.Adapter<BillingCheckoutAdapter.BillViewHolder> {
List<BillingCheckOutPojo.OrdersListBean> billList=new ArrayList<>();
    Context context;

    public BillingCheckoutAdapter(List<BillingCheckOutPojo.OrdersListBean> billList, Context context) {
        this.billList=billList;
        this.context=context;
    }


    @Override
    public BillingCheckoutAdapter.BillViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.billing_checkout_single_row, parent, false);
        return new BillViewHolder(v);
    }

    @Override
    public void onBindViewHolder(BillingCheckoutAdapter.BillViewHolder holder, int position) {
holder.itemTextView.setText(String.valueOf(billList.get(position).getOrderId()));
        holder.quantityTextView.setText(String.valueOf(billList.get(position).getQuantity()));
        holder.rateTextView.setText(String.valueOf(billList.get(position).getRate()));
        holder.couponTextView.setText(String.valueOf(billList.get(position).getCouponOffers()));
        holder.amoutTextView.setText(String.valueOf(billList.get(position).getAmount()));

    }

    @Override
    public int getItemCount() {
        return billList.size();
    }

    public class BillViewHolder extends RecyclerView.ViewHolder {
        TextView itemTextView;
        TextView quantityTextView;
        TextView rateTextView;
        TextView couponTextView;
        TextView amoutTextView;

        public BillViewHolder(View itemView) {
            super(itemView);
            itemTextView=(TextView)itemView.findViewById(R.id.item_single_row_text_view);
            quantityTextView=(TextView)itemView.findViewById(R.id.quantity_text_view);
            rateTextView=(TextView)itemView.findViewById(R.id.rate_text_view);
            couponTextView=(TextView)itemView.findViewById(R.id.coupon_offer_text_view);
            amoutTextView=(TextView)itemView.findViewById(R.id.amount_text_view);
        }
    }
}
