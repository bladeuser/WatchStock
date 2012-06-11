package com.teamziegenbock.android.apis;

import java.util.Calendar;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.teamziegenbock.android.apis.finance.ReadStocks;
import com.teamziegenbock.android.apis.helfer.DAX;
import com.teamziegenbock.android.apis.helfer.StockPropertie;

public class Portfolio_Actitivty extends ListActivity {
	ArrayAdapter<String> adapter;
	

@Override
public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

	// no more this
	// setContentView(R.layout.list_fruit);

	setListAdapter(new ArrayAdapter<String>(this, R.layout.portfolio,DAX.values));

	ListView listView = getListView();
	listView.setTextFilterEnabled(true);

	listView.setOnItemClickListener(new OnItemClickListener() {
		public void onItemClick(AdapterView<?> parent, View view,
				int position, long id) {
		    // When clicked, show a toast with the TextView text
		    Toast.makeText(getApplicationContext(),
			((TextView) view).getText(), Toast.LENGTH_SHORT).show();
		    
		    Calendar cal = Calendar.getInstance();
			ReadStocks r = new ReadStocks();
			StockPropertie propertie = new StockPropertie();
			
			String stock = ((TextView) view).getText().toString();
			propertie.setWkn(new DAX().getSymbol(stock));
			propertie.setStartDay(String.valueOf(cal.get(Calendar.DATE)));
			propertie.setStartMonth(String.valueOf(cal.get(Calendar.MONTH)));
			propertie.setStartYear(String.valueOf(cal.get(Calendar.YEAR)));
			propertie.setEndDay("1");
			propertie.setEndMonth("0");
			propertie.setEndYear("2000");
			propertie.setChartAbstufung("d");
			
			r.setProperties(propertie);
			if (r.readStock()==null){
				
			}		    
		}
	});

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
	
