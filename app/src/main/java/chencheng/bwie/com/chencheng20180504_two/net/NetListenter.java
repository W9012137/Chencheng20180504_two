package chencheng.bwie.com.chencheng20180504_two.net;

/**
 * Created by dell on 2018/5/4.
 */

public interface NetListenter<T> {
    //成功
    void onSccess(T t);
    //失败
     void onFailuer(Exception e);
}
