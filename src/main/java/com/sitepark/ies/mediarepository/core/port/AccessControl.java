package com.sitepark.ies.mediarepository.core.port;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * Port via which the required rights can be queried.
 */
@SuppressFBWarnings
public interface AccessControl {
	boolean isMediaRemovable(long id);
}
