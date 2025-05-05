package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import clients.UserClient;
import io.restassured.response.Response;

public class DeleteUserTest {
	
	UserClient userClient=new UserClient();

	@Test
	public void verifyDeleteUser() {
		Response response= userClient.deleteUser(2);
		
		Assert.assertEquals(response.statusCode(), 204);
	}
}
