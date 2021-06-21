package com.pramod.productrestapi;

import com.pramod.productrestapi.entities.Product;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductrestapiApplicationTests {

	@Value("${productrestapi.services.url}")
	private String baseURL;

	@Test
	public void testGetProducts() {
		System.out.println(baseURL);
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(baseURL+"2", Product.class);
		assertNotNull(product);
		assertEquals("Iphone",product.getName());
	}

	@Test
	public void testCreateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = new Product();
		product.setName("Samsung");
		product.setDescription("Its cool");
		product.setPrice(1000);
		Product newproduct = restTemplate.postForObject(baseURL,product,Product.class);
		assertNotNull(product);
		assertNotNull(newproduct.getId());
		assertEquals("Samsung",newproduct.getName());
	}

	@Test
	public void testUpdateProducts() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(baseURL+"2", Product.class);
		product.setPrice(7777);
		restTemplate.put(baseURL,product);
	}
}
