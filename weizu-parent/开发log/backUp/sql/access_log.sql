/*
Navicat MySQL Data Transfer

Source Server         : channel-server
Source Server Version : 50626
Source Host           : 120.55.162.224:3306
Source Database       : rate_channel

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2018-02-08 09:04:57
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `access_log`
-- ----------------------------
DROP TABLE IF EXISTS `access_log`;
CREATE TABLE `access_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `request_url` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '接口访问地址',
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单号（关键字）',
  `access_num` int(11) DEFAULT NULL COMMENT '访问次数',
  `last_access` bigint(20) DEFAULT NULL COMMENT '最后一次访问时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of access_log
-- ----------------------------

-- ----------------------------
-- Table structure for `event_log`
-- ----------------------------
DROP TABLE IF EXISTS `event_log`;
CREATE TABLE `event_log` (
  `id` bigint(20) NOT NULL,
  `agency_id` int(11) DEFAULT NULL,
  `event_type` int(11) DEFAULT NULL,
  `event_state` int(11) DEFAULT NULL COMMENT '事件绑定状态',
  `last_access` bigint(20) DEFAULT NULL,
  `event_key` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '主要字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of event_log
-- ----------------------------

-- ----------------------------
-- Table structure for `purchase_log`
-- ----------------------------
DROP TABLE IF EXISTS `purchase_log`;
CREATE TABLE `purchase_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) DEFAULT NULL,
  `pg_id` int(11) DEFAULT NULL,
  `number` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `sign` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `order_id_from` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `report_url` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `order_arrive_time` bigint(20) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `tip_code` int(11) DEFAULT NULL COMMENT '结果码',
  `tip_msg` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '结果描述',
  `rec_add_tag` int(11) DEFAULT NULL COMMENT '冲单账户扣款情况',
  `supper_rec_add_tag` int(11) DEFAULT NULL COMMENT '超管账户扣款情况',
  `rec_add_tag_desc` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '账户扣款描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=561 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of purchase_log
-- ----------------------------
