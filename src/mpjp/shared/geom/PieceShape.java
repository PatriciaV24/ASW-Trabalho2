package mpjp.shared.geom;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PieceShape 
implements Serializable {
	private static final long serialVersionUID = 6987016641965349831L;
	List<Segment> segments;
	Point startPoint;

	public PieceShape() {}

	public PieceShape(Point startPoint) {
		segments= new ArrayList<Segment>();
		this.startPoint = startPoint;
	}

	public PieceShape(Point startPoint, List<Segment> segments) {
		this.segments = segments;
		this.startPoint = startPoint;
	}

	public List<Segment> getSegments() {
		return segments;
	}

	public void setSegments(List<Segment> segments) {
		this.segments = segments;
	}

	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public PieceShape addSegment(Segment segment) {
		segments.add(segment);
		return this;
	}

}
