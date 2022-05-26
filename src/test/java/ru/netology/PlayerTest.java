package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Set;

public class PlayerTest {

    // другие ваши тесты

    @Test
    public void shouldInstallOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");

        player.installGame(game);


        int expected = 1;
        int actual = player.play(game, 1);
        assertEquals(expected, actual);

    }


}
