package com.sitepark.ies.mediarepository.core.domain.entity;

import java.util.Objects;

/**
 * Indicates that the medium is used by an entity. The reference is also
 * assigned a type that indicates whether the medium is embedded or only
 * linked.
 */
public class MediaReference {

  private final String mediaId;
  final String usedBy;
  private final MediaReferenceType type;

  protected MediaReference(Builder builder) {
    this.mediaId = builder.mediaId;
    this.usedBy = builder.usedBy;
    this.type = builder.type;
  }

  public String getMediaId() {
    return this.mediaId;
  }

  public String getUsedBy() {
    return this.usedBy;
  }

  public MediaReferenceType getType() {
    return this.type;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(this.mediaId, this.usedBy, this.type);
  }

  @Override
  public final boolean equals(Object o) {

    return (o instanceof MediaReference that)
        && Objects.equals(this.mediaId, that.mediaId)
        && Objects.equals(this.usedBy, that.usedBy)
        && Objects.equals(this.type, that.type);
  }

  public static Builder builder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static class Builder {

    private String mediaId;
    private String usedBy;
    private MediaReferenceType type;

    protected Builder() {}

    protected Builder(MediaReference media) {
      this.mediaId = media.mediaId;
      this.usedBy = media.usedBy;
      this.type = media.type;
    }

    public Builder mediaId(String mediaId) {
      Objects.requireNonNull(mediaId, "mediaId is null");
      this.mediaId = mediaId;
      return this;
    }

    public Builder usedBy(String usedBy) {
      Objects.requireNonNull(usedBy, "usedBy is null");
      this.usedBy = usedBy;
      return this;
    }

    public Builder type(MediaReferenceType type) {
      Objects.requireNonNull(type, "type is null");
      this.type = type;
      return this;
    }

    public MediaReference build() {

      if (this.mediaId == null) {
        throw new IllegalStateException("mediaId not set");
      }
      if (this.usedBy == null) {
        throw new IllegalStateException("usedBy not set");
      }
      if (this.type == null) {
        throw new IllegalStateException("type not set");
      }

      return new MediaReference(this);
    }
  }
}
