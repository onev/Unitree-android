package com.lt.unitreetest.ui.personal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.lt.unitreetest.R;
import com.lt.unitreetest.common.CommonTitleActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class TechSupportActivity extends CommonTitleActivity {

    @BindView(R.id.iv_close)
    ImageView close;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech_support);
        unbinder = ButterKnife.bind(this);
        close.setVisibility(View.GONE);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void beforeFinish(){}

    @Override
    public void setTitle(){titleBar.setText(getString(R.string.technical_support));}
}
