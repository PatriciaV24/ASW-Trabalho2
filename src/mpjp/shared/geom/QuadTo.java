package mpjp.shared.geom;

import java.io.Serializable;

public class QuadTo implements Segment, Serializable {
	private static final long serialVersionUID = 6134546084561227628L;
	Point controlPoint;
	Point endPoint;

	public QuadTo() {}

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
