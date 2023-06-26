package esense.bff.faces;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import esense.bff.file.model.ImageFacesResult;

@Service
public class ImageFaceApp {

	private final ImageFaceApi imageFaceApi;

	public ImageFaceApp(ImageFaceApi imageFaceApi) {
		this.imageFaceApi = imageFaceApi;
	}

	public ResponseEntity<?> getFacesFromImage(String fileUid) {
		ImageFacesResult response = imageFaceApi.getFacesFromImage(fileUid);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}