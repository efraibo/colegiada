package br.ifpe.pg.provacolegiada.repository;

import br.ifpe.pg.provacolegiada.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {

    @Query("select d from Disciplina d where d.nome like %:nome% and d.curso.id = :idCurso order by d.nome")
    List<Disciplina> findByNomeCurso(String nome, Integer idCurso);
}
