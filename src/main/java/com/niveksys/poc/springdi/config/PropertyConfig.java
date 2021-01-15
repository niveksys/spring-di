package com.niveksys.poc.springdi.config;

import com.niveksys.poc.springdi.bean.FakeDataSource;
import com.niveksys.poc.springdi.bean.FakeJmsBroker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
// @PropertySource({ "classpath:datasource.properties",
// "classpath:jms.properties" })
@PropertySources({ @PropertySource("classpath:datasource.properties"), @PropertySource("classpath:jms.properties") })
public class PropertyConfig {

    @Autowired
    Environment env;

    @Value("${niveksys.username}")
    String username;

    @Value("${niveksys.password}")
    String password;

    @Value("${niveksys.dburl}")
    String url;

    @Value("${niveksys.jms.username}")
    String jmsUsername;

    @Value("${niveksys.jms.password}")
    String jmsPassword;

    @Value("${niveksys.jms.dburl}")
    String jmsUrl;

    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(this.username);
        fakeDataSource.setPassword(this.env.getProperty("PASSWORD"));
        fakeDataSource.setUrl(this.url);
        return fakeDataSource;
    }

    @Bean
    public FakeJmsBroker FakeDataSource() {
        FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
        fakeJmsBroker.setUsername(this.jmsUsername);
        fakeJmsBroker.setPassword(this.jmsPassword);
        fakeJmsBroker.setUrl(this.jmsUrl);
        return fakeJmsBroker;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }
}
