package com.course.project.Fapi.propertys;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:application.properties")
public class BackendApiProperties {


    @Value("${back.server.uri}")
    private String backUri;

    public String getUserUri() {
        return backUri + "/user";
    }

    public String getUserRoleUri() {
        return backUri + "/user-role";
    }

    public String getRoomUri() {
        return backUri + "/room";
    }

    public String getStatusUri() {
        return backUri + "/status";
    }

    public String getRequestUri() {
        return backUri + "/request";
    }

}
