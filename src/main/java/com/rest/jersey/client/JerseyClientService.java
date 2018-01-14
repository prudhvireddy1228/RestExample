package com.rest.jersey.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClientService {

	public static void main(String[] args) {

		try {
			Client client = Client.create();

			WebResource webResource = client
					.resource("http://localhost:8080/RestExample/rest/hello/getCarInfo");

			ClientResponse response = webResource.accept("text/plain").get(
					ClientResponse.class);
			
			String output = response.getEntity(String.class);
			
			System.out.println("output from GET method ::: \n"+output);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
