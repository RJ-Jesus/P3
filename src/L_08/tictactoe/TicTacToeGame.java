package L_08.tictactoe;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGame {
	private JFrame frame;
	private Player player;
	private TicTacToeButton[][] board;
	private boolean isFinished;
	private Player winner;

	public TicTacToeGame(Player firstPlayer) {
		frame = new JFrame("Tic-Tac-Toe Game");
		frame.setPreferredSize(new Dimension(240, 240));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3, 3));
		player = firstPlayer;
		board = new TicTacToeButton[3][3];
		for (int i = 0, size = board.length; i < size; i++)
			for (int j = 0; j < size; j++)
				board[i][j] = new TicTacToeButton(i, j);
		frame.pack();
		frame.setVisible(true);
	}

	private boolean play(final int i, final int j) {
		if (isFinished)
			return false;
		if (board[i][j].getPlayer() != null)
			return false;
		board[i][j].setPlayer(player);
		board[i][j].setBackground(new Color(153, 204, 255));
		if (!(isFinished = isFinished(i, j)))
			player = player.other();
		return true;
	}

	private boolean isFinished(final int i, final int j) {
		if (checkWinInRow(i) || checkWinInCol(j) || checkWinInDia(i, j)) {
			winner = player;
			return true;
		}
		return isFull();
	}

	private boolean isFull() {
		for (int i = 0, c = 0, size = board.length; i < size; i++) {
			for (TicTacToeButton player : board[i])
				if (player.getPlayer() != null)
					c++;
				else
					break;
			if (c == size * size)
				return true;
		}
		return false;
	}

	private boolean checkWinInRow(final int i) {
		int j = 0, size = board[0].length;
		for (; j < size; j++)
			if (!player.equals(board[i][j].getPlayer()))
				break;
		return j == size;
	}

	private boolean checkWinInCol(final int j) {
		int i = 0, size = board.length;
		for (; i < size; i++)
			if (!player.equals(board[i][j].getPlayer()))
				break;
		return i == size;
	}

	private boolean checkWinInDia(final int i, final int j) {
		if (i != j && i != board.length - 1 - j)
			return false;
		Player middlePlayer = board[1][1].getPlayer();
		for (int k = 0, size = board.length; k < size && middlePlayer != null; k++) {
			if (!middlePlayer.equals(board[k][k].getPlayer()))
				break;
			if (k == size - 1)
				return true;
		}
		for (int k = 0, size = board.length; k < size && middlePlayer != null; k++) {
			if (!middlePlayer.equals(board[k][size - 1 - k].getPlayer()))
				break;
			if (k == size - 1)
				return true;
		}
		return false;
	}

    private class TicTacToeButton extends JButton implements ActionListener {
		private static final long serialVersionUID = 1L;
		private Player player;
		private final int i, j;

		TicTacToeButton(final int i, final int j) {
			super();
            this.i = i; this.j = j;
			setFont(new Font(getFont().getName(), Font.BOLD, 40));
			setForeground(Color.WHITE);
			this.addActionListener(this);
			frame.add(this);
		}

		Player getPlayer() {
			return player;
		}

		void setPlayer(final Player player) {
			this.player = player;
			setText(player.toString());
		}

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!play(i, j))
                if (winner != null)
                    javax.swing.JOptionPane.showMessageDialog(frame.getContentPane(), winner + " has won!");
                else if (isFinished)
                    javax.swing.JOptionPane.showMessageDialog(frame.getContentPane(), "Game ended as a tie.");
                else
                    javax.swing.JOptionPane.showMessageDialog(frame.getContentPane(), "Can't play there.");
            else if (winner != null)
                javax.swing.JOptionPane.showMessageDialog(frame.getContentPane(), winner + " has won!");
        }
    }

	public enum Player {
		X, O;
		static final int size = values().length;

		Player other() {
			return values()[(this.ordinal() + 1) % size];
		}
	}

}
