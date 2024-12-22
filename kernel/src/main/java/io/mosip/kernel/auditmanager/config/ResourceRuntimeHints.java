package io.mosip.kernel.auditmanager.config;

import org.hibernate.dialect.PostgreSQLDialect;
import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportRuntimeHints;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;

@Configuration
@ImportRuntimeHints({ ResourceRuntimeHints.ResourcesRegistrar.class,
		ResourceRuntimeHints.PropertyNamingStrategyRegistrar.class,
		ResourceRuntimeHints.DatabaseRuntimeHintsRegistrar.class })
public class ResourceRuntimeHints {
	static class ResourcesRegistrar implements RuntimeHintsRegistrar {

		@Override
		public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
			hints.resources().registerPattern("./**/*");
		}
	}

	static class PropertyNamingStrategyRegistrar implements RuntimeHintsRegistrar {

		@Override
		public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
			try {
				hints.reflection().registerField(PropertyNamingStrategies.class.getDeclaredField("SNAKE_CASE"));
			} catch (NoSuchFieldException e) {
				// ...
			}
		}
	}

	static class DatabaseRuntimeHintsRegistrar implements RuntimeHintsRegistrar {

		@Override
		public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
			try {
				// Change this to use your database Dialect class when using other databases
				hints.reflection().registerType(PostgreSQLDialect.class, MemberCategory.values());
			} catch (Exception e) {
				// ...
			}
		}
	}
}