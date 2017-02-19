import java.net.*;
import java.io.*;

public class terry {
	public static void Get_Price(String url) throws Exception {
		URL stock = new URL("http://finance.google.com/finance/info?client=ig&q=NASDAQ:" + url);
		URLConnection conn = stock.openConnection();
		BufferedReader in = new BufferedReader(
					new InputStreamReader(
					conn.getInputStream()));
		String inputLine;

		while ((inputLine = in.readLine()) != null)
			System.out.println(inputLine);
		in.close();
	}

	public static void main(String[] args) throws Exception {
	Get_Price("GOOG");
	}
}
