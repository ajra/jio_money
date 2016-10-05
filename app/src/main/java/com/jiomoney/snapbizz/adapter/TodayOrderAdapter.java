package com.jiomoney.snapbizz.adapter;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiomoney.snapbizz.R;

/**
 * Created by sthiritha on 5/10/16.
 */
public class TodayOrderAdapter extends RecyclerView.Adapter<TodayOrderAdapter.TodayViewHolder> {
    @Override
    public TodayOrderAdapter.TodayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_today_transaction, parent, false);
        return null;
    }
    @Override
    public void onBindViewHolder(TodayOrderAdapter.TodayViewHolder holder, int position) {
    }
    @Override
    public int getItemCount() {
        return 0;
    }
    public static class TodayViewHolder extends RecyclerView.ViewHolder {
        LinearLayout type_of_transaction;
        ImageView newImageView,inProcessImageView,deliveryImageView,cancelImageView;
        public TodayViewHolder(View itemView) {
            super(itemView);
            type_of_transaction=(LinearLayout) itemView.findViewById(R.id.linear_Layout_value);
            newImageView=(ImageView) itemView.findViewById(R.id.name_image_view);
            inProcessImageView=(ImageView) itemView.findViewById(R.id.in_process_image_view);
            deliveryImageView=(ImageView) itemView.findViewById(R.id.in_process_image_view);
            cancelImageView=(ImageView) itemView.findViewById(R.id.canceled_image_view);
             }
    }
}
