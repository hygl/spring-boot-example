package de.ble.demo.todo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController{

  private TodoRepository todoRepository;

  @Autowired
  public TodoController(TodoRepository todoRepository){
    this.todoRepository = todoRepository; 
  }


  @PostMapping("/todo")
  public String addTodo(@RequestParam String task,@RequestParam(required = false) Date datum) {
	  if (datum !=null) {
		  todoRepository.save(new Todo(task, datum));
	  }else {
		  todoRepository.save(new Todo(task, null));
	  }
	  return "redirect:/todos";
  }
  
  @GetMapping("/todos")
  public String getTodos(Model model){
    model.addAttribute("todos", todoRepository.findAll());
    return "todos";
  }
}