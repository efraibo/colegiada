package br.ifpe.pg.provacolegiada.service;

import br.ifpe.pg.provacolegiada.model.Questao;
import br.ifpe.pg.provacolegiada.repository.QuestaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestaoService {

    @Autowired
    private QuestaoRepository repositorio;

    public List<Questao> listarTodos() {
        return repositorio.findAll();
    }

    public Questao buscarPorId(Integer id) {
        return null;
    }

    public Questao salvar(Questao questao) {
        return repositorio.saveAndFlush(questao);
    }

    public Questao removerPorId(Integer id) {
        Questao questao = buscarPorId(id);
        repositorio.deleteById(id);
        return questao;
    }


}
