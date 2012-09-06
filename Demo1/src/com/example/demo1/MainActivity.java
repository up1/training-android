package com.example.demo1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";
    
    TextView textView;    
    int count =0;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        textView = (TextView)findViewById(R.id.textView1);
        Button button = (Button)findViewById(R.id.button1);
        
        if( savedInstanceState != null ) {
        	count = savedInstanceState.getInt("count");
        	textView.setText("Count : " + count);
        }
        
        
        button.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Log.d(TAG, "Count from OnClickListener");
				count=count+1;
				textView.setText("Count : " + count);
			}
		});
        
        
        
    }
	
	
    
    @Override
	protected void onSaveInstanceState(Bundle outState) {
		outState.putInt("count", count);
		super.onSaveInstanceState(outState);
	}



	public void countMe( View view ) {
    	Log.d(TAG, "countMe");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
