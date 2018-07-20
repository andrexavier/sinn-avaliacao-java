package br.com.sinn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sinn.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	public List<Role> findAllWithoutDeleted();
}
