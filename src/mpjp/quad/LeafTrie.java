package mpjp.quad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import mpjp.shared.HasPoint;

public class LeafTrie<T extends HasPoint> extends Trie<T> {
	private List<T> points;

	public LeafTrie(double topLeftX, double topLeftY, double bottomRightX, double bottomRightY) {
		super(topLeftX, topLeftY, bottomRightX, bottomRightY);
		points = new ArrayList<T>(Trie.getCapacity());
	}

	public void accept(Visitor<T> visitor) {
		visitor.visit(this);
	}

	@Override
	public void collectAll(Set<T> nodes) {
		nodes.addAll(points);
	}

	@Override
	public void collectNear(double x, double y, double radius, Set<T> nodes) {
		for(T current: points) {
			if(getDistance(current.getX(),current.getY(),x,y) <= radius) 
			nodes.add(current);
		}	
	}


	@Override
	public void delete(T point) {
		this.points.remove(point);
	}

	@Override
	public T find(T point) {
		for(T x: points) {
			if(x.getX()==point.getX() && x.getY()==point.getY()) 
				return x;
		}
		return null;
	}
	
	public Collection<T> getPoints() {
		return this.points;
	}


	@Override
	public Trie<T> insert(T point) {
		if(this.points.size()<Trie.getCapacity()) {
			this.points.add(point);
			return this;
		}else{
			Trie<T> nTrie = new NodeTrie<T> (this.topLeftX,this.topLeftY, this.bottomRightX,this.bottomRightY);
			for(T p: points) {
				nTrie.insert(p);
			}
			nTrie.insert(point);
			return nTrie;
		}
	}


	@Override
	public Trie<T> insertReplace(T point) {
		this.points.removeIf(p -> p.getX()==point.getX() && p.getY()==point.getY());
		return this.insert(point);
	}

	@Override
	public String toString() {
		return "LeafTrie [points=" + points + ", bottomRightX=" + bottomRightX + ", bottomRightY=" + bottomRightY
				+ ", topLeftX=" + topLeftX + ", topLeftY=" + topLeftY + "]";
	}


}