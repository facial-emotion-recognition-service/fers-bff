package esense.bff.image;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Component;

import esense.bff.faces.Rectangle;

@Component
public class BufferedImageTool {

	public BufferedImage cutBufferedImage(InputStream inputFile, Rectangle r) throws IOException {
		BufferedImage inputImage = ImageIO.read(inputFile);
		return inputImage.getSubimage(r.x(), r.y(), r.w(), r.h());
	}

	public InputStream toInputStream(String extension, BufferedImage outImage) throws IOException {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ImageIO.write(outImage, extension, os);
		return new ByteArrayInputStream(os.toByteArray());
	}

}
