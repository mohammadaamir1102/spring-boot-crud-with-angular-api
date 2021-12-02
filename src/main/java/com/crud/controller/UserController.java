package com.crud.controller;

import com.crud.common.dto.PaginationDTO;
import com.crud.common.dto.ServiceException;
import com.crud.entity.User;
import com.crud.repo.UserRepository;
import com.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
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
                return new ResponseEntity<String>("This gmail already exists", HttpStatus.INTERNAL_SERVER_ERROR);
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

    @GetMapping("/get-name-and-mobile/{userName}/{userMobile}")
    public ResponseEntity<User> getUserByUserNameOrUserMobile(@PathVariable String userName,
                                                              @PathVariable String userMobile) throws Exception {
        return new ResponseEntity<User>(userService.getUserByUserNameAndUserMobile(userName, userMobile), HttpStatus.OK);

    }

    //    @GetMapping("/get-name-or-mobile/{userNameAndMobileNo}")
//    public ResponseEntity<User> getUserByUserNameOrUserMobile(@PathVariable String userNameAndMobileNo) throws Exception {
//        return new ResponseEntity<User>(userService.getUserByUserNameOrUserMobile(userNameAndMobileNo), HttpStatus.OK);
//
//
//    }
    @PostMapping("/upload-local")
    public ResponseEntity<String> uploadToLocal(@RequestParam("file") MultipartFile file) {
        try {
            userService.uploadToLocal(file);
        } catch (Exception i) {
            i.printStackTrace();
            return new ResponseEntity<String>("file not uploaded", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>("file uploaded in Local Storage  ", HttpStatus.OK);
    }

    @PostMapping("/upload-db")
    public ResponseEntity<String> uploadToDb(@RequestParam("file") MultipartFile file) {

        try {
            userService.uploadToDb(file);
        } catch (Exception i) {
            i.printStackTrace();
            return new ResponseEntity<String>("file not uploaded", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>("file uploaded in Database ", HttpStatus.OK);
    }

    @GetMapping("/{offset}/{page}")
    public Map getUsersWithPagination(@PathVariable Long offset, @PathVariable Long page) throws ServiceException {
        PaginationDTO paginationDTO = new PaginationDTO();
        paginationDTO.setOffset(offset.intValue());
        paginationDTO.setPageNumber(page.intValue());
        return userService.getUsersWithPagination(paginationDTO);
    }

}
