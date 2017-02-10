import java.util.Scanner;

/**
 * Created by adamm on 2/10/2017.
 */
public class User extends Player{
private Scanner scnr = new Scanner(System.in);

    public User(String name) {
        super(name);
    }

    @Override
    public int generateRoshamboValue() {
        System.out.println("Pick the number that matches yout choice\n1.Rock\n2.Paper\n3.Scissors");
        int input = scnr.nextInt();
        scnr.nextLine();
        return input;
    }
}
