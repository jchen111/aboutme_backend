package com.aboutme.util.handler

import com.aboutme.util.exceptions.BadRequestException
import com.aboutme.util.exceptions.InternalErrorException
import com.aboutme.util.exceptions.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.client.ClientHttpResponse
import org.springframework.web.client.ResponseErrorHandler

import java.util.stream.Collectors
/**
 * CommonResponseErrorHandler decide wether and what exception should be thrown
 */
class CommonResponseErrorHandler implements ResponseErrorHandler {

    /**
     * Override hasError method, if the response status code is not 2XX, should return true
     * @param response
     * @return
     * @throws IOException
     */
    @Override
    boolean hasError(ClientHttpResponse response) throws Exception {
        !response.statusCode.'2xxSuccessful'
    }
    /**
     * Override handleError method, decide which exception to throw based on the corresponding response
     * @param response
     * @throws IOException
     */
    @Override
    void handleError(ClientHttpResponse response) throws Exception{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(response.getBody()))
        println(buffer.lines().collect(Collectors.joining("\n")))

        if(response.statusCode == HttpStatus.BAD_REQUEST){
            throw new BadRequestException(response.statusCode.reasonPhrase)
        }else if(response.statusCode == HttpStatus.NOT_FOUND){
            throw new NotFoundException(response.statusCode.reasonPhrase)
        }else if(response.statusCode.'5xxServerError'){
            throw new InternalErrorException(response.statusCode.reasonPhrase)
        }
    }
}

