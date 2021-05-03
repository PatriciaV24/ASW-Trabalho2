package mpjp.game.cuttings;

import java.util.HashMap;
import java.util.Map;

import mpjp.game.PuzzleStructure;
import mpjp.shared.geom.Point;
import mpjp.shared.geom.PieceShape;
import mpjp.shared.geom.QuadTo;

/**
 * This is a simple cutting where each side of a piece is a quadratic curve
 * segment.
 * 
 * @author Manuel Sá up201805273
 * @author Patricia Vieira up201805238
 */
public class RoundCutting implements Cutting {
	/** Constructor-An empty instance */
	public RoundCutting() {
		super();
	}

	/**
	 * Constructor-An empty instance
	 * 
	 * @param PuzzleStructure structure
	 */

	public Map<Integer, PieceShape> getShapes(PuzzleStructure structure) {
		Map<Integer, PieceShape> map = new HashMap<Integer, PieceShape>();

		int rows = structure.getRows();
		int cols = structure.getColumns();
		double x = structure.getPieceWidth() / 2;
		double y = structure.getPieceHeight() / 2;

		Point begin = new Point(x, y);
		Point botRigh = new Point(x, y);
		Point botLeft = new Point(-x, y);
		Point topLeft = new Point(-x, -y);
		Point topRigh = new Point(x, -y);

		Point botIn = new Point(0, y / 2);
		Point leftIn = new Point(-x / 2, 0);
		Point topIn = new Point(0, -y / 2);
		Point rigIn = new Point(x / 2, 0);

		Point botM = new Point(0, y);
		Point leftM = new Point(-x, 0);
		Point topM = new Point(0, -y);
		Point rigM = new Point(x, 0);

		Point botOut = new Point(0, y + y / 2);
		Point lefOut = new Point(-x - x / 2, 0);
		Point topOut = new Point(0, -y - y / 2);
		Point rigOut = new Point(x + x / 2, 0);

		QuadTo circBotOut = new QuadTo(botOut, botLeft);
		QuadTo circBotIn = new QuadTo(botIn, botLeft);
		QuadTo circBotMiddle = new QuadTo(botM, botLeft);
		QuadTo circLeftOut = new QuadTo(lefOut, topLeft);
		QuadTo circLeftIn = new QuadTo(leftIn, topLeft);
		QuadTo circLeftMiddle = new QuadTo(leftM, topLeft);
		QuadTo circTopOut = new QuadTo(topOut, topRigh);
		QuadTo circTopIn = new QuadTo(topIn, topRigh);
		QuadTo circTopMiddle = new QuadTo(topM, topRigh);
		QuadTo circRighOut = new QuadTo(rigOut, botRigh);
		QuadTo circRighIn = new QuadTo(rigIn, botRigh);
		QuadTo circRighMiddle = new QuadTo(rigM, botRigh);

		PieceShape cir1 = new PieceShape(begin).addSegment(circBotOut).addSegment(circLeftOut).addSegment(circTopOut)
				.addSegment(circRighOut);

		PieceShape cir1Top = new PieceShape(begin).addSegment(circBotOut).addSegment(circLeftOut)
				.addSegment(circTopMiddle).addSegment(circRighOut);

		/*
		 * PieceShape cir1TopLeft = new PieceShape(begin) .addSegment(circBotOut)
		 * .addSegment(circLeftMiddle) .addSegment(circTopMiddle)
		 * .addSegment(circRighOut);
		 */

		PieceShape cir1TopRig = new PieceShape(begin).addSegment(circBotOut).addSegment(circLeftOut)
				.addSegment(circTopMiddle).addSegment(circRighMiddle);

		PieceShape cir1Bot = new PieceShape(begin).addSegment(circBotMiddle).addSegment(circLeftOut)
				.addSegment(circTopOut).addSegment(circRighOut);

		PieceShape cir1BotLeft = new PieceShape(begin).addSegment(circBotMiddle).addSegment(circLeftMiddle)
				.addSegment(circTopOut).addSegment(circRighOut);

		PieceShape cir1BotRig = new PieceShape(begin).addSegment(circBotMiddle).addSegment(circLeftOut)
				.addSegment(circTopOut).addSegment(circRighMiddle);

		PieceShape cir1Left = new PieceShape(begin).addSegment(circBotOut).addSegment(circLeftMiddle)
				.addSegment(circTopOut).addSegment(circRighOut);

		PieceShape cir1Rig = new PieceShape(begin).addSegment(circBotOut).addSegment(circLeftOut).addSegment(circTopOut)
				.addSegment(circRighMiddle);

		PieceShape cir2 = new PieceShape(begin).addSegment(circBotIn).addSegment(circLeftIn).addSegment(circTopIn)
				.addSegment(circRighIn);

		PieceShape cir2Top = new PieceShape(begin).addSegment(circBotIn).addSegment(circLeftIn)
				.addSegment(circTopMiddle).addSegment(circRighIn);

		PieceShape cir2TopLeft = new PieceShape(begin).addSegment(circBotIn).addSegment(circLeftMiddle)
				.addSegment(circTopMiddle).addSegment(circRighIn);

		PieceShape cir2TopRig = new PieceShape(begin).addSegment(circBotIn).addSegment(circLeftIn)
				.addSegment(circTopMiddle).addSegment(circRighMiddle);

		PieceShape cir2Bot = new PieceShape(begin).addSegment(circBotMiddle).addSegment(circLeftIn)
				.addSegment(circTopIn).addSegment(circRighIn);

		PieceShape cir2BotLeft = new PieceShape(begin).addSegment(circBotMiddle).addSegment(circLeftMiddle)
				.addSegment(circTopIn).addSegment(circRighIn);

		PieceShape cir2BotRig = new PieceShape(begin).addSegment(circBotMiddle).addSegment(circLeftIn)
				.addSegment(circTopIn).addSegment(circRighMiddle);

		PieceShape cir2Left = new PieceShape(begin).addSegment(circBotIn).addSegment(circLeftMiddle)
				.addSegment(circTopIn).addSegment(circRighIn);

		PieceShape cir2Rig = new PieceShape(begin).addSegment(circBotIn).addSegment(circLeftIn).addSegment(circTopIn)
				.addSegment(circRighMiddle);

		for (int c = 0; c < cols; c++) {
			for (int r = 0; r < rows; r++) {
				if (c % 2 == 0) {
					if (c == 0) {
						if (r == 0)
							map.put(r * cols + c, cir2TopLeft);
						else {
							if (r == rows - 1)
								if (r % 2 == 0)
									map.put(r * cols + c, cir2BotLeft);
								else
									map.put(r * cols + c, cir1BotLeft);
							else {
								if (r % 2 == 0)
									map.put(r * cols + c, cir2Left);
								else
									map.put(r * cols + c, cir1Left);
							}
						}
					} else {
						if (c == cols - 1) {
							if (r == 0)
								map.put(r * cols + c, cir2TopRig);
							else {
								if (r == rows - 1) {
									if (r % 2 == 0)
										map.put(r * cols + c, cir2BotRig);
									else
										map.put(r * cols + c, cir1BotRig);
								} else {
									if (r % 2 == 0)
										map.put(r * cols + c, cir2Rig);
									else
										map.put(r * cols + c, cir1Rig);
								}
							}
						} else {
							if (r == 0)
								map.put(r * cols + c, cir2Top);
							else {
								if (r == rows - 1)
									if (r % 2 == 0)
										map.put(r * cols + c, cir2Bot);
									else
										map.put(r * cols + c, cir1Bot);
								else {
									if (r % 2 == 0)
										map.put(r * cols + c, cir2);
									else
										map.put(r * cols + c, cir1);
								}
							}
						}
					}
				} else {
					if (c == cols - 1) {
						if (r == 0)
							map.put(r * cols + c, cir1TopRig);
						else {
							if (r == rows - 1) {
								if (r % 2 == 0)
									map.put(r * cols + c, cir1BotRig);
								else
									map.put(r * cols + c, cir2BotRig);
							} else {
								if (r % 2 == 0)
									map.put(r * cols + c, cir1Rig);
								else
									map.put(r * cols + c, cir2Rig);
							}
						}
					} else {
						if (r == 0)
							map.put(r * cols + c, cir1Top);
						else {
							if (r == rows - 1)
								if (r % 2 == 0)
									map.put(r * cols + c, cir1Bot);
								else
									map.put(r * cols + c, cir2Bot);
							else {
								if (r % 2 == 0)
									map.put(r * cols + c, cir1);
								else
									map.put(r * cols + c, cir2);
							}
						}
					}
				}
			}
		}
		return map;
	}
}
