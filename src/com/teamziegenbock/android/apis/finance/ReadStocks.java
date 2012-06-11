package com.teamziegenbock.android.apis.finance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;
import java.util.StringTokenizer;

import com.teamziegenbock.android.apis.helfer.StockPropertie;

public class ReadStocks {

	// g= Chart-Abstufung (d=tägliche Werte, w=wöchentliche Werte, m=monatliche
	// Werte, v=Dividendenausschüttungen)
	public static final String[] CHART_ABSTUFUNG = { "d", "w", "m", "v" };
	private String[][] items;
	private BufferedReader reader = null;
	private String[][] history;
	private int row = 0;
	private String url = "";
	private StockPropertie propertie = null;

	public ReadStocks() {

	}

	public boolean checkReader() {
		return reader != null;
	}

	public String[][] getArray() {
		return items;
	}

	public String[][] getCSVFromURLToArray(String urlString) {
		if (urlString != null && urlString.length() > 0) {
			// http://ichart.finance.yahoo.com/table.csv?s=AAPL&d=3&e=3&f=2008&g=d&a=8&b=7&c=1984&ignore=.cvs

			String nextLine;
			URL url = null;
			URLConnection urlConn = null;
			InputStreamReader inStream = null;
			int r = 0;
			try {
				// Create the URL obect that points at the default file
				// index.html
				url = new URL(urlString);

				// Open Connection to read Number of lines
				urlConn = url.openConnection();
				inStream = new InputStreamReader(urlConn.getInputStream());
				reader = new BufferedReader(inStream);

				// Read Number of Lines to determine the Array
				items = new String[getRowNumber() - 1][7];

				// Open Connection to read values
				urlConn = url.openConnection();
				inStream = new InputStreamReader(urlConn.getInputStream());
				reader = new BufferedReader(inStream);

				boolean firstLine = false;
				while (true) {

					// Read next line of values
					nextLine = reader.readLine();
					if (firstLine) {
						if (nextLine != null) {
							StringTokenizer z = new StringTokenizer(nextLine,
									",");
							while (z.hasMoreTokens()) {
								// Loop through the 7 values Opening, Closing,
								// High, Low, Date...
								for (int c = 0; c < 7; c++) {
									// write the items in to Array
									items[r][c] = z.nextToken();
								}
								r++;
							}
						} else {
							break;
						}
					} else {
						firstLine = true;
					}
				}
			} catch (MalformedURLException e) {
				System.out.println("Please check the URL:" + e.toString());
			} catch (IOException e1) {
				System.out.println("Can't read  from the Internet: "
						+ e1.toString());
			}
		}
		return items;
	}

	public String[][] getHistory() {
		return history;
	}

	/*
	 * Liefert die Anzahl der Zeilen aus der *.csv Datei
	 * 
	 * @return int
	 */
	private int getRowNumber() {
		row = 0;
		if (checkReader()) {
			try {
				while ((reader.readLine() != null)) {
					row++;
				}
			} catch (Exception e) {
			}
		} else {
			System.out.println("This is not a file");
		}
		return row;
	}

	public String getUrl() {
		return url;
	}

	/*
	 * Systemausgabe des Arrays
	 */
	public void printArray() {
		for (int x = 0; x < items.length; x++) {
			System.out.printf("%s - ", x);
			for (int y = 0; y < items[x].length; y++) {
				System.out.printf("%s ", items[x][y]);
			}
			System.out.println();
		}
	}

	public void setHistory(String[][] history) {
		this.history = history;
	}

	/*
	 * Retrieve stocks and set them to variable history
	 */
	public Exception readStock() {
		if (this.propertie != null) {
			try {
				setHistory(getCSVFromURLToArray(getUrl()));
				return null;
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
		} else {
			return new Exception("Error: Es fehlen die Propertie Einstellungen!");
		}

	}

	/*
	 * Setzt das Start- und Enddatum, sowie die WKN Nr. des Aktienunternehmen.
	 */
	public void setProperties(StockPropertie propertie) {

		this.propertie = propertie;
		this.url = "http://ichart.finance.yahoo.com/table.csv?s="
				+ propertie.getWkn() + "&d=" + propertie.getStartMonth()
				+ "&e=" + propertie.getStartDay() + "&f="
				+ propertie.getStartYear() + "&g="
				+ propertie.getChartAbstufung() + "&a="
				+ propertie.getEndMonth() + "&b=" + propertie.getEndDay()
				+ "&c=" + propertie.getEndYear() + "&ignore=.cvs";

		// http://ichart.finance.yahoo.com/table.csv?s=AAPL&d=3&e=3&f=2008&g=d&a=8&b=7&c=1984&ignore=.cvs
	}

}
