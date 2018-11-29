package com.lt.unitreetest.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.lt.unitreetest.R;

/**
 * 作者：zhaowenlong on 2018/11/6 11:14
 * <p>
 * 邮箱：1317351149@qq.com
 */
public class ConsoleDialog {
    private String dialogTitle;
    private String dialogContent;
    private Context mContext;
    private AlertDialog.Builder builder;
    private TextView title,content;
    private EditText editText;
    private Button cancel,confirm;
    private Dialog dialog;

    public Button getCancel() {
        return cancel;
    }

    public void setCancel(Button cancel) {
        this.cancel = cancel;
    }

    public Button getConfirm() {
        return confirm;
    }

    public void setConfirm(Button confirm) {
        this.confirm = confirm;
    }

    public ConsoleDialog(String dialogTitle, Context mContext) {
        this.dialogTitle = dialogTitle;
        this.mContext = mContext;
    }

    public ConsoleDialog(String dialogTitle, String dialogContent, Context mContext) {
        this.dialogTitle = dialogTitle;
        this.dialogContent = dialogContent;
        this.mContext = mContext;
    }

    public void creat() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.layout_console_dailog, null);
        title = (TextView)v.findViewById(R.id.tv_dialog_title);
        title.setText(dialogTitle);
        content = (TextView)v.findViewById(R.id.tv_dialog_content);
        content.setText(dialogContent);
        editText = (EditText)v.findViewById(R.id.et_dialog_content);
        cancel = (Button)v.findViewById(R.id.btn_dialog_cancel);
        confirm = (Button)v.findViewById(R.id.btn_dialog_confirm);
        dialog = builder.create();
        dialog.show();
        dialog.getWindow().setContentView(v);//自定义布局应该在这里添加，要在dialog.show()的后面
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.width = 1000;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.RIGHT;
        dialog.getWindow().setAttributes(lp);
        //Dialog中的EditText能获取输入
        dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
    }

    public String getContentText() {
        return editText.getText().toString();
    }

    public void dialogDismiss(){
        dialog.dismiss();
    }

}
