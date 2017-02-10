/**
 * Created by adamm on 2/10/2017.
 */
public abstract class Player {

    String name;


    public Player(String name) {
        this.name = name;

    }

    public abstract int generateRoshamboValue();
}
