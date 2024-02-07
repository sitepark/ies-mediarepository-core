package com.sitepark.ies.mediarepository.core.usecase;


import com.sitepark.ies.mediarepository.core.domain.entity.MediaReference;
import com.sitepark.ies.mediarepository.core.port.MediaRepository;

import jakarta.inject.Inject;

/**
 * Adds a reference to the medium.
 */
public final class AddReference {

	private final MediaRepository repository;

	@Inject
	protected AddReference(MediaRepository repository) {
		this.repository = repository;
	}

	public void addReference(MediaReference reference) {
		this.repository.addReference(reference);
	}

}
