# Media-Repository

Feature of the media repository

- Management of binary data
- Reading the metadata
- Scaling images
- Metadata management: Modify metadata, add to it. Maybe also the media pool logics with inheritances and enable/disable metadata.
- Reference management. The media repository should know which article uses the media.

## UseCases

### AddReference

If a medium is used by a RepositoryContent entry, this is used to announce the relationship.

### RemoveByReference

If RepositoryContent entry is deleted, this removes all references to used media. All media that are without reference afterwards are deleted.

### RemoveMedia

Removes a medium