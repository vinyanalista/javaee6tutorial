package br.com.vinyanalista.agenda.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "age_contato")
public class Contato implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "con_id")
	private int id;

	@Column(name = "con_nome", unique = true, nullable = false)
	private String nome;

	@Column(name = "con_email")
	private String email;

	@Column(name = "con_telefone")
	private String telefone;
	
	@ManyToMany
	@JoinTable(name = "age_pertence",
		joinColumns = @JoinColumn(name = "per_contato"),
		inverseJoinColumns = @JoinColumn(name = "per_categoria"))
	private List<Categoria> categorias = new ArrayList<Categoria>();

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
	
	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
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