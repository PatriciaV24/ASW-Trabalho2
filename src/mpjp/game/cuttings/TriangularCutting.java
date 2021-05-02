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

		Point begin = new Point(x, y);
		LineTo botRigh = new LineTo(new Point(x, y));
		LineTo botLeft = new LineTo(new Point(-x, y));
		LineTo topLeft = new LineTo(new Point(-x, -y)); // Right->Left
		LineTo topRigh = new LineTo(new Point(x, -y));

		LineTo botIn = new LineTo(new Point(0, y / 2));
		LineTo leftIn = new LineTo(new Point(-x / 2, 0));
		LineTo topIn = new LineTo(new Point(0, -y / 2));
		LineTo rigIn = new LineTo(new Point(x / 2, 0));

		LineTo botM = new LineTo(new Point(0, y));
		LineTo leftM = new LineTo(new Point(-x, 0));
		LineTo topM = new LineTo(new Point(0, -y));
		LineTo rigM = new LineTo(new Point(x, 0));

		LineTo botOut = new LineTo(new Point(0, y + y / 2));
		LineTo lefOut = new LineTo(new Point(-x - x / 2, 0));
		LineTo topOut = new LineTo(new Point(0, -y - y / 2));
		LineTo rigOut = new LineTo(new Point(x + x / 2, 0));

		/*Peça Estrela c/ várias alternativas*/
		PieceShape star = new PieceShape(begin)
				.addSegment(botIn)
				.addSegment(botLeft)
				.addSegment(leftIn)
				.addSegment(topLeft)
				.addSegment(topIn)
				.addSegment(topRigh)
				.addSegment(rigIn)
				.addSegment(botRigh);

		PieceShape starTop = new PieceShape(begin)
				.addSegment(botIn)
				.addSegment(botLeft)
				.addSegment(leftIn)
				.addSegment(topLeft)
				.addSegment(topM)
				.addSegment(topRigh)
				.addSegment(rigIn)
				.addSegment(botRigh);

		PieceShape starBot = new PieceShape(begin)
				.addSegment(botM)
				.addSegment(botLeft)
				.addSegment(leftIn)
				.addSegment(topLeft)
				.addSegment(topIn)
				.addSegment(topRigh)
				.addSegment(rigIn)
				.addSegment(botRigh);

		PieceShape starLeft = new PieceShape(begin)
				.addSegment(botIn)
				.addSegment(botLeft)
				.addSegment(leftM)
				.addSegment(topLeft)
				.addSegment(topIn)
				.addSegment(topRigh)
				.addSegment(rigIn)
				.addSegment(botRigh);

		PieceShape starRig = new PieceShape(begin)
				.addSegment(botIn)
				.addSegment(botLeft)
				.addSegment(leftIn)
				.addSegment(topLeft)
				.addSegment(topIn)
				.addSegment(topRigh)
				.addSegment(rigM)
				.addSegment(botRigh);

		PieceShape starTopLeft = new PieceShape(begin)
				.addSegment(botIn)
				.addSegment(botLeft)
				.addSegment(leftM)
				.addSegment(topLeft)
				.addSegment(topM)
				.addSegment(topRigh)
				.addSegment(rigIn)
				.addSegment(botRigh);

		PieceShape starTopRig = new PieceShape(begin)
				.addSegment(botIn)
				.addSegment(botLeft)
				.addSegment(leftIn)
				.addSegment(topLeft)
				.addSegment(topM)
				.addSegment(topRigh)
				.addSegment(rigM)
				.addSegment(botRigh);

		PieceShape starBotLeft = new PieceShape(begin)
				.addSegment(botM)
				.addSegment(botLeft)
				.addSegment(leftM)
				.addSegment(topLeft)
				.addSegment(topIn)
				.addSegment(topRigh)
				.addSegment(rigIn)
				.addSegment(botRigh);

		PieceShape starBotRig = new PieceShape(begin)
				.addSegment(botM)
				.addSegment(botLeft)
				.addSegment(leftIn)
				.addSegment(topLeft)
				.addSegment(topIn)
				.addSegment(topRigh)
				.addSegment(rigM)
				.addSegment(botRigh);

		/*Peça Losangulo c/ várias alternativas*/
		PieceShape los = new PieceShape(begin)
				.addSegment(botOut)
				.addSegment(botLeft)
				.addSegment(lefOut)
				.addSegment(topLeft)
				.addSegment(topOut)
				.addSegment(topRigh)
				.addSegment(rigOut)
				.addSegment(botRigh);

		PieceShape losTop = new PieceShape(begin)
				.addSegment(botOut)
				.addSegment(botLeft)
				.addSegment(lefOut)
				.addSegment(topLeft)
				.addSegment(topM)
				.addSegment(topRigh)
				.addSegment(rigOut)
				.addSegment(botRigh);

		PieceShape losBot = new PieceShape(begin)
				.addSegment(botM)
				.addSegment(botLeft)
				.addSegment(lefOut)
				.addSegment(topLeft)
				.addSegment(topOut)
				.addSegment(topRigh)
				.addSegment(rigOut)
				.addSegment(botRigh);

		PieceShape losLeft = new PieceShape(begin)
				.addSegment(botOut)
				.addSegment(botLeft)
				.addSegment(leftM)
				.addSegment(topLeft)
				.addSegment(topOut)
				.addSegment(topRigh)
				.addSegment(rigOut)
				.addSegment(botRigh);

		PieceShape losRig = new PieceShape(begin)
				.addSegment(botOut)
				.addSegment(botLeft)
				.addSegment(lefOut)
				.addSegment(topLeft)
				.addSegment(topOut)
				.addSegment(topRigh)
				.addSegment(rigM)
				.addSegment(botRigh);

		/*PieceShape losTopLeft = new PieceShape(begin)
				.addSegment(botOut)
				.addSegment(botLeft)
				.addSegment(leftM)
				.addSegment(topLeft)
				.addSegment(topM)
				.addSegment(topRigh)
				.addSegment(rigOut)
				.addSegment(botRigh);
		*/
	
		PieceShape losTopRig = new PieceShape(begin)
				.addSegment(botOut)
				.addSegment(botLeft)
				.addSegment(lefOut)
				.addSegment(topLeft)
				.addSegment(topM)
				.addSegment(topRigh)
				.addSegment(rigM)
				.addSegment(botRigh);

		PieceShape losBotLeft = new PieceShape(begin)
				.addSegment(botM)
				.addSegment(botLeft)
				.addSegment(leftM)
				.addSegment(topLeft)
				.addSegment(topOut)
				.addSegment(topRigh)
				.addSegment(rigOut)
				.addSegment(botRigh);

		PieceShape losBotRig = new PieceShape(begin)
				.addSegment(botM)
				.addSegment(botLeft)
				.addSegment(lefOut)
				.addSegment(topLeft)
				.addSegment(topOut)
				.addSegment(topRigh)
				.addSegment(rigM)
				.addSegment(botRigh);
		
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
		return map;
	}
}
