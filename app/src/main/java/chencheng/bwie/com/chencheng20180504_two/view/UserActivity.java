package chencheng.bwie.com.chencheng20180504_two.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import chencheng.bwie.com.chencheng20180504_two.R;

/**
 * Created by dell on 2018/5/4.
 */

public class UserActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView mIv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user);
        initView();
    }

    private void initView() {
        mIv = (ImageView) findViewById(R.id.iv);
        mIv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv:
                startActivity(new Intent(this,other.class));
                break;
        }
    }
}
