package com.rskn.capacitor.auto.start;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;

public class BootCompletedReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("CapacitorAutoStart", "BOOT Complete received");
        AppStarter appStarter = new AppStarter();
        appStarter.run(context, intent, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, true);
    }
}
