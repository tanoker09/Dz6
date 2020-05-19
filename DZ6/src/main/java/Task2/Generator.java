package Task2;

import java.util.Random;

public interface Generator {

    default int newRandomInt(int min, int max){
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }


}
