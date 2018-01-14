package com.rest.example;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rest.pojo.Cars;

@Path("/hello")
public class HelloWorldService {

	@GET
	@Path("/get/{param}")
	@Produces("image/png")
	public BufferedImage getImage(@PathParam("param") String msg) throws IOException {


		return ImageIO.read(new File("C:/pictures/images/image.png"));

	}
	
	@GET
	@Path("/{oper}/{dgt1}/{dgt2}")
	public Response printMessage(@PathParam("oper") String operation, @PathParam("dgt1") Long digit1, @PathParam("dgt2") Long digit2){
		
		Long result=0L;
		if("add".equalsIgnoreCase(operation)){
			result = digit1+digit2;
		}else if("substract".equalsIgnoreCase(operation)){
			result = digit1-digit2;
		}else if("multiply".equalsIgnoreCase(operation)){
			result = digit1*digit2;
		}else if("divide".equalsIgnoreCase(operation)){
			result = digit1/digit2;
		}
		String output = "Result of your operation is ::::"+result;
		return Response.status(200).entity(output).build();
	}
	
	
	@GET
	@Path("/getCarInfo")
	@Produces(MediaType.APPLICATION_JSON)
	public String getTrackInJSON() {

		Cars car = new Cars();
		car.setModel("Volkswagen");
		car.setName("Beetle");
		car.setPrice(34000L);

		return car.toString();

	}
	
	@POST
	@Path("/postCars")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postMethod(Cars cars){
		
		String result = "Track saved : " + cars;
		return Response.status(201).entity(result).build();
		
	}

}