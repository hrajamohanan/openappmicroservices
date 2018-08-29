package com.openapp.starter.config;


import static com.openapp.starter.config.OpenAppConfigParams.URI;


import java.time.LocalDateTime;

public class OpenAppConfigInit {

    private OpenAppConfig openappConfig;

    public OpenAppConfigInit(OpenAppConfig config) {
        this.openappConfig = config;
    }

    public String getConfig(LocalDateTime localDateTime) {

        String uri = openappConfig.getProperty(URI);
        if (uri.equals(null) || uri.isEmpty()) {
        	uri = "http://localhost:8888/foo/development";
        }
        return uri;

       
    }

    public String getConfig() {
        return getConfig(LocalDateTime.now());
    }

}
