package io.mosip.kernel.auditmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import io.mosip.kernel.auditmanager.config.OpenApiProperties;

/**
 * Audit manager application
 * 
 * @author Dharmesh Khandelwal
 * @since 1.0.0
 *
 */
@SpringBootApplication(scanBasePackages = { "io.mosip.kernel.auditmanager","${mosip.auth.adapter.impl.basepackage}"
		,"io.mosip.kernel.core.logger.config"})
@EnableConfigurationProperties(OpenApiProperties.class)
public class AuditManagerBootApplication {

	/**
	 * Main method to run spring boot application
	 * 
	 * @param args args
	 */
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(AuditManagerBootApplication.class);
		app.setMainApplicationClass(AuditManagerBootApplication.class);
		app.run(args);
		//SpringApplication.run(AuditManagerBootApplication.class, args);
	}
}
