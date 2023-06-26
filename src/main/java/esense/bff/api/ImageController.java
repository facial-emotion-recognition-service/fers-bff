package esense.bff.api;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import esense.bff.faces.ImageFaceApp;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1/image")
public class ImageController {

	private final ImageFaceApp imageFaceApp;

	public ImageController(ImageFaceApp imageFaceApp) {
		this.imageFaceApp = imageFaceApp;
	}

	@GetMapping("/{uid}/faces")
	@Operation(summary = "Get all faces locations inside image as rectangle coordinates")
	public ResponseEntity<?> getFacesFromImage(@PathVariable String uid) throws IOException {
		return imageFaceApp.getFacesFromImage(uid);

	}

}