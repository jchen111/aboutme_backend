package com.aboutme.util.exceptions

/**
 * BadRequest Exception will be thrown if post data doesn't meet JIRA requirements
 */
class BadRequestException extends Exception{

    BadRequestException(String message){
        super(message)
    }
}
