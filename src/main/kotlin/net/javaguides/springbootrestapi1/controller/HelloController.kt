package net.javaguides.springbootrestapi1.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @GetMapping("/hello-world")
    fun helloWorld(): String {
        return "Hello World"
    }
}