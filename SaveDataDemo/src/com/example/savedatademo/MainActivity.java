package com.example.savedatademo;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
	
	static final int DAY_VIEW_MODE = 0;
    static final int WEEK_VIEW_MODE = 1;
	private static final String TAG = "MainActivity";
    
    private SharedPreferences mPrefs;
    private int mCurViewMode;

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        SharedPreferences mPrefs = getSharedPreferences("userdetails", MODE_PRIVATE);
        mCurViewMode = mPrefs.getInt("view_mode", DAY_VIEW_MODE);
        Log.d(TAG, "onCreate->mCurViewMode :: " + mCurViewMode);
    }
    
    protected void onPause() {
    	Log.d(TAG, "onPause");    	
        super.onPause();

        SharedPreferences mPrefs = getSharedPreferences("userdetails", MODE_PRIVATE);
        SharedPreferences.Editor ed = mPrefs.edit();
        ed.putInt("view_mode", WEEK_VIEW_MODE);
        ed.commit();
        Log.d(TAG, "onPause->mCurViewMode :: " + mCurViewMode);
    }
    
}
