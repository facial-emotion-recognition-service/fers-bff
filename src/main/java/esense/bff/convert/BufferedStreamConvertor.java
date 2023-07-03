package esense.bff.convert;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Component;

@Component
public class BufferedStreamConvertor {

	public BufferedImage toBufferedImage(InputStream input) {
		try {
			return ImageIO.read(input);
		} catch (IOException e) {
			throw new RuntimeException("Fail to read InputStream into BufferedImage");
		}
	}

	public InputStream toInputStream(BufferedImage input, String imageFormat) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(input, imageFormat, baos);
			return new ByteArrayInputStream(baos.toByteArray());
		} catch (IOException e) {
			throw new RuntimeException("Fail to read BufferedImage into InputStream with format: " + imageFormat);
		}
	}

}
