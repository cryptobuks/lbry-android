package io.lbry.lbrynet.reactmodules;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import io.lbry.lbrynet.MainActivity;
import io.lbry.lbrynet.LbrynetService;
import io.lbry.lbrynet.ServiceHelper;

public class DaemonServiceControlModule extends ReactContextBaseJavaModule {
    private Context context;

    public DaemonServiceControlModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.context = reactContext;
    }

    @Override
    public String getName() {
        return "DaemonServiceControl";
    }
    
    @ReactMethod
    public void updateKeepDaemonRunning(boolean value) {
        SharedPreferences sp = context.getSharedPreferences(MainActivity.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("keepDaemonRunning", value);
        editor.commit();
    }

    @ReactMethod
    public void stopService() {
        ServiceHelper.stop(context, LbrynetService.class);
    }
}
