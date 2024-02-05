package controller.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@ComponentScan(basePackages= {"controller"})
@EnableWebMvc
@Configuration
public class MvcConfig implements WebMvcConfigurer {
	
	@Autowired
	private ApplicationContext applicationContext;
	@Bean
	public SpringResourceTemplateResolver templateResolver(){
	 SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
	 templateResolver.setApplicationContext(this.applicationContext);
	 templateResolver.setPrefix("/");
	 templateResolver.setSuffix(".html");
	 // HTML es la plantilla por defecto, se indica por claridad.
	 templateResolver.setTemplateMode(TemplateMode.HTML);
	 return templateResolver;
	}
	@Bean
	public SpringTemplateEngine templateEngine(){ 
	 SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	 templateEngine.setTemplateResolver(templateResolver());
	 templateEngine.setEnableSpringELCompiler(true);
	 return templateEngine;
	}
	@Bean
	public ThymeleafViewResolver viewResolver(){
	 ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
	 viewResolver.setTemplateEngine(templateEngine());
	 return viewResolver;
	}

	//este método sirve para controlar la navegación estática
	//nos cargamos los métodos para navegación estática del BuscadorController
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("login");
		registry.addViewController("/toNuevo").setViewName("nuevo");
		registry.addViewController("/toMenu").setViewName("menu");	
	}
	
	//método para localizar los recursos estáticos de la aplicación:
	//imágenes, hojas de estilo, etc...
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//trae lo que haya de la carpeta raíz
		registry.addResourceHandler("/**").addResourceLocations("/");
	}
	
	

}
