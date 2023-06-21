-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-06-2023 a las 13:46:23
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
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `comentarios`
--

INSERT INTO `comentarios` (`IdComentario`, `IdTarea`, `Comentario`, `FechaAvance`) VALUES
(17, 20, 'Gestion de Energia', '2023-05-01'),
(18, 21, 'Giro preciso', '2023-05-10'),
(19, 22, 'Giro habilidoso', '2022-05-20'),
(20, 23, 'Precision letal del Guerrero', '2023-05-21'),
(21, 24, 'Pensar el proximo movimiento', '2023-05-22'),
(22, 25, 'Consume el doble de energia', '2023-05-13'),
(23, 26, 'Potencia la Señal', '2022-05-12'),
(24, 27, 'Proteccion total y datos seguros', '2023-05-13'),
(25, 28, 'Guia precisa', '2023-05-25'),
(26, 29, 'Informacion estructurada', '2023-05-09'),
(27, 30, 'Consultar y filtrar datos', '2022-05-17'),
(28, 31, 'Informacion sincronizada', '2023-05-23'),
(29, 32, 'seleccionar las mas innovadoras', '2022-05-10'),
(30, 33, 'reducir gastos', '2023-05-10'),
(31, 34, 'uno por mes', '2022-05-25'),
(32, 35, 'objetivos comerciales', '2023-02-09'),
(33, 36, 'comenzar temprano', '2023-05-08'),
(34, 37, 'tener objetivos claros', '2022-08-10'),
(35, 38, 'innovadores', '2023-01-25'),
(36, 39, 'todos locales', '2023-04-11'),
(37, 40, 'semanal', '2022-08-25'),
(38, 41, 'innovadores', '2023-01-25'),
(39, 42, 'todos locales', '2023-04-11'),
(40, 43, 'semanal', '2022-08-25'),
(41, 44, 'diseña los planos las aulas', '2023-04-25'),
(42, 45, 'Calcula gastos', '2023-04-22'),
(43, 46, 'Organiza a los albañiles', '2023-04-29'),
(44, 47, 'Necesita mas cemento', '2023-05-25'),
(45, 48, 'Ya tiene 5 aulas terminadas', '2023-06-15'),
(46, 49, 'Hizo el revoque de 3 aulas', '2023-06-21'),
(47, 50, 'Lijo todas las paredes', '2023-06-02'),
(48, 51, 'Le falta terminar 5 ambientes', '2023-05-27'),
(49, 52, 'Reparo el cielo de los baños', '2023-06-07'),
(50, 53, 'Remplazo 20 placas de yeso de las paredes', '2023-05-28'),
(51, 54, 'Conto muchos chiste durante todo el dia', '2023-06-07'),
(52, 55, 'Se preparo un desayuno de la PM', '2023-06-07');

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
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `equipo`
--

INSERT INTO `equipo` (`IdEquipo`, `IdProyecto`, `Nombre`, `FechaCreacion`, `Estado`) VALUES
(22, 38, 'Avanzar', '2023-03-25', 1),
(23, 38, 'Disparar', '2023-03-26', 1),
(24, 39, 'Conexion Movil', '2022-01-27', 1),
(25, 39, 'Conexion SQL', '2022-01-28', 1),
(26, 40, 'los constructores', '2023-03-10', 1),
(27, 40, 'los tecnologicos', '2023-01-10', 0),
(28, 41, 'EcoGuardianes', '2023-04-08', 1),
(29, 41, 'EcoAccion', '2023-05-01', 0),
(30, 42, 'Arquitectos', '2023-06-20', 1),
(31, 42, 'Albañiles', '2023-06-20', 1),
(32, 43, 'Pintores', '2023-07-25', 1),
(33, 43, 'Durleros', '2023-07-25', 1);

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
  UNIQUE KEY `IdMiembro` (`IdMiembro`) USING BTREE,
  KEY `IdEquipo` (`IdEquipo`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `incorporacion`
--

INSERT INTO `incorporacion` (`IdIncorporacion`, `IdEquipo`, `IdMiembro`, `FechaIncorporacion`) VALUES
(44, 22, 25, '2023-03-28'),
(45, 22, 26, '2023-03-29'),
(46, 22, 27, '2023-03-29'),
(47, 23, 28, '2023-03-28'),
(48, 23, 29, '2023-03-29'),
(49, 23, 30, '2023-03-29'),
(50, 24, 31, '2022-01-29'),
(51, 24, 32, '2022-01-30'),
(52, 24, 33, '2022-01-31'),
(53, 25, 34, '2022-02-03'),
(54, 25, 35, '2022-02-05'),
(55, 25, 36, '2022-02-09'),
(68, 26, 37, '2022-08-10'),
(69, 26, 38, '2022-01-12'),
(70, 26, 39, '2023-05-21'),
(71, 27, 40, '2023-02-18'),
(72, 27, 41, '2023-04-21'),
(73, 27, 42, '2023-07-12'),
(74, 28, 43, '2023-03-10'),
(75, 28, 44, '2022-05-25'),
(76, 28, 45, '2023-04-28'),
(77, 29, 46, '2023-05-30'),
(78, 29, 47, '2023-05-30'),
(79, 29, 48, '2023-04-21'),
(80, 30, 73, '2023-06-10'),
(81, 30, 74, '2023-06-11'),
(82, 30, 75, '2023-06-12'),
(83, 31, 76, '2023-06-13'),
(84, 31, 77, '2023-06-14'),
(85, 31, 78, '2023-06-15'),
(86, 32, 79, '2023-06-16'),
(87, 32, 80, '2023-06-17'),
(88, 32, 83, '2023-06-17'),
(89, 33, 84, '2023-06-17'),
(90, 33, 81, '2023-06-18'),
(91, 33, 82, '2023-06-19');

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
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `miembro`
--

INSERT INTO `miembro` (`IdMiembro`, `Dni`, `Apellido`, `Nombre`, `Estado`) VALUES
(25, 434546789, 'Guerrero', 'Thor', 1),
(26, 555321698, 'Rodriguez', 'Ana', 0),
(27, 77223381, 'Ines', 'Esario', 1),
(28, 86782201, 'Aitor', 'Tilla', 1),
(29, 46231794, 'Sosa', 'Carlos', 1),
(30, 2345118, 'Paredes', 'Armando', 0),
(31, 36589556, 'Lopez', 'Susanita', 1),
(32, 3899556, 'Lopez', 'Marquitos', 1),
(33, 29874159, 'Sosa', 'Lautaro', 1),
(34, 35715982, 'Mercado', 'Florencia', 0),
(35, 45678925, 'Pepito', 'Matias', 1),
(36, 44487596, 'Rosarios', 'Martina', 0),
(37, 35894720, 'Ortega', 'Gabriel', 1),
(38, 24987325, 'Castro', 'Daniel', 0),
(39, 32594272, 'Guzman', 'Diego', 1),
(40, 29897361, 'Silva', 'Natalia', 1),
(41, 38872658, 'Ruiz', 'Andrea', 1),
(42, 25658471, 'Lopez', 'Carlos', 1),
(43, 26897632, 'Garcia', 'Alejandro', 0),
(44, 35999478, 'Morales', 'Laura', 0),
(45, 31894155, 'Perez', 'Raquel', 0),
(46, 27568222, 'Medina', 'Juan', 0),
(47, 34444155, 'Savalla', 'Lorenzo', 1),
(48, 38915985, 'Mendoza', 'Raquelita', 1),
(73, 35894020, 'Olivera', 'Mary', 1),
(74, 24987125, 'Becerra', 'Gabriel', 1),
(75, 32595272, 'Estudillo', 'Alex', 1),
(76, 29896361, 'Peñaloza', 'Pablo', 1),
(77, 38870058, 'Gonzalez', 'Juan', 1),
(78, 25657471, 'Gomez', 'Pedro', 1),
(79, 26897132, 'Aguilar', 'Nicolas', 1),
(80, 35099478, 'Moreno', 'Lucas', 1),
(81, 31804155, 'Castro', 'Martin', 1),
(82, 27508222, 'Riquelme', 'Roman', 1),
(83, 35011478, 'Morenito', 'Cocolizo', 1),
(84, 33099155, 'Lopez', 'Martina', 1),
(92, 36581116, 'Lopez', 'Susanita', 1),
(93, 38995569, 'Susanita', 'Recargada', 1),
(94, 38000556, 'Lopez', 'Marquitos', 1),
(95, 22574159, 'Sosa', 'Lautaro', 1),
(96, 35995982, 'Mercado', 'Florencia', 0),
(97, 44478925, 'Pepito', 'Matias', 1),
(98, 33387596, 'Rosarios', 'Martina', 0);

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
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `proyecto`
--

INSERT INTO `proyecto` (`IdProyecto`, `Nombre`, `Descripcion`, `FechaInicial`, `Estado`) VALUES
(38, 'Guerrero', 'Hacer funcionar al guerrero', '2023-03-21', 1),
(39, 'APP', 'Crear una aplicacion', '2022-01-25', 1),
(40, 'Responsabilidad Ambiental', 'tecnologias EcoAmigables', '2022-02-08', 1),
(41, 'Solucioneas Innovadoras', 'eficiencia y poductividad', '2020-10-31', 1),
(42, 'Construir Escuela', 'En barrio Estacion', '2023-06-20', 1),
(43, 'Remoledar un edificio', 'En el centro', '2023-07-25', 1),
(44, 'Gestion', 'Trabajo Final Laboratorio', '2023-05-31', 1),
(45, 'Robot', 'Hacer Funcionar un Robot', '2023-03-28', 1),
(46, 'Viaje', 'Creacion de viajes', '2022-05-31', 0);

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
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tarea`
--

INSERT INTO `tarea` (`IdTarea`, `IdIncorporacion`, `Nombre`, `FechaComienzo`, `FechaCierre`, `Estado`) VALUES
(20, 44, 'Cuidar la Energia', '2023-04-08', '2023-04-28', 1),
(21, 45, 'Girar a la Derecha', '2023-04-09', '2023-04-29', 1),
(22, 46, 'Girar a la Izquierda', '2023-04-10', '2023-04-30', 1),
(23, 47, 'Apuntar', '2023-03-30', '2023-04-03', 1),
(24, 48, 'Mantener Posicion', '2023-03-30', '2023-04-07', 1),
(25, 49, 'Disparo Rapido', '2023-03-31', '2023-04-10', 1),
(26, 50, 'Optimizar Señal', '2022-02-05', '2022-02-26', 1),
(27, 51, 'Seguridad y Privacidad', '2022-02-08', '2022-02-27', 1),
(28, 52, 'Localizacion y Navegacion', '2022-02-09', '2022-02-28', 1),
(29, 53, 'Gestionar Base de Datos', '2022-03-18', '2022-03-20', 1),
(30, 54, 'Consultas SQL', '2022-03-08', '2022-04-01', 1),
(31, 55, 'Sincronizar Datos', '2022-03-10', '2022-04-15', 1),
(32, 68, 'generar ideas', '2022-04-10', '2023-04-10', 0),
(33, 69, 'analizar costos', '2023-02-01', '2023-06-28', 1),
(34, 70, 'preparar informes', '2022-02-10', '2023-08-05', 1),
(35, 71, 'marketing', '2022-11-08', '2023-11-10', 1),
(36, 72, 'limpieza', '2022-03-01', '2024-03-01', 1),
(37, 73, 'investigacion', '2022-05-10', '2023-09-05', 1),
(38, 74, 'desarrollar proyectos', '2023-01-11', '2023-10-11', 1),
(39, 75, 'seleccionar proveedores', '2022-12-28', '2023-12-28', 1),
(40, 76, 'seguimiento', '2022-03-10', '2023-11-25', 1),
(41, 77, 'desarrollar inteligencia', '2023-01-11', '2023-10-11', 1),
(42, 78, 'seleccionar compradores', '2022-12-02', '2023-12-28', 1),
(43, 79, 'seguimiento de usuarios', '2022-09-10', '2023-11-25', 1),
(44, 80, 'Realizar planos', '2023-04-21', '2023-05-22', 1),
(45, 81, 'Calcular costos', '2023-04-21', '2023-05-22', 1),
(46, 82, 'Dar instrucciones a los albañi', '2023-04-21', '2023-05-22', 1),
(47, 83, 'Preparar mezcla', '2023-05-23', '2023-06-23', 1),
(48, 84, 'Levantar pared', '2023-05-23', '2023-06-23', 1),
(49, 85, 'Revocar pared', '2023-05-23', '2023-06-23', 1),
(50, 86, 'lijar y poner fijador', '2023-04-21', '2023-10-11', 1),
(51, 87, 'pintar paredes', '2023-04-21', '2023-10-10', 1),
(52, 88, 'desmontar cielo razos y montar', '2023-04-21', '2023-10-25', 1),
(53, 89, 'remplazar placas de yeso rotas', '2023-04-21', '2023-10-25', 1),
(54, 90, 'Contar chistes', '2023-04-21', '2023-10-25', 1),
(55, 91, 'preparar el desayuno', '2023-04-21', '2023-10-25', 1);

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
  ADD CONSTRAINT `incorporacion_ibfk_1` FOREIGN KEY (`IdEquipo`) REFERENCES `equipo` (`IdEquipo`),
  ADD CONSTRAINT `incorporacion_ibfk_2` FOREIGN KEY (`IdMiembro`) REFERENCES `miembro` (`IdMiembro`);

--
-- Filtros para la tabla `tarea`
--
ALTER TABLE `tarea`
  ADD CONSTRAINT `tarea_ibfk_1` FOREIGN KEY (`IdIncorporacion`) REFERENCES `incorporacion` (`IdIncorporacion`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
