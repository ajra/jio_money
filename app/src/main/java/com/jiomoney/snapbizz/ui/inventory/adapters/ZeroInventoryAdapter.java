package com.jiomoney.snapbizz.ui.inventory.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiomoney.snapbizz.R;

public class ZeroInventoryAdapter extends RecyclerView.Adapter<ZeroInventoryAdapter.ZeroInventoryViewHolder>{

    @Override
    public ZeroInventoryAdapter.ZeroInventoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_zero_inventory, parent, false);
        return new ZeroInventoryAdapter.ZeroInventoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ZeroInventoryAdapter.ZeroInventoryViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ZeroInventoryViewHolder extends RecyclerView.ViewHolder {

        public ZeroInventoryViewHolder(View itemView) {
            super(itemView);
        }
    }
}
