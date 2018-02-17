package com.fishy.fishy;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FishRepository extends CrudRepository<Fish, Long> {

    public List<Fish> findByName(String name);
    public Fish findById(long id);

}
