package com.aboutme.util.exceptions

/**
 * InternalErrorException will be thrown if an exception is caught during the internal process
 */
class InternalErrorException extends Exception{
    InternalErrorException(String message) {
        super(message)
    }
}
