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

import br.com.sinn.model.Person;
import br.com.sinn.repository.PersonRepository;
import br.com.sinn.util.SalaryUtil;

@RestController
public class PersonController {
	
	@Autowired
	private PersonRepository personRepository;

	@RequestMapping(value = "/people", method = RequestMethod.GET)
	@ResponseBody
	public List<Person> all() {
		return this.personRepository.findAllWithoutDeleted();
	}
	
	@RequestMapping(value = "/people/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Person getPerson(@PathVariable Long id) {
		return this.personRepository.findOne(id);
	}
	
	@RequestMapping(value = "/person", method = RequestMethod.POST)
	@ResponseBody
	public Person save(@RequestBody @Valid Person person) {
		return this.personRepository.save(person);
	}
	
	@RequestMapping(value = "/person/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<String> delete(@PathVariable Long id) {
		Person person = personRepository.findOne(id);
		person.setDeleted(1);
		personRepository.save(person);
		return new ResponseEntity<String>("Person removed!", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/increase-salary-of/{id}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> save(@PathVariable Long id) {
		Person person = personRepository.findOne(id);
		double olderSalary = person.getSalary();
		double newSalary = SalaryUtil.increaseSalary(olderSalary, person.getRole().getDefaultPercentOfIncrease());
		person.setSalary(newSalary);
		personRepository.save(person);
		
		return new ResponseEntity<String>(person.getName()
				+", your older salary is "
				+olderSalary
				+" and your new salary is "
				+newSalary, HttpStatus.OK);
	}
	
}

