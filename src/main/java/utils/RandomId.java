package utils;

import java.util.Random;

public class RandomId {

    private static Random rand=new Random();

    public RandomId() {}


    public static int  getRandomId(int maxId) {
    return (1+rand.nextInt(maxId));
    }
}
