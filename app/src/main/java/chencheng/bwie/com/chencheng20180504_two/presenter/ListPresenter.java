package chencheng.bwie.com.chencheng20180504_two.presenter;

import chencheng.bwie.com.chencheng20180504_two.bean.ProuductsBean;
import chencheng.bwie.com.chencheng20180504_two.model.IProuduModel;
import chencheng.bwie.com.chencheng20180504_two.model.ListModel;
import chencheng.bwie.com.chencheng20180504_two.net.NetListenter;
import chencheng.bwie.com.chencheng20180504_two.view.IListView;

/**
 * Created by dell on 2018/5/4.
 */

public class ListPresenter {
    private IListView iListView;
    private IProuduModel iProuduModel;

    public ListPresenter(IListView iListView) {
        this.iListView = iListView;
        iProuduModel=new ListModel();
    }
    public void list(final String pscid, String page, String sort){
        iProuduModel.getList(pscid, page, sort, new NetListenter<ProuductsBean>() {
            @Override
            public void onSccess(ProuductsBean prouductsBean) {
                iListView.show(prouductsBean,pscid);
            }

            @Override
            public void onFailuer(Exception e) {

            }
        });
    }
}
