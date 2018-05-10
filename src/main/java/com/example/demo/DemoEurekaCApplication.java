package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class DemoEurekaCApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoEurekaCApplication.class, args);
	}
	
    @Value("${server.port}")
    String port;
    @RequestMapping("/hi")
    public String home(@RequestParam String name) {
        return "hi "+name+",i am from port:" +port;
    }
    @Value("${name}")
    private  String name2;
    @Value("${age}")
    private  String age;
    @Value("${version}")
    private  String version="test";
    
    @RequestMapping("/hello")
    public String helloTest(@RequestParam String name) {
        return "hello "+name+",i am"+name2+" from port:" +port+" I'm "+age+" years old (version:"+version+")";
    }
}
