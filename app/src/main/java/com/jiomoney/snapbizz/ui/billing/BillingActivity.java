package com.jiomoney.snapbizz.ui.billing;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jiomoney.snapbizz.R;
import com.jiomoney.snapbizz.ui.billing.adapter.BillingCheckoutAdapter;
import com.jiomoney.snapbizz.ui.billing.model.BillingCheckOutPojo;
import com.jiomoney.snapbizz.utils.ReadFiles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BillingActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.billing_checkout_text_view)
    TextView billingCheckoutTextView;
    @BindView(R.id.customer_mobile_text_view)
    TextView customerMobileTextView;
    @BindView(R.id.customer_mobile_edit_text)
    EditText customerMobileEditText;
    @BindView(R.id.coupon_applicable_text_view)
    TextView couponApplicableTextView;
    @BindView(R.id.coupon_applicable_edit_text)
    EditText couponApplicableEditText;
    @BindView(R.id.coupon_applicable2_edit_text)
    EditText couponApplicable2EditText;
    @BindView(R.id.item_text_view)
    TextView itemTextView;
    @BindView(R.id.quantity_text_view)
    TextView quantityTextView;
    @BindView(R.id.rate_text_view)
    TextView rateTextView;
    @BindView(R.id.coupon_offer_text_view)
    TextView couponOfferTextView;
    @BindView(R.id.amount_text_view)
    TextView amountTextView;
    @BindView(R.id.itemlist_recycle_view)
    RecyclerView itemlistRecycleView;
    @BindView(R.id.savings_text_view)
    TextView savingsTextView;
    @BindView(R.id.savings_value_text_view)
    TextView savingsValueTextView;
    @BindView(R.id.amount_payable_text_view)
    TextView amountPayableTextView;
    @BindView(R.id.amount_payable_value_text_view)
    TextView amountPayableValueTextView;
    @BindView(R.id.item_value_text_view)
    TextView itemValueTextView;
    @BindView(R.id.total_value_text_view)
    TextView totalValueTextView;
    @BindView(R.id.item_single_row_text_view)
    TextView itemSingleRowTextView;
    @BindView(R.id.total_text_view)
    TextView totalTextView;
    @BindView(R.id.suggestions_text_view)
    TextView suggestionsTextView;
    @BindView(R.id.suggestions_recycler_view)
    RecyclerView suggestionsRecyclerView;
    @BindView(R.id.content_billing)
    ScrollView contentBilling;
    List<BillingCheckOutPojo.OrdersListBean> billList = new ArrayList<>();
    BillingCheckOutPojo billingCheckOutPojo = new BillingCheckOutPojo();
    BillingCheckoutAdapter billingCheckoutAdapter;
    Context context;
    LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billing);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        context = this;
        mLayoutManager = new LinearLayoutManager(this);
        itemlistRecycleView.setHasFixedSize(true);
        itemlistRecycleView.setLayoutManager(mLayoutManager);
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        try {
            billingCheckOutPojo = gson.fromJson(ReadFiles.readRawFileAsString(this, R.raw.bill_checkout), BillingCheckOutPojo.class);
            billList.clear();
            for (int i = 0; i < billingCheckOutPojo.getOrdersList().size(); i++) {
                billList.add(billingCheckOutPojo.getOrdersList().get(i));
                System.out.println("Today order list: " + billingCheckOutPojo.getOrdersList().get(i));
                System.out.println("Today order list: " + billList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        billingCheckoutAdapter = new BillingCheckoutAdapter(billList, context);
        itemlistRecycleView.setAdapter(billingCheckoutAdapter);
    }
}

