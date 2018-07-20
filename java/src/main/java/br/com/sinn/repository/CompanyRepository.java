package br.com.sinn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sinn.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{
	public List<Company> findAllWithoutDeleted();
}
