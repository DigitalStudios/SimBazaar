CREATE TABLE `address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `address_line1` varchar(45) DEFAULT NULL,
  `address_line2` varchar(45) DEFAULT NULL,
  `pincode` bigint(6) DEFAULT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `orderdate` date DEFAULT NULL,
  `estd_deliverydate` date DEFAULT NULL,
  `deliverydate` date DEFAULT NULL,
  `orderstatus` varchar(20) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `fk_order_user_idx` (`user_id`),
  CONSTRAINT `fk_order_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `order_details` (
  `orderdetail_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `sim_id` int(11) NOT NULL,
  PRIMARY KEY (`orderdetail_id`),
  KEY `fk_orderdet_order_idx` (`order_id`),
  KEY `fk_orderdet_sim_idx` (`sim_id`),
  CONSTRAINT `fk_orderdet_order` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_orderdet_sim` FOREIGN KEY (`sim_id`) REFERENCES `sim_details` (`sim_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sim_details` (
  `sim_no` bigint(20) NOT NULL,
  `sim_id` int(11) NOT NULL AUTO_INCREMENT,
  `operator` varchar(20) DEFAULT NULL,
  `billing_type` varchar(10) DEFAULT NULL,
  `category` varchar(20) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `status` enum('y','n') NOT NULL,
  PRIMARY KEY (`sim_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `userphone` bigint(20) NOT NULL,
  `address_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `fk_address_user_idx` (`address_id`),
  CONSTRAINT `fk_address_user` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
