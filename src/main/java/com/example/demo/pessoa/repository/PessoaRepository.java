package com.example.demo.pessoa.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.pessoa.domain.Pessoa;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{


}
