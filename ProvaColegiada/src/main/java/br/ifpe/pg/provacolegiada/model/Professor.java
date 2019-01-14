package br.ifpe.pg.provacolegiada.model;

import br.ifpe.pg.provacolegiada.model.enumerator.EAreasPesquisa;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Professor {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;

	@Enumerated(EnumType.STRING)
	private EAreasPesquisa areasPesquisa;

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
	@JoinColumn(name = "professor_id")
	private Set<Curso> cursos = new HashSet<>();

	public Professor() {
		super();
	}
	public Professor(Integer id, String nome, String email, Set<Curso> cursos, EAreasPesquisa areasPesquisa) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cursos = cursos;
		this.areasPesquisa = areasPesquisa;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}

	public EAreasPesquisa getAreasPesquisa() {
		return areasPesquisa;
	}

	public void setAreasPesquisa(EAreasPesquisa areasPesquisa) {
		this.areasPesquisa = areasPesquisa;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Professor professor = (Professor) o;
		return Objects.equals(id, professor.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return nome;
	}
}
