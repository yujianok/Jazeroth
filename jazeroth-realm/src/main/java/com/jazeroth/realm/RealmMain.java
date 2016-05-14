package com.jazeroth.realm;

import com.jazeroth.realm.bean.ChannelHandlerBeanLocator;
import com.jazeroth.realm.config.RealmConfig;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * Created by Jack on 2016/5/7.
 */
@SpringBootApplication
@EnableConfigurationProperties(RealmConfig.class)
public class RealmMain {

    public static void main(String[] args) {
        SpringApplication.run(RealmMain.class, args);
    }

    @Bean
    public ServiceLocatorFactoryBean channelHandlerBeanLocator() {
        ServiceLocatorFactoryBean serviceLocatorFactoryBean = new ServiceLocatorFactoryBean();
        serviceLocatorFactoryBean.setServiceLocatorInterface(ChannelHandlerBeanLocator.class);

        return serviceLocatorFactoryBean;
    }
}
