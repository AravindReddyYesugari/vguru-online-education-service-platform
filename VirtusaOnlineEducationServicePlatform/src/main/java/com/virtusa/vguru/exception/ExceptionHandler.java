package com.virtusa.vguru.exception;

public class ExceptionHandler  extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExceptionHandler(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public ExceptionHandler(String exMessage) {
        super(exMessage);
    }
}
