package com.fish.user.fishuserservice;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    public User findByName(String name);
    public User findById(Long id);
}
