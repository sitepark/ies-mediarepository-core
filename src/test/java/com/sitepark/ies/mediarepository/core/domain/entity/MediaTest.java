package com.sitepark.ies.mediarepository.core.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

class MediaTest {

  @Test
  void testEquals() {
    EqualsVerifier.forClass(Media.class).verify();
  }

  @Test
  void testSetId() {
    Media media = Media.builder().id("123").build();
    assertEquals("123", media.getId().orElse(""), "unexpected id");
  }

  @Test
  void testGetEmptyId() {
    Media media = Media.builder().build();
    assertTrue(media.getId().isEmpty(), "id should be empty");
  }

  @Test
  void testSetInvalidId() {
    assertThrows(
        NullPointerException.class, () -> Media.builder().id(null), "id should not be null");
  }

  @Test
  void testToBuilder() {

    Media media = Media.builder().id("123").build();
    Media copy = media.toBuilder().id("345").build();
    Media expected = Media.builder().id("345").build();

    assertEquals(expected, copy, "unexpected media copy");
  }
}
