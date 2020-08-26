package reasearch;

import java.util.Random;

public class CalculateMould {



    public static void main(String[] args) throws InterruptedException {
        long uid = 30000000L;

        Random random = new Random();

        Long value;
        int result;

        while (true) {
            value = random.nextLong();
            System.out.println(value);
            result =  (value.hashCode()%20);
            System.out.println(result);
            if(result == 20) {
                break;
            }
            Thread.sleep(1000);
        }
    }

}
