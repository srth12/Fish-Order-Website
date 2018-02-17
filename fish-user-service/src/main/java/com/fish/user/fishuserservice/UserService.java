package com.fish.user.fishuserservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUser(String name){
        if (Objects.isNull(name)){
            return (List<User>) userRepository.findAll();
        }else {
            return Collections.singletonList(userRepository.findByName(name));
        }
    }

    public boolean addUser(String name, double balance) {
        userRepository.save(new User(name, balance));
        return true;
    }

    public List<User> getUser(Long id) {
        if (id != -1)
            return Collections.singletonList(userRepository.findById(id));
        else return (List<User>) userRepository.findAll();
    }
}
