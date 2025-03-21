package com.example.JpaCRUD.Controller;

import com.example.JpaCRUD.Model.Todo;
import com.example.JpaCRUD.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoRepository repo;

    @PostMapping()
    public String addTodo(@RequestBody Todo todo){
        repo.save(todo);
        return "Todo added successfully";
    }

    @GetMapping()
    public ResponseEntity<List<Todo>> getTodos(){
        return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable int id){
        Todo todo=repo.findById(id).orElse(null);
        if(todo!=null){
            return new ResponseEntity<>(todo,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTodo(@PathVariable int id){
        Todo todo1=repo.findById(id).orElse(null);
        if(todo1!=null){
            if(todo1.getId()==id){
                todo1.setCompleted(true);
                repo.save(todo1);
                return new ResponseEntity<>("Todo with Id:"+id+" marked as completed",HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Todo not found with Id:"+id,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable int id){
        Todo todo=repo.findById(id).orElse(null);
        if(todo!=null){
            repo.deleteById(id);
            return new ResponseEntity<>("Todo with Id:"+id+" deleted successfully",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Todo with Id:"+id+" not found",HttpStatus.NOT_FOUND);
        }
    }
}
