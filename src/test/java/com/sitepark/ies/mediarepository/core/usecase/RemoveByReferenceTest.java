package com.sitepark.ies.mediarepository.core.usecase;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.sitepark.ies.mediarepository.core.domain.entity.MediaReference;
import com.sitepark.ies.mediarepository.core.domain.entity.MediaReferenceType;
import com.sitepark.ies.mediarepository.core.port.MediaRepository;

class RemoveByReferenceTest {

	@Test
	void testRemoveReferencesUsedByIfReferenceIsNotOtherwiseUsed() {

		List<MediaReference> referencesByUserList = Arrays.asList(
				MediaReference.builder()
						.mediaId(123)
						.usedBy(10L)
						.type(MediaReferenceType.EMBEDDED)
						.build(),
				MediaReference.builder()
						.mediaId(1231)
						.usedBy(10L)
						.type(MediaReferenceType.LINKED)
						.build()
		);

		MediaRepository repository = mock(MediaRepository.class);
		when(repository.getReferencesUsedBy(anyLong())).thenReturn(referencesByUserList);
		when(repository.getReferencesByMedia(anyLong())).thenReturn(Collections.emptyList());

		var removeByReference = new RemoveByReference(repository);
		removeByReference.removeByReference(10L);

		verify(repository).removeReferencesUsedBy(10L);
		verify(repository).remove(123);
	}

	@Test
	void testRemoveReferencesUsedByIfReferenceUsedOnceByOwn() {

		List<MediaReference> referencesByUserList = Arrays.asList(
				MediaReference.builder()
						.mediaId(123)
						.usedBy(10L)
						.type(MediaReferenceType.EMBEDDED)
						.build(),
				MediaReference.builder()
						.mediaId(1231)
						.usedBy(1231)
						.type(MediaReferenceType.LINKED)
						.build()
		);

		List<MediaReference> referencesByMediaList = Arrays.asList(
				MediaReference.builder()
						.mediaId(123)
						.usedBy(10L)
						.type(MediaReferenceType.EMBEDDED)
						.build()
		);

		MediaRepository repository = mock(MediaRepository.class);
		when(repository.getReferencesUsedBy(anyLong())).thenReturn(referencesByUserList);
		when(repository.getReferencesByMedia(anyLong())).thenReturn(referencesByMediaList);

		var removeByReference = new RemoveByReference(repository);
		removeByReference.removeByReference(10L);

		verify(repository).removeReferencesUsedBy(10L);
		verify(repository).remove(123);
	}

	@Test
	void testRemoveReferencesUsedByIfReferenceUsedOnceByOther() {

		List<MediaReference> referencesByUserList = Arrays.asList(
				MediaReference.builder()
						.mediaId(123)
						.usedBy(10L)
						.type(MediaReferenceType.EMBEDDED)
						.build(),
				MediaReference.builder()
						.mediaId(1231)
						.usedBy(1231)
						.type(MediaReferenceType.LINKED)
						.build()
		);

		List<MediaReference> referencesByMediaList = Arrays.asList(
				MediaReference.builder()
						.mediaId(123)
						.usedBy(101L)
						.type(MediaReferenceType.EMBEDDED)
						.build()
		);

		MediaRepository repository = mock(MediaRepository.class);
		when(repository.getReferencesUsedBy(anyLong())).thenReturn(referencesByUserList);
		when(repository.getReferencesByMedia(anyLong())).thenReturn(referencesByMediaList);

		var removeByReference = new RemoveByReference(repository);
		removeByReference.removeByReference(10L);

		verify(repository).removeReferencesUsedBy(10L);
		verify(repository, never()).remove(anyLong());
	}

	@Test
	void testRemoveReferencesUsedByIfReferenceUsedSeveralTimes() {

		List<MediaReference> referencesByUserList = Arrays.asList(
				MediaReference.builder()
						.mediaId(123)
						.usedBy(10L)
						.type(MediaReferenceType.EMBEDDED)
						.build(),
				MediaReference.builder()
						.mediaId(1231)
						.usedBy(1231)
						.type(MediaReferenceType.LINKED)
						.build()
		);

		List<MediaReference> referencesByMediaList = Arrays.asList(
				MediaReference.builder()
						.mediaId(123)
						.usedBy(10L)
						.type(MediaReferenceType.EMBEDDED)
						.build(),
				MediaReference.builder()
						.mediaId(123)
						.usedBy(10L)
						.type(MediaReferenceType.EMBEDDED)
						.build()
		);

		MediaRepository repository = mock(MediaRepository.class);
		when(repository.getReferencesUsedBy(anyLong())).thenReturn(referencesByUserList);
		when(repository.getReferencesByMedia(anyLong())).thenReturn(referencesByMediaList);

		var removeByReference = new RemoveByReference(repository);
		removeByReference.removeByReference(10L);

		verify(repository).removeReferencesUsedBy(10L);
		verify(repository, never()).remove(anyLong());
	}
}
