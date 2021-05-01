package mpjp.game.cuttings;


import java.util.HashMap;
import java.util.Map;

import mpjp.game.PuzzleStructure;
import mpjp.shared.geom.LineTo;
import mpjp.shared.geom.PieceShape;
import mpjp.shared.geom.Point;

public class StraightCutting implements Cutting {

	public StraightCutting() {
		super();
	}

	public Map<Integer, PieceShape> getShapes(PuzzleStructure structure) {
		Map<Integer, PieceShape> map = new HashMap<Integer, PieceShape>();

		double centerPointX = structure.getPieceWidth() / 2;
		double centerPointY = structure.getPieceHeight() / 2;

		Point  bottomRight = new Point(centerPointX, centerPointY);
		Point  topRight= new Point(-centerPointX, centerPointY);

		Point  bottomLeft = new Point(centerPointX, -centerPointY);
		Point  topLeft= new Point(-centerPointX, -centerPointY);

		
		PieceShape piece = new PieceShape();
		piece.setStartPoint(bottomRight);
		piece.addSegment(new LineTo(bottomLeft));
		piece.addSegment(new LineTo(topLeft));
		piece.addSegment(new LineTo(topRight));
	
		
		// TODO adicionar os pontos ao piece

		for (int i = 0; i < structure.getPieceCount(); i++)
			map.put(i, piece);
		return map;
	}
}
