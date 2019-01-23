package br.ifpe.pg.provacolegiada.repository;

import br.ifpe.pg.provacolegiada.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

	boolean existsByNome(String nome);

	@Query("select c from Curso c where c.modalidade='PRESENCIAL'")
	List<Curso> listarCursosCustomizados();
}
