package com.sitepark.ies.mediarepository.core.port;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@SuppressFBWarnings
public interface AccessControl {
	boolean isMediaRemovable(long id);
}
