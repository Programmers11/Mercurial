Update `booking` set gst = (gst * 100/(100-discount)) where gst>0;

Update `booking` set amount = amount+gst where gst>0;

Update `booking` set gst = 14 where gst>0;

drop view mercreports;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `mercreports` AS select `b`.`rcptNo` AS `Voucher No`,`b`.`phone` AS `Phone`,`c`.`clientName` AS `Customer`,`b`.`status` AS `Status`,`b`.`issueDate` AS `IssueDate`,`b`.`deldate` AS `deldate`,sum((`info`.`qty` * (select `cl`.`countVal` from `clothes` `cl` where (`cl`.`cid` = `info`.`cid`)))) AS `qty`,`b`.`netAmount` AS `netAmount`,`b`.`gst` AS `gst%`,((`b`.`netAmount` * `b`.`gst`) / (100 + `b`.`gst`)) AS `Gst_Amt`,(`b`.`netAmount` - ((`b`.`netAmount` * `b`.`gst`) / (100 + `b`.`gst`))) AS `GrosAmount` from ((`booking` `b` join `booking_clothes` `info`) join `client` `c`) where ((`info`.`rcptNo` = `b`.`rcptNo`) and (`b`.`phone` = `c`.`phone`)) group by `b`.`rcptNo`;


