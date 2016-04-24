-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema faculdade
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema faculdade
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `faculdade` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `faculdade` ;

-- -----------------------------------------------------
-- Table `faculdade`.`Aluno`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `faculdade`.`Aluno` (
  `cpf` VARCHAR(11) NOT NULL COMMENT '',
  `nome` VARCHAR(240) NOT NULL COMMENT '',
  `rg` VARCHAR(9) NOT NULL COMMENT '',
  `email` VARCHAR(150) NOT NULL COMMENT '',
  `telefone` VARCHAR(15) NOT NULL COMMENT '',
  `id` INT(5) NOT NULL AUTO_INCREMENT COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;

SELECT * FROM Aluno;

-- -----------------------------------------------------
-- Table `faculdade`.`Curso`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `faculdade`.`Curso` (
  `idCurso` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nomeCurso` VARCHAR(45) NOT NULL COMMENT '',
  `dataIniCurso` VARCHAR(45) NOT NULL COMMENT '',
  `dataFimCurso` VARCHAR(45) NOT NULL COMMENT '',
  `valorCurso` VARCHAR(45) NOT NULL COMMENT '',
  `numVagasCurso` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`idCurso`)  COMMENT '')
ENGINE = InnoDB;

SELECT * FROM Curso;
SELECT nomeCurso, DataIniCurso, DataFimCurso, valorCurso, numVagasCurso FROM Curso WHERE idCurso = 2;

INSERT INTO Curso (nomeCurso, dataIniCurso, dataFimCurso, valorCurso, numVagasCurso) VALUES (?,?,?,?,?);
UPDATE Curso SET nomeCurso = ?, dataIniCurso = ?, dataFimCurso = ? , valorCurso = ?, numVagasCurso = ? WHERE idCurso = ?;

-- -----------------------------------------------------
-- Table `faculdade`.`Matricula`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `faculdade`.`Matricula` (
  `idMatricula` INT(5) NOT NULL AUTO_INCREMENT COMMENT '',
  `idAluno` INT(5) NOT NULL COMMENT '',
  `idCurso` INT(5) NOT NULL COMMENT '',
  `nome` VARCHAR(240) NOT NULL COMMENT '',
  `dataMatricula` VARCHAR(15) NOT NULL COMMENT '',
  `dataCancelMatricula` VARCHAR(15) NOT NULL COMMENT '',
  `valorMatricula` VARCHAR(5) NOT NULL COMMENT '',
  `statusPagMatricula` VARCHAR(100) NOT NULL COMMENT '',
  PRIMARY KEY (`idMatricula`)  COMMENT '',
  INDEX `fk_Matricula_Aluno_idx` (`idAluno` ASC)  COMMENT '',
  INDEX `fk_Matricula_Curso1_idx` (`idCurso` ASC)  COMMENT '',
  CONSTRAINT `fk_Matricula_Aluno`
    FOREIGN KEY (`idAluno`)
    REFERENCES `faculdade`.`Aluno` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Matricula_Curso1`
    FOREIGN KEY (`idCurso`)
    REFERENCES `faculdade`.`Curso` (`idCurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SELECT * FROM Matricula;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


select * from Aluno;