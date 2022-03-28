package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Player;
import ru.netology.exception.NotRegisteredException;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game = new Game();

    private Player first = new Player(1, "first", 1);
    private Player second = new Player(2, "second", 2);
    private Player third = new Player(3, "third", 3);
    private Player forth = new Player(4, "forth", 3);
    private Player fifth = new Player(5, "fifth", 10);
    private Player sixth = new Player(6, "sixth", 9);


    @BeforeEach
    void setUp() {
        game.register(first);
        game.register(second);
        game.register(third);
        game.register(forth);
    }

    @Test
    void shouldWinFirstPlayer() {

        int actual = game.round(forth.getName(), second.getName());
        assertEquals(1, actual);
    }

    @Test
    void shouldWinSecondPlayer() {

        int actual = game.round(first.getName(), second.getName());
        assertEquals(2, actual);
    }

    @Test
    void shouldDraw() {

        int actual = game.round(third.getName(), forth.getName());
        assertEquals(0, actual);
    }

    @Test
    void shouldOneNotRegisteredException() {

        assertThrows(NotRegisteredException.class, () -> game.round(third.getName(), fifth.getName()));
    }

    @Test
    void shouldOneBothNotRegisteredException() {

        assertThrows(NotRegisteredException.class, () -> game.round(fifth.getName(), sixth.getName()));
    }
}