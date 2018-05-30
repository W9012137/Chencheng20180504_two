package chencheng.bwie.com.chencheng20180504_two.model;

import chencheng.bwie.com.chencheng20180504_two.bean.ProuductsBean;
import chencheng.bwie.com.chencheng20180504_two.net.NetListenter;

/**
 * Created by dell on 2018/5/4.
 */

public interface IProuduModel {
    void getList(String pscid, String page, String sort, NetListenter<ProuductsBean> netListenter);
}
