package org.example;

class TicTacToe {

    private String currentPlayer = "X";
    private String [] board = new String[9];
    private String winner;


    public String getCurrentPlayer() {
        return currentPlayer;
    }
    public void makeMove(int position) {

        if (winner != null) {
            return;
        }
        if (position < 1 || position > 9) {
            return;
        }
        if (board[position - 1] == null) {
            String player = currentPlayer;
            board[position - 1] = player;


            if(hasWinner()) {
                winner = player;
            }

            if (currentPlayer.equals("X")) {
                currentPlayer = "O";
            } else {
                currentPlayer = "X";
            }
        }
    }

    public String getPosition(int position){
            return board[position - 1];
    }
    public boolean hasWinner() {
        return board[0] != null &&
                board[0].equals(board[1]) &&
                board[1].equals(board[2])
                ||
                (board[3] != null &&
                        board[3].equals(board[4]) &&
                        board[4].equals(board[5]))

                ||
                (board[6] != null &&
                        board[6].equals(board[7]) &&
                        board[7].equals(board[8]))
                ||
                (board[0] != null &&
                        board[0].equals(board[3]) &&
                        board[3].equals(board[6]))
                ||
                (board[1] != null &&
                        board[1].equals(board[4]) &&
                        board[4].equals(board[7]))

                ||
                (board[2] != null &&
                        board[2].equals(board[5]) &&
                        board[5].equals(board[8]))
                ||
                (board[0] != null &&
                        board[0].equals(board[4]) &&
                        board[4].equals(board[8]))
                ||
                (board[2] != null &&
                        board[2].equals(board[4]) &&
                        board[4].equals(board[6]));


    }
    public String getWinner() {
        return winner;
    }
    public boolean isDraw() {
        for (String position : board) {
            if (position == null) {
                return false;
            }
        }
        return !hasWinner();
    }

    @Test
    void noMovesCanBeMadeAfterADraw() {
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

        game.makeMove(1); // O tries to move after draw

        assertEquals("X", game.getPosition(1));
    }
}