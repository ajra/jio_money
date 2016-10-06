package com.jiomoney.snapbizz.ui.inventory.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiomoney.snapbizz.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ZeroInventoryAdapter extends RecyclerView.Adapter<ZeroInventoryAdapter.ZeroInventoryViewHolder> {

    @Override
    public ZeroInventoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_zero_inventory, parent, false);
        return new ZeroInventoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ZeroInventoryViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
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
