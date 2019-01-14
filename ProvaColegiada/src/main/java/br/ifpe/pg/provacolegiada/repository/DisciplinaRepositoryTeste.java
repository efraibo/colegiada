package br.ifpe.pg.provacolegiada.repository;

import br.ifpe.pg.provacolegiada.model.Curso;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DisciplinaRepositoryTeste {

    @Query("select count(d) from Disciplina d where d.curso = :curso and d.nome = :nome and d.cargaHoraria = :cargaHoraria")
    int verificarTurmaIgual(@Param("curso") Curso curso, @Param("nome") String nome, @Param("cargaHoraria") int cargaHoraria);
}
