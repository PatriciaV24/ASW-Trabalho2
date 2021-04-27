package mpjp.shared.geom;
import java.io.Serializable;

public class CurveTo implements Segment, Serializable {
	private static final long serialVersionUID = -5409814925512765064L;
	Point controlPoint1;
	Point ControlPoint2;
	Point endPoint;

	public CurveTo() {}

	public CurveTo(Point controlPoint1, Point controlPoint2, Point endPoint) {
		this.controlPoint1 = controlPoint1;
		ControlPoint2 = controlPoint2;
		this.endPoint = endPoint;
	}

	public Point getControlPoint1() {
		return controlPoint1;
	}

	public void setControlPoint1(Point controlPoint1) {
		this.controlPoint1 = controlPoint1;
	}

	public Point getControlPoint2() {
		return ControlPoint2;
	}

	public void setControlPoint2(Point controlPoint2) {
		ControlPoint2 = controlPoint2;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

}
