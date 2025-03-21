package com.example.DataJPA.Controller;

import com.example.DataJPA.Model.Todo;
import com.example.DataJPA.Repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoRepo repo;

    @GetMapping()
    public List<Todo> getTodo(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable int id){
        return repo.findById(id).orElse(null);
    }

    @PostMapping()
    public String addTodo(@RequestBody Todo task){
        repo.save(task);
        return "Todo added successfully";
    }

    @PutMapping("/{id}")
    public String updateTodo(@PathVariable int id){
        Todo to=repo.findById(id).orElse(null);
        to.setCompleted(true);
        repo.save(to);
        return "Todo marked as completed";
    }

    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable int id){
        repo.deleteById(id);
        return "Todo deleted successfully";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.HEAD)
    public void check(@PathVariable int id){
        Todo to=repo.findById(id).orElse(null);
        if(to==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
