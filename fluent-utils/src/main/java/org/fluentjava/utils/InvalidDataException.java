package org.fluentjava.utils;


public class InvalidDataException extends RuntimeException {

	public InvalidDataException() {

		// empty constructor
	}

	public InvalidDataException(final String message) {

		super(message);
	}

	public InvalidDataException(final Throwable cause) {

		super(cause);
	}

	public InvalidDataException(final String message, final Throwable cause) {

		super(message, cause);
	}

	public InvalidDataException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {

		super(message, cause, enableSuppression, writableStackTrace);
	}

}
