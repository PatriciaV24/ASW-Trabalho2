package mpjp.quad;

import mpjp.shared.HasPoint;

/**
 * The Element interface, part of the abstract layer of the Visitor design
 * pattern. In this case, the elements is parameterized by HasPoint and defines
 * a method to accept a Visitor. This type must be added to the Component (Trie)
 * of the Composite to ensure that all types of the structure implement it.
 * 
 * @author Manuel Sá up201805273
 * @author Patricia Vieira up201805238
 */
public interface Element<T extends HasPoint> {
	void accept(Visitor<T> visitor);

}
