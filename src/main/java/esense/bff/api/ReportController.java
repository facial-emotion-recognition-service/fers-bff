package esense.bff.api;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import esense.bff.report.ReportApp;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1/report")
public class ReportController {

	private final ReportApp reportApp;

	public ReportController(ReportApp reportApp) {
		this.reportApp = reportApp;
	}

	@GetMapping("/download/{uid}")
	@Operation(summary = "Download a report using its uid")
	public ResponseEntity<?> download(@PathVariable String uid) throws IOException {
		return reportApp.readFile(uid);

	}

}