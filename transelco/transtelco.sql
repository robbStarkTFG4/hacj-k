-- phpMyAdmin SQL Dump
-- version 4.0.9
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-10-2014 a las 19:15:49
-- Versión del servidor: 5.6.14
-- Versión de PHP: 5.5.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `transtelco`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `familia`
--

CREATE TABLE IF NOT EXISTS `familia` (
  `idfamilia` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idfamilia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `material`
--

CREATE TABLE IF NOT EXISTS `material` (
  `idmaterial` int(11) NOT NULL AUTO_INCREMENT,
  `noParte` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `stock` varchar(45) DEFAULT NULL,
  `materialcol` varchar(45) DEFAULT NULL,
  `tbl_admin_idtbl_admin` int(11) NOT NULL,
  `sub_familia_idsub_familia` int(11) NOT NULL,
  PRIMARY KEY (`idmaterial`),
  UNIQUE KEY `noParte_UNIQUE` (`noParte`),
  KEY `fk_material_tbl_admin1_idx` (`tbl_admin_idtbl_admin`),
  KEY `fk_material_sub_familia1_idx` (`sub_familia_idsub_familia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamos`
--

CREATE TABLE IF NOT EXISTS `prestamos` (
  `idprestamos` int(11) NOT NULL AUTO_INCREMENT,
  `usuario_idusuario` int(11) NOT NULL,
  `usuario_nombre` varchar(45) NOT NULL,
  `fechaPrestamo` date NOT NULL,
  PRIMARY KEY (`idprestamos`),
  KEY `fk_prestamos_usuario1_idx` (`usuario_idusuario`,`usuario_nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sub_familia`
--

CREATE TABLE IF NOT EXISTS `sub_familia` (
  `idsub_familia` int(11) NOT NULL AUTO_INCREMENT,
  `familia_idfamilia` int(11) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idsub_familia`),
  KEY `fk_sub_familia_familia1_idx` (`familia_idfamilia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_admin`
--

CREATE TABLE IF NOT EXISTS `tbl_admin` (
  `idtbl_admin` int(11) NOT NULL AUTO_INCREMENT,
  `tbl_tipo_admin_idtbl_tipo_admin` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `apellidoPaterno` varchar(45) DEFAULT NULL,
  `apellidoMaterno` varchar(45) DEFAULT NULL,
  `usuario` varchar(45) NOT NULL,
  `contraseña` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtbl_admin`),
  KEY `fk_tbl_admin_tbl_tipo_admin_idx` (`tbl_tipo_admin_idtbl_tipo_admin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_tipo_admin`
--

CREATE TABLE IF NOT EXISTS `tbl_tipo_admin` (
  `idtbl_tipo_admin` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idtbl_tipo_admin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transanciones`
--

CREATE TABLE IF NOT EXISTS `transanciones` (
  `id_transanciones` int(11) NOT NULL AUTO_INCREMENT,
  `material_idmaterial` int(11) NOT NULL,
  `prestamos_idprestamos` int(11) NOT NULL,
  `cantidad` varchar(45) NOT NULL,
  PRIMARY KEY (`id_transanciones`),
  KEY `fk_transanciones_material1_idx` (`material_idmaterial`),
  KEY `fk_transanciones_prestamos1_idx` (`prestamos_idprestamos`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `id_trabajador` varchar(45) NOT NULL,
  `apellido_paterno` varchar(45) NOT NULL,
  `apellido_materno` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idusuario`,`nombre`),
  UNIQUE KEY `id_trabajador_UNIQUE` (`id_trabajador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `material`
--
ALTER TABLE `material`
  ADD CONSTRAINT `fk_material_tbl_admin1` FOREIGN KEY (`tbl_admin_idtbl_admin`) REFERENCES `tbl_admin` (`idtbl_admin`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_material_sub_familia1` FOREIGN KEY (`sub_familia_idsub_familia`) REFERENCES `sub_familia` (`idsub_familia`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `prestamos`
--
ALTER TABLE `prestamos`
  ADD CONSTRAINT `fk_prestamos_usuario1` FOREIGN KEY (`usuario_idusuario`, `usuario_nombre`) REFERENCES `usuario` (`idusuario`, `nombre`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `sub_familia`
--
ALTER TABLE `sub_familia`
  ADD CONSTRAINT `fk_sub_familia_familia1` FOREIGN KEY (`familia_idfamilia`) REFERENCES `familia` (`idfamilia`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tbl_admin`
--
ALTER TABLE `tbl_admin`
  ADD CONSTRAINT `fk_tbl_admin_tbl_tipo_admin` FOREIGN KEY (`tbl_tipo_admin_idtbl_tipo_admin`) REFERENCES `tbl_tipo_admin` (`idtbl_tipo_admin`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `transanciones`
--
ALTER TABLE `transanciones`
  ADD CONSTRAINT `fk_transanciones_material1` FOREIGN KEY (`material_idmaterial`) REFERENCES `material` (`idmaterial`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_transanciones_prestamos1` FOREIGN KEY (`prestamos_idprestamos`) REFERENCES `prestamos` (`idprestamos`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
