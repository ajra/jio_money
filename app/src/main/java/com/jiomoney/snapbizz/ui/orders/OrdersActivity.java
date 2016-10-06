package com.jiomoney.snapbizz.ui.orders;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jiomoney.snapbizz.R;
import com.jiomoney.snapbizz.adapter.TodayOrderAdapter;
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
    Activity context;
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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR_MR1) {
            todayOrderRecyclerView.setHasFixedSize(true);
        }
        mLayoutManager = new LinearLayoutManager(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR_MR1) {
            todayOrderRecyclerView.setLayoutManager(mLayoutManager);
        }
        todayOrderPojo=new TodayOrder();
        try {
            GsonBuilder gsonBUilder = new GsonBuilder();
            Gson gson = gsonBUilder.create();
            todayOrderPojo = gson.fromJson(ReadFiles.readRawFileAsString(this, R.raw.today_orders), TodayOrder.class);
            todayOrderList.clear();
            for (int i = 0; i < todayOrderPojo.orderList.size(); i++) {
                todayOrderList.add(todayOrderPojo.orderList.get(i));
                System.out.println("Today order list: " + todayOrderPojo.orderList.get(i));
                System.out.println("Today order list: " + todayOrderPojo.orderList);
                System.out.println("Today order list: " + todayOrderList);
            }
        } catch (Exception e) {
            AppLog.handleException(AppLog.TAG, e);
        }
        todayOrderAdapter = new TodayOrderAdapter(todayOrderList,context);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR_MR1) {
            todayOrderRecyclerView.setAdapter(todayOrderAdapter);
        }
    }
}