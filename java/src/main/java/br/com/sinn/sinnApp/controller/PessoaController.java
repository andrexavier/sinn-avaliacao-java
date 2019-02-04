package br.com.sinn.sinnApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sinn.sinnApp.exception.ResourceNotFoundException;
import br.com.sinn.sinnApp.model.Pessoa;
import br.com.sinn.sinnApp.repository.CargoRepository;
import br.com.sinn.sinnApp.repository.PessoaRepository;

@RestController
public class PessoaController 
{
	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private CargoRepository cargoRepository;

	@GetMapping("/cargos/{cargoId}/pessoas")
	public List<Pessoa> getPessoaByCargoId(@PathVariable("cargoId") Long cargoId){
		return pessoaRepository.findByCargoId(cargoId);
	}
	
	@PostMapping("/cargos/{cargoId}/pessoas")
	public Pessoa addPessoa(@PathVariable("cargoId") Long cargoId,
																 @Valid @RequestBody Pessoa pessoa){
		return cargoRepository.findById(cargoId)
			.map(cargo -> {
				pessoa.setCargo(cargo);
				return pessoaRepository.save(pessoa);
			}).orElseThrow(() -> new ResourceNotFoundException(
					"Cargo não encontrado com esse Id: " + cargoId
				));
	}

	@DeleteMapping("/cargos/{cargoId}/pessoas/{pessoaId}")
	public Pessoa logicalDelete(@PathVariable("cargoId") Long cargoId,
															@PathVariable("pessoaId") Long pessoaId){
		if (!cargoRepository.existsById(cargoId)) {
			throw new ResourceNotFoundException(
					"Cargo não encontrado com esse Id: " + cargoId
			);
		}

		return pessoaRepository.findById(pessoaId)
			.map(pessoa ->{
				pessoa.setActive(false);
				return pessoaRepository.save(pessoa);
			}).orElseThrow(() -> new ResourceNotFoundException(
					"Pessoa não encontrada com esse Id: " + pessoaId
				));
	}

	@PutMapping("/cargos/{cargoId}/pessoas/{pessoaId}")
	public Pessoa updateSalario(@PathVariable("cargoId") Long cargoId,
															@PathVariable("pessoaId") Long pessoaId){
		if (!cargoRepository.existsById(cargoId)) {
			throw new ResourceNotFoundException(
					"Cargo não encontrado com esse Id: " + cargoId
			);
		} 

		return pessoaRepository.findById(pessoaId)
			.map(pessoa -> {
				double aumento = 0;

				if(pessoa.getCargo().getNome().equalsIgnoreCase("estagiario"))
					aumento = 0.10;
				else if (pessoa.getCargo().getNome().equalsIgnoreCase("gerente")) 
					aumento = 0.20;
				else if (pessoa.getCargo().getNome().equalsIgnoreCase("diretor")) 
					aumento = 0.35;

				pessoa.setSalario(
					pessoa.getSalario() + pessoa.getSalario() * aumento
				);
				return pessoaRepository.save(pessoa);
			}).orElseThrow(() -> new ResourceNotFoundException(
					"Pessoa não encontrada com esse Id: " + pessoaId
				));
	}
}

