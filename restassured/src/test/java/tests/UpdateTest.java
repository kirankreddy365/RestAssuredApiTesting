package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import clients.UserClient;
import io.restassured.response.Response;
import models.UserRequest;
import models.UserResponse;

public class UpdateTest {
	
	UserClient userClient=new UserClient();
	
	@Test
	public void verifyUpdatePut() {
		UserRequest userRequest=new UserRequest("kkreddy", "put update");
		Response response=userClient.putSingleUser(2, userRequest);
		
		Assert.assertEquals(response.statusCode(), 201, "failed status code for put request.");
		
		UserResponse userResponse=response.as(UserResponse.class);
		
		System.out.println(userResponse);
	}
	
	@Test
	public void verifyUpdatePatch() {
		UserRequest userRequest=new UserRequest("kkr", "patch update");
		Response response=userClient.putSingleUser(2, userRequest);
		
		Assert.assertEquals(response.statusCode(), 200, "failed status code for put request.");
		
		UserResponse userResponse=response.as(UserResponse.class);
		
		System.out.println(userResponse);
	}

}
