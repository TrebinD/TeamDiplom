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

    @Test
    public void shouldMostPlayerByGenreIfDoNotPlay() {

        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Java-викторина", "Аркады");
        Game game3 = store.publishGame("Путешествие в мир авто-тестов", "Приключение");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.play(game1, 3);
        player.play(game2, 5);

        Game expected = null;
        Game actual = player.mostPlayerByGenre(game3.getGenre());

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfMoreThanOneGame() {
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

        int expected = 9;
        int actual = player.sumGenre(game1.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfMoreThanOneGameWithDifferentGenre() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Крутой java-программист", "Симуляторы");
        Game game3 = store.publishGame("Путешествие в мир авто-тестов", "Аркады");
        Game game4 = store.publishGame("Путешествие по веткам Git", "Приключения");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.installGame(game4);
        player.play(game1, 3);
        player.play(game2, 4);
        player.play(game3, 1);
        player.play(game4, 7);

        int expected = 4;
        int actual = player.sumGenre(game1.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfoNotPlay() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Крутой java-программист", "Симуляторы");
        Game game3 = store.publishGame("Путешествие в мир авто-тестов", "Аркады");
        Game game4 = store.publishGame("Путешествие по веткам Git", "Приключения");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.installGame(game4);
        player.play(game1, 3);
        player.play(game3, 1);
        player.play(game4, 7);

        int expected = 0;
        int actual = player.sumGenre(game2.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldPlayIfOneTime() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Player player = new Player("Petya");
        player.installGame(game);

        int expected = 3;
        int actual = player.play(game, 3);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldPlayIfMoreThanOneTime() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 1);

        int expected = 4;
        int actual = player.play(game, 3);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldPlayIfMoreThanOneTimeDifferentGames() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Крутой java-программист", "Симуляторы");
        Game game3 = store.publishGame("Путешествие в мир авто-тестов", "Аркады");
        Game game4 = store.publishGame("Путешествие по веткам Git", "Приключения");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.installGame(game4);
        player.play(game1, 1);
        player.play(game2, 3);
        player.play(game1, 2);

        int expected = 8;
        int actual = player.play(game1, 5);;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldPlayIfDoNotInstallGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Player player = new Player("Petya");

        assertThrows(NotInstalledGame.class, () -> player.play(game, 1));
    }
}