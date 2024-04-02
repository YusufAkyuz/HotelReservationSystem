package com.Proje.demo.services.impl;

import com.Proje.demo.entity.UserInfo;
import com.Proje.demo.repository.UserRepository;
import com.Proje.demo.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserInfo> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserInfo> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserInfo saveUser(UserInfo userInfo) {
        return userRepository.save(userInfo);
    }

    @Override
    public UserInfo updateUser(UserInfo userInfo) {
        return userRepository.save(userInfo);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public String createPassword() {
        StringBuilder password = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            password.append(random.nextInt(9));
        }
        return password.toString();
    }

}
