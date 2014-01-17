package com.JKM.climbingroutes;


import android.app.ListActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.view.View;

public class GymListActivity extends ListActivity{
	private SimpleAdapter adapter; 
	private ListView listView;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview);
		
		listView = (ListView)findViewById(android.R.id.list);
		
		
		adapter = new SimpleAdapter(this, 
									GymConfig.getData(),
									R.layout.listviewcontent,
									new String[] {"img", "area", "gymName"}, 
									new int[] {	R.id.img, R.id.area, R.id.gymName});
		
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub
				ListView listView = (ListView) arg0;
				Toast.makeText(	GymListActivity.this,
						"ID：" + arg3 + "   選單文字："+ listView.getItemAtPosition(arg2).toString(),
						Toast.LENGTH_LONG).show();
			}
		});
	}
	
	
	
}
