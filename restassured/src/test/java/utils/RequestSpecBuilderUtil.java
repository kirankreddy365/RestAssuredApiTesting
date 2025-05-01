package utils;

import static config.ConfigManager.*;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecBuilderUtil {
	
	public static RequestSpecification getRequestSpecs() {
		
		return new RequestSpecBuilder()
				.setBaseUri(get("base.url"))
				.addHeader("Content-Type", "application/json")
				.addHeader("x-api-key", "reqres-free-v1")
				.build();
	}

}
