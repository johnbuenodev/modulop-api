package com.example.demo.contato.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.example.demo.contato.domain.Contato;
import com.example.demo.contato.repository.ContatoRepository;
import com.example.demo.exceptionshelper.ObjectNotFoundException;

@Service
@Configurable
public class ContatoService {

	@Autowired
	public ContatoRepository repository;
	
	public List<Contato> findAll(){
		
		List<Contato> contatoList = repository.findAll();
		return contatoList;
	}
	
	public Contato createContato(Contato contato) {
		
		//contato.setId(null);
		return repository.save(contato);
	}
	
	public Contato findById(Integer id) {
		
		Optional<Contato> contato= repository.findById(id);
		
		return contato.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", tipo: " + Contato.class.getName()));
	}
	
	public void deleteContato(Integer id) {
		
		repository.deleteById(id);
		
	} 
	
	public Contato updateContato(Integer id, Contato contato) {
		
		Contato contatoAtualizado = this.findById(id);
		
		contatoAtualizado.setNome(contato.getNome());
		contatoAtualizado.setTelefone(contato.getTelefone());
		contatoAtualizado.setEmail(contato.getEmail());
		repository.save(contatoAtualizado);
		
		return contatoAtualizado;
		
	}

	public List<Contato> findAllByPessoaId(Integer id) {
		
		List<Contato> contatoList = repository.findAllByPessoaId(id);
		return contatoList;
	
	}
	
}
