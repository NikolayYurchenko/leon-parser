package com.matchit.me.leonparser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableAsync
@EnableCaching
@EnableScheduling
@SpringBootApplication(scanBasePackages = {"com.matchit.me.leonparser"})
@ConfigurationPropertiesScan("com.matchit.me.leonparser.config")
public class LeonParserApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeonParserApplication.class, args);
	}

}
