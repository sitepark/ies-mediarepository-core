package com.sitepark.ies.mediarepository.core.usecase;

import com.sitepark.ies.mediarepository.core.domain.exception.AccessDeniedException;
import com.sitepark.ies.mediarepository.core.port.AccessControl;
import com.sitepark.ies.mediarepository.core.port.MediaRepository;
import jakarta.inject.Inject;

/**
 * Removes a medium
 */
public final class RemoveMedia {

  private final MediaRepository repository;
  private final AccessControl accessControl;

  @Inject
  RemoveMedia(MediaRepository repository, AccessControl accessControl) {
    this.repository = repository;
    this.accessControl = accessControl;
  }

  public void removeMedia(String id) {

    if (!this.accessControl.isMediaRemovable(id)) {
      throw new AccessDeniedException("Not allowed to remove media " + id);
    }

    this.repository.remove(id);
  }
}
