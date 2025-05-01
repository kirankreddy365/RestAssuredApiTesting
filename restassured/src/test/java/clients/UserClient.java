package clients;

import io.restassured.response.Response;
import models.UserRequest;
import utils.RequestSpecBuilderUtil;
import static io.restassured.RestAssured.given;

public class UserClient {

	public Response getSingleUser(int userId) {

		return given()
				.spec(RequestSpecBuilderUtil.getRequestSpecs())
				.pathParam("id", userId)
				.when()
				.get("/users/{id}");
	}

	public Response createUser(UserRequest userRequest) {
		return given()
				.spec(RequestSpecBuilderUtil.getRequestSpecs())
				.body(userRequest)
				.when()
				.post("/users");
	}

	public Response getListOfUsers(int pageNo) {

		return given()
				.spec(RequestSpecBuilderUtil.getRequestSpecs())
				.queryParam("page", pageNo)
				.when()
				.get("/users");
	}

	public Response putSingleUser(int userId, UserRequest userRequest) {

		return given()
				.spec(RequestSpecBuilderUtil.getRequestSpecs())
				.pathParam("id", userId)
				.body(userRequest)
				.when()
				.put("/users/{id}");
	}

	public Response patchSingleUser(int userId, UserRequest userRequest) {

		return given()
				.spec(RequestSpecBuilderUtil.getRequestSpecs())
				.pathParam("id", userId)
				.body(userRequest)
				.when()
				.patch("/users/{id}");
	}
	
	public Response deleteUser(int userId) {
		return given()
				.spec(RequestSpecBuilderUtil.getRequestSpecs())
				.pathParam("id", userId)
				.when()
				.delete("/users/{id}");
	}

}
