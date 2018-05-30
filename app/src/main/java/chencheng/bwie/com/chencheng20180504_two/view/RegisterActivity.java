package chencheng.bwie.com.chencheng20180504_two.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import chencheng.bwie.com.chencheng20180504_two.R;
import chencheng.bwie.com.chencheng20180504_two.bean.RegisterBean;
import chencheng.bwie.com.chencheng20180504_two.presenter.RegisterPresenter;


/**
 * Created by dell on 2018/5/4.
 */

public class RegisterActivity extends AppCompatActivity implements IRegisterView, View.OnClickListener {
    @BindView(R.id.fanhu)
    ImageView mFanhu;
    @BindView(R.id.name)
    EditText mName;
    @BindView(R.id.pwad)
    EditText mPwad;
    @BindView(R.id.register)
    TextView mRegister;
    RegisterPresenter presenter;
    String name;
    String pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        initView();
        ButterKnife.bind(this);
        //关联
        presenter = new RegisterPresenter(this);
    }


    @Override
    public void showRegister(RegisterBean registerBean) {
        Toast.makeText(this, registerBean.getMsg(), Toast.LENGTH_SHORT).show();
    }

    private void initView() {
        mFanhu = (ImageView) findViewById(R.id.fanhu);
        mFanhu.setOnClickListener(this);
        mName = (EditText) findViewById(R.id.name);
        mPwad = (EditText) findViewById(R.id.pwad);
        mRegister = (TextView) findViewById(R.id.register);
        mRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
                //返回上一层
            case R.id.fanhu:
                final Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);

                break;

                //注册
            case R.id.register:
                name = mName.getText().toString().trim();
                pwd = mPwad.getText().toString().trim();
                presenter.register(name, pwd);
                break;
        }
    }
}
