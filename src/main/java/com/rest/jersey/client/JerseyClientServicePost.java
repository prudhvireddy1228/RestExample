package com.rest.jersey.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClientServicePost {

	public static void main(String[] args) {

		Client client = Client.create();

		WebResource webResource = client
				.resource("http://localhost:8080/RestExample/rest/hello/getCarInfo");
		
		String input = "{\"name\":\"Beetle\",\"model\":\"Volkswagen\",\"price\":\"34000\"}";
		
		ClientResponse response =  webResource.type("application/json").post(ClientResponse.class, input);
		
		System.out.println("Output from Server .... \n");
		String output = response.getEntity(String.class);
		System.out.println(output);
	}

}
