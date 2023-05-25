package esense.bff.file.storage;

import java.io.IOException;
import java.util.UUID;

import esense.bff.file.model.DownloadFileResult;
import esense.bff.file.model.FileMetaData;
import esense.bff.file.model.content.ContentSupplier;

public interface FileStorageApi {
	String writeFile(UUID uuid, ContentSupplier file) throws IOException;

	DownloadFileResult readFile(FileMetaData metaData) throws IOException;
}