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
		System.out.println("ImageFileConvertor.convert 1: inUid = " + inUid);
		DownloadFileResult download = fileService.readFile(inUid);
		System.out.println("ImageFileConvertor.convert 2: download.name = " + download.getName());
		InputStreamContentSupplier content = imageConvertor.convert(download);
		System.out.println("ImageFileConvertor.convert 3: inUid = " + inUid);
		return fileService.writeFile(download.getName(), content); // TODO
	}

}
