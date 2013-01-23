package br.com.vinyanalista.agenda.modelo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Contato implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nome;

	private String email;

	private String telefone;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Contato)
			return ((Contato) obj).id == this.id;
		else
			return false;
	}
	
	@Override
	public String toString() {
		return nome;
	}

}