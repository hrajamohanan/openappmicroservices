package com.openapp.starter.config;

import static com.openapp.starter.config.OpenAppConfigParams.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(OpenAppConfigInit.class)
@EnableConfigurationProperties(OpenAppStarterConfigProperties.class)
@ComponentScan
public class OpenAppStarterConfiguration {
	
	
	
	@Bean
	@ConditionalOnMissingBean
	public OpenAppStarterConfiguration openAppStarterConfiguration() {
		return new OpenAppStarterConfiguration();
	}

	
    @Autowired 
    private OpenAppStarterConfigProperties openAppStarterConfigProperties;
 
    @Bean
    @ConditionalOnMissingBean
    public OpenAppConfig openAppConfig() {
 


                String uri = openAppStarterConfigProperties.getUri() == null ? "http://localhost:8888/foo/development" : openAppStarterConfigProperties.getUri();
                String consulHost = openAppStarterConfigProperties.getConsulHost() == null ? "localhost" : openAppStarterConfigProperties.getConsulHost();
                
                String consulPort = openAppStarterConfigProperties.getConsulPort() == null ? "8500" : openAppStarterConfigProperties.getConsulPort();
                String consulDiscoveryHealthCheckPath = openAppStarterConfigProperties.getConsulDiscoveryHealthCheckPath() == null ?
                		"/actuator/health" : openAppStarterConfigProperties.getConsulDiscoveryHealthCheckPath();
                String consulDiscoveryHealthCheckInterval  = openAppStarterConfigProperties.getConsulDiscoveryHealthCheckInterval() == null?
                		"15s" : openAppStarterConfigProperties.getConsulDiscoveryHealthCheckInterval();
                OpenAppConfig openAppConfig = new OpenAppConfig();
                openAppConfig.put(URI, uri);
                openAppConfig.put(CONSUL_HOST, consulHost);
                openAppConfig.put(CONSUL_PORT, consulPort);
                openAppConfig.put(CONSUL_DISCOVERY_HEALTHCHECKPATH, consulDiscoveryHealthCheckPath);
        		
        		
        // ...
        return openAppConfig;
    }
 

}
