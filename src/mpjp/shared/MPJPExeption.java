package mpjp.shared;

public class MPJPExeption 
extends Exception {

	private static final long serialVersionUID = -6988465460765724246L;

	public MPJPExeption() {
		super();
	}

	public MPJPExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public MPJPExeption(String message, Throwable cause) {
		super(message, cause);
			}

	public MPJPExeption(String message) {
		super(message);

	}

	public MPJPExeption(Throwable cause) {
		super(cause);
	
	}


}
