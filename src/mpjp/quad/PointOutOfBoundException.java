package mpjp.quad;

/**
 * Exception raised when the quad tree is used with a point outside its
 * boundaries. Programmers can easily avoid these exceptions by checking points
 * before attempting to insert them in a quad tree. Since it extends
 * RuntimeException, it is not mandatory to handle this kind of exception.
 * 
 * @author Manuel Sá up201805273
 * @author Patricia Vieira up201805238
 */
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
