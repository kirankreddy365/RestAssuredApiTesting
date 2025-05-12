package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import clients.UserClient;
import config.Setup;
import io.restassured.response.Response;
import models.SingleUserResponse;
import models.UserRequest;
import models.UserResponse;

public class UserTests {
	
	UserClient userClient=new UserClient();
	
	@Test(groups= {"smoke", "retest"})
	public void verifygetUser() {
		
		Response response=userClient.getSingleUser(2);

		//ExtentTestListener.assertEqual(response.statusCode(), 200, "Status code ");
		Assert.assertEquals(response.statusCode(), 200, "Status code failed.");

		SingleUserResponse singleUser=response.as(SingleUserResponse.class);
		System.out.println(singleUser.getData().getFirst_name());
		System.out.println(singleUser.getData().getLast_name());
		System.out.println(singleUser.getSupport().getUrl());
		System.out.println(singleUser.getSupport().getText());
		
	}
	
	@Test
	public void verifyUserNotFound() {
		
		Response response=userClient.getSingleUser(23);

		Assert.assertEquals(response.statusCode(), 404, "Status code failed.");

	}
	
	@Test(groups= {"smoke"})
	public void verifyCreateUser() {
		 
		UserRequest userRequest=new UserRequest("QATest1", "QATitle1");
		
		Response response=userClient.createUser(userRequest);
		
		Assert.assertEquals(response.statusCode(), 201, "Status code failed.");
		
		UserResponse userReponse=response.as(UserResponse.class);
		
		Assert.assertEquals(userReponse.getName(), "QATest1", "name mismatch.");
		Assert.assertEquals(userReponse.getJob(), "QATitle1", "job mismatch.");
		
		
		
	}

}
