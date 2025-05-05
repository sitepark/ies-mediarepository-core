package com.sitepark.ies.mediarepository.core.port;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * Port via which the required rights can be queried.
 */
@SuppressFBWarnings
@SuppressWarnings("PMD.ImplicitFunctionalInterface")
public interface AccessControl {
  boolean isMediaRemovable(String id);
}
