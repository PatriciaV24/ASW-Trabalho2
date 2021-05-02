package mpjp.game.cuttings;

import java.util.HashMap;
import java.util.Map;
import mpjp.game.PuzzleStructure;
import mpjp.shared.geom.CurveTo;
import mpjp.shared.geom.PieceShape;
import mpjp.shared.geom.Point;

public class StandardCutting implements Cutting {

	public StandardCutting() {
		
	}

	public Map<Integer, PieceShape> getShapes(PuzzleStructure structure) {
		Map<Integer, PieceShape> map = new HashMap<Integer, PieceShape>(); // ID e PEÇA
		
		int rows = structure.getRows();
		int cols = structure.getColumns();
		double x = structure.getPieceWidth() / 2;
		double y = structure.getPieceHeight() / 2;

		/* Todos os pontos utilizados */
		Point begin = new Point(x, y);
		
		Point botRigh = new Point(x, y);
		Point botLeft = new Point(-x, y);
		Point topLeft = new Point(-x, -y);
		Point topRigh = new Point(x, -y);
		
		Point botIn = new Point(0, y / 2);
		//Point leftIn = new Point(-x / 2, 0);
		//Point topIn = new Point(0, -y / 2);
		Point rigIn = new Point(x / 2, 0);

		Point botMiddle = new Point(0, y);
		Point leftMiddle = new Point(-x, 0);
		Point topMiddle = new Point(0, -y);
		Point rigMiddle = new Point(x, 0);

		Point botMiddleLeft = new Point(x-x/2, y);
		Point botMiddleRig = new Point(x-x/2, y);
		
		Point leftMiddleTop = new Point(-x, -y+y/2);
		Point leftMiddleBot = new Point(-x, y-y/2);
		
		Point topMiddleLeft = new Point(-x+x/2, -y);
		Point topMiddleRig = new Point(x-x/2, -y);
		
		Point rigMiddleTop = new Point(x, -y+y/2);
		Point rigMiddleBot = new Point(x, y-y/2);
		
		//Point botOut = new Point(0, y + y / 2);
		Point leftOut = new Point(-x - x / 2, 0);
		Point topOut = new Point(0, -y - y / 2);
		Point rigOut = new Point(x + x /2, 0);
		
		Point leftBotOut = new Point(-x-x/2,y);
		Point leftTopOut = new Point(-x-x/2,-y);
		Point topLeftOut = new Point(-x, -y-y/2);
		Point topRigOut = new Point(x, -y-y/2);
		//Point rigTopOut = new Point(x+x/2, -y);
		//Point rigBotOut = new Point(x+x/2, y);
		//Point botLeftOut = new Point(-x, y+y/2);
		//Point botRigOut  = new Point(x, y+y/2);
		
		
		PieceShape c1 = new PieceShape(begin)
				.addSegment(new CurveTo(botLeft,rigMiddleBot,botIn))
				.addSegment(new CurveTo(leftMiddleBot,botRigh,botLeft))
				.addSegment(new CurveTo(topLeft,leftBotOut,leftOut))
				.addSegment(new CurveTo(leftTopOut,botLeft,topLeft))
				.addSegment(new CurveTo(topRigh,topLeftOut,topOut))
				.addSegment(new CurveTo(topRigOut,topLeft,topRigh))
				.addSegment(new CurveTo(botRigh,topMiddleRig,rigIn))
				.addSegment(new CurveTo(botMiddleRig,topRigh,botRigh));
		
		PieceShape c1Bot = new PieceShape(begin)
				.addSegment(new CurveTo(botMiddleRig,botMiddleRig,botMiddle))
				.addSegment(new CurveTo(botMiddleLeft,botMiddleLeft,botLeft))
				.addSegment(new CurveTo(topLeft,leftBotOut,leftOut))
				.addSegment(new CurveTo(leftTopOut,botLeft,topLeft))
				.addSegment(new CurveTo(topRigh,topLeftOut,topOut))
				.addSegment(new CurveTo(topRigOut,topLeft,topRigh))
				.addSegment(new CurveTo(botRigh,topMiddleRig,rigIn))
				.addSegment(new CurveTo(botMiddleRig,topRigh,botRigh));
		
		PieceShape c1BotLeft = new PieceShape(begin)
				.addSegment(new CurveTo(botMiddleRig,botMiddleRig,botMiddle))
				.addSegment(new CurveTo(botMiddleLeft,botMiddleLeft,botLeft))
				.addSegment(new CurveTo(leftMiddleBot,leftMiddleBot,leftMiddle))
				.addSegment(new CurveTo(leftMiddleTop,leftMiddleTop,topLeft))
				.addSegment(new CurveTo(topRigh,topLeftOut,topOut))
				.addSegment(new CurveTo(topRigOut,topLeft,topRigh))
				.addSegment(new CurveTo(botRigh,topMiddleRig,rigIn))
				.addSegment(new CurveTo(botMiddleRig,topRigh,botRigh));
		
		PieceShape c1BotRig = new PieceShape(begin)
				.addSegment(new CurveTo(botMiddleRig,botMiddleRig,botMiddle))
				.addSegment(new CurveTo(botMiddleLeft,botMiddleLeft,botLeft))
				.addSegment(new CurveTo(topLeft,leftBotOut,leftOut))
				.addSegment(new CurveTo(leftTopOut,botLeft,topLeft))
				.addSegment(new CurveTo(topRigh,topLeftOut,topOut))
				.addSegment(new CurveTo(topRigOut,topLeft,topRigh))
				.addSegment(new CurveTo(rigMiddleTop,rigMiddleTop,rigMiddle))
				.addSegment(new CurveTo(rigMiddleBot,rigMiddleBot,botRigh));
		
		PieceShape c1Left = new PieceShape(begin)
				.addSegment(new CurveTo(botLeft,rigMiddleBot,botIn))
				.addSegment(new CurveTo(leftMiddleBot,botRigh,botLeft))
				.addSegment(new CurveTo(leftMiddleBot,leftMiddleBot,leftMiddle))
				.addSegment(new CurveTo(leftMiddleTop,leftMiddleTop,topLeft))
				.addSegment(new CurveTo(topRigh,topLeftOut,topOut))
				.addSegment(new CurveTo(topRigOut,topLeft,topRigh))
				.addSegment(new CurveTo(botRigh,topMiddleRig,rigIn))
				.addSegment(new CurveTo(botMiddleRig,topRigh,botRigh));
		
		PieceShape c1Top = new PieceShape(begin)
				.addSegment(new CurveTo(botLeft,rigMiddleBot,botIn))
				.addSegment(new CurveTo(leftMiddleBot,botRigh,botLeft))
				.addSegment(new CurveTo(topLeft,leftBotOut,leftOut))
				.addSegment(new CurveTo(leftTopOut,botLeft,topLeft))
				.addSegment(new CurveTo(topMiddleLeft,topMiddleLeft,topMiddle))
				.addSegment(new CurveTo(topMiddleRig,topMiddleRig,topRigh))
				.addSegment(new CurveTo(botRigh,topMiddleRig,rigIn))
				.addSegment(new CurveTo(botMiddleRig,topRigh,botRigh));
		
		PieceShape c1TopLeft = new PieceShape(begin)
				.addSegment(new CurveTo(botLeft,rigMiddleBot,botIn))
				.addSegment(new CurveTo(leftMiddleBot,botRigh,botLeft))
				.addSegment(new CurveTo(leftMiddleBot,leftMiddleBot,leftMiddle))
				.addSegment(new CurveTo(leftMiddleTop,leftMiddleTop,topLeft))
				.addSegment(new CurveTo(topMiddleLeft,topMiddleLeft,topMiddle))
				.addSegment(new CurveTo(topMiddleRig,topMiddleRig,topRigh))
				.addSegment(new CurveTo(botRigh,topMiddleRig,rigIn))
				.addSegment(new CurveTo(botMiddleRig,topRigh,botRigh));
		
		PieceShape c1TopRig = new PieceShape(begin)
				.addSegment(new CurveTo(botLeft,rigMiddleBot,botIn))
				.addSegment(new CurveTo(leftMiddleBot,botRigh,botLeft))
				.addSegment(new CurveTo(topLeft,leftBotOut,leftOut))
				.addSegment(new CurveTo(leftTopOut,botLeft,topLeft))
				.addSegment(new CurveTo(topMiddleLeft,topMiddleLeft,topMiddle))
				.addSegment(new CurveTo(topMiddleRig,topMiddleRig,topRigh))
				.addSegment(new CurveTo(rigMiddleTop,rigMiddleTop,rigMiddle))
				.addSegment(new CurveTo(rigMiddleBot,rigMiddleBot,botRigh));
		
		PieceShape c1Rig = new PieceShape(begin)
				.addSegment(new CurveTo(botLeft,rigMiddleBot,botIn))
				.addSegment(new CurveTo(leftMiddleBot,botRigh,botLeft))
				.addSegment(new CurveTo(topLeft,leftBotOut,leftOut))
				.addSegment(new CurveTo(leftTopOut,botLeft,topLeft))
				.addSegment(new CurveTo(topRigh,topLeftOut,topOut))
				.addSegment(new CurveTo(topRigOut,topLeft,topRigh))
				.addSegment(new CurveTo(rigMiddleTop,rigMiddleTop,rigMiddle))
				.addSegment(new CurveTo(rigMiddleBot,rigMiddleBot,botRigh));
		
		for (int c = 0; c < cols; c++) {
			for (int r = 0; r < rows; r++) {
				if (c == 0) {
					if (r == 0)
						map.put(r * cols + c, c1TopLeft);
					else {
						if (r == rows - 1)
							map.put(r * cols + c, c1BotLeft);
							
						else {
							map.put(r * cols + c, c1Left);
						}
					}
				} else {
					if (c == cols - 1) {
						if (r == 0)
							map.put(r * cols + c, c1TopRig);
						else {
							if (r == rows - 1) {
								map.put(r * cols + c, c1BotRig);
							} else {
								map.put(r * cols + c, c1Rig);
							}
						}
					} else {
						if (r == 0)
							map.put(r * cols + c, c1Top);
						else {
							if (r == rows - 1)
									map.put(r * cols + c, c1Bot);
							else {
									map.put(r * cols + c, c1);

							}
						}
					}
				}
			}
		}
		return map;
	}
}
