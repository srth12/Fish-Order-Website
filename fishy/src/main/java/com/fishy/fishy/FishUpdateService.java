package com.fishy.fishy;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FishUpdateService {

    @Autowired
    private FishUpdateService fishUpdateService;

    @Autowired
    private FishRepository fishRepository;

    public boolean updateFish(long id, String name, int quantity, double price){
        Fish fish = fishRepository.findById(id);
        fish = updateFishData(fish, name, quantity, price);
        if( fish != null){
            fishRepository.save(fish);
            return true;
        }else {
            return false;
        }
    }

    private Fish updateFishData(Fish fish, String name, int quantity, double price) {
        if (!name.equalsIgnoreCase("default"))
            fish.setName(name);
        if (price != -1)
            fish.setPrice(price);
        if (quantity != -1)
            fish.setQuantity(quantity);

        return new Fish(fish.getId(), quantity, fish.getName(), fish.getPrice());
    }


    public List<Fish> getFishList(String name){
        if (name.equalsIgnoreCase("default"))
            return Lists.newArrayList(fishRepository.findAll());
        else
            return fishRepository.findByName(name);
    }

    public boolean addFish(String name, long price, int quantity) {
         fishRepository.save(new Fish(quantity, name, price));
         return true;
    }
}
