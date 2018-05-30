package chencheng.bwie.com.chencheng20180504_two.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dell on 2018/5/4.
 */

public class RetrofitUtils {
    public static OkHttpClient client;
    public static ServiceApi serviceApi;
    static {
        getClient();
    }
    //单例模式
    public static OkHttpClient getClient(){
        if (client==null){
            synchronized (RetrofitUtils.class){
                if (client==null){
                    client=new OkHttpClient.Builder()
                            .connectTimeout(3000, TimeUnit.MILLISECONDS)
                            .build();
                }
            }
        }
        return client;
    }
    //单例模式
    public static ServiceApi getServiceApi(){
        if (serviceApi==null){
            synchronized (OkHttpClient.class){
                if (serviceApi==null){
                    serviceApi=RetrofitUtils.onCreate(ServiceApi.class,Api.HOME);
                }
            }

        }
      return serviceApi;
    }
    public static <T> T onCreate(Class<T> tClass,String url){
        final Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(url)
                .build();
        return retrofit.create(tClass);
    }
}
