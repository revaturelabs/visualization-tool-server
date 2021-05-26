package com.revature.app.exception;

@SuppressWarnings("serial")
public class SkillNotFoundException extends Exception {

	public SkillNotFoundException() {
	}

	public SkillNotFoundException(String message) {
		super(message);
	}

	public SkillNotFoundException(Throwable cause) {
		super(cause);
	}

	public SkillNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public SkillNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
