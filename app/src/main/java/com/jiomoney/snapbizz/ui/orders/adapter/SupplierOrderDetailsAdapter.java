package com.jiomoney.snapbizz.ui.orders.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiomoney.snapbizz.R;

public class SupplierOrderDetailsAdapter extends RecyclerView.Adapter<SupplierOrderDetailsAdapter.SupplierOrderDetailsViewHolder>{

    @Override
    public SupplierOrderDetailsAdapter.SupplierOrderDetailsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.suppliers_values_layout, parent, false);
        return new SupplierOrderDetailsAdapter.SupplierOrderDetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SupplierOrderDetailsAdapter.SupplierOrderDetailsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class SupplierOrderDetailsViewHolder extends RecyclerView.ViewHolder {

        public SupplierOrderDetailsViewHolder(View itemView) {
            super(itemView);
        }
    }
}
