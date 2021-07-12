package com.example.demo.pessoa.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
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
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.example.demo.pessoa.domain.Pessoa;
import com.example.demo.pessoa.service.PessoaService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService service;
    
    @GetMapping("/")
    public List<Pessoa> findAll(){
    	
    	List<Pessoa> pessoaList = service.findAll();
    	return pessoaList;
    }
    
    /*
    @GetMapping("/todas")
    public ResponseEntity<Object> findAllPage(int page, int pageSize){
     
     return ResponseEntity.ok().body(service.findAllPage(page, pageSize));	
    }
    */
	
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> findById(@PathVariable("id") Integer id){
		
		Pessoa pessoa = service.findById(id);
		return ResponseEntity.ok().body(pessoa);
	}
	
	@PostMapping("/")
	public ResponseEntity<Pessoa> createPessoa(@Valid @RequestBody Pessoa pessoa){
		
		Pessoa novaPessoa = service.createPessoa(pessoa);
		
		URI uriPessoaResponse = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novaPessoa.getId()).toUri();
		
		return ResponseEntity.created(uriPessoaResponse).body(novaPessoa);
		
	}
	
	@DeleteMapping("/{id}")
	public void removeById(@PathVariable("id") Integer id) {

		    service.deletePessoa(id);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> updatePessoa(@Valid @PathVariable("id") Integer id, @RequestBody Pessoa pessoa){
		
		Pessoa pessoaAtualizada = service.updateById(id, pessoa);
		return ResponseEntity.ok().body(pessoaAtualizada);
		
	}
	
}
