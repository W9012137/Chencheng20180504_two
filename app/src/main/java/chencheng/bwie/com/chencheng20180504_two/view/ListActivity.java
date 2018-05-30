package chencheng.bwie.com.chencheng20180504_two.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import chencheng.bwie.com.chencheng20180504_two.R;
import chencheng.bwie.com.chencheng20180504_two.adapter.MyAdapter;
import chencheng.bwie.com.chencheng20180504_two.bean.ProuductsBean;
import chencheng.bwie.com.chencheng20180504_two.presenter.ListPresenter;

/**
 * Created by dell on 2018/5/4.
 */

public class ListActivity extends AppCompatActivity implements IListView{
    @BindView(R.id.rv_list)
    MyAdapter adapter;
    private RecyclerView mRvList;
 ListPresenter presenter;
    private String sort = "0";
    private int page = 1;
    private String pscid="1";
    List<ProuductsBean.DataBean> list = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_main);
        ButterKnife.bind(this);
        initView();
        presenter=new ListPresenter(this);
        presenter.list(page+"",pscid,"0");
    }

    private void initView() {
        mRvList = (RecyclerView) findViewById(R.id.rv_list);
        mRvList.setLayoutManager(new LinearLayoutManager(ListActivity.this));
    }


    @Override
    public void show(ProuductsBean prouductsBean, String pscid) {
       adapter=new MyAdapter(this,prouductsBean.getData());
       mRvList.setAdapter(adapter);
       //接口回调
       adapter.setOnclickSpflAdpter(new MyAdapter.OnClickfl() {
           @Override
           public void onClickxq(int position) {
                Intent intent = new Intent(ListActivity.this, DeatliActivity.class);
               intent.putExtra("pid",position);
               startActivity(intent);
           }
       });
    }
}
