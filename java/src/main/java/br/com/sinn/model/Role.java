package br.com.sinn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@NamedQuery(name = "Role.findAllWithoutDeleted", query = "SELECT r FROM Role r WHERE r.deleted = 0")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String name;
	@Column(name="default_percent_of_increase")
	private int defaultPercentOfIncrease;
	
	@JsonIgnore
	private int deleted = 0;

	public final Long getId() {
		return id;
	}

	public final void setId(Long id) {
		this.id = id;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}
	
	public final int getDefaultPercentOfIncrease() {
		return defaultPercentOfIncrease;
	}

	public final void setDefaultPercentOfIncrease(int defaultPercentOfIncrease) {
		this.defaultPercentOfIncrease = defaultPercentOfIncrease;
	}

	public final int getDeleted() {
		return deleted;
	}

	public final void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
