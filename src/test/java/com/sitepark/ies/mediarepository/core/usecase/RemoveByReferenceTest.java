package com.sitepark.ies.mediarepository.core.usecase;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

import com.sitepark.ies.mediarepository.core.port.MediaRepository;

class RemoveByReferenceTest {

	@Test
	void testRemoveReferencesUsedBy() {

		MediaRepository repository = mock(MediaRepository.class);

		var removeByReference = new RemoveByReference(repository);
		removeByReference.removeByReference(10L);

		verify(repository).removeReferencesUsedBy(10L);
	}
}
