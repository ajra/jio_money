package com.jiomoney.snapbizz.ui.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.jiomoney.snapbizz.App;
import com.jiomoney.snapbizz.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.billing_text_view)
    TextView billingTextView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
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
    }

}
