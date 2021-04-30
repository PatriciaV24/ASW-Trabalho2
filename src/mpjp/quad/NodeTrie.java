package mpjp.quad;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import mpjp.shared.HasPoint;

public class NodeTrie<T extends HasPoint> extends Trie<T> {
	Map<Quadrant, Trie<T>> tries;

	final private double centerx = (this.bottomRightX + this.topLeftX) / 2;
	final private double centery = (this.bottomRightY + this.topLeftY) / 2;
	
	public NodeTrie(double topLeftX, double topLeftY, double bottomRightX, double bottomRightY) {
		super(topLeftX, topLeftY, bottomRightX, bottomRightY);
		this.tries = new HashMap<Trie.Quadrant, Trie<T>>();
	}

	@Override
	public void accept(Visitor<T> visitor) {
		visitor.visit(this);
	}

	@Override
	void collectAll(Set<T> points) {
		for (Quadrant q : tries.keySet()) {
			Trie<T> trie = tries.get(q);
			trie.collectAll(points);
		}
	}

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

	@Override
	T find(T point) {
		Trie<T> trie = tries.get(quadrantOf(point));
		if(trie!=null)
			return trie.find(point);
		return null;
	}

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
