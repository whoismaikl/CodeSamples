package minigames;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created by mihails_nikitins on 01.08.2016.
 */
public class UserGuesses {
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Random random = new Random();
        int rn = random.nextInt(100);
        int i=0;
        int guessCount = 0;

        System.out.println("Привет! Я загадал число от 1 до 100. Попробуй его отгадать! :)");
        while(i != rn){
            i = Integer.parseInt(reader.readLine());
            guessCount++;
            if (i > rn)
                System.out.println("Мое число меньше :P");
            else if (i < rn)
                System.out.println("Мое число больше :)");
        }
        System.out.println("Вы угадали! Загаданное число - " +rn + "\n" + "Число попыток - " + guessCount);
    }
}
