package com.sitepark.ies.mediarepository.core.usecase;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.sitepark.ies.mediarepository.core.port.AccessControl;
import com.sitepark.ies.mediarepository.core.port.MediaRepository;
import com.sitepark.ies.sharedkernel.security.AccessDeniedException;
import org.junit.jupiter.api.Test;

class RemoveMediaTest {

  @Test
  void testAccessDenied() {

    AccessControl accessControl = mock(AccessControl.class);
    when(accessControl.isMediaRemovable(any())).thenReturn(false);

    var removeMedia = new RemoveMedia(null, accessControl);
    assertThrows(AccessDeniedException.class, () -> removeMedia.removeMedia("10"));
  }

  @Test
  void testRemoveMedia() {

    AccessControl accessControl = mock(AccessControl.class);
    when(accessControl.isMediaRemovable(any())).thenReturn(true);

    MediaRepository repository = mock(MediaRepository.class);

    var removeMedia = new RemoveMedia(repository, accessControl);
    removeMedia.removeMedia("10");

    verify(repository).remove("10");
  }
}
