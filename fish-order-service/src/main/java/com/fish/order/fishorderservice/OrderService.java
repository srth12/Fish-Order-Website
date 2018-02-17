package com.fish.order.fishorderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    //TODO
    public Fish getFishDetails(long fishId){
        return null;
    }

    //TODO
    public double getBalanceOfUser(long userId){
        return 0;
    }

    //TODO
    public boolean reduceBalanceOfUser(long userId, double amount){
        return false;
    }

    //TODO need to take care of concurrency as well
    public boolean updateFishCountAfterOrder(long fishId, int orderedFishCount){
        return false;
    }


    public boolean orderFish(long fishId, long userId, int quantity){
        Fish fish = getFishDetails(fishId);
        if (quantity >= fish.getQuantity() && getBalanceOfUser(userId) >= fish.getPrice() * quantity){ //not required, should remove as different service and won't be consistant
            boolean isUserBalanceUpdated = reduceBalanceOfUser(userId, fish.getPrice() * quantity);
            boolean isFishQuantityUpdated = updateFishCountAfterOrder(fishId, quantity);

            if (isFishQuantityUpdated & isUserBalanceUpdated)
                return true;
            else {
                //TODO need to rollback the updated value of fish quantity and balance
                return false;
            }
        }else {
            return false;
        }
    }

}
