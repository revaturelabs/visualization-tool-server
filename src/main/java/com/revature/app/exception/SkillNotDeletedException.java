package com.revature.app.exception;

@SuppressWarnings("serial")
public class SkillNotDeletedException extends Exception {

	public SkillNotDeletedException() {
	}

	public SkillNotDeletedException(String message) {
		super(message);
	}

	public SkillNotDeletedException(Throwable cause) {
		super(cause);
	}

	public SkillNotDeletedException(String message, Throwable cause) {
		super(message, cause);
	}

	public SkillNotDeletedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
