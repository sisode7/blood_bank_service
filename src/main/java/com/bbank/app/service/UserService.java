package com.bbank.app.service;

import com.bbank.app.model.LoginUser;
import com.bbank.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public LoginUser getUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public List<LoginUser> getAllUsers() {
        return userRepository.findAll();
    }

    public LoginUser saveUser(LoginUser user) {
        return userRepository.save(user);
    }

    public Optional<LoginUser> getById(Long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public void deleteUser(LoginUser user) {
        userRepository.delete(user);
    }
}
