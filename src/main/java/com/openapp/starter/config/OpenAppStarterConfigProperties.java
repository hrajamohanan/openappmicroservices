package com.openapp.starter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.cloud")
public class OpenAppStarterConfigProperties {
	
	

		private String uri;
		
		private String consulHost;
		
		private String consulPort;
		
		private String consulDiscoveryHealthCheckPath;
		
		private String consulDiscoveryHealthCheckInterval ;
		

		public String getUri() {
			return uri;
		}

		public void setUri(String uri) {
			this.uri = uri;
		}

		public String getConsulHost() {
			return consulHost;
		}

		public void setConsulHost(String consulHost) {
			this.consulHost = consulHost;
		}

		public String getConsulPort() {
			return consulPort;
		}

		public void setConsulPort(String consulPort) {
			this.consulPort = consulPort;
		}

		public String getConsulDiscoveryHealthCheckPath() {
			return consulDiscoveryHealthCheckPath;
		}

		public void setConsulDiscoveryHealthCheckPath(String consulDiscoveryHealthCheckPath) {
			this.consulDiscoveryHealthCheckPath = consulDiscoveryHealthCheckPath;
		}

		public String getConsulDiscoveryHealthCheckInterval() {
			return consulDiscoveryHealthCheckInterval;
		}

		public void setConsulDiscoveryHealthCheckInterval(String consulDiscoveryHealthCheckInterval) {
			this.consulDiscoveryHealthCheckInterval = consulDiscoveryHealthCheckInterval;
		}


}
