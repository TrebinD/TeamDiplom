package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class GameStoreTest {

    GameStore store = new GameStore();
    Player player = new Player("Petia");

    @Test
    public void shouldAddGame() {

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("WarCraft", "Strategy");
        Game game3 = store.publishGame("MortalKombat", "action");

        assertTrue(store.containsGame(game3));
    }

    @Test
    public void shouldAddGameOneGame() {

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldNotInstalledGame() {

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Game game2 = null;
        assertFalse(store.containsGame(game2));
    }

    @Test
    public void shouldNotGame() {

        Game game = null;
        assertFalse(store.containsGame(game));
    }

    @Test
    public void timeNotPlayer() {

        String expected = store.getMostPlayer();
        String actual = null;

        assertEquals(expected, actual);
    }

    @Test
    public void timeTwoPlayer() {

        store.addPlayTime("Vasia", 15);
        store.addPlayTime("Gena", 26);

        String actual = store.getMostPlayer();
        String expected = "Gena";

        assertEquals(expected, actual);
    }

    @Test
    public void timeMorePlayer() {

        store.addPlayTime("Vasia", 15);
        store.addPlayTime("Gena", 26);
        store.addPlayTime("Petia", 36);

        String actual = store.getMostPlayer();
        String expected = "Petia";

        assertEquals(expected, actual);
    }

    @Test
    public void timeMoreNotPlayer() {

        String actual = store.getMostPlayer();
        String expected = null;

        assertEquals(expected, actual);
    }

    @Test
    public void addPlayerTime() {

        store.addPlayTime("Vasia", 15);
        store.addPlayTime("Gena", 26);
        store.addPlayTime("Vasia", 12);

        String actual = store.getMostPlayer();
        String expected = "Vasia";

        assertEquals(expected, actual);
    }


    @Test
    public void allTimePlayed() {

        store.addPlayTime("Vasia", 2);
        store.addPlayTime("Gena", 3);

        int actual = store.getSumPlayedTime();
        int expected = 5;

        assertEquals(expected, actual);
    }

    @Test
    public void addTimePlayedWithClassPlayer() {

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        player.installGame(game);
        player.play(game, 7);

        int expected = 7;
        int actual = store.getSumPlayedTime();

        assertEquals(expected, actual);
    }

    @Test
    public void sumPlayedTimeWithClassPlayer() {
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        player.play(game, 7);
        player.play(game, 7);

        int expected = 14;
        int actual = store.getSumPlayedTime();

        assertEquals(expected, actual);
    }
}
