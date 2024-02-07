package com.sitepark.ies.mediarepository.core.usecase;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.sitepark.ies.mediarepository.core.domain.entity.MediaReference;
import com.sitepark.ies.mediarepository.core.domain.entity.MediaReferenceType;
import com.sitepark.ies.mediarepository.core.port.MediaRepository;
import org.junit.jupiter.api.Test;

class AddReferenceTest {

  @Test
  void testAddReference() {

    MediaRepository repository = mock(MediaRepository.class);

    MediaReference ref =
        MediaReference.builder()
            .mediaId("10")
            .usedBy("12")
            .type(MediaReferenceType.EMBEDDED)
            .build();

    var addReference = new AddReference(repository);
    addReference.addReference(ref);

    verify(repository).addReference(ref);
  }
}
