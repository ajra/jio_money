package com.jiomoney.snapbizz.ui.orders;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jiomoney.snapbizz.R;
import com.jiomoney.snapbizz.ui.orders.adapter.OrderDetails;
import com.jiomoney.snapbizz.ui.orders.adapter.SupplierOrderDetailsAdapter;
import com.jiomoney.snapbizz.utils.ReadFiles;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SuppliersOrderActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.header_no)
    TextView headerNo;
    @BindView(R.id.header_order_id)
    TextView headerOrderId;
    @BindView(R.id.header_distributor_name)
    TextView headerDistributorName;
    @BindView(R.id.header_date)
    TextView headerDate;
    @BindView(R.id.header_no_item)
    TextView headerNoItem;
    @BindView(R.id.header_delivery_date)
    TextView headerDeliveryDate;
    @BindView(R.id.header_amount)
    TextView headerAmount;
    @BindView(R.id.header_status)
    TextView headerStatus;
    @BindView(R.id.supplier_row)
    LinearLayout supplierRow;
    @BindView(R.id.supplier_orders_recycler_view)
    RecyclerView supplierOrdersRecyclerView;
    @BindView(R.id.llMainTittle)
    LinearLayout llMainTittle;
    @BindView(R.id.content_suppliers_order)
    RelativeLayout contentSuppliersOrder;
    OrderDetails orderDetails;
    @BindView(R.id.day_active_view)
    View dayActiveView;
    @BindView(R.id.week_active_view)
    View weekActiveView;
    @BindView(R.id.month_active_view)
    View monthActiveView;
    @BindView(R.id.day_button)
    Button dayButton;
    @BindView(R.id.week_button)
    Button weekButton;
    @BindView(R.id.month_button)
    Button monthButton;
    SupplierOrderDetailsAdapter supplierOrderDetailsAdapter;
    Gson gson = new Gson();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suppliers_order);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        try {
            orderDetails = gson.fromJson(ReadFiles.readRawFileAsString(this, R.raw.day_order_details), OrderDetails.class);
            dayActiveView.setVisibility(View.VISIBLE);
            weekActiveView.setVisibility(View.INVISIBLE);
            monthActiveView.setVisibility(View.INVISIBLE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        supplierOrderDetailsAdapter = new SupplierOrderDetailsAdapter(orderDetails.getOrdersList(), this);
        supplierOrdersRecyclerView.setLayoutManager(mLayoutManager);
        supplierOrdersRecyclerView.setItemAnimator(new DefaultItemAnimator());
        supplierOrdersRecyclerView.setAdapter(supplierOrderDetailsAdapter);

    }

    @OnClick({R.id.day_button, R.id.week_button, R.id.month_button})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.day_button:
                dayButtonAction();
                break;
            case R.id.week_button:
                weekButtonAction();
                break;
            case R.id.month_button:
                monthButtonAction();
                break;
        }
        supplierOrderDetailsAdapter = new SupplierOrderDetailsAdapter(orderDetails.getOrdersList(), this);
        supplierOrdersRecyclerView.setAdapter(supplierOrderDetailsAdapter);
        supplierOrderDetailsAdapter.notifyDataSetChanged();
    }

    private void dayButtonAction() {
        try {
            orderDetails = gson.fromJson(ReadFiles.readRawFileAsString(this, R.raw.day_order_details), OrderDetails.class);
            dayActiveView.setVisibility(View.VISIBLE);
            weekActiveView.setVisibility(View.INVISIBLE);
            monthActiveView.setVisibility(View.INVISIBLE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void weekButtonAction() {
        try {
            orderDetails = gson.fromJson(ReadFiles.readRawFileAsString(this, R.raw.weekly_order_details), OrderDetails.class);
            dayActiveView.setVisibility(View.INVISIBLE);
            weekActiveView.setVisibility(View.VISIBLE);
            monthActiveView.setVisibility(View.INVISIBLE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void monthButtonAction() {
        try {
            orderDetails = gson.fromJson(ReadFiles.readRawFileAsString(this, R.raw.monthy_order_details), OrderDetails.class);
            dayActiveView.setVisibility(View.INVISIBLE);
            weekActiveView.setVisibility(View.INVISIBLE);
            monthActiveView.setVisibility(View.VISIBLE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
