package com.rskn.capacitor.auto.start;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "CapacitorAutoStart")
public class CapacitorAutoStartPlugin extends Plugin {

     private final CapacitorAutoStart implementation = new CapacitorAutoStart();

    @PluginMethod
    public void enable(PluginCall call) {
        Boolean enableAutoStart = call.getBoolean("enable");
        Boolean enableService = call.getBoolean("enableService");
        implementation.enableAutoStart(getContext(), getBridge().getActivity().getLocalClassName(), Boolean.TRUE.equals(enableAutoStart), Boolean.TRUE.equals(enableService), call);
    }

    @PluginMethod
    public void isEnabled(PluginCall call) {
        Context context = getActivity().getApplicationContext();
        PackageManager pm = context.getPackageManager();
        ComponentName bootCompletedReceiver = new ComponentName(context, BootCompletedReceiver.class);
        ComponentName packageReplaceReceiver = new ComponentName(context, PackageReplacedReceiver.class);
        ComponentName userPresentReceiver = new ComponentName(context, UserPresentReceiver.class);

        int state = pm.getComponentEnabledSetting(bootCompletedReceiver);
        int packageReplaceState = pm.getComponentEnabledSetting(packageReplaceReceiver);
        int userPresentState = pm.getComponentEnabledSetting(userPresentReceiver);
        JSObject result = new JSObject();
        result.put("bootReceiver", state == PackageManager.COMPONENT_ENABLED_STATE_ENABLED);
        result.put("packageReplacer", packageReplaceState == PackageManager.COMPONENT_ENABLED_STATE_ENABLED);
        result.put("userPresent", userPresentState == PackageManager.COMPONENT_ENABLED_STATE_ENABLED);
        call.resolve(result);
    }
}
