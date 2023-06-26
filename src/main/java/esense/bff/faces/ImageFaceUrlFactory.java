package esense.bff.faces;

public class ImageFaceUrlFactory {

	// http://192.168.2.91:8001/faces/multi_faces.jpg
	public static String buildUrl(String baseurl, String uid) {
		StringBuilder sb = new StringBuilder();
		sb.append(baseurl);
		sb.append("/faces/");
		sb.append(uid);
		String url = sb.toString();
		return url;
	}

}
