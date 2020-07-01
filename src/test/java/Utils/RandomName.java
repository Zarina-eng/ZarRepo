package Utils;

import java.util.Random;

public class RandomName {


    public static String getRandomName() {


        Random random = new Random();

        String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        int upperBound = 26;


        String Name = "";



        for (int i = 0; i < 5; i++) {

            Name += alphabet[random.nextInt(upperBound)];

        }
        return Name;


    }
}
