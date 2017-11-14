/*
Navicat MySQL Data Transfer

Source Server         : channel-server
Source Server Version : 50626
Source Host           : 120.55.162.224:3306
Source Database       : rate_channel

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2017-11-13 09:51:48
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `telchannel`
-- ----------------------------
DROP TABLE IF EXISTS `telchannel`;
CREATE TABLE `telchannel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id（话费通道折扣id）',
  `telchannel_discount` double DEFAULT NULL COMMENT '通道价',
  `bill_type` int(11) DEFAULT NULL COMMENT '商务类型',
  `telchannel_total_use` int(11) DEFAULT NULL,
  `telchannel_total_amount` double DEFAULT NULL COMMENT '交易总金额',
  `telchannel_total_profit` double DEFAULT NULL COMMENT '总利润 ',
  `telchannel_state` int(11) DEFAULT NULL COMMENT '通道状态（0-运行 1-暂停）',
  `telchannel_use_state` int(11) DEFAULT NULL COMMENT '通道使用状态(0-已启用，1-已暂停)',
  `tel_product_id` bigint(20) DEFAULT NULL COMMENT '产品编码外键',
  `last_access` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `telchannel_product_fk` (`tel_product_id`),
  CONSTRAINT `telchannel_product_fk` FOREIGN KEY (`tel_product_id`) REFERENCES `tel_product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of telchannel
-- ----------------------------

-- ----------------------------
-- Table structure for `tel_product`
-- ----------------------------
DROP TABLE IF EXISTS `tel_product`;
CREATE TABLE `tel_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ep_id` int(11) DEFAULT NULL,
  `ep_name` varchar(40) CHARACTER SET utf8 DEFAULT NULL,
  `tel_code` varchar(40) CHARACTER SET utf8 DEFAULT NULL,
  `charge_limit_low` int(11) DEFAULT NULL,
  `charge_limit_high` int(11) DEFAULT NULL,
  `charge_value` int(11) DEFAULT NULL,
  `free_charge` int(11) DEFAULT NULL,
  `cityid` varchar(11) CHARACTER SET utf8 NOT NULL COMMENT '城市编码',
  `charge_speed` int(11) DEFAULT NULL,
  `service_type` int(11) DEFAULT NULL,
  `operator_name` int(11) DEFAULT NULL,
  `limit_description` varchar(80) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tel_product
-- ----------------------------
