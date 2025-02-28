package com.sitepark.ies.mediarepository.core.domain.exception;

import java.io.Serial;

/**
 * Base exception from which all specific exceptions to the media
 * repository inherit.
 */
public abstract class MediaRepositoryException extends RuntimeException {

  @Serial private static final long serialVersionUID = 1L;

  public MediaRepositoryException(String message) {
    super(message);
  }
}
