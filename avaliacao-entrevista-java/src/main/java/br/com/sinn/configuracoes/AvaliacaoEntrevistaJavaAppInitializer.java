package br.com.sinn.configuracoes;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**Classe para objetos do tipo DecisoesAppInitializer, onde serao contidos, informacoes e metodos para o mesmo.
* 
* @version 1.0
* 
*/
public class AvaliacaoEntrevistaJavaAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{AvaliacaoEntrevistaJavaDBConfig.class, FrameworkConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{MVCConfig.class};
	}
	
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/v1.0/*"};
	}

}
