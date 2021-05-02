package mpjp.shared.geom;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * Representation of the boundary if a piece as an initial Point followed by by a list of Segment. 
 * This is an abstraction of a path as available in several graphic packages, such as java.awt.geom or HTML Canvas.
 * For each piece, the origin of the coordinates is its geometric center. 
 * Hence, two pieces with the same shape have the same boundary representation. 
 * This approach enables piece positioning using translations. The coordinate system is simply translated to the point where the piece must be positioned and then it is drawn using this representation.
 * Shapes are typically created using chaining using addSegment(Segment).
 * This method returns the instance itself and thus can be used as context to another invocation of the same method. 
 *
 * @author Manuel Sá up201805273
 * @author Patricia Vieira up201805238
 *
 */
public class PieceShape 
implements Serializable {
	private static final long serialVersionUID = 6987016641965349831L;
	/**List of segments, each starting at the end of the preceding one, or the start point.*/
	List<Segment> segments;
	/**Start point of this shape*/
	Point startPoint; 

	/** Constructor-Create an empty piece shape*/
	public PieceShape() {}

	/**
	 * Create a piece shape with an initial point. Other segments can be subsequently added.
	 * @param startPoint - start point
	 */
	public PieceShape(Point startPoint) {
		this.segments= new ArrayList<Segment>();
		this.startPoint = startPoint;
	}

	/**
	 * Create a complete shape from an initial point as a list of segments
	 *
	 * @param startPoint - start point
	 * @param segments - initialization of the list with the received values  
	 */
	public PieceShape(Point startPoint, List<Segment> segments) {
		this.segments = segments;
		this.startPoint = startPoint;
	}

	/**
	 * The current starting point
	 * @return startPoint
	 */
	public Point getStartPoint() {
		return startPoint;
	}
	
	/**
	 * Change the starting point
	 * @param startPoint - start point
	 */
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	
	/**
	 * The current list of segments
	 * @return segments
	 */
	public List<Segment> getSegments() {
		return segments;
	}
	
	/**
	 * Change the list of segments
	 * @param segments
	 */
	public void setSegments(List<Segment> segments) {
		this.segments = segments;
	}

	/**
	 * Add a segment to this shape
	 * @param segment
	 * @return this-instance, to allow chaining
	 */
	public PieceShape addSegment(Segment segment) {
		segments.add(segment);
		return this;
	}

}
