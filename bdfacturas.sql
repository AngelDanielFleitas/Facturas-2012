SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `bdfacturas` ;
CREATE SCHEMA IF NOT EXISTS `bdfacturas` DEFAULT CHARACTER SET utf8 ;
USE `bdfacturas` ;

-- -----------------------------------------------------
-- Table `bdfacturas`.`EMISOR`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdfacturas`.`EMISOR` ;

CREATE TABLE IF NOT EXISTS `bdfacturas`.`EMISOR` (
  `RFC` VARCHAR(45) NOT NULL,
  `RazonSocial` VARCHAR(45) NULL,
  `RegimenFiscal` VARCHAR(45) NULL,
  `Calle` VARCHAR(45) NULL,
  `numeroext` VARCHAR(45) NULL,
  `numeroint` VARCHAR(45) NULL,
  `colonia` VARCHAR(45) NULL,
  `cp` VARCHAR(45) NULL,
  `municipio` VARCHAR(45) NULL,
  `estado` VARCHAR(45) NULL,
  PRIMARY KEY (`RFC`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdfacturas`.`CLIENTE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdfacturas`.`CLIENTE` ;

CREATE TABLE IF NOT EXISTS `bdfacturas`.`CLIENTE` (
  `RFC` CHAR(13) NOT NULL,
  `RazonSocial` VARCHAR(45) NULL,
  `Calle` VARCHAR(45) NULL,
  `Numeroext` VARCHAR(45) NULL,
  `Numeroint` VARCHAR(45) NULL,
  `Colonia` VARCHAR(45) NULL,
  `CP` VARCHAR(45) NULL,
  `Municipio` VARCHAR(45) NULL,
  `Estado` VARCHAR(45) NULL,
  `Correo` VARCHAR(45) NULL,
  PRIMARY KEY (`RFC`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdfacturas`.`COMPRA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdfacturas`.`COMPRA` ;

CREATE TABLE IF NOT EXISTS `bdfacturas`.`COMPRA` (
  `IdCompra` VARCHAR(45) NOT NULL,
  `Descripcion` VARCHAR(45) NULL,
  `Cantidad` VARCHAR(45) NULL,
  `Unidad` VARCHAR(45) NULL DEFAULT 'LITROS',
  `valorUnitario` VARCHAR(45) NULL,
  `subtotal` VARCHAR(45) NULL,
  `impuestos` VARCHAR(45) NULL,
  `total` VARCHAR(45) NULL,
  `Fecha` DATE NULL,
  `Hora` TIME NULL,
  PRIMARY KEY (`IdCompra`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdfacturas`.`FACTURA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdfacturas`.`FACTURA` ;

CREATE TABLE IF NOT EXISTS `bdfacturas`.`FACTURA` (
  `IdFactura` INT NOT NULL AUTO_INCREMENT,
  `TipoPago` VARCHAR(45) NULL,
  `Serie` VARCHAR(45) NULL,
  `Folio` VARCHAR(45) NULL,
  `Sello` VARCHAR(45) NULL,
  `Cadena` VARCHAR(45) NULL,
  `Fecha` DATE NULL,
  `Hora` TIME NULL,
  `EMISORRFC` VARCHAR(45) NULL,
  `CLIENTERFC` CHAR(13) NULL,
  `IdCompra` VARCHAR(45) NULL,
  PRIMARY KEY (`IdFactura`),
  INDEX `fk_FACTURA_EMISOR_idx` (`EMISORRFC` ASC),
  INDEX `fk_FACTURA_CLIENTE1_idx` (`CLIENTERFC` ASC),
  INDEX `fk_FACTURA_COMPRA1_idx` (`IdCompra` ASC),
  CONSTRAINT `fk_FACTURA_EMISOR`
    FOREIGN KEY (`EMISORRFC`)
    REFERENCES `bdfacturas`.`EMISOR` (`RFC`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_FACTURA_CLIENTE1`
    FOREIGN KEY (`CLIENTERFC`)
    REFERENCES `bdfacturas`.`CLIENTE` (`RFC`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_FACTURA_COMPRA1`
    FOREIGN KEY (`IdCompra`)
    REFERENCES `bdfacturas`.`COMPRA` (`IdCompra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdfacturas`.`ADMIN`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdfacturas`.`ADMIN` ;

CREATE TABLE IF NOT EXISTS `bdfacturas`.`ADMIN` (
  `idADMIN` VARCHAR(45) NOT NULL,
  `Mensaje` VARCHAR(45) NULL,
  `Asunto` VARCHAR(45) NULL,
  `Pass` VARCHAR(45) NULL,
  PRIMARY KEY (`idADMIN`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdfacturas`.`Combustible`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bdfacturas`.`Combustible` ;

CREATE TABLE IF NOT EXISTS `bdfacturas`.`Combustible` (
  `Nombre` VARCHAR(45) NOT NULL,
  `PrecioUnitario` VARCHAR(45) NULL,
  PRIMARY KEY (`Nombre`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
