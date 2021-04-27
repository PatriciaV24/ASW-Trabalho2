package mpjp.shared;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import mpjp.shared.geom.PieceShape;
import mpjp.shared.geom.Point;

public class PuzzleView implements Serializable {
	private static final long serialVersionUID = 5059085866896291246L;
	String image;
	Map<Integer, Point> locations;
	double pieceHeight;
	double pieceWidth;
	double puzzleHeight;
	double puzzleWidth;
	Map<Integer, PieceShape> shapes;
	Date start;
	double workspaceHeight;
	double workspaceWidht;

	public PuzzleView() {}

	public PuzzleView(Date start, double workspaceHeight, double workspaceWidht, double puzzleHeight, double puzzleWidth, 
			double pieceHeight, double pieceWidth, String image,	Map<Integer, PieceShape> shapes, Map<Integer, Point> location) {
		this.image = image;
		this.locations = location;
		this.pieceHeight = pieceHeight;
		this.pieceWidth = pieceWidth;
		this.puzzleHeight = puzzleHeight;
		this.puzzleWidth = puzzleWidth;
		this.shapes = shapes;
		this.start = start;
		this.workspaceHeight=workspaceHeight;
		this.workspaceWidht=workspaceWidht;
	}

	public String getImage() {
		return image;
	}

	public Map<Integer, Point> getLocations() {
		return locations;
	}

	public double getPieceHeight() {
		return pieceHeight;
	}

	public double getPieceWidth() {
		return pieceWidth;
	}

	public double getPuzzleHeight() {
		return puzzleHeight;
	}

	public double getPuzzleWidth() {
		return puzzleWidth;
	}

	public Map<Integer, PieceShape> getShapes() {
		return shapes;
	}

	public Date getStart() {
		return start;
	}

	public double getWorkspaceHeight() {
		return workspaceHeight;
	}

	public double getWorkspaceWidth() {
		return workspaceWidht;
	}

	public PieceShape getPieceShape(int id) {
		return shapes.get(id);
	
	}
	public Point getStandardPieceLocation(int id) {
		return locations.get(id);
	}

}
