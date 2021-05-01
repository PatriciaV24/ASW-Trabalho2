package mpjp.game.cuttings;

import java.util.HashMap;
import java.util.Map;

import mpjp.game.PuzzleStructure;
import mpjp.shared.geom.PieceShape;

public class RoundCutting
implements Cutting{

	public RoundCutting() {
		super();
	}
	
	public Map<Integer,PieceShape> getShapes(PuzzleStructure structure){
		 Map<Integer,PieceShape> map = new HashMap<Integer,PieceShape>();
		 for(int i=0;i<structure.getPieceCount();i++) {
		 		
		 	}
		 return map;
	}
}
