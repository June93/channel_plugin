package com.june.channel_plugin;

import android.app.Activity;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

public class ChannelPlugin implements MethodCallHandler {

    Activity activity;

    ChannelPlugin(Activity activity) {
        this.activity = activity;
    }

    public static void registerWith(Registrar registrar) {
        final MethodChannel channel = new MethodChannel(registrar.messenger(), "channel_plugin");
        channel.setMethodCallHandler(new ChannelPlugin(registrar.activity()));
    }

    @Override
    public void onMethodCall(MethodCall call, Result result) {
        if (call.method.equals("getPlatformVersion")) {
            result.success("Android " + android.os.Build.VERSION.RELEASE);
        } else if (call.method.equals("getChannel")) {
            handleGetAppChannel(result);
        } else {
            result.notImplemented();
        }
    }

    private void handleGetAppChannel(Result result) {
        String channel = CommonUtil.getMetaDataString(activity, "channel", "unknown");
        result.success(channel);
    }

}
