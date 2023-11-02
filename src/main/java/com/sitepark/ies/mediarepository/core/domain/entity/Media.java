package com.sitepark.ies.mediarepository.core.domain.entity;

import java.util.Objects;
import java.util.Optional;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@SuppressFBWarnings("PI_DO_NOT_REUSE_PUBLIC_IDENTIFIERS_CLASS_NAMES")
public class Media {

	private final long id;

	protected Media(Builder builder) {
		this.id = builder.id;
	}

	public Optional<Long> getId() {
		if (this.id == 0) {
			return Optional.empty();
		} else {
			return Optional.of(this.id);
		}
	}

	@Override
	public final int hashCode() {
		return Objects.hash(
				this.id);
	}

	@Override
	public final boolean equals(Object o) {

		if (!(o instanceof Media)) {
			return false;
		}

		Media media = (Media)o;

		return Objects.equals(this.id, media.id);
	}

	public static Builder builder() {
		return new Builder();
	}

	public Builder toBuilder() {
		return new Builder(this);
	}

	public static class Builder {

		private long id;

		protected Builder() {}

		protected Builder(Media media) {
			this.id = media.id;
		}

		public Builder id(long id) {
			if (id <= 0) {
				throw new IllegalArgumentException("id should be greater than 0");
			}
			this.id = id;
			return this;
		}

		public Media build() {
			return new Media(this);
		}
	}
}
