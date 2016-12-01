package com.globalmart.config;
 
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
 
@EnableWebMvc
@Configuration
@ComponentScan({ "com.globalmart.web" })
public class SpringWebConfig extends WebMvcConfigurerAdapter {

}