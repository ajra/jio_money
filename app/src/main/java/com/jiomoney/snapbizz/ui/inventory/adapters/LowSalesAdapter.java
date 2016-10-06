package com.jiomoney.snapbizz.ui.inventory.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiomoney.snapbizz.R;

public class LowSalesAdapter extends RecyclerView.Adapter<LowSalesAdapter.LowSalesViewHolder> {
    @Override
    public LowSalesAdapter.LowSalesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_inventory_low_sales, parent, false);
        return new LowSalesAdapter.LowSalesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LowSalesAdapter.LowSalesViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class LowSalesViewHolder extends RecyclerView.ViewHolder {

        public LowSalesViewHolder(View itemView) {
            super(itemView);
        }
    }
}
