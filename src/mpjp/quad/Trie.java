package mpjp.quad;

import java.util.Set;

import mpjp.shared.HasPoint;

public abstract class Trie<T extends HasPoint> implements Element<T> {
	protected double bottomRightX;
	protected double bottomRightY;
	protected double topLeftX;
	protected double topLeftY;
	static int capacity;

	public enum Quadrant{
		NE,NW,SE,SW;
	}
	
	protected Trie(double bottomRightX, double bottomRightY, double topLeftX, double topLeftY) {
		this.bottomRightX = bottomRightX;
		this.bottomRightY = bottomRightY;
		this.topLeftX = topLeftX;
		this.topLeftY = topLeftY;
	}
	
	abstract void accept​(Visitor<T> visitor);
	
	abstract void collectAll(Set<T> points);
	
	abstract void collectNear(double x, double y, double radius, Set<T> points);
	
	abstract void delete(T point);
	
	abstract T find(T point);
	
	public static int getCapacity() {
		return capacity;
	}
	
	static double getDistance(double x, double y, double x2, double y2) {
		return Math.sqrt((Math.pow(x2-x, 2)+Math.pow(y2-y, 2)));
	}
	
	abstract Trie<T> insert(T point);
	
	abstract Trie<T> insertReplace(T point);
	
	
	boolean overlaps(double x, double y, double radius) {
		if(Math.pow(bottomRightX-x,2) + Math.pow(bottomRightY-y,2) < Math.pow(radius,2)) 
			return true;
		
		if(Math.pow(topLeftX-x,2) + Math.pow(topLeftY-y,2) < Math.pow(radius,2)) 
			return true;
		
		return false;	
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
