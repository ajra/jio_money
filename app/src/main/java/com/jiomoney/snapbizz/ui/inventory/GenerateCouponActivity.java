package com.jiomoney.snapbizz.ui.inventory;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.jiomoney.snapbizz.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GenerateCouponActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.product_name_edit_text)
    EditText productNameEditText;
    @BindView(R.id.mrp_edit_text)
    EditText mrpEditText;
    @BindView(R.id.selling_price_edit_text)
    EditText sellingPriceEditText;
    @BindView(R.id.discount_code_edit_text)
    EditText discountCodeEditText;
    @BindView(R.id.discount_spinner)
    Spinner discountSpinner;
    @BindView(R.id.customer_spinner)
    Spinner customerSpinner;
    @BindView(R.id.submit_button)
    Button submitButton;
    @BindView(R.id.content_generate_coupon)
    LinearLayout contentGenerateCoupon;
    Context context;
    List<String> discountList = new ArrayList<String>();
    List<String> customerList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_coupon);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        //hide soft-keyboard
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        context = this;
        submitButton.setOnClickListener(this);
        discountList.add("All");
        discountList.add("Bala");
        discountList.add("Ram");
        discountList.add("Hari");
        discountList.add("venkat");

        customerList.add("5%");
        customerList.add("10%");
        customerList.add("20%");
        customerList.add("30%");
        customerList.add("40%");
        customerList.add("50%");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, discountList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        discountSpinner.setAdapter(dataAdapter);

        ArrayAdapter<String> custAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, customerList);
        custAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        customerSpinner.setAdapter(custAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.submit_button:
                final Dialog storeDialog = new Dialog(GenerateCouponActivity.this);
                storeDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                storeDialog.setContentView(R.layout.layout_alert_generate_coupon);
                storeDialog.show();
                break;
        }
    }

   /* @OnClick({R.id.discount_spinner, R.id.customer_spinner, R.id.submit_button})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.discount_spinner:
                break;
            case R.id.customer_spinner:
                break;
            case R.id.submit_button:
                break;
        }
    }*/
}
