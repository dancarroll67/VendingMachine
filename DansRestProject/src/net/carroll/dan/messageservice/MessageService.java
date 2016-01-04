package net.carroll.dan.messageservice;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import net.carroll.data.Message;
import net.carroll.data.MessageAccessor;

@Path("/messageservice")
public class MessageService extends MessageServiceBase {

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
		
		@POST
		@Path("/postrecord")
		@Consumes(MediaType.APPLICATION_XML)
		public Response messageServicePostXml(InputStream incomingData) {
			System.out.println(" messageServicePostXml rest POST entry");
			StringBuilder strBuilder = new StringBuilder();
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
				String line = null;
				while ((line = in.readLine()) != null) {
					strBuilder.append(line);
					System.out.println("line = " + line);
					//parseJsonObject(line);
				}
			} catch (Exception e) {
				System.out.println("Error Parsing: - ");
			}
		
			Message m1 = jaxbUnmarshallMessage(strBuilder.toString());
			System.out.println(" messageServicePostXml unmarshall message object = " + m1.toString());
			
			// return HTTP response 200 in case of success
			return Response.status(200).entity(strBuilder.toString()).build();
		}

}
