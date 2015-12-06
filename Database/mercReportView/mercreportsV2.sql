-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 06, 2015 at 08:41 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `project`
--

-- --------------------------------------------------------

--
-- Structure for view `mercreports`
--
DROP VIEW `mercreports`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `mercreports` AS select `b`.`rcptNo` AS `Voucher No`,`b`.`phone` AS `Phone`,`c`.`clientName` AS `Customer`,`b`.`status` AS `Status`,`b`.`issueDate` AS `IssueDate`,`b`.`deldate` AS `deldate`,sum((`info`.`qty` * (select `cl`.`countVal` from `clothes` `cl` where (`cl`.`cid` = `info`.`cid`)))) AS `qty`,`b`.`netAmount` AS `netAmount`,`b`.`gst` AS `gst%`,floor(((`b`.`netAmount` * `b`.`gst`) / (100 + `b`.`gst`))) AS `Gst_Amt`,floor((`b`.`netAmount` - ((`b`.`netAmount` * `b`.`gst`) / (100 + `b`.`gst`)))) AS `GrosAmount` from ((`booking` `b` join `booking_clothes` `info`) join `client` `c`) where ((`info`.`rcptNo` = `b`.`rcptNo`) and (`b`.`phone` = `c`.`phone`)) group by `b`.`rcptNo`;

--
-- VIEW  `mercreports`
-- Data: None
--


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
