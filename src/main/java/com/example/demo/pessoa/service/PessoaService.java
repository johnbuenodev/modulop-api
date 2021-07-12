package com.example.demo.pessoa.service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.exceptionshelper.ObjectNotFoundException;
import com.example.demo.pessoa.domain.Pessoa;
import com.example.demo.pessoa.repository.PessoaRepository;
import org.springframework.data.domain.PageRequest;

@Service
@Configurable
public class PessoaService {
	
	@Autowired
	public PessoaRepository repository;
	
	//Alterar para paginação no controller
	public List<Pessoa> findAll(){
		
		List<Pessoa> pessoaList = repository.findAll();
		return pessoaList;
	} 
	
	public Pessoa createPessoa(Pessoa pessoa) {
		
		//pessoa.setId(null);
		return repository.save(pessoa);
		
	}

	public Pessoa findById(Integer id) {
		
		Optional<Pessoa> pessoa = repository.findById(id);
		
		return pessoa.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", tipo: " + Pessoa.class.getName()));
		
	}
	
	public void deletePessoa(Integer id) {
		
		repository.deleteById(id);
	}
	
	public Pessoa updateById(Integer id, Pessoa pessoa) {
		
		Pessoa pessoaAtualizada = this.findById(id);
		pessoaAtualizada.setNome(pessoa.getNome());
		pessoaAtualizada.setCpf(pessoa.getCpf());
		pessoaAtualizada.setDataNascimento(pessoa.getDataNascimento());
		repository.save(pessoaAtualizada);
		
		return pessoaAtualizada;
	}

	/*
	public Page<Pessoa> findAllPage(int page, int pageSize) {
		
		Pageable pageable = (Pageable) PageRequest.of(page, pageSize);
		
		return repository.findAll(pageable);
	} */
	
	
}
