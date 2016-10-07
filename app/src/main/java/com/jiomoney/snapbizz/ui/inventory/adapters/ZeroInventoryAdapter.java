package com.jiomoney.snapbizz.ui.inventory.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiomoney.snapbizz.R;
import com.jiomoney.snapbizz.ui.inventory.model.InventoryManagementList;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ZeroInventoryAdapter extends RecyclerView.Adapter<ZeroInventoryAdapter.ZeroInventoryViewHolder> {

    List<InventoryManagementList.ZeroInventoryListBean> zeroInventoryListBeanList;
    Context context;

    public ZeroInventoryAdapter(List<InventoryManagementList.ZeroInventoryListBean> lowStockListBeanList, Context context) {
        this.zeroInventoryListBeanList = lowStockListBeanList;
        this.context = context;
    }

    @Override
    public ZeroInventoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_zero_inventory, parent, false);
        return new ZeroInventoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ZeroInventoryViewHolder holder, int position) {
        InventoryManagementList.ZeroInventoryListBean zeroInventoryListBean = zeroInventoryListBeanList.get(position);
        holder.productNameTextView.setText(String.valueOf(zeroInventoryListBean.getProductName()));
        holder.supplierTextView.setText(zeroInventoryListBean.getSupplierProductList().get(0).getSupplierName());
        holder.sellingPriceTextView.setText(String.valueOf(zeroInventoryListBean.getSupplierProductList().get(0).getSellingPrice()));
        holder.qtyEditText.setText(String.valueOf(zeroInventoryListBean.getSupplierProductList().get(0).getQuantity()));
        holder.actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return zeroInventoryListBeanList.size();
    }

    @OnClick(R.id.action_button)
    public void onClick() {
    }

    public static class ZeroInventoryViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.product_name_text_view)
        TextView productNameTextView;
        @BindView(R.id.supplier_text_view)
        TextView supplierTextView;
        @BindView(R.id.selling_price_text_view)
        TextView sellingPriceTextView;
        @BindView(R.id.qty_edit_text)
        EditText qtyEditText;
        @BindView(R.id.action_button)
        Button actionButton;
        @BindView(R.id.supplier_row)
        LinearLayout supplierRow;

        public ZeroInventoryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
