package com.jiomoney.snapbizz.ui.orders;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jiomoney.snapbizz.R;
import com.jiomoney.snapbizz.adapter.TodayOrderAdapter;
import com.jiomoney.snapbizz.ui.inventory.adapters.LowSalesAdapter;
import com.jiomoney.snapbizz.ui.orders.model.TodayOrder;
import com.jiomoney.snapbizz.utils.AppLog;
import com.jiomoney.snapbizz.utils.ReadFiles;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrdersActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.today_order_recyclerView)
    RecyclerView todayOrderRecyclerView;
    @BindView(R.id.linearLayouttitle)
    LinearLayout linearLayouttitle;
    @BindView(R.id.llMainTittle)
    LinearLayout llMainTittle;
    @BindView(R.id.content_orders)
    RelativeLayout contentOrders;
    List<TodayOrder.OrderList> todayOrderList;
    LinearLayoutManager mLayoutManager;
    TodayOrder todayOrderPojo;
    TodayOrderAdapter todayOrderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        todayOrderList = new ArrayList<>();
        todayOrderPojo = new TodayOrder();
        try {
            GsonBuilder gsonBUilder = new GsonBuilder();
            Gson gson = gsonBUilder.create();
            todayOrderPojo = gson.fromJson(ReadFiles.readRawFileAsString(this, R.raw.today_orders), TodayOrder.class);
            todayOrderList.clear();
            for (TodayOrder.OrderList orderList : todayOrderPojo.orderList) {
                todayOrderList.add(orderList);
            }
        } catch (Exception e) {
            AppLog.handleException(AppLog.TAG, e);
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        todayOrderAdapter = new TodayOrderAdapter(todayOrderList, this);
        todayOrderRecyclerView.setLayoutManager(layoutManager);
        todayOrderRecyclerView.setItemAnimator(new DefaultItemAnimator());
        todayOrderRecyclerView.setAdapter(todayOrderAdapter);
    }
}