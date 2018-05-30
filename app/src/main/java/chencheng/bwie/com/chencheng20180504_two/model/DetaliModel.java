package chencheng.bwie.com.chencheng20180504_two.model;

import chencheng.bwie.com.chencheng20180504_two.bean.XiangBean;
import chencheng.bwie.com.chencheng20180504_two.net.NetListenter;
import chencheng.bwie.com.chencheng20180504_two.net.RetrofitUtils;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dell on 2018/5/4.
 */

public class DetaliModel implements IXiangModel {
    @Override
    public void GetDetail(String pid, final NetListenter<XiangBean> netListenter) {
        Flowable flowable= RetrofitUtils.getServiceApi().detail(pid,"android");
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<XiangBean>() {


                    @Override
                    public void accept(XiangBean xiangBean) throws Exception {
                        netListenter.onSccess(xiangBean);
                    }

                });

    }
}
