package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Set;

public class PlayerTest {

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
        Game game4 = store.publishGame("Путешествия по веткам Git", "Приключения");

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
    @Disabled
    public void shouldInstallOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        //HashMap<Game, Integer> playedTime = player.getPlayedTimeMap(); // добавить гетер в класс плеер
        //assertTrue(playedTime.containsKey(game));
    }

    @Test
    @Disabled
    public void shouldInstallMoreThanOneGame() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Java Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        //HashMap<Game, Integer> playedTime = player.getPlayedTimeMap(); // добавить гетер в класс плеер???
//        Set<Game> games = playedTime.keySet();
//
//        Set<Game> expected = Set.of(store.publishGame("Нетология Баттл Онлайн", "Аркады"),
//                store.publishGame("Java Баттл Онлайн", "Аркады"));
//        Set<Game> actual = games;
        //assertTrue(playedTime.containsKey(game1));
        //assertTrue(playedTime.containsKey(game2));
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
        player.play(game, 3);

        int expected = 4;
        int actual = player.play(game, 4);
        assertEquals(expected, actual);
    }

}