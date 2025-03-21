package com.example.DataValidation.Service;

import com.example.DataValidation.DTO.UserRequest;
import com.example.DataValidation.Model.User;
import com.example.DataValidation.Repository.UserRepository;
import com.example.DataValidation.exception.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public User saveUser(UserRequest userRequest){
        User user=User.build(0, userRequest.getName(),userRequest.getEmail(),
                userRequest.getMobile(), userRequest.getGender(),userRequest.getAge(),
                userRequest.getNationality());
        return repo.save(user);
    }

    public List<User> getAllUsers(){
        return repo.findAll();
    }

//    public User getUser(int id){
//        return repo.findById(id).orElse(null);
//    }

    //We can use 'ResponseStatusException' but this time we create a custom exception.
    //If the user is not present we create a custom exception with message "User is not found";
    public User getUser(int id) throws UserNotFoundException {
        User user=repo.findById(id).orElse(null);
        if(user!=null){
            return user;
        }else{
            //throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            throw new UserNotFoundException("User not found with Id:"+id);
        }
    }

    public void deleteUser(int id) throws UserNotFoundException{
        //repo.deleteById(id);
        User user=repo.findById(id).orElse(null);
        if(user!=null){
            repo.deleteById(id);
        }else{
            throw new UserNotFoundException("There is no user with Id:"+id);
        }
    }


    public void updateUser(@Valid UserRequest userRequest, int id) throws UserNotFoundException{
        User user=repo.findById(id).orElse(null);
        if(user!=null) {
            user = User.build(id, userRequest.getName(), userRequest.getEmail(), userRequest.getMobile(),
                    userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());
            repo.save(user);
        }else{
            throw new UserNotFoundException("User with Id:"+id+" is not available");
        }
    }
}
