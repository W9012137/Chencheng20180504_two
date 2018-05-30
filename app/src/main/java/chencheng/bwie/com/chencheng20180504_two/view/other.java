package chencheng.bwie.com.chencheng20180504_two.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import chencheng.bwie.com.chencheng20180504_two.R;

/**
 * Created by dell on 2018/5/4.
 */

public class other extends AppCompatActivity implements View.OnClickListener {
    private ImageView mFanhu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userbase);
        initView();
    }

    private void initView() {
        mFanhu = (ImageView) findViewById(R.id.fanhu);
        mFanhu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.fanhu:
                break;
        }
    }
}
