package de.ble.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import de.ble.demo.post.Post;
import de.ble.demo.post.PostRepository;

@Component 
public class DatabaseLoader implements CommandLineRunner { 

	private final PostRepository repository;

	@Autowired 
	public DatabaseLoader(PostRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... strings) throws Exception { 
		this.repository.save(new Post("title","text",new Date()));
	}
}