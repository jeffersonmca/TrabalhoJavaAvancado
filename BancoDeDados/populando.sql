INSERT INTO `GerenciadorAmbiente`.`PERIODO` (`per_ano`, `per_semestre`) VALUES ('2019', 'PRIMEIRO');
INSERT INTO `GerenciadorAmbiente`.`PERIODO` (`per_ano`, `per_semestre`) VALUES ('2019', 'SEGUNDO');

INSERT INTO `GerenciadorAmbiente`.`CURSO` (`cur_nome`, `cur_perCodigo`) VALUES ('Ciência da Computação', '1');
INSERT INTO `GerenciadorAmbiente`.`CURSO` (`cur_nome`, `cur_perCodigo`) VALUES ('Matemática', '2');
INSERT INTO `GerenciadorAmbiente`.`CURSO` (`cur_nome`, `cur_perCodigo`) VALUES ('Ciência da Computação', '2');

INSERT INTO `GerenciadorAmbiente`.`DISCIPLINA` (`dis_cargaHoraria`, `dis_nome`, `dis_curCodigo`) VALUES ('60', 'Teoria da Computação', '1');
INSERT INTO `GerenciadorAmbiente`.`DISCIPLINA` (`dis_cargaHoraria`, `dis_nome`, `dis_curCodigo`) VALUES ('90', 'Cálculo 1', '2');
INSERT INTO `GerenciadorAmbiente`.`DISCIPLINA` (`dis_cargaHoraria`, `dis_nome`, `dis_curCodigo`) VALUES ('60', 'POO', '3');

INSERT INTO `GerenciadorAmbiente`.`PESSOA` (`pes_email`, `pes_nome`, `pes_tipoPessoa`) VALUES ('prof1@gmail.com', 'Professor1', 'PROFESSOR');
INSERT INTO `GerenciadorAmbiente`.`PESSOA` (`pes_email`, `pes_nome`, `pes_tipoPessoa`) VALUES ('alu1@gmail.com', 'Aluno1', 'ALUNO');
INSERT INTO `GerenciadorAmbiente`.`PESSOA` (`pes_email`, `pes_nome`, `pes_tipoPessoa`) VALUES ('alu2@gmail.com', 'Aluno2', 'ALUNO');
INSERT INTO `GerenciadorAmbiente`.`PESSOA` (`pes_email`, `pes_nome`, `pes_tipoPessoa`) VALUES ('alu3@gmail.com', 'Aluno3', 'ALUNO');
INSERT INTO `GerenciadorAmbiente`.`PESSOA` (`pes_email`, `pes_nome`, `pes_tipoPessoa`) VALUES ('prof2@gmail.com', 'Professor2', 'PROFESSOR');

INSERT INTO `GerenciadorAmbiente`.`AMBIENTE` (`amb_capacidade`, `amb_localizacao`, `amb_nome`, `amb_tipCodigo`) VALUES ('40', 'Bloco C', 'Sala 37', 'SALA');
INSERT INTO `GerenciadorAmbiente`.`AMBIENTE` (`amb_capacidade`, `amb_localizacao`, `amb_nome`, `amb_tipCodigo`) VALUES ('50', 'Bloco C', 'Sala 16', 'SALA');
INSERT INTO `GerenciadorAmbiente`.`AMBIENTE` (`amb_capacidade`, `amb_localizacao`, `amb_nome`, `amb_tipCodigo`) VALUES ('35', 'Bloco C', 'Sala 22', 'SALA');
INSERT INTO `GerenciadorAmbiente`.`AMBIENTE` (`amb_capacidade`, `amb_localizacao`, `amb_nome`, `amb_tipCodigo`) VALUES ('25', 'Bloco B', 'Lab 1', 'LABORATORIO');
INSERT INTO `GerenciadorAmbiente`.`AMBIENTE` (`amb_capacidade`, `amb_localizacao`, `amb_nome`, `amb_tipCodigo`) VALUES ('25', 'Bloco B', 'Lab 2', 'LABORATORIO');

INSERT INTO `GerenciadorAmbiente`.`TURMA` (`tur_nome`, `tur_perCodigo`, `tur_proCodigo`, `tur_disCodigo`) VALUES ('Turma1', '1', '1', '1');
INSERT INTO `GerenciadorAmbiente`.`TURMA` (`tur_nome`, `tur_perCodigo`, `tur_proCodigo`, `tur_disCodigo`) VALUES ('Turma2', '2', '5', '2');
INSERT INTO `GerenciadorAmbiente`.`TURMA` (`tur_nome`, `tur_perCodigo`, `tur_proCodigo`, `tur_disCodigo`) VALUES ('Turma3', '1', '1', '3');

INSERT INTO `GerenciadorAmbiente`.`AULA` (`aul_enumDiaSemana`, `aul_horarioInicio`, `aul_horarioTermino`, `aul_ambCodigo`, `TURMA_tur_codigo`) VALUES ('SEGUNDA', '13:30', '15:50', '1', '2');
INSERT INTO `GerenciadorAmbiente`.`AULA` (`aul_enumDiaSemana`, `aul_horarioInicio`, `aul_horarioTermino`, `aul_ambCodigo`, `TURMA_tur_codigo`) VALUES ('TERCA', '10:20', '12:20', '1', '1');
INSERT INTO `GerenciadorAmbiente`.`AULA` (`aul_enumDiaSemana`, `aul_horarioInicio`, `aul_horarioTermino`, `aul_ambCodigo`, `TURMA_tur_codigo`) VALUES ('TERCA', '18:30', '20:30', '4', '3');