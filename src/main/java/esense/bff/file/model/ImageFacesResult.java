package esense.bff.file.model;

import java.util.List;

import esense.bff.faces.Rectangle;

public class ImageFacesResult {

	private String uid;
	private List<Rectangle> coordinates;

	public ImageFacesResult(String uid, List<Rectangle> coordinates) {
		this.uid = uid;
		this.coordinates = coordinates;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public List<Rectangle> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<Rectangle> coordinates) {
		this.coordinates = coordinates;
	}

}
