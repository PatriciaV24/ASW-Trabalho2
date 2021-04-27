package mpjp.shared;

import java.util.Date;

public class PuzzleSelectInfo extends PuzzleInfo {
	private static final long serialVersionUID = 6065465073995979725L;
	int percentageSolved;
	Date start;

	public PuzzleSelectInfo() {}

	// ver poque de puzzle info aqui
	public PuzzleSelectInfo(PuzzleInfo info, int percentageSolved, Date start) {
		this.percentageSolved = percentageSolved;
		this.start = start;
	}

	public int getPercentageSolved() {
		return percentageSolved;
	}

	public Date getStart() {
		return start;
	}
}
