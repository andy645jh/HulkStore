package com.hulk.store;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hulk.store.entity.Darkex;
import com.hulk.store.entity.Register;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

@SpringBootTest
public class RegisterTest {

	private static final String BASE_PATH = "/registers/";	
	public enum Operation {
		COMPRA(1), VENTA(2), DEVOLUCION_COMPRA(3), DEVOLUCION_VENTA(4);
	 
	    public final int intValue;
	 
	    private Operation(int label) {
	        this.intValue = label;
	    }
	}
	
	private static long kardexId = 1;
	private static boolean setUpIsDone = false;
	
	@BeforeEach
	void setUp() throws Exception {
		
		if (setUpIsDone) {
	        return;
	    }
	    // do the setup
	    setUpIsDone = true;
	    
		RestAssured.baseURI = HulksapiApplicationTests.BASE_URI;
		RestAssured.port = HulksapiApplicationTests.PORT;
		
		System.out.println("setUp");	
		CreateKardex();
	}
	
	
	private void CreateKardex() throws JsonMappingException, JsonProcessingException
	{
		Map<String, Object> newKardex = new HashMap<>();
		newKardex.put("productName", "Libro");
		newKardex.put("proveedores", "Editorial Castellana");

		ExtractableResponse<Response> responseD = given().contentType(HulksapiApplicationTests.CONTENT_TYPE)
				.accept(HulksapiApplicationTests.CONTENT_TYPE).body(newKardex).when().put("/darkex/").then().extract();
		
		System.out.println("CreateKardex D: "+responseD.asString());	
		Darkex kardexCreated = new ObjectMapper().readValue(responseD.asString(), Darkex.class);
		kardexId = kardexCreated.getId();
	}

	@Test
	public void ShouldCreateRegister() throws JsonMappingException, JsonProcessingException
	{
		System.out.println("Operation: "+ Operation.COMPRA.intValue);
		
		Map<String, Object> newRegister = new HashMap<>();
		newRegister.put("description", "Esto es una descripcion de prueba");
		newRegister.put("unitVal", 15000);
		newRegister.put("cantEntrada", 10);
		newRegister.put("cantSalida", 0);
		newRegister.put("operation", Operation.COMPRA.intValue);
		newRegister.put("date", new Date());


		ExtractableResponse<Response> response = given().contentType(HulksapiApplicationTests.CONTENT_TYPE)
				.accept(HulksapiApplicationTests.CONTENT_TYPE).body(newRegister).when().put(BASE_PATH + kardexId).
				then().extract();
		
		System.out.println("Result: "+response.asString());		
		assertThat(response.statusCode()).isEqualTo(200);
		assertThat(response.asString()).isNotBlank();
		
		Register regCreated = new ObjectMapper().readValue(response.asString(), Register.class);
		assertThat(regCreated.getId()).isNotNegative();
		assertThat(regCreated.getId()).isNotNull();		
	}
	
	@Test
	public void ShouldNotCreateRegister_WhenNotDate() throws JsonMappingException, JsonProcessingException
	{
		Map<String, Object> newRegister = new HashMap<>();
		newRegister.put("description", "Esto es una descripcion de prueba");
		newRegister.put("unitVal", 18000);
		newRegister.put("cantidad", 3);
		newRegister.put("operation", Operation.VENTA.intValue);		


		ExtractableResponse<Response> response = given().contentType(HulksapiApplicationTests.CONTENT_TYPE)
				.accept(HulksapiApplicationTests.CONTENT_TYPE).body(newRegister).when().put(BASE_PATH + kardexId).
				then().extract();
		
		System.out.println("Result: "+response.asString());		
		assertThat(response.statusCode()).isEqualTo(422);		
		
	}
	
	@Test
	public void ShouldNotCreateRegister_WhenCantidadNegative() throws JsonMappingException, JsonProcessingException
	{
		Map<String, Object> newRegister = new HashMap<>();
		newRegister.put("description", "Esto es una descripcion de prueba");
		newRegister.put("unitVal", 18000);
		newRegister.put("cantidad", -3);
		newRegister.put("operation", Operation.VENTA.intValue);		
		newRegister.put("date", new Date());
		

		ExtractableResponse<Response> response = given().contentType(HulksapiApplicationTests.CONTENT_TYPE)
				.accept(HulksapiApplicationTests.CONTENT_TYPE).body(newRegister).when().put(BASE_PATH + kardexId).
				then().extract();
		
		System.out.println("Result: "+response.asString());		
		assertThat(response.statusCode()).isEqualTo(422);	
		
	}
	
	@Test
	public void ShouldNotCreateRegister_WhenCantidadZero() throws JsonMappingException, JsonProcessingException
	{	
		
		Map<String, Object> newRegister = new HashMap<>();
		newRegister.put("description", "Esto es una descripcion de prueba");
		newRegister.put("unitVal", 18000);
		newRegister.put("cantidad", 0);
		newRegister.put("operation", Operation.VENTA.intValue);	
		newRegister.put("date", new Date());

		ExtractableResponse<Response> response = given().contentType(HulksapiApplicationTests.CONTENT_TYPE)
				.accept(HulksapiApplicationTests.CONTENT_TYPE).body(newRegister).when().put(BASE_PATH + kardexId).
				then().extract();
		
		System.out.println("Result: "+response.asString());		
		assertThat(response.statusCode()).isEqualTo(422);		
	}
	
	@Test
	public void ShouldNotCreateRegister_WhenUnitValEmpty() throws JsonMappingException, JsonProcessingException
	{
		Map<String, Object> newRegister = new HashMap<>();
		newRegister.put("description", "Esto es una descripcion de prueba");		
		newRegister.put("cantidad", 10);
		newRegister.put("operation", Operation.VENTA.intValue);		
		newRegister.put("date", new Date());


		ExtractableResponse<Response> response = given().contentType(HulksapiApplicationTests.CONTENT_TYPE)
				.accept(HulksapiApplicationTests.CONTENT_TYPE).body(newRegister).when().put(BASE_PATH + kardexId).
				then().extract();
		
		System.out.println("Result: "+response.asString());		
		assertThat(response.statusCode()).isEqualTo(422);	
		
	}
	
	@Test
	public void ShouldNotCreateRegister_WhenKardexIdIncorrect() throws JsonMappingException, JsonProcessingException
	{
		Map<String, Object> newRegister = new HashMap<>();
		newRegister.put("description", "Esto es una descripcion de prueba");		
		newRegister.put("cantidad", 10);
		newRegister.put("unitVal", 18000);
		newRegister.put("operation", Operation.DEVOLUCION_VENTA.intValue);		
		newRegister.put("date", new Date());
		
		String darkexId = "1rt";

		ExtractableResponse<Response> response = given().contentType(HulksapiApplicationTests.CONTENT_TYPE)
				.accept(HulksapiApplicationTests.CONTENT_TYPE).body(newRegister).when().put(BASE_PATH + darkexId).
				then().extract();
		
		System.out.println("Result: "+response.asString());		
		assertThat(response.statusCode()).isEqualTo(400);			
	}
	
	@Test
	public void ShouldNotCreateRegister_WhenOperationNotCorrect() throws JsonMappingException, JsonProcessingException
	{
		Map<String, Object> newRegister = new HashMap<>();
		newRegister.put("description", "Esto es una descripcion de prueba");
		newRegister.put("unitVal", 18000);
		newRegister.put("cantidad", 3);
		newRegister.put("operation", 10);		
		newRegister.put("date", new Date());
		
	
		ExtractableResponse<Response> response = given().contentType(HulksapiApplicationTests.CONTENT_TYPE)
				.accept(HulksapiApplicationTests.CONTENT_TYPE).body(newRegister).when().put(BASE_PATH + kardexId).
				then().extract();
		
		System.out.println("Result: "+response.asString());		
		assertThat(response.statusCode()).isEqualTo(422);	
		
	}
	
	@Test
	public void ShouldNotCreateRegister_WhenRegisterEmpty() throws JsonMappingException, JsonProcessingException
	{
		Map<String, Object> newRegister = new HashMap<>();
			
		ExtractableResponse<Response> response = given().contentType(HulksapiApplicationTests.CONTENT_TYPE)
				.accept(HulksapiApplicationTests.CONTENT_TYPE).body(newRegister).when().put(BASE_PATH + kardexId).
				then().extract();
		
		System.out.println("Result: "+response.asString());		
		assertThat(response.statusCode()).isEqualTo(422);	
		
	}
	
}
