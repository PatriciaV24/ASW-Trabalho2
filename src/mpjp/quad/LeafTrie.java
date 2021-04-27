package mpjp.quad;

import java.util.Set;

import mpjp.shared.HasPoint;

import java.util.Collection;
public class LeafTrie<T extends HasPoint> extends Trie<T>{

	public LeafTrie(double bottomRightX, double bottomRightY, double topLeftX, double topLeftY) {
		super(bottomRightX, bottomRightY, topLeftX, topLeftY);
	}

 	void accept​(Visitor<T> visitor) {
 		visitor.visit(this);
 	}
 	void collectAll​(Set<T> nodes) {
 		
 		nodes.addAll(this.getPoints());
 	}
 	
 	void collectNear​(double x, double y, double radius, Set<T> nodes) {
 		
 	}
 	void delete​(T point) {
 		
 	}
 	T find​(T point) {
 		
 	}
 	
 	Collection<T> getPoints(){
 		
 	}
 	
 	Trie<T> insert​(T point) {
 		
 	}
 	
 	Trie<T> insertReplace​(T point){
 		
 	}
 	
	@Override
	public String toString() {
		return "LeafTrie []";
	}
	

}
