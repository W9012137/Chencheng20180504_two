package chencheng.bwie.com.chencheng20180504_two;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by dell on 2018/5/4.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
       Fresco.initialize(this);
    }
}
