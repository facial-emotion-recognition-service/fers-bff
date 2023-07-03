package esense.bff.convert;

import java.io.InputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import esense.bff.file.model.DownloadFileResult;
import esense.bff.file.model.content.InputStreamContentSupplier;

@Component
public class ImageDataConvertor {

    private static Logger logger = LogManager.getLogger(ImageFileConvertor.class);

	private StreamImageConvertor imageConvertor;

	public ImageDataConvertor(StreamImageConvertor imageConvertor) {
		this.imageConvertor = imageConvertor;
	}

	public InputStreamContentSupplier convert(DownloadFileResult download, String target) {
		InputStream before = download.getBody();
		logger.info("ImageDataConvertor.convert 1: download.name = " + download.getName());
		InputStream after = imageConvertor.convert(before, target);
		logger.info("ImageDataConvertor.convert 2: download.name = " + download.getName());
		return new InputStreamContentSupplier(after);
	}

}
