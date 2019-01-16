-- INSERT INTO PROFESSOR VALUES(1, 'Francisco', 'francisco@ifpe.com', 'ENGENHARIA_E_TECNOLOGIA_DA_INFORMACAO_E_COMUNICACAO');
-- INSERT INTO CURSO VALUES(1, 'CCO', 50, 'EAD', 1);
-- INSERT INTO DISCIPLINA VALUES(1, 'java', 1, 40, 'teste', '', '1°');

insert into professor (id, areas_pesquisa, email, nome) values (1, 'ENGENHARIA_E_TECNOLOGIA_DA_INFORMACAO_E_COMUNICACAO', 'francisco@ifpe.com', 'Francisco');
insert into curso (id, carga_horaria, professor_id, modalidade, nome) values (1, 50, 1, 'EAD', 'CCO');
insert into disciplina (id, carga_horaria, curso_id, ementa, nome, periodo) values (1, 80, 1, 'Orientação a Objetos', 'Java', 'SEGUNDO');

insert into topico (id, descricao, ordem, disciplina_id) values (1, 'Topico Inicial', 1, 1);