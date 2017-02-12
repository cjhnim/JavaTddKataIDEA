package BowlingGame;

import BowlingGame.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by frank on 2017. 2. 12..
 */
class BowlingGameTest {

    @Test
    void 하나도못마침() {
        BowlingGame game = new BowlingGame();

        game.roll(0);
        assertEquals(0, game.score());
    }

    @Test
    void 한개의핀쓰러트림() {
        BowlingGame game = new BowlingGame();
        game.roll(1);
        assertEquals(1, game.score());
    }

    @Test
    void 스페어쳐보자() {
        BowlingGame game = new BowlingGame();

        game.roll(9);
        game.roll(1);
        game.roll(1);
        game.roll(0);
        assertEquals(12, game.score());
    }

    @Test
    void 스트라이크쳐보자() {
        BowlingGame game = new BowlingGame();

        game.roll(10);
        game.roll(1);
        game.roll(1);
        game.roll(0);
        assertEquals(14, game.score());
    }

    @Test
    void 퍼펙트게임() {
        BowlingGame game = new BowlingGame();
        rollMany(game, 10, 12);
        assertEquals(300, game.score());
    }

    private void rollMany(BowlingGame game, int pins, int count) {

        for (int i = 0; i < count; i++)
            game.roll(pins);
    }
}