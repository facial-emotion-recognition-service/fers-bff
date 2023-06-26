package esense.bff.file.model;

import java.util.List;

public class ImageFacesResult {

	private String uid;
	private List<List<Integer>> coordinates;

	public ImageFacesResult(String uid, List<List<Integer>> coordinates) {
		this.uid = uid;
		this.coordinates = coordinates;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public List<List<Integer>> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<List<Integer>> coordinates) {
		this.coordinates = coordinates;
	}

}
