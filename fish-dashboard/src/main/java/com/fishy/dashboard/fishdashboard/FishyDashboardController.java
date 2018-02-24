package com.fishy.dashboard.fishdashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RibbonClient(name = "fishy-user", configuration = UserConfiguration.class)
public class FishyDashboardController {

   /* @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }*/

    @LoadBalanced
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public List<User> getUsers(@RequestParam(name = "id", required = false)Long id){
        User[] results = restTemplate.getForObject("http://fishy-user/getUser", User[].class);
        return Arrays.asList(results);
    }

    @RequestMapping(value = "/getFishes", method = RequestMethod.GET)
    public List<Fish> getFishes(@RequestParam(name = "fishId", required = false)Long fishId){
        Fish[] fishes = restTemplate.getForObject("http://FISH-REGISTRY-SERVICE/fishes", Fish[].class);
        return Arrays.asList(fishes);
    }

    @RequestMapping(value = "/initLoad", method = RequestMethod.GET)
    public String getAllDetails(){
        List<User> userList = getUsers(0l);
        List<Fish> fishList = getFishes(0l);
        String result = "";
        result += userList.stream().map(Object::toString).collect(Collectors.joining("\r\n"));
        result +="\r\n" + fishList.stream().map(Object::toString).collect(Collectors.joining("\r\n"));
        return result;
    }


}
