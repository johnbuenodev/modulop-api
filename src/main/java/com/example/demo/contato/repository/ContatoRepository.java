package com.example.demo.contato.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.contato.domain.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer>{

	@Query("select c from Contato c where c.pessoa.id = :id")
	List<Contato> findAllByPessoaId(Integer id);
	

}
