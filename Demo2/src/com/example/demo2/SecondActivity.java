package com.example.demo2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);        
        
        TextView textView = (TextView)findViewById(R.id.textView1);        
        Intent intent = getIntent();        
        textView.setText(intent.getStringExtra("msg"));
        
        Button backButton = (Button)findViewById(R.id.button1);
        backButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				finish();				
			}
		});        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
