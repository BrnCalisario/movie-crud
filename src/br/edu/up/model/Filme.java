package br.edu.up.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "filme")
public class Filme implements Serializable {

	private static final long serialVersionUID = 5364898667897119191L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nome;
	private String ano;
	private String diretor;

	public Filme() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	@Override
	public String toString() {
		return nome + " (" + ano + ") " + "Directed by " + diretor + "\n";
	}

}
