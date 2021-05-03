package mpjp.shared;

import java.util.Date;

/**
 * Information required to select a puzzle currently being solved. It will be
 * used by users to decide to join to an existing workspace. Most of the
 * information is the same used for workspace creation, thus it extends
 * PuzzleInfo. The extra information is the start date and the percentage of the
 * puzzle that is solved.
 * 
 * @author Manuel Sá up201805273
 * @author Patricia Vieira up201805238
 *
 */
public class PuzzleSelectInfo extends PuzzleInfo {
	private static final long serialVersionUID = 6065465073995979725L;
	/**Percentage of the puzzle solved ([0, 100])*/
	
	int percentageSolved;
	/**Moment when the jigsaw puzzle started being solved*/
	Date start;
	
	/** Constructor*/
	public PuzzleSelectInfo() {
		
	}

	/** Constructor-Creates an instance from a puzzle view and start date and percentage solved*/
	public PuzzleSelectInfo(PuzzleInfo info, int percentageSolved, Date start) {
		this.percentageSolved = percentageSolved;
		this.start = start;
	}

	/**Percentage of the puzzle that is solved, an integer in [0,100]
	 *@return percentageSolved
	 **/
	public int getPercentageSolved() {
		return percentageSolved;
	}

	/**
	 * The moment when the puzzle start being solved
	 * @return start
	 */
	public Date getStart() {
		return start;
	}
}
