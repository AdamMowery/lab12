
import java.util.Scanner;

public class Main {

    private enum Roshambo {Rock, Paper, Scissors}

    private static Scanner scnr = new Scanner(System.in);
    private static int userWins;
    private static int cpuWin;

    public static void main(String[] args) {
        int exit;
        DumbPlayer player1 = new DumbPlayer("Bob");
        RandomPlayer player2 = new RandomPlayer("Steve");
        System.out.println("Whats your name?");
        String player3 = scnr.nextLine();
        User user = new User(player3);

        do {


            int p1 = player1.generateRoshamboValue();
            String player1Answer = options(p1);
            int p2 = player2.generateRoshamboValue();
            String player2Answer = options(p2);
            int choice = instructions();
            int p3 = user.generateRoshamboValue();
            String player3Answer = options(p3);

            switch (choice) {
                case 3: {
                    //player1
                    twoPlayerGame(player1Answer, player3Answer);
                    break;
                }
                case 4: {
                    //player2
                    twoPlayerGame(player2Answer, player3Answer);
                    break;
                }
            }
            System.out.println("the computer has won " + cpuWin + " times you have won " + userWins + " times");
            System.out.println("Would you like to play again?\n(1. Yes/2. No)");
            exit = scnr.nextInt();
            scnr.nextLine();
        } while (exit == 1);
    }

    private static String options(int number) {
        if (number < 4) {
            switch (number) {
                case 1: {
                    return Roshambo.Rock.toString();
                }
                case 2: {
                    return Roshambo.Paper.toString();

                }
                case 3: {
                    return Roshambo.Scissors.toString();

                }

            }
        }
        return null;
    }

    private static int instructions() {

        System.out.println(" ");

        System.out.println("Would you like to play against player 1 or 2 ?");
        int input = scnr.nextInt();
        scnr.nextLine();
        if (input == 1) {
            return 3;
        }
        return 4;
    }


    private static void twoPlayerGame(String player1Answer, String player2Answer) {
        int p1Count = 0;
        int p2Count = 0;
        if (!player1Answer.equalsIgnoreCase(player2Answer)) {
            if (player1Answer.equalsIgnoreCase("rock") && !player2Answer.equalsIgnoreCase("Paper")) {
                p1Count += 1;
            } else if (player1Answer.equalsIgnoreCase("paper") && !player2Answer.equalsIgnoreCase("scissors")) {
                p1Count += 1;
            } else if (player1Answer.equalsIgnoreCase("scissors") && !player2Answer.equalsIgnoreCase("rock")) {
                p1Count += 1;
            } else if (player2Answer.equalsIgnoreCase("rock") && !player1Answer.equalsIgnoreCase("Paper")) {
                p2Count += 1;
            } else if (player2Answer.equalsIgnoreCase("paper") && !player1Answer.equalsIgnoreCase("scissors")) {
                p2Count += 1;
            } else if (player2Answer.equalsIgnoreCase("scissors") && !player1Answer.equalsIgnoreCase("rock")) {
                p2Count += 1;
            }


        }
        if (p1Count > p2Count) {
            System.out.println("player 1 won with " + player1Answer);
            cpuWin++;
        }
        if (p2Count > p1Count) {
            System.out.println("you won with " + player2Answer);
            userWins++;
        }
        if (p2Count == p1Count) {
            System.out.println("tie");
        }

    }


}
