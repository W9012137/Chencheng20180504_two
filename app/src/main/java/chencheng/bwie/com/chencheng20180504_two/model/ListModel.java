package chencheng.bwie.com.chencheng20180504_two.model;

import java.util.HashMap;

import chencheng.bwie.com.chencheng20180504_two.bean.ProuductsBean;
import chencheng.bwie.com.chencheng20180504_two.net.NetListenter;
import chencheng.bwie.com.chencheng20180504_two.net.RetrofitUtils;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dell on 2018/5/4.
 */

public class ListModel implements IProuduModel {
    @Override
    public void getList(String pscid, String page, String sort, final NetListenter<ProuductsBean> netListenter) {
         HashMap<String, String> map = new HashMap<>();
         map.put("pscid",pscid);
        map.put("page",page);
        map.put("sort",sort);
        Flowable flowable= RetrofitUtils.getServiceApi().prouducts("product/getProducts",map);
        flowable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ProuductsBean>() {

                    @Override
                    public void accept(ProuductsBean prouductsBean) throws Exception {
                        netListenter.onSccess(prouductsBean);
                    }


                });
    }
}
