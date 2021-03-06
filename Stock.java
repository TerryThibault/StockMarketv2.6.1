package badidea;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Stock {
	public String name; // The abbreviated, stock exchange name. (e.g. GOOG)
	public double price_current;

	public Stock(String name) throws Exception {
		this.name = name;
		price_current = Get_Price(name);
	}
	
	// This function only works with the depreciated Google Finance API, which can 
	// be found here: http://finance.google.com/finance/info?client=ig&q=NASDAQ:GOOG
	public double Get_Price(String name) throws Exception { 
		URL stock = new URL("http://finance.google.com/finance/info?client=ig&q=NASDAQ:" + name);
		URLConnection conn = stock.openConnection();
		BufferedReader in = new BufferedReader(
					new InputStreamReader(
					conn.getInputStream()));
		String inputLine;
                Scanner scanner;
		while ((inputLine = in.readLine()) != null) {
			if (inputLine.length() < 5)
				continue;
			if (inputLine.substring(0, 5).equals(",\"l_c")) {
                                System.out.println(inputLine);
                                return Double.parseDouble(inputLine.split(":")[1].replace("\"", "").trim());
				//return Double.parseDouble(inputLine.substring(12, 18)); // This only works on 5 digit stock prices
											// Can be made better by using 'split' func
                        }
		}

		in.close();
		return 100; // An error has occurred.
	}
}
