package com.aboutme.controller

import com.aboutme.AppConstants
import com.aboutme.domain.Email
import com.aboutme.dto.mapper.EmailRequestMapper
import com.aboutme.dto.request.EmailRequest
import com.aboutme.service.AboutmebackendService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

import javax.validation.Valid

/**
 * Created by z001ktb on 6/14/16.
 */
@RestController
@RequestMapping(AppConstants.APP_CONTEXT_ROOT)
class AboutmebackendController {

    @Autowired
    EmailRequestMapper emailRequestMapper

    @Autowired
    AboutmebackendService service

    @CrossOrigin
    @RequestMapping(value = '/emails', consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    void sendEmail(@Valid @RequestBody EmailRequest emailRequest) {
        Email email = emailRequestMapper.toEmail(emailRequest)
        service.sendEmail(email)
    }
}
