package br.com.sinn.usuario;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

/**
 * Classe para objetos do tipo Usuario, onde serao contidos, informacoes e
 * metodos para o mesmo.
 * 
 * @version 1.0
 * 
 */
@Entity
@Table(name = "usuario")
public class Usuario extends BaseEntity {

	/** The uuid. */
	@Column(name = "USER_CD_UUID")
	@Type(type = "uuid-char")
	private UUID uuid;

	/** The nome. */
	@Column(name = "USER_NM_NOME")
	private String nome;

	/** The email. */
	@Column(name = "USER_TX_EMAIL")
	private String email;

	/** The interno. */
	@Column(name = "USER_IN_INTERNO")
	private Boolean interno;

	/** The cpf. */
	@Column(name = "user_cd_cpf")
	private String cpf;

	/** The perfil. */
	@Transient
	private String perfil;

	/** The area usuario. */
	@Transient
	private String areaUsuario;

	/** The area aprovacao. */
	@Transient
	private String areaAprovacao;

	/**
	 * Method - getEmail
	 * Return - String.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Method - setEmail
	 * Return - void.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the uuid.
	 *
	 * @return the uuid
	 */
	public UUID getUuid() {
		return uuid;
	}

	/**
	 * Sets the uuid.
	 *
	 * @param uuid the uuid to set
	 */
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Sets the nome.
	 *
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Gets the interno.
	 *
	 * @return the interno
	 */
	public Boolean getInterno() {
		return interno;
	}

	/**
	 * Sets the interno.
	 *
	 * @param interno the interno to set
	 */
	public void setInterno(Boolean interno) {
		this.interno = interno;
	}

	/**
	 * Gets the area usuario.
	 *
	 * @return the areaUsuario
	 */
	public String getAreaUsuario() {
		return areaUsuario;
	}

	/**
	 * Sets the area usuario.
	 *
	 * @param areaUsuario the areaUsuario to set
	 */
	public void setAreaUsuario(String areaUsuario) {
		this.areaUsuario = areaUsuario;
	}

	/**
	 * Gets the perfil.
	 *
	 * @return the perfil
	 */
	public String getPerfil() {
		return perfil;
	}

	/**
	 * Sets the perfil.
	 *
	 * @param perfil the perfil to set
	 */
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	/**
	 * Gets the cpf.
	 *
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * Sets the cpf.
	 *
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * Gets the area aprovacao.
	 *
	 * @return the area aprovacao
	 */
	public String getAreaAprovacao() {
		return areaAprovacao;
	}

	/**
	 * Sets the area aprovacao.
	 *
	 * @param areaAprovacao the new area aprovacao
	 */
	public void setAreaAprovacao(String areaAprovacao) {
		this.areaAprovacao = areaAprovacao;
	}
}
