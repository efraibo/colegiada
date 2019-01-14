package br.ifpe.pg.provacolegiada.service;

import br.ifpe.pg.provacolegiada.model.Curso;
import br.ifpe.pg.provacolegiada.model.Turma;
import br.ifpe.pg.provacolegiada.repository.CursoRepository;
import br.ifpe.pg.provacolegiada.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository repositorio;

	@Autowired
	private CursoRepository cursoRepository;

	public List<Turma> listarTodas() {
		return repositorio.findAll(Sort.by("curso.nome"));
	}

	public List<Turma> buscarPorCurso(Curso curso) {
		return repositorio.findByCurso(curso);
	}
	
	public Turma buscarPorId(Integer id) {
		return repositorio.findById(id).orElse(null);
	}

	public <S extends Turma> S salvar(S entity) throws Exception {
		if (cursoRepository.findAll().isEmpty()) {
			throw new Exception("Não é possível criar turmas sem cursos no sistema");
		}
		return repositorio.saveAndFlush(entity);
	}

	public void removerPorId(Integer id) {
		repositorio.deleteById(id);
	}
	
}
