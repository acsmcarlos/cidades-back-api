package com.github.acsmcarlos.cidadesapi.cidades;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cidades")
public class CidadeResource {
	
	@Autowired
	private CidadeRepository repository;
	

	@GetMapping
	public Page<Cidade> cidades(Pageable page){
		 return repository.findAll(page);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cidade> getOne(@PathVariable Long id) {
		Optional<Cidade> optional = repository.findById(id);
		
		if (optional.isPresent()) {
			return ResponseEntity.ok().body(optional.get());			
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}

}
