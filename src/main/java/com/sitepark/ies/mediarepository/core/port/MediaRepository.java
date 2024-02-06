package com.sitepark.ies.mediarepository.core.port;

import java.util.List;

import com.sitepark.ies.mediarepository.core.domain.entity.MediaReference;

/**
 * Interface of the media repository that defines all the methods
 * required for the use cases.
 */
public interface MediaRepository {
	void addReference(MediaReference reference);
	void remove(String mediaId);
	void removeReferencesUsedBy(String usedBy);
	List<MediaReference> getReferencesUsedBy(String usedBy);
	List<MediaReference> getReferencesByMedia(String mediaId);
}
