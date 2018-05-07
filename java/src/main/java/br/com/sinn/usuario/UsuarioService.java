package br.com.sinn.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**Classe para objetos do tipo AreaService, onde serao contidos, informacoes e metodos para o mesmo.
* 
* @version 1.0
* 
*/
@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	/**
	 * 
	 * Method - search
	 * Return - List<AreaUsuario>
	 * @param codigo
	 * @param isEscala 
	 * @param limit
	 * @return
	 *
	 */
	public Usuario search(Long id) {
		
		return usuarioRepository.findById(id);
	}
	
	
		

}
