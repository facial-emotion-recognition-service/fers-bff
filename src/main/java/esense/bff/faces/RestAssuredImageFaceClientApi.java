package esense.bff.faces;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import io.restassured.RestAssured;
import io.restassured.response.Response;

@Component
public class RestAssuredImageFaceClientApi {

	public String getFacesFromImage(String url) {
		Response response = RestAssured.given().when().put(url).andReturn();
		Integer ok = HttpStatus.OK.value();// 
		Integer actual = response.getStatusCode();
		if (!ok.equals(actual)) {
			String message = "Fail to get faces from image with response: ";
			throw new RuntimeException(message + response.getStatusCode());
		}
		return response.getBody().asString();
	}

}
