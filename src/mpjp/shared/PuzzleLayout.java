package mpjp.shared;

import java.io.Serializable;
import java.lang.Integer;
import java.util.List;
import java.util.Map;

public class PuzzleLayout implements Serializable {
	private static final long serialVersionUID = -8716432803274263011L;
	Map<Integer, List<Integer>> blocks; //Mapeie a partir de IDs de bloco (inteiros) para a lista de IDs das peças que ele contém
	int percentageSolved;  //Percentagem já resolvido ([0 - 100])
	Map<Integer, PieceStatus> pieces;

	public PuzzleLayout() {}

	public PuzzleLayout(Map<Integer, PieceStatus > pieces, Map<Integer, List<Integer>> blocks , int percentageSolved) {
		this.blocks = blocks;
		this.percentageSolved = percentageSolved;
		this.pieces = pieces;
	}



	public Map<Integer, List<Integer>> getBlocks() {
		return blocks;
	}

	public int getPercentageSolved() {
		return percentageSolved;
	}

	public Map<Integer, PieceStatus> getPieces() {
		return pieces;
	}

	boolean isSolved() {
		if (blocks.size()==1)
			return true;
		return false;
	}

}
