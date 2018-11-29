package com.lt.unitreetest.ui.personal.PasswordManagement;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.lt.unitreetest.R;
import com.lt.unitreetest.common.CommonTitleActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class BackPasswordActivity extends CommonTitleActivity {

    @BindView(R.id.iv_close)
    ImageView close;
    @BindView(R.id.btn_get_authentication_code)
    Button getCode;
    @BindView(R.id.btn_confirm_modify)
    Button confirm;

    private Unbinder unbinder;
    private TimeCount timeCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_password);
        unbinder = ButterKnife.bind(this);
        close.setVisibility(View.GONE);
        timeCount = new TimeCount(60000,1000);
        getCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeCount.start();
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    class TimeCount extends CountDownTimer {
        public TimeCount(long paramLong1, long paramLong2) {
            super(paramLong1,paramLong2);
        }

        public void onFinish() {
            getCode.setText("重新获取验证码");
            getCode.setClickable(true);
//            getCode.setBackgroundColor(BackPasswordActivity.this.getResources().getColor(R.color.transparent));
        }

        public void onTick(long paramLong) {
//            getCode.setBackgroundColor(BackPasswordActivity.this.getResources().getColor(R.color.darkGray));
            getCode.setClickable(false);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("(");
            localStringBuilder.append(paramLong / 1000L);
            localStringBuilder.append("秒后重发)");
            getCode.setText(localStringBuilder.toString());
        }
    }




    @Override
    public void onDestroy(){
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void beforeFinish(){timeCount.cancel();}

    @Override
    public void setTitle(){titleBar.setText(getString(R.string.modify_password));}
}
