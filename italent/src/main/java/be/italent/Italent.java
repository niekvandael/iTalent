package be.italent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@RestController
@EnableZuulProxy
@ComponentScan(basePackages = {"be.italent"})
public class Italent extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(Italent.class, args);
    }

}
