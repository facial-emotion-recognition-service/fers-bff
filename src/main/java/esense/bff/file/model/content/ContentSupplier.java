package esense.bff.file.model.content;

import java.io.InputStream;

public interface ContentSupplier {
	
	//This method can be called only once and need to use try-catch to ensure close
	public InputStream get();

}
