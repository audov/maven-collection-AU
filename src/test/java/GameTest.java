import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    Player playerA = new Player(10, "Archer", 240);
    Player playerB = new Player(20, "Bingo", 200);
    Player playerC = new Player(30, "Cooper", 280);
    Player playerD = new Player(40, "Winston", 240);
    Player playerE = new Player(50, "Zoe", 300);

    Game game = new Game();

    @Test
    public void testWhenFirstPlayerLose() {

        game.register(playerA);
        game.register(playerC);

        int actual = game.round("Archer", "Cooper");
        int expected = 2;

        Assertions.assertEquals(actual, expected);
    }

    @Test

    public void testWhenFirstPlayerWin() {

        game.register(playerA);
        game.register(playerB);

        int actual = game.round("Archer", "Bingo");
        int expected = 1;

        Assertions.assertEquals(actual, expected);

    }

    @Test
    public void testWhenPlayersDraw() {

        game.register(playerA);
        game.register(playerD);

        int actual = game.round("Archer", "Winston");
        int expected = 0;

        Assertions.assertEquals(actual, expected);
        System.out.println(playerA.getId());
        System.out.println(playerD.getId());
    }

    @Test
    public void testIfPlayerNotExist() {

        game.register(playerD);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Winston", "Zoe"));
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Zoe", "Winston"));
    }
}
