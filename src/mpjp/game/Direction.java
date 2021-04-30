package mpjp.game;

public enum Direction {
	EAST, NORTH, SOUTH, WEST;

	int getSignalX() {
		switch (this) {
			case EAST:	return 1;
			case WEST:	return -1;
			case NORTH:	return 0;
			case SOUTH:	return 0;
			default:	return -2;
		}
	}

	int getSignalY() {
		switch (this) {
			case EAST:	return 0;
			case WEST:	return 0;
			case NORTH:	return -1;
			case SOUTH:	return 1;
			default:	return -2;
		}

	}
}
