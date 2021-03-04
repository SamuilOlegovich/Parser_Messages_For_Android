package com.parsermessages.model;

import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.content.pm.ApplicationInfo;

import com.fastloan.R;
import com.parsermessages.view.StartMainActivity;

import java.util.ArrayList;
import java.util.List;



public class LoadApplications extends AsyncTask<Void, Void, Void> {
    private List<ApplicationInfo> applist = null;
    private StartMainActivity startMainActivity;
    private ProgressDialog progress = null;
    private PackageManager packageManager;
    private AppAdapter listadapter = null;


    public LoadApplications() {
        this.packageManager = Agent.getPackageManager();
        this.startMainActivity = Agent.getStartMainActivity();
    }


    private List<ApplicationInfo> checkForLaunchIntent(List<ApplicationInfo> list) {
        ArrayList<ApplicationInfo> appList = new ArrayList<>();

        for (ApplicationInfo info : list) {
            try{
                if(packageManager.getLaunchIntentForPackage(info.packageName) != null) {
                    appList.add(info);
                }
            } catch(Exception e) { e.printStackTrace(); }
        }
        return appList;
    }


    @Override
    protected Void doInBackground(Void... params) {
        applist = checkForLaunchIntent(packageManager.getInstalledApplications(PackageManager.GET_META_DATA));
        listadapter = new AppAdapter(startMainActivity, R.layout.list_item, applist);
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        startMainActivity.setListAdapter(listadapter);
        progress.dismiss();
        super.onPostExecute(result);
    }

    @Override
    protected void onPreExecute() {
        progress = ProgressDialog.show(startMainActivity, null, "Loading apps info...");
        super.onPreExecute();
    }
}
