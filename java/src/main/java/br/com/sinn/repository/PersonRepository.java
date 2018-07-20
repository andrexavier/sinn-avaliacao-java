package br.com.sinn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sinn.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
	public List<Person> findAllWithoutDeleted();
}
