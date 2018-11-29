package com.lt.unitreetest.ui.personal.PasswordManagement;

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

public class ModifyPasswordActivity extends CommonTitleActivity {

    @BindView(R.id.iv_close)
    ImageView close;
    @BindView(R.id.btn_confirm_modify)
    Button modify;

    private Unbinder unbinder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_password);
        unbinder = ButterKnife.bind(this);
        close.setVisibility(View.GONE);

        modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
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
    public void setTitle(){titleBar.setText(getString(R.string.modify_password));}
}
