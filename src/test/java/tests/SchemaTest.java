package tests;

import org.testng.annotations.Test;

import clients.UserClient;
import io.restassured.module.jsv.JsonSchemaValidator;

public class SchemaTest {
	
	@Test
	public void verityAllUsersSchema() {
		
		UserClient userClient=new UserClient();
		
		userClient.getListOfUsers(2).then().assertThat()
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("JSONSchemas/ListUserSchema.json"));
	}

}
