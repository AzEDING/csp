package com.iitp.csp;

import com.iitp.csp.property.CspFileProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@EnableConfigurationProperties({
		CspFileProperties.class
})
public class CspApplication {

	public static void main(String[] args) {
		SpringApplication.run(CspApplication.class, args);
	}
}
