package com.aboutme.config

import groovy.transform.ToString
import org.springframework.boot.context.properties.ConfigurationProperties

/**
 * Created by z001ktb on 3/19/16.
 */
@ConfigurationProperties(prefix = 'mailgunProvider', ignoreUnknownFields = true)
class MailgunProvider {
    //defaults
    static final String MAILGUN_BASE_URL = 'https://api.mailgun.net/v3/'
    static final String MAILGUN_DOMAIN = 'sandbox45000b2ea7c241d7a1bc2e454e163f82.mailgun.org'
    String mailgunBaseUrl = MAILGUN_BASE_URL
    String mailgunDomain = MAILGUN_DOMAIN
    HttpSettings httpSettings = new HttpSettings()

    @ToString
    static class HttpSettings {
        //defaults
        static final int DEFAULT_MAX_REQUESTS_PER_ROUTE = 10
        static final int DEFAULT_MAX_REQUESTS_TOTAL = 10
        static final int DEFAULT_CONNECTION_REQUEST_TIMEOUT_MILLS = 30000
        static final int DEFAULT_CONNECTION_TIMEOUT_MILLIS = 30000
        static final int DEFAULT_READ_TIMEOUT_MILLIS = 10000

        //mailgunProvider
        int maxRequestsPerRoute = DEFAULT_MAX_REQUESTS_PER_ROUTE
        int maxRequestsTotal = DEFAULT_MAX_REQUESTS_TOTAL
        int connectionRequestTimeoutMillis = DEFAULT_CONNECTION_REQUEST_TIMEOUT_MILLS
        int connectionTimeoutMillis = DEFAULT_CONNECTION_TIMEOUT_MILLIS
        int readTimeoutMillis = DEFAULT_READ_TIMEOUT_MILLIS

    }
}
