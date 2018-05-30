package chencheng.bwie.com.chencheng20180504_two.model;

import java.util.HashMap;

import chencheng.bwie.com.chencheng20180504_two.bean.RegisterBean;
import chencheng.bwie.com.chencheng20180504_two.net.NetListenter;
import chencheng.bwie.com.chencheng20180504_two.net.RetrofitUtils;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dell on 2018/5/4.
 */

public class RegisterModel implements IRegisterModel {
    @Override
    public void getRegsiter(String mobile, String password, final NetListenter<RegisterBean> netListenter) {
        HashMap<String, String> map = new HashMap<>();
        map.put("mobile",mobile);
        map.put("password",password);
        Flowable flowable= RetrofitUtils.getServiceApi().registre("user/reg",map);
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RegisterBean>() {

                    @Override
                    public void accept(RegisterBean registerBean) throws Exception {
                        netListenter.onSccess(registerBean);
                    }


                });
    }
}
