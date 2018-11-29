package com.lt.unitreetest.ui.device;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.daimajia.numberprogressbar.NumberProgressBar;
import com.lt.unitreetest.R;
import com.lt.unitreetest.common.CommonTitleActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FirmwareUpdateActivity extends CommonTitleActivity {


    @BindView(R.id.iv_close)
    ImageView close;
    @BindView(R.id.iv_update_icon)
    ImageView icon;
    @BindView(R.id.btn_start_update)
    Button startUpdate;
    @BindView(R.id.ll_update_progress)
    LinearLayout update;
    @BindView(R.id.pb_update_progress)
    NumberProgressBar progressBar;
    @BindView(R.id.tv_update_progress)
    TextView progressText;


    private Unbinder unbinder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firmware_update);
        unbinder = ButterKnife.bind(this);
        close.setVisibility(View.GONE);

        startUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Glide.with(FirmwareUpdateActivity.this).load(R.drawable.upgrade).into(icon);
                startUpdate.setVisibility(View.GONE);
                update.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void beforeFinish(){}

    @Override
    public void setTitle(){titleBar.setText(getString(R.string.firmware_update));}
}
