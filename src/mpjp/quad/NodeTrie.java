package mpjp.quad;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import mpjp.quad.Trie.Quadrant;
import mpjp.shared.HasPoint;

public class NodeTrie<T extends HasPoint> extends Trie<T> {
	Map<Quadrant, Trie<T>> tries;

	public NodeTrie(double bottomRightX, double bottomRightY, double topLeftX, double topLeftY) {
		super(bottomRightX, bottomRightY, topLeftX, topLeftY);
	}

	void accept​(Visitor<T> visitor) {
		visitor.visit(this);
	}

	void collectAll​(java.util.Set<T> points) {

	}

	void collectNear​(double x, double y, double radius, Set<T> nodes) {

	}

	void delete​(T point) {
		tries.containsValue(this);
	}

	T find​(T point) {
		if(tries.containsValue(point)) return point;
		return null;
	}

	Collection<Trie<T>> getTries() {
		return null; // idk yet
	}

	Trie<T> insert(T point) {
		return this;
	}

	Trie<T> insertReplace(T point) {
		return this;
	}

	Trie.Quadrant quadrantOf(T point) {
		for(Entry<Quadrant, Trie<T>> entry: tries.entrySet()) {
			 if (entry.getValue().equals(point)) return entry.getKey();
		}
		return null;
	}

	@Override
	public String toString() {
		return "NodeTrie [tries=" + tries + "]";
	}
	
}
