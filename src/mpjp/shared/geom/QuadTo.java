package mpjp.shared.geom;

import java.io.Serializable;

public class QuadTo implements Segment, Serializable {
/**
*	public class QuadTo
*	extends java.lang.Object
*	implements Segment, java.io.Serializable
*	
*	A segment of a quadratic curve from the previous point to the given one. The given control point
*	defines 2 lines, one with the starting point, 
*	an the other with the end point. 
*	These lines are tangents to the quadratic curve, respectively on the starting and end points.
*/
	
	private static final long serialVersionUID = 6134546084561227628L;
	Point controlPoint;
	Point endPoint;

	public QuadTo() {
	}

	public QuadTo(Point controlPoint, Point endPoint) {
		this.controlPoint = controlPoint;
		this.endPoint = endPoint;
	}

	public Point getControlPoint() {
		return controlPoint;
	}

	public void setControlPoint(Point controlPoint) {
		this.controlPoint = controlPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
}
