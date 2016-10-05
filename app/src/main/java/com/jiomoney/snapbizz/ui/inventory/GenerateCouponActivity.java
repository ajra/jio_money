package com.jiomoney.snapbizz.ui.inventory;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.jiomoney.snapbizz.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GenerateCouponActivity extends AppCompatActivity {


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_coupon);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @OnClick({R.id.discount_spinner, R.id.customer_spinner, R.id.submit_button})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.discount_spinner:
                break;
            case R.id.customer_spinner:
                break;
            case R.id.submit_button:
                break;
        }
    }
}
