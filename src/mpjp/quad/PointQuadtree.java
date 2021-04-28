package mpjp.quad;
import java.util.Iterator;
import mpjp.shared.HasPoint;

public class PointQuadtree<T extends HasPoint> implements Iterable<T> {
	Trie<T> top;
	
	public PointQuadtree(double width,double height) {
		top.topLeftX=0;
		top.topLeftY=height;
		top.bottomRightX=width;
		top.bottomRightY=0;
	}
	public PointQuadtree(double width,	double height,double margin) {
		top.topLeftX=-margin;
		top.topLeftY=height+margin;
		top.bottomRightX=width+margin;
		top.bottomRightY=-margin;
	}
	
	public PointQuadtree(double topLeftX, double topLeftY, double bottomRightX,	double bottomRightY) {
		top.topLeftX=topLeftX;
		top.topLeftY=topLeftY;
		top.bottomRightX=bottomRightX;
		top.bottomRightY=bottomRightY;
	}
	
	public T find​(T point) {
		
	}
	public void insert​(T point) {
		
	}
	public void insertReplace​(T point) {
		
	}
	public Set<T> findNear​(double x, double y,double radius){
		
	}
	
	public void delete​(T point) {
		
	}
	
	public Set<T> getAll(){
		
	}
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
