module com.sitepark.ies.mediarepository.core {
	exports com.sitepark.ies.mediarepository.core.domain.entity;
	exports com.sitepark.ies.mediarepository.core.domain.exception;
	exports com.sitepark.ies.mediarepository.core.port;
	exports com.sitepark.ies.mediarepository.core.usecase;
	requires javax.inject;
	requires org.eclipse.jdt.annotation;
	requires com.github.spotbugs.annotations;
}
