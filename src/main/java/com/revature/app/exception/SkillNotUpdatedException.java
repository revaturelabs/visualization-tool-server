package com.revature.app.exception;

@SuppressWarnings("serial")
public class SkillNotUpdatedException extends Exception {

	public SkillNotUpdatedException() {
	}

	public SkillNotUpdatedException(String message) {
		super(message);
	}

	public SkillNotUpdatedException(Throwable cause) {
		super(cause);
	}

	public SkillNotUpdatedException(String message, Throwable cause) {
		super(message, cause);
	}

	public SkillNotUpdatedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
