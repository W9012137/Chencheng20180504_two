package chencheng.bwie.com.chencheng20180504_two.presenter;

import chencheng.bwie.com.chencheng20180504_two.bean.XiangBean;
import chencheng.bwie.com.chencheng20180504_two.model.DetaliModel;
import chencheng.bwie.com.chencheng20180504_two.model.IXiangModel;
import chencheng.bwie.com.chencheng20180504_two.net.NetListenter;
import chencheng.bwie.com.chencheng20180504_two.view.IDetaliView;

/**
 * Created by dell on 2018/5/4.
 */

public class DetaPreaenter {
    private IDetaliView iDetaliView;
    private IXiangModel iXiangModel;

    public DetaPreaenter(IDetaliView iDetaliView) {
        this.iDetaliView = iDetaliView;
        iXiangModel=new DetaliModel();
    }
    public void ond(){
        iDetaliView=null;
    }
    public void get(final String pid){
        iXiangModel.GetDetail(pid, new NetListenter<XiangBean>() {
            @Override
            public void onSccess(XiangBean xiangBean) {
                iDetaliView.showDetali(xiangBean,pid);
            }

            @Override
            public void onFailuer(Exception e) {

            }
        });
    }
}
