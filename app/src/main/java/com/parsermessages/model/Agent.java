package com.parsermessages.model;

import android.content.pm.PackageManager;

import com.parsermessages.view.StartMainActivity;


public class Agent {
    private static int sortNumber = 0;
    private static StartMainActivity startMainActivity;
    private static PackageManager packageManager;


    public static int getSortNumber() {
        return sortNumber;
    }

    public static void setSortNumber(int sortNumber) {
        Agent.sortNumber = sortNumber;
    }

    public static StartMainActivity getStartMainActivity() {
        return startMainActivity;
    }

    public static void setStartMainActivity(StartMainActivity startMainActivity) {
        Agent.startMainActivity = startMainActivity;
    }

    public static PackageManager getPackageManager() {
        return packageManager;
    }

    public static void setPackageManager(PackageManager packageManager) {
        Agent.packageManager = packageManager;
    }
}
