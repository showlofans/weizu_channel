/*
Navicat MySQL Data Transfer

Source Server         : home
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : rate_channel

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2017-10-19 10:00:26
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
  CONSTRAINT `bind_account_fk` FOREIGN KEY (`account_id`) REFERENCES `charge_account` (`id`) ON DELETE CASCADE,
  CONSTRAINT `bind_agency_fk` FOREIGN KEY (`bind_agency_id`) REFERENCES `agency_backward` (`id`),
  CONSTRAINT `channel_agency_fk` FOREIGN KEY (`rate_discount_id`) REFERENCES `rate_discount` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1232 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account_active_rate
-- ----------------------------
INSERT INTO `account_active_rate` VALUES ('35', '2', '1', '22', '1', '123', '0');
INSERT INTO `account_active_rate` VALUES ('36', '4', '1', '22', '1', 'wzkj', '0');
INSERT INTO `account_active_rate` VALUES ('37', '2', '1', '23', '0', '123', '1506500713200');
INSERT INTO `account_active_rate` VALUES ('38', '4', '1', '23', '0', 'wzkj', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('39', '5', '1', '23', '0', '冰河', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('40', '6', '1', '23', '0', 'jiafeng', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('41', '7', '1', '23', '0', 'l474705958', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('42', '8', '1', '23', '0', '184066643', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('43', '9', '1', '23', '0', '2369412', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('44', '10', '1', '23', '0', 'hy123', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('45', '11', '1', '23', '0', 'zishu', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('46', '12', '1', '23', '0', 'tianjing', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('47', '13', '1', '23', '0', 'zqy95178250', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('48', '14', '1', '23', '0', 'QQ574912927', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('49', '15', '1', '23', '0', '1579599827', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('50', '17', '1', '23', '0', '789', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('51', '18', '1', '23', '0', '112', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('52', '20', '1', '23', '0', 'b2218776', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('53', '21', '1', '23', '0', '13771547176', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('86', '2', '1', '26', '0', '123', '1505731154644');
INSERT INTO `account_active_rate` VALUES ('87', '4', '1', '26', '0', 'wzkj', '1505731154644');
INSERT INTO `account_active_rate` VALUES ('88', '5', '1', '26', '0', '冰河', '1505731154644');
INSERT INTO `account_active_rate` VALUES ('89', '6', '1', '26', '0', 'jiafeng', '1505731154644');
INSERT INTO `account_active_rate` VALUES ('90', '7', '1', '26', '0', 'l474705958', '1505731154644');
INSERT INTO `account_active_rate` VALUES ('91', '8', '1', '26', '0', '184066643', '1505731154644');
INSERT INTO `account_active_rate` VALUES ('92', '9', '1', '26', '0', '2369412', '1505731154644');
INSERT INTO `account_active_rate` VALUES ('93', '10', '1', '26', '0', 'hy123', '1505731154644');
INSERT INTO `account_active_rate` VALUES ('94', '11', '1', '26', '0', 'zishu', '1505731154644');
INSERT INTO `account_active_rate` VALUES ('95', '12', '1', '26', '0', 'tianjing', '1505731154644');
INSERT INTO `account_active_rate` VALUES ('96', '13', '1', '26', '0', 'zqy95178250', '1505731158002');
INSERT INTO `account_active_rate` VALUES ('97', '14', '1', '26', '0', 'QQ574912927', '1505731158002');
INSERT INTO `account_active_rate` VALUES ('98', '15', '1', '26', '0', '1579599827', '1505731158002');
INSERT INTO `account_active_rate` VALUES ('99', '17', '1', '26', '0', '789', '1505731158002');
INSERT INTO `account_active_rate` VALUES ('100', '18', '1', '26', '0', '112', '1505731158002');
INSERT INTO `account_active_rate` VALUES ('101', '20', '1', '26', '0', 'b2218776', '1505731158002');
INSERT INTO `account_active_rate` VALUES ('102', '21', '1', '26', '0', '13771547176', '1505731158002');
INSERT INTO `account_active_rate` VALUES ('103', '22', '1', '26', '0', '1', '1505731158002');
INSERT INTO `account_active_rate` VALUES ('104', '23', '1', '26', '0', '小aq', '1505731158002');
INSERT INTO `account_active_rate` VALUES ('105', '24', '1', '26', '0', '15914897978', '1505731158002');
INSERT INTO `account_active_rate` VALUES ('106', '25', '1', '26', '0', 'oushinanshen', '1505731160500');
INSERT INTO `account_active_rate` VALUES ('107', '26', '1', '26', '0', 'wxx899999', '1505731160500');
INSERT INTO `account_active_rate` VALUES ('108', '27', '1', '26', '0', '1464975293', '1505731160500');
INSERT INTO `account_active_rate` VALUES ('109', '30', '1', '26', '0', 'Bear', '1505731160500');
INSERT INTO `account_active_rate` VALUES ('110', '31', '1', '26', '0', 'zxx', '1505731160500');
INSERT INTO `account_active_rate` VALUES ('114', '32', '1', '26', '0', 'hy123456', '1505744206093');
INSERT INTO `account_active_rate` VALUES ('115', '33', '1', '26', '0', 'wl123', '1505744206093');
INSERT INTO `account_active_rate` VALUES ('116', '34', '1', '26', '0', '鳯儿网店', '1505744206093');
INSERT INTO `account_active_rate` VALUES ('117', '35', '1', '26', '0', 'ruiruima', '1505744206093');
INSERT INTO `account_active_rate` VALUES ('118', '36', '1', '26', '0', '944581678', '1505744206093');
INSERT INTO `account_active_rate` VALUES ('119', '37', '1', '26', '0', '2069959168', '1505744206093');
INSERT INTO `account_active_rate` VALUES ('120', '38', '1', '26', '0', '570156062', '1505744206093');
INSERT INTO `account_active_rate` VALUES ('121', '39', '1', '26', '0', '770733914', '1505744206093');
INSERT INTO `account_active_rate` VALUES ('122', '40', '1', '26', '0', '5257', '1505744206093');
INSERT INTO `account_active_rate` VALUES ('123', '41', '1', '26', '0', '18734158108', '1505744206093');
INSERT INTO `account_active_rate` VALUES ('124', '42', '1', '26', '0', 'xhq1347574865', '1505744208055');
INSERT INTO `account_active_rate` VALUES ('154', '5', '1', '22', '0', '冰河', '1505744248587');
INSERT INTO `account_active_rate` VALUES ('155', '6', '1', '22', '0', 'jiafeng', '1505744248587');
INSERT INTO `account_active_rate` VALUES ('156', '7', '1', '22', '0', 'l474705958', '1505744248587');
INSERT INTO `account_active_rate` VALUES ('157', '8', '1', '22', '0', '184066643', '1505744248587');
INSERT INTO `account_active_rate` VALUES ('158', '9', '1', '22', '0', '2369412', '1505744248587');
INSERT INTO `account_active_rate` VALUES ('159', '10', '1', '22', '0', 'hy123', '1505744248587');
INSERT INTO `account_active_rate` VALUES ('160', '11', '1', '22', '0', 'zishu', '1505744248587');
INSERT INTO `account_active_rate` VALUES ('161', '12', '1', '22', '0', 'tianjing', '1505744248587');
INSERT INTO `account_active_rate` VALUES ('162', '13', '1', '22', '0', 'zqy95178250', '1505744248587');
INSERT INTO `account_active_rate` VALUES ('163', '14', '1', '22', '0', 'QQ574912927', '1505744248587');
INSERT INTO `account_active_rate` VALUES ('164', '15', '1', '22', '0', '1579599827', '1505744253873');
INSERT INTO `account_active_rate` VALUES ('165', '17', '1', '22', '0', '789', '1505744253873');
INSERT INTO `account_active_rate` VALUES ('166', '18', '1', '22', '0', '112', '1505744253873');
INSERT INTO `account_active_rate` VALUES ('167', '20', '1', '22', '0', 'b2218776', '1505744253873');
INSERT INTO `account_active_rate` VALUES ('168', '21', '1', '22', '0', '13771547176', '1505744253873');
INSERT INTO `account_active_rate` VALUES ('169', '22', '1', '22', '0', '1', '1505744253873');
INSERT INTO `account_active_rate` VALUES ('170', '23', '1', '22', '0', '小aq', '1505744253873');
INSERT INTO `account_active_rate` VALUES ('171', '24', '1', '22', '0', '15914897978', '1505744253873');
INSERT INTO `account_active_rate` VALUES ('172', '25', '1', '22', '0', 'oushinanshen', '1505744253873');
INSERT INTO `account_active_rate` VALUES ('173', '26', '1', '22', '0', 'wxx899999', '1505744253873');
INSERT INTO `account_active_rate` VALUES ('174', '27', '1', '22', '0', '1464975293', '1505744255935');
INSERT INTO `account_active_rate` VALUES ('175', '30', '1', '22', '0', 'Bear', '1505744255935');
INSERT INTO `account_active_rate` VALUES ('176', '31', '1', '22', '0', 'zxx', '1505744255935');
INSERT INTO `account_active_rate` VALUES ('177', '32', '1', '22', '0', 'hy123456', '1505744255935');
INSERT INTO `account_active_rate` VALUES ('178', '33', '1', '22', '0', 'wl123', '1505744255935');
INSERT INTO `account_active_rate` VALUES ('179', '34', '1', '22', '0', '鳯儿网店', '1505744255935');
INSERT INTO `account_active_rate` VALUES ('180', '35', '1', '22', '0', 'ruiruima', '1505744255935');
INSERT INTO `account_active_rate` VALUES ('181', '36', '1', '22', '0', '944581678', '1505744255935');
INSERT INTO `account_active_rate` VALUES ('182', '37', '1', '22', '0', '2069959168', '1505744255935');
INSERT INTO `account_active_rate` VALUES ('183', '38', '1', '22', '0', '570156062', '1505744255935');
INSERT INTO `account_active_rate` VALUES ('184', '39', '1', '22', '0', '770733914', '1505744258448');
INSERT INTO `account_active_rate` VALUES ('185', '40', '1', '22', '0', '5257', '1505744258448');
INSERT INTO `account_active_rate` VALUES ('186', '41', '1', '22', '0', '18734158108', '1505744258448');
INSERT INTO `account_active_rate` VALUES ('187', '42', '1', '22', '0', 'xhq1347574865', '1505744258448');
INSERT INTO `account_active_rate` VALUES ('188', '43', '1', '26', '0', 'Chen', '1505745428700');
INSERT INTO `account_active_rate` VALUES ('189', '44', '1', '26', '0', 'qq130496', '1505745428700');
INSERT INTO `account_active_rate` VALUES ('190', '45', '1', '26', '0', 'kevinchow', '1505745428700');
INSERT INTO `account_active_rate` VALUES ('191', '46', '1', '26', '0', '17346544413', '1505745428700');
INSERT INTO `account_active_rate` VALUES ('254', '47', '1', '26', '0', '2480199685', '1505829677290');
INSERT INTO `account_active_rate` VALUES ('255', '48', '1', '26', '0', 'jim145', '1505829677290');
INSERT INTO `account_active_rate` VALUES ('256', '49', '1', '26', '0', 'bada', '1505829677290');
INSERT INTO `account_active_rate` VALUES ('257', '50', '1', '26', '0', '罗大大', '1505829677290');
INSERT INTO `account_active_rate` VALUES ('258', '51', '1', '26', '0', '109', '1505829677290');
INSERT INTO `account_active_rate` VALUES ('259', '52', '1', '26', '0', '119', '1505829677290');
INSERT INTO `account_active_rate` VALUES ('260', '53', '1', '26', '0', 'gigi77', '1505829677290');
INSERT INTO `account_active_rate` VALUES ('261', '55', '1', '26', '0', 'gigi777', '1505829677290');
INSERT INTO `account_active_rate` VALUES ('322', '22', '1', '23', '0', '1', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('323', '23', '1', '23', '0', '小aq', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('324', '24', '1', '23', '0', '15914897978', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('325', '25', '1', '23', '0', 'oushinanshen', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('326', '26', '1', '23', '0', 'wxx899999', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('327', '27', '1', '23', '0', '1464975293', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('328', '30', '1', '23', '0', 'Bear', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('329', '31', '1', '23', '0', 'zxx', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('330', '32', '1', '23', '0', 'hy123456', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('331', '33', '1', '23', '0', 'wl123', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('332', '34', '1', '23', '0', '鳯儿网店', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('333', '35', '1', '23', '0', 'ruiruima', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('334', '36', '1', '23', '0', '944581678', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('335', '37', '1', '23', '0', '2069959168', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('336', '38', '1', '23', '0', '570156062', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('337', '39', '1', '23', '0', '770733914', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('338', '40', '1', '23', '0', '5257', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('339', '41', '1', '23', '0', '18734158108', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('340', '42', '1', '23', '0', 'xhq1347574865', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('341', '43', '1', '23', '0', 'Chen', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('342', '44', '1', '23', '0', 'qq130496', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('343', '45', '1', '23', '0', 'kevinchow', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('344', '46', '1', '23', '0', '17346544413', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('345', '47', '1', '23', '0', '2480199685', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('346', '48', '1', '23', '0', 'jim145', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('347', '49', '1', '23', '0', 'bada', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('348', '50', '1', '23', '0', '罗大大', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('349', '51', '1', '23', '0', '109', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('350', '52', '1', '23', '0', '119', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('351', '53', '1', '23', '0', 'gigi77', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('352', '55', '1', '23', '0', 'gigi777', '1506499870586');
INSERT INTO `account_active_rate` VALUES ('353', '2', '1', '29', '0', '123', '1505872343109');
INSERT INTO `account_active_rate` VALUES ('354', '4', '1', '29', '0', 'wzkj', '1505872343109');
INSERT INTO `account_active_rate` VALUES ('355', '5', '1', '29', '0', '冰河', '1505872343109');
INSERT INTO `account_active_rate` VALUES ('356', '6', '1', '29', '0', 'jiafeng', '1505872343109');
INSERT INTO `account_active_rate` VALUES ('357', '7', '1', '29', '0', 'l474705958', '1505872343109');
INSERT INTO `account_active_rate` VALUES ('358', '8', '1', '29', '0', '184066643', '1505872343109');
INSERT INTO `account_active_rate` VALUES ('359', '9', '1', '29', '0', '2369412', '1505872343109');
INSERT INTO `account_active_rate` VALUES ('360', '10', '1', '29', '0', 'hy123', '1505872343109');
INSERT INTO `account_active_rate` VALUES ('361', '11', '1', '29', '0', 'zishu', '1505872343109');
INSERT INTO `account_active_rate` VALUES ('362', '12', '1', '29', '0', 'tianjing', '1505872343109');
INSERT INTO `account_active_rate` VALUES ('363', '13', '1', '29', '0', 'zqy95178250', '1505872345104');
INSERT INTO `account_active_rate` VALUES ('364', '14', '1', '29', '0', 'QQ574912927', '1505872345104');
INSERT INTO `account_active_rate` VALUES ('365', '15', '1', '29', '0', '1579599827', '1505872345104');
INSERT INTO `account_active_rate` VALUES ('366', '17', '1', '29', '0', '789', '1505872345104');
INSERT INTO `account_active_rate` VALUES ('367', '18', '1', '29', '0', '112', '1505872345104');
INSERT INTO `account_active_rate` VALUES ('368', '20', '1', '29', '0', 'b2218776', '1505872345104');
INSERT INTO `account_active_rate` VALUES ('369', '21', '1', '29', '0', '13771547176', '1505872345104');
INSERT INTO `account_active_rate` VALUES ('370', '22', '1', '29', '0', '1', '1505872345104');
INSERT INTO `account_active_rate` VALUES ('371', '23', '1', '29', '0', '小aq', '1505872345104');
INSERT INTO `account_active_rate` VALUES ('372', '24', '1', '29', '0', '15914897978', '1505872345104');
INSERT INTO `account_active_rate` VALUES ('373', '25', '1', '29', '0', 'oushinanshen', '1505872347551');
INSERT INTO `account_active_rate` VALUES ('374', '26', '1', '29', '0', 'wxx899999', '1505872347551');
INSERT INTO `account_active_rate` VALUES ('375', '27', '1', '29', '0', '1464975293', '1505872347551');
INSERT INTO `account_active_rate` VALUES ('376', '30', '1', '29', '0', 'Bear', '1505872347551');
INSERT INTO `account_active_rate` VALUES ('377', '31', '1', '29', '0', 'zxx', '1505872347551');
INSERT INTO `account_active_rate` VALUES ('378', '32', '1', '29', '0', 'hy123456', '1505872347551');
INSERT INTO `account_active_rate` VALUES ('379', '33', '1', '29', '0', 'wl123', '1505872347551');
INSERT INTO `account_active_rate` VALUES ('380', '34', '1', '29', '0', '鳯儿网店', '1505872347551');
INSERT INTO `account_active_rate` VALUES ('381', '35', '1', '29', '0', 'ruiruima', '1505872347551');
INSERT INTO `account_active_rate` VALUES ('382', '36', '1', '29', '0', '944581678', '1505872347551');
INSERT INTO `account_active_rate` VALUES ('383', '37', '1', '29', '0', '2069959168', '1505872349441');
INSERT INTO `account_active_rate` VALUES ('384', '38', '1', '29', '0', '570156062', '1505872349441');
INSERT INTO `account_active_rate` VALUES ('385', '39', '1', '29', '0', '770733914', '1505872349441');
INSERT INTO `account_active_rate` VALUES ('386', '40', '1', '29', '0', '5257', '1505872349441');
INSERT INTO `account_active_rate` VALUES ('387', '41', '1', '29', '0', '18734158108', '1505872349441');
INSERT INTO `account_active_rate` VALUES ('388', '42', '1', '29', '0', 'xhq1347574865', '1505872349441');
INSERT INTO `account_active_rate` VALUES ('389', '43', '1', '29', '0', 'Chen', '1505872349441');
INSERT INTO `account_active_rate` VALUES ('390', '44', '1', '29', '0', 'qq130496', '1505872349441');
INSERT INTO `account_active_rate` VALUES ('391', '45', '1', '29', '0', 'kevinchow', '1505872349441');
INSERT INTO `account_active_rate` VALUES ('392', '46', '1', '29', '0', '17346544413', '1505872349441');
INSERT INTO `account_active_rate` VALUES ('393', '47', '1', '29', '0', '2480199685', '1505872351418');
INSERT INTO `account_active_rate` VALUES ('394', '48', '1', '29', '0', 'jim145', '1505872351418');
INSERT INTO `account_active_rate` VALUES ('395', '49', '1', '29', '0', 'bada', '1505872351418');
INSERT INTO `account_active_rate` VALUES ('396', '50', '1', '29', '0', '罗大大', '1505872351418');
INSERT INTO `account_active_rate` VALUES ('397', '51', '1', '29', '0', '109', '1505872351418');
INSERT INTO `account_active_rate` VALUES ('398', '52', '1', '29', '0', '119', '1505872351418');
INSERT INTO `account_active_rate` VALUES ('399', '53', '1', '29', '0', 'gigi77', '1505872351418');
INSERT INTO `account_active_rate` VALUES ('400', '55', '1', '29', '0', 'gigi777', '1505872351418');
INSERT INTO `account_active_rate` VALUES ('402', '4', '1', '30', '0', 'wzkj', '1505872369457');
INSERT INTO `account_active_rate` VALUES ('403', '5', '1', '30', '0', '冰河', '1505872369457');
INSERT INTO `account_active_rate` VALUES ('404', '6', '1', '30', '0', 'jiafeng', '1505872369457');
INSERT INTO `account_active_rate` VALUES ('405', '7', '1', '30', '0', 'l474705958', '1505872369457');
INSERT INTO `account_active_rate` VALUES ('406', '8', '1', '30', '0', '184066643', '1505872369457');
INSERT INTO `account_active_rate` VALUES ('407', '9', '1', '30', '0', '2369412', '1505872369457');
INSERT INTO `account_active_rate` VALUES ('408', '10', '1', '30', '0', 'hy123', '1505872369457');
INSERT INTO `account_active_rate` VALUES ('409', '11', '1', '30', '0', 'zishu', '1505872369457');
INSERT INTO `account_active_rate` VALUES ('410', '12', '1', '30', '0', 'tianjing', '1505872369457');
INSERT INTO `account_active_rate` VALUES ('411', '13', '1', '30', '0', 'zqy95178250', '1505872371357');
INSERT INTO `account_active_rate` VALUES ('412', '14', '1', '30', '0', 'QQ574912927', '1505872371357');
INSERT INTO `account_active_rate` VALUES ('413', '15', '1', '30', '0', '1579599827', '1505872371357');
INSERT INTO `account_active_rate` VALUES ('414', '17', '1', '30', '0', '789', '1505872371357');
INSERT INTO `account_active_rate` VALUES ('415', '18', '1', '30', '0', '112', '1505872371357');
INSERT INTO `account_active_rate` VALUES ('416', '20', '1', '30', '0', 'b2218776', '1505872371357');
INSERT INTO `account_active_rate` VALUES ('417', '21', '1', '30', '0', '13771547176', '1505872371357');
INSERT INTO `account_active_rate` VALUES ('418', '22', '1', '30', '0', '1', '1505872371357');
INSERT INTO `account_active_rate` VALUES ('419', '23', '1', '30', '0', '小aq', '1505872371357');
INSERT INTO `account_active_rate` VALUES ('420', '24', '1', '30', '0', '15914897978', '1505872371357');
INSERT INTO `account_active_rate` VALUES ('421', '25', '1', '30', '0', 'oushinanshen', '1505872373410');
INSERT INTO `account_active_rate` VALUES ('422', '26', '1', '30', '0', 'wxx899999', '1505872373410');
INSERT INTO `account_active_rate` VALUES ('423', '27', '1', '30', '0', '1464975293', '1505872373410');
INSERT INTO `account_active_rate` VALUES ('424', '30', '1', '30', '0', 'Bear', '1505872373410');
INSERT INTO `account_active_rate` VALUES ('425', '31', '1', '30', '0', 'zxx', '1505872373410');
INSERT INTO `account_active_rate` VALUES ('426', '32', '1', '30', '0', 'hy123456', '1505872373410');
INSERT INTO `account_active_rate` VALUES ('427', '33', '1', '30', '0', 'wl123', '1505872373410');
INSERT INTO `account_active_rate` VALUES ('428', '34', '1', '30', '0', '鳯儿网店', '1505872373410');
INSERT INTO `account_active_rate` VALUES ('429', '35', '1', '30', '0', 'ruiruima', '1505872373410');
INSERT INTO `account_active_rate` VALUES ('430', '36', '1', '30', '0', '944581678', '1505872373410');
INSERT INTO `account_active_rate` VALUES ('431', '37', '1', '30', '0', '2069959168', '1505872375499');
INSERT INTO `account_active_rate` VALUES ('432', '38', '1', '30', '0', '570156062', '1505872375499');
INSERT INTO `account_active_rate` VALUES ('433', '39', '1', '30', '0', '770733914', '1505872375499');
INSERT INTO `account_active_rate` VALUES ('434', '40', '1', '30', '0', '5257', '1505872375499');
INSERT INTO `account_active_rate` VALUES ('435', '41', '1', '30', '0', '18734158108', '1505872375499');
INSERT INTO `account_active_rate` VALUES ('436', '42', '1', '30', '0', 'xhq1347574865', '1505872375499');
INSERT INTO `account_active_rate` VALUES ('437', '43', '1', '30', '0', 'Chen', '1505872375499');
INSERT INTO `account_active_rate` VALUES ('438', '44', '1', '30', '0', 'qq130496', '1505872375499');
INSERT INTO `account_active_rate` VALUES ('439', '45', '1', '30', '0', 'kevinchow', '1505872375499');
INSERT INTO `account_active_rate` VALUES ('440', '46', '1', '30', '0', '17346544413', '1505872375499');
INSERT INTO `account_active_rate` VALUES ('441', '47', '1', '30', '0', '2480199685', '1505872377264');
INSERT INTO `account_active_rate` VALUES ('442', '48', '1', '30', '0', 'jim145', '1505872377264');
INSERT INTO `account_active_rate` VALUES ('443', '49', '1', '30', '0', 'bada', '1505872377264');
INSERT INTO `account_active_rate` VALUES ('444', '50', '1', '30', '0', '罗大大', '1505872377264');
INSERT INTO `account_active_rate` VALUES ('445', '51', '1', '30', '0', '109', '1505872377264');
INSERT INTO `account_active_rate` VALUES ('446', '52', '1', '30', '0', '119', '1505872377264');
INSERT INTO `account_active_rate` VALUES ('447', '53', '1', '30', '0', 'gigi77', '1505872377264');
INSERT INTO `account_active_rate` VALUES ('448', '55', '1', '30', '0', 'gigi777', '1505872377264');
INSERT INTO `account_active_rate` VALUES ('643', '57', '1', '29', '1', '111111', '0');
INSERT INTO `account_active_rate` VALUES ('644', '58', '1', '29', '0', 'dada', '1505881078455');
INSERT INTO `account_active_rate` VALUES ('645', '57', '1', '30', '1', '111111', '0');
INSERT INTO `account_active_rate` VALUES ('646', '58', '1', '30', '0', 'dada', '1505881100716');
INSERT INTO `account_active_rate` VALUES ('659', '43', '1', '22', '0', 'Chen', '1505881245426');
INSERT INTO `account_active_rate` VALUES ('660', '44', '1', '22', '0', 'qq130496', '1505881245426');
INSERT INTO `account_active_rate` VALUES ('661', '45', '1', '22', '0', 'kevinchow', '1505881245426');
INSERT INTO `account_active_rate` VALUES ('662', '46', '1', '22', '0', '17346544413', '1505881245426');
INSERT INTO `account_active_rate` VALUES ('663', '47', '1', '22', '0', '2480199685', '1505881245426');
INSERT INTO `account_active_rate` VALUES ('664', '48', '1', '22', '0', 'jim145', '1505881245426');
INSERT INTO `account_active_rate` VALUES ('665', '49', '1', '22', '0', 'bada', '1505881245426');
INSERT INTO `account_active_rate` VALUES ('666', '50', '1', '22', '0', '罗大大', '1505881245426');
INSERT INTO `account_active_rate` VALUES ('667', '51', '1', '22', '0', '109', '1505881245426');
INSERT INTO `account_active_rate` VALUES ('668', '52', '1', '22', '0', '119', '1505881245426');
INSERT INTO `account_active_rate` VALUES ('669', '53', '1', '22', '0', 'gigi77', '1505881247065');
INSERT INTO `account_active_rate` VALUES ('670', '55', '1', '22', '0', 'gigi777', '1505881247065');
INSERT INTO `account_active_rate` VALUES ('671', '57', '1', '22', '1', '111111', '0');
INSERT INTO `account_active_rate` VALUES ('672', '58', '1', '22', '0', 'dada', '1505881247065');
INSERT INTO `account_active_rate` VALUES ('673', '4', '1', '36', '0', 'wzkj', '1505883064715');
INSERT INTO `account_active_rate` VALUES ('674', '5', '1', '36', '0', '冰河', '1505883064715');
INSERT INTO `account_active_rate` VALUES ('675', '6', '1', '36', '0', 'jiafeng', '1505883064715');
INSERT INTO `account_active_rate` VALUES ('676', '7', '1', '36', '0', 'l474705958', '1505883064715');
INSERT INTO `account_active_rate` VALUES ('677', '8', '1', '36', '0', '184066643', '1505883064715');
INSERT INTO `account_active_rate` VALUES ('678', '9', '1', '36', '0', '2369412', '1505883064715');
INSERT INTO `account_active_rate` VALUES ('679', '10', '1', '36', '0', 'hy123', '1505883064715');
INSERT INTO `account_active_rate` VALUES ('680', '11', '1', '36', '0', 'zishu', '1505883064715');
INSERT INTO `account_active_rate` VALUES ('681', '12', '1', '36', '0', 'tianjing', '1505883064715');
INSERT INTO `account_active_rate` VALUES ('682', '13', '1', '36', '0', 'zqy95178250', '1505883064715');
INSERT INTO `account_active_rate` VALUES ('683', '14', '1', '36', '0', 'QQ574912927', '1505883066430');
INSERT INTO `account_active_rate` VALUES ('684', '15', '1', '36', '0', '1579599827', '1505883066430');
INSERT INTO `account_active_rate` VALUES ('685', '17', '1', '36', '0', '789', '1505883066430');
INSERT INTO `account_active_rate` VALUES ('686', '18', '1', '36', '0', '112', '1505883066430');
INSERT INTO `account_active_rate` VALUES ('687', '20', '1', '36', '0', 'b2218776', '1505883066430');
INSERT INTO `account_active_rate` VALUES ('688', '21', '1', '36', '0', '13771547176', '1505883066430');
INSERT INTO `account_active_rate` VALUES ('689', '22', '1', '36', '0', '1', '1505883066430');
INSERT INTO `account_active_rate` VALUES ('690', '23', '1', '36', '0', '小aq', '1505883066430');
INSERT INTO `account_active_rate` VALUES ('691', '24', '1', '36', '0', '15914897978', '1505883066430');
INSERT INTO `account_active_rate` VALUES ('692', '25', '1', '36', '0', 'oushinanshen', '1505883066430');
INSERT INTO `account_active_rate` VALUES ('693', '26', '1', '36', '0', 'wxx899999', '1505883067669');
INSERT INTO `account_active_rate` VALUES ('694', '27', '1', '36', '0', '1464975293', '1505883067669');
INSERT INTO `account_active_rate` VALUES ('695', '30', '1', '36', '0', 'Bear', '1505883067669');
INSERT INTO `account_active_rate` VALUES ('696', '31', '1', '36', '0', 'zxx', '1505883067669');
INSERT INTO `account_active_rate` VALUES ('697', '32', '1', '36', '0', 'hy123456', '1505883067669');
INSERT INTO `account_active_rate` VALUES ('698', '33', '1', '36', '0', 'wl123', '1505883067669');
INSERT INTO `account_active_rate` VALUES ('699', '34', '1', '36', '0', '鳯儿网店', '1505883067669');
INSERT INTO `account_active_rate` VALUES ('700', '35', '1', '36', '0', 'ruiruima', '1505883067669');
INSERT INTO `account_active_rate` VALUES ('701', '36', '1', '36', '0', '944581678', '1505883067669');
INSERT INTO `account_active_rate` VALUES ('702', '37', '1', '36', '0', '2069959168', '1505883067669');
INSERT INTO `account_active_rate` VALUES ('703', '38', '1', '36', '0', '570156062', '1505883069644');
INSERT INTO `account_active_rate` VALUES ('704', '39', '1', '36', '0', '770733914', '1505883069644');
INSERT INTO `account_active_rate` VALUES ('705', '40', '1', '36', '0', '5257', '1505883069644');
INSERT INTO `account_active_rate` VALUES ('706', '41', '1', '36', '0', '18734158108', '1505883069644');
INSERT INTO `account_active_rate` VALUES ('707', '42', '1', '36', '0', 'xhq1347574865', '1505883069644');
INSERT INTO `account_active_rate` VALUES ('708', '43', '1', '36', '0', 'Chen', '1505883069644');
INSERT INTO `account_active_rate` VALUES ('709', '44', '1', '36', '0', 'qq130496', '1505883069644');
INSERT INTO `account_active_rate` VALUES ('710', '45', '1', '36', '0', 'kevinchow', '1505883069644');
INSERT INTO `account_active_rate` VALUES ('711', '46', '1', '36', '0', '17346544413', '1505883069644');
INSERT INTO `account_active_rate` VALUES ('712', '47', '1', '36', '0', '2480199685', '1505883069644');
INSERT INTO `account_active_rate` VALUES ('713', '48', '1', '36', '0', 'jim145', '1505883071220');
INSERT INTO `account_active_rate` VALUES ('714', '49', '1', '36', '0', 'bada', '1505883071220');
INSERT INTO `account_active_rate` VALUES ('715', '50', '1', '36', '0', '罗大大', '1505883071220');
INSERT INTO `account_active_rate` VALUES ('716', '51', '1', '36', '0', '109', '1505883071220');
INSERT INTO `account_active_rate` VALUES ('717', '52', '1', '36', '0', '119', '1505883071220');
INSERT INTO `account_active_rate` VALUES ('718', '53', '1', '36', '0', 'gigi77', '1505883071220');
INSERT INTO `account_active_rate` VALUES ('719', '55', '1', '36', '0', 'gigi777', '1505883071220');
INSERT INTO `account_active_rate` VALUES ('720', '57', '1', '36', '1', '111111', '0');
INSERT INTO `account_active_rate` VALUES ('721', '58', '1', '36', '0', 'dada', '1505883071220');
INSERT INTO `account_active_rate` VALUES ('722', '59', '1', '36', '0', '源肥呀', '1505883071220');
INSERT INTO `account_active_rate` VALUES ('723', '4', '1', '37', '0', 'wzkj', '1505891005276');
INSERT INTO `account_active_rate` VALUES ('724', '5', '1', '37', '0', '冰河', '1505891005276');
INSERT INTO `account_active_rate` VALUES ('725', '6', '1', '37', '0', 'jiafeng', '1505891005276');
INSERT INTO `account_active_rate` VALUES ('726', '7', '1', '37', '0', 'l474705958', '1505891005276');
INSERT INTO `account_active_rate` VALUES ('727', '8', '1', '37', '0', '184066643', '1505891005276');
INSERT INTO `account_active_rate` VALUES ('728', '9', '1', '37', '0', '2369412', '1505891005276');
INSERT INTO `account_active_rate` VALUES ('729', '10', '1', '37', '0', 'hy123', '1505891005276');
INSERT INTO `account_active_rate` VALUES ('730', '11', '1', '37', '0', 'zishu', '1505891005276');
INSERT INTO `account_active_rate` VALUES ('731', '12', '1', '37', '0', 'tianjing', '1505891005276');
INSERT INTO `account_active_rate` VALUES ('732', '13', '1', '37', '0', 'zqy95178250', '1505891005276');
INSERT INTO `account_active_rate` VALUES ('733', '14', '1', '37', '0', 'QQ574912927', '1505891007451');
INSERT INTO `account_active_rate` VALUES ('734', '15', '1', '37', '0', '1579599827', '1505891007451');
INSERT INTO `account_active_rate` VALUES ('735', '17', '1', '37', '0', '789', '1505891007451');
INSERT INTO `account_active_rate` VALUES ('736', '18', '1', '37', '0', '112', '1505891007451');
INSERT INTO `account_active_rate` VALUES ('737', '20', '1', '37', '0', 'b2218776', '1505891007451');
INSERT INTO `account_active_rate` VALUES ('738', '21', '1', '37', '0', '13771547176', '1505891007451');
INSERT INTO `account_active_rate` VALUES ('739', '22', '1', '37', '0', '1', '1505891007451');
INSERT INTO `account_active_rate` VALUES ('740', '23', '1', '37', '0', '小aq', '1505891007451');
INSERT INTO `account_active_rate` VALUES ('741', '24', '1', '37', '0', '15914897978', '1505891007451');
INSERT INTO `account_active_rate` VALUES ('742', '25', '1', '37', '0', 'oushinanshen', '1505891007451');
INSERT INTO `account_active_rate` VALUES ('743', '26', '1', '37', '0', 'wxx899999', '1505891009820');
INSERT INTO `account_active_rate` VALUES ('744', '27', '1', '37', '0', '1464975293', '1505891009821');
INSERT INTO `account_active_rate` VALUES ('745', '30', '1', '37', '0', 'Bear', '1505891009821');
INSERT INTO `account_active_rate` VALUES ('746', '31', '1', '37', '0', 'zxx', '1505891009821');
INSERT INTO `account_active_rate` VALUES ('747', '32', '1', '37', '0', 'hy123456', '1505891009821');
INSERT INTO `account_active_rate` VALUES ('748', '33', '1', '37', '0', 'wl123', '1505891009821');
INSERT INTO `account_active_rate` VALUES ('749', '34', '1', '37', '0', '鳯儿网店', '1505891009821');
INSERT INTO `account_active_rate` VALUES ('750', '35', '1', '37', '0', 'ruiruima', '1505891009821');
INSERT INTO `account_active_rate` VALUES ('751', '36', '1', '37', '0', '944581678', '1505891009821');
INSERT INTO `account_active_rate` VALUES ('752', '37', '1', '37', '0', '2069959168', '1505891009821');
INSERT INTO `account_active_rate` VALUES ('753', '38', '1', '37', '0', '570156062', '1505891011307');
INSERT INTO `account_active_rate` VALUES ('754', '39', '1', '37', '0', '770733914', '1505891011307');
INSERT INTO `account_active_rate` VALUES ('755', '40', '1', '37', '0', '5257', '1505891011307');
INSERT INTO `account_active_rate` VALUES ('756', '41', '1', '37', '0', '18734158108', '1505891011307');
INSERT INTO `account_active_rate` VALUES ('757', '42', '1', '37', '0', 'xhq1347574865', '1505891011307');
INSERT INTO `account_active_rate` VALUES ('758', '43', '1', '37', '0', 'Chen', '1505891011307');
INSERT INTO `account_active_rate` VALUES ('759', '44', '1', '37', '0', 'qq130496', '1505891011307');
INSERT INTO `account_active_rate` VALUES ('760', '45', '1', '37', '0', 'kevinchow', '1505891011307');
INSERT INTO `account_active_rate` VALUES ('761', '46', '1', '37', '0', '17346544413', '1505891011307');
INSERT INTO `account_active_rate` VALUES ('762', '47', '1', '37', '0', '2480199685', '1505891011307');
INSERT INTO `account_active_rate` VALUES ('763', '48', '1', '37', '0', 'jim145', '1505891013113');
INSERT INTO `account_active_rate` VALUES ('764', '49', '1', '37', '0', 'bada', '1505891013113');
INSERT INTO `account_active_rate` VALUES ('765', '50', '1', '37', '0', '罗大大', '1505891013113');
INSERT INTO `account_active_rate` VALUES ('766', '51', '1', '37', '0', '109', '1505891013113');
INSERT INTO `account_active_rate` VALUES ('767', '52', '1', '37', '0', '119', '1505891013113');
INSERT INTO `account_active_rate` VALUES ('768', '53', '1', '37', '0', 'gigi77', '1505891013113');
INSERT INTO `account_active_rate` VALUES ('769', '55', '1', '37', '0', 'gigi777', '1505891013113');
INSERT INTO `account_active_rate` VALUES ('770', '57', '1', '37', '1', '111111', '0');
INSERT INTO `account_active_rate` VALUES ('771', '58', '1', '37', '0', 'dada', '1505891013113');
INSERT INTO `account_active_rate` VALUES ('772', '59', '1', '37', '0', '源肥呀', '1505891013113');
INSERT INTO `account_active_rate` VALUES ('823', '4', '1', '39', '0', 'wzkj', '1505899162401');
INSERT INTO `account_active_rate` VALUES ('824', '5', '1', '39', '0', '冰河', '1505899162401');
INSERT INTO `account_active_rate` VALUES ('825', '6', '1', '39', '0', 'jiafeng', '1505899162401');
INSERT INTO `account_active_rate` VALUES ('826', '7', '1', '39', '0', 'l474705958', '1505899162401');
INSERT INTO `account_active_rate` VALUES ('827', '8', '1', '39', '0', '184066643', '1505899162401');
INSERT INTO `account_active_rate` VALUES ('828', '9', '1', '39', '0', '2369412', '1505899162401');
INSERT INTO `account_active_rate` VALUES ('829', '10', '1', '39', '0', 'hy123', '1505899162401');
INSERT INTO `account_active_rate` VALUES ('830', '11', '1', '39', '0', 'zishu', '1505899162401');
INSERT INTO `account_active_rate` VALUES ('831', '12', '1', '39', '0', 'tianjing', '1505899162401');
INSERT INTO `account_active_rate` VALUES ('832', '13', '1', '39', '0', 'zqy95178250', '1505899162401');
INSERT INTO `account_active_rate` VALUES ('833', '14', '1', '39', '0', 'QQ574912927', '1505899164236');
INSERT INTO `account_active_rate` VALUES ('834', '15', '1', '39', '0', '1579599827', '1505899164236');
INSERT INTO `account_active_rate` VALUES ('835', '17', '1', '39', '0', '789', '1505899164236');
INSERT INTO `account_active_rate` VALUES ('836', '18', '1', '39', '0', '112', '1505899164236');
INSERT INTO `account_active_rate` VALUES ('837', '20', '1', '39', '0', 'b2218776', '1505899164236');
INSERT INTO `account_active_rate` VALUES ('838', '21', '1', '39', '0', '13771547176', '1505899164236');
INSERT INTO `account_active_rate` VALUES ('839', '22', '1', '39', '0', '1', '1505899164236');
INSERT INTO `account_active_rate` VALUES ('840', '23', '1', '39', '0', '小aq', '1505899164236');
INSERT INTO `account_active_rate` VALUES ('841', '24', '1', '39', '0', '15914897978', '1505899164236');
INSERT INTO `account_active_rate` VALUES ('842', '25', '1', '39', '0', 'oushinanshen', '1505899164236');
INSERT INTO `account_active_rate` VALUES ('843', '26', '1', '39', '0', 'wxx899999', '1505899165725');
INSERT INTO `account_active_rate` VALUES ('844', '27', '1', '39', '0', '1464975293', '1505899165725');
INSERT INTO `account_active_rate` VALUES ('845', '30', '1', '39', '0', 'Bear', '1505899165725');
INSERT INTO `account_active_rate` VALUES ('846', '31', '1', '39', '0', 'zxx', '1505899165725');
INSERT INTO `account_active_rate` VALUES ('847', '32', '1', '39', '0', 'hy123456', '1505899165725');
INSERT INTO `account_active_rate` VALUES ('848', '33', '1', '39', '0', 'wl123', '1505899165725');
INSERT INTO `account_active_rate` VALUES ('849', '34', '1', '39', '0', '鳯儿网店', '1505899165725');
INSERT INTO `account_active_rate` VALUES ('850', '35', '1', '39', '0', 'ruiruima', '1505899165725');
INSERT INTO `account_active_rate` VALUES ('851', '36', '1', '39', '0', '944581678', '1505899165725');
INSERT INTO `account_active_rate` VALUES ('852', '37', '1', '39', '0', '2069959168', '1505899165725');
INSERT INTO `account_active_rate` VALUES ('853', '38', '1', '39', '0', '570156062', '1505899167142');
INSERT INTO `account_active_rate` VALUES ('854', '39', '1', '39', '0', '770733914', '1505899167142');
INSERT INTO `account_active_rate` VALUES ('855', '40', '1', '39', '0', '5257', '1505899167142');
INSERT INTO `account_active_rate` VALUES ('856', '41', '1', '39', '0', '18734158108', '1505899167142');
INSERT INTO `account_active_rate` VALUES ('857', '42', '1', '39', '0', 'xhq1347574865', '1505899167142');
INSERT INTO `account_active_rate` VALUES ('858', '43', '1', '39', '0', 'Chen', '1505899167142');
INSERT INTO `account_active_rate` VALUES ('859', '44', '1', '39', '0', 'qq130496', '1505899167142');
INSERT INTO `account_active_rate` VALUES ('860', '45', '1', '39', '0', 'kevinchow', '1505899167142');
INSERT INTO `account_active_rate` VALUES ('861', '46', '1', '39', '0', '17346544413', '1505899167142');
INSERT INTO `account_active_rate` VALUES ('862', '47', '1', '39', '0', '2480199685', '1505899167142');
INSERT INTO `account_active_rate` VALUES ('863', '48', '1', '39', '0', 'jim145', '1505899168893');
INSERT INTO `account_active_rate` VALUES ('864', '49', '1', '39', '0', 'bada', '1505899168893');
INSERT INTO `account_active_rate` VALUES ('865', '50', '1', '39', '0', '罗大大', '1505899168893');
INSERT INTO `account_active_rate` VALUES ('866', '51', '1', '39', '0', '109', '1505899168893');
INSERT INTO `account_active_rate` VALUES ('867', '52', '1', '39', '0', '119', '1505899168893');
INSERT INTO `account_active_rate` VALUES ('868', '53', '1', '39', '0', 'gigi77', '1505899168893');
INSERT INTO `account_active_rate` VALUES ('869', '55', '1', '39', '0', 'gigi777', '1505899168893');
INSERT INTO `account_active_rate` VALUES ('870', '57', '1', '39', '1', '111111', '0');
INSERT INTO `account_active_rate` VALUES ('871', '58', '1', '39', '0', 'dada', '1505899168893');
INSERT INTO `account_active_rate` VALUES ('872', '59', '1', '39', '0', '源肥呀', '1505899168893');
INSERT INTO `account_active_rate` VALUES ('873', '4', '1', '40', '0', 'wzkj', '1505899313103');
INSERT INTO `account_active_rate` VALUES ('874', '5', '1', '40', '0', '冰河', '1505899313103');
INSERT INTO `account_active_rate` VALUES ('875', '6', '1', '40', '0', 'jiafeng', '1505899313103');
INSERT INTO `account_active_rate` VALUES ('876', '7', '1', '40', '0', 'l474705958', '1505899313103');
INSERT INTO `account_active_rate` VALUES ('877', '8', '1', '40', '0', '184066643', '1505899313103');
INSERT INTO `account_active_rate` VALUES ('878', '9', '1', '40', '0', '2369412', '1505899313103');
INSERT INTO `account_active_rate` VALUES ('879', '10', '1', '40', '0', 'hy123', '1505899313103');
INSERT INTO `account_active_rate` VALUES ('880', '11', '1', '40', '0', 'zishu', '1505899313103');
INSERT INTO `account_active_rate` VALUES ('881', '12', '1', '40', '0', 'tianjing', '1505899313103');
INSERT INTO `account_active_rate` VALUES ('882', '13', '1', '40', '0', 'zqy95178250', '1505899313103');
INSERT INTO `account_active_rate` VALUES ('883', '14', '1', '40', '0', 'QQ574912927', '1505899314728');
INSERT INTO `account_active_rate` VALUES ('884', '15', '1', '40', '0', '1579599827', '1505899314728');
INSERT INTO `account_active_rate` VALUES ('885', '17', '1', '40', '0', '789', '1505899314728');
INSERT INTO `account_active_rate` VALUES ('886', '18', '1', '40', '0', '112', '1505899314728');
INSERT INTO `account_active_rate` VALUES ('887', '20', '1', '40', '0', 'b2218776', '1505899314728');
INSERT INTO `account_active_rate` VALUES ('888', '21', '1', '40', '0', '13771547176', '1505899314728');
INSERT INTO `account_active_rate` VALUES ('889', '22', '1', '40', '0', '1', '1505899314728');
INSERT INTO `account_active_rate` VALUES ('890', '23', '1', '40', '0', '小aq', '1505899314728');
INSERT INTO `account_active_rate` VALUES ('891', '24', '1', '40', '0', '15914897978', '1505899314728');
INSERT INTO `account_active_rate` VALUES ('892', '25', '1', '40', '0', 'oushinanshen', '1505899314728');
INSERT INTO `account_active_rate` VALUES ('893', '26', '1', '40', '0', 'wxx899999', '1505899316696');
INSERT INTO `account_active_rate` VALUES ('894', '27', '1', '40', '0', '1464975293', '1505899316696');
INSERT INTO `account_active_rate` VALUES ('895', '30', '1', '40', '0', 'Bear', '1505899316696');
INSERT INTO `account_active_rate` VALUES ('896', '31', '1', '40', '0', 'zxx', '1505899316696');
INSERT INTO `account_active_rate` VALUES ('897', '32', '1', '40', '0', 'hy123456', '1505899316696');
INSERT INTO `account_active_rate` VALUES ('898', '33', '1', '40', '0', 'wl123', '1505899316696');
INSERT INTO `account_active_rate` VALUES ('899', '34', '1', '40', '0', '鳯儿网店', '1505899316696');
INSERT INTO `account_active_rate` VALUES ('900', '35', '1', '40', '0', 'ruiruima', '1505899316696');
INSERT INTO `account_active_rate` VALUES ('901', '36', '1', '40', '0', '944581678', '1505899316696');
INSERT INTO `account_active_rate` VALUES ('902', '37', '1', '40', '0', '2069959168', '1505899316696');
INSERT INTO `account_active_rate` VALUES ('903', '38', '1', '40', '0', '570156062', '1505899319859');
INSERT INTO `account_active_rate` VALUES ('904', '39', '1', '40', '0', '770733914', '1505899319859');
INSERT INTO `account_active_rate` VALUES ('905', '40', '1', '40', '0', '5257', '1505899319859');
INSERT INTO `account_active_rate` VALUES ('906', '41', '1', '40', '0', '18734158108', '1505899319859');
INSERT INTO `account_active_rate` VALUES ('907', '42', '1', '40', '0', 'xhq1347574865', '1505899319859');
INSERT INTO `account_active_rate` VALUES ('908', '43', '1', '40', '0', 'Chen', '1505899319859');
INSERT INTO `account_active_rate` VALUES ('909', '44', '1', '40', '0', 'qq130496', '1505899319859');
INSERT INTO `account_active_rate` VALUES ('910', '45', '1', '40', '0', 'kevinchow', '1505899319859');
INSERT INTO `account_active_rate` VALUES ('911', '46', '1', '40', '0', '17346544413', '1505899319859');
INSERT INTO `account_active_rate` VALUES ('912', '47', '1', '40', '0', '2480199685', '1505899319859');
INSERT INTO `account_active_rate` VALUES ('913', '48', '1', '40', '0', 'jim145', '1505899321395');
INSERT INTO `account_active_rate` VALUES ('914', '49', '1', '40', '0', 'bada', '1505899321395');
INSERT INTO `account_active_rate` VALUES ('915', '50', '1', '40', '0', '罗大大', '1505899321395');
INSERT INTO `account_active_rate` VALUES ('916', '51', '1', '40', '0', '109', '1505899321395');
INSERT INTO `account_active_rate` VALUES ('917', '52', '1', '40', '0', '119', '1505899321395');
INSERT INTO `account_active_rate` VALUES ('918', '53', '1', '40', '0', 'gigi77', '1505899321395');
INSERT INTO `account_active_rate` VALUES ('919', '55', '1', '40', '0', 'gigi777', '1505899321395');
INSERT INTO `account_active_rate` VALUES ('920', '57', '1', '40', '1', '111111', '0');
INSERT INTO `account_active_rate` VALUES ('921', '58', '1', '40', '0', 'dada', '1505899321395');
INSERT INTO `account_active_rate` VALUES ('922', '59', '1', '40', '0', '源肥呀', '1505899321395');
INSERT INTO `account_active_rate` VALUES ('923', '4', '1', '41', '0', 'wzkj', '1505899412562');
INSERT INTO `account_active_rate` VALUES ('924', '5', '1', '41', '0', '冰河', '1505899412562');
INSERT INTO `account_active_rate` VALUES ('925', '6', '1', '41', '0', 'jiafeng', '1505899412562');
INSERT INTO `account_active_rate` VALUES ('926', '7', '1', '41', '0', 'l474705958', '1505899412562');
INSERT INTO `account_active_rate` VALUES ('927', '8', '1', '41', '0', '184066643', '1505899412562');
INSERT INTO `account_active_rate` VALUES ('928', '9', '1', '41', '0', '2369412', '1505899412562');
INSERT INTO `account_active_rate` VALUES ('929', '10', '1', '41', '0', 'hy123', '1505899412562');
INSERT INTO `account_active_rate` VALUES ('930', '11', '1', '41', '0', 'zishu', '1505899412562');
INSERT INTO `account_active_rate` VALUES ('931', '12', '1', '41', '0', 'tianjing', '1505899412562');
INSERT INTO `account_active_rate` VALUES ('932', '13', '1', '41', '0', 'zqy95178250', '1505899412562');
INSERT INTO `account_active_rate` VALUES ('933', '14', '1', '41', '0', 'QQ574912927', '1505899419050');
INSERT INTO `account_active_rate` VALUES ('934', '15', '1', '41', '0', '1579599827', '1505899419050');
INSERT INTO `account_active_rate` VALUES ('935', '17', '1', '41', '0', '789', '1505899419050');
INSERT INTO `account_active_rate` VALUES ('936', '18', '1', '41', '0', '112', '1505899419050');
INSERT INTO `account_active_rate` VALUES ('937', '20', '1', '41', '0', 'b2218776', '1505899419050');
INSERT INTO `account_active_rate` VALUES ('938', '21', '1', '41', '0', '13771547176', '1505899419050');
INSERT INTO `account_active_rate` VALUES ('939', '22', '1', '41', '0', '1', '1505899419050');
INSERT INTO `account_active_rate` VALUES ('940', '23', '1', '41', '0', '小aq', '1505899419050');
INSERT INTO `account_active_rate` VALUES ('941', '24', '1', '41', '0', '15914897978', '1505899419050');
INSERT INTO `account_active_rate` VALUES ('942', '25', '1', '41', '0', 'oushinanshen', '1505899419050');
INSERT INTO `account_active_rate` VALUES ('943', '26', '1', '41', '0', 'wxx899999', '1505899420668');
INSERT INTO `account_active_rate` VALUES ('944', '27', '1', '41', '0', '1464975293', '1505899420668');
INSERT INTO `account_active_rate` VALUES ('945', '30', '1', '41', '0', 'Bear', '1505899420668');
INSERT INTO `account_active_rate` VALUES ('946', '31', '1', '41', '0', 'zxx', '1505899420668');
INSERT INTO `account_active_rate` VALUES ('947', '32', '1', '41', '0', 'hy123456', '1505899420668');
INSERT INTO `account_active_rate` VALUES ('948', '33', '1', '41', '0', 'wl123', '1505899420668');
INSERT INTO `account_active_rate` VALUES ('949', '34', '1', '41', '0', '鳯儿网店', '1505899420668');
INSERT INTO `account_active_rate` VALUES ('950', '35', '1', '41', '0', 'ruiruima', '1505899420668');
INSERT INTO `account_active_rate` VALUES ('951', '36', '1', '41', '0', '944581678', '1505899420668');
INSERT INTO `account_active_rate` VALUES ('952', '37', '1', '41', '0', '2069959168', '1505899420668');
INSERT INTO `account_active_rate` VALUES ('953', '38', '1', '41', '0', '570156062', '1505899422529');
INSERT INTO `account_active_rate` VALUES ('954', '39', '1', '41', '0', '770733914', '1505899422529');
INSERT INTO `account_active_rate` VALUES ('955', '40', '1', '41', '0', '5257', '1505899422529');
INSERT INTO `account_active_rate` VALUES ('956', '41', '1', '41', '0', '18734158108', '1505899422529');
INSERT INTO `account_active_rate` VALUES ('957', '42', '1', '41', '0', 'xhq1347574865', '1505899422529');
INSERT INTO `account_active_rate` VALUES ('958', '43', '1', '41', '0', 'Chen', '1505899422529');
INSERT INTO `account_active_rate` VALUES ('959', '44', '1', '41', '0', 'qq130496', '1505899422529');
INSERT INTO `account_active_rate` VALUES ('960', '45', '1', '41', '0', 'kevinchow', '1505899422529');
INSERT INTO `account_active_rate` VALUES ('961', '46', '1', '41', '0', '17346544413', '1505899422529');
INSERT INTO `account_active_rate` VALUES ('962', '47', '1', '41', '0', '2480199685', '1505899422529');
INSERT INTO `account_active_rate` VALUES ('963', '48', '1', '41', '0', 'jim145', '1505899424077');
INSERT INTO `account_active_rate` VALUES ('964', '49', '1', '41', '0', 'bada', '1505899424077');
INSERT INTO `account_active_rate` VALUES ('965', '50', '1', '41', '0', '罗大大', '1505899424077');
INSERT INTO `account_active_rate` VALUES ('966', '51', '1', '41', '0', '109', '1505899424077');
INSERT INTO `account_active_rate` VALUES ('967', '52', '1', '41', '0', '119', '1505899424077');
INSERT INTO `account_active_rate` VALUES ('968', '53', '1', '41', '0', 'gigi77', '1505899424077');
INSERT INTO `account_active_rate` VALUES ('969', '55', '1', '41', '0', 'gigi777', '1505899424077');
INSERT INTO `account_active_rate` VALUES ('970', '57', '1', '41', '1', '111111', '0');
INSERT INTO `account_active_rate` VALUES ('971', '58', '1', '41', '0', 'dada', '1505899424077');
INSERT INTO `account_active_rate` VALUES ('972', '59', '1', '41', '0', '源肥呀', '1505899424077');
INSERT INTO `account_active_rate` VALUES ('973', '4', '1', '42', '0', 'wzkj', '1505899503599');
INSERT INTO `account_active_rate` VALUES ('974', '5', '1', '42', '0', '冰河', '1505899503599');
INSERT INTO `account_active_rate` VALUES ('975', '6', '1', '42', '0', 'jiafeng', '1505899503599');
INSERT INTO `account_active_rate` VALUES ('976', '7', '1', '42', '0', 'l474705958', '1505899503599');
INSERT INTO `account_active_rate` VALUES ('977', '8', '1', '42', '0', '184066643', '1505899503599');
INSERT INTO `account_active_rate` VALUES ('978', '9', '1', '42', '0', '2369412', '1505899503599');
INSERT INTO `account_active_rate` VALUES ('979', '10', '1', '42', '0', 'hy123', '1505899503599');
INSERT INTO `account_active_rate` VALUES ('980', '11', '1', '42', '0', 'zishu', '1505899503599');
INSERT INTO `account_active_rate` VALUES ('981', '12', '1', '42', '0', 'tianjing', '1505899503599');
INSERT INTO `account_active_rate` VALUES ('982', '13', '1', '42', '0', 'zqy95178250', '1505899503599');
INSERT INTO `account_active_rate` VALUES ('983', '14', '1', '42', '0', 'QQ574912927', '1505899505224');
INSERT INTO `account_active_rate` VALUES ('984', '15', '1', '42', '0', '1579599827', '1505899505224');
INSERT INTO `account_active_rate` VALUES ('985', '17', '1', '42', '0', '789', '1505899505224');
INSERT INTO `account_active_rate` VALUES ('986', '18', '1', '42', '0', '112', '1505899505224');
INSERT INTO `account_active_rate` VALUES ('987', '20', '1', '42', '0', 'b2218776', '1505899505224');
INSERT INTO `account_active_rate` VALUES ('988', '21', '1', '42', '0', '13771547176', '1505899505224');
INSERT INTO `account_active_rate` VALUES ('989', '22', '1', '42', '0', '1', '1505899505224');
INSERT INTO `account_active_rate` VALUES ('990', '23', '1', '42', '0', '小aq', '1505899505224');
INSERT INTO `account_active_rate` VALUES ('991', '24', '1', '42', '0', '15914897978', '1505899505224');
INSERT INTO `account_active_rate` VALUES ('992', '25', '1', '42', '0', 'oushinanshen', '1505899505224');
INSERT INTO `account_active_rate` VALUES ('993', '26', '1', '42', '0', 'wxx899999', '1505899507051');
INSERT INTO `account_active_rate` VALUES ('994', '27', '1', '42', '0', '1464975293', '1505899507051');
INSERT INTO `account_active_rate` VALUES ('995', '30', '1', '42', '0', 'Bear', '1505899507051');
INSERT INTO `account_active_rate` VALUES ('996', '31', '1', '42', '0', 'zxx', '1505899507051');
INSERT INTO `account_active_rate` VALUES ('997', '32', '1', '42', '0', 'hy123456', '1505899507051');
INSERT INTO `account_active_rate` VALUES ('998', '33', '1', '42', '0', 'wl123', '1505899507051');
INSERT INTO `account_active_rate` VALUES ('999', '34', '1', '42', '0', '鳯儿网店', '1505899507051');
INSERT INTO `account_active_rate` VALUES ('1000', '35', '1', '42', '0', 'ruiruima', '1505899507051');
INSERT INTO `account_active_rate` VALUES ('1001', '36', '1', '42', '0', '944581678', '1505899507051');
INSERT INTO `account_active_rate` VALUES ('1002', '37', '1', '42', '0', '2069959168', '1505899507051');
INSERT INTO `account_active_rate` VALUES ('1003', '38', '1', '42', '0', '570156062', '1505899508773');
INSERT INTO `account_active_rate` VALUES ('1004', '39', '1', '42', '0', '770733914', '1505899508773');
INSERT INTO `account_active_rate` VALUES ('1005', '40', '1', '42', '0', '5257', '1505899508773');
INSERT INTO `account_active_rate` VALUES ('1006', '41', '1', '42', '0', '18734158108', '1505899508773');
INSERT INTO `account_active_rate` VALUES ('1007', '42', '1', '42', '0', 'xhq1347574865', '1505899508773');
INSERT INTO `account_active_rate` VALUES ('1008', '43', '1', '42', '0', 'Chen', '1505899508773');
INSERT INTO `account_active_rate` VALUES ('1009', '44', '1', '42', '0', 'qq130496', '1505899508773');
INSERT INTO `account_active_rate` VALUES ('1010', '45', '1', '42', '0', 'kevinchow', '1505899508773');
INSERT INTO `account_active_rate` VALUES ('1011', '46', '1', '42', '0', '17346544413', '1505899508773');
INSERT INTO `account_active_rate` VALUES ('1012', '47', '1', '42', '0', '2480199685', '1505899508773');
INSERT INTO `account_active_rate` VALUES ('1013', '48', '1', '42', '0', 'jim145', '1505899510350');
INSERT INTO `account_active_rate` VALUES ('1014', '49', '1', '42', '0', 'bada', '1505899510350');
INSERT INTO `account_active_rate` VALUES ('1015', '50', '1', '42', '0', '罗大大', '1505899510350');
INSERT INTO `account_active_rate` VALUES ('1016', '51', '1', '42', '0', '109', '1505899510350');
INSERT INTO `account_active_rate` VALUES ('1017', '52', '1', '42', '0', '119', '1505899510350');
INSERT INTO `account_active_rate` VALUES ('1018', '53', '1', '42', '0', 'gigi77', '1505899510350');
INSERT INTO `account_active_rate` VALUES ('1019', '55', '1', '42', '0', 'gigi777', '1505899510350');
INSERT INTO `account_active_rate` VALUES ('1020', '57', '1', '42', '1', '111111', '0');
INSERT INTO `account_active_rate` VALUES ('1021', '58', '1', '42', '0', 'dada', '1505899510350');
INSERT INTO `account_active_rate` VALUES ('1022', '59', '1', '42', '0', '源肥呀', '1505899510350');
INSERT INTO `account_active_rate` VALUES ('1023', '4', '1', '43', '0', 'wzkj', '1505899601705');
INSERT INTO `account_active_rate` VALUES ('1024', '5', '1', '43', '0', '冰河', '1505899601705');
INSERT INTO `account_active_rate` VALUES ('1025', '6', '1', '43', '0', 'jiafeng', '1505899601705');
INSERT INTO `account_active_rate` VALUES ('1026', '7', '1', '43', '0', 'l474705958', '1505899601705');
INSERT INTO `account_active_rate` VALUES ('1027', '8', '1', '43', '0', '184066643', '1505899601705');
INSERT INTO `account_active_rate` VALUES ('1028', '9', '1', '43', '0', '2369412', '1505899601705');
INSERT INTO `account_active_rate` VALUES ('1029', '10', '1', '43', '0', 'hy123', '1505899601705');
INSERT INTO `account_active_rate` VALUES ('1030', '11', '1', '43', '0', 'zishu', '1505899601705');
INSERT INTO `account_active_rate` VALUES ('1031', '12', '1', '43', '0', 'tianjing', '1505899601705');
INSERT INTO `account_active_rate` VALUES ('1032', '13', '1', '43', '0', 'zqy95178250', '1505899601705');
INSERT INTO `account_active_rate` VALUES ('1033', '14', '1', '43', '0', 'QQ574912927', '1505899603361');
INSERT INTO `account_active_rate` VALUES ('1034', '15', '1', '43', '0', '1579599827', '1505899603361');
INSERT INTO `account_active_rate` VALUES ('1035', '17', '1', '43', '0', '789', '1505899603361');
INSERT INTO `account_active_rate` VALUES ('1036', '18', '1', '43', '0', '112', '1505899603361');
INSERT INTO `account_active_rate` VALUES ('1037', '20', '1', '43', '0', 'b2218776', '1505899603361');
INSERT INTO `account_active_rate` VALUES ('1038', '21', '1', '43', '0', '13771547176', '1505899603361');
INSERT INTO `account_active_rate` VALUES ('1039', '22', '1', '43', '0', '1', '1505899603361');
INSERT INTO `account_active_rate` VALUES ('1040', '23', '1', '43', '0', '小aq', '1505899603361');
INSERT INTO `account_active_rate` VALUES ('1041', '24', '1', '43', '0', '15914897978', '1505899603361');
INSERT INTO `account_active_rate` VALUES ('1042', '25', '1', '43', '0', 'oushinanshen', '1505899603361');
INSERT INTO `account_active_rate` VALUES ('1043', '26', '1', '43', '0', 'wxx899999', '1505899604666');
INSERT INTO `account_active_rate` VALUES ('1044', '27', '1', '43', '0', '1464975293', '1505899604666');
INSERT INTO `account_active_rate` VALUES ('1045', '30', '1', '43', '0', 'Bear', '1505899604666');
INSERT INTO `account_active_rate` VALUES ('1046', '31', '1', '43', '0', 'zxx', '1505899604666');
INSERT INTO `account_active_rate` VALUES ('1047', '32', '1', '43', '0', 'hy123456', '1505899604666');
INSERT INTO `account_active_rate` VALUES ('1048', '33', '1', '43', '0', 'wl123', '1505899604666');
INSERT INTO `account_active_rate` VALUES ('1049', '34', '1', '43', '0', '鳯儿网店', '1505899604666');
INSERT INTO `account_active_rate` VALUES ('1050', '35', '1', '43', '0', 'ruiruima', '1505899604666');
INSERT INTO `account_active_rate` VALUES ('1051', '36', '1', '43', '0', '944581678', '1505899604666');
INSERT INTO `account_active_rate` VALUES ('1052', '37', '1', '43', '0', '2069959168', '1505899604666');
INSERT INTO `account_active_rate` VALUES ('1053', '38', '1', '43', '0', '570156062', '1505899606151');
INSERT INTO `account_active_rate` VALUES ('1054', '39', '1', '43', '0', '770733914', '1505899606151');
INSERT INTO `account_active_rate` VALUES ('1055', '40', '1', '43', '0', '5257', '1505899606151');
INSERT INTO `account_active_rate` VALUES ('1056', '41', '1', '43', '0', '18734158108', '1505899606151');
INSERT INTO `account_active_rate` VALUES ('1057', '42', '1', '43', '0', 'xhq1347574865', '1505899606151');
INSERT INTO `account_active_rate` VALUES ('1058', '43', '1', '43', '0', 'Chen', '1505899606151');
INSERT INTO `account_active_rate` VALUES ('1059', '44', '1', '43', '0', 'qq130496', '1505899606151');
INSERT INTO `account_active_rate` VALUES ('1060', '45', '1', '43', '0', 'kevinchow', '1505899606151');
INSERT INTO `account_active_rate` VALUES ('1061', '46', '1', '43', '0', '17346544413', '1505899606151');
INSERT INTO `account_active_rate` VALUES ('1062', '47', '1', '43', '0', '2480199685', '1505899606151');
INSERT INTO `account_active_rate` VALUES ('1063', '48', '1', '43', '0', 'jim145', '1505899608082');
INSERT INTO `account_active_rate` VALUES ('1064', '49', '1', '43', '0', 'bada', '1505899608082');
INSERT INTO `account_active_rate` VALUES ('1065', '50', '1', '43', '0', '罗大大', '1505899608082');
INSERT INTO `account_active_rate` VALUES ('1066', '51', '1', '43', '0', '109', '1505899608082');
INSERT INTO `account_active_rate` VALUES ('1067', '52', '1', '43', '0', '119', '1505899608082');
INSERT INTO `account_active_rate` VALUES ('1068', '53', '1', '43', '0', 'gigi77', '1505899608082');
INSERT INTO `account_active_rate` VALUES ('1069', '55', '1', '43', '0', 'gigi777', '1505899608082');
INSERT INTO `account_active_rate` VALUES ('1070', '57', '1', '43', '1', '111111', '0');
INSERT INTO `account_active_rate` VALUES ('1071', '58', '1', '43', '0', 'dada', '1505899608082');
INSERT INTO `account_active_rate` VALUES ('1072', '59', '1', '43', '0', '源肥呀', '1505899608082');
INSERT INTO `account_active_rate` VALUES ('1173', '4', '1', '46', '0', 'wzkj', '1505900380262');
INSERT INTO `account_active_rate` VALUES ('1174', '5', '1', '46', '0', '冰河', '1505900380262');
INSERT INTO `account_active_rate` VALUES ('1175', '6', '1', '46', '0', 'jiafeng', '1505900380262');
INSERT INTO `account_active_rate` VALUES ('1176', '7', '1', '46', '0', 'l474705958', '1505900380262');
INSERT INTO `account_active_rate` VALUES ('1177', '8', '1', '46', '0', '184066643', '1505900380262');
INSERT INTO `account_active_rate` VALUES ('1178', '9', '1', '46', '0', '2369412', '1505900380262');
INSERT INTO `account_active_rate` VALUES ('1179', '10', '1', '46', '0', 'hy123', '1505900380262');
INSERT INTO `account_active_rate` VALUES ('1180', '11', '1', '46', '0', 'zishu', '1505900380262');
INSERT INTO `account_active_rate` VALUES ('1181', '12', '1', '46', '0', 'tianjing', '1505900380262');
INSERT INTO `account_active_rate` VALUES ('1182', '13', '1', '46', '0', 'zqy95178250', '1505900380263');
INSERT INTO `account_active_rate` VALUES ('1183', '14', '1', '46', '0', 'QQ574912927', '1505900381840');
INSERT INTO `account_active_rate` VALUES ('1184', '15', '1', '46', '0', '1579599827', '1505900381840');
INSERT INTO `account_active_rate` VALUES ('1185', '17', '1', '46', '0', '789', '1505900381840');
INSERT INTO `account_active_rate` VALUES ('1186', '18', '1', '46', '0', '112', '1505900381840');
INSERT INTO `account_active_rate` VALUES ('1187', '20', '1', '46', '0', 'b2218776', '1505900381840');
INSERT INTO `account_active_rate` VALUES ('1188', '21', '1', '46', '0', '13771547176', '1505900381840');
INSERT INTO `account_active_rate` VALUES ('1189', '22', '1', '46', '0', '1', '1505900381840');
INSERT INTO `account_active_rate` VALUES ('1190', '23', '1', '46', '0', '小aq', '1505900381840');
INSERT INTO `account_active_rate` VALUES ('1191', '24', '1', '46', '0', '15914897978', '1505900381840');
INSERT INTO `account_active_rate` VALUES ('1192', '25', '1', '46', '0', 'oushinanshen', '1505900381840');
INSERT INTO `account_active_rate` VALUES ('1193', '26', '1', '46', '0', 'wxx899999', '1505900383582');
INSERT INTO `account_active_rate` VALUES ('1194', '27', '1', '46', '0', '1464975293', '1505900383582');
INSERT INTO `account_active_rate` VALUES ('1195', '30', '1', '46', '0', 'Bear', '1505900383582');
INSERT INTO `account_active_rate` VALUES ('1196', '31', '1', '46', '0', 'zxx', '1505900383582');
INSERT INTO `account_active_rate` VALUES ('1197', '32', '1', '46', '0', 'hy123456', '1505900383582');
INSERT INTO `account_active_rate` VALUES ('1198', '33', '1', '46', '0', 'wl123', '1505900383582');
INSERT INTO `account_active_rate` VALUES ('1199', '34', '1', '46', '0', '鳯儿网店', '1505900383582');
INSERT INTO `account_active_rate` VALUES ('1200', '35', '1', '46', '0', 'ruiruima', '1505900383582');
INSERT INTO `account_active_rate` VALUES ('1201', '36', '1', '46', '0', '944581678', '1505900383582');
INSERT INTO `account_active_rate` VALUES ('1202', '37', '1', '46', '0', '2069959168', '1505900383582');
INSERT INTO `account_active_rate` VALUES ('1203', '38', '1', '46', '0', '570156062', '1505900386015');
INSERT INTO `account_active_rate` VALUES ('1204', '39', '1', '46', '0', '770733914', '1505900386015');
INSERT INTO `account_active_rate` VALUES ('1205', '40', '1', '46', '0', '5257', '1505900386015');
INSERT INTO `account_active_rate` VALUES ('1206', '41', '1', '46', '0', '18734158108', '1505900386015');
INSERT INTO `account_active_rate` VALUES ('1207', '42', '1', '46', '0', 'xhq1347574865', '1505900386015');
INSERT INTO `account_active_rate` VALUES ('1208', '43', '1', '46', '0', 'Chen', '1505900386015');
INSERT INTO `account_active_rate` VALUES ('1209', '44', '1', '46', '0', 'qq130496', '1505900386015');
INSERT INTO `account_active_rate` VALUES ('1210', '45', '1', '46', '0', 'kevinchow', '1505900386015');
INSERT INTO `account_active_rate` VALUES ('1211', '46', '1', '46', '0', '17346544413', '1505900386015');
INSERT INTO `account_active_rate` VALUES ('1212', '47', '1', '46', '0', '2480199685', '1505900386015');
INSERT INTO `account_active_rate` VALUES ('1213', '48', '1', '46', '0', 'jim145', '1505900387889');
INSERT INTO `account_active_rate` VALUES ('1214', '49', '1', '46', '0', 'bada', '1505900387889');
INSERT INTO `account_active_rate` VALUES ('1215', '50', '1', '46', '0', '罗大大', '1505900387889');
INSERT INTO `account_active_rate` VALUES ('1216', '51', '1', '46', '0', '109', '1505900387889');
INSERT INTO `account_active_rate` VALUES ('1217', '52', '1', '46', '0', '119', '1505900387889');
INSERT INTO `account_active_rate` VALUES ('1218', '53', '1', '46', '0', 'gigi77', '1505900387889');
INSERT INTO `account_active_rate` VALUES ('1219', '55', '1', '46', '0', 'gigi777', '1505900387889');
INSERT INTO `account_active_rate` VALUES ('1220', '57', '1', '46', '1', '111111', '0');
INSERT INTO `account_active_rate` VALUES ('1221', '58', '1', '46', '0', 'dada', '1505900387889');
INSERT INTO `account_active_rate` VALUES ('1222', '59', '1', '46', '0', '源肥呀', '1505900387889');
INSERT INTO `account_active_rate` VALUES ('1223', '3', '2', '47', '0', '456', '1505919246683');
INSERT INTO `account_active_rate` VALUES ('1224', '60', '1', '46', '0', '764388753', '1505958123826');
INSERT INTO `account_active_rate` VALUES ('1225', '61', '1', '46', '0', '815555213', '1505958123826');
INSERT INTO `account_active_rate` VALUES ('1226', '60', '1', '36', '0', '764388753', '1505958137853');
INSERT INTO `account_active_rate` VALUES ('1227', '61', '1', '36', '0', '815555213', '1505958137853');
INSERT INTO `account_active_rate` VALUES ('1228', '60', '1', '43', '0', '764388753', '1505958522240');
INSERT INTO `account_active_rate` VALUES ('1229', '61', '1', '43', '0', '815555213', '1505958522240');
INSERT INTO `account_active_rate` VALUES ('1230', '61', '1', '46', '0', '无厘头', '1505986790229');
INSERT INTO `account_active_rate` VALUES ('1231', '54', '1', '49', '0', '123', '1507875851032');

-- ----------------------------
-- Table structure for `account_purchase`
-- ----------------------------
DROP TABLE IF EXISTS `account_purchase`;
CREATE TABLE `account_purchase` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) DEFAULT NULL,
  `purchase_id` bigint(20) DEFAULT NULL,
  `rate_discount_id` bigint(20) DEFAULT NULL,
  `order_amount` double DEFAULT NULL COMMENT '充值金额(成本）',
  `order_platform_path` int(11) DEFAULT NULL COMMENT '订单来源（0-网页，1-接口）',
  `order_price` double DEFAULT NULL COMMENT '下级代理商的扣款',
  `from_agency_name` varchar(255) DEFAULT NULL COMMENT '订单来源代理商名称',
  `order_state` int(11) DEFAULT NULL COMMENT '代理商的订单状态',
  `order_state_detail` varchar(255) DEFAULT NULL COMMENT '代理商的订单状态详情',
  `from_account_id` int(11) DEFAULT NULL,
  `record_id` bigint(20) DEFAULT NULL COMMENT '消费记录id',
  PRIMARY KEY (`id`),
  KEY `fk_ap_agency` (`account_id`),
  KEY `fk_ap_purchase` (`purchase_id`),
  KEY `fk_ap_rateDiscount` (`rate_discount_id`),
  KEY `fk_ap_record` (`record_id`),
  CONSTRAINT `fk)ap_account` FOREIGN KEY (`account_id`) REFERENCES `charge_account` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_ap_purchase` FOREIGN KEY (`purchase_id`) REFERENCES `purchase` (`order_id`) ON DELETE CASCADE,
  CONSTRAINT `fk_ap_record` FOREIGN KEY (`record_id`) REFERENCES `charge_record` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account_purchase
-- ----------------------------
INSERT INTO `account_purchase` VALUES ('29', '2', '734955636709658624', '19', '2.01', '0', '2.01', '123', '0', '系统：失败', '2', '41');
INSERT INTO `account_purchase` VALUES ('30', '1', '734955636709658624', '19', '1.995', '2', '2.01', '123', '0', '系统：失败', null, '42');
INSERT INTO `account_purchase` VALUES ('31', '2', '734968246582644736', '19', '2.01', '0', '2.01', '123', '0', '系统：失败', '2', '43');
INSERT INTO `account_purchase` VALUES ('32', '1', '734968246582644736', '19', '1.995', '2', '2.01', '123', '0', '系统：失败', null, '44');
INSERT INTO `account_purchase` VALUES ('33', '1', '734991771976601600', null, '2.85', '0', '2.85', 'xiao', '0', '系统：失败', null, '45');
INSERT INTO `account_purchase` VALUES ('34', '1', '734992684296441856', null, '2.85', '0', '2.85', 'xiao', '0', '系统：失败', null, '46');
INSERT INTO `account_purchase` VALUES ('35', '2', '735263809198886912', '21', '1.74', '0', '1.74', '123', '0', '系统：失败', '2', '48');
INSERT INTO `account_purchase` VALUES ('36', '1', '735263809198886912', '21', '1.71', '2', '1.74', '123', '0', '系统：失败', null, '49');
INSERT INTO `account_purchase` VALUES ('37', '2', '735556856507797504', '21', '1.74', '0', '1.74', '123', '0', '系统：失败', '2', '50');
INSERT INTO `account_purchase` VALUES ('38', '1', '735556856507797504', '21', '1.71', '2', '1.74', '123', '0', '系统：失败', null, '51');
INSERT INTO `account_purchase` VALUES ('39', '1', '735565336828448768', '15', '1.71', '0', '1.71', 'xiao', '0', '系统：失败', null, '54');
INSERT INTO `account_purchase` VALUES ('40', '1', '735637674362146816', '25', '0.99', '0', '0.99', 'xiao', '0', '系统：失败', null, '57');
INSERT INTO `account_purchase` VALUES ('41', '1', '735643477341114368', '25', '0.99', '0', '0.99', 'xiao', '0', '系统：失败', null, '58');
INSERT INTO `account_purchase` VALUES ('42', '10', '735691086504136704', '25', '92.4', '0', '92.4', 'hy123', '0', '系统：失败', '10', '60');
INSERT INTO `account_purchase` VALUES ('43', '1', '735691086504136704', '25', '92.4', '2', '92.4', 'hy123', '0', '系统：失败', null, '61');
INSERT INTO `account_purchase` VALUES ('44', '32', '735696617457324032', '25', '92.4', '0', '92.4', 'wl123', '0', '系统：失败', '32', '62');
INSERT INTO `account_purchase` VALUES ('45', '1', '735696617457324032', '25', '92.4', '2', '92.4', 'wl123', '0', '系统：失败', null, '63');
INSERT INTO `account_purchase` VALUES ('46', '32', '735696780196319232', '25', '92.4', '0', '92.4', 'wl123', '0', '系统：失败', '32', '64');
INSERT INTO `account_purchase` VALUES ('47', '1', '735696780196319232', '25', '92.4', '2', '92.4', 'wl123', '0', '系统：失败', null, '65');
INSERT INTO `account_purchase` VALUES ('48', '32', '735701276200800256', '25', '92.4', '0', '92.4', 'wl123', '0', '系统：失败', '32', '66');
INSERT INTO `account_purchase` VALUES ('49', '1', '735701276200800256', '25', '92.4', '2', '92.4', 'wl123', '0', '系统：失败', null, '67');
INSERT INTO `account_purchase` VALUES ('50', '39', '735918403251867648', '25', '0.99', '0', '0.99', '5257', '0', '系统：失败', '39', '72');
INSERT INTO `account_purchase` VALUES ('51', '1', '735918403251867648', '25', '0.99', '2', '0.99', '5257', '0', '系统：失败', null, '73');
INSERT INTO `account_purchase` VALUES ('52', '39', '736056020098355200', '25', '0.99', '0', '0.99', '5257', '0', '系统：失败', '39', '76');
INSERT INTO `account_purchase` VALUES ('53', '1', '736056020098355200', '25', '0.99', '2', '0.99', '5257', '0', '系统：失败', null, '77');
INSERT INTO `account_purchase` VALUES ('54', '39', '736063456880365568', '25', '9.9', '0', '9.9', '5257', '0', '系统：失败', '39', '80');
INSERT INTO `account_purchase` VALUES ('55', '1', '736063456880365568', '25', '9.9', '2', '9.9', '5257', '0', '系统：失败', null, '81');
INSERT INTO `account_purchase` VALUES ('56', '2', '736283369150615552', '27', '9.9', '0', '9.9', '123', '0', '系统：失败', '2', '86');
INSERT INTO `account_purchase` VALUES ('57', '1', '736283369150615552', '27', '9.9', '2', '9.9', '123', '0', '系统：失败', null, '87');
INSERT INTO `account_purchase` VALUES ('58', '55', '736322784392646656', '27', '23.1', '0', '23.1', '111111', '0', '系统：失败', '55', '92');
INSERT INTO `account_purchase` VALUES ('59', '1', '736322784392646656', '27', '23.1', '2', '23.1', '111111', '0', '系统：失败', null, '93');
INSERT INTO `account_purchase` VALUES ('60', '55', '736326301064892416', '27', '21.7', '0', '21.7', '111111', '0', '系统：失败', '55', '96');
INSERT INTO `account_purchase` VALUES ('61', '1', '736326301064892416', '27', '23.1', '2', '21.7', '111111', '0', '系统：失败', null, '97');
INSERT INTO `account_purchase` VALUES ('62', '7', '736402598193532928', '45', '15.5', '0', '15.5', 'l474705958', '0', '系统：失败', '7', '100');
INSERT INTO `account_purchase` VALUES ('63', '1', '736402598193532928', '45', '15.5', '2', '15.5', 'l474705958', '0', '系统：失败', null, '101');
INSERT INTO `account_purchase` VALUES ('64', '39', '736437229278203904', '46', '3.1', '0', '3.1', '5257', '0', '系统：失败', '39', '150');
INSERT INTO `account_purchase` VALUES ('65', '1', '736437229278203904', '46', '3.1', '2', '3.1', '5257', '0', '系统：失败', null, '151');
INSERT INTO `account_purchase` VALUES ('66', '7', '736450404098772992', '46', '15.5', '0', '15.5', 'l474705958', '0', '系统：失败', '7', '152');
INSERT INTO `account_purchase` VALUES ('67', '1', '736450404098772992', '46', '15.5', '2', '15.5', 'l474705958', '0', '系统：失败', null, '153');
INSERT INTO `account_purchase` VALUES ('68', '7', '736465259857973248', '46', '21.7', '0', '21.7', 'l474705958', '0', '系统：失败', '7', '156');
INSERT INTO `account_purchase` VALUES ('69', '1', '736465259857973248', '46', '21.7', '2', '21.7', 'l474705958', '0', '系统：失败', null, '157');
INSERT INTO `account_purchase` VALUES ('70', '7', '736465769222639616', '46', '21.7', '0', '21.7', 'l474705958', '0', '系统：失败', '7', '158');
INSERT INTO `account_purchase` VALUES ('71', '1', '736465769222639616', '46', '21.7', '2', '21.7', 'l474705958', '0', '系统：失败', null, '159');
INSERT INTO `account_purchase` VALUES ('72', '7', '736471316961431552', '46', '40.3', '0', '40.3', 'l474705958', '0', '系统：失败', '7', '160');
INSERT INTO `account_purchase` VALUES ('73', '1', '736471316961431552', '46', '40.3', '2', '40.3', 'l474705958', '0', '系统：失败', null, '161');
INSERT INTO `account_purchase` VALUES ('74', '7', '736474802667130880', '46', '31', '0', '31', 'l474705958', '0', '系统：失败', '7', '162');
INSERT INTO `account_purchase` VALUES ('75', '1', '736474802667130880', '46', '31', '2', '31', 'l474705958', '0', '系统：失败', null, '163');
INSERT INTO `account_purchase` VALUES ('76', '3', '736483154348478464', '47', '1.74', '0', '1.74', '456', '0', '系统：失败', '3', '166');
INSERT INTO `account_purchase` VALUES ('77', '2', '736483154348478464', '23', '1.71', '2', '1.74', '456', '0', '系统：失败', null, '167');
INSERT INTO `account_purchase` VALUES ('78', '1', '736483154348478464', '23', '1.38', '2', '1.71', '456', '0', '系统：失败', null, '168');
INSERT INTO `account_purchase` VALUES ('79', '7', '736673432812392448', '46', '15.5', '0', '15.5', 'l474705958', '0', '系统：失败', '7', '169');
INSERT INTO `account_purchase` VALUES ('80', '1', '736673432812392448', '46', '15.5', '2', '15.5', 'l474705958', '0', '系统：失败', null, '170');
INSERT INTO `account_purchase` VALUES ('81', '7', '736709519052115968', '46', '40.3', '0', '40.3', 'l474705958', '0', '系统：失败', '7', '171');
INSERT INTO `account_purchase` VALUES ('82', '1', '736709519052115968', '46', '40.3', '2', '40.3', 'l474705958', '0', '系统：失败', null, '172');
INSERT INTO `account_purchase` VALUES ('83', '26', '736766071347875840', '46', '21.7', '0', '21.7', 'wxx899999', '0', '系统：失败', '26', '175');
INSERT INTO `account_purchase` VALUES ('84', '1', '736766071347875840', '46', '21.7', '2', '21.7', 'wxx899999', '0', '系统：失败', null, '176');
INSERT INTO `account_purchase` VALUES ('91', '2', '738549100521197568', '23', '1.71', '0', '1.71', '123', '0', '系统：失败', '2', '182');
INSERT INTO `account_purchase` VALUES ('92', '1', '738549100521197568', '23', '1.38', '2', '1.71', '123', '0', '系统：失败', '2', '183');
INSERT INTO `account_purchase` VALUES ('93', '2', '738564868096921600', '23', '1.71', '0', '1.71', '123', '0', '系统：失败', '2', '184');
INSERT INTO `account_purchase` VALUES ('94', '1', '738564868096921600', '19', '1.38', '2', '1.71', '123', '0', '系统：失败', '2', '185');
INSERT INTO `account_purchase` VALUES ('95', '2', '738566427362988032', '23', '1.71', '0', '1.71', '123', '0', '系统：失败', '2', '186');
INSERT INTO `account_purchase` VALUES ('96', '1', '738566427362988032', '19', '1.38', '2', '1.71', '123', '0', '系统：失败', '2', '187');
INSERT INTO `account_purchase` VALUES ('97', '2', '738813373969338368', '23', '1.71', '0', '1.71', '123', '2', '正在充值', '2', '193');
INSERT INTO `account_purchase` VALUES ('98', '1', '738813373969338368', '19', '1.38', '2', '1.71', '123', null, null, '2', '194');
INSERT INTO `account_purchase` VALUES ('99', '3', '738815199615651840', '47', '1.74', '0', '1.74', '456', '2', '正在充值', '3', '195');
INSERT INTO `account_purchase` VALUES ('100', '2', '738815199615651840', '23', '1.71', '2', '1.74', '456', '2', '正在充值', '3', '196');
INSERT INTO `account_purchase` VALUES ('101', '1', '738815199615651840', '19', '1.38', '2', '1.71', null, '3', '通道暂停等待', '2', '196');
INSERT INTO `account_purchase` VALUES ('102', '3', '738816343100362752', '47', '1.74', '0', '1.74', '456', '2', '正在充值', '3', '198');
INSERT INTO `account_purchase` VALUES ('103', '2', '738816343100362752', '23', '1.71', '2', '1.74', '456', '2', '正在充值', '3', '199');
INSERT INTO `account_purchase` VALUES ('104', '1', '738816343100362752', '19', '1.38', '2', '1.71', null, '3', '通道暂停等待', '2', '199');
INSERT INTO `account_purchase` VALUES ('105', '3', '738817927960072192', '47', '1.74', '0', '1.74', '456', '2', '正在充值', '3', '201');
INSERT INTO `account_purchase` VALUES ('106', '2', '738817927960072192', '23', '1.71', '2', '1.74', '456', '2', '正在充值', '3', '202');
INSERT INTO `account_purchase` VALUES ('107', '1', '738817927960072192', '19', '1.38', '2', '1.71', '123', '3', '通道暂停等待', '2', '202');
INSERT INTO `account_purchase` VALUES ('108', '3', '738823326721380352', '47', '1.74', '0', '1.74', '456', '2', '正在充值', '3', '204');
INSERT INTO `account_purchase` VALUES ('109', '2', '738823326721380352', '23', '1.71', '2', '1.74', '456', '2', '正在充值', '3', '205');
INSERT INTO `account_purchase` VALUES ('110', '1', '738823326721380352', '19', '1.38', '2', '1.71', '123', '3', '通道暂停等待', '2', '205');
INSERT INTO `account_purchase` VALUES ('111', '3', '738824633628758016', '47', '1.74', '0', '1.74', '456', '2', '正在充值', '3', '207');
INSERT INTO `account_purchase` VALUES ('112', '2', '738824633628758016', '23', '1.71', '2', '1.74', '456', '2', '正在充值', '3', '208');
INSERT INTO `account_purchase` VALUES ('113', '1', '738824633628758016', '19', '1.38', '2', '1.71', '123', '3', '通道暂停等待', '2', '208');
INSERT INTO `account_purchase` VALUES ('114', '3', '738827550343565312', '47', '1.74', '0', '1.74', '456', '2', '正在充值', '3', '210');
INSERT INTO `account_purchase` VALUES ('115', '2', '738827550343565312', '23', '1.71', '2', '1.74', '456', '2', '正在充值', '3', '211');
INSERT INTO `account_purchase` VALUES ('116', '1', '738827550343565312', '19', '1.38', '2', '1.71', '123', '3', '通道暂停等待', '2', '212');
INSERT INTO `account_purchase` VALUES ('117', '2', '738830028967514112', '23', '1.71', '0', '1.71', '123', '2', '正在充值', '2', '213');
INSERT INTO `account_purchase` VALUES ('118', '1', '738830028967514112', '19', '1.38', '2', '1.71', '123', '3', '通道暂停等待', '2', '214');
INSERT INTO `account_purchase` VALUES ('119', '2', '742911737304453120', '23', '1.71', '0', '1.71', '123', '2', '系统：正在充值', '2', '219');
INSERT INTO `account_purchase` VALUES ('120', '1', '742911737304453120', '19', '1.38', '2', '1.71', '123', '2', '系统：正在充值', '2', '220');
INSERT INTO `account_purchase` VALUES ('121', '2', '742913528372924416', '23', '1.71', '0', '1.71', '123', '2', '系统：正在充值', '2', '221');
INSERT INTO `account_purchase` VALUES ('122', '1', '742913528372924416', '19', '1.38', '2', '1.71', '123', '2', '系统：正在充值', '2', '222');

-- ----------------------------
-- Table structure for `agency_active_rate`
-- ----------------------------
DROP TABLE IF EXISTS `agency_active_rate`;
CREATE TABLE `agency_active_rate` (
  `id` bigint(20) NOT NULL DEFAULT '0' COMMENT '连接id',
  `agency_id` int(11) DEFAULT NULL,
  `bind_agency_id` int(255) DEFAULT NULL COMMENT '绑定人Id',
  `rate_discount_id` bigint(11) DEFAULT NULL COMMENT '费率折扣id',
  `bind_state` int(11) DEFAULT '0' COMMENT '绑定状态（0-已绑定，1-未绑定）',
  `agency_name` varchar(255) DEFAULT NULL,
  `active_time` bigint(20) DEFAULT NULL COMMENT '连接时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of agency_active_rate
-- ----------------------------
INSERT INTO `agency_active_rate` VALUES ('35', '2', '1', '22', '1', '123', '0');
INSERT INTO `agency_active_rate` VALUES ('36', '4', '1', '22', '1', 'wzkj', '0');
INSERT INTO `agency_active_rate` VALUES ('37', '2', '1', '23', '0', '123', '1505707720453');
INSERT INTO `agency_active_rate` VALUES ('38', '4', '1', '23', '0', 'wzkj', '1505707720453');
INSERT INTO `agency_active_rate` VALUES ('39', '5', '1', '23', '0', '冰河', '1505707720453');
INSERT INTO `agency_active_rate` VALUES ('40', '6', '1', '23', '0', 'jiafeng', '1505707720453');
INSERT INTO `agency_active_rate` VALUES ('41', '7', '1', '23', '0', 'l474705958', '1505707720453');
INSERT INTO `agency_active_rate` VALUES ('42', '8', '1', '23', '0', '184066643', '1505707720453');
INSERT INTO `agency_active_rate` VALUES ('43', '9', '1', '23', '0', '2369412', '1505707720453');
INSERT INTO `agency_active_rate` VALUES ('44', '10', '1', '23', '0', 'hy123', '1505707720453');
INSERT INTO `agency_active_rate` VALUES ('45', '11', '1', '23', '0', 'zishu', '1505707720453');
INSERT INTO `agency_active_rate` VALUES ('46', '12', '1', '23', '0', 'tianjing', '1505707720453');
INSERT INTO `agency_active_rate` VALUES ('47', '13', '1', '23', '0', 'zqy95178250', '1505707793755');
INSERT INTO `agency_active_rate` VALUES ('48', '14', '1', '23', '0', 'QQ574912927', '1505707793755');
INSERT INTO `agency_active_rate` VALUES ('49', '15', '1', '23', '0', '1579599827', '1505707793755');
INSERT INTO `agency_active_rate` VALUES ('50', '17', '1', '23', '0', '789', '1505707793755');
INSERT INTO `agency_active_rate` VALUES ('51', '18', '1', '23', '0', '112', '1505707793755');
INSERT INTO `agency_active_rate` VALUES ('52', '20', '1', '23', '0', 'b2218776', '1505707793755');
INSERT INTO `agency_active_rate` VALUES ('53', '21', '1', '23', '0', '13771547176', '1505707793755');
INSERT INTO `agency_active_rate` VALUES ('86', '2', '1', '26', '0', '123', '1505731154644');
INSERT INTO `agency_active_rate` VALUES ('87', '4', '1', '26', '0', 'wzkj', '1505731154644');
INSERT INTO `agency_active_rate` VALUES ('88', '5', '1', '26', '0', '冰河', '1505731154644');
INSERT INTO `agency_active_rate` VALUES ('89', '6', '1', '26', '0', 'jiafeng', '1505731154644');
INSERT INTO `agency_active_rate` VALUES ('90', '7', '1', '26', '0', 'l474705958', '1505731154644');
INSERT INTO `agency_active_rate` VALUES ('91', '8', '1', '26', '0', '184066643', '1505731154644');
INSERT INTO `agency_active_rate` VALUES ('92', '9', '1', '26', '0', '2369412', '1505731154644');
INSERT INTO `agency_active_rate` VALUES ('93', '10', '1', '26', '0', 'hy123', '1505731154644');
INSERT INTO `agency_active_rate` VALUES ('94', '11', '1', '26', '0', 'zishu', '1505731154644');
INSERT INTO `agency_active_rate` VALUES ('95', '12', '1', '26', '0', 'tianjing', '1505731154644');
INSERT INTO `agency_active_rate` VALUES ('96', '13', '1', '26', '0', 'zqy95178250', '1505731158002');
INSERT INTO `agency_active_rate` VALUES ('97', '14', '1', '26', '0', 'QQ574912927', '1505731158002');
INSERT INTO `agency_active_rate` VALUES ('98', '15', '1', '26', '0', '1579599827', '1505731158002');
INSERT INTO `agency_active_rate` VALUES ('99', '17', '1', '26', '0', '789', '1505731158002');
INSERT INTO `agency_active_rate` VALUES ('100', '18', '1', '26', '0', '112', '1505731158002');
INSERT INTO `agency_active_rate` VALUES ('101', '20', '1', '26', '0', 'b2218776', '1505731158002');
INSERT INTO `agency_active_rate` VALUES ('102', '21', '1', '26', '0', '13771547176', '1505731158002');
INSERT INTO `agency_active_rate` VALUES ('103', '22', '1', '26', '0', '1', '1505731158002');
INSERT INTO `agency_active_rate` VALUES ('104', '23', '1', '26', '0', '小aq', '1505731158002');
INSERT INTO `agency_active_rate` VALUES ('105', '24', '1', '26', '0', '15914897978', '1505731158002');
INSERT INTO `agency_active_rate` VALUES ('106', '25', '1', '26', '0', 'oushinanshen', '1505731160500');
INSERT INTO `agency_active_rate` VALUES ('107', '26', '1', '26', '0', 'wxx899999', '1505731160500');
INSERT INTO `agency_active_rate` VALUES ('108', '27', '1', '26', '0', '1464975293', '1505731160500');
INSERT INTO `agency_active_rate` VALUES ('109', '28', '1', '26', '0', 'Bear', '1505731160500');
INSERT INTO `agency_active_rate` VALUES ('110', '29', '1', '26', '0', 'zxx', '1505731160500');
INSERT INTO `agency_active_rate` VALUES ('114', '30', '1', '26', '0', 'hy123456', '1505744206093');
INSERT INTO `agency_active_rate` VALUES ('115', '31', '1', '26', '0', 'wl123', '1505744206093');
INSERT INTO `agency_active_rate` VALUES ('116', '32', '1', '26', '0', '鳯儿网店', '1505744206093');
INSERT INTO `agency_active_rate` VALUES ('117', '33', '1', '26', '0', 'ruiruima', '1505744206093');
INSERT INTO `agency_active_rate` VALUES ('118', '34', '1', '26', '0', '944581678', '1505744206093');
INSERT INTO `agency_active_rate` VALUES ('119', '35', '1', '26', '0', '2069959168', '1505744206093');
INSERT INTO `agency_active_rate` VALUES ('120', '36', '1', '26', '0', '570156062', '1505744206093');
INSERT INTO `agency_active_rate` VALUES ('121', '37', '1', '26', '0', '770733914', '1505744206093');
INSERT INTO `agency_active_rate` VALUES ('122', '38', '1', '26', '0', '5257', '1505744206093');
INSERT INTO `agency_active_rate` VALUES ('123', '39', '1', '26', '0', '18734158108', '1505744206093');
INSERT INTO `agency_active_rate` VALUES ('124', '40', '1', '26', '0', 'xhq1347574865', '1505744208055');
INSERT INTO `agency_active_rate` VALUES ('154', '5', '1', '22', '0', '冰河', '1505744248587');
INSERT INTO `agency_active_rate` VALUES ('155', '6', '1', '22', '0', 'jiafeng', '1505744248587');
INSERT INTO `agency_active_rate` VALUES ('156', '7', '1', '22', '0', 'l474705958', '1505744248587');
INSERT INTO `agency_active_rate` VALUES ('157', '8', '1', '22', '0', '184066643', '1505744248587');
INSERT INTO `agency_active_rate` VALUES ('158', '9', '1', '22', '0', '2369412', '1505744248587');
INSERT INTO `agency_active_rate` VALUES ('159', '10', '1', '22', '0', 'hy123', '1505744248587');
INSERT INTO `agency_active_rate` VALUES ('160', '11', '1', '22', '0', 'zishu', '1505744248587');
INSERT INTO `agency_active_rate` VALUES ('161', '12', '1', '22', '0', 'tianjing', '1505744248587');
INSERT INTO `agency_active_rate` VALUES ('162', '13', '1', '22', '0', 'zqy95178250', '1505744248587');
INSERT INTO `agency_active_rate` VALUES ('163', '14', '1', '22', '0', 'QQ574912927', '1505744248587');
INSERT INTO `agency_active_rate` VALUES ('164', '15', '1', '22', '0', '1579599827', '1505744253873');
INSERT INTO `agency_active_rate` VALUES ('165', '17', '1', '22', '0', '789', '1505744253873');
INSERT INTO `agency_active_rate` VALUES ('166', '18', '1', '22', '0', '112', '1505744253873');
INSERT INTO `agency_active_rate` VALUES ('167', '20', '1', '22', '0', 'b2218776', '1505744253873');
INSERT INTO `agency_active_rate` VALUES ('168', '21', '1', '22', '0', '13771547176', '1505744253873');
INSERT INTO `agency_active_rate` VALUES ('169', '22', '1', '22', '0', '1', '1505744253873');
INSERT INTO `agency_active_rate` VALUES ('170', '23', '1', '22', '0', '小aq', '1505744253873');
INSERT INTO `agency_active_rate` VALUES ('171', '24', '1', '22', '0', '15914897978', '1505744253873');
INSERT INTO `agency_active_rate` VALUES ('172', '25', '1', '22', '0', 'oushinanshen', '1505744253873');
INSERT INTO `agency_active_rate` VALUES ('173', '26', '1', '22', '0', 'wxx899999', '1505744253873');
INSERT INTO `agency_active_rate` VALUES ('174', '27', '1', '22', '0', '1464975293', '1505744255935');
INSERT INTO `agency_active_rate` VALUES ('175', '28', '1', '22', '0', 'Bear', '1505744255935');
INSERT INTO `agency_active_rate` VALUES ('176', '29', '1', '22', '0', 'zxx', '1505744255935');
INSERT INTO `agency_active_rate` VALUES ('177', '30', '1', '22', '0', 'hy123456', '1505744255935');
INSERT INTO `agency_active_rate` VALUES ('178', '31', '1', '22', '0', 'wl123', '1505744255935');
INSERT INTO `agency_active_rate` VALUES ('179', '32', '1', '22', '0', '鳯儿网店', '1505744255935');
INSERT INTO `agency_active_rate` VALUES ('180', '33', '1', '22', '0', 'ruiruima', '1505744255935');
INSERT INTO `agency_active_rate` VALUES ('181', '34', '1', '22', '0', '944581678', '1505744255935');
INSERT INTO `agency_active_rate` VALUES ('182', '35', '1', '22', '0', '2069959168', '1505744255935');
INSERT INTO `agency_active_rate` VALUES ('183', '36', '1', '22', '0', '570156062', '1505744255935');
INSERT INTO `agency_active_rate` VALUES ('184', '37', '1', '22', '0', '770733914', '1505744258448');
INSERT INTO `agency_active_rate` VALUES ('185', '38', '1', '22', '0', '5257', '1505744258448');
INSERT INTO `agency_active_rate` VALUES ('186', '39', '1', '22', '0', '18734158108', '1505744258448');
INSERT INTO `agency_active_rate` VALUES ('187', '40', '1', '22', '0', 'xhq1347574865', '1505744258448');
INSERT INTO `agency_active_rate` VALUES ('188', '41', '1', '26', '0', 'Chen', '1505745428700');
INSERT INTO `agency_active_rate` VALUES ('189', '42', '1', '26', '0', 'qq130496', '1505745428700');
INSERT INTO `agency_active_rate` VALUES ('190', '43', '1', '26', '0', 'kevinchow', '1505745428700');
INSERT INTO `agency_active_rate` VALUES ('191', '44', '1', '26', '0', '17346544413', '1505745428700');
INSERT INTO `agency_active_rate` VALUES ('254', '45', '1', '26', '0', '2480199685', '1505829677290');
INSERT INTO `agency_active_rate` VALUES ('255', '46', '1', '26', '0', 'jim145', '1505829677290');
INSERT INTO `agency_active_rate` VALUES ('256', '47', '1', '26', '0', 'bada', '1505829677290');
INSERT INTO `agency_active_rate` VALUES ('257', '48', '1', '26', '0', '罗大大', '1505829677290');
INSERT INTO `agency_active_rate` VALUES ('258', '49', '1', '26', '0', '109', '1505829677290');
INSERT INTO `agency_active_rate` VALUES ('259', '50', '1', '26', '0', '119', '1505829677290');
INSERT INTO `agency_active_rate` VALUES ('260', '51', '1', '26', '0', 'gigi77', '1505829677290');
INSERT INTO `agency_active_rate` VALUES ('261', '52', '1', '26', '0', 'gigi777', '1505829677290');
INSERT INTO `agency_active_rate` VALUES ('322', '22', '1', '23', '0', '1', '1505829757751');
INSERT INTO `agency_active_rate` VALUES ('323', '23', '1', '23', '0', '小aq', '1505829757751');
INSERT INTO `agency_active_rate` VALUES ('324', '24', '1', '23', '0', '15914897978', '1505829757751');
INSERT INTO `agency_active_rate` VALUES ('325', '25', '1', '23', '0', 'oushinanshen', '1505829757751');
INSERT INTO `agency_active_rate` VALUES ('326', '26', '1', '23', '0', 'wxx899999', '1505829757751');
INSERT INTO `agency_active_rate` VALUES ('327', '27', '1', '23', '0', '1464975293', '1505829757751');
INSERT INTO `agency_active_rate` VALUES ('328', '28', '1', '23', '0', 'Bear', '1505829757751');
INSERT INTO `agency_active_rate` VALUES ('329', '29', '1', '23', '0', 'zxx', '1505829757751');
INSERT INTO `agency_active_rate` VALUES ('330', '30', '1', '23', '0', 'hy123456', '1505829757751');
INSERT INTO `agency_active_rate` VALUES ('331', '31', '1', '23', '0', 'wl123', '1505829757751');
INSERT INTO `agency_active_rate` VALUES ('332', '32', '1', '23', '0', '鳯儿网店', '1505829759640');
INSERT INTO `agency_active_rate` VALUES ('333', '33', '1', '23', '0', 'ruiruima', '1505829759640');
INSERT INTO `agency_active_rate` VALUES ('334', '34', '1', '23', '0', '944581678', '1505829759640');
INSERT INTO `agency_active_rate` VALUES ('335', '35', '1', '23', '0', '2069959168', '1505829759640');
INSERT INTO `agency_active_rate` VALUES ('336', '36', '1', '23', '0', '570156062', '1505829759640');
INSERT INTO `agency_active_rate` VALUES ('337', '37', '1', '23', '0', '770733914', '1505829759640');
INSERT INTO `agency_active_rate` VALUES ('338', '38', '1', '23', '0', '5257', '1505829759640');
INSERT INTO `agency_active_rate` VALUES ('339', '39', '1', '23', '0', '18734158108', '1505829759640');
INSERT INTO `agency_active_rate` VALUES ('340', '40', '1', '23', '0', 'xhq1347574865', '1505829759640');
INSERT INTO `agency_active_rate` VALUES ('341', '41', '1', '23', '0', 'Chen', '1505829759640');
INSERT INTO `agency_active_rate` VALUES ('342', '42', '1', '23', '0', 'qq130496', '1505829761767');
INSERT INTO `agency_active_rate` VALUES ('343', '43', '1', '23', '0', 'kevinchow', '1505829761767');
INSERT INTO `agency_active_rate` VALUES ('344', '44', '1', '23', '0', '17346544413', '1505829761767');
INSERT INTO `agency_active_rate` VALUES ('345', '45', '1', '23', '0', '2480199685', '1505829761767');
INSERT INTO `agency_active_rate` VALUES ('346', '46', '1', '23', '0', 'jim145', '1505829761767');
INSERT INTO `agency_active_rate` VALUES ('347', '47', '1', '23', '0', 'bada', '1505829761767');
INSERT INTO `agency_active_rate` VALUES ('348', '48', '1', '23', '0', '罗大大', '1505829761767');
INSERT INTO `agency_active_rate` VALUES ('349', '49', '1', '23', '0', '109', '1505829761767');
INSERT INTO `agency_active_rate` VALUES ('350', '50', '1', '23', '0', '119', '1505829761767');
INSERT INTO `agency_active_rate` VALUES ('351', '51', '1', '23', '0', 'gigi77', '1505829761767');
INSERT INTO `agency_active_rate` VALUES ('352', '52', '1', '23', '0', 'gigi777', '1505829763600');
INSERT INTO `agency_active_rate` VALUES ('353', '2', '1', '29', '0', '123', '1505872343109');
INSERT INTO `agency_active_rate` VALUES ('354', '4', '1', '29', '0', 'wzkj', '1505872343109');
INSERT INTO `agency_active_rate` VALUES ('355', '5', '1', '29', '0', '冰河', '1505872343109');
INSERT INTO `agency_active_rate` VALUES ('356', '6', '1', '29', '0', 'jiafeng', '1505872343109');
INSERT INTO `agency_active_rate` VALUES ('357', '7', '1', '29', '0', 'l474705958', '1505872343109');
INSERT INTO `agency_active_rate` VALUES ('358', '8', '1', '29', '0', '184066643', '1505872343109');
INSERT INTO `agency_active_rate` VALUES ('359', '9', '1', '29', '0', '2369412', '1505872343109');
INSERT INTO `agency_active_rate` VALUES ('360', '10', '1', '29', '0', 'hy123', '1505872343109');
INSERT INTO `agency_active_rate` VALUES ('361', '11', '1', '29', '0', 'zishu', '1505872343109');
INSERT INTO `agency_active_rate` VALUES ('362', '12', '1', '29', '0', 'tianjing', '1505872343109');
INSERT INTO `agency_active_rate` VALUES ('363', '13', '1', '29', '0', 'zqy95178250', '1505872345104');
INSERT INTO `agency_active_rate` VALUES ('364', '14', '1', '29', '0', 'QQ574912927', '1505872345104');
INSERT INTO `agency_active_rate` VALUES ('365', '15', '1', '29', '0', '1579599827', '1505872345104');
INSERT INTO `agency_active_rate` VALUES ('366', '17', '1', '29', '0', '789', '1505872345104');
INSERT INTO `agency_active_rate` VALUES ('367', '18', '1', '29', '0', '112', '1505872345104');
INSERT INTO `agency_active_rate` VALUES ('368', '20', '1', '29', '0', 'b2218776', '1505872345104');
INSERT INTO `agency_active_rate` VALUES ('369', '21', '1', '29', '0', '13771547176', '1505872345104');
INSERT INTO `agency_active_rate` VALUES ('370', '22', '1', '29', '0', '1', '1505872345104');
INSERT INTO `agency_active_rate` VALUES ('371', '23', '1', '29', '0', '小aq', '1505872345104');
INSERT INTO `agency_active_rate` VALUES ('372', '24', '1', '29', '0', '15914897978', '1505872345104');
INSERT INTO `agency_active_rate` VALUES ('373', '25', '1', '29', '0', 'oushinanshen', '1505872347551');
INSERT INTO `agency_active_rate` VALUES ('374', '26', '1', '29', '0', 'wxx899999', '1505872347551');
INSERT INTO `agency_active_rate` VALUES ('375', '27', '1', '29', '0', '1464975293', '1505872347551');
INSERT INTO `agency_active_rate` VALUES ('376', '28', '1', '29', '0', 'Bear', '1505872347551');
INSERT INTO `agency_active_rate` VALUES ('377', '29', '1', '29', '0', 'zxx', '1505872347551');
INSERT INTO `agency_active_rate` VALUES ('378', '30', '1', '29', '0', 'hy123456', '1505872347551');
INSERT INTO `agency_active_rate` VALUES ('379', '31', '1', '29', '0', 'wl123', '1505872347551');
INSERT INTO `agency_active_rate` VALUES ('380', '32', '1', '29', '0', '鳯儿网店', '1505872347551');
INSERT INTO `agency_active_rate` VALUES ('381', '33', '1', '29', '0', 'ruiruima', '1505872347551');
INSERT INTO `agency_active_rate` VALUES ('382', '34', '1', '29', '0', '944581678', '1505872347551');
INSERT INTO `agency_active_rate` VALUES ('383', '35', '1', '29', '0', '2069959168', '1505872349441');
INSERT INTO `agency_active_rate` VALUES ('384', '36', '1', '29', '0', '570156062', '1505872349441');
INSERT INTO `agency_active_rate` VALUES ('385', '37', '1', '29', '0', '770733914', '1505872349441');
INSERT INTO `agency_active_rate` VALUES ('386', '38', '1', '29', '0', '5257', '1505872349441');
INSERT INTO `agency_active_rate` VALUES ('387', '39', '1', '29', '0', '18734158108', '1505872349441');
INSERT INTO `agency_active_rate` VALUES ('388', '40', '1', '29', '0', 'xhq1347574865', '1505872349441');
INSERT INTO `agency_active_rate` VALUES ('389', '41', '1', '29', '0', 'Chen', '1505872349441');
INSERT INTO `agency_active_rate` VALUES ('390', '42', '1', '29', '0', 'qq130496', '1505872349441');
INSERT INTO `agency_active_rate` VALUES ('391', '43', '1', '29', '0', 'kevinchow', '1505872349441');
INSERT INTO `agency_active_rate` VALUES ('392', '44', '1', '29', '0', '17346544413', '1505872349441');
INSERT INTO `agency_active_rate` VALUES ('393', '45', '1', '29', '0', '2480199685', '1505872351418');
INSERT INTO `agency_active_rate` VALUES ('394', '46', '1', '29', '0', 'jim145', '1505872351418');
INSERT INTO `agency_active_rate` VALUES ('395', '47', '1', '29', '0', 'bada', '1505872351418');
INSERT INTO `agency_active_rate` VALUES ('396', '48', '1', '29', '0', '罗大大', '1505872351418');
INSERT INTO `agency_active_rate` VALUES ('397', '49', '1', '29', '0', '109', '1505872351418');
INSERT INTO `agency_active_rate` VALUES ('398', '50', '1', '29', '0', '119', '1505872351418');
INSERT INTO `agency_active_rate` VALUES ('399', '51', '1', '29', '0', 'gigi77', '1505872351418');
INSERT INTO `agency_active_rate` VALUES ('400', '52', '1', '29', '0', 'gigi777', '1505872351418');
INSERT INTO `agency_active_rate` VALUES ('402', '4', '1', '30', '0', 'wzkj', '1505872369457');
INSERT INTO `agency_active_rate` VALUES ('403', '5', '1', '30', '0', '冰河', '1505872369457');
INSERT INTO `agency_active_rate` VALUES ('404', '6', '1', '30', '0', 'jiafeng', '1505872369457');
INSERT INTO `agency_active_rate` VALUES ('405', '7', '1', '30', '0', 'l474705958', '1505872369457');
INSERT INTO `agency_active_rate` VALUES ('406', '8', '1', '30', '0', '184066643', '1505872369457');
INSERT INTO `agency_active_rate` VALUES ('407', '9', '1', '30', '0', '2369412', '1505872369457');
INSERT INTO `agency_active_rate` VALUES ('408', '10', '1', '30', '0', 'hy123', '1505872369457');
INSERT INTO `agency_active_rate` VALUES ('409', '11', '1', '30', '0', 'zishu', '1505872369457');
INSERT INTO `agency_active_rate` VALUES ('410', '12', '1', '30', '0', 'tianjing', '1505872369457');
INSERT INTO `agency_active_rate` VALUES ('411', '13', '1', '30', '0', 'zqy95178250', '1505872371357');
INSERT INTO `agency_active_rate` VALUES ('412', '14', '1', '30', '0', 'QQ574912927', '1505872371357');
INSERT INTO `agency_active_rate` VALUES ('413', '15', '1', '30', '0', '1579599827', '1505872371357');
INSERT INTO `agency_active_rate` VALUES ('414', '17', '1', '30', '0', '789', '1505872371357');
INSERT INTO `agency_active_rate` VALUES ('415', '18', '1', '30', '0', '112', '1505872371357');
INSERT INTO `agency_active_rate` VALUES ('416', '20', '1', '30', '0', 'b2218776', '1505872371357');
INSERT INTO `agency_active_rate` VALUES ('417', '21', '1', '30', '0', '13771547176', '1505872371357');
INSERT INTO `agency_active_rate` VALUES ('418', '22', '1', '30', '0', '1', '1505872371357');
INSERT INTO `agency_active_rate` VALUES ('419', '23', '1', '30', '0', '小aq', '1505872371357');
INSERT INTO `agency_active_rate` VALUES ('420', '24', '1', '30', '0', '15914897978', '1505872371357');
INSERT INTO `agency_active_rate` VALUES ('421', '25', '1', '30', '0', 'oushinanshen', '1505872373410');
INSERT INTO `agency_active_rate` VALUES ('422', '26', '1', '30', '0', 'wxx899999', '1505872373410');
INSERT INTO `agency_active_rate` VALUES ('423', '27', '1', '30', '0', '1464975293', '1505872373410');
INSERT INTO `agency_active_rate` VALUES ('424', '28', '1', '30', '0', 'Bear', '1505872373410');
INSERT INTO `agency_active_rate` VALUES ('425', '29', '1', '30', '0', 'zxx', '1505872373410');
INSERT INTO `agency_active_rate` VALUES ('426', '30', '1', '30', '0', 'hy123456', '1505872373410');
INSERT INTO `agency_active_rate` VALUES ('427', '31', '1', '30', '0', 'wl123', '1505872373410');
INSERT INTO `agency_active_rate` VALUES ('428', '32', '1', '30', '0', '鳯儿网店', '1505872373410');
INSERT INTO `agency_active_rate` VALUES ('429', '33', '1', '30', '0', 'ruiruima', '1505872373410');
INSERT INTO `agency_active_rate` VALUES ('430', '34', '1', '30', '0', '944581678', '1505872373410');
INSERT INTO `agency_active_rate` VALUES ('431', '35', '1', '30', '0', '2069959168', '1505872375499');
INSERT INTO `agency_active_rate` VALUES ('432', '36', '1', '30', '0', '570156062', '1505872375499');
INSERT INTO `agency_active_rate` VALUES ('433', '37', '1', '30', '0', '770733914', '1505872375499');
INSERT INTO `agency_active_rate` VALUES ('434', '38', '1', '30', '0', '5257', '1505872375499');
INSERT INTO `agency_active_rate` VALUES ('435', '39', '1', '30', '0', '18734158108', '1505872375499');
INSERT INTO `agency_active_rate` VALUES ('436', '40', '1', '30', '0', 'xhq1347574865', '1505872375499');
INSERT INTO `agency_active_rate` VALUES ('437', '41', '1', '30', '0', 'Chen', '1505872375499');
INSERT INTO `agency_active_rate` VALUES ('438', '42', '1', '30', '0', 'qq130496', '1505872375499');
INSERT INTO `agency_active_rate` VALUES ('439', '43', '1', '30', '0', 'kevinchow', '1505872375499');
INSERT INTO `agency_active_rate` VALUES ('440', '44', '1', '30', '0', '17346544413', '1505872375499');
INSERT INTO `agency_active_rate` VALUES ('441', '45', '1', '30', '0', '2480199685', '1505872377264');
INSERT INTO `agency_active_rate` VALUES ('442', '46', '1', '30', '0', 'jim145', '1505872377264');
INSERT INTO `agency_active_rate` VALUES ('443', '47', '1', '30', '0', 'bada', '1505872377264');
INSERT INTO `agency_active_rate` VALUES ('444', '48', '1', '30', '0', '罗大大', '1505872377264');
INSERT INTO `agency_active_rate` VALUES ('445', '49', '1', '30', '0', '109', '1505872377264');
INSERT INTO `agency_active_rate` VALUES ('446', '50', '1', '30', '0', '119', '1505872377264');
INSERT INTO `agency_active_rate` VALUES ('447', '51', '1', '30', '0', 'gigi77', '1505872377264');
INSERT INTO `agency_active_rate` VALUES ('448', '52', '1', '30', '0', 'gigi777', '1505872377264');
INSERT INTO `agency_active_rate` VALUES ('643', '53', '1', '29', '1', '111111', '0');
INSERT INTO `agency_active_rate` VALUES ('644', '54', '1', '29', '0', 'dada', '1505881078455');
INSERT INTO `agency_active_rate` VALUES ('645', '53', '1', '30', '1', '111111', '0');
INSERT INTO `agency_active_rate` VALUES ('646', '54', '1', '30', '0', 'dada', '1505881100716');
INSERT INTO `agency_active_rate` VALUES ('659', '41', '1', '22', '0', 'Chen', '1505881245426');
INSERT INTO `agency_active_rate` VALUES ('660', '42', '1', '22', '0', 'qq130496', '1505881245426');
INSERT INTO `agency_active_rate` VALUES ('661', '43', '1', '22', '0', 'kevinchow', '1505881245426');
INSERT INTO `agency_active_rate` VALUES ('662', '44', '1', '22', '0', '17346544413', '1505881245426');
INSERT INTO `agency_active_rate` VALUES ('663', '45', '1', '22', '0', '2480199685', '1505881245426');
INSERT INTO `agency_active_rate` VALUES ('664', '46', '1', '22', '0', 'jim145', '1505881245426');
INSERT INTO `agency_active_rate` VALUES ('665', '47', '1', '22', '0', 'bada', '1505881245426');
INSERT INTO `agency_active_rate` VALUES ('666', '48', '1', '22', '0', '罗大大', '1505881245426');
INSERT INTO `agency_active_rate` VALUES ('667', '49', '1', '22', '0', '109', '1505881245426');
INSERT INTO `agency_active_rate` VALUES ('668', '50', '1', '22', '0', '119', '1505881245426');
INSERT INTO `agency_active_rate` VALUES ('669', '51', '1', '22', '0', 'gigi77', '1505881247065');
INSERT INTO `agency_active_rate` VALUES ('670', '52', '1', '22', '0', 'gigi777', '1505881247065');
INSERT INTO `agency_active_rate` VALUES ('671', '53', '1', '22', '1', '111111', '0');
INSERT INTO `agency_active_rate` VALUES ('672', '54', '1', '22', '0', 'dada', '1505881247065');
INSERT INTO `agency_active_rate` VALUES ('673', '4', '1', '36', '0', 'wzkj', '1505883064715');
INSERT INTO `agency_active_rate` VALUES ('674', '5', '1', '36', '0', '冰河', '1505883064715');
INSERT INTO `agency_active_rate` VALUES ('675', '6', '1', '36', '0', 'jiafeng', '1505883064715');
INSERT INTO `agency_active_rate` VALUES ('676', '7', '1', '36', '0', 'l474705958', '1505883064715');
INSERT INTO `agency_active_rate` VALUES ('677', '8', '1', '36', '0', '184066643', '1505883064715');
INSERT INTO `agency_active_rate` VALUES ('678', '9', '1', '36', '0', '2369412', '1505883064715');
INSERT INTO `agency_active_rate` VALUES ('679', '10', '1', '36', '0', 'hy123', '1505883064715');
INSERT INTO `agency_active_rate` VALUES ('680', '11', '1', '36', '0', 'zishu', '1505883064715');
INSERT INTO `agency_active_rate` VALUES ('681', '12', '1', '36', '0', 'tianjing', '1505883064715');
INSERT INTO `agency_active_rate` VALUES ('682', '13', '1', '36', '0', 'zqy95178250', '1505883064715');
INSERT INTO `agency_active_rate` VALUES ('683', '14', '1', '36', '0', 'QQ574912927', '1505883066430');
INSERT INTO `agency_active_rate` VALUES ('684', '15', '1', '36', '0', '1579599827', '1505883066430');
INSERT INTO `agency_active_rate` VALUES ('685', '17', '1', '36', '0', '789', '1505883066430');
INSERT INTO `agency_active_rate` VALUES ('686', '18', '1', '36', '0', '112', '1505883066430');
INSERT INTO `agency_active_rate` VALUES ('687', '20', '1', '36', '0', 'b2218776', '1505883066430');
INSERT INTO `agency_active_rate` VALUES ('688', '21', '1', '36', '0', '13771547176', '1505883066430');
INSERT INTO `agency_active_rate` VALUES ('689', '22', '1', '36', '0', '1', '1505883066430');
INSERT INTO `agency_active_rate` VALUES ('690', '23', '1', '36', '0', '小aq', '1505883066430');
INSERT INTO `agency_active_rate` VALUES ('691', '24', '1', '36', '0', '15914897978', '1505883066430');
INSERT INTO `agency_active_rate` VALUES ('692', '25', '1', '36', '0', 'oushinanshen', '1505883066430');
INSERT INTO `agency_active_rate` VALUES ('693', '26', '1', '36', '0', 'wxx899999', '1505883067669');
INSERT INTO `agency_active_rate` VALUES ('694', '27', '1', '36', '0', '1464975293', '1505883067669');
INSERT INTO `agency_active_rate` VALUES ('695', '28', '1', '36', '0', 'Bear', '1505883067669');
INSERT INTO `agency_active_rate` VALUES ('696', '29', '1', '36', '0', 'zxx', '1505883067669');
INSERT INTO `agency_active_rate` VALUES ('697', '30', '1', '36', '0', 'hy123456', '1505883067669');
INSERT INTO `agency_active_rate` VALUES ('698', '31', '1', '36', '0', 'wl123', '1505883067669');
INSERT INTO `agency_active_rate` VALUES ('699', '32', '1', '36', '0', '鳯儿网店', '1505883067669');
INSERT INTO `agency_active_rate` VALUES ('700', '33', '1', '36', '0', 'ruiruima', '1505883067669');
INSERT INTO `agency_active_rate` VALUES ('701', '34', '1', '36', '0', '944581678', '1505883067669');
INSERT INTO `agency_active_rate` VALUES ('702', '35', '1', '36', '0', '2069959168', '1505883067669');
INSERT INTO `agency_active_rate` VALUES ('703', '36', '1', '36', '0', '570156062', '1505883069644');
INSERT INTO `agency_active_rate` VALUES ('704', '37', '1', '36', '0', '770733914', '1505883069644');
INSERT INTO `agency_active_rate` VALUES ('705', '38', '1', '36', '0', '5257', '1505883069644');
INSERT INTO `agency_active_rate` VALUES ('706', '39', '1', '36', '0', '18734158108', '1505883069644');
INSERT INTO `agency_active_rate` VALUES ('707', '40', '1', '36', '0', 'xhq1347574865', '1505883069644');
INSERT INTO `agency_active_rate` VALUES ('708', '41', '1', '36', '0', 'Chen', '1505883069644');
INSERT INTO `agency_active_rate` VALUES ('709', '42', '1', '36', '0', 'qq130496', '1505883069644');
INSERT INTO `agency_active_rate` VALUES ('710', '43', '1', '36', '0', 'kevinchow', '1505883069644');
INSERT INTO `agency_active_rate` VALUES ('711', '44', '1', '36', '0', '17346544413', '1505883069644');
INSERT INTO `agency_active_rate` VALUES ('712', '45', '1', '36', '0', '2480199685', '1505883069644');
INSERT INTO `agency_active_rate` VALUES ('713', '46', '1', '36', '0', 'jim145', '1505883071220');
INSERT INTO `agency_active_rate` VALUES ('714', '47', '1', '36', '0', 'bada', '1505883071220');
INSERT INTO `agency_active_rate` VALUES ('715', '48', '1', '36', '0', '罗大大', '1505883071220');
INSERT INTO `agency_active_rate` VALUES ('716', '49', '1', '36', '0', '109', '1505883071220');
INSERT INTO `agency_active_rate` VALUES ('717', '50', '1', '36', '0', '119', '1505883071220');
INSERT INTO `agency_active_rate` VALUES ('718', '51', '1', '36', '0', 'gigi77', '1505883071220');
INSERT INTO `agency_active_rate` VALUES ('719', '52', '1', '36', '0', 'gigi777', '1505883071220');
INSERT INTO `agency_active_rate` VALUES ('720', '53', '1', '36', '1', '111111', '0');
INSERT INTO `agency_active_rate` VALUES ('721', '54', '1', '36', '0', 'dada', '1505883071220');
INSERT INTO `agency_active_rate` VALUES ('722', '55', '1', '36', '0', '源肥呀', '1505883071220');
INSERT INTO `agency_active_rate` VALUES ('723', '4', '1', '37', '0', 'wzkj', '1505891005276');
INSERT INTO `agency_active_rate` VALUES ('724', '5', '1', '37', '0', '冰河', '1505891005276');
INSERT INTO `agency_active_rate` VALUES ('725', '6', '1', '37', '0', 'jiafeng', '1505891005276');
INSERT INTO `agency_active_rate` VALUES ('726', '7', '1', '37', '0', 'l474705958', '1505891005276');
INSERT INTO `agency_active_rate` VALUES ('727', '8', '1', '37', '0', '184066643', '1505891005276');
INSERT INTO `agency_active_rate` VALUES ('728', '9', '1', '37', '0', '2369412', '1505891005276');
INSERT INTO `agency_active_rate` VALUES ('729', '10', '1', '37', '0', 'hy123', '1505891005276');
INSERT INTO `agency_active_rate` VALUES ('730', '11', '1', '37', '0', 'zishu', '1505891005276');
INSERT INTO `agency_active_rate` VALUES ('731', '12', '1', '37', '0', 'tianjing', '1505891005276');
INSERT INTO `agency_active_rate` VALUES ('732', '13', '1', '37', '0', 'zqy95178250', '1505891005276');
INSERT INTO `agency_active_rate` VALUES ('733', '14', '1', '37', '0', 'QQ574912927', '1505891007451');
INSERT INTO `agency_active_rate` VALUES ('734', '15', '1', '37', '0', '1579599827', '1505891007451');
INSERT INTO `agency_active_rate` VALUES ('735', '17', '1', '37', '0', '789', '1505891007451');
INSERT INTO `agency_active_rate` VALUES ('736', '18', '1', '37', '0', '112', '1505891007451');
INSERT INTO `agency_active_rate` VALUES ('737', '20', '1', '37', '0', 'b2218776', '1505891007451');
INSERT INTO `agency_active_rate` VALUES ('738', '21', '1', '37', '0', '13771547176', '1505891007451');
INSERT INTO `agency_active_rate` VALUES ('739', '22', '1', '37', '0', '1', '1505891007451');
INSERT INTO `agency_active_rate` VALUES ('740', '23', '1', '37', '0', '小aq', '1505891007451');
INSERT INTO `agency_active_rate` VALUES ('741', '24', '1', '37', '0', '15914897978', '1505891007451');
INSERT INTO `agency_active_rate` VALUES ('742', '25', '1', '37', '0', 'oushinanshen', '1505891007451');
INSERT INTO `agency_active_rate` VALUES ('743', '26', '1', '37', '0', 'wxx899999', '1505891009820');
INSERT INTO `agency_active_rate` VALUES ('744', '27', '1', '37', '0', '1464975293', '1505891009821');
INSERT INTO `agency_active_rate` VALUES ('745', '28', '1', '37', '0', 'Bear', '1505891009821');
INSERT INTO `agency_active_rate` VALUES ('746', '29', '1', '37', '0', 'zxx', '1505891009821');
INSERT INTO `agency_active_rate` VALUES ('747', '30', '1', '37', '0', 'hy123456', '1505891009821');
INSERT INTO `agency_active_rate` VALUES ('748', '31', '1', '37', '0', 'wl123', '1505891009821');
INSERT INTO `agency_active_rate` VALUES ('749', '32', '1', '37', '0', '鳯儿网店', '1505891009821');
INSERT INTO `agency_active_rate` VALUES ('750', '33', '1', '37', '0', 'ruiruima', '1505891009821');
INSERT INTO `agency_active_rate` VALUES ('751', '34', '1', '37', '0', '944581678', '1505891009821');
INSERT INTO `agency_active_rate` VALUES ('752', '35', '1', '37', '0', '2069959168', '1505891009821');
INSERT INTO `agency_active_rate` VALUES ('753', '36', '1', '37', '0', '570156062', '1505891011307');
INSERT INTO `agency_active_rate` VALUES ('754', '37', '1', '37', '0', '770733914', '1505891011307');
INSERT INTO `agency_active_rate` VALUES ('755', '38', '1', '37', '0', '5257', '1505891011307');
INSERT INTO `agency_active_rate` VALUES ('756', '39', '1', '37', '0', '18734158108', '1505891011307');
INSERT INTO `agency_active_rate` VALUES ('757', '40', '1', '37', '0', 'xhq1347574865', '1505891011307');
INSERT INTO `agency_active_rate` VALUES ('758', '41', '1', '37', '0', 'Chen', '1505891011307');
INSERT INTO `agency_active_rate` VALUES ('759', '42', '1', '37', '0', 'qq130496', '1505891011307');
INSERT INTO `agency_active_rate` VALUES ('760', '43', '1', '37', '0', 'kevinchow', '1505891011307');
INSERT INTO `agency_active_rate` VALUES ('761', '44', '1', '37', '0', '17346544413', '1505891011307');
INSERT INTO `agency_active_rate` VALUES ('762', '45', '1', '37', '0', '2480199685', '1505891011307');
INSERT INTO `agency_active_rate` VALUES ('763', '46', '1', '37', '0', 'jim145', '1505891013113');
INSERT INTO `agency_active_rate` VALUES ('764', '47', '1', '37', '0', 'bada', '1505891013113');
INSERT INTO `agency_active_rate` VALUES ('765', '48', '1', '37', '0', '罗大大', '1505891013113');
INSERT INTO `agency_active_rate` VALUES ('766', '49', '1', '37', '0', '109', '1505891013113');
INSERT INTO `agency_active_rate` VALUES ('767', '50', '1', '37', '0', '119', '1505891013113');
INSERT INTO `agency_active_rate` VALUES ('768', '51', '1', '37', '0', 'gigi77', '1505891013113');
INSERT INTO `agency_active_rate` VALUES ('769', '52', '1', '37', '0', 'gigi777', '1505891013113');
INSERT INTO `agency_active_rate` VALUES ('770', '53', '1', '37', '1', '111111', '0');
INSERT INTO `agency_active_rate` VALUES ('771', '54', '1', '37', '0', 'dada', '1505891013113');
INSERT INTO `agency_active_rate` VALUES ('772', '55', '1', '37', '0', '源肥呀', '1505891013113');
INSERT INTO `agency_active_rate` VALUES ('823', '4', '1', '39', '0', 'wzkj', '1505899162401');
INSERT INTO `agency_active_rate` VALUES ('824', '5', '1', '39', '0', '冰河', '1505899162401');
INSERT INTO `agency_active_rate` VALUES ('825', '6', '1', '39', '0', 'jiafeng', '1505899162401');
INSERT INTO `agency_active_rate` VALUES ('826', '7', '1', '39', '0', 'l474705958', '1505899162401');
INSERT INTO `agency_active_rate` VALUES ('827', '8', '1', '39', '0', '184066643', '1505899162401');
INSERT INTO `agency_active_rate` VALUES ('828', '9', '1', '39', '0', '2369412', '1505899162401');
INSERT INTO `agency_active_rate` VALUES ('829', '10', '1', '39', '0', 'hy123', '1505899162401');
INSERT INTO `agency_active_rate` VALUES ('830', '11', '1', '39', '0', 'zishu', '1505899162401');
INSERT INTO `agency_active_rate` VALUES ('831', '12', '1', '39', '0', 'tianjing', '1505899162401');
INSERT INTO `agency_active_rate` VALUES ('832', '13', '1', '39', '0', 'zqy95178250', '1505899162401');
INSERT INTO `agency_active_rate` VALUES ('833', '14', '1', '39', '0', 'QQ574912927', '1505899164236');
INSERT INTO `agency_active_rate` VALUES ('834', '15', '1', '39', '0', '1579599827', '1505899164236');
INSERT INTO `agency_active_rate` VALUES ('835', '17', '1', '39', '0', '789', '1505899164236');
INSERT INTO `agency_active_rate` VALUES ('836', '18', '1', '39', '0', '112', '1505899164236');
INSERT INTO `agency_active_rate` VALUES ('837', '20', '1', '39', '0', 'b2218776', '1505899164236');
INSERT INTO `agency_active_rate` VALUES ('838', '21', '1', '39', '0', '13771547176', '1505899164236');
INSERT INTO `agency_active_rate` VALUES ('839', '22', '1', '39', '0', '1', '1505899164236');
INSERT INTO `agency_active_rate` VALUES ('840', '23', '1', '39', '0', '小aq', '1505899164236');
INSERT INTO `agency_active_rate` VALUES ('841', '24', '1', '39', '0', '15914897978', '1505899164236');
INSERT INTO `agency_active_rate` VALUES ('842', '25', '1', '39', '0', 'oushinanshen', '1505899164236');
INSERT INTO `agency_active_rate` VALUES ('843', '26', '1', '39', '0', 'wxx899999', '1505899165725');
INSERT INTO `agency_active_rate` VALUES ('844', '27', '1', '39', '0', '1464975293', '1505899165725');
INSERT INTO `agency_active_rate` VALUES ('845', '28', '1', '39', '0', 'Bear', '1505899165725');
INSERT INTO `agency_active_rate` VALUES ('846', '29', '1', '39', '0', 'zxx', '1505899165725');
INSERT INTO `agency_active_rate` VALUES ('847', '30', '1', '39', '0', 'hy123456', '1505899165725');
INSERT INTO `agency_active_rate` VALUES ('848', '31', '1', '39', '0', 'wl123', '1505899165725');
INSERT INTO `agency_active_rate` VALUES ('849', '32', '1', '39', '0', '鳯儿网店', '1505899165725');
INSERT INTO `agency_active_rate` VALUES ('850', '33', '1', '39', '0', 'ruiruima', '1505899165725');
INSERT INTO `agency_active_rate` VALUES ('851', '34', '1', '39', '0', '944581678', '1505899165725');
INSERT INTO `agency_active_rate` VALUES ('852', '35', '1', '39', '0', '2069959168', '1505899165725');
INSERT INTO `agency_active_rate` VALUES ('853', '36', '1', '39', '0', '570156062', '1505899167142');
INSERT INTO `agency_active_rate` VALUES ('854', '37', '1', '39', '0', '770733914', '1505899167142');
INSERT INTO `agency_active_rate` VALUES ('855', '38', '1', '39', '0', '5257', '1505899167142');
INSERT INTO `agency_active_rate` VALUES ('856', '39', '1', '39', '0', '18734158108', '1505899167142');
INSERT INTO `agency_active_rate` VALUES ('857', '40', '1', '39', '0', 'xhq1347574865', '1505899167142');
INSERT INTO `agency_active_rate` VALUES ('858', '41', '1', '39', '0', 'Chen', '1505899167142');
INSERT INTO `agency_active_rate` VALUES ('859', '42', '1', '39', '0', 'qq130496', '1505899167142');
INSERT INTO `agency_active_rate` VALUES ('860', '43', '1', '39', '0', 'kevinchow', '1505899167142');
INSERT INTO `agency_active_rate` VALUES ('861', '44', '1', '39', '0', '17346544413', '1505899167142');
INSERT INTO `agency_active_rate` VALUES ('862', '45', '1', '39', '0', '2480199685', '1505899167142');
INSERT INTO `agency_active_rate` VALUES ('863', '46', '1', '39', '0', 'jim145', '1505899168893');
INSERT INTO `agency_active_rate` VALUES ('864', '47', '1', '39', '0', 'bada', '1505899168893');
INSERT INTO `agency_active_rate` VALUES ('865', '48', '1', '39', '0', '罗大大', '1505899168893');
INSERT INTO `agency_active_rate` VALUES ('866', '49', '1', '39', '0', '109', '1505899168893');
INSERT INTO `agency_active_rate` VALUES ('867', '50', '1', '39', '0', '119', '1505899168893');
INSERT INTO `agency_active_rate` VALUES ('868', '51', '1', '39', '0', 'gigi77', '1505899168893');
INSERT INTO `agency_active_rate` VALUES ('869', '52', '1', '39', '0', 'gigi777', '1505899168893');
INSERT INTO `agency_active_rate` VALUES ('870', '53', '1', '39', '1', '111111', '0');
INSERT INTO `agency_active_rate` VALUES ('871', '54', '1', '39', '0', 'dada', '1505899168893');
INSERT INTO `agency_active_rate` VALUES ('872', '55', '1', '39', '0', '源肥呀', '1505899168893');
INSERT INTO `agency_active_rate` VALUES ('873', '4', '1', '40', '0', 'wzkj', '1505899313103');
INSERT INTO `agency_active_rate` VALUES ('874', '5', '1', '40', '0', '冰河', '1505899313103');
INSERT INTO `agency_active_rate` VALUES ('875', '6', '1', '40', '0', 'jiafeng', '1505899313103');
INSERT INTO `agency_active_rate` VALUES ('876', '7', '1', '40', '0', 'l474705958', '1505899313103');
INSERT INTO `agency_active_rate` VALUES ('877', '8', '1', '40', '0', '184066643', '1505899313103');
INSERT INTO `agency_active_rate` VALUES ('878', '9', '1', '40', '0', '2369412', '1505899313103');
INSERT INTO `agency_active_rate` VALUES ('879', '10', '1', '40', '0', 'hy123', '1505899313103');
INSERT INTO `agency_active_rate` VALUES ('880', '11', '1', '40', '0', 'zishu', '1505899313103');
INSERT INTO `agency_active_rate` VALUES ('881', '12', '1', '40', '0', 'tianjing', '1505899313103');
INSERT INTO `agency_active_rate` VALUES ('882', '13', '1', '40', '0', 'zqy95178250', '1505899313103');
INSERT INTO `agency_active_rate` VALUES ('883', '14', '1', '40', '0', 'QQ574912927', '1505899314728');
INSERT INTO `agency_active_rate` VALUES ('884', '15', '1', '40', '0', '1579599827', '1505899314728');
INSERT INTO `agency_active_rate` VALUES ('885', '17', '1', '40', '0', '789', '1505899314728');
INSERT INTO `agency_active_rate` VALUES ('886', '18', '1', '40', '0', '112', '1505899314728');
INSERT INTO `agency_active_rate` VALUES ('887', '20', '1', '40', '0', 'b2218776', '1505899314728');
INSERT INTO `agency_active_rate` VALUES ('888', '21', '1', '40', '0', '13771547176', '1505899314728');
INSERT INTO `agency_active_rate` VALUES ('889', '22', '1', '40', '0', '1', '1505899314728');
INSERT INTO `agency_active_rate` VALUES ('890', '23', '1', '40', '0', '小aq', '1505899314728');
INSERT INTO `agency_active_rate` VALUES ('891', '24', '1', '40', '0', '15914897978', '1505899314728');
INSERT INTO `agency_active_rate` VALUES ('892', '25', '1', '40', '0', 'oushinanshen', '1505899314728');
INSERT INTO `agency_active_rate` VALUES ('893', '26', '1', '40', '0', 'wxx899999', '1505899316696');
INSERT INTO `agency_active_rate` VALUES ('894', '27', '1', '40', '0', '1464975293', '1505899316696');
INSERT INTO `agency_active_rate` VALUES ('895', '28', '1', '40', '0', 'Bear', '1505899316696');
INSERT INTO `agency_active_rate` VALUES ('896', '29', '1', '40', '0', 'zxx', '1505899316696');
INSERT INTO `agency_active_rate` VALUES ('897', '30', '1', '40', '0', 'hy123456', '1505899316696');
INSERT INTO `agency_active_rate` VALUES ('898', '31', '1', '40', '0', 'wl123', '1505899316696');
INSERT INTO `agency_active_rate` VALUES ('899', '32', '1', '40', '0', '鳯儿网店', '1505899316696');
INSERT INTO `agency_active_rate` VALUES ('900', '33', '1', '40', '0', 'ruiruima', '1505899316696');
INSERT INTO `agency_active_rate` VALUES ('901', '34', '1', '40', '0', '944581678', '1505899316696');
INSERT INTO `agency_active_rate` VALUES ('902', '35', '1', '40', '0', '2069959168', '1505899316696');
INSERT INTO `agency_active_rate` VALUES ('903', '36', '1', '40', '0', '570156062', '1505899319859');
INSERT INTO `agency_active_rate` VALUES ('904', '37', '1', '40', '0', '770733914', '1505899319859');
INSERT INTO `agency_active_rate` VALUES ('905', '38', '1', '40', '0', '5257', '1505899319859');
INSERT INTO `agency_active_rate` VALUES ('906', '39', '1', '40', '0', '18734158108', '1505899319859');
INSERT INTO `agency_active_rate` VALUES ('907', '40', '1', '40', '0', 'xhq1347574865', '1505899319859');
INSERT INTO `agency_active_rate` VALUES ('908', '41', '1', '40', '0', 'Chen', '1505899319859');
INSERT INTO `agency_active_rate` VALUES ('909', '42', '1', '40', '0', 'qq130496', '1505899319859');
INSERT INTO `agency_active_rate` VALUES ('910', '43', '1', '40', '0', 'kevinchow', '1505899319859');
INSERT INTO `agency_active_rate` VALUES ('911', '44', '1', '40', '0', '17346544413', '1505899319859');
INSERT INTO `agency_active_rate` VALUES ('912', '45', '1', '40', '0', '2480199685', '1505899319859');
INSERT INTO `agency_active_rate` VALUES ('913', '46', '1', '40', '0', 'jim145', '1505899321395');
INSERT INTO `agency_active_rate` VALUES ('914', '47', '1', '40', '0', 'bada', '1505899321395');
INSERT INTO `agency_active_rate` VALUES ('915', '48', '1', '40', '0', '罗大大', '1505899321395');
INSERT INTO `agency_active_rate` VALUES ('916', '49', '1', '40', '0', '109', '1505899321395');
INSERT INTO `agency_active_rate` VALUES ('917', '50', '1', '40', '0', '119', '1505899321395');
INSERT INTO `agency_active_rate` VALUES ('918', '51', '1', '40', '0', 'gigi77', '1505899321395');
INSERT INTO `agency_active_rate` VALUES ('919', '52', '1', '40', '0', 'gigi777', '1505899321395');
INSERT INTO `agency_active_rate` VALUES ('920', '53', '1', '40', '1', '111111', '0');
INSERT INTO `agency_active_rate` VALUES ('921', '54', '1', '40', '0', 'dada', '1505899321395');
INSERT INTO `agency_active_rate` VALUES ('922', '55', '1', '40', '0', '源肥呀', '1505899321395');
INSERT INTO `agency_active_rate` VALUES ('923', '4', '1', '41', '0', 'wzkj', '1505899412562');
INSERT INTO `agency_active_rate` VALUES ('924', '5', '1', '41', '0', '冰河', '1505899412562');
INSERT INTO `agency_active_rate` VALUES ('925', '6', '1', '41', '0', 'jiafeng', '1505899412562');
INSERT INTO `agency_active_rate` VALUES ('926', '7', '1', '41', '0', 'l474705958', '1505899412562');
INSERT INTO `agency_active_rate` VALUES ('927', '8', '1', '41', '0', '184066643', '1505899412562');
INSERT INTO `agency_active_rate` VALUES ('928', '9', '1', '41', '0', '2369412', '1505899412562');
INSERT INTO `agency_active_rate` VALUES ('929', '10', '1', '41', '0', 'hy123', '1505899412562');
INSERT INTO `agency_active_rate` VALUES ('930', '11', '1', '41', '0', 'zishu', '1505899412562');
INSERT INTO `agency_active_rate` VALUES ('931', '12', '1', '41', '0', 'tianjing', '1505899412562');
INSERT INTO `agency_active_rate` VALUES ('932', '13', '1', '41', '0', 'zqy95178250', '1505899412562');
INSERT INTO `agency_active_rate` VALUES ('933', '14', '1', '41', '0', 'QQ574912927', '1505899419050');
INSERT INTO `agency_active_rate` VALUES ('934', '15', '1', '41', '0', '1579599827', '1505899419050');
INSERT INTO `agency_active_rate` VALUES ('935', '17', '1', '41', '0', '789', '1505899419050');
INSERT INTO `agency_active_rate` VALUES ('936', '18', '1', '41', '0', '112', '1505899419050');
INSERT INTO `agency_active_rate` VALUES ('937', '20', '1', '41', '0', 'b2218776', '1505899419050');
INSERT INTO `agency_active_rate` VALUES ('938', '21', '1', '41', '0', '13771547176', '1505899419050');
INSERT INTO `agency_active_rate` VALUES ('939', '22', '1', '41', '0', '1', '1505899419050');
INSERT INTO `agency_active_rate` VALUES ('940', '23', '1', '41', '0', '小aq', '1505899419050');
INSERT INTO `agency_active_rate` VALUES ('941', '24', '1', '41', '0', '15914897978', '1505899419050');
INSERT INTO `agency_active_rate` VALUES ('942', '25', '1', '41', '0', 'oushinanshen', '1505899419050');
INSERT INTO `agency_active_rate` VALUES ('943', '26', '1', '41', '0', 'wxx899999', '1505899420668');
INSERT INTO `agency_active_rate` VALUES ('944', '27', '1', '41', '0', '1464975293', '1505899420668');
INSERT INTO `agency_active_rate` VALUES ('945', '28', '1', '41', '0', 'Bear', '1505899420668');
INSERT INTO `agency_active_rate` VALUES ('946', '29', '1', '41', '0', 'zxx', '1505899420668');
INSERT INTO `agency_active_rate` VALUES ('947', '30', '1', '41', '0', 'hy123456', '1505899420668');
INSERT INTO `agency_active_rate` VALUES ('948', '31', '1', '41', '0', 'wl123', '1505899420668');
INSERT INTO `agency_active_rate` VALUES ('949', '32', '1', '41', '0', '鳯儿网店', '1505899420668');
INSERT INTO `agency_active_rate` VALUES ('950', '33', '1', '41', '0', 'ruiruima', '1505899420668');
INSERT INTO `agency_active_rate` VALUES ('951', '34', '1', '41', '0', '944581678', '1505899420668');
INSERT INTO `agency_active_rate` VALUES ('952', '35', '1', '41', '0', '2069959168', '1505899420668');
INSERT INTO `agency_active_rate` VALUES ('953', '36', '1', '41', '0', '570156062', '1505899422529');
INSERT INTO `agency_active_rate` VALUES ('954', '37', '1', '41', '0', '770733914', '1505899422529');
INSERT INTO `agency_active_rate` VALUES ('955', '38', '1', '41', '0', '5257', '1505899422529');
INSERT INTO `agency_active_rate` VALUES ('956', '39', '1', '41', '0', '18734158108', '1505899422529');
INSERT INTO `agency_active_rate` VALUES ('957', '40', '1', '41', '0', 'xhq1347574865', '1505899422529');
INSERT INTO `agency_active_rate` VALUES ('958', '41', '1', '41', '0', 'Chen', '1505899422529');
INSERT INTO `agency_active_rate` VALUES ('959', '42', '1', '41', '0', 'qq130496', '1505899422529');
INSERT INTO `agency_active_rate` VALUES ('960', '43', '1', '41', '0', 'kevinchow', '1505899422529');
INSERT INTO `agency_active_rate` VALUES ('961', '44', '1', '41', '0', '17346544413', '1505899422529');
INSERT INTO `agency_active_rate` VALUES ('962', '45', '1', '41', '0', '2480199685', '1505899422529');
INSERT INTO `agency_active_rate` VALUES ('963', '46', '1', '41', '0', 'jim145', '1505899424077');
INSERT INTO `agency_active_rate` VALUES ('964', '47', '1', '41', '0', 'bada', '1505899424077');
INSERT INTO `agency_active_rate` VALUES ('965', '48', '1', '41', '0', '罗大大', '1505899424077');
INSERT INTO `agency_active_rate` VALUES ('966', '49', '1', '41', '0', '109', '1505899424077');
INSERT INTO `agency_active_rate` VALUES ('967', '50', '1', '41', '0', '119', '1505899424077');
INSERT INTO `agency_active_rate` VALUES ('968', '51', '1', '41', '0', 'gigi77', '1505899424077');
INSERT INTO `agency_active_rate` VALUES ('969', '52', '1', '41', '0', 'gigi777', '1505899424077');
INSERT INTO `agency_active_rate` VALUES ('970', '53', '1', '41', '1', '111111', '0');
INSERT INTO `agency_active_rate` VALUES ('971', '54', '1', '41', '0', 'dada', '1505899424077');
INSERT INTO `agency_active_rate` VALUES ('972', '55', '1', '41', '0', '源肥呀', '1505899424077');
INSERT INTO `agency_active_rate` VALUES ('973', '4', '1', '42', '0', 'wzkj', '1505899503599');
INSERT INTO `agency_active_rate` VALUES ('974', '5', '1', '42', '0', '冰河', '1505899503599');
INSERT INTO `agency_active_rate` VALUES ('975', '6', '1', '42', '0', 'jiafeng', '1505899503599');
INSERT INTO `agency_active_rate` VALUES ('976', '7', '1', '42', '0', 'l474705958', '1505899503599');
INSERT INTO `agency_active_rate` VALUES ('977', '8', '1', '42', '0', '184066643', '1505899503599');
INSERT INTO `agency_active_rate` VALUES ('978', '9', '1', '42', '0', '2369412', '1505899503599');
INSERT INTO `agency_active_rate` VALUES ('979', '10', '1', '42', '0', 'hy123', '1505899503599');
INSERT INTO `agency_active_rate` VALUES ('980', '11', '1', '42', '0', 'zishu', '1505899503599');
INSERT INTO `agency_active_rate` VALUES ('981', '12', '1', '42', '0', 'tianjing', '1505899503599');
INSERT INTO `agency_active_rate` VALUES ('982', '13', '1', '42', '0', 'zqy95178250', '1505899503599');
INSERT INTO `agency_active_rate` VALUES ('983', '14', '1', '42', '0', 'QQ574912927', '1505899505224');
INSERT INTO `agency_active_rate` VALUES ('984', '15', '1', '42', '0', '1579599827', '1505899505224');
INSERT INTO `agency_active_rate` VALUES ('985', '17', '1', '42', '0', '789', '1505899505224');
INSERT INTO `agency_active_rate` VALUES ('986', '18', '1', '42', '0', '112', '1505899505224');
INSERT INTO `agency_active_rate` VALUES ('987', '20', '1', '42', '0', 'b2218776', '1505899505224');
INSERT INTO `agency_active_rate` VALUES ('988', '21', '1', '42', '0', '13771547176', '1505899505224');
INSERT INTO `agency_active_rate` VALUES ('989', '22', '1', '42', '0', '1', '1505899505224');
INSERT INTO `agency_active_rate` VALUES ('990', '23', '1', '42', '0', '小aq', '1505899505224');
INSERT INTO `agency_active_rate` VALUES ('991', '24', '1', '42', '0', '15914897978', '1505899505224');
INSERT INTO `agency_active_rate` VALUES ('992', '25', '1', '42', '0', 'oushinanshen', '1505899505224');
INSERT INTO `agency_active_rate` VALUES ('993', '26', '1', '42', '0', 'wxx899999', '1505899507051');
INSERT INTO `agency_active_rate` VALUES ('994', '27', '1', '42', '0', '1464975293', '1505899507051');
INSERT INTO `agency_active_rate` VALUES ('995', '28', '1', '42', '0', 'Bear', '1505899507051');
INSERT INTO `agency_active_rate` VALUES ('996', '29', '1', '42', '0', 'zxx', '1505899507051');
INSERT INTO `agency_active_rate` VALUES ('997', '30', '1', '42', '0', 'hy123456', '1505899507051');
INSERT INTO `agency_active_rate` VALUES ('998', '31', '1', '42', '0', 'wl123', '1505899507051');
INSERT INTO `agency_active_rate` VALUES ('999', '32', '1', '42', '0', '鳯儿网店', '1505899507051');
INSERT INTO `agency_active_rate` VALUES ('1000', '33', '1', '42', '0', 'ruiruima', '1505899507051');
INSERT INTO `agency_active_rate` VALUES ('1001', '34', '1', '42', '0', '944581678', '1505899507051');
INSERT INTO `agency_active_rate` VALUES ('1002', '35', '1', '42', '0', '2069959168', '1505899507051');
INSERT INTO `agency_active_rate` VALUES ('1003', '36', '1', '42', '0', '570156062', '1505899508773');
INSERT INTO `agency_active_rate` VALUES ('1004', '37', '1', '42', '0', '770733914', '1505899508773');
INSERT INTO `agency_active_rate` VALUES ('1005', '38', '1', '42', '0', '5257', '1505899508773');
INSERT INTO `agency_active_rate` VALUES ('1006', '39', '1', '42', '0', '18734158108', '1505899508773');
INSERT INTO `agency_active_rate` VALUES ('1007', '40', '1', '42', '0', 'xhq1347574865', '1505899508773');
INSERT INTO `agency_active_rate` VALUES ('1008', '41', '1', '42', '0', 'Chen', '1505899508773');
INSERT INTO `agency_active_rate` VALUES ('1009', '42', '1', '42', '0', 'qq130496', '1505899508773');
INSERT INTO `agency_active_rate` VALUES ('1010', '43', '1', '42', '0', 'kevinchow', '1505899508773');
INSERT INTO `agency_active_rate` VALUES ('1011', '44', '1', '42', '0', '17346544413', '1505899508773');
INSERT INTO `agency_active_rate` VALUES ('1012', '45', '1', '42', '0', '2480199685', '1505899508773');
INSERT INTO `agency_active_rate` VALUES ('1013', '46', '1', '42', '0', 'jim145', '1505899510350');
INSERT INTO `agency_active_rate` VALUES ('1014', '47', '1', '42', '0', 'bada', '1505899510350');
INSERT INTO `agency_active_rate` VALUES ('1015', '48', '1', '42', '0', '罗大大', '1505899510350');
INSERT INTO `agency_active_rate` VALUES ('1016', '49', '1', '42', '0', '109', '1505899510350');
INSERT INTO `agency_active_rate` VALUES ('1017', '50', '1', '42', '0', '119', '1505899510350');
INSERT INTO `agency_active_rate` VALUES ('1018', '51', '1', '42', '0', 'gigi77', '1505899510350');
INSERT INTO `agency_active_rate` VALUES ('1019', '52', '1', '42', '0', 'gigi777', '1505899510350');
INSERT INTO `agency_active_rate` VALUES ('1020', '53', '1', '42', '1', '111111', '0');
INSERT INTO `agency_active_rate` VALUES ('1021', '54', '1', '42', '0', 'dada', '1505899510350');
INSERT INTO `agency_active_rate` VALUES ('1022', '55', '1', '42', '0', '源肥呀', '1505899510350');
INSERT INTO `agency_active_rate` VALUES ('1023', '4', '1', '43', '0', 'wzkj', '1505899601705');
INSERT INTO `agency_active_rate` VALUES ('1024', '5', '1', '43', '0', '冰河', '1505899601705');
INSERT INTO `agency_active_rate` VALUES ('1025', '6', '1', '43', '0', 'jiafeng', '1505899601705');
INSERT INTO `agency_active_rate` VALUES ('1026', '7', '1', '43', '0', 'l474705958', '1505899601705');
INSERT INTO `agency_active_rate` VALUES ('1027', '8', '1', '43', '0', '184066643', '1505899601705');
INSERT INTO `agency_active_rate` VALUES ('1028', '9', '1', '43', '0', '2369412', '1505899601705');
INSERT INTO `agency_active_rate` VALUES ('1029', '10', '1', '43', '0', 'hy123', '1505899601705');
INSERT INTO `agency_active_rate` VALUES ('1030', '11', '1', '43', '0', 'zishu', '1505899601705');
INSERT INTO `agency_active_rate` VALUES ('1031', '12', '1', '43', '0', 'tianjing', '1505899601705');
INSERT INTO `agency_active_rate` VALUES ('1032', '13', '1', '43', '0', 'zqy95178250', '1505899601705');
INSERT INTO `agency_active_rate` VALUES ('1033', '14', '1', '43', '0', 'QQ574912927', '1505899603361');
INSERT INTO `agency_active_rate` VALUES ('1034', '15', '1', '43', '0', '1579599827', '1505899603361');
INSERT INTO `agency_active_rate` VALUES ('1035', '17', '1', '43', '0', '789', '1505899603361');
INSERT INTO `agency_active_rate` VALUES ('1036', '18', '1', '43', '0', '112', '1505899603361');
INSERT INTO `agency_active_rate` VALUES ('1037', '20', '1', '43', '0', 'b2218776', '1505899603361');
INSERT INTO `agency_active_rate` VALUES ('1038', '21', '1', '43', '0', '13771547176', '1505899603361');
INSERT INTO `agency_active_rate` VALUES ('1039', '22', '1', '43', '0', '1', '1505899603361');
INSERT INTO `agency_active_rate` VALUES ('1040', '23', '1', '43', '0', '小aq', '1505899603361');
INSERT INTO `agency_active_rate` VALUES ('1041', '24', '1', '43', '0', '15914897978', '1505899603361');
INSERT INTO `agency_active_rate` VALUES ('1042', '25', '1', '43', '0', 'oushinanshen', '1505899603361');
INSERT INTO `agency_active_rate` VALUES ('1043', '26', '1', '43', '0', 'wxx899999', '1505899604666');
INSERT INTO `agency_active_rate` VALUES ('1044', '27', '1', '43', '0', '1464975293', '1505899604666');
INSERT INTO `agency_active_rate` VALUES ('1045', '28', '1', '43', '0', 'Bear', '1505899604666');
INSERT INTO `agency_active_rate` VALUES ('1046', '29', '1', '43', '0', 'zxx', '1505899604666');
INSERT INTO `agency_active_rate` VALUES ('1047', '30', '1', '43', '0', 'hy123456', '1505899604666');
INSERT INTO `agency_active_rate` VALUES ('1048', '31', '1', '43', '0', 'wl123', '1505899604666');
INSERT INTO `agency_active_rate` VALUES ('1049', '32', '1', '43', '0', '鳯儿网店', '1505899604666');
INSERT INTO `agency_active_rate` VALUES ('1050', '33', '1', '43', '0', 'ruiruima', '1505899604666');
INSERT INTO `agency_active_rate` VALUES ('1051', '34', '1', '43', '0', '944581678', '1505899604666');
INSERT INTO `agency_active_rate` VALUES ('1052', '35', '1', '43', '0', '2069959168', '1505899604666');
INSERT INTO `agency_active_rate` VALUES ('1053', '36', '1', '43', '0', '570156062', '1505899606151');
INSERT INTO `agency_active_rate` VALUES ('1054', '37', '1', '43', '0', '770733914', '1505899606151');
INSERT INTO `agency_active_rate` VALUES ('1055', '38', '1', '43', '0', '5257', '1505899606151');
INSERT INTO `agency_active_rate` VALUES ('1056', '39', '1', '43', '0', '18734158108', '1505899606151');
INSERT INTO `agency_active_rate` VALUES ('1057', '40', '1', '43', '0', 'xhq1347574865', '1505899606151');
INSERT INTO `agency_active_rate` VALUES ('1058', '41', '1', '43', '0', 'Chen', '1505899606151');
INSERT INTO `agency_active_rate` VALUES ('1059', '42', '1', '43', '0', 'qq130496', '1505899606151');
INSERT INTO `agency_active_rate` VALUES ('1060', '43', '1', '43', '0', 'kevinchow', '1505899606151');
INSERT INTO `agency_active_rate` VALUES ('1061', '44', '1', '43', '0', '17346544413', '1505899606151');
INSERT INTO `agency_active_rate` VALUES ('1062', '45', '1', '43', '0', '2480199685', '1505899606151');
INSERT INTO `agency_active_rate` VALUES ('1063', '46', '1', '43', '0', 'jim145', '1505899608082');
INSERT INTO `agency_active_rate` VALUES ('1064', '47', '1', '43', '0', 'bada', '1505899608082');
INSERT INTO `agency_active_rate` VALUES ('1065', '48', '1', '43', '0', '罗大大', '1505899608082');
INSERT INTO `agency_active_rate` VALUES ('1066', '49', '1', '43', '0', '109', '1505899608082');
INSERT INTO `agency_active_rate` VALUES ('1067', '50', '1', '43', '0', '119', '1505899608082');
INSERT INTO `agency_active_rate` VALUES ('1068', '51', '1', '43', '0', 'gigi77', '1505899608082');
INSERT INTO `agency_active_rate` VALUES ('1069', '52', '1', '43', '0', 'gigi777', '1505899608082');
INSERT INTO `agency_active_rate` VALUES ('1070', '53', '1', '43', '1', '111111', '0');
INSERT INTO `agency_active_rate` VALUES ('1071', '54', '1', '43', '0', 'dada', '1505899608082');
INSERT INTO `agency_active_rate` VALUES ('1072', '55', '1', '43', '0', '源肥呀', '1505899608082');
INSERT INTO `agency_active_rate` VALUES ('1173', '4', '1', '46', '0', 'wzkj', '1505900380262');
INSERT INTO `agency_active_rate` VALUES ('1174', '5', '1', '46', '0', '冰河', '1505900380262');
INSERT INTO `agency_active_rate` VALUES ('1175', '6', '1', '46', '0', 'jiafeng', '1505900380262');
INSERT INTO `agency_active_rate` VALUES ('1176', '7', '1', '46', '0', 'l474705958', '1505900380262');
INSERT INTO `agency_active_rate` VALUES ('1177', '8', '1', '46', '0', '184066643', '1505900380262');
INSERT INTO `agency_active_rate` VALUES ('1178', '9', '1', '46', '0', '2369412', '1505900380262');
INSERT INTO `agency_active_rate` VALUES ('1179', '10', '1', '46', '0', 'hy123', '1505900380262');
INSERT INTO `agency_active_rate` VALUES ('1180', '11', '1', '46', '0', 'zishu', '1505900380262');
INSERT INTO `agency_active_rate` VALUES ('1181', '12', '1', '46', '0', 'tianjing', '1505900380262');
INSERT INTO `agency_active_rate` VALUES ('1182', '13', '1', '46', '0', 'zqy95178250', '1505900380263');
INSERT INTO `agency_active_rate` VALUES ('1183', '14', '1', '46', '0', 'QQ574912927', '1505900381840');
INSERT INTO `agency_active_rate` VALUES ('1184', '15', '1', '46', '0', '1579599827', '1505900381840');
INSERT INTO `agency_active_rate` VALUES ('1185', '17', '1', '46', '0', '789', '1505900381840');
INSERT INTO `agency_active_rate` VALUES ('1186', '18', '1', '46', '0', '112', '1505900381840');
INSERT INTO `agency_active_rate` VALUES ('1187', '20', '1', '46', '0', 'b2218776', '1505900381840');
INSERT INTO `agency_active_rate` VALUES ('1188', '21', '1', '46', '0', '13771547176', '1505900381840');
INSERT INTO `agency_active_rate` VALUES ('1189', '22', '1', '46', '0', '1', '1505900381840');
INSERT INTO `agency_active_rate` VALUES ('1190', '23', '1', '46', '0', '小aq', '1505900381840');
INSERT INTO `agency_active_rate` VALUES ('1191', '24', '1', '46', '0', '15914897978', '1505900381840');
INSERT INTO `agency_active_rate` VALUES ('1192', '25', '1', '46', '0', 'oushinanshen', '1505900381840');
INSERT INTO `agency_active_rate` VALUES ('1193', '26', '1', '46', '0', 'wxx899999', '1505900383582');
INSERT INTO `agency_active_rate` VALUES ('1194', '27', '1', '46', '0', '1464975293', '1505900383582');
INSERT INTO `agency_active_rate` VALUES ('1195', '28', '1', '46', '0', 'Bear', '1505900383582');
INSERT INTO `agency_active_rate` VALUES ('1196', '29', '1', '46', '0', 'zxx', '1505900383582');
INSERT INTO `agency_active_rate` VALUES ('1197', '30', '1', '46', '0', 'hy123456', '1505900383582');
INSERT INTO `agency_active_rate` VALUES ('1198', '31', '1', '46', '0', 'wl123', '1505900383582');
INSERT INTO `agency_active_rate` VALUES ('1199', '32', '1', '46', '0', '鳯儿网店', '1505900383582');
INSERT INTO `agency_active_rate` VALUES ('1200', '33', '1', '46', '0', 'ruiruima', '1505900383582');
INSERT INTO `agency_active_rate` VALUES ('1201', '34', '1', '46', '0', '944581678', '1505900383582');
INSERT INTO `agency_active_rate` VALUES ('1202', '35', '1', '46', '0', '2069959168', '1505900383582');
INSERT INTO `agency_active_rate` VALUES ('1203', '36', '1', '46', '0', '570156062', '1505900386015');
INSERT INTO `agency_active_rate` VALUES ('1204', '37', '1', '46', '0', '770733914', '1505900386015');
INSERT INTO `agency_active_rate` VALUES ('1205', '38', '1', '46', '0', '5257', '1505900386015');
INSERT INTO `agency_active_rate` VALUES ('1206', '39', '1', '46', '0', '18734158108', '1505900386015');
INSERT INTO `agency_active_rate` VALUES ('1207', '40', '1', '46', '0', 'xhq1347574865', '1505900386015');
INSERT INTO `agency_active_rate` VALUES ('1208', '41', '1', '46', '0', 'Chen', '1505900386015');
INSERT INTO `agency_active_rate` VALUES ('1209', '42', '1', '46', '0', 'qq130496', '1505900386015');
INSERT INTO `agency_active_rate` VALUES ('1210', '43', '1', '46', '0', 'kevinchow', '1505900386015');
INSERT INTO `agency_active_rate` VALUES ('1211', '44', '1', '46', '0', '17346544413', '1505900386015');
INSERT INTO `agency_active_rate` VALUES ('1212', '45', '1', '46', '0', '2480199685', '1505900386015');
INSERT INTO `agency_active_rate` VALUES ('1213', '46', '1', '46', '0', 'jim145', '1505900387889');
INSERT INTO `agency_active_rate` VALUES ('1214', '47', '1', '46', '0', 'bada', '1505900387889');
INSERT INTO `agency_active_rate` VALUES ('1215', '48', '1', '46', '0', '罗大大', '1505900387889');
INSERT INTO `agency_active_rate` VALUES ('1216', '49', '1', '46', '0', '109', '1505900387889');
INSERT INTO `agency_active_rate` VALUES ('1217', '50', '1', '46', '0', '119', '1505900387889');
INSERT INTO `agency_active_rate` VALUES ('1218', '51', '1', '46', '0', 'gigi77', '1505900387889');
INSERT INTO `agency_active_rate` VALUES ('1219', '52', '1', '46', '0', 'gigi777', '1505900387889');
INSERT INTO `agency_active_rate` VALUES ('1220', '53', '1', '46', '1', '111111', '0');
INSERT INTO `agency_active_rate` VALUES ('1221', '54', '1', '46', '0', 'dada', '1505900387889');
INSERT INTO `agency_active_rate` VALUES ('1222', '55', '1', '46', '0', '源肥呀', '1505900387889');
INSERT INTO `agency_active_rate` VALUES ('1223', '3', '2', '47', '0', '456', '1505919246683');
INSERT INTO `agency_active_rate` VALUES ('1224', '56', '1', '46', '0', '764388753', '1505958123826');
INSERT INTO `agency_active_rate` VALUES ('1225', '57', '1', '46', '0', '815555213', '1505958123826');
INSERT INTO `agency_active_rate` VALUES ('1226', '56', '1', '36', '0', '764388753', '1505958137853');
INSERT INTO `agency_active_rate` VALUES ('1227', '57', '1', '36', '0', '815555213', '1505958137853');
INSERT INTO `agency_active_rate` VALUES ('1228', '56', '1', '43', '0', '764388753', '1505958522240');
INSERT INTO `agency_active_rate` VALUES ('1229', '57', '1', '43', '0', '815555213', '1505958522240');
INSERT INTO `agency_active_rate` VALUES ('1230', '59', '1', '46', '0', '无厘头', '1505986790229');

-- ----------------------------
-- Table structure for `agency_backward`
-- ----------------------------
DROP TABLE IF EXISTS `agency_backward`;
CREATE TABLE `agency_backward` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ä»£ç†å•†id',
  `root_agency_id` int(11) DEFAULT NULL COMMENT '上一级代理商id',
  `user_name` varchar(32) DEFAULT NULL COMMENT 'ä»£ç†å•†æ˜µç§°ï¼ˆè´¦å·ï¼‰',
  `user_pass` varchar(255) DEFAULT NULL COMMENT 'ä»£ç†å•†å¯†ç ',
  `user_real_name` varchar(255) DEFAULT NULL COMMENT 'ä»£ç†å•†çœŸå®žåå­—',
  `agency_tel` varchar(11) DEFAULT NULL COMMENT 'è”ç³»ç”µè¯',
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
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of agency_backward
-- ----------------------------
INSERT INTO `agency_backward` VALUES ('1', '0', 'xiao', 'xiao', 'xiaoqiang', '', '3004569972&', '', '', null, '1506474904065', 'XXM4', null, '1', null);
INSERT INTO `agency_backward` VALUES ('2', '1', '123', '123', '123', '123', '1727661035', '1727661035@qq.com', '江西省永丰', null, '1505095878921', 'W6C2', '8a982a8a5e9fd1c1015e9fd1c1900000', '1', null);
INSERT INTO `agency_backward` VALUES ('3', '2', '456', '456', '123', '123', '123', '123@456', '123', null, '1506143496652', 'T4JX4W7', null, '0', null);
INSERT INTO `agency_backward` VALUES ('4', '1', 'wzkj', 'wzkj', '何兵', '17707005023', '820267814', '820267814@qq.com', '江西省南昌市高新区', null, '1505389590642', 'MMTX', null, '0', null);
INSERT INTO `agency_backward` VALUES ('5', '1', '冰河', '', '李冰超', '15009525347', '325588827', '35588827@qq.com', '宁夏石嘴山市惠农区', null, '1505397230874', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('6', '1', 'jiafeng', 'jiafeng868', 'jf', '13603997958', '37956093', '37956093@qq.com', '河南郑州', null, '1505402408521', '8XXL', null, '0', null);
INSERT INTO `agency_backward` VALUES ('7', '1', 'l474705958', 'ads321321001', '李晨', '17629105551', '474705958', '474705958@qq.com', '陕西', null, '1505897014257', 'DSL7', null, '0', null);
INSERT INTO `agency_backward` VALUES ('8', '1', '184066643', '184066643', '184066643', '184066643', '184066643', '184066643@qq.com', '184066643', null, '1505484614195', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('9', '1', '2369412', '2369412', '郭阳', '17630587400', '2369412', '2369412@qq.com', '中国河南', null, '1505484849135', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('10', '1', 'hy123', '960528hy', '韩雨', '15191436371', '1114780147', '1114780147@qq.com', '陕西西安', null, '1505485285182', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('11', '1', 'zishu', 'zishu123', '施俊亦', '13489769696', '81650457', '81650457@qq.com', '福建省', null, '1505485407733', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('12', '1', 'tianjing', 'tianjing', 'tianjing', '18273986790', '56968884', '56968884@qq.com', '湖南省', null, '1505486349500', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('13', '1', 'zqy95178250', 'zqy95178250', '邹千宇', '13831729071', '95178250', '95178250@qq.com', '95178250@qq.com', null, '1505487209568', 'HBDJ', null, '0', null);
INSERT INTO `agency_backward` VALUES ('14', '1', 'QQ574912927', 'Q574912927', '微族科技', '18876167757', '574912927', '574912927@qq.com', '江西南昌', null, '1505548396858', 'PUBS', null, '0', null);
INSERT INTO `agency_backward` VALUES ('15', '1', '1579599827', 'asd123456', '钟小六', '18863516250', '1579599827', '1579599827@qq.com', '山东', null, '1505555171857', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('16', '2', 'xiaosan', '123', '123', '123', '123@123.com', '123@123.com', '', null, '1505702946637', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('17', '1', '789', '789', '789', '789', '789', '789@qq.com', '', null, '1505703728736', 'W4NQ', null, '0', null);
INSERT INTO `agency_backward` VALUES ('18', '1', '112', '112', '112', '112', '112', '112@qq.com', '', null, '1505704557368', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('19', '2', '11111', 'xiao', '123', '123', '123', '123@qq.com', '', null, '1505704606872', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('20', '1', 'b2218776', 'wyj123', '巫永健', '13376679503', '841021035', '841021035@qq.com', '', null, '1505704761342', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('21', '1', '13771547176', '191030', '汪具伟', '13771547176', '410166448', '410166448@qq.com', '', null, '1505704868970', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('22', '1', '1', '123', '1', '2', '2@.com', '2@qq.com', '', null, '1505712635147', 'E28U', null, '0', null);
INSERT INTO `agency_backward` VALUES ('23', '1', '小aq', '199712', '朱', '13160777351', '1099435752', '1099435752@qq.com', '', null, '1505719976694', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('24', '1', '15914897978', '123456', '许', '15914897978', '981882844', '981882844@qq.com', '', null, '1505720371086', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('25', '1', 'oushinanshen', '12345qq', '江子川', '15735083175', '1254822700', '1254822700@qq.com', '', null, '1505720890798', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('26', '1', 'wxx899999', '123456', '卫鑫星', '13679296790', '1483710008', '1483710008@qq.com', '', null, '1505722102442', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('27', '1', '1464975293', '1464975293', '周国伟', '47602966154', '1464975293', '1464975293@qq.com', '', null, '1505725569485', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('28', '1', 'Bear', 'asd274623', '赖俊雄', '18820909087', '954836430', '954836430@qq.com', '', null, '1505730497012', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('29', '1', 'zxx', 'zxx123', '张爻', '15664888254', '1054567997', '1054567997@qq.com', '', null, '1505730499251', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('30', '1', 'hy123456', '960528', '王龙', '13944497056', '1664187132', '1664187132@qq.com', '', null, '1505731306220', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('31', '1', 'wl123', '960528', '王龙', '13944493069', '1664187132', '1664187132@qq.com', '', null, '1505731438351', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('32', '1', '鳯儿网店', 'T123456', '鳯儿', '13215109641', '383643152', '383643152@qq.com', '', null, '1505731457757', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('33', '1', 'ruiruima', 'wxl1114520', '倪华娟', '17315850506', '1044601933', '693881963@qq.com', '', null, '1505742798410', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('34', '1', '944581678', '1320465879', '王耀雍', '18758767161', '944581678', '944581678@qq.com', '', null, '1505742805995', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('35', '1', '2069959168', '1531795623', '蔡文姬', '16364256452', '2069959168', '2069959168@qq.com', '', null, '1505743112788', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('36', '1', '570156062', '906686', '邝安联', '13386660915', '570156062', '12@123678', '', null, '1505743566777', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('37', '1', '770733914', '770733914', '刘勇健', '15766031847', '770733914', '770733914@qq.com', '', null, '1505743787277', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('38', '1', '5257', '52575856', '5257', '17691078309', '254853397', '254853397@qq.com', '', null, '1505743826259', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('39', '1', '18734158108', '666222', '左卫鑫', '18734158108', '117647296', '117647296@qq.com', '', null, '1505743883633', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('40', '1', 'xhq1347574865', 'xhq2853098', '许华强', '13359118576', '13359118576', '1354335693@qq.com', '', null, '1505823157007', 'BWE5', null, '0', null);
INSERT INTO `agency_backward` VALUES ('41', '1', 'Chen', 'reborn27', '琛', '15014327583', '1396552584', '1396552584@qq.com', '', null, '1505744411008', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('42', '1', 'qq130496', '123456789', '账', '13128610471', '13128610471', '2431589968@qq.com', '', null, '1505744430320', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('43', '1', 'kevinchow', 'kevinchow520', 'kc', '13088235623', '123456', 'kc@kc.com', '', null, '1505744505920', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('44', '1', '17346544413', 'cyfcyf032525', '云飞', '17346544413', '1648537174', '1648537174@qq.com', '', null, '1505744941429', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('45', '1', '2480199685', 'ljw14141', '李嘉文', '13416662096', '772487533', '772487533@qq.com', '', null, '1505745508514', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('46', '1', 'jim145', '131400', '杨荣锦', '13413057130', '1739120586', '1739120586@qq.com', '', null, '1505747100822', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('47', '1', 'bada', '123456789a!', '张点星', '15023456541', '15023456541', 'badaccount@163.com', '', null, '1505747900461', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('48', '1', '罗大大', '201103', '罗志远', '18047122202', '27579080', '27579080@qq.com', '', null, '1505777025121', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('49', '1', '109', '109', '何晓阳', '15003433795', '819303204', '819303204@qq.com', '', null, '1505780699506', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('50', '1', '119', '119', '晓阳', '15003433795', '819303204', '819303204@qq.com', '', null, '1505781054289', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('51', '1', 'gigi77', '19910803', '徐小琪', '15813324599', '987703275', '15813324599@163.com', '', null, '1505783246196', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('52', '1', 'gigi777', '19910803', '徐小琪', '15813324599', '987703275', '15813324599@163.com', '', null, '1505783990311', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('53', '1', '111111', '960528', '韩云', '18710364039', '18710364039', '1114780147@qq.com', '', null, '1505880444101', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('54', '1', 'dada', '5205057', '权宇', '13208190370', '3004569972', '2248649317@qq.com', '', null, '1505882035062', '3US5', null, '0', null);
INSERT INTO `agency_backward` VALUES ('55', '1', '源肥呀', 'aa8753128', '许源凯', '13682930062', '2985374225', '2985374225@qq.com', '', null, '1505883026363', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('56', '1', '764388753', 'qwe123', '钟益彬', '13421575988', '764388753', '764388753@qq.com', '', null, '1505956994305', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('57', '1', '815555213', 'yebang123888', '廖', '15812910347', '815255213', '815255213@qq.com', '', null, '1505957853277', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('58', '2', '无叮咚', '12', 'W6C2', 'sd', 'aa', 'W6C2@qq.com', '', null, '1505983584355', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('59', '1', '无厘头', 'QQ1244701909', '无厘头', '13800138000', '1244701909', '1244701909@qq.com', '', null, '1505983878309', '', null, '0', null);

-- ----------------------------
-- Table structure for `agency_charge_bank`
-- ----------------------------
DROP TABLE IF EXISTS `agency_charge_bank`;
CREATE TABLE `agency_charge_bank` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bank_account_id` bigint(20) DEFAULT NULL COMMENT '银行卡信息id',
  `agency_id` int(11) DEFAULT NULL COMMENT '代理商id',
  `bill_type` int(11) DEFAULT NULL COMMENT '票务类型（）',
  PRIMARY KEY (`id`),
  KEY `acb_agency` (`agency_id`),
  KEY `fk_acb_bank` (`bank_account_id`),
  CONSTRAINT `acb_agency` FOREIGN KEY (`agency_id`) REFERENCES `agency_backward` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_acb_bank` FOREIGN KEY (`bank_account_id`) REFERENCES `bank_account` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of agency_charge_bank
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of agency_ep
-- ----------------------------
INSERT INTO `agency_ep` VALUES ('24', '1', 'xiao', '32', 'wzkj');

-- ----------------------------
-- Table structure for `bank_account`
-- ----------------------------
DROP TABLE IF EXISTS `bank_account`;
CREATE TABLE `bank_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) DEFAULT NULL COMMENT '充值账户id',
  `remittance_way` varchar(255) DEFAULT NULL COMMENT '汇款方式',
  `remittance_bank_account` varchar(255) DEFAULT NULL COMMENT '汇款账号',
  `account_name` varchar(255) DEFAULT NULL COMMENT '账户真实姓名',
  `reference_balance` double DEFAULT NULL COMMENT '对账余额',
  `agency_id` int(11) DEFAULT NULL COMMENT '引用账户所属代理商',
  `use_state` int(11) DEFAULT NULL COMMENT '使用状态',
  `polarity` int(11) DEFAULT NULL COMMENT '使用方式（1-加款卡，0-被加卡）',
  PRIMARY KEY (`id`),
  KEY `fk_ba_account` (`account_id`),
  KEY `fk_ba_agency` (`agency_id`),
  CONSTRAINT `fk_ba_account` FOREIGN KEY (`account_id`) REFERENCES `charge_account` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_ba_agency` FOREIGN KEY (`agency_id`) REFERENCES `agency_backward` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bank_account
-- ----------------------------
INSERT INTO `bank_account` VALUES ('17', '28', '工商对公卡', '7541541545512154655', '宁强', '30900', '1', null, '1');
INSERT INTO `bank_account` VALUES ('19', '54', '工商对公卡', '71111111111', '李威', '1300', '2', null, '1');
INSERT INTO `bank_account` VALUES ('20', '2', '建设银行对私卡', '322222222222222222', '李威', '2700', '2', null, '1');
INSERT INTO `bank_account` VALUES ('21', '54', '工商对公卡', '7541541545512154655', '宁强', null, '1', '1', '1');
INSERT INTO `bank_account` VALUES ('23', '3', '支付宝', '13699562589', '宁强', '200', '3', null, '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of channel_channel
-- ----------------------------
INSERT INTO `channel_channel` VALUES ('22', '微族 浙江移动', '10& 30& 70& 100& 150& 300& 500& 1024& 2048& 3072& 4096& 6144& 11264', '32', null, null, null, null, '1', '0', '1506475346019', '1');
INSERT INTO `channel_channel` VALUES ('30', '微族-宁夏本地', '10& 30& 70& 150& 500& 1024& 2048& 3072& 4096& 6144& 11264', '32', null, null, null, null, '0', '0', '1505784729788', '1');
INSERT INTO `channel_channel` VALUES ('46', '微族-陕西移动', '10& 30& 70& 100& 150& 300& 500& 1024& 2048& 3072& 4096& 6144& 11264', '32', null, null, null, null, '0', '0', null, '1');
INSERT INTO `channel_channel` VALUES ('47', '微族-黑龙江移动', '10& 30& 70& 100& 150& 300& 500& 1024& 2048& 3072& 4096& 6144& 11264', '32', null, null, null, null, '0', '0', null, '1');
INSERT INTO `channel_channel` VALUES ('48', '微族-广东特殊包', '300', '32', null, null, null, null, '0', '0', '1505900431526', '1');
INSERT INTO `channel_channel` VALUES ('49', '微族-内蒙古移动', '10& 30& 70& 100& 150& 300& 500& 1024& 2048& 3072& 4096& 6144& 11264', '32', null, null, null, null, '0', '0', '1505900428852', '1');
INSERT INTO `channel_channel` VALUES ('51', '微族-山东移动', '10& 30& 70& 100& 150& 300& 500& 1024& 2048& 4096& 3072& 6144& 11264', '32', null, null, null, null, '0', '0', null, '1');
INSERT INTO `channel_channel` VALUES ('52', '微族-浙江移动', '10& 30& 70& 100& 150& 300& 500& 1024& 2048& 3072& 4096& 6144& 11264', '32', null, null, null, null, '0', '0', '1505900426093', '1');
INSERT INTO `channel_channel` VALUES ('53', '微族-山西移动', '10& 30& 70& 100& 150& 300& 500& 1024& 2048& 3072& 4096& 6144& 11264', '32', null, null, null, null, '0', '0', '1505900423985', '1');
INSERT INTO `channel_channel` VALUES ('56', '微族-安徽移动', '10& 30& 70& 100& 150& 300& 500& 1024& 2048', '32', null, null, null, null, '0', '0', '1505899972071', '1');
INSERT INTO `channel_channel` VALUES ('57', '微族-湖南移动', '10& 30& 70& 100& 150& 300& 500& 1024& 2048& 3072& 4096& 6144& 11264', '32', null, null, null, null, '0', '0', '1505900419160', '1');
INSERT INTO `channel_channel` VALUES ('61', '微族-陕西本地移动', '500& 1024& 2048& 3072& 4096& 6144& 11264& 100& 300', '32', null, null, null, null, '0', '0', '1507858161512', '1');
INSERT INTO `channel_channel` VALUES ('62', '微族-陕西本地移动-带', '10& 30& 70& 150', '32', null, null, null, null, '0', '0', null, '1');
INSERT INTO `channel_channel` VALUES ('63', '微族-宁夏移动-省漫游-带', '10& 30& 70& 100& 150& 300& 500& 1024& 2048& 3072', '32', null, null, null, null, '0', '0', null, '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of channel_discount
-- ----------------------------
INSERT INTO `channel_discount` VALUES ('19', '22', '11', '0.46', '省漫游-微族 浙江移动', '0', '0', '2', '0');
INSERT INTO `channel_discount` VALUES ('27', '30', '29', '0.47', '省内-微族-宁夏本地', '0', '0', '1', '0');
INSERT INTO `channel_discount` VALUES ('43', '46', '26', '0.72', '省漫游-微族-陕西移动', '0', '0', '2', '0');
INSERT INTO `channel_discount` VALUES ('44', '47', '08', '0.76', '省漫游-微族-黑龙江移动', '0', '0', '2', '0');
INSERT INTO `channel_discount` VALUES ('45', '48', '19', '0.7', '省漫游-微族-广东特殊包', '0', '0', '2', '0');
INSERT INTO `channel_discount` VALUES ('46', '49', '05', '0.62', '省漫游-微族-内蒙古移动', '0', '0', '2', '0');
INSERT INTO `channel_discount` VALUES ('48', '51', '15', '0.612', '省漫游-微族-山东移动', '0', '0', '2', '0');
INSERT INTO `channel_discount` VALUES ('49', '52', '11', '0.445', '省漫游-微族-浙江移动', '0', '0', '2', '0');
INSERT INTO `channel_discount` VALUES ('50', '53', '04', '0.467', '省漫游-微族-山西移动', '0', '0', '2', '0');
INSERT INTO `channel_discount` VALUES ('53', '56', '12', '0.448', '省漫游-微族-安徽移动', '0', '0', '2', '0');
INSERT INTO `channel_discount` VALUES ('54', '57', '18', '0.768', '省漫游-微族-湖南移动', '0', '0', '2', '0');
INSERT INTO `channel_discount` VALUES ('58', '61', '26', '0.31', '省内-微族-陕西本地移动', '0', '0', '1', '0');
INSERT INTO `channel_discount` VALUES ('59', '62', '26', '0.41', '微族-陕西本地移动-带', '0', '0', '1', '0');
INSERT INTO `channel_discount` VALUES ('60', '63', '29', '0.88', '微族-宁夏移动-省漫游-带', '0', '1', '2', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of charge_account
-- ----------------------------
INSERT INTO `charge_account` VALUES ('1', '-99782.455', null, null, '0', '1', '0', null, '1495689716779', null);
INSERT INTO `charge_account` VALUES ('2', '401.58', '中国银行', '123', '0', '2', '0', null, '1505095878921', '123');
INSERT INTO `charge_account` VALUES ('3', '89.56', null, null, '0', '3', '0', null, '1505099730745', '456');
INSERT INTO `charge_account` VALUES ('4', '0', null, null, '0', '4', '0', null, '1505389590642', 'wzkj');
INSERT INTO `charge_account` VALUES ('5', '0', null, null, '0', '5', '0', null, '1505397230874', '冰河');
INSERT INTO `charge_account` VALUES ('6', '0', '121212', '121212', '0', '6', '0', null, '1505402408521', 'jiafeng');
INSERT INTO `charge_account` VALUES ('7', '798.5', null, null, '0', '7', '0', null, '1505451449663', 'l474705958');
INSERT INTO `charge_account` VALUES ('8', '0', null, null, '0', '8', '0', null, '1505484614195', '184066643');
INSERT INTO `charge_account` VALUES ('9', '0', null, null, '0', '9', '0', null, '1505484849135', '2369412');
INSERT INTO `charge_account` VALUES ('10', '-69.4', null, null, '0', '10', '0', null, '1505485285182', 'hy123');
INSERT INTO `charge_account` VALUES ('11', '0', null, null, '0', '11', '0', null, '1505485407733', 'zishu');
INSERT INTO `charge_account` VALUES ('12', '0', null, null, '0', '12', '0', null, '1505486349500', 'tianjing');
INSERT INTO `charge_account` VALUES ('13', '0', null, null, '0', '13', '0', null, '1505487209568', 'zqy95178250');
INSERT INTO `charge_account` VALUES ('14', '0', null, null, '0', '14', '0', null, '1505548396858', 'QQ574912927');
INSERT INTO `charge_account` VALUES ('15', '0', null, null, '0', '15', '0', null, '1505555171857', '1579599827');
INSERT INTO `charge_account` VALUES ('16', '0', null, null, '0', '16', '0', null, '1505702946637', 'xiaosan');
INSERT INTO `charge_account` VALUES ('17', '0', null, null, '0', '17', '0', null, '1505703728736', '789');
INSERT INTO `charge_account` VALUES ('18', '0', null, null, '0', '18', '0', null, '1505704557368', '112');
INSERT INTO `charge_account` VALUES ('19', '0', null, null, '0', '19', '0', null, '1505704606872', '11111');
INSERT INTO `charge_account` VALUES ('20', '0', '支付宝', '13376679503', '0', '20', '0', null, '1505704761342', 'b2218776');
INSERT INTO `charge_account` VALUES ('21', '0', null, null, '0', '21', '0', null, '1505704868970', '13771547176');
INSERT INTO `charge_account` VALUES ('22', '0', null, null, '0', '22', '0', null, '1505712635147', '1');
INSERT INTO `charge_account` VALUES ('23', '0', null, null, '0', '23', '0', null, '1505719976694', '小aq');
INSERT INTO `charge_account` VALUES ('24', '0', null, null, '0', '24', '0', null, '1505720371086', '15914897978');
INSERT INTO `charge_account` VALUES ('25', '0', null, null, '0', '25', '0', null, '1505720890798', 'oushinanshen');
INSERT INTO `charge_account` VALUES ('26', '28.3', null, null, '0', '26', '0', null, '1505722102442', 'wxx899999');
INSERT INTO `charge_account` VALUES ('27', '0', null, null, '0', '27', '0', null, '1505725569485', '1464975293');
INSERT INTO `charge_account` VALUES ('28', '0', null, null, '0', '1', '1', null, '1505730448737', 'xiao');
INSERT INTO `charge_account` VALUES ('29', '0', null, null, '0', '28', '0', null, '1505730497012', 'Bear');
INSERT INTO `charge_account` VALUES ('30', '0', null, null, '0', '29', '0', null, '1505730499251', 'zxx');
INSERT INTO `charge_account` VALUES ('31', '0', null, null, '0', '30', '0', null, '1505731306220', 'hy123456');
INSERT INTO `charge_account` VALUES ('32', '-184.8', null, null, '0', '31', '0', null, '1505731438351', 'wl123');
INSERT INTO `charge_account` VALUES ('33', '0', null, null, '0', '32', '0', null, '1505731457757', '鳯儿网店');
INSERT INTO `charge_account` VALUES ('34', '0', null, null, '0', '33', '0', null, '1505742798410', 'ruiruima');
INSERT INTO `charge_account` VALUES ('35', '0', null, null, '0', '34', '0', null, '1505742805995', '944581678');
INSERT INTO `charge_account` VALUES ('36', '0', null, null, '0', '35', '0', null, '1505743112788', '2069959168');
INSERT INTO `charge_account` VALUES ('37', '0', null, null, '0', '36', '0', null, '1505743566777', '570156062');
INSERT INTO `charge_account` VALUES ('38', '0', '支付宝', '15766031847', '0', '37', '0', null, '1505743787277', '770733914');
INSERT INTO `charge_account` VALUES ('39', '6.9', null, null, '0', '38', '0', null, '1505743826259', '5257');
INSERT INTO `charge_account` VALUES ('40', '0', null, null, '0', '39', '0', null, '1505743883633', '18734158108');
INSERT INTO `charge_account` VALUES ('41', '0', null, null, '0', '40', '0', null, '1505744071753', 'xhq1347574865');
INSERT INTO `charge_account` VALUES ('42', '0', null, null, '0', '41', '0', null, '1505744411008', 'Chen');
INSERT INTO `charge_account` VALUES ('43', '0', null, null, '0', '42', '0', null, '1505744430320', 'qq130496');
INSERT INTO `charge_account` VALUES ('44', '0', null, null, '0', '43', '0', null, '1505744505920', 'kevinchow');
INSERT INTO `charge_account` VALUES ('45', '0', null, null, '0', '44', '0', null, '1505744941429', '17346544413');
INSERT INTO `charge_account` VALUES ('46', '0', null, null, '0', '45', '0', null, '1505745508514', '2480199685');
INSERT INTO `charge_account` VALUES ('47', '0', null, null, '0', '46', '0', null, '1505747100822', 'jim145');
INSERT INTO `charge_account` VALUES ('48', '0', null, null, '0', '47', '0', null, '1505747900461', 'bada');
INSERT INTO `charge_account` VALUES ('49', '0', null, null, '0', '48', '0', null, '1505777025121', '罗大大');
INSERT INTO `charge_account` VALUES ('50', '0', null, null, '0', '49', '0', null, '1505780699506', '109');
INSERT INTO `charge_account` VALUES ('51', '0', null, null, '0', '50', '0', null, '1505781054289', '119');
INSERT INTO `charge_account` VALUES ('52', '0', null, null, '0', '51', '0', null, '1505783246196', 'gigi77');
INSERT INTO `charge_account` VALUES ('53', '0', null, null, '0', '52', '0', null, '1505783990311', 'gigi777');
INSERT INTO `charge_account` VALUES ('54', '900', null, null, '0', '2', '1', null, '1505874476912', '123');
INSERT INTO `charge_account` VALUES ('55', '6.9', null, null, '0', '53', '0', null, '1505880444101', '111111');
INSERT INTO `charge_account` VALUES ('56', '0', null, null, '0', '54', '0', null, '1505880504457', 'dada');
INSERT INTO `charge_account` VALUES ('57', '0', null, null, '0', '55', '0', null, '1505883026363', '源肥呀');
INSERT INTO `charge_account` VALUES ('58', '0', null, null, '0', '56', '0', null, '1505956994305', '764388753');
INSERT INTO `charge_account` VALUES ('59', '0', null, null, '0', '57', '0', null, '1505957853277', '815555213');
INSERT INTO `charge_account` VALUES ('60', '0', null, null, '0', '58', '0', null, '1505983584355', '无叮咚');
INSERT INTO `charge_account` VALUES ('61', '1', null, null, '0', '59', '0', null, '1505983878309', '无厘头');

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
  `account_type` int(11) DEFAULT NULL COMMENT '充值扣款标识(0-充值，1-扣款)',
  `account_id` int(11) DEFAULT NULL COMMENT '账户id',
  `charge_for` int(11) DEFAULT NULL COMMENT '发生原因',
  `purchase_id` bigint(20) DEFAULT NULL COMMENT '订单id',
  PRIMARY KEY (`id`),
  KEY `fk_cr_account` (`account_id`),
  CONSTRAINT `fk_cr_account` FOREIGN KEY (`account_id`) REFERENCES `charge_account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=232 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of charge_record
-- ----------------------------
INSERT INTO `charge_record` VALUES ('1', '1505110515253', '3000', '-96093.26', '-99093.26', '1', '1', '1', null);
INSERT INTO `charge_record` VALUES ('2', '1505110515267', '3000', '0', '3000', '0', '2', '1', null);
INSERT INTO `charge_record` VALUES ('3', '1505120440644', '242.2', '3000', '2757.8', '1', '2', '1', '733132175595016192');
INSERT INTO `charge_record` VALUES ('4', '1505120440694', '238', '-98851.06', '-99089.06', '1', '1', '1', '733132175595016192');
INSERT INTO `charge_record` VALUES ('5', '1505459685489', '1.71', '2757.8', '2756.09', '1', '2', '1', '734555071601184768');
INSERT INTO `charge_record` VALUES ('6', '1505459685505', '1.68', '-99087.35', '-99089.03', '1', '1', '1', '734555071601184768');
INSERT INTO `charge_record` VALUES ('7', '1505459760710', '1.71', '2756.09', '2754.38', '1', '2', '1', '734555387096731648');
INSERT INTO `charge_record` VALUES ('8', '1505459760721', '1.68', '-99087.32', '-99089', '1', '1', '1', '734555387096731648');
INSERT INTO `charge_record` VALUES ('9', '1505459760000', '1.71', '2754.38', '2756.09', '2', '2', '1', '734555387096731648');
INSERT INTO `charge_record` VALUES ('10', '1505459760000', '1.68', '-99089', '-99087.32', '2', '1', '1', '734555387096731648');
INSERT INTO `charge_record` VALUES ('11', '1505459930561', '1.71', '2756.09', '2754.38', '1', '2', '1', '734556099503460352');
INSERT INTO `charge_record` VALUES ('12', '1505459930580', '1.68', '-99085.61', '-99087.29', '1', '1', '1', '734556099503460352');
INSERT INTO `charge_record` VALUES ('13', '1505460179011', '1.71', '2754.38', '2752.67', '1', '2', '1', '734557141578289152');
INSERT INTO `charge_record` VALUES ('14', '1505460179027', '1.68', '-99085.58', '-99087.26', '1', '1', '1', '734557141578289152');
INSERT INTO `charge_record` VALUES ('15', '1505460179088', '1.71', '2754.38', '2752.67', '1', '2', '1', '734557141901250560');
INSERT INTO `charge_record` VALUES ('16', '1505460179242', '1.68', '-99085.58', '-99087.26', '1', '1', '1', '734557141901250560');
INSERT INTO `charge_record` VALUES ('17', '1505460259655', '1.71', '2752.67', '2750.96', '1', '2', '1', '734557479823740928');
INSERT INTO `charge_record` VALUES ('18', '1505460259678', '1.68', '-99085.55', '-99087.23', '1', '1', '1', '734557479823740928');
INSERT INTO `charge_record` VALUES ('19', '1505460269962', '1.71', '2750.96', '2749.25', '1', '2', '1', '734557523054432256');
INSERT INTO `charge_record` VALUES ('20', '1505460269976', '1.68', '-99085.52', '-99087.2', '1', '1', '1', '734557523054432256');
INSERT INTO `charge_record` VALUES ('21', '1505460270000', '1.71', '2749.25', '2750.96', '2', '2', '1', '734557523054432256');
INSERT INTO `charge_record` VALUES ('22', '1505460270000', '1.68', '-99087.2', '-99085.52', '2', '1', '1', '734557523054432256');
INSERT INTO `charge_record` VALUES ('23', '1505460259000', '1.71', '2750.96', '2752.67', '2', '2', '1', '734557479823740928');
INSERT INTO `charge_record` VALUES ('24', '1505460259000', '1.68', '-99085.52', '-99083.84', '2', '1', '1', '734557479823740928');
INSERT INTO `charge_record` VALUES ('25', '1505460179000', '1.71', '2752.67', '2754.38', '2', '2', '1', '734557141901250560');
INSERT INTO `charge_record` VALUES ('26', '1505460179000', '1.68', '-99083.84', '-99082.16', '2', '1', '1', '734557141901250560');
INSERT INTO `charge_record` VALUES ('27', '1505460179000', '1.71', '2754.38', '2756.09', '2', '2', '1', '734557141578289152');
INSERT INTO `charge_record` VALUES ('28', '1505460179000', '1.68', '-99082.16', '-99080.48', '2', '1', '1', '734557141578289152');
INSERT INTO `charge_record` VALUES ('29', '1505464964624', '1.68', '-99080.48', '-99082.16', '1', '1', '1', '734577213864677376');
INSERT INTO `charge_record` VALUES ('30', '1505465141946', '1.68', '-99082.16', '-99083.84', '1', '1', '1', '734577957615439872');
INSERT INTO `charge_record` VALUES ('31', '1505465339220', '1.68', '-99083.84', '-99085.52', '1', '1', '1', '734578785042567168');
INSERT INTO `charge_record` VALUES ('32', '1505465383564', '1.74', '2756.09', '2754.35', '1', '2', '1', '734578971055755264');
INSERT INTO `charge_record` VALUES ('33', '1505465383579', '1.68', '-99083.78', '-99085.46', '1', '1', '1', '734578971055755264');
INSERT INTO `charge_record` VALUES ('34', '1505466918070', '1.74', '2754.35', '2752.61', '1', '2', '1', '734585407244603392');
INSERT INTO `charge_record` VALUES ('35', '1505466918597', '1.68', '-99083.72', '-99085.4', '1', '1', '1', '734585407244603392');
INSERT INTO `charge_record` VALUES ('36', '1505547039855', '1.995', '-99085.4', '-99087.395', '1', '1', '1', '734921441190875136');
INSERT INTO `charge_record` VALUES ('37', '1505547647717', '1.74', '0', '-1.74', '1', '2', '1', '734924011921739776');
INSERT INTO `charge_record` VALUES ('38', '1505547647735', '1.695', '-99085.655', '-99087.35', '1', '1', '1', '734924011921739776');
INSERT INTO `charge_record` VALUES ('39', '1505547792811', '1.74', '-1.74', '-3.48', '1', '2', '1', '734924620490084352');
INSERT INTO `charge_record` VALUES ('40', '1505547792823', '1.695', '-99085.61', '-99087.305', '1', '1', '1', '734924620490084352');
INSERT INTO `charge_record` VALUES ('41', '1505555187652', '2.01', '-3.48', '-5.49', '1', '2', '1', '734955636709658624');
INSERT INTO `charge_record` VALUES ('42', '1505555188174', '1.995', '-99085.295', '-99087.29', '1', '1', '1', '734955636709658624');
INSERT INTO `charge_record` VALUES ('43', '1505558194080', '2.01', '-5.49', '-7.5', '1', '2', '1', '734968246582644736');
INSERT INTO `charge_record` VALUES ('44', '1505558194117', '1.995', '-99085.28', '-99087.275', '1', '1', '1', '734968246582644736');
INSERT INTO `charge_record` VALUES ('45', '1505563802978', '2.85', '-99087.275', '-99090.125', '1', '1', '1', '734991771976601600');
INSERT INTO `charge_record` VALUES ('46', '1505564020492', '2.85', '-99090.125', '-99092.975', '1', '1', '1', '734992684296441856');
INSERT INTO `charge_record` VALUES ('47', '1505564437679', '2.85', '-99092.975', '-99090.125', '2', '1', '1', '734991771976601600');
INSERT INTO `charge_record` VALUES ('48', '1505628661701', '1.74', '-7.5', '-9.24', '1', '2', '1', '735263809198886912');
INSERT INTO `charge_record` VALUES ('49', '1505628661715', '1.71', '-99088.385', '-99090.095', '1', '1', '1', '735263809198886912');
INSERT INTO `charge_record` VALUES ('50', '1505698529623', '1.74', '-9.24', '-10.98', '1', '2', '1', '735556856507797504');
INSERT INTO `charge_record` VALUES ('51', '1505698530177', '1.71', '-99088.355', '-99090.065', '1', '1', '1', '735556856507797504');
INSERT INTO `charge_record` VALUES ('52', '1505698531000', '1.74', '-10.98', '-9.24', '2', '2', '1', '735556856507797504');
INSERT INTO `charge_record` VALUES ('53', '1505698531000', '1.71', '-99090.065', '-99088.355', '2', '1', '1', '735556856507797504');
INSERT INTO `charge_record` VALUES ('54', '1505700592385', '1.71', '-99088.355', '-99090.065', '1', '1', '1', '735565336828448768');
INSERT INTO `charge_record` VALUES ('55', '1505715363877', '23', '-99090.065', '-99113.065', '1', '1', '1', null);
INSERT INTO `charge_record` VALUES ('56', '1505715363887', '23', '0', '23', '0', '10', '1', null);
INSERT INTO `charge_record` VALUES ('57', '1505717798109', '0.99', '-99113.065', '-99114.055', '1', '1', '1', '735637674362146816');
INSERT INTO `charge_record` VALUES ('58', '1505719186588', '0.99', '-99114.055', '-99115.045', '1', '1', '1', '735643477341114368');
INSERT INTO `charge_record` VALUES ('59', '1505719189000', '0.99', '-99115.045', '-99114.055', '2', '1', '1', '735643477341114368');
INSERT INTO `charge_record` VALUES ('60', '1505730532546', '92.4', '23', '-69.4', '1', '10', '1', '735691086504136704');
INSERT INTO `charge_record` VALUES ('61', '1505730532607', '92.4', '-99021.655', '-99114.055', '1', '1', '1', '735691086504136704');
INSERT INTO `charge_record` VALUES ('62', '1505731851229', '92.4', '0', '-92.4', '1', '32', '1', '735696617457324032');
INSERT INTO `charge_record` VALUES ('63', '1505731851245', '92.4', '-99021.655', '-99114.055', '1', '1', '1', '735696617457324032');
INSERT INTO `charge_record` VALUES ('64', '1505731890031', '92.4', '-92.4', '-184.8', '1', '32', '1', '735696780196319232');
INSERT INTO `charge_record` VALUES ('65', '1505731890045', '92.4', '-99021.655', '-99114.055', '1', '1', '1', '735696780196319232');
INSERT INTO `charge_record` VALUES ('66', '1505732961962', '92.4', '-184.8', '-277.2', '1', '32', '1', '735701276200800256');
INSERT INTO `charge_record` VALUES ('67', '1505732961986', '92.4', '-99021.655', '-99114.055', '1', '1', '1', '735701276200800256');
INSERT INTO `charge_record` VALUES ('68', '1505732962000', '92.4', '-277.2', '-184.8', '2', '32', '1', '735701276200800256');
INSERT INTO `charge_record` VALUES ('69', '1505732962000', '92.4', '-99114.055', '-99021.655', '2', '1', '1', '735701276200800256');
INSERT INTO `charge_record` VALUES ('70', '1505784609680', '10', '-99021.655', '-99031.655', '1', '1', '1', null);
INSERT INTO `charge_record` VALUES ('71', '1505784609685', '10', '0', '10', '0', '39', '1', null);
INSERT INTO `charge_record` VALUES ('72', '1505784729085', '0.99', '10', '9.01', '1', '39', '1', '735918403251867648');
INSERT INTO `charge_record` VALUES ('73', '1505784729105', '0.99', '-99030.665', '-99031.655', '1', '1', '1', '735918403251867648');
INSERT INTO `charge_record` VALUES ('74', '1505784729000', '0.99', '9.01', '10', '2', '39', '1', '735918403251867648');
INSERT INTO `charge_record` VALUES ('75', '1505784729000', '0.99', '-99031.655', '-99030.665', '2', '1', '1', '735918403251867648');
INSERT INTO `charge_record` VALUES ('76', '1505817539496', '0.99', '10', '9.01', '1', '39', '1', '736056020098355200');
INSERT INTO `charge_record` VALUES ('77', '1505817539514', '0.99', '-99029.675', '-99030.665', '1', '1', '1', '736056020098355200');
INSERT INTO `charge_record` VALUES ('78', '1505817539000', '0.99', '9.01', '10', '2', '39', '1', '736056020098355200');
INSERT INTO `charge_record` VALUES ('79', '1505817539000', '0.99', '-99030.665', '-99029.675', '2', '1', '1', '736056020098355200');
INSERT INTO `charge_record` VALUES ('80', '1505819312565', '9.9', '10', '0.1', '1', '39', '1', '736063456880365568');
INSERT INTO `charge_record` VALUES ('81', '1505819312582', '9.9', '-99019.775', '-99029.675', '1', '1', '1', '736063456880365568');
INSERT INTO `charge_record` VALUES ('82', '1505819511093', '9.9', '0.1', '10', '2', '39', '1', '736063456880365568');
INSERT INTO `charge_record` VALUES ('83', '1505819511093', '9.9', '-99029.675', '-99019.775', '2', '1', '1', '736063456880365568');
INSERT INTO `charge_record` VALUES ('84', '1505871727968', '100', '-99019.775', '-99119.775', '1', '1', '1', null);
INSERT INTO `charge_record` VALUES ('85', '1505871727972', '100', '-9.24', '90.76', '0', '2', '1', null);
INSERT INTO `charge_record` VALUES ('86', '1505871743736', '9.9', '90.76', '80.86', '1', '2', '1', '736283369150615552');
INSERT INTO `charge_record` VALUES ('87', '1505871743747', '9.9', '-99109.875', '-99119.775', '1', '1', '1', '736283369150615552');
INSERT INTO `charge_record` VALUES ('88', '1505871743000', '9.9', '80.86', '90.76', '2', '2', '1', '736283369150615552');
INSERT INTO `charge_record` VALUES ('89', '1505871743000', '9.9', '-99119.775', '-99109.875', '2', '1', '1', '736283369150615552');
INSERT INTO `charge_record` VALUES ('90', '1505880699466', '30', '-99109.875', '-99139.875', '1', '1', '1', null);
INSERT INTO `charge_record` VALUES ('91', '1505880699469', '30', '0', '30', '0', '55', '1', null);
INSERT INTO `charge_record` VALUES ('92', '1505881141062', '23.1', '30', '6.9', '1', '55', '1', '736322784392646656');
INSERT INTO `charge_record` VALUES ('93', '1505881141074', '23.1', '-99116.775', '-99139.875', '1', '1', '1', '736322784392646656');
INSERT INTO `charge_record` VALUES ('94', '1505881141000', '23.1', '6.9', '30', '2', '55', '1', '736322784392646656');
INSERT INTO `charge_record` VALUES ('95', '1505881141000', '23.1', '-99139.875', '-99116.775', '2', '1', '1', '736322784392646656');
INSERT INTO `charge_record` VALUES ('96', '1505881979502', '21.7', '30', '8.3', '1', '55', '1', '736326301064892416');
INSERT INTO `charge_record` VALUES ('97', '1505881979553', '23.1', '-99095.075', '-99118.175', '1', '1', '1', '736326301064892416');
INSERT INTO `charge_record` VALUES ('98', '1505899918958', '1000', '-99118.175', '-100118.175', '1', '1', '1', null);
INSERT INTO `charge_record` VALUES ('99', '1505899918963', '1000', '0', '1000', '0', '7', '1', null);
INSERT INTO `charge_record` VALUES ('100', '1505900170153', '15.5', '1000', '984.5', '1', '7', '1', '736402598193532928');
INSERT INTO `charge_record` VALUES ('101', '1505900170166', '15.5', '-100102.675', '-100118.175', '1', '1', '1', '736402598193532928');
INSERT INTO `charge_record` VALUES ('102', '1505881141000', '23.1', '8.3', '31.4', '2', '55', '1', '736322784392646656');
INSERT INTO `charge_record` VALUES ('103', '1505881141000', '23.1', '-100118.175', '-100095.075', '2', '1', '1', '736322784392646656');
INSERT INTO `charge_record` VALUES ('104', '1505871743000', '9.9', '90.76', '100.66', '2', '2', '1', '736283369150615552');
INSERT INTO `charge_record` VALUES ('105', '1505871743000', '9.9', '-100095.075', '-100085.175', '2', '1', '1', '736283369150615552');
INSERT INTO `charge_record` VALUES ('106', '1505881141000', '23.1', '31.4', '54.5', '2', '55', '1', '736322784392646656');
INSERT INTO `charge_record` VALUES ('107', '1505881141000', '23.1', '-100085.175', '-100062.075', '2', '1', '1', '736322784392646656');
INSERT INTO `charge_record` VALUES ('108', '1505871743000', '9.9', '100.66', '110.56', '2', '2', '1', '736283369150615552');
INSERT INTO `charge_record` VALUES ('109', '1505871743000', '9.9', '-100062.075', '-100052.175', '2', '1', '1', '736283369150615552');
INSERT INTO `charge_record` VALUES ('110', '1505881141000', '23.1', '54.5', '77.6', '2', '55', '1', '736322784392646656');
INSERT INTO `charge_record` VALUES ('111', '1505881141000', '23.1', '-100052.175', '-100029.075', '2', '1', '1', '736322784392646656');
INSERT INTO `charge_record` VALUES ('112', '1505871743000', '9.9', '110.56', '120.46', '2', '2', '1', '736283369150615552');
INSERT INTO `charge_record` VALUES ('113', '1505871743000', '9.9', '-100029.075', '-100019.175', '2', '1', '1', '736283369150615552');
INSERT INTO `charge_record` VALUES ('114', '1505881141000', '23.1', '77.6', '100.7', '2', '55', '1', '736322784392646656');
INSERT INTO `charge_record` VALUES ('115', '1505881141000', '23.1', '-100019.175', '-99996.075', '2', '1', '1', '736322784392646656');
INSERT INTO `charge_record` VALUES ('116', '1505871743000', '9.9', '120.46', '130.36', '2', '2', '1', '736283369150615552');
INSERT INTO `charge_record` VALUES ('117', '1505871743000', '9.9', '-99996.075', '-99986.175', '2', '1', '1', '736283369150615552');
INSERT INTO `charge_record` VALUES ('118', '1505881141000', '23.1', '100.7', '123.8', '2', '55', '1', '736322784392646656');
INSERT INTO `charge_record` VALUES ('119', '1505881141000', '23.1', '-99986.175', '-99963.075', '2', '1', '1', '736322784392646656');
INSERT INTO `charge_record` VALUES ('120', '1505871743000', '9.9', '130.36', '140.26', '2', '2', '1', '736283369150615552');
INSERT INTO `charge_record` VALUES ('121', '1505871743000', '9.9', '-99963.075', '-99953.175', '2', '1', '1', '736283369150615552');
INSERT INTO `charge_record` VALUES ('122', '1505881141000', '23.1', '123.8', '146.9', '2', '55', '1', '736322784392646656');
INSERT INTO `charge_record` VALUES ('123', '1505881141000', '23.1', '-99953.175', '-99930.075', '2', '1', '1', '736322784392646656');
INSERT INTO `charge_record` VALUES ('124', '1505871743000', '9.9', '140.26', '150.16', '2', '2', '1', '736283369150615552');
INSERT INTO `charge_record` VALUES ('125', '1505871743000', '9.9', '-99930.075', '-99920.175', '2', '1', '1', '736283369150615552');
INSERT INTO `charge_record` VALUES ('126', '1505881141000', '23.1', '146.9', '170', '2', '55', '1', '736322784392646656');
INSERT INTO `charge_record` VALUES ('127', '1505881141000', '23.1', '-99920.175', '-99897.075', '2', '1', '1', '736322784392646656');
INSERT INTO `charge_record` VALUES ('128', '1505871743000', '9.9', '150.16', '160.06', '2', '2', '1', '736283369150615552');
INSERT INTO `charge_record` VALUES ('129', '1505871743000', '9.9', '-99897.075', '-99887.175', '2', '1', '1', '736283369150615552');
INSERT INTO `charge_record` VALUES ('130', '1505881141000', '23.1', '170', '193.1', '2', '55', '1', '736322784392646656');
INSERT INTO `charge_record` VALUES ('131', '1505881141000', '23.1', '-99887.175', '-99864.075', '2', '1', '1', '736322784392646656');
INSERT INTO `charge_record` VALUES ('132', '1505871743000', '9.9', '160.06', '169.96', '2', '2', '1', '736283369150615552');
INSERT INTO `charge_record` VALUES ('133', '1505871743000', '9.9', '-99864.075', '-99854.175', '2', '1', '1', '736283369150615552');
INSERT INTO `charge_record` VALUES ('134', '1505881141000', '23.1', '193.1', '216.2', '2', '55', '1', '736322784392646656');
INSERT INTO `charge_record` VALUES ('135', '1505881141000', '23.1', '-99854.175', '-99831.075', '2', '1', '1', '736322784392646656');
INSERT INTO `charge_record` VALUES ('136', '1505871743000', '9.9', '169.96', '179.86', '2', '2', '1', '736283369150615552');
INSERT INTO `charge_record` VALUES ('137', '1505871743000', '9.9', '-99831.075', '-99821.175', '2', '1', '1', '736283369150615552');
INSERT INTO `charge_record` VALUES ('138', '1505881141000', '23.1', '216.2', '239.3', '2', '55', '1', '736322784392646656');
INSERT INTO `charge_record` VALUES ('139', '1505881141000', '23.1', '-99821.175', '-99798.075', '2', '1', '1', '736322784392646656');
INSERT INTO `charge_record` VALUES ('140', '1505881141000', '23.1', '239.3', '262.4', '2', '55', '1', '736322784392646656');
INSERT INTO `charge_record` VALUES ('141', '1505881141000', '23.1', '-99798.075', '-99774.975', '2', '1', '1', '736322784392646656');
INSERT INTO `charge_record` VALUES ('142', '1505871743000', '9.9', '179.86', '189.76', '2', '2', '1', '736283369150615552');
INSERT INTO `charge_record` VALUES ('143', '1505871743000', '9.9', '-99774.975', '-99765.075', '2', '1', '1', '736283369150615552');
INSERT INTO `charge_record` VALUES ('144', '1505871743000', '9.9', '189.76', '199.66', '2', '2', '1', '736283369150615552');
INSERT INTO `charge_record` VALUES ('145', '1505871743000', '9.9', '-99765.075', '-99755.175', '2', '1', '1', '736283369150615552');
INSERT INTO `charge_record` VALUES ('146', '1505881141000', '23.1', '262.4', '285.5', '2', '55', '1', '736322784392646656');
INSERT INTO `charge_record` VALUES ('147', '1505881141000', '23.1', '-99755.175', '-99732.075', '2', '1', '1', '736322784392646656');
INSERT INTO `charge_record` VALUES ('148', '1505871743000', '9.9', '199.66', '209.56', '2', '2', '1', '736283369150615552');
INSERT INTO `charge_record` VALUES ('149', '1505871743000', '9.9', '-99732.075', '-99722.175', '2', '1', '1', '736283369150615552');
INSERT INTO `charge_record` VALUES ('150', '1505908426848', '3.1', '10', '6.9', '1', '39', '1', '736437229278203904');
INSERT INTO `charge_record` VALUES ('151', '1505908426871', '3.1', '-99719.075', '-99722.175', '1', '1', '1', '736437229278203904');
INSERT INTO `charge_record` VALUES ('152', '1505911567970', '15.5', '984.5', '969', '1', '7', '1', '736450404098772992');
INSERT INTO `charge_record` VALUES ('153', '1505911567995', '15.5', '-99706.675', '-99722.175', '1', '1', '1', '736450404098772992');
INSERT INTO `charge_record` VALUES ('154', '1505911634341', '-278.6', '-99722.175', '-99443.575', '1', '1', '1', null);
INSERT INTO `charge_record` VALUES ('155', '1505911634347', '-278.6', '285.5', '6.9', '0', '55', '1', null);
INSERT INTO `charge_record` VALUES ('156', '1505915109860', '21.7', '969', '947.3', '1', '7', '1', '736465259857973248');
INSERT INTO `charge_record` VALUES ('157', '1505915109892', '21.7', '-99421.875', '-99443.575', '1', '1', '1', '736465259857973248');
INSERT INTO `charge_record` VALUES ('158', '1505915231302', '21.7', '947.3', '925.6', '1', '7', '1', '736465769222639616');
INSERT INTO `charge_record` VALUES ('159', '1505915231319', '21.7', '-99421.875', '-99443.575', '1', '1', '1', '736465769222639616');
INSERT INTO `charge_record` VALUES ('160', '1505916553986', '40.3', '925.6', '885.3', '1', '7', '1', '736471316961431552');
INSERT INTO `charge_record` VALUES ('161', '1505916554007', '40.3', '-99403.275', '-99443.575', '1', '1', '1', '736471316961431552');
INSERT INTO `charge_record` VALUES ('162', '1505917385043', '31', '885.3', '854.3', '1', '7', '1', '736474802667130880');
INSERT INTO `charge_record` VALUES ('163', '1505917385059', '31', '-99412.575', '-99443.575', '1', '1', '1', '736474802667130880');
INSERT INTO `charge_record` VALUES ('164', '1505919340819', '100', '209.56', '109.56', '1', '2', '1', null);
INSERT INTO `charge_record` VALUES ('165', '1505919340826', '100', '0', '100', '0', '3', '1', null);
INSERT INTO `charge_record` VALUES ('166', '1505919376239', '1.74', '100', '98.26', '1', '3', '1', '736483154348478464');
INSERT INTO `charge_record` VALUES ('167', '1505919376253', '1.71', '111.3', '109.59', '1', '2', '1', '736483154348478464');
INSERT INTO `charge_record` VALUES ('168', '1505919376256', '1.38', '-99441.865', '-99443.245', '1', '1', '1', '736483154348478464');
INSERT INTO `charge_record` VALUES ('169', '1505964742160', '15.5', '854.3', '838.8', '1', '7', '1', '736673432812392448');
INSERT INTO `charge_record` VALUES ('170', '1505964742172', '15.5', '-99427.745', '-99443.245', '1', '1', '1', '736673432812392448');
INSERT INTO `charge_record` VALUES ('171', '1505973345790', '40.3', '838.8', '798.5', '1', '7', '1', '736709519052115968');
INSERT INTO `charge_record` VALUES ('172', '1505973345819', '40.3', '-99402.945', '-99443.245', '1', '1', '1', '736709519052115968');
INSERT INTO `charge_record` VALUES ('173', '1505986767916', '50', '-99443.245', '-99493.245', '1', '1', '1', null);
INSERT INTO `charge_record` VALUES ('174', '1505986767925', '50', '0', '50', '0', '26', '1', null);
INSERT INTO `charge_record` VALUES ('175', '1505986828906', '21.7', '50', '28.3', '1', '26', '1', '736766071347875840');
INSERT INTO `charge_record` VALUES ('176', '1505986828948', '21.7', '-99471.545', '-99493.245', '1', '1', '1', '736766071347875840');
INSERT INTO `charge_record` VALUES ('182', '1506411936189', '1.71', '109.59', '107.88', '1', '2', '1', '738549100521197568');
INSERT INTO `charge_record` VALUES ('183', '1506411942429', '1.38', '-99491.535', '-99492.915', '1', '1', '1', '738549100521197568');
INSERT INTO `charge_record` VALUES ('184', '1506415695472', '1.71', '107.88', '106.17', '1', '2', '1', '738564868096921600');
INSERT INTO `charge_record` VALUES ('185', '1506415702802', '1.38', '-99491.205', '-99492.585', '1', '1', '1', '738564868096921600');
INSERT INTO `charge_record` VALUES ('186', '1506416067229', '1.71', '106.17', '104.46', '1', '2', '1', '738566427362988032');
INSERT INTO `charge_record` VALUES ('187', '1506416073432', '1.38', '-99490.875', '-99492.255', '1', '1', '1', '738566427362988032');
INSERT INTO `charge_record` VALUES ('188', '1505919376000', '1.74', '98.26', '100', '2', '3', '1', '736483154348478464');
INSERT INTO `charge_record` VALUES ('189', '1505919376000', '1.71', '104.46', '106.17', '2', '2', '1', '736483154348478464');
INSERT INTO `charge_record` VALUES ('190', '1505919376000', '1.38', '-99492.255', '-99490.875', '2', '1', '1', '736483154348478464');
INSERT INTO `charge_record` VALUES ('191', '1505871743000', '9.9', '106.17', '116.07', '2', '2', '1', '736283369150615552');
INSERT INTO `charge_record` VALUES ('192', '1505871743000', '9.9', '-99490.875', '-99480.975', '2', '1', '1', '736283369150615552');
INSERT INTO `charge_record` VALUES ('193', '1506474943889', '1.71', '104.46', '102.75', '1', '2', '1', '738813373969338368');
INSERT INTO `charge_record` VALUES ('194', '1506474955926', '1.38', '-99479.265', '-99480.645', '1', '1', '1', '738813373969338368');
INSERT INTO `charge_record` VALUES ('195', '1506475379158', '1.74', '100', '98.26', '1', '3', '1', '738815199615651840');
INSERT INTO `charge_record` VALUES ('196', '1506475383680', '1.71', '104.49', '102.78', '1', '2', '1', '738815199615651840');
INSERT INTO `charge_record` VALUES ('197', '1506475383690', '1.38', '-99478.935', '-99480.315', '1', '1', '1', '738815199615651840');
INSERT INTO `charge_record` VALUES ('198', '1506475651786', '1.74', '98.26', '96.52', '1', '3', '1', '738816343100362752');
INSERT INTO `charge_record` VALUES ('199', '1506475693816', '1.71', '104.52', '102.81', '1', '2', '1', '738816343100362752');
INSERT INTO `charge_record` VALUES ('200', '1506475745949', '1.38', '-99478.605', '-99479.985', '1', '1', '1', '738816343100362752');
INSERT INTO `charge_record` VALUES ('201', '1506476029645', '1.74', '96.52', '94.78', '1', '3', '1', '738817927960072192');
INSERT INTO `charge_record` VALUES ('202', '1506476033426', '1.71', '104.55', '102.84', '1', '2', '1', '738817927960072192');
INSERT INTO `charge_record` VALUES ('203', '1506476033433', '1.38', '-99478.275', '-99479.655', '1', '1', '1', '738817927960072192');
INSERT INTO `charge_record` VALUES ('204', '1506477316811', '1.74', '94.78', '93.04', '1', '3', '1', '738823326721380352');
INSERT INTO `charge_record` VALUES ('205', '1506477326993', '1.71', '104.58', '102.87', '1', '2', '1', '738823326721380352');
INSERT INTO `charge_record` VALUES ('206', '1506477368691', '1.38', '-99477.945', '-99479.325', '1', '1', '1', '738823326721380352');
INSERT INTO `charge_record` VALUES ('207', '1506477628393', '1.74', '93.04', '91.3', '1', '3', '1', '738824633628758016');
INSERT INTO `charge_record` VALUES ('208', '1506477647865', '1.71', '104.61', '102.9', '1', '2', '1', '738824633628758016');
INSERT INTO `charge_record` VALUES ('209', '1506477670404', '1.38', '-99477.615', '-99478.995', '1', '1', '1', '738824633628758016');
INSERT INTO `charge_record` VALUES ('210', '1506478323800', '1.74', '91.3', '89.56', '1', '3', '1', '738827550343565312');
INSERT INTO `charge_record` VALUES ('211', '1506478335804', '1.71', '104.64', '102.93', '1', '2', '1', '738827550343565312');
INSERT INTO `charge_record` VALUES ('212', '1506478361340', '1.38', '-99477.285', '-99478.665', '1', '1', '1', '738827550343565312');
INSERT INTO `charge_record` VALUES ('213', '1506478914751', '1.71', '102.93', '101.22', '1', '2', '1', '738830028967514112');
INSERT INTO `charge_record` VALUES ('214', '1506478920810', '1.38', '-99476.955', '-99478.335', '1', '1', '1', '738830028967514112');
INSERT INTO `charge_record` VALUES ('215', '1506479006156', '2.93', '0', '-2.93', '1', '60', '1', null);
INSERT INTO `charge_record` VALUES ('216', '1506479006160', '2.93', '-2.93', '0', '0', '60', '1', null);
INSERT INTO `charge_record` VALUES ('217', '1506482459290', '3.78', '-99478.335', '-99482.115', '1', '1', '1', null);
INSERT INTO `charge_record` VALUES ('218', '1506482459308', '3.78', '101.22', '105', '0', '2', '1', null);
INSERT INTO `charge_record` VALUES ('219', '1507452069852', '1.71', '105', '103.29', '1', '2', '1', '742911737304453120');
INSERT INTO `charge_record` VALUES ('220', '1507452079471', '1.38', '-99480.405', '-99481.785', '1', '1', '1', '742911737304453120');
INSERT INTO `charge_record` VALUES ('221', '1507452496876', '1.71', '103.29', '101.58', '1', '2', '1', '742913528372924416');
INSERT INTO `charge_record` VALUES ('222', '1507452503419', '1.38', '-99480.075', '-99481.455', '1', '1', '1', '742913528372924416');
INSERT INTO `charge_record` VALUES ('223', '1507512593003', '1', '-99481.455', '-99482.455', '1', '1', '1', null);
INSERT INTO `charge_record` VALUES ('224', '1507512593056', '1', '0', '1', '0', '61', '1', null);
INSERT INTO `charge_record` VALUES ('225', '1507866489593', '300', '600', '900', '0', '54', '1', null);
INSERT INTO `charge_record` VALUES ('226', '1507869326202', '100', '-99482.455', '-99582.455', '1', '1', '1', null);
INSERT INTO `charge_record` VALUES ('227', '1507869326230', '100', '101.58', '201.58', '0', '2', '1', null);
INSERT INTO `charge_record` VALUES ('228', '1507873193200', '100', '-99582.455', '-99682.455', '1', '1', '1', null);
INSERT INTO `charge_record` VALUES ('229', '1507873193215', '100', '201.58', '301.58', '0', '2', '1', null);
INSERT INTO `charge_record` VALUES ('230', '1507873809542', '100', '-99682.455', '-99782.455', '1', '1', '1', null);
INSERT INTO `charge_record` VALUES ('231', '1507873809551', '100', '301.58', '401.58', '0', '2', '1', null);

-- ----------------------------
-- Table structure for `cnel_bind_pg`
-- ----------------------------
DROP TABLE IF EXISTS `cnel_bind_pg`;
CREATE TABLE `cnel_bind_pg` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '绑定id',
  `channel_id` bigint(20) DEFAULT NULL,
  `pg_id` int(11) DEFAULT NULL,
  `channel_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '通道名称',
  `pg_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '包体名称',
  PRIMARY KEY (`id`),
  KEY `cbp_fk_cnel` (`channel_id`),
  KEY `cbp_fk_pg` (`pg_id`),
  CONSTRAINT `cbp_fk_cnel` FOREIGN KEY (`channel_id`) REFERENCES `channel_channel` (`id`) ON DELETE CASCADE,
  CONSTRAINT `cbp_fk_pg` FOREIGN KEY (`pg_id`) REFERENCES `operator_pg_data` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=440 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of cnel_bind_pg
-- ----------------------------
INSERT INTO `cnel_bind_pg` VALUES ('74', '22', '41', '省漫游-微族 浙江移动', '3元10M');
INSERT INTO `cnel_bind_pg` VALUES ('75', '22', '43', '省漫游-微族 浙江移动', '5元30M');
INSERT INTO `cnel_bind_pg` VALUES ('76', '22', '44', '省漫游-微族 浙江移动', '10元70');
INSERT INTO `cnel_bind_pg` VALUES ('77', '22', '45', '省漫游-微族 浙江移动', '10元100M');
INSERT INTO `cnel_bind_pg` VALUES ('78', '22', '46', '省漫游-微族 浙江移动', '20元150M');
INSERT INTO `cnel_bind_pg` VALUES ('79', '22', '47', '省漫游-微族 浙江移动', '20元300');
INSERT INTO `cnel_bind_pg` VALUES ('80', '22', '48', '省漫游-微族 浙江移动', '30元500M');
INSERT INTO `cnel_bind_pg` VALUES ('81', '22', '49', '省漫游-微族 浙江移动', '50元1G');
INSERT INTO `cnel_bind_pg` VALUES ('82', '22', '50', '省漫游-微族 浙江移动', '70元2G');
INSERT INTO `cnel_bind_pg` VALUES ('83', '22', '51', '省漫游-微族 浙江移动', '100元3G');
INSERT INTO `cnel_bind_pg` VALUES ('84', '22', '52', '省漫游-微族 浙江移动', '130元4G');
INSERT INTO `cnel_bind_pg` VALUES ('85', '22', '53', '省漫游-微族 浙江移动', '180元6G');
INSERT INTO `cnel_bind_pg` VALUES ('86', '22', '54', '省漫游-微族 浙江移动', '280元11G');
INSERT INTO `cnel_bind_pg` VALUES ('172', '30', '66', '省内-微族-宁夏本地', '3元10M省内');
INSERT INTO `cnel_bind_pg` VALUES ('173', '30', '67', '省内-微族-宁夏本地', '5元30M省内');
INSERT INTO `cnel_bind_pg` VALUES ('174', '30', '68', '省内-微族-宁夏本地', '10元70M省内');
INSERT INTO `cnel_bind_pg` VALUES ('175', '30', '69', '省内-微族-宁夏本地', '20元150M省内');
INSERT INTO `cnel_bind_pg` VALUES ('176', '30', '70', '省内-微族-宁夏本地', '30元500M省内');
INSERT INTO `cnel_bind_pg` VALUES ('177', '30', '71', '省内-微族-宁夏本地', '50元1G省内');
INSERT INTO `cnel_bind_pg` VALUES ('178', '30', '72', '省内-微族-宁夏本地', '70元2G省内');
INSERT INTO `cnel_bind_pg` VALUES ('179', '30', '73', '省内-微族-宁夏本地', '100元3G省内');
INSERT INTO `cnel_bind_pg` VALUES ('180', '30', '74', '省内-微族-宁夏本地', '130元4G省内');
INSERT INTO `cnel_bind_pg` VALUES ('181', '30', '75', '省内-微族-宁夏本地', '180元6G省内');
INSERT INTO `cnel_bind_pg` VALUES ('182', '30', '76', '省内-微族-宁夏本地', '280元11G省内');
INSERT INTO `cnel_bind_pg` VALUES ('269', '46', '41', '省漫游-微族-陕西移动', '3元10M');
INSERT INTO `cnel_bind_pg` VALUES ('270', '46', '43', '省漫游-微族-陕西移动', '5元30M');
INSERT INTO `cnel_bind_pg` VALUES ('271', '46', '44', '省漫游-微族-陕西移动', '10元70');
INSERT INTO `cnel_bind_pg` VALUES ('272', '46', '45', '省漫游-微族-陕西移动', '10元100M');
INSERT INTO `cnel_bind_pg` VALUES ('273', '46', '46', '省漫游-微族-陕西移动', '20元150M');
INSERT INTO `cnel_bind_pg` VALUES ('274', '46', '47', '省漫游-微族-陕西移动', '20元300');
INSERT INTO `cnel_bind_pg` VALUES ('275', '46', '48', '省漫游-微族-陕西移动', '30元500M');
INSERT INTO `cnel_bind_pg` VALUES ('276', '46', '49', '省漫游-微族-陕西移动', '50元1G');
INSERT INTO `cnel_bind_pg` VALUES ('277', '46', '50', '省漫游-微族-陕西移动', '70元2G');
INSERT INTO `cnel_bind_pg` VALUES ('278', '46', '51', '省漫游-微族-陕西移动', '100元3G');
INSERT INTO `cnel_bind_pg` VALUES ('279', '46', '52', '省漫游-微族-陕西移动', '130元4G');
INSERT INTO `cnel_bind_pg` VALUES ('280', '46', '53', '省漫游-微族-陕西移动', '180元6G');
INSERT INTO `cnel_bind_pg` VALUES ('281', '46', '54', '省漫游-微族-陕西移动', '280元11G');
INSERT INTO `cnel_bind_pg` VALUES ('282', '47', '41', '省漫游-微族-黑龙江移动', '3元10M');
INSERT INTO `cnel_bind_pg` VALUES ('283', '47', '43', '省漫游-微族-黑龙江移动', '5元30M');
INSERT INTO `cnel_bind_pg` VALUES ('284', '47', '44', '省漫游-微族-黑龙江移动', '10元70');
INSERT INTO `cnel_bind_pg` VALUES ('285', '47', '45', '省漫游-微族-黑龙江移动', '10元100M');
INSERT INTO `cnel_bind_pg` VALUES ('286', '47', '46', '省漫游-微族-黑龙江移动', '20元150M');
INSERT INTO `cnel_bind_pg` VALUES ('287', '47', '47', '省漫游-微族-黑龙江移动', '20元300');
INSERT INTO `cnel_bind_pg` VALUES ('288', '47', '48', '省漫游-微族-黑龙江移动', '30元500M');
INSERT INTO `cnel_bind_pg` VALUES ('289', '47', '49', '省漫游-微族-黑龙江移动', '50元1G');
INSERT INTO `cnel_bind_pg` VALUES ('290', '47', '50', '省漫游-微族-黑龙江移动', '70元2G');
INSERT INTO `cnel_bind_pg` VALUES ('291', '47', '51', '省漫游-微族-黑龙江移动', '100元3G');
INSERT INTO `cnel_bind_pg` VALUES ('292', '47', '52', '省漫游-微族-黑龙江移动', '130元4G');
INSERT INTO `cnel_bind_pg` VALUES ('293', '47', '53', '省漫游-微族-黑龙江移动', '180元6G');
INSERT INTO `cnel_bind_pg` VALUES ('294', '47', '54', '省漫游-微族-黑龙江移动', '280元11G');
INSERT INTO `cnel_bind_pg` VALUES ('295', '48', '47', '省漫游-微族-广东特殊包', '20元300');
INSERT INTO `cnel_bind_pg` VALUES ('296', '49', '41', '省漫游-微族-内蒙古移动', '3元10M');
INSERT INTO `cnel_bind_pg` VALUES ('297', '49', '43', '省漫游-微族-内蒙古移动', '5元30M');
INSERT INTO `cnel_bind_pg` VALUES ('298', '49', '44', '省漫游-微族-内蒙古移动', '10元70');
INSERT INTO `cnel_bind_pg` VALUES ('299', '49', '45', '省漫游-微族-内蒙古移动', '10元100M');
INSERT INTO `cnel_bind_pg` VALUES ('300', '49', '46', '省漫游-微族-内蒙古移动', '20元150M');
INSERT INTO `cnel_bind_pg` VALUES ('301', '49', '47', '省漫游-微族-内蒙古移动', '20元300');
INSERT INTO `cnel_bind_pg` VALUES ('302', '49', '48', '省漫游-微族-内蒙古移动', '30元500M');
INSERT INTO `cnel_bind_pg` VALUES ('303', '49', '49', '省漫游-微族-内蒙古移动', '50元1G');
INSERT INTO `cnel_bind_pg` VALUES ('304', '49', '50', '省漫游-微族-内蒙古移动', '70元2G');
INSERT INTO `cnel_bind_pg` VALUES ('305', '49', '51', '省漫游-微族-内蒙古移动', '100元3G');
INSERT INTO `cnel_bind_pg` VALUES ('306', '49', '52', '省漫游-微族-内蒙古移动', '130元4G');
INSERT INTO `cnel_bind_pg` VALUES ('307', '49', '53', '省漫游-微族-内蒙古移动', '180元6G');
INSERT INTO `cnel_bind_pg` VALUES ('308', '49', '54', '省漫游-微族-内蒙古移动', '280元11G');
INSERT INTO `cnel_bind_pg` VALUES ('320', '51', '41', '省漫游-微族-山东移动', '3元10M');
INSERT INTO `cnel_bind_pg` VALUES ('321', '51', '43', '省漫游-微族-山东移动', '5元30M');
INSERT INTO `cnel_bind_pg` VALUES ('322', '51', '44', '省漫游-微族-山东移动', '10元70');
INSERT INTO `cnel_bind_pg` VALUES ('323', '51', '45', '省漫游-微族-山东移动', '10元100M');
INSERT INTO `cnel_bind_pg` VALUES ('324', '51', '46', '省漫游-微族-山东移动', '20元150M');
INSERT INTO `cnel_bind_pg` VALUES ('325', '51', '47', '省漫游-微族-山东移动', '20元300');
INSERT INTO `cnel_bind_pg` VALUES ('326', '51', '48', '省漫游-微族-山东移动', '30元500M');
INSERT INTO `cnel_bind_pg` VALUES ('327', '51', '49', '省漫游-微族-山东移动', '50元1G');
INSERT INTO `cnel_bind_pg` VALUES ('328', '51', '50', '省漫游-微族-山东移动', '70元2G');
INSERT INTO `cnel_bind_pg` VALUES ('329', '51', '52', '省漫游-微族-山东移动', '130元4G');
INSERT INTO `cnel_bind_pg` VALUES ('330', '51', '51', '省漫游-微族-山东移动', '100元3G');
INSERT INTO `cnel_bind_pg` VALUES ('331', '51', '53', '省漫游-微族-山东移动', '180元6G');
INSERT INTO `cnel_bind_pg` VALUES ('332', '51', '54', '省漫游-微族-山东移动', '280元11G');
INSERT INTO `cnel_bind_pg` VALUES ('333', '52', '41', '省漫游-微族-浙江移动', '3元10M');
INSERT INTO `cnel_bind_pg` VALUES ('334', '52', '43', '省漫游-微族-浙江移动', '5元30M');
INSERT INTO `cnel_bind_pg` VALUES ('335', '52', '44', '省漫游-微族-浙江移动', '10元70');
INSERT INTO `cnel_bind_pg` VALUES ('336', '52', '45', '省漫游-微族-浙江移动', '10元100M');
INSERT INTO `cnel_bind_pg` VALUES ('337', '52', '46', '省漫游-微族-浙江移动', '20元150M');
INSERT INTO `cnel_bind_pg` VALUES ('338', '52', '47', '省漫游-微族-浙江移动', '20元300');
INSERT INTO `cnel_bind_pg` VALUES ('339', '52', '48', '省漫游-微族-浙江移动', '30元500M');
INSERT INTO `cnel_bind_pg` VALUES ('340', '52', '49', '省漫游-微族-浙江移动', '50元1G');
INSERT INTO `cnel_bind_pg` VALUES ('341', '52', '50', '省漫游-微族-浙江移动', '70元2G');
INSERT INTO `cnel_bind_pg` VALUES ('342', '52', '51', '省漫游-微族-浙江移动', '100元3G');
INSERT INTO `cnel_bind_pg` VALUES ('343', '52', '52', '省漫游-微族-浙江移动', '130元4G');
INSERT INTO `cnel_bind_pg` VALUES ('344', '52', '53', '省漫游-微族-浙江移动', '180元6G');
INSERT INTO `cnel_bind_pg` VALUES ('345', '52', '54', '省漫游-微族-浙江移动', '280元11G');
INSERT INTO `cnel_bind_pg` VALUES ('346', '53', '41', '省漫游-微族-山西移动', '3元10M');
INSERT INTO `cnel_bind_pg` VALUES ('347', '53', '43', '省漫游-微族-山西移动', '5元30M');
INSERT INTO `cnel_bind_pg` VALUES ('348', '53', '44', '省漫游-微族-山西移动', '10元70');
INSERT INTO `cnel_bind_pg` VALUES ('349', '53', '45', '省漫游-微族-山西移动', '10元100M');
INSERT INTO `cnel_bind_pg` VALUES ('350', '53', '46', '省漫游-微族-山西移动', '20元150M');
INSERT INTO `cnel_bind_pg` VALUES ('351', '53', '47', '省漫游-微族-山西移动', '20元300');
INSERT INTO `cnel_bind_pg` VALUES ('352', '53', '48', '省漫游-微族-山西移动', '30元500M');
INSERT INTO `cnel_bind_pg` VALUES ('353', '53', '49', '省漫游-微族-山西移动', '50元1G');
INSERT INTO `cnel_bind_pg` VALUES ('354', '53', '50', '省漫游-微族-山西移动', '70元2G');
INSERT INTO `cnel_bind_pg` VALUES ('355', '53', '51', '省漫游-微族-山西移动', '100元3G');
INSERT INTO `cnel_bind_pg` VALUES ('356', '53', '52', '省漫游-微族-山西移动', '130元4G');
INSERT INTO `cnel_bind_pg` VALUES ('357', '53', '53', '省漫游-微族-山西移动', '180元6G');
INSERT INTO `cnel_bind_pg` VALUES ('358', '53', '54', '省漫游-微族-山西移动', '280元11G');
INSERT INTO `cnel_bind_pg` VALUES ('359', '56', '41', '省漫游-微族-安徽移动', '3元10M');
INSERT INTO `cnel_bind_pg` VALUES ('360', '56', '43', '省漫游-微族-安徽移动', '5元30M');
INSERT INTO `cnel_bind_pg` VALUES ('361', '56', '44', '省漫游-微族-安徽移动', '10元70');
INSERT INTO `cnel_bind_pg` VALUES ('362', '56', '45', '省漫游-微族-安徽移动', '10元100M');
INSERT INTO `cnel_bind_pg` VALUES ('363', '56', '46', '省漫游-微族-安徽移动', '20元150M');
INSERT INTO `cnel_bind_pg` VALUES ('364', '56', '47', '省漫游-微族-安徽移动', '20元300');
INSERT INTO `cnel_bind_pg` VALUES ('365', '56', '48', '省漫游-微族-安徽移动', '30元500M');
INSERT INTO `cnel_bind_pg` VALUES ('366', '56', '49', '省漫游-微族-安徽移动', '50元1G');
INSERT INTO `cnel_bind_pg` VALUES ('367', '56', '50', '省漫游-微族-安徽移动', '70元2G');
INSERT INTO `cnel_bind_pg` VALUES ('368', '57', '41', '省漫游-微族-湖南移动', '3元10M');
INSERT INTO `cnel_bind_pg` VALUES ('369', '57', '43', '省漫游-微族-湖南移动', '5元30M');
INSERT INTO `cnel_bind_pg` VALUES ('370', '57', '44', '省漫游-微族-湖南移动', '10元70');
INSERT INTO `cnel_bind_pg` VALUES ('371', '57', '45', '省漫游-微族-湖南移动', '10元100M');
INSERT INTO `cnel_bind_pg` VALUES ('372', '57', '46', '省漫游-微族-湖南移动', '20元150M');
INSERT INTO `cnel_bind_pg` VALUES ('373', '57', '47', '省漫游-微族-湖南移动', '20元300');
INSERT INTO `cnel_bind_pg` VALUES ('374', '57', '48', '省漫游-微族-湖南移动', '30元500M');
INSERT INTO `cnel_bind_pg` VALUES ('375', '57', '49', '省漫游-微族-湖南移动', '50元1G');
INSERT INTO `cnel_bind_pg` VALUES ('376', '57', '50', '省漫游-微族-湖南移动', '70元2G');
INSERT INTO `cnel_bind_pg` VALUES ('377', '57', '51', '省漫游-微族-湖南移动', '100元3G');
INSERT INTO `cnel_bind_pg` VALUES ('378', '57', '52', '省漫游-微族-湖南移动', '130元4G');
INSERT INTO `cnel_bind_pg` VALUES ('379', '57', '53', '省漫游-微族-湖南移动', '180元6G');
INSERT INTO `cnel_bind_pg` VALUES ('380', '57', '54', '省漫游-微族-湖南移动', '280元11G');
INSERT INTO `cnel_bind_pg` VALUES ('417', '61', '70', '省内-微族-陕西本地移动', '30元500M省内');
INSERT INTO `cnel_bind_pg` VALUES ('418', '61', '71', '省内-微族-陕西本地移动', '50元1G省内');
INSERT INTO `cnel_bind_pg` VALUES ('419', '61', '72', '省内-微族-陕西本地移动', '70元2G省内');
INSERT INTO `cnel_bind_pg` VALUES ('420', '61', '73', '省内-微族-陕西本地移动', '100元3G省内');
INSERT INTO `cnel_bind_pg` VALUES ('421', '61', '74', '省内-微族-陕西本地移动', '130元4G省内');
INSERT INTO `cnel_bind_pg` VALUES ('422', '61', '75', '省内-微族-陕西本地移动', '180元6G省内');
INSERT INTO `cnel_bind_pg` VALUES ('423', '61', '76', '省内-微族-陕西本地移动', '280元11G省内');
INSERT INTO `cnel_bind_pg` VALUES ('424', '61', '78', '省内-微族-陕西本地移动', '10元100M省内');
INSERT INTO `cnel_bind_pg` VALUES ('425', '61', '79', '省内-微族-陕西本地移动', '20元300M省内');
INSERT INTO `cnel_bind_pg` VALUES ('426', '62', '66', '微族-陕西本地移动-带', '3元10M省内');
INSERT INTO `cnel_bind_pg` VALUES ('427', '62', '67', '微族-陕西本地移动-带', '5元30M省内');
INSERT INTO `cnel_bind_pg` VALUES ('428', '62', '68', '微族-陕西本地移动-带', '10元70M省内');
INSERT INTO `cnel_bind_pg` VALUES ('429', '62', '69', '微族-陕西本地移动-带', '20元150M省内');
INSERT INTO `cnel_bind_pg` VALUES ('430', '63', '41', '微族-宁夏移动-省漫游-带', '3元10M');
INSERT INTO `cnel_bind_pg` VALUES ('431', '63', '43', '微族-宁夏移动-省漫游-带', '5元30M');
INSERT INTO `cnel_bind_pg` VALUES ('432', '63', '44', '微族-宁夏移动-省漫游-带', '10元70');
INSERT INTO `cnel_bind_pg` VALUES ('433', '63', '45', '微族-宁夏移动-省漫游-带', '10元100M');
INSERT INTO `cnel_bind_pg` VALUES ('434', '63', '46', '微族-宁夏移动-省漫游-带', '20元150M');
INSERT INTO `cnel_bind_pg` VALUES ('435', '63', '47', '微族-宁夏移动-省漫游-带', '20元300');
INSERT INTO `cnel_bind_pg` VALUES ('436', '63', '48', '微族-宁夏移动-省漫游-带', '30元500M');
INSERT INTO `cnel_bind_pg` VALUES ('437', '63', '49', '微族-宁夏移动-省漫游-带', '50元1G');
INSERT INTO `cnel_bind_pg` VALUES ('438', '63', '50', '微族-宁夏移动-省漫游-带', '70元2G');
INSERT INTO `cnel_bind_pg` VALUES ('439', '63', '51', '微族-宁夏移动-省漫游-带', '100元3G');

-- ----------------------------
-- Table structure for `company_credentials`
-- ----------------------------
DROP TABLE IF EXISTS `company_credentials`;
CREATE TABLE `company_credentials` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '验证id',
  `agency_id` int(11) DEFAULT NULL COMMENT '待验证代理商id',
  `agency_name` varchar(255) DEFAULT NULL COMMENT '代理商名称',
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company_credentials
-- ----------------------------
INSERT INTO `company_credentials` VALUES ('1', '2', null, '1', '1', null, null, null, null, '5453454534', '1', '南昌微族科技有限公司', '江西省南昌市', '何兵 17707005023', '中国银行', '360111199605236014', '4sad5sa45d453', '信息服务费', null, '54353453453', '53453453', '54353453', null, null, null, null, '1505478089907', '1505874476912');
INSERT INTO `company_credentials` VALUES ('2', '14', null, '1', '0', null, null, null, null, '', null, '', '', '', '', '', '', '信息服务费', null, '', '', '', null, null, null, null, '1505828215431', '1505891023608');

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
  `ep_order_state_ip` varchar(255) DEFAULT NULL COMMENT '订单查询地址',
  `ep_call_back_ip` varchar(255) DEFAULT NULL COMMENT '回调地址',
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
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exchange_platform
-- ----------------------------
INSERT INTO `exchange_platform` VALUES ('32', '河南硕郎', 'Weizu', 'http://139.224.70.161:32001/api/v1/sendOrder', 'http://139.224.70.161:32001/api/v1/sendOrder', 'http://139.224.70.161:32001/api/v1/orderState', 'http://120.55.162.224:8082/flowsys/callBack/weizu', 'http://139.224.70.161:32001/api/v1/getBalance', 'CS111111', '123456', null, '722c16de0a83e5bd2f988e3c7bc9fee8', 'http://139.224.70.161/', '', '0', '1508204585221');
INSERT INTO `exchange_platform` VALUES ('42', '行云流水', 'Lljypt', 'http://api.lljypt.com/capi/trade.charge', 'http://api.lljypt.com/capi/trade.charge', 'http://api.lljypt.com/capi/query.order', null, 'http://api.lljypt.com/capi/query.balance', 'cncwz', '249636', '0', 'KKIGoAFUTxoIFfC', 'http://customer.lljypt.com/a', 'merchant=10210&clientId=10000&version=V100&', '1', '1505470884956');
INSERT INTO `exchange_platform` VALUES ('43', '行云对私', 'Lljypt0', 'http://api.lljypt.com/capi/trade.charge', 'http://api.lljypt.com/capi/trade.charge', 'http://api.lljypt.com/capi/query.order', null, 'http://api.lljypt.com/capi/query.balance', 'cncwz', '249636', '0', 'AoYIuPLXMmpTwTw', 'http://customer.lljypt.com/a', 'merchant=10304&clientId=10000&version=V100& ', '1', '1504000740478');
INSERT INTO `exchange_platform` VALUES ('44', 'wzkj0', 'Wzkj0', 'wzkj0', 'wzkj0', 'wzkj0', null, 'wzkj0', '123', '123', null, '123', '123', null, '1', '1505109915512');

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
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of operator_pg_data
-- ----------------------------
INSERT INTO `operator_pg_data` VALUES ('41', '10', '3', '3元10M', '1', '0', '中国移动', '2');
INSERT INTO `operator_pg_data` VALUES ('43', '30', '5', '5元30M', '1', '0', '中国移动', '2');
INSERT INTO `operator_pg_data` VALUES ('44', '70', '10', '10元70', '1', '0', '中国移动', '2');
INSERT INTO `operator_pg_data` VALUES ('45', '100', '10', '10元100M', '1', '0', '中国移动', '2');
INSERT INTO `operator_pg_data` VALUES ('46', '150', '20', '20元150M', '1', '0', '中国移动', '2');
INSERT INTO `operator_pg_data` VALUES ('47', '300', '20', '20元300', '1', '0', '中国移动', '2');
INSERT INTO `operator_pg_data` VALUES ('48', '500', '30', '30元500M', '1', '0', '中国移动', '2');
INSERT INTO `operator_pg_data` VALUES ('49', '1024', '50', '50元1G', '1', '0', '中国移动', '2');
INSERT INTO `operator_pg_data` VALUES ('50', '2048', '70', '70元2G', '1', '0', '中国移动', '2');
INSERT INTO `operator_pg_data` VALUES ('51', '3072', '100', '100元3G', '1', '0', '中国移动', '2');
INSERT INTO `operator_pg_data` VALUES ('52', '4096', '130', '130元4G', '1', '0', '中国移动', '2');
INSERT INTO `operator_pg_data` VALUES ('53', '6144', '180', '180元6G', '1', '0', '中国移动', '2');
INSERT INTO `operator_pg_data` VALUES ('54', '11264', '280', '280元11G', '1', '0', '中国移动', '2');
INSERT INTO `operator_pg_data` VALUES ('66', '10', '3', '3元10M省内', '1', '0', '中国移动', '1');
INSERT INTO `operator_pg_data` VALUES ('67', '30', '5', '5元30M省内', '1', '0', '中国移动', '1');
INSERT INTO `operator_pg_data` VALUES ('68', '70', '10', '10元70M省内', '1', '0', '中国移动', '1');
INSERT INTO `operator_pg_data` VALUES ('69', '150', '20', '20元150M省内', '1', '0', '中国移动', '1');
INSERT INTO `operator_pg_data` VALUES ('70', '500', '30', '30元500M省内', '1', '0', '中国移动', '1');
INSERT INTO `operator_pg_data` VALUES ('71', '1024', '50', '50元1G省内', '1', '0', '中国移动', '1');
INSERT INTO `operator_pg_data` VALUES ('72', '2048', '70', '70元2G省内', '1', '0', '中国移动', '1');
INSERT INTO `operator_pg_data` VALUES ('73', '3072', '100', '100元3G省内', '1', '0', '中国移动', '1');
INSERT INTO `operator_pg_data` VALUES ('74', '4096', '130', '130元4G省内', '1', '0', '中国移动', '1');
INSERT INTO `operator_pg_data` VALUES ('75', '6144', '180', '180元6G省内', '1', '0', '中国移动', '1');
INSERT INTO `operator_pg_data` VALUES ('76', '11264', '280', '280元11G省内', '1', '0', '中国移动', '1');
INSERT INTO `operator_pg_data` VALUES ('78', '100', '10', '10元100M省内', '1', '0', '中国移动', '1');
INSERT INTO `operator_pg_data` VALUES ('79', '300', '20', '20元300M省内', '1', '0', '中国移动', '1');
INSERT INTO `operator_pg_data` VALUES ('80', '10', '3', '联通3.0元10MB省漫游', '1', '1', '中国联通', '2');
INSERT INTO `operator_pg_data` VALUES ('81', '655', '30', '联通30.0元655MB省内', '1', '1', '中国联通', '1');

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
  PRIMARY KEY (`id`),
  KEY `fk_ep_pc` (`ep_id`),
  CONSTRAINT `fk_ep_pc` FOREIGN KEY (`ep_id`) REFERENCES `exchange_platform` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=231 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_code
-- ----------------------------
INSERT INTO `product_code` VALUES ('1', '广东省', '22', '19', null, '32', 'gd11264');
INSERT INTO `product_code` VALUES ('2', '全国', '1', '32', null, '32', 'qg6144');
INSERT INTO `product_code` VALUES ('3', '全国', '1', '32', null, '44', 'qg6144');
INSERT INTO `product_code` VALUES ('10', '广东省', '41', '19', null, '32', '10');
INSERT INTO `product_code` VALUES ('11', '广东省', '43', '19', null, '32', '30');
INSERT INTO `product_code` VALUES ('12', '广东省', '44', '19', null, '32', '70');
INSERT INTO `product_code` VALUES ('14', '广东省', '45', '19', null, '32', '100');
INSERT INTO `product_code` VALUES ('15', '广东省', '46', '19', null, '32', '150');
INSERT INTO `product_code` VALUES ('16', '广东省', '47', '19', null, '32', '300');
INSERT INTO `product_code` VALUES ('17', '广东省', '48', '19', null, '32', '500');
INSERT INTO `product_code` VALUES ('18', '广东省', '49', '19', null, '32', '1024');
INSERT INTO `product_code` VALUES ('19', '广东省', '50', '19', null, '32', '2048');
INSERT INTO `product_code` VALUES ('20', '广东省', '51', '19', null, '32', '3072');
INSERT INTO `product_code` VALUES ('21', '广东省', '52', '19', null, '32', '4096');
INSERT INTO `product_code` VALUES ('22', '广东省', '53', '19', null, '32', '6144');
INSERT INTO `product_code` VALUES ('23', '广东省', '54', '19', null, '32', '11264');
INSERT INTO `product_code` VALUES ('36', '陕西省', '66', '26', null, '32', '10');
INSERT INTO `product_code` VALUES ('37', '陕西省', '67', '26', null, '32', '30');
INSERT INTO `product_code` VALUES ('38', '陕西省', '68', '26', null, '32', '70');
INSERT INTO `product_code` VALUES ('39', '陕西省', '69', '26', null, '32', '150');
INSERT INTO `product_code` VALUES ('40', '陕西省', '70', '26', null, '32', '500');
INSERT INTO `product_code` VALUES ('41', '陕西省', '71', '26', null, '32', '1024');
INSERT INTO `product_code` VALUES ('42', '陕西省', '72', '26', null, '32', '2048');
INSERT INTO `product_code` VALUES ('43', '陕西省', '73', '26', null, '32', '3072');
INSERT INTO `product_code` VALUES ('44', '陕西省', '74', '26', null, '32', '4096');
INSERT INTO `product_code` VALUES ('45', '陕西省', '75', '26', null, '32', '6144');
INSERT INTO `product_code` VALUES ('46', '陕西省', '76', '26', null, '32', '11264');
INSERT INTO `product_code` VALUES ('48', '宁夏回族自治区', '66', '29', null, '32', '10');
INSERT INTO `product_code` VALUES ('49', '宁夏回族自治区', '67', '29', null, '32', '30');
INSERT INTO `product_code` VALUES ('50', '宁夏回族自治区', '68', '29', null, '32', '70');
INSERT INTO `product_code` VALUES ('51', '宁夏回族自治区', '69', '29', null, '32', '150');
INSERT INTO `product_code` VALUES ('52', '宁夏回族自治区', '70', '29', null, '32', '500');
INSERT INTO `product_code` VALUES ('53', '宁夏回族自治区', '71', '29', null, '32', '1024');
INSERT INTO `product_code` VALUES ('54', '宁夏回族自治区', '72', '29', null, '32', '2048');
INSERT INTO `product_code` VALUES ('55', '宁夏回族自治区', '73', '29', null, '32', '3072');
INSERT INTO `product_code` VALUES ('56', '宁夏回族自治区', '74', '29', null, '32', '4096');
INSERT INTO `product_code` VALUES ('57', '宁夏回族自治区', '75', '29', null, '32', '6144');
INSERT INTO `product_code` VALUES ('58', '宁夏回族自治区', '76', '29', null, '32', '11264');
INSERT INTO `product_code` VALUES ('59', '山西省', '41', '04', null, '32', '10');
INSERT INTO `product_code` VALUES ('60', '山西省', '43', '04', null, '32', '30');
INSERT INTO `product_code` VALUES ('61', '山西省', '44', '04', null, '32', '70');
INSERT INTO `product_code` VALUES ('62', '山西省', '45', '04', null, '32', '100');
INSERT INTO `product_code` VALUES ('63', '山西省', '46', '04', null, '32', '150');
INSERT INTO `product_code` VALUES ('64', '山西省', '47', '04', null, '32', '300');
INSERT INTO `product_code` VALUES ('65', '山西省', '48', '04', null, '32', '500');
INSERT INTO `product_code` VALUES ('66', '山西省', '49', '04', null, '32', '1024');
INSERT INTO `product_code` VALUES ('67', '山西省', '50', '04', null, '32', '2048');
INSERT INTO `product_code` VALUES ('68', '山西省', '51', '04', null, '32', '3072');
INSERT INTO `product_code` VALUES ('69', '山西省', '52', '04', null, '32', '4096');
INSERT INTO `product_code` VALUES ('70', '山西省', '53', '04', null, '32', '6144');
INSERT INTO `product_code` VALUES ('71', '山西省', '54', '04', null, '32', '11264');
INSERT INTO `product_code` VALUES ('73', '陕西省', '78', '26', null, '32', '100');
INSERT INTO `product_code` VALUES ('74', '陕西省', '79', '26', null, '32', '300');
INSERT INTO `product_code` VALUES ('75', '山东省', '41', '15', null, '32', '3');
INSERT INTO `product_code` VALUES ('76', '河南省', '41', '16', null, '32', '10');
INSERT INTO `product_code` VALUES ('77', '河南省', '43', '16', null, '32', '30');
INSERT INTO `product_code` VALUES ('78', '河南省', '44', '16', null, '32', '70');
INSERT INTO `product_code` VALUES ('79', '河南省', '45', '16', null, '32', '100');
INSERT INTO `product_code` VALUES ('80', '河南省', '46', '16', null, '32', '150');
INSERT INTO `product_code` VALUES ('81', '河南省', '47', '16', null, '32', '300');
INSERT INTO `product_code` VALUES ('82', '河南省', '48', '16', null, '32', '500');
INSERT INTO `product_code` VALUES ('83', '河南省', '49', '16', null, '32', '1024');
INSERT INTO `product_code` VALUES ('84', '河南省', '50', '16', null, '32', '2048');
INSERT INTO `product_code` VALUES ('85', '河南省', '51', '16', null, '32', '3072');
INSERT INTO `product_code` VALUES ('86', '河南省', '52', '16', null, '32', '4096');
INSERT INTO `product_code` VALUES ('87', '河南省', '53', '16', null, '32', '6144');
INSERT INTO `product_code` VALUES ('88', '河南省', '54', '16', null, '32', '11264');
INSERT INTO `product_code` VALUES ('89', '浙江省', '41', '11', null, '32', '10');
INSERT INTO `product_code` VALUES ('90', '浙江省', '43', '11', null, '32', '30');
INSERT INTO `product_code` VALUES ('91', '浙江省', '44', '11', null, '32', '70');
INSERT INTO `product_code` VALUES ('92', '浙江省', '45', '11', null, '32', '100');
INSERT INTO `product_code` VALUES ('93', '浙江省', '46', '11', null, '32', '150');
INSERT INTO `product_code` VALUES ('94', '浙江省', '47', '11', null, '32', '300');
INSERT INTO `product_code` VALUES ('95', '浙江省', '48', '11', null, '32', '500');
INSERT INTO `product_code` VALUES ('96', '浙江省', '49', '11', null, '32', '1024');
INSERT INTO `product_code` VALUES ('97', '浙江省', '50', '11', null, '32', '2048');
INSERT INTO `product_code` VALUES ('98', '浙江省', '51', '11', null, '32', '3072');
INSERT INTO `product_code` VALUES ('99', '浙江省', '52', '11', null, '32', '4096');
INSERT INTO `product_code` VALUES ('100', '浙江省', '53', '11', null, '32', '6144');
INSERT INTO `product_code` VALUES ('101', '浙江省', '54', '11', null, '32', '11264');
INSERT INTO `product_code` VALUES ('102', '安徽省', '41', '12', null, '32', '10');
INSERT INTO `product_code` VALUES ('103', '安徽省', '43', '12', null, '32', '30');
INSERT INTO `product_code` VALUES ('104', '安徽省', '44', '12', null, '32', '70');
INSERT INTO `product_code` VALUES ('105', '安徽省', '45', '12', null, '32', '100');
INSERT INTO `product_code` VALUES ('106', '安徽省', '46', '12', null, '32', '150');
INSERT INTO `product_code` VALUES ('107', '安徽省', '47', '12', null, '32', '300');
INSERT INTO `product_code` VALUES ('108', '安徽省', '48', '12', null, '32', '500');
INSERT INTO `product_code` VALUES ('109', '安徽省', '49', '12', null, '32', '1024');
INSERT INTO `product_code` VALUES ('110', '安徽省', '50', '12', null, '32', '2048');
INSERT INTO `product_code` VALUES ('111', '安徽省', '51', '12', null, '32', '3072');
INSERT INTO `product_code` VALUES ('112', '安徽省', '52', '12', null, '32', '4096');
INSERT INTO `product_code` VALUES ('113', '安徽省', '53', '12', null, '32', '6144');
INSERT INTO `product_code` VALUES ('114', '安徽省', '54', '12', null, '32', '11264');
INSERT INTO `product_code` VALUES ('115', '山东省', '43', '15', null, '32', '30');
INSERT INTO `product_code` VALUES ('116', '山东省', '44', '15', null, '32', '70');
INSERT INTO `product_code` VALUES ('117', '山东省', '45', '15', null, '32', '100');
INSERT INTO `product_code` VALUES ('118', '山东省', '46', '15', null, '32', '150');
INSERT INTO `product_code` VALUES ('119', '山东省', '47', '15', null, '32', '300');
INSERT INTO `product_code` VALUES ('120', '山东省', '48', '15', null, '32', '500');
INSERT INTO `product_code` VALUES ('121', '山东省', '49', '15', null, '32', '1024');
INSERT INTO `product_code` VALUES ('122', '山东省', '50', '15', null, '32', '2048');
INSERT INTO `product_code` VALUES ('124', '山东省', '52', '15', null, '32', '4096');
INSERT INTO `product_code` VALUES ('125', '山东省', '51', '15', null, '32', '3072');
INSERT INTO `product_code` VALUES ('126', '山东省', '53', '15', null, '32', '6144');
INSERT INTO `product_code` VALUES ('127', '山东省', '54', '15', null, '32', '11264');
INSERT INTO `product_code` VALUES ('128', '黑龙江省', '41', '08', null, '32', '10');
INSERT INTO `product_code` VALUES ('129', '黑龙江省', '43', '08', null, '32', '30');
INSERT INTO `product_code` VALUES ('130', '黑龙江省', '44', '08', null, '32', '70');
INSERT INTO `product_code` VALUES ('131', '黑龙江省', '45', '08', null, '32', '100');
INSERT INTO `product_code` VALUES ('132', '黑龙江省', '46', '08', null, '32', '150');
INSERT INTO `product_code` VALUES ('133', '黑龙江省', '47', '08', null, '32', '300');
INSERT INTO `product_code` VALUES ('134', '黑龙江省', '48', '08', null, '32', '500');
INSERT INTO `product_code` VALUES ('135', '黑龙江省', '49', '08', null, '32', '1024');
INSERT INTO `product_code` VALUES ('136', '黑龙江省', '50', '08', null, '32', '2048');
INSERT INTO `product_code` VALUES ('137', '黑龙江省', '51', '08', null, '32', '3072');
INSERT INTO `product_code` VALUES ('138', '黑龙江省', '52', '08', null, '32', '4096');
INSERT INTO `product_code` VALUES ('139', '黑龙江省', '53', '08', null, '32', '6144');
INSERT INTO `product_code` VALUES ('140', '黑龙江省', '54', '08', null, '32', '11264');
INSERT INTO `product_code` VALUES ('141', '内蒙古自治区', '41', '05', null, '32', '10');
INSERT INTO `product_code` VALUES ('142', '内蒙古自治区', '43', '05', null, '32', '30');
INSERT INTO `product_code` VALUES ('143', '内蒙古自治区', '44', '05', null, '32', '70');
INSERT INTO `product_code` VALUES ('144', '内蒙古自治区', '45', '05', null, '32', '100');
INSERT INTO `product_code` VALUES ('145', '内蒙古自治区', '46', '05', null, '32', '150');
INSERT INTO `product_code` VALUES ('146', '内蒙古自治区', '47', '05', null, '32', '300');
INSERT INTO `product_code` VALUES ('147', '内蒙古自治区', '48', '05', null, '32', '500');
INSERT INTO `product_code` VALUES ('148', '内蒙古自治区', '49', '05', null, '32', '1024');
INSERT INTO `product_code` VALUES ('149', '内蒙古自治区', '50', '05', null, '32', '2048');
INSERT INTO `product_code` VALUES ('150', '内蒙古自治区', '51', '05', null, '32', '3072');
INSERT INTO `product_code` VALUES ('151', '内蒙古自治区', '52', '05', null, '32', '4096');
INSERT INTO `product_code` VALUES ('152', '内蒙古自治区', '53', '05', null, '32', '6144');
INSERT INTO `product_code` VALUES ('153', '内蒙古自治区', '54', '05', null, '32', '11264');
INSERT INTO `product_code` VALUES ('154', '江苏省', '41', '10', null, '32', '10');
INSERT INTO `product_code` VALUES ('155', '江苏省', '43', '10', null, '32', '30');
INSERT INTO `product_code` VALUES ('156', '江苏省', '44', '10', null, '32', '70');
INSERT INTO `product_code` VALUES ('157', '江苏省', '45', '10', null, '32', '100');
INSERT INTO `product_code` VALUES ('158', '江苏省', '46', '10', null, '32', '150');
INSERT INTO `product_code` VALUES ('159', '江苏省', '47', '10', null, '32', '300');
INSERT INTO `product_code` VALUES ('160', '江苏省', '48', '10', null, '32', '500');
INSERT INTO `product_code` VALUES ('161', '江苏省', '49', '10', null, '32', '1024');
INSERT INTO `product_code` VALUES ('162', '江苏省', '50', '10', null, '32', '2048');
INSERT INTO `product_code` VALUES ('163', '江苏省', '51', '10', null, '32', '3072');
INSERT INTO `product_code` VALUES ('164', '江苏省', '52', '10', null, '32', '4096');
INSERT INTO `product_code` VALUES ('165', '江苏省', '53', '10', null, '32', '6144');
INSERT INTO `product_code` VALUES ('166', '江苏省', '54', '10', null, '32', '11264');
INSERT INTO `product_code` VALUES ('167', '北京市', '41', '01', null, '32', '30');
INSERT INTO `product_code` VALUES ('168', '北京市', '44', '01', null, '32', '70');
INSERT INTO `product_code` VALUES ('169', '北京市', '45', '01', null, '32', '100');
INSERT INTO `product_code` VALUES ('170', '北京市', '46', '01', null, '32', '150');
INSERT INTO `product_code` VALUES ('171', '北京市', '47', '01', null, '32', '300');
INSERT INTO `product_code` VALUES ('172', '北京市', '48', '01', null, '32', '500');
INSERT INTO `product_code` VALUES ('173', '北京市', '49', '01', null, '32', '1024');
INSERT INTO `product_code` VALUES ('174', '北京市', '50', '01', null, '32', '2048');
INSERT INTO `product_code` VALUES ('175', '北京市', '51', '01', null, '32', '3072');
INSERT INTO `product_code` VALUES ('176', '北京市', '52', '01', null, '32', '4096');
INSERT INTO `product_code` VALUES ('177', '北京市', '53', '01', null, '32', '6144');
INSERT INTO `product_code` VALUES ('178', '北京市', '54', '01', null, '32', '11264');
INSERT INTO `product_code` VALUES ('179', '天津市', '41', '02', null, '32', '10');
INSERT INTO `product_code` VALUES ('180', '天津市', '43', '02', null, '32', '30');
INSERT INTO `product_code` VALUES ('181', '天津市', '44', '02', null, '32', '70');
INSERT INTO `product_code` VALUES ('182', '天津市', '45', '02', null, '32', '100');
INSERT INTO `product_code` VALUES ('183', '天津市', '46', '02', null, '32', '150');
INSERT INTO `product_code` VALUES ('184', '天津市', '47', '02', null, '32', '300');
INSERT INTO `product_code` VALUES ('185', '天津市', '48', '02', null, '32', '500');
INSERT INTO `product_code` VALUES ('186', '天津市', '49', '02', null, '32', '1024');
INSERT INTO `product_code` VALUES ('187', '天津市', '50', '02', null, '32', '2048');
INSERT INTO `product_code` VALUES ('188', '天津市', '51', '02', null, '32', '3072');
INSERT INTO `product_code` VALUES ('189', '天津市', '52', '02', null, '32', '4096');
INSERT INTO `product_code` VALUES ('190', '天津市', '53', '02', null, '32', '6144');
INSERT INTO `product_code` VALUES ('191', '天津市', '54', '02', null, '32', '11264');
INSERT INTO `product_code` VALUES ('192', '福建省', '41', '13', null, '32', '10');
INSERT INTO `product_code` VALUES ('193', '福建省', '43', '13', null, '32', '30');
INSERT INTO `product_code` VALUES ('194', '福建省', '44', '13', null, '32', '70');
INSERT INTO `product_code` VALUES ('195', '福建省', '45', '13', null, '32', '100');
INSERT INTO `product_code` VALUES ('196', '福建省', '46', '13', null, '32', '150');
INSERT INTO `product_code` VALUES ('197', '福建省', '47', '13', null, '32', '300');
INSERT INTO `product_code` VALUES ('198', '福建省', '48', '13', null, '32', '500');
INSERT INTO `product_code` VALUES ('199', '福建省', '49', '13', null, '32', '1024');
INSERT INTO `product_code` VALUES ('200', '福建省', '50', '13', null, '32', '2048');
INSERT INTO `product_code` VALUES ('201', '福建省', '51', '13', null, '32', '3072');
INSERT INTO `product_code` VALUES ('202', '福建省', '52', '13', null, '32', '4096');
INSERT INTO `product_code` VALUES ('203', '福建省', '53', '13', null, '32', '6144');
INSERT INTO `product_code` VALUES ('204', '福建省', '54', '13', null, '32', '11264');
INSERT INTO `product_code` VALUES ('205', '陕西省', '41', '26', null, '32', '10');
INSERT INTO `product_code` VALUES ('206', '陕西省', '43', '26', null, '32', '30');
INSERT INTO `product_code` VALUES ('207', '陕西省', '44', '26', null, '32', '70');
INSERT INTO `product_code` VALUES ('208', '陕西省', '45', '26', null, '32', '100');
INSERT INTO `product_code` VALUES ('209', '陕西省', '46', '26', null, '32', '150');
INSERT INTO `product_code` VALUES ('210', '陕西省', '47', '26', null, '32', '300');
INSERT INTO `product_code` VALUES ('211', '陕西省', '48', '26', null, '32', '500');
INSERT INTO `product_code` VALUES ('212', '陕西省', '49', '26', null, '32', '1024');
INSERT INTO `product_code` VALUES ('213', '陕西省', '50', '26', null, '32', '2048');
INSERT INTO `product_code` VALUES ('214', '陕西省', '51', '26', null, '32', '3072');
INSERT INTO `product_code` VALUES ('215', '陕西省', '52', '26', null, '32', '4096');
INSERT INTO `product_code` VALUES ('216', '陕西省', '53', '26', null, '32', '6144');
INSERT INTO `product_code` VALUES ('217', '陕西省', '54', '26', null, '32', '11264');
INSERT INTO `product_code` VALUES ('218', '宁夏回族自治区', '41', '29', null, '32', '10');
INSERT INTO `product_code` VALUES ('219', '宁夏回族自治区', '43', '29', null, '32', '30');
INSERT INTO `product_code` VALUES ('220', '宁夏回族自治区', '44', '29', null, '32', '70');
INSERT INTO `product_code` VALUES ('221', '宁夏回族自治区', '45', '29', null, '32', '100');
INSERT INTO `product_code` VALUES ('222', '宁夏回族自治区', '46', '29', null, '32', '150');
INSERT INTO `product_code` VALUES ('223', '宁夏回族自治区', '47', '29', null, '32', '300');
INSERT INTO `product_code` VALUES ('224', '宁夏回族自治区', '48', '29', null, '32', '500');
INSERT INTO `product_code` VALUES ('225', '宁夏回族自治区', '49', '29', null, '32', '1024');
INSERT INTO `product_code` VALUES ('226', '宁夏回族自治区', '50', '29', null, '32', '2048');
INSERT INTO `product_code` VALUES ('227', '宁夏回族自治区', '51', '29', null, '32', '3072');
INSERT INTO `product_code` VALUES ('228', '宁夏回族自治区', '52', '29', null, '32', '4096');
INSERT INTO `product_code` VALUES ('229', '宁夏回族自治区', '53', '29', null, '32', '6144');
INSERT INTO `product_code` VALUES ('230', '宁夏回族自治区', '54', '29', null, '32', '11264');

-- ----------------------------
-- Table structure for `purchase`
-- ----------------------------
DROP TABLE IF EXISTS `purchase`;
CREATE TABLE `purchase` (
  `order_id` bigint(20) NOT NULL COMMENT 'è®¢å•å·',
  `order_id_api` varchar(255) DEFAULT NULL COMMENT '其他系统返回的订单id',
  `order_id_from` varchar(40) DEFAULT NULL COMMENT '下级代理商传过来的订单号',
  `account_id` int(255) DEFAULT NULL COMMENT '生成订单的代理商账户',
  `charge_tel` varchar(255) DEFAULT NULL COMMENT 'æ‰‹æœºå·',
  `order_amount` double DEFAULT NULL COMMENT '订单的初始价格（适用于接口充值）',
  `pg_id` int(255) DEFAULT NULL COMMENT 'æµé‡åŒ…idï¼ˆå¤–é”®ï¼‰',
  `order_arrive_time` bigint(20) DEFAULT NULL COMMENT 'æäº¤æ—¶é—´ï¼ˆæœ¬å¹³å°èŽ·å¾—è¯¥æ•°æ®è¯·æ±‚çš„æ—¶é—´ï¼‰',
  `charge_tel_detail` varchar(255) DEFAULT NULL COMMENT 'å·ç å½’å±žï¼ˆï¼šæ±Ÿè¥¿ç§»åŠ¨ï¼‰',
  `charge_tel_city` varchar(255) DEFAULT NULL COMMENT 'å·ç å½’å±žå…·ä½“åŸŽå¸‚',
  `order_result` int(11) DEFAULT NULL COMMENT '订单状态（超级管理员）',
  `channel_name` varchar(255) DEFAULT NULL COMMENT '通道名称',
  `order_result_detail` varchar(255) DEFAULT NULL COMMENT '订单结果描述（超级管理员）',
  `order_back_time` bigint(20) DEFAULT NULL COMMENT '订单返回时间',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of purchase
-- ----------------------------
INSERT INTO `purchase` VALUES ('734955636709658624', '20170916174630022160', null, '2', '13670850603', '2.01', '41', '1505555187652', '广东移动', null, '1', '', '手动成功', '1505644752909');
INSERT INTO `purchase` VALUES ('734968246582644736', '20170916183634779408', null, '2', '13670850603', '2.01', '41', '1505558194080', '广东移动', null, '1', '', '手动成功', '1505644751085');
INSERT INTO `purchase` VALUES ('734991771976601600', '20170916201003689894', null, '1', '13670850603', '2.85', '43', '1505563802973', '广东移动', null, '0', '河南硕郎-微族', '手动失败', '1505564437705');
INSERT INTO `purchase` VALUES ('734992684296441856', '20170916201340983206', null, '1', '13670850603', '2.85', '43', '1505564020487', '广东移动', null, '1', '河南硕郎-微族', '手动成功', '1505564435425');
INSERT INTO `purchase` VALUES ('735263809198886912', '20170917141101319201', null, '2', '13670850603', '1.74', '41', '1505628661701', '广东移动', null, '1', '河南硕郎-微族', '手动成功', '1505644748535');
INSERT INTO `purchase` VALUES ('735556856507797504', '20170918093530398593', null, '2', '13670850603', '1.74', '41', '1505698529623', '广东移动', null, '0', '河南硕郎-微族', '', '1505698788641');
INSERT INTO `purchase` VALUES ('735565336828448768', '20170918100954832330', null, '1', '13670850603', '1.71', '41', '1505700551489', '广东移动', null, '1', '河南硕郎-微族', '欠费等待', '1505700687646');
INSERT INTO `purchase` VALUES ('735637674362146816', '20170918145638676806', null, '1', '13891258899', '0.99', '66', '1505717798098', '陕西移动', null, '1', '河南硕郎', '欠费等待', '1505717844166');
INSERT INTO `purchase` VALUES ('735643477341114368', '20170918151948954209', null, '1', '13891258899', '0.99', '66', '1505719181638', '陕西移动', null, '0', '河南硕郎', '产品未配置', '1505719191124');
INSERT INTO `purchase` VALUES ('735691086504136704', '20170918182852691495', null, '10', '15191436371', '92.4', '76', '1505730532546', '陕西移动', null, '1', '河南硕郎', '正在充值', '1505730656147');
INSERT INTO `purchase` VALUES ('735696617457324032', '20170918185051643763', null, '32', '15029075956', '92.4', '76', '1505731851229', '陕西移动', null, '1', '河南硕郎', '正在充值', '1505731947558');
INSERT INTO `purchase` VALUES ('735696780196319232', '20170918185130878911', null, '32', '18710364039', '92.4', '76', '1505731890031', '陕西移动', null, '1', '河南硕郎', '正在充值', '1505732038387');
INSERT INTO `purchase` VALUES ('735700764608958464', null, null, '2', '18710364039', '0.99', '66', '1505732839988', '陕西移动', null, null, '河南硕郎', null, null);
INSERT INTO `purchase` VALUES ('735701276200800256', '20170918190922367883', null, '32', '18392775815', '92.4', '76', '1505732961962', '陕西移动', null, '0', '河南硕郎', '正在充值', '1505733305832');
INSERT INTO `purchase` VALUES ('735702630147297280', null, null, '2', '18392775815', '0.99', '66', '1505733284766', '陕西移动', null, null, '河南硕郎', null, null);
INSERT INTO `purchase` VALUES ('735702695658131456', null, null, '32', '15202459815', '92.4', '76', '1505733300387', '陕西移动', null, null, '河南硕郎', null, null);
INSERT INTO `purchase` VALUES ('735736701875392512', null, null, '32', '15202459815', '92.4', '76', '1505741408101', '陕西移动', null, null, '河南硕郎', null, null);
INSERT INTO `purchase` VALUES ('735736758393638912', null, null, '32', '15202459815', '33', '73', '1505741421576', '陕西移动', null, null, '河南硕郎', null, null);
INSERT INTO `purchase` VALUES ('735750781898067968', null, null, '2', '15891790092', '0.99', '66', '1505744765040', '陕西移动', null, null, '河南硕郎', null, null);
INSERT INTO `purchase` VALUES ('735918403251867648', '20170919093209013011', null, '39', '15829898209', '0.99', '66', '1505784729085', '陕西移动', null, '0', '河南硕郎', '产品未配置', '1505784735694');
INSERT INTO `purchase` VALUES ('736056020098355200', '20170919183859270499', null, '39', '15829898209', '0.99', '66', '1505817539496', '陕西移动', null, '0', '河南硕郎', '产品未配置', '1505819072245');
INSERT INTO `purchase` VALUES ('736063456880365568', '20170919190832800630', null, '39', '15829898209', '9.9', '70', '1505819312565', '陕西移动', null, '0', '河南硕郎', '手动失败', '1505819511123');
INSERT INTO `purchase` VALUES ('736124156227096576', null, null, '32', '18710364039', '92.4', '76', '1505833784417', '陕西移动', null, null, '微族-陕西省内移动', null, null);
INSERT INTO `purchase` VALUES ('736283208571686912', null, null, '2', '15829898209', '9.9', '70', '1505871705451', '陕西移动', null, null, '微族-陕西省内移动', null, null);
INSERT INTO `purchase` VALUES ('736283369150615552', '20170920094223425583', null, '2', '15829898209', '9.9', '70', '1505871743736', '陕西移动', null, '0', '微族-陕西省内移动', '系统：失败', '1506474925524');
INSERT INTO `purchase` VALUES ('736322784392646656', '20170920121901386880', null, '55', '13772665275', '23.1', '72', '1505881141062', '陕西移动', null, '0', '微族-陕西省内移动', '失败', '1505905476867');
INSERT INTO `purchase` VALUES ('736326301064892416', '20170920123259330129', null, '55', '13772665275', '21.7', '72', '1505881979502', '陕西移动', null, '1', '微族-陕西省内移动', '正在充值', '1505905591596');
INSERT INTO `purchase` VALUES ('736402598193532928', '20170920173610388982', null, '7', '15991994058', '15.5', '71', '1505900170153', '陕西移动', null, '2', '微族-陕西本地移动', '正在充值', '1505987304861');
INSERT INTO `purchase` VALUES ('736437229278203904', '20170920195346054210', null, '39', '15829898209', '3.1', '78', '1505908426848', '陕西移动', null, '1', '微族-陕西本地移动', '正在充值', '1505909905347');
INSERT INTO `purchase` VALUES ('736450404098772992', '20170920204608835997', null, '7', '13572191613', '15.5', '71', '1505911567970', '陕西移动', null, '2', '微族-陕西本地移动', '正在充值', '1505987304820');
INSERT INTO `purchase` VALUES ('736465259857973248', '20170920214509680953', null, '7', '15191128003', '21.7', '72', '1505915109860', '陕西移动', null, '2', '微族-陕西本地移动', '正在充值', '1505987304785');
INSERT INTO `purchase` VALUES ('736465769222639616', '20170920214711067496', null, '7', '18392138893', '21.7', '72', '1505915231302', '陕西移动', null, '2', '微族-陕西本地移动', '正在充值', '1505987304749');
INSERT INTO `purchase` VALUES ('736471316961431552', '20170920220914304716', null, '7', '18392163283', '40.3', '74', '1505916553986', '陕西移动', null, '2', '微族-陕西本地移动', '正在充值', '1505987304710');
INSERT INTO `purchase` VALUES ('736474802667130880', '20170920222305683750', null, '7', '15191258181', '31', '73', '1505917385043', '陕西移动', null, '2', '微族-陕西本地移动', '正在充值', '1505987304672');
INSERT INTO `purchase` VALUES ('736482923628204032', null, null, '3', '15067460579', '1.74', '41', '1505919321231', '浙江移动', null, null, '微族 浙江移动', null, null);
INSERT INTO `purchase` VALUES ('736483154348478464', '20170920225616935511', null, '3', '15067460579', '1.74', '41', '1505919376239', '浙江移动', null, '0', '微族 浙江移动', '产品未配置', '1506474925412');
INSERT INTO `purchase` VALUES ('736673432812392448', '20170921113222041038', null, '7', '15291660333', '15.5', '71', '1505964742160', '陕西移动', null, '1', '微族-陕西本地移动', '系统：成功', '1505987368331');
INSERT INTO `purchase` VALUES ('736709519052115968', '20170921135545877550', null, '7', '13772150177', '40.3', '74', '1505973345790', '陕西移动', null, '1', '微族-陕西本地移动', '系统：成功', '1505987368290');
INSERT INTO `purchase` VALUES ('736766071347875840', '20170921174028871424', null, '26', '15929211697', '21.7', '72', '1505986828906', '陕西移动', null, '1', '微族-陕西本地移动', '系统：成功', '1505987368249');
INSERT INTO `purchase` VALUES ('738549100521197568', null, null, '2', '15067460579', '1.71', '41', '1506411936189', '浙江移动', null, null, '微族 浙江移动', '系统：充值进行', null);
INSERT INTO `purchase` VALUES ('738564868096921600', null, null, '2', '15067460579', '1.71', '41', '1506415695472', '浙江移动', null, null, '微族 浙江移动', '', null);
INSERT INTO `purchase` VALUES ('738566427362988032', null, null, '2', '15067460579', '1.71', '41', '1506416067229', '浙江移动', null, null, '微族 浙江移动', null, null);
INSERT INTO `purchase` VALUES ('738813373969338368', null, null, '2', '15067460579', '1.71', '41', '1506474943889', '浙江移动', null, null, '微族 浙江移动', null, null);
INSERT INTO `purchase` VALUES ('738815199615651840', null, null, '3', '15067460579', '1.74', '41', '1506475379158', '浙江移动', null, null, '微族 浙江移动', null, null);
INSERT INTO `purchase` VALUES ('738816343100362752', null, null, '3', '15067460579', '1.74', '41', '1506475651786', '浙江移动', null, null, '微族 浙江移动', null, null);
INSERT INTO `purchase` VALUES ('738817927960072192', null, null, '3', '15067460579', '1.74', '41', '1506476029645', '浙江移动', null, null, '微族 浙江移动', null, null);
INSERT INTO `purchase` VALUES ('738823326721380352', null, null, '3', '15067460579', '1.74', '41', '1506477316811', '浙江移动', null, null, '微族 浙江移动', null, null);
INSERT INTO `purchase` VALUES ('738824633628758016', null, null, '3', '15067460579', '1.74', '41', '1506477628393', '浙江移动', null, null, '微族 浙江移动', null, null);
INSERT INTO `purchase` VALUES ('738827550343565312', null, null, '3', '15067460579', '1.74', '41', '1506478323800', '浙江移动', null, null, '微族 浙江移动', null, null);
INSERT INTO `purchase` VALUES ('738830028967514112', null, null, '2', '15067460579', '1.71', '41', '1506478914751', '浙江移动', null, null, '微族 浙江移动', null, null);
INSERT INTO `purchase` VALUES ('742911737304453120', null, null, '2', '15067460579', '1.71', '41', '1507452069852', '浙江移动', null, '3', '微族 浙江移动', '通道暂停等待', null);
INSERT INTO `purchase` VALUES ('742913528372924416', null, null, '2', '15067460579', '1.71', '41', '1507452496876', '浙江移动', '宁波', '3', '微族 浙江移动', '通道暂停等待', null);

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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rate_backward
-- ----------------------------
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
INSERT INTO `rate_backward` VALUES ('19', 'fd', '1', '{\"内蒙古自治区\":0.23,\"湖北省\":0.3}', null, null, '0', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rate_discount
-- ----------------------------
INSERT INTO `rate_discount` VALUES ('22', '0.66', null, '19', '0', '22');
INSERT INTO `rate_discount` VALUES ('23', '0.57', null, '19', '0', '22');
INSERT INTO `rate_discount` VALUES ('26', '0.47', null, '27', '0', '30');
INSERT INTO `rate_discount` VALUES ('29', '0.76', null, '44', '0', '47');
INSERT INTO `rate_discount` VALUES ('30', '0.72', null, '43', '0', '46');
INSERT INTO `rate_discount` VALUES ('36', '0.7', null, '45', '0', '48');
INSERT INTO `rate_discount` VALUES ('37', '0.62', null, '46', '0', '49');
INSERT INTO `rate_discount` VALUES ('39', '0.612', null, '48', '0', '51');
INSERT INTO `rate_discount` VALUES ('40', '0.445', null, '49', '0', '52');
INSERT INTO `rate_discount` VALUES ('41', '0.467', null, '50', '0', '53');
INSERT INTO `rate_discount` VALUES ('42', '0.448', null, '53', '0', '56');
INSERT INTO `rate_discount` VALUES ('43', '0.768', null, '54', '0', '57');
INSERT INTO `rate_discount` VALUES ('46', '0.31', null, '58', '0', '61');
INSERT INTO `rate_discount` VALUES ('47', '0.58', '23', '19', '0', '22');
INSERT INTO `rate_discount` VALUES ('48', '0.33', null, '58', '0', '61');
INSERT INTO `rate_discount` VALUES ('49', '0.89', null, '60', '1', '63');

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
-- Table structure for `transfer_record`
-- ----------------------------
DROP TABLE IF EXISTS `transfer_record`;
CREATE TABLE `transfer_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `from_bank_id` bigint(20) DEFAULT NULL,
  `to_bank_id` bigint(20) DEFAULT NULL,
  `commit_amount` double DEFAULT NULL,
  `transfer_amount` double DEFAULT NULL COMMENT '入账金额',
  `commit_time` bigint(20) DEFAULT NULL,
  `real_time` bigint(20) DEFAULT NULL,
  `confirm_time` bigint(20) DEFAULT NULL,
  `confirm_state` int(11) DEFAULT NULL,
  `from_agency_id` int(11) DEFAULT NULL,
  `to_agency_id` int(11) DEFAULT NULL,
  `transfer_slip` bigint(20) DEFAULT NULL COMMENT '转账凭条',
  PRIMARY KEY (`id`),
  KEY `fk_tsr_ba1` (`from_bank_id`),
  KEY `fk_tsr_ba2` (`to_bank_id`),
  KEY `fk_tsr_agb1` (`from_agency_id`),
  KEY `fk_tsr_agb2` (`to_agency_id`),
  CONSTRAINT `fk_tsr_agb1` FOREIGN KEY (`from_agency_id`) REFERENCES `agency_backward` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_tsr_agb2` FOREIGN KEY (`to_agency_id`) REFERENCES `agency_backward` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_tsr_ba1` FOREIGN KEY (`from_bank_id`) REFERENCES `bank_account` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_tsr_ba2` FOREIGN KEY (`to_bank_id`) REFERENCES `bank_account` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of transfer_record
-- ----------------------------
INSERT INTO `transfer_record` VALUES ('6', '19', '17', '300', '300', '1507864652139', '1507864646000', '1507865588052', '1', '2', '1', '6031462352208');
INSERT INTO `transfer_record` VALUES ('7', '19', '17', '300', '300', '1507866339618', '1507866332000', '1507866489616', '1', '2', '1', '6031465958468');
INSERT INTO `transfer_record` VALUES ('14', '19', '17', '100', '0', '1507881620653', '1507881618000', null, '2', '2', '1', null);
