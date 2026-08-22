package com.jmp.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class BowlingGameTest {
    // --------------------------------------------------------- // Basic game // ---------------------------------------------------------
    @Test
    void gutterGameScoresZero() {
        BowlingGame game = new BowlingGame();
        for (int i = 0; i < 20; i++) {
            game.roll(0);
        }
        assertEquals(0, game.score());
    }

    @Test
    void allOnesScoreTwenty() {
        BowlingGame game = new BowlingGame();
        for (int i = 0; i < 20; i++) {
            game.roll(1);
        }
        assertEquals(20, game.score());
    }

    // --------------------------------------------------------- // Open frame // ---------------------------------------------------------
    @Test
    void openFrameScoresSumOfPins() {
        BowlingGame game = new BowlingGame();
        game.roll(3);
        game.roll(4);
        // Remaining frames
        for (int i = 0; i < 18; i++) {
            game.roll(0);
        }
        assertEquals(7, game.score());
    }

    // --------------------------------------------------------- // Spare // ---------------------------------------------------------
    @Test
    void spareScoresTenPlusNextRoll() {
        BowlingGame game = new BowlingGame();
        game.roll(5);
        game.roll(5);
        game.roll(3);
        for (int i = 0; i < 17; i++) {
            game.roll(0);
        }
        assertEquals(16, game.score());
    }

    // --------------------------------------------------------- // Strike // ---------------------------------------------------------
    @Test
    void strikeScoresTenPlusNextTwoRolls() {
        BowlingGame game = new BowlingGame();
        game.roll(10);
        game.roll(3);
        game.roll(4);
        for (int i = 0; i < 15; i++) {
            game.roll(0);
        }
        assertEquals(24, game.score());
    }

    // --------------------------------------------------------- // Multiple strikes // ---------------------------------------------------------
    @Test
    void consecutiveStrikesAreScoredCorrectly() {
        BowlingGame game = new BowlingGame();
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(5);
        game.roll(0);
        for (int i = 0; i < 12; i++) {
            game.roll(0);
        }
        assertEquals(75, game.score());
    }

    // --------------------------------------------------------- // Perfect game // ---------------------------------------------------------
    @Test
    void perfectGameScoresThreeHundred() {
        BowlingGame game = new BowlingGame();
        // 12 strikes
        for (int i = 0; i < 12; i++) {
            game.roll(10);
        }
        assertEquals(300, game.score());
    }

    // --------------------------------------------------------- // Mixed game // ---------------------------------------------------------
    @Test
    void mixedGameIsScoredCorrectly() {
        BowlingGame game = new BowlingGame();
        int[] rolls = {1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 8, 6};
        for (int pins : rolls) {
            game.roll(pins);
        }
        assertEquals(133, game.score());
    }

    // --------------------------------------------------------- // Invalid input // ---------------------------------------------------------
    @Test
    void negativePinsAreRejected() {
        BowlingGame game = new BowlingGame();
        assertThrows(IllegalArgumentException.class, () -> game.roll(-1));
    }

    @Test
    void moreThanTenPinsAreRejected() {
        BowlingGame game = new BowlingGame();
        assertThrows(IllegalArgumentException.class, () -> game.roll(11));
    }
}
