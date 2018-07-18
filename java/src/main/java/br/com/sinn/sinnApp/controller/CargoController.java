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
import br.com.sinn.sinnApp.model.Cargo;
import br.com.sinn.sinnApp.repository.CargoRepository;

@RestController
public class CargoController 
{
	@Autowired
	private CargoRepository cargoRepository;

	@GetMapping("/cargos")
	public Page<Cargo> getCargos(Pageable pageable){
		return cargoRepository.findAll(pageable);
	}

	@PostMapping("/cargos")
	public Cargo createCargo(@Valid @RequestBody Cargo cargo){
		return cargoRepository.save(cargo);
	}

	@DeleteMapping("/cargos/{cargoId}")
	public Cargo logicalDelete(@PathVariable("cargoId") Long cargoId){
		return cargoRepository.findById(cargoId)
			.map(cargo -> {
				cargo.setActive(false);
				return cargoRepository.save(cargo);
			}).orElseThrow(() -> new ResourceNotFoundException(
					"Cargo não encontrado com esse Id: " + cargoId
				));
	}
}

