package com.hulk.store;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
class HulksapiApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testLista() {
		get("/registers").then().body("modelo[0]", equalTo("Yoga"));		
	}
}
