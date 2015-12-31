package net.carroll.dan.messageservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.carroll.data.Message;
import net.carroll.data.MessageAccessor;

@Path("/messageservice")
public class MessageService {

		@GET
		@Produces(MediaType.APPLICATION_XML)
		public List<Message> getAllMessages() {
			
			MessageAccessor	ma = new MessageAccessor();
			return ma.getAll();
			
		}

		@Path("{id}")
		@GET
		@Produces(MediaType.APPLICATION_XML)
		public Message getMessage(@PathParam("id") Long id) {
			
			MessageAccessor	ma = new MessageAccessor();
			return ma.getMessage(id);
			 
		}

}
