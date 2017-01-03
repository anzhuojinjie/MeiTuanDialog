package com.hsg.meituandialog;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MyDialog myDialog;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0x01:
                    myDialog.dismiss();
                    Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnClick(View view) {
        switch (view.getId()){
            case R.id.btn_loading_start:
                myDialog = new MyDialog(this,"正在登录。。。");
                myDialog.show();
                handler.sendEmptyMessageDelayed(0x01,5000);
                break;
            default:
                break;
        }
    }
}
