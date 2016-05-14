package com.jazeroth.realm.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Jack on 2016/5/7.
 */
@ConfigurationProperties(prefix = RealmConfig.PREFIX)
public class RealmConfig {

    public static final String PREFIX = "jazeroth.realm";

    private String address;

    private int port;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
