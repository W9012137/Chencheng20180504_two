package chencheng.bwie.com.chencheng20180504_two.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import chencheng.bwie.com.chencheng20180504_two.R;
import chencheng.bwie.com.chencheng20180504_two.bean.LogBean;
import chencheng.bwie.com.chencheng20180504_two.net.Toasts;
import chencheng.bwie.com.chencheng20180504_two.presenter.LoginPresenter;


public class MainActivity extends AppCompatActivity implements IMainView, View.OnClickListener {


    LoginPresenter presenter;
    String mane;
    String pwd;
    private ImageView mImageView;
    /**
     * 手机号/会员号/邮箱
     */
    private EditText mPhone;
    /**
     * 请输入密码
     */
    private EditText mPwd;
    /**
     * 忘记密码
     */
    private TextView mTextView;
    /**
     * 新用户注册
     */
    private TextView mTextView2;
    /**
     * 登录
     */
    private TextView mLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter=new LoginPresenter(this);
        initView();


    }


    @Override
    public void showLigin(LogBean logBean) {
        Toast.makeText(this, logBean.getMsg(), Toast.LENGTH_SHORT).show();
        Toasts.showLong(this, "登录成功");
        final Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);

    }



    private void initView() {
        mImageView = (ImageView) findViewById(R.id.imageView);
        mPhone = (EditText) findViewById(R.id.phone);
        mPwd = (EditText) findViewById(R.id.pwd);
        mTextView = (TextView) findViewById(R.id.textView);
        mTextView2 = (TextView) findViewById(R.id.textView2);
        mTextView2.setOnClickListener(this);
        mLogin = (TextView) findViewById(R.id.login);
        mLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;

                //驻车页面
            case R.id.textView2:
                final Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
                //登录
            case R.id.login:
                mane = mPhone.getText().toString().trim();
                pwd = mPwd.getText().toString().trim();
                presenter.log(mane,pwd);
                break;
        }
    }
}
