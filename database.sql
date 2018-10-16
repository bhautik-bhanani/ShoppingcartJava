-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Sep 13, 2018 at 02:03 PM
-- Server version: 5.7.21
-- PHP Version: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java`
--

-- --------------------------------------------------------

--
-- Table structure for table `jdbc_product`
--

DROP TABLE IF EXISTS `jdbc_product`;
CREATE TABLE IF NOT EXISTS `jdbc_product` (
  `productId` int(11) NOT NULL AUTO_INCREMENT,
  `productName` varchar(100) NOT NULL,
  `productDesc` text NOT NULL,
  `productImg` varchar(100) NOT NULL,
  `productPrice` double NOT NULL,
  `typeId` int(11) NOT NULL,
  PRIMARY KEY (`productId`)
) ENGINE=MyISAM AUTO_INCREMENT=1235 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jdbc_product`
--

INSERT INTO `jdbc_product` (`productId`, `productName`, `productDesc`, `productImg`, `productPrice`, `typeId`) VALUES
(1230, 'Samsung 9+', 'product 1 description!!!', 'p1.jpg', 700, 100),
(1231, 'iPhone X', 'product 2 description!!!', 'p2.jpg', 999, 100),
(1232, 'Sony XZ2', 'product 3 description!!!', 'p3.jpg', 999, 100),
(1233, 'Dell XPS 15', 'product 4 description!!!', 'p4.jpg', 1500, 101),
(1234, 'Asus', 'product 5 description!!!', 'p5.jpg', 1900, 101);

-- --------------------------------------------------------

--
-- Table structure for table `jdbc_type`
--

DROP TABLE IF EXISTS `jdbc_type`;
CREATE TABLE IF NOT EXISTS `jdbc_type` (
  `typeId` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(50) NOT NULL,
  PRIMARY KEY (`typeId`)
) ENGINE=MyISAM AUTO_INCREMENT=102 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jdbc_type`
--

INSERT INTO `jdbc_type` (`typeId`, `typeName`) VALUES
(100, 'Cell Phone'),
(101, 'Laptop');

-- --------------------------------------------------------

--
-- Table structure for table `jdbc_user`
--

DROP TABLE IF EXISTS `jdbc_user`;
CREATE TABLE IF NOT EXISTS `jdbc_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `address` text NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jdbc_user`
--

INSERT INTO `jdbc_user` (`userId`, `name`, `email`, `password`, `address`) VALUES
(1, 'admin', 'admin@gmail.com', '12345', 'New Jersey, USA');

-- --------------------------------------------------------

--
-- Table structure for table `jdbc_wishlist`
--

DROP TABLE IF EXISTS `jdbc_wishlist`;
CREATE TABLE IF NOT EXISTS `jdbc_wishlist` (
  `wishlistId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `productId` int(11) NOT NULL,
  PRIMARY KEY (`wishlistId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE IF NOT EXISTS `user_role` (
  `email` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`email`, `role`) VALUES
('admin@gmail.com', 'ROLE_USER'),
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
