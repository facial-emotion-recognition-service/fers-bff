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
		System.out.println("StreamImageConvertor.convert 1");
		BufferedImage inputImage = streamConvertor.toBufferedImage(before);
		System.out.println("StreamImageConvertor.convert 2");
		BufferedImage outputImage = imageConvertor.convertBufferedImage(inputImage);
		System.out.println("StreamImageConvertor.convert 3");
		return streamConvertor.toInputStream(outputImage, "jpg"); // TODO
	}

}
