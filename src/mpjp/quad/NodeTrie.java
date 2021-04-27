package mpjp.quad;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import mpjp.quad.Trie.Quadrant;
import mpjp.shared.HasPoint;

public class NodeTrie<T extends HasPoint> extends Trie<T> {
	Map<Quadrant, Trie<T>> tries;

	public NodeTrie(double bottomRightX, double bottomRightY, double topLeftX, double topLeftY) {
		super(bottomRightX, bottomRightY, topLeftX, topLeftY);
	}

	void accept​(Visitor<T> visitor) {

	}

	void collectAll​(java.util.Set<T> points) {

	}

	void collectNear​(double x, double y, double radius, Set<T> nodes) {

	}

	void delete​(T point) {

	}

	T find​(T point) {
		return point;
	}

	Collection<Trie<T>> getTries() {
		return; // idk yet
	}

	Trie<T> insert(T point) {
		return;
	}

	Trie<T> insertReplace(T point) {
		return;
	}

	Trie.Quadrant quadrantOf(T point) {
		return;
	}

	@Override
	public String toString() {
		return "NodeTrie [tries=" + tries + "]";
	}
	
	
}
