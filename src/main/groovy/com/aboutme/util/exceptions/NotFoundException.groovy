package com.aboutme.util.exceptions

/**
 * NotFoundException will be thrown if the upload file is not found or JIRA issue is not found.
 */
class NotFoundException extends Exception{
    NotFoundException(String message){
        super(message)
    }
}
