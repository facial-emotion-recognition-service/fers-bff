package esense.bff.faces;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import esense.bff.faces.mapper.CoordinatesMapper;
import esense.bff.file.model.ImageFacesResult;

@Component
public class ImageFaceApi {

	@Value("${url.base.image.face}")
	private String urlBaseForImageFace;

	private final RestAssuredImageFaceClientApi clientApi;
	private final CoordinatesMapper mapper;

	public ImageFaceApi(RestAssuredImageFaceClientApi clientApi) {
		this.clientApi = clientApi;
		this.mapper = new CoordinatesMapper();
	}

	public ImageFacesResult getFacesFromImage(String uid) {
		String url = ImageFaceUrlFactory.buildUrl(urlBaseForImageFace, uid);
		String text = clientApi.getFacesFromImage(url);
		List<Rectangle> coordinates = mapper.toCoordinatesList(text);
		return new ImageFacesResult(uid, coordinates);
	}

}
