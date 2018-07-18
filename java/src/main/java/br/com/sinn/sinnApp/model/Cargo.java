package br.com.sinn.sinnApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Where;

@SuppressWarnings("serial")
@Entity
@Table(name = "cargo")
@Where(clause = "active is true")
public class Cargo extends AuditModel
{
	@Id
	@GeneratedValue(generator = "cargo_generator")
	@SequenceGenerator(
		name = "cargo_generator",
		sequenceName = "cargo_sequence",
		initialValue = 1000
	)
	private Long id;

	@NotBlank
	@Size(min = 3, max = 100)
	private String nome;

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
}

