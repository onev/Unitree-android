package com.lt.unitreetest.ui.personal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.lt.unitreetest.R;
import com.lt.unitreetest.common.CommonItem;
import com.lt.unitreetest.common.CommonListAdapter;
import com.lt.unitreetest.common.CommonTitleActivity;
import com.lt.unitreetest.common.ItemClickListener;
import com.lt.unitreetest.model.PersonalMenuItem;
import com.lt.unitreetest.ui.homepage.adapter.MoreAdapter;
import com.lt.unitreetest.ui.personal.PasswordManagement.BackPasswordActivity;
import com.lt.unitreetest.ui.personal.PasswordManagement.ModifyPasswordActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class PasswordManagementActivity extends CommonTitleActivity {

    @BindView(R.id.iv_close)
    ImageView close;
    @BindView(R.id.rv_password_management)
    RecyclerView recyclerView;

    private Unbinder unbinder;
    private CommonListAdapter adapter;
    private List<CommonItem> itemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_management);
        unbinder = ButterKnife.bind(this);
        close.setVisibility(View.GONE);

        initData();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recyclerView.setHasFixedSize(true);
        adapter = new CommonListAdapter(itemList,this);
        adapter.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(PasswordManagementActivity.this,ModifyPasswordActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(PasswordManagementActivity.this,BackPasswordActivity.class);
                        startActivity(intent1);
                        break;
                        default:
                            break;
                }
            }
        });
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void initData(){
        CommonItem first = new CommonItem("修改密码");
        CommonItem second = new CommonItem("忘记密码");
        itemList.add(first);
        itemList.add(second);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void beforeFinish(){}

    @Override
    public void setTitle(){titleBar.setText(getString(R.string.password_management));}
}
