package br.com.sinn.sinnApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import br.com.sinn.sinnApp.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {}

