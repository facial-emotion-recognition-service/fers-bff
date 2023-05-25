package esense.bff.report;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import esense.bff.app.http.HttpResponseFactory;
import esense.bff.file.model.DownloadFileResult;

@Service
public class ReportApp {

	private final ReportService reportService;

	private final HttpResponseFactory httpResponseFactory;

	public ReportApp(ReportService reportService, HttpResponseFactory httpResponseFactory) {
		this.reportService = reportService;
		this.httpResponseFactory = httpResponseFactory;
	}

	public ResponseEntity<?> readFile(String fileUid) {
		try {
			DownloadFileResult response = reportService.readFile(fileUid);
			return httpResponseFactory.buildFileResponse(response);
		} catch (IOException e) {
			return httpResponseFactory.buildBadRequest();
		}
	}

}