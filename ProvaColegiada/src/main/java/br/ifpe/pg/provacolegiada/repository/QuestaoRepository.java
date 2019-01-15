package br.ifpe.pg.provacolegiada.repository;

import br.ifpe.pg.provacolegiada.model.Questao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface QuestaoRepository extends JpaRepository<Questao, Integer> {
}
