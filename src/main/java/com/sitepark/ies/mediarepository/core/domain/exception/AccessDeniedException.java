package com.sitepark.ies.mediarepository.core.domain.exception;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * This error occurs if an action in the repository is not
 * allowed for the executing subject.
 */
@SuppressFBWarnings("PI_DO_NOT_REUSE_PUBLIC_IDENTIFIERS_CLASS_NAMES")
public class AccessDeniedException extends MediaRepositoryException {
  private static final long serialVersionUID = 1L;

  public AccessDeniedException(String message) {
    super(message);
  }
}
