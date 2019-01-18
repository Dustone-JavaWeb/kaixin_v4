package top.dustone.kaixin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class KaixinApplication extends SpringBootServletInitializer{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
         return application.sources(KaixinApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(KaixinApplication.class, args);
	}
}
