package com.sitepark.ies.mediarepository.core.domain.exception;

import java.io.Serial;

/**
 * This error occurs if an action in the repository is not
 * allowed for the executing subject.
 */
public class AccessDeniedException extends MediaRepositoryException {
  @Serial private static final long serialVersionUID = 1L;

  public AccessDeniedException(String message) {
    super(message);
  }
}
