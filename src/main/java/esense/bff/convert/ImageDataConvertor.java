package esense.bff.convert;

import java.io.InputStream;

import org.springframework.stereotype.Component;

import esense.bff.file.model.DownloadFileResult;
import esense.bff.file.model.content.InputStreamContentSupplier;

@Component
public class ImageDataConvertor {

	private StreamImageConvertor imageConvertor;

	public ImageDataConvertor(StreamImageConvertor imageConvertor) {
		this.imageConvertor = imageConvertor;
	}

	public InputStreamContentSupplier convert(DownloadFileResult download) {
		InputStream before = download.getBody();
		InputStream after = imageConvertor.convert(before);
		return new InputStreamContentSupplier(after);
	}

}
