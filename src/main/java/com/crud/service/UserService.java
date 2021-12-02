package com.crud.service;

import com.crud.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService {
    User saveUser(User user);

    List<User> saveUsers(List<User> users);

    List<User> getUsers();

    User Update(User user, Long userId);

    User getUserById(Long userId);

    List<User> getUserByName(String userName);

    User getUserByUserNameAndUserMobile(String userName, String userMobile) throws Exception;

    //    User getUserByUserNameOrUserMobile(String userNameAndMobileNo) throws Exception;
    void DeleteById(Long userId);

    void uploadToLocal(MultipartFile file);

    void uploadToDb(MultipartFile file);
}
