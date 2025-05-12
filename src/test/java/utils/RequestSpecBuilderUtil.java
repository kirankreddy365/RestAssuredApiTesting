package utils;

import static config.ConfigManager.*;

import config.ConfigManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecBuilderUtil {
	
	public static RequestSpecification getRequestSpecs() {
		
		ConfigManager.loadConfig(System.getProperty("env"));
		
		return new RequestSpecBuilder()
				.setBaseUri(get("baseURL"))
				.addHeader("Content-Type", "application/json")
				.addHeader("x-api-key", "reqres-free-v1")
				.build();
	}

}
