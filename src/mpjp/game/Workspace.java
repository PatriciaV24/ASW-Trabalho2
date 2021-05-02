package mpjp.game;

import java.awt.Point;
import java.io.Serializable;
import java.util.Date;

import mpjp.shared.MPJPException;
import mpjp.shared.PuzzleInfo;
import mpjp.shared.PuzzleLayout;
import mpjp.shared.PuzzleView;

public class Workspace
implements Serializable{
	private static final long serialVersionUID = 5367870857776116546L;
	
	PuzzleInfo info;
	Date start;
	static double radius, heightFactor, widthFactor;
	
	public Workspace(PuzzleInfo info)
	throws MPJPException{
		this.info = info;
		this.start = new Date();
	}
	
	

	PuzzleLayout connect(int moveId, Point point) {
		
	}
	
	PuzzleLayout getCurrentLayout() {
		
	}
	
	
	String getId() {
		return info.getImageName()+start;
	}
	
	int getPercentageSolved() {
		info.
	}
	
	PuzzleLayout getPuzzleSelectInfo(){
		
	}
	
	PuzzleLayout getPuzzleStructure() {
		
	}
	
	PuzzleView getPuzzleView() {
		
	}
	
	
	
	double getSelectRadius() {
		
	}
	
	
	void restore() {
		
	}
	
	void scatter() {
		
	}
	
	Integer selectPiece(Point point) {
		
	}



	public static double getRadius() {
		return radius;
	}



	public static void setRadius(double radius) {
		Workspace.radius = radius;
	}



	public static double getHeightFactor() {
		return heightFactor;
	}



	public static void setHeightFactor(double heightFactor) {
		Workspace.heightFactor = heightFactor;
	}



	public static double getWidthFactor() {
		return widthFactor;
	}



	public static void setWidthFactor(double widthFactor) {
		Workspace.widthFactor = widthFactor;
	}
	
}
