package mpjp.quad;

import java.util.Set;

import mpjp.shared.HasPoint;

/**
 * Abstract class common to all classes implementing the trie structure. Defines methods required by those classes and provides general methods for checking overlaps and computing distances. This class corresponds to the Component in the Composite design pattern.
 * @author Manuel Sá up201805273
 * @author Patricia Vieira up201805238
 */
public abstract class Trie<T extends HasPoint> implements Element<T> {
	
	protected double bottomRightX;
	protected double bottomRightY;
	protected double topLeftX;
	protected double topLeftY;
	static int capacity = 8;

	public enum Quadrant{
		NE,NW,SE,SW;
	}
	/** Constructor */
	protected Trie(double topLeftX, double topLeftY, double bottomRightX, double bottomRightY) {
		this.bottomRightX = bottomRightX;
		this.bottomRightY = bottomRightY;
		this.topLeftX = topLeftX;
		this.topLeftY = topLeftY;
		 
	}
	
	
	abstract void collectAll(Set<T> points);
	
	abstract void collectNear(double x, double y, double radius, Set<T> points);
	
	abstract void delete(T point);
	
	abstract T find(T point);
	
	public static int getCapacity() {
		return capacity;
	}
	
	static double getDistance(double x, double y, double x2, double y2) {
		return Math.sqrt((Math.pow(x-x2, 2)+Math.pow(y-y2, 2)));
	}
	
	abstract Trie<T> insert(T point);
	
	abstract Trie<T> insertReplace(T point);
	
	
	/*boolean overlaps(double x, double y, double radius) {
		double RectWidth = topLeftX;
		double RectHeight =topLeftY;
		double RectX = bottomRightX;
		double RectY = bottomRightY;
		
		double DeltaX = x - Math.max(RectX, Math.min (x, RectWidth));
		double DeltaY = y - Math.max(RectY, Math.min (y, RectHeight));
		return  ( DeltaX * DeltaX + DeltaY * DeltaY ) < ( radius * radius ) ;
	}*/
	
	boolean overlaps(double x, double y, double radius) {
		double Width = (x - Math.max(topLeftX, Math.min(x, bottomRightX)));
        double Height = (y - Math.max(bottomRightY, Math.min(y, topLeftY)));

        return (Math.pow(Width, 2) + Math.pow(Height, 2) <= Math.pow(radius, 2));
	}

	
	static void setCapacity(int capacity) {
		Trie.capacity=capacity;
	}
	
	@Override
	public String toString() {
		return "Trie [bottomRightX=" + bottomRightX + ", bottomRightY=" + bottomRightY + ", topLeftX=" + topLeftX
				+ ", topLeftY=" + topLeftY + "]";
	}
	
	
}
