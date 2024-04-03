    package com.Proje.demo.services;


    import com.Proje.demo.entity.UserInfo;
    import org.springframework.security.core.userdetails.UsernameNotFoundException;

    import java.util.List;
    import java.util.Optional;

    public interface UserService {
        List<UserInfo> findAllUser();
        Optional<UserInfo> findById(long id);
        UserInfo saveUser(UserInfo userInfo);
        UserInfo updateUser(UserInfo userInfo);
        void deleteUser(Long id);
        String createPassword();
        public void loadUserByUsername(String username) throws UsernameNotFoundException;
    }
