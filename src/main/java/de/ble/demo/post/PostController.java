package de.ble.demo.post;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController{

  private final PostRepository postRepository;

  @Autowired
  public PostController(final PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  @PostMapping("/post")
  public Post addTodo(@RequestBody final Post post) {
    return postRepository.save(post);
  }

  @GetMapping("/posts")
  public Iterable<Post> getTodos() {
    return postRepository.findAll();
  }

  @GetMapping("/post/{id}")
  public Optional<Post> getTodo(@PathVariable("id") final long id) {
    return postRepository.findById(id);
  }
}
