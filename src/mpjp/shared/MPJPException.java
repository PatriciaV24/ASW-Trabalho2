package mpjp.shared;

public class MPJPException extends Exception {

	private static final long serialVersionUID = -6988465460765724246L;

	public MPJPException() {
		super();
	}

	public MPJPException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public MPJPException(String message, Throwable cause) {
		super(message, cause);
			}

	public MPJPException(String message) {
		super(message);

	}

	public MPJPException(Throwable cause) {
		super(cause);
	
	}


}
