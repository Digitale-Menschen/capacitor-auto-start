package com.rskn.capacitor.auto.start;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;

public class AppStarter {
    public static final int BYPASS_USERPRESENT_MODIFICATION = -1;
    private static final String CAPACITOR_AUTOSTART = "capacitor_autostart";

    public void run(Context context, Intent intent, int componentState) {
        this.run(context, intent, componentState, false);
    }

    public void run(Context context, Intent intent, int componentState, boolean onAutostart) {
        if (componentState != BYPASS_USERPRESENT_MODIFICATION) {
            ComponentName receiver = new ComponentName(context, UserPresentReceiver.class);
            PackageManager pm = context.getPackageManager();
            pm.setComponentEnabledSetting(receiver, componentState, PackageManager.DONT_KILL_APP);
        }

        // Starting your app...
        SharedPreferences sp = context.getSharedPreferences(CapacitorAutoStart.PREFS, Context.MODE_PRIVATE);
        String packageName = context.getPackageName();
        String activityClassName = sp.getString(CapacitorAutoStart.ACTIVITY_CLASS_NAME, "");
        if (!activityClassName.isEmpty()) {
            Intent activityIntent = new Intent();
            activityIntent.setClassName(
                    context, String.format("%s.%s", packageName, activityClassName));
            activityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            if (onAutostart) {
                activityIntent.putExtra(CAPACITOR_AUTOSTART, true);
            }
            context.startActivity(activityIntent);
        }

        String serviceClassName = sp.getString(CapacitorAutoStart.SERVICE_CLASS_NAME, "");
        if (!serviceClassName.isEmpty()) {
            String servicePackageName = serviceClassName.substring(0, serviceClassName.lastIndexOf("."));
            Intent serviceIntent = new Intent(context, getLauncherActivityClass(context));
            serviceIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            serviceIntent.setClassName(servicePackageName, serviceClassName);
            if (onAutostart) {
                serviceIntent.putExtra(CAPACITOR_AUTOSTART, true);
            }
            context.startActivity(serviceIntent);
        }
    }

    private Class<?> getLauncherActivityClass(Context context) {
        try {
            PackageManager pm = context.getPackageManager();
            Intent intent = pm.getLaunchIntentForPackage(context.getPackageName());
            if (intent != null && intent.getComponent() != null) {
                String className = intent.getComponent().getClassName();
                return Class.forName(className); // Load and return the Class object
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null; // Return null if the class cannot be found
    }
}
