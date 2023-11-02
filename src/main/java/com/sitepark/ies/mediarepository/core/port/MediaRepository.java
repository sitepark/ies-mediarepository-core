package com.sitepark.ies.mediarepository.core.port;

import java.util.List;

import com.sitepark.ies.mediarepository.core.domain.entity.MediaReference;

public interface MediaRepository {
	void addReference(MediaReference reference);
	void remove(long mediaId);
	void removeReferencesUsedBy(long usedBy);
	List<MediaReference> getReferencesUsedBy(long usedBy);
	List<MediaReference> getReferencesByMedia(long mediaId);
}
