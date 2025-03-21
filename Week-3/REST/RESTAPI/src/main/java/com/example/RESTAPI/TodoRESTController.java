package com.example.RESTAPI;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoRESTController {
    private final List<Todo> list=new ArrayList<>(Arrays.asList(new Todo(1,"Learning Java Basics",false)
            ,new Todo(2,"Learning Streams",false)
            ,new Todo(3,"Learning Spring boot",false)));

    @GetMapping()
    public List<Todo> getTodo(){
        return list;
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable int id){
        return list.stream()
                .filter(p->p.getId()==id)
                .findFirst()
                .orElse(new Todo(0,"No Todo",false));
    }

    @PostMapping()
    public String addTodo(@RequestBody Todo t){
        list.add(t);
        return "Todo added successfully";
    }

    //Marking Todo as completed.
    //We can also use @PatchMapping("/{id}")
    @PutMapping("/{id}")
    public String markTodo(@PathVariable int id){
        for(Todo to:list){
            if(to.getId()==id){
                to.setCompleted(true);
                return "Todo marked as Completed";
            }
        }
        return "No todo";
    }

    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable int id){
        list.removeIf(t->t.getId()==id);
        return "Todo Deleted successfully";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.HEAD)
    public void contains(@PathVariable int id){
        Todo t=list.stream()
                .filter(to->to.getId()==id)
                .findFirst()
                .orElse(null);
        if(t!=null){

        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
