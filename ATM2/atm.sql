# Host: 127.0.0.1  (Version 5.7.17-log)
# Date: 2017-03-13 10:21:36
# Generator: MySQL-Front 6.0  (Build 1.57)


#
# Structure for table "detail"
#

DROP TABLE IF EXISTS `detail`;
CREATE TABLE `detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `card_id` bigint(19) NOT NULL,
  `amount` decimal(10,2) NOT NULL DEFAULT '0.00',
  `date` datetime NOT NULL,
  `des` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=utf8;

#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `Id` int(11) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `card_id` bigint(19) unsigned NOT NULL AUTO_INCREMENT,
  `balance` decimal(10,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`card_id`,`Id`),
  KEY `card_id` (`card_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6220000000000000011 DEFAULT CHARSET=utf8;
