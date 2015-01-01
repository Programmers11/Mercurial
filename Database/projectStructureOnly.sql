-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 30, 2014 at 07:01 PM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `project`
--
CREATE DATABASE IF NOT EXISTS `project` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `project`;

-- --------------------------------------------------------

--
-- Stand-in structure for view `allreports`
--
CREATE TABLE IF NOT EXISTS `allreports` (
`Voucher No` varchar(7)
,`Phone` varchar(11)
,`Customer` varchar(20)
,`Status` varchar(15)
,`IssueDate` date
,`deldate` datetime
,`qty` decimal(42,0)
,`Amount` int(11)
);
-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE IF NOT EXISTS `booking` (
  `rcptNo` varchar(7) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `sname` varchar(30) NOT NULL,
  `amount` int(11) NOT NULL,
  `discount` float NOT NULL,
  `netAmount` int(11) NOT NULL,
  `issueDate` date NOT NULL,
  `dueDate` date NOT NULL,
  `deldate` datetime DEFAULT NULL,
  `status` varchar(15) NOT NULL,
  `category` varchar(15) NOT NULL,
  `prevRcpt` varchar(6) DEFAULT NULL,
  `Hanger` varchar(4) NOT NULL DEFAULT '0',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `dupCount` int(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`rcptNo`),
  KEY `booking_fk_client` (`phone`),
  KEY `booking_fk_staff` (`sname`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `booking_clothes`
--

CREATE TABLE IF NOT EXISTS `booking_clothes` (
  `cid` int(11) NOT NULL,
  `rcptNo` varchar(7) NOT NULL,
  `qty` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `remarks` varchar(800) DEFAULT NULL,
  KEY `booking_fk_clothes` (`cid`),
  KEY `booking_fk_booking` (`rcptNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `phone` varchar(11) NOT NULL,
  `clientName` varchar(20) NOT NULL,
  `address` varchar(50) NOT NULL,
  `altPh` varchar(11) DEFAULT NULL,
  `discount` float NOT NULL,
  PRIMARY KEY (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Stand-in structure for view `closingreport`
--
CREATE TABLE IF NOT EXISTS `closingreport` (
`Voucher No` varchar(7)
,`deldate` datetime
,`qty` decimal(42,0)
,`Amount` int(11)
);
-- --------------------------------------------------------

--
-- Stand-in structure for view `closing_summary`
--
CREATE TABLE IF NOT EXISTS `closing_summary` (
`Date` date
,`voucher_count` bigint(21)
,`total_amt` decimal(32,0)
);
-- --------------------------------------------------------

--
-- Table structure for table `clothes`
--

CREATE TABLE IF NOT EXISTS `clothes` (
  `cid` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `price` int(11) NOT NULL,
  `countVal` int(11) NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dnp`
--

CREATE TABLE IF NOT EXISTS `dnp` (
  `phone` varchar(11) NOT NULL DEFAULT '',
  PRIMARY KEY (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Stand-in structure for view `duplicates`
--
CREATE TABLE IF NOT EXISTS `duplicates` (
`Voucher No` varchar(7)
,`Phone` varchar(11)
,`Customer` varchar(20)
,`Status` varchar(15)
,`IssueDate` date
,`deldate` datetime
,`qty` decimal(42,0)
,`Amount` int(11)
);
-- --------------------------------------------------------

--
-- Table structure for table `mode`
--

CREATE TABLE IF NOT EXISTS `mode` (
  `mName` varchar(11) NOT NULL,
  `mulFactor` float NOT NULL,
  `discount` tinyint(1) NOT NULL,
  `processTime` int(11) NOT NULL,
  PRIMARY KEY (`mName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `new_able`
--

CREATE TABLE IF NOT EXISTS `new_able` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Stand-in structure for view `normal`
--
CREATE TABLE IF NOT EXISTS `normal` (
`rcptno` varchar(7)
,`phone` varchar(11)
,`clientName` varchar(20)
,`issuedate` date
,`duedate` date
,`Status` varchar(15)
);
-- --------------------------------------------------------

--
-- Stand-in structure for view `press`
--
CREATE TABLE IF NOT EXISTS `press` (
`rcptno` varchar(7)
,`phone` varchar(11)
,`clientName` varchar(20)
,`issuedate` date
,`duedate` date
,`Status` varchar(15)
);
-- --------------------------------------------------------

--
-- Stand-in structure for view `special`
--
CREATE TABLE IF NOT EXISTS `special` (
`rcptno` varchar(7)
,`phone` varchar(11)
,`clientName` varchar(20)
,`issuedate` date
,`duedate` date
,`Status` varchar(15)
);
-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE IF NOT EXISTS `staff` (
  `sname` varchar(30) NOT NULL,
  `pass` varchar(32) NOT NULL,
  `type` int(11) NOT NULL,
  `priv` varchar(3) NOT NULL,
  `no_of_bookings` int(11) NOT NULL,
  PRIMARY KEY (`sname`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Stand-in structure for view `surgent`
--
CREATE TABLE IF NOT EXISTS `surgent` (
`rcptno` varchar(7)
,`phone` varchar(11)
,`clientName` varchar(20)
,`issuedate` date
,`duedate` date
,`Status` varchar(15)
);
-- --------------------------------------------------------

--
-- Stand-in structure for view `urgent`
--
CREATE TABLE IF NOT EXISTS `urgent` (
`rcptno` varchar(7)
,`phone` varchar(11)
,`clientName` varchar(20)
,`issuedate` date
,`duedate` date
,`Status` varchar(15)
);
-- --------------------------------------------------------

--
-- Structure for view `allreports`
--
DROP TABLE IF EXISTS `allreports`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `allreports` AS select `b`.`rcptNo` AS `Voucher No`,`b`.`phone` AS `Phone`,`c`.`clientName` AS `Customer`,`b`.`status` AS `Status`,`b`.`issueDate` AS `IssueDate`,`b`.`deldate` AS `deldate`,sum((`info`.`qty` * (select `cl`.`countVal` from `clothes` `cl` where (`cl`.`cid` = `info`.`cid`)))) AS `qty`,`b`.`netAmount` AS `Amount` from ((`booking` `b` join `booking_clothes` `info`) join `client` `c`) where ((`info`.`rcptNo` = `b`.`rcptNo`) and (`b`.`phone` = `c`.`phone`)) group by `b`.`rcptNo`;

-- --------------------------------------------------------

--
-- Structure for view `closingreport`
--
DROP TABLE IF EXISTS `closingreport`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `closingreport` AS select `b`.`rcptNo` AS `Voucher No`,`b`.`deldate` AS `deldate`,sum((`info`.`qty` * (select `cl`.`countVal` from `clothes` `cl` where (`cl`.`cid` = `info`.`cid`)))) AS `qty`,`b`.`netAmount` AS `Amount` from (`booking` `b` join `booking_clothes` `info`) where ((`info`.`rcptNo` = `b`.`rcptNo`) and (`b`.`status` = 'Delivered')) group by `b`.`rcptNo`;

-- --------------------------------------------------------

--
-- Structure for view `closing_summary`
--
DROP TABLE IF EXISTS `closing_summary`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `closing_summary` AS (select cast(`closingreport`.`deldate` as date) AS `Date`,count(0) AS `voucher_count`,sum(`closingreport`.`Amount`) AS `total_amt` from `closingreport` group by cast(`closingreport`.`deldate` as date));

-- --------------------------------------------------------

--
-- Structure for view `duplicates`
--
DROP TABLE IF EXISTS `duplicates`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `duplicates` AS select `b`.`rcptNo` AS `Voucher No`,`b`.`phone` AS `Phone`,`c`.`clientName` AS `Customer`,`b`.`status` AS `Status`,`b`.`issueDate` AS `IssueDate`,`b`.`deldate` AS `deldate`,sum((`info`.`qty` * (select `cl`.`countVal` from `clothes` `cl` where (`cl`.`cid` = `info`.`cid`)))) AS `qty`,`b`.`netAmount` AS `Amount` from ((`booking` `b` join `booking_clothes` `info`) join `client` `c`) where ((`b`.`dupCount` > 0) and (`info`.`rcptNo` = `b`.`rcptNo`) and (`b`.`phone` = `c`.`phone`)) group by `b`.`rcptNo`;

-- --------------------------------------------------------

--
-- Structure for view `normal`
--
DROP TABLE IF EXISTS `normal`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `normal` AS (select `b`.`rcptNo` AS `rcptno`,`c`.`phone` AS `phone`,`c`.`clientName` AS `clientName`,`b`.`issueDate` AS `issuedate`,`b`.`dueDate` AS `duedate`,`b`.`status` AS `Status` from (`booking` `b` join `client` `c`) where ((`c`.`phone` = `b`.`phone`) and (`b`.`category` = 'Normal')));

-- --------------------------------------------------------

--
-- Structure for view `press`
--
DROP TABLE IF EXISTS `press`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `press` AS (select `b`.`rcptNo` AS `rcptno`,`c`.`phone` AS `phone`,`c`.`clientName` AS `clientName`,`b`.`issueDate` AS `issuedate`,`b`.`dueDate` AS `duedate`,`b`.`status` AS `Status` from (`booking` `b` join `client` `c`) where ((`c`.`phone` = `b`.`phone`) and (`b`.`category` = 'Press')));

-- --------------------------------------------------------

--
-- Structure for view `special`
--
DROP TABLE IF EXISTS `special`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `special` AS (select `b`.`rcptNo` AS `rcptno`,`c`.`phone` AS `phone`,`c`.`clientName` AS `clientName`,`b`.`issueDate` AS `issuedate`,`b`.`dueDate` AS `duedate`,`b`.`status` AS `Status` from (`booking` `b` join `client` `c`) where ((`c`.`phone` = `b`.`phone`) and (`b`.`category` = 'Special')));

-- --------------------------------------------------------

--
-- Structure for view `surgent`
--
DROP TABLE IF EXISTS `surgent`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `surgent` AS (select `b`.`rcptNo` AS `rcptno`,`c`.`phone` AS `phone`,`c`.`clientName` AS `clientName`,`b`.`issueDate` AS `issuedate`,`b`.`dueDate` AS `duedate`,`b`.`status` AS `Status` from (`booking` `b` join `client` `c`) where ((`c`.`phone` = `b`.`phone`) and (`b`.`category` = 'SemiUrgent')));

-- --------------------------------------------------------

--
-- Structure for view `urgent`
--
DROP TABLE IF EXISTS `urgent`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `urgent` AS (select `b`.`rcptNo` AS `rcptno`,`c`.`phone` AS `phone`,`c`.`clientName` AS `clientName`,`b`.`issueDate` AS `issuedate`,`b`.`dueDate` AS `duedate`,`b`.`status` AS `Status` from (`booking` `b` join `client` `c`) where ((`c`.`phone` = `b`.`phone`) and (`b`.`category` = 'Urgent')));

--
-- Constraints for dumped tables
--

--
-- Constraints for table `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `booking_fk_client` FOREIGN KEY (`phone`) REFERENCES `client` (`phone`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `booking_fk_staff` FOREIGN KEY (`sname`) REFERENCES `staff` (`sname`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `booking_clothes`
--
ALTER TABLE `booking_clothes`
  ADD CONSTRAINT `booking_fk_booking` FOREIGN KEY (`rcptNo`) REFERENCES `booking` (`rcptNo`),
  ADD CONSTRAINT `booking_fk_clothes` FOREIGN KEY (`cid`) REFERENCES `clothes` (`cid`);

--
-- Constraints for table `dnp`
--
ALTER TABLE `dnp`
  ADD CONSTRAINT `dnf_clients` FOREIGN KEY (`phone`) REFERENCES `client` (`phone`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
