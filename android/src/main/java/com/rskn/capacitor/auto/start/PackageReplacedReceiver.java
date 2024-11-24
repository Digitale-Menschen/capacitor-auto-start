package com.rskn.capacitor.auto.start;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class PackageReplacedReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("CapacitorAutoStart", "PackageReplaced received");
        AppStarter appStarter = new AppStarter();
        appStarter.run(context, intent, AppStarter.BYPASS_USERPRESENT_MODIFICATION );
    }
}
