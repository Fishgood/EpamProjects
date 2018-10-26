package project1.model;

import project1.model.Entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Data<T extends Candy> {

    public List<T> fillPresentWithRandomParams(int curWeight, int totalWeight){

        List<T> candies = new ArrayList<>();
        int tempWeight = curWeight;
        Random random = new Random();
        int[] params = new int[3];
        while (tempWeight != totalWeight){

            params[0] = random.nextInt(20);
            params[2] = (totalWeight >= tempWeight && totalWeight - tempWeight > 0
                    && totalWeight - tempWeight < 150)
                    ? random.nextInt(totalWeight - tempWeight)
                    : random.nextInt(150);
            params[1] = (params[2] >= 0 && params[2] <=1) ? 0 : random.nextInt(params[2]/2);

            if (totalWeight >= tempWeight && totalWeight - tempWeight > 0 && totalWeight - tempWeight < 25){
                params[2] = totalWeight - tempWeight;
                params[1] = (params[2] >= 0 && params[2] <=1) ? 0 : random.nextInt(params[2]/2);
            }

            switch (random.nextInt(5)){
                case 0:
                    candies.add((T)new Caramel(params[0], params[1], params[2]));
                    break;
                case 1:
                    candies.add((T)new Chocolate(params[0], params[1], params[2]));
                    break;
                case 2:
                    candies.add((T)new Iris(params[0], params[1], params[2]));
                    break;
                case 3:
                    candies.add((T)new Jelly(params[0], params[1], params[2]));
                    break;
                case 4:
                    candies.add((T)new Marshmallow(params[0], params[1], params[2]));
                    break;
            }
            tempWeight += params[2];
        }
        return candies;
    }

}
