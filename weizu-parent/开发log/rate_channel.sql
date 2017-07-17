/*
Navicat MySQL Data Transfer

Source Server         : home
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : rate_channel

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2017-07-17 18:34:01
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aac_join_rd
-- ----------------------------
INSERT INTO `aac_join_rd` VALUES ('1', '14', '17');
INSERT INTO `aac_join_rd` VALUES ('3', '16', '19');
INSERT INTO `aac_join_rd` VALUES ('5', '18', '21');
INSERT INTO `aac_join_rd` VALUES ('6', '19', '22');

-- ----------------------------
-- Table structure for `agency_active_rate`
-- ----------------------------
DROP TABLE IF EXISTS `agency_active_rate`;
CREATE TABLE `agency_active_rate` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '连接id',
  `agency_id` int(11) DEFAULT NULL,
  `bind_agency_id` int(255) DEFAULT NULL COMMENT '绑定人Id',
  `rate_discount_id` bigint(11) DEFAULT NULL COMMENT '费率折扣id',
  `bind_state` int(11) DEFAULT '0' COMMENT '绑定状态（0-已绑定，1-未绑定）',
  `agency_name` varchar(255) DEFAULT NULL,
  `active_time` bigint(20) DEFAULT NULL COMMENT '连接时间',
  PRIMARY KEY (`id`),
  KEY `agency_agency` (`agency_id`),
  KEY `bind_agency_fk` (`bind_agency_id`),
  KEY `channel_agency_fk` (`rate_discount_id`),
  CONSTRAINT `agency_agency` FOREIGN KEY (`agency_id`) REFERENCES `agency_backward` (`id`),
  CONSTRAINT `bind_agency_fk` FOREIGN KEY (`bind_agency_id`) REFERENCES `agency_backward` (`id`),
  CONSTRAINT `channel_agency_fk` FOREIGN KEY (`rate_discount_id`) REFERENCES `rate_discount` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of agency_active_rate
-- ----------------------------
INSERT INTO `agency_active_rate` VALUES ('1', '21', '4', '12', '1', '456', null);
INSERT INTO `agency_active_rate` VALUES ('2', '21', '4', '10', '1', '456', null);
INSERT INTO `agency_active_rate` VALUES ('3', '21', '4', '12', '1', '456', null);
INSERT INTO `agency_active_rate` VALUES ('4', '21', '4', '12', '1', '456', null);
INSERT INTO `agency_active_rate` VALUES ('5', '21', '4', '12', '0', '456', '1499419864447');
INSERT INTO `agency_active_rate` VALUES ('6', '23', '4', '10', '0', 'w', '1499476171448');
INSERT INTO `agency_active_rate` VALUES ('7', '21', '4', '12', '0', '456', '1499652418441');
INSERT INTO `agency_active_rate` VALUES ('8', '21', '4', '12', '0', '456', '1499652439155');
INSERT INTO `agency_active_rate` VALUES ('9', '21', '4', '12', '0', '456', '1499652492051');
INSERT INTO `agency_active_rate` VALUES ('13', '21', '4', '12', '0', '456', '1499653581437');
INSERT INTO `agency_active_rate` VALUES ('14', '24', '4', '12', '0', 'kkk', '1499653621056');
INSERT INTO `agency_active_rate` VALUES ('15', '23', '4', '11', '0', 'w', '1499678717931');
INSERT INTO `agency_active_rate` VALUES ('16', '21', '4', '12', '0', '456', '1499752473997');
INSERT INTO `agency_active_rate` VALUES ('17', '21', '4', '12', '0', '456', '1499757929280');
INSERT INTO `agency_active_rate` VALUES ('18', '21', '4', '7', '0', '456', '1499850122120');
INSERT INTO `agency_active_rate` VALUES ('19', '23', '4', '12', '1', 'w', '1499909562779');
INSERT INTO `agency_active_rate` VALUES ('20', '21', '4', '11', '1', '456', '1500008387698');
INSERT INTO `agency_active_rate` VALUES ('21', '23', '4', null, '0', 'w', '1500024678964');
INSERT INTO `agency_active_rate` VALUES ('22', '23', '4', null, '0', 'w', '1500024876798');
INSERT INTO `agency_active_rate` VALUES ('25', '24', '4', '22', '0', 'kkk', '1500025358726');
INSERT INTO `agency_active_rate` VALUES ('26', '21', '4', '23', '0', '456', '1500081258422');
INSERT INTO `agency_active_rate` VALUES ('27', '24', '4', '24', '1', 'kkk', '1500081299461');
INSERT INTO `agency_active_rate` VALUES ('28', '27', '4', '32', '0', 'company', '1500092461795');
INSERT INTO `agency_active_rate` VALUES ('29', '27', '4', '33', '0', 'company', '1500093565885');
INSERT INTO `agency_active_rate` VALUES ('30', '27', '4', '34', '0', 'company', '1500093595298');
INSERT INTO `agency_active_rate` VALUES ('31', '27', '4', '35', '0', 'company', '1500093683813');

-- ----------------------------
-- Table structure for `agency_backward`
-- ----------------------------
DROP TABLE IF EXISTS `agency_backward`;
CREATE TABLE `agency_backward` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ä»£ç†å•†id',
  `root_agency_id` int(11) DEFAULT NULL COMMENT '上一级代理商id',
  `user_name` varchar(255) DEFAULT NULL COMMENT 'ä»£ç†å•†æ˜µç§°ï¼ˆè´¦å·ï¼‰',
  `user_pass` varchar(255) DEFAULT NULL COMMENT 'ä»£ç†å•†å¯†ç ',
  `user_real_name` varchar(255) DEFAULT NULL COMMENT 'ä»£ç†å•†çœŸå®žåå­—',
  `agency_tel` varchar(255) DEFAULT NULL COMMENT 'è”ç³»ç”µè¯',
  `user_email` varchar(255) DEFAULT NULL COMMENT 'è”ç³»é‚®ç®±',
  `agency_ip` varchar(255) DEFAULT NULL COMMENT 'ä»£ç†å•†ç³»ç»Ÿè®¿é—®ipåœ°å€',
  `rate_id` bigint(11) DEFAULT NULL COMMENT '不带票费率id',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `verify_code` varchar(255) DEFAULT NULL COMMENT '注册邀请码',
  `user_api_key` varchar(32) DEFAULT NULL COMMENT '用户系统对接平台的apikey',
  `bill_rate_id` bigint(20) DEFAULT NULL COMMENT '带票费率id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of agency_backward
-- ----------------------------
INSERT INTO `agency_backward` VALUES ('1', '0', 'xiao', 'xiao', 'xiaoqiang', '', '', '', null, '1495689716779', 'FV', null, null);
INSERT INTO `agency_backward` VALUES ('4', '1', '123', '123', '木头人', '15858343638', '22222', '22', '3', '1499736896474', 'GD9QS', null, null);
INSERT INTO `agency_backward` VALUES ('21', '4', '456', '123', '123', '123', '123@123.com', '1233', null, '1498617431513', 'H769', '402880ef5cd2b925015cd2b925b90000', '12');
INSERT INTO `agency_backward` VALUES ('23', '4', 'w', 'w', 'w', 'w', 'w@d.com', 'f', null, '1498621008604', 'H65M', '402880ef5cd2b925015cd2bc11d70001', '13');
INSERT INTO `agency_backward` VALUES ('24', '4', 'kkk', 'kkk', 'kkk', 'kkk', 'kkk@qq.com', 'kkk', '7', '1498617873998', '7L4T', '402880ef5cd2b925015cd2bc5d130002', null);
INSERT INTO `agency_backward` VALUES ('25', '1', 'lexin', 'lexin', '乐信', '13699562589', '13699562589@qq.com', 'http://127.0.0.1:8080', null, '1496479483371', '', null, '9');
INSERT INTO `agency_backward` VALUES ('26', '23', 'wt', 'wt', 'wt', 'wt', 'wt@qq', 'wt', null, '1497231635832', 'LG3G', '402880ef5cec6811015cec6811ed0000', null);
INSERT INTO `agency_backward` VALUES ('27', '4', 'company', '123', 'xiaozhu', '1', '16@163', '1', null, '1499421323673', '', null, null);

-- ----------------------------
-- Table structure for `agency_ep`
-- ----------------------------
DROP TABLE IF EXISTS `agency_ep`;
CREATE TABLE `agency_ep` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `agency_id` int(11) DEFAULT NULL,
  `agency_name` varchar(255) DEFAULT NULL,
  `ep_id` int(11) DEFAULT NULL,
  `ep_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_agencyEp_agencyId` (`agency_id`),
  KEY `FK_agencyEp_epId` (`ep_id`),
  CONSTRAINT `FK_agencyEp_agencyId` FOREIGN KEY (`agency_id`) REFERENCES `agency_backward` (`id`) ON DELETE NO ACTION,
  CONSTRAINT `FK_agencyEp_epId` FOREIGN KEY (`ep_id`) REFERENCES `exchange_platform` (`id`) ON DELETE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of agency_ep
-- ----------------------------
INSERT INTO `agency_ep` VALUES ('1', '4', '123', '2', '尚通');
INSERT INTO `agency_ep` VALUES ('5', '4', '123', '13', '123');
INSERT INTO `agency_ep` VALUES ('10', '4', '123', '18', '1');
INSERT INTO `agency_ep` VALUES ('19', '4', '123', '27', '4');
INSERT INTO `agency_ep` VALUES ('22', '4', '123', '30', '5');
INSERT INTO `agency_ep` VALUES ('23', '4', '123', '31', '0');
INSERT INTO `agency_ep` VALUES ('24', '4', '123', '32', 'wzkj');
INSERT INTO `agency_ep` VALUES ('26', '21', '456', '32', 'wzkj');
INSERT INTO `agency_ep` VALUES ('28', '4', '123', '13', '123');
INSERT INTO `agency_ep` VALUES ('30', '4', '123', '40', '456');

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
-- Table structure for `channel_channel`
-- ----------------------------
DROP TABLE IF EXISTS `channel_channel`;
CREATE TABLE `channel_channel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '通道id',
  `channel_name` varchar(255) DEFAULT NULL COMMENT '通道名称',
  `pg_size` varchar(255) DEFAULT NULL COMMENT '通道规格',
  `ep_id` int(11) DEFAULT '0' COMMENT '平台id（外键）',
  `channel_total_use` int(11) DEFAULT NULL COMMENT '通道交易总单数',
  `channel_total_amount` double DEFAULT NULL COMMENT '通道交易总额',
  `channel_total_profit` double DEFAULT '0' COMMENT '通道利润',
  `channel_balance` double DEFAULT NULL COMMENT '通道余额（和平台余额的值是一样的。）',
  `channel_state` int(11) DEFAULT '0' COMMENT '通道状态--（0-运行 1-暂停）',
  `channel_use_state` int(11) DEFAULT '0' COMMENT '通道使用状态(0-已启用，1-已暂停)',
  `bill_type` int(11) DEFAULT NULL COMMENT '票务类型（1-对公，0-对私）',
  `last_access` bigint(20) DEFAULT NULL COMMENT '最后更新时间',
  `belong_agency_id` int(11) DEFAULT NULL COMMENT '通道所属代理商',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of channel_channel
-- ----------------------------
INSERT INTO `channel_channel` VALUES ('7', 'wz本地', '1000', '32', null, null, null, null, '0', '0', '0', '1499233574741', '4');
INSERT INTO `channel_channel` VALUES ('8', '省内-wz江西省', '500& 500', '32', null, null, null, null, '1', '0', '0', '1499236841669', '4');
INSERT INTO `channel_channel` VALUES ('9', '全国-wz福建', '100', null, null, null, null, null, '0', '0', '0', null, '4');
INSERT INTO `channel_channel` VALUES ('10', '省内-wz广东', '200', '32', null, null, null, null, '0', '0', '0', null, '4');
INSERT INTO `channel_channel` VALUES ('11', '全国-wz广东移动95', '6144& 3072& 500', '32', null, null, null, null, '0', '0', '0', null, '4');
INSERT INTO `channel_channel` VALUES ('12', '省漫游-wz广东移动75', '500& 6144', '32', null, null, null, null, '0', '0', '0', null, '4');
INSERT INTO `channel_channel` VALUES ('13', '省漫游-江西', '1000', '32', null, null, null, null, '1', '1', '0', '1499680372499', '4');
INSERT INTO `channel_channel` VALUES ('14', '全国-', '6144& 3072& 500', '32', null, null, null, null, '0', '0', '0', null, '4');

-- ----------------------------
-- Table structure for `channel_discount`
-- ----------------------------
DROP TABLE IF EXISTS `channel_discount`;
CREATE TABLE `channel_discount` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `channel_id` bigint(11) DEFAULT NULL,
  `scope_city_code` varchar(255) DEFAULT NULL COMMENT '地区',
  `channel_discount` double DEFAULT NULL COMMENT '通道折扣',
  `channel_name` varchar(255) DEFAULT NULL COMMENT '通道名称',
  `operator_type` int(11) DEFAULT NULL COMMENT '运营商类型(0-移动，1-联通，2-电信）',
  `service_type` int(11) DEFAULT NULL COMMENT '流量类型',
  `discount_type` int(11) DEFAULT NULL COMMENT '通道折扣类型（0-对上，1-对下）',
  PRIMARY KEY (`id`),
  KEY `channel_channel_discouont` (`channel_id`),
  CONSTRAINT `channel_channel_discouont` FOREIGN KEY (`channel_id`) REFERENCES `channel_channel` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of channel_discount
-- ----------------------------
INSERT INTO `channel_discount` VALUES ('3', null, '01', '0.8', 'wz江西', null, '0', '0');
INSERT INTO `channel_discount` VALUES ('4', null, '14', '0.6', 'wz江西', null, '0', '0');
INSERT INTO `channel_discount` VALUES ('7', '7', '09', '0.85', 'wz本地', '1', '0', '0');
INSERT INTO `channel_discount` VALUES ('8', '7', '14', '0.7', 'wz本地', '1', '0', '0');
INSERT INTO `channel_discount` VALUES ('9', '8', '13', '0.56', '省内-wz江西省', '0', '0', '0');
INSERT INTO `channel_discount` VALUES ('10', '9', '13', '0.9', '全国-wz福建', '1', '0', '0');
INSERT INTO `channel_discount` VALUES ('11', '10', '19', '0.85', '省内-wz广东', '1', '0', '0');
INSERT INTO `channel_discount` VALUES ('12', '11', '15', '0.95', '全国-wz广东移动95', '0', '0', '0');
INSERT INTO `channel_discount` VALUES ('13', '12', '19', '0.75', '省漫游-wz广东移动75', '0', '0', '0');
INSERT INTO `channel_discount` VALUES ('14', '13', '14', '0.65', '省漫游-省漫游-江西', '1', null, '0');
INSERT INTO `channel_discount` VALUES ('15', '14', '06', '0.58', '全国-全国-', '0', '0', '0');

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
-- Table structure for `charge_account`
-- ----------------------------
DROP TABLE IF EXISTS `charge_account`;
CREATE TABLE `charge_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ep_id',
  `account_balance` double DEFAULT '0' COMMENT '账户余额',
  `remittance_way` varchar(255) DEFAULT NULL COMMENT '常用汇款方式',
  `remittance_bank_account` varchar(255) DEFAULT NULL COMMENT '汇款账号',
  `account_credit` double DEFAULT '0' COMMENT '透支额',
  `agency_id` int(11) DEFAULT NULL COMMENT '所属代理商id',
  `bill_type` int(2) DEFAULT NULL COMMENT '票务类型（1-对公，0-对私）',
  `certification_img` varchar(255) DEFAULT NULL COMMENT '认证图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of charge_account
-- ----------------------------
INSERT INTO `charge_account` VALUES ('1', '3981', null, null, '200', '1', '0', null);
INSERT INTO `charge_account` VALUES ('2', '-456', '工行', '123', '100', '4', '0', null);
INSERT INTO `charge_account` VALUES ('3', '0', null, null, '0', '16', '0', null);
INSERT INTO `charge_account` VALUES ('4', '0', null, null, '0', '17', '0', null);
INSERT INTO `charge_account` VALUES ('5', '0', null, null, '0', '18', '0', null);
INSERT INTO `charge_account` VALUES ('6', '0', null, null, '0', '19', '0', null);
INSERT INTO `charge_account` VALUES ('7', '0', null, null, '0', '20', '0', null);
INSERT INTO `charge_account` VALUES ('8', '600', null, null, '2000', '21', '0', null);
INSERT INTO `charge_account` VALUES ('9', '0', null, null, '0', '22', '0', null);
INSERT INTO `charge_account` VALUES ('10', '1000', null, null, '0', '23', '0', null);
INSERT INTO `charge_account` VALUES ('11', '356', null, null, '1212', '24', '0', null);
INSERT INTO `charge_account` VALUES ('12', '500', null, null, '2000', '25', '0', null);
INSERT INTO `charge_account` VALUES ('13', '123', null, null, '0', '26', '0', null);
INSERT INTO `charge_account` VALUES ('15', '0', null, null, '0', '1', '1', '/download?fileName=149881406211919859915_980x1200_0.jpg');
INSERT INTO `charge_account` VALUES ('17', '100', null, null, '0', '21', '1', '/download?fileName=149881550554119859915_980x1200_0.jpg');
INSERT INTO `charge_account` VALUES ('18', '0', null, null, '0', '24', '1', '/certification//download?fileName=149881581565019859915_980x1200_0.jpg');
INSERT INTO `charge_account` VALUES ('19', '0', null, null, '0', '26', '1', '/certification//download?fileName=149888733072419859915_980x1200_0.jpg');
INSERT INTO `charge_account` VALUES ('20', '0', null, null, '0', '27', '0', null);

-- ----------------------------
-- Table structure for `charge_record`
-- ----------------------------
DROP TABLE IF EXISTS `charge_record`;
CREATE TABLE `charge_record` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '操作id',
  `remittance_time` bigint(255) DEFAULT NULL COMMENT '汇款时间（信息更新时间）',
  `recharge_amount` double DEFAULT NULL COMMENT '发生金额',
  `charge_before` double DEFAULT NULL COMMENT ' 交易前余额',
  `charge_after` double DEFAULT NULL COMMENT '交易后余额',
  `bill_type` int(11) DEFAULT '1' COMMENT '发票类型（1-对公，0-对私）',
  `account_type` int(11) DEFAULT NULL COMMENT '充值扣款标识(0-充值，1-扣款)',
  `account_id` int(11) DEFAULT NULL COMMENT '账户id',
  `agency_id` int(11) DEFAULT NULL COMMENT '代理商账户id',
  `charge_for` int(11) DEFAULT NULL COMMENT '发生原因',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of charge_record
-- ----------------------------
INSERT INTO `charge_record` VALUES ('1', '1494472130819', '200', '4343', '4543', '0', '0', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('2', '1494475783929', '300', '4543', '4843', '0', '0', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('3', '1494476477425', '200', '4843', '5043', '0', '0', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('4', '1494476697825', '622', '5043', '5665', '1', '0', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('5', '1495698206637', '564', '0', '564', '0', '0', '8', '21', '1');
INSERT INTO `charge_record` VALUES ('6', '1496306974700', '500', '0', '500', '1', '0', '12', '25', '1');
INSERT INTO `charge_record` VALUES ('7', '1496457191946', '244', '564', '808', '1', '0', '8', '21', '1');
INSERT INTO `charge_record` VALUES ('8', '1496457234241', '100', '0', '100', '1', '0', '11', '24', '1');
INSERT INTO `charge_record` VALUES ('9', '1496479230732', '5665', '5665', '11330', '1', '0', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('10', '1497070558065', '-124', '11330', '11454', '1', '1', '2', '21', '1');
INSERT INTO `charge_record` VALUES ('11', '1497070572618', '124', '808', '932', '1', '0', '8', '21', '1');
INSERT INTO `charge_record` VALUES ('12', '1497070830424', '100', '11206', '11106', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('13', '1497070830432', '100', '0', '100', '0', '0', '10', '23', '1');
INSERT INTO `charge_record` VALUES ('14', '1497071092695', '200', '11106', '10906', '1', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('15', '1497071092702', '200', '100', '300', '1', '0', '11', '24', '1');
INSERT INTO `charge_record` VALUES ('16', '1497096706561', '100', '10906', '10806', '1', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('17', '1497096706578', '100', '932', '1032', '1', '0', '8', '21', '1');
INSERT INTO `charge_record` VALUES ('18', '1497230761210', '56', '10806', '10750', '1', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('19', '1497230761228', '56', '1032', '1088', '1', '0', '8', '21', '1');
INSERT INTO `charge_record` VALUES ('20', '1497234286518', '123', '100', '-23', '1', '1', '10', '23', '1');
INSERT INTO `charge_record` VALUES ('21', '1497234286526', '123', '0', '123', '1', '0', '13', '26', '1');
INSERT INTO `charge_record` VALUES ('22', '1497319843388', '100.8', '10750', '10649.2', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('23', '1497320189655', '23', '10649.2', '10626.2', '1', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('24', '1497320189670', '23', '-23', '0', '1', '0', '10', '23', '1');
INSERT INTO `charge_record` VALUES ('30', '1497324711645', '100.8', '10323.8', '10223', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('31', '1497334170959', '100.8', '10323.8', '10223', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('32', '1497334320341', '100.8', '10323.8', '10223', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('33', '1497334589164', '100.8', '10323.8', '10223', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('34', '1497334678719', '100.8', '10323.8', '10223', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('35', '1497335041420', '100.8', '10323.8', '10223', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('36', '1497335072514', '100.8', '10223', '10122.2', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('37', '1497335205009', '100.8', '10122.2', '10021.4', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('38', '1497335350632', '100.8', '10021.4', '9920.6', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('39', '1497341079646', '100.8', '9920.6', '9819.8', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('40', '1497422624876', '100.8', '9819.8', '9719', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('41', '1497502581980', '100.8', '9719', '9618.2', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('42', '1497664802383', '15', '9618.2', '9603.2', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('44', '1497672169552', '50', '9603.2', '9553.2', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('46', '1497673214580', '90', '9553.2', '9463.2', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('51', '1498011543965', '90', '9103.2', '9013.2', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('53', '1498019892416', '90', '9013.2', '8923.2', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('54', '1498020864242', '50', '8923.2', '8873.2', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('55', '1498020864305', '50', '8873.2', '8823.2', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('56', '1498036472826', '-1000', '8823.2', '9823.2', '1', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('57', '1498036472838', '-1000', '1088', '88', '1', '0', '8', '21', '1');
INSERT INTO `charge_record` VALUES ('58', '1498105372504', '90', '9823.2', '9733.2', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('59', '1498105686902', '90', '9733.2', '9643.2', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('60', '1498107512542', '90', '9643.2', '9553.2', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('61', '1498114604746', '1000', '9553.2', '8553.2', '1', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('62', '1498114604752', '1000', '0', '1000', '1', '0', '10', '23', '1');
INSERT INTO `charge_record` VALUES ('63', '1498443661235', '90', '88', '-2', '0', '1', '8', '21', '1');
INSERT INTO `charge_record` VALUES ('64', '1498451844240', '90', '8553.2', '8463.2', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('65', '1498454239884', '90', '-2', '-92', '0', '1', '8', '21', '1');
INSERT INTO `charge_record` VALUES ('66', '1498557176529', '123', '8463.2', '8340.2', '1', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('67', '1498557176568', '123', '-92', '31', '1', '0', '8', '21', '1');
INSERT INTO `charge_record` VALUES ('68', '1498557176595', '123', '8217.2', '8094.2', '1', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('69', '1498557176605', '123', '31', '154', '1', '0', '8', '21', '1');
INSERT INTO `charge_record` VALUES ('70', '1498557588247', '-123', '8094.2', '8217.2', '1', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('71', '1498557588259', '-123', '154', '31', '1', '0', '8', '21', '1');
INSERT INTO `charge_record` VALUES ('72', '1498557605211', '-56', '8340.2', '8396.2', '1', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('73', '1498557605215', '-56', '31', '-25', '1', '0', '8', '21', '1');
INSERT INTO `charge_record` VALUES ('75', '1498709926710', '100', '8396.2', '8296.2', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('76', '1498710206728', '100', '8296.2', '8196.2', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('77', '1498710232235', '100', '8196.2', '8096.2', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('78', '1498710238401', '100', '8096.2', '7996.2', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('79', '1498710239941', '100', '7996.2', '7896.2', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('80', '1498710418569', '100', '7896.2', '7796.2', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('81', '1498710618612', '100', '7796.2', '7696.2', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('82', '1498710793814', '100', '7696.2', '7596.2', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('83', '1498711032309', '100', '7596.2', '7496.2', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('84', '1498711156057', '100', '7496.2', '7396.2', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('85', '1498711174058', '100', '7396.2', '7296.2', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('86', '1498711184556', '100', '7296.2', '7196.2', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('87', '1498711224189', '100', '7196.2', '7096.2', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('88', '1498711397517', '100', '7096.2', '6996.2', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('89', '1498791831345', '25', '6996.2', '6971.2', '1', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('90', '1498791831355', '25', '-25', '0', '1', '0', '8', '21', '1');
INSERT INTO `charge_record` VALUES ('91', '1499676982137', '56', '0', '-56', '1', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('92', '1499676982175', '56', '300', '356', '1', '0', '11', '24', '1');
INSERT INTO `charge_record` VALUES ('94', '1499741844216', '200', '-56', '-256', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('95', '1499741844254', '200', '200', '400', '0', '0', '8', '21', '1');
INSERT INTO `charge_record` VALUES ('96', '1499741905706', '200', '-256', '-456', '0', '1', '2', '4', '1');
INSERT INTO `charge_record` VALUES ('97', '1499741914681', '200', '400', '600', '0', '0', '8', '21', '1');

-- ----------------------------
-- Table structure for `exchange_platform`
-- ----------------------------
DROP TABLE IF EXISTS `exchange_platform`;
CREATE TABLE `exchange_platform` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '平台ID',
  `ep_name` varchar(255) DEFAULT NULL COMMENT '平台名称',
  `ep_purchase_ip` varchar(255) DEFAULT NULL COMMENT '流量订购地址',
  `product_list_ip` varchar(255) DEFAULT NULL COMMENT '产品列表地址',
  `pgdata_check_ip` varchar(255) DEFAULT NULL COMMENT '订单查询地址',
  `ep_balance_ip` varchar(255) DEFAULT NULL COMMENT '余额查询地址',
  `ep_user_name` varchar(255) DEFAULT NULL COMMENT '账号',
  `ep_user_pass` varchar(255) DEFAULT NULL COMMENT '密码',
  `ep_balance` double DEFAULT NULL COMMENT '平台余额',
  `ep_apikey` varchar(255) DEFAULT NULL COMMENT 'apikey',
  `ep_ip` varchar(255) DEFAULT NULL COMMENT '主页地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exchange_platform
-- ----------------------------
INSERT INTO `exchange_platform` VALUES ('1', '迈远', 'http://120.76.194.45:8080/api.aspx', 'http://120.76.194.45:8080/api.aspx', 'http://120.76.194.45:8080/api.aspx', 'http://120.76.194.45:8080/api.aspx', 'ncwz22', '333221', '2000', '48dee3af73174054b3a5f88c58d17d61', 'http://120.76.194.45');
INSERT INTO `exchange_platform` VALUES ('2', '尚通', 'http://120.76.194.45:8080/api.aspx', 'http://120.76.194.45:8080/api.aspx', 'http://120.76.194.45:8080/api.aspx', 'http://120.76.194.45:8080/api.aspx', 'ncwz22', '333221', '3000', '48dee3af73174054b3a5f88c58d17d61', 'http://120.76.194.45');
INSERT INTO `exchange_platform` VALUES ('13', '123', '12', '3', '121', '2', '2', '2123', '12', '3', '2');
INSERT INTO `exchange_platform` VALUES ('18', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `exchange_platform` VALUES ('27', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4');
INSERT INTO `exchange_platform` VALUES ('30', '5', '5', '5', '5', '55', '5', '55', '5', '5', '5');
INSERT INTO `exchange_platform` VALUES ('31', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `exchange_platform` VALUES ('32', 'wzkj', 'http://139.224.70.161:32001/api/v1/sendOrder', 'http://139.224.70.161:32001/api/v1/sendOrder', 'http://139.224.70.161:32001/api/v1/orderState', 'http://139.224.70.161:32001/api/v1/getBalance', 'CS111111', '123456', null, '722c16de0a83e5bd2f988e3c7bc9fee8', 'http://139.224.70.161/');
INSERT INTO `exchange_platform` VALUES ('40', '456', '45', '645', '45', '45', '454', '4', '545', '5', '4');

-- ----------------------------
-- Table structure for `operator_discount`
-- ----------------------------
DROP TABLE IF EXISTS `operator_discount`;
CREATE TABLE `operator_discount` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '费率id',
  `operator_type` int(11) DEFAULT NULL COMMENT '运营商类型',
  `scope_name` varchar(255) DEFAULT NULL COMMENT '所属地区',
  `discount` double DEFAULT NULL COMMENT '该地区折扣',
  `rate_name` varchar(255) DEFAULT NULL COMMENT '费率名称',
  `root_agency_id` int(11) DEFAULT NULL COMMENT '费率所属代理商id',
  `rate_id` bigint(20) DEFAULT NULL COMMENT '费率id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of operator_discount
-- ----------------------------
INSERT INTO `operator_discount` VALUES ('1', '0', '内蒙古自治区', '0.56', '买欧元', '1', null);
INSERT INTO `operator_discount` VALUES ('2', '2', '09', '1', '买欧元', '1', null);
INSERT INTO `operator_discount` VALUES ('3', '2', '13', '1', '买欧元', '1', null);
INSERT INTO `operator_discount` VALUES ('4', '0', '内蒙古自治区', '0.2', '', '1', null);
INSERT INTO `operator_discount` VALUES ('5', '2', '内蒙古自治区', '0.3', '', '1', null);
INSERT INTO `operator_discount` VALUES ('6', '0', '内蒙古自治区', '1', '22', '1', null);
INSERT INTO `operator_discount` VALUES ('7', '0', '福建省', '0.23', '22', '1', null);
INSERT INTO `operator_discount` VALUES ('8', '0', '内蒙古自治区', '0.233', 'fsd', '1', '1');
INSERT INTO `operator_discount` VALUES ('9', '0', '湖北省', '0.22', 'fsd', '1', '1');
INSERT INTO `operator_discount` VALUES ('10', '0', '内蒙古自治区', '0.23', 'fd', '1', '2');
INSERT INTO `operator_discount` VALUES ('11', '0', '湖北省', '0.3', 'fd', '1', '2');
INSERT INTO `operator_discount` VALUES ('12', '0', '北京市', '0.56', '接口', '1', '3');
INSERT INTO `operator_discount` VALUES ('13', '0', '湖北省', '0.23', '接口', '1', '3');
INSERT INTO `operator_discount` VALUES ('14', '1', '山东省', '0.36', 'jz', '1', '4');
INSERT INTO `operator_discount` VALUES ('15', '1', '湖南省', '0.23', 'jz', '1', '4');
INSERT INTO `operator_discount` VALUES ('16', '1', '福建省', '0.23', 'jzk', '1', '5');
INSERT INTO `operator_discount` VALUES ('17', '0', '北京市', '0.45', '45', '1', '6');
INSERT INTO `operator_discount` VALUES ('18', '1', '北京市', '0.45', '45', '1', '6');
INSERT INTO `operator_discount` VALUES ('19', '2', '北京市', '0.45', '45', '1', '6');
INSERT INTO `operator_discount` VALUES ('20', '0', '福建省', '0.85', '456', '4', '7');
INSERT INTO `operator_discount` VALUES ('21', '2', '福建省', '0.73', '456', '4', '7');
INSERT INTO `operator_discount` VALUES ('22', '1', '内蒙古自治区', '0.56', 'hts', '1', '8');
INSERT INTO `operator_discount` VALUES ('23', '0', '江西省', '0.85', '乐信', '1', '9');
INSERT INTO `operator_discount` VALUES ('24', '1', '江西省', '0.65', '乐信', '1', '9');
INSERT INTO `operator_discount` VALUES ('25', '2', '江西省', '0.75', '乐信', '1', '9');
INSERT INTO `operator_discount` VALUES ('26', '0', '北京市', '0.123', 'fs', '4', '10');
INSERT INTO `operator_discount` VALUES ('27', '0', '上海市', '0.56', 'fs', '4', '10');
INSERT INTO `operator_discount` VALUES ('28', '0', '福建省', '1', 'fs', '4', '10');
INSERT INTO `operator_discount` VALUES ('29', '2', '上海市', '0.566', 'fs', '4', '10');
INSERT INTO `operator_discount` VALUES ('30', '0', '浙江省', '0.52', '456rate', '4', '11');
INSERT INTO `operator_discount` VALUES ('31', '0', '浙江省', '0.52', '浙江', '4', '12');
INSERT INTO `operator_discount` VALUES ('32', '2', '江西省', '0.85', '测试', '4', '13');
INSERT INTO `operator_discount` VALUES ('33', '0', '浙江省', '1', '浙江', '4', '14');
INSERT INTO `operator_discount` VALUES ('34', '1', '北京市', '0.25', '浙江', '4', '14');
INSERT INTO `operator_discount` VALUES ('35', '0', '上海市', '0.56', '迈远', '4', '15');
INSERT INTO `operator_discount` VALUES ('36', '2', '北京市', '0.65', '硕朗', '4', '16');
INSERT INTO `operator_discount` VALUES ('37', '0', '内蒙古自治区', '0.56', 'er', '26', '17');
INSERT INTO `operator_discount` VALUES ('38', '0', '福建省', '0.54', '发的', '4', '18');

-- ----------------------------
-- Table structure for `operator_pg_data`
-- ----------------------------
DROP TABLE IF EXISTS `operator_pg_data`;
CREATE TABLE `operator_pg_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'æµé‡åŒ…id',
  `pg_size` int(11) DEFAULT NULL COMMENT '包体大小',
  `pg_price` double DEFAULT NULL COMMENT '包体价格',
  `pg_name` varchar(255) DEFAULT NULL COMMENT 'æµé‡åŒ…ä¸šåŠ¡åç§°ï¼ˆ100å…ƒ3072MB',
  `pg_in_service` int(255) DEFAULT '0' COMMENT 'æµé‡åŒ…å¼€é€šçŠ¶æ€ ï¼ˆ0-å¯ç”¨ 1-å…³é—­ï¼‰',
  `operator_type` int(11) DEFAULT '0' COMMENT '运营商类型（0-移动，1-联通，电信）',
  `operator_name` varchar(255) DEFAULT NULL COMMENT '运营商名称',
  `service_type` int(11) DEFAULT NULL COMMENT '业务类型（0-全国，1-省内，2-省漫游，3-转赠,4-红包）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of operator_pg_data
-- ----------------------------
INSERT INTO `operator_pg_data` VALUES ('1', '6144', '180', '180元6144MB', '1', '0', '中国移动', '0');
INSERT INTO `operator_pg_data` VALUES ('8', '3072', '100', '100元3072MB', '1', '0', '中国移动', '0');
INSERT INTO `operator_pg_data` VALUES ('10', '100', '10', '10元100MB', '1', '1', '中国联通', '0');
INSERT INTO `operator_pg_data` VALUES ('11', '200', '10', '10yuan200m', '1', '1', '中国联通', '1');
INSERT INTO `operator_pg_data` VALUES ('12', '1000', '10', '10yuan1000m', '1', '1', '中国联通', '2');
INSERT INTO `operator_pg_data` VALUES ('13', '500', '30', '移动', '1', '0', '中国移动', '1');
INSERT INTO `operator_pg_data` VALUES ('15', '500', '30', '移动30.0元500MB省漫游', '1', '0', '中国移动', '2');
INSERT INTO `operator_pg_data` VALUES ('16', '500', '30', '移动30.0元500MB全国', '1', '0', '中国移动', '0');
INSERT INTO `operator_pg_data` VALUES ('17', '6144', '180', '联通180.0元6144MB转增', '1', '1', '中国联通', '3');
INSERT INTO `operator_pg_data` VALUES ('18', '6144', '180', '移动180.0元6144MB省漫游', '1', '0', '中国移动', '2');
INSERT INTO `operator_pg_data` VALUES ('19', '500', '30', '移动30.0元500MB省内', '1', '0', '中国移动', '1');

-- ----------------------------
-- Table structure for `product_code`
-- ----------------------------
DROP TABLE IF EXISTS `product_code`;
CREATE TABLE `product_code` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '通道编码ID',
  `product_name` varchar(255) DEFAULT NULL COMMENT '产品编码名称',
  `pg_id` int(11) DEFAULT NULL COMMENT '包体ID',
  `scope_city_code` varchar(255) DEFAULT NULL COMMENT '地区编码',
  `pg_encode_price` double DEFAULT '0' COMMENT '包体编码价格',
  `ep_id` int(11) DEFAULT NULL COMMENT '平台ID',
  `product_code` varchar(255) DEFAULT NULL COMMENT '产品编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_code
-- ----------------------------
INSERT INTO `product_code` VALUES ('1', '江西移动500M全国流量包', '15', '14', '30', '2', 'jx10086500500');
INSERT INTO `product_code` VALUES ('2', null, '1', '32', null, '2', '333333');
INSERT INTO `product_code` VALUES ('3', '全国', '1', '32', null, '2', '1255456');
INSERT INTO `product_code` VALUES ('4', '全国', '10', '32', null, '2', '565656');
INSERT INTO `product_code` VALUES ('5', '江西省', '10', '14', null, '2', '56666');
INSERT INTO `product_code` VALUES ('6', '云南省', '1', '24', null, '13', '11111111111');
INSERT INTO `product_code` VALUES ('7', '全国', '11', '32', null, '13', '22222');
INSERT INTO `product_code` VALUES ('8', '全国', '13', '32', null, '2', '56');
INSERT INTO `product_code` VALUES ('9', '全国', '1', '32', null, '13', '22222222');
INSERT INTO `product_code` VALUES ('10', '全国', '13', '32', null, '2', '555555555');
INSERT INTO `product_code` VALUES ('11', '全国', '1', '32', null, '13', '33333333333');
INSERT INTO `product_code` VALUES ('12', '陕西省', '1', '26', null, '13', '66');
INSERT INTO `product_code` VALUES ('13', '全国', '1', '32', null, '2', 'jx10086500500');
INSERT INTO `product_code` VALUES ('14', '全国', '1', '32', null, '2', '333333');
INSERT INTO `product_code` VALUES ('15', '全国', '1', '32', null, '2', '333333');
INSERT INTO `product_code` VALUES ('16', '全国', '1', '32', null, '2', '333333');
INSERT INTO `product_code` VALUES ('17', '全国', '1', '32', null, '2', '333333');
INSERT INTO `product_code` VALUES ('18', '全国', '1', '32', null, '2', '333333');
INSERT INTO `product_code` VALUES ('19', '全国', '1', '32', null, '2', '333333');
INSERT INTO `product_code` VALUES ('20', '江西省', '1', '14', null, '2', '14100866144');
INSERT INTO `product_code` VALUES ('21', '全国', '16', '32', null, '32', '500');
INSERT INTO `product_code` VALUES ('22', '浙江省', '1', '11', null, '32', '6144');
INSERT INTO `product_code` VALUES ('23', '浙江省', '8', '11', null, '32', '3072');
INSERT INTO `product_code` VALUES ('24', '浙江省', '16', '11', null, '32', '500');
INSERT INTO `product_code` VALUES ('25', '全国', '1', '32', null, '2', '');
INSERT INTO `product_code` VALUES ('26', '四川省', '10', '22', null, '32', '123');
INSERT INTO `product_code` VALUES ('27', '全国', '1', '32', null, '2', '456');

-- ----------------------------
-- Table structure for `purchase`
-- ----------------------------
DROP TABLE IF EXISTS `purchase`;
CREATE TABLE `purchase` (
  `order_id` bigint(20) NOT NULL COMMENT 'è®¢å•å·',
  `order_id_api` varchar(255) DEFAULT NULL COMMENT '其他系统返回的订单id',
  `root_agency_id` int(11) DEFAULT NULL COMMENT '订单所属代理商',
  `agency_id` int(11) DEFAULT NULL COMMENT 'ä»£ç†idï¼ˆå¤–é”®ï¼‰',
  `charge_tel` varchar(255) DEFAULT NULL COMMENT 'æ‰‹æœºå·',
  `pg_id` int(11) DEFAULT NULL COMMENT 'æµé‡åŒ…idï¼ˆå¤–é”®ï¼‰',
  `order_arrive_time` bigint(20) DEFAULT NULL COMMENT 'æäº¤æ—¶é—´ï¼ˆæœ¬å¹³å°èŽ·å¾—è¯¥æ•°æ®è¯·æ±‚çš„æ—¶é—´ï¼‰',
  `order_back_time` bigint(20) DEFAULT NULL COMMENT 'å……å€¼æ—¶é—´ï¼ˆæœ¬å¹³å°èŽ·å¾—è¿”å›žç»“æžœï¼‰',
  `charge_tel_detail` varchar(255) DEFAULT NULL COMMENT 'å·ç å½’å±žï¼ˆï¼šæ±Ÿè¥¿ç§»åŠ¨ï¼‰',
  `charge_tel_city` varchar(255) DEFAULT NULL COMMENT 'å·ç å½’å±žå…·ä½“åŸŽå¸‚',
  `order_platform_path` int(11) DEFAULT NULL COMMENT 'å……å€¼æ–¹å¼(0-æŽ¥å£ï¼Œ1-æœ¬å¹³å°)',
  `order_result` int(11) DEFAULT NULL COMMENT 'ç»“æžœï¼ˆenum:ï¼‰',
  `channel_id` int(11) DEFAULT NULL COMMENT 'é€šé“idï¼ˆå¤–é”®ï¼‰',
  `order_result_detail` varchar(255) DEFAULT NULL COMMENT 'ç»“æžœæè¿°',
  `order_amount` double DEFAULT NULL COMMENT '充值金额(扣款）',
  `record_id` bigint(20) DEFAULT NULL COMMENT '消费记录id',
  `bill_type` int(11) DEFAULT NULL COMMENT '票务类型（0-无票，1-带票）',
  PRIMARY KEY (`order_id`),
  KEY `record_join_purchase` (`record_id`),
  CONSTRAINT `record_join_purchase` FOREIGN KEY (`record_id`) REFERENCES `charge_record` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of purchase
-- ----------------------------
INSERT INTO `purchase` VALUES ('703710166008205312', '20170622122808967868', '4', '4', '15858343638', '1', '1498105686877', '1498105689000', '浙江移动', '嘉兴', '0', '4', '35', '未充', '90', '46', '0');
INSERT INTO `purchase` VALUES ('703717823528046592', '20170622125834883058', '4', '4', '15858343638', '1', '1498107512532', '1498107514000', '浙江移动', '嘉兴', '0', '4', '35', '未充', '90', null, '0');
INSERT INTO `purchase` VALUES ('704535206018686976', '20170624190623128150', null, '21', '15858343638', '1', null, '1498302381513', '浙江移动', '嘉兴', '1', '1', '38', '欠费等待', '93.6', null, '0');
INSERT INTO `purchase` VALUES ('704544611741212672', '20170624194216502396', null, '21', '15858343638', '1', '1498304515178', '1498304537000', '浙江移动', '嘉兴', '1', '0', '39', '失败', '93.6', null, '0');
INSERT INTO `purchase` VALUES ('705126212669808640', '20170626101458398987', '4', '21', '15858343638', '1', '1498443287474', '1498443298000', '浙江移动', '嘉兴', '1', '4', '39', '未充', '93.6', null, '0');
INSERT INTO `purchase` VALUES ('705127733130170368', '20170626102101696623', '21', '21', '15858343638', '1', '1498443661235', '1498443661000', '浙江移动', '嘉兴', '0', '0', '39', '失败', '90', null, '0');
INSERT INTO `purchase` VALUES ('705129750095470592', '20170626102901656910', '4', '21', '15858343638', '1', '1498444085497', '1498444142000', '浙江移动', '嘉兴', '1', '4', '39', '未充', '93.6', null, '0');
INSERT INTO `purchase` VALUES ('705133259956166656', '20170626104258028713', '4', '21', '15858343638', '1', '1498444954103', '1498444979000', '浙江移动', '嘉兴', '1', '4', '39', '未充', '93.6', null, '0');
INSERT INTO `purchase` VALUES ('705162055119802368', '20170626123724333015', '4', '4', '15858343638', '1', '1498451844217', '1498451844000', '浙江移动', '嘉兴', '0', '4', '35', '未充', '90', null, '0');
INSERT INTO `purchase` VALUES ('705172103195791360', '20170626131720748968', '21', '21', '15858343638', '1', '1498454239867', '1498454240000', '浙江移动', '嘉兴', '0', '0', '39', '失败', '90', null, '0');
INSERT INTO `purchase` VALUES ('705499613372620800', null, null, null, '15858343638', '1', '1498532288078', null, '浙江移动', '嘉兴', null, null, null, null, '93.6', null, '0');

-- ----------------------------
-- Table structure for `rate_backward`
-- ----------------------------
DROP TABLE IF EXISTS `rate_backward`;
CREATE TABLE `rate_backward` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '费率id',
  `rate_name` varchar(255) DEFAULT NULL COMMENT '费率名称',
  `root_agency_id` int(11) DEFAULT NULL COMMENT '上一级代理商id',
  `rate_price_0` varchar(255) DEFAULT '' COMMENT '费率价格（折扣）-移动',
  `rate_price_1` varchar(255) DEFAULT NULL COMMENT '费率价格（折扣）-联通',
  `rate_price_2` varchar(255) DEFAULT NULL COMMENT '费率价格（折扣）-电信',
  `rate_state` int(11) DEFAULT NULL COMMENT '状态（0-正常，1-暂停）',
  `bill_type` int(2) DEFAULT NULL COMMENT '票务类型（1-对公，0-对私）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rate_backward
-- ----------------------------
INSERT INTO `rate_backward` VALUES ('0', 'fd', '1', '{\"内蒙古自治区\":0.23,\"湖北省\":0.3}', null, null, '0', '0');
INSERT INTO `rate_backward` VALUES ('1', 'fsd', '1', '{\"内蒙古自治区\":\"0.233\",\"湖北省\":\"0.22\"}', null, null, '0', '0');
INSERT INTO `rate_backward` VALUES ('3', '接口', '1', '{\"北京市\":0.56,\"湖北省\":0.23}', null, null, '0', '0');
INSERT INTO `rate_backward` VALUES ('4', 'jz', '1', '{\"湖南省\":0.23,\"山东省\":0.36}', null, null, '0', '0');
INSERT INTO `rate_backward` VALUES ('5', 'jzk', '1', null, '{\"福建省\":0.23}', null, '0', '0');
INSERT INTO `rate_backward` VALUES ('6', '45', '1', '{\"北京市\":0.45}', '{\"北京市\":0.45}', '{\"北京市\":0.45}', '0', '0');
INSERT INTO `rate_backward` VALUES ('7', '456', '4', '{\"福建省\":0.85}', null, '{\"福建省\":0.73}', '0', '0');
INSERT INTO `rate_backward` VALUES ('8', 'hts', '1', null, '{\"内蒙古自治区\":0.56}', null, '0', '1');
INSERT INTO `rate_backward` VALUES ('9', '乐信', '1', '{\"江西省\":0.85}', '{\"江西省\":0.65}', '{\"江西省\":0.75}', '0', '1');
INSERT INTO `rate_backward` VALUES ('10', 'fs', '4', '{\"上海市\":0.56,\"福建省\":1,\"北京市\":0.123}', null, '{\"上海市\":0.566}', '0', '1');
INSERT INTO `rate_backward` VALUES ('11', '456rate', '4', '{\"浙江省\":0.52}', null, null, '0', '1');
INSERT INTO `rate_backward` VALUES ('12', '浙江', '4', '{\"浙江省\":0.52}', null, null, '0', '1');
INSERT INTO `rate_backward` VALUES ('13', '测试', '4', null, null, '{\"江西省\":0.85}', '0', '1');
INSERT INTO `rate_backward` VALUES ('14', '浙江', '4', '{\"浙江省\":1}', '{\"北京市\":0.25}', null, '0', '1');
INSERT INTO `rate_backward` VALUES ('15', '迈远', '4', '{\"上海市\":0.56}', null, null, '0', '0');
INSERT INTO `rate_backward` VALUES ('16', '硕朗', '4', null, null, '{\"北京市\":0.65}', '0', '1');
INSERT INTO `rate_backward` VALUES ('17', 'er', '26', '{\"内蒙古自治区\":0.56}', null, null, '0', '0');
INSERT INTO `rate_backward` VALUES ('18', '发的', '4', '{\"福建省\":0.54}', null, null, '0', '0');

-- ----------------------------
-- Table structure for `rate_discount`
-- ----------------------------
DROP TABLE IF EXISTS `rate_discount`;
CREATE TABLE `rate_discount` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '通道折扣id',
  `active_discount` double DEFAULT NULL COMMENT '费率折扣',
  `active_id` bigint(20) DEFAULT NULL COMMENT '活动通道连接id',
  `channel_discount_id` bigint(20) DEFAULT NULL,
  `bill_type` int(11) DEFAULT NULL COMMENT '是否带票（0-一般不带票，1-带票高级）',
  PRIMARY KEY (`id`),
  KEY `active_discount_fk` (`active_id`),
  KEY `fk_channel_dis_rate` (`channel_discount_id`),
  CONSTRAINT `fk_channel_dis_rate` FOREIGN KEY (`channel_discount_id`) REFERENCES `channel_discount` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rate_discount
-- ----------------------------
INSERT INTO `rate_discount` VALUES ('1', '0.95', '1', '12', '1');
INSERT INTO `rate_discount` VALUES ('2', null, '2', '12', '1');
INSERT INTO `rate_discount` VALUES ('3', '85', '3', '12', '1');
INSERT INTO `rate_discount` VALUES ('4', '87', '4', '12', '1');
INSERT INTO `rate_discount` VALUES ('5', '0.14', '5', '12', '1');
INSERT INTO `rate_discount` VALUES ('6', '0.111', '6', '12', '1');
INSERT INTO `rate_discount` VALUES ('7', '0.56', '7', '12', '0');
INSERT INTO `rate_discount` VALUES ('8', '0.12', '8', '12', '1');
INSERT INTO `rate_discount` VALUES ('9', '0.13', '9', '12', '1');
INSERT INTO `rate_discount` VALUES ('10', '0.445', '13', '12', '1');
INSERT INTO `rate_discount` VALUES ('11', '0.56', '14', '12', '1');
INSERT INTO `rate_discount` VALUES ('12', '0.85', '15', '12', '1');
INSERT INTO `rate_discount` VALUES ('13', '0.65', '16', '12', '1');
INSERT INTO `rate_discount` VALUES ('14', '0.116', '17', '12', '1');
INSERT INTO `rate_discount` VALUES ('16', '0.11', '19', '12', '1');
INSERT INTO `rate_discount` VALUES ('18', '0.85', null, null, '1');
INSERT INTO `rate_discount` VALUES ('19', '0.99', null, '12', '1');
INSERT INTO `rate_discount` VALUES ('22', '0.83', null, '13', '1');
INSERT INTO `rate_discount` VALUES ('23', '0.71', null, '8', '1');
INSERT INTO `rate_discount` VALUES ('24', '0.89', null, '7', '1');
INSERT INTO `rate_discount` VALUES ('25', '0.88', null, null, '1');
INSERT INTO `rate_discount` VALUES ('26', '0.72', null, '8', '1');
INSERT INTO `rate_discount` VALUES ('27', '0.75', null, '8', '1');
INSERT INTO `rate_discount` VALUES ('28', '0.88', null, '7', '1');
INSERT INTO `rate_discount` VALUES ('29', '89', null, '11', '1');
INSERT INTO `rate_discount` VALUES ('30', '88', null, '11', '1');
INSERT INTO `rate_discount` VALUES ('32', '0.6', null, '15', '1');
INSERT INTO `rate_discount` VALUES ('33', '0.99', null, '12', '0');
INSERT INTO `rate_discount` VALUES ('34', '0.98', null, '12', '1');
INSERT INTO `rate_discount` VALUES ('35', '0.78', null, '8', '1');
INSERT INTO `rate_discount` VALUES ('36', '0.88', null, '13', '1');
INSERT INTO `rate_discount` VALUES ('37', '0.87', null, '13', '1');
INSERT INTO `rate_discount` VALUES ('38', '0.87', null, '7', '1');

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

-- ----------------------------
-- Table structure for `service_scope`
-- ----------------------------
DROP TABLE IF EXISTS `service_scope`;
CREATE TABLE `service_scope` (
  `id` varchar(255) NOT NULL DEFAULT '' COMMENT '业务id',
  `scope_city_code` varchar(255) DEFAULT NULL COMMENT '包城市编码',
  `scope_city_name` varchar(255) DEFAULT NULL COMMENT '包城市名',
  `service_type` int(11) DEFAULT NULL COMMENT '业务类型（0-全国，1-省内，2-省漫游，3-转赠，4-红包,5-日包）',
  `operator_type` int(11) DEFAULT '0' COMMENT '运营商类型（0-移动，1-联通，2-电信）',
  `operator_name` varchar(255) DEFAULT NULL COMMENT '流量包运营商名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of service_scope
-- ----------------------------
INSERT INTO `service_scope` VALUES ('0100', '01', '北京市', '0', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0101', '01', '北京市', '1', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0102', '01', '北京市', '2', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0103', '01', '北京市', '3', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0104', '01', '北京市', '4', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0110', '01', '北京市', '0', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0111', '01', '北京市', '1', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0112', '01', '北京市', '2', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0113', '01', '北京市', '3', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0114', '01', '北京市', '4', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0120', '01', '北京市', '0', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0121', '01', '北京市', '1', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0122', '01', '北京市', '2', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0123', '01', '北京市', '3', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0124', '01', '北京市', '4', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0200', '02', '天津市', '0', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0201', '02', '天津市', '1', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0202', '02', '天津市', '2', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0203', '02', '天津市', '3', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0204', '02', '天津市', '4', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0210', '02', '天津市', '0', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0211', '02', '天津市', '1', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0212', '02', '天津市', '2', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0213', '02', '天津市', '3', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0214', '02', '天津市', '4', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0220', '02', '天津市', '0', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0221', '02', '天津市', '1', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0222', '02', '天津市', '2', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0223', '02', '天津市', '3', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0224', '02', '天津市', '4', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0300', '03', '河北省', '0', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0301', '03', '河北省', '1', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0302', '03', '河北省', '2', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0303', '03', '河北省', '3', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0304', '03', '河北省', '4', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0310', '03', '河北省', '0', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0311', '03', '河北省', '1', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0312', '03', '河北省', '2', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0313', '03', '河北省', '3', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0314', '03', '河北省', '4', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0320', '03', '河北省', '0', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0321', '03', '河北省', '1', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0322', '03', '河北省', '2', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0323', '03', '河北省', '3', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0324', '03', '河北省', '4', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0400', '04', '山西省', '0', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0401', '04', '山西省', '1', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0402', '04', '山西省', '2', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0403', '04', '山西省', '3', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0404', '04', '山西省', '4', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0410', '04', '山西省', '0', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0411', '04', '山西省', '1', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0412', '04', '山西省', '2', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0413', '04', '山西省', '3', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0414', '04', '山西省', '4', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0420', '04', '山西省', '0', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0421', '04', '山西省', '1', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0422', '04', '山西省', '2', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0423', '04', '山西省', '3', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0424', '04', '山西省', '4', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0500', '05', '内蒙古自治区', '0', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0501', '05', '内蒙古自治区', '1', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0502', '05', '内蒙古自治区', '2', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0503', '05', '内蒙古自治区', '3', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0504', '05', '内蒙古自治区', '4', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0510', '05', '内蒙古自治区', '0', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0511', '05', '内蒙古自治区', '1', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0512', '05', '内蒙古自治区', '2', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0513', '05', '内蒙古自治区', '3', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0514', '05', '内蒙古自治区', '4', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0520', '05', '内蒙古自治区', '0', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0521', '05', '内蒙古自治区', '1', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0522', '05', '内蒙古自治区', '2', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0523', '05', '内蒙古自治区', '3', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0524', '05', '内蒙古自治区', '4', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0600', '06', '辽宁省', '0', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0601', '06', '辽宁省', '1', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0602', '06', '辽宁省', '2', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0603', '06', '辽宁省', '3', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0604', '06', '辽宁省', '4', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0610', '06', '辽宁省', '0', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0611', '06', '辽宁省', '1', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0612', '06', '辽宁省', '2', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0613', '06', '辽宁省', '3', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0614', '06', '辽宁省', '4', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0620', '06', '辽宁省', '0', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0621', '06', '辽宁省', '1', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0622', '06', '辽宁省', '2', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0623', '06', '辽宁省', '3', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0624', '06', '辽宁省', '4', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0700', '07', '吉林省', '0', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0701', '07', '吉林省', '1', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0702', '07', '吉林省', '2', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0703', '07', '吉林省', '3', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0704', '07', '吉林省', '4', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0710', '07', '吉林省', '0', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0711', '07', '吉林省', '1', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0712', '07', '吉林省', '2', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0713', '07', '吉林省', '3', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0714', '07', '吉林省', '4', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0720', '07', '吉林省', '0', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0721', '07', '吉林省', '1', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0722', '07', '吉林省', '2', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0723', '07', '吉林省', '3', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0724', '07', '吉林省', '4', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0800', '08', '黑龙江省', '0', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0801', '08', '黑龙江省', '1', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0802', '08', '黑龙江省', '2', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0803', '08', '黑龙江省', '3', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0804', '08', '黑龙江省', '4', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0810', '08', '黑龙江省', '0', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0811', '08', '黑龙江省', '1', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0812', '08', '黑龙江省', '2', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0813', '08', '黑龙江省', '3', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0814', '08', '黑龙江省', '4', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0820', '08', '黑龙江省', '0', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0821', '08', '黑龙江省', '1', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0822', '08', '黑龙江省', '2', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0823', '08', '黑龙江省', '3', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0824', '08', '黑龙江省', '4', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0900', '09', '上海市', '0', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0901', '09', '上海市', '1', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0902', '09', '上海市', '2', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0903', '09', '上海市', '3', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0904', '09', '上海市', '4', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('0910', '09', '上海市', '0', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0911', '09', '上海市', '1', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0912', '09', '上海市', '2', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0913', '09', '上海市', '3', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0914', '09', '上海市', '4', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('0920', '09', '上海市', '0', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0921', '09', '上海市', '1', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0922', '09', '上海市', '2', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0923', '09', '上海市', '3', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('0924', '09', '上海市', '4', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1000', '10', '江苏省', '0', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1001', '10', '江苏省', '1', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1002', '10', '江苏省', '2', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1003', '10', '江苏省', '3', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1004', '10', '江苏省', '4', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1010', '10', '江苏省', '0', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1011', '10', '江苏省', '1', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1012', '10', '江苏省', '2', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1013', '10', '江苏省', '3', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1014', '10', '江苏省', '4', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1020', '10', '江苏省', '0', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1021', '10', '江苏省', '1', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1022', '10', '江苏省', '2', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1023', '10', '江苏省', '3', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1024', '10', '江苏省', '4', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1100', '11', '浙江省', '0', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1101', '11', '浙江省', '1', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1102', '11', '浙江省', '2', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1103', '11', '浙江省', '3', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1104', '11', '浙江省', '4', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1110', '11', '浙江省', '0', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1111', '11', '浙江省', '1', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1112', '11', '浙江省', '2', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1113', '11', '浙江省', '3', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1114', '11', '浙江省', '4', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1120', '11', '浙江省', '0', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1121', '11', '浙江省', '1', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1122', '11', '浙江省', '2', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1123', '11', '浙江省', '3', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1124', '11', '浙江省', '4', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1200', '12', '安徽省', '0', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1201', '12', '安徽省', '1', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1202', '12', '安徽省', '2', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1203', '12', '安徽省', '3', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1204', '12', '安徽省', '4', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1210', '12', '安徽省', '0', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1211', '12', '安徽省', '1', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1212', '12', '安徽省', '2', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1213', '12', '安徽省', '3', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1214', '12', '安徽省', '4', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1220', '12', '安徽省', '0', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1221', '12', '安徽省', '1', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1222', '12', '安徽省', '2', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1223', '12', '安徽省', '3', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1224', '12', '安徽省', '4', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1300', '13', '福建省', '0', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1301', '13', '福建省', '1', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1302', '13', '福建省', '2', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1303', '13', '福建省', '3', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1304', '13', '福建省', '4', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1310', '13', '福建省', '0', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1311', '13', '福建省', '1', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1312', '13', '福建省', '2', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1313', '13', '福建省', '3', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1314', '13', '福建省', '4', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1320', '13', '福建省', '0', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1321', '13', '福建省', '1', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1322', '13', '福建省', '2', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1323', '13', '福建省', '3', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1324', '13', '福建省', '4', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1400', '14', '江西省', '0', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1401', '14', '江西省', '1', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1402', '14', '江西省', '2', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1403', '14', '江西省', '3', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1404', '14', '江西省', '4', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1410', '14', '江西省', '0', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1411', '14', '江西省', '1', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1412', '14', '江西省', '2', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1413', '14', '江西省', '3', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1414', '14', '江西省', '4', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1420', '14', '江西省', '0', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1421', '14', '江西省', '1', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1422', '14', '江西省', '2', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1423', '14', '江西省', '3', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1424', '14', '江西省', '4', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1500', '15', '山东省', '0', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1501', '15', '山东省', '1', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1502', '15', '山东省', '2', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1503', '15', '山东省', '3', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1504', '15', '山东省', '4', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1510', '15', '山东省', '0', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1511', '15', '山东省', '1', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1512', '15', '山东省', '2', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1513', '15', '山东省', '3', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1514', '15', '山东省', '4', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1520', '15', '山东省', '0', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1521', '15', '山东省', '1', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1522', '15', '山东省', '2', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1523', '15', '山东省', '3', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1524', '15', '山东省', '4', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1600', '16', '河南省', '0', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1601', '16', '河南省', '1', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1602', '16', '河南省', '2', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1603', '16', '河南省', '3', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1604', '16', '河南省', '4', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1610', '16', '河南省', '0', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1611', '16', '河南省', '1', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1612', '16', '河南省', '2', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1613', '16', '河南省', '3', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1614', '16', '河南省', '4', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1620', '16', '河南省', '0', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1621', '16', '河南省', '1', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1622', '16', '河南省', '2', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1623', '16', '河南省', '3', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1624', '16', '河南省', '4', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1700', '17', '湖北省', '0', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1701', '17', '湖北省', '1', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1702', '17', '湖北省', '2', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1703', '17', '湖北省', '3', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1704', '17', '湖北省', '4', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1710', '17', '湖北省', '0', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1711', '17', '湖北省', '1', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1712', '17', '湖北省', '2', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1713', '17', '湖北省', '3', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1714', '17', '湖北省', '4', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1720', '17', '湖北省', '0', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1721', '17', '湖北省', '1', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1722', '17', '湖北省', '2', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1723', '17', '湖北省', '3', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1724', '17', '湖北省', '4', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1800', '18', '湖南省', '0', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1801', '18', '湖南省', '1', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1802', '18', '湖南省', '2', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1803', '18', '湖南省', '3', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1804', '18', '湖南省', '4', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1810', '18', '湖南省', '0', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1811', '18', '湖南省', '1', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1812', '18', '湖南省', '2', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1813', '18', '湖南省', '3', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1814', '18', '湖南省', '4', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1820', '18', '湖南省', '0', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1821', '18', '湖南省', '1', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1822', '18', '湖南省', '2', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1823', '18', '湖南省', '3', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1824', '18', '湖南省', '4', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1900', '19', '广东省', '0', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1901', '19', '广东省', '1', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1902', '19', '广东省', '2', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1903', '19', '广东省', '3', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1904', '19', '广东省', '4', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('1910', '19', '广东省', '0', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1911', '19', '广东省', '1', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1912', '19', '广东省', '2', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1913', '19', '广东省', '3', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1914', '19', '广东省', '4', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('1920', '19', '广东省', '0', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1921', '19', '广东省', '1', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1922', '19', '广东省', '2', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1923', '19', '广东省', '3', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('1924', '19', '广东省', '4', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2000', '20', '广西壮族自治区', '0', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2001', '20', '广西壮族自治区', '1', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2002', '20', '广西壮族自治区', '2', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2003', '20', '广西壮族自治区', '3', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2004', '20', '广西壮族自治区', '4', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2010', '20', '广西壮族自治区', '0', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2011', '20', '广西壮族自治区', '1', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2012', '20', '广西壮族自治区', '2', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2013', '20', '广西壮族自治区', '3', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2014', '20', '广西壮族自治区', '4', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2020', '20', '广西壮族自治区', '0', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2021', '20', '广西壮族自治区', '1', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2022', '20', '广西壮族自治区', '2', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2023', '20', '广西壮族自治区', '3', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2024', '20', '广西壮族自治区', '4', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2100', '21', '海南省', '0', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2101', '21', '海南省', '1', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2102', '21', '海南省', '2', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2103', '21', '海南省', '3', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2104', '21', '海南省', '4', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2110', '21', '海南省', '0', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2111', '21', '海南省', '1', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2112', '21', '海南省', '2', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2113', '21', '海南省', '3', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2114', '21', '海南省', '4', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2120', '21', '海南省', '0', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2121', '21', '海南省', '1', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2122', '21', '海南省', '2', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2123', '21', '海南省', '3', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2124', '21', '海南省', '4', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2200', '22', '四川省', '0', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2201', '22', '四川省', '1', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2202', '22', '四川省', '2', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2203', '22', '四川省', '3', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2204', '22', '四川省', '4', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2210', '22', '四川省', '0', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2211', '22', '四川省', '1', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2212', '22', '四川省', '2', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2213', '22', '四川省', '3', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2214', '22', '四川省', '4', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2220', '22', '四川省', '0', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2221', '22', '四川省', '1', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2222', '22', '四川省', '2', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2223', '22', '四川省', '3', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2224', '22', '四川省', '4', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2300', '23', '贵州省', '0', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2301', '23', '贵州省', '1', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2302', '23', '贵州省', '2', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2303', '23', '贵州省', '3', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2304', '23', '贵州省', '4', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2310', '23', '贵州省', '0', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2311', '23', '贵州省', '1', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2312', '23', '贵州省', '2', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2313', '23', '贵州省', '3', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2314', '23', '贵州省', '4', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2320', '23', '贵州省', '0', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2321', '23', '贵州省', '1', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2322', '23', '贵州省', '2', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2323', '23', '贵州省', '3', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2324', '23', '贵州省', '4', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2400', '24', '云南省', '0', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2401', '24', '云南省', '1', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2402', '24', '云南省', '2', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2403', '24', '云南省', '3', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2404', '24', '云南省', '4', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2410', '24', '云南省', '0', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2411', '24', '云南省', '1', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2412', '24', '云南省', '2', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2413', '24', '云南省', '3', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2414', '24', '云南省', '4', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2420', '24', '云南省', '0', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2421', '24', '云南省', '1', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2422', '24', '云南省', '2', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2423', '24', '云南省', '3', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2424', '24', '云南省', '4', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2500', '25', '西藏自治区', '0', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2501', '25', '西藏自治区', '1', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2502', '25', '西藏自治区', '2', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2503', '25', '西藏自治区', '3', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2504', '25', '西藏自治区', '4', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2510', '25', '西藏自治区', '0', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2511', '25', '西藏自治区', '1', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2512', '25', '西藏自治区', '2', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2513', '25', '西藏自治区', '3', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2514', '25', '西藏自治区', '4', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2520', '25', '西藏自治区', '0', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2521', '25', '西藏自治区', '1', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2522', '25', '西藏自治区', '2', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2523', '25', '西藏自治区', '3', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2524', '25', '西藏自治区', '4', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2600', '26', '陕西省', '0', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2601', '26', '陕西省', '1', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2602', '26', '陕西省', '2', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2603', '26', '陕西省', '3', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2604', '26', '陕西省', '4', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2610', '26', '陕西省', '0', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2611', '26', '陕西省', '1', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2612', '26', '陕西省', '2', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2613', '26', '陕西省', '3', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2614', '26', '陕西省', '4', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2620', '26', '陕西省', '0', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2621', '26', '陕西省', '1', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2622', '26', '陕西省', '2', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2623', '26', '陕西省', '3', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2624', '26', '陕西省', '4', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2700', '27', '甘肃省', '0', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2701', '27', '甘肃省', '1', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2702', '27', '甘肃省', '2', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2703', '27', '甘肃省', '3', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2704', '27', '甘肃省', '4', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2710', '27', '甘肃省', '0', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2711', '27', '甘肃省', '1', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2712', '27', '甘肃省', '2', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2713', '27', '甘肃省', '3', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2714', '27', '甘肃省', '4', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2720', '27', '甘肃省', '0', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2721', '27', '甘肃省', '1', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2722', '27', '甘肃省', '2', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2723', '27', '甘肃省', '3', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2724', '27', '甘肃省', '4', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2800', '28', '青海省', '0', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2801', '28', '青海省', '1', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2802', '28', '青海省', '2', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2803', '28', '青海省', '3', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2804', '28', '青海省', '4', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2810', '28', '青海省', '0', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2811', '28', '青海省', '1', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2812', '28', '青海省', '2', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2813', '28', '青海省', '3', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2814', '28', '青海省', '4', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2820', '28', '青海省', '0', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2821', '28', '青海省', '1', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2822', '28', '青海省', '2', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2823', '28', '青海省', '3', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2824', '28', '青海省', '4', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2900', '29', '宁夏回族自治区', '0', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2901', '29', '宁夏回族自治区', '1', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2902', '29', '宁夏回族自治区', '2', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2903', '29', '宁夏回族自治区', '3', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2904', '29', '宁夏回族自治区', '4', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('2910', '29', '宁夏回族自治区', '0', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2911', '29', '宁夏回族自治区', '1', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2912', '29', '宁夏回族自治区', '2', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2913', '29', '宁夏回族自治区', '3', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2914', '29', '宁夏回族自治区', '4', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('2920', '29', '宁夏回族自治区', '0', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2921', '29', '宁夏回族自治区', '1', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2922', '29', '宁夏回族自治区', '2', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2923', '29', '宁夏回族自治区', '3', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('2924', '29', '宁夏回族自治区', '4', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('3000', '30', '新疆维吾尔自治区', '0', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('3001', '30', '新疆维吾尔自治区', '1', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('3002', '30', '新疆维吾尔自治区', '2', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('3003', '30', '新疆维吾尔自治区', '3', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('3004', '30', '新疆维吾尔自治区', '4', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('3010', '30', '新疆维吾尔自治区', '0', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('3011', '30', '新疆维吾尔自治区', '1', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('3012', '30', '新疆维吾尔自治区', '2', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('3013', '30', '新疆维吾尔自治区', '3', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('3014', '30', '新疆维吾尔自治区', '4', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('3020', '30', '新疆维吾尔自治区', '0', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('3021', '30', '新疆维吾尔自治区', '1', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('3022', '30', '新疆维吾尔自治区', '2', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('3023', '30', '新疆维吾尔自治区', '3', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('3024', '30', '新疆维吾尔自治区', '4', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('3100', '31', '重庆市', '0', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('3101', '31', '重庆市', '1', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('3102', '31', '重庆市', '2', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('3103', '31', '重庆市', '3', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('3104', '31', '重庆市', '4', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('3110', '31', '重庆市', '0', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('3111', '31', '重庆市', '1', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('3112', '31', '重庆市', '2', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('3113', '31', '重庆市', '3', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('3114', '31', '重庆市', '4', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('3120', '31', '重庆市', '0', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('3121', '31', '重庆市', '1', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('3122', '31', '重庆市', '2', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('3123', '31', '重庆市', '3', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('3124', '31', '重庆市', '4', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('3200', '32', '全国', '0', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('3201', '32', '全国', '1', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('3202', '32', '全国', '2', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('3203', '32', '全国', '3', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('3204', '32', '全国', '4', '0', '中国移动');
INSERT INTO `service_scope` VALUES ('3210', '32', '全国', '0', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('3211', '32', '全国', '1', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('3212', '32', '全国', '2', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('3213', '32', '全国', '3', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('3214', '32', '全国', '4', '1', '中国联通');
INSERT INTO `service_scope` VALUES ('3220', '32', '全国', '0', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('3221', '32', '全国', '1', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('3222', '32', '全国', '2', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('3223', '32', '全国', '3', '2', '中国电信');
INSERT INTO `service_scope` VALUES ('3224', '32', '全国', '4', '2', '中国电信');

-- ----------------------------
-- Table structure for `t_b`
-- ----------------------------
DROP TABLE IF EXISTS `t_b`;
CREATE TABLE `t_b` (
  `id` int(11) NOT NULL DEFAULT '0' COMMENT '平台ID',
  `ep_name` varchar(255) DEFAULT NULL COMMENT '平台名称',
  `count(*)` bigint(21) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_b
-- ----------------------------
INSERT INTO `t_b` VALUES ('28', '12', '2');
INSERT INTO `t_b` VALUES ('19', '2', '2');
INSERT INTO `t_b` VALUES ('21', '3', '4');
INSERT INTO `t_b` VALUES ('25', '33', '2');
INSERT INTO `t_b` VALUES ('14', 'wzkj', '4');
