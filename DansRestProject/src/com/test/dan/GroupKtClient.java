package com.test.dan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;

import org.json.JSONObject;

import com.sun.jersey.api.json.JSONJAXBContext.JSONNotation;

public class GroupKtClient {

	public static void main(String[] args) {
		//callForUsa();
		
		callForAll();
	}
	

	public static void callForUsa() {
		
		try {
			URL url = new URL("http://services.groupkt.com/country/get/iso2code/US");
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			

			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String str="";
			while ((str =in.readLine()) != null) {
				// str = in.readLine();
				System.out.println(" in.readline not null: "+ str);
				sb.append(str);
			}
			System.out.println("\n callForUsa REST Service Invoked Successfully..");
			in.close();
			
			JSONObject j = new JSONObject(sb.toString());
			System.out.println("\n json object: " + j.toString());
			parseJsonCallForUs(j);;
			
		} catch (Exception e) {
			System.out.println("\n Error while calling callForUsa REST Service");
			System.out.println(e);
			e.printStackTrace();
		}

		//br.close();
	
	}

	private static void parseJsonCallForUs(JSONObject j ) {
		
		System.out.println("parseJsonCallForUs entry");
		@SuppressWarnings("unchecked")
		Iterator<Object> itr = j.keys();
		while (itr.hasNext()) {
			Object o = itr.next();
			System.out.println("object " + o.toString());
		}
		
		JSONObject rr  = (JSONObject) j.get("RestResponse");
		System.out.println("rest reponse =" + rr.toString());
		
		JSONObject res = (JSONObject) rr.get("result");
		System.out.println("result =" + res.toString());
		
		Object nameo = res.get("name");
		System.out.println("nameo =" + nameo.getClass() + "::" + nameo.toString());
		
		String a2 = (String) res.get("alpha2_code");
		System.out.println("code =" + a2);
		
		String a3 = (String) res.get("alpha3_code");
		System.out.println("code =" + a3);
	}
	public static void callForAll() {
		
		try {
			URL url = new URL("http://services.groupkt.com/country/get/all");
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			//OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
			//out.write(jsonObject.toString());
			//out.close();

			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			StringBuffer sb = new StringBuffer();
			String str="";
			while ((str =in.readLine()) != null) {
				// str = in.readLine();
				System.out.println(" in.readline not null: "+ str);
				sb.append(str);
			}

			System.out.println("\n callForall REST Service Invoked Successfully..");
			in.close();
			
			JSONObject j = new JSONObject(sb.toString());
			System.out.println("\n json object: " + j.toString());
			parseJsonCallForAll(j);;
			
		} catch (Exception e) {
			System.out.println("\n Error while calling callForAll REST Service");
			System.out.println(e);
			e.printStackTrace();
		}

		//br.close();	
	}
	
	private static void parseJsonCallForAll(JSONObject j ) {
		
		System.out.println("parseJsonCallForUs entry");
		@SuppressWarnings("unchecked")
		Iterator<Object> itr = j.keys();
		while (itr.hasNext()) {
			Object o = itr.next();
			System.out.println("object " + o.toString());
		}
		
		JSONObject rr  = (JSONObject) j.get("RestResponse");
		System.out.println("rest reponse =" + rr.toString());
		
		JSONObject res = (JSONObject) rr.get("result");
		System.out.println("result =" + res.toString());
		
	
	}
}
