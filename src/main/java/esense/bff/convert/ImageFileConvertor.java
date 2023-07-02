package esense.bff.convert;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import esense.bff.file.FileService;
import esense.bff.file.model.DownloadFileResult;
import esense.bff.file.model.UploadFileResult;
import esense.bff.file.model.content.InputStreamContentSupplier;

@Service
public class ImageFileConvertor {
	
    private static Logger logger = LogManager.getLogger(ImageFileConvertor.class);

	private FileService fileService;
	private ImageDataConvertor imageConvertor;

	public UploadFileResult convert(String inUid) throws IOException {
		logger.info("ImageFileConvertor.convert 1: inUid = " + inUid);
		DownloadFileResult download = fileService.readFile(inUid);
		logger.info("ImageFileConvertor.convert 2: download.name = " + download.getName());
		InputStreamContentSupplier content = imageConvertor.convert(download);
		logger.info("ImageFileConvertor.convert 3: inUid = " + inUid);
		return fileService.writeFile(download.getName(), content); // TODO
	}

}
