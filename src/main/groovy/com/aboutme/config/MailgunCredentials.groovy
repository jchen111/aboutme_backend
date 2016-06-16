package com.aboutme.config

import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.context.support.ReloadableResourceBundleMessageSource

/**
 * Created by z001ktb on 3/19/16.
 */
class MailgunCredentials {
    String mailgunApiKey

    MailgunCredentials(ReloadableResourceBundleMessageSource bundle) {
        Locale currentLocale = LocaleContextHolder.locale
        mailgunApiKey = bundle.getMessage('mailgun.apiKey', null, currentLocale)
    }

    MailgunCredentials(String key) {
        mailgunApiKey = key
    }
}
