package br.com.sinn.sinnApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import br.com.sinn.sinnApp.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	List<Pessoa> findByCargoId(Long cargoId);
}

