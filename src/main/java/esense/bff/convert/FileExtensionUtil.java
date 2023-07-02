package esense.bff.convert;

import java.util.Optional;

public class FileExtensionUtil {

	public static String replaceExtension(String filename, String after) {
		if (filename == null || filename.isBlank() || !filename.contains(".")) {
			return filename;
		}
		Optional<Integer> pindex = getExtensionIndex(filename);
		if (pindex.isEmpty()) {
			return filename;
		}
		int index = pindex.get();
		String fileNameWithoutExtension = filename.substring(0, index);
		return fileNameWithoutExtension + after;
	}
	
	private static Optional<Integer> getExtensionIndex(String filename) {
	    return Optional.ofNullable(filename)
	      .filter(f -> f.contains("."))
	      .map(f -> filename.lastIndexOf("."));
	}

}
