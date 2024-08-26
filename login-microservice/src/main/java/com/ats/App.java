package com.ats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 *
 */

@EnableFeignClients("com.ats.proxy")
@EnableDiscoveryClient
@SpringBootApplication
public class App 
{

    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
//        System.out.println("Enter the email address");
//        String email = input.nextLine();
//        System.out.println("Enter password");
//        String password = input.nextLine();
    }
}
