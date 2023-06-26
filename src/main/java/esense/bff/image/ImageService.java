package esense.bff.image;

import java.io.IOException;

import org.springframework.stereotype.Service;

import esense.bff.faces.Rectangle;
import esense.bff.file.FileService;
import esense.bff.file.model.DownloadFileResult;
import esense.bff.file.model.UploadFileResult;
import esense.bff.file.model.content.ContentSupplier;

@Service
public class ImageService {

	private FileService fileService;
	private ImageEditor imageEditor;

	public ImageService(FileService fileService, ImageEditor imageEditor) {
		this.fileService = fileService;
		this.imageEditor = imageEditor;
	}

	public UploadFileResult createNewImage(String inUid, Rectangle rectangle) throws IOException {
		DownloadFileResult inputFile = fileService.readFile(inUid);
		ContentSupplier content = imageEditor.cutImage(inputFile, rectangle);
		return fileService.writeFile("face", content);
	}

}
