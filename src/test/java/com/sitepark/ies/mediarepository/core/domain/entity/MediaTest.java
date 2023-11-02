package com.sitepark.ies.mediarepository.core.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

class MediaTest {

	@Test
	@SuppressWarnings("PMD.JUnitTestsShouldIncludeAssert")
	void testEquals() {
		EqualsVerifier.forClass(Media.class)
			.verify();
	}

	@Test
	void testSetId() {
		Media media = Media.builder().id(123).build();
		assertEquals(123, media.getId().get(), "unexpected id");
	}

	@Test
	void testGetEmptyId() {
		Media media = Media.builder().build();
		assertTrue(media.getId().isEmpty(), "id should be empty");
	}

	@Test
	void testSetInvalidId() {
		assertThrows(IllegalArgumentException.class, () -> {
			Media.builder().id(0);
		}, "id 0 should't be allowed");
	}
}
