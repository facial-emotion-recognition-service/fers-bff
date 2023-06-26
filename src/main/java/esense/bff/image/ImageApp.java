package esense.bff.image;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import esense.bff.faces.Rectangle;
import esense.bff.file.model.UploadFileResult;

@Service
public class ImageApp {

	private final ImageService imageService;

	public ImageApp(ImageService imageService) {
		this.imageService = imageService;
	}

	public ResponseEntity<?> createNewImage(String inUid, RectangleRequest request) {
		try {
			Rectangle rectangle = new Rectangle(request.getX(), request.getY(), request.getW(), request.getH());
			UploadFileResult result = imageService.createNewImage(inUid, rectangle);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}