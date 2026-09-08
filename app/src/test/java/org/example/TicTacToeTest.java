package org.example;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;

class TicTacToeTest {

    //X starts the game

    @Test
    void gameStartsWithPlayerX() {
        TicTacToe game = new TicTacToe();
        assertEquals("X", game.getCurrentPlayer());
    }

    //X - O after a move

    @Test
    void turnChangestoPlayerOOncePlayerXTakesTheirTurn() {
        TicTacToe game = new TicTacToe();

        game.makeMove(1);

        assertEquals("O", game.getCurrentPlayer());
    }

    //O - X after a move

    @Test
    void turnChangesbacktoPlayerXOncePlayerOHasTakenTheirTurn() {
        TicTacToe game = new TicTacToe();

        game.makeMove(1);
        game.makeMove(2);

        assertEquals("X", game.getCurrentPlayer());
    }

    //A player can claim a position

    @Test
    void PlayerXCanClaimAPosition() {
        TicTacToe game = new TicTacToe();

        game.makeMove(1);

        assertEquals("X", game.getPosition(1));
    }

    //An occupied position cannot be claimed

    @Test
    void PlayerCannotClaimAnOccupiedPosition() {
        TicTacToe game = new TicTacToe();

        game.makeMove(1);
        game.makeMove(1);

        assertEquals("X", game.getPosition(1));
    }

    //Cannot make move outside the board (only 9 positions)
    @Test
    void CannotMakeMoveOutsideBoard() {
        TicTacToe game = new TicTacToe();

        game.makeMove(10);

        assertEquals("X", game.getCurrentPlayer());
    }

    //Checking position 1-9 on board all work correctly

    @Test
    void PlayerCanClaimDifferentPositons() {
        TicTacToe game = new TicTacToe();

        game.makeMove(1);
        game.makeMove(2);

        assertEquals("X", game.getPosition(1));

        assertEquals("O", game.getPosition(2));
    }


    //Checking Player X can win with top row

    @Test
    void PlayerXCanWithTopRow() {
        TicTacToe game = new TicTacToe();
        game.makeMove(1); //X
        game.makeMove(7); //O
        game.makeMove(2); //X
        game.makeMove(5); //O
        game.makeMove(3); //X

        assertTrue(game.hasWinner());
    }

    //Checking Player X can win with middle row

    @Test
    void PlayerXCanWithMiddleRow() {
        TicTacToe game = new TicTacToe();
        game.makeMove(4); //X
        game.makeMove(3); //O
        game.makeMove(5); //X
        game.makeMove(1); //O
        game.makeMove(6); //X

        assertTrue(game.hasWinner());
    }
    //Checking Player X can win with bottom row

    @Test
    void PlayerXCanWithBottomRow() {
        TicTacToe game = new TicTacToe();
        game.makeMove(7); //X
        game.makeMove(3); //O
        game.makeMove(8); //X
        game.makeMove(1); //O
        game.makeMove(9); //X

        assertTrue(game.hasWinner());
    }

    //Checking Player X can win with right column

    @Test
    void PlayerXCanWithRightColumn() {
        TicTacToe game = new TicTacToe();
        game.makeMove(1); //X
        game.makeMove(3); //O
        game.makeMove(4); //X
        game.makeMove(2); //O
        game.makeMove(7); //X

        assertTrue(game.hasWinner());
    }

    //Checking Player X can win with middle column

    @Test
    void PlayerXCanWithMiddleColumn() {
        TicTacToe game = new TicTacToe();
        game.makeMove(2); //X
        game.makeMove(3); //O
        game.makeMove(5); //X
        game.makeMove(4); //O
        game.makeMove(8); //X

        assertTrue(game.hasWinner());
    }
    //Checking Player X can win with left column

    @Test
    void PlayerXCanWithLeftColumn() {
        TicTacToe game = new TicTacToe();
        game.makeMove(3); //X
        game.makeMove(1); //O
        game.makeMove(6); //X
        game.makeMove(4); //O
        game.makeMove(9); //X

        assertTrue(game.hasWinner());
    }

    //Checking Player X can win with diagonal

    @Test
    void PlayerXCanWithDiagonal() {
        TicTacToe game = new TicTacToe();
        game.makeMove(1); //X
        game.makeMove(2); //O
        game.makeMove(5); //X
        game.makeMove(4); //O
        game.makeMove(9); //X

        assertTrue(game.hasWinner());
    }

    //Checking Player X can win with reverse diagonal

    @Test
    void PlayerXCanWithReverseDiagonal() {
        TicTacToe game = new TicTacToe();
        game.makeMove(3); //X
        game.makeMove(2); //O
        game.makeMove(5); //X
        game.makeMove(4); //O
        game.makeMove(7); //X

        assertTrue(game.hasWinner());
    }

    //checking X is the winner

    @Test
    void PlayerXIsTheWinner() {
        TicTacToe game = new TicTacToe();

        game.makeMove(1); // X
        game.makeMove(4); // O
        game.makeMove(2); // X
        game.makeMove(5); // O
        game.makeMove(3); // X

        assertEquals("X", game.getWinner());

    }
    //Checking Player O can win with top row

    @Test
    void PlayerOCanWithTopRow() {
        TicTacToe game = new TicTacToe();
        game.makeMove(5); //X
        game.makeMove(1); //O
        game.makeMove(4); //X
        game.makeMove(2); //O
        game.makeMove(9); //X
        game.makeMove(3); //O

        assertTrue(game.hasWinner());
    }

    //Checking Player O can win with middle row

    @Test
    void PlayerOCanWithMiddleRow() {
        TicTacToe game = new TicTacToe();
        game.makeMove(1); //X
        game.makeMove(4); //O
        game.makeMove(2); //X
        game.makeMove(5); //O
        game.makeMove(9); //X
        game.makeMove(6); //O

        assertTrue(game.hasWinner());
    }

    //Checking Player O can win with bottom row

    @Test
    void PlayerOCanWithBottomRow() {
        TicTacToe game = new TicTacToe();
        game.makeMove(1); //X
        game.makeMove(7); //O
        game.makeMove(2); //X
        game.makeMove(8); //O
        game.makeMove(4); //X
        game.makeMove(9); //O

        assertTrue(game.hasWinner());
    }

    //Checking Player O can win with right column

    @Test
    void PlayerOCanWithRightColumn() {
        TicTacToe game = new TicTacToe();
        game.makeMove(3); //X
        game.makeMove(1); //O
        game.makeMove(2); //X
        game.makeMove(4); //O
        game.makeMove(6); //X
        game.makeMove(7); //O

        assertTrue(game.hasWinner());
    }

    //Checking Player O can win with middle column

    @Test
    void PlayerOCanWithMiddleColumn() {
        TicTacToe game = new TicTacToe();
        game.makeMove(1); //X
        game.makeMove(2); //O
        game.makeMove(6); //X
        game.makeMove(5); //O
        game.makeMove(4); //X
        game.makeMove(8); //O

        assertTrue(game.hasWinner());
    }

    //Checking Player O can win with left column

    @Test
    void PlayerOCanWithLeftColumn() {
        TicTacToe game = new TicTacToe();
        game.makeMove(1); //X
        game.makeMove(3); //O
        game.makeMove(2); //X
        game.makeMove(6); //O
        game.makeMove(4); //X
        game.makeMove(9); //O

        assertTrue(game.hasWinner());
    }
    //Checking Player 0 can win with diagonal

    @Test
    void Player0CanWithDiagonal() {
        TicTacToe game = new TicTacToe();
        game.makeMove(7); //X
        game.makeMove(1); //O
        game.makeMove(2); //X
        game.makeMove(5); //O
        game.makeMove(4); //X
        game.makeMove(9); //O

        assertTrue(game.hasWinner());
    }

    //Checking Player X can win with reverse diagonal

    @Test
    void PlayerOCanWithReverseDiagonal() {
        TicTacToe game = new TicTacToe();
        game.makeMove(1); //X
        game.makeMove(3); //O
        game.makeMove(2); //X
        game.makeMove(5); //O
        game.makeMove(4); //X
        game.makeMove(7); //O

        assertTrue(game.hasWinner());
    }

    //checking O is the winner

    @Test
    void PlayerOIsTheWinner() {
        TicTacToe game = new TicTacToe();

        game.makeMove(5); //X
        game.makeMove(1); //O
        game.makeMove(4); //X
        game.makeMove(2); //O
        game.makeMove(9); //X
        game.makeMove(3); //O

        assertEquals("O", game.getWinner());

    }
    @Test
    void GameOverAfterThereIsAWinner() {
        TicTacToe game = new TicTacToe();

        game.makeMove(1); //X
        game.makeMove(7); //O
        game.makeMove(2); //X
        game.makeMove(5); //O
        game.makeMove(3); //X wins

        game.makeMove(6); // O tries to make move after X wins

        assertNull(game.getPosition(6));

    }

    @Test
    void gameIsADrawWhenAllPositionsAreFilledWithoutAWinner() {
        TicTacToe game = new TicTacToe();

        game.makeMove(1); // X
        game.makeMove(2); // O
        game.makeMove(3); // X
        game.makeMove(5); // O
        game.makeMove(4); // X
        game.makeMove(6); // O
        game.makeMove(8); // X
        game.makeMove(7); // O
        game.makeMove(9); // X

        assertTrue(game.isDraw());
    }
}

