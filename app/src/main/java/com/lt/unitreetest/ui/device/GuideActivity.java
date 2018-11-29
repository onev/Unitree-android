package com.lt.unitreetest.ui.device;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lt.unitreetest.MainActivity;
import com.lt.unitreetest.R;
import com.lt.unitreetest.common.CommonTitleActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class GuideActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.ib_back)
    LinearLayout back;
    @BindView(R.id.iv_close)
    ImageView close;
    @BindView(R.id.iv_guide)
    ImageView guide;
    @BindView(R.id.btn_guide)
    Button guideNext;

    private Unbinder unbinder;
    private int flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        unbinder = ButterKnife.bind(this);
        Glide.with(this).load(R.drawable.steps1).into(guide);
        guideNext.setText(R.string.next_step);

        flag=0;

        back.setOnClickListener(this);
        close.setOnClickListener(this);
        guideNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.ib_back:
                if (flag==0){
                    finish();
                }else{
                    flag -=1;
                    onGuide(flag);
                }
                break;
            case R.id.iv_close:
                finish();
                break;
            case R.id.btn_guide:
                if (flag==2){
                    Intent intent = new Intent(GuideActivity.this,MainActivity.class);
                    startActivity(intent);
                    //Toast.makeText(this,"跳转",Toast.LENGTH_SHORT).show();
                }else {
                    flag +=1;
                    onGuide(flag);
                }
                break;
                default:break;
        }
    }

    public void onGuide(int flag){
        switch (flag){
            case 0:
                Glide.with(this).load(R.drawable.steps1).into(guide);
                guideNext.setText(R.string.next_step);
                break;
            case 1:
                Glide.with(this).load(R.drawable.steps2).into(guide);
                guideNext.setText(R.string.next_step);
                break;
            case 2:
                Glide.with(this).load(R.drawable.steps3).into(guide);
                guideNext.setText(R.string.completed);
                break;
                default:break;
        }
    }


    @Override
    public void onDestroy(){
        super.onDestroy();
        unbinder.unbind();
    }
}
