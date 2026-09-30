import org.jspecify.annotations.NullMarked;

@NullMarked
module com.sitepark.ies.mediarepository.core {
  exports com.sitepark.ies.mediarepository.core.domain.entity;
  exports com.sitepark.ies.mediarepository.core.port;
  exports com.sitepark.ies.mediarepository.core.usecase;

  requires static org.jspecify;
  requires jakarta.inject;
  requires java.xml;
  requires com.sitepark.ies.sharedkernel;
}
