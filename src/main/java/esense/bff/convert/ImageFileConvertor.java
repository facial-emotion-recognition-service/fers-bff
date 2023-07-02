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

	public UploadFileResult convert(String inUid) throws IOException {
		DownloadFileResult download = fileService.readFile(inUid);
		InputStreamContentSupplier content = imageConvertor.convert(download);
		return fileService.writeFile(download.getName(), content); // TODO
	}

}
