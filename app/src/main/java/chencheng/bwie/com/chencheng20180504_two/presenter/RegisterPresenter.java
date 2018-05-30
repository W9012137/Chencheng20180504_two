package chencheng.bwie.com.chencheng20180504_two.presenter;


import chencheng.bwie.com.chencheng20180504_two.bean.RegisterBean;
import chencheng.bwie.com.chencheng20180504_two.model.IRegisterModel;
import chencheng.bwie.com.chencheng20180504_two.model.RegisterModel;
import chencheng.bwie.com.chencheng20180504_two.net.NetListenter;
import chencheng.bwie.com.chencheng20180504_two.view.IRegisterView;

/**
 * Created by dell on 2018/5/4.
 */

public class RegisterPresenter {
    private IRegisterView iRegisterView;
    private IRegisterModel iRegisterModel;

    public RegisterPresenter(IRegisterView iRegisterView) {
        this.iRegisterView = iRegisterView;
        iRegisterModel= new RegisterModel();
    }
    public void register(String mobile ,String password ){
        iRegisterModel.getRegsiter(mobile, password, new NetListenter<RegisterBean>() {
            @Override
            public void onSccess(RegisterBean registerBean) {
                iRegisterView.showRegister(registerBean);
            }

            @Override
            public void onFailuer(Exception e) {

            }
        });
    }
}
