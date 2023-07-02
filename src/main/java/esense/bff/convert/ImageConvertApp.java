package esense.bff.convert;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import esense.bff.file.model.UploadFileResult;

@Service
public class ImageConvertApp {

	private final ImageFileConvertor fileConvertor;

	public ImageConvertApp(ImageFileConvertor fileConvertor) {
		this.fileConvertor = fileConvertor;
	}

	public ResponseEntity<?> convert(String inUid) {
		try {
			System.out.println("ImageConvertApp.convert 1: inUid = " + inUid);
			UploadFileResult result = fileConvertor.convert(inUid);
			System.out.println("ImageConvertApp.convert 2: inUid = " + inUid + ", outUid = " + result.getUid());
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}