package com.lt.unitreetest.ui.device.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.lt.unitreetest.R;
import com.lt.unitreetest.common.BaseFragment;
import com.lt.unitreetest.widget.ConsoleDialog;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TwoFragment extends BaseFragment {
    @BindView(R.id.tv_wifi_name)
    TextView wifiName;
    @BindView(R.id.tv_wifi_password_data)
    TextView wifiPassword;
    @BindView(R.id.btn_password_visible)
    CheckBox passwordVisiable;


    private ConsoleDialog dialog;
    public TwoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        ButterKnife.bind(this,view);
        wifiName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new ConsoleDialog("修改WiFi名称","WiFi名称",getActivity());
                dialog.creat();
                dialog.getConfirm().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (dialog.getContentText().isEmpty()){
                            dialog.dialogDismiss();
                        }else {
                            wifiName.setText(dialog.getContentText());
                            dialog.dialogDismiss();
                        }
                    }
                });
                dialog.getCancel().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dialogDismiss();
                    }
                });
            }
        });

        wifiPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new ConsoleDialog("修改WiFi密码","WiFi密码",getActivity());
                dialog.creat();
                dialog.getConfirm().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (dialog.getContentText().isEmpty()){
                            dialog.dialogDismiss();
                        }else {
                        wifiPassword.setText(dialog.getContentText());
                        dialog.dialogDismiss();
                        }
                    }
                });
                dialog.getCancel().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dialogDismiss();
                    }
                });
            }
        });

        passwordVisiable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    wifiPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    wifiPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        return view;
    }

}
