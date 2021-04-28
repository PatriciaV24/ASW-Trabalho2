package mpjp.quad;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import mpjp.shared.HasPoint;

public class NodeTrie<T extends HasPoint> extends Trie<T> {
	Map<Quadrant, Trie<T>> tries;

	public NodeTrie (double topLeftX, double topLeftY, double bottomRightX, double bottomRightY){
		super(topLeftX, topLeftY, bottomRightX, bottomRightY);

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
		
	}

	@Override
	Trie<T> insertReplace(T point) {
		Trie<T> trie = tries.get(this.quadrantOf(point));
		return trie.insertReplace(point);
	}


	Quadrant quadrantOf(T point) {
		double centerx, centery;
		centerx= (this.bottomRightX+this.topLeftX)/2;
		centery= (this.bottomRightY+this.topLeftY)/2;		
		if(point.getX()> centerx && point.getY()> centery)
			return Quadrant.NE;
		if(point.getX()> centerx && point.getY()< centery)
			return Quadrant.SE;
		if(point.getX()< centerx && point.getY()> centery)
			return Quadrant.NW;
		if(point.getX()< centerx && point.getY()< centery)
			return Quadrant.SW;
	
		return null;
	}


	@Override
	public String toString() {
		return "NodeTrie [tries=" + tries + "]";
	}
}




	

