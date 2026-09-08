package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        TicTacToe game = new TicTacToe();


        System.out.println(" 1 | 2 | 3 ");
        System.out.println("---+---+---");
        System.out.println(" 4 | 5 | 6 ");
        System.out.println("---+---+---");
        System.out.println(" 7 | 8 | 9 ");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Tic Tac Toe");
        while (game.getWinner() == null && !game.isDraw()) {

            System.out.println("Player " + game.getCurrentPlayer() + ", choose a position:");

            int position = scanner.nextInt();

            game.makeMove(position);

            System.out.println(
                    " " + displayPosition(game, 1) + " | "
                            + displayPosition(game, 2) + " | "
                            + displayPosition(game, 3)
            );
            System.out.println("---+---+---");
            System.out.println(
                    " " + displayPosition(game, 4) + " | "
                            + displayPosition(game, 5) + " | "
                            + displayPosition(game, 6)
            );
            System.out.println("---+---+---");
            System.out.println(
                    " " + displayPosition(game, 7) + " | "
                            + displayPosition(game, 8) + " | "
                            + displayPosition(game, 9)
            );
        }
        if (game.getWinner() != null) {
            System.out.println("Player " + game.getWinner() + " wins!");
        } else {
            System.out.println("It's a draw!");
        }

    }
    private static String displayPosition(TicTacToe game, int position) {
        String value = game.getPosition(position);

        if (value == null) {
            return String.valueOf(position);
        }

        return value;
    }
}
