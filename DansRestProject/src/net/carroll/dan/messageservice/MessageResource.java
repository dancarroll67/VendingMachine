package net.carroll.dan.messageservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.carroll.data.Message;

@Path("/messages")
public class MessageResource {

	MessageService ms = new MessageService();
	
//	@GET
//	@Produces(MediaType.APPLICATION_XML)
//	public List<Message> getMessages() {
//		return ms.getAllMessages();
//	}

}
