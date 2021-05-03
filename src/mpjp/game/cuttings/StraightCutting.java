package mpjp.game.cuttings;

import java.util.HashMap;
import java.util.Map;

import mpjp.game.PuzzleStructure;
import mpjp.shared.geom.LineTo;
import mpjp.shared.geom.PieceShape;
import mpjp.shared.geom.Point;

/**
 * This is a very simple cutting where each piece is just a rectangle wit its
 * center at the origin (0,0). Hence, all shapes are equal, independently of the
 * piece id. They all have an initial point and 4 (straight) lines. To represent
 * lines the shape should use lines LineTo.
 * 
 * @author Manuel Sá up201805273
 * @author Patricia Vieira up201805238
 */
public class StraightCutting implements Cutting {
	
	/** Constructor-An empty instance */
	public StraightCutting() {
		super();
	}

	public Map<Integer, PieceShape> getShapes(PuzzleStructure structure) {
		Map<Integer, PieceShape> map = new HashMap<Integer, PieceShape>();

		int rows = structure.getRows();
		int cols = structure.getColumns();
		double x = structure.getPieceWidth() / 2;
		double y = structure.getPieceHeight() / 2;

		Point BotRigh = new Point(x, y);
		Point BotLeft = new Point(-x, y);
		Point TopRigh = new Point(-x, -y);
		Point TopLeft = new Point(x, -y);

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				PieceShape piece = new PieceShape(BotRigh) 
						.addSegment(new LineTo(BotLeft))
						.addSegment(new LineTo(TopRigh)) 
						.addSegment(new LineTo(TopLeft)) 
						.addSegment(new LineTo(BotRigh));
				map.put(r * cols + c, piece);
			}
		}
		return map;
	}
}
