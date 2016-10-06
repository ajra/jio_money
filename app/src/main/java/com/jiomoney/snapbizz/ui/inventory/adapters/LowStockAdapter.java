package com.jiomoney.snapbizz.ui.inventory.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiomoney.snapbizz.R;

public class LowStockAdapter extends RecyclerView.Adapter<LowStockAdapter.LowStockViewHolder>{
    @Override
    public LowStockAdapter.LowStockViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_inventory_low_stock, parent, false);
        return new LowStockViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LowStockAdapter.LowStockViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class LowStockViewHolder extends RecyclerView.ViewHolder {

        public LowStockViewHolder(View itemView) {
            super(itemView);
        }
    }
}
