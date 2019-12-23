import services.GameService;
import services.impl.GameServiceImpl;

public class RockPaperScissorsApplication {

    public static void main(String[] args) {
        GameService gameService = new GameServiceImpl();

        gameService.runGameWithFixLength();
        gameService.runGameWithVariableLength();
    }
}
