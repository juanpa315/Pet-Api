package utils;

import java.util.Random;

public class idRandom {

    public static int generarIdCompra() {

        // Create a Random object
        Random random;
        random = new Random();
        int randomNumber;
        randomNumber = random.nextInt(1000000);
        return randomNumber;
    }

}
