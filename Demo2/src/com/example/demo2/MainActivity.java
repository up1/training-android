package com.example.demo2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    protected static final String TAG = "MainActivity";
    
    EditText msgText;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        msgText = (EditText)findViewById(R.id.editText1);
        
        Button button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Log.d(TAG, "onClick");
				nextPage();
			}
		});
        
    }

    protected void nextPage() {
		Intent intent = new Intent(this, SecondActivity.class);
		intent.putExtra("msg", msgText.getText().toString());
		startActivity(intent);
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
