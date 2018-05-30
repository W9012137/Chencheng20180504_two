package chencheng.bwie.com.chencheng20180504_two.model;

import chencheng.bwie.com.chencheng20180504_two.bean.XiangBean;
import chencheng.bwie.com.chencheng20180504_two.net.NetListenter;

/**
 * Created by dell on 2018/5/4.
 */

public interface IXiangModel {
    void GetDetail(String pid, NetListenter<XiangBean> netListenter);
}
