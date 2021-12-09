-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 23, 2019 at 03:30 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `c01`
--

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `empId` varchar(10) NOT NULL,
  `employeeName` varchar(30) NOT NULL,
  `designation` varchar(30) NOT NULL,
  `salary` double(9,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`empId`, `employeeName`, `designation`, `salary`) VALUES
('17-00000-2', 'Mr.X', 'Manager', 20000.00),
('17-11111-2', 'Mahin', 'Chef', 12000.00),
('17-22222-2', 'Nazim', 'Chef', 12000.00),
('17-33333-2', 'Ehsan', 'Cleaner', 12000.00),
('17-34868-2', 'Bulbul', 'Supervisor', 15000.00),
('17-35045-2', 'Sanjida', 'Token Provider', 10000.00),
('17-35179-2', 'Chironzit', 'Token Provider', 10000.00),
('17-35214-2', 'Foyaz', 'Token Provider', 10000.00),
('17-44444-2', 'Tomal', 'Chef', 12000.00),
('17-55555-2', 'Ayesha', 'Token Provider', 10000.00);

-- --------------------------------------------------------

--
-- Table structure for table `fooditem`
--

CREATE TABLE `fooditem` (
  `itemId` varchar(20) NOT NULL,
  `itemName` varchar(30) NOT NULL,
  `price` double(8,2) NOT NULL,
  `quantity` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fooditem`
--

INSERT INTO `fooditem` (`itemId`, `itemName`, `price`, `quantity`) VALUES
('b1', 'Naga Burger', 600.00, 96),
('b2', 'Beef Burger', 250.00, 100),
('b3', 'Chicken Burger', 180.00, 115),
('c1', 'Regular', 120.00, 115),
('c19', 'Hot coffee', 120.00, 50),
('c2', 'Black Coffee', 100.00, 42),
('c3', 'Cold Coffee', 150.00, 130),
('c9', 'Cold Coffe', 410.00, 25),
('d1', 'yeloow coffee', 120.00, 50),
('p1', 'Chicken Pizza', 700.00, 98),
('p2', 'Beef Pizza', 550.00, 80),
('p3', 'Shrimp Pizza', 650.00, 60),
('p4', 'Vegetable Pizza', 750.00, 43),
('s1', 'Chicken Regular Sandwice', 200.00, 100),
('s2', 'Beef Sub Sandwich', 250.00, 80);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `userId` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  `status` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`userId`, `password`, `status`) VALUES
('17-00000-2', '1238', 2),
('17-11111-2', '1230', 0),
('17-22222-2', '1231', 0),
('17-33333-2', '1232', 0),
('17-34179-2', '1237', 0),
('17-34868-2', '1234', 1),
('17-35045-2', '1235', 0),
('17-35214-2', '1236', 0),
('17-44444-2', '1233', 0),
('17-55555-2', '1223', 0);

-- --------------------------------------------------------

--
-- Table structure for table `orderinfo`
--

CREATE TABLE `orderinfo` (
  `orderId` varchar(10) NOT NULL,
  `orderSerial` int(5) NOT NULL,
  `orderPersonName` varchar(10) NOT NULL,
  `orderAmount` double(8,2) NOT NULL,
  `orderDate` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orderinfo`
--

INSERT INTO `orderinfo` (`orderId`, `orderSerial`, `orderPersonName`, `orderAmount`, `orderDate`) VALUES
('1171', 33, 'batasi', 410.00, '1-1-111'),
('1343', 8, 'hgfhg', 300.00, '11/7/19'),
('1440', 110, 'mhjjh', 1000.00, '1-1-1'),
('1731', 23, 'mahina', 300.00, '8-9-7'),
('1763', 334, 'vhhfh', 300.00, '5-2-12'),
('1888', 21, 'rasel', 300.00, '2-2-2009'),
('2226', 6, 'mehedi', 240.00, '1'),
('3191', 5, 'foyaz', 1200.00, '2016'),
('3751', 87, 'brust', 600.00, '11-5-23'),
('5012', 53, 'akash', 240.00, '2-2-2014'),
('5390', 20, 'fgfg', 120.00, '5-5-5'),
('6118', 101, 'sabita', 1500.00, '9-8-7'),
('6134', 33, 'hghgh', 615.00, '11-1-1'),
('6367', 5, 'bulbul', 600.00, '2003'),
('6390', 44, 'cvbvb', 200.00, '5-5-5'),
('6649', 97, 'mehedi', 250.00, '1-1-2018'),
('6891', 14, 'Farhad', 600.00, '4-3-2007'),
('7020', 29, 'bulbul', 410.00, '2-7-2018'),
('7032', 12, 'bishu', 300.00, '2-2-3'),
('7246', 33, 'batasi', 1160.00, '1-1-111'),
('7788', 9, 'ghgh', 100.00, '11-9-5'),
('7999', 18, 'Robi', 400.00, '1-3-2002'),
('8126', 1, 'fggfg', 600.00, '2-11-17'),
('8146', 22, 'kuddus', 600.00, '3-3-2008'),
('8283', 12, 'hakim', 900.00, '2-2-2019'),
('8673', 1000, 'fgfg', 600.00, '8-7-9'),
('8681', 992, 'ggg', 400.00, '12-12-12'),
('b43', 3, 'julekha', 456.00, '21-1-11');

-- --------------------------------------------------------

--
-- Table structure for table `purchaseinfo`
--

CREATE TABLE `purchaseinfo` (
  `productName` varchar(20) NOT NULL,
  `productQuantity` double(8,2) NOT NULL,
  `productCost` double(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchaseinfo`
--

INSERT INTO `purchaseinfo` (`productName`, `productQuantity`, `productCost`) VALUES
('Beef', 5.00, 2450.00),
('Bun', 500.00, 3000.00),
('Capsicum', 5.00, 400.00),
('Chesses', 10.00, 2000.00),
('Chicken', 10.00, 1200.00),
('Coffee Bin', 20.00, 400.00),
('Oil', 20.00, 2200.00),
('sugar', 2.50, 150.00);

-- --------------------------------------------------------

--
-- Table structure for table `reginfo`
--

CREATE TABLE `reginfo` (
  `customerName` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `address` varchar(20) NOT NULL,
  `phnNo` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reginfo`
--

INSERT INTO `reginfo` (`customerName`, `email`, `address`, `phnNo`) VALUES
('Biddut', 'biddut.kumar34@gmail.com', 'banani', '0123456789'),
('Biraj kor', 'biraj@gmail.com', 'khilkhet Nikunja 2', '0183487388'),
('chirnjit kumar roy', 'roy@gmail.com', 'kuratoli 990', '019393943994'),
('Ishfaq Xahan', 'ishfaq00@gmail.com', 'Chandpur, Sadar', '01288383833'),
('mahin', 'mahinmuntasir@gmail.com', 'Nikunja 2', '01626181444'),
('Shovo', 'square.shuvo11@gmail.com', 'Pabna', '01212145879');

-- --------------------------------------------------------

--
-- Table structure for table `salesinfo`
--

CREATE TABLE `salesinfo` (
  `slPrdctName` varchar(30) NOT NULL,
  `slQuantity` int(10) NOT NULL,
  `slAmount` double(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `salesinfo`
--

INSERT INTO `salesinfo` (`slPrdctName`, `slQuantity`, `slAmount`) VALUES
('Chicken Regular Sandwice', 2, 200.00),
('Chicken Regular Sandwice', 3, 200.00),
('Naga Burger', 2, 600.00),
('Vegetable Pizza', 3, 750.00),
('Vegetable Pizza', 4, 230.00);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`employeeName`,`designation`,`salary`),
  ADD UNIQUE KEY `UNIQUE` (`empId`);

--
-- Indexes for table `fooditem`
--
ALTER TABLE `fooditem`
  ADD PRIMARY KEY (`itemName`,`price`,`quantity`),
  ADD UNIQUE KEY `UNIQUE` (`itemId`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`password`,`status`),
  ADD UNIQUE KEY `UNIQUE` (`userId`);

--
-- Indexes for table `orderinfo`
--
ALTER TABLE `orderinfo`
  ADD PRIMARY KEY (`orderSerial`,`orderPersonName`,`orderAmount`,`orderDate`),
  ADD UNIQUE KEY `UNIQUE` (`orderId`);

--
-- Indexes for table `purchaseinfo`
--
ALTER TABLE `purchaseinfo`
  ADD PRIMARY KEY (`productName`,`productQuantity`,`productCost`);

--
-- Indexes for table `reginfo`
--
ALTER TABLE `reginfo`
  ADD PRIMARY KEY (`customerName`,`email`,`address`,`phnNo`);

--
-- Indexes for table `salesinfo`
--
ALTER TABLE `salesinfo`
  ADD PRIMARY KEY (`slPrdctName`,`slQuantity`,`slAmount`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
