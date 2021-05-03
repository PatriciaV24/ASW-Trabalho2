package mpjp.quad;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import mpjp.shared.HasPoint;

/**
 * Trie with 4 sub tries with equal dimensions covering all its area. This class
 * corresponds to the Container in the Composite design pattern.
 * 
 * @author Manuel Sá up201805273
 * @author Patricia Vieira up201805238
 */
public class NodeTrie<T extends HasPoint> extends Trie<T> {
	Map<Quadrant, Trie<T>> tries;

	final private double centerx = (this.bottomRightX + this.topLeftX) / 2;
	final private double centery = (this.bottomRightY + this.topLeftY) / 2;
	
	/** Constructor*/
	public NodeTrie(double topLeftX, double topLeftY, double bottomRightX, double bottomRightY) {
		super(topLeftX, topLeftY, bottomRightX, bottomRightY);
		this.tries = new HashMap<Trie.Quadrant, Trie<T>>();
	}

	/**Accept a visitor to operate on a node of the composite structure*/
	@Override
	public void accept(Visitor<T> visitor) {
		visitor.visit(this);
	}
	
	/**Collect all points in this node and its descendants in given set*/
	@Override
	void collectAll(Set<T> points) {
		for (Quadrant q : tries.keySet()) {
			Trie<T> trie = tries.get(q);
			trie.collectAll(points);
		}
	}

	/**Collect points at a distance smaller or equal to radius from (x,y) and place them in given list*/
	@Override
	void collectNear(double x, double y, double radius, Set<T> nodes) {
		if (overlaps(x, y, radius)) {
			for (Quadrant q : tries.keySet()) {
				Trie<T> trie = tries.get(q);
				trie.collectNear(x, y, radius, nodes);
			}
		}
	}

	@Override
	void delete(T point) {
		Trie<T> trie = tries.get(quadrantOf(point));
		if(trie!=null)
			trie.delete(point);
	}
	/**Find a recorded point with the same coordinates of given point*/
	@Override
	T find(T point) {
		Trie<T> trie = tries.get(quadrantOf(point));
		if(trie!=null)
			return trie.find(point);
		return null;
	}

	/** A collection of tries that descend from this one */
	Collection<Trie<T>> getTries() {
		return tries.values();
	}

	@Override
	Trie<T> insert(T point) {
		Quadrant q = quadrantOf(point);
		Trie<T> trie = tries.get(q);
		if (trie == null) {
			trie = newLeafTreeByQuadrant(q);
		}
		tries.put(q, trie.insert(point));
		return this;
	}

	/**Insert given point, replacing existing points in same location*/
	@Override
	Trie<T> insertReplace(T point) {
		Quadrant q = quadrantOf(point);
		Trie<T> trie = tries.get(q);
		if (trie == null) {
			trie = newLeafTreeByQuadrant(q);
		}
		tries.put(q, trie.insertReplace(point));
		return this;
	}

	
	/*
	 * Creates new Leaf based on the Given Quadrant
	 */
	private LeafTrie<T> newLeafTreeByQuadrant(Quadrant a) {
		switch (a) {
			case NE:
				return new LeafTrie<T>(this.centerx, this.topLeftY, this.bottomRightX, this.centery);
			case NW:
				return new LeafTrie<T>(this.topLeftX, this.topLeftY, this.centerx, centery);
			case SE:
				return new LeafTrie<T>(this.centerx, this.centery, this.bottomRightX, this.bottomRightY);
			case SW:
				return new LeafTrie<T>(this.topLeftX, this.centery, this.centerx, this.bottomRightY);
		}
		return null;
	}
		
	Quadrant quadrantOf(T point) {
		if (point.getX() >= centerx && point.getY() >= centery)
			return Quadrant.NE;
		if (point.getX() >= centerx && point.getY() <= centery)
			return Quadrant.SE;
		if (point.getX() <= centerx && point.getY() >= centery)
			return Quadrant.NW;
		if (point.getX() <= centerx && point.getY() <= centery)
			return Quadrant.SW;
		return null;
	}

	@Override
	public String toString() {
		return "NodeTrie [tries=" + tries + "]";
	}
}
