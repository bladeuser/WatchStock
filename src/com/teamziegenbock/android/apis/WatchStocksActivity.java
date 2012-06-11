package com.teamziegenbock.android.apis;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class WatchStocksActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ImageView portfolio = (ImageView) findViewById(R.id.imageViewPortfolio);
		portfolio.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent myIntent = new Intent(v.getContext(),
						Portfolio_Actitivty.class);
				v.getContext().startActivity(myIntent);
			}
		});

		ImageView search = (ImageView) findViewById(R.id.imageViewSuche);
		search.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// Toast.makeText(getApplicationContext(),"igor",
				// Toast.LENGTH_SHORT).show();
				Intent myIntentSearch = new Intent(v.getContext(),
						Search_Actitivty.class);
				v.getContext().startActivity(myIntentSearch);

			}
		});
		
		ImageView info = (ImageView) findViewById(R.id.imageViewInfo);
		info.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// Toast.makeText(getApplicationContext(),"igor",
				// Toast.LENGTH_SHORT).show();
				Intent myIntentInfo = new Intent(v.getContext(),
						Info_Actitivty.class);
				v.getContext().startActivity(myIntentInfo);

			}
		});
	}
}