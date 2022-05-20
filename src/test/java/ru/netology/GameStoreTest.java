package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("WarCraft", "Strategy");
        Game game3 = store.publishGame("MortalKombat", "action");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldAddGameOneGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }


    @Test
    public void shouldNotGame() {

        GameStore store = new GameStore();

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Game game2 = null;
        assertFalse(store.containsGame(game2));
    }

    @Test
    public void timeNotPlayer() {

        GameStore store = new GameStore();

        String expected = store.getMostPlayer();
        String actual = null;

        assertEquals(expected, actual);
    }

    @Test
    public void timeTwoPlayer() {

        GameStore store = new GameStore();

        Player player = new Player("Vasia");
        Player player2 = new Player("Gena");
        Game game1 = store.publishGame("MortalKombat", "Action");
        Game game2 = store.publishGame("SeaWar", "Logic");

        player.play(game1, 9);
        player2.play(game2, 7);

        String actual = store.getMostPlayer();
        String expected = "Vasia";

        assertEquals(expected, actual);
    }

    @Test
    public void timeMorePlayer() {

        GameStore store = new GameStore();
        GameStore store2 = new GameStore();
        Player player = new Player("Vasia");
        Player player2 = new Player("Gena");
        Player player3 = new Player("Petiya");
        Player player4 = new Player("Den");
        Game game1 = store.publishGame("MortalKombat", "Action");
        Game game2 = store2.publishGame("SeaWar", "Logic");

        player.play(game1, 1);
        player2.play(game2, 2);
        player3.play(game1, 12);
        player4.play(game2, 16);

        String actual = store.getMostPlayer();
        String expected = "Petiya";

        assertEquals(expected, actual);
    }

    @Test
    public void addPlayerTime() {

        GameStore store = new GameStore();
        GameStore store2 = new GameStore();
        Player player = new Player("Vasia");
        Player player2 = new Player("Gena");
        Player player3 = new Player("Petiya");
        Player player4 = new Player("Den");
        Game game1 = store.publishGame("MortalKombat", "Action");


        player.play(game1, 15);
        player2.play(game1, 26);
        player3.play(game1, 12);
        player4.play(game1, 16);
        player.play(game1, 12);

        String actual = store.getMostPlayer();
        String expected = "Vasia";

        assertEquals(expected, actual);
    }


    @Test
    public void allTimePlayed() {

        GameStore store = new GameStore();
        Player player = new Player("Vasia");
        Player player2 = new Player("Gena");
        Player player3 = new Player("Petiya");
        Game game1 = store.publishGame("MortalKombat", "Action");
        Game game2 = store.publishGame("SeaWar", "Logic");

        player.play(game1, 1);
        player2.play(game2, 2);
        player3.play(game1, 7);

        int actual = store.getSumPlayedTime();
        int expected = 10;

        assertEquals(expected, actual);
    }


    // другие ваши тесты
}
