package com.JKM.climbingroutes;

import com.JKM.climbingroutes.DrawView;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//setContentView(new DrawView(this));
		//DrawView.drawCircle()
		//DrawView.drawTriangle(canvas, 200, 300, (float)0.5, paint);
		Button artificialButton = (Button)findViewById(R.id.artificialButton);
		
		artificialButton.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent transfer2gym = new Intent();
				transfer2gym.setClass(MainActivity.this ,GymListActivity.class);
				startActivity(transfer2gym);
				//MainActivity.this.finish();
			}
			
		});
		
		
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
