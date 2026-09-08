package org.example;

class TicTacToe {

    private String currentPlayer = "X";
    private String[] board = new String[9];
    private String winner;


    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public void makeMove(int position) {

        if (winner != null) {
            return;
        }

        if (!isValidPosition(position)) {
            return;
        }

        if (isPositionAvailable(position)) {
            String player = currentPlayer;
            board[position - 1] = player;

            if (hasWinner()) {
                winner = player;
            }
            switchPlayer();
        }
    }

    public String getPosition(int position) {
        return board[position - 1];
    }

    public boolean hasWinner() {
        for (int[] combination : winningCombinations) {
            if (board[combination[0]] != null &&
                    board[combination[0]].equals(board[combination[1]]) &&
                    board[combination[1]].equals(board[combination[2]])) {
                return true;
            }
        }

        return false;
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

    private boolean isValidPosition(int position) {
        return position >= 1 && position <= 9;
    }

    private boolean isPositionAvailable(int position) {
        return board[position - 1] == null;
    }
    private void switchPlayer() {
        if (currentPlayer.equals("X")) {
            currentPlayer = "O";
        } else {
            currentPlayer = "X";
        }
    }
    private final int[][] winningCombinations = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}
    };

}