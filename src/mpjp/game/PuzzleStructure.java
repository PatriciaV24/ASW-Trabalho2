package mpjp.game;
import mpjp.shared.MPJPException;
import mpjp.shared.PuzzleInfo;
import mpjp.shared.geom.Point;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

public class PuzzleStructure implements Iterable<Integer>{
	int rows, columns;
	double width, height;

	public PuzzleStructure(int rows, int collumns, double width, double height) {
		this.rows = rows;
		this.columns = collumns;
		this.width = width;
		this.height = height;
	}

	public PuzzleStructure(PuzzleInfo info) {
		this.rows = info.getRows();
		this.columns = info.getColumns();
		this.width = info.getWidth();
		this.height = info.getHeight();
	}

	void init(int rows, int columns, double width,double height) {
	}
	
	
	public int getPieceCount() {
		return getRows()* getColumns();
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
	
	public Integer getPieceFacing(Direction direction, Integer id) {
		if (!validId(id)) {
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
				if (validId(id % getColumns()-1))
					return id -1;
				break;	
						
			case EAST:
				if (validId(id % getColumns()+1))
					return id +1;
		}
		return null;
	}
	public Point getPieceCenterFacing​(Direction direction,Point point) {
		Point p =new Point();
		​
		return point;
	}
	
	public int getPieceRow​(int id) throws MPJPException{
		if (!validId(id)) 
			throw new MPJPException();
		return id / getColumns();
	}
	
	public int getPieceColumn​(int id) throws MPJPException{
		if (!validId(id)) 
			throw new MPJPException();
		return id % getColumns();
	}
	
	public Map<Integer,Point> getStandardLocations(){
		Map<Integer, Point> map = new HashMap<Integer, Point>();
		int count = getPieceCount();
		
		for (int i = 0; i < count; i++) {
			try {
			Point tmp = getPieceStandardCenter​(i);
			map.put(i, tmp);
			}catch (MPJPException e) {
				e.printStackTrace();
			}
		}
		return map;
	}
	
	public Point getPieceStandardCenter​(int id) throws MPJPException{
		if(validId(id)) {
			int pC= this.getPieceColumn​(id);
			int pR=this.getPieceRow​(id);
			
			Point p =new Point();
			
			p.setX(pC* getPieceWidth() + getPieceWidth()/2);
			p.setY(pR * getPieceHeight()+ getPieceHeight()/2);
			return p;
		}
		throw new MPJPException();
	}

	public Set<Integer> getPossiblePiecesInStandarFor​(Point point){
		return null;
	}
	public Point getRandomPointInStandardPuzzle() {
		Random r = new Random();
		Point p= new Point();
		p.setX(getWidth()* r.nextDouble());
		p.setY(getHeight()* r.nextDouble());
		return p;
	}
	
	@Override
	public Iterator<Integer> iterator(){
		return IntStream.range(0, getPieceCount()).iterator();
	}
}
