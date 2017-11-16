/*
Navicat MySQL Data Transfer

Source Server         : home
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : rate_channel

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2017-11-16 18:18:21
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `telrate_bind_account`
-- ----------------------------
DROP TABLE IF EXISTS `telrate_bind_account`;
CREATE TABLE `telrate_bind_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) DEFAULT NULL,
  `agency_name` varchar(255) DEFAULT NULL,
  `tel_rate_id` bigint(20) DEFAULT NULL,
  `active_time` bigint(20) DEFAULT NULL,
  `bind_state` int(11) DEFAULT NULL,
  `bind_agency_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `telrate_bind_fk` (`tel_rate_id`),
  CONSTRAINT `telrate_bind_fk` FOREIGN KEY (`tel_rate_id`) REFERENCES `tel_rate` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of telrate_bind_account
-- ----------------------------

-- ----------------------------
-- Table structure for `tel_rate`
-- ----------------------------
DROP TABLE IF EXISTS `tel_rate`;
CREATE TABLE `tel_rate` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_discount` double DEFAULT NULL,
  `active_id` bigint(20) DEFAULT NULL,
  `bill_type` int(11) DEFAULT NULL,
  `telchannel_id` bigint(20) DEFAULT NULL,
  `raet_for` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `telchanel_rate_fk` (`telchannel_id`),
  CONSTRAINT `telchanel_rate_fk` FOREIGN KEY (`telchannel_id`) REFERENCES `telchannel` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tel_rate
-- ----------------------------
