package com.example.demo.contato.service;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.contato.domain.Contato;
import com.example.demo.contato.repository.ContatoRepository;
import com.example.demo.pessoa.domain.Pessoa;
import com.example.demo.pessoa.repository.PessoaRepository;
import com.example.demo.pessoa.service.PessoaService;

@RunWith(SpringRunner.class)
@SpringBootTest
class ContatoServiceTest {

	@MockBean
	private ContatoRepository contatoRepository;
	
	@SpyBean
	private ContatoService contatoService;

	
	private Integer idgen;
	private Integer idgen2;
	private Pessoa pessoa;
	private Contato c1;
	private Contato c2;
	private List<Contato> contatoList;
	SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
	
	@Before
	public void init() throws ParseException {
		
		idgen = 1;
		idgen2 = 2;
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		pessoa = new Pessoa(idgen, "João Paulo R B","363.064.588-75",
				formatter.parse("09/07/1988"));

		c1 = new Contato(idgen, "Marcos Paulo", "99722040","marcuspaulo@gmail.com",pessoa);
		c2 = new Contato(idgen2, "Natalia Campos", "99722023","nataliacampos@gmail.com",pessoa);
		
		contatoList = new ArrayList<>();
		contatoList.add(c1);
		contatoList.add(c2);
		
	}	
	
	@Test
	public void findContatoById() {
		Mockito.when(contatoRepository.findById(Mockito.any())).thenReturn(Optional.of(c1));
		Assert.assertEquals(c1,contatoService.findById(c1.getId()));
		
	}
	
	
	@Test
	public void deleteContato() {
		
		this.contatoService.deleteContato(c1.getId());
	}
	
	
	@Test
	public void findAllContato() {
		Mockito.when(this.contatoRepository.findAll()).thenReturn(contatoList);
		Assert.assertEquals(contatoList, this.contatoService.findAll());
		
	}
	
	//@Test
	////public void findAllContatoByPessoaId() {
	//	Mockito.when(contatoRepository.findAllByPessoaId(Mockito.any())).thenReturn(contatoList);
	///	Assert.assertEquals(contatoList, contatoService.findAllByPessoaId(pessoa.getId()));
		
	//}
	
	
   /// @Test
    ///public void updateContato(){
    //	Mockito.when(contatoRepository.findById(Mockito.any())).thenReturn(Optional.of(c1));
    //	Mockito.when(contatoRepository.save(Mockito.any())).thenReturn(c1);
    	
    //	c1.setNome("Bueno teste");
    //	c1.setTelefone("33214550");
    //	
    //	Assert.assertEquals(c1, contatoService.updateContato(c1.getId(),c1));
    	
    //}
    
  
    @Test
    public void insertContato() {
    	
    	Mockito.when(this.contatoRepository.save(Mockito.any())).thenReturn(Optional.of(c1));
    	Assert.assertEquals(c1, this.contatoService.createContato(c1));
    	
    }

	
}
