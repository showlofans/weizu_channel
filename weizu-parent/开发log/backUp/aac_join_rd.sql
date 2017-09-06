/*
Navicat MySQL Data Transfer

Source Server         : home
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : rate_channel

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2017-09-06 15:29:07
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `aac_join_rd`
-- ----------------------------
DROP TABLE IF EXISTS `aac_join_rd`;
CREATE TABLE `aac_join_rd` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rate_discount_id` bigint(20) DEFAULT NULL COMMENT '费率折扣id',
  `active_id` bigint(20) DEFAULT NULL COMMENT '代理商通道连接id',
  PRIMARY KEY (`id`),
  KEY `join_aac_fk` (`active_id`),
  KEY `join_rd_fk` (`rate_discount_id`),
  CONSTRAINT `join_aac_fk` FOREIGN KEY (`active_id`) REFERENCES `agency_active_rate` (`id`) ON DELETE CASCADE,
  CONSTRAINT `join_rd_fk` FOREIGN KEY (`rate_discount_id`) REFERENCES `rate_discount` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aac_join_rd
-- ----------------------------

-- ----------------------------
-- Table structure for `agency_join_rate`
-- ----------------------------
DROP TABLE IF EXISTS `agency_join_rate`;
CREATE TABLE `agency_join_rate` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `agency_id` int(11) DEFAULT NULL,
  `rate_discount_id` bigint(20) DEFAULT NULL,
  `join_time` bigint(20) DEFAULT NULL,
  `join_state` int(11) DEFAULT NULL COMMENT '绑定状态（0-绑定，1-解绑）',
  `join_agency_id` int(11) DEFAULT NULL COMMENT '绑定人',
  PRIMARY KEY (`id`),
  KEY `fk_join_agency_ajr` (`agency_id`),
  KEY `fk_join_rateDis_ajr` (`rate_discount_id`),
  CONSTRAINT `fk_join_agency_ajr` FOREIGN KEY (`agency_id`) REFERENCES `agency_backward` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_join_rateDis_ajr` FOREIGN KEY (`rate_discount_id`) REFERENCES `rate_discount` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of agency_join_rate
-- ----------------------------

-- ----------------------------
-- Table structure for `channel_discount_bind`
-- ----------------------------
DROP TABLE IF EXISTS `channel_discount_bind`;
CREATE TABLE `channel_discount_bind` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `channel_id` bigint(11) DEFAULT NULL,
  `scope_city_code` varchar(255) DEFAULT NULL COMMENT '地区',
  `channel_discount` double DEFAULT NULL COMMENT '通道折扣',
  `channel_name` varchar(255) DEFAULT NULL COMMENT '通道名称',
  `operator_type` int(11) DEFAULT NULL COMMENT '运营商类型(0-移动，1-联通，2-电信）',
  `service_type` int(11) DEFAULT NULL COMMENT '流量类型',
  PRIMARY KEY (`id`),
  KEY `channel_channel_discouont` (`channel_id`),
  CONSTRAINT `channel_discount_bind_ibfk_1` FOREIGN KEY (`channel_id`) REFERENCES `channel_channel` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of channel_discount_bind
-- ----------------------------
INSERT INTO `channel_discount_bind` VALUES ('3', null, '01', '0.8', 'wz江西', null, '0');
INSERT INTO `channel_discount_bind` VALUES ('4', null, '14', '0.6', 'wz江西', null, '0');
INSERT INTO `channel_discount_bind` VALUES ('7', '7', '09', '0.85', 'wz本地', '1', '0');
INSERT INTO `channel_discount_bind` VALUES ('8', '7', '14', '0.7', 'wz本地', '1', '0');
INSERT INTO `channel_discount_bind` VALUES ('9', '8', '13', '0.56', '省内-wz江西省', '0', '0');
INSERT INTO `channel_discount_bind` VALUES ('10', '9', '13', '0.9', '全国-wz福建', '1', '0');
INSERT INTO `channel_discount_bind` VALUES ('11', '10', '19', '0.85', '省内-wz广东', '1', '0');
INSERT INTO `channel_discount_bind` VALUES ('12', '11', '15', '0.95', '全国-wz广东移动95', '0', '0');
INSERT INTO `channel_discount_bind` VALUES ('13', '12', '19', '0.75', '省漫游-wz广东移动75', '0', '0');
INSERT INTO `channel_discount_bind` VALUES ('14', '13', '14', '0.65', '省漫游-省漫游-江西', '1', null);

-- ----------------------------
-- Table structure for `channel_forward`
-- ----------------------------
DROP TABLE IF EXISTS `channel_forward`;
CREATE TABLE `channel_forward` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '通道id',
  `agency_id` int(11) DEFAULT NULL COMMENT '通道所属代理商id',
  `channel_name` varchar(255) DEFAULT NULL COMMENT '通道名称',
  `pg_size` varchar(255) DEFAULT NULL COMMENT '包体大小列表（通道规格）',
  `service_id` varchar(11) DEFAULT NULL COMMENT '流量范围id(外键)',
  `operator_type` int(11) DEFAULT NULL COMMENT '运营商类型（0-移动，1-联通，2-电信）',
  `channel_discount` double DEFAULT '1' COMMENT '折扣',
  `ep_id` int(11) DEFAULT NULL COMMENT '平台所属ID（外键）',
  `channel_total_use` int(11) DEFAULT NULL COMMENT '通道交易总单数',
  `channel_total_amount` double DEFAULT NULL COMMENT '通道交易总额',
  `channel_balance` double DEFAULT NULL COMMENT '通道余额（和平台余额的值是一样的。）',
  `channel_state` int(11) DEFAULT '0' COMMENT '通道状态--（0-运行 1-暂停）',
  `channel_use_state` int(11) DEFAULT '0' COMMENT '通道使用状态(0-已启用，1-已暂停)',
  `last_access` bigint(20) DEFAULT '0' COMMENT '最后更新时间',
  `bill_type` int(2) DEFAULT NULL COMMENT '票务类型（1-对公，0-对私）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of channel_forward
-- ----------------------------
INSERT INTO `channel_forward` VALUES ('27', '1', '看看-福建省', '200', '1300', '0', '0.2', '1', '0', '0', '0', '0', '0', '12', '0');
INSERT INTO `channel_forward` VALUES ('28', '1', 'gd-北京市', '300 200', '0100', '0', '0.6', '1', '0', '0', '0', '0', '0', '13', '0');
INSERT INTO `channel_forward` VALUES ('29', '1', '福建2-福建省', '6144& 3072& 100', '1300', '0', '0.05', '1', '0', '0', '0', '0', '0', '14', '0');
INSERT INTO `channel_forward` VALUES ('30', '1', '福建3-福建省', '6144& 3072& 100', '1300', '0', '0.56', '1', '0', '0', '0', '0', '0', '15', '0');
INSERT INTO `channel_forward` VALUES ('31', '1', '方式-上海市', '6144& 3072& 100', '0900', '0', '0.34', '1', '0', '0', '0', '0', '0', '16', '0');
INSERT INTO `channel_forward` VALUES ('32', '4', '尚通假-江西省', '6144& 3072& 100', '1400', '0', '0.56', '2', '18', '1814.4', '0', '0', '1', null, '0');
INSERT INTO `channel_forward` VALUES ('33', '4', '尚通联通-江西省', '100', '1410', '1', '0.55', '2', '0', '0', '0', '0', '0', null, '0');
INSERT INTO `channel_forward` VALUES ('34', '1', '12345-江西省', '200', '1411', '1', '0.56', '1', '0', '0', '0', '0', '0', null, '0');
INSERT INTO `channel_forward` VALUES ('35', '4', '浙江-浙江省', '500', '1101', '0', '0.5', '32', '11', '795', '0', '0', '0', null, '0');
INSERT INTO `channel_forward` VALUES ('36', '4', '省漫游500-浙江省', '500', '1102', '0', '0.5', '32', '0', '0', '0', '0', '1', null, '0');
INSERT INTO `channel_forward` VALUES ('37', '4', '全国5折-浙江省', '6144& 3072& 500', '1100', '0', '0.5', '32', '0', '0', '0', '0', '0', null, '0');
INSERT INTO `channel_forward` VALUES ('39', '21', '微族-浙江省', '6144& 3072& 500', '1100', '0', '0.5', '32', '6', '540', '0', '0', '0', null, '0');
INSERT INTO `channel_forward` VALUES ('41', '4', 'wz河南-河南省', '6144& 3072& 500', '1600', '0', '0.56', '32', '0', '0', '0', '0', '0', null, '0');
INSERT INTO `channel_forward` VALUES ('45', '4', 'wz河南-河南省', '6144& 3072& 500', '1600', '0', '0.6', '32', '0', '0', '0', '0', '0', null, '0');
INSERT INTO `channel_forward` VALUES ('47', '4', 'wz河南-河南省', '6144& 3072& 500', '1600', '0', '0.6', '32', '0', '0', '0', '0', '0', null, '0');
INSERT INTO `channel_forward` VALUES ('48', '4', 'wz河南-河南省', '6144& 3072& 500', '1600', '0', '0.6', '32', '0', '0', '0', '0', '0', null, '0');
INSERT INTO `channel_forward` VALUES ('49', '4', 'wz河南-河南省', '6144& 3072& 500', '1600', '0', '0.6', '32', '0', '0', '0', '0', '0', null, '0');
INSERT INTO `channel_forward` VALUES ('53', '4', 'wz-江西省', '100', '1410', '1', '0.56', '32', '0', '0', '0', '0', '0', null, '0');
INSERT INTO `channel_forward` VALUES ('54', '4', 'fsd-辽宁省', '6144& 3072& 500', '0600', '0', '0.56', '32', '0', '0', '0', '0', '0', null, '0');
INSERT INTO `channel_forward` VALUES ('55', '4', 'fsd-江苏省', '6144& 3072& 500', '1000', '0', '0.56', '32', '0', '0', '0', '0', '0', null, '0');
INSERT INTO `channel_forward` VALUES ('56', '4', 'wz江西', '6144& 3072& 500', null, '0', '1', '32', '0', '0', '0', null, '0', '0', '0');

-- ----------------------------
-- Table structure for `channel_group`
-- ----------------------------
DROP TABLE IF EXISTS `channel_group`;
CREATE TABLE `channel_group` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '群组id',
  `group_type` int(11) DEFAULT NULL COMMENT '群组类型（分组依据）(0-流量类型，1-平台分组)',
  `group_name` varchar(255) DEFAULT NULL COMMENT '群组名',
  `channel_id` int(11) DEFAULT NULL COMMENT '通道id(外键)',
  `channel_name` varchar(255) DEFAULT NULL COMMENT '通道名称(方便显示)',
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of channel_group
-- ----------------------------

-- ----------------------------
-- Table structure for `channel_pg`
-- ----------------------------
DROP TABLE IF EXISTS `channel_pg`;
CREATE TABLE `channel_pg` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `operator_type` int(11) DEFAULT '0' COMMENT '运营商类型（0-移动，1-联通，电信）',
  `pg_size` int(11) DEFAULT '0' COMMENT '包体大小',
  `pg_price` double DEFAULT NULL COMMENT '包体价格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of channel_pg
-- ----------------------------

-- ----------------------------
-- Table structure for `rate_join_channel`
-- ----------------------------
DROP TABLE IF EXISTS `rate_join_channel`;
CREATE TABLE `rate_join_channel` (
  `id` bigint(20) NOT NULL DEFAULT '0' COMMENT '主键id',
  `rate_id` bigint(20) DEFAULT NULL COMMENT '费率id',
  `channel_id` int(11) DEFAULT NULL COMMENT '通道id',
  `join_time` bigint(20) DEFAULT NULL COMMENT '配置时间',
  `bill_type` int(2) DEFAULT NULL COMMENT '是否带票（1-对公带票，0-对私不带票）',
  PRIMARY KEY (`id`),
  KEY `join_rate` (`rate_id`),
  KEY `join_channel` (`channel_id`),
  CONSTRAINT `join_channel` FOREIGN KEY (`channel_id`) REFERENCES `agency_backward` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `join_rate` FOREIGN KEY (`rate_id`) REFERENCES `rate_backward` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rate_join_channel
-- ----------------------------
