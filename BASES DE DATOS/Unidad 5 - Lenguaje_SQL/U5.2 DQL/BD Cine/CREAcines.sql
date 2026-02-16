

CREATE TABLE `cine` (
  `idCine` int(11) NOT NULL ,
  `nombreCine` varchar(44)  NOT NULL,
  `poblacionCine` varchar(33) NOT NULL
) ;

CREATE TABLE `sala` (
  `idCine` int(11) NOT NULL,
  `idSala` int(11) NOT NULL,
  `butacasSala` int(11) NOT NULL
) ;


CREATE TABLE `ticket` (
  `idTicket` int(11) NOT NULL,
  `idCine` int(11) NOT NULL,
  `idSala` int(11) NOT NULL,
  `dia` date NOT NULL,
  `hora` time NOT NULL,
  `precio` float NOT NULL
) ;

ALTER TABLE `cine`
  ADD PRIMARY KEY (`idCine`);


ALTER TABLE `sala`
  ADD PRIMARY KEY (`idCine`,`idSala`),
  ADD KEY `idCine` (`idCine`);


ALTER TABLE `ticket`
  ADD PRIMARY KEY (`idTicket`),
  ADD KEY `idCine` (`idCine`,`idSala`);


ALTER TABLE `cine`
  MODIFY `idCine` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

ALTER TABLE `ticket`
  MODIFY `idTicket` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

ALTER TABLE `sala`
  ADD CONSTRAINT `sala_ibfk_1` FOREIGN KEY (`idCine`) REFERENCES `cine` (`idCine`) ON UPDATE CASCADE;

 
