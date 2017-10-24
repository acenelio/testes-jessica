package br.com.appvendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.appvendas.domain.Categoria;
import br.com.appvendas.repositories.CategoriaRepository;
import br.com.appvendas.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id){
		
		Categoria obj = repo.findOne(id);
		if(obj == null){
			throw new ObjectNotFoundException("Objeto não encontrado! Id: "+ id
					+", Tipo: "+Categoria.class.getName());
		}
		return obj;
		
	}
}
