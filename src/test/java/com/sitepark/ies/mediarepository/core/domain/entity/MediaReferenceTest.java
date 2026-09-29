package com.sitepark.ies.mediarepository.core.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

class MediaReferenceTest {

  @Test
  void testEquals() {
    EqualsVerifier.forClass(MediaReference.class).verify();
  }

  @Test
  void testSetMediaId() {
    MediaReference ref =
        MediaReference.builder()
            .mediaId("123")
            .usedBy("123")
            .type(MediaReferenceType.EMBEDDED)
            .build();
    assertEquals("123", ref.getMediaId(), "unexpected mediaId");
  }

  @Test
  void testMissingMediaId() {
    assertThrows(
        IllegalStateException.class,
        () -> MediaReference.builder().usedBy("123").type(MediaReferenceType.EMBEDDED).build());
  }

  @Test
  void testSetInvalidMediaId() {
    assertThrows(
        NullPointerException.class,
        () -> MediaReference.builder().mediaId(null),
        "mediaId should not be null");
  }

  @Test
  void testSetUsedBy() {
    MediaReference ref =
        MediaReference.builder()
            .mediaId("123")
            .usedBy("123")
            .type(MediaReferenceType.EMBEDDED)
            .build();
    assertEquals("123", ref.getUsedBy(), "unexpected usedBy");
  }

  @Test
  void testMissingUsedBy() {
    assertThrows(
        IllegalStateException.class,
        () -> MediaReference.builder().mediaId("123").type(MediaReferenceType.EMBEDDED).build());
  }

  @Test
  void testSetInvalidUsedBy() {
    assertThrows(
        NullPointerException.class,
        () -> MediaReference.builder().usedBy(null),
        "usedBy should not be null");
  }

  @Test
  void testSetType() {
    MediaReference ref =
        MediaReference.builder()
            .mediaId("123")
            .usedBy("123")
            .type(MediaReferenceType.EMBEDDED)
            .build();
    assertEquals(MediaReferenceType.EMBEDDED, ref.getType(), "unexpected type");
  }

  @Test
  void testSetNullType() {
    assertThrows(
        NullPointerException.class,
        () -> MediaReference.builder().type(null),
        "type null should not be allowed");
  }

  @Test
  void testMissingType() {
    assertThrows(
        IllegalStateException.class,
        () -> MediaReference.builder().mediaId("123").usedBy("123").build());
  }

  @Test
  void testToBuilder() {

    MediaReference ref =
        MediaReference.builder()
            .mediaId("123")
            .usedBy("123")
            .type(MediaReferenceType.EMBEDDED)
            .build();

    MediaReference copy = ref.toBuilder().mediaId("345").build();

    MediaReference expected =
        MediaReference.builder()
            .mediaId("345")
            .usedBy("123")
            .type(MediaReferenceType.EMBEDDED)
            .build();

    assertEquals(expected, copy, "unexpected media reference copy");
  }
}
