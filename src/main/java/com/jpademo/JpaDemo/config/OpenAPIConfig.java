package com.jpademo.JpaDemo.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfig {



  @Bean
  public OpenAPI myOpenAPI() {
    Server devServer = new Server();
    devServer.setDescription("Server URL in Development environment");


    Contact contact = new Contact();
    contact.setEmail("vivekfarzi@gmail.com");
    contact.setName("Vivek Bhardwaj and SSY");
    contact.setUrl("www.gla.ac.in");

    License mitLicense = new License().name("GLA University, Mathura")
            .url("www.gla.ac.in");

    Info info = new Info()
        .title("Top Notch APIs")
        .version("56789")
        .contact(contact)
        .description("Book project APIs").termsOfService("hamare terms condition kuch nahi")
        .license(mitLicense);

    return new OpenAPI().info(info).servers(List.of(devServer));
  }
}