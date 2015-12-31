package com.crunchify.restjersey;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;


@Path("/")
public class DansHelloWorld {


		@GET
		@Path("/danshelloworld")
		@Produces("application/xml")
		public String sayHelloWorld() { 
	 
			System.out.println("danc here in say hello world: " );
			Double fahrenheit;
			Double celsius = 36.8;
			fahrenheit = ((celsius * 9) / 5) + 32;
	 
			String result = "@Produces(\"application/xml\") Output: \n\nHello World newestpath!: \n\n";
			return "<danshelloworld>" +  "<ctofoutput>" 
					+ result + "</ctofoutput>" + "</danshelloworld>";
		}
		
		@POST
		@Path("/helloworldpost")
		@Consumes(MediaType.APPLICATION_JSON)
		public Response crunchifyREST(InputStream incomingData) {
			StringBuilder crunchifyBuilder = new StringBuilder();
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
				String line = null;
				while ((line = in.readLine()) != null) {
					crunchifyBuilder.append(line);
					System.out.println("line = " + line);
					parseJsonObject(line);
				}
			} catch (Exception e) {
				System.out.println("Error Parsing: - ");
			}
			System.out.println("Data Received: " + crunchifyBuilder.toString());
	 
			// return HTTP response 200 in case of success
			return Response.status(200).entity(crunchifyBuilder.toString()).build();
		}
		
		private void parseJsonObject(String str) {
			JSONObject j = new JSONObject(str);
			System.out.println("json object " + j.keySet().size());
			System.out.println("json object getkeyset: " +j.keySet().toString());
		//	System.out.println("json object getkey:" + j.getNames(jo)("tutorials"));
			
			//			while (j.keys().hasNext()) {
//				Object o = j.keys().next();
//				System.out.println("json key:: " + o.getClass() + "::" + o.toString());
//			}
		}
}
