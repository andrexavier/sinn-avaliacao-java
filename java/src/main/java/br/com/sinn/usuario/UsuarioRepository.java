package br.com.sinn.usuario;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**Interface para objetos do tipo UsuarioRepository, onde serao contidos, informacoes e metodos para o mesmo.
* 
* @version 1.0
* 
*/
public interface UsuarioRepository extends CrudRepository<Usuario, Long>,  JpaSpecificationExecutor<Usuario>{
	/**
	 * 
	 * Method - findByEmail
	 * Return - Usuario
	 * @param email
	 * @return
	 *
	 */
	Usuario findByEmail(String email);
	
	/**
	 * 
	 * Method - findById
	 * Return - Usuario
	 * @param id
	 * @return
	 *
	 */
	Usuario findById(Long id);
}
