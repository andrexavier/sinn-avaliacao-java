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

import br.com.sinn.model.Role;
import br.com.sinn.repository.RoleRepository;

@RestController
public class RoleController {
	
	@Autowired
	private RoleRepository roleRepository;

	@RequestMapping(value = "/roles", method = RequestMethod.GET)
	@ResponseBody
	public List<Role> all() {
		return this.roleRepository.findAllWithoutDeleted();
	}
	
	@RequestMapping(value = "/roles/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Role getRole(@PathVariable Long id) {
		return this.roleRepository.findOne(id);
	}
	
	@RequestMapping(value = "/role", method = RequestMethod.POST)
	@ResponseBody
	public Role save(@RequestBody @Valid Role role) {
		return this.roleRepository.save(role);
	}
	
	@RequestMapping(value = "/role/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<String> delete(@PathVariable Long id) {
		Role role = roleRepository.findOne(id);
		role.setDeleted(1);
		roleRepository.save(role);
		return new ResponseEntity<String>("Role removed!", HttpStatus.OK);
	}
	
}
