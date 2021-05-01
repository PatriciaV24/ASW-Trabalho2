package mpjp.game;

import java.awt.Point;
import java.io.Serializable;
import java.sql.Date;

import mpjp.shared.MPJPException;
import mpjp.shared.PuzzleInfo;
import mpjp.shared.PuzzleLayout;
import mpjp.shared.PuzzleView;

public class Workspace
implements Serializable{
	private static final long serialVersionUID = 5367870857776116546L;
	
	PuzzleInfo info;
	Date start;
	
	
	public Workspace(PuzzleInfo info)
	throws MPJPException{
		this.info = info;
	}

	PuzzleLayout connect(int moveId, Point point) {
		
	}
	
	PuzzleLayout getCurrentLayout() {
		
	}
	
	static double getHeightFactor() {
		
	}
	
	String getId() {
		String id = info.getImageName()+start;
		
	}
	
	int getPercentageSolved() {
		
	}
	
	PuzzleLayout getPuzzleSelectInfo(){
		
	}
	
	PuzzleLayout getPuzzleStructure() {
		
	}
	
	PuzzleView getPuzzleView() {
		
	}
	
	static double getRadius() {
		
	}
	
	double getSelectRadius() {
		
	}
	
	static double getWidthFactor() {
		
	}
	
	void restore() {
		
	}
	
	void scatter() {
		
	}
	
	Integer selectPiece(Point point) {
		
	}
	
	static void setHeighFactor(double heighFactor) {
		
	}
	
	static void setRadius(double radius) {
		
	}
	
	static void setWidthFactor(double widthFactor) {
		
	}
}
