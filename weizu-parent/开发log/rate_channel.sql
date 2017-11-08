/*
Navicat MySQL Data Transfer

Source Server         : channel-server
Source Server Version : 50626
Source Host           : 120.55.162.224:3306
Source Database       : rate_channel

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2017-11-08 18:19:02
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `account_active_rate`
-- ----------------------------
DROP TABLE IF EXISTS `account_active_rate`;
CREATE TABLE `account_active_rate` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '连接id',
  `account_id` int(11) DEFAULT NULL,
  `bind_agency_id` int(255) DEFAULT NULL COMMENT '绑定人Id',
  `rate_discount_id` bigint(11) DEFAULT NULL COMMENT '费率折扣id',
  `bind_state` int(11) DEFAULT '0' COMMENT '绑定状态（0-已绑定，1-未绑定）',
  `agency_name` varchar(255) DEFAULT NULL,
  `active_time` bigint(20) DEFAULT NULL COMMENT '连接时间',
  PRIMARY KEY (`id`),
  KEY `agency_agency` (`account_id`),
  KEY `bind_agency_fk` (`bind_agency_id`),
  KEY `channel_agency_fk` (`rate_discount_id`),
  CONSTRAINT `account_aar` FOREIGN KEY (`account_id`) REFERENCES `charge_account` (`id`) ON DELETE CASCADE,
  CONSTRAINT `bind_agency_fk` FOREIGN KEY (`bind_agency_id`) REFERENCES `agency_backward` (`id`),
  CONSTRAINT `channel_agency_fk` FOREIGN KEY (`rate_discount_id`) REFERENCES `rate_discount` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4300 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account_active_rate
-- ----------------------------
