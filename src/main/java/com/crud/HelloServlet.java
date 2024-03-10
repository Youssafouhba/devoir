package com.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class HelloServlet{
    @GetMapping("/")
    public String index() {
        return "ListClients.xhtml";
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloServlet.class, args);
    }
}
