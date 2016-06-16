package com.aboutme.dto.mapper

import com.aboutme.domain.Email
import com.aboutme.dto.request.EmailRequest
import org.springframework.stereotype.Component

/**
 * Created by z001ktb on 6/14/16.
 */
@Component
class EmailRequestMapper {
    Email toEmail(EmailRequest request) {
        new Email(name: request.name, email: request.email, text: request.text)
    }
}
