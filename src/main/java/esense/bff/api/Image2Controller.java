package esense.bff.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import esense.bff.image.ImageApp;
import esense.bff.image.RectangleRequest;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1/image2")
public class Image2Controller {

	private final ImageApp imageApp;

	public Image2Controller(ImageApp imageApp) {
		this.imageApp = imageApp;
	}

	@PostMapping(value = "/{uid}/cut", produces = "application/json", consumes = "application/json")
	@Operation(summary = "Create a new image from an existing image by cutting a rectangle from it")
	public ResponseEntity<?> createSubImage(
			@PathVariable String uid,
			@RequestBody RectangleRequest rectangle) {
		return imageApp.createNewImage(uid, rectangle);
	}

}