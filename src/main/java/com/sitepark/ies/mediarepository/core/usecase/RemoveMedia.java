package com.sitepark.ies.mediarepository.core.usecase;

import javax.inject.Inject;

import com.sitepark.ies.mediarepository.core.domain.exception.AccessDeniedException;
import com.sitepark.ies.mediarepository.core.port.AccessControl;
import com.sitepark.ies.mediarepository.core.port.MediaRepository;

public final class RemoveMedia {

	private final MediaRepository repository;
	private final AccessControl accessControl;

	@Inject
	protected RemoveMedia(MediaRepository repository, AccessControl accessControl) {
		this.repository = repository;
		this.accessControl = accessControl;
	}

	public void removeMedia(long id) {

		if (!this.accessControl.isMediaRemovable(id)) {
			throw new AccessDeniedException("Not allowed to remove media " + id);
		}

		this.repository.remove(id);
	}

}
