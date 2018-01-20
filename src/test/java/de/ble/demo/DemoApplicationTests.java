package de.ble.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {

	@LocalServerPort
	private int port;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void uppercase() {
		// TODO: make this work with a JSON stream as well (like in WebFlux)
		assertThat(new TestRestTemplate().postForObject(
				"http://localhost:" + port + "/uppercase", "test",
				String.class)).isEqualTo("TEST");
	}


}
