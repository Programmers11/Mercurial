create view bookingReport as 
(
(select `b`.`rcptNo` AS `Voucher No`,`b`.`issueDate` AS `IssueDate`,sum((`info`.`qty` * (select `cl`.`countVal` from `project`.`clothes` `cl` where (`cl`.`cid` = `info`.`cid`)))) AS `qty`,`b`.`netAmount` AS `Amount` from (`project`.`booking` `b` join `project`.`booking_clothes` `info`) where (`info`.`rcptNo` = `b`.`rcptNo`) group by `b`.`rcptNo` order by `b`.`rcptNo`)
)