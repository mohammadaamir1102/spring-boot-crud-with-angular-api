package com.crud.controller;

import com.crud.entity.User;
import com.crud.repo.UserRepository;
import com.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200/", "http://localhost:8080"})
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    //for creating single user
    @PostMapping("/")
    public ResponseEntity<String> saveUser(@RequestBody User user) {

        try {
            User existsUser = userRepository.findByUserEmail(user.getUserEmail());
            if (existsUser != null) {
                return new ResponseEntity<String>("User already exists", HttpStatus.INTERNAL_SERVER_ERROR);
            }
            userService.saveUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("Exception in saving data", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>("User Saved Successfully", HttpStatus.OK);
    }

    //for creating multiple user
    @PostMapping("/users")
    public ResponseEntity<List<User>> saveUsers(@RequestBody List<User> users) {
        return new ResponseEntity<List<User>>(userService.saveUsers(users), HttpStatus.CREATED);
    }

    //getting user record
    @GetMapping("/get-users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    //update user based on id
    @PutMapping("/update/{id}")
    public ResponseEntity<User> Update(@PathVariable("id") Long userId, @RequestBody User user) {
        return new ResponseEntity<User>(userService.Update(user, userId), HttpStatus.OK);

    }

    //getting user based on id
    @GetMapping("/get-id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId) {
        return new ResponseEntity<User>(userService.getUserById(userId), HttpStatus.OK);
    }

    //getting user based on user user
    @GetMapping("/get-name/{userName}")
    public ResponseEntity<List<User>> getUserByName(@PathVariable("userName") String userName) {
        return new ResponseEntity<List<User>>(userService.getUserByName(userName), HttpStatus.OK);
    }

    //delete user based on id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteById(@PathVariable("id") Long userId) {
        userService.DeleteById(userId);
        return new ResponseEntity<String>("user id no:" + userId + " has been delete successfully", HttpStatus.OK);
    }


}
