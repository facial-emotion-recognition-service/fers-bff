package esense.bff.app.http;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import esense.bff.file.model.DownloadFileResult;
import esense.bff.file.model.ImagePredictorResult;
import esense.bff.file.model.UploadFileResult;


@Component
public class HttpResponseFactory {
	
	private final HttpHeadersFactory httpHeadersFactory;
	
	private final  ResponseEntityFactory httpResponseFactory;

	public HttpResponseFactory(HttpHeadersFactory httpHeadersFactory, ResponseEntityFactory httpResponseFactory) {
		this.httpHeadersFactory = httpHeadersFactory;
		this.httpResponseFactory = httpResponseFactory;
	}
	
	
	public ResponseEntity<?> buildBadRequest() {
		return httpResponseFactory.buildBadRequest();
	}

	public ResponseEntity<UploadFileResult> buildSuccess(UploadFileResult r) {
		return httpResponseFactory.buildSuccess(r);
	}

	public ResponseEntity<?> buildFileResponse(DownloadFileResult response) {
		HttpHeaders headers = httpHeadersFactory.buildDownloadHead(response.getName());
		return httpResponseFactory.buildFileResponse(headers, response);
	}
	
	public ResponseEntity<ImagePredictorResult> buildSuccess(ImagePredictorResult r) {
		return httpResponseFactory.buildSuccess(r);
	}

}
