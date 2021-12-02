package com.crud.service;

import com.crud.common.dto.PaginationDTO;
import com.crud.common.dto.ServiceException;
import com.crud.entity.User;
import com.crud.exception.ResourceNotFoundException;
import com.crud.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ServiceImpl implements UserService {

    private String uploadFolderPath = "/home/aamir/Desktop";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PaginationService paginationService;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> saveUsers(List<User> users) {
        return userRepository.saveAll(users);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User Update(User user, Long userId) {
        User existsUser = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "UserId", userId));
        existsUser.setUserName(user.getUserName());
        existsUser.setUserFatherName(user.getUserFatherName());
        existsUser.setUserMobile(user.getUserMobile());
        existsUser.setUserAddress(user.getUserAddress());
        userRepository.save(existsUser);
        return existsUser;
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));

    }

    @Override
    public List<User> getUserByName(String userName) {
        List<User> existsName = userRepository.findByUserName(userName);
        if (!existsName.isEmpty() || existsName == null) {
            userRepository.findByUserName(userName);
        } else {
            throw new ResourceNotFoundException("User", "userName", userName);
        }
        return existsName;

    }

    @Override
    public User getUserByUserNameAndUserMobile(String userName, String userMobile) {
        User byUserNameAndUserMobile = userRepository.findByUserNameAndUserMobile(userName, userMobile);
        if (byUserNameAndUserMobile == null) {
            throw new ResourceNotFoundException("User", "userName", userName);
        }
        return byUserNameAndUserMobile;
    }

//    @Override
//    public User getUserByUserNameOrUserMobile(String userNameAndMobileNo) throws Exception {
//        User byUserNameOrUserMobile = userRepository.findByUserNameOrUserMobile(userNameAndMobileNo);
//        if (byUserNameOrUserMobile==null){
//            throw new ResourceNotFoundException("User","userName",userNameAndMobileNo);
//        }
//        return byUserNameOrUserMobile;
//    }

    @Override
    public void DeleteById(Long userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
        userRepository.deleteById(userId);
    }

    @Override
    public void uploadToLocal(MultipartFile file) {
        try {
            byte[] data = file.getBytes();
            Path path = Paths.get(uploadFolderPath + file.getOriginalFilename());
            Files.write(path, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void uploadToDb(MultipartFile file) {
        User user = new User();
        try {
//            user.setFileData(file.getBytes());
//            user.setFileType(file.getContentType());
//            user.setFileName(file.getOriginalFilename());
            userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map getUsersWithPagination(PaginationDTO paginationDTO) throws ServiceException {
        Page<User> userDetails = userRepository.findAll(paginationService.getPagination(paginationDTO));
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("data", userDetails);
        dataMap.put("totalPage", userDetails.getTotalPages());
        dataMap.put("currentPage", userDetails.getNumber());
        dataMap.put("totalRecords", userDetails.getTotalElements());
        return dataMap;
    }


}
