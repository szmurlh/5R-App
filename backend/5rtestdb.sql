-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 18, 2020 at 06:01 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `5rtestdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `locations`
--

CREATE TABLE `locations` (
  `locID` int(11) NOT NULL,
  `RET/PRI/PUB` char(7) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `State` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `City` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Area` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `zip` int(5) DEFAULT NULL,
  `residency` tinyint(1) DEFAULT NULL,
  `notes` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `website` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `locations`
--

INSERT INTO `locations` (`locID`, `RET/PRI/PUB`, `name`, `State`, `City`, `Area`, `zip`, `residency`, `notes`, `phone`, `website`) VALUES
(1, 'Public', 'Oneida-Herkimer Solid Waste Authority: Recycling Center', 'NY', 'Utica', '', 13502, 0, '', '(315) 733-1224', 'https://www.ohswa.org/'),
(2, 'Private', 'Westmo City Private Recycling Bin', 'NY', 'Westmoreland', '', 13490, 1, 'Note: Not a real bin, just for demo.', 'N/A', 'N/A'),
(3, 'Private', 'The Useless Recycle Center', 'NY', 'Rome', '', 13440, 0, 'I don\'t recycle anything.', 'N/A', 'N/A'),
(4, 'Private', 'Port Jervis Private Bin', 'NY', 'Port Jervis', '', 12771, 1, '', 'N/A', 'N/A'),
(5, 'Retail', 'Walmart - New Hartford', 'NY', 'New Hartford', '', 13413, 0, '', '(315) 736-4932', 'https://www.walmart.com/store/1677-new-hartford-ny');

-- --------------------------------------------------------

--
-- Table structure for table `productmatch`
--

CREATE TABLE `productmatch` (
  `locID` int(11) NOT NULL,
  `prodID` int(11) NOT NULL,
  `accepted` tinyint(1) NOT NULL,
  `pkey` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `productmatch`
--

INSERT INTO `productmatch` (`locID`, `prodID`, `accepted`, `pkey`) VALUES
(1, 1, 1, 1),
(2, 1, 1, 2),
(3, 1, 0, 3),
(1, 2, 1, 4),
(2, 2, 1, 5),
(3, 2, 0, 6),
(4, 1, 1, 7),
(4, 2, 1, 8),
(1, 3, 1, 9),
(1, 4, 1, 10),
(5, 4, 1, 11);

-- --------------------------------------------------------

--
-- Table structure for table `producttable`
--

CREATE TABLE `producttable` (
  `ID` int(11) NOT NULL,
  `mainCode` char(1) COLLATE utf8mb4_unicode_ci NOT NULL,
  `subCode` char(2) COLLATE utf8mb4_unicode_ci NOT NULL,
  `productName` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `producttable`
--

INSERT INTO `producttable` (`ID`, `mainCode`, `subCode`, `productName`) VALUES
(1, 'P', 'DB', 'Water Bottle'),
(2, 'E', 'B', 'AA Battery'),
(3, 'E', 'B', 'Lithium-Ion Battery'),
(4, 'E', 'B', 'Car Battery');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `locations`
--
ALTER TABLE `locations`
  ADD PRIMARY KEY (`locID`);

--
-- Indexes for table `productmatch`
--
ALTER TABLE `productmatch`
  ADD PRIMARY KEY (`pkey`);

--
-- Indexes for table `producttable`
--
ALTER TABLE `producttable`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `productmatch`
--
ALTER TABLE `productmatch`
  MODIFY `pkey` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
