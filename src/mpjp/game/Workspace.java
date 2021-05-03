package mpjp.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import mpjp.game.cuttings.Cutting;
import mpjp.game.cuttings.CuttingFactoryImplementation;
import mpjp.quad.PointQuadtree;
import mpjp.shared.MPJPException;
import mpjp.shared.PieceStatus;
import mpjp.shared.PuzzleInfo;
import mpjp.shared.PuzzleLayout;
import mpjp.shared.PuzzleSelectInfo;
import mpjp.shared.PuzzleView;
import mpjp.shared.geom.PieceShape;
import mpjp.shared.geom.Point;

public class Workspace implements Serializable {
	private static final long serialVersionUID = 5367870857776116546L;

	PuzzleInfo info;
	Date start;
	static double radius, heightFactor = 2, widthFactor = 2;
	double pieceWidth;
	double pieceHeight;

	transient private PuzzleStructure struct;
	transient private PointQuadtree<PieceStatus> quadTree;

	Map<Integer, PieceStatus> pieces;
	Map<Integer, PieceShape> shapes;
	Map<Integer, Point> points;

	public Workspace(PuzzleInfo info) throws MPJPException {
		this.info = info;
		this.start = new Date();
		struct = new PuzzleStructure(info);
		radius = Math.min(struct.getHeight() / 2, struct.getWidth() / 2);
		this.pieceWidth = info.getWidth() / info.getColumns();
		this.pieceHeight = info.getHeight() / info.getRows();
		
		scatter();
		CuttingFactoryImplementation cuttingImplement = new CuttingFactoryImplementation();
		Cutting cuts = cuttingImplement.createCutting(info.getCuttingName());
		
		shapes = cuts.getShapes(getPuzzleStructure());
		quadTree = new PointQuadtree<PieceStatus>(info.getWidth() * widthFactor, info.getHeight() * heightFactor);
		
		for (PieceStatus p : pieces.values()) quadTree.insert​(p);
	}

	PuzzleLayout connect(int moveId, Point point) throws MPJPException {

		if (point.getX() < 0 || point.getX() > struct.getWidth() * Workspace.widthFactor || point.getY() < 0
				|| point.getY() > struct.getHeight() * Workspace.heightFactor)
			throw new MPJPException("input position out of bounds");
		if (moveId >= struct.getPieceCount())
			throw new MPJPException("input id out of bounds");

		Point movedPoint = new Point(point.getX() - pieces.get(moveId).getX(),
				point.getY() - pieces.get(moveId).getY());
		
		int blockMoved = pieces.get(moveId).getBlock();
		LinkedList<PieceStatus> pieceList = new LinkedList<PieceStatus>();

		for (Entry<Integer, PieceStatus> p : pieces.entrySet()) {

			PieceStatus pieceStat = p.getValue();
			if (pieceStat.getBlock() == blockMoved) {
				quadTree.delete​(pieceStat);
				Point newPoint = pieceStat.getPosition();

				newPoint.setX(newPoint.getX() + movedPoint.getX());
				newPoint.setY(newPoint.getY() + movedPoint.getY());
				pieceStat.setPosition(newPoint);
				quadTree.insert​(pieceStat);
				pieceList.add(pieceStat);
			}
		}

		while (pieceList.size() != 0) {
			PieceStatus firstPiece = pieceList.pollFirst();
			for (Direction dir : Direction.values()) {
				Integer nearId = struct.getPieceFacing(dir, firstPiece.getId());
				if (nearId == null)
					continue;

				Point nearestPoint = struct.getPieceCenterFacing​(dir, firstPiece.getPosition());
				Set<PieceStatus> nearestPieces = this.quadTree.findNear​(nearestPoint.getX(), nearestPoint.getY(),radius);

				if (nearestPieces.size() != 0) {
					for (PieceStatus piece : nearestPieces) {
						if(piece.getId()==nearId && piece.getBlock() != blockMoved) {
							pieceList.add(piece);
							piece.setPosition(nearestPoint);
							piece.setBlock(blockMoved);
						}
					}
				}
			}
		}
			return getCurrentLayout();
	}

	PuzzleLayout getCurrentLayout() {
		Map<Integer, List<Integer>> blocks = new HashMap<Integer, List<Integer>>();
		for (PieceStatus p : pieces.values()) {
			if (blocks.containsKey(p.getBlock()) == false)
				blocks.put(p.getBlock(), new ArrayList<Integer>());
			blocks.get(p.getBlock()).add(p.getId());
		}
		PuzzleLayout layout = new PuzzleLayout(pieces, blocks, getPercentageSolved());
		return layout;
	}

	String getId() {
		return info.getImageName() + start.getTime();
	}

	int getPercentageSolved() {
		Map<Integer, List<Integer>> blocks = new HashMap<Integer, List<Integer>>();

		for (PieceStatus p : pieces.values()) {
			if (!blocks.containsKey(p.getBlock()))
				blocks.put(p.getBlock(), new ArrayList<Integer>());
			blocks.get(p.getBlock()).add(p.getId());
		}

		return 100 * (this.pieces.size() - blocks.size()) / (pieces.size() - 1);
	}

	PuzzleSelectInfo getPuzzleSelectInfo() {
		PuzzleSelectInfo selectInfo = new PuzzleSelectInfo(info, getPercentageSolved(), start);
		return selectInfo;
	}

	PuzzleStructure getPuzzleStructure() {
		PuzzleStructure structure = new PuzzleStructure(info);
		return structure;
	}

	private Map<Integer, Point> getLocations() {
		Map<Integer, Point> locations = new HashMap<Integer, Point>();
		for (Integer p : pieces.keySet()) {
			try {
			locations.put(p, struct.getPieceStandardCenter​(p));
			} catch (MPJPException error) {
				error.printStackTrace();
			}
		}
		return locations;
	}

	PuzzleView getPuzzleView() {
		PuzzleView v = new PuzzleView(start, info.getHeight() * heightFactor, info.getWidth() * widthFactor,
				info.getHeight(), info.getWidth(), pieceHeight, pieceWidth, info.getImageName(), shapes, points);
		return v;
	}

	double getSelectRadius() {

		return Math.max(pieceHeight, pieceWidth);
	}

	void restore() {
		struct = new PuzzleStructure(this.info);
		quadTree = new PointQuadtree<PieceStatus>(info.getWidth()*widthFactor, info.getHeight()*heightFactor);
		for(Entry<Integer,PieceStatus> n: this.pieces.entrySet()) {
			quadTree.insert​(n.getValue());
		}
	}


	void scatter() {
		pieces = new HashMap<Integer, PieceStatus>();
		Map<Integer, Point> locations = getLocations();

		for (int i = 0; i < struct.getPieceCount(); i++) {
			Point p = struct.getRandomPointInStandardPuzzle();
			while (locations.containsValue(p)) {
				p = struct.getRandomPointInStandardPuzzle();
			}

			PieceStatus piece = new PieceStatus(i, p);
			piece.setBlock(i);
			pieces.put(i, piece);
		}
	}

	Integer selectPiece(Point point) {
		double selectRadius = radius;
		Set<PieceStatus> pointSet = quadTree.findNear​(point.getX(), point.getY(), selectRadius);
		if (pointSet.size() == 0)
			return null;

		int maxBlock = -1;
		Integer id = 0;

		for (PieceStatus p : pointSet) {
			if (p.getBlock() >= maxBlock) {
				id = p.getId();
				maxBlock = p.getBlock();
			}
		}
		return id;
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
