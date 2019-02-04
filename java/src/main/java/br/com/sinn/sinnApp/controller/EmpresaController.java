package br.com.sinn.sinnApp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sinn.sinnApp.exception.ResourceNotFoundException;
import br.com.sinn.sinnApp.model.Empresa;
import br.com.sinn.sinnApp.repository.EmpresaRepository;

@RestController
public class EmpresaController 
{
	@Autowired
	private EmpresaRepository empresaRepository;

	@GetMapping("/empresas")
	public Page<Empresa> getEmpresas(Pageable pageable){
		return empresaRepository.findAll(pageable);
	}

	@PostMapping("/empresas")
	public Empresa createEmpresa(@Valid @RequestBody Empresa empresa){
		return empresaRepository.save(empresa);
	}

	@DeleteMapping("/empresas/{empresaId}")
	public Empresa logicalDelete(@PathVariable("empresaId") Long empresaId){
		return empresaRepository.findById(empresaId)
			.map(empresa ->{
				empresa.setActive(false);
				return empresaRepository.save(empresa);
			}).orElseThrow(() -> new ResourceNotFoundException(
					"Empresa não foi encontrada com esse id: " + empresaId
				));
	}
}

