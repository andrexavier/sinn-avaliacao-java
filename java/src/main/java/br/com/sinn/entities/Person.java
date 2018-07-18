package br.com.sinn.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String cpf;
	private double salary;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="role_id")
	private Role role;
	
	public Person() {
	}

	public Person(int id, String name, String cpf, Role role, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.role = role;
		this.salary = salary;
	}

	public final int getId() {
		return id;
	}

	public final void setId(int id) {
		this.id = id;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getCpf() {
		return cpf;
	}

	public final void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public final Role getRole() {
		return role;
	}

	public final void setRole(Role role) {
		this.role = role;
	}

	public final double getSalary() {
		return salary;
	}

	public final void setSalary(double salary) {
		this.salary = salary;
	}
}
