package com.aboutme.dto.request

import com.fasterxml.jackson.annotation.JsonProperty

import javax.validation.constraints.NotNull

/**
 * Created by z001ktb on 6/14/16.
 */
class EmailRequest {

    @JsonProperty('name')
    @NotNull
    String name

    @JsonProperty('email')
    @NotNull
    String email

    @JsonProperty('text')
    @NotNull
    String text
}
