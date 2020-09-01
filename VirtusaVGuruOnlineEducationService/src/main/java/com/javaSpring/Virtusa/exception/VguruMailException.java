package com.javaSpring.Virtusa.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class VguruMailException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VguruMailException(String exMessage, Object e) {
	        super(exMessage);
	    }

	    public VguruMailException(String exMessage) {
	        super(exMessage);
	    }

}
