package mpjp.game;

import mpjp.shared.MPJPException;
import mpjp.shared.PuzzleInfo;
import mpjp.shared.geom.Point;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * A PuzzleStructure is responsible for connecting neighboring pieces. Puzzle
 * Structure This is different from a physical puzzle where piece connection is
 * given by cutting; in MPJP the cutting is only used to visual cues to the
 * player.
 * 
 * The core of this class is a panel of rows and columns. For instance, a jigsaw
 * puzzle with 3 rows and 3 columns has 9 pieces as in the figure. Each piece is
 * associated with and rectangular cell on the panel. However, most pieces won't
 * be completely contained within their rectangles as their tabPanel will fall
 * into the rectangles of neighboring pieces.
 * 
 * Individual pieces are identified by an non-negative integer, with piece 0
 * being the upper left corner. The IDs increase from left to right, and wrap
 * the next row.
 * 
 * @author Manuel Sá up201805273
 * @author Patricia Vieira up201805238
 */
public class PuzzleStructure implements Iterable<Integer> {
	int rows, columns;
	double width, height;

	/** Constructor-Create an instance from raw data */
	public PuzzleStructure(int rows, int collumns, double width, double height) {
		this.rows = rows;
		this.columns = collumns;
		this.width = width;
		this.height = height;
	}

	/** Constructor-Create instance from data in PuzzleInfo */
	public PuzzleStructure(PuzzleInfo info) {
		this(info.getRows(), info.getColumns(), info.getWidth(), info.getHeight());
	}

	void init(int rows, int columns, double width, double height) {
	}

	public int getPieceCount() {
		return getRows() * getColumns();
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getPieceWidth() {
		return this.getWidth() / this.getColumns();
	}

	public double getPieceHeight() {
		return this.getHeight() / this.getRows();
	}

	private boolean validId(int id) {
		return (id >= 0 && id < getPieceCount());

	}

	/**
	 * The ID of the piece facing in the given direction the give piece For
	 * instance, in a puzzle with 2 rows and 3 columns, the IDs are
	 */
	public Integer getPieceFacing(Direction direction, Integer id) {
		if (id == null || !validId(id)) {
			return null;
		}
		switch (direction) {
		case NORTH:
			if (validId(id - getColumns()))
				return id - getColumns();
			break;

		case SOUTH:
			if (validId(id + getColumns()))
				return id + getColumns();
			break;

		case WEST:
			if (id % getColumns() != 0)
				return id - 1;
			break;

		case EAST:
			if (id % getColumns() != (getColumns() - 1))
				return id + 1;
		}
		return null;
	}

	/**
	 * The center of a matching piece facing in the given direction the piece with
	 * given center For instance, in a puzzle with a piece cell width is 120 and
	 * height is 100, the matching piece facing a piece currently with center
	 * (200,200) to the: EAST is centered at (320,100) SOUTH is centered at
	 * (200,300) WEST is centered at (80,200) NORTH is centered at (200,100)
	 */
	public Point getPieceCenterFacing​(Direction direction, Point point) {
		Point p = new Point();

		double x = point.getX();
		double y = point.getY();

		switch (direction) {
		case NORTH:
			p.setX(x);
			p.setY(point.getY() - getPieceHeight());
			return p;
		case SOUTH:
			p.setX(x);
			p.setY(point.getY() + getPieceHeight());
			return p;
		case WEST:
			p.setX(point.getX() - getPieceWidth());
			p.setY(y);
			return p;
		case EAST:
			p.setX(point.getX() + getPieceWidth());
			p.setY(y);
			return p;
		default:
			return null;
		}
	}

	public int getPieceRow​(int id) throws MPJPException {
		if (!validId(id))
			throw new MPJPException();
		return id / getColumns();
	}

	public int getPieceColumn​(int id) throws MPJPException {
		if (!validId(id))
			throw new MPJPException();
		return id % getColumns();
	}

	/**
	 * Locations of given piece in the final position, assuming the origin at (0,0)
	 * on the upper left corner
	 */
	public Map<Integer, Point> getStandardLocations() {
		Map<Integer, Point> map = new HashMap<Integer, Point>();
		int count = getPieceCount();

		for (int i = 0; i < count; i++) {
			try {
				Point tmp = getPieceStandardCenter​(i);
				map.put(i, tmp);
			} catch (MPJPException e) {
				e.printStackTrace();
			}
		}
		return map;
	}

	/**
	 * Center of given piece in the final position, assuming the origin at (0,0) on
	 * the upper left corner
	 */
	public Point getPieceStandardCenter​(int id) throws MPJPException {
		if (validId(id)) {
			int pC = this.getPieceColumn​(id);
			int pR = this.getPieceRow​(id);

			Point p = new Point();

			p.setX(pC * getPieceWidth() + getPieceWidth() / 2);
			p.setY(pR * getPieceHeight() + getPieceHeight() / 2);
			return p;
		}
		throw new MPJPException();
	}

	/**Set of pieces where a point might be located in a complete puzzle.*/
	public Set<Integer> getPossiblePiecesInStandarFor​(Point point) {
		Set<Integer> p = new HashSet<Integer>();

		int colum = (int) (point.getX() / getPieceWidth());
		int row = (int) (point.getY() / getPieceHeight());
		int id = (row * getColumns()) + colum;

		p.add(id);

		p.add(getPieceFacing(Direction.NORTH, id));
		p.add(getPieceFacing(Direction.NORTH, getPieceFacing(Direction.EAST, id)));
		p.add(getPieceFacing(Direction.NORTH, getPieceFacing(Direction.WEST, id)));
		p.add(getPieceFacing(Direction.SOUTH, id));
		p.add(getPieceFacing(Direction.SOUTH, getPieceFacing(Direction.EAST, id)));
		p.add(getPieceFacing(Direction.SOUTH, getPieceFacing(Direction.WEST, id)));
		p.add(getPieceFacing(Direction.EAST, id));
		p.add(getPieceFacing(Direction.WEST, id));
		p.remove(null);
		return p;
	}
	/**A random point in the standard puzzle, with origin (0,0) at the upper left corner and bottom right corner a (width,height).*/
	public Point getRandomPointInStandardPuzzle() {
		Random r = new Random();
		Point p = new Point();
		p.setX(getWidth() * r.nextDouble());
		p.setY(getHeight() * r.nextDouble());
		return p;
	}

	@Override
	public Iterator<Integer> iterator() {
		return IntStream.range(0, getPieceCount()).iterator();
	}
}
