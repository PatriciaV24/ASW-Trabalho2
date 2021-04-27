package mpjp.shared;

import java.io.Serializable;

import mpjp.shared.geom.Point;

public class PieceStatus 
implements HasPoint, Serializable {
	private static final long serialVersionUID = 5048712326092057583L;
	int block;
	int id;
	Point position;
	double rotation;

	public PieceStatus() {}

	public PieceStatus(int id, Point position) {
		this.id = id;
		this.position = position;
	}

	public int getBlock() {
		return block;
	}

	public int getId() {
		return id;
	}

	public Point getPosition() {
		return position;
	}

	public double getRotation() {
		return rotation;
	}

	@Override
	public double getX() {
		return this.position.getX();
	}

	@Override
	public double getY() {
		return this.position.getY();
	}

	public void setBlock(int block) {
		this.block = block;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public void setRotation(double rotation) {
		this.rotation = rotation;
	}

}
