package br.com.sinn.usuario;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**Classe para objetos do tipo BaseEntity, onde serao contidos, informacoes e metodos para o mesmo.
* 
* @version 1.0
* 
*/
@MappedSuperclass
public class BaseEntity {
	
	/**
	 * 
	 */
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CD_ID")
	private Long id;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
}
