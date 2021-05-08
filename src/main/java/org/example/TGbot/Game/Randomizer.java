package org.example.TGbot.Game;


import java.util.HashSet;
import java.util.Random;

public class Randomizer {

    public static int[] randomizeQue(int number) {

        Random rand = new Random();


        int[] result = new int[number];
        int k = 0;
        int randomElement = number+5;
        HashSet<Integer> set = new HashSet();


        for (int i=0; i<number; i++){
            set.add(i);
        }

        while(!set.isEmpty()){
            while (!set.contains(randomElement)) {
                randomElement = rand.nextInt(number);
            }
            result[k] = randomElement;
            k++;
            set.remove(randomElement);
        }



        return result;



    }
}
