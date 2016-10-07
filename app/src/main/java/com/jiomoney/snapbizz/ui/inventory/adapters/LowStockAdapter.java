package com.jiomoney.snapbizz.ui.inventory.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiomoney.snapbizz.R;
import com.jiomoney.snapbizz.ui.inventory.model.InventoryManagementList;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LowStockAdapter extends RecyclerView.Adapter<LowStockAdapter.LowStockViewHolder> {

    List<InventoryManagementList.LowStockListBean> lowStockListBeanList;
    Context context;

    public LowStockAdapter(List<InventoryManagementList.LowStockListBean> lowStockListBeanList, Context context) {
        this.lowStockListBeanList = lowStockListBeanList;
        this.context = context;
    }

    @Override
    public LowStockViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_inventory_low_stock, parent, false);
        return new LowStockViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LowStockViewHolder holder, int position) {
        InventoryManagementList.LowStockListBean lowStockListBean = lowStockListBeanList.get(position);
        holder.productNameTextView.setText(lowStockListBean.getProductName());
        holder.qtyTextView.setText(String.valueOf(lowStockListBean.getQuantity()));
    }

    @Override
    public int getItemCount() {
        return lowStockListBeanList.size();
    }

    public static class LowStockViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.product_name_text_view)
        TextView productNameTextView;
        @BindView(R.id.qty_text_view)
        TextView qtyTextView;
        @BindView(R.id.selling_details_text_view)
        TextView sellingDetailsTextView;
        @BindView(R.id.supplier_row)
        LinearLayout supplierRow;
        public LowStockViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
