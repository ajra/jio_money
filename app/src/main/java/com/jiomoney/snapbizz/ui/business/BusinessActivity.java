package com.jiomoney.snapbizz.ui.business;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jiomoney.snapbizz.App;
import com.jiomoney.snapbizz.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BusinessActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.total_value_text_view)
    TextView totalValueTextView;
    @BindView(R.id.total_amount_text_view)
    TextView totalAmountTextView;
    @BindView(R.id.total_outstanding_label)
    TextView totalOutstandingLabel;
    @BindView(R.id.total_outstanding_text_view)
    TextView totalOutstandingTextView;
    @BindView(R.id.total_transaction_label)
    TextView totalTransactionLabel;
    @BindView(R.id.total_transaction_text_view)
    TextView totalTransactionTextView;
    @BindView(R.id.total_collection_label)
    TextView totalCollectionLabel;
    @BindView(R.id.total_collection_text_view)
    TextView totalCollectionTextView;
    @BindView(R.id.content_business)
    RelativeLayout contentBusiness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setTypeFaces();
    }

    private void setTypeFaces() {
        totalCollectionLabel.setTypeface(App.helveticaBold);
        totalValueTextView.setTypeface(App.helveticaBold);
        totalTransactionLabel.setTypeface(App.helveticaBold);
        totalOutstandingLabel.setTypeface(App.helveticaBold);
        // set type face
        totalAmountTextView.setTypeface(App.rupeeForadian);
        totalCollectionTextView.setTypeface(App.rupeeForadian);
        totalTransactionTextView.setTypeface(App.rupeeForadian);
        totalOutstandingTextView.setTypeface(App.rupeeForadian);
        totalAmountTextView.setText(this.getResources().getString(
                R.string.rs_symbol) +" 60,000");
        totalCollectionTextView.setText(this.getResources().getString(
                R.string.rs_symbol) +" 57,000");
        totalTransactionTextView.setText(this.getResources().getString(
                R.string.rs_symbol) +" 50");
        totalOutstandingTextView.setText(this.getResources().getString(
                R.string.rs_symbol) +" 3,000");
    }

}
