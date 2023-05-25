package esense.bff.file.metadata;

import java.util.UUID;

import esense.bff.file.model.FileMetaData;

public interface FileMetadataApi {

	void writeFileMetaData(FileMetaData metaData);

	FileMetaData readFileMetaDataByUid(UUID uuid);

}