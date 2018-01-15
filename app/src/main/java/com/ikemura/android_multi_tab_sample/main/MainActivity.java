package com.ikemura.android_multi_tab_sample.main;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ikemura.android_multi_tab_sample.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private final String PONTA_PACKAGE = "jp.ponta.myponta";
    private final String PONTA_START_ACTIVITY = "jp.ponta.myponta.MainActivity";
    private final String DPOINT_PACKAGE = "com.dcm_gate.premierclub";
    private final String DPOINT_START_ACTIVITY = "com.nttdocomo.android.dpoint.MainActivity";

    /**
     * ポンタ
     *
     * @param view
     */
    public void pontaClick(View view) {
//        startIntentToPonta();
        startPackage(PONTA_PACKAGE);
    }

    private void startIntentToPonta() {
        startIntentToPonta();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setAction("android.intent.category.LAUNCHER");
        intent.setClassName("jp.ponta.myponta", "jp.ponta.myponta.MainActivity");
        startActivity(intent);
    }

    /**
     * dポイント
     *
     * @param view
     */
    public void dPointClick(View view) {
//        startIntentToDPoint();
        startPackage(DPOINT_PACKAGE);
    }

    private void startIntentToDPoint() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setAction("android.intent.category.LAUNCHER");
        intent.setClassName("com.dcm_gate.premierclub", "com.dcm_gate.premierclub.MainActivity");
        startActivity(intent);
    }

    /**
     * パッケージで起動
     *
     * @param pkg
     */
    private void startPackage(String pkg) {
        String packageName = pkg;

        PackageManager pm = getApplicationContext().getPackageManager();
        Intent intent = pm.getLaunchIntentForPackage(packageName);
        if (intent == null) {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=" + packageName));
        }
        startActivity(intent);
    }
}
