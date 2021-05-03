package mpjp.shared;

import java.io.Serializable;

import mpjp.shared.geom.Point;

/**
 * The current status of a single puzzle's piece. The piece is identified by an
 * integer, and has and a block, a position, rotation. A block is a set of
 * connected pieces When the puzzle's pieces are scattered each piece is in a
 * block containing a single piece. When 2 pieces are connected they become part
 * of the same block, as well as the other pieces belonging to their previous
 * blocks. Connected pieces - belonging to the same block - are moved together.
 * The position of a piece is determined by it's center. The center corresponds
 * to a point in the panel of PuzzleStructure. At any moment, the piece's
 * visualization is completely determined by its position and rotation.
 * Depending of the puzzle's features, a piece may be able to rotate. Simple
 * puzzles don't allow rotation. If rotated, a piece can only be connected to
 * another piece with the same rotation. When a piece is rotated, all pieces in
 * the same block are updated to the same angle.
 *
 * @author Manuel Sá up201805273
 * @author Patricia Vieira up201805238
 */
public class PieceStatus implements HasPoint, Serializable {
	private static final long serialVersionUID = 5048712326092057583L;
	int block;
	int id;
	Point position;
	double rotation;

	/** Constructor */
	public PieceStatus() {
	}
	
	/** Constructor */
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
