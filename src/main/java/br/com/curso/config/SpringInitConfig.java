package br.com.curso.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * quando subir a aplicacao a classe RootConfig.java será a primeira configuracao da aplicacao que o spring tem que carregar
	 * 
	 * */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {SpringMvcConfig.class};
	}

	/**
	 * mapeamento dos servlets
	 * sempre que a aplicacao encontrar na url uma barra ela vai entender que estamos trabalhando com servlet
	 * */
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
