package tests;

import java.util.List;
import java.util.stream.Collectors;

import org.testng.Assert;
import org.testng.annotations.Test;

import clients.UserClient;
import config.Setup;
import io.restassured.response.Response;
import models.Data;
import models.ListUsersResponse;

public class ListOfUsers {

	UserClient userClient = new UserClient();

	@Test(groups= {"smoke", "retest"})
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
	
	@Test
	public void verifyGetUsersFilteredJsonPath() {
		Response response = userClient.getListOfUsers(2);

		Assert.assertEquals(response.statusCode(), 200);
		
		//ListUsersResponse listUsersResponse=response.jsonPath().getList("data", Data.class);
		List<Data> listOfusers=response.jsonPath().getList("data", Data.class);
		
		System.out.println("Data size "+listOfusers.size());
		
		for (Data data : listOfusers) {
			System.out.println(data);
		}
		
		List<Data> listOfusersFiltered=listOfusers.stream()
				.filter(u->u.getId()>9)
				.collect(Collectors.toList());
		
		System.out.println("Data size "+listOfusersFiltered.size());
		
		for (Data data : listOfusersFiltered) {
			System.out.println(data);
		}
	}
}
