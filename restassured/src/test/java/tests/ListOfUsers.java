package tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import clients.UserClient;
import io.restassured.response.Response;
import models.Data;
import models.ListUsersResponse;

public class ListOfUsers {

	UserClient userClient = new UserClient();

	@Test
	public void verifyGetAllUsers() {
		Response response = userClient.getListOfUsers(1);

		Assert.assertEquals(response.statusCode(), 200);
		
		ListUsersResponse listUsersResponse=response.as(ListUsersResponse.class);
		List<Data> listOfusers=listUsersResponse.getData();
		
		System.out.println("Data size "+listOfusers.size());

		Assert.assertEquals(listUsersResponse.getPage(), 1);
		
		for (Data data : listOfusers) {
			System.out.println(data);
		}
	}
}
