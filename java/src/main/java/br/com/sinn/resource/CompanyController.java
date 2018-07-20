package br.com.sinn.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sinn.model.Company;
import br.com.sinn.repository.CompanyRepository;

@RestController
public class CompanyController {
	
	@Autowired
	private CompanyRepository companyRepository;

	@RequestMapping(value = "/companies", method = RequestMethod.GET)
	@ResponseBody
	public List<Company> all() {
		return this.companyRepository.findAllWithoutDeleted();
	}
	
	@RequestMapping(value = "/companies/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Company getCompany(@PathVariable Long id) {
		return this.companyRepository.findOne(id);
	}
	
	@RequestMapping(value = "/company", method = RequestMethod.POST)
	@ResponseBody
	public Company save(@RequestBody @Valid Company company) {
		return this.companyRepository.save(company);
	}
	
	@RequestMapping(value = "/company/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<String> delete(@PathVariable Long id) {
		Company company = companyRepository.findOne(id);
		company.setDeleted(1);
		companyRepository.save(company);
		return new ResponseEntity<String>("Company removed!", HttpStatus.OK);
	}
	
}
