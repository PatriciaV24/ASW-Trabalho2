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
		this.points = new ArrayList<T>(Trie.getCapacity());
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
		for(T current: this.points) {
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
		for(T x: this.points) {
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
		if (Trie.capacity == this.points.size()) {
			NodeTrie<T> node = new NodeTrie<>(this.topLeftX, this.topLeftY, this.bottomRightX, this.bottomRightY);
			node.insert(point);
			for (T t : points) {
				node.insert(t);
			}
			return node;
		} else {
			points.add(point);
			return this;
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