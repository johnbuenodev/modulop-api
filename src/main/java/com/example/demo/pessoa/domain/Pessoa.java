package com.example.demo.pessoa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.example.demo.contato.domain.Contato;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="pessoa_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min=10,max=80, message = "Minimo 10 caracteres.")
	@Column(nullable = false)
	private String nome;
	
	@Size(min=11, max=14, message = "Minimo 11 numeros.")
	@Column(nullable = false, unique=true)
	@CPF
	private String cpf;
	
	@Column(nullable = false)
	@Past(message = "DataNascimento não pode ser uma data atual.")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Contato> contatos = new ArrayList<Contato>();
	
	public Pessoa() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Pessoa(Integer id, String nome, String cpf, Date dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
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


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Date getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
}

