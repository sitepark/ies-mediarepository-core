package com.sitepark.ies.mediarepository.core.domain.exception;

/**
 * Base exception from which all specific exceptions of the media
 * repository inherit.
 */
public abstract class MediaRepositoryException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public MediaRepositoryException(String message) {
    super(message);
  }
}
