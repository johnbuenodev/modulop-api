package com.example.demo.contato.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import com.example.demo.pessoa.domain.Pessoa;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Contato implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Nome não pode ser vazio.")
	@Size(min=10, max=80, message = "Minimo 10 caracteres")
	private String nome;
	
	@NotEmpty(message = "Telefone não pode ser vazio.")
	@Size(min=8, max=8, message = "Minimo 8 caracteres")
	private String telefone;
	
	@NotEmpty(message = "E-mail não pode ser vazio.")
	@Email
	private String email;
	
    @ManyToOne
    @JoinColumn(name="pessoa_id", insertable = true)
    private Pessoa pessoa;
	
	public Contato() {
		super();
		// TODO Auto-generated constructor stub
	}
		

	public Contato(Integer id, String nome, String telefone, String email, Pessoa pessoa) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.pessoa = pessoa;
	}

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getTelefone() {
		return telefone;
	}



	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Pessoa getPessoa() {
		return pessoa;
	}



	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

    
	
	
}
