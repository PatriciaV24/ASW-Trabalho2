package mpjp.shared.geom;

import java.io.Serializable;

public class LineTo implements Segment, Serializable {
	private static final long serialVersionUID = -4455738333199971600L;
	Point endPoint;

	public LineTo() {}

	public LineTo(Point endPoint) {
		this.endPoint = endPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

}
