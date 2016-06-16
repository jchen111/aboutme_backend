package com.aboutme.dao

import com.aboutme.config.MailgunCredentials
import com.aboutme.config.MailgunProvider
import com.aboutme.domain.Email

import com.aboutme.util.exceptions.InternalErrorException
import groovy.util.logging.Slf4j
import org.apache.commons.codec.binary.Base64
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.client.RestTemplate

/**
 * Created by z001ktb on 6/14/16.
 */
@Slf4j
@Repository
@Component(value = 'MailgunDAO')
class MailgunDAO {
    @Autowired
    RestTemplate restTemplate

    @Autowired
    MailgunCredentials mailgunCredentials

    @Autowired
    MailgunProvider mailgunProvider

    HttpHeaders creatAuthenticationHeader() {
        String plainCreds = 'api' + ':' + mailgunCredentials.mailgunApiKey;
        byte[] plainCredsBytes = plainCreds.getBytes()
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes)
        String base64Creds = new String(base64CredsBytes)

        HttpHeaders headers = new HttpHeaders()
        headers.add('Authorization', 'Basic ' + base64Creds)
        headers
    }

    void sendEmail(Email email) {

        MultiValueMap formData = new LinkedMultiValueMap<String, String>()
        formData.add("from", email.name+'@'+mailgunProvider.mailgunDomain)
        formData.add("to", "jackychen901010@gmail.com")
        formData.add("subject", "A Message from " + email.name + " ("+ email.email + ") through personal website")
        formData.add("text", email.text)

        HttpEntity<MultiValueMap> request = new HttpEntity<MultiValueMap>(formData,creatAuthenticationHeader())
        def response = restTemplate.exchange(mailgunProvider.mailgunBaseUrl+mailgunProvider.mailgunDomain+"/messages",
                HttpMethod.POST, request, Object)
        System.out.println(response.statusCode.value());
        if(response.statusCode.value() != 200){
            throw new InternalErrorException('Email can not be delivered due to Internal Server Error.')
        }
    }
}
