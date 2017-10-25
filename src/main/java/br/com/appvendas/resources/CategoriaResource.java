package br.com.appvendas.resources;


//import java.net.URI;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.appvendas.domain.Categoria;
import br.com.appvendas.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	@RequestMapping(value= "/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
			Categoria obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	
		
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Categoria> inser(@RequestBody Categoria obj){
		Categoria categoriaSalva = service.insert(obj);
		
		return new ResponseEntity<>(categoriaSalva, HttpStatus.CREATED);
	
	/*public ResponseEntity<Void> insert(@RequestBody Categoria obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		*/
	}

}
