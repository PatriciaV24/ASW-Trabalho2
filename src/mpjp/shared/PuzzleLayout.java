package mpjp.shared;

import java.io.Serializable;
import java.lang.Integer;
import java.util.List;
import java.util.Map;

/**
 * Current puzzle layout, the status (position, rotation) of each piece, and the
 * blocks pieces fit together.
 *
 * @author Manuel Sá up201805273
 * @author Patricia Vieira up201805238
 */
public class PuzzleLayout implements Serializable {
	private static final long serialVersionUID = -8716432803274263011L;
	/** Map from block IDs (integers) to the list IDs of the pieces it contains */
	Map<Integer, List<Integer>> blocks;

	/** Percentage of the puzzle already solved ([0 - 100]) */
	int percentageSolved;

	/** Map from piece IDs (integers) to piece status */
	Map<Integer, PieceStatus> pieces;

	/** Constructor */
	public PuzzleLayout() {
	}

	/** Constructor-An instance created from fields */
	public PuzzleLayout(Map<Integer, PieceStatus> pieces, Map<Integer, List<Integer>> blocks, int percentageSolved) {
		this.blocks = blocks;
		this.percentageSolved = percentageSolved;
		this.pieces = pieces;
	}

	/**
	 * The list of pieces belonging to a block indexed by bloc id (a positive
	 * integer)
	 */
	public Map<Integer, List<Integer>> getBlocks() {
		return blocks;
	}

	/** Percentage in which puzzle is solved. */
	public int getPercentageSolved() {
		return percentageSolved;
	}

	/** Piece status indexed by their IDs */
	public Map<Integer, PieceStatus> getPieces() {
		return pieces;
	}

	/**
	 * The puzzle is complete when it has a single block When 2 pieces are fit
	 * together, they become part of the same block, as all the other pieces
	 * belonging to their blocks
	 */
	public boolean isSolved() {
		if (blocks.size() == 1)
			return true;
		return false;
	}
}
