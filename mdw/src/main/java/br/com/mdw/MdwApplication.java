package br.com.mdw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import br.com.mdw.config.MdwApiProperty;

@SpringBootApplication
//@EnableConfigurationProperties(MdwApiProperty.class)
public class MdwApplication {

	public static void main(String[] args) {
		SpringApplication.run(MdwApplication.class, args);
	}
}
