package com.pramod.rest.fileprocessing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;

@SpringBootTest
class RestfileprocessingApplicationTests {

	private static final String FILE_UPLOAD_URL = "http://localhost:8080/upload";
	private static final String DOWNLOAD_URL = "http://localhost:8080/download/";
	private static final String DOWNLOAD_PATH = "C:/Users/Pramod/OneDrive/Documents/downloads/";


	@Autowired
	RestTemplate restTemplate;

	@Test
	void testUpload() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

		MultiValueMap<String,Object> body = new LinkedMultiValueMap<>();
		body.add("file", new PathResource("src/main/resources/pp.jpg"));

		System.out.println(new ClassPathResource("pp.jpg"));
		System.out.println(new PathResource("src/main/resources/pp.jpg"));

		HttpEntity<MultiValueMap<String,Object>> httpEntity = new HttpEntity<>(body,httpHeaders);

		ResponseEntity<Boolean> repsonse = restTemplate.postForEntity(FILE_UPLOAD_URL, httpEntity, Boolean.class);

		System.out.println(repsonse.getBody());
	}

	@Test
	void testDownload() throws IOException {
		HttpHeaders httpHeaders = new HttpHeaders();

		httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_OCTET_STREAM));

		String fileName = "pp.jpg";

		HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
		ResponseEntity<byte[]> response = restTemplate.exchange(DOWNLOAD_URL+fileName, HttpMethod.GET, httpEntity,byte[].class);
		Files.write(Paths.get(DOWNLOAD_PATH+fileName),response.getBody());
	}

}
