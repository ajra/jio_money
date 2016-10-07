package com.jiomoney.snapbizz.ui.orders.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiomoney.snapbizz.App;
import com.jiomoney.snapbizz.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SupplierOrderDetailsAdapter extends RecyclerView.Adapter<SupplierOrderDetailsAdapter.SupplierOrderDetailsViewHolder> {

    List<OrderDetails.OrdersListBean> ordersListBeanList;
    Context context;

    public SupplierOrderDetailsAdapter(List<OrderDetails.OrdersListBean> ordersListBeanList, Context context) {
        this.ordersListBeanList = ordersListBeanList;
        this.context = context;
    }

    @Override
    public SupplierOrderDetailsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.suppliers_values_layout, parent, false);
        return new SupplierOrderDetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SupplierOrderDetailsViewHolder holder, int position) {
        OrderDetails.OrdersListBean ordersListBean = ordersListBeanList.get(position);
        holder.tvNo.setText(String.valueOf(position+1));
        holder.tvOrderId.setText(String.valueOf(ordersListBean.getOrderId()));
        holder.tvDistributorName.setText(String.valueOf(ordersListBean.getDistributorName()));
        holder.tvDate.setText(String.valueOf(ordersListBean.getDate()));
        holder.tvNoItem.setText(String.valueOf(ordersListBean.getNoOfItems()));
        holder.tvDeliveryDate.setText(String.valueOf(ordersListBean.getDeliveryDate()));
        holder.statusButton.setText(String.valueOf("Payment through Jio Money"));
        holder.tvAmount.setTypeface(App.rupeeForadian);
        holder.tvAmount.setText(context.getResources().getString(
                R.string.rs_symbol) +String.valueOf(ordersListBean.getAmount()));
    }

    @Override
    public int getItemCount() {
        return ordersListBeanList.size();
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
        @BindView(R.id.status_button)
        Button statusButton;
        @BindView(R.id.supplier_row)
        LinearLayout supplierRow;

        public SupplierOrderDetailsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}