package com.jiomoney.snapbizz.ui.orders.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiomoney.snapbizz.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SupplierOrderDetailsAdapter extends RecyclerView.Adapter<SupplierOrderDetailsAdapter.SupplierOrderDetailsViewHolder> {


    @Override
    public SupplierOrderDetailsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.suppliers_values_layout, parent, false);
        return new SupplierOrderDetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SupplierOrderDetailsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class SupplierOrderDetailsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_no)
        TextView tvNo;
        @BindView(R.id.tv_order_id)
        TextView tvOrderId;
        @BindView(R.id.tv_distributor_name)
        TextView tvDistributorName;
        @BindView(R.id.tv_date)
        TextView tvDate;
        @BindView(R.id.tv_no_item)
        TextView tvNoItem;
        @BindView(R.id.tv_delivery_date)
        TextView tvDeliveryDate;
        @BindView(R.id.tv_amount)
        TextView tvAmount;
        @BindView(R.id.tv_status)
        TextView tvStatus;
        @BindView(R.id.supplier_row)
        LinearLayout supplierRow;

        public SupplierOrderDetailsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}