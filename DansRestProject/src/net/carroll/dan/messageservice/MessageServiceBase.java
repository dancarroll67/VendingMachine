package net.carroll.dan.messageservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import net.carroll.data.Message;
import net.carroll.data.Messages;

public abstract class MessageServiceBase {
	public static void main(String[] args) {
		System.out.println("start ");
		
		String str = getXmlMessageString(new Message(100L, "mytext", new Date()));
		System.out.println("str");
	}
	
	public static String getXmlMessageString(Message msg) {
		//TODO danc start here and convert msg (dont read from file)
		StringWriter sw = new StringWriter();
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Message.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
					
			marshaller.marshal(msg, sw);
			String xmlString = sw.toString();
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}

		
		System.out.println("() " + sw.toString());
		return sw.toString();
	}
	public static Message jaxbUnmarshallMessage(String xml) {
		Message msg = new Message();
		try {
			System.out.println("entry jaxbUnmarshall ");
			
			
			String str ="<message><created>2015-12-29T20:24:30.875-07:00</created><id>3</id><text>dans</text></message>";
			
			Message m1 = new Message(1L, "message1", new Date());
			//File file = new File("C:\\file.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Message.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

			StringReader reader = new StringReader(xml);
			msg = (Message) unmarshaller.unmarshal(reader);			
			
			System.out.println(msg.toString());

		  } catch (JAXBException e) {
			e.printStackTrace();
		  }
		return msg;
	}
	public static void jaxbUnmarshallMessages(String xml) {
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
	
}
