package com.aboutme.service

import com.aboutme.dao.MailgunDAO
import com.aboutme.domain.Email
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

/**
 * Created by z001ktb on 6/14/16.
 */
@Repository
class AboutmebackendService {
    @Autowired
    MailgunDAO mailgunDAO

    void sendEmail(Email email) {
        mailgunDAO.sendEmail(email)
    }

}
