package mpjp.game.cuttings;

import java.util.HashMap;
import java.util.Map;

import mpjp.game.PuzzleStructure;
import mpjp.shared.geom.PieceShape;
import mpjp.shared.geom.Point;
import mpjp.shared.geom.QuadTo;

public class RoundCutting
implements Cutting{

	public RoundCutting() {
		super();
	}
	
	public Map<Integer,PieceShape> getShapes(PuzzleStructure structure){
		 Map<Integer,PieceShape> map = new HashMap<Integer,PieceShape>();
		 
		 int rows = structure.getRows();
			int cols = structure.getColumns();
			double x = structure.getPieceWidth() / 2;
			double y = structure.getPieceHeight() / 2;
		 
			PieceShape cir1 = new PieceShape(new Point(x, y))
					.addSegment(new QuadTo(new Point(0,y+y/2), new Point(-x,y)))
					.addSegment(new QuadTo(new Point(-x-x/2,0), new Point(-x,-y)))
					.addSegment(new QuadTo(new Point(0,-y-y/2), new Point(x,-y)))
					.addSegment(new QuadTo(new Point(x+x/2,0), new Point(x,y)));
			
			PieceShape cir1Top = new PieceShape(new Point(x, y))
					.addSegment(new QuadTo(new Point(0,y+y/2), new Point(-x,y)))
					.addSegment(new QuadTo(new Point(-x-x/2,0), new Point(-x,-y)))
					.addSegment(new QuadTo(new Point(0,-y), new Point(x,-y)))
					.addSegment(new QuadTo(new Point(x+x/2,0), new Point(x,y)));
			
			PieceShape cir1TopLeft = new PieceShape(new Point(x, y))
					.addSegment(new QuadTo(new Point(0,y+y/2), new Point(-x,y)))
					.addSegment(new QuadTo(new Point(-x,0), new Point(-x,-y)))
					.addSegment(new QuadTo(new Point(0,-y), new Point(x,-y)))
					.addSegment(new QuadTo(new Point(x+x/2,0), new Point(x,y)));
			
			PieceShape cir1TopRig = new PieceShape(new Point(x, y))
					.addSegment(new QuadTo(new Point(0,y+y/2), new Point(-x,y)))
					.addSegment(new QuadTo(new Point(-x-x/2,0), new Point(-x,-y)))
					.addSegment(new QuadTo(new Point(0,-y), new Point(x,-y)))
					.addSegment(new QuadTo(new Point(x,0), new Point(x,y)));
			
			PieceShape cir1Bot = new PieceShape(new Point(x, y))
					.addSegment(new QuadTo(new Point(0,y), new Point(-x,y)))
					.addSegment(new QuadTo(new Point(-x-x/2,0), new Point(-x,-y)))
					.addSegment(new QuadTo(new Point(0,-y-y/2), new Point(x,-y)))
					.addSegment(new QuadTo(new Point(x+x/2,0), new Point(x,y)));
			
			PieceShape cir1BotLeft = new PieceShape(new Point(x, y))
					.addSegment(new QuadTo(new Point(0,y), new Point(-x,y)))
					.addSegment(new QuadTo(new Point(-x,0), new Point(-x,-y)))
					.addSegment(new QuadTo(new Point(0,-y-y/2), new Point(x,-y)))
					.addSegment(new QuadTo(new Point(x+x/2,0), new Point(x,y)));
			
			PieceShape cir1BotRig = new PieceShape(new Point(x, y))
					.addSegment(new QuadTo(new Point(0,y), new Point(-x,y)))
					.addSegment(new QuadTo(new Point(-x-x/2,0), new Point(-x,-y)))
					.addSegment(new QuadTo(new Point(0,-y-y/2), new Point(x,-y)))
					.addSegment(new QuadTo(new Point(x,0), new Point(x,y)));
			
			PieceShape cir1Left = new PieceShape(new Point(x, y))
					.addSegment(new QuadTo(new Point(0,y+y/2), new Point(-x,y)))
					.addSegment(new QuadTo(new Point(-x,0), new Point(-x,-y)))
					.addSegment(new QuadTo(new Point(0,-y-y/2), new Point(x,-y)))
					.addSegment(new QuadTo(new Point(x+x/2,0), new Point(x,y)));
			
			
			PieceShape cir1Rig = new PieceShape(new Point(x, y))
					.addSegment(new QuadTo(new Point(0,y+y/2), new Point(-x,y)))
					.addSegment(new QuadTo(new Point(-x-x/2,0), new Point(-x,-y)))
					.addSegment(new QuadTo(new Point(0,-y-y/2), new Point(x,-y)))
					.addSegment(new QuadTo(new Point(x,0), new Point(x,y)));
			
			
			
			
			PieceShape cir2 = new PieceShape(new Point(x, y))
					.addSegment(new QuadTo(new Point(0,y/2), new Point(-x,y)))
					.addSegment(new QuadTo(new Point(-x/2,0), new Point(-x,-y)))
					.addSegment(new QuadTo(new Point(0,-y/2), new Point(x,-y)))
					.addSegment(new QuadTo(new Point(x/2,0), new Point(x,y)));
			
			PieceShape cir2Top = new PieceShape(new Point(x, y))
					.addSegment(new QuadTo(new Point(0,y/2), new Point(-x,y)))
					.addSegment(new QuadTo(new Point(-x/2,0), new Point(-x,-y)))
					.addSegment(new QuadTo(new Point(0,-y), new Point(x,-y)))
					.addSegment(new QuadTo(new Point(x/2,0), new Point(x,y)));
			
			PieceShape cir2TopLeft = new PieceShape(new Point(x, y))
					.addSegment(new QuadTo(new Point(0,y/2), new Point(-x,y)))
					.addSegment(new QuadTo(new Point(-x,0), new Point(-x,-y)))
					.addSegment(new QuadTo(new Point(0,-y), new Point(x,-y)))
					.addSegment(new QuadTo(new Point(x/2,0), new Point(x,y)));
			
			PieceShape cir2TopRig = new PieceShape(new Point(x, y))
					.addSegment(new QuadTo(new Point(0,y/2), new Point(-x,y)))
					.addSegment(new QuadTo(new Point(-x/2,0), new Point(-x,-y)))
					.addSegment(new QuadTo(new Point(0,-y), new Point(x,-y)))
					.addSegment(new QuadTo(new Point(x,0), new Point(x,y)));
			
			PieceShape cir2Bot = new PieceShape(new Point(x, y))
					.addSegment(new QuadTo(new Point(0,y), new Point(-x,y)))
					.addSegment(new QuadTo(new Point(-x/2,0), new Point(-x,-y)))
					.addSegment(new QuadTo(new Point(0,-y/2), new Point(x,-y)))
					.addSegment(new QuadTo(new Point(x/2,0), new Point(x,y)));
			
			PieceShape cir2BotLeft = new PieceShape(new Point(x, y))
					.addSegment(new QuadTo(new Point(0,y), new Point(-x,y)))
					.addSegment(new QuadTo(new Point(-x,0), new Point(-x,-y)))
					.addSegment(new QuadTo(new Point(0,-y/2), new Point(x,-y)))
					.addSegment(new QuadTo(new Point(x/2,0), new Point(x,y)));
			
			PieceShape cir2BotRig = new PieceShape(new Point(x, y))
					.addSegment(new QuadTo(new Point(0,y), new Point(-x,y)))
					.addSegment(new QuadTo(new Point(-x/2,0), new Point(-x,-y)))
					.addSegment(new QuadTo(new Point(0,-y/2), new Point(x,-y)))
					.addSegment(new QuadTo(new Point(x,0), new Point(x,y)));
			
			PieceShape cir2Left = new PieceShape(new Point(x, y))
					.addSegment(new QuadTo(new Point(0,y/2), new Point(-x,y)))
					.addSegment(new QuadTo(new Point(-x,0), new Point(-x,-y)))
					.addSegment(new QuadTo(new Point(0,-y/2), new Point(x,-y)))
					.addSegment(new QuadTo(new Point(x/2,0), new Point(x,y)));
			
			PieceShape cir2Rig = new PieceShape(new Point(x, y))
					.addSegment(new QuadTo(new Point(0,y/2), new Point(-x,y)))
					.addSegment(new QuadTo(new Point(-x/2,0), new Point(-x,-y)))
					.addSegment(new QuadTo(new Point(0,-y/2), new Point(x,-y)))
					.addSegment(new QuadTo(new Point(x,0), new Point(x,y)));

			
	 
		 
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
					if (c == 0) {
						if (r == 0)
							map.put(r * cols + c, cir1TopLeft);
						else {
							if (r == rows - 1)
								if (r % 2 == 0)
									map.put(r * cols + c, cir1BotLeft);
								else
									map.put(r * cols + c, cir2BotLeft);
							else {
								if (r % 2 == 0)
									map.put(r * cols + c, cir1Left);
								else
									map.put(r * cols + c, cir2Left);
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
		}		 
		return map;
	}
}
