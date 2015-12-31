package com.test.dan;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
public class JsonTest {

	public static void main(String[] args) {
		JsonTest jt = new JsonTest();
		jt.testJson2();

	}
	
	public void testJson2(){
		
		JSONObject obj =  getJsonObject();
		obj.put("age", new Integer(100));
		
		System.out.println("json object:" + obj.toString());
		
		@SuppressWarnings("unchecked")
		Set<Object> keys = obj.keySet();
		log("keys: " +keys.size());
		
		Iterator<Object> ki= keys.iterator();
		while (ki.hasNext()) {
			log("keys next: " +ki.next().toString());
		}
		
		System.out.println("get key age:" + obj.get("age"));
	}
	
	public void testJson(){
		
		JSONObject obj =  new JSONObject();
		obj.put("name", "mkyong.com");
		obj.put("age", new Integer(100));

		JSONArray list = new JSONArray();
	//	list.add("msg 1");
	
		obj.put("messages", list);

		System.out.println("json object:" + obj.toString());
		
		System.out.println("get key:" + obj.get("name"));
	}
	
	private JSONObject getJsonObject() {
		// Step1: Let's 1st read file from fileSystem
		// Change CrunchifyJSON.txt path here
		System.out.println("json test getJson");
		String string = "";
		try {
			InputStream crunchifyInputStream = new FileInputStream("C:\\Users\\dcarroll\\Documents\\CrunchifyJSON.txt");
			InputStreamReader crunchifyReader = new InputStreamReader(crunchifyInputStream);
			BufferedReader br = new BufferedReader(crunchifyReader);
			String line;
			while ((line = br.readLine()) != null) {
				string += line + "\n";
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}

		JSONObject jsonObject = new JSONObject(string);
		System.out.println("client json object: " + jsonObject.toString());
		return jsonObject;
	}

	private void log(String s) {
		System.out.println(s);
	}
	private void log(int s) {
		System.out.println(s);
	}
}
