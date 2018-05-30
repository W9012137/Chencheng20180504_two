package chencheng.bwie.com.chencheng20180504_two.model;

import java.util.HashMap;

import chencheng.bwie.com.chencheng20180504_two.bean.LogBean;
import chencheng.bwie.com.chencheng20180504_two.net.NetListenter;
import chencheng.bwie.com.chencheng20180504_two.net.RetrofitUtils;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dell on 2018/5/4.
 */

public class LoginModel implements ILoginModel {
    @Override
    public void getLogin(String mobile, String password, final NetListenter<LogBean> netListenter) {
         HashMap<String, String> map = new HashMap<>();
         map.put("mobile",mobile);
         map.put("password",password);
        Flowable flowable= RetrofitUtils.getServiceApi().login("user/login",map);
        flowable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<LogBean>() {

                    @Override
                    public void accept(LogBean logBean) throws Exception {
                        netListenter.onSccess(logBean);
                    }


                });
    }
}
