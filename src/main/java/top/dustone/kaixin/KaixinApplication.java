package top.dustone.kaixin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import org.springframework.remoting.caucho.HessianProxyFactoryBean;
import top.dustone.UserAuth.service.rmi.UserAuthorityService;

@SpringBootApplication
public class KaixinApplication extends SpringBootServletInitializer{
	@Bean
	public HessianProxyFactoryBean helloClient() {
		HessianProxyFactoryBean factory = new HessianProxyFactoryBean();
		factory.setServiceUrl("http://localhost:8081/uams/userAuth");
		factory.setServiceInterface(UserAuthorityService.class);
		return factory;
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
         return application.sources(KaixinApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(KaixinApplication.class, args);
	}
}
