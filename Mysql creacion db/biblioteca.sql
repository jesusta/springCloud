-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-11-2022 a las 22:35:49
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `biblioteca`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE `categorias` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `created` timestamp NULL DEFAULT NULL,
  `modified` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`id`, `nombre`, `created`, `modified`) VALUES
(3, 'dfffff', NULL, '2022-04-27 02:13:39'),
(4, 'ficcion', '2022-04-27 00:29:57', '2022-04-27 00:29:57'),
(6, 'accion', '2022-04-27 01:59:42', '2022-04-27 01:59:42'),
(7, 'dffff', '2022-04-27 02:00:14', '2022-04-27 02:00:14'),
(8, 'wold studio', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalles`
--

CREATE TABLE `detalles` (
  `Id` int(11) NOT NULL,
  `libros_id` int(11) NOT NULL,
  `prestamos_id` int(11) NOT NULL,
  `precio` double NOT NULL,
  `created` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `modified` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detalles`
--

INSERT INTO `detalles` (`Id`, `libros_id`, `prestamos_id`, `precio`, `created`, `modified`) VALUES
(1, 1, 5, 1000, '2022-05-04 05:32:10', NULL),
(2, 2, 5, 2000, '2022-05-04 05:48:10', NULL),
(3, 1, 1, 20000, '2022-05-04 06:32:54', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `editoriales`
--

CREATE TABLE `editoriales` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `created` timestamp NULL DEFAULT NULL,
  `modified` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `editoriales`
--

INSERT INTO `editoriales` (`id`, `nombre`, `created`, `modified`) VALUES
(2, 'dale', '2022-04-27 02:23:07', NULL),
(3, 'Lola', '2020-08-03 00:00:00', '2022-03-12 00:00:00'),
(4, 'moli', '2020-08-03 00:00:00', NULL),
(5, 'Cindy', '2022-10-04 04:27:14', '2022-10-04 04:27:14'),
(6, 'Cindy', '2022-10-04 04:16:14', '2022-10-04 04:16:14'),
(7, 'wold studio', '2022-11-02 19:42:27', '2022-11-02 19:42:27');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libros`
--

CREATE TABLE `libros` (
  `id` int(11) NOT NULL,
  `titulo` varchar(45) NOT NULL,
  `descripcion` varchar(70) NOT NULL,
  `precio` double NOT NULL,
  `ejemplares` int(11) NOT NULL,
  `autor` varchar(45) NOT NULL,
  `editoriales_id` int(11) NOT NULL,
  `categorias_id` int(11) NOT NULL,
  `created` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `modified` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `libros`
--

INSERT INTO `libros` (`id`, `titulo`, `descripcion`, `precio`, `ejemplares`, `autor`, `editoriales_id`, `categorias_id`, `created`, `modified`) VALUES
(1, 'Anaconda', 'película de una anaconda', 10000, 4, 'jose', 2, 7, '2022-04-27 02:38:48', NULL),
(2, 'lienzo', 'lozan', 1000, 4, 'jose', 2, 7, '2022-04-27 04:18:35', '2022-04-27 04:18:35');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `multas`
--

CREATE TABLE `multas` (
  `id` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `observacion` varchar(50) NOT NULL,
  `valor` double NOT NULL,
  `usuarios_id` int(11) NOT NULL,
  `created` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `modfied` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pagos`
--

CREATE TABLE `pagos` (
  `id` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `valor` double NOT NULL,
  `concepto` varchar(45) NOT NULL,
  `usuarios_id` int(11) NOT NULL,
  `created` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `modified` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pagos`
--

INSERT INTO `pagos` (`id`, `fecha`, `valor`, `concepto`, `usuarios_id`, `created`, `modified`) VALUES
(1, '2022-04-13', 100000, 'mdasd', 3, '2022-04-27 22:56:12', '2022-04-27 22:56:12'),
(2, '2022-04-13', 100000, 'mejoramiento', 3, '2022-04-27 22:56:51', '2022-04-27 22:56:51');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamos`
--

CREATE TABLE `prestamos` (
  `id` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `devolucion` date NOT NULL,
  `entrega` date NOT NULL,
  `created` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `modified` timestamp NULL DEFAULT NULL,
  `usuarios_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `prestamos`
--

INSERT INTO `prestamos` (`id`, `fecha`, `devolucion`, `entrega`, `created`, `modified`, `usuarios_id`) VALUES
(1, '2022-04-13', '2022-06-13', '2022-09-13', '2022-04-27 23:23:51', '2022-04-27 23:23:51', 6),
(2, '2022-04-13', '2022-05-12', '2022-09-13', '2022-04-27 23:11:04', '2022-04-27 23:11:04', 2),
(3, '2022-04-13', '2022-06-13', '2022-09-13', '2022-04-27 23:20:09', '2022-04-27 23:20:09', 3),
(5, '2022-04-13', '2022-06-13', '2022-09-13', '2022-04-27 23:20:25', '2022-04-27 23:20:25', 5),
(6, '2022-04-13', '2022-06-13', '2022-09-13', '2022-04-27 23:21:15', '2022-04-27 23:21:15', 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `documento` varchar(20) NOT NULL,
  `nombres` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `correo` varchar(60) NOT NULL,
  `created` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `modified` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `documento`, `nombres`, `apellidos`, `direccion`, `telefono`, `correo`, `created`, `modified`) VALUES
(2, '2', 'Justine', 'Rowland', 'Ap #698-2919 Diam Road', '(+57)367 5685428', 'sit.amet.ultricies@hotmail.org', '2023-01-02 12:42:05', '2022-05-29 03:24:31'),
(3, '3', 'Lillian', 'Wooten', '7244 Non, Rd.', '(+57)351 1819534', 'elit.aliquam@yahoo.edu', '2022-01-11 11:46:53', '2021-03-21 01:52:37'),
(5, '5', 'Elaine', 'Powell', '517-1650 Magna. Ave', '(+57)327 2212358', 'elit.curabitur.sed@yahoo.ca', '2021-12-09 01:30:29', '2021-03-22 16:12:22'),
(6, '6', 'Octavia', 'Cooley', '109-1331 Vehicula Rd.', '(+57)317 7241046', 'primis.in@aol.net', '2022-04-15 16:56:19', '2021-06-29 20:16:48'),
(7, '7', 'Garrett', 'Booker', 'Ap #850-7630 Ullamcorper Street', '(+57)366 6011456', 'lorem.sit@aol.couk', '2022-01-04 05:00:08', '2022-10-23 06:44:17'),
(8, '8', 'Dustin', 'Rodriguez', 'Ap #338-906 Magna, Rd.', '(+57)313 0516478', 'nulla.semper.tellus@yahoo.com', '2021-08-10 05:07:55', '2021-05-19 23:40:15'),
(9, '9', 'Caldwell', 'Horne', '3105 Tellus Rd.', '(+57)375 1383314', 'morbi@hotmail.net', '2021-03-03 06:08:43', '2021-02-10 22:27:40'),
(10, '10', 'Amery', 'oooo', 'Ap #934-9861 Dolor Rd.', '(+57)305 0226344', 'id.enim@aol.net', '2022-04-06 00:37:30', '2022-04-06 00:37:30'),
(11, '11', 'Kamal', 'Ayers', '257-1388 Fringilla St.', '(+57)312 2166817', 'et.netus.et@outlook.org', '2021-10-16 10:34:41', '2023-01-23 22:11:17'),
(12, '12', 'Chiquita', 'Kennedy', '8777 Venenatis St.', '(+57)313 1249724', 'vel.pede@icloud.org', '2021-02-15 20:03:16', '2021-09-26 15:05:39'),
(13, '13', 'Nolan', 'Middleton', '3469 Vitae St.', '(+57)377 2437579', 'blandit.at@hotmail.net', '2021-06-28 11:04:16', '2022-12-26 03:41:31'),
(14, '14', 'Yuli', 'Daugherty', 'Ap #458-2733 Cum Av.', '(+57)321 5113268', 'bibendum.fermentum@google.ca', '2022-03-07 02:40:59', '2022-12-14 12:06:39'),
(15, '15', 'April', 'Waters', '952-5233 Lacus Avenue', '(+57)388 1345446', 'nec.urna@aol.ca', '2021-11-30 05:45:32', '2021-12-10 01:35:21'),
(16, '16', 'Demetria', 'Rosario', 'P.O. Box 358, 273 Nulla. St.', '(+57)304 3376586', 'rutrum.justo@outlook.couk', '2022-06-02 17:09:53', '2021-10-14 06:59:14'),
(17, '17', 'Zeus', 'Jensen', '8426 Interdum Ave', '(+57)315 1514501', 'lorem@protonmail.ca', '2022-01-22 23:31:57', '2021-09-11 07:17:05'),
(18, '18', 'Geraldine', 'Moreno', '1874 Tincidunt Av.', '(+57)311 9817346', 'malesuada.fames.ac@outlook.ca', '2022-06-27 20:27:31', '2022-03-31 21:56:21'),
(19, '19', 'Castor', 'Fuller', 'P.O. Box 151, 7967 Ullamcorper, Av.', '(+57)394 6051197', 'fringilla@outlook.net', '2021-11-10 02:01:40', '2022-08-13 00:55:33'),
(20, '20', 'Neve', 'Watts', 'P.O. Box 505, 5732 Cras Rd.', '(+57)364 6825638', 'pharetra.ut@protonmail.edu', '2022-02-25 10:25:22', '2021-07-29 13:42:39'),
(21, '21', 'Montana', 'Park', '803-3232 Nec St.', '(+57)356 4591333', 'mauris@icloud.net', '2022-12-13 13:41:42', '2022-04-08 14:19:49'),
(22, '22', 'Nissim', 'Martin', '690-103 Luctus. St.', '(+57)381 5033854', 'neque@google.ca', '2022-03-13 06:52:59', '2021-11-21 05:47:03'),
(23, '23', 'Desirae', 'Schultz', '709-7453 Et Rd.', '(+57)399 3949448', 'sit.amet.risus@icloud.net', '2021-12-20 13:40:13', '2022-06-17 11:07:30'),
(24, '24', 'Reuben', 'William', '345-8682 Tincidunt St.', '(+57)340 8148188', 'aenean.eget@aol.edu', '2021-12-02 23:13:43', '2021-12-17 02:37:14'),
(25, '25', 'Megan', 'Knapp', 'Ap #229-3838 Sit Rd.', '(+57)365 0736877', 'dui@protonmail.net', '2022-08-15 19:54:16', '2021-05-04 12:39:28'),
(26, '26', 'Trevor', 'Sharp', '1513 Velit Avenue', '(+57)334 4654215', 'augue.malesuada.malesuada@yahoo.com', '2021-12-02 20:15:57', '2022-02-20 08:43:09'),
(27, '27', 'McKenzie', 'Dickson', 'Ap #746-4302 Enim Street', '(+57)338 1178452', 'sit.amet@hotmail.net', '2022-02-24 15:05:53', '2022-02-16 09:35:39'),
(28, '28', 'Kerry', 'Cruz', 'P.O. Box 692, 9265 Sagittis Street', '(+57)306 0313627', 'tincidunt.vehicula.risus@hotmail.edu', '2021-08-29 00:19:34', '2021-08-09 19:31:17'),
(29, '29', 'Lysandra', 'Blackwell', 'P.O. Box 175, 6095 Et St.', '(+57)314 3977537', 'nec.urna@yahoo.net', '2021-06-14 23:11:01', '2021-10-08 12:51:53'),
(30, '30', 'Tara', 'Juarez', '936-2912 Ad St.', '(+57)373 6364836', 'aliquet.sem.ut@yahoo.couk', '2021-05-10 21:37:15', '2021-08-06 20:20:54'),
(31, '31', 'Bradley', 'Callahan', '482-6152 Fusce Rd.', '(+57)332 8341719', 'vehicula.aliquet@aol.couk', '2021-12-11 22:16:21', '2022-11-23 18:11:02'),
(32, '32', 'Zachery', 'Bolton', 'P.O. Box 142, 9983 Iaculis Ave', '(+57)328 1375166', 'phasellus.libero.mauris@icloud.org', '2022-11-06 23:01:09', '2021-12-09 03:50:26'),
(33, '33', 'Ishmael', 'Davenport', 'Ap #595-3723 At St.', '(+57)316 4441447', 'dolor@icloud.ca', '2023-01-20 17:07:22', '2022-10-29 22:01:28'),
(34, '34', 'Jeremy', 'Freeman', '469-3665 Quis Rd.', '(+57)311 9322646', 'malesuada@aol.com', '2022-02-07 10:31:06', '2021-10-23 05:45:00'),
(35, '35', 'Cooper', 'Dickson', '997-8382 Hendrerit Avenue', '(+57)342 8707406', 'augue.id@aol.com', '2021-07-14 23:44:39', '2022-04-19 19:34:40'),
(36, '36', 'Clark', 'Beck', '728-4531 Non, Street', '(+57)361 8031327', 'suspendisse@yahoo.com', '2022-02-14 11:51:35', '2021-04-09 10:00:31'),
(37, '37', 'Hyacinth', 'Frederick', '5161 Elit. Street', '(+57)323 5749115', 'sed.eget@yahoo.ca', '2021-09-24 01:28:45', '2021-10-17 10:30:08'),
(38, '38', 'Genevieve', 'Gay', 'P.O. Box 919, 1910 Cum St.', '(+57)344 2019788', 'mauris.blandit@icloud.org', '2021-06-11 17:52:22', '2021-06-11 08:05:53'),
(39, '39', 'Brendan', 'Delacruz', '7875 Donec St.', '(+57)372 0699596', 'mauris.non@aol.net', '2021-12-21 21:13:09', '2022-12-08 03:41:47'),
(40, '40', 'Merritt', 'Lewis', 'Ap #179-918 Dignissim St.', '(+57)307 5663127', 'augue.ac@google.ca', '2022-10-27 22:31:30', '2021-11-23 04:05:49'),
(41, '41', 'Yen', 'Hernandez', '329-7761 Nec, St.', '(+57)386 4636427', 'sem@google.couk', '2023-01-19 13:57:13', '2022-11-10 20:40:24'),
(42, '42', 'Jacob', 'Baird', '7872 Vel Av.', '(+57)314 8570769', 'tellus.sem@icloud.org', '2022-11-23 03:58:05', '2021-11-26 12:12:03'),
(43, '43', 'Curran', 'Salas', 'Ap #347-6801 Tempus, Road', '(+57)346 6141571', 'aenean.gravida@icloud.edu', '2022-03-11 08:01:36', '2022-03-31 02:17:36'),
(44, '44', 'Maggie', 'Mcdonald', '864-410 Neque Rd.', '(+57)305 4499276', 'est.mauris.rhoncus@google.couk', '2022-04-06 17:05:18', '2022-10-02 20:34:43'),
(45, '45', 'Cedric', 'Mueller', 'P.O. Box 260, 9878 Nonummy. Rd.', '(+57)324 9061797', 'quis.massa@google.net', '2021-02-14 10:15:09', '2022-05-27 06:05:12'),
(46, '46', 'Giacomo', 'Chen', '388-2802 Curabitur Road', '(+57)328 3824487', 'nunc@yahoo.net', '2022-11-30 10:09:57', '2022-03-16 20:59:01'),
(47, '47', 'Nadine', 'Buchanan', 'Ap #530-1668 Id Street', '(+57)365 4333885', 'ac.tellus@aol.couk', '2022-10-21 09:30:57', '2021-10-29 07:50:29'),
(48, '48', 'Logan', 'Shaw', 'P.O. Box 491, 6115 Consequat, Rd.', '(+57)329 8328342', 'arcu@hotmail.edu', '2021-06-24 09:38:33', '2021-02-10 23:17:43'),
(49, '49', 'Aurelia', 'Ashley', 'P.O. Box 749, 6909 Amet St.', '(+57)389 6401643', 'netus.et@aol.ca', '2022-11-14 03:09:53', '2021-02-18 11:18:26'),
(50, '50', 'Gail', 'Carpenter', '152-5439 Dis Road', '(+57)385 7444230', 'nunc@google.net', '2023-02-08 02:32:52', '2022-07-29 01:36:41'),
(51, '51', 'Cody', 'Graves', 'Ap #629-4428 Placerat, Rd.', '(+57)347 8547448', 'aliquam.ornare.libero@outlook.org', '2022-04-02 14:27:33', '2022-06-09 12:33:20'),
(52, '52', 'Charles', 'Huffman', 'Ap #408-542 Metus Street', '(+57)341 8821664', 'ipsum@icloud.net', '2023-01-13 22:53:52', '2021-10-02 00:18:40'),
(53, '53', 'Brett', 'Bowen', '103-460 Arcu Rd.', '(+57)306 8372464', 'in.dolor@yahoo.com', '2021-11-06 17:52:59', '2021-11-04 01:40:25'),
(54, '54', 'Desirae', 'Clements', '824-4077 Id, Rd.', '(+57)363 4348772', 'pellentesque.habitant.morbi@yahoo.org', '2021-06-23 02:41:39', '2022-05-13 06:44:43'),
(55, '55', 'Theodore', 'Schneider', 'Ap #396-3976 Sapien Street', '(+57)313 0584612', 'urna.et@outlook.couk', '2021-05-26 22:39:04', '2021-02-09 12:39:01'),
(56, '56', 'Debra', 'Tillman', 'Ap #839-798 Parturient Street', '(+57)360 5800427', 'at.sem@hotmail.ca', '2021-12-30 17:54:44', '2022-03-07 20:41:09'),
(57, '57', 'Bert', 'Gordon', '5210 Sed St.', '(+57)387 6525923', 'cras.dolor.dolor@hotmail.com', '2022-04-26 11:21:48', '2022-12-30 08:15:48'),
(58, '58', 'Anne', 'Dillard', '394-5751 Lacus. Avenue', '(+57)327 9108079', 'sed@hotmail.com', '2022-10-08 12:57:04', '2022-02-17 01:09:31'),
(59, '59', 'Brady', 'Rose', '4392 At St.', '(+57)366 1735257', 'id.sapien@hotmail.couk', '2022-08-22 18:37:48', '2021-03-13 18:31:15'),
(60, '60', 'Hoyt', 'Mcdaniel', 'P.O. Box 559, 4732 Augue Av.', '(+57)336 6513295', 'urna.suscipit.nonummy@icloud.couk', '2022-08-09 13:46:21', '2022-01-07 18:48:49'),
(61, '61', 'Chaney', 'Sanchez', '546 Convallis Avenue', '(+57)388 4365946', 'nibh.aliquam.ornare@aol.net', '2021-07-01 16:27:50', '2022-07-12 21:11:24'),
(62, '62', 'Acton', 'Mills', '758-5223 Gravida St.', '(+57)352 8177343', 'aliquet.metus.urna@aol.net', '2022-12-21 16:02:43', '2022-11-18 02:27:02'),
(63, '63', 'Kieran', 'House', '947-3536 Neque St.', '(+57)308 0872163', 'mauris.eu@yahoo.edu', '2022-02-23 18:24:29', '2021-11-15 15:15:53'),
(64, '64', 'Keaton', 'Patel', '147-3940 Pretium Av.', '(+57)337 6970676', 'feugiat.nec.diam@outlook.org', '2021-08-04 07:58:03', '2022-11-23 13:26:45'),
(65, '65', 'Shaine', 'Meyer', '165-2089 Magna. St.', '(+57)352 6777609', 'aliquam.fringilla.cursus@google.com', '2021-02-22 19:23:19', '2021-05-04 14:58:09'),
(66, '66', 'Willa', 'Carney', '7294 Mauris Av.', '(+57)340 3298856', 'mattis.semper.dui@hotmail.ca', '2022-03-02 03:18:52', '2022-09-16 05:37:35'),
(67, '67', 'Denton', 'Warner', '161-4936 Ac St.', '(+57)314 4247525', 'netus.et@yahoo.org', '2022-02-15 06:17:39', '2021-07-21 06:52:41'),
(68, '68', 'Nell', 'Woods', '911-4613 Blandit St.', '(+57)339 1510244', 'enim@aol.ca', '2022-12-07 04:31:28', '2023-01-19 13:06:01'),
(69, '69', 'Orli', 'Franks', '574-3972 Velit. Road', '(+57)389 9410118', 'posuere.at@icloud.couk', '2021-07-08 08:42:34', '2022-07-15 11:26:56'),
(70, '70', 'Quinn', 'Henderson', '635-2618 Lacinia Avenue', '(+57)337 9040432', 'parturient.montes@hotmail.couk', '2021-03-03 17:37:17', '2021-12-29 18:02:52'),
(71, '71', 'Hall', 'Emerson', '3033 Orci Ave', '(+57)358 0601627', 'lacus@protonmail.edu', '2022-12-13 06:23:19', '2021-04-15 02:59:27'),
(72, '72', 'Stephen', 'Baird', '956-2555 Eu Rd.', '(+57)326 7728664', 'vulputate.dui@yahoo.ca', '2021-05-11 22:22:56', '2021-02-15 03:14:52'),
(73, '73', 'Imelda', 'Carver', 'Ap #588-8233 Non Ave', '(+57)363 6850782', 'vitae.purus@aol.couk', '2022-12-30 20:32:59', '2021-10-04 06:26:19'),
(74, '74', 'Christine', 'Delacruz', 'P.O. Box 206, 6169 Tempor Avenue', '(+57)328 3312588', 'erat.vitae@google.org', '2022-09-14 06:53:09', '2022-07-30 10:52:15'),
(75, '75', 'Cameran', 'Nicholson', 'P.O. Box 807, 7574 Interdum Avenue', '(+57)353 5171236', 'neque@aol.com', '2023-01-12 04:18:50', '2021-04-10 03:43:29'),
(76, '76', 'Mohammad', 'Wade', 'Ap #113-5861 Elit St.', '(+57)351 5134244', 'at.pede.cras@outlook.net', '2021-08-09 08:45:59', '2022-02-26 09:17:58'),
(77, '77', 'Kelly', 'Hahn', 'Ap #905-4905 Proin Street', '(+57)321 1333694', 'sem.eget.massa@protonmail.ca', '2022-03-25 15:49:22', '2021-05-12 20:42:23'),
(78, '78', 'Vera', 'Freeman', '607-7697 Enim Avenue', '(+57)351 7571626', 'velit.quisque@hotmail.net', '2022-03-03 06:42:40', '2022-02-16 23:23:21'),
(79, '79', 'Emerald', 'Hines', '8099 Dolor. Av.', '(+57)332 7163315', 'a.nunc@protonmail.net', '2021-07-31 07:06:04', '2022-03-14 14:29:27'),
(80, '80', 'Margaret', 'Avery', 'Ap #278-6831 Vestibulum Ave', '(+57)396 2614012', 'laoreet.lectus@icloud.edu', '2021-06-23 01:02:48', '2021-12-10 01:24:43'),
(81, '81', 'Micah', 'Rhodes', '9855 Dictum St.', '(+57)361 1157555', 'dictum.placerat@yahoo.org', '2021-06-09 09:51:20', '2022-02-12 07:15:47'),
(82, '82', 'Samson', 'Whitley', '794-9822 Duis Rd.', '(+57)329 2464884', 'nulla@hotmail.org', '2021-05-15 18:25:38', '2023-01-25 08:50:49'),
(83, '83', 'Emerald', 'Olsen', '5941 Ante Ave', '(+57)353 7840235', 'phasellus.libero.mauris@protonmail.net', '2022-06-26 22:22:56', '2022-10-11 03:50:11'),
(84, '84', 'Lael', 'Chandler', '863-8553 Consequat St.', '(+57)307 8343952', 'purus.sapien@yahoo.org', '2022-11-05 11:22:07', '2022-04-01 07:59:15'),
(85, '85', 'Hamish', 'Benjamin', '3962 Mauris Av.', '(+57)348 7114668', 'ut.pharetra@yahoo.org', '2022-02-15 16:50:22', '2023-01-14 22:21:19'),
(86, '86', 'Armand', 'Alvarez', '832-3471 Suspendisse St.', '(+57)372 1760675', 'luctus.aliquet.odio@outlook.edu', '2021-08-08 20:19:17', '2021-10-03 21:51:57'),
(87, '87', 'Zephania', 'Terrell', '2508 Phasellus St.', '(+57)314 9884598', 'fusce.diam@aol.com', '2022-02-09 20:25:19', '2021-06-08 02:35:02'),
(88, '88', 'Irma', 'Butler', '173-9466 Eros Avenue', '(+57)335 7451431', 'eu.nibh@aol.ca', '2021-07-01 03:00:51', '2022-06-09 18:03:28'),
(89, '89', 'Mallory', 'Bond', '865-3703 Donec Rd.', '(+57)355 3368793', 'morbi.vehicula.pellentesque@yahoo.couk', '2022-02-16 13:51:20', '2021-09-12 05:32:14'),
(90, '90', 'Bree', 'Bird', 'Ap #416-373 Tortor Ave', '(+57)324 8524354', 'aenean.euismod.mauris@outlook.edu', '2022-11-19 09:08:56', '2021-10-20 22:38:57'),
(91, '91', 'Lillith', 'Mcleod', '540 Pellentesque Rd.', '(+57)342 3571121', 'lobortis.risus@icloud.com', '2021-04-10 08:03:25', '2022-11-18 00:26:25'),
(92, '92', 'Shad', 'Gibson', 'P.O. Box 918, 2180 Orci Street', '(+57)361 2318146', 'lacus.ut@icloud.edu', '2021-04-09 21:14:17', '2022-11-10 15:58:33'),
(93, '93', 'Zeph', 'Walls', '209-8923 Erat Avenue', '(+57)327 1671337', 'facilisis.lorem.tristique@yahoo.edu', '2021-07-19 06:32:23', '2023-01-22 03:21:32'),
(94, '94', 'Mannix', 'Fuentes', 'Ap #196-6251 Aliquam Av.', '(+57)346 2423383', 'sagittis.nullam.vitae@yahoo.org', '2021-11-05 16:00:40', '2021-12-09 03:36:36'),
(95, '95', 'Cain', 'Larsen', 'Ap #116-8188 Velit Road', '(+57)372 1410381', 'ultricies.adipiscing.enim@yahoo.net', '2021-07-10 15:03:36', '2021-03-03 05:31:29'),
(96, '96', 'Shelly', 'Andrews', '188-7701 Vel, Rd.', '(+57)386 1821576', 'lectus@icloud.ca', '2021-07-25 09:41:40', '2022-12-18 15:12:53'),
(97, '97', 'Gil', 'Valenzuela', 'Ap #312-1274 Cum Rd.', '(+57)328 1333762', 'nunc.risus@protonmail.couk', '2022-01-20 14:06:09', '2022-05-06 10:00:38'),
(98, '98', 'Ebony', 'Romero', 'Ap #572-332 Ac, St.', '(+57)378 6213284', 'ipsum.leo@hotmail.ca', '2021-10-14 20:17:22', '2021-04-20 19:18:49'),
(99, '99', 'Mannix', 'Burt', 'P.O. Box 591, 3858 Quisque St.', '(+57)355 8488228', 'eros.non@icloud.net', '2022-07-27 11:27:28', '2021-02-22 08:17:45'),
(100, '100', 'Joel', 'Villarreal', '5561 Dictum St.', '(+57)338 3509117', 'vel.turpis@icloud.org', '2021-12-06 13:51:17', '2023-02-05 13:48:50'),
(101, '1011', 'Amery', 'oooo', 'Ap #934-9861 Dolor Rd.', '(+57)305 0226344', 'id.enim@aol.net', '2022-04-06 00:40:46', '2022-04-06 00:40:46');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `detalles`
--
ALTER TABLE `detalles`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `fk_detalles_libros1_idx` (`libros_id`),
  ADD KEY `fk_detalles_prestamos1_idx` (`prestamos_id`);

--
-- Indices de la tabla `editoriales`
--
ALTER TABLE `editoriales`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `libros`
--
ALTER TABLE `libros`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_libros_editoriales_idx` (`editoriales_id`),
  ADD KEY `fk_libros_categorias1_idx` (`categorias_id`);

--
-- Indices de la tabla `multas`
--
ALTER TABLE `multas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_multas_usuarios1_idx` (`usuarios_id`);

--
-- Indices de la tabla `pagos`
--
ALTER TABLE `pagos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_pagos_usuarios1_idx` (`usuarios_id`);

--
-- Indices de la tabla `prestamos`
--
ALTER TABLE `prestamos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_prestamos_usuarios1_idx` (`usuarios_id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `documento_UNIQUE` (`documento`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categorias`
--
ALTER TABLE `categorias`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `detalles`
--
ALTER TABLE `detalles`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `editoriales`
--
ALTER TABLE `editoriales`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `libros`
--
ALTER TABLE `libros`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `multas`
--
ALTER TABLE `multas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pagos`
--
ALTER TABLE `pagos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `prestamos`
--
ALTER TABLE `prestamos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=102;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalles`
--
ALTER TABLE `detalles`
  ADD CONSTRAINT `fk_detalles_libros1` FOREIGN KEY (`libros_id`) REFERENCES `libros` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_detalles_prestamos1` FOREIGN KEY (`prestamos_id`) REFERENCES `prestamos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `libros`
--
ALTER TABLE `libros`
  ADD CONSTRAINT `fk_libros_categorias1` FOREIGN KEY (`categorias_id`) REFERENCES `categorias` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_libros_editoriales` FOREIGN KEY (`editoriales_id`) REFERENCES `editoriales` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `multas`
--
ALTER TABLE `multas`
  ADD CONSTRAINT `fk_multas_usuarios1` FOREIGN KEY (`usuarios_id`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `pagos`
--
ALTER TABLE `pagos`
  ADD CONSTRAINT `fk_pagos_usuarios1` FOREIGN KEY (`usuarios_id`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `prestamos`
--
ALTER TABLE `prestamos`
  ADD CONSTRAINT `fk_prestamos_usuarios1` FOREIGN KEY (`usuarios_id`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
