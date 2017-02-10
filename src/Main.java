
import java.util.Scanner;

public class Main {

    private enum Roshambo {Rock, Paper, Scissors}

    private static int input;
    private static Scanner scnr = new Scanner(System.in);

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
                case 2: {
                    // Two players
                    threePlayers(player1Answer, player2Answer, player3Answer);
                    break;
                }
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
            System.out.println("Would you like to play again?\n(1. Yes/2. No)");
            exit = scnr.nextInt();
            scnr.nextLine();
        } while (exit == 1);
    }

    static String options(int number) {
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

    static int instructions() {

        System.out.println(" ");
        System.out.println("Would you like to play against 1 or 2 players?");
        input = scnr.nextInt();
        scnr.nextLine();
        if (input == 1) {
            System.out.println("Would you like to play against player 1 or 2 ?");
            input = scnr.nextInt();
            scnr.nextLine();
            if (input == 1) {
                return 3;
            } else {
                return 4;
            }
        }
        return input;
    }

    static void threePlayers(String player1Answer, String player2Answer, String player3Answer) {
        int p1Count = 0;
        int p2Count = 0;
        int p3Count = 0;
        if (player1Answer.equalsIgnoreCase("rock") && !player2Answer.equalsIgnoreCase("rock") && !player2Answer.equalsIgnoreCase("Paper")) {
            p1Count += 1;
        } else if (player1Answer !=player2Answer){
            p2Count += 1;
        }
        if (player1Answer.equalsIgnoreCase("rock") && !player3Answer.equalsIgnoreCase("rock") && !player3Answer.equalsIgnoreCase("Paper")) {
            p1Count += 1;
        } else if (player1Answer !=player3Answer){
            p3Count += 1;
        }
        if (player2Answer.equalsIgnoreCase("rock") && !player3Answer.equalsIgnoreCase("rock") && !player3Answer.equalsIgnoreCase("Paper")) {
            p2Count += 1;
        } else if (player2Answer !=player3Answer){
            p3Count += 1;
        }

        if (player1Answer.equalsIgnoreCase("paper") && !player2Answer.equalsIgnoreCase("paper") && !player2Answer.equalsIgnoreCase("scissors")) {
            p1Count += 1;
        } else if (player1Answer !=player2Answer){
            p2Count += 1;
        }
        if (player1Answer.equalsIgnoreCase("paper") && !player3Answer.equalsIgnoreCase("paper") && !player3Answer.equalsIgnoreCase("scissors")) {
            p1Count += 1;
        } else if (player1Answer !=player3Answer){
            p3Count += 1;
        }
        if (player2Answer.equalsIgnoreCase("paper") && !player3Answer.equalsIgnoreCase("paper") && !player3Answer.equalsIgnoreCase("scissors")) {
            p2Count += 1;
        } else if (player2Answer !=player3Answer){
            p3Count += 1;
        }

        if (player1Answer.equalsIgnoreCase("scissors") && !player2Answer.equalsIgnoreCase("scissors") && !player2Answer.equalsIgnoreCase("rock")) {
            p1Count += 1;
        } else if (player1Answer !=player2Answer){
            p2Count += 1;
        }
        if (player1Answer.equalsIgnoreCase("scissors") && !player3Answer.equalsIgnoreCase("scissors") && !player3Answer.equalsIgnoreCase("rock")) {
            p1Count += 1;
        } else if (player1Answer !=player3Answer){
            p3Count += 1;
        }
        if (player2Answer.equalsIgnoreCase("scissors") && !player3Answer.equalsIgnoreCase("scissors") && !player3Answer.equalsIgnoreCase("rock")) {
            p2Count += 1;
        } else if (player2Answer !=player3Answer){
            p3Count += 1;
        }

        if (p1Count > p2Count && p1Count > p3Count) {
            System.out.println("player 1 won with " + player1Answer);
        }
        if (p2Count > p1Count && p2Count > p3Count) {
            System.out.println("player 2 won with " + player2Answer);
        }
        if (p3Count > p1Count && p3Count > p3Count) {
            System.out.println("you won with " + player3Answer);
        }
    }

    static void twoPlayerGame(String player1Answer, String player2Answer) {
        int p1Count = 0;
        int p2Count = 0;

        if (player1Answer.equalsIgnoreCase("rock") && !player2Answer.equalsIgnoreCase("rock") && !player2Answer.equalsIgnoreCase("Paper")) {
            p1Count += 1;
        } else {
            p2Count += 1;
        }

        if (player1Answer.equalsIgnoreCase("paper") && !player2Answer.equalsIgnoreCase("paper") && !player2Answer.equalsIgnoreCase("scissors")) {
            p1Count += 1;
        } else {
            p2Count += 1;
        }

        if (player1Answer.equalsIgnoreCase("scissors") && !player2Answer.equalsIgnoreCase("scissors") && !player2Answer.equalsIgnoreCase("rock")) {
            p1Count += 1;
        } else {
            p2Count += 1;
        }

        if (p1Count > p2Count) {
            System.out.println("player 1 won with " + player1Answer);
        }
        if (p2Count > p1Count) {
            System.out.println("you won with " + player2Answer);
        }

    }


}
