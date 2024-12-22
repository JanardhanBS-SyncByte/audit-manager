package com.example.graalvmdemo.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "openapi")
public class OpenApiProperties {
	private InfoProperty info;
	private Service service;

	public OpenApiProperties() {
		super();
	}

	public OpenApiProperties(InfoProperty info, Service service) {
		super();
		this.info = info;
		this.service = service;
	}

	public InfoProperty getInfo() {
		return info;
	}

	public void setInfo(InfoProperty info) {
		this.info = info;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}
	
	@Override
	public String toString() {
		return "OpenApiProperties [info=" + info + ", service=" + service + "]";
	}

	public static class InfoProperty {
		private String title;
		private String description;
		private String version;
		private LicenseProperty license;

		public InfoProperty() {
			super();
		}

		public InfoProperty(String title, String description, String version, LicenseProperty license) {
			super();
			this.title = title;
			this.description = description;
			this.version = version;
			this.license = license;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getVersion() {
			return version;
		}

		public void setVersion(String version) {
			this.version = version;
		}

		public LicenseProperty getLicense() {
			return license;
		}

		public void setLicense(LicenseProperty license) {
			this.license = license;
		}

		@Override
		public String toString() {
			return "InfoProperty [title=" + title + ", description=" + description + ", version=" + version
					+ ", license=" + license + "]";
		}
		
		
	}
	
	public static class Service {
		private List<Server> servers;

		public Service() {
			super();
		}

		public Service(@Autowired List<Server> servers) {
			super();
			this.servers = servers;
		}

		public List<Server> getServers() {
			return servers;
		}

		public void setServers(List<Server> servers) {
			this.servers = servers;
		}

		@Override
		public String toString() {
			return "Service [servers=" + servers + "]";
		}
		
		
	}
	
	public static class Server {
		private String description;
		private String url;

		public Server() {
			super();
		}

		public Server(String description, String url) {
			super();
			this.description = description;
			this.url = url;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		@Override
		public String toString() {
			return "Server [description=" + description + ", url=" + url + "]";
		}
		
		
	}
	
	public static class LicenseProperty {
		private String name;
		private String url;

		public LicenseProperty() {
			super();
		}

		public LicenseProperty(String name, String url) {
			super();
			this.name = name;
			this.url = url;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		@Override
		public String toString() {
			return "LicenseProperty [name=" + name + ", url=" + url + "]";
		}
		
		
	}
}