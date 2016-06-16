package com.aboutme.config

import com.aboutme.util.handler.CommonResponseErrorHandler
import org.apache.http.client.HttpClient
import org.apache.http.impl.client.HttpClients
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ReloadableResourceBundleMessageSource
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.web.client.ResponseErrorHandler
import org.springframework.web.client.RestTemplate

/**
 * Created by z001ktb on 6/14/16.
 */
@Configuration
@ComponentScan(basePackages = 'com.aboutme')
@EnableConfigurationProperties(value = [MailgunProvider])
class AboutmeConfig {
    @Autowired
    MailgunProvider mailgunProvider

    @Bean
    MailgunCredentials mailgunCredentials() {
        ReloadableResourceBundleMessageSource bundle = new ReloadableResourceBundleMessageSource()
        bundle.setBasename('mailgunCredentials')
        new MailgunCredentials(bundle)
    }

    @Bean
    RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate(makeFactory(makeHttpClient()))
        restTemplate.setErrorHandler(responseErrorHandler())
        restTemplate
    }


    @Bean
    HttpComponentsClientHttpRequestFactory makeFactory(HttpClient httpClient){
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient)
        factory.connectionRequestTimeout = mailgunProvider.httpSettings.connectionRequestTimeoutMillis
        factory.connectTimeout = mailgunProvider.httpSettings.connectionTimeoutMillis
        factory.readTimeout = mailgunProvider.httpSettings.readTimeoutMillis
        factory
    }

    @Bean
    HttpClient makeHttpClient(){
        HttpClient httpClient = HttpClients.custom()
                .setMaxConnPerRoute(mailgunProvider.httpSettings.maxRequestsPerRoute)
                .setMaxConnTotal(mailgunProvider.httpSettings.maxRequestsTotal).build()
        httpClient
    }

    @Bean
    ResponseErrorHandler responseErrorHandler() {
        new CommonResponseErrorHandler()
    }
}
