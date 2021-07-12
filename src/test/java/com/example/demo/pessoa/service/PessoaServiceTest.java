package com.example.demo.pessoa.service;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.pessoa.domain.Pessoa;
import com.example.demo.pessoa.repository.PessoaRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
class PessoaServiceTest {


	@MockBean
	private PessoaRepository pessoaRepository;
	
	@SpyBean
	private PessoaService pessoaService;
	
	private Integer idgen;
	private Integer idgen2;
	private Pessoa pessoa;
	private Pessoa pessoa2;
	private List<Pessoa> pessoaList;
	SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
	Date date;
	Date date2;
	
	@Before
	public void init() throws ParseException {
		
		idgen = 1;
		idgen2 = 2;
		
		pessoaList = new ArrayList<>();
		
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		
		date = new SimpleDateFormat("dd/MM/yyyy").parse("09/07/1990");
		date2 = new SimpleDateFormat("dd/MM/yyyy").parse("09/07/1990");
		
		
		pessoa = new Pessoa(idgen, "João Paulo R B","363.064.588-75",date);
		
		pessoa2 = new Pessoa(idgen2, "Domingos de almeida neto","648.325.770-85",date2);
		
		pessoaList.add(pessoa);
		pessoaList.add(pessoa2);
		
		
	}
	
	@Test
	public void findPessoaById() {
		Mockito.when(pessoaRepository.findById(pessoa.getId())).thenReturn(Optional.of(pessoa));
		Assert.assertEquals(pessoa, pessoaService.findById(pessoa.getId()));
		
	}
	
	@Test
	public void deletePessoa() {
		
		pessoaService.deletePessoa(pessoa.getId());
	}
	
	@Test
	public void findAllPessoa() {
		Mockito.when(pessoaRepository.findAll()).thenReturn(pessoaList);
		Assert.assertEquals(pessoaList, pessoaService.findAll());
		
	}
	
	/*
    @Test
    public void updatePessoa(){
    	Mockito.when(pessoaRepository.findById(Mockito.any())).thenReturn(Optional.of(pessoa));
    	Mockito.when(pessoaRepository.save(Mockito.any())).thenReturn(pessoa);
   
    	pessoa.setNome("John alterado");
    	pessoa.setCpf("363.064.588-75");
    	
    	Assert.assertEquals(pessoa, pessoaService.updateById(pessoa.getId(),pessoa));
    	
    }
    
    @Test
    public void insertPessoa() {
    	
    	Mockito.when(pessoaRepository.save(Mockito.any())).thenReturn(Optional.of(pessoa));
    	Optional<Pessoa> pessoa3 = Optional.ofNullable(pessoa);
    	Assert.assertEquals(pessoa3, pessoaService.createPessoa(pessoa));
    	
    } */
	
	
}