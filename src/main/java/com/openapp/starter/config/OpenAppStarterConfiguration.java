package com.openapp.starter.config;

import static com.openapp.starter.config.OpenAppConfigParams.URI;


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
 


                String uri = openAppStarterConfigProperties.getUri() == null ? "http://127.0.0.1:8888" : openAppStarterConfigProperties.getUri();

                OpenAppConfig openAppConfig = new OpenAppConfig();
                openAppConfig.put(URI, uri);
        		
        		
        // ...
        return openAppConfig;
    }
 

}
