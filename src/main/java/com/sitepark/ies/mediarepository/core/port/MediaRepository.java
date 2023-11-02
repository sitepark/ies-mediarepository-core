package com.sitepark.ies.mediarepository.core.port;

import java.util.List;

import com.sitepark.ies.mediarepository.core.domain.entity.MediaReference;

/**
 * Interface of the media repository that defines all the methods
 * required for the use cases.
 */
public interface MediaRepository {
	void addReference(MediaReference reference);
	void remove(long mediaId);
	void removeReferencesUsedBy(long usedBy);
	List<MediaReference> getReferencesUsedBy(long usedBy);
	List<MediaReference> getReferencesByMedia(long mediaId);
}
