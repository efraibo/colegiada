package br.ifpe.pg.provacolegiada.model;

import br.ifpe.pg.provacolegiada.model.enumerator.EModalidade;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	private String nome;
	@Min(value = 40)
	private int cargaHoraria;

	@Enumerated(EnumType.STRING)
	private EModalidade modalidade;

	@ManyToOne
	@JoinColumn(name = "professor_id")
	private Professor coordenadorCurso;

	public Curso() {

	}

	public Curso(Integer id, String nome, int cargaHoraria, EModalidade modalidade, Professor coordenadorCurso) {
		super();
		this.id = id;
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
		this.modalidade = modalidade;
		this.coordenadorCurso = coordenadorCurso;
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

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public EModalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(EModalidade modalidade) {
		this.modalidade = modalidade;
	}

	public Professor getCoordenadorCurso() {
		return coordenadorCurso;
	}

	public void setCoordenadorCurso(Professor coordenadorCurso) {
		this.coordenadorCurso = coordenadorCurso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cargaHoraria;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		if (cargaHoraria != other.cargaHoraria)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
