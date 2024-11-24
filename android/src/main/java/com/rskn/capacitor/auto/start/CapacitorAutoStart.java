package com.rskn.capacitor.auto.start;

import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;

import com.getcapacitor.PluginCall;

public class CapacitorAutoStart {

    public static final String PREFS = "autostart";
    public static final String ACTIVITY_CLASS_NAME = "class";
    public static final String SERVICE_CLASS_NAME = "service";

    public void enableAutoStart(final Context context, final String className, boolean enabled, boolean isService, PluginCall call) {
            int componentState;
            SharedPreferences sp = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            if (enabled) {
                PackageManager pm = context.getPackageManager();

                ComponentName bootCompletedReceiver = new ComponentName(context, BootCompletedReceiver.class);
                ComponentName packageReplacedReceiver = new ComponentName(context, PackageReplacedReceiver.class);
                ComponentName userPresentReceiver = new ComponentName(context, UserPresentReceiver.class);

                pm.setComponentEnabledSetting(bootCompletedReceiver, enabled ? PackageManager.COMPONENT_ENABLED_STATE_ENABLED : PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
                pm.setComponentEnabledSetting(
                        packageReplacedReceiver,
                        enabled ? PackageManager.COMPONENT_ENABLED_STATE_ENABLED : PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                        PackageManager.DONT_KILL_APP
                );
                pm.setComponentEnabledSetting(
                        userPresentReceiver,
                        enabled ? PackageManager.COMPONENT_ENABLED_STATE_ENABLED : PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                        PackageManager.DONT_KILL_APP
                );


                // Store the class name of your service or main activity for AppStarter
                final String preferenceKey = isService ? SERVICE_CLASS_NAME : ACTIVITY_CLASS_NAME;
                if (className != null) {
                    editor.putString(preferenceKey, className);
                } else {
                    Log.e("CapacitorAutoStart", "No classname provided for enabling the plugin, seems getActivity() not working...");
                    call.reject("No classname provided for enabling the plugin, seems getActivity() not working...");
                }
            } else {
                componentState = PackageManager.COMPONENT_ENABLED_STATE_DISABLED;
                editor.remove(ACTIVITY_CLASS_NAME);
                editor.remove(SERVICE_CLASS_NAME);
            }
            editor.commit();
            call.resolve();
        }
}
