package br.ifpe.pg.provacolegiada.repository;

import java.util.List;

import br.ifpe.pg.provacolegiada.model.Curso;
import br.ifpe.pg.provacolegiada.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer> {

	@Query("select e from Turma e where e.curso = :curso order by e.ano, e.entrada")
	public List<Turma> findByCurso(Curso curso);
}
