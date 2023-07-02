package esense.bff.convert;

// Maybe later add source and target formats
public class ConvertImageFormatRequest {

	private String uid;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "ConvertRequest [uid=" + uid + "]";
	}

}
