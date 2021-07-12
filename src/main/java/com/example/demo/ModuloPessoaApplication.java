package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.contato.domain.Contato;
import com.example.demo.contato.repository.ContatoRepository;
import com.example.demo.pessoa.domain.Pessoa;
import com.example.demo.pessoa.repository.PessoaRepository;

@SpringBootApplication
public class ModuloPessoaApplication implements CommandLineRunner{
	
	@Autowired
	private PessoaRepository pessoarepository;
	
	@Autowired
	private ContatoRepository contatorepository;

	public static void main(String[] args) {
		SpringApplication.run(ModuloPessoaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		Pessoa p1 = new Pessoa(1, "João Paulo R B","363.064.588-75",
				formatter.parse("09/07/1988"));
		Pessoa p2 = new Pessoa(2, "Domingos de almeida neto","648.325.770-85",
				formatter.parse("09/07/2000"));
		Pessoa p3 = new Pessoa(3, "Mariana rodrigues", "239.748.140-51",formatter.parse("09/07/2000"));

		pessoarepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Contato c1 = new Contato(1, "Marcos Paulo", "99722040","marcuspaulo@gmail.com",p1);
		Contato c2 = new Contato(2, "Natalia Campos", "99722023","nataliacampos@gmail.com",p1);
		
		Contato c3 = new Contato(3, "Marcos Paulo", "99722040","marcuspaulo@gmail.com",p2);
		
		contatorepository.saveAll(Arrays.asList(c1,c2,c3));
		
	
        
	}
	
	
	
}
