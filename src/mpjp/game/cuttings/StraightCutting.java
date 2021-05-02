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
		
		int rows= structure.getRows();
		int cols= structure.getColumns();
		double x = structure.getPieceWidth() / 2;
		double y = structure.getPieceHeight() / 2;
		
		Point BotRigh = new Point(x,y);
		Point BotLeft = new Point(-x,y);
		Point TopRigh = new Point(-x,-y);
		Point TopLeft = new Point(x,-y);
		
		for(int r=0; r<rows; r++) {
			for(int c=0; c<cols; c++) {
				PieceShape piece = new PieceShape(BotRigh) //Cima Esquerdo
							.addSegment(new LineTo(BotLeft))//Baixo Esquerdo
							.addSegment(new LineTo(TopRigh))  //Baixo Direita
							.addSegment(new LineTo(TopLeft)) //Cima Direita
							.addSegment(new LineTo(BotRigh)); //Inicio
				map.put(r*cols+c, piece);
			}
		}
		return map;
	}
}
