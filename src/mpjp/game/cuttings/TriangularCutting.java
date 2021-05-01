package mpjp.game.cuttings;

import java.util.HashMap;
import java.util.Map;

import mpjp.game.PuzzleStructure;
import mpjp.shared.geom.LineTo;
import mpjp.shared.geom.PieceShape;
import mpjp.shared.geom.Point;

public class TriangularCutting
implements Cutting{

	public TriangularCutting() {
		
	}
	
	public Map<Integer, PieceShape> getShapes(PuzzleStructure structure) {
		Map<Integer, PieceShape> map = new HashMap<Integer, PieceShape>(); // ID e PEÇA

		int rows = structure.getRows();
		int cols = structure.getColumns();
		double x = structure.getPieceWidth() / 2;
		double y = structure.getPieceHeight() / 2;

		PieceShape star = new PieceShape(new Point(x, y)).addSegment(new LineTo(new Point(0, y / 2)))
				.addSegment(new LineTo(new Point(-x, y))).addSegment(new LineTo(new Point(-x / 2, 0)))
				.addSegment(new LineTo(new Point(-x, -y))).addSegment(new LineTo(new Point(0, -y / 2)))
				.addSegment(new LineTo(new Point(x, -y))).addSegment(new LineTo(new Point(x / 2, 0)))
				.addSegment(new LineTo(new Point(x, y)));

		PieceShape starTop = new PieceShape(new Point(x, y)).addSegment(new LineTo(new Point(0, y / 2)))
				.addSegment(new LineTo(new Point(-x, y))).addSegment(new LineTo(new Point(-x / 2, 0)))
				.addSegment(new LineTo(new Point(-x, -y))).addSegment(new LineTo(new Point(x / 2, -y)))
				.addSegment(new LineTo(new Point(x, -y))).addSegment(new LineTo(new Point(x / 2, 0)))
				.addSegment(new LineTo(new Point(x, y)));

		PieceShape starBot = new PieceShape(new Point(x, y)).addSegment(new LineTo(new Point(x / 2, y)))
				.addSegment(new LineTo(new Point(-x, y))).addSegment(new LineTo(new Point(-x / 2, 0)))
				.addSegment(new LineTo(new Point(-x, -y))).addSegment(new LineTo(new Point(0, -y / 2)))
				.addSegment(new LineTo(new Point(x, -y))).addSegment(new LineTo(new Point(x / 2, 0)))
				.addSegment(new LineTo(new Point(x, y)));

		PieceShape starLeft = new PieceShape(new Point(x, y)).addSegment(new LineTo(new Point(0, y / 2)))
				.addSegment(new LineTo(new Point(-x, y))).addSegment(new LineTo(new Point(-x, y / 2)))
				.addSegment(new LineTo(new Point(-x, -y))).addSegment(new LineTo(new Point(0, -y / 2)))
				.addSegment(new LineTo(new Point(x, -y))).addSegment(new LineTo(new Point(x / 2, 0)))
				.addSegment(new LineTo(new Point(x, y)));

		PieceShape starRig = new PieceShape(new Point(x, y)).addSegment(new LineTo(new Point(0, y / 2)))
				.addSegment(new LineTo(new Point(-x, y))).addSegment(new LineTo(new Point(-x / 2, 0)))
				.addSegment(new LineTo(new Point(-x, -y))).addSegment(new LineTo(new Point(0, -y / 2)))
				.addSegment(new LineTo(new Point(x, -y))).addSegment(new LineTo(new Point(x, y / 2)))
				.addSegment(new LineTo(new Point(x, y)));

		PieceShape starTopLeft = new PieceShape(new Point(x, y)).addSegment(new LineTo(new Point(0, y / 2)))
				.addSegment(new LineTo(new Point(-x, y))).addSegment(new LineTo(new Point(-x, y / 2)))
				.addSegment(new LineTo(new Point(-x, -y))).addSegment(new LineTo(new Point(0, -y)))
				.addSegment(new LineTo(new Point(x, -y))).addSegment(new LineTo(new Point(x / 2, 0)))
				.addSegment(new LineTo(new Point(x, y)));

		PieceShape starTopRig = new PieceShape(new Point(x, y)).addSegment(new LineTo(new Point(0, y / 2)))
				.addSegment(new LineTo(new Point(-x, y))).addSegment(new LineTo(new Point(-x / 2, 0)))
				.addSegment(new LineTo(new Point(-x, -y))).addSegment(new LineTo(new Point(x / 2, -y)))
				.addSegment(new LineTo(new Point(x, -y))).addSegment(new LineTo(new Point(x, y / 2)))
				.addSegment(new LineTo(new Point(x, y)));

		PieceShape starBotLeft = new PieceShape(new Point(x, y)).addSegment(new LineTo(new Point(x / 2, y)))
				.addSegment(new LineTo(new Point(-x, y))).addSegment(new LineTo(new Point(-x, y / 2)))
				.addSegment(new LineTo(new Point(-x, -y))).addSegment(new LineTo(new Point(0, -y / 2)))
				.addSegment(new LineTo(new Point(x, -y))).addSegment(new LineTo(new Point(x / 2, 0)))
				.addSegment(new LineTo(new Point(x, y)));

		PieceShape starBotRig = new PieceShape(new Point(x, y)).addSegment(new LineTo(new Point(x / 2, y)))
				.addSegment(new LineTo(new Point(-x, y))).addSegment(new LineTo(new Point(-x / 2, 0)))
				.addSegment(new LineTo(new Point(-x, -y))).addSegment(new LineTo(new Point(0, -y / 2)))
				.addSegment(new LineTo(new Point(x, -y))).addSegment(new LineTo(new Point(x, y / 2)))
				.addSegment(new LineTo(new Point(x, y)));

		PieceShape los = new PieceShape(new Point(x, y)).addSegment(new LineTo(new Point(0, y + y / 2)))
				.addSegment(new LineTo(new Point(-x, y))).addSegment(new LineTo(new Point(-x - x / 2, 0)))
				.addSegment(new LineTo(new Point(-x, -y))).addSegment(new LineTo(new Point(0, -y - y / 2)))
				.addSegment(new LineTo(new Point(x, -y))).addSegment(new LineTo(new Point(x + x / 2, 0)))
				.addSegment(new LineTo(new Point(x, y)));

		PieceShape losTop = new PieceShape(new Point(x, y)).addSegment(new LineTo(new Point(0, y + y / 2)))
				.addSegment(new LineTo(new Point(-x, y))).addSegment(new LineTo(new Point(-x - x / 2, 0)))
				.addSegment(new LineTo(new Point(-x, -y))).addSegment(new LineTo(new Point(x / 2, -y)))
				.addSegment(new LineTo(new Point(x, -y))).addSegment(new LineTo(new Point(x + x / 2, 0)))
				.addSegment(new LineTo(new Point(x, y)));

		PieceShape losBot = new PieceShape(new Point(x, y)).addSegment(new LineTo(new Point(x / 2, y)))
				.addSegment(new LineTo(new Point(-x, y))).addSegment(new LineTo(new Point(-x - x / 2, 0)))
				.addSegment(new LineTo(new Point(-x, -y))).addSegment(new LineTo(new Point(0, -y - y / 2)))
				.addSegment(new LineTo(new Point(x, -y))).addSegment(new LineTo(new Point(x + x / 2, 0)))
				.addSegment(new LineTo(new Point(x, y)));

		PieceShape losLeft = new PieceShape(new Point(x, y)).addSegment(new LineTo(new Point(0, y + y / 2)))
				.addSegment(new LineTo(new Point(-x, y))).addSegment(new LineTo(new Point(-x, y / 2)))
				.addSegment(new LineTo(new Point(-x, -y))).addSegment(new LineTo(new Point(0, -y - y / 2)))
				.addSegment(new LineTo(new Point(x, -y))).addSegment(new LineTo(new Point(x + x / 2, 0)))
				.addSegment(new LineTo(new Point(x, y)));

		PieceShape losRig = new PieceShape(new Point(x, y)).addSegment(new LineTo(new Point(0, y + y / 2)))
				.addSegment(new LineTo(new Point(-x, y))).addSegment(new LineTo(new Point(-x - x / 2, 0)))
				.addSegment(new LineTo(new Point(-x, -y))).addSegment(new LineTo(new Point(0, -y - y / 2)))
				.addSegment(new LineTo(new Point(x, -y))).addSegment(new LineTo(new Point(x, y / 2)))
				.addSegment(new LineTo(new Point(x, y)));

		PieceShape losTopLeft = new PieceShape(new Point(x, y)).addSegment(new LineTo(new Point(0, y + y / 2)))
				.addSegment(new LineTo(new Point(-x, y))).addSegment(new LineTo(new Point(-x, y / 2)))
				.addSegment(new LineTo(new Point(-x, -y))).addSegment(new LineTo(new Point(x / 2, -y)))
				.addSegment(new LineTo(new Point(x, -y))).addSegment(new LineTo(new Point(x + x / 2, 0)))
				.addSegment(new LineTo(new Point(x, y)));

		PieceShape losTopRig = new PieceShape(new Point(x, y)).addSegment(new LineTo(new Point(0, y + y / 2)))
				.addSegment(new LineTo(new Point(-x, y))).addSegment(new LineTo(new Point(-x - x / 2, 0)))
				.addSegment(new LineTo(new Point(-x, -y))).addSegment(new LineTo(new Point(x / 2, -y)))
				.addSegment(new LineTo(new Point(x, -y))).addSegment(new LineTo(new Point(x, y / 2)))
				.addSegment(new LineTo(new Point(x, y)));

		PieceShape losBotLeft = new PieceShape(new Point(x, y)).addSegment(new LineTo(new Point(x / 2, y)))
				.addSegment(new LineTo(new Point(-x, y))).addSegment(new LineTo(new Point(-x, y / 2)))
				.addSegment(new LineTo(new Point(-x, -y))).addSegment(new LineTo(new Point(0, -y - y / 2)))
				.addSegment(new LineTo(new Point(x, -y))).addSegment(new LineTo(new Point(x + x / 2, 0)))
				.addSegment(new LineTo(new Point(x, y)));

		PieceShape losBotRig = new PieceShape(new Point(x, y)).addSegment(new LineTo(new Point(x / 2, y)))
				.addSegment(new LineTo(new Point(-x, y))).addSegment(new LineTo(new Point(-x - x / 2, 0)))
				.addSegment(new LineTo(new Point(-x, -y))).addSegment(new LineTo(new Point(0, -y - y / 2)))
				.addSegment(new LineTo(new Point(x, -y))).addSegment(new LineTo(new Point(x, y / 2)))
				.addSegment(new LineTo(new Point(x, y)));

		for (int c = 0; c < cols; c++) {
			for (int r = 0; r < rows; r++) {
				if (c % 2 == 0) {
					if (c == 0) {
						if (r == 0)
							map.put(r * cols + c, starTopLeft);
						else {
							if (r == rows - 1)
								if (r % 2 == 0)
									map.put(r * cols + c, starBotLeft);
								else
									map.put(r * cols + c, losBotLeft);
							else {
								if (r % 2 == 0)
									map.put(r * cols + c, starLeft);
								else
									map.put(r * cols + c, losLeft);
							}
						}
					} else {
						if (c == cols - 1) {
							if (r == 0)
								map.put(r * cols + c, starTopRig);
							else {
								if (r == rows - 1) {
									if (r % 2 == 0)
										map.put(r * cols + c, starBotRig);
									else
										map.put(r * cols + c, losBotRig);
								} else {
									if (r % 2 == 0)
										map.put(r * cols + c, starRig);
									else
										map.put(r * cols + c, losRig);
								}
							}
						} else {
							if (r == 0)
								map.put(r * cols + c, starTop);
							else {
								if (r == rows - 1)
									if (r % 2 == 0)
										map.put(r * cols + c, starBot);
									else
										map.put(r * cols + c, losBot);
								else {
									if (r % 2 == 0)
										map.put(r * cols + c, star);
									else
										map.put(r * cols + c, los);
								}
							}
						}
					}
				} else {
					if (c == 0) {
						if (r == 0)
							map.put(r * cols + c, losTopLeft);
						else {
							if (r == rows - 1)
								if (r % 2 == 0)
									map.put(r * cols + c, losBotLeft);
								else
									map.put(r * cols + c, starBotLeft);
							else {
								if (r % 2 == 0)
									map.put(r * cols + c, losLeft);
								else
									map.put(r * cols + c, starLeft);
							}
						}
					} else {
						if (c == cols - 1) {
							if (r == 0)
								map.put(r * cols + c, losTopRig);
							else {
								if (r == rows - 1) {
									if (r % 2 == 0)
										map.put(r * cols + c, losBotRig);
									else
										map.put(r * cols + c, starBotRig);
								} else {
									if (r % 2 == 0)
										map.put(r * cols + c, losRig);
									else
										map.put(r * cols + c, starRig);
								}
							}
						} else {
							if (r == 0)
								map.put(r * cols + c, losTop);
							else {
								if (r == rows - 1)
									if (r % 2 == 0)
										map.put(r * cols + c, losBot);
									else
										map.put(r * cols + c, starBot);
								else {
									if (r % 2 == 0)
										map.put(r * cols + c, los);
									else
										map.put(r * cols + c, star);
								}
							}
						}
					}
				}
			}
		}
		return map;
	}
}
