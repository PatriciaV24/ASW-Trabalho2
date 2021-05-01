package mpjp.game.cuttings;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import mpjp.game.Direction;
import mpjp.game.PuzzleStructure;
import mpjp.shared.geom.PieceShape;

public class StandardCutting implements Cutting {

	public StandardCutting() {
		super();
	}

	public Map<Integer, PieceShape> getShapes(PuzzleStructure structure) {
		Map<Integer, PieceShape> map = new HashMap<Integer, PieceShape>();
		for (int i = 0; i < structure.getPieceCount(); i++) {

		}
		return map;
	}

	Point getMiddlePoint(int id, Direction direction) {
		Point p = new Point();
		return p;
	}

	Point getStartControlPoint1(int id, Direction direction) {
		Point p = new Point();
		return p;
	}

	Point getStartControlPoint2(int id, Direction direction) {
		Point p = new Point();
		return p;
	}

	Point getEndControlPoint1(int id, Direction direction) {
		Point p = new Point();
		return p;
	}

	Point getEndControlPoint2(int id, Direction direction) {
		Point p = new Point();
		return p;
	}

}
