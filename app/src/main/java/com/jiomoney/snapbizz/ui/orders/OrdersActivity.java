package com.jiomoney.snapbizz.ui.orders;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jiomoney.snapbizz.R;
import com.jiomoney.snapbizz.adapter.TodayOrderAdapter;
import com.jiomoney.snapbizz.ui.orders.model.TodayOrder;
import com.jiomoney.snapbizz.utils.AppLog;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrdersActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.today_Order_RecyclerView)
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
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        todayOrderList = new ArrayList<>();
        todayOrderRecyclerView.setHasFixedSize(true);
        mLayoutManager=new LinearLayoutManager(this);
        todayOrderRecyclerView.setLayoutManager(mLayoutManager);
        todayOrderPojo=new TodayOrder();
        try {
            GsonBuilder gsonBUilder = new GsonBuilder();
            Gson gson = gsonBUilder.create();
            todayOrderPojo = gson.fromJson(loadJSONFromAsset("today_orders.json"), TodayOrder.class);
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
        todayOrderRecyclerView.setAdapter(todayOrderAdapter);
    }

    public String loadJSONFromAsset(String string) {
        String json = null;
        try {
            InputStream is = OrdersActivity.this.getAssets().open(string);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            AppLog.handleException(AppLog.TAG, ex);
            return null;
        }
        return json;
    }
}