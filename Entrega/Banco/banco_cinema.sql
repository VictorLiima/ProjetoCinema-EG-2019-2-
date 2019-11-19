CREATE DATABASE `banco_cinema`;
USE `banco_cinema`;

CREATE TABLE `filmes` (
  `idfilme` int(11) NOT NULL,
  `titulo` varchar(100) NOT NULL,
  `diretor` varchar(100) NOT NULL,
  `genero` varchar(45) NOT NULL,
  `idioma` varchar(45) NOT NULL,
  `duracao` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `ingressos` (
  `idingressos` int(11) NOT NULL,
  `valor` int(11) NOT NULL,
  `quantidade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `salas` (
  `idsala` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `capacidade` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `sessoes` (
  `idsessoes` int(11) NOT NULL,
  `filme` varchar(150) NOT NULL,
  `sala` int(11) NOT NULL,
  `data` varchar(20) NOT NULL,
  `horario` varchar(20) NOT NULL,
  `valor_ingresso` int(11) NOT NULL,
  `ingressos_disponiveis` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `filmes`
  ADD PRIMARY KEY (`idfilme`);
  
ALTER TABLE `ingressos`
  ADD PRIMARY KEY (`idingressos`);
  
ALTER TABLE `salas`
  ADD PRIMARY KEY (`idsala`);
  
ALTER TABLE `sessoes`
  ADD PRIMARY KEY (`idsessoes`);
  
ALTER TABLE `filmes`
  MODIFY `idfilme` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
  
ALTER TABLE `ingressos`
  MODIFY `idingressos` int(11) NOT NULL AUTO_INCREMENT;
  
ALTER TABLE `salas`
  MODIFY `idsala` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
  
ALTER TABLE `sessoes`
  MODIFY `idsessoes` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
COMMIT;

