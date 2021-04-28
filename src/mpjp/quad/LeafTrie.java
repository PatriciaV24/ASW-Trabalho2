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
		nodes.addAll(points);	
	}

	void collectNear​(double x, double y, double radius, Set<T> nodes) {
		for(T current: points) {
		if(getDistance(current.getX(),current.getY(),x,y)<=radius) 
		nodes.add(current);
		}
	}

	void delete​(T point) {
		for(T x: points) {
			if((x.getX()==point.getX() && x.getY()==point.getY())) points.remove(x);
		}
	}

	T find​(T point) {
		for(T x: points) {
			if(x.getX()==point.getX() && x.getY()==point.getY()) return x;
		}
		return null;
	}

	Collection<T> getPoints() {
		return points;
	}

	Trie<T> insert​(T point) {
		if(points.size()<capacity) {
		points.add(point);
		return this;
		}
		else {
			Trie<T> nTrie = new NodeTrie<T>(this.bottomRightX, this.bottomRightY, this.topLeftX, this.topLeftY);
			for(T p: points) {
				nTrie.insert(p);
			}
		
			nTrie.insert(point);
			return nTrie;
		}
		
	}

	Trie<T> insertReplace​(T point) {
		for(T x: points) {
			if(x.getX()==point.getX() && x.getY()==point.getY()) 
				points.remove(x);
		}
		points.add(point);
		return this;
	}

	@Override
	public String toString() {
		return "LeafTrie [points=" + points + ", bottomRightX=" + bottomRightX + ", bottomRightY=" + bottomRightY
				+ ", topLeftX=" + topLeftX + ", topLeftY=" + topLeftY + "]";
	}

}
