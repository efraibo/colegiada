package br.ifpe.pg.provacolegiada.model;

import br.ifpe.pg.provacolegiada.model.enumerator.ESituacao;
import br.ifpe.pg.provacolegiada.model.enumerator.ETurno;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Curso curso;
    @Enumerated(EnumType.STRING)
    private br.ifpe.pg.provacolegiada.model.enumerator.ETurno ETurno;
    private int ano;
    private int entrada;
    @Enumerated(EnumType.STRING)
    private ESituacao situacao;

    public Turma() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public ETurno getETurno() {
        return ETurno;
    }

    public void setETurno(ETurno ETurno) {
        this.ETurno = ETurno;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getEntrada() {
        return entrada;
    }

    public void setEntrada(int entrada) {
        this.entrada = entrada;
    }

    public ESituacao getSituacao() {
        return situacao;
    }

    public void setSituacao(ESituacao situacao) {
        this.situacao = situacao;
    }
}
