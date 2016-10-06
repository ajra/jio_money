package com.jiomoney.snapbizz.ui.inventory;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jiomoney.snapbizz.R;
import com.jiomoney.snapbizz.adapter.TodayOrderAdapter;
import com.jiomoney.snapbizz.ui.inventory.adapters.LowSalesAdapter;
import com.jiomoney.snapbizz.ui.inventory.adapters.LowStockAdapter;
import com.jiomoney.snapbizz.ui.inventory.model.InventoryManagementList;
import com.jiomoney.snapbizz.ui.orders.model.TodayOrder;
import com.jiomoney.snapbizz.utils.ReadFiles;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InventoryManagementActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.header_product)
    TextView headerProduct;
    @BindView(R.id.header_supplier)
    TextView headerSupplier;
    @BindView(R.id.header_selling_price)
    TextView headerSellingPrice;
    @BindView(R.id.zero_inventory_recycler_view)
    RecyclerView zeroInventoryRecyclerView;
    @BindView(R.id.header_qty)
    TextView headerQty;
    @BindView(R.id.header_selling_details)
    TextView headerSellingDetails;
    @BindView(R.id.supplier_row)
    LinearLayout supplierRow;
    @BindView(R.id.low_stock_recycler_view)
    RecyclerView lowStockRecyclerView;
    @BindView(R.id.header_action)
    TextView headerAction;
    @BindView(R.id.low_sales_recycler_view)
    RecyclerView lowSalesRecyclerView;
    @BindView(R.id.content_inventory_management)
    RelativeLayout contentInventoryManagement;
    @BindView(R.id.header_stock_product_name)
    TextView headerStockProductName;
    @BindView(R.id.header_stock_qty)
    TextView headerStockQty;
    @BindView(R.id.stock_supplier_row)
    LinearLayout stockSupplierRow;

    InventoryManagementList inventoryManagementList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_management);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        Gson gson = new Gson();
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        try {
            inventoryManagementList = gson.fromJson(ReadFiles.readRawFileAsString(this, R.raw.inventory_managment_list), InventoryManagementList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LowStockAdapter lowStockAdapter = new LowStockAdapter(inventoryManagementList.getLowStockList(), this);
        lowStockRecyclerView.setLayoutManager(mLayoutManager);
        lowStockRecyclerView.setItemAnimator(new DefaultItemAnimator());
        lowStockRecyclerView.setAdapter(lowStockAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        LowSalesAdapter lowSalesAdapter = new LowSalesAdapter(inventoryManagementList.getLowSalesList(), this);
        lowSalesRecyclerView.setLayoutManager(layoutManager);
        lowSalesRecyclerView.setItemAnimator(new DefaultItemAnimator());
        lowSalesRecyclerView.setAdapter(lowSalesAdapter);
    }

}
