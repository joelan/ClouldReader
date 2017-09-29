package com.example.jingbin.cloudreader.app;

import android.app.Application;
import android.content.res.Configuration;
import android.content.res.Resources;

import com.example.http.HttpUtils;
import com.example.jingbin.cloudreader.utils.DebugUtil;
import com.fengteng.adslibrary.FengtengSDKContext;

/**
 * Created by jingbin on 2016/11/22.
 */

public class CloudReaderApplication extends Application {

    private static CloudReaderApplication cloudReaderApplication;

    public static CloudReaderApplication getInstance() {
        return cloudReaderApplication;
    }

    @SuppressWarnings("unused")
    @Override
    public void onCreate() {
        super.onCreate();
        cloudReaderApplication = this;
        HttpUtils.getInstance().init(this, DebugUtil.DEBUG);

        //初始化SDk信息  第二个参数appid,第三个参数sid
        FengtengSDKContext.init(this,"a358eabbe25f57c699d346a0cfcc6485","143");

        initTextSize();
    }

    /**
     * 使其系统更改字体大小无效
     */
    private void initTextSize() {
        Resources res = getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config, res.getDisplayMetrics());
    }

}
