package esense.bff.predictor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import esense.bff.file.model.ImagePredictorResult;

@Component
public class PredictorApi {

	// http://192.168.2.87:8000
	@Value("${url.base.predictor}")
	private String urlBaseForPredictor;

	private final RestAssuredPredictorClientApi clientApi;

	public PredictorApi(RestAssuredPredictorClientApi clientApi) {
		this.clientApi = clientApi;
	}

	public ImagePredictorResult processImage(String uid) {
		String url = buildCreatePredictorUrl(uid);
		clientApi.triggerImageProcessing(url);
		return new ImagePredictorResult(uid);
	}

	// http://192.168.2.87:8000/emotions/image.png
	private String buildCreatePredictorUrl(String uid) {
		StringBuilder sb = new StringBuilder();
		sb.append(urlBaseForPredictor);
		sb.append("/emotions/");
		sb.append(uid);
		String url = sb.toString();
		return url;
	}

}
