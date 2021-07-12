package com.example.demo.contato.api;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.contato.domain.Contato;
import com.example.demo.contato.service.ContatoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/contato")
public class ContatoController {
	
	@Autowired
	private ContatoService service;
	
	@ManagedOperation(description = "Busca um contato pelo id.")
	@GetMapping("/{id}")
	public ResponseEntity<Contato> findContatoById(@PathVariable("id") Integer id){
		
		Contato contato = service.findById(id);
		return ResponseEntity.ok().body(contato);
		
	}
	
	@ManagedOperation(description = "Deleta um contato pelo id.")
	@DeleteMapping("/{id}")
	public void deleteContato(@PathVariable("id") Integer id) {
		service.deleteContato(id);
	}

	@ManagedOperation(description = "Busca todos os registros de contato.")
	@GetMapping("/")
	public ResponseEntity<List<Contato>> findAll(){
		
		List<Contato> contatoList = service.findAll(); 
		return ResponseEntity.ok().body(contatoList);
		
	}
	
	@ManagedOperation(description = "Busca todos os registros de contato vinculados a uma entidade Pessoa.")
	@GetMapping("/pessoa/{id}")
	public ResponseEntity<List<Contato>> findAllByPessoaId(@PathVariable("id") Integer id){
		
		List<Contato> contatoList = service.findAllByPessoaId(id); 
		return ResponseEntity.ok().body(contatoList);
		
	}
	
	@ManagedOperation(description = "Cria um novo contato.")
	@PostMapping("/")
	public ResponseEntity<Contato> createContato(@Valid @RequestBody Contato contato){
		
		Contato novoContato = service.createContato(contato);
		URI uriContatoResponse = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novoContato .getId()).toUri();
		
		return ResponseEntity.created(uriContatoResponse).body(novoContato);
	}
	
	@ManagedOperation(description = "Altera um contato.")
	@PutMapping("/{id}")
	public ResponseEntity<Contato> updateContato(@Valid @PathVariable("id") Integer id, @RequestBody Contato contato){
		
		Contato contatoAtualizado = service.updateContato(id, contato);
		
		return ResponseEntity.ok().body(contatoAtualizado);
	}
	
}
