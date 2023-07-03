package esense.bff.convert;

import java.io.IOException;

import org.springframework.stereotype.Service;

import esense.bff.file.FileService;
import esense.bff.file.model.DownloadFileResult;
import esense.bff.file.model.UploadFileResult;
import esense.bff.file.model.content.InputStreamContentSupplier;

@Service
public class ImageFileConvertor {

	private FileService fileService;
	private ImageDataConvertor imageConvertor;

	public ImageFileConvertor(FileService fileService, ImageDataConvertor imageConvertor) {
		this.fileService = fileService;
		this.imageConvertor = imageConvertor;
	}

	public UploadFileResult convert(ConvertImageFormatRequest request) throws IOException {
		String inUid = request.getSourecFileUid();
		String target = request.getTargetImageFormat();
		DownloadFileResult download = fileService.readFile(inUid);
		InputStreamContentSupplier content = imageConvertor.convert(download, target);
		String targetName = FileExtensionUtil.replaceExtension(download.getName(), request.getTargetImageFormat());
		return fileService.writeFile(targetName, content);
	}

}
