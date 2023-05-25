package esense.bff.api;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import esense.bff.predictor.PredictorApp;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1/predictor")
public class PredictorController {

	private final PredictorApp predictorApp;

	public PredictorController(PredictorApp predictorApp) {
		this.predictorApp = predictorApp;
	}

	@GetMapping("/image/process/{uid}")
	@Operation(summary = "Process an image usign its uid and generate json report for it")
	public ResponseEntity<?> download(@PathVariable String uid) throws IOException {
		return predictorApp.processImage(uid);

	}

}