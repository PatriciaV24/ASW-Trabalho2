package mpjp.quad;

public class PointOutOfBoundException extends RuntimeException {
	private static final long serialVersionUID = 3728874182166709818L;

	public PointOutOfBoundException() {
	}

	public PointOutOfBoundException(String message) {
		super(message);
	}

	public PointOutOfBoundException(Throwable cause) {
		super(cause);
	}

	public PointOutOfBoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PointOutOfBoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
