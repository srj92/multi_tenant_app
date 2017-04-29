package co.md.exception;

public class ServiceException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public ServiceException(Exception e) {
		super(e);
		this.message = e.getMessage();
	}
	
	public ServiceException(String message) {
		this.message = message;
	}
	
	public ServiceException(Throwable cause) {
		super(cause);
		this.message = cause.getMessage();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
