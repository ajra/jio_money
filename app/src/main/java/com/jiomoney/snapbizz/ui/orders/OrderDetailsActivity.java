package com.jiomoney.snapbizz.ui.orders;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jiomoney.snapbizz.R;
import com.jiomoney.snapbizz.ui.orders.adapter.OrderDetailsAdapter;
import com.jiomoney.snapbizz.ui.orders.model.TodayOrder;
import com.jiomoney.snapbizz.utils.AppLog;
import com.jiomoney.snapbizz.utils.ReadFiles;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class OrderDetailsActivity extends AppCompatActivity {


    List<TodayOrder.OrderList.ItemList> orderDetailsList = new ArrayList<>();
    OrderDetailsAdapter orderDetailsAdapter;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.orderHeaderText)
    LinearLayout orderHeaderText;
    @BindView(R.id.custNameEditText)
    EditText custNameEditText;
    @BindView(R.id.custNoEditText)
    EditText custNoEditText;
    @BindView(R.id.deliverTimeEditText)
    EditText deliverTimeEditText;
    @BindView(R.id.sutAddressText)
    EditText sutAddressText;
    @BindView(R.id.nameLayout)
    LinearLayout nameLayout;
    @BindView(R.id.itemLayout)
    RelativeLayout itemLayout;
    @BindView(R.id.itemHeaderLayout)
    LinearLayout itemHeaderLayout;
    @BindView(R.id.orderDetailsRv)
    RecyclerView orderDetailsRv;
    @BindView(R.id.totalAmtText)
    TextView totalAmtText;
    @BindView(R.id.content_order_details)
    RelativeLayout contentOrderDetails;
    @BindView(R.id.pamentMethodText)
    TextView pamentMethodText;
    @BindView(R.id.totlQtyText)
    TextView totlQtyText;
    @BindView(R.id.continueBtn)
    Button continueBtn;
    @BindView(R.id.totlItemText)
    TextView totlItemText;
    private EventBus bus = EventBus.getDefault();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        ButterKnife.bind(this);
        //hide soft-keyboard
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        initView();
    }

    public void initView()

    {
        orderDetailsRv = (RecyclerView) findViewById(R.id.orderDetailsRv);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR_MR1) {
            orderDetailsRv.setHasFixedSize(true);
        }
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR_MR1) {
            orderDetailsRv.setLayoutManager(mLayoutManager);
        }
        TodayOrder orderDetailsResponse=new TodayOrder();
        try {

            GsonBuilder gsonBUilder = new GsonBuilder();
            Gson gson = gsonBUilder.create();
            orderDetailsResponse = gson.fromJson(ReadFiles.readRawFileAsString(this, R.raw.today_orders), TodayOrder.class);
            for (int i = 0; i < orderDetailsResponse.orderList.get(2).itemList.size(); i++) {
                orderDetailsList.add(orderDetailsResponse.orderList.get(2).itemList.get(i));
                System.out.println("Today order list: " + orderDetailsResponse.orderList.get(2).itemList.get(i).productQuantity);
                System.out.println("Today order list: " + orderDetailsResponse.orderList.get(2).itemList.get(i));
                System.out.println("Today order list: " + orderDetailsResponse.orderList.get(2).itemList.get(i));
            }
        } catch (Exception e) {
            AppLog.handleException(AppLog.TAG, e);
        }
        orderDetailsAdapter = new OrderDetailsAdapter(getApplicationContext(), orderDetailsList);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR_MR1) {
            orderDetailsRv.setAdapter(orderDetailsAdapter);
        }

        try {

            totlItemText.setText(orderDetailsList.size() + "");
            totalAmtText.setText("Total  :  "+orderDetailsResponse.orderList.get(2).total + "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        bus.register(this); // registering the bus
    }

    @Override
    public void onStop() {
        bus.unregister(this); // un-registering the bus
        super.onStop();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onTotal(OrderTotal event) {
        totalAmtText.setText("Total  :  "+String.valueOf(event.count));

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onTotalQty(OrderQty event) {
        totlQtyText.setText(String.valueOf(event.count));

    }
}
