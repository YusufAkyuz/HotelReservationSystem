package com.Proje.demo.controller;

import com.Proje.demo.entity.UserInfo;
import com.Proje.demo.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public List<UserInfo> findAllUser() {
        return userService.findAllUser();
    }

    @GetMapping("/{id}")
    public Optional<UserInfo> findUserById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public UserInfo saveUser(@RequestBody UserInfo userInfo) {
        return userService.saveUser(userInfo);
    }

    @PutMapping
    public UserInfo updateUser(@RequestBody UserInfo userInfo) {
        return userService.updateUser(userInfo);
    }

    @DeleteMapping("({id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }
}
