package mpjp.quad;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import mpjp.shared.HasPoint;

public class LeafTrie<T extends HasPoint> extends Trie<T> {
	List<T> points;


	public LeafTrie(double bottomRightX, double bottomRightY, double topLeftX, double topLeftY) {
		super(bottomRightX, bottomRightY, topLeftX, topLeftY);
		this.points = new ArrayList<T>();
	}

	void accept​(Visitor<T> visitor) {
		visitor.visit(this);
	}

	void collectAll​(Set<T> nodes) {
		for(T current: nodes) points.add(current);		
	}

	void collectNear​(double x, double y, double radius, Set<T> nodes) {
		for(T current: nodes) {
		if(Math.pow(current.getX()-x,2) + Math.pow(current.getY()-y,2) < Math.pow(radius,2)) 
			points.add(current);
		}
	}

	void delete​(T point) {
		for(T x: points) {
			if(x==point) points.remove(x);
		}
	}

	T find​(T point) {
		for(T x: points) {
			if(x==point) return x;
		}
		return null;
	}

	Collection<T> getPoints() {

	}

	Trie<T> insert​(T point) {
		points.add(point);
		return this;
	}

	Trie<T> insertReplace​(T point) {
		points.add(point);
		return this;
	}

	@Override
	public String toString() {
		return "LeafTrie [points=" + points + ", bottomRightX=" + bottomRightX + ", bottomRightY=" + bottomRightY
				+ ", topLeftX=" + topLeftX + ", topLeftY=" + topLeftY + "]";
	}

}
