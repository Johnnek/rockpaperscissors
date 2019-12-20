import services.Game;
import services.impl.GameImpl;

public class RockPaperScissorsApplication {

    public static void main(String[] args) {
        Game game = new GameImpl();

        game.runGame();
    }
}
