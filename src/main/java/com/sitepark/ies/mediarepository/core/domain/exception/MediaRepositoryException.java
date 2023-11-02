package com.sitepark.ies.mediarepository.core.domain.exception;

public abstract class MediaRepositoryException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MediaRepositoryException(String message) {
		super(message);
	}
}
