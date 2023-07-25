package esense.bff.faces;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import esense.bff.faces.mapper.CoordinatesMapper;
import esense.bff.file.model.ImageFacesResult;
import jakarta.annotation.PostConstruct;

@Component
public class ImageFaceApi {

	private static final Logger logger = Logger.getLogger(ImageFaceApi.class.getName());

	@Value("${url.base.image.face}")
	private String urlBaseForImageFace;

	private final RestAssuredImageFaceClientApi clientApi;
	private final CoordinatesMapper mapper;

	public ImageFaceApi(RestAssuredImageFaceClientApi clientApi) {
		this.clientApi = clientApi;
		this.mapper = new CoordinatesMapper();
		logger.info("ImageFaceApi.constructor urlBaseForImageFace = " + urlBaseForImageFace);
	}

	@PostConstruct
	private void postConstruct() {
		logger.info("ImageFaceApi.postConstruct urlBaseForImageFace = " + urlBaseForImageFace);

	}

	public ImageFacesResult getFacesFromImage(String uid) {
		logger.info("ImageFaceApi.getFacesFromImage 1: uid = " + uid);
		String url = ImageFaceUrlFactory.buildUrl(urlBaseForImageFace, uid);
		logger.info("ImageFaceApi.getFacesFromImage 2: uid = " + uid + ", url = " + url);
		String text = clientApi.getFacesFromImage(url);
		logger.info("ImageFaceApi.getFacesFromImage 3: uid = " + uid + ", text = " + text);
		List<Rectangle> coordinates = mapper.toCoordinatesList(text);
		logger.info("ImageFaceApi.getFacesFromImage 4: uid = " + uid + ", coordinates = " + coordinates);
		return new ImageFacesResult(uid, coordinates);
	}

}
