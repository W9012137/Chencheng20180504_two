package chencheng.bwie.com.chencheng20180504_two.model;


import chencheng.bwie.com.chencheng20180504_two.bean.LogBean;
import chencheng.bwie.com.chencheng20180504_two.net.NetListenter;

/**
 * Created by dell on 2018/5/4.
 */

public interface ILoginModel {
    void getLogin(String mobile, String password, NetListenter<LogBean> netListenter);
}
