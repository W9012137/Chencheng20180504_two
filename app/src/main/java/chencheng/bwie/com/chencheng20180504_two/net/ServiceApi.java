package chencheng.bwie.com.chencheng20180504_two.net;

import java.util.Map;

import chencheng.bwie.com.chencheng20180504_two.bean.LogBean;
import chencheng.bwie.com.chencheng20180504_two.bean.ProuductsBean;
import chencheng.bwie.com.chencheng20180504_two.bean.RegisterBean;
import chencheng.bwie.com.chencheng20180504_two.bean.Userbean;
import chencheng.bwie.com.chencheng20180504_two.bean.XiangBean;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by dell on 2018/5/4.
 */

public interface ServiceApi {
    //注册
 @POST
    Flowable<RegisterBean> registre(@Url String url, @QueryMap Map<String, String> map);
  //登录
    @POST
    Flowable<LogBean> login(@Url String url, @QueryMap Map<String, String> map);
 //列表
    @POST
    Flowable<ProuductsBean> prouducts(@Url String url,@QueryMap Map<String,String> map);
    //详情
    @GET("product/getProductDetail")
    Flowable<XiangBean> detail (@Query("pid") String pid, @Query("source") String source);
    //个然中心
    @GET("user/getUserInfo")
    Flowable<Userbean> user (@Query("uid") String pid, @Query("source") String source);
}
