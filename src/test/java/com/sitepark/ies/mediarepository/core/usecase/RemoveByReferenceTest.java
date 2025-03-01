package com.sitepark.ies.mediarepository.core.usecase;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.sitepark.ies.mediarepository.core.domain.entity.MediaReference;
import com.sitepark.ies.mediarepository.core.domain.entity.MediaReferenceType;
import com.sitepark.ies.mediarepository.core.port.MediaRepository;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class RemoveByReferenceTest {

  @SuppressWarnings("PMD.UnitTestContainsTooManyAsserts")
  @Test
  void testRemoveReferencesUsedByIfReferenceIsNotOtherwiseUsed() {

    List<MediaReference> referencesByUserList =
        Arrays.asList(
            MediaReference.builder()
                .mediaId("123")
                .usedBy("10L")
                .type(MediaReferenceType.EMBEDDED)
                .build(),
            MediaReference.builder()
                .mediaId("1231")
                .usedBy("10L")
                .type(MediaReferenceType.LINKED)
                .build());

    MediaRepository repository = mock(MediaRepository.class);
    when(repository.getReferencesUsedBy(any())).thenReturn(referencesByUserList);
    when(repository.getReferencesByMedia(any())).thenReturn(Collections.emptyList());

    var removeByReference = new RemoveByReference(repository);
    removeByReference.removeByReference("10");

    verify(repository).removeReferencesUsedBy("10");
    verify(repository).remove("123");
  }

  @SuppressWarnings("PMD.UnitTestContainsTooManyAsserts")
  @Test
  void testRemoveReferencesUsedByIfReferenceUsedOnceByOwn() {

    List<MediaReference> referencesByUserList =
        Arrays.asList(
            MediaReference.builder()
                .mediaId("123")
                .usedBy("10")
                .type(MediaReferenceType.EMBEDDED)
                .build(),
            MediaReference.builder()
                .mediaId("1231")
                .usedBy("1231")
                .type(MediaReferenceType.LINKED)
                .build());

    List<MediaReference> referencesByMediaList =
        Collections.singletonList(
            MediaReference.builder()
                .mediaId("123")
                .usedBy("10")
                .type(MediaReferenceType.EMBEDDED)
                .build());

    MediaRepository repository = mock(MediaRepository.class);
    when(repository.getReferencesUsedBy(any())).thenReturn(referencesByUserList);
    when(repository.getReferencesByMedia(any())).thenReturn(referencesByMediaList);

    var removeByReference = new RemoveByReference(repository);
    removeByReference.removeByReference("10");

    verify(repository).removeReferencesUsedBy("10");
    verify(repository).remove("123");
  }

  @SuppressWarnings("PMD.UnitTestContainsTooManyAsserts")
  @Test
  void testRemoveReferencesUsedByIfReferenceUsedOnceByOther() {

    List<MediaReference> referencesByUserList =
        Arrays.asList(
            MediaReference.builder()
                .mediaId("123")
                .usedBy("10")
                .type(MediaReferenceType.EMBEDDED)
                .build(),
            MediaReference.builder()
                .mediaId("1231")
                .usedBy("1231")
                .type(MediaReferenceType.LINKED)
                .build());

    List<MediaReference> referencesByMediaList =
        Collections.singletonList(
            MediaReference.builder()
                .mediaId("123")
                .usedBy("101")
                .type(MediaReferenceType.EMBEDDED)
                .build());

    MediaRepository repository = mock(MediaRepository.class);
    when(repository.getReferencesUsedBy(any())).thenReturn(referencesByUserList);
    when(repository.getReferencesByMedia(any())).thenReturn(referencesByMediaList);

    var removeByReference = new RemoveByReference(repository);
    removeByReference.removeByReference("10");

    verify(repository).removeReferencesUsedBy("10");
    verify(repository, never()).remove(any());
  }

  @SuppressWarnings("PMD.UnitTestContainsTooManyAsserts")
  @Test
  void testRemoveReferencesUsedByIfReferenceUsedSeveralTimes() {

    List<MediaReference> referencesByUserList =
        Arrays.asList(
            MediaReference.builder()
                .mediaId("123")
                .usedBy("10")
                .type(MediaReferenceType.EMBEDDED)
                .build(),
            MediaReference.builder()
                .mediaId("1231")
                .usedBy("1231")
                .type(MediaReferenceType.LINKED)
                .build());

    List<MediaReference> referencesByMediaList =
        Arrays.asList(
            MediaReference.builder()
                .mediaId("123")
                .usedBy("10")
                .type(MediaReferenceType.EMBEDDED)
                .build(),
            MediaReference.builder()
                .mediaId("123")
                .usedBy("10")
                .type(MediaReferenceType.EMBEDDED)
                .build());

    MediaRepository repository = mock(MediaRepository.class);
    when(repository.getReferencesUsedBy(any())).thenReturn(referencesByUserList);
    when(repository.getReferencesByMedia(any())).thenReturn(referencesByMediaList);

    var removeByReference = new RemoveByReference(repository);
    removeByReference.removeByReference("10");

    verify(repository).removeReferencesUsedBy("10");
    verify(repository, never()).remove(any());
  }
}
