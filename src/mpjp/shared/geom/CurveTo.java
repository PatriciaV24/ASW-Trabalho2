package mpjp.shared.geom;
import java.io.Serializable;
/**
 *A segment of a cubic (Bezier) curve from the previous point to the given one. 
 *Cubic (Bezier) curve segment The given control points defines 2 lines, one with the 
 *starting point and the first control point, an the other with second control point and the end point. 
 *These lines are tangents to the cubic curve, respectively on the starting and end points.
 *
 * @author Manuel Sá up201805273
 * @author Patricia Vieira up201805238
 */

public class CurveTo implements Segment, Serializable {
	private static final long serialVersionUID = -5409814925512765064L;
	Point controlPoint1;
	Point ControlPoint2;
	Point endPoint;

	/** Constructor-An empty instance*/
	public CurveTo() {}

	/** Constructor-Bezier segment with given control points and end point
	 * @param controlPoint1 - First control point in this Bezier line
	 * @param controlPoint2 - Second control point in this Bezier line
	 * @param endPoint - End point in this Bezier line
	 * */
	public CurveTo(Point controlPoint1, Point controlPoint2, Point endPoint) {
		this.controlPoint1 = controlPoint1;
		ControlPoint2 = controlPoint2;
		this.endPoint = endPoint;
	}
	
	/**
	 * Current first control point
	 * @return controlPoint1
	 */
	public Point getControlPoint1() {
		return controlPoint1;
	}
	
	/**Change first control point
	 * @return controlPoint1 - first control point
	 */
	public void setControlPoint1(Point controlPoint1) {
		this.controlPoint1 = controlPoint1;
	}
	
	/**Current second control point
	 * @return controlPoint2
	 */
	public Point getControlPoint2() {
		return ControlPoint2;
	}

	/**
	 *Change second control point 
	 * @param controlPoint2 - second control point
	 */
	public void setControlPoint2(Point controlPoint2) {
		ControlPoint2 = controlPoint2;
	}

	/**
	 * The current end point
	 * @return endPoint
	 */
	public Point getEndPoint() {
		return endPoint;
	}
	/**
	 * Change the end point
	 * @param endPoint - end point
	 */
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

}
