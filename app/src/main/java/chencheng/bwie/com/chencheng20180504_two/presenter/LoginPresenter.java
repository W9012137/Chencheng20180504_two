package chencheng.bwie.com.chencheng20180504_two.presenter;


import chencheng.bwie.com.chencheng20180504_two.bean.LogBean;
import chencheng.bwie.com.chencheng20180504_two.model.ILoginModel;
import chencheng.bwie.com.chencheng20180504_two.model.LoginModel;
import chencheng.bwie.com.chencheng20180504_two.net.NetListenter;
import chencheng.bwie.com.chencheng20180504_two.view.IMainView;

/**
 * Created by dell on 2018/5/4.
 */

public class LoginPresenter {
    private IMainView iMainView;
    private ILoginModel iLoginModel;

    public LoginPresenter(IMainView iMainView) {
        this.iMainView = iMainView;
        iLoginModel=new LoginModel();
    }
    public void log(String mobile ,String password ){
        iLoginModel.getLogin(mobile, password, new NetListenter<LogBean>() {
            @Override
            public void onSccess(LogBean logBean) {
                iMainView.showLigin(logBean);
            }

            @Override
            public void onFailuer(Exception e) {

            }
        });
    }
}
