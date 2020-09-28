package de.ble.demo.todo;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController{

  private final TodoRepository todoRepository;

  @Autowired
  public TodoController(final TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  @PostMapping("/todo")
  public Todo addTodo(@RequestBody final Todo newTodo) {
    return todoRepository.save(newTodo);
  }

  @GetMapping("/todos")
  public Iterable<Todo> getTodos() {
    return todoRepository.findAll();
  }

  @GetMapping("/todo/{id}")
  public Optional<Todo> getTodo(@PathVariable("id") final long id) {
    return todoRepository.findById(id);
  }
}
