package com.example.DataJPA.Controller;

import com.example.DataJPA.Model.User;
import com.example.DataJPA.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepo repo;

    @GetMapping()
    public List<User> getUsers(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id){
        return repo.findById(id).orElse(null);
    }

    @PostMapping()      //Don't give 'id' int the body.
    public String addUser(@RequestBody User us){
        repo.save(us);
        return "User added successfully";
    }

    @PutMapping         //Give all three attributes in the body.
    public String updateUser(@RequestBody User us){
        repo.save(us);
        return "User updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id){
        repo.deleteById(id);
        return "User deleted successfully";
    }

    @PatchMapping()
    public String updateUserPartially(@RequestBody User us){
        repo.save(us);
        return "Partially Updated user.";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.HEAD)
    public void check(@PathVariable int id){
        Optional<User> user=repo.findById(id);
        if(user.isPresent()){

        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        //Also written as:-
//        if(!user.isPresent()){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
    }
}
