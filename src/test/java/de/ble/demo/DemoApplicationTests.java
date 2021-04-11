package de.ble.demo;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import de.ble.demo.post.PostController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DemoApplicationTests {
	
	@Autowired
	private PostController postController;
	@Test
	public void contextLoads() {
		assertThat(postController).isNotNull();
	}

}
