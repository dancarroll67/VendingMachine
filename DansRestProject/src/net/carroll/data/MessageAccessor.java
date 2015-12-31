package net.carroll.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageAccessor {
	
	private static List<Message> list = loadAll();
	
	public List<Message> getAll() {
		
		return MessageAccessor.list;
	}
	public Message getMessage(Long l) {
		
		return MessageAccessor.list.get(l.intValue());
	}
	
	private static List<Message> loadAll() {
		
		Message m1=new Message(0L, "hello", new Date());
		Message m2=new Message(1L, "world", new Date());
		List<Message> list = new ArrayList<Message>();
		list.add(m1);
		list.add(m2);
		return list;
	}
	
	
	

}
