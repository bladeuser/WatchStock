package com.teamziegenbock.android.apis;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class Info_Actitivty extends Activity {
	ArrayAdapter<String> adapter;
	

@Override
public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.info);

	// no more this
	// setContentView(R.layout.list_fruit);
	//
}
		
		
		
		
//		Calendar cal = Calendar.getInstance();
//
//		try {
//			ReadFiles r = new ReadFiles();
//
//			r.setProperties(DAX.ADIDAS, String.valueOf(cal.get(Calendar.DATE)),
//					String.valueOf(cal.get(Calendar.MONTH)),
//					String.valueOf(cal.get(Calendar.YEAR)), "1", "0", "2000",
//					"d");
//			r.setHistory(r.getCSVFromURLToArray(r.getUrl()));
//			r.printArray();
//			
//			ImageButton next = (ImageButton) findViewById(R.id.imageButton1);
//			ListView lView = (ListView) findViewById(R.id.listView1);
//			
//			String[] values = new String[]{"Adidas", "Deutsche Bank"};
//			adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
//			
//			lView.setAdapter(adapter);
//			adapter.add("weiteres element");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		Button next = (Button) findViewById(R.id.button1);
//		next.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				adapter.add("und noch ein weiteres element");
//			}
//		});
		
		
}
	
