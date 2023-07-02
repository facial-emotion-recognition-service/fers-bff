package esense.bff.convert;

import java.awt.image.BufferedImage;
import java.io.InputStream;

import org.springframework.stereotype.Component;

@Component
public class StreamImageConvertor {

	private final BufferedStreamConvertor streamConvertor;
	private final BufferedImageConvertor imageConvertor;

	public StreamImageConvertor(BufferedStreamConvertor streamConvertor, BufferedImageConvertor imageConvertor) {
		this.streamConvertor = streamConvertor;
		this.imageConvertor = imageConvertor;
	}

	public InputStream convert(InputStream before) {
		BufferedImage inputImage = streamConvertor.toBufferedImage(before);
		BufferedImage outputImage = imageConvertor.convertBufferedImage(inputImage);
		return streamConvertor.toInputStream(outputImage, "jpg"); // TODO
	}

}
