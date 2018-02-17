package com.fish.user.fishuserservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.server.RMIClassLoader;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUserByName", method = RequestMethod.GET)
    public List<User> getUser(@RequestParam(name = "name", required = false)String name){
        return userService.getUser(name);
    }
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public List<User> getUser(@RequestParam(name = "id", required = false, defaultValue = "-1")Long id){
        System.out.println("****************Server 2***********************");
        return userService.getUser(id);
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public boolean addUser(@RequestParam(name = "name", required = true)String name,
                           @RequestParam(name = "balance", required = false, defaultValue = "0")double balance){
        return userService.addUser(name, balance);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String checkServerStatus(){
        System.out.println("User Server is being triggered for checking status");
        return "User Serve works fine";
    }
}
