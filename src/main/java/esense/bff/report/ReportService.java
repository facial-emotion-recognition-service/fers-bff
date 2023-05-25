package esense.bff.report;

import java.io.IOException;

import org.springframework.stereotype.Service;

import esense.bff.file.model.DownloadFileResult;

@Service
public class ReportService {

	private final LocalReportStorageApi reportStorage;

	public ReportService(LocalReportStorageApi reportStorage) {
		this.reportStorage = reportStorage;
	}

	public DownloadFileResult readFile(String suid) throws IOException {
		return reportStorage.readFile(suid);
	}

}