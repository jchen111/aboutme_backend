package com.aboutme.dto.response.errorResponse

import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * Created by z001ktb on 3/18/16.
 */
@ToString
@EqualsAndHashCode
class ErrorResponse {
    @JsonProperty("errorMessage")
    String message

    ErrorResponse(String m){
        this.message = m
    }
}
