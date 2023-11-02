package com.sitepark.ies.mediarepository.core.usecase;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.sitepark.ies.mediarepository.core.domain.exception.AccessDeniedException;
import com.sitepark.ies.mediarepository.core.port.AccessControl;
import com.sitepark.ies.mediarepository.core.port.MediaRepository;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

class RemoveMediaTest {

	@Test
	@SuppressFBWarnings("RV_EXCEPTION_NOT_THROWN")
	void testAccessDenied() {

		AccessControl accessControl = mock(AccessControl.class);
		when(accessControl.isMediaRemovable(anyLong())).thenReturn(false);

		var removeMedia = new RemoveMedia(
				null,
				accessControl);
		assertThrows(AccessDeniedException.class, () -> {
			removeMedia.removeMedia(10L);
		});
	}

	@SuppressWarnings("PMD")
	@Test
	void testRemoveMedia() {

		AccessControl accessControl = mock(AccessControl.class);
		when(accessControl.isMediaRemovable(anyLong())).thenReturn(true);

		MediaRepository repository = mock(MediaRepository.class);

		var removeMedia = new RemoveMedia(
				repository,
				accessControl);
		removeMedia.removeMedia(10L);

		verify(repository).remove(10L);
	}
}
