package com.example.android.explicitintent;

/**
 * Created by Ro on 10/05/2017.
 */

import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.Window;
        import android.view.WindowManager;

public class SplashProgress_Activity extends Activity {

    private static String TAG = SplashProgress_Activity.class.getName();
    private static long SLEEP_TIME = 5;    // Sleep for some time

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);    // Removes title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,     WindowManager.LayoutParams.FLAG_FULLSCREEN);    // Removes notification bar

        setContentView(R.layout.splash);

        // Start timer and launch main activity
        IntentLauncher launcher = new IntentLauncher();
        launcher.start();
    }

    private class IntentLauncher extends Thread {
        @Override
        /**
         * Sleep for some time and than start new activity.
         */
        public void run() {
            try {
                // Sleeping
                Thread.sleep(SLEEP_TIME*1000);
            } catch (Exception e) {
                Log.e(TAG, e.getMessage());
            }

            // Start main activity
            Intent intent = new Intent(SplashProgress_Activity.this, MainActivity.class);
            SplashProgress_Activity.this.startActivity(intent);
            SplashProgress_Activity.this.finish();
        }
    }
}