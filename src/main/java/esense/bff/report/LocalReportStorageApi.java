package esense.bff.report;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import esense.bff.file.model.DownloadFileResult;
import esense.bff.file.storage.DirValidator;
import jakarta.annotation.PostConstruct;

@Service
public class LocalReportStorageApi {

	private static final Logger logger = LoggerFactory.getLogger(LocalReportStorageApi.class);

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
		logger.info("LocalReportStorageApi.init: reportsDirPath " + reportsDirPath);
	}

	public DownloadFileResult readFile(String fileName) throws IOException {
		logger.info("LocalReportStorageApi.readFile 1: reportsDirPath = " + reportsDirPath + ", fileName = " + fileName);
		Path path = Paths.get(reportsDirPath, fileName);
		logger.info("LocalReportStorageApi.readFile 2: path " + path.toAbsolutePath());
		logger.info("LocalReportStorageApi.readFile 2: path " + path.toFile());
		long fileSize = path.toFile().length();
		InputStream body = new FileInputStream(path.toFile());
		DownloadFileResult r = new DownloadFileResult(fileName, body, fileSize);
		logger.info("LocalReportStorageApi.readFile 3: r " + r.getName());
		return r;
	}

}
