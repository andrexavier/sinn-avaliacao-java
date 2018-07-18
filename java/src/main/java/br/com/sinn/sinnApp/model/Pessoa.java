package br.com.sinn.sinnApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Where;

@SuppressWarnings("serial")
@Entity
@Table(name = "pessoa")
@Where(clause = "active is true")
public class Pessoa extends AuditModel
{
	@Id
	@GeneratedValue(generator = "pessoa_generator")
	@SequenceGenerator(
		name = "pessoa_generator",
		sequenceName = "pessoa_sequence",
		initialValue = 1000
	)
	private Long id;

	@NotBlank
	@Size(min = 3, max = 100)
	private String nome;

	@NotBlank
	@Pattern(regexp = "^((\\d{3}).(\\d{3}).(\\d{3})-(\\d{2}))*$")
	private String cpf;

	private double salario;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "cargo_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Cargo cargo;

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

	public String getCpf(){
		return this.cpf;
	}

	public void setCpf(String cpf){
		this.cpf = cpf;
	}

	public double getSalario(){
		return this.salario;
	}

	public void setSalario(double salario){
		this.salario = salario;
	}

	public Cargo getCargo(){
		return this.cargo;
	}

	public void setCargo(Cargo cargo){
		this.cargo = cargo;
	}
}

