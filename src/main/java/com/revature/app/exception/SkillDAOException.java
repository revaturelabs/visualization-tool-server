package com.revature.app.exception;

@SuppressWarnings("serial")
public class SkillDAOException extends Exception {

	public SkillDAOException() {
	}

	public SkillDAOException(String message) {
		super(message);
	}

	public SkillDAOException(Throwable cause) {
		super(cause);
	}

	public SkillDAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public SkillDAOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
