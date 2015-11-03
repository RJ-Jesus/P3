package L_08.millionaire;

public class Question implements Comparable<Question> {
	private String imgPath;
	private String questText;
	private String questAnswer;
	private String[] options;
	private int difficulty;
	private int prize;

	public Question(String imgPath, String questText, String questAnswer, int difficulty, String... options) {
		this.imgPath = imgPath;
		this.questText = questText;
		this.questAnswer = questAnswer;
		this.difficulty = difficulty;
		this.options = Parser.scrambleArray(options);
	}

	String getImgPath() {
		return imgPath;
	}

	String getQuestText() {
		return questText;
	}

	String getQuestAnswer() {
		return questAnswer;
	}

	String[] getOptions() {
		return options;
	}
	
	String getOption(final int i) {
		return options[i];
	}

	int getDifficulty() {
		return difficulty;
	}

	@Override
	public int compareTo(final Question q) {
		int thisVal = difficulty, otherVal = q.difficulty;
		return thisVal < otherVal ? -1 : (thisVal == otherVal ? 0 : 1);
	}

	int getPrize() {
		return prize;
	}

	void setPrize(int prize) {
		this.prize = prize;
	}

}
