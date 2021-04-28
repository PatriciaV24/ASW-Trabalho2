package mpjp.quad;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import mpjp.shared.HasPoint;

public class NodeTrie<T extends HasPoint> extends Trie<T> {
	Map<Quadrant, Trie<T>> tries;

	public NodeTrie(double bottomRightX, double bottomRightY, double topLeftX, double topLeftY) {
		super(bottomRightX, bottomRightY, topLeftX, topLeftY);
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
	void collectNear(double x, double y, double radius, Set<T> points) {
		for (Quadrant q : tries.keySet()) {
			Trie<T> trie = tries.get(q);
			if (trie.overlaps(x, y, radius))
				trie.collectNear(x, y, radius, points);
		}
	}

	
	@Override
	void delete(T point) {
		for (Quadrant q : tries.keySet()) {
			Trie<T> trie = tries.get(q);
			trie.delete(point);
		}
		
	}

	@Override
	T find(T point) {
		for (Quadrant q : tries.keySet()) {
			Trie<T> trie = tries.get(q);
			if(trie.find(point)==point) return point;
		}
		return null;
	}
	
	Collection<Trie<T>> getTries() {
		return tries.values();
	}

	@Override
	Trie<T> insert(T point) {
		Trie<T> trie = tries.get(this.quadrantOf(point));
		return trie.insert(point);
	}

	@Override
	Trie<T> insertReplace(T point) {
		Trie<T> trie = tries.get(this.quadrantOf(point));
		return trie.insertReplace(point);
	}

	Trie.Quadrant quadrantOf(T point) {
		for (Quadrant q : tries.keySet()) {
			Trie<T> trie = tries.get(q);
			if(point.getX()>trie.topLeftX && 
			   point.getX()<trie.bottomRightX &&
			   point.getY()>trie.bottomRightY &&
			   point.getY()<trie.topLeftY) return q;
		}
		return null;
	}


	@Override
	public String toString() {
		return "NodeTrie [tries=" + tries + "]";
	}
}




	

