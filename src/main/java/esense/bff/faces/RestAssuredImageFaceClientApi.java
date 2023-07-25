package esense.bff.faces;

import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import io.restassured.RestAssured;
import io.restassured.response.Response;

@Component
public class RestAssuredImageFaceClientApi {
	
	private static final Logger logger = Logger.getLogger(RestAssuredImageFaceClientApi.class.getName());

	public String getFacesFromImage(String url) {
		logger.info("RestAssuredImageFaceClientApi.getFacesFromImage 1: url =" + url);
		Response response = RestAssured.given().when().put(url).andReturn();
		Integer ok = HttpStatus.OK.value();
		Integer actual = response.getStatusCode();
		logger.info("RestAssuredImageFaceClientApi/getFacesFromImage 2: actual =" + actual);
		if (!ok.equals(actual)) {
			logger.info("RestAssuredImageFaceClientApi/getFacesFromImage 2.2: error");
			String message = "Fail to get faces from image with response: ";
			throw new RuntimeException(message + response.getStatusCode());
		}
		logger.info("RestAssuredImageFaceClientApi/getFacesFromImage 3: actual =" + actual);
		return response.getBody().asString();
	}

}
