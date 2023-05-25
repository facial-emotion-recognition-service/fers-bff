package esense.bff.predictor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import io.restassured.RestAssured;
import io.restassured.response.Response;

@Component
public class RestAssuredPredictorClientApi {

	//http://192.168.2.87:8000/emotions/image.png
	public void triggerImageProcessing(String url) {
		Response response = RestAssured.given().when().put(url).andReturn();
		Integer ok = HttpStatus.OK.value();// 
		Integer actual = response.getStatusCode();
		if (!ok.equals(actual)) {
			throw new RuntimeException("Fail triggerImageProcessing response: " + response.getStatusCode());
		}
	}

}
