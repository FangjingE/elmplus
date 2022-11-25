/*
MySQL Data Transfer
Source Host: localhost
Source Database: credit
Target Host: localhost
Target Database: credit
Date: 2022/11/25 13:32:51
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for bonuspointstranscation
-- ----------------------------
DROP TABLE IF EXISTS `bonuspointstranscation`;
CREATE TABLE `bonuspointstranscation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userid` varchar(50) DEFAULT NULL,
  `orderid` int DEFAULT NULL,
  `amount` decimal(10,0) DEFAULT NULL,
  `type` tinyint(1) DEFAULT NULL,
  `createtime` mediumtext NOT NULL,
  `expiredtime` mediumtext NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records 
-- ----------------------------
