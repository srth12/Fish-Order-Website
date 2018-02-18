package com.fish.user.fishuserservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }

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
