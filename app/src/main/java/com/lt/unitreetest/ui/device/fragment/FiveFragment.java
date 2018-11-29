package com.lt.unitreetest.ui.device.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.lt.unitreetest.R;
import com.lt.unitreetest.common.BaseFragment;
import com.lt.unitreetest.widget.ConsoleDialog;
import com.suke.widget.SwitchButton;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class FiveFragment extends BaseFragment {

    @BindView(R.id.btn_cruise_model)
    SwitchButton cruiseMode;
    @BindView(R.id.btn_matrix_mode)
    RadioButton matrixMode;
    @BindView(R.id.btn_circle_mode)
    RadioButton circleMode;
    @BindView(R.id.tv_mode_setting)
    TextView modeSetting;
    @BindView(R.id.btn_clockwise)
    RadioButton clockwise;
    @BindView(R.id.btn_counterclockwise)
    RadioButton counterclockwise;
    @BindView(R.id.ll_longitudinal_direction)
    LinearLayout longdirection;
    @BindView(R.id.ll_width_direction)
    LinearLayout widthdirection;
    @BindView(R.id.ll_circle_radius)
    LinearLayout circleradius;
    @BindView(R.id.tv_longitudinal_direction)
    TextView length;
    @BindView(R.id.tv_width_direction)
    TextView width;
    @BindView(R.id.tv_circle_radius)
    TextView radius;
    @BindView(R.id.tv_circle_number)
    TextView circleNumber;
    @BindView(R.id.ll_matrix)
    LinearLayout matrixll;
    @BindView(R.id.ll_circle)
    LinearLayout circlell;
    @BindView(R.id.ll_counterclockwise)
    LinearLayout counterclockwisell;
    @BindView(R.id.ll_clockwise)
    LinearLayout clockwisell;


    private ConsoleDialog dialog;
    public FiveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_five, container, false);
        ButterKnife.bind(this,view);

        matrixMode.setChecked(true);
        clockwise.setChecked(true);
        matrixMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    modeSetting.setText("矩形模式设置");
                    circleradius.setVisibility(View.GONE);
                    longdirection.setVisibility(View.VISIBLE);
                    widthdirection.setVisibility(View.VISIBLE);
                }
            }
        });
        circleMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                modeSetting.setText("圆形轨迹模式设置");
                longdirection.setVisibility(View.GONE);
                widthdirection.setVisibility(View.GONE);
                circleradius.setVisibility(View.VISIBLE);
                }
            }
        });
        length.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new ConsoleDialog("修改长度方向","长度方向",getActivity());
                dialog.creat();
                dialog.getConfirm().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (dialog.getContentText().isEmpty()){
                            dialog.dialogDismiss();
                        }else {
                            length.setText(dialog.getContentText());
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

        width.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new ConsoleDialog("修改宽度方向","宽度方向",getActivity());
                dialog.creat();
                dialog.getConfirm().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (dialog.getContentText().isEmpty()){
                            dialog.dialogDismiss();
                        }else {
                            width.setText(dialog.getContentText());
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

        radius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new ConsoleDialog("修改圆半径","圆半径",getActivity());
                dialog.creat();
                dialog.getConfirm().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (dialog.getContentText().isEmpty()){
                            dialog.dialogDismiss();
                        }else {
                            radius.setText(dialog.getContentText());
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

        circleNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new ConsoleDialog("修改绕行圈数","绕行圈数",getActivity());
                dialog.creat();
                dialog.getConfirm().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (dialog.getContentText().isEmpty()){
                            dialog.dialogDismiss();
                        }else {
                            circleNumber.setText(dialog.getContentText());
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

        matrixll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                matrixMode.setChecked(true);
            }
        });
        circlell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                circleMode.setChecked(true);
            }
        });
        clockwisell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clockwise.setChecked(true);
            }
        });
        counterclockwisell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counterclockwise.setChecked(true);
            }
        });

        return view;
    }

}
