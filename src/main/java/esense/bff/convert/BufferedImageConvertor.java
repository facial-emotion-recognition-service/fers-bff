package esense.bff.convert;

import java.awt.Color;
import java.awt.image.BufferedImage;

import org.springframework.stereotype.Component;

@Component
public class BufferedImageConvertor {

	public BufferedImage convertBufferedImage(BufferedImage input) {
		BufferedImage out = buildBufferedImageSettings(input);
		drawImageIntoBuffer(input, out);
		return out;
	}

	private void drawImageIntoBuffer(BufferedImage pngImageOriginal, BufferedImage newBufferedImage) {
		newBufferedImage.createGraphics().drawImage(pngImageOriginal, 0, 0, Color.white, null);
	}

	private BufferedImage buildBufferedImageSettings(BufferedImage pngImageOriginal) {
		return new BufferedImage(pngImageOriginal.getWidth(), pngImageOriginal.getHeight(), BufferedImage.TYPE_INT_BGR);
	}

}
