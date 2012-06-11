package com.teamziegenbock.android.apis;

import android.app.ListActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.teamziegenbock.android.apis.helfer.DAX;

public class Search_Actitivty extends ListActivity{
	ListView listView;
	ArrayAdapter<String> adapter;
	EditText et;
	
	
	public void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		// no more this
//		// setContentView(R.layout.list_fruit);
//
//		setContentView(R.layout.search);
////		setListAdapter(new ArrayAdapter<String>(this, R.layout.search,
////				DAX.values2));
//
//		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//				android.R.layout.simple_list_item_1, android.R.id.text1, DAX.values2);
//		
//		EditText et = (EditText) findViewById(R.id.etSearch);		
//		
//		
//		listView = (ListView) findViewById(R.id.list);
//		
//		listView.setOnItemClickListener(new OnItemClickListener() {
//			public void onItemClick(AdapterView<?> parent, View view,
//					int position, long id) {
//				// When clicked, show a toast with the TextView text
//				Toast.makeText(getApplicationContext(),"listeneintrag", Toast.LENGTH_SHORT).show();
//
//				listView.setAdapter(getListAdapter());
//			}
//		});
		
		super.onCreate(savedInstanceState);

        // Use a custom layout file
        setContentView(R.layout.search);
        
        // Tell the list view which view to display when the list is empty
        getListView().setEmptyView(findViewById(R.id.empty));
        
        // Set up our adapter
        
        adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, DAX.values2);
        setListAdapter(adapter);
        
        // Wire up the clear button to remove all photos
        TextView.OnEditorActionListener exampleListener = new TextView.OnEditorActionListener() {
			
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				if (actionId == EditorInfo.IME_NULL && event.getAction() == KeyEvent.ACTION_DOWN){
					example_confirm();
				}
				return true;
			}
		};
        et = (EditText) findViewById(R.id.etSearch);
        et.setOnEditorActionListener(exampleListener);
        et.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {	
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				
			}
		});

	}


	protected void example_confirm() {
		Toast.makeText(getApplicationContext(),et.getText(), Toast.LENGTH_SHORT).show();
	}


	protected void clear() {
		// TODO Auto-generated method stub
		
	}

	// Calendar cal = Calendar.getInstance();
	//
	// try {
	// ReadFiles r = new ReadFiles();
	//
	// r.setProperties(DAX.ADIDAS, String.valueOf(cal.get(Calendar.DATE)),
	// String.valueOf(cal.get(Calendar.MONTH)),
	// String.valueOf(cal.get(Calendar.YEAR)), "1", "0", "2000",
	// "d");
	// r.setHistory(r.getCSVFromURLToArray(r.getUrl()));
	// r.printArray();
	//
	// ImageButton next = (ImageButton) findViewById(R.id.imageButton1);
	// ListView lView = (ListView) findViewById(R.id.listView1);
	//
	// String[] values = new String[]{"Adidas", "Deutsche Bank"};
	// adapter = new ArrayAdapter<String>(this,
	// android.R.layout.simple_list_item_1, values);
	//
	// lView.setAdapter(adapter);
	// adapter.add("weiteres element");
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// Button next = (Button) findViewById(R.id.button1);
	// next.setOnClickListener(new OnClickListener() {
	//
	// @Override
	// public void onClick(View v) {
	// adapter.add("und noch ein weiteres element");
	// }
	// });

}
