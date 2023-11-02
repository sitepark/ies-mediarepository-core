package com.sitepark.ies.mediarepository.core.usecase;

import javax.inject.Inject;

import com.sitepark.ies.mediarepository.core.domain.entity.MediaReference;
import com.sitepark.ies.mediarepository.core.port.MediaRepository;

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
