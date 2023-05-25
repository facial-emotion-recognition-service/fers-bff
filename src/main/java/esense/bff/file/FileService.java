package esense.bff.file;

import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Service;

import esense.bff.file.metadata.FileMetadataApi;
import esense.bff.file.model.DownloadFileResult;
import esense.bff.file.model.FileMetaData;
import esense.bff.file.model.UploadFileResult;
import esense.bff.file.model.content.ContentSupplier;
import esense.bff.file.storage.FileStorageApi;

@Service
public class FileService {

	private final FileStorageApi fileStorage;
	private final FileMetadataApi fileMetadata;

	public FileService(FileStorageApi fileStorage, FileMetadataApi fileMetadata) {
		this.fileStorage = fileStorage;
		this.fileMetadata = fileMetadata;
	}

	public UploadFileResult writeFile(String name, ContentSupplier content) throws IOException {
		UUID uuid = UUID.randomUUID();
		String key = fileStorage.writeFile(uuid, content);
		FileMetaData metaData = new FileMetaData(uuid, key, name);
		fileMetadata.writeFileMetaData(metaData);
		return new UploadFileResult(metaData.getUid().toString());
	}

	public DownloadFileResult readFile(String suid) throws IOException {
		UUID uuid = UUID.fromString(suid);
		FileMetaData metaData = fileMetadata.readFileMetaDataByUid(uuid);
		return fileStorage.readFile(metaData);
	}

}