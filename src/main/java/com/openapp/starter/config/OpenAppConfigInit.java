package com.openapp.starter.config;


import static com.openapp.starter.config.OpenAppConfigParams.URI;

import java.time.LocalDateTime;
public class OpenAppConfigInit {

    private OpenAppConfig greetingConfig;

    public OpenAppConfigInit(OpenAppConfig greetingConfig) {
        this.greetingConfig = greetingConfig;
    }

    public String greet(LocalDateTime localDateTime) {

        String uri = greetingConfig.getProperty(URI);
        if (uri.equals(null) || uri.isEmpty()) {
        	uri = "http://localhost:8888";
        }
        return uri;

       
    }

    public String greet() {
        return greet(LocalDateTime.now());
    }

}
