package com.hulk.store;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
public class HulksapiApplicationTests 
{
	public static final String CONTENT_TYPE = "application/json";
	public static final String BASE_URI = "http://localhost";
	public static final int PORT = 8080;	
	
}
