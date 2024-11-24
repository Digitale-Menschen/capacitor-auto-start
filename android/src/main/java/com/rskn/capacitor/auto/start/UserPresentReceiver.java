package com.rskn.capacitor.auto.start;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;

public class UserPresentReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("CapacitorAutoStart", "UserPresent received");
        AppStarter appStarter = new AppStarter();
        appStarter.run(context, intent, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, true);
    }
}
