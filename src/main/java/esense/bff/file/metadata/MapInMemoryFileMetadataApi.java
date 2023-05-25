package esense.bff.file.metadata;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import esense.bff.file.model.FileMetaData;

@Service
public class MapInMemoryFileMetadataApi implements FileMetadataApi {

	private Map<UUID, FileMetaData> uidToKey = new HashMap<>(); // Temp solution in memeory

	@Override
	public void writeFileMetaData(FileMetaData metaData) {
		uidToKey.put(metaData.getUid(), metaData);
	}

	@Override
	public FileMetaData readFileMetaDataByUid(UUID uuid) {
		return uidToKey.get(uuid);
	}

}
