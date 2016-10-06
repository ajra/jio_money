package com.jiomoney.snapbizz.adapter;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiomoney.snapbizz.R;
import com.jiomoney.snapbizz.ui.orders.model.TodayOrder;

import java.util.List;

public class TodayOrderAdapter extends RecyclerView.Adapter<TodayOrderAdapter.TodayViewHolder> {

    TodayOrder todayOrder = new TodayOrder();
    List<TodayOrder.OrderList> todayOrdersInfo;
    Activity context;
    TodayViewHolder tvh;

    public TodayOrderAdapter(List<TodayOrder.OrderList> todayOrderList, Activity context) {
        this.todayOrdersInfo = todayOrderList;
        this.context = context;
    }

    @Override
    public TodayOrderAdapter.TodayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_today_transaction, parent, false);
        tvh = new TodayViewHolder(v);
        return tvh;
    }
    @Override
    public void onBindViewHolder(TodayOrderAdapter.TodayViewHolder holder, int position) {
//        TodayOrder.OrderList t_info=todayOrdersInfo.get(position);
        holder.myOrderName.setText(todayOrdersInfo.get(position).customerName);
        holder.orderDate_time.setText((todayOrdersInfo.get(position).orderDate));
        String status_new =todayOrdersInfo.get(position).orderStatusDescription;

        if("New".equals(status_new) && !status_new.equals(null)){
            holder.newImageView.setVisibility(View.VISIBLE);
            holder.inProcessImageView.setVisibility(View.GONE);
            holder.deliveryImageView.setVisibility(View.GONE);
            holder.cancelImageView.setVisibility(View.GONE);
        }else if("In process".equals(status_new) && !status_new.equals(null)){
            holder.newImageView.setVisibility(View.GONE);
            holder.inProcessImageView.setVisibility(View.VISIBLE);
            holder.deliveryImageView.setVisibility(View.GONE);
            holder.cancelImageView.setVisibility(View.GONE);
        }else if("Delivery".equals(status_new) && !status_new.equals(null)){
            holder.newImageView.setVisibility(View.GONE);
            holder.inProcessImageView.setVisibility(View.GONE);
            holder.deliveryImageView.setVisibility(View.VISIBLE);
            holder.cancelImageView.setVisibility(View.GONE);
        }else if("Canceled".equals(status_new) && !status_new.equals(null)){
            holder.newImageView.setVisibility(View.GONE);
            holder.inProcessImageView.setVisibility(View.GONE);
            holder.deliveryImageView.setVisibility(View.GONE);
            holder.cancelImageView.setVisibility(View.VISIBLE);
        }else {
            holder.newImageView.setVisibility(View.GONE);
            holder.inProcessImageView.setVisibility(View.GONE);
            holder.deliveryImageView.setVisibility(View.GONE);
            holder.cancelImageView.setVisibility(View.GONE);
        }
    }
    @Override
    public int getItemCount() {
        return  todayOrder.orderList.size();
    }
    public static class TodayViewHolder extends RecyclerView.ViewHolder {
        LinearLayout type_of_transaction;
        ImageView newImageView,inProcessImageView,deliveryImageView,cancelImageView;
        TextView sNo,myOrderName,orderDate_time;
        public TodayViewHolder(View itemView) {
            super(itemView);
            type_of_transaction=(LinearLayout) itemView.findViewById(R.id.linear_Layout_value);
            newImageView=(ImageView) itemView.findViewById(R.id.new_image_view);
            inProcessImageView=(ImageView) itemView.findViewById(R.id.in_process_image_view);
            deliveryImageView=(ImageView) itemView.findViewById(R.id.delivery_image_view);
            cancelImageView=(ImageView) itemView.findViewById(R.id.canceled_image_view);
            sNo=(TextView) itemView.findViewById(R.id.sno_text_view);
            myOrderName=(TextView) itemView.findViewById(R.id.my_order_text_view);
            orderDate_time=(TextView) itemView.findViewById(R.id.my_order_date_time_text_view);
        }
    }
    public void clear() {
        todayOrder.orderList.clear();
        notifyDataSetChanged();
    }
}