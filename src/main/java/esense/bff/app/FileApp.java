package esense.bff.app;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import esense.bff.app.http.HttpResponseFactory;
import esense.bff.app.http.MultipartFileValidator;
import esense.bff.file.FileService;
import esense.bff.file.model.DownloadFileResult;
import esense.bff.file.model.UploadFileResult;
import esense.bff.file.model.content.MultipartFileContentSupplier;

@Service
public class FileApp {

	private final FileService fileService;

	private final HttpResponseFactory httpResponseFactory;

	public FileApp(FileService filesService, HttpResponseFactory httpResponseFactory) {
		this.fileService = filesService;
		this.httpResponseFactory = httpResponseFactory;
	}

	public ResponseEntity<?> writeFile(MultipartFile file) {
		try {
			MultipartFileValidator.validateMultipartFile(file);
			String name = file.getOriginalFilename();
			MultipartFileContentSupplier content = new MultipartFileContentSupplier(file);
			UploadFileResult r = fileService.writeFile(name, content);
			return httpResponseFactory.buildSuccess(r);
		} catch (IOException e) {
			return httpResponseFactory.buildBadRequest();
		}
	}

	public ResponseEntity<?> readFile(String fileUid) {
		try {
			DownloadFileResult response = fileService.readFile(fileUid);
			return httpResponseFactory.buildFileResponse(response);
		} catch (IOException e) {
			return httpResponseFactory.buildBadRequest();
		}
	}

}