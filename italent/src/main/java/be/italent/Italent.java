package be.italent;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Italent extends SpringBootServletInitializer {

	private static final Logger logger = LogManager.getLogger(Italent.class.getName());
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Italent.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Italent.class, args);
        logger.error("________ iTalent gestart ________");
    }
}