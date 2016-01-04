package net.carroll.dan.messageservice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.json.JSONObject;

import net.carroll.data.Message;
import net.carroll.data.Messages;

public class MessageClient extends MessageServiceBase {

	public static void main(String[] args) {
		System.out.println("start ");
		
		testPostOneMessage();
		
		//testManyMessages();
		
		//testOneMessage();
	}
	
	public static void testManyMessages() {
		System.out.println(" testManyMessages() start ");
		try {
			URL url = new URL("http://localhost:8080/DansRestProject/services/messageservice");
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/xml");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			
			System.out.println("one ");
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String str="";
			while ((str =in.readLine()) != null) {
				// str = in.readLine();
				System.out.println(" in.readline not null: "+ str);
				sb.append(str);
			}
			System.out.println("\n messages REST Service Invoked Successfully..");
			System.out.println("\n sb.tostring=" + sb.toString());
			in.close();
			
			
			jaxbUnmarshallMessages(sb.toString());
			
		} catch (Exception e) {
			System.out.println("\n Error while calling messageservice (many messages) REST Service");
			System.out.println(e);
			e.printStackTrace();
		}
	}
	public static void testOneMessage() {
		System.out.println(" testOneMessage start ");
		try {
			URL url = new URL("http://localhost:8080/DansRestProject/services/messageservice/0");
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/xml");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			
			System.out.println("one ");
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String str="";
			while ((str =in.readLine()) != null) {
				// str = in.readLine();
				System.out.println(" in.readline not null: "+ str);
				sb.append(str);
			}
			System.out.println("\n messages REST Service Invoked Successfully..");
			System.out.println("\n sb.tostring=" + sb.toString());
			in.close();
			
			
			Message msg = jaxbUnmarshallMessage(sb.toString());
			
		} catch (Exception e) {
			System.out.println("\n Error while calling messageservice REST Service");
			System.out.println(e);
		}
	}
	
	public static void testPostOneMessage() {
		System.out.println(" testPostOneMessage start ");
		try {
			URL url = new URL("http://localhost:8080/DansRestProject/services/messageservice/postrecord");
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type", "application/xml");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
			
			//TODO danc now create a mesage object and then unmarshall it to xml for this call
			out.write(getXmlMessageString(new Message(100L, "mytext", new Date())) );
			out.close();
			
			System.out.println("one ");
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String str = "";
			while ((str =in.readLine()) != null) {
				// str = in.readLine();
				System.out.println(" in.readline not null: "+ str);
				sb.append(str);
			}
			System.out.println("\n messages REST Service Invoked Successfully..");
			System.out.println("\n sb.tostring=" + sb.toString());
			in.close();
			
			
			jaxbUnmarshallMessage(sb.toString());
			
		} catch (Exception e) {
			System.out.println("\n Error while calling messageservice REST Service");
			System.out.println(e);
		}
	}
	


	
	
	private static String getXmlMessageString() {
		
		StringBuffer sw= new StringBuffer(); 
		try {
			
			InputStream xmlStream = new FileInputStream("C:\\Users\\dcarroll\\Documents\\message.xml");
			InputStreamReader isReader = new InputStreamReader(xmlStream);
			BufferedReader br = new BufferedReader(isReader);
			String line;
			while ((line = br.readLine()) != null) {
				sw.append(line);
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

		
		System.out.println("() " + sw.toString());
		return sw.toString();
	}
	private static  Message  jaxbMarshallMessage() {
		Message m1=new Message(0L, "hello", new Date());
		
		try {
			System.out.println("entry jaxbUnmarshall ");
			
			
			String str ="<message><created>2015-12-29T20:24:30.875-07:00</created><id>3</id><text>dans</text></message>";
			File file = new File("C:\\Users\\dcarroll\\Documents\\message.xml");
			
			m1 =new Message(0L, "hello", new Date());
			
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Message.class);
			Marshaller marshaller = jaxbContext.createMarshaller();

		
			marshaller.marshal(m1, file);
			
			System.out.println(m1.toString());

			return m1;
		  } catch (JAXBException e) {
			e.printStackTrace();
		  }
		return m1;
	}

}
