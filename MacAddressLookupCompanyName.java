package com.demo.rest.macaddress;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MacAddressLookupCompanyName {
	final static String defaultApiEndPoint = "https://api.macaddress.io/v1";
	final static Pattern pattern = Pattern.compile("companyName\":\"(.*?)\",\"companyAddress");

	public static void main(String[] args) throws IOException {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your macAddress: ");
		String macAddress = scanner.nextLine();
		 
		System.out.print("Enter your apiKey: ");
		String apiKey = scanner.nextLine();

		String companyName = "";   		
		try {
			URL url = new URL(defaultApiEndPoint + "?output=json&search=" + macAddress);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("GET");

			conn.setRequestProperty("X-Authentication-Token", apiKey); 
			conn.setRequestProperty("Content-Type", "application/json");

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String apiOutput = br.readLine();
			System.out.println(apiOutput);

			Matcher matcher = pattern.matcher(apiOutput);
			while (matcher.find()) {
				companyName = matcher.group(1);
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} finally {
			System.out.println("companyName = " + companyName); 
			//conn.disconnect();
		}
	}
}