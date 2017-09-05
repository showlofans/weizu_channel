/*
Navicat MySQL Data Transfer

Source Server         : home
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : rate_channel

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2017-09-05 18:11:44
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
  CONSTRAINT `channel_agency_fk` FOREIGN KEY (`rate_discount_id`) REFERENCES `rate_discount` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of agency_active_rate
-- ----------------------------
INSERT INTO `agency_active_rate` VALUES ('71', '25', '1', '58', '0', 'lexin', '1504257992220');
INSERT INTO `agency_active_rate` VALUES ('72', '4', '1', '58', '1', '123', '1504258025996');
INSERT INTO `agency_active_rate` VALUES ('75', '4', '1', '75', '0', '123', '1504602330259');
INSERT INTO `agency_active_rate` VALUES ('76', '4', '1', '76', '0', '123', '1504602462106');

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
  `other_contact` varchar(255) DEFAULT NULL COMMENT '其他联系方式（qq号）',
  `user_email` varchar(255) DEFAULT NULL COMMENT 'è”ç³»é‚®ç®±',
  `agency_ip` varchar(255) DEFAULT NULL COMMENT 'ä»£ç†å•†ç³»ç»Ÿè®¿é—®ipåœ°å€',
  `rate_id` bigint(11) DEFAULT NULL COMMENT '不带票费率id',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `verify_code` varchar(255) DEFAULT NULL COMMENT '注册邀请码',
  `user_api_key` varchar(32) DEFAULT NULL COMMENT '用户系统对接平台的apikey',
  `agency_tag` int(20) DEFAULT NULL COMMENT '代理商类型（0-平台用户，1,-接口用户）',
  `call_back_ip` varchar(255) DEFAULT NULL COMMENT '回调地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of agency_backward
-- ----------------------------
INSERT INTO `agency_backward` VALUES ('1', '0', 'xiao', 'xiao', 'xiaoqiang', '', '1575326411', '', '', null, '1495689716779', 'FV', null, '0', null);
INSERT INTO `agency_backward` VALUES ('4', '1', '123', '123', '木头人', '15858343638', '1727661035', '22222', '22', '3', '1499736896474', 'VEPX', '402881e85de51dec015de51dec180000', '1', null);
INSERT INTO `agency_backward` VALUES ('21', '4', '456', '123', '123', '123', '1575326411', '123@123.com', '1233', null, '1500523402299', 'H769', '402880ef5cd2b925015cd2b925b90000', '1', null);
INSERT INTO `agency_backward` VALUES ('23', '4', 'w', 'w', 'w', 'w', '1575326411', 'w@d.com', 'f', null, '1500519015597', 'H65M', '402880ef5cd2b925015cd2bc11d70001', '1', null);
INSERT INTO `agency_backward` VALUES ('24', '4', 'kkk', 'kkk', 'kkk', 'kkk', '1575326411', 'kkk@qq.com', 'kkk', '7', '1498617873998', '7L4T', '402880ef5cd2b925015cd2bc5d130002', '1', null);
INSERT INTO `agency_backward` VALUES ('25', '1', 'lexin', 'lexin', '乐信', '13699562589', '1575326411', '13699562589@qq.com', 'http://127.0.0.1:8080', null, '1496479483371', '', '', '0', null);
INSERT INTO `agency_backward` VALUES ('26', '23', 'wt', 'wt', 'wt', 'wt', '1575326411', 'wt@qq', 'wt', null, '1497231635832', 'LG3G', '402880ef5cec6811015cec6811ed0000', '1', null);
INSERT INTO `agency_backward` VALUES ('27', '4', 'company', '123', 'xiaozhu', '1', '1575326411', '16@163', '1', null, '1500458238239', 'T4P6', '402881e85d5a47ed015d5a47edfe0000', '1', null);
INSERT INTO `agency_backward` VALUES ('28', '21', '789', '123', '123', '123', '820267814  ', '123@dd', 'fd', null, '1501055624169', 'BU6D', null, null, null);

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
  KEY `FK_agencyEp_epId` (`ep_id`),
  KEY `FK_agencyEp_agencyId` (`agency_id`),
  CONSTRAINT `FK_agencyEp_agencyId` FOREIGN KEY (`agency_id`) REFERENCES `agency_backward` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FK_agencyEp_epId` FOREIGN KEY (`ep_id`) REFERENCES `exchange_platform` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of agency_ep
-- ----------------------------
INSERT INTO `agency_ep` VALUES ('24', '1', 'xiao', '32', 'wzkj');
INSERT INTO `agency_ep` VALUES ('26', '21', '456', '32', 'wzkj');

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
-- Table structure for `agency_purchase`
-- ----------------------------
DROP TABLE IF EXISTS `agency_purchase`;
CREATE TABLE `agency_purchase` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `agency_id` int(11) DEFAULT NULL,
  `purchase_id` bigint(20) DEFAULT NULL,
  `rate_discount_id` bigint(20) DEFAULT NULL,
  `order_amount` double DEFAULT NULL COMMENT '充值金额(成本）',
  `bill_type` int(11) DEFAULT NULL COMMENT '票务类型（0-无票，1-带票）',
  `order_platform_path` int(11) DEFAULT NULL COMMENT '订单来源（0-网页，1-接口）',
  `order_price` double DEFAULT NULL COMMENT '下级代理商的扣款',
  `from_agency_name` varchar(255) DEFAULT NULL COMMENT '订单来源代理商名称',
  `order_state` int(11) DEFAULT NULL COMMENT '代理商的订单状态',
  `order_state_detail` varchar(255) DEFAULT NULL COMMENT '代理商的订单状态详情',
  PRIMARY KEY (`id`),
  KEY `fk_ap_agency` (`agency_id`),
  KEY `fk_ap_purchase` (`purchase_id`),
  KEY `fk_ap_rateDiscount` (`rate_discount_id`),
  CONSTRAINT `fk_ap_agency` FOREIGN KEY (`agency_id`) REFERENCES `agency_backward` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_ap_purchase` FOREIGN KEY (`purchase_id`) REFERENCES `purchase` (`order_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=175 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of agency_purchase
-- ----------------------------
INSERT INTO `agency_purchase` VALUES ('120', '21', '726614433270337536', '51', '27.9', '0', '0', '27.9', '456', '0', '手动失败');
INSERT INTO `agency_purchase` VALUES ('121', '4', '726614433270337536', '46', '25.5', '0', '2', '27.9', '456', '0', '手动失败');
INSERT INTO `agency_purchase` VALUES ('122', '1', '726614433270337536', '46', '22.5', '0', '2', '25.5', '123', '0', '手动失败');
INSERT INTO `agency_purchase` VALUES ('123', '21', '726617282914029568', '51', '27.9', '0', '0', '27.9', '456', '0', '');
INSERT INTO `agency_purchase` VALUES ('124', '4', '726617282914029568', '46', '25.5', '0', '2', '27.9', '456', '0', '');
INSERT INTO `agency_purchase` VALUES ('125', '1', '726617282914029568', '46', '22.5', '0', '2', '25.5', '123', '0', '');
INSERT INTO `agency_purchase` VALUES ('126', '21', '726623422175514624', '51', '27.9', '0', '0', '27.9', '456', '0', '');
INSERT INTO `agency_purchase` VALUES ('127', '4', '726623422175514624', '46', '25.5', '0', '2', '27.9', '456', '0', '');
INSERT INTO `agency_purchase` VALUES ('128', '1', '726623422175514624', '46', '22.5', '0', '2', '25.5', '123', '0', '');
INSERT INTO `agency_purchase` VALUES ('129', '21', '726628023574466560', '51', '27.9', '0', '0', '27.9', '456', '0', '');
INSERT INTO `agency_purchase` VALUES ('130', '4', '726628023574466560', '46', '25.5', '0', '2', '27.9', '456', '0', '');
INSERT INTO `agency_purchase` VALUES ('131', '1', '726628023574466560', '46', '22.5', '0', '2', '25.5', '123', '0', '');
INSERT INTO `agency_purchase` VALUES ('132', '21', '726628486671765504', '51', '27.9', '0', '0', '27.9', '456', '0', '手动失败');
INSERT INTO `agency_purchase` VALUES ('133', '4', '726628486671765504', '46', '25.5', '0', '2', '27.9', '456', '0', '手动失败');
INSERT INTO `agency_purchase` VALUES ('134', '1', '726628486671765504', '46', '22.5', '0', '2', '25.5', '123', '0', '手动失败');
INSERT INTO `agency_purchase` VALUES ('135', '1', '726633391352451072', '13', '22.5', '0', '0', '22.5', 'xiao', '0', '手动失败');
INSERT INTO `agency_purchase` VALUES ('136', '1', '728332613520986112', null, '22.5', '0', '0', '22.5', 'xiao', '0', '手动失败');
INSERT INTO `agency_purchase` VALUES ('147', '4', '728385208486727680', '46', '25.5', '0', '0', '25.5', '123', '0', '');
INSERT INTO `agency_purchase` VALUES ('148', '1', '728385208486727680', '46', '22.5', '0', '2', '25.5', 'xiao', '0', '');
INSERT INTO `agency_purchase` VALUES ('149', '4', '728388336288272384', '46', '25.5', '0', '0', '25.5', '123', '0', '');
INSERT INTO `agency_purchase` VALUES ('150', '1', '728388336288272384', '46', '22.5', '0', '2', '25.5', '123', '0', '');
INSERT INTO `agency_purchase` VALUES ('151', '4', '729815532068409344', '74', '25.5', '0', '1', '25.5', '123', '0', '');
INSERT INTO `agency_purchase` VALUES ('152', '1', '729815532068409344', '13', '22.5', '0', '1', '25.5', '123', '0', '');
INSERT INTO `agency_purchase` VALUES ('153', '4', '729815729775316992', '74', '25.5', '0', '1', '25.5', '123', '0', '');
INSERT INTO `agency_purchase` VALUES ('154', '1', '729815729775316992', '13', '22.5', '0', '1', '25.5', '123', '0', '');
INSERT INTO `agency_purchase` VALUES ('156', '4', '729884281316315136', '74', '25.5', '0', '1', '25.5', '123', '2', '正在充值');
INSERT INTO `agency_purchase` VALUES ('157', '4', '729884608027430912', '74', '25.5', '0', '1', '25.5', '123', '2', '正在充值');
INSERT INTO `agency_purchase` VALUES ('158', '4', '729885751004631040', '74', '25.5', '0', '1', '25.5', '123', '3', '产品待更新，产品暂不支持购买！！');
INSERT INTO `agency_purchase` VALUES ('159', '4', '729886325943046144', '74', '25.5', '0', '1', '25.5', '123', '3', '产品待更新，产品暂不支持购买！！');
INSERT INTO `agency_purchase` VALUES ('160', '1', '729886325943046144', '13', '22.5', '0', '1', '25.5', '123', '2', '正在充值');
INSERT INTO `agency_purchase` VALUES ('161', '4', '729886591610261504', '74', '25.5', '0', '1', '25.5', '123', '3', '产品待更新，产品暂不支持购买！！');
INSERT INTO `agency_purchase` VALUES ('162', '1', '729886591610261504', '13', '22.5', '0', '1', '25.5', '123', '2', '正在充值');
INSERT INTO `agency_purchase` VALUES ('163', '4', '729886956942528512', '74', '25.5', '0', '1', '25.5', '123', '2', '正在充值');
INSERT INTO `agency_purchase` VALUES ('164', '1', '729886956942528512', '13', '22.5', '0', '1', '25.5', '123', '3', '产品待更新，产品暂不支持购买！！');
INSERT INTO `agency_purchase` VALUES ('165', '4', '730624043929047040', '75', '21', '0', '0', '21', '123', '2', null);
INSERT INTO `agency_purchase` VALUES ('166', '1', '730624043929047040', '21', '20.1', '0', '2', '21', '123', '2', '通道暂停等待');
INSERT INTO `agency_purchase` VALUES ('167', '4', '730862647364292608', '75', '21', '0', '0', '21', '123', '2', null);
INSERT INTO `agency_purchase` VALUES ('168', '1', '730862647364292608', '75', '20.1', '0', '2', '21', '123', '3', '通道暂停等待');
INSERT INTO `agency_purchase` VALUES ('169', '4', '730868271292616704', '75', '21', '0', '0', '21', '123', '2', null);
INSERT INTO `agency_purchase` VALUES ('170', '1', '730868271292616704', '21', '20.1', '0', '2', '21', '123', '2', '通道暂停等待');
INSERT INTO `agency_purchase` VALUES ('171', '4', '730952907712630784', '76', '21', '0', '0', '21', '123', '2', null);
INSERT INTO `agency_purchase` VALUES ('172', '1', '730952907712630784', '76', '18.06', '0', '2', '21', '123', '2', '');
INSERT INTO `agency_purchase` VALUES ('173', '4', '730959306731556864', '76', '21', '0', '0', '21', '123', '2', null);
INSERT INTO `agency_purchase` VALUES ('174', '1', '730959306731556864', '21', '20.1', '0', '2', '21', '123', '2', '通道暂停等待');

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
  `last_access` bigint(20) DEFAULT NULL COMMENT '最后更新时间',
  `belong_agency_id` int(11) DEFAULT NULL COMMENT '通道所属代理商',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of channel_channel
-- ----------------------------
INSERT INTO `channel_channel` VALUES ('7', 'wz本地', '1000', '32', null, null, null, null, '0', '0', '1499233574741', '1');
INSERT INTO `channel_channel` VALUES ('8', '省内-wz江西省', '500& 500', '32', null, null, null, null, '1', '0', '1499236841669', '1');
INSERT INTO `channel_channel` VALUES ('9', '全国-wz福建', '100', null, null, null, null, null, '0', '0', null, '1');
INSERT INTO `channel_channel` VALUES ('10', '省内-wz广东', '200', '32', null, null, null, null, '0', '0', '1503978140431', '1');
INSERT INTO `channel_channel` VALUES ('11', '全国-wz广东移动95', '6144& 3072& 500', '32', null, null, null, null, '0', '0', null, '1');
INSERT INTO `channel_channel` VALUES ('12', '省漫游-wz广东移动75', '500, 6144', '32', null, null, null, null, '0', '0', '1504518292801', '1');
INSERT INTO `channel_channel` VALUES ('13', '省漫游-江西', '1000', '32', null, null, null, null, '0', '1', '1499680372499', '1');
INSERT INTO `channel_channel` VALUES ('14', '全国-', '6144& 3072& 500', '32', null, null, null, null, '0', '0', '1500862266556', '1');
INSERT INTO `channel_channel` VALUES ('15', '全国-1w', '100,500', '32', null, null, null, null, '0', '0', '1500862263126', '1');
INSERT INTO `channel_channel` VALUES ('20', '省内-wzkj省内', '500,,100', '32', null, null, null, null, '1', '0', '1504579062428', '1');
INSERT INTO `channel_channel` VALUES ('21', '省内-wzkj省内2', '500, 100', '32', null, null, null, null, '0', '0', null, '1');

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
  `bill_type` int(11) DEFAULT NULL COMMENT '票务类型（1-对公，0-对私）',
  `service_type` int(11) DEFAULT NULL COMMENT '流量类型',
  `discount_type` int(11) DEFAULT NULL COMMENT '通道折扣类型（0-对上，1-对下）',
  PRIMARY KEY (`id`),
  KEY `channel_channel_discouont` (`channel_id`),
  CONSTRAINT `channel_channel_discouont` FOREIGN KEY (`channel_id`) REFERENCES `channel_channel` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of channel_discount
-- ----------------------------
INSERT INTO `channel_discount` VALUES ('3', null, '01', '0.8', 'wz江西', null, '0', '0', '0');
INSERT INTO `channel_discount` VALUES ('4', null, '14', '0.6', 'wz江西', null, '0', '0', '0');
INSERT INTO `channel_discount` VALUES ('7', '7', '09', '0.85', 'wz本地', '1', '0', '0', '0');
INSERT INTO `channel_discount` VALUES ('8', '7', '14', '0.7', 'wz本地', '1', '0', '0', '0');
INSERT INTO `channel_discount` VALUES ('9', '8', '13', '0.56', '省内-wz江西省', '0', '0', '0', '0');
INSERT INTO `channel_discount` VALUES ('10', '9', '13', '0.9', '全国-wz福建', '1', '0', '0', '0');
INSERT INTO `channel_discount` VALUES ('11', '10', '19', '0.85', '省内-wz广东', '1', '0', '0', '0');
INSERT INTO `channel_discount` VALUES ('12', '11', '15', '0.95', '全国-wz广东移动95', '0', '0', '0', '0');
INSERT INTO `channel_discount` VALUES ('13', '12', '19', '0.75', '省漫游-wz广东移动75', '0', '0', '0', '0');
INSERT INTO `channel_discount` VALUES ('14', '13', '14', '0.65', '省漫游-省漫游-江西', '1', '0', null, '0');
INSERT INTO `channel_discount` VALUES ('15', '14', '06', '0.58', '全国-全国-', '0', '0', '0', '0');
INSERT INTO `channel_discount` VALUES ('16', '15', '05', '0.76', '全国-全国-1w', '1', '0', '0', '0');
INSERT INTO `channel_discount` VALUES ('21', '20', '19', '0.67', '省内-省内-wzkj省内', '0', '0', '1', '0');
INSERT INTO `channel_discount` VALUES ('22', '21', '19', '0.602', '省内-省内-wzkj省内2', '0', '0', '1', '0');

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
  `create_time` bigint(20) DEFAULT NULL COMMENT '账户创建时间',
  `agency_name` varchar(255) DEFAULT NULL COMMENT '代理商名称',
  PRIMARY KEY (`id`),
  KEY `fk_cat_agency` (`agency_id`),
  CONSTRAINT `fk_cat_agency` FOREIGN KEY (`agency_id`) REFERENCES `agency_backward` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of charge_account
-- ----------------------------
INSERT INTO `charge_account` VALUES ('1', '-96100.26', null, null, '200', '1', '0', null, '1495689716779', null);
INSERT INTO `charge_account` VALUES ('2', '93913.6', '工行', '123', '0', '4', '0', null, '1499736896474', null);
INSERT INTO `charge_account` VALUES ('8', '844.2', null, null, '2001', '21', '0', null, '1500523402299', null);
INSERT INTO `charge_account` VALUES ('10', '2000', null, null, '1', '23', '0', null, '1500523402299', null);
INSERT INTO `charge_account` VALUES ('11', '356', null, null, '1212', '24', '0', null, '1498617873998', null);
INSERT INTO `charge_account` VALUES ('12', '700', null, null, '2000', '25', '0', null, '1496479483371', null);
INSERT INTO `charge_account` VALUES ('13', '123', null, null, '0', '26', '0', null, '1497231635832', null);
INSERT INTO `charge_account` VALUES ('17', '100', null, null, '0', '21', '1', '/download?fileName=149881550554119859915_980x1200_0.jpg', '1500519015597', null);
INSERT INTO `charge_account` VALUES ('18', '0', null, null, '0', '24', '1', '/certification//download?fileName=149881581565019859915_980x1200_0.jpg', '1498617873998', null);
INSERT INTO `charge_account` VALUES ('19', '0', null, null, '0', '26', '1', '/certification//download?fileName=149888733072419859915_980x1200_0.jpg', '1497231635832', null);
INSERT INTO `charge_account` VALUES ('20', '100', null, null, '0', '27', '0', null, '1500458238239', null);
INSERT INTO `charge_account` VALUES ('21', '1000', '建行', '6217002020019622232', '0', '1', '1', null, '1495689716779', null);
INSERT INTO `charge_account` VALUES ('22', '0', null, null, '0', '28', '0', null, '1501055624169', null);

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
  `purchase_id` bigint(20) DEFAULT NULL COMMENT '订单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=344 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of charge_record
-- ----------------------------
INSERT INTO `charge_record` VALUES ('1', '1494472130819', '200', '4343', '4543', '0', '0', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('2', '1494475783929', '300', '4543', '4843', '0', '0', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('3', '1494476477425', '200', '4843', '5043', '0', '0', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('4', '1494476697825', '622', '5043', '5665', '1', '0', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('5', '1495698206637', '564', '0', '564', '0', '0', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('6', '1496306974700', '500', '0', '500', '1', '0', '12', '25', '1', null);
INSERT INTO `charge_record` VALUES ('7', '1496457191946', '244', '564', '808', '1', '0', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('8', '1496457234241', '100', '0', '100', '1', '0', '11', '24', '1', null);
INSERT INTO `charge_record` VALUES ('9', '1496479230732', '5665', '5665', '11330', '1', '0', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('10', '1497070558065', '-124', '11330', '11454', '1', '1', '2', '21', '1', null);
INSERT INTO `charge_record` VALUES ('11', '1497070572618', '124', '808', '932', '1', '0', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('12', '1497070830424', '100', '11206', '11106', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('13', '1497070830432', '100', '0', '100', '0', '0', '10', '23', '1', null);
INSERT INTO `charge_record` VALUES ('14', '1497071092695', '200', '11106', '10906', '1', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('15', '1497071092702', '200', '100', '300', '1', '0', '11', '24', '1', null);
INSERT INTO `charge_record` VALUES ('16', '1497096706561', '100', '10906', '10806', '1', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('17', '1497096706578', '100', '932', '1032', '1', '0', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('18', '1497230761210', '56', '10806', '10750', '1', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('19', '1497230761228', '56', '1032', '1088', '1', '0', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('20', '1497234286518', '123', '100', '-23', '1', '1', '10', '23', '1', null);
INSERT INTO `charge_record` VALUES ('21', '1497234286526', '123', '0', '123', '1', '0', '13', '26', '1', null);
INSERT INTO `charge_record` VALUES ('22', '1497319843388', '100.8', '10750', '10649.2', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('23', '1497320189655', '23', '10649.2', '10626.2', '1', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('24', '1497320189670', '23', '-23', '0', '1', '0', '10', '23', '1', null);
INSERT INTO `charge_record` VALUES ('30', '1497324711645', '100.8', '10323.8', '10223', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('31', '1497334170959', '100.8', '10323.8', '10223', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('32', '1497334320341', '100.8', '10323.8', '10223', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('33', '1497334589164', '100.8', '10323.8', '10223', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('34', '1497334678719', '100.8', '10323.8', '10223', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('35', '1497335041420', '100.8', '10323.8', '10223', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('36', '1497335072514', '100.8', '10223', '10122.2', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('37', '1497335205009', '100.8', '10122.2', '10021.4', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('38', '1497335350632', '100.8', '10021.4', '9920.6', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('39', '1497341079646', '100.8', '9920.6', '9819.8', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('40', '1497422624876', '100.8', '9819.8', '9719', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('41', '1497502581980', '100.8', '9719', '9618.2', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('42', '1497664802383', '15', '9618.2', '9603.2', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('44', '1497672169552', '50', '9603.2', '9553.2', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('46', '1497673214580', '90', '9553.2', '9463.2', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('51', '1498011543965', '90', '9103.2', '9013.2', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('53', '1498019892416', '90', '9013.2', '8923.2', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('54', '1498020864242', '50', '8923.2', '8873.2', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('55', '1498020864305', '50', '8873.2', '8823.2', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('56', '1498036472826', '-1000', '8823.2', '9823.2', '1', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('57', '1498036472838', '-1000', '1088', '88', '1', '0', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('58', '1498105372504', '90', '9823.2', '9733.2', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('59', '1498105686902', '90', '9733.2', '9643.2', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('60', '1498107512542', '90', '9643.2', '9553.2', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('61', '1498114604746', '1000', '9553.2', '8553.2', '1', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('62', '1498114604752', '1000', '0', '1000', '1', '0', '10', '23', '1', null);
INSERT INTO `charge_record` VALUES ('63', '1498443661235', '90', '88', '-2', '0', '1', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('64', '1498451844240', '90', '8553.2', '8463.2', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('65', '1498454239884', '90', '-2', '-92', '0', '1', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('66', '1498557176529', '123', '8463.2', '8340.2', '1', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('67', '1498557176568', '123', '-92', '31', '1', '0', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('68', '1498557176595', '123', '8217.2', '8094.2', '1', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('69', '1498557176605', '123', '31', '154', '1', '0', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('70', '1498557588247', '-123', '8094.2', '8217.2', '1', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('71', '1498557588259', '-123', '154', '31', '1', '0', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('72', '1498557605211', '-56', '8340.2', '8396.2', '1', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('73', '1498557605215', '-56', '31', '-25', '1', '0', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('75', '1498709926710', '100', '8396.2', '8296.2', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('76', '1498710206728', '100', '8296.2', '8196.2', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('77', '1498710232235', '100', '8196.2', '8096.2', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('78', '1498710238401', '100', '8096.2', '7996.2', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('79', '1498710239941', '100', '7996.2', '7896.2', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('80', '1498710418569', '100', '7896.2', '7796.2', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('81', '1498710618612', '100', '7796.2', '7696.2', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('82', '1498710793814', '100', '7696.2', '7596.2', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('83', '1498711032309', '100', '7596.2', '7496.2', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('84', '1498711156057', '100', '7496.2', '7396.2', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('85', '1498711174058', '100', '7396.2', '7296.2', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('86', '1498711184556', '100', '7296.2', '7196.2', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('87', '1498711224189', '100', '7196.2', '7096.2', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('88', '1498711397517', '100', '7096.2', '6996.2', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('89', '1498791831345', '25', '6996.2', '6971.2', '1', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('90', '1498791831355', '25', '-25', '0', '1', '0', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('91', '1499676982137', '56', '0', '-56', '1', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('92', '1499676982175', '56', '300', '356', '1', '0', '11', '24', '1', null);
INSERT INTO `charge_record` VALUES ('94', '1499741844216', '200', '-56', '-256', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('95', '1499741844254', '200', '200', '400', '0', '0', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('96', '1499741905706', '200', '-256', '-456', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('97', '1499741914681', '200', '400', '600', '0', '0', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('108', '1501231518184', '1000', '-456', '-1456', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('109', '1501231518603', '1000', '1000', '2000', '0', '0', '10', '23', '1', null);
INSERT INTO `charge_record` VALUES ('110', '1501231763745', '400', '-2456', '-2856', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('111', '1501231779234', '400', '600', '1000', '0', '0', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('112', '1501231919992', '100', '-2856', '-2956', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('113', '1501231924154', '100', '0', '100', '0', '0', '20', '27', '1', null);
INSERT INTO `charge_record` VALUES ('122', '1501753735785', '27.9', '1000', '972.1', '0', '1', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('123', '1501753735834', '25.5', '-2956', '-2981.5', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('124', '1501829737647', '167.4', '972.1', '804.7', '0', '1', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('125', '1501829737662', '153', '-2981.5', '-3134.5', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('126', '1501829912756', '167.4', '804.7', '637.3', '0', '1', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('127', '1501829912766', '153', '-3134.5', '-3287.5', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('128', '1501830024285', '93', '637.3', '544.3', '0', '1', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('129', '1501830024297', '85', '-3287.5', '-3372.5', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('130', '1501832094088', '93', '544.3', '451.3', '0', '1', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('131', '1501832094139', '85', '-3372.5', '-3457.5', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('132', '1501832138470', '93', '451.3', '358.3', '0', '1', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('133', '1501832138486', '85', '-3457.5', '-3542.5', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('134', '1501832358954', '27.9', '358.3', '330.4', '0', '1', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('135', '1501832358975', '25.5', '-3542.5', '-3568', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('136', '1501832717793', '27.9', '330.4', '302.5', '0', '1', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('137', '1501832717801', '25.5', '-3568', '-3593.5', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('138', '1501832935411', '167.4', '302.5', '135.1', '0', '1', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('139', '1501832935430', '153', '-3593.5', '-3746.5', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('140', '1501833425377', '27.9', '135.1', '107.2', '0', '1', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('141', '1501833425389', '25.5', '-3746.5', '-3772', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('142', '1501833524428', '27.9', '107.2', '79.3', '0', '1', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('143', '1501833524446', '25.5', '-3772', '-3797.5', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('144', '1501835849475', '27.9', '79.3', '51.4', '0', '1', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('145', '1501836163849', '27.9', '51.4', '23.5', '0', '1', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('146', '1501836360050', '27.9', '23.5', '-4.4', '0', '1', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('147', '1501837362622', '1000', '-3797.5', '-4797.5', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('148', '1501837362632', '1000', '-4.4', '995.6', '0', '0', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('149', '1501837482474', '27.9', '995.6', '967.7', '0', '1', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('150', '1501898858108', '93', '967.7', '874.7', '0', '1', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('151', '1501921458637', '167.4', '874.7', '707.3', '0', '1', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('152', '1501924827786', '27.9', '707.3', '679.4', '0', '1', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('153', '1501928543671', '27.9', '679.4', '651.5', '0', '1', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('154', '1502260713966', '93', '651.5', '558.5', '0', '1', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('155', '1502696005714', '27.9', '558.5', '530.6', '0', '1', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('156', '1502696205446', '27.9', '530.6', '502.7', '0', '1', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('157', '1502696226131', '27.9', '502.7', '474.8', '0', '1', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('158', '1502698662105', '27.9', '474.8', '446.9', '0', '1', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('159', '1502698831963', '167.4', '446.9', '279.5', '0', '1', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('160', '1502698932839', '27.9', '279.5', '251.6', '0', '1', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('161', '1502699024665', '167.4', '251.6', '84.2', '0', '1', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('162', '1502699066786', '27.9', '84.2', '56.3', '0', '1', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('163', '1502699294241', '27.9', '56.3', '28.4', '0', '1', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('164', '1502700533165', '100000', '3981', '-96019', '0', '1', '1', '1', '1', null);
INSERT INTO `charge_record` VALUES ('165', '1502700533176', '100000', '-4797.5', '95202.5', '0', '0', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('166', '1502764868508', '27.9', '28.4', '0.5', '0', '1', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('167', '1502764868524', '25.5', '95202.5', '95177', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('168', '1502766011846', '10000', '95177', '85177', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('169', '1502766011856', '10000', '0.5', '10000.5', '0', '0', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('170', '1502766050089', '27.9', '10000.5', '9972.6', '0', '1', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('171', '1502766050103', '25.5', '85177', '85151.5', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('172', '1503038800149', '25.5', '85151.5', '85126', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('177', '1503045601695', '27.9', '9972.6', '9944.7', '0', '1', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('178', '1503045601714', '25.5', '85126', '85100.5', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('179', '1503110037018', '1000', null, null, null, '0', '1', '4', '0', '703710166008205312');
INSERT INTO `charge_record` VALUES ('188', '1503288312464', '27.9', '9944.7', '9916.8', '0', '1', '8', '21', '1', '725447673032740864');
INSERT INTO `charge_record` VALUES ('189', '1503288317728', '27.9', '85100.5', '85128.4', '0', '2', '2', '4', '1', '725447673032740864');
INSERT INTO `charge_record` VALUES ('190', '1503288317728', '25.5', '85128.4', '85102.9', '0', '1', '2', '4', '1', '725447673032740864');
INSERT INTO `charge_record` VALUES ('191', '1503299068262', '27.9', '9916.8', '9888.9', '0', '1', '8', '21', '1', '725492786119315456');
INSERT INTO `charge_record` VALUES ('192', '1503299193137', '27.9', '85102.9', '85130.8', '0', '2', '2', '4', '1', '725492786119315456');
INSERT INTO `charge_record` VALUES ('193', '1503299197359', '25.5', '85130.79999999999', '85105.29999999999', '0', '1', '2', '4', '1', '725492786119315456');
INSERT INTO `charge_record` VALUES ('194', '1503300347206', '27.9', '9888.9', '9861', '0', '1', '8', '21', '1', '725498150399250432');
INSERT INTO `charge_record` VALUES ('195', '1503300514608', '25.5', '-96019', '-96044.5', '0', '1', '1', '1', '1', '725498150399250432');
INSERT INTO `charge_record` VALUES ('196', '1503300369505', '27.9', '85105.3', '85133.2', '0', '2', '2', '4', '1', '725498150399250432');
INSERT INTO `charge_record` VALUES ('197', '1503300372482', '25.5', '85133.2', '85107.7', '0', '1', '2', '4', '1', '725498150399250432');
INSERT INTO `charge_record` VALUES ('198', '1503300911009', '27.9', '9861', '9833.1', '0', '1', '8', '21', '1', '725500515160428544');
INSERT INTO `charge_record` VALUES ('199', '1503300931889', '25.5', '-96019', '-96044.5', '0', '1', '1', '1', '1', '725500515160428544');
INSERT INTO `charge_record` VALUES ('200', '1503300919876', '27.9', '85107.7', '85135.6', '0', '2', '2', '4', '1', '725500515160428544');
INSERT INTO `charge_record` VALUES ('201', '1503300921875', '25.5', '85135.59999999999', '85110.09999999999', '0', '1', '2', '4', '1', '725500515160428544');
INSERT INTO `charge_record` VALUES ('204', '1503301622695', '27.9', '9833.1', '9805.2', '0', '1', '8', '21', '1', '725503500187865088');
INSERT INTO `charge_record` VALUES ('205', '1503301640123', '25.5', '-96019', '-96044.5', '0', '1', '1', '1', '1', '725503500187865088');
INSERT INTO `charge_record` VALUES ('206', '1503301627448', '27.9', '85110.1', '85138', '0', '2', '2', '4', '1', '725503500187865088');
INSERT INTO `charge_record` VALUES ('207', '1503301627448', '25.5', '85138', '85112.5', '0', '1', '2', '4', '1', '725503500187865088');
INSERT INTO `charge_record` VALUES ('208', '1503311277139', '200', '-96019', '-96219', '0', '1', '1', '1', '1', null);
INSERT INTO `charge_record` VALUES ('209', '1503311277157', '200', '500', '700', '0', '0', '12', '25', '1', null);
INSERT INTO `charge_record` VALUES ('210', '1503312472750', '27.9', '9805.2', '9777.3', '0', '1', '8', '21', '1', '725549008616951808');
INSERT INTO `charge_record` VALUES ('211', '1503312477897', '25.5', '85140.4', '85114.9', '0', '1', '2', '4', '1', '725549008616951808');
INSERT INTO `charge_record` VALUES ('212', '1503312479306', '22.5', '-96193.5', '-96216', '0', '1', '1', '1', '1', '725549008616951808');
INSERT INTO `charge_record` VALUES ('213', '1503314019267', '100000', '85114.9', '-14885.1', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('214', '1503314019271', '100000', '9777.3', '109777.3', '0', '0', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('215', '1503314258626', '-109777.3', '-14885.1', '94892.2', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('216', '1503314258630', '-109777.3', '109777.3', '0', '0', '0', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('217', '1503364189924', '1000', '94892.2', '93892.2', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('218', '1503364189942', '1000', '0', '1000', '0', '0', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('219', '1503364222367', '27.9', '1000', '972.1', '0', '1', '8', '21', '1', '725766062242533376');
INSERT INTO `charge_record` VALUES ('220', '1503364299427', '25.5', '93920.1', '93894.6', '0', '1', '2', '4', '1', '725766062242533376');
INSERT INTO `charge_record` VALUES ('221', '1503364401802', '22.5', '-96193.5', '-96216', '0', '1', '1', '1', '1', '725766062242533376');
INSERT INTO `charge_record` VALUES ('222', '1503364983157', '27.9', '972.1', '944.2', '0', '1', '8', '21', '1', '725769253227073536');
INSERT INTO `charge_record` VALUES ('223', '1503364987214', '25.5', '93922.5', '93897', '0', '1', '2', '4', '1', '725769253227073536');
INSERT INTO `charge_record` VALUES ('224', '1503364989516', '22.5', '-96193.5', '-96216', '0', '1', '1', '1', '1', '725769253227073536');
INSERT INTO `charge_record` VALUES ('225', '1503368508035', '27.9', '944.2', '916.3', '0', '1', '8', '21', '1', '725784037636968448');
INSERT INTO `charge_record` VALUES ('226', '1503368508053', '25.5', '93924.9', '93899.4', '0', '1', '2', '4', '1', '725784037636968448');
INSERT INTO `charge_record` VALUES ('227', '1503368508055', '22.5', '-96193.5', '-96216', '0', '1', '1', '1', '1', '725784037636968448');
INSERT INTO `charge_record` VALUES ('229', '1503369178973', '27.9', '916.3', '888.4', '0', '1', '8', '21', '1', '725786851754905600');
INSERT INTO `charge_record` VALUES ('230', '1503369179000', '25.5', '93927.3', '93901.8', '0', '1', '2', '4', '1', '725786851754905600');
INSERT INTO `charge_record` VALUES ('231', '1503369179004', '22.5', '-96193.5', '-96216', '0', '1', '1', '1', '1', '725786851754905600');
INSERT INTO `charge_record` VALUES ('232', '1503384584955', '-100', '93901.8', '94001.8', '0', '1', '2', '4', '1', null);
INSERT INTO `charge_record` VALUES ('233', '1503384584970', '-100', '888.4', '788.4', '0', '0', '8', '21', '1', null);
INSERT INTO `charge_record` VALUES ('234', '1503461541553', '27.9', '788.4', '760.5', '0', '1', '8', '21', '1', '726174248493649920');
INSERT INTO `charge_record` VALUES ('235', '1503461541585', '25.5', '94029.7', '94004.2', '0', '1', '2', '4', '1', '726174248493649920');
INSERT INTO `charge_record` VALUES ('236', '1503461547249', '22.5', '-96193.5', '-96216', '0', '1', '1', '1', '1', '726174248493649920');
INSERT INTO `charge_record` VALUES ('237', '1503549547347', '22.5', '-96219', '-96241.5', '0', '1', '1', '1', '1', null);
INSERT INTO `charge_record` VALUES ('238', '1503549807315', '22.5', '-96219', '-96241.5', '0', '1', '1', '1', '1', null);
INSERT INTO `charge_record` VALUES ('240', '1503556929562', '27.9', '760.5', '732.6', '0', '1', '8', '21', '1', '726574368183816192');
INSERT INTO `charge_record` VALUES ('241', '1503556939402', '25.5', '94032.1', '94006.6', '0', '1', '2', '4', '1', '726574368183816192');
INSERT INTO `charge_record` VALUES ('242', '1503556939405', '22.5', '-96193.5', '-96216', '0', '1', '1', '1', '1', '726574368183816192');
INSERT INTO `charge_record` VALUES ('243', '1503557076810', '22.5', '-96219', '-96241.5', '0', '1', '1', '1', '1', null);
INSERT INTO `charge_record` VALUES ('244', '1503557576955', '22.5', '-96219', '-96241.5', '0', '1', '1', '1', '1', null);
INSERT INTO `charge_record` VALUES ('245', '1503561739925', '22.5', '-96219', '-96241.5', '0', '2', '1', '1', '1', '726574979755282432');
INSERT INTO `charge_record` VALUES ('246', '1503561938952', '27.9', '732.6', '760.5', '0', '2', '8', '21', '1', '725766062242533376');
INSERT INTO `charge_record` VALUES ('247', '1503561946933', '25.5', '94006.6', '94032.1', '0', '2', '2', '4', '1', '725766062242533376');
INSERT INTO `charge_record` VALUES ('248', '1503561950365', '22.5', '-96241.5', '-96219', '0', '2', '1', '1', '1', '725766062242533376');
INSERT INTO `charge_record` VALUES ('249', '1503562546924', '27.9', '760.5', '788.4', '0', '2', '8', '21', '1', '725549008616951808');
INSERT INTO `charge_record` VALUES ('250', '1503562549958', '25.5', '94032.1', '94057.6', '0', '2', '2', '4', '1', '725549008616951808');
INSERT INTO `charge_record` VALUES ('251', '1503562555542', '22.5', '-96219', '-96196.5', '0', '2', '1', '1', '1', '725549008616951808');
INSERT INTO `charge_record` VALUES ('252', '1503563359725', '27.9', '816.3', '844.2', '0', '2', '8', '21', '1', '725500515160428544');
INSERT INTO `charge_record` VALUES ('253', '1503563359734', '25.5', '94083.1', '94108.6', '0', '2', '2', '4', '1', '725500515160428544');
INSERT INTO `charge_record` VALUES ('254', '1503563359742', '25.5', '-96196.5', '-96171', '0', '2', '1', '1', '1', '725500515160428544');
INSERT INTO `charge_record` VALUES ('255', '1503566489755', '27.9', '844.2', '816.3', '0', '1', '8', '21', '1', '726614433270337536');
INSERT INTO `charge_record` VALUES ('256', '1503566489811', '25.5', '94136.5', '94111', '0', '1', '2', '4', '1', '726614433270337536');
INSERT INTO `charge_record` VALUES ('257', '1503566489815', '22.5', '-96145.5', '-96168', '0', '1', '1', '1', '1', '726614433270337536');
INSERT INTO `charge_record` VALUES ('258', '1503566653828', '27.9', '816.3', '844.2', '0', '2', '8', '21', '1', '726614433270337536');
INSERT INTO `charge_record` VALUES ('259', '1503566653843', '25.5', '94111', '94136.5', '0', '2', '2', '4', '1', '726614433270337536');
INSERT INTO `charge_record` VALUES ('260', '1503566653852', '22.5', '-96171', '-96148.5', '0', '2', '1', '1', '1', '726614433270337536');
INSERT INTO `charge_record` VALUES ('261', '1503567169183', '27.9', '844.2', '816.3', '0', '1', '8', '21', '1', '726617282914029568');
INSERT INTO `charge_record` VALUES ('262', '1503567169209', '25.5', '94164.4', '94138.9', '0', '1', '2', '4', '1', '726617282914029568');
INSERT INTO `charge_record` VALUES ('263', '1503567169212', '22.5', '-96123', '-96145.5', '0', '1', '1', '1', '1', '726617282914029568');
INSERT INTO `charge_record` VALUES ('264', '1503568632896', '27.9', '816.3', '788.4', '0', '1', '8', '21', '1', '726623422175514624');
INSERT INTO `charge_record` VALUES ('265', '1503568632918', '25.5', '94166.8', '94141.3', '0', '1', '2', '4', '1', '726623422175514624');
INSERT INTO `charge_record` VALUES ('266', '1503568632920', '22.5', '-96123', '-96145.5', '0', '1', '1', '1', '1', '726623422175514624');
INSERT INTO `charge_record` VALUES ('267', '1503569729934', '27.9', '788.4', '760.5', '0', '1', '8', '21', '1', '726628023574466560');
INSERT INTO `charge_record` VALUES ('268', '1503569729988', '25.5', '94169.2', '94143.7', '0', '1', '2', '4', '1', '726628023574466560');
INSERT INTO `charge_record` VALUES ('269', '1503569729993', '22.5', '-96123', '-96145.5', '0', '1', '1', '1', '1', '726628023574466560');
INSERT INTO `charge_record` VALUES ('270', '1503569840368', '27.9', '760.5', '732.6', '0', '1', '8', '21', '1', '726628486671765504');
INSERT INTO `charge_record` VALUES ('271', '1503569840391', '25.5', '94171.6', '94146.1', '0', '1', '2', '4', '1', '726628486671765504');
INSERT INTO `charge_record` VALUES ('272', '1503569840395', '22.5', '-96120', '-96142.5', '0', '1', '1', '1', '1', '726628486671765504');
INSERT INTO `charge_record` VALUES ('273', '1503570066025', '27.9', '732.6', '760.5', '0', '2', '8', '21', '1', '726628486671765504');
INSERT INTO `charge_record` VALUES ('274', '1503570066034', '25.5', '94146.1', '94171.6', '0', '2', '2', '4', '1', '726628486671765504');
INSERT INTO `charge_record` VALUES ('275', '1503570066039', '22.5', '-96142.5', '-96120', '0', '2', '1', '1', '1', '726628486671765504');
INSERT INTO `charge_record` VALUES ('276', '1503571009734', '22.5', '-96120', '-96142.5', '0', '1', '1', '1', '1', null);
INSERT INTO `charge_record` VALUES ('277', '1503976129260', '22.5', '-96120', '-96142.5', '0', '1', '1', '1', '1', null);
INSERT INTO `charge_record` VALUES ('288', '1503988657193', '25.5', '94171.6', '94146.1', '0', '1', '2', '4', '1', '728385208486727680');
INSERT INTO `charge_record` VALUES ('289', '1503988951271', '22.5', '-96117', '-96139.5', '0', '1', '1', '1', '1', '728385208486727680');
INSERT INTO `charge_record` VALUES ('290', '1503989421198', '25.5', '94146.1', '94120.6', '0', '1', '2', '4', '1', '728388336288272384');
INSERT INTO `charge_record` VALUES ('291', '1503989431901', '22.5', '-96114', '-96136.5', '0', '1', '1', '1', '1', '728388336288272384');
INSERT INTO `charge_record` VALUES ('292', '1504252491459', '22.5', '-96136.5', '-96114', '0', '2', '1', '1', '1', '728332613520986112');
INSERT INTO `charge_record` VALUES ('293', '1504252497937', '22.5', '-96114', '-96091.5', '0', '2', '1', '1', '1', '726633391352451072');
INSERT INTO `charge_record` VALUES ('294', '1504327955313', '25.5', '94120.6', '94095.1', '0', '1', '2', '4', '1', '729808250916048896');
INSERT INTO `charge_record` VALUES ('295', '1504327955340', '22.5', '-96091.5', '-96114', '0', '1', '1', '1', '1', '729808250916048896');
INSERT INTO `charge_record` VALUES ('296', '1504329055397', '25.5', '94095.1', '94069.6', '0', '1', '2', '4', '1', '729812697243193344');
INSERT INTO `charge_record` VALUES ('297', '1504329058823', '22.5', '-96114', '-96136.5', '0', '1', '1', '1', '1', '729812697243193344');
INSERT INTO `charge_record` VALUES ('298', '1504329691227', '25.5', '94069.6', '94044.1', '0', '1', '2', '4', '1', '729815532068409344');
INSERT INTO `charge_record` VALUES ('299', '1504329691234', '22.5', '-96136.5', '-96159', '0', '1', '1', '1', '1', '729815532068409344');
INSERT INTO `charge_record` VALUES ('300', '1504329738400', '25.5', '94044.1', '94018.6', '0', '1', '2', '4', '1', '729815729775316992');
INSERT INTO `charge_record` VALUES ('301', '1504329738410', '22.5', '-96159', '-96181.5', '0', '1', '1', '1', '1', '729815729775316992');
INSERT INTO `charge_record` VALUES ('302', '1504329742000', '25.5', '94018.6', '94044.1', '0', '2', '2', '4', '1', '729815729775316992');
INSERT INTO `charge_record` VALUES ('303', '1504329742000', '22.5', '-96181.5', '-96159', '0', '2', '1', '1', '1', '729815729775316992');
INSERT INTO `charge_record` VALUES ('304', '1504329695000', '25.5', '94044.1', '94069.6', '0', '2', '2', '4', '1', '729815532068409344');
INSERT INTO `charge_record` VALUES ('305', '1504329695000', '22.5', '-96159', '-96136.5', '0', '2', '1', '1', '1', '729815532068409344');
INSERT INTO `charge_record` VALUES ('306', '1504329695000', '27.9', '760.5', '788.4', '0', '2', '8', '21', '1', '726628023574466560');
INSERT INTO `charge_record` VALUES ('307', '1504329695000', '25.5', '94069.6', '94095.1', '0', '2', '2', '4', '1', '726628023574466560');
INSERT INTO `charge_record` VALUES ('308', '1504329695000', '22.5', '-96136.5', '-96114', '0', '2', '1', '1', '1', '726628023574466560');
INSERT INTO `charge_record` VALUES ('309', '1504329695000', '27.9', '788.4', '816.3', '0', '2', '8', '21', '1', '726623422175514624');
INSERT INTO `charge_record` VALUES ('310', '1504329695000', '25.5', '94095.1', '94120.6', '0', '2', '2', '4', '1', '726623422175514624');
INSERT INTO `charge_record` VALUES ('311', '1504329695000', '22.5', '-96114', '-96091.5', '0', '2', '1', '1', '1', '726623422175514624');
INSERT INTO `charge_record` VALUES ('312', '1504329695000', '27.9', '816.3', '844.2', '0', '2', '8', '21', '1', '726617282914029568');
INSERT INTO `charge_record` VALUES ('313', '1504329695000', '25.5', '94120.6', '94146.1', '0', '2', '2', '4', '1', '726617282914029568');
INSERT INTO `charge_record` VALUES ('314', '1504329695000', '22.5', '-96091.5', '-96069', '0', '2', '1', '1', '1', '726617282914029568');
INSERT INTO `charge_record` VALUES ('315', '1504329695000', '25.5', '94146.1', '94171.6', '0', '2', '2', '4', '1', '728388336288272384');
INSERT INTO `charge_record` VALUES ('316', '1504329695000', '22.5', '-96069', '-96046.5', '0', '2', '1', '1', '1', '728388336288272384');
INSERT INTO `charge_record` VALUES ('317', '1504329695000', '25.5', '94171.6', '94197.1', '0', '2', '2', '4', '1', '728385208486727680');
INSERT INTO `charge_record` VALUES ('318', '1504329695000', '22.5', '-96046.5', '-96024', '0', '2', '1', '1', '1', '728385208486727680');
INSERT INTO `charge_record` VALUES ('319', '1504344725747', '25.5', '94197.1', '94171.6', '0', '1', '2', '4', '1', '729878532062187520');
INSERT INTO `charge_record` VALUES ('320', '1504344730808', '22.5', '-96024', '-96046.5', '0', '1', '1', '1', '1', '729878532062187520');
INSERT INTO `charge_record` VALUES ('322', '1504346082323', '25.5', '94171.6', '94146.1', '0', '1', '2', '4', '1', '729884281316315136');
INSERT INTO `charge_record` VALUES ('323', '1504346160217', '25.5', '94146.1', '94120.6', '0', '1', '2', '4', '1', '729884608027430912');
INSERT INTO `charge_record` VALUES ('326', '1504346432726', '25.5', '94120.6', '94095.1', '0', '1', '2', '4', '1', '729885751004631040');
INSERT INTO `charge_record` VALUES ('327', '1504346569799', '25.5', '94095.1', '94069.6', '0', '1', '2', '4', '1', '729886325943046144');
INSERT INTO `charge_record` VALUES ('328', '1504346633162', '25.5', '94069.6', '94044.1', '0', '1', '2', '4', '1', '729886591610261504');
INSERT INTO `charge_record` VALUES ('329', '1504346720245', '25.5', '94044.1', '94018.6', '0', '1', '2', '4', '1', '729886956942528512');
INSERT INTO `charge_record` VALUES ('330', '1504522455452', '21', '94018.6', '93997.6', '0', '1', '2', '4', '1', '730624043929047040');
INSERT INTO `charge_record` VALUES ('331', '1504522459659', '20.1', '-96025.5', '-96045.6', '0', '1', '1', '1', '1', '730624043929047040');
INSERT INTO `charge_record` VALUES ('332', '1504577938706', '20.1', '-96045.6', '-96065.7', '0', '1', '1', '1', '1', '730624043929047040');
INSERT INTO `charge_record` VALUES ('333', '1504579342947', '21', '93997.6', '93976.6', '0', '1', '2', '4', '1', '730862647364292608');
INSERT INTO `charge_record` VALUES ('334', '1504579345554', '20.1', '-96044.7', '-96064.8', '0', '1', '1', '1', '1', '730862647364292608');
INSERT INTO `charge_record` VALUES ('335', '1504580683795', '21', '93976.6', '93955.6', '0', '1', '2', '4', '1', '730868271292616704');
INSERT INTO `charge_record` VALUES ('336', '1504580715860', '20.1', '-96043.8', '-96063.9', '0', '1', '1', '1', '1', '730868271292616704');
INSERT INTO `charge_record` VALUES ('337', '1504580937907', '20.1', '-96063.9', '-96084', '0', '1', '1', '1', '1', '730868271292616704');
INSERT INTO `charge_record` VALUES ('338', '1504600862693', '21', '93955.6', '93934.6', '0', '1', '2', '4', '1', '730952907712630784');
INSERT INTO `charge_record` VALUES ('339', '1504600868196', '18.06', '-96063', '-96081.06', '0', '1', '1', '1', '1', '730952907712630784');
INSERT INTO `charge_record` VALUES ('340', '1504602388338', '21', '93934.6', '93913.6', '0', '1', '2', '4', '1', '730959306731556864');
INSERT INTO `charge_record` VALUES ('341', '1504602395148', '20.1', '-96060.06', '-96080.16', '0', '1', '1', '1', '1', '730959306731556864');
INSERT INTO `charge_record` VALUES ('343', '1504602827054', '20.1', '-96080.16', '-96100.26', '0', '1', '1', '1', '1', '730959306731556864');

-- ----------------------------
-- Table structure for `company_credentials`
-- ----------------------------
DROP TABLE IF EXISTS `company_credentials`;
CREATE TABLE `company_credentials` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '验证id',
  `agency_id` int(11) DEFAULT NULL COMMENT '待验证代理商id',
  `confirm_agency_id` int(11) DEFAULT NULL COMMENT '验证人Id(一般是rootAgencyId)',
  `confirm_state` int(11) DEFAULT '0' COMMENT '验证状态（1-验证通过，0-验证失败，2-待验证，3-待完善:草稿）',
  `business_executive_name` varchar(255) DEFAULT NULL COMMENT '商务负责人姓名',
  `be_tel` varchar(255) DEFAULT NULL COMMENT '商务联系电话',
  `emergency_contact` varchar(255) DEFAULT NULL COMMENT '紧急联系人姓名',
  `ec_tel` varchar(255) DEFAULT NULL COMMENT '紧急联系人电话',
  `company_address` varchar(255) DEFAULT NULL COMMENT '企业现居地址',
  `taxpayer_is_qualification` int(11) DEFAULT NULL COMMENT '是否具备增值税一般纳税人资格',
  `company_name` varchar(255) DEFAULT NULL COMMENT '公司名称',
  `company_location` varchar(255) DEFAULT NULL COMMENT '公司地址',
  `corporate_tel` varchar(255) DEFAULT NULL COMMENT '公司（负责人）联系电话',
  `deposit_bank_name` varchar(255) DEFAULT NULL COMMENT '开户行名称',
  `bank_account` varchar(255) DEFAULT NULL COMMENT '银行账号',
  `tax_registration_certificate` varchar(255) DEFAULT NULL COMMENT '税务登记证号',
  `billing_content` varchar(255) DEFAULT NULL COMMENT '开票内容',
  `info_service_fee` double DEFAULT NULL,
  `bill_recipients_name` varchar(255) DEFAULT NULL COMMENT '发票收件人',
  `bill_recipients_tel` varchar(255) DEFAULT NULL COMMENT '收件人电话',
  `bill_recipients_address` varchar(255) DEFAULT NULL COMMENT '收件地址',
  `business_license` varchar(255) DEFAULT NULL COMMENT '营业执照',
  `deposit_bank_photo` varchar(255) DEFAULT NULL COMMENT '银行开户信息',
  `corporate_identity_front` varchar(255) DEFAULT NULL COMMENT '法定人身份证(正面)',
  `corporate_identity_back` varchar(255) DEFAULT NULL COMMENT '法定人身份证(反面)',
  `commit_time` bigint(20) DEFAULT NULL COMMENT '提交时间',
  `confirm_time` bigint(20) DEFAULT NULL COMMENT '审核时间',
  PRIMARY KEY (`id`),
  KEY `fk_credentials_aid` (`agency_id`),
  KEY `fk_credentials_raid` (`confirm_agency_id`),
  CONSTRAINT `fk_credentials_aid` FOREIGN KEY (`agency_id`) REFERENCES `agency_backward` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_credentials_raid` FOREIGN KEY (`confirm_agency_id`) REFERENCES `agency_backward` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company_credentials
-- ----------------------------
INSERT INTO `company_credentials` VALUES ('1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1495689716779', '1495689716779');
INSERT INTO `company_credentials` VALUES ('2', '4', '1', '2', '网吧', '456', '微博', '456', '减肥快圣诞节了附近可', '1', '微族科技', 'zhongyilu', '13699562589', '建行', '6217002020019622332', '456454654546545', '信息服务费', null, '发斯蒂芬', '564656411', '方式的减肥了可适当', '/upload/123/license.jpg', '', '/upload/123/idFront.jpg', '/upload/123/idBack.jpg', '1500888168922', '1500980290627');
INSERT INTO `company_credentials` VALUES ('3', '21', '4', '3', null, null, null, null, null, null, '南昌微族科技', null, null, null, null, null, null, null, null, null, null, null, null, null, '', '1495689716779', '1495689716779');

-- ----------------------------
-- Table structure for `exchange_platform`
-- ----------------------------
DROP TABLE IF EXISTS `exchange_platform`;
CREATE TABLE `exchange_platform` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '平台ID',
  `ep_name` varchar(255) DEFAULT NULL COMMENT '平台名称',
  `ep_eng_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '平台英文标识',
  `ep_purchase_ip` varchar(255) DEFAULT NULL COMMENT '流量订购地址',
  `product_list_ip` varchar(255) DEFAULT NULL COMMENT '产品列表地址',
  `pgdata_check_ip` varchar(255) DEFAULT NULL COMMENT '订单查询地址',
  `ep_balance_ip` varchar(255) DEFAULT NULL COMMENT '余额查询地址',
  `ep_user_name` varchar(255) DEFAULT NULL COMMENT '账号',
  `ep_user_pass` varchar(255) DEFAULT NULL COMMENT '密码',
  `ep_balance` double DEFAULT NULL COMMENT '平台余额',
  `ep_apikey` varchar(255) DEFAULT NULL COMMENT 'apikey',
  `ep_ip` varchar(255) DEFAULT NULL COMMENT '主页地址',
  `ep_other_params` varchar(255) DEFAULT NULL COMMENT '平台接口其他参数',
  `ep_call_back` int(11) DEFAULT NULL COMMENT '是否支持回调（1-不支持，0-支持）',
  `last_access` bigint(20) DEFAULT NULL COMMENT '平台更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exchange_platform
-- ----------------------------
INSERT INTO `exchange_platform` VALUES ('32', 'wzkj', 'Weizu', 'http://139.224.70.161:32001/api/v1/sendOrder', 'http://139.224.70.161:32001/api/v1/sendOrder', 'http://139.224.70.161:32001/api/v1/orderState', 'http://139.224.70.161:32001/api/v1/getBalance', 'CS111111', '123456', null, '722c16de0a83e5bd2f988e3c7bc9fee8', 'http://139.224.70.161/', null, '0', '1503369178973');
INSERT INTO `exchange_platform` VALUES ('42', '行云', 'Lljypt', 'http://api.lljypt.com/capi/trade.charge', 'http://api.lljypt.com/capi/trade.charge', 'http://api.lljypt.com/capi/query.order', 'http://api.lljypt.com/capi/query.balance', 'cncwz', '249636', '0', 'KKIGoAFUTxoIFfC', 'http://customer.lljypt.com/a', 'merchant=10210&clientId=10000&version=V100&', null, '1504000807525');
INSERT INTO `exchange_platform` VALUES ('43', '行云对私', 'Lljypt0', 'http://api.lljypt.com/capi/trade.charge', 'http://api.lljypt.com/capi/trade.charge', 'http://api.lljypt.com/capi/query.order', 'http://api.lljypt.com/capi/query.balance', 'cncwz', '249636', '0', 'AoYIuPLXMmpTwTw', 'http://customer.lljypt.com/a', 'merchant=10304&clientId=10000&version=V100& ', null, '1504000740478');

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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of operator_pg_data
-- ----------------------------
INSERT INTO `operator_pg_data` VALUES ('1', '6144', '180', '180元6144MB', '1', '0', '中国移动', '0');
INSERT INTO `operator_pg_data` VALUES ('8', '3072', '100', '100元3072MB', '1', '0', '中国移动', '0');
INSERT INTO `operator_pg_data` VALUES ('10', '100', '10', '10元100MB', '1', '1', '中国联通', '0');
INSERT INTO `operator_pg_data` VALUES ('11', '200', '10', '10yuan200m', '1', '1', '中国联通', '1');
INSERT INTO `operator_pg_data` VALUES ('12', '1000', '10', '10yuan1000m', '1', '1', '中国联通', '2');
INSERT INTO `operator_pg_data` VALUES ('15', '500', '30', '移动30.0元500MB省漫游', '1', '0', '中国移动', '2');
INSERT INTO `operator_pg_data` VALUES ('16', '500', '30', '移动30.0元500MB全国', '1', '0', '中国移动', '0');
INSERT INTO `operator_pg_data` VALUES ('17', '6144', '180', '联通180.0元6144MB转增', '1', '1', '中国联通', '3');
INSERT INTO `operator_pg_data` VALUES ('18', '6144', '180', '移动180.0元6144MB省漫游', '1', '0', '中国移动', '2');
INSERT INTO `operator_pg_data` VALUES ('19', '500', '30', '移动30.0元500MB省内', '1', '0', '中国移动', '1');
INSERT INTO `operator_pg_data` VALUES ('20', '100', '10', '移动10.0元100MB省内', '1', '0', '中国移动', '1');
INSERT INTO `operator_pg_data` VALUES ('21', '100', '10', '移动10.0元100MB全国', '1', '0', '中国移动', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_code
-- ----------------------------
INSERT INTO `product_code` VALUES ('1', '江西移动500M全国流量包', '15', '14', '30', '2', 'jx10086500500');
INSERT INTO `product_code` VALUES ('2', null, '1', '32', null, '2', '333333');
INSERT INTO `product_code` VALUES ('3', '全国', '1', '32', null, '2', '1255456');
INSERT INTO `product_code` VALUES ('4', '全国', '10', '32', null, '2', '565656');
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
INSERT INTO `product_code` VALUES ('26', '四川省', '10', '22', null, '32', '123');
INSERT INTO `product_code` VALUES ('27', '全国', '1', '32', null, '2', '456');
INSERT INTO `product_code` VALUES ('28', '全国', null, '32', null, '2', null);
INSERT INTO `product_code` VALUES ('29', '全国', null, '32', null, '2', null);
INSERT INTO `product_code` VALUES ('30', '全国', null, '32', null, '2', null);
INSERT INTO `product_code` VALUES ('34', '广东省', '19', '19', null, '32', '500sn');
INSERT INTO `product_code` VALUES ('35', '广东省', '20', '19', null, '32', '100sn');

-- ----------------------------
-- Table structure for `purchase`
-- ----------------------------
DROP TABLE IF EXISTS `purchase`;
CREATE TABLE `purchase` (
  `order_id` bigint(20) NOT NULL COMMENT 'è®¢å•å·',
  `order_id_api` varchar(255) DEFAULT NULL COMMENT '其他系统返回的订单id',
  `order_id_from` varchar(255) DEFAULT NULL COMMENT '下级代理商传过来的订单号',
  `agency_id` int(11) DEFAULT NULL COMMENT '生成订单的代理商',
  `charge_tel` varchar(255) DEFAULT NULL COMMENT 'æ‰‹æœºå·',
  `order_amount` double DEFAULT NULL COMMENT '订单的初始价格（适用于接口充值）',
  `pg_id` int(11) DEFAULT NULL COMMENT 'æµé‡åŒ…idï¼ˆå¤–é”®ï¼‰',
  `order_arrive_time` bigint(20) DEFAULT NULL COMMENT 'æäº¤æ—¶é—´ï¼ˆæœ¬å¹³å°èŽ·å¾—è¯¥æ•°æ®è¯·æ±‚çš„æ—¶é—´ï¼‰',
  `charge_tel_detail` varchar(255) DEFAULT NULL COMMENT 'å·ç å½’å±žï¼ˆï¼šæ±Ÿè¥¿ç§»åŠ¨ï¼‰',
  `charge_tel_city` varchar(255) DEFAULT NULL COMMENT 'å·ç å½’å±žå…·ä½“åŸŽå¸‚',
  `order_result` int(11) DEFAULT NULL COMMENT '订单状态（超级管理员）',
  `channel_id` bigint(11) DEFAULT NULL COMMENT 'é€šé“idï¼ˆå¤–é”®ï¼‰',
  `order_result_detail` varchar(255) DEFAULT NULL COMMENT '订单结果描述（超级管理员）',
  `order_back_time` bigint(20) DEFAULT NULL COMMENT '订单返回时间',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of purchase
-- ----------------------------
INSERT INTO `purchase` VALUES ('726614433270337536', '20170902132135923754', null, '21', '15014369834', null, '16', '1503566489755', '广东移动', null, '0', '12', '手动失败', '1503566653868');
INSERT INTO `purchase` VALUES ('726617282914029568', '20170902132135923750', null, '21', '15014369834', null, '16', '1503567169183', '广东移动', null, '0', '12', '', '1504340681112');
INSERT INTO `purchase` VALUES ('726623422175514624', '20170902132135923751', null, '21', '15014369834', null, '16', '1503568632896', '广东移动', null, '0', '12', '', '1504340681010');
INSERT INTO `purchase` VALUES ('726628023574466560', '20170902132135923752', null, '21', '15014369834', null, '16', '1503569729934', '广东移动', null, '0', '12', '', '1504340680898');
INSERT INTO `purchase` VALUES ('726628486671765504', '20170902132135923753', null, '21', '15014369834', null, '16', '1503569840368', '广东移动', null, '0', '12', '手动失败', '1503570066051');
INSERT INTO `purchase` VALUES ('726633391352451072', '20170902132135923755', null, '1', '15014369834', null, '16', '1503571009732', '广东移动', null, '0', '12', '手动失败', '1504252497960');
INSERT INTO `purchase` VALUES ('728332613520986112', '20170902132135923756', null, '1', '15014369834', null, '16', '1503976117855', '广东移动', null, '0', '12', '手动失败', '1504252491491');
INSERT INTO `purchase` VALUES ('728385208486727680', '20170902132135923757', null, '4', '15014369834', null, '16', '1503988657193', '广东移动', null, '0', '12', '', '1504340790342');
INSERT INTO `purchase` VALUES ('728388336288272384', '20170902132135923758', null, '4', '15014369834', null, '16', '1503989421198', '广东移动', null, '0', '12', '', '1504340790254');
INSERT INTO `purchase` VALUES ('729815532068409344', '20170902132135923759', '123456123', '4', '15014369834', '25.5', '16', '1504329691209', '广东移动', '汕尾', '0', '12', '', '1504339812706');
INSERT INTO `purchase` VALUES ('729815729775316992', '201709021322229544170', '123456123', '4', '15014369834', '25.5', '16', '1504329738346', '广东移动', '汕尾', '0', '12', '', '1504339803189');
INSERT INTO `purchase` VALUES ('729884281316315136', null, '123456123', '4', '15014369834', '25.5', '16', '1504346082307', '广东移动', '汕尾', null, '12', null, null);
INSERT INTO `purchase` VALUES ('729884608027430912', null, '123456123', '4', '15014369834', '25.5', '16', '1504346160201', '广东移动', '汕尾', null, '12', null, null);
INSERT INTO `purchase` VALUES ('729885751004631040', null, '123456123', '4', '15014369834', '25.5', '16', '1504346432708', '广东移动', '汕尾', null, '12', null, null);
INSERT INTO `purchase` VALUES ('729886325943046144', null, '123456123', '4', '15014369834', '25.5', '16', '1504346569784', '广东移动', '汕尾', null, '12', null, null);
INSERT INTO `purchase` VALUES ('729886591610261504', null, '123456123', '4', '15014369834', '25.5', '16', '1504346633124', '广东移动', '汕尾', null, '12', null, null);
INSERT INTO `purchase` VALUES ('729886956942528512', null, '123456123', '4', '15014369834', '25.5', '16', '1504346720226', '广东移动', '汕尾', null, '12', null, null);
INSERT INTO `purchase` VALUES ('730624043929047040', null, null, '4', '13688969536', null, '19', '1504522455452', '广东移动', null, null, '20', null, null);
INSERT INTO `purchase` VALUES ('730862647364292608', null, null, '4', '13688969536', null, '19', '1504579342947', '广东移动', null, null, '20', null, null);
INSERT INTO `purchase` VALUES ('730868271292616704', null, null, '4', '13688969536', '21', '19', '1504580683795', '广东移动', null, null, '20', null, null);
INSERT INTO `purchase` VALUES ('730952907712630784', null, null, '4', '13688969536', '21', '19', '1504600862693', '广东移动', null, null, '21', null, null);
INSERT INTO `purchase` VALUES ('730959306731556864', '20170905171406355753', null, '4', '13688969536', '21', '19', '1504602819477', '广东移动', null, null, '20', null, null);

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
  `channel_id` bigint(20) DEFAULT NULL COMMENT '通道id',
  PRIMARY KEY (`id`),
  KEY `active_discount_fk` (`active_id`),
  KEY `fk_channel_dis_rate` (`channel_discount_id`),
  CONSTRAINT `fk_channel_dis_rate` FOREIGN KEY (`channel_discount_id`) REFERENCES `channel_discount` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rate_discount
-- ----------------------------
INSERT INTO `rate_discount` VALUES ('49', '0.9', '46', '13', '1', '12');
INSERT INTO `rate_discount` VALUES ('51', '0.93', '46', '13', '0', '12');
INSERT INTO `rate_discount` VALUES ('52', '0.9', '46', '13', '1', '12');
INSERT INTO `rate_discount` VALUES ('53', '0.99', '46', '13', '1', '12');
INSERT INTO `rate_discount` VALUES ('54', '0.9', '46', '13', '1', '12');
INSERT INTO `rate_discount` VALUES ('58', '0.95', null, '13', '1', null);
INSERT INTO `rate_discount` VALUES ('65', '0.84', null, '13', '1', '12');
INSERT INTO `rate_discount` VALUES ('66', '0.98', null, '13', '1', null);
INSERT INTO `rate_discount` VALUES ('70', '0.96', null, '12', '0', '11');
INSERT INTO `rate_discount` VALUES ('71', '0.32', null, '12', '0', '11');
INSERT INTO `rate_discount` VALUES ('72', '56', null, '16', '1', '15');
INSERT INTO `rate_discount` VALUES ('75', '0.7', null, '21', '0', '20');
INSERT INTO `rate_discount` VALUES ('76', '0.7', null, '22', '0', '21');

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
