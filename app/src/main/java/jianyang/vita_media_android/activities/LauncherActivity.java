package jianyang.vita_media_android.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import jianyang.vita_media_android.R;

public class LauncherActivity extends Activity {
    private static int LAUNCHER_TIME = 2000;
    private Runnable starter = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(LauncherActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        new Handler().postDelayed(starter, LAUNCHER_TIME);
    }
}
