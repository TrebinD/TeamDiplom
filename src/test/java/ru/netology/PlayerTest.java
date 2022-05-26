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

    @Test
    public void shouldMostPlayerByGenre() {

        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Java-викторина", "Аркады");
        Game game3 = store.publishGame("Путешествие в мир авто-тестов", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.play(game1, 3);
        player.play(game2, 5);
        player.play(game3, 1);
        Game expected = game2;
        Game actual = player.mostPlayerByGenre(game3.getGenre());

        assertEquals(expected, actual);
    }
}