package com.hulk.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class RegisterTest {
	
	//private final String CONTEXT_PATH="/";
	
	@BeforeEach
	void setUp() throws Exception{
		RestAssured.baseURI ="http://localhost";
		RestAssured.port = 8080;
	}
	
	@Test
	public void listRegister()
	{
				
		try {			
		
			Response response = given().
			contentType("application/json").
			accept("application/json").			
			when().			
			get("/registers/").
			then().
			statusCode(200).
			contentType("application/json").
			extract().
			response();
			
			String result = response.jsonPath().prettyPrint();
			
		}catch(Exception e)
		{
			System.out.println("Error: "+e.toString());
		}
	}
	
	@Test
	public void createRegister()
	{
		Map<String, Object> newRegister = new HashMap<>();
		newRegister.put("description", "Esto es una descripcion de prueba");
		newRegister.put("unitVal", 15000);
		newRegister.put("cantidad", 10);
		newRegister.put("operation", 1);
		
		int darkexId = 1;
		
		try {			
		
			Response response = given().
			contentType("application/json").
			accept("application/json").
			body(newRegister).
			when().
			put("/registers/"+darkexId).			
			then().
			statusCode(200).
			contentType("application/json").
			extract().
			response();
			
			String result = response.jsonPath().prettyPrint();
			//System.out.println("Hecho: "+result);
		}catch(Exception e)
		{
			System.out.println("Error: "+e.toString());
		}
		
		
		
	}
}
