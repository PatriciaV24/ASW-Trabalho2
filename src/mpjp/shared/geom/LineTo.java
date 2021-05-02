package mpjp.shared.geom;
/**
 * A line segment from the previous point to the given one.
 * 
 * @author Manuel Sá up201805273
 * @author Patricia Vieira up201805238
 */
import java.io.Serializable;

public class LineTo implements Segment, Serializable {
	private static final long serialVersionUID = -4455738333199971600L;
	Point endPoint;
	
	/** Constructor-An empty instance*/
	public LineTo() {}

	/**
	 * A line segment to the given end point
	 * @param endPoint
	 */
	public LineTo(Point endPoint) {
		this.endPoint = endPoint;
	}
	
	/**
	 * The current end point
	 * @return endPoint - end point
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
