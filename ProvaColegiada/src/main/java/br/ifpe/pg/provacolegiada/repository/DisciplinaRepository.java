package br.ifpe.pg.provacolegiada.repository;

import br.ifpe.pg.provacolegiada.model.Curso;
import br.ifpe.pg.provacolegiada.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {

    @Query("select d from Disciplina d where d.nome like %:nome% and d.curso.id = :idCurso order by d.nome")
    List<Disciplina> findByNomeCurso(String nome, Integer idCurso);

    @Query("select count(d) from Disciplina d where d.curso = :curso and d.nome = :nome and d.cargaHoraria = :cargaHoraria")
    int verificarTurmaIgual(@Param("curso") Curso curso, @Param("nome") String nome, @Param("cargaHoraria") int cargaHoraria);
}
