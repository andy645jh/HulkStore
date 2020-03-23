package com.hulk.store;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;

@SpringBootTest
public class KardexTest {
	
	//private final String CONTEXT_PATH="/";
	
	@BeforeEach
	void setUp() throws Exception{
		RestAssured.baseURI ="http://localhost";
		RestAssured.port = 8080;
	}
	
	@Test
	public void listKardex()
	{
		
		Response response = given().
		contentType("application/json").
		accept("application/json").
		body("").
		when().
		get("/darkex/").
		then().
		statusCode(200).
		contentType("application/json").
		extract().
		response();
		
		String result = response.jsonPath().toString();		
		System.out.print("Response: " + result);
	}
	
	@Test
	public void createKardex()
	{
		//crea kardex sin registro		
		Map<String, Object> newKardex = new HashMap<>();
		newKardex.put("productName", "Libro");
		newKardex.put("proveedores", "Editorial Castellana");
		
		Response response = given().
		contentType("application/json").
		accept("application/json").
		body(newKardex).
		when().
		put("/darkex/").
		then().
		statusCode(200).
		contentType("application/json").
		extract().
		response();
		
		String result = response.jsonPath().toString();		
		
	}
}