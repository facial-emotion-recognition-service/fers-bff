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

	public ImageFileConvertor(FileService fileService, ImageDataConvertor imageConvertor) {
		this.fileService = fileService;
		this.imageConvertor = imageConvertor;
	}

	public UploadFileResult convert(ConvertImageFormatRequest request) throws IOException {
		String inUid = request.getSourecFileUid();
		String target = request.getTargetImageFormat();
		logger.info("ImageFileConvertor.convert 1: inUid = " + inUid);
		DownloadFileResult download = fileService.readFile(inUid);
		logger.info("ImageFileConvertor.convert 2: download.name = " + download.getName());
		InputStreamContentSupplier content = imageConvertor.convert(download, target);
		logger.info("ImageFileConvertor.convert 3: inUid = " + request);
		String targetName = FileExtensionUtil.replaceExtension(download.getName(), request.getTargetImageFormat());
		return fileService.writeFile(targetName, content); // TODO
	}

}
