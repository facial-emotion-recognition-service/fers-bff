package esense.bff.image;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Component;

import esense.bff.faces.Rectangle;
import esense.bff.file.model.DownloadFileResult;
import esense.bff.file.model.content.ContentSupplier;
import esense.bff.file.model.content.InputStreamContentSupplier;

@Component
public class ImageEditor {
	
	private BufferedImageTool tool;

	public ImageEditor(BufferedImageTool tool) {
		this.tool = tool;
	}

	public ContentSupplier cutImage(DownloadFileResult inputFile, Rectangle r) throws IOException {
		String extension = FileExtensionUtil.getExtension(inputFile.getName()).get(); //TODO
		BufferedImage outImage = tool.cutBufferedImage(inputFile.getBody(), r);
		InputStream is = tool.toInputStream(extension, outImage);
		return new InputStreamContentSupplier(is);
	}


}
