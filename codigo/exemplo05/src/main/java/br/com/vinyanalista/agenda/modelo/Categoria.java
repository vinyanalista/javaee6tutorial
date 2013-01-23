package br.com.vinyanalista.agenda.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "age_categoria")
@NamedQuery(name = Categoria.LISTAR_TODAS, query = "SELECT c FROM Categoria c")
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String LISTAR_TODAS = "Categoria.listarTodas";

	@Id
	@GeneratedValue
	@Column(name = "cat_id")
	private Integer id;

	@Column(name = "cat_nome", unique = true, nullable = false)
	private String nome;
	
	@ManyToMany(mappedBy = "categorias")
	private List<Contato> contatos = new ArrayList<Contato>();

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
	
	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Categoria)
			return ((Categoria) obj).id == this.id;
		else
			return false;
	}
	
	@Override
	public String toString() {
		return nome;
	}

}