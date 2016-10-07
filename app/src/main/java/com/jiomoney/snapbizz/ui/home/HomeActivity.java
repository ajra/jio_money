package com.jiomoney.snapbizz.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jiomoney.snapbizz.App;
import com.jiomoney.snapbizz.R;
import com.jiomoney.snapbizz.ui.billing.BillingActivity;
import com.jiomoney.snapbizz.ui.business.BusinessActivity;
import com.jiomoney.snapbizz.ui.inventory.InventoryManagementActivity;
import com.jiomoney.snapbizz.ui.orders.OrdersActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.billing_text_view)
    TextView billingTextView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.yesterday_business_text_view)
    TextView yesterdayBusinessTextView;
    @BindView(R.id.today_order_text_view)
    TextView todayOrderTextView;
    @BindView(R.id.inventory_management_text_view)
    TextView inventoryManagementTextView;
    @BindView(R.id.content_home)
    RelativeLayout contentHome;
    @BindView(R.id.yesterday_business_layour)
    LinearLayout yesterdayBusinessLayour;
    @BindView(R.id.today_order_layout)
    LinearLayout todayOrderLayout;
    @BindView(R.id.home_inventory_layout)
    LinearLayout homeInventoryLayout;
    @BindView(R.id.billing_layout)
    LinearLayout billingLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setTypeFaces();
    }

    private void setTypeFaces() {
        billingTextView.setTypeface(App.helveticaBold);
        yesterdayBusinessTextView.setTypeface(App.helveticaBold);
        todayOrderTextView.setTypeface(App.helveticaBold);
        inventoryManagementTextView.setTypeface(App.helveticaBold);
    }

    @OnClick({R.id.yesterday_business_layour, R.id.today_order_layout, R.id.home_inventory_layout, R.id.billing_layout})
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.yesterday_business_layour:
                intent = new Intent(this, BusinessActivity.class);
                startActivity(intent);
                break;
            case R.id.today_order_layout:
                intent = new Intent(this, OrdersActivity.class);
                startActivity(intent);
                break;
            case R.id.home_inventory_layout:
                intent = new Intent(this, InventoryManagementActivity.class);
                startActivity(intent);
                break;
            case R.id.billing_layout:
                intent = new Intent(this, BillingActivity.class);
                startActivity(intent);
                break;
        }

    }
}
