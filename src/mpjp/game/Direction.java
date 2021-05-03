package mpjp.game;

/**
 * Directions in the plane. Each direction can be translated to a signal
 * variation in both the X and Y axis, using the getSignalX() and getSignalY().
 * The methods return a value in { -1, 0, 1}.
 * 
 * @author Manuel Sá up201805273
 * @author Patricia Vieira up201805238
 */
public enum Direction {
	EAST, NORTH, SOUTH, WEST;

	int getSignalX() {
		switch (this) {
		case EAST:
			return 1;
		case WEST:
			return -1;
		case NORTH:
			return 0;
		case SOUTH:
			return 0;
		default:
			return -2;
		}
	}

	int getSignalY() {
		switch (this) {
		case EAST:
			return 0;
		case WEST:
			return 0;
		case NORTH:
			return -1;
		case SOUTH:
			return 1;
		default:
			return -2;
		}

	}
}
