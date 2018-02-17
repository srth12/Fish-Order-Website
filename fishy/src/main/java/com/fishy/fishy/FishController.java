package com.fishy.fishy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FishController {

    @Autowired
    private FishRepository fishRepository;

    @Autowired
    private FishUpdateService fishUpdateService;

    @RequestMapping(value = "/fishes", method = RequestMethod.GET)
    public List<Fish> getFish(@RequestParam(name = "name", defaultValue = "default", required = false)String name) {
        return fishUpdateService.getFishList(name);
    }

    @RequestMapping(value = "/updateFish", method = RequestMethod.GET)
    public boolean updateFishData(@RequestParam(name = "id", required = true)long id,
                                  @RequestParam(name = "name", required = false, defaultValue = "default")String name,
                                  @RequestParam(name = "quantity", required = false, defaultValue = "-1")int quantity,
                                  @RequestParam(name = "price", required = false, defaultValue = "-1")double price){
        return fishUpdateService.updateFish(id, name, quantity, price);
    }

    @RequestMapping(value = "/addFish", method = RequestMethod.GET)
    public boolean addFish(@RequestParam(name = "name", required = true)String name,
                           @RequestParam(name = "quantity", required = false)int quantity,
                           @RequestParam(name = "price", required = false)long price){
        return fishUpdateService.addFish(name, price, quantity);
    }
}
