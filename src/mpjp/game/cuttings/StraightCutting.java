package mpjp.game.cuttings;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import mpjp.game.PuzzleStructure;
import mpjp.shared.geom.PieceShape;

public class StraightCutting implements Cutting {

	public StraightCutting() {
		super();
	}

	public Map<Integer, PieceShape> getShapes(PuzzleStructure structure) {
		Map<Integer, PieceShape> map = new HashMap<Integer, PieceShape>();

		double centerPointX = structure.getPieceWidth() / 2;
		double centerPointY = structure.getPieceHeight() / 2;

		// TODO ver porque e que os pontos nao sao criados
		Point topRight = new Point(centerPointX, centerPointY);
		Point TopLeft = new Point(-centerPointX, centerPointY);

		Point BottomRight = new Point(centerPointX, -centerPointY);
		Point BottomLeft = new Point(-centerPointX, -centerPointY);

		PieceShape piece = new PieceShape();
		// TODO adicionar os pontos ao piece

		for (int i = 0; i < structure.getPieceCount(); i++)
			map.put(i, piece);
		return map;
	}
}
