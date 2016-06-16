package com.aboutme

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.servlet.config.annotation.EnableWebMvc

/**
 * Created by z001ktb on 6/14/16.
 */
@SpringBootApplication
@EnableWebMvc
class AboutmebackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(AboutmebackendApplication.class, args);
    }
}
