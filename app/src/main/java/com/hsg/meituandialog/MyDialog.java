package com.hsg.meituandialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Joe on 2017/1/3.
 */

public class MyDialog extends ProgressDialog {
    private Context mContext;
    private String mLoadingTip;
    private ImageView iv_loading;
    private TextView tv_loading;
    private AnimationDrawable mAnimation;

    public MyDialog(Context context,String content) {
        super(context);
        this.mContext = context;
        this.mLoadingTip = content;
    }

    /**
     * ProgressDialog不是ViewGroup，自定义布局通过setContentView方法加载进来自定义布局。要重写onCreate
     * 对话框创建的时候调用
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setCancelable(false);//设置点击屏幕不能消失
        initview();
        initdata();
    }

    private void initview() {
        setContentView(R.layout.progress_dialog);
        iv_loading = ((ImageView) findViewById(R.id.iv_loading));
        tv_loading = ((TextView) findViewById(R.id.tv_loading));
    }

    private void initdata() {
        // 通过ImageView对象拿到背景显示的AnimationDrawable
        mAnimation = ((AnimationDrawable) iv_loading.getBackground());
        //主界面点击登录，立即调用这里的动画显示功能
        mAnimation.start();
        //设置正在加载中信息
        tv_loading.setText(mLoadingTip);
    }

    @Override
    public void dismiss() {
        super.dismiss();
        //对话框关闭，同时关闭掉动画。节约资源
        mAnimation.stop();
        mAnimation = null;
    }
}
