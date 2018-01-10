package com.yangc.customdialog;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.yangc.dialog.DialogManager;
import com.yangc.dialog.IDialogListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void show(View view){
        showDialog(R.layout.dialog_common,
                R.id.btn_dialog_confirm,"确定",
                R.id.btn_dialog_cancel,"取消",
                R.id.tv_dialog_title,"你确定要取消该订单吗？",
                R.id.tv_dialog_content,"订单取消后将不可恢复",
                orderCancelListener);
    }
    /**
     * 显示对话框
     * @param dialogLayout 对话框布局
     * @param positiveButtonId 确定按钮id
     * @param positiveButtonText 确定按钮文字
     * @param negativeButtonId  取消按钮id
     * @param negativeButtonText  取消按钮文字
     * @param titleId 标题id
     * @param title 标题文字
     * @param contentId 内容id
     * @param content 内容文字
     * @param dialogListener 按钮回调接口
     */
    private void showDialog(@LayoutRes int dialogLayout,
                            @IdRes int positiveButtonId, CharSequence positiveButtonText,
                            @IdRes int negativeButtonId, CharSequence negativeButtonText,
                            @IdRes int titleId, String title,
                            @IdRes int contentId, String content,
                            IDialogListener dialogListener
    ){
        DialogManager.create()
                .with(this)
                .setDialogListener(dialogListener)
                .setDialogLayout(dialogLayout)
                .setButtonResId(positiveButtonId,positiveButtonText,
                        negativeButtonId,negativeButtonText)
                .setTitle(titleId,title)
                .setContent(contentId,content)
                .show();
    }
    /**
     * 处理 dialog 按钮点击事件
     */
    private IDialogListener orderCancelListener = new IDialogListener() {
        @Override
        public void onPositiveButtonClick() {

        }

        @Override
        public void onNegativeButtonClick() {

        }
    };
}
