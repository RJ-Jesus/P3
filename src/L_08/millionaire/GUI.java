package L_08.millionaire;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GUI {
	private static final Dimension defaultDimension = new Dimension(200, 200);
	private Questions questions;
	private Question currentQuestion;
	private JFrame frame;
	private JLabel amount, picture;
	private JTextArea questionText;
	private JButton audience, phone, _50;
	private JRadioButton a, b, c, d;
	private JButton giveUp, confirm;
	private static Random rand = new Random();

	public GUI(final String questionsFName) throws IOException {
		questions = new Questions(questionsFName);
		currentQuestion = questions.getQuestion();
		frame = new JFrame("QQSM");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		initiateGUI(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
	}

	private void initiateGUI(final Container contentPane) throws IOException {
		if (!(contentPane.getLayout() instanceof BorderLayout)) {
			contentPane.add(new JLabel("Container doesn't use BorderLayout!"));
			return;
		}

		amount = new JLabel(String.valueOf(currentQuestion.getPrize()), SwingConstants.CENTER);
		contentPane.add(amount, BorderLayout.PAGE_START);

		picture = new JLabel(
				new ImageIcon(ImageIO.read(new File(currentQuestion.getImgPath())).getScaledInstance(200, 200, 0)));
		picture.setPreferredSize(defaultDimension);
		contentPane.add(picture, BorderLayout.LINE_START);

		questionText = new JTextArea(currentQuestion.getQuestText());
		questionText.setPreferredSize(defaultDimension);
		questionText.setEditable(false);
		questionText.setLineWrap(true);
		questionText.setWrapStyleWord(true);
		questionText.setFont(questionText.getFont().deriveFont(20f));
		contentPane.add(questionText, BorderLayout.CENTER);

		a = new JRadioButton("<html>" + currentQuestion.getOption(0) + "</html>");
		b = new JRadioButton("<html>" + currentQuestion.getOption(1) + "</html>");
		c = new JRadioButton("<html>" + currentQuestion.getOption(2) + "</html>");
		d = new JRadioButton("<html>" + currentQuestion.getOption(3) + "</html>");
		ButtonGroup group = new ButtonGroup();
		group.add(a);
		group.add(b);
		group.add(c);
		group.add(d);
		JPanel radioPanel = new JPanel(new GridLayout(2, 2));
		radioPanel.setPreferredSize(defaultDimension);
		radioPanel.add(a);
		radioPanel.add(b);
		radioPanel.add(c);
		radioPanel.add(d);
		contentPane.add(radioPanel, BorderLayout.LINE_END);

		audience = new JButton("Audience");
		phone = new JButton("Phone");
		_50 = new JButton("50-50");
		giveUp = new JButton("Give Up");
		confirm = new JButton("Confirm");
		JPanel helpPane = new JPanel();
		helpPane.add(audience);
		helpPane.add(phone);
		helpPane.add(_50);
		JPanel actionPane = new JPanel();
		actionPane.add(giveUp);
		actionPane.add(confirm);
		JPanel buttonPane = new JPanel(new BorderLayout());
		buttonPane.add(helpPane, BorderLayout.WEST);
		buttonPane.add(actionPane, BorderLayout.EAST);
		contentPane.add(buttonPane, BorderLayout.PAGE_END);

		confirm.addActionListener(e -> {
            for (JRadioButton button : new JRadioButton[] { a, b, c, d })
                if (button.isSelected())
                    if (isSolution(button))
                        try {
                            nextQuestionOrWin();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                            endGame();
                        }
                    else
                        lose();
        });

		giveUp.addActionListener(e -> endGame());

		audience.addActionListener(e -> audience());

		phone.addActionListener(e -> phone());

		_50.addActionListener(e -> _50());
	}

	private void displayNextQuestion() throws IOException {
		currentQuestion = questions.getQuestion();
		amount.setText(String.valueOf(currentQuestion.getPrize()));
		picture.setIcon(new ImageIcon(ImageIO.read(new File(currentQuestion.getImgPath()))));
		questionText.setText(currentQuestion.getQuestText());
		a.setText("<html>" + currentQuestion.getOption(0) + "</html>");
		a.setEnabled(true);
		b.setText("<html>" + currentQuestion.getOption(1) + "</html>");
		b.setEnabled(true);
		c.setText("<html>" + currentQuestion.getOption(2) + "</html>");
		c.setEnabled(true);
		d.setText("<html>" + currentQuestion.getOption(3) + "</html>");
		d.setEnabled(true);
	}

	private void _50() {
		int i = 2;
		JRadioButton[] buttons = { a, b, c, d };
		while (i != 0) {
			int idx = rand.nextInt(buttons.length);
			if(buttons[idx].isEnabled() && !isSolution(buttons[idx])){
				buttons[idx].setEnabled(false);
				i--;
			}
		}
		_50.setEnabled(false);
	}

	private boolean isSolution(JRadioButton button) {
		return currentQuestion.getQuestAnswer().equals(getButtonText(button));
	}

	private void phone() {
		JRadioButton[] arr = new JRadioButton[2];
		JRadioButton[] buttons = { a, b, c, d };
		int i = 0;
		while(i != 2){
			int idx = rand.nextInt(buttons.length);
			if(i == 0 || arr[i-1] != buttons[idx])
				arr[i++] = buttons[idx];
		}
		String textMessage = "I thinks it is...";
		for(JRadioButton b : arr)
			textMessage += "\n" + getButtonText(b);
		JOptionPane.showMessageDialog(frame.getContentPane(), textMessage);
		phone.setEnabled(false);
	}
	
	private String getButtonText(JRadioButton b){
		String buttonText = b.getText();
		return buttonText.substring(6, buttonText.length() - 7);
	}

	private void audience() {
		JRadioButton[] buttons = {a, b, c, d};
		int max = 100;
		int[] vals = new int[buttons.length];
		for(int i = 0; i < vals.length; i++)
			max -= (vals[i] = rand.nextInt(max));
		int idx = 0;
		String textMessage = "Audience results:";
		for(JRadioButton bt : new JRadioButton[] {a, b, c, d})
			textMessage += "\n" + vals[idx++] + "% - " + getButtonText(bt);
		JOptionPane.showMessageDialog(frame.getContentPane(), textMessage);
		audience.setEnabled(false);
	}

	private void nextQuestionOrWin() throws IOException {
		if (questions.noOtherQuestion())
			win();
		else {
			JOptionPane.showMessageDialog(frame.getContentPane(), "Correct! You may proceed to the next level.");
			displayNextQuestion();
		}
	}

	private void win() {
		JOptionPane.showMessageDialog(frame.getContentPane(),
				"You have won! Your grand prize is: " + currentQuestion.getPrize());
		endGame();
	}

	private void lose() {
		JOptionPane.showMessageDialog(frame.getContentPane(),
				"You have lost. Your prize is: " + questions.lastQuestionPrize());
		endGame();
	}

	private void endGame() {
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}

}
