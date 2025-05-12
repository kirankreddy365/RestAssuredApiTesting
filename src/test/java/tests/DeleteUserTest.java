package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import clients.UserClient;
import config.Setup;
import io.restassured.response.Response;

public class DeleteUserTest  {
	
	UserClient userClient=new UserClient();

	@Test(groups= {"smoke"})
	public void verifyDeleteUser() {
		Response response= userClient.deleteUser(2);
		
		Assert.assertEquals(response.statusCode(), 204);
	}
}
