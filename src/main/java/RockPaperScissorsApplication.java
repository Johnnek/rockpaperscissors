import services.GameService;
import services.impl.GameServiceImpl;

import java.util.Scanner;

public class RockPaperScissorsApplication {

    public static void main(String[] args) {
        GameService gameService = new GameServiceImpl();
        int input = 0;

        System.out.println("Do you want to start a game with a length of 100 rounds or variable length?");
        System.out.print("Type in 1 for 100 rounds or 2 for variable rounds: ");

        while (input == 0 || input > 2) {
            Scanner modeScanner = new Scanner(System.in);

            input = modeScanner.nextInt();

            if (input == 1) {
                gameService.runGame(100);
                break;
            } else if (input == 2) {
                System.out.println("How many rounds do you want to play?");
                Scanner roundScanner = new Scanner(System.in);
                int maxRounds = roundScanner.nextInt();
                gameService.runGame(maxRounds);
                break;
            } else System.out.print("Wrong input. Please choose between 1 or 2: ");
        }
    }
}
