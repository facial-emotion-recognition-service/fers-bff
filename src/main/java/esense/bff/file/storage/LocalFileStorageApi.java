package esense.bff.file.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import esense.bff.file.model.DownloadFileResult;
import esense.bff.file.model.FileMetaData;
import esense.bff.file.model.content.ContentSupplier;
import jakarta.annotation.PostConstruct;

@Service
public class LocalFileStorageApi implements FileStorageApi {

	@Value("${file.storage.dir}")
    private String filesDirPath;

	private final DirValidator dirValidator;

	public LocalFileStorageApi(DirValidator dirValidator) {
		this.dirValidator = dirValidator;
	}

	@PostConstruct
	private void init() {
		dirValidator.createIfNotExists(filesDirPath);
		dirValidator.validateDirPath(filesDirPath);
	}

	@Override
	public String writeFile(UUID uuid, ContentSupplier file) {
		String fileName = uuid.toString();
		File target = Paths.get(filesDirPath, fileName).toFile();
		contentIntoFile(file, target);
		return target.getAbsolutePath();
	}

	private void contentIntoFile(ContentSupplier inputFile, File targetFile) {
		try (InputStream is = inputFile.get()) {
			Files.copy(is, targetFile.toPath());
		}catch (Throwable t) {
			throw new RuntimeException("Fail to write upload file into local file", t);
		}
	}

	@Override
	public DownloadFileResult readFile(FileMetaData metaData) throws IOException {
		Path path = Paths.get(metaData.getKey());
		long fileSize = path.toFile().length();
		InputStream body = new FileInputStream(path.toFile());
		return new DownloadFileResult(metaData.getFileName(), body, fileSize);
	}

}
