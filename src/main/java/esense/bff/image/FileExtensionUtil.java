package esense.bff.image;

import java.util.Optional;

public class FileExtensionUtil {

	public static Optional<String> getExtension(String filename) {
	    return Optional.ofNullable(filename)
	      .filter(f -> f.contains("."))
	      .map(f -> f.substring(filename.lastIndexOf(".") + 1));
	}

}
