package com.sitepark.ies.mediarepository.core.port;

/**
 * Port via which the required rights can be queried.
 */
@SuppressWarnings("PMD.ImplicitFunctionalInterface")
public interface AccessControl {
  boolean isMediaRemovable(String id);
}
