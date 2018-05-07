package br.com.sinn.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * EstadoController
 *
 * @author André Xavier - 28 de nov de 2016
 *
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<Usuario> get(@RequestParam(required=false) Long id){
		return new ResponseEntity<Usuario>(usuarioService.search(id), HttpStatus.OK);
	}
	
}
