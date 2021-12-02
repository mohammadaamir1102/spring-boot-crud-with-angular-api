package com.crud.repo;

import com.crud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findByUserName(String userName);
//    @Query("select u From user u where u.user_name =:n or u.user_mobile=:m")
//    User findByUserNameOrUserMobile(@Param("n") String userName, @Param("m") String userMobile);
    User findByUserNameAndUserMobile(String userName,String userMobile);
//    User findByUserNameOrUserMobile(String userNameAndMobileNo);
    User findByUserEmail(String userEmail);
}
