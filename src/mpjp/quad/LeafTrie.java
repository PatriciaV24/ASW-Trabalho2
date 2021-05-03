package mpjp.quad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import mpjp.shared.HasPoint;

/**
 * A Trie that has no descendants. This class corresponds to the Leaf in the
 * Composite design pattern.
 * 
 * @author Manuel Sá up201805273
 * @author Patricia Vieira up201805238
 */

public class LeafTrie<T extends HasPoint> extends Trie<T> {
	private List<T> points;

	public LeafTrie(double topLeftX, double topLeftY, double bottomRightX, double bottomRightY) {
		super(topLeftX, topLeftY, bottomRightX, bottomRightY);
		this.points = new ArrayList<T>(Trie.getCapacity());
	}
	/**Accept a visitor to operate on a node of the composite structure*/
	public void accept(Visitor<T> visitor) {
		visitor.visit(this);
	}
	
	/**Collect all points in this node and its descendants in given set*/
	@Override
	public void collectAll(Set<T> nodes) {
		nodes.addAll(points);
	}
	
	/**Collect points at a distance smaller or equal to radius from (x,y) and place them in given list*/
	@Override
	public void collectNear(double x, double y, double radius, Set<T> nodes) {
		for (T current : this.points) {
			if (getDistance(current.getX(), current.getY(), x, y) <= radius)
				nodes.add(current);
		}
	}

	@Override
	public void delete(T point) {
		this.points.remove(point);
	}

	/**Find a recorded point with the same coordinates of given point*/
	@Override
	public T find(T point) {
		for (T x : this.points) {
			if (x.getX() == point.getX() && x.getY() == point.getY())
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

	/**Insert given point, replacing existing points in same location*/
	@Override
	public Trie<T> insertReplace(T point) {
		this.points.removeIf(p -> p.getX() == point.getX() && p.getY() == point.getY());
		return this.insert(point);
	}

	@Override
	public String toString() {
		return "LeafTrie [points=" + points + ", bottomRightX=" + bottomRightX + ", bottomRightY=" + bottomRightY
				+ ", topLeftX=" + topLeftX + ", topLeftY=" + topLeftY + "]";
	}

}