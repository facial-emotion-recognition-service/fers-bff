package esense.bff.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import esense.bff.convert.ConvertImageFormatRequest;
import esense.bff.convert.ImageConvertApp;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1/convert")
public class ConvertController {

    private static Logger logger = LogManager.getLogger(ConvertController.class);

	private final ImageConvertApp imageConvertApp;

	public ConvertController(ImageConvertApp imageConvertApp) {
		this.imageConvertApp = imageConvertApp;
	}

	@PostMapping(value = "/file/format", produces = "application/json", consumes = "application/json")
	@Operation(summary = "Convert file into image")
	public ResponseEntity<?> convert(@RequestBody ConvertImageFormatRequest request) {
		logger.info("ConvertController.convert: uid = " + request);
		return imageConvertApp.convert(request.getUid());
	}

}