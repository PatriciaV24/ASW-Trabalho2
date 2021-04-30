package mpjp.game;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import mpjp.shared.MPJPExeption;
import mpjp.shared.PuzzleInfo;

public class PuzzleStructure {
	int rows, columns;
	double width, heigth;
	PuzzleInfo info;

	public PuzzleStructure(int rows, int collumns, double width, double heigth) {
		this.rows = rows;
		this.columns = collumns;
		this.width = width;
		this.heigth = heigth;
	}

	public PuzzleStructure(PuzzleInfo info) {
		this.rows = info.getRows();
		this.columns = info.getColumns();
		this.width = info.getWidth();
		this.heigth = info.getHeight();
	}

	public int getPieceCount() {
		return getColumns() * getRows();
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

	public double getHeigth() {
		return heigth;
	}

	public void setHeigth(double heigth) {
		this.heigth = heigth;
	}

	public double getPieceWidth() {
		return this.getWidth() / this.getRows();
	}

	public double getPieceHeight() {
		return this.getHeigth() / this.getColumns();
	}

	public boolean validId(int id) {
		return id >= 0 || id < getPieceCount();

	}

	public Integer getPieceFacing(Direction direction, Integer id) {
		if (validId(id) == false) {
			return null;
		}
		switch (direction) {
		case NORTH: {
			if (validId(id - getColumns()))
				return null;
			else
				return id - getColumns();
		}

		case SOUTH: {
			if (validId(id + getColumns()))
				return null;
			else
				return id + getColumns();
		}

		case WEST: {
			if (validId(id - getRows()))
				return null;
			else
				return id - getRows();
		}

		case EAST: {
			if (validId(id + getRows()))
				return null;
			else
				return id + getRows();
		}

		default:
			return null;
		}
	}

	Point getPieceCenterFacing(Direction direction, Point point) {
		int newX = point.x, newY = point.y;

		switch (direction) {

		case NORTH: {
			newY -= getPieceHeight();
		}
			break;

		case SOUTH: {
			newY += getPieceHeight();
			break;
		}

		case WEST: {
			newX -= getPieceWidth();
			break;
		}

		case EAST: {
			newX += getPieceWidth();
			break;
		}

		default:
			break;
		}

		Point newPoint = new Point(newX, newY);
		return newPoint;
	}

	public int getPieceRow(int id) throws MPJPExeption {
		if (id >= 0 || id < getPieceCount()) {
			return id % getColumns();
		}

		throw new MPJPExeption();
	}

	public int getPieceColumn(int id) throws MPJPExeption {
		if (id >= 0 || id < getPieceCount()) {
			return id / getRows();
		}

		throw new MPJPExeption();
	}

	public Map<Integer, Point> getStandardLocations() throws MPJPExeption {
		
		Map<Integer, Point> map = new HashMap<Integer, Point>();
		int count = getPieceCount();
		
		for (int i = 0; i < count; i++) {
			Point tmp = getPieceStandardCenter(i);
			map.put(i, tmp);
			}
		return map;
	}

	public Point getPieceStandardCenter(int id) throws MPJPExeption {
		int x, y;
		if(validId(id)) {
		
		x =(int) (getPieceRow(id)+(getPieceWidth()/2));
		y= (int) (getPieceColumn(id)+(getPieceHeight()/2));
		
		Point p =new Point();
		p.x=x;
		p.y=y;
		
		return p;
		}
		
		return null;
	
	}

}
