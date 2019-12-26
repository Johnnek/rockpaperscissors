import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.GameService;
import services.impl.GameServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

class RockPaperScissorsApplication {

    private static Logger LOG = LoggerFactory.getLogger(RockPaperScissorsApplication.class);

    public static void main(String[] args) {
        GameService gameService = new GameServiceImpl();
        System.out.println("This application starts a Rock - Paper - Scissors game between two players.");
        System.out.println("You have to choose between two game modes. A game with a round length of 100 " +
                "or a game with variable round length. Do you want to start a game with a length of 100 rounds " +
                "or variable length?");

        boolean flag = false;
        int input = 0;

        // Run the while loop as long as no game has been played
        while (!flag) {
            if (input != 1 && input != 2) {
                Scanner modeScanner = new Scanner(System.in);
                try {
                    System.out.print("Type in the game mode (1 for 100 rounds, 2 for variable rounds or 9 to end the application): ");
                    input = modeScanner.nextInt();
                } catch (InputMismatchException inputMismatchException) {
                    LOG.info("", inputMismatchException);
                }
            }
            if (input == 1) {
                // Run game mode 1 and start a game with 100 rounds
                gameService.runGame(100);
                flag = true;
            } else if (input == 2) {
                // Run game mode 2 and start a game with variable rounds
                Scanner roundScanner = new Scanner(System.in);
                try {
                    System.out.print("Type in the rounds you want to play (Maximal rounds = 2147483647): ");
                    int maxRounds = roundScanner.nextInt();
                    gameService.runGame(maxRounds);
                    flag = true;
                } catch (InputMismatchException inputMismatchException) {
                    LOG.info("", inputMismatchException);
                }
            } else if (input == 9) flag = true;
            else System.out.print("Wrong input. ");
        }
    }
}
