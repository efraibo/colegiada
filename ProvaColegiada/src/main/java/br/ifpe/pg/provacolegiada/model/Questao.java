package br.ifpe.pg.provacolegiada.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.ifpe.pg.provacolegiada.model.enumerator.ETipoQuestao;
import br.ifpe.pg.provacolegiada.model.enumerator.ENivelComplexidade;

@Entity
public class Questao {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Enumerated(EnumType.STRING)
	private ETipoQuestao ETipoQuestao;
	private String enunciado;
	@ManyToOne
	private Topico topico;
	@Enumerated(EnumType.STRING)
	private ENivelComplexidade ENivelComplexidade;
	@ManyToOne
	private Professor autor;
	
	public Questao() {
		super();
	}
	public Questao(Integer id, ETipoQuestao ETipoQuestao, String enunciado, Topico topico,
				   ENivelComplexidade ENivelComplexidade, Professor autor) {
		super();
		this.id = id;
		this.ETipoQuestao = ETipoQuestao;
		this.enunciado = enunciado;
		this.topico = topico;
		this.ENivelComplexidade = ENivelComplexidade;
		this.setAutor(autor);
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ETipoQuestao getETipoQuestao() {
		return ETipoQuestao;
	}
	public void setETipoQuestao(ETipoQuestao ETipoQuestao) {
		this.ETipoQuestao = ETipoQuestao;
	}
	public String getEnunciado() {
		return enunciado;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	public Topico getTopico() {
		return topico;
	}
	public void setTopico(Topico topico) {
		this.topico = topico;
	}
	public ENivelComplexidade getENivelComplexidade() {
		return ENivelComplexidade;
	}
	public void setENivelComplexidade(ENivelComplexidade ENivelComplexidade) {
		this.ENivelComplexidade = ENivelComplexidade;
	}
	public Professor getAutor() {
		return autor;
	}
	public void setAutor(Professor autor) {
		this.autor = autor;
	}
	
	
}
