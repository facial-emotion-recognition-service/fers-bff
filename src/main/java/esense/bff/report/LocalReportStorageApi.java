package esense.bff.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

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
		File dir = new File(reportsDirPath);
		logger.info("LocalReportStorageApi.init 1: reportsDirPath " + reportsDirPath);
		logger.info("LocalReportStorageApi.init 2: dir exists = " + dir.exists());
		logger.info("LocalReportStorageApi.init 3: dir isDirectory = " + dir.isDirectory());
		List<File> files = Arrays.asList(dir.listFiles());
		logger.info("LocalReportStorageApi.init 4: dir files = " + files.stream().map(f->f.getAbsolutePath()).toList());
	}

	public DownloadFileResult readFile(String fileName) throws IOException {
		logger.info("LocalReportStorageApi.readFile 1: reportsDirPath = " + reportsDirPath + ", fileName = " + fileName);
		Path path = Paths.get(reportsDirPath, fileName);
		logger.info("LocalReportStorageApi.readFile 2.1: path " + path.toAbsolutePath());
		logger.info("LocalReportStorageApi.readFile 2.2: file.exists = " + path.toFile().exists());
		long fileSize = path.toFile().length();
		logger.info("LocalReportStorageApi.readFile 2.3: file.size = " + fileSize);
		InputStream body = new FileInputStream(path.toFile());
		DownloadFileResult r = new DownloadFileResult(fileName, body, fileSize);
		logger.info("LocalReportStorageApi.readFile 3: r " + r.getName());
		return r;
	}

}
