package esense.bff.report;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import esense.bff.file.model.DownloadFileResult;
import esense.bff.file.storage.DirValidator;
import jakarta.annotation.PostConstruct;

@Service
public class LocalReportStorageApi {

	private static final String JSON_EXT = ".json";

	@Value("${report.storage.dir}")
	private String reportsDirPath;

	private final DirValidator dirValidator;

	public LocalReportStorageApi(DirValidator dirValidator) {
		this.dirValidator = dirValidator;
	}

	@PostConstruct
	private void init() {
		dirValidator.createIfNotExists(reportsDirPath);
		dirValidator.validateDirPath(reportsDirPath);
	}

	public DownloadFileResult readFile(String fileName) throws IOException {
		fileName = (fileName.endsWith(JSON_EXT))? fileName : fileName + JSON_EXT;
		Path path = Paths.get(reportsDirPath, fileName);
		long fileSize = path.toFile().length();
		InputStream body = new FileInputStream(path.toFile());
		DownloadFileResult r = new DownloadFileResult(fileName, body, fileSize);
		return r;
	}

}
