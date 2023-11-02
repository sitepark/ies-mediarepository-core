package com.sitepark.ies.mediarepository.core.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import nl.jqno.equalsverifier.EqualsVerifier;

class MediaReferenceTest {

	@Test
	@SuppressWarnings("PMD.JUnitTestsShouldIncludeAssert")
	void testEquals() {
		EqualsVerifier.forClass(MediaReference.class)
			.verify();
	}

	@Test
	void testSetMediaId() {
		MediaReference ref = MediaReference.builder()
				.mediaId(123)
				.usedBy(123)
				.type(MediaReferenceType.EMBEDDED)
				.build();
		assertEquals(123, ref.getMediaId(), "unexpected mediaId");
	}

	@Test
	@SuppressFBWarnings("RV_EXCEPTION_NOT_THROWN")
	void testMissingMediaId() {
		assertThrows(IllegalStateException.class, () -> {
			MediaReference.builder()
			.usedBy(123)
			.type(MediaReferenceType.EMBEDDED);
		});
	}


	@Test
	@SuppressFBWarnings("RV_EXCEPTION_NOT_THROWN")
	void testSetInvalidMediaId() {
		assertThrows(IllegalArgumentException.class, () -> {
			MediaReference.builder().mediaId(0);
		}, "mediaId 0 should't be allowed");
	}

	@Test
	void testSetUsedBy() {
		MediaReference ref = MediaReference.builder()
				.mediaId(123)
				.usedBy(123)
				.type(MediaReferenceType.EMBEDDED)
				.build();
		assertEquals(123, ref.getUsedBy(), "unexpected usedBy");
	}

	@Test
	@SuppressFBWarnings("RV_EXCEPTION_NOT_THROWN")
	void testMissingUsedBy() {
		assertThrows(IllegalStateException.class, () -> {
			MediaReference.builder()
			.mediaId(123)
			.type(MediaReferenceType.EMBEDDED);
		});
	}

	@Test
	@SuppressFBWarnings("RV_EXCEPTION_NOT_THROWN")
	void testSetInvalidUsedBy() {
		assertThrows(IllegalArgumentException.class, () -> {
			MediaReference.builder().usedBy(0);
		}, "usedBy 0 should't be allowed");
	}

	@Test
	void testSetType() {
		MediaReference ref = MediaReference.builder()
				.mediaId(123)
				.usedBy(123)
				.type(MediaReferenceType.EMBEDDED)
				.build();
		assertEquals(
				MediaReferenceType.EMBEDDED,
				ref.getType(),
				"unexpected type");
	}

	@Test
	@SuppressFBWarnings({
			"NP_NULL_PARAM_DEREF_ALL_TARGETS_DANGEROUS",
			"RV_EXCEPTION_NOT_THROWN"
	})
	void testSetNullType() {
		assertThrows(NullPointerException.class, () -> {
			MediaReference.builder().type(null);
		}, "type null should't be allowed");
	}

	@Test
	@SuppressFBWarnings("RV_EXCEPTION_NOT_THROWN")
	void testMissingType() {
		assertThrows(IllegalStateException.class, () -> {
			MediaReference.builder()
			.mediaId(123)
			.usedBy(123);
		});
	}
}
