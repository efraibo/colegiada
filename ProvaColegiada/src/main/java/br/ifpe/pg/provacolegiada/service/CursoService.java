package br.ifpe.pg.provacolegiada.service;

import java.util.List;

import br.ifpe.pg.provacolegiada.model.Curso;
import br.ifpe.pg.provacolegiada.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

	@Autowired
	private CursoRepository repositorio;

	public List<Curso> listarTodos() {
		return repositorio.findAll(Sort.by("nome"));
	}


	public List<Curso> listarCursosCustomizados() {
		return repositorio.listarCursosCustomizados();
	}

	public Curso buscarPorId(Integer id) {
		return repositorio.findById(id).orElse(null);
	}

	public Curso salvar(Curso curso) throws Exception {
		if (repositorio.existsByNome(curso.getNome()) && curso.getId() == null) {
			throw new Exception("Já existe curso com este nome");
		}
		return repositorio.saveAndFlush(curso);
	}

	public Curso removerPorId(Integer id) {
		Curso curso = buscarPorId(id);
		repositorio.deleteById(id);
		return curso;
	}

	
}
