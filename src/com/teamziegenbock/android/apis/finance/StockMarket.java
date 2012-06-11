package com.teamziegenbock.android.apis.finance;



import java.util.Calendar;

import com.teamziegenbock.android.apis.helfer.DAX;
import com.teamziegenbock.android.apis.helfer.StockPropertie;

public class StockMarket {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();

		try {
			ReadStocks r = new ReadStocks();
			StockPropertie propertie = new StockPropertie();
			
			propertie.setWkn("DAX.ADIDAS");
			propertie.setStartDay(String.valueOf(cal.get(Calendar.DATE)));
			propertie.setStartMonth(String.valueOf(cal.get(Calendar.MONTH)));
			propertie.setStartYear(String.valueOf(cal.get(Calendar.YEAR)));
			propertie.setEndDay("1");
			propertie.setEndMonth("0");
			propertie.setEndYear("2000");
			propertie.setChartAbstufung("d");
			
			r.setProperties(propertie);
			r.readStock();
			String[][] history = r.getHistory();
			r.printArray();

			// LineChartDemo demo = new LineChartDemo("igors test",
			// r.getHistory());
			// demo.showWindow();
			//
			// Formulas f = new Formulas();
			// f.createDataArray(r.getHistory());
			// f.createDateArray(r.getHistory());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
