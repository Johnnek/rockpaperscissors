import services.GameService;
import services.impl.GameServiceImpl;

import java.util.Scanner;

class RockPaperScissorsApplication {

    public static void main(String[] args) {
        GameService gameService = new GameServiceImpl();
        int input = 0;
        System.out.println("This application starts a Rock - Paper - Scissors game between two players.");
        System.out.println("You have to choose between two game modes. A game with a round length of 100 " +
                "or a game with variable round length. Do you want to start a game with a length of 100 rounds " +
                "or variable length?");
        System.out.print("Type in 1 for 100 rounds or 2 for variable rounds: ");

        // while (input != 1 && input != 2)
        while (!(input > 0 && input < 3)) {

            Scanner modeScanner = new Scanner(System.in);
            input = modeScanner.nextInt();

            if (input == 1) {
                gameService.runGame(100);
            } else if (input == 2) {
                System.out.println("How many rounds do you want to play?");
                Scanner roundScanner = new Scanner(System.in);
                int maxRounds = roundScanner.nextInt();
                gameService.runGame(maxRounds);
            } else System.out.print("Wrong input. Please choose between 1 or 2: ");
        }
    }
}
