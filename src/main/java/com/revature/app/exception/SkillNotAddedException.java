package com.revature.app.exception;

@SuppressWarnings("serial")
public class SkillNotAddedException extends Exception {

	public SkillNotAddedException() {
	}

	public SkillNotAddedException(String message) {
		super(message);
	}

	public SkillNotAddedException(Throwable cause) {
		super(cause);
	}

	public SkillNotAddedException(String message, Throwable cause) {
		super(message, cause);
	}

	public SkillNotAddedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
