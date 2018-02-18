package com.fishy.dashboard.fishdashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RibbonClient(name = "fishy-user", configuration = UserConfiguration.class)
public class FishyDashboardController {

    @Autowired
    private DiscoveryClient discoveryClient;

    public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName){
        return this.discoveryClient.getInstances(applicationName);
    }

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


}
