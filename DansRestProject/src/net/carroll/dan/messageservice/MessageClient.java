package net.carroll.dan.messageservice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import net.carroll.data.Message;
import net.carroll.data.Messages;

public class MessageClient {

	public static void main(String[] args) {
		System.out.println("start ");
		
		
		testManyMessages();
	}
	
	public static void testManyMessages() {
		System.out.println("start ");
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
	public static void testOneMessage(String[] args) {
		System.out.println("start ");
		try {
			URL url = new URL("http://localhost:8080/DanDynamicWebProject/services/messageservice/0");
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
			
			
			jaxbUnmarshallMessage(sb.toString());
			
		} catch (Exception e) {
			System.out.println("\n Error while calling messageservice REST Service");
			System.out.println(e);
		}
	}
	
	private static void jaxbUnmarshallMessages(String xml) {
		try {
			System.out.println("\n\n entry jaxbUnmarshalls " + xml);
			
			
			//String str ="<message><created>2015-12-29T20:24:30.875-07:00</created><id>3</id><text>dans</text></message>";
						
			JAXBContext jaxbContext = JAXBContext.newInstance(Messages.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

			StringReader reader = new StringReader(xml);
			Messages msgs = (Messages) unmarshaller.unmarshal(reader);			
			
			System.out.println(msgs.toString());

		  } catch (JAXBException e) {
			e.printStackTrace();
		  }
	}
	
	private static void jaxbUnmarshallMessage(String xml) {
		try {
			System.out.println("entry jaxbUnmarshall ");
			
			
			String str ="<message><created>2015-12-29T20:24:30.875-07:00</created><id>3</id><text>dans</text></message>";
			
			Message m1 = new Message(1L, "message1", new Date());
			//File file = new File("C:\\file.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Message.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

			StringReader reader = new StringReader(xml);
			Message msg = (Message) unmarshaller.unmarshal(reader);			
			
			System.out.println(msg.toString());

		  } catch (JAXBException e) {
			e.printStackTrace();
		  }
	}

}
