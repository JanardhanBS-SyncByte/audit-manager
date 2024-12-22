package com.example.graalvmdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

	/*
	 * @Value("${openapi.info.title}") private String title;
	 * 
	 * @Value("${openapi.info.description}") private String description;
	 * 
	 * @Value("${openapi.info.version}") private String version;
	 * 
	 * @Value("${openapi.info.license.name}") private String licenseName;
	 * 
	 * @Value("${openapi.info.license.url}") private String licenseUrl;
	 * 
	 * @Value("${openapi.service.servers[0].url}") private String serverUrl;
	 * 
	 * @Value("${openapi.service.servers[0].description}") private String
	 * serverDescription;
	 * 
	 * @Bean public OpenAPI openApi() { return new OpenAPI() .info(new
	 * Info().title(title).description(description).version(version) .license(new
	 * License().name(licenseName).url(licenseUrl)))
	 * .servers(Collections.singletonList(new
	 * Server().url(serverUrl).description(serverDescription))); }
	 */

	@Bean
	public OpenAPI openApi(OpenApiProperties openApiProperties) {
		if (openApiProperties == null) {
			throw new IllegalStateException("OpenApiProperties is not injected properly!");
		}

		System.out.println("SwaggerConfig>>>>>>OpenApiProperties>>>>>>>>>" + openApiProperties.toString());
		System.out.println("SwaggerConfig>>>>>>>info>>>>>>>>" + openApiProperties.getInfo());
		System.out.println("SwaggerConfig>>>>>>>Service>>>>>>>>" + openApiProperties.getService());
		Info info = new Info().title(openApiProperties.getInfo().getTitle())
				.version(openApiProperties.getInfo().getVersion())
				.description(openApiProperties.getInfo().getDescription())
				.license(new License().name(openApiProperties.getInfo().getLicense().getName())
						.url(openApiProperties.getInfo().getLicense().getUrl()));

		OpenAPI api = new OpenAPI().info(info).components(new Components());

		openApiProperties.getService().getServers().forEach(
				server -> api.addServersItem(new Server().description(server.getDescription()).url(server.getUrl())));

		return api;

		/*
		 * OpenAPI api = new OpenAPI().components(new Components()) .info(new
		 * Info().title(openApiProperties.getInfo().getTitle())
		 * .version(openApiProperties.getInfo().getVersion())
		 * .description(openApiProperties.getInfo().getDescription()) .license(new
		 * License().name(openApiProperties.getInfo().getLicense().getName())
		 * .url(openApiProperties.getInfo().getLicense().getUrl())));
		 * 
		 * openApiProperties.getService().getServers().forEach( server ->
		 * api.addServersItem(new
		 * Server().description(server.getDescription()).url(server.getUrl()))); return
		 * api;
		 */
	}
}