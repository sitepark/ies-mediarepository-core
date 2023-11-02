package com.sitepark.ies.mediarepository.core.domain.entity;

import java.util.Objects;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * Indicates that the medium is used by an entity. The reference is also
 * assigned a type that indicates whether the medium is embedded or only
 * linked.
 */
@SuppressFBWarnings("PI_DO_NOT_REUSE_PUBLIC_IDENTIFIERS_CLASS_NAMES")
public class MediaReference {

	private final long mediaId;
	final long usedBy;
	private final MediaReferenceType type;

	protected MediaReference(Builder builder) {
		this.mediaId = builder.mediaId;
		this.usedBy = builder.usedBy;
		this.type = builder.type;
	}

	public long getMediaId() {
		return this.mediaId;
	}

	public long getUsedBy() {
		return this.usedBy;
	}

	public MediaReferenceType getType() {
		return this.type;
	}

	@Override
	public final int hashCode() {
		return Objects.hash(
				this.mediaId,
				this.usedBy,
				this.type);
	}

	@Override
	public final boolean equals(Object o) {

		if (!(o instanceof MediaReference)) {
			return false;
		}

		MediaReference ref = (MediaReference)o;

		return
				Objects.equals(this.mediaId, ref.mediaId) &&
				Objects.equals(this.usedBy, ref.usedBy) &&
				Objects.equals(this.type, ref.type);
	}

	public static Builder builder() {
		return new Builder();
	}

	public Builder toBuilder() {
		return new Builder(this);
	}

	public static class Builder {

		private long mediaId;
		private long usedBy;
		private MediaReferenceType type;

		protected Builder() {}

		protected Builder(MediaReference media) {
			this.mediaId = media.mediaId;
			this.usedBy = media.usedBy;
			this.type = media.type;
		}

		public Builder mediaId(long mediaId) {
			if (mediaId <= 0) {
				throw new IllegalArgumentException("mediaId should be greater than 0");
			}
			this.mediaId = mediaId;
			return this;
		}

		public Builder usedBy(long usedBy) {
			if (usedBy <= 0) {
				throw new IllegalArgumentException("usedBy should be greater than 0");
			}
			this.usedBy = usedBy;
			return this;
		}
		public Builder type(MediaReferenceType type) {
			if (type == null) {
				throw new NullPointerException("type is null");
			}
			this.type = type;
			return this;
		}
		public MediaReference build() {

			if (this.mediaId == 0) {
				throw new IllegalStateException("mediaId not set");
			}
			if (this.usedBy == 0) {
				throw new IllegalStateException("usedBy not set");
			}
			if (this.type == null) {
				throw new IllegalStateException("type not set");
			}

			return new MediaReference(this);
		}
	}
}
