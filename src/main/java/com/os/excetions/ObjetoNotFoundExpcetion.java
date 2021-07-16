package com.os.excetions;

public class ObjetoNotFoundExpcetion extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ObjetoNotFoundExpcetion(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ObjetoNotFoundExpcetion(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
