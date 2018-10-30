package springboor.email.commont.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyAdapter  implements WebMvcConfigurer {
	public void addViewController(ViewControllerRegistry registry){
		registry.addViewController("/").setViewName("forward:/login.html");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	}
}
