package com.Proje.demo.services.impl;

import com.Proje.demo.entity.UserInfo;
import com.Proje.demo.repository.UserRepository;
import com.Proje.demo.security.SecurityConfig;
import com.Proje.demo.services.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final SecurityConfig securityConfig;

    public UserServiceImpl(UserRepository userRepository, SecurityConfig securityConfig) {
        this.userRepository = userRepository;
        this.securityConfig = securityConfig;
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

    @Override
    public void loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        System.out.println(user.getUsername()+user.getPassword());

        UserDetails newUser = User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles("user")
                .build();

        securityConfig.passwordEncoder();
    }
}
