package esense.bff.file.model.content;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public class MultipartFileContentSupplier implements ContentSupplier {

	private final MultipartFile file;

	public MultipartFileContentSupplier(MultipartFile file) {
		this.file = file;
	}

	@Override
	public InputStream get() {
		try {
			return file.getInputStream();
		} catch (IOException e) {
			throw new RuntimeException("Fail to read content from upload file");
		}
	}

}
