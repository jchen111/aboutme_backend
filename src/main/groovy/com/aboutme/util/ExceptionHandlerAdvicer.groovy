package com.aboutme.util

import com.aboutme.dto.response.errorResponse.ErrorResponse
import com.aboutme.util.exceptions.BadRequestException
import com.aboutme.util.exceptions.InternalErrorException
import com.aboutme.util.exceptions.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.servlet.config.annotation.EnableWebMvc

/**
 * Created by z001ktb on 3/18/16.
 */
@ControllerAdvice
@EnableWebMvc
class ExceptionHandlerAdvicer {

    @ExceptionHandler(UnknownHostException)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleBadRequest(UnknownHostException e){
        new ErrorResponse(e.message)
    }

    @ExceptionHandler(BadRequestException)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleBadRequest(BadRequestException e){
        new ErrorResponse(e.message)
    }

    @ExceptionHandler(NotFoundException)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleNotFound(NotFoundException e){
        new ErrorResponse(e.message)
    }

    @ExceptionHandler(InternalErrorException)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleInternalError(InternalErrorException e) {
        new ErrorResponse(e.message)
    }
}
