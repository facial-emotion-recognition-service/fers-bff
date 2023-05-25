package esense.bff.predictor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import esense.bff.app.http.HttpResponseFactory;
import esense.bff.file.model.ImagePredictorResult;

@Service
public class PredictorApp {

	private final PredictorApi predictorApi;

	private final HttpResponseFactory httpResponseFactory;

	public PredictorApp(PredictorApi predictorApi, HttpResponseFactory httpResponseFactory) {
		this.predictorApi = predictorApi;
		this.httpResponseFactory = httpResponseFactory;
	}

	public ResponseEntity<?> processImage(String fileUid) {
			ImagePredictorResult response = predictorApi.processImage(fileUid);;
			return httpResponseFactory.buildSuccess(response);
	}

}