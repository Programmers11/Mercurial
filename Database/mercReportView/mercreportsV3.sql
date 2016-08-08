SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;


CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `mercreports` AS select `b`.`rcptNo` AS `Voucher No`,`b`.`phone` AS `Phone`,`c`.`clientName` AS `Customer`,`b`.`status` AS `Status`,`b`.`issueDate` AS `IssueDate`,`b`.`deldate` AS `deldate`,sum((`info`.`qty` * (select `cl`.`countVal` from `clothes` `cl` where (`cl`.`cid` = `info`.`cid`)))) AS `qty`,`b`.`netAmount` AS `netAmount`,`b`.`gst` AS `gst%`,round(((`b`.`netAmount` * `b`.`gst`) / (100 + `b`.`gst`)),2) AS `Gst_Amt`,round((`b`.`netAmount` - ((`b`.`netAmount` * `b`.`gst`) / (100 + `b`.`gst`))),2) AS `GrosAmount` from ((`booking` `b` join `booking_clothes` `info`) join `client` `c`) where ((`info`.`rcptNo` = `b`.`rcptNo`) and (`b`.`phone` = `c`.`phone`)) group by `b`.`rcptNo`;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
