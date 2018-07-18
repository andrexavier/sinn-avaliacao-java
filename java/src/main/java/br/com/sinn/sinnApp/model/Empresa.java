package br.com.sinn.sinnApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Where;

@SuppressWarnings("serial")
@Entity
@Table(name = "empresa")
@Where(clause = "active is true")
public class Empresa extends AuditModel
{
	@Id
	@GeneratedValue(generator = "empresa_generator")
	@SequenceGenerator(
		name = "empresa_generator",
		sequenceName = "empresa_sequence",
		initialValue = 1000
	)
	private Long id;

	@NotBlank
	@Size(min = 3, max = 100)
	private String nome;

	@NotBlank
	@Pattern(regexp = "^((\\d{2}).(\\d{3}).(\\d{3})/(\\d{4})-(\\d{2}))*$")
	private String cnpj;

	@NotBlank
	@Size(min = 3, max = 100)
	private String dono;

	public Long getId(){
		return this.id;
	}

	public void setId(Long id){
		this.id = id;
	}

	public String getNome(){
		return this.nome;
	}

	public void setNome(String nome){
		this.nome = nome;
	}

	public String getCnpj(){
		return this.cnpj;
	}

	public void setCnpj(String cnpj){
		this.cnpj = cnpj;
	}

	public String getDono(){
		return this.dono;
	}

	public void setDono(String dono){
		this.dono = dono;
	}
}

