package esense.bff.convert;

// Maybe later add source and target formats
public class ConvertImageFormatRequest {

	private String sourecFileUid;
	private String sourceImageFormat;
	private String targetImageFormat;

	public String getSourecFileUid() {
		return sourecFileUid;
	}

	public void setSourecFileUid(String sourecFileUid) {
		this.sourecFileUid = sourecFileUid;
	}

	public String getSourceImageFormat() {
		return sourceImageFormat;
	}

	public void setSourceImageFormat(String sourceImageFormat) {
		this.sourceImageFormat = sourceImageFormat;
	}

	public String getTargetImageFormat() {
		return targetImageFormat;
	}

	public void setTargetImageFormat(String targetImageFormat) {
		this.targetImageFormat = targetImageFormat;
	}

	@Override
	public String toString() {
		return "ConvertImageFormatRequest [sourecFileUid=" + sourecFileUid 
				+ ", sourceImageFormat=" + sourceImageFormat
				+ ", targetImageFormat=" + targetImageFormat + "]";
	}


}
