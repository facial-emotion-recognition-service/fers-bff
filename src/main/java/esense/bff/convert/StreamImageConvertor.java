package esense.bff.convert;

import java.awt.image.BufferedImage;
import java.io.InputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class StreamImageConvertor {

    private static Logger logger = LogManager.getLogger(ImageFileConvertor.class);

	private final BufferedStreamConvertor streamConvertor;
	private final BufferedImageConvertor imageConvertor;

	public StreamImageConvertor(BufferedStreamConvertor streamConvertor, BufferedImageConvertor imageConvertor) {
		this.streamConvertor = streamConvertor;
		this.imageConvertor = imageConvertor;
	}

	public InputStream convert(InputStream before, String target) {
		logger.info("StreamImageConvertor.convert 1");
		BufferedImage inputImage = streamConvertor.toBufferedImage(before);
		logger.info("StreamImageConvertor.convert 2");
		BufferedImage outputImage = imageConvertor.convertBufferedImage(inputImage);
		logger.info("StreamImageConvertor.convert 3");
		return streamConvertor.toInputStream(outputImage, target);
	}

}
