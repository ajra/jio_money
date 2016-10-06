package com.jiomoney.snapbizz.ui.inventory.adapters;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jiomoney.snapbizz.R;
import com.jiomoney.snapbizz.ui.inventory.GenerateCouponActivity;
import com.jiomoney.snapbizz.ui.inventory.model.InventoryManagementList;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LowSalesAdapter extends RecyclerView.Adapter<LowSalesAdapter.LowSalesViewHolder> {
    List<InventoryManagementList.LowSalesListBean> lowSalesListBeanList;
    Context context;

    public LowSalesAdapter(List<InventoryManagementList.LowSalesListBean> lowSalesListBeanList, Context context) {
        this.lowSalesListBeanList = lowSalesListBeanList;
        this.context = context;
    }

    @Override
    public LowSalesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_inventory_low_sales, parent, false);
        return new LowSalesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LowSalesViewHolder holder, int position) {
        InventoryManagementList.LowSalesListBean lowSalesListBean = lowSalesListBeanList.get(position);
        holder.lowSalesProductTextView.setText(lowSalesListBean.getProductName());
        holder.lowSalesDaysTextView.setText(String.valueOf(lowSalesListBean.getSalesLast3Days()));
        holder.lowSalesStockTextView.setText(String.valueOf(lowSalesListBean.getQuantityInStock()));
    }

    @Override
    public int getItemCount() {
        return lowSalesListBeanList.size();
    }

    @OnClick(R.id.generate_coupon_button)
    public void onClick() {
        Intent intent = new Intent(context, GenerateCouponActivity.class);
        context.startActivity(intent);
    }

    public static class LowSalesViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.low_sales_product_text_view)
        TextView lowSalesProductTextView;
        @BindView(R.id.low_sales_stock_text_view)
        TextView lowSalesStockTextView;
        @BindView(R.id.low_sales_days_text_view)
        TextView lowSalesDaysTextView;
        @BindView(R.id.generate_coupon_button)
        Button generateCouponButton;
        public LowSalesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
