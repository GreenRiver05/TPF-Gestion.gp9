-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-06-2023 a las 16:25:19
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gestion_gp9_com2`
--
CREATE DATABASE IF NOT EXISTS `gestion_gp9_com2` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `gestion_gp9_com2`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentarios`
--

CREATE TABLE IF NOT EXISTS `comentarios` (
  `IdComentario` int(11) NOT NULL AUTO_INCREMENT,
  `IdTarea` int(11) NOT NULL,
  `Comentario` varchar(100) NOT NULL,
  `FechaAvance` date NOT NULL,
  PRIMARY KEY (`IdComentario`),
  KEY `IdTarea` (`IdTarea`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `comentarios`
--

INSERT INTO `comentarios` (`IdComentario`, `IdTarea`, `Comentario`, `FechaAvance`) VALUES
(1, 1, 'Deben crear 3/5 vistas', '2023-05-20'),
(2, 2, 'Crear Clases Entidades', '2023-10-10'),
(3, 3, 'Deben Crear conexion con singleton', '2022-08-20'),
(4, 4, 'No deben permitir que los compañeros se aburran', '2023-01-20');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipo`
--

CREATE TABLE IF NOT EXISTS `equipo` (
  `IdEquipo` int(11) NOT NULL AUTO_INCREMENT,
  `IdProyecto` int(11) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `FechaCreacion` date NOT NULL,
  `Estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`IdEquipo`),
  KEY `IdProyecto` (`IdProyecto`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `equipo`
--

INSERT INTO `equipo` (`IdEquipo`, `IdProyecto`, `Nombre`, `FechaCreacion`, `Estado`) VALUES
(2, 1, 'Equipo 2', '2022-10-14', 1),
(3, 14, 'Equipo 9', '2023-05-06', 1),
(4, 16, 'Equipo 4', '2021-03-24', 1),
(5, 15, 'Equipo 2', '2023-05-09', 1),
(6, 1, 'Equipo 1', '2023-08-17', 1),
(11, 14, 'Las mariposas', '2022-10-14', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `incorporacion`
--

CREATE TABLE IF NOT EXISTS `incorporacion` (
  `IdIncorporacion` int(11) NOT NULL AUTO_INCREMENT,
  `IdEquipo` int(11) NOT NULL,
  `IdMiembro` int(11) NOT NULL,
  `FechaIncorporacion` date NOT NULL,
  PRIMARY KEY (`IdIncorporacion`),
  KEY `IdEquipo` (`IdEquipo`),
  KEY `IdMiembro` (`IdMiembro`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `incorporacion`
--

INSERT INTO `incorporacion` (`IdIncorporacion`, `IdEquipo`, `IdMiembro`, `FechaIncorporacion`) VALUES
(13, 2, 1, '2023-01-25'),
(14, 3, 2, '2023-02-01'),
(15, 4, 3, '2021-10-19'),
(16, 5, 4, '2022-03-28'),
(17, 6, 5, '2022-08-04'),
(18, 6, 6, '2022-11-12');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `miembro`
--

CREATE TABLE IF NOT EXISTS `miembro` (
  `IdMiembro` int(11) NOT NULL AUTO_INCREMENT,
  `Dni` int(11) NOT NULL,
  `Apellido` varchar(30) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`IdMiembro`),
  UNIQUE KEY `Dni` (`Dni`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `miembro`
--

INSERT INTO `miembro` (`IdMiembro`, `Dni`, `Apellido`, `Nombre`, `Estado`) VALUES
(1, 36589556, 'Lopez', 'Susanita', 1),
(2, 3899556, 'Lopez', 'Marquitos', 1),
(3, 29874159, 'Sosa', 'Lautaro', 1),
(4, 35715982, 'Mercado', 'Florencia', 0),
(5, 45678925, 'Pepito', 'Matias', 1),
(6, 44487596, 'Rosarios', 'Martina', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyecto`
--

CREATE TABLE IF NOT EXISTS `proyecto` (
  `IdProyecto` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(30) NOT NULL,
  `Descripcion` varchar(30) NOT NULL,
  `FechaInicial` date NOT NULL,
  `Estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`IdProyecto`),
  UNIQUE KEY `Nombre` (`Nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `proyecto`
--

INSERT INTO `proyecto` (`IdProyecto`, `Nombre`, `Descripcion`, `FechaInicial`, `Estado`) VALUES
(1, 'Viaje', 'Creacion de viajes', '2022-05-31', 0),
(14, 'Gestion', 'Trabajo Final Laboratorio', '2023-05-31', 1),
(15, 'Robot', 'Hacer Funcionar un Robot', '2023-03-28', 0),
(16, 'Universidad', 'Trabajo Transversal Laboratori', '0000-00-00', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarea`
--

CREATE TABLE IF NOT EXISTS `tarea` (
  `IdTarea` int(11) NOT NULL AUTO_INCREMENT,
  `IdIncorporacion` int(11) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `FechaComienzo` date NOT NULL,
  `FechaCierre` date NOT NULL,
  `Estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`IdTarea`),
  KEY `IdIncorporacion` (`IdIncorporacion`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tarea`
--

INSERT INTO `tarea` (`IdTarea`, `IdIncorporacion`, `Nombre`, `FechaComienzo`, `FechaCierre`, `Estado`) VALUES
(1, 14, 'Crear Vistas', '2023-05-08', '2023-05-30', 1),
(2, 13, 'Crear Clases', '2022-02-20', '2022-03-03', 1),
(3, 15, 'Crear Conexión', '2023-10-28', '2023-11-20', 1),
(4, 17, 'Contar Chistes', '2023-01-18', '2023-12-10', 1),
(5, 18, 'Es la Jefa', '2023-05-08', '2023-05-30', 1);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `comentarios`
--
ALTER TABLE `comentarios`
  ADD CONSTRAINT `comentarios_ibfk_1` FOREIGN KEY (`IdTarea`) REFERENCES `tarea` (`IdTarea`);

--
-- Filtros para la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD CONSTRAINT `equipo_ibfk_1` FOREIGN KEY (`IdProyecto`) REFERENCES `proyecto` (`IdProyecto`);

--
-- Filtros para la tabla `incorporacion`
--
ALTER TABLE `incorporacion`
  ADD CONSTRAINT `incorporacion_ibfk_1` FOREIGN KEY (`IdEquipo`) REFERENCES `equipo` (`IdEquipo`);

--
-- Filtros para la tabla `miembro`
--
ALTER TABLE `miembro`
  ADD CONSTRAINT `miembro_ibfk_1` FOREIGN KEY (`IdMiembro`) REFERENCES `incorporacion` (`IdMiembro`);

--
-- Filtros para la tabla `tarea`
--
ALTER TABLE `tarea`
  ADD CONSTRAINT `tarea_ibfk_1` FOREIGN KEY (`IdIncorporacion`) REFERENCES `incorporacion` (`IdIncorporacion`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
