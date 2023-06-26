package esense.bff.file.model.content;

import java.io.InputStream;

public class InputStreamContentSupplier implements ContentSupplier {

	private final InputStream is;

	public InputStreamContentSupplier(InputStream is) {
		this.is = is;
	}

	@Override
	public InputStream get() {
		return is;
	}

}
