package esense.bff.faces;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import esense.bff.file.model.ImageFacesResult;

import java.util.logging.Logger;


@Service
public class ImageFaceApp {
	
    private static final Logger logger = Logger.getLogger(ImageFaceApp.class.getName());

	private final ImageFaceApi imageFaceApi;

	public ImageFaceApp(ImageFaceApi imageFaceApi) {
		this.imageFaceApi = imageFaceApi;
	}

	public ResponseEntity<?> getFacesFromImage(String fileUid) {
		logger.info("ImageFaceApp.getFacesFromImage 1: fileUid = " + fileUid);
		ImageFacesResult response = imageFaceApi.getFacesFromImage(fileUid);
		logger.info("ImageFaceApp.getFacesFromImage 2: fileUid = " + fileUid);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}