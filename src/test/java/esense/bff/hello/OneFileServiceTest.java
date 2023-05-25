package esense.bff.hello;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.MultipartFile;

import esense.bff.file.FileService;
import esense.bff.file.model.DownloadFileResult;
import esense.bff.file.model.UploadFileResult;
import esense.bff.file.model.content.ContentSupplier;
import esense.bff.file.model.content.MultipartFileContentSupplier;

@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OneFileServiceTest {

	private static final String FILE_NAME = "abc.txt";
	private static final String FILE_TEXT = "hello world";

	private static Optional<String> fileUid = Optional.empty();

	@LocalServerPort
	private int port;
	
	@Autowired
    private FileService fileService;

	@Order(1)
	@Test
	public void test01UploadFile() throws Exception {
		MultipartFile uploadFile = new MockMultipartFile(FILE_NAME, FILE_TEXT.getBytes());
		ContentSupplier content = new MultipartFileContentSupplier(uploadFile);

		UploadFileResult result = fileService.writeFile(FILE_NAME, content);

		Assertions.assertNotNull(result);
		Assertions.assertNotNull(result.getUid());
		fileUid = Optional.of(result.getUid());
	}

	@Order(2)
	@Test
	public void test02DownloadFile() throws Exception {
		Assertions.assertTrue(fileUid.isPresent());
		String uid = fileUid.get();

		DownloadFileResult result = fileService.readFile(uid);

		Assertions.assertNotNull(result);
		Assertions.assertNotNull(result.getName());
		Assertions.assertNotNull(result.getBody());
		Assertions.assertEquals(FILE_NAME, result.getName());

		byte[] bodyBytes = result.getBody().readAllBytes();
		String actual = new String(bodyBytes);
		Assertions.assertEquals(FILE_TEXT, actual);
	}

}