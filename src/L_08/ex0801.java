package L_08;

import L_08.tictactoe.TicTacToeGame;

public class ex0801 {

    public static void main(String[] args) {
        if (args.length == 1)
            new TicTacToeGame(TicTacToeGame.Player.valueOf(args[0].toUpperCase()));
        else
            new TicTacToeGame(TicTacToeGame.Player.X);
    }

}
