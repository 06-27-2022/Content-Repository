package com.revature.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/*
 * We will be using this class to configure our ApplicationContext. This means that we will be
 * adding Spring beans to our IoC container using this class. This is a replacement for our XML
 * configuration.
 * 
 * If you wish to use a class to configure your context, it must be annotated with @Configuration.
 */

@Configuration
/*
 * The @ComponentScan annotation tells Spring which packages to scan for Spring
 * stereotypes.
 */
@ComponentScan(basePackages = { "com.revature.service", "com.revature.repository", "com.revature.controller" })
/*
 * To enable support for Spring Web Mvc, use the following annotation:
 */
@EnableWebMvc
public class AppConfig {

	/*
	 * If you wish to tell Spring to add beans to the container, you should declare
	 * methods which return those beans and annotate those methods with @Bean.
	 * 
	 * Note that I've commented these methods out because we simply don't need them
	 * as we are switching Spring stereotypes.
	 */

//	@Bean(name = "polkamanService")
//	public PolkamanService getPolkamanService() {
//		/*
//		 * Typically, we don't add such simple beans to our container using this strategy. We
//		 * would typically add beans that require a lot custom configuration to the container like
//		 * this.
//		 */
//		return new PolkamanService(getPolkamanRepository());
//	}
//	
//	@Bean(name = "polkamanRepository")
//	public PolkamanRepository getPolkamanRepository() {
//		return new PolkamanRepositoryImpl();
//	}

}
