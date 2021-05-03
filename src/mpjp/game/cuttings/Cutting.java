package mpjp.game.cuttings;

import java.util.Map;

import mpjp.game.PuzzleStructure;
import mpjp.shared.geom.PieceShape;

/**
 * A Cutting provides a method to trace the boundaries o jigsaw puzzle pieces.
 * These boundaries are computed from a puzzle structure - specifying the
 * puzzle's dimensions (width and height) and the number of rows and columns.
 * the getShapes(PuzzleStructure) method return a map of piece ID (Integer) to
 * PieceShape
 * 
 * A specific cutting implements a strategy for tracing piece boundaries.
 * However, it should randomly generate different cuttings for each puzzle.
 * Ideally, 2 distinct puzzle pieces should be different enough to suggest only
 * valid connections, even in the absence of a image. That is, one should be
 * able to solve a blank puzzle using only the visual cues given by the cutting.
 * 
 * In the representation of each piece boundary, the origin of the coordinates
 * is its geometric center. Hence, two pieces with the same shape have the same
 * boundary representation. This approach enables piece positioning using
 * translations. The coordinate system is simply translated to the point where
 * the piece must be positioned and then it is drawn using this representation.
 *
 * @author Manuel Sá up201805273
 * @author Patricia Vieira up201805238
 */
public interface Cutting {
	Map<Integer, PieceShape> getShapes(PuzzleStructure structure);

}
