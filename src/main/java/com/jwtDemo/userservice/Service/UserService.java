package com.jwtDemo.userservice.Service;

import com.jwtDemo.userservice.Entity.Role;
import com.jwtDemo.userservice.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username,String roleName);
    User getUser(String username);
    List<User> getUsers();  // it's better to return a Page , not a List !
}
