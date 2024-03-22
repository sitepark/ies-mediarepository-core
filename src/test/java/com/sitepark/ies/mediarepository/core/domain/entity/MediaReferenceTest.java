package com.sitepark.ies.mediarepository.core.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

@SuppressWarnings("PMD.AvoidDuplicateLiterals")
@SuppressFBWarnings("NP_NULL_PARAM_DEREF_ALL_TARGETS_DANGEROUS")
class MediaReferenceTest {

  @Test
  @SuppressWarnings("PMD.JUnitTestsShouldIncludeAssert")
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
  @SuppressFBWarnings("RV_EXCEPTION_NOT_THROWN")
  void testMissingMediaId() {
    assertThrows(
        IllegalStateException.class,
        () -> {
          MediaReference.builder().usedBy("123").type(MediaReferenceType.EMBEDDED).build();
        });
  }

  @Test
  @SuppressFBWarnings("RV_EXCEPTION_NOT_THROWN")
  void testSetInvalidMediaId() {
    assertThrows(
        NullPointerException.class,
        () -> {
          MediaReference.builder().mediaId(null);
        },
        "mediaId should't be null");
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
  @SuppressFBWarnings("RV_EXCEPTION_NOT_THROWN")
  void testMissingUsedBy() {
    assertThrows(
        IllegalStateException.class,
        () -> {
          MediaReference.builder().mediaId("123").type(MediaReferenceType.EMBEDDED).build();
        });
  }

  @Test
  @SuppressFBWarnings("RV_EXCEPTION_NOT_THROWN")
  void testSetInvalidUsedBy() {
    assertThrows(
        NullPointerException.class,
        () -> {
          MediaReference.builder().usedBy(null);
        },
        "usedBy should't be null");
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
  @SuppressFBWarnings({"NP_NULL_PARAM_DEREF_ALL_TARGETS_DANGEROUS", "RV_EXCEPTION_NOT_THROWN"})
  void testSetNullType() {
    assertThrows(
        NullPointerException.class,
        () -> {
          MediaReference.builder().type(null);
        },
        "type null should't be allowed");
  }

  @Test
  @SuppressFBWarnings("RV_EXCEPTION_NOT_THROWN")
  void testMissingType() {
    assertThrows(
        IllegalStateException.class,
        () -> {
          MediaReference.builder().mediaId("123").usedBy("123").build();
        });
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

    assertEquals(expected, copy, "unexpected mediareference copy");
  }
}
