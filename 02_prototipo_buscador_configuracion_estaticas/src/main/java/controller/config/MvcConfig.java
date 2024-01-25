package controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ComponentScan(basePackages = {"controller"})
@EnableWebMvc
@Configuration
public class MvcConfig implements WebMvcConfigurer {
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		 InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		 resolver.setPrefix("/");
		 resolver.setSuffix(".jsp");
		 return resolver;
		}

	//este método sirve para controlar la navegación estática
	//nos cargamos los métodos para navegación estática del BuscadorController
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("menu");
		registry.addViewController("/toAlta").setViewName("alta");
		registry.addViewController("/toBuscar").setViewName("buscar");
	}
	
	
}
