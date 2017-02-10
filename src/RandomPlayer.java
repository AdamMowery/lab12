import java.util.Random;

/**
 * Created by adamm on 2/10/2017.
 */
public class RandomPlayer extends Player{
    public RandomPlayer(String name) {
        super(name);
        int roshamboValue = generateRoshamboValue();
    }

    @Override
    public int generateRoshamboValue() {
        Random num = new Random();
        int rand = num.nextInt(3) + 1;
        return rand;
    }
}
