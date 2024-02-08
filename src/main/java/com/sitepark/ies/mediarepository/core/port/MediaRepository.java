package com.sitepark.ies.mediarepository.core.port;

import com.sitepark.ies.mediarepository.core.domain.entity.MediaReference;
import java.util.List;

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
