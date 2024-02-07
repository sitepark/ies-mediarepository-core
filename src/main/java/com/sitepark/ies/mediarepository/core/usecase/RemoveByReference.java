package com.sitepark.ies.mediarepository.core.usecase;

import java.util.List;
import java.util.stream.Collectors;

import com.sitepark.ies.mediarepository.core.domain.entity.MediaReference;
import com.sitepark.ies.mediarepository.core.domain.entity.MediaReferenceType;
import com.sitepark.ies.mediarepository.core.port.MediaRepository;

import jakarta.inject.Inject;

/**
 * Removes a medium via its reference. If this is the only or last reference
 * of the medium, the medium is deleted. Otherwise, only the reference is
 * removed.
 */
public final class RemoveByReference {

	private final MediaRepository repository;

	@Inject
	protected RemoveByReference(MediaRepository repository) {
		this.repository = repository;
	}

	public void removeByReference(String usedBy) {

		List<MediaReference> embeddedReferenceList =
				this.repository.getReferencesUsedBy(usedBy).stream()
				.filter(ref -> ref.getType() == MediaReferenceType.EMBEDDED)
				.collect(Collectors.toList());

		this.repository.removeReferencesUsedBy(usedBy);

		List<String> mediaList = embeddedReferenceList.stream()
				.map(ref -> ref.getMediaId())
				.distinct()
				.collect(Collectors.toList());

		this.removeMediaOnlyAssociatedWithDeletedEmbeddedReference(usedBy, mediaList);
	}

	@SuppressWarnings("PMD.AvoidLiteralsInIfCondition")
	private void removeMediaOnlyAssociatedWithDeletedEmbeddedReference(String usedBy, List<String> mediaList) {
		for (String mediaId : mediaList) {
			List<MediaReference> mediaReferenceList = this.repository.getReferencesByMedia(mediaId);

			/*
			 * The media repository does not have its own referrer table yet and this.repository.getReferencesByMedia()
			 * therefore still uses the LinkContent table.
			 *
			 * this.repository.removeReferencesUsedBy(usedBy); also has no effect yet. Therefore
			 * mediaReferenceList still contains the usedBy id. Therefore it is first queried,
			 * whether the list size = 1 and contains usedBy.
			 *
			 * With a real reference table for the mediaRepository then applies:
			 *
			if (mediaReferenceList.isEmpty()) {
				this.repository.remove(mediaId);
			}
			*/

			if (mediaReferenceList.isEmpty()) {
				this.repository.remove(mediaId);
			} else if (mediaReferenceList.size() == 1) {
				MediaReference mediaReference = mediaReferenceList.get(0);
				if (mediaReference.getUsedBy().equals(usedBy)) {
					this.repository.remove(mediaId);
				}
			}
		}
	}
}
