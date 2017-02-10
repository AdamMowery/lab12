/**
 * Created by adamm on 2/10/2017.
 */
public class DumbPlayer extends Player {
    public DumbPlayer(String name) {
        super(name);
    }

    @Override
    public int generateRoshamboValue() {
        return 1;
    }
}
