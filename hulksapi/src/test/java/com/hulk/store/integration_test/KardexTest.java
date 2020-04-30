package com.hulk.store.integration_test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hulk.store.HulksapiApplicationTests;
import com.hulk.store.entity.Darkex;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

@SpringBootTest
public class KardexTest {

	private static final String BASE_PATH = "/darkex/";

	@BeforeEach
	void setUp() throws Exception {
		RestAssured.baseURI = HulksapiApplicationTests.BASE_URI;
		RestAssured.port = HulksapiApplicationTests.PORT;
	}

	@Test
	public void ShouldGetAllKardexSuccess() {
		ExtractableResponse<Response> response = given().contentType(HulksapiApplicationTests.CONTENT_TYPE)
				.accept(HulksapiApplicationTests.CONTENT_TYPE).body("").when().get(BASE_PATH).then().extract();

		assertThat(response.statusCode()).isEqualTo(200);
	}

	@Test
	public void ShouldCreateKardex() throws JsonMappingException, JsonProcessingException {
		
		Map<String, Object> newKardex = new HashMap<>();
		newKardex.put("productName", "Libro");
		newKardex.put("proveedores", "Editorial Castellana");

		ExtractableResponse<Response> response = given().contentType(HulksapiApplicationTests.CONTENT_TYPE)
				.accept(HulksapiApplicationTests.CONTENT_TYPE).body(newKardex).when().put(BASE_PATH).then().extract();

		assertThat(response.asString()).isNotBlank();
		Darkex kardexCreated = new ObjectMapper().readValue(response.asString(), Darkex.class);
		assertThat(kardexCreated.getId()).isNotNegative();
		assertThat(kardexCreated.getId()).isNotNull();
		assertThat(response.statusCode()).isEqualTo(200);
	}

	@Test
	public void ShouldNotCreateKardex_WhenEmpty() throws JsonMappingException, JsonProcessingException {
		
		Map<String, Object> newKardex = new HashMap<>();
		newKardex.put("productName", "Libro");

		ExtractableResponse<Response> response = given().contentType(HulksapiApplicationTests.CONTENT_TYPE)
				.accept(HulksapiApplicationTests.CONTENT_TYPE).body(newKardex).when().put(BASE_PATH).then().extract();

		System.out.println("Result: " + response.asString());

		assertThat(response.statusCode()).isEqualTo(422);

	}

	@Test
	public void ShouldFailedDeleteKardex() {
		
		ExtractableResponse<Response> response = given().contentType(HulksapiApplicationTests.CONTENT_TYPE)
				.accept(HulksapiApplicationTests.CONTENT_TYPE).when().delete(BASE_PATH).then().extract();

		assertThat(response.statusCode()).isEqualTo(405);
	}

	@Test
	public void ShouldFailedDeleteKardexWithIncorrectParam() {
		
		String kardexId = "test";

		ExtractableResponse<Response> response = given().contentType(HulksapiApplicationTests.CONTENT_TYPE)
				.accept(HulksapiApplicationTests.CONTENT_TYPE).when().delete(BASE_PATH + kardexId).then().extract();

		assertThat(response.statusCode()).isEqualTo(400);
	}

	@Test
	public void ShouldDeleteKardex() {
		
		int kardesId = 1;

		ExtractableResponse<Response> response = given().contentType(HulksapiApplicationTests.CONTENT_TYPE)
				.accept(HulksapiApplicationTests.CONTENT_TYPE).when().delete(BASE_PATH + kardesId).then().extract();

		assertThat(response.statusCode()).isEqualTo(200);
	}
}