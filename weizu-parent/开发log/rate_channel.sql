/*
Navicat MySQL Data Transfer

Source Server         : channel-server
Source Server Version : 50626
Source Host           : 120.55.162.224:3306
Source Database       : rate_channel

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2017-10-14 18:12:15
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
) ENGINE=InnoDB AUTO_INCREMENT=2492 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account_active_rate
-- ----------------------------
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
INSERT INTO `account_active_rate` VALUES ('109', '29', '1', '26', '0', 'Bear', '1505731160500');
INSERT INTO `account_active_rate` VALUES ('110', '30', '1', '26', '0', 'zxx', '1505731160500');
INSERT INTO `account_active_rate` VALUES ('114', '31', '1', '26', '0', 'hy123456', '1505744206093');
INSERT INTO `account_active_rate` VALUES ('115', '32', '1', '26', '0', 'wl123', '1505744206093');
INSERT INTO `account_active_rate` VALUES ('116', '33', '1', '26', '0', '鳯儿网店', '1505744206093');
INSERT INTO `account_active_rate` VALUES ('117', '34', '1', '26', '0', 'ruiruima', '1505744206093');
INSERT INTO `account_active_rate` VALUES ('118', '35', '1', '26', '0', '944581678', '1505744206093');
INSERT INTO `account_active_rate` VALUES ('119', '36', '1', '26', '0', '2069959168', '1505744206093');
INSERT INTO `account_active_rate` VALUES ('120', '37', '1', '26', '0', '570156062', '1505744206093');
INSERT INTO `account_active_rate` VALUES ('121', '38', '1', '26', '0', '770733914', '1505744206093');
INSERT INTO `account_active_rate` VALUES ('122', '39', '1', '26', '0', '5257', '1505744206093');
INSERT INTO `account_active_rate` VALUES ('123', '40', '1', '26', '0', '18734158108', '1505744206093');
INSERT INTO `account_active_rate` VALUES ('124', '41', '1', '26', '0', 'xhq1347574865', '1505744208055');
INSERT INTO `account_active_rate` VALUES ('188', '42', '1', '26', '0', 'Chen', '1505745428700');
INSERT INTO `account_active_rate` VALUES ('189', '43', '1', '26', '0', 'qq130496', '1505745428700');
INSERT INTO `account_active_rate` VALUES ('190', '44', '1', '26', '0', 'kevinchow', '1505745428700');
INSERT INTO `account_active_rate` VALUES ('191', '45', '1', '26', '0', '17346544413', '1505745428700');
INSERT INTO `account_active_rate` VALUES ('254', '46', '1', '26', '0', '2480199685', '1505829677290');
INSERT INTO `account_active_rate` VALUES ('255', '47', '1', '26', '0', 'jim145', '1505829677290');
INSERT INTO `account_active_rate` VALUES ('256', '48', '1', '26', '0', 'bada', '1505829677290');
INSERT INTO `account_active_rate` VALUES ('257', '49', '1', '26', '0', '罗大大', '1505829677290');
INSERT INTO `account_active_rate` VALUES ('258', '50', '1', '26', '0', '109', '1505829677290');
INSERT INTO `account_active_rate` VALUES ('259', '51', '1', '26', '0', '119', '1505829677290');
INSERT INTO `account_active_rate` VALUES ('260', '52', '1', '26', '0', 'gigi77', '1505829677290');
INSERT INTO `account_active_rate` VALUES ('261', '53', '1', '26', '0', 'gigi777', '1505829677290');
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
INSERT INTO `account_active_rate` VALUES ('376', '29', '1', '29', '0', 'Bear', '1505872347551');
INSERT INTO `account_active_rate` VALUES ('377', '30', '1', '29', '0', 'zxx', '1505872347551');
INSERT INTO `account_active_rate` VALUES ('378', '31', '1', '29', '0', 'hy123456', '1505872347551');
INSERT INTO `account_active_rate` VALUES ('379', '32', '1', '29', '0', 'wl123', '1505872347551');
INSERT INTO `account_active_rate` VALUES ('380', '33', '1', '29', '0', '鳯儿网店', '1505872347551');
INSERT INTO `account_active_rate` VALUES ('381', '34', '1', '29', '0', 'ruiruima', '1505872347551');
INSERT INTO `account_active_rate` VALUES ('382', '35', '1', '29', '0', '944581678', '1505872347551');
INSERT INTO `account_active_rate` VALUES ('383', '36', '1', '29', '0', '2069959168', '1505872349441');
INSERT INTO `account_active_rate` VALUES ('384', '37', '1', '29', '0', '570156062', '1505872349441');
INSERT INTO `account_active_rate` VALUES ('385', '38', '1', '29', '0', '770733914', '1505872349441');
INSERT INTO `account_active_rate` VALUES ('386', '39', '1', '29', '0', '5257', '1505872349441');
INSERT INTO `account_active_rate` VALUES ('387', '40', '1', '29', '0', '18734158108', '1505872349441');
INSERT INTO `account_active_rate` VALUES ('388', '41', '1', '29', '0', 'xhq1347574865', '1505872349441');
INSERT INTO `account_active_rate` VALUES ('389', '42', '1', '29', '0', 'Chen', '1505872349441');
INSERT INTO `account_active_rate` VALUES ('390', '43', '1', '29', '0', 'qq130496', '1505872349441');
INSERT INTO `account_active_rate` VALUES ('391', '44', '1', '29', '0', 'kevinchow', '1505872349441');
INSERT INTO `account_active_rate` VALUES ('392', '45', '1', '29', '0', '17346544413', '1505872349441');
INSERT INTO `account_active_rate` VALUES ('393', '46', '1', '29', '0', '2480199685', '1505872351418');
INSERT INTO `account_active_rate` VALUES ('394', '47', '1', '29', '0', 'jim145', '1505872351418');
INSERT INTO `account_active_rate` VALUES ('395', '48', '1', '29', '0', 'bada', '1505872351418');
INSERT INTO `account_active_rate` VALUES ('396', '49', '1', '29', '0', '罗大大', '1505872351418');
INSERT INTO `account_active_rate` VALUES ('397', '50', '1', '29', '0', '109', '1505872351418');
INSERT INTO `account_active_rate` VALUES ('398', '51', '1', '29', '0', '119', '1505872351418');
INSERT INTO `account_active_rate` VALUES ('399', '52', '1', '29', '0', 'gigi77', '1505872351418');
INSERT INTO `account_active_rate` VALUES ('400', '53', '1', '29', '0', 'gigi777', '1505872351418');
INSERT INTO `account_active_rate` VALUES ('402', '4', '1', '30', '0', 'wzkj', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('403', '5', '1', '30', '0', '冰河', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('404', '6', '1', '30', '0', 'jiafeng', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('405', '7', '1', '30', '0', 'l474705958', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('406', '8', '1', '30', '0', '184066643', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('407', '9', '1', '30', '0', '2369412', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('408', '10', '1', '30', '0', 'hy123', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('409', '11', '1', '30', '0', 'zishu', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('410', '12', '1', '30', '0', 'tianjing', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('411', '13', '1', '30', '0', 'zqy95178250', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('412', '14', '1', '30', '0', 'QQ574912927', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('413', '15', '1', '30', '0', '1579599827', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('414', '17', '1', '30', '0', '789', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('415', '18', '1', '30', '0', '112', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('416', '20', '1', '30', '0', 'b2218776', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('417', '21', '1', '30', '0', '13771547176', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('418', '22', '1', '30', '0', '1', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('419', '23', '1', '30', '0', '小aq', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('420', '24', '1', '30', '0', '15914897978', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('421', '25', '1', '30', '0', 'oushinanshen', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('422', '26', '1', '30', '0', 'wxx899999', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('423', '27', '1', '30', '0', '1464975293', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('424', '29', '1', '30', '0', 'Bear', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('425', '30', '1', '30', '0', 'zxx', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('426', '31', '1', '30', '0', 'hy123456', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('427', '32', '1', '30', '0', 'wl123', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('428', '33', '1', '30', '0', '鳯儿网店', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('429', '34', '1', '30', '0', 'ruiruima', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('430', '35', '1', '30', '0', '944581678', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('431', '36', '1', '30', '0', '2069959168', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('432', '37', '1', '30', '0', '570156062', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('433', '38', '1', '30', '0', '770733914', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('434', '39', '1', '30', '0', '5257', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('435', '40', '1', '30', '0', '18734158108', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('436', '41', '1', '30', '0', 'xhq1347574865', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('437', '42', '1', '30', '0', 'Chen', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('438', '43', '1', '30', '0', 'qq130496', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('439', '44', '1', '30', '0', 'kevinchow', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('440', '45', '1', '30', '0', '17346544413', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('441', '46', '1', '30', '0', '2480199685', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('442', '47', '1', '30', '0', 'jim145', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('443', '48', '1', '30', '0', 'bada', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('444', '49', '1', '30', '0', '罗大大', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('445', '50', '1', '30', '0', '109', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('446', '51', '1', '30', '0', '119', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('447', '52', '1', '30', '0', 'gigi77', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('448', '53', '1', '30', '0', 'gigi777', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('643', '55', '1', '29', '1', '111111', '0');
INSERT INTO `account_active_rate` VALUES ('644', '56', '1', '29', '0', 'dada', '1505881078455');
INSERT INTO `account_active_rate` VALUES ('645', '55', '1', '30', '0', '111111', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('646', '56', '1', '30', '0', 'dada', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('673', '4', '1', '36', '1', 'wzkj', '1505883064715');
INSERT INTO `account_active_rate` VALUES ('674', '5', '1', '36', '1', '冰河', '1505883064715');
INSERT INTO `account_active_rate` VALUES ('675', '6', '1', '36', '1', 'jiafeng', '1505883064715');
INSERT INTO `account_active_rate` VALUES ('676', '7', '1', '36', '1', 'l474705958', '1505883064715');
INSERT INTO `account_active_rate` VALUES ('677', '8', '1', '36', '1', '184066643', '1505883064715');
INSERT INTO `account_active_rate` VALUES ('678', '9', '1', '36', '1', '2369412', '1505883064715');
INSERT INTO `account_active_rate` VALUES ('679', '10', '1', '36', '1', 'hy123', '1505883064715');
INSERT INTO `account_active_rate` VALUES ('680', '11', '1', '36', '1', 'zishu', '1505883064715');
INSERT INTO `account_active_rate` VALUES ('681', '12', '1', '36', '1', 'tianjing', '1505883064715');
INSERT INTO `account_active_rate` VALUES ('682', '13', '1', '36', '1', 'zqy95178250', '1505883064715');
INSERT INTO `account_active_rate` VALUES ('683', '14', '1', '36', '1', 'QQ574912927', '1505883066430');
INSERT INTO `account_active_rate` VALUES ('684', '15', '1', '36', '1', '1579599827', '1505883066430');
INSERT INTO `account_active_rate` VALUES ('685', '17', '1', '36', '1', '789', '1505883066430');
INSERT INTO `account_active_rate` VALUES ('686', '18', '1', '36', '1', '112', '1505883066430');
INSERT INTO `account_active_rate` VALUES ('687', '20', '1', '36', '1', 'b2218776', '1505883066430');
INSERT INTO `account_active_rate` VALUES ('688', '21', '1', '36', '1', '13771547176', '1505883066430');
INSERT INTO `account_active_rate` VALUES ('689', '22', '1', '36', '1', '1', '1505883066430');
INSERT INTO `account_active_rate` VALUES ('690', '23', '1', '36', '1', '小aq', '1505883066430');
INSERT INTO `account_active_rate` VALUES ('691', '24', '1', '36', '1', '15914897978', '1505883066430');
INSERT INTO `account_active_rate` VALUES ('692', '25', '1', '36', '1', 'oushinanshen', '1505883066430');
INSERT INTO `account_active_rate` VALUES ('693', '26', '1', '36', '1', 'wxx899999', '1505883067669');
INSERT INTO `account_active_rate` VALUES ('694', '27', '1', '36', '1', '1464975293', '1505883067669');
INSERT INTO `account_active_rate` VALUES ('695', '29', '1', '36', '1', 'Bear', '1505883067669');
INSERT INTO `account_active_rate` VALUES ('696', '30', '1', '36', '1', 'zxx', '1505883067669');
INSERT INTO `account_active_rate` VALUES ('697', '31', '1', '36', '1', 'hy123456', '1505883067669');
INSERT INTO `account_active_rate` VALUES ('698', '32', '1', '36', '1', 'wl123', '1505883067669');
INSERT INTO `account_active_rate` VALUES ('699', '33', '1', '36', '1', '鳯儿网店', '1505883067669');
INSERT INTO `account_active_rate` VALUES ('700', '34', '1', '36', '1', 'ruiruima', '1505883067669');
INSERT INTO `account_active_rate` VALUES ('701', '35', '1', '36', '1', '944581678', '1505883067669');
INSERT INTO `account_active_rate` VALUES ('702', '36', '1', '36', '1', '2069959168', '1505883067669');
INSERT INTO `account_active_rate` VALUES ('703', '37', '1', '36', '1', '570156062', '1505883069644');
INSERT INTO `account_active_rate` VALUES ('704', '38', '1', '36', '1', '770733914', '1505883069644');
INSERT INTO `account_active_rate` VALUES ('705', '39', '1', '36', '1', '5257', '1505883069644');
INSERT INTO `account_active_rate` VALUES ('706', '40', '1', '36', '1', '18734158108', '1505883069644');
INSERT INTO `account_active_rate` VALUES ('707', '41', '1', '36', '1', 'xhq1347574865', '1505883069644');
INSERT INTO `account_active_rate` VALUES ('708', '42', '1', '36', '1', 'Chen', '1505883069644');
INSERT INTO `account_active_rate` VALUES ('709', '43', '1', '36', '1', 'qq130496', '1505883069644');
INSERT INTO `account_active_rate` VALUES ('710', '44', '1', '36', '1', 'kevinchow', '1505883069644');
INSERT INTO `account_active_rate` VALUES ('711', '45', '1', '36', '1', '17346544413', '1505883069644');
INSERT INTO `account_active_rate` VALUES ('712', '46', '1', '36', '1', '2480199685', '1505883069644');
INSERT INTO `account_active_rate` VALUES ('713', '47', '1', '36', '1', 'jim145', '1505883071220');
INSERT INTO `account_active_rate` VALUES ('714', '48', '1', '36', '1', 'bada', '1505883071220');
INSERT INTO `account_active_rate` VALUES ('715', '49', '1', '36', '1', '罗大大', '1505883071220');
INSERT INTO `account_active_rate` VALUES ('716', '50', '1', '36', '1', '109', '1505883071220');
INSERT INTO `account_active_rate` VALUES ('717', '51', '1', '36', '1', '119', '1505883071220');
INSERT INTO `account_active_rate` VALUES ('718', '52', '1', '36', '1', 'gigi77', '1505883071220');
INSERT INTO `account_active_rate` VALUES ('719', '53', '1', '36', '1', 'gigi777', '1505883071220');
INSERT INTO `account_active_rate` VALUES ('720', '55', '1', '36', '1', '111111', '0');
INSERT INTO `account_active_rate` VALUES ('721', '56', '1', '36', '1', 'dada', '1505883071220');
INSERT INTO `account_active_rate` VALUES ('722', '57', '1', '36', '1', '源肥呀', '1505883071220');
INSERT INTO `account_active_rate` VALUES ('723', '4', '1', '37', '0', 'wzkj', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('724', '5', '1', '37', '0', '冰河', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('725', '6', '1', '37', '0', 'jiafeng', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('726', '7', '1', '37', '0', 'l474705958', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('727', '8', '1', '37', '0', '184066643', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('728', '9', '1', '37', '0', '2369412', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('729', '10', '1', '37', '0', 'hy123', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('730', '11', '1', '37', '0', 'zishu', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('731', '12', '1', '37', '0', 'tianjing', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('732', '13', '1', '37', '0', 'zqy95178250', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('733', '14', '1', '37', '0', 'QQ574912927', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('734', '15', '1', '37', '0', '1579599827', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('735', '17', '1', '37', '0', '789', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('736', '18', '1', '37', '0', '112', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('737', '20', '1', '37', '0', 'b2218776', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('738', '21', '1', '37', '0', '13771547176', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('739', '22', '1', '37', '0', '1', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('740', '23', '1', '37', '0', '小aq', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('741', '24', '1', '37', '0', '15914897978', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('742', '25', '1', '37', '0', 'oushinanshen', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('743', '26', '1', '37', '0', 'wxx899999', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('744', '27', '1', '37', '0', '1464975293', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('745', '29', '1', '37', '0', 'Bear', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('746', '30', '1', '37', '0', 'zxx', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('747', '31', '1', '37', '0', 'hy123456', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('748', '32', '1', '37', '0', 'wl123', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('749', '33', '1', '37', '0', '鳯儿网店', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('750', '34', '1', '37', '0', 'ruiruima', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('751', '35', '1', '37', '0', '944581678', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('752', '36', '1', '37', '0', '2069959168', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('753', '37', '1', '37', '0', '570156062', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('754', '38', '1', '37', '0', '770733914', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('755', '39', '1', '37', '0', '5257', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('756', '40', '1', '37', '0', '18734158108', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('757', '41', '1', '37', '0', 'xhq1347574865', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('758', '42', '1', '37', '0', 'Chen', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('759', '43', '1', '37', '0', 'qq130496', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('760', '44', '1', '37', '0', 'kevinchow', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('761', '45', '1', '37', '0', '17346544413', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('762', '46', '1', '37', '0', '2480199685', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('763', '47', '1', '37', '0', 'jim145', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('764', '48', '1', '37', '0', 'bada', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('765', '49', '1', '37', '0', '罗大大', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('766', '50', '1', '37', '0', '109', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('767', '51', '1', '37', '0', '119', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('768', '52', '1', '37', '0', 'gigi77', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('769', '53', '1', '37', '0', 'gigi777', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('770', '55', '1', '37', '0', '111111', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('771', '56', '1', '37', '0', 'dada', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('772', '57', '1', '37', '0', '源肥呀', '1506152004967');
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
INSERT INTO `account_active_rate` VALUES ('845', '29', '1', '39', '0', 'Bear', '1505899165725');
INSERT INTO `account_active_rate` VALUES ('846', '30', '1', '39', '0', 'zxx', '1505899165725');
INSERT INTO `account_active_rate` VALUES ('847', '31', '1', '39', '0', 'hy123456', '1505899165725');
INSERT INTO `account_active_rate` VALUES ('848', '32', '1', '39', '0', 'wl123', '1505899165725');
INSERT INTO `account_active_rate` VALUES ('849', '33', '1', '39', '0', '鳯儿网店', '1505899165725');
INSERT INTO `account_active_rate` VALUES ('850', '34', '1', '39', '0', 'ruiruima', '1505899165725');
INSERT INTO `account_active_rate` VALUES ('851', '35', '1', '39', '0', '944581678', '1505899165725');
INSERT INTO `account_active_rate` VALUES ('852', '36', '1', '39', '0', '2069959168', '1505899165725');
INSERT INTO `account_active_rate` VALUES ('853', '37', '1', '39', '0', '570156062', '1505899167142');
INSERT INTO `account_active_rate` VALUES ('854', '38', '1', '39', '0', '770733914', '1505899167142');
INSERT INTO `account_active_rate` VALUES ('855', '39', '1', '39', '0', '5257', '1505899167142');
INSERT INTO `account_active_rate` VALUES ('856', '40', '1', '39', '0', '18734158108', '1505899167142');
INSERT INTO `account_active_rate` VALUES ('857', '41', '1', '39', '0', 'xhq1347574865', '1505899167142');
INSERT INTO `account_active_rate` VALUES ('858', '42', '1', '39', '0', 'Chen', '1505899167142');
INSERT INTO `account_active_rate` VALUES ('859', '43', '1', '39', '0', 'qq130496', '1505899167142');
INSERT INTO `account_active_rate` VALUES ('860', '44', '1', '39', '0', 'kevinchow', '1505899167142');
INSERT INTO `account_active_rate` VALUES ('861', '45', '1', '39', '0', '17346544413', '1505899167142');
INSERT INTO `account_active_rate` VALUES ('862', '46', '1', '39', '0', '2480199685', '1505899167142');
INSERT INTO `account_active_rate` VALUES ('863', '47', '1', '39', '0', 'jim145', '1505899168893');
INSERT INTO `account_active_rate` VALUES ('864', '48', '1', '39', '0', 'bada', '1505899168893');
INSERT INTO `account_active_rate` VALUES ('865', '49', '1', '39', '0', '罗大大', '1505899168893');
INSERT INTO `account_active_rate` VALUES ('866', '50', '1', '39', '0', '109', '1505899168893');
INSERT INTO `account_active_rate` VALUES ('867', '51', '1', '39', '0', '119', '1505899168893');
INSERT INTO `account_active_rate` VALUES ('868', '52', '1', '39', '0', 'gigi77', '1505899168893');
INSERT INTO `account_active_rate` VALUES ('869', '53', '1', '39', '0', 'gigi777', '1505899168893');
INSERT INTO `account_active_rate` VALUES ('870', '55', '1', '39', '1', '111111', '0');
INSERT INTO `account_active_rate` VALUES ('871', '56', '1', '39', '0', 'dada', '1505899168893');
INSERT INTO `account_active_rate` VALUES ('872', '57', '1', '39', '0', '源肥呀', '1505899168893');
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
INSERT INTO `account_active_rate` VALUES ('895', '29', '1', '40', '0', 'Bear', '1505899316696');
INSERT INTO `account_active_rate` VALUES ('896', '30', '1', '40', '0', 'zxx', '1505899316696');
INSERT INTO `account_active_rate` VALUES ('897', '31', '1', '40', '0', 'hy123456', '1505899316696');
INSERT INTO `account_active_rate` VALUES ('898', '32', '1', '40', '0', 'wl123', '1505899316696');
INSERT INTO `account_active_rate` VALUES ('899', '33', '1', '40', '0', '鳯儿网店', '1505899316696');
INSERT INTO `account_active_rate` VALUES ('900', '34', '1', '40', '0', 'ruiruima', '1505899316696');
INSERT INTO `account_active_rate` VALUES ('901', '35', '1', '40', '0', '944581678', '1505899316696');
INSERT INTO `account_active_rate` VALUES ('902', '36', '1', '40', '0', '2069959168', '1505899316696');
INSERT INTO `account_active_rate` VALUES ('903', '37', '1', '40', '0', '570156062', '1505899319859');
INSERT INTO `account_active_rate` VALUES ('904', '38', '1', '40', '0', '770733914', '1505899319859');
INSERT INTO `account_active_rate` VALUES ('905', '39', '1', '40', '0', '5257', '1505899319859');
INSERT INTO `account_active_rate` VALUES ('906', '40', '1', '40', '0', '18734158108', '1505899319859');
INSERT INTO `account_active_rate` VALUES ('907', '41', '1', '40', '0', 'xhq1347574865', '1505899319859');
INSERT INTO `account_active_rate` VALUES ('908', '42', '1', '40', '0', 'Chen', '1505899319859');
INSERT INTO `account_active_rate` VALUES ('909', '43', '1', '40', '0', 'qq130496', '1505899319859');
INSERT INTO `account_active_rate` VALUES ('910', '44', '1', '40', '0', 'kevinchow', '1505899319859');
INSERT INTO `account_active_rate` VALUES ('911', '45', '1', '40', '0', '17346544413', '1505899319859');
INSERT INTO `account_active_rate` VALUES ('912', '46', '1', '40', '0', '2480199685', '1505899319859');
INSERT INTO `account_active_rate` VALUES ('913', '47', '1', '40', '0', 'jim145', '1505899321395');
INSERT INTO `account_active_rate` VALUES ('914', '48', '1', '40', '0', 'bada', '1505899321395');
INSERT INTO `account_active_rate` VALUES ('915', '49', '1', '40', '0', '罗大大', '1505899321395');
INSERT INTO `account_active_rate` VALUES ('916', '50', '1', '40', '0', '109', '1505899321395');
INSERT INTO `account_active_rate` VALUES ('917', '51', '1', '40', '0', '119', '1505899321395');
INSERT INTO `account_active_rate` VALUES ('918', '52', '1', '40', '0', 'gigi77', '1505899321395');
INSERT INTO `account_active_rate` VALUES ('919', '53', '1', '40', '0', 'gigi777', '1505899321395');
INSERT INTO `account_active_rate` VALUES ('920', '55', '1', '40', '1', '111111', '0');
INSERT INTO `account_active_rate` VALUES ('921', '56', '1', '40', '0', 'dada', '1505899321395');
INSERT INTO `account_active_rate` VALUES ('922', '57', '1', '40', '0', '源肥呀', '1505899321395');
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
INSERT INTO `account_active_rate` VALUES ('945', '29', '1', '41', '0', 'Bear', '1505899420668');
INSERT INTO `account_active_rate` VALUES ('946', '30', '1', '41', '0', 'zxx', '1505899420668');
INSERT INTO `account_active_rate` VALUES ('947', '31', '1', '41', '0', 'hy123456', '1505899420668');
INSERT INTO `account_active_rate` VALUES ('948', '32', '1', '41', '0', 'wl123', '1505899420668');
INSERT INTO `account_active_rate` VALUES ('949', '33', '1', '41', '0', '鳯儿网店', '1505899420668');
INSERT INTO `account_active_rate` VALUES ('950', '34', '1', '41', '0', 'ruiruima', '1505899420668');
INSERT INTO `account_active_rate` VALUES ('951', '35', '1', '41', '0', '944581678', '1505899420668');
INSERT INTO `account_active_rate` VALUES ('952', '36', '1', '41', '0', '2069959168', '1505899420668');
INSERT INTO `account_active_rate` VALUES ('953', '37', '1', '41', '0', '570156062', '1505899422529');
INSERT INTO `account_active_rate` VALUES ('954', '38', '1', '41', '0', '770733914', '1505899422529');
INSERT INTO `account_active_rate` VALUES ('955', '39', '1', '41', '0', '5257', '1505899422529');
INSERT INTO `account_active_rate` VALUES ('956', '40', '1', '41', '0', '18734158108', '1505899422529');
INSERT INTO `account_active_rate` VALUES ('957', '41', '1', '41', '0', 'xhq1347574865', '1505899422529');
INSERT INTO `account_active_rate` VALUES ('958', '42', '1', '41', '0', 'Chen', '1505899422529');
INSERT INTO `account_active_rate` VALUES ('959', '43', '1', '41', '0', 'qq130496', '1505899422529');
INSERT INTO `account_active_rate` VALUES ('960', '44', '1', '41', '0', 'kevinchow', '1505899422529');
INSERT INTO `account_active_rate` VALUES ('961', '45', '1', '41', '0', '17346544413', '1505899422529');
INSERT INTO `account_active_rate` VALUES ('962', '46', '1', '41', '0', '2480199685', '1505899422529');
INSERT INTO `account_active_rate` VALUES ('963', '47', '1', '41', '0', 'jim145', '1505899424077');
INSERT INTO `account_active_rate` VALUES ('964', '48', '1', '41', '0', 'bada', '1505899424077');
INSERT INTO `account_active_rate` VALUES ('965', '49', '1', '41', '0', '罗大大', '1505899424077');
INSERT INTO `account_active_rate` VALUES ('966', '50', '1', '41', '0', '109', '1505899424077');
INSERT INTO `account_active_rate` VALUES ('967', '51', '1', '41', '0', '119', '1505899424077');
INSERT INTO `account_active_rate` VALUES ('968', '52', '1', '41', '0', 'gigi77', '1505899424077');
INSERT INTO `account_active_rate` VALUES ('969', '53', '1', '41', '0', 'gigi777', '1505899424077');
INSERT INTO `account_active_rate` VALUES ('970', '55', '1', '41', '1', '111111', '0');
INSERT INTO `account_active_rate` VALUES ('971', '56', '1', '41', '0', 'dada', '1505899424077');
INSERT INTO `account_active_rate` VALUES ('972', '57', '1', '41', '0', '源肥呀', '1505899424077');
INSERT INTO `account_active_rate` VALUES ('973', '4', '1', '42', '0', 'wzkj', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('974', '5', '1', '42', '0', '冰河', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('975', '6', '1', '42', '0', 'jiafeng', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('976', '7', '1', '42', '0', 'l474705958', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('977', '8', '1', '42', '0', '184066643', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('978', '9', '1', '42', '0', '2369412', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('979', '10', '1', '42', '0', 'hy123', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('980', '11', '1', '42', '0', 'zishu', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('981', '12', '1', '42', '0', 'tianjing', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('982', '13', '1', '42', '0', 'zqy95178250', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('983', '14', '1', '42', '0', 'QQ574912927', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('984', '15', '1', '42', '0', '1579599827', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('985', '17', '1', '42', '0', '789', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('986', '18', '1', '42', '0', '112', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('987', '20', '1', '42', '0', 'b2218776', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('988', '21', '1', '42', '0', '13771547176', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('989', '22', '1', '42', '0', '1', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('990', '23', '1', '42', '0', '小aq', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('991', '24', '1', '42', '0', '15914897978', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('992', '25', '1', '42', '0', 'oushinanshen', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('993', '26', '1', '42', '0', 'wxx899999', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('994', '27', '1', '42', '0', '1464975293', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('995', '29', '1', '42', '0', 'Bear', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('996', '30', '1', '42', '0', 'zxx', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('997', '31', '1', '42', '0', 'hy123456', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('998', '32', '1', '42', '0', 'wl123', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('999', '33', '1', '42', '0', '鳯儿网店', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1000', '34', '1', '42', '0', 'ruiruima', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1001', '35', '1', '42', '0', '944581678', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1002', '36', '1', '42', '0', '2069959168', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1003', '37', '1', '42', '0', '570156062', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1004', '38', '1', '42', '0', '770733914', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1005', '39', '1', '42', '0', '5257', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1006', '40', '1', '42', '0', '18734158108', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1007', '41', '1', '42', '0', 'xhq1347574865', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1008', '42', '1', '42', '0', 'Chen', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1009', '43', '1', '42', '0', 'qq130496', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1010', '44', '1', '42', '0', 'kevinchow', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1011', '45', '1', '42', '0', '17346544413', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1012', '46', '1', '42', '0', '2480199685', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1013', '47', '1', '42', '0', 'jim145', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1014', '48', '1', '42', '0', 'bada', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1015', '49', '1', '42', '0', '罗大大', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1016', '50', '1', '42', '0', '109', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1017', '51', '1', '42', '0', '119', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1018', '52', '1', '42', '0', 'gigi77', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1019', '53', '1', '42', '0', 'gigi777', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1020', '55', '1', '42', '0', '111111', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1021', '56', '1', '42', '0', 'dada', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1022', '57', '1', '42', '0', '源肥呀', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1023', '4', '1', '43', '0', 'wzkj', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1024', '5', '1', '43', '0', '冰河', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1025', '6', '1', '43', '0', 'jiafeng', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1026', '7', '1', '43', '0', 'l474705958', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1027', '8', '1', '43', '0', '184066643', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1028', '9', '1', '43', '0', '2369412', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1029', '10', '1', '43', '0', 'hy123', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1030', '11', '1', '43', '0', 'zishu', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1031', '12', '1', '43', '0', 'tianjing', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1032', '13', '1', '43', '0', 'zqy95178250', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1033', '14', '1', '43', '0', 'QQ574912927', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1034', '15', '1', '43', '0', '1579599827', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1035', '17', '1', '43', '0', '789', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1036', '18', '1', '43', '0', '112', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1037', '20', '1', '43', '0', 'b2218776', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1038', '21', '1', '43', '0', '13771547176', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1039', '22', '1', '43', '0', '1', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1040', '23', '1', '43', '0', '小aq', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1041', '24', '1', '43', '0', '15914897978', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1042', '25', '1', '43', '0', 'oushinanshen', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1043', '26', '1', '43', '0', 'wxx899999', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1044', '27', '1', '43', '0', '1464975293', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1045', '29', '1', '43', '0', 'Bear', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1046', '30', '1', '43', '0', 'zxx', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1047', '31', '1', '43', '0', 'hy123456', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1048', '32', '1', '43', '0', 'wl123', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1049', '33', '1', '43', '0', '鳯儿网店', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1050', '34', '1', '43', '0', 'ruiruima', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1051', '35', '1', '43', '0', '944581678', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1052', '36', '1', '43', '0', '2069959168', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1053', '37', '1', '43', '0', '570156062', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1054', '38', '1', '43', '0', '770733914', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1055', '39', '1', '43', '0', '5257', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1056', '40', '1', '43', '0', '18734158108', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1057', '41', '1', '43', '0', 'xhq1347574865', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1058', '42', '1', '43', '0', 'Chen', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1059', '43', '1', '43', '0', 'qq130496', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1060', '44', '1', '43', '0', 'kevinchow', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1061', '45', '1', '43', '0', '17346544413', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1062', '46', '1', '43', '0', '2480199685', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1063', '47', '1', '43', '0', 'jim145', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1064', '48', '1', '43', '0', 'bada', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1065', '49', '1', '43', '0', '罗大大', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1066', '50', '1', '43', '0', '109', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1067', '51', '1', '43', '0', '119', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1068', '52', '1', '43', '0', 'gigi77', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1069', '53', '1', '43', '0', 'gigi777', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1070', '55', '1', '43', '0', '111111', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1071', '56', '1', '43', '0', 'dada', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1072', '57', '1', '43', '0', '源肥呀', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1226', '58', '1', '36', '1', '764388753', '1505958137853');
INSERT INTO `account_active_rate` VALUES ('1227', '59', '1', '36', '1', '815555213', '1505958137853');
INSERT INTO `account_active_rate` VALUES ('1228', '58', '1', '43', '0', '764388753', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1229', '59', '1', '43', '0', '815555213', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1232', '58', '1', '42', '0', '764388753', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1233', '59', '1', '42', '0', '815555213', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1234', '61', '1', '42', '0', '无厘头', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1235', '62', '1', '42', '0', '2630832822', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1236', '61', '1', '43', '0', '无厘头', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1237', '62', '1', '43', '0', '2630832822', '1506151912430');
INSERT INTO `account_active_rate` VALUES ('1238', '58', '1', '40', '0', '764388753', '1506043806298');
INSERT INTO `account_active_rate` VALUES ('1239', '59', '1', '40', '0', '815555213', '1506043806298');
INSERT INTO `account_active_rate` VALUES ('1240', '61', '1', '40', '0', '无厘头', '1506043806298');
INSERT INTO `account_active_rate` VALUES ('1241', '62', '1', '40', '0', '2630832822', '1506043806298');
INSERT INTO `account_active_rate` VALUES ('1242', '58', '1', '39', '0', '764388753', '1506043818293');
INSERT INTO `account_active_rate` VALUES ('1243', '59', '1', '39', '0', '815555213', '1506043818293');
INSERT INTO `account_active_rate` VALUES ('1244', '61', '1', '39', '0', '无厘头', '1506043818293');
INSERT INTO `account_active_rate` VALUES ('1245', '62', '1', '39', '0', '2630832822', '1506043818293');
INSERT INTO `account_active_rate` VALUES ('1246', '58', '1', '37', '0', '764388753', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('1247', '59', '1', '37', '0', '815555213', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('1248', '61', '1', '37', '0', '无厘头', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('1249', '62', '1', '37', '0', '2630832822', '1506152004967');
INSERT INTO `account_active_rate` VALUES ('1250', '57', '1', '29', '0', '源肥呀', '1506043841930');
INSERT INTO `account_active_rate` VALUES ('1251', '58', '1', '29', '0', '764388753', '1506043841930');
INSERT INTO `account_active_rate` VALUES ('1252', '59', '1', '29', '0', '815555213', '1506043841930');
INSERT INTO `account_active_rate` VALUES ('1253', '61', '1', '29', '0', '无厘头', '1506043841930');
INSERT INTO `account_active_rate` VALUES ('1254', '62', '1', '29', '0', '2630832822', '1506043841930');
INSERT INTO `account_active_rate` VALUES ('1255', '57', '1', '30', '0', '源肥呀', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('1256', '58', '1', '30', '0', '764388753', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('1257', '59', '1', '30', '0', '815555213', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('1258', '61', '1', '30', '0', '无厘头', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('1259', '62', '1', '30', '0', '2630832822', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('1260', '55', '1', '26', '0', '111111', '1506043861150');
INSERT INTO `account_active_rate` VALUES ('1261', '56', '1', '26', '0', 'dada', '1506043861150');
INSERT INTO `account_active_rate` VALUES ('1262', '57', '1', '26', '0', '源肥呀', '1506043861150');
INSERT INTO `account_active_rate` VALUES ('1263', '58', '1', '26', '0', '764388753', '1506043861150');
INSERT INTO `account_active_rate` VALUES ('1264', '59', '1', '26', '0', '815555213', '1506043861150');
INSERT INTO `account_active_rate` VALUES ('1265', '61', '1', '26', '0', '无厘头', '1506043861150');
INSERT INTO `account_active_rate` VALUES ('1266', '62', '1', '26', '0', '2630832822', '1506043861150');
INSERT INTO `account_active_rate` VALUES ('1272', '49', '1', '49', '0', '罗大大', '1506055740876');
INSERT INTO `account_active_rate` VALUES ('1273', '14', '1', '49', '0', 'QQ574912927', '1506055758877');
INSERT INTO `account_active_rate` VALUES ('1274', '15', '1', '49', '0', '1579599827', '1506055758877');
INSERT INTO `account_active_rate` VALUES ('1275', '17', '1', '49', '0', '789', '1506055758877');
INSERT INTO `account_active_rate` VALUES ('1276', '18', '1', '49', '0', '112', '1506055758877');
INSERT INTO `account_active_rate` VALUES ('1277', '20', '1', '49', '0', 'b2218776', '1506055758877');
INSERT INTO `account_active_rate` VALUES ('1278', '21', '1', '49', '0', '13771547176', '1506055758877');
INSERT INTO `account_active_rate` VALUES ('1279', '22', '1', '49', '0', '1', '1506055758877');
INSERT INTO `account_active_rate` VALUES ('1280', '23', '1', '49', '0', '小aq', '1506055758877');
INSERT INTO `account_active_rate` VALUES ('1281', '24', '1', '49', '0', '15914897978', '1506055758877');
INSERT INTO `account_active_rate` VALUES ('1282', '25', '1', '49', '0', 'oushinanshen', '1506055758877');
INSERT INTO `account_active_rate` VALUES ('1283', '26', '1', '49', '0', 'wxx899999', '1506055761254');
INSERT INTO `account_active_rate` VALUES ('1284', '27', '1', '49', '0', '1464975293', '1506055761254');
INSERT INTO `account_active_rate` VALUES ('1285', '29', '1', '49', '0', 'Bear', '1506055761254');
INSERT INTO `account_active_rate` VALUES ('1286', '30', '1', '49', '0', 'zxx', '1506055761254');
INSERT INTO `account_active_rate` VALUES ('1287', '31', '1', '49', '0', 'hy123456', '1506055761254');
INSERT INTO `account_active_rate` VALUES ('1288', '32', '1', '49', '0', 'wl123', '1506055761254');
INSERT INTO `account_active_rate` VALUES ('1289', '33', '1', '49', '0', '鳯儿网店', '1506055761254');
INSERT INTO `account_active_rate` VALUES ('1290', '34', '1', '49', '0', 'ruiruima', '1506055761254');
INSERT INTO `account_active_rate` VALUES ('1291', '35', '1', '49', '0', '944581678', '1506055761254');
INSERT INTO `account_active_rate` VALUES ('1292', '36', '1', '49', '0', '2069959168', '1506055761254');
INSERT INTO `account_active_rate` VALUES ('1293', '37', '1', '49', '0', '570156062', '1506055763013');
INSERT INTO `account_active_rate` VALUES ('1294', '38', '1', '49', '0', '770733914', '1506055763013');
INSERT INTO `account_active_rate` VALUES ('1295', '39', '1', '49', '0', '5257', '1506055763013');
INSERT INTO `account_active_rate` VALUES ('1296', '40', '1', '49', '0', '18734158108', '1506055763013');
INSERT INTO `account_active_rate` VALUES ('1297', '41', '1', '49', '0', 'xhq1347574865', '1506055763013');
INSERT INTO `account_active_rate` VALUES ('1298', '42', '1', '49', '0', 'Chen', '1506055763013');
INSERT INTO `account_active_rate` VALUES ('1299', '43', '1', '49', '0', 'qq130496', '1506055763013');
INSERT INTO `account_active_rate` VALUES ('1300', '44', '1', '49', '0', 'kevinchow', '1506055763013');
INSERT INTO `account_active_rate` VALUES ('1301', '45', '1', '49', '0', '17346544413', '1506055763013');
INSERT INTO `account_active_rate` VALUES ('1302', '46', '1', '49', '0', '2480199685', '1506055763013');
INSERT INTO `account_active_rate` VALUES ('1303', '47', '1', '49', '0', 'jim145', '1506055764995');
INSERT INTO `account_active_rate` VALUES ('1304', '48', '1', '49', '0', 'bada', '1506055764995');
INSERT INTO `account_active_rate` VALUES ('1305', '50', '1', '49', '0', '109', '1506055764995');
INSERT INTO `account_active_rate` VALUES ('1306', '51', '1', '49', '0', '119', '1506055764995');
INSERT INTO `account_active_rate` VALUES ('1307', '52', '1', '49', '0', 'gigi77', '1506055764995');
INSERT INTO `account_active_rate` VALUES ('1308', '53', '1', '49', '0', 'gigi777', '1506055764995');
INSERT INTO `account_active_rate` VALUES ('1309', '55', '1', '49', '0', '111111', '1506055764995');
INSERT INTO `account_active_rate` VALUES ('1310', '56', '1', '49', '0', 'dada', '1506055764995');
INSERT INTO `account_active_rate` VALUES ('1311', '57', '1', '49', '0', '源肥呀', '1506055764995');
INSERT INTO `account_active_rate` VALUES ('1312', '58', '1', '49', '0', '764388753', '1506055764995');
INSERT INTO `account_active_rate` VALUES ('1313', '59', '1', '49', '0', '815555213', '1506055767141');
INSERT INTO `account_active_rate` VALUES ('1314', '61', '1', '49', '0', '无厘头', '1506055767141');
INSERT INTO `account_active_rate` VALUES ('1315', '62', '1', '49', '0', '2630832822', '1506055767141');
INSERT INTO `account_active_rate` VALUES ('1316', '63', '48', '50', '0', '15754715147', '1506065689686');
INSERT INTO `account_active_rate` VALUES ('1317', '63', '48', '51', '0', '15754715147', '1506065701257');
INSERT INTO `account_active_rate` VALUES ('1318', '63', '48', '52', '0', '15754715147', '1506065709717');
INSERT INTO `account_active_rate` VALUES ('1319', '63', '48', '53', '0', '15754715147', '1506065742733');
INSERT INTO `account_active_rate` VALUES ('1320', '63', '48', '54', '0', '15754715147', '1506065749393');
INSERT INTO `account_active_rate` VALUES ('1321', '63', '48', '55', '0', '15754715147', '1506065757354');
INSERT INTO `account_active_rate` VALUES ('1322', '63', '48', '56', '0', '15754715147', '1506065763558');
INSERT INTO `account_active_rate` VALUES ('1323', '63', '48', '57', '0', '15754715147', '1506065772197');
INSERT INTO `account_active_rate` VALUES ('1324', '63', '48', '58', '0', '15754715147', '1506065778609');
INSERT INTO `account_active_rate` VALUES ('1325', '63', '48', '59', '0', '15754715147', '1506065785353');
INSERT INTO `account_active_rate` VALUES ('1326', '4', '1', '60', '0', 'wzkj', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1327', '5', '1', '60', '0', '冰河', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1328', '6', '1', '60', '0', 'jiafeng', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1329', '7', '1', '60', '0', 'l474705958', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1330', '8', '1', '60', '0', '184066643', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1331', '9', '1', '60', '0', '2369412', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1332', '10', '1', '60', '0', 'hy123', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1333', '11', '1', '60', '0', 'zishu', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1334', '12', '1', '60', '0', 'tianjing', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1335', '13', '1', '60', '0', 'zqy95178250', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1336', '14', '1', '60', '0', 'QQ574912927', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1337', '15', '1', '60', '0', '1579599827', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1338', '17', '1', '60', '0', '789', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1339', '18', '1', '60', '0', '112', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1340', '20', '1', '60', '0', 'b2218776', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1341', '21', '1', '60', '0', '13771547176', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1342', '22', '1', '60', '0', '1', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1343', '23', '1', '60', '0', '小aq', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1344', '24', '1', '60', '0', '15914897978', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1345', '25', '1', '60', '0', 'oushinanshen', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1346', '26', '1', '60', '0', 'wxx899999', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1347', '27', '1', '60', '0', '1464975293', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1348', '29', '1', '60', '0', 'Bear', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1349', '30', '1', '60', '0', 'zxx', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1350', '31', '1', '60', '0', 'hy123456', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1351', '32', '1', '60', '0', 'wl123', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1352', '33', '1', '60', '0', '鳯儿网店', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1353', '34', '1', '60', '0', 'ruiruima', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1354', '35', '1', '60', '0', '944581678', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1355', '36', '1', '60', '0', '2069959168', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1356', '37', '1', '60', '0', '570156062', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1357', '38', '1', '60', '0', '770733914', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1358', '39', '1', '60', '0', '5257', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1359', '40', '1', '60', '0', '18734158108', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1360', '41', '1', '60', '0', 'xhq1347574865', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1361', '42', '1', '60', '0', 'Chen', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1362', '43', '1', '60', '0', 'qq130496', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1363', '44', '1', '60', '0', 'kevinchow', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1364', '45', '1', '60', '0', '17346544413', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1365', '46', '1', '60', '0', '2480199685', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1366', '47', '1', '60', '0', 'jim145', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1367', '48', '1', '60', '0', 'bada', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1368', '49', '1', '60', '0', '罗大大', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1369', '50', '1', '60', '0', '109', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1370', '51', '1', '60', '0', '119', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1371', '52', '1', '60', '0', 'gigi77', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1372', '53', '1', '60', '0', 'gigi777', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1373', '55', '1', '60', '0', '111111', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1374', '56', '1', '60', '0', 'dada', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1375', '57', '1', '60', '0', '源肥呀', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1376', '58', '1', '60', '0', '764388753', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1377', '59', '1', '60', '0', '815555213', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1378', '61', '1', '60', '0', '无厘头', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1379', '62', '1', '60', '0', '2630832822', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1380', '64', '1', '60', '0', '850618', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1381', '66', '1', '60', '0', '18706732390', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1382', '64', '1', '42', '0', '850618', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1383', '66', '1', '42', '0', '18706732390', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1384', '58', '1', '41', '0', '764388753', '1506087809969');
INSERT INTO `account_active_rate` VALUES ('1385', '59', '1', '41', '0', '815555213', '1506087809969');
INSERT INTO `account_active_rate` VALUES ('1386', '61', '1', '41', '0', '无厘头', '1506087809969');
INSERT INTO `account_active_rate` VALUES ('1387', '62', '1', '41', '0', '2630832822', '1506087809969');
INSERT INTO `account_active_rate` VALUES ('1388', '64', '1', '41', '0', '850618', '1506087809969');
INSERT INTO `account_active_rate` VALUES ('1389', '66', '1', '41', '0', '18706732390', '1506087809969');
INSERT INTO `account_active_rate` VALUES ('1390', '64', '1', '40', '0', '850618', '1506087821641');
INSERT INTO `account_active_rate` VALUES ('1391', '66', '1', '40', '0', '18706732390', '1506087821641');
INSERT INTO `account_active_rate` VALUES ('1392', '64', '1', '39', '0', '850618', '1506087835540');
INSERT INTO `account_active_rate` VALUES ('1393', '66', '1', '39', '0', '18706732390', '1506087835540');
INSERT INTO `account_active_rate` VALUES ('1394', '4', '1', '49', '0', 'wzkj', '1506087849918');
INSERT INTO `account_active_rate` VALUES ('1395', '5', '1', '49', '0', '冰河', '1506087849918');
INSERT INTO `account_active_rate` VALUES ('1396', '6', '1', '49', '0', 'jiafeng', '1506087849918');
INSERT INTO `account_active_rate` VALUES ('1397', '7', '1', '49', '0', 'l474705958', '1506087849918');
INSERT INTO `account_active_rate` VALUES ('1398', '8', '1', '49', '0', '184066643', '1506087849918');
INSERT INTO `account_active_rate` VALUES ('1399', '9', '1', '49', '0', '2369412', '1506087849918');
INSERT INTO `account_active_rate` VALUES ('1400', '10', '1', '49', '0', 'hy123', '1506087849918');
INSERT INTO `account_active_rate` VALUES ('1401', '11', '1', '49', '0', 'zishu', '1506087849918');
INSERT INTO `account_active_rate` VALUES ('1402', '12', '1', '49', '0', 'tianjing', '1506087849918');
INSERT INTO `account_active_rate` VALUES ('1403', '13', '1', '49', '0', 'zqy95178250', '1506087849918');
INSERT INTO `account_active_rate` VALUES ('1404', '64', '1', '49', '0', '850618', '1506087851867');
INSERT INTO `account_active_rate` VALUES ('1405', '66', '1', '49', '0', '18706732390', '1506087851867');
INSERT INTO `account_active_rate` VALUES ('1406', '61', '1', '36', '1', '无厘头', '1506087865059');
INSERT INTO `account_active_rate` VALUES ('1407', '62', '1', '36', '1', '2630832822', '1506087865059');
INSERT INTO `account_active_rate` VALUES ('1408', '64', '1', '36', '1', '850618', '1506087865059');
INSERT INTO `account_active_rate` VALUES ('1409', '66', '1', '36', '1', '18706732390', '1506087865059');
INSERT INTO `account_active_rate` VALUES ('1410', '64', '1', '29', '0', '850618', '1506087877972');
INSERT INTO `account_active_rate` VALUES ('1411', '66', '1', '29', '0', '18706732390', '1506087877972');
INSERT INTO `account_active_rate` VALUES ('1412', '64', '1', '30', '0', '850618', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('1413', '66', '1', '30', '0', '18706732390', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('1414', '64', '1', '26', '0', '850618', '1506087899750');
INSERT INTO `account_active_rate` VALUES ('1415', '66', '1', '26', '0', '18706732390', '1506087899750');
INSERT INTO `account_active_rate` VALUES ('1416', '2', '1', '60', '1', '123', '1507898297091');
INSERT INTO `account_active_rate` VALUES ('1417', '67', '1', '60', '0', '灰灰小店', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1418', '68', '1', '60', '0', 'adidaszxc', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1419', '69', '1', '60', '0', 'asdfghjkl', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1420', '70', '1', '60', '0', '15111201915', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1421', '71', '1', '60', '0', '1550471939', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1422', '72', '1', '60', '0', '3138108592', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1423', '73', '1', '60', '0', 'Zippo1995', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1424', '74', '1', '60', '0', '3330118825', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1425', '75', '1', '60', '0', '315061813', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1426', '67', '1', '41', '0', '灰灰小店', '1506151958613');
INSERT INTO `account_active_rate` VALUES ('1427', '68', '1', '41', '0', 'adidaszxc', '1506151958613');
INSERT INTO `account_active_rate` VALUES ('1428', '69', '1', '41', '0', 'asdfghjkl', '1506151958613');
INSERT INTO `account_active_rate` VALUES ('1429', '70', '1', '41', '0', '15111201915', '1506151958613');
INSERT INTO `account_active_rate` VALUES ('1430', '71', '1', '41', '0', '1550471939', '1506151958613');
INSERT INTO `account_active_rate` VALUES ('1431', '72', '1', '41', '0', '3138108592', '1506151958613');
INSERT INTO `account_active_rate` VALUES ('1432', '73', '1', '41', '0', 'Zippo1995', '1506151958613');
INSERT INTO `account_active_rate` VALUES ('1433', '74', '1', '41', '0', '3330118825', '1506151958613');
INSERT INTO `account_active_rate` VALUES ('1434', '75', '1', '41', '0', '315061813', '1506151958613');
INSERT INTO `account_active_rate` VALUES ('1435', '67', '1', '42', '0', '灰灰小店', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1436', '68', '1', '42', '0', 'adidaszxc', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1437', '69', '1', '42', '0', 'asdfghjkl', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1438', '70', '1', '42', '0', '15111201915', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1439', '71', '1', '42', '0', '1550471939', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1440', '72', '1', '42', '0', '3138108592', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1441', '73', '1', '42', '0', 'Zippo1995', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1442', '74', '1', '42', '0', '3330118825', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1443', '75', '1', '42', '0', '315061813', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1444', '67', '1', '40', '0', '灰灰小店', '1506151984507');
INSERT INTO `account_active_rate` VALUES ('1445', '68', '1', '40', '0', 'adidaszxc', '1506151984507');
INSERT INTO `account_active_rate` VALUES ('1446', '69', '1', '40', '0', 'asdfghjkl', '1506151984507');
INSERT INTO `account_active_rate` VALUES ('1447', '70', '1', '40', '0', '15111201915', '1506151984507');
INSERT INTO `account_active_rate` VALUES ('1448', '71', '1', '40', '0', '1550471939', '1506151984507');
INSERT INTO `account_active_rate` VALUES ('1449', '72', '1', '40', '0', '3138108592', '1506151984507');
INSERT INTO `account_active_rate` VALUES ('1450', '73', '1', '40', '0', 'Zippo1995', '1506151984507');
INSERT INTO `account_active_rate` VALUES ('1451', '74', '1', '40', '0', '3330118825', '1506151984507');
INSERT INTO `account_active_rate` VALUES ('1452', '75', '1', '40', '0', '315061813', '1506151984507');
INSERT INTO `account_active_rate` VALUES ('1453', '67', '1', '39', '0', '灰灰小店', '1506152042473');
INSERT INTO `account_active_rate` VALUES ('1454', '68', '1', '39', '0', 'adidaszxc', '1506152042473');
INSERT INTO `account_active_rate` VALUES ('1455', '69', '1', '39', '0', 'asdfghjkl', '1506152042473');
INSERT INTO `account_active_rate` VALUES ('1456', '70', '1', '39', '0', '15111201915', '1506152042473');
INSERT INTO `account_active_rate` VALUES ('1457', '71', '1', '39', '0', '1550471939', '1506152042473');
INSERT INTO `account_active_rate` VALUES ('1458', '72', '1', '39', '0', '3138108592', '1506152042473');
INSERT INTO `account_active_rate` VALUES ('1459', '73', '1', '39', '0', 'Zippo1995', '1506152042473');
INSERT INTO `account_active_rate` VALUES ('1460', '74', '1', '39', '0', '3330118825', '1506152042473');
INSERT INTO `account_active_rate` VALUES ('1461', '75', '1', '39', '0', '315061813', '1506152042473');
INSERT INTO `account_active_rate` VALUES ('1462', '67', '1', '36', '1', '灰灰小店', '1506152054780');
INSERT INTO `account_active_rate` VALUES ('1463', '68', '1', '36', '1', 'adidaszxc', '1506152054780');
INSERT INTO `account_active_rate` VALUES ('1464', '69', '1', '36', '1', 'asdfghjkl', '1506152054780');
INSERT INTO `account_active_rate` VALUES ('1465', '70', '1', '36', '1', '15111201915', '1506152054780');
INSERT INTO `account_active_rate` VALUES ('1466', '71', '1', '36', '1', '1550471939', '1506152054780');
INSERT INTO `account_active_rate` VALUES ('1467', '72', '1', '36', '1', '3138108592', '1506152054780');
INSERT INTO `account_active_rate` VALUES ('1468', '73', '1', '36', '1', 'Zippo1995', '1506152054780');
INSERT INTO `account_active_rate` VALUES ('1469', '74', '1', '36', '1', '3330118825', '1506152054780');
INSERT INTO `account_active_rate` VALUES ('1470', '75', '1', '36', '1', '315061813', '1506152054780');
INSERT INTO `account_active_rate` VALUES ('1471', '67', '1', '30', '0', '灰灰小店', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('1472', '68', '1', '30', '0', 'adidaszxc', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('1473', '69', '1', '30', '0', 'asdfghjkl', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('1474', '70', '1', '30', '0', '15111201915', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('1475', '71', '1', '30', '0', '1550471939', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('1476', '72', '1', '30', '0', '3138108592', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('1477', '73', '1', '30', '0', 'Zippo1995', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('1478', '74', '1', '30', '0', '3330118825', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('1479', '75', '1', '30', '0', '315061813', '1507543201024');
INSERT INTO `account_active_rate` VALUES ('1480', '67', '1', '26', '0', '灰灰小店', '1506152074367');
INSERT INTO `account_active_rate` VALUES ('1481', '68', '1', '26', '0', 'adidaszxc', '1506152074367');
INSERT INTO `account_active_rate` VALUES ('1482', '69', '1', '26', '0', 'asdfghjkl', '1506152074367');
INSERT INTO `account_active_rate` VALUES ('1483', '70', '1', '26', '0', '15111201915', '1506152074367');
INSERT INTO `account_active_rate` VALUES ('1484', '71', '1', '26', '0', '1550471939', '1506152074367');
INSERT INTO `account_active_rate` VALUES ('1485', '72', '1', '26', '0', '3138108592', '1506152074367');
INSERT INTO `account_active_rate` VALUES ('1486', '73', '1', '26', '0', 'Zippo1995', '1506152074367');
INSERT INTO `account_active_rate` VALUES ('1487', '74', '1', '26', '0', '3330118825', '1506152074367');
INSERT INTO `account_active_rate` VALUES ('1488', '75', '1', '26', '0', '315061813', '1506152074367');
INSERT INTO `account_active_rate` VALUES ('1624', '76', '1', '41', '0', 'AOK', '1506154831413');
INSERT INTO `account_active_rate` VALUES ('1625', '77', '1', '41', '0', '李勇', '1506154831413');
INSERT INTO `account_active_rate` VALUES ('1626', '78', '1', '41', '0', 'boca', '1506154831413');
INSERT INTO `account_active_rate` VALUES ('1627', '79', '1', '41', '0', '15735083175', '1506154831413');
INSERT INTO `account_active_rate` VALUES ('1628', '76', '1', '60', '0', 'AOK', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1629', '77', '1', '60', '0', '李勇', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1630', '78', '1', '60', '0', 'boca', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1631', '79', '1', '60', '0', '15735083175', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1632', '4', '1', '63', '0', 'wzkj', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1633', '5', '1', '63', '0', '冰河', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1634', '6', '1', '63', '0', 'jiafeng', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1635', '7', '1', '63', '0', 'l474705958', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1636', '8', '1', '63', '0', '184066643', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1637', '9', '1', '63', '0', '2369412', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1638', '10', '1', '63', '0', 'hy123', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1639', '11', '1', '63', '0', 'zishu', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1640', '12', '1', '63', '0', 'tianjing', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1641', '13', '1', '63', '0', 'zqy95178250', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1642', '14', '1', '63', '0', 'QQ574912927', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1643', '15', '1', '63', '0', '1579599827', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1644', '17', '1', '63', '0', '789', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1645', '18', '1', '63', '0', '112', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1646', '20', '1', '63', '0', 'b2218776', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1647', '21', '1', '63', '0', '13771547176', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1648', '22', '1', '63', '0', '1', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1649', '23', '1', '63', '0', '小aq', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1650', '24', '1', '63', '0', '15914897978', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1651', '25', '1', '63', '0', 'oushinanshen', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1652', '26', '1', '63', '0', 'wxx899999', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1653', '27', '1', '63', '0', '1464975293', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1654', '29', '1', '63', '0', 'Bear', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1655', '30', '1', '63', '0', 'zxx', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1656', '31', '1', '63', '0', 'hy123456', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1657', '32', '1', '63', '0', 'wl123', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1658', '33', '1', '63', '0', '鳯儿网店', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1659', '34', '1', '63', '0', 'ruiruima', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1660', '35', '1', '63', '0', '944581678', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1661', '36', '1', '63', '0', '2069959168', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1662', '37', '1', '63', '0', '570156062', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1663', '38', '1', '63', '0', '770733914', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1664', '39', '1', '63', '0', '5257', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1665', '40', '1', '63', '0', '18734158108', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1666', '41', '1', '63', '0', 'xhq1347574865', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1667', '42', '1', '63', '0', 'Chen', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1668', '43', '1', '63', '0', 'qq130496', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1669', '44', '1', '63', '0', 'kevinchow', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1670', '45', '1', '63', '0', '17346544413', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1671', '46', '1', '63', '0', '2480199685', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1672', '47', '1', '63', '0', 'jim145', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1673', '48', '1', '63', '0', 'bada', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1674', '49', '1', '63', '0', '罗大大', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1675', '50', '1', '63', '0', '109', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1676', '51', '1', '63', '0', '119', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1677', '52', '1', '63', '0', 'gigi77', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1678', '53', '1', '63', '0', 'gigi777', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1679', '55', '1', '63', '0', '111111', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1680', '56', '1', '63', '0', 'dada', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1681', '57', '1', '63', '0', '源肥呀', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1682', '58', '1', '63', '0', '764388753', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1683', '59', '1', '63', '0', '815555213', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1684', '61', '1', '63', '0', '无厘头', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1685', '62', '1', '63', '0', '2630832822', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1686', '64', '1', '63', '0', '850618', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1687', '66', '1', '63', '0', '18706732390', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1688', '67', '1', '63', '0', '灰灰小店', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1689', '68', '1', '63', '0', 'adidaszxc', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1690', '69', '1', '63', '0', 'asdfghjkl', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1691', '70', '1', '63', '0', '15111201915', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1692', '71', '1', '63', '0', '1550471939', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1693', '72', '1', '63', '0', '3138108592', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1694', '73', '1', '63', '0', 'Zippo1995', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1695', '74', '1', '63', '0', '3330118825', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1696', '75', '1', '63', '0', '315061813', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1697', '76', '1', '63', '0', 'AOK', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1698', '77', '1', '63', '0', '李勇', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1699', '78', '1', '63', '0', 'boca', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1700', '79', '1', '63', '0', '15735083175', '1506161678928');
INSERT INTO `account_active_rate` VALUES ('1701', '4', '1', '64', '0', 'wzkj', '1506156473151');
INSERT INTO `account_active_rate` VALUES ('1702', '5', '1', '64', '0', '冰河', '1506156473151');
INSERT INTO `account_active_rate` VALUES ('1703', '6', '1', '64', '0', 'jiafeng', '1506156473151');
INSERT INTO `account_active_rate` VALUES ('1704', '7', '1', '64', '0', 'l474705958', '1506156473151');
INSERT INTO `account_active_rate` VALUES ('1705', '8', '1', '64', '0', '184066643', '1506156473151');
INSERT INTO `account_active_rate` VALUES ('1706', '9', '1', '64', '0', '2369412', '1506156473151');
INSERT INTO `account_active_rate` VALUES ('1707', '10', '1', '64', '0', 'hy123', '1506156473151');
INSERT INTO `account_active_rate` VALUES ('1708', '11', '1', '64', '0', 'zishu', '1506156473151');
INSERT INTO `account_active_rate` VALUES ('1709', '12', '1', '64', '0', 'tianjing', '1506156473151');
INSERT INTO `account_active_rate` VALUES ('1710', '13', '1', '64', '0', 'zqy95178250', '1506156473151');
INSERT INTO `account_active_rate` VALUES ('1711', '14', '1', '64', '0', 'QQ574912927', '1506156474853');
INSERT INTO `account_active_rate` VALUES ('1712', '15', '1', '64', '0', '1579599827', '1506156474853');
INSERT INTO `account_active_rate` VALUES ('1713', '17', '1', '64', '0', '789', '1506156474853');
INSERT INTO `account_active_rate` VALUES ('1714', '18', '1', '64', '0', '112', '1506156474853');
INSERT INTO `account_active_rate` VALUES ('1715', '20', '1', '64', '0', 'b2218776', '1506156474853');
INSERT INTO `account_active_rate` VALUES ('1716', '21', '1', '64', '0', '13771547176', '1506156474853');
INSERT INTO `account_active_rate` VALUES ('1717', '22', '1', '64', '0', '1', '1506156474853');
INSERT INTO `account_active_rate` VALUES ('1718', '23', '1', '64', '0', '小aq', '1506156474853');
INSERT INTO `account_active_rate` VALUES ('1719', '24', '1', '64', '0', '15914897978', '1506156474853');
INSERT INTO `account_active_rate` VALUES ('1720', '25', '1', '64', '0', 'oushinanshen', '1506156474854');
INSERT INTO `account_active_rate` VALUES ('1721', '26', '1', '64', '0', 'wxx899999', '1506156476604');
INSERT INTO `account_active_rate` VALUES ('1722', '27', '1', '64', '0', '1464975293', '1506156476604');
INSERT INTO `account_active_rate` VALUES ('1723', '29', '1', '64', '0', 'Bear', '1506156476604');
INSERT INTO `account_active_rate` VALUES ('1724', '30', '1', '64', '0', 'zxx', '1506156476604');
INSERT INTO `account_active_rate` VALUES ('1725', '31', '1', '64', '0', 'hy123456', '1506156476604');
INSERT INTO `account_active_rate` VALUES ('1726', '32', '1', '64', '0', 'wl123', '1506156476605');
INSERT INTO `account_active_rate` VALUES ('1727', '33', '1', '64', '0', '鳯儿网店', '1506156476605');
INSERT INTO `account_active_rate` VALUES ('1728', '34', '1', '64', '0', 'ruiruima', '1506156476605');
INSERT INTO `account_active_rate` VALUES ('1729', '35', '1', '64', '0', '944581678', '1506156476605');
INSERT INTO `account_active_rate` VALUES ('1730', '36', '1', '64', '0', '2069959168', '1506156476605');
INSERT INTO `account_active_rate` VALUES ('1731', '37', '1', '64', '0', '570156062', '1506156478801');
INSERT INTO `account_active_rate` VALUES ('1732', '38', '1', '64', '0', '770733914', '1506156478801');
INSERT INTO `account_active_rate` VALUES ('1733', '39', '1', '64', '0', '5257', '1506156478801');
INSERT INTO `account_active_rate` VALUES ('1734', '40', '1', '64', '0', '18734158108', '1506156478801');
INSERT INTO `account_active_rate` VALUES ('1735', '41', '1', '64', '0', 'xhq1347574865', '1506156478801');
INSERT INTO `account_active_rate` VALUES ('1736', '42', '1', '64', '0', 'Chen', '1506156478801');
INSERT INTO `account_active_rate` VALUES ('1737', '43', '1', '64', '0', 'qq130496', '1506156478801');
INSERT INTO `account_active_rate` VALUES ('1738', '44', '1', '64', '0', 'kevinchow', '1506156478801');
INSERT INTO `account_active_rate` VALUES ('1739', '45', '1', '64', '0', '17346544413', '1506156478801');
INSERT INTO `account_active_rate` VALUES ('1740', '46', '1', '64', '0', '2480199685', '1506156478801');
INSERT INTO `account_active_rate` VALUES ('1741', '47', '1', '64', '0', 'jim145', '1506156481079');
INSERT INTO `account_active_rate` VALUES ('1742', '48', '1', '64', '0', 'bada', '1506156481079');
INSERT INTO `account_active_rate` VALUES ('1743', '49', '1', '64', '0', '罗大大', '1506156481079');
INSERT INTO `account_active_rate` VALUES ('1744', '50', '1', '64', '0', '109', '1506156481079');
INSERT INTO `account_active_rate` VALUES ('1745', '51', '1', '64', '0', '119', '1506156481079');
INSERT INTO `account_active_rate` VALUES ('1746', '52', '1', '64', '0', 'gigi77', '1506156481079');
INSERT INTO `account_active_rate` VALUES ('1747', '53', '1', '64', '0', 'gigi777', '1506156481079');
INSERT INTO `account_active_rate` VALUES ('1748', '55', '1', '64', '0', '111111', '1506156481079');
INSERT INTO `account_active_rate` VALUES ('1749', '56', '1', '64', '0', 'dada', '1506156481079');
INSERT INTO `account_active_rate` VALUES ('1750', '57', '1', '64', '0', '源肥呀', '1506156481079');
INSERT INTO `account_active_rate` VALUES ('1751', '58', '1', '64', '0', '764388753', '1506156482759');
INSERT INTO `account_active_rate` VALUES ('1752', '59', '1', '64', '0', '815555213', '1506156482759');
INSERT INTO `account_active_rate` VALUES ('1753', '61', '1', '64', '0', '无厘头', '1506156482759');
INSERT INTO `account_active_rate` VALUES ('1754', '62', '1', '64', '0', '2630832822', '1506156482759');
INSERT INTO `account_active_rate` VALUES ('1755', '64', '1', '64', '0', '850618', '1506156482759');
INSERT INTO `account_active_rate` VALUES ('1756', '66', '1', '64', '0', '18706732390', '1506156482759');
INSERT INTO `account_active_rate` VALUES ('1757', '67', '1', '64', '0', '灰灰小店', '1506156482759');
INSERT INTO `account_active_rate` VALUES ('1758', '68', '1', '64', '0', 'adidaszxc', '1506156482759');
INSERT INTO `account_active_rate` VALUES ('1759', '69', '1', '64', '0', 'asdfghjkl', '1506156482759');
INSERT INTO `account_active_rate` VALUES ('1760', '70', '1', '64', '0', '15111201915', '1506156482759');
INSERT INTO `account_active_rate` VALUES ('1761', '71', '1', '64', '0', '1550471939', '1506156484855');
INSERT INTO `account_active_rate` VALUES ('1762', '72', '1', '64', '0', '3138108592', '1506156484855');
INSERT INTO `account_active_rate` VALUES ('1763', '73', '1', '64', '0', 'Zippo1995', '1506156484855');
INSERT INTO `account_active_rate` VALUES ('1764', '74', '1', '64', '0', '3330118825', '1506156484855');
INSERT INTO `account_active_rate` VALUES ('1765', '75', '1', '64', '0', '315061813', '1506156484855');
INSERT INTO `account_active_rate` VALUES ('1766', '76', '1', '64', '0', 'AOK', '1506156484855');
INSERT INTO `account_active_rate` VALUES ('1767', '77', '1', '64', '0', '李勇', '1506156484855');
INSERT INTO `account_active_rate` VALUES ('1768', '78', '1', '64', '0', 'boca', '1506156484855');
INSERT INTO `account_active_rate` VALUES ('1769', '79', '1', '64', '0', '15735083175', '1506156484855');
INSERT INTO `account_active_rate` VALUES ('1770', null, null, null, '0', null, null);
INSERT INTO `account_active_rate` VALUES ('1771', null, null, null, '0', null, null);
INSERT INTO `account_active_rate` VALUES ('1772', null, null, null, '0', null, null);
INSERT INTO `account_active_rate` VALUES ('1773', '80', '1', '63', '0', '刘淮槟', '1506164698635');
INSERT INTO `account_active_rate` VALUES ('1774', '81', '1', '63', '0', 'shenyaolin', '1506164698635');
INSERT INTO `account_active_rate` VALUES ('1775', '82', '1', '63', '0', '1452395483', '1506164698635');
INSERT INTO `account_active_rate` VALUES ('1776', '83', '1', '63', '0', '1184164070', '1506164698635');
INSERT INTO `account_active_rate` VALUES ('1777', '80', '1', '64', '0', '刘淮槟', '1506305175764');
INSERT INTO `account_active_rate` VALUES ('1778', '81', '1', '64', '0', 'shenyaolin', '1506305175764');
INSERT INTO `account_active_rate` VALUES ('1779', '82', '1', '64', '0', '1452395483', '1506305175764');
INSERT INTO `account_active_rate` VALUES ('1780', '83', '1', '64', '0', '1184164070', '1506305175764');
INSERT INTO `account_active_rate` VALUES ('1781', '84', '1', '64', '0', '1782249351', '1506305175764');
INSERT INTO `account_active_rate` VALUES ('1782', '85', '1', '64', '0', '18291797284', '1506305175764');
INSERT INTO `account_active_rate` VALUES ('1783', '86', '1', '64', '0', '745530430', '1506305175764');
INSERT INTO `account_active_rate` VALUES ('1784', '87', '1', '64', '0', '1648327136', '1506305175764');
INSERT INTO `account_active_rate` VALUES ('1785', '80', '1', '60', '0', '刘淮槟', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1786', '81', '1', '60', '0', 'shenyaolin', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1787', '82', '1', '60', '0', '1452395483', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1788', '83', '1', '60', '0', '1184164070', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1789', '84', '1', '60', '0', '1782249351', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1790', '85', '1', '60', '0', '18291797284', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1791', '86', '1', '60', '0', '745530430', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1792', '87', '1', '60', '0', '1648327136', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('1793', '4', '1', '68', '0', 'wzkj', '1506312909639');
INSERT INTO `account_active_rate` VALUES ('1794', '5', '1', '68', '0', '冰河', '1506312909639');
INSERT INTO `account_active_rate` VALUES ('1795', '6', '1', '68', '0', 'jiafeng', '1506312909639');
INSERT INTO `account_active_rate` VALUES ('1796', '7', '1', '68', '0', 'l474705958', '1506312909639');
INSERT INTO `account_active_rate` VALUES ('1797', '8', '1', '68', '0', '184066643', '1506312909639');
INSERT INTO `account_active_rate` VALUES ('1798', '9', '1', '68', '0', '2369412', '1506312909639');
INSERT INTO `account_active_rate` VALUES ('1799', '10', '1', '68', '0', 'hy123', '1506312909639');
INSERT INTO `account_active_rate` VALUES ('1800', '11', '1', '68', '0', 'zishu', '1506312909639');
INSERT INTO `account_active_rate` VALUES ('1801', '12', '1', '68', '0', 'tianjing', '1506312909639');
INSERT INTO `account_active_rate` VALUES ('1802', '13', '1', '68', '0', 'zqy95178250', '1506312909639');
INSERT INTO `account_active_rate` VALUES ('1803', '14', '1', '68', '0', 'QQ574912927', '1506312911505');
INSERT INTO `account_active_rate` VALUES ('1804', '15', '1', '68', '0', '1579599827', '1506312911505');
INSERT INTO `account_active_rate` VALUES ('1805', '17', '1', '68', '0', '789', '1506312911505');
INSERT INTO `account_active_rate` VALUES ('1806', '18', '1', '68', '0', '112', '1506312911505');
INSERT INTO `account_active_rate` VALUES ('1807', '20', '1', '68', '0', 'b2218776', '1506312911505');
INSERT INTO `account_active_rate` VALUES ('1808', '21', '1', '68', '0', '13771547176', '1506312911505');
INSERT INTO `account_active_rate` VALUES ('1809', '22', '1', '68', '0', '1', '1506312911505');
INSERT INTO `account_active_rate` VALUES ('1810', '23', '1', '68', '0', '小aq', '1506312911505');
INSERT INTO `account_active_rate` VALUES ('1811', '24', '1', '68', '0', '15914897978', '1506312911505');
INSERT INTO `account_active_rate` VALUES ('1812', '25', '1', '68', '0', 'oushinanshen', '1506312911505');
INSERT INTO `account_active_rate` VALUES ('1813', '26', '1', '68', '0', 'wxx899999', '1506312913163');
INSERT INTO `account_active_rate` VALUES ('1814', '27', '1', '68', '0', '1464975293', '1506312913163');
INSERT INTO `account_active_rate` VALUES ('1815', '29', '1', '68', '0', 'Bear', '1506312913163');
INSERT INTO `account_active_rate` VALUES ('1816', '30', '1', '68', '0', 'zxx', '1506312913163');
INSERT INTO `account_active_rate` VALUES ('1817', '31', '1', '68', '0', 'hy123456', '1506312913163');
INSERT INTO `account_active_rate` VALUES ('1818', '32', '1', '68', '0', 'wl123', '1506312913163');
INSERT INTO `account_active_rate` VALUES ('1819', '33', '1', '68', '0', '鳯儿网店', '1506312913163');
INSERT INTO `account_active_rate` VALUES ('1820', '34', '1', '68', '0', 'ruiruima', '1506312913163');
INSERT INTO `account_active_rate` VALUES ('1821', '35', '1', '68', '0', '944581678', '1506312913163');
INSERT INTO `account_active_rate` VALUES ('1822', '36', '1', '68', '0', '2069959168', '1506312913163');
INSERT INTO `account_active_rate` VALUES ('1823', '37', '1', '68', '0', '570156062', '1506312914777');
INSERT INTO `account_active_rate` VALUES ('1824', '38', '1', '68', '0', '770733914', '1506312914777');
INSERT INTO `account_active_rate` VALUES ('1825', '39', '1', '68', '0', '5257', '1506312914777');
INSERT INTO `account_active_rate` VALUES ('1826', '40', '1', '68', '0', '18734158108', '1506312914777');
INSERT INTO `account_active_rate` VALUES ('1827', '41', '1', '68', '0', 'xhq1347574865', '1506312914777');
INSERT INTO `account_active_rate` VALUES ('1828', '42', '1', '68', '0', 'Chen', '1506312914777');
INSERT INTO `account_active_rate` VALUES ('1829', '43', '1', '68', '0', 'qq130496', '1506312914777');
INSERT INTO `account_active_rate` VALUES ('1830', '44', '1', '68', '0', 'kevinchow', '1506312914777');
INSERT INTO `account_active_rate` VALUES ('1831', '45', '1', '68', '0', '17346544413', '1506312914777');
INSERT INTO `account_active_rate` VALUES ('1832', '46', '1', '68', '0', '2480199685', '1506312914777');
INSERT INTO `account_active_rate` VALUES ('1833', '47', '1', '68', '0', 'jim145', '1506312916744');
INSERT INTO `account_active_rate` VALUES ('1834', '48', '1', '68', '0', 'bada', '1506312916744');
INSERT INTO `account_active_rate` VALUES ('1835', '49', '1', '68', '0', '罗大大', '1506312916744');
INSERT INTO `account_active_rate` VALUES ('1836', '50', '1', '68', '0', '109', '1506312916744');
INSERT INTO `account_active_rate` VALUES ('1837', '51', '1', '68', '0', '119', '1506312916744');
INSERT INTO `account_active_rate` VALUES ('1838', '52', '1', '68', '0', 'gigi77', '1506312916744');
INSERT INTO `account_active_rate` VALUES ('1839', '53', '1', '68', '0', 'gigi777', '1506312916744');
INSERT INTO `account_active_rate` VALUES ('1840', '55', '1', '68', '0', '111111', '1506312916744');
INSERT INTO `account_active_rate` VALUES ('1841', '56', '1', '68', '0', 'dada', '1506312916744');
INSERT INTO `account_active_rate` VALUES ('1842', '57', '1', '68', '0', '源肥呀', '1506312916744');
INSERT INTO `account_active_rate` VALUES ('1843', '58', '1', '68', '0', '764388753', '1506312918220');
INSERT INTO `account_active_rate` VALUES ('1844', '59', '1', '68', '0', '815555213', '1506312918220');
INSERT INTO `account_active_rate` VALUES ('1845', '61', '1', '68', '0', '无厘头', '1506312918220');
INSERT INTO `account_active_rate` VALUES ('1846', '62', '1', '68', '0', '2630832822', '1506312918220');
INSERT INTO `account_active_rate` VALUES ('1847', '64', '1', '68', '0', '850618', '1506312918220');
INSERT INTO `account_active_rate` VALUES ('1848', '66', '1', '68', '0', '18706732390', '1506312918220');
INSERT INTO `account_active_rate` VALUES ('1849', '67', '1', '68', '0', '灰灰小店', '1506312918220');
INSERT INTO `account_active_rate` VALUES ('1850', '68', '1', '68', '0', 'adidaszxc', '1506312918220');
INSERT INTO `account_active_rate` VALUES ('1851', '69', '1', '68', '0', 'asdfghjkl', '1506312918220');
INSERT INTO `account_active_rate` VALUES ('1852', '70', '1', '68', '0', '15111201915', '1506312918220');
INSERT INTO `account_active_rate` VALUES ('1853', '71', '1', '68', '0', '1550471939', '1506312919918');
INSERT INTO `account_active_rate` VALUES ('1854', '72', '1', '68', '0', '3138108592', '1506312919918');
INSERT INTO `account_active_rate` VALUES ('1855', '73', '1', '68', '0', 'Zippo1995', '1506312919918');
INSERT INTO `account_active_rate` VALUES ('1856', '74', '1', '68', '0', '3330118825', '1506312919918');
INSERT INTO `account_active_rate` VALUES ('1857', '75', '1', '68', '0', '315061813', '1506312919918');
INSERT INTO `account_active_rate` VALUES ('1858', '76', '1', '68', '0', 'AOK', '1506312919918');
INSERT INTO `account_active_rate` VALUES ('1859', '77', '1', '68', '0', '李勇', '1506312919918');
INSERT INTO `account_active_rate` VALUES ('1860', '78', '1', '68', '0', 'boca', '1506312919918');
INSERT INTO `account_active_rate` VALUES ('1861', '79', '1', '68', '0', '15735083175', '1506312919918');
INSERT INTO `account_active_rate` VALUES ('1862', '80', '1', '68', '0', '刘淮槟', '1506312919918');
INSERT INTO `account_active_rate` VALUES ('1863', '81', '1', '68', '0', 'shenyaolin', '1506312922762');
INSERT INTO `account_active_rate` VALUES ('1864', '82', '1', '68', '0', '1452395483', '1506312922762');
INSERT INTO `account_active_rate` VALUES ('1865', '83', '1', '68', '0', '1184164070', '1506312922762');
INSERT INTO `account_active_rate` VALUES ('1866', '84', '1', '68', '0', '1782249351', '1506312922762');
INSERT INTO `account_active_rate` VALUES ('1867', '85', '1', '68', '0', '18291797284', '1506312922762');
INSERT INTO `account_active_rate` VALUES ('1868', '86', '1', '68', '0', '745530430', '1506312922762');
INSERT INTO `account_active_rate` VALUES ('1869', '87', '1', '68', '0', '1648327136', '1506312922762');
INSERT INTO `account_active_rate` VALUES ('1870', '76', '1', '42', '0', 'AOK', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1871', '77', '1', '42', '0', '李勇', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1872', '78', '1', '42', '0', 'boca', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1873', '79', '1', '42', '0', '15735083175', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1874', '80', '1', '42', '0', '刘淮槟', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1875', '81', '1', '42', '0', 'shenyaolin', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1876', '82', '1', '42', '0', '1452395483', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1877', '83', '1', '42', '0', '1184164070', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1878', '84', '1', '42', '0', '1782249351', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1879', '85', '1', '42', '0', '18291797284', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1880', '86', '1', '42', '0', '745530430', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1881', '87', '1', '42', '0', '1648327136', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1882', '88', '1', '42', '0', '15291739020', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('1883', '4', '1', '69', '0', 'wzkj', '1506413612655');
INSERT INTO `account_active_rate` VALUES ('1884', '5', '1', '69', '0', '冰河', '1506413612655');
INSERT INTO `account_active_rate` VALUES ('1885', '6', '1', '69', '0', 'jiafeng', '1506413612655');
INSERT INTO `account_active_rate` VALUES ('1886', '7', '1', '69', '0', 'l474705958', '1506413612655');
INSERT INTO `account_active_rate` VALUES ('1887', '8', '1', '69', '0', '184066643', '1506413612655');
INSERT INTO `account_active_rate` VALUES ('1888', '9', '1', '69', '0', '2369412', '1506413612655');
INSERT INTO `account_active_rate` VALUES ('1889', '10', '1', '69', '0', 'hy123', '1506413612655');
INSERT INTO `account_active_rate` VALUES ('1890', '11', '1', '69', '0', 'zishu', '1506413612655');
INSERT INTO `account_active_rate` VALUES ('1891', '12', '1', '69', '0', 'tianjing', '1506413612655');
INSERT INTO `account_active_rate` VALUES ('1892', '13', '1', '69', '0', 'zqy95178250', '1506413612655');
INSERT INTO `account_active_rate` VALUES ('1893', '14', '1', '69', '0', 'QQ574912927', '1506413614267');
INSERT INTO `account_active_rate` VALUES ('1894', '15', '1', '69', '0', '1579599827', '1506413614267');
INSERT INTO `account_active_rate` VALUES ('1895', '17', '1', '69', '0', '789', '1506413614267');
INSERT INTO `account_active_rate` VALUES ('1896', '18', '1', '69', '0', '112', '1506413614267');
INSERT INTO `account_active_rate` VALUES ('1897', '20', '1', '69', '0', 'b2218776', '1506413614267');
INSERT INTO `account_active_rate` VALUES ('1898', '21', '1', '69', '0', '13771547176', '1506413614267');
INSERT INTO `account_active_rate` VALUES ('1899', '22', '1', '69', '0', '1', '1506413614267');
INSERT INTO `account_active_rate` VALUES ('1900', '23', '1', '69', '0', '小aq', '1506413614267');
INSERT INTO `account_active_rate` VALUES ('1901', '24', '1', '69', '0', '15914897978', '1506413614267');
INSERT INTO `account_active_rate` VALUES ('1902', '25', '1', '69', '0', 'oushinanshen', '1506413614267');
INSERT INTO `account_active_rate` VALUES ('1903', '26', '1', '69', '0', 'wxx899999', '1506413615925');
INSERT INTO `account_active_rate` VALUES ('1904', '27', '1', '69', '0', '1464975293', '1506413615925');
INSERT INTO `account_active_rate` VALUES ('1905', '29', '1', '69', '0', 'Bear', '1506413615925');
INSERT INTO `account_active_rate` VALUES ('1906', '30', '1', '69', '0', 'zxx', '1506413615925');
INSERT INTO `account_active_rate` VALUES ('1907', '31', '1', '69', '0', 'hy123456', '1506413615925');
INSERT INTO `account_active_rate` VALUES ('1908', '32', '1', '69', '0', 'wl123', '1506413615925');
INSERT INTO `account_active_rate` VALUES ('1909', '33', '1', '69', '0', '鳯儿网店', '1506413615925');
INSERT INTO `account_active_rate` VALUES ('1910', '34', '1', '69', '0', 'ruiruima', '1506413615925');
INSERT INTO `account_active_rate` VALUES ('1911', '35', '1', '69', '0', '944581678', '1506413615925');
INSERT INTO `account_active_rate` VALUES ('1912', '36', '1', '69', '0', '2069959168', '1506413615925');
INSERT INTO `account_active_rate` VALUES ('1913', '37', '1', '69', '0', '570156062', '1506413617942');
INSERT INTO `account_active_rate` VALUES ('1914', '38', '1', '69', '0', '770733914', '1506413617942');
INSERT INTO `account_active_rate` VALUES ('1915', '39', '1', '69', '0', '5257', '1506413617942');
INSERT INTO `account_active_rate` VALUES ('1916', '40', '1', '69', '0', '18734158108', '1506413617942');
INSERT INTO `account_active_rate` VALUES ('1917', '41', '1', '69', '0', 'xhq1347574865', '1506413617942');
INSERT INTO `account_active_rate` VALUES ('1918', '42', '1', '69', '0', 'Chen', '1506413617942');
INSERT INTO `account_active_rate` VALUES ('1919', '43', '1', '69', '0', 'qq130496', '1506413617942');
INSERT INTO `account_active_rate` VALUES ('1920', '44', '1', '69', '0', 'kevinchow', '1506413617942');
INSERT INTO `account_active_rate` VALUES ('1921', '45', '1', '69', '0', '17346544413', '1506413617942');
INSERT INTO `account_active_rate` VALUES ('1922', '46', '1', '69', '0', '2480199685', '1506413617942');
INSERT INTO `account_active_rate` VALUES ('1923', '47', '1', '69', '0', 'jim145', '1506413619610');
INSERT INTO `account_active_rate` VALUES ('1924', '48', '1', '69', '0', 'bada', '1506413619610');
INSERT INTO `account_active_rate` VALUES ('1925', '49', '1', '69', '0', '罗大大', '1506413619610');
INSERT INTO `account_active_rate` VALUES ('1926', '50', '1', '69', '0', '109', '1506413619610');
INSERT INTO `account_active_rate` VALUES ('1927', '51', '1', '69', '0', '119', '1506413619610');
INSERT INTO `account_active_rate` VALUES ('1928', '52', '1', '69', '0', 'gigi77', '1506413619610');
INSERT INTO `account_active_rate` VALUES ('1929', '53', '1', '69', '0', 'gigi777', '1506413619610');
INSERT INTO `account_active_rate` VALUES ('1930', '55', '1', '69', '0', '111111', '1506413619610');
INSERT INTO `account_active_rate` VALUES ('1931', '56', '1', '69', '0', 'dada', '1506413619610');
INSERT INTO `account_active_rate` VALUES ('1932', '57', '1', '69', '0', '源肥呀', '1506413619610');
INSERT INTO `account_active_rate` VALUES ('1933', '58', '1', '69', '0', '764388753', '1506413621766');
INSERT INTO `account_active_rate` VALUES ('1934', '59', '1', '69', '0', '815555213', '1506413621766');
INSERT INTO `account_active_rate` VALUES ('1935', '61', '1', '69', '0', '无厘头', '1506413621766');
INSERT INTO `account_active_rate` VALUES ('1936', '62', '1', '69', '0', '2630832822', '1506413621766');
INSERT INTO `account_active_rate` VALUES ('1937', '64', '1', '69', '0', '850618', '1506413621766');
INSERT INTO `account_active_rate` VALUES ('1938', '66', '1', '69', '0', '18706732390', '1506413621766');
INSERT INTO `account_active_rate` VALUES ('1939', '67', '1', '69', '0', '灰灰小店', '1506413621766');
INSERT INTO `account_active_rate` VALUES ('1940', '68', '1', '69', '0', 'adidaszxc', '1506413621766');
INSERT INTO `account_active_rate` VALUES ('1941', '69', '1', '69', '0', 'asdfghjkl', '1506413621766');
INSERT INTO `account_active_rate` VALUES ('1942', '70', '1', '69', '0', '15111201915', '1506413621766');
INSERT INTO `account_active_rate` VALUES ('1943', '71', '1', '69', '0', '1550471939', '1506413624013');
INSERT INTO `account_active_rate` VALUES ('1944', '72', '1', '69', '0', '3138108592', '1506413624013');
INSERT INTO `account_active_rate` VALUES ('1945', '73', '1', '69', '0', 'Zippo1995', '1506413624013');
INSERT INTO `account_active_rate` VALUES ('1946', '74', '1', '69', '0', '3330118825', '1506413624013');
INSERT INTO `account_active_rate` VALUES ('1947', '75', '1', '69', '0', '315061813', '1506413624013');
INSERT INTO `account_active_rate` VALUES ('1948', '76', '1', '69', '0', 'AOK', '1506413624013');
INSERT INTO `account_active_rate` VALUES ('1949', '77', '1', '69', '0', '李勇', '1506413624013');
INSERT INTO `account_active_rate` VALUES ('1950', '78', '1', '69', '0', 'boca', '1506413624013');
INSERT INTO `account_active_rate` VALUES ('1951', '79', '1', '69', '0', '15735083175', '1506413624013');
INSERT INTO `account_active_rate` VALUES ('1952', '80', '1', '69', '0', '刘淮槟', '1506413624013');
INSERT INTO `account_active_rate` VALUES ('1953', '81', '1', '69', '0', 'shenyaolin', '1506413626259');
INSERT INTO `account_active_rate` VALUES ('1954', '82', '1', '69', '0', '1452395483', '1506413626259');
INSERT INTO `account_active_rate` VALUES ('1955', '83', '1', '69', '0', '1184164070', '1506413626259');
INSERT INTO `account_active_rate` VALUES ('1956', '84', '1', '69', '0', '1782249351', '1506413626259');
INSERT INTO `account_active_rate` VALUES ('1957', '85', '1', '69', '0', '18291797284', '1506413626259');
INSERT INTO `account_active_rate` VALUES ('1958', '86', '1', '69', '0', '745530430', '1506413626259');
INSERT INTO `account_active_rate` VALUES ('1959', '87', '1', '69', '0', '1648327136', '1506413626259');
INSERT INTO `account_active_rate` VALUES ('1960', '88', '1', '69', '0', '15291739020', '1506413626259');
INSERT INTO `account_active_rate` VALUES ('1961', '4', '1', '70', '0', 'wzkj', '1506414223601');
INSERT INTO `account_active_rate` VALUES ('1962', '5', '1', '70', '0', '冰河', '1506414223601');
INSERT INTO `account_active_rate` VALUES ('1963', '6', '1', '70', '0', 'jiafeng', '1506414223601');
INSERT INTO `account_active_rate` VALUES ('1964', '7', '1', '70', '0', 'l474705958', '1506414223601');
INSERT INTO `account_active_rate` VALUES ('1965', '8', '1', '70', '0', '184066643', '1506414223601');
INSERT INTO `account_active_rate` VALUES ('1966', '9', '1', '70', '0', '2369412', '1506414223601');
INSERT INTO `account_active_rate` VALUES ('1967', '10', '1', '70', '0', 'hy123', '1506414223601');
INSERT INTO `account_active_rate` VALUES ('1968', '11', '1', '70', '0', 'zishu', '1506414223601');
INSERT INTO `account_active_rate` VALUES ('1969', '12', '1', '70', '0', 'tianjing', '1506414223601');
INSERT INTO `account_active_rate` VALUES ('1970', '13', '1', '70', '0', 'zqy95178250', '1506414223601');
INSERT INTO `account_active_rate` VALUES ('1971', '14', '1', '70', '0', 'QQ574912927', '1506414225252');
INSERT INTO `account_active_rate` VALUES ('1972', '15', '1', '70', '0', '1579599827', '1506414225252');
INSERT INTO `account_active_rate` VALUES ('1973', '17', '1', '70', '0', '789', '1506414225252');
INSERT INTO `account_active_rate` VALUES ('1974', '18', '1', '70', '0', '112', '1506414225252');
INSERT INTO `account_active_rate` VALUES ('1975', '20', '1', '70', '0', 'b2218776', '1506414225252');
INSERT INTO `account_active_rate` VALUES ('1976', '21', '1', '70', '0', '13771547176', '1506414225252');
INSERT INTO `account_active_rate` VALUES ('1977', '22', '1', '70', '0', '1', '1506414225252');
INSERT INTO `account_active_rate` VALUES ('1978', '23', '1', '70', '0', '小aq', '1506414225252');
INSERT INTO `account_active_rate` VALUES ('1979', '24', '1', '70', '0', '15914897978', '1506414225252');
INSERT INTO `account_active_rate` VALUES ('1980', '25', '1', '70', '0', 'oushinanshen', '1506414225252');
INSERT INTO `account_active_rate` VALUES ('1981', '26', '1', '70', '0', 'wxx899999', '1506414227614');
INSERT INTO `account_active_rate` VALUES ('1982', '27', '1', '70', '0', '1464975293', '1506414227614');
INSERT INTO `account_active_rate` VALUES ('1983', '29', '1', '70', '0', 'Bear', '1506414227614');
INSERT INTO `account_active_rate` VALUES ('1984', '30', '1', '70', '0', 'zxx', '1506414227614');
INSERT INTO `account_active_rate` VALUES ('1985', '31', '1', '70', '0', 'hy123456', '1506414227614');
INSERT INTO `account_active_rate` VALUES ('1986', '32', '1', '70', '0', 'wl123', '1506414227614');
INSERT INTO `account_active_rate` VALUES ('1987', '33', '1', '70', '0', '鳯儿网店', '1506414227614');
INSERT INTO `account_active_rate` VALUES ('1988', '34', '1', '70', '0', 'ruiruima', '1506414227614');
INSERT INTO `account_active_rate` VALUES ('1989', '35', '1', '70', '0', '944581678', '1506414227614');
INSERT INTO `account_active_rate` VALUES ('1990', '36', '1', '70', '0', '2069959168', '1506414227614');
INSERT INTO `account_active_rate` VALUES ('1991', '37', '1', '70', '0', '570156062', '1506414229225');
INSERT INTO `account_active_rate` VALUES ('1992', '38', '1', '70', '0', '770733914', '1506414229225');
INSERT INTO `account_active_rate` VALUES ('1993', '39', '1', '70', '0', '5257', '1506414229225');
INSERT INTO `account_active_rate` VALUES ('1994', '40', '1', '70', '0', '18734158108', '1506414229225');
INSERT INTO `account_active_rate` VALUES ('1995', '41', '1', '70', '0', 'xhq1347574865', '1506414229225');
INSERT INTO `account_active_rate` VALUES ('1996', '42', '1', '70', '0', 'Chen', '1506414229225');
INSERT INTO `account_active_rate` VALUES ('1997', '43', '1', '70', '0', 'qq130496', '1506414229225');
INSERT INTO `account_active_rate` VALUES ('1998', '44', '1', '70', '0', 'kevinchow', '1506414229225');
INSERT INTO `account_active_rate` VALUES ('1999', '45', '1', '70', '0', '17346544413', '1506414229225');
INSERT INTO `account_active_rate` VALUES ('2000', '46', '1', '70', '0', '2480199685', '1506414229225');
INSERT INTO `account_active_rate` VALUES ('2001', '47', '1', '70', '0', 'jim145', '1506414230828');
INSERT INTO `account_active_rate` VALUES ('2002', '48', '1', '70', '0', 'bada', '1506414230828');
INSERT INTO `account_active_rate` VALUES ('2003', '49', '1', '70', '0', '罗大大', '1506414230828');
INSERT INTO `account_active_rate` VALUES ('2004', '50', '1', '70', '0', '109', '1506414230828');
INSERT INTO `account_active_rate` VALUES ('2005', '51', '1', '70', '0', '119', '1506414230828');
INSERT INTO `account_active_rate` VALUES ('2006', '52', '1', '70', '0', 'gigi77', '1506414230828');
INSERT INTO `account_active_rate` VALUES ('2007', '53', '1', '70', '0', 'gigi777', '1506414230828');
INSERT INTO `account_active_rate` VALUES ('2008', '55', '1', '70', '0', '111111', '1506414230828');
INSERT INTO `account_active_rate` VALUES ('2009', '56', '1', '70', '0', 'dada', '1506414230828');
INSERT INTO `account_active_rate` VALUES ('2010', '57', '1', '70', '0', '源肥呀', '1506414230828');
INSERT INTO `account_active_rate` VALUES ('2011', '58', '1', '70', '0', '764388753', '1506414232806');
INSERT INTO `account_active_rate` VALUES ('2012', '59', '1', '70', '0', '815555213', '1506414232806');
INSERT INTO `account_active_rate` VALUES ('2013', '61', '1', '70', '0', '无厘头', '1506414232806');
INSERT INTO `account_active_rate` VALUES ('2014', '62', '1', '70', '0', '2630832822', '1506414232806');
INSERT INTO `account_active_rate` VALUES ('2015', '64', '1', '70', '0', '850618', '1506414232806');
INSERT INTO `account_active_rate` VALUES ('2016', '66', '1', '70', '0', '18706732390', '1506414232806');
INSERT INTO `account_active_rate` VALUES ('2017', '67', '1', '70', '0', '灰灰小店', '1506414232806');
INSERT INTO `account_active_rate` VALUES ('2018', '68', '1', '70', '0', 'adidaszxc', '1506414232806');
INSERT INTO `account_active_rate` VALUES ('2019', '69', '1', '70', '0', 'asdfghjkl', '1506414232806');
INSERT INTO `account_active_rate` VALUES ('2020', '70', '1', '70', '0', '15111201915', '1506414232806');
INSERT INTO `account_active_rate` VALUES ('2021', '71', '1', '70', '0', '1550471939', '1506414235312');
INSERT INTO `account_active_rate` VALUES ('2022', '72', '1', '70', '0', '3138108592', '1506414235312');
INSERT INTO `account_active_rate` VALUES ('2023', '73', '1', '70', '0', 'Zippo1995', '1506414235312');
INSERT INTO `account_active_rate` VALUES ('2024', '74', '1', '70', '0', '3330118825', '1506414235312');
INSERT INTO `account_active_rate` VALUES ('2025', '75', '1', '70', '0', '315061813', '1506414235312');
INSERT INTO `account_active_rate` VALUES ('2026', '76', '1', '70', '0', 'AOK', '1506414235312');
INSERT INTO `account_active_rate` VALUES ('2027', '77', '1', '70', '0', '李勇', '1506414235312');
INSERT INTO `account_active_rate` VALUES ('2028', '78', '1', '70', '0', 'boca', '1506414235312');
INSERT INTO `account_active_rate` VALUES ('2029', '79', '1', '70', '0', '15735083175', '1506414235312');
INSERT INTO `account_active_rate` VALUES ('2030', '80', '1', '70', '0', '刘淮槟', '1506414235312');
INSERT INTO `account_active_rate` VALUES ('2031', '81', '1', '70', '0', 'shenyaolin', '1506414237396');
INSERT INTO `account_active_rate` VALUES ('2032', '82', '1', '70', '0', '1452395483', '1506414237396');
INSERT INTO `account_active_rate` VALUES ('2033', '83', '1', '70', '0', '1184164070', '1506414237396');
INSERT INTO `account_active_rate` VALUES ('2034', '84', '1', '70', '0', '1782249351', '1506414237396');
INSERT INTO `account_active_rate` VALUES ('2035', '85', '1', '70', '0', '18291797284', '1506414237396');
INSERT INTO `account_active_rate` VALUES ('2036', '86', '1', '70', '0', '745530430', '1506414237396');
INSERT INTO `account_active_rate` VALUES ('2037', '87', '1', '70', '0', '1648327136', '1506414237396');
INSERT INTO `account_active_rate` VALUES ('2038', '88', '1', '70', '0', '15291739020', '1506414237396');
INSERT INTO `account_active_rate` VALUES ('2039', '76', '1', '40', '0', 'AOK', '1506476852589');
INSERT INTO `account_active_rate` VALUES ('2040', '77', '1', '40', '0', '李勇', '1506476852589');
INSERT INTO `account_active_rate` VALUES ('2041', '78', '1', '40', '0', 'boca', '1506476852589');
INSERT INTO `account_active_rate` VALUES ('2042', '79', '1', '40', '0', '15735083175', '1506476852589');
INSERT INTO `account_active_rate` VALUES ('2043', '80', '1', '40', '0', '刘淮槟', '1506476852589');
INSERT INTO `account_active_rate` VALUES ('2044', '81', '1', '40', '0', 'shenyaolin', '1506476852589');
INSERT INTO `account_active_rate` VALUES ('2045', '82', '1', '40', '0', '1452395483', '1506476852589');
INSERT INTO `account_active_rate` VALUES ('2046', '83', '1', '40', '0', '1184164070', '1506476852589');
INSERT INTO `account_active_rate` VALUES ('2047', '84', '1', '40', '0', '1782249351', '1506476852589');
INSERT INTO `account_active_rate` VALUES ('2048', '85', '1', '40', '0', '18291797284', '1506476852589');
INSERT INTO `account_active_rate` VALUES ('2049', '86', '1', '40', '0', '745530430', '1506476854960');
INSERT INTO `account_active_rate` VALUES ('2050', '87', '1', '40', '0', '1648327136', '1506476854960');
INSERT INTO `account_active_rate` VALUES ('2051', '88', '1', '40', '0', '15291739020', '1506476854960');
INSERT INTO `account_active_rate` VALUES ('2052', '2', '1', '70', '1', '123', '0');
INSERT INTO `account_active_rate` VALUES ('2053', '4', '1', '71', '0', 'wzkj', '1506571155200');
INSERT INTO `account_active_rate` VALUES ('2054', '5', '1', '71', '0', '冰河', '1506571155200');
INSERT INTO `account_active_rate` VALUES ('2055', '6', '1', '71', '0', 'jiafeng', '1506571155200');
INSERT INTO `account_active_rate` VALUES ('2056', '7', '1', '71', '0', 'l474705958', '1506571155200');
INSERT INTO `account_active_rate` VALUES ('2057', '8', '1', '71', '0', '184066643', '1506571155200');
INSERT INTO `account_active_rate` VALUES ('2058', '9', '1', '71', '0', '2369412', '1506571155200');
INSERT INTO `account_active_rate` VALUES ('2059', '10', '1', '71', '0', 'hy123', '1506571155200');
INSERT INTO `account_active_rate` VALUES ('2060', '11', '1', '71', '0', 'zishu', '1506571155200');
INSERT INTO `account_active_rate` VALUES ('2061', '12', '1', '71', '0', 'tianjing', '1506571155200');
INSERT INTO `account_active_rate` VALUES ('2062', '13', '1', '71', '0', 'zqy95178250', '1506571155200');
INSERT INTO `account_active_rate` VALUES ('2063', '14', '1', '71', '0', 'QQ574912927', '1506571156896');
INSERT INTO `account_active_rate` VALUES ('2064', '15', '1', '71', '0', '1579599827', '1506571156896');
INSERT INTO `account_active_rate` VALUES ('2065', '17', '1', '71', '0', '789', '1506571156896');
INSERT INTO `account_active_rate` VALUES ('2066', '18', '1', '71', '0', '112', '1506571156896');
INSERT INTO `account_active_rate` VALUES ('2067', '20', '1', '71', '0', 'b2218776', '1506571156896');
INSERT INTO `account_active_rate` VALUES ('2068', '21', '1', '71', '0', '13771547176', '1506571156896');
INSERT INTO `account_active_rate` VALUES ('2069', '22', '1', '71', '0', '1', '1506571156896');
INSERT INTO `account_active_rate` VALUES ('2070', '23', '1', '71', '0', '小aq', '1506571156896');
INSERT INTO `account_active_rate` VALUES ('2071', '24', '1', '71', '0', '15914897978', '1506571156896');
INSERT INTO `account_active_rate` VALUES ('2072', '25', '1', '71', '0', 'oushinanshen', '1506571156896');
INSERT INTO `account_active_rate` VALUES ('2073', '26', '1', '71', '0', 'wxx899999', '1506571158539');
INSERT INTO `account_active_rate` VALUES ('2074', '27', '1', '71', '0', '1464975293', '1506571158539');
INSERT INTO `account_active_rate` VALUES ('2075', '29', '1', '71', '0', 'Bear', '1506571158539');
INSERT INTO `account_active_rate` VALUES ('2076', '30', '1', '71', '0', 'zxx', '1506571158539');
INSERT INTO `account_active_rate` VALUES ('2077', '31', '1', '71', '0', 'hy123456', '1506571158539');
INSERT INTO `account_active_rate` VALUES ('2078', '32', '1', '71', '0', 'wl123', '1506571158539');
INSERT INTO `account_active_rate` VALUES ('2079', '33', '1', '71', '0', '鳯儿网店', '1506571158539');
INSERT INTO `account_active_rate` VALUES ('2080', '34', '1', '71', '0', 'ruiruima', '1506571158539');
INSERT INTO `account_active_rate` VALUES ('2081', '35', '1', '71', '0', '944581678', '1506571158539');
INSERT INTO `account_active_rate` VALUES ('2082', '36', '1', '71', '0', '2069959168', '1506571158539');
INSERT INTO `account_active_rate` VALUES ('2083', '37', '1', '71', '0', '570156062', '1506571160334');
INSERT INTO `account_active_rate` VALUES ('2084', '38', '1', '71', '0', '770733914', '1506571160334');
INSERT INTO `account_active_rate` VALUES ('2085', '39', '1', '71', '0', '5257', '1506571160334');
INSERT INTO `account_active_rate` VALUES ('2086', '40', '1', '71', '0', '18734158108', '1506571160334');
INSERT INTO `account_active_rate` VALUES ('2087', '41', '1', '71', '0', 'xhq1347574865', '1506571160334');
INSERT INTO `account_active_rate` VALUES ('2088', '42', '1', '71', '0', 'Chen', '1506571160334');
INSERT INTO `account_active_rate` VALUES ('2089', '43', '1', '71', '0', 'qq130496', '1506571160334');
INSERT INTO `account_active_rate` VALUES ('2090', '44', '1', '71', '0', 'kevinchow', '1506571160334');
INSERT INTO `account_active_rate` VALUES ('2091', '45', '1', '71', '0', '17346544413', '1506571160334');
INSERT INTO `account_active_rate` VALUES ('2092', '46', '1', '71', '0', '2480199685', '1506571160334');
INSERT INTO `account_active_rate` VALUES ('2093', '47', '1', '71', '0', 'jim145', '1506571162613');
INSERT INTO `account_active_rate` VALUES ('2094', '48', '1', '71', '0', 'bada', '1506571162613');
INSERT INTO `account_active_rate` VALUES ('2095', '49', '1', '71', '0', '罗大大', '1506571162613');
INSERT INTO `account_active_rate` VALUES ('2096', '50', '1', '71', '0', '109', '1506571162613');
INSERT INTO `account_active_rate` VALUES ('2097', '51', '1', '71', '0', '119', '1506571162613');
INSERT INTO `account_active_rate` VALUES ('2098', '52', '1', '71', '0', 'gigi77', '1506571162613');
INSERT INTO `account_active_rate` VALUES ('2099', '53', '1', '71', '0', 'gigi777', '1506571162613');
INSERT INTO `account_active_rate` VALUES ('2100', '55', '1', '71', '0', '111111', '1506571162613');
INSERT INTO `account_active_rate` VALUES ('2101', '56', '1', '71', '0', 'dada', '1506571162613');
INSERT INTO `account_active_rate` VALUES ('2102', '57', '1', '71', '0', '源肥呀', '1506571162613');
INSERT INTO `account_active_rate` VALUES ('2103', '58', '1', '71', '0', '764388753', '1506571164590');
INSERT INTO `account_active_rate` VALUES ('2104', '59', '1', '71', '0', '815555213', '1506571164590');
INSERT INTO `account_active_rate` VALUES ('2105', '61', '1', '71', '0', '无厘头', '1506571164590');
INSERT INTO `account_active_rate` VALUES ('2106', '62', '1', '71', '0', '2630832822', '1506571164590');
INSERT INTO `account_active_rate` VALUES ('2107', '64', '1', '71', '0', '850618', '1506571164590');
INSERT INTO `account_active_rate` VALUES ('2108', '66', '1', '71', '0', '18706732390', '1506571164590');
INSERT INTO `account_active_rate` VALUES ('2109', '67', '1', '71', '0', '灰灰小店', '1506571164590');
INSERT INTO `account_active_rate` VALUES ('2110', '68', '1', '71', '0', 'adidaszxc', '1506571164590');
INSERT INTO `account_active_rate` VALUES ('2111', '69', '1', '71', '0', 'asdfghjkl', '1506571164590');
INSERT INTO `account_active_rate` VALUES ('2112', '70', '1', '71', '0', '15111201915', '1506571164590');
INSERT INTO `account_active_rate` VALUES ('2113', '71', '1', '71', '0', '1550471939', '1506571166283');
INSERT INTO `account_active_rate` VALUES ('2114', '72', '1', '71', '0', '3138108592', '1506571166283');
INSERT INTO `account_active_rate` VALUES ('2115', '73', '1', '71', '0', 'Zippo1995', '1506571166283');
INSERT INTO `account_active_rate` VALUES ('2116', '74', '1', '71', '0', '3330118825', '1506571166283');
INSERT INTO `account_active_rate` VALUES ('2117', '75', '1', '71', '0', '315061813', '1506571166283');
INSERT INTO `account_active_rate` VALUES ('2118', '76', '1', '71', '0', 'AOK', '1506571166283');
INSERT INTO `account_active_rate` VALUES ('2119', '77', '1', '71', '0', '李勇', '1506571166283');
INSERT INTO `account_active_rate` VALUES ('2120', '78', '1', '71', '0', 'boca', '1506571166283');
INSERT INTO `account_active_rate` VALUES ('2121', '79', '1', '71', '0', '15735083175', '1506571166284');
INSERT INTO `account_active_rate` VALUES ('2122', '80', '1', '71', '0', '刘淮槟', '1506571166284');
INSERT INTO `account_active_rate` VALUES ('2123', '81', '1', '71', '0', 'shenyaolin', '1506571168256');
INSERT INTO `account_active_rate` VALUES ('2124', '82', '1', '71', '0', '1452395483', '1506571168256');
INSERT INTO `account_active_rate` VALUES ('2125', '83', '1', '71', '0', '1184164070', '1506571168256');
INSERT INTO `account_active_rate` VALUES ('2126', '84', '1', '71', '0', '1782249351', '1506571168256');
INSERT INTO `account_active_rate` VALUES ('2127', '85', '1', '71', '0', '18291797284', '1506571168256');
INSERT INTO `account_active_rate` VALUES ('2128', '86', '1', '71', '0', '745530430', '1506571168256');
INSERT INTO `account_active_rate` VALUES ('2129', '87', '1', '71', '0', '1648327136', '1506571168256');
INSERT INTO `account_active_rate` VALUES ('2130', '88', '1', '71', '0', '15291739020', '1506571168256');
INSERT INTO `account_active_rate` VALUES ('2131', '89', '1', '71', '0', 'wu159369', '1506571168256');
INSERT INTO `account_active_rate` VALUES ('2132', '88', '1', '60', '0', '15291739020', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('2133', '89', '1', '60', '0', 'wu159369', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('2134', '90', '1', '60', '0', '2676005659', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('2135', '91', '1', '60', '0', '17608410344', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('2136', '92', '1', '60', '0', '18856960943', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('2137', '93', '1', '60', '0', 'a1579599827', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('2138', '94', '1', '60', '0', '龙龙龙', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('2139', '95', '1', '60', '0', '呵呵哒', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('2140', '96', '1', '60', '0', '1838969699', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('2141', '89', '1', '42', '0', 'wu159369', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('2142', '90', '1', '42', '0', '2676005659', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('2143', '91', '1', '42', '0', '17608410344', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('2144', '92', '1', '42', '0', '18856960943', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('2145', '93', '1', '42', '0', 'a1579599827', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('2146', '94', '1', '42', '0', '龙龙龙', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('2147', '95', '1', '42', '0', '呵呵哒', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('2148', '96', '1', '42', '0', '1838969699', '1507542547540');
INSERT INTO `account_active_rate` VALUES ('2149', '89', '1', '40', '0', 'wu159369', '1507436931904');
INSERT INTO `account_active_rate` VALUES ('2150', '90', '1', '40', '0', '2676005659', '1507436931904');
INSERT INTO `account_active_rate` VALUES ('2151', '91', '1', '40', '0', '17608410344', '1507436931904');
INSERT INTO `account_active_rate` VALUES ('2152', '92', '1', '40', '0', '18856960943', '1507436931904');
INSERT INTO `account_active_rate` VALUES ('2153', '93', '1', '40', '0', 'a1579599827', '1507436931904');
INSERT INTO `account_active_rate` VALUES ('2154', '94', '1', '40', '0', '龙龙龙', '1507436931904');
INSERT INTO `account_active_rate` VALUES ('2155', '95', '1', '40', '0', '呵呵哒', '1507436931904');
INSERT INTO `account_active_rate` VALUES ('2156', '96', '1', '40', '0', '1838969699', '1507436931904');
INSERT INTO `account_active_rate` VALUES ('2157', '97', '1', '60', '0', 'zhang2580', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('2158', '98', '1', '60', '0', '250859412', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('2159', '97', '1', '42', '0', 'zhang2580', '1507542551610');
INSERT INTO `account_active_rate` VALUES ('2160', '98', '1', '42', '0', '250859412', '1507542551610');
INSERT INTO `account_active_rate` VALUES ('2161', '76', '1', '30', '0', 'AOK', '1507543204878');
INSERT INTO `account_active_rate` VALUES ('2162', '77', '1', '30', '0', '李勇', '1507543204878');
INSERT INTO `account_active_rate` VALUES ('2163', '78', '1', '30', '0', 'boca', '1507543204878');
INSERT INTO `account_active_rate` VALUES ('2164', '79', '1', '30', '0', '15735083175', '1507543204878');
INSERT INTO `account_active_rate` VALUES ('2165', '80', '1', '30', '0', '刘淮槟', '1507543204878');
INSERT INTO `account_active_rate` VALUES ('2166', '81', '1', '30', '0', 'shenyaolin', '1507543204878');
INSERT INTO `account_active_rate` VALUES ('2167', '82', '1', '30', '0', '1452395483', '1507543204878');
INSERT INTO `account_active_rate` VALUES ('2168', '83', '1', '30', '0', '1184164070', '1507543204878');
INSERT INTO `account_active_rate` VALUES ('2169', '84', '1', '30', '0', '1782249351', '1507543204878');
INSERT INTO `account_active_rate` VALUES ('2170', '85', '1', '30', '0', '18291797284', '1507543204878');
INSERT INTO `account_active_rate` VALUES ('2171', '86', '1', '30', '0', '745530430', '1507543206857');
INSERT INTO `account_active_rate` VALUES ('2172', '87', '1', '30', '0', '1648327136', '1507543206857');
INSERT INTO `account_active_rate` VALUES ('2173', '88', '1', '30', '0', '15291739020', '1507543206857');
INSERT INTO `account_active_rate` VALUES ('2174', '89', '1', '30', '0', 'wu159369', '1507543206857');
INSERT INTO `account_active_rate` VALUES ('2175', '90', '1', '30', '0', '2676005659', '1507543206857');
INSERT INTO `account_active_rate` VALUES ('2176', '91', '1', '30', '0', '17608410344', '1507543206857');
INSERT INTO `account_active_rate` VALUES ('2177', '92', '1', '30', '0', '18856960943', '1507543206857');
INSERT INTO `account_active_rate` VALUES ('2178', '93', '1', '30', '0', 'a1579599827', '1507543206857');
INSERT INTO `account_active_rate` VALUES ('2179', '94', '1', '30', '0', '龙龙龙', '1507543206857');
INSERT INTO `account_active_rate` VALUES ('2180', '95', '1', '30', '0', '呵呵哒', '1507543206857');
INSERT INTO `account_active_rate` VALUES ('2181', '96', '1', '30', '0', '1838969699', '1507543208793');
INSERT INTO `account_active_rate` VALUES ('2182', '97', '1', '30', '0', 'zhang2580', '1507543208793');
INSERT INTO `account_active_rate` VALUES ('2183', '98', '1', '30', '0', '250859412', '1507543208793');
INSERT INTO `account_active_rate` VALUES ('2184', '4', '1', '72', '0', 'wzkj', '1507630264905');
INSERT INTO `account_active_rate` VALUES ('2185', '5', '1', '72', '0', '冰河', '1507630264905');
INSERT INTO `account_active_rate` VALUES ('2186', '6', '1', '72', '0', 'jiafeng', '1507630264905');
INSERT INTO `account_active_rate` VALUES ('2187', '7', '1', '72', '0', 'l474705958', '1507630264905');
INSERT INTO `account_active_rate` VALUES ('2188', '8', '1', '72', '0', '184066643', '1507630264905');
INSERT INTO `account_active_rate` VALUES ('2189', '9', '1', '72', '0', '2369412', '1507630264905');
INSERT INTO `account_active_rate` VALUES ('2190', '10', '1', '72', '0', 'hy123', '1507630264905');
INSERT INTO `account_active_rate` VALUES ('2191', '11', '1', '72', '0', 'zishu', '1507630264905');
INSERT INTO `account_active_rate` VALUES ('2192', '12', '1', '72', '0', 'tianjing', '1507630264905');
INSERT INTO `account_active_rate` VALUES ('2193', '13', '1', '72', '0', 'zqy95178250', '1507630264905');
INSERT INTO `account_active_rate` VALUES ('2194', '14', '1', '72', '0', 'QQ574912927', '1507630266704');
INSERT INTO `account_active_rate` VALUES ('2195', '15', '1', '72', '0', '1579599827', '1507630266704');
INSERT INTO `account_active_rate` VALUES ('2196', '17', '1', '72', '0', '789', '1507630266704');
INSERT INTO `account_active_rate` VALUES ('2197', '18', '1', '72', '0', '112', '1507630266704');
INSERT INTO `account_active_rate` VALUES ('2198', '20', '1', '72', '0', 'b2218776', '1507630266704');
INSERT INTO `account_active_rate` VALUES ('2199', '21', '1', '72', '0', '13771547176', '1507630266704');
INSERT INTO `account_active_rate` VALUES ('2200', '22', '1', '72', '0', '1', '1507630266704');
INSERT INTO `account_active_rate` VALUES ('2201', '23', '1', '72', '0', '小aq', '1507630266704');
INSERT INTO `account_active_rate` VALUES ('2202', '24', '1', '72', '0', '15914897978', '1507630266704');
INSERT INTO `account_active_rate` VALUES ('2203', '25', '1', '72', '0', 'oushinanshen', '1507630266704');
INSERT INTO `account_active_rate` VALUES ('2204', '26', '1', '72', '0', 'wxx899999', '1507630268300');
INSERT INTO `account_active_rate` VALUES ('2205', '27', '1', '72', '0', '1464975293', '1507630268300');
INSERT INTO `account_active_rate` VALUES ('2206', '29', '1', '72', '0', 'Bear', '1507630268300');
INSERT INTO `account_active_rate` VALUES ('2207', '30', '1', '72', '0', 'zxx', '1507630268300');
INSERT INTO `account_active_rate` VALUES ('2208', '31', '1', '72', '0', 'hy123456', '1507630268300');
INSERT INTO `account_active_rate` VALUES ('2209', '32', '1', '72', '0', 'wl123', '1507630268300');
INSERT INTO `account_active_rate` VALUES ('2210', '33', '1', '72', '0', '鳯儿网店', '1507630268300');
INSERT INTO `account_active_rate` VALUES ('2211', '34', '1', '72', '0', 'ruiruima', '1507630268300');
INSERT INTO `account_active_rate` VALUES ('2212', '35', '1', '72', '0', '944581678', '1507630268300');
INSERT INTO `account_active_rate` VALUES ('2213', '36', '1', '72', '0', '2069959168', '1507630268300');
INSERT INTO `account_active_rate` VALUES ('2214', '37', '1', '72', '0', '570156062', '1507630269659');
INSERT INTO `account_active_rate` VALUES ('2215', '38', '1', '72', '0', '770733914', '1507630269659');
INSERT INTO `account_active_rate` VALUES ('2216', '39', '1', '72', '0', '5257', '1507630269659');
INSERT INTO `account_active_rate` VALUES ('2217', '40', '1', '72', '0', '18734158108', '1507630269659');
INSERT INTO `account_active_rate` VALUES ('2218', '41', '1', '72', '0', 'xhq1347574865', '1507630269659');
INSERT INTO `account_active_rate` VALUES ('2219', '42', '1', '72', '0', 'Chen', '1507630269659');
INSERT INTO `account_active_rate` VALUES ('2220', '43', '1', '72', '0', 'qq130496', '1507630269659');
INSERT INTO `account_active_rate` VALUES ('2221', '44', '1', '72', '0', 'kevinchow', '1507630269659');
INSERT INTO `account_active_rate` VALUES ('2222', '45', '1', '72', '0', '17346544413', '1507630269659');
INSERT INTO `account_active_rate` VALUES ('2223', '46', '1', '72', '0', '2480199685', '1507630269659');
INSERT INTO `account_active_rate` VALUES ('2224', '47', '1', '72', '0', 'jim145', '1507630271737');
INSERT INTO `account_active_rate` VALUES ('2225', '48', '1', '72', '0', 'bada', '1507630271737');
INSERT INTO `account_active_rate` VALUES ('2226', '49', '1', '72', '0', '罗大大', '1507630271737');
INSERT INTO `account_active_rate` VALUES ('2227', '50', '1', '72', '0', '109', '1507630271737');
INSERT INTO `account_active_rate` VALUES ('2228', '51', '1', '72', '0', '119', '1507630271737');
INSERT INTO `account_active_rate` VALUES ('2229', '52', '1', '72', '0', 'gigi77', '1507630271737');
INSERT INTO `account_active_rate` VALUES ('2230', '53', '1', '72', '0', 'gigi777', '1507630271737');
INSERT INTO `account_active_rate` VALUES ('2231', '55', '1', '72', '0', '111111', '1507630271737');
INSERT INTO `account_active_rate` VALUES ('2232', '56', '1', '72', '0', 'dada', '1507630271737');
INSERT INTO `account_active_rate` VALUES ('2233', '57', '1', '72', '0', '源肥呀', '1507630271737');
INSERT INTO `account_active_rate` VALUES ('2234', '58', '1', '72', '0', '764388753', '1507630274340');
INSERT INTO `account_active_rate` VALUES ('2235', '59', '1', '72', '0', '815555213', '1507630274340');
INSERT INTO `account_active_rate` VALUES ('2236', '61', '1', '72', '0', '无厘头', '1507630274340');
INSERT INTO `account_active_rate` VALUES ('2237', '62', '1', '72', '0', '2630832822', '1507630274340');
INSERT INTO `account_active_rate` VALUES ('2238', '64', '1', '72', '0', '850618', '1507630274340');
INSERT INTO `account_active_rate` VALUES ('2239', '66', '1', '72', '0', '18706732390', '1507630274340');
INSERT INTO `account_active_rate` VALUES ('2240', '67', '1', '72', '0', '灰灰小店', '1507630274340');
INSERT INTO `account_active_rate` VALUES ('2241', '68', '1', '72', '0', 'adidaszxc', '1507630274340');
INSERT INTO `account_active_rate` VALUES ('2242', '69', '1', '72', '0', 'asdfghjkl', '1507630274340');
INSERT INTO `account_active_rate` VALUES ('2243', '70', '1', '72', '0', '15111201915', '1507630274340');
INSERT INTO `account_active_rate` VALUES ('2244', '71', '1', '72', '0', '1550471939', '1507630275799');
INSERT INTO `account_active_rate` VALUES ('2245', '72', '1', '72', '0', '3138108592', '1507630275799');
INSERT INTO `account_active_rate` VALUES ('2246', '73', '1', '72', '0', 'Zippo1995', '1507630275799');
INSERT INTO `account_active_rate` VALUES ('2247', '74', '1', '72', '0', '3330118825', '1507630275799');
INSERT INTO `account_active_rate` VALUES ('2248', '75', '1', '72', '0', '315061813', '1507630275799');
INSERT INTO `account_active_rate` VALUES ('2249', '76', '1', '72', '0', 'AOK', '1507630275799');
INSERT INTO `account_active_rate` VALUES ('2250', '77', '1', '72', '0', '李勇', '1507630275799');
INSERT INTO `account_active_rate` VALUES ('2251', '78', '1', '72', '0', 'boca', '1507630275799');
INSERT INTO `account_active_rate` VALUES ('2252', '79', '1', '72', '0', '15735083175', '1507630275799');
INSERT INTO `account_active_rate` VALUES ('2253', '80', '1', '72', '0', '刘淮槟', '1507630275799');
INSERT INTO `account_active_rate` VALUES ('2254', '81', '1', '72', '0', 'shenyaolin', '1507630277317');
INSERT INTO `account_active_rate` VALUES ('2255', '82', '1', '72', '0', '1452395483', '1507630277317');
INSERT INTO `account_active_rate` VALUES ('2256', '83', '1', '72', '0', '1184164070', '1507630277317');
INSERT INTO `account_active_rate` VALUES ('2257', '84', '1', '72', '0', '1782249351', '1507630277317');
INSERT INTO `account_active_rate` VALUES ('2258', '85', '1', '72', '0', '18291797284', '1507630277317');
INSERT INTO `account_active_rate` VALUES ('2259', '86', '1', '72', '0', '745530430', '1507630277317');
INSERT INTO `account_active_rate` VALUES ('2260', '87', '1', '72', '0', '1648327136', '1507630277317');
INSERT INTO `account_active_rate` VALUES ('2261', '88', '1', '72', '0', '15291739020', '1507630277317');
INSERT INTO `account_active_rate` VALUES ('2262', '89', '1', '72', '0', 'wu159369', '1507630277317');
INSERT INTO `account_active_rate` VALUES ('2263', '90', '1', '72', '0', '2676005659', '1507630277317');
INSERT INTO `account_active_rate` VALUES ('2264', '91', '1', '72', '0', '17608410344', '1507630279425');
INSERT INTO `account_active_rate` VALUES ('2265', '92', '1', '72', '0', '18856960943', '1507630279425');
INSERT INTO `account_active_rate` VALUES ('2266', '93', '1', '72', '0', 'a1579599827', '1507630279425');
INSERT INTO `account_active_rate` VALUES ('2267', '94', '1', '72', '0', '龙龙龙', '1507630279425');
INSERT INTO `account_active_rate` VALUES ('2268', '95', '1', '72', '0', '呵呵哒', '1507630279425');
INSERT INTO `account_active_rate` VALUES ('2269', '96', '1', '72', '0', '1838969699', '1507630279425');
INSERT INTO `account_active_rate` VALUES ('2270', '97', '1', '72', '0', 'zhang2580', '1507630279425');
INSERT INTO `account_active_rate` VALUES ('2271', '98', '1', '72', '0', '250859412', '1507630279425');
INSERT INTO `account_active_rate` VALUES ('2272', '99', '1', '72', '0', '18573748125', '1507630279425');
INSERT INTO `account_active_rate` VALUES ('2273', '99', '1', '42', '0', '18573748125', '1507641081342');
INSERT INTO `account_active_rate` VALUES ('2274', '100', '1', '42', '0', '1772419834', '1507641081342');
INSERT INTO `account_active_rate` VALUES ('2275', '101', '1', '42', '0', '1923491217', '1507641081342');
INSERT INTO `account_active_rate` VALUES ('2276', '4', '1', '73', '0', 'wzkj', '1507691235426');
INSERT INTO `account_active_rate` VALUES ('2277', '5', '1', '73', '0', '冰河', '1507691235426');
INSERT INTO `account_active_rate` VALUES ('2278', '6', '1', '73', '0', 'jiafeng', '1507691235426');
INSERT INTO `account_active_rate` VALUES ('2279', '7', '1', '73', '0', 'l474705958', '1507691235426');
INSERT INTO `account_active_rate` VALUES ('2280', '8', '1', '73', '0', '184066643', '1507691235426');
INSERT INTO `account_active_rate` VALUES ('2281', '9', '1', '73', '0', '2369412', '1507691235426');
INSERT INTO `account_active_rate` VALUES ('2282', '10', '1', '73', '0', 'hy123', '1507691235426');
INSERT INTO `account_active_rate` VALUES ('2283', '11', '1', '73', '0', 'zishu', '1507691235426');
INSERT INTO `account_active_rate` VALUES ('2284', '12', '1', '73', '0', 'tianjing', '1507691235426');
INSERT INTO `account_active_rate` VALUES ('2285', '13', '1', '73', '0', 'zqy95178250', '1507691235426');
INSERT INTO `account_active_rate` VALUES ('2286', '14', '1', '73', '0', 'QQ574912927', '1507691237704');
INSERT INTO `account_active_rate` VALUES ('2287', '15', '1', '73', '0', '1579599827', '1507691237704');
INSERT INTO `account_active_rate` VALUES ('2288', '17', '1', '73', '0', '789', '1507691237704');
INSERT INTO `account_active_rate` VALUES ('2289', '18', '1', '73', '0', '112', '1507691237704');
INSERT INTO `account_active_rate` VALUES ('2290', '20', '1', '73', '0', 'b2218776', '1507691237704');
INSERT INTO `account_active_rate` VALUES ('2291', '21', '1', '73', '0', '13771547176', '1507691237704');
INSERT INTO `account_active_rate` VALUES ('2292', '22', '1', '73', '0', '1', '1507691237704');
INSERT INTO `account_active_rate` VALUES ('2293', '23', '1', '73', '0', '小aq', '1507691237704');
INSERT INTO `account_active_rate` VALUES ('2294', '24', '1', '73', '0', '15914897978', '1507691237704');
INSERT INTO `account_active_rate` VALUES ('2295', '25', '1', '73', '0', 'oushinanshen', '1507691237704');
INSERT INTO `account_active_rate` VALUES ('2296', '26', '1', '73', '0', 'wxx899999', '1507691239481');
INSERT INTO `account_active_rate` VALUES ('2297', '27', '1', '73', '0', '1464975293', '1507691239481');
INSERT INTO `account_active_rate` VALUES ('2298', '29', '1', '73', '0', 'Bear', '1507691239481');
INSERT INTO `account_active_rate` VALUES ('2299', '30', '1', '73', '0', 'zxx', '1507691239481');
INSERT INTO `account_active_rate` VALUES ('2300', '31', '1', '73', '0', 'hy123456', '1507691239481');
INSERT INTO `account_active_rate` VALUES ('2301', '32', '1', '73', '0', 'wl123', '1507691239481');
INSERT INTO `account_active_rate` VALUES ('2302', '33', '1', '73', '0', '鳯儿网店', '1507691239481');
INSERT INTO `account_active_rate` VALUES ('2303', '34', '1', '73', '0', 'ruiruima', '1507691239481');
INSERT INTO `account_active_rate` VALUES ('2304', '35', '1', '73', '0', '944581678', '1507691239481');
INSERT INTO `account_active_rate` VALUES ('2305', '36', '1', '73', '0', '2069959168', '1507691239481');
INSERT INTO `account_active_rate` VALUES ('2306', '37', '1', '73', '0', '570156062', '1507691242792');
INSERT INTO `account_active_rate` VALUES ('2307', '38', '1', '73', '0', '770733914', '1507691242792');
INSERT INTO `account_active_rate` VALUES ('2308', '39', '1', '73', '0', '5257', '1507691242792');
INSERT INTO `account_active_rate` VALUES ('2309', '40', '1', '73', '0', '18734158108', '1507691242792');
INSERT INTO `account_active_rate` VALUES ('2310', '41', '1', '73', '0', 'xhq1347574865', '1507691242792');
INSERT INTO `account_active_rate` VALUES ('2311', '42', '1', '73', '0', 'Chen', '1507691242792');
INSERT INTO `account_active_rate` VALUES ('2312', '43', '1', '73', '0', 'qq130496', '1507691242792');
INSERT INTO `account_active_rate` VALUES ('2313', '44', '1', '73', '0', 'kevinchow', '1507691242792');
INSERT INTO `account_active_rate` VALUES ('2314', '45', '1', '73', '0', '17346544413', '1507691242792');
INSERT INTO `account_active_rate` VALUES ('2315', '46', '1', '73', '0', '2480199685', '1507691242792');
INSERT INTO `account_active_rate` VALUES ('2316', '47', '1', '73', '0', 'jim145', '1507691244790');
INSERT INTO `account_active_rate` VALUES ('2317', '48', '1', '73', '0', 'bada', '1507691244790');
INSERT INTO `account_active_rate` VALUES ('2318', '49', '1', '73', '0', '罗大大', '1507691244790');
INSERT INTO `account_active_rate` VALUES ('2319', '50', '1', '73', '0', '109', '1507691244790');
INSERT INTO `account_active_rate` VALUES ('2320', '51', '1', '73', '0', '119', '1507691244790');
INSERT INTO `account_active_rate` VALUES ('2321', '52', '1', '73', '0', 'gigi77', '1507691244790');
INSERT INTO `account_active_rate` VALUES ('2322', '53', '1', '73', '0', 'gigi777', '1507691244790');
INSERT INTO `account_active_rate` VALUES ('2323', '55', '1', '73', '0', '111111', '1507691244790');
INSERT INTO `account_active_rate` VALUES ('2324', '56', '1', '73', '0', 'dada', '1507691244790');
INSERT INTO `account_active_rate` VALUES ('2325', '57', '1', '73', '0', '源肥呀', '1507691244790');
INSERT INTO `account_active_rate` VALUES ('2326', '58', '1', '73', '0', '764388753', '1507691246491');
INSERT INTO `account_active_rate` VALUES ('2327', '59', '1', '73', '0', '815555213', '1507691246491');
INSERT INTO `account_active_rate` VALUES ('2328', '61', '1', '73', '0', '无厘头', '1507691246491');
INSERT INTO `account_active_rate` VALUES ('2329', '62', '1', '73', '0', '2630832822', '1507691246491');
INSERT INTO `account_active_rate` VALUES ('2330', '64', '1', '73', '0', '850618', '1507691246491');
INSERT INTO `account_active_rate` VALUES ('2331', '66', '1', '73', '0', '18706732390', '1507691246491');
INSERT INTO `account_active_rate` VALUES ('2332', '67', '1', '73', '0', '灰灰小店', '1507691246491');
INSERT INTO `account_active_rate` VALUES ('2333', '68', '1', '73', '0', 'adidaszxc', '1507691246491');
INSERT INTO `account_active_rate` VALUES ('2334', '69', '1', '73', '0', 'asdfghjkl', '1507691246491');
INSERT INTO `account_active_rate` VALUES ('2335', '70', '1', '73', '0', '15111201915', '1507691246491');
INSERT INTO `account_active_rate` VALUES ('2336', '71', '1', '73', '0', '1550471939', '1507691248209');
INSERT INTO `account_active_rate` VALUES ('2337', '72', '1', '73', '0', '3138108592', '1507691248209');
INSERT INTO `account_active_rate` VALUES ('2338', '73', '1', '73', '0', 'Zippo1995', '1507691248209');
INSERT INTO `account_active_rate` VALUES ('2339', '74', '1', '73', '0', '3330118825', '1507691248209');
INSERT INTO `account_active_rate` VALUES ('2340', '75', '1', '73', '0', '315061813', '1507691248209');
INSERT INTO `account_active_rate` VALUES ('2341', '76', '1', '73', '0', 'AOK', '1507691248209');
INSERT INTO `account_active_rate` VALUES ('2342', '77', '1', '73', '0', '李勇', '1507691248209');
INSERT INTO `account_active_rate` VALUES ('2343', '78', '1', '73', '0', 'boca', '1507691248209');
INSERT INTO `account_active_rate` VALUES ('2344', '79', '1', '73', '0', '15735083175', '1507691248209');
INSERT INTO `account_active_rate` VALUES ('2345', '80', '1', '73', '0', '刘淮槟', '1507691248209');
INSERT INTO `account_active_rate` VALUES ('2346', '81', '1', '73', '0', 'shenyaolin', '1507691249554');
INSERT INTO `account_active_rate` VALUES ('2347', '82', '1', '73', '0', '1452395483', '1507691249554');
INSERT INTO `account_active_rate` VALUES ('2348', '83', '1', '73', '0', '1184164070', '1507691249554');
INSERT INTO `account_active_rate` VALUES ('2349', '84', '1', '73', '0', '1782249351', '1507691249554');
INSERT INTO `account_active_rate` VALUES ('2350', '85', '1', '73', '0', '18291797284', '1507691249554');
INSERT INTO `account_active_rate` VALUES ('2351', '86', '1', '73', '0', '745530430', '1507691249554');
INSERT INTO `account_active_rate` VALUES ('2352', '87', '1', '73', '0', '1648327136', '1507691249554');
INSERT INTO `account_active_rate` VALUES ('2353', '88', '1', '73', '0', '15291739020', '1507691249554');
INSERT INTO `account_active_rate` VALUES ('2354', '89', '1', '73', '0', 'wu159369', '1507691249554');
INSERT INTO `account_active_rate` VALUES ('2355', '90', '1', '73', '0', '2676005659', '1507691249554');
INSERT INTO `account_active_rate` VALUES ('2356', '91', '1', '73', '0', '17608410344', '1507691251166');
INSERT INTO `account_active_rate` VALUES ('2357', '92', '1', '73', '0', '18856960943', '1507691251166');
INSERT INTO `account_active_rate` VALUES ('2358', '93', '1', '73', '0', 'a1579599827', '1507691251166');
INSERT INTO `account_active_rate` VALUES ('2359', '94', '1', '73', '0', '龙龙龙', '1507691251166');
INSERT INTO `account_active_rate` VALUES ('2360', '95', '1', '73', '0', '呵呵哒', '1507691251166');
INSERT INTO `account_active_rate` VALUES ('2361', '96', '1', '73', '0', '1838969699', '1507691251166');
INSERT INTO `account_active_rate` VALUES ('2362', '97', '1', '73', '0', 'zhang2580', '1507691251166');
INSERT INTO `account_active_rate` VALUES ('2363', '98', '1', '73', '0', '250859412', '1507691251166');
INSERT INTO `account_active_rate` VALUES ('2364', '99', '1', '73', '0', '18573748125', '1507691251166');
INSERT INTO `account_active_rate` VALUES ('2365', '100', '1', '73', '0', '1772419834', '1507691251166');
INSERT INTO `account_active_rate` VALUES ('2366', '101', '1', '73', '0', '1923491217', '1507691252764');
INSERT INTO `account_active_rate` VALUES ('2367', '4', '1', '74', '0', 'wzkj', '1507711606980');
INSERT INTO `account_active_rate` VALUES ('2368', '5', '1', '74', '0', '冰河', '1507711606980');
INSERT INTO `account_active_rate` VALUES ('2369', '6', '1', '74', '0', 'jiafeng', '1507711606980');
INSERT INTO `account_active_rate` VALUES ('2370', '7', '1', '74', '0', 'l474705958', '1507711606980');
INSERT INTO `account_active_rate` VALUES ('2371', '8', '1', '74', '0', '184066643', '1507711606980');
INSERT INTO `account_active_rate` VALUES ('2372', '9', '1', '74', '0', '2369412', '1507711606980');
INSERT INTO `account_active_rate` VALUES ('2373', '10', '1', '74', '0', 'hy123', '1507711606980');
INSERT INTO `account_active_rate` VALUES ('2374', '11', '1', '74', '0', 'zishu', '1507711606980');
INSERT INTO `account_active_rate` VALUES ('2375', '12', '1', '74', '0', 'tianjing', '1507711606980');
INSERT INTO `account_active_rate` VALUES ('2376', '13', '1', '74', '0', 'zqy95178250', '1507711606980');
INSERT INTO `account_active_rate` VALUES ('2377', '14', '1', '74', '0', 'QQ574912927', '1507711609787');
INSERT INTO `account_active_rate` VALUES ('2378', '15', '1', '74', '0', '1579599827', '1507711609787');
INSERT INTO `account_active_rate` VALUES ('2379', '17', '1', '74', '0', '789', '1507711609787');
INSERT INTO `account_active_rate` VALUES ('2380', '18', '1', '74', '0', '112', '1507711609787');
INSERT INTO `account_active_rate` VALUES ('2381', '20', '1', '74', '0', 'b2218776', '1507711609787');
INSERT INTO `account_active_rate` VALUES ('2382', '21', '1', '74', '0', '13771547176', '1507711609787');
INSERT INTO `account_active_rate` VALUES ('2383', '22', '1', '74', '0', '1', '1507711609787');
INSERT INTO `account_active_rate` VALUES ('2384', '23', '1', '74', '0', '小aq', '1507711609787');
INSERT INTO `account_active_rate` VALUES ('2385', '24', '1', '74', '0', '15914897978', '1507711609787');
INSERT INTO `account_active_rate` VALUES ('2386', '25', '1', '74', '0', 'oushinanshen', '1507711609787');
INSERT INTO `account_active_rate` VALUES ('2387', '26', '1', '74', '0', 'wxx899999', '1507711611286');
INSERT INTO `account_active_rate` VALUES ('2388', '27', '1', '74', '0', '1464975293', '1507711611286');
INSERT INTO `account_active_rate` VALUES ('2389', '29', '1', '74', '0', 'Bear', '1507711611286');
INSERT INTO `account_active_rate` VALUES ('2390', '30', '1', '74', '0', 'zxx', '1507711611286');
INSERT INTO `account_active_rate` VALUES ('2391', '31', '1', '74', '0', 'hy123456', '1507711611286');
INSERT INTO `account_active_rate` VALUES ('2392', '32', '1', '74', '0', 'wl123', '1507711611286');
INSERT INTO `account_active_rate` VALUES ('2393', '33', '1', '74', '0', '鳯儿网店', '1507711611286');
INSERT INTO `account_active_rate` VALUES ('2394', '34', '1', '74', '0', 'ruiruima', '1507711611286');
INSERT INTO `account_active_rate` VALUES ('2395', '35', '1', '74', '0', '944581678', '1507711611286');
INSERT INTO `account_active_rate` VALUES ('2396', '36', '1', '74', '0', '2069959168', '1507711611286');
INSERT INTO `account_active_rate` VALUES ('2397', '37', '1', '74', '0', '570156062', '1507711612976');
INSERT INTO `account_active_rate` VALUES ('2398', '38', '1', '74', '0', '770733914', '1507711612976');
INSERT INTO `account_active_rate` VALUES ('2399', '39', '1', '74', '0', '5257', '1507711612976');
INSERT INTO `account_active_rate` VALUES ('2400', '40', '1', '74', '0', '18734158108', '1507711612976');
INSERT INTO `account_active_rate` VALUES ('2401', '41', '1', '74', '0', 'xhq1347574865', '1507711612976');
INSERT INTO `account_active_rate` VALUES ('2402', '42', '1', '74', '0', 'Chen', '1507711612976');
INSERT INTO `account_active_rate` VALUES ('2403', '43', '1', '74', '0', 'qq130496', '1507711612976');
INSERT INTO `account_active_rate` VALUES ('2404', '44', '1', '74', '0', 'kevinchow', '1507711612976');
INSERT INTO `account_active_rate` VALUES ('2405', '45', '1', '74', '0', '17346544413', '1507711612976');
INSERT INTO `account_active_rate` VALUES ('2406', '46', '1', '74', '0', '2480199685', '1507711612976');
INSERT INTO `account_active_rate` VALUES ('2407', '47', '1', '74', '0', 'jim145', '1507711615225');
INSERT INTO `account_active_rate` VALUES ('2408', '48', '1', '74', '0', 'bada', '1507711615225');
INSERT INTO `account_active_rate` VALUES ('2409', '49', '1', '74', '0', '罗大大', '1507711615225');
INSERT INTO `account_active_rate` VALUES ('2410', '50', '1', '74', '0', '109', '1507711615225');
INSERT INTO `account_active_rate` VALUES ('2411', '51', '1', '74', '0', '119', '1507711615225');
INSERT INTO `account_active_rate` VALUES ('2412', '52', '1', '74', '0', 'gigi77', '1507711615225');
INSERT INTO `account_active_rate` VALUES ('2413', '53', '1', '74', '0', 'gigi777', '1507711615225');
INSERT INTO `account_active_rate` VALUES ('2414', '55', '1', '74', '0', '111111', '1507711615225');
INSERT INTO `account_active_rate` VALUES ('2415', '56', '1', '74', '0', 'dada', '1507711615225');
INSERT INTO `account_active_rate` VALUES ('2416', '57', '1', '74', '0', '源肥呀', '1507711615225');
INSERT INTO `account_active_rate` VALUES ('2417', '58', '1', '74', '0', '764388753', '1507711617091');
INSERT INTO `account_active_rate` VALUES ('2418', '59', '1', '74', '0', '815555213', '1507711617091');
INSERT INTO `account_active_rate` VALUES ('2419', '61', '1', '74', '0', '无厘头', '1507711617091');
INSERT INTO `account_active_rate` VALUES ('2420', '62', '1', '74', '0', '2630832822', '1507711617091');
INSERT INTO `account_active_rate` VALUES ('2421', '64', '1', '74', '0', '850618', '1507711617091');
INSERT INTO `account_active_rate` VALUES ('2422', '66', '1', '74', '0', '18706732390', '1507711617091');
INSERT INTO `account_active_rate` VALUES ('2423', '67', '1', '74', '0', '灰灰小店', '1507711617091');
INSERT INTO `account_active_rate` VALUES ('2424', '68', '1', '74', '0', 'adidaszxc', '1507711617091');
INSERT INTO `account_active_rate` VALUES ('2425', '69', '1', '74', '0', 'asdfghjkl', '1507711617091');
INSERT INTO `account_active_rate` VALUES ('2426', '70', '1', '74', '0', '15111201915', '1507711617091');
INSERT INTO `account_active_rate` VALUES ('2427', '71', '1', '74', '0', '1550471939', '1507711618953');
INSERT INTO `account_active_rate` VALUES ('2428', '72', '1', '74', '0', '3138108592', '1507711618953');
INSERT INTO `account_active_rate` VALUES ('2429', '73', '1', '74', '0', 'Zippo1995', '1507711618953');
INSERT INTO `account_active_rate` VALUES ('2430', '74', '1', '74', '0', '3330118825', '1507711618953');
INSERT INTO `account_active_rate` VALUES ('2431', '75', '1', '74', '0', '315061813', '1507711618953');
INSERT INTO `account_active_rate` VALUES ('2432', '76', '1', '74', '0', 'AOK', '1507711618953');
INSERT INTO `account_active_rate` VALUES ('2433', '77', '1', '74', '0', '李勇', '1507711618953');
INSERT INTO `account_active_rate` VALUES ('2434', '78', '1', '74', '0', 'boca', '1507711618953');
INSERT INTO `account_active_rate` VALUES ('2435', '79', '1', '74', '0', '15735083175', '1507711618953');
INSERT INTO `account_active_rate` VALUES ('2436', '80', '1', '74', '0', '刘淮槟', '1507711618953');
INSERT INTO `account_active_rate` VALUES ('2437', '81', '1', '74', '0', 'shenyaolin', '1507711621000');
INSERT INTO `account_active_rate` VALUES ('2438', '82', '1', '74', '0', '1452395483', '1507711621000');
INSERT INTO `account_active_rate` VALUES ('2439', '83', '1', '74', '0', '1184164070', '1507711621000');
INSERT INTO `account_active_rate` VALUES ('2440', '84', '1', '74', '0', '1782249351', '1507711621000');
INSERT INTO `account_active_rate` VALUES ('2441', '85', '1', '74', '0', '18291797284', '1507711621000');
INSERT INTO `account_active_rate` VALUES ('2442', '86', '1', '74', '0', '745530430', '1507711621000');
INSERT INTO `account_active_rate` VALUES ('2443', '87', '1', '74', '0', '1648327136', '1507711621000');
INSERT INTO `account_active_rate` VALUES ('2444', '88', '1', '74', '0', '15291739020', '1507711621000');
INSERT INTO `account_active_rate` VALUES ('2445', '89', '1', '74', '0', 'wu159369', '1507711621000');
INSERT INTO `account_active_rate` VALUES ('2446', '90', '1', '74', '0', '2676005659', '1507711621000');
INSERT INTO `account_active_rate` VALUES ('2447', '91', '1', '74', '0', '17608410344', '1507711622480');
INSERT INTO `account_active_rate` VALUES ('2448', '92', '1', '74', '0', '18856960943', '1507711622480');
INSERT INTO `account_active_rate` VALUES ('2449', '93', '1', '74', '0', 'a1579599827', '1507711622480');
INSERT INTO `account_active_rate` VALUES ('2450', '94', '1', '74', '0', '龙龙龙', '1507711622480');
INSERT INTO `account_active_rate` VALUES ('2451', '95', '1', '74', '0', '呵呵哒', '1507711622480');
INSERT INTO `account_active_rate` VALUES ('2452', '96', '1', '74', '0', '1838969699', '1507711622480');
INSERT INTO `account_active_rate` VALUES ('2453', '97', '1', '74', '0', 'zhang2580', '1507711622480');
INSERT INTO `account_active_rate` VALUES ('2454', '98', '1', '74', '0', '250859412', '1507711622480');
INSERT INTO `account_active_rate` VALUES ('2455', '99', '1', '74', '0', '18573748125', '1507711622480');
INSERT INTO `account_active_rate` VALUES ('2456', '100', '1', '74', '0', '1772419834', '1507711622480');
INSERT INTO `account_active_rate` VALUES ('2457', '101', '1', '74', '0', '1923491217', '1507711624450');
INSERT INTO `account_active_rate` VALUES ('2458', '97', '1', '40', '0', 'zhang2580', '1507729315452');
INSERT INTO `account_active_rate` VALUES ('2459', '98', '1', '40', '0', '250859412', '1507729315452');
INSERT INTO `account_active_rate` VALUES ('2460', '99', '1', '40', '0', '18573748125', '1507729315452');
INSERT INTO `account_active_rate` VALUES ('2461', '100', '1', '40', '0', '1772419834', '1507729315452');
INSERT INTO `account_active_rate` VALUES ('2462', '101', '1', '40', '0', '1923491217', '1507729315452');
INSERT INTO `account_active_rate` VALUES ('2463', '99', '1', '60', '0', '18573748125', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('2464', '100', '1', '60', '0', '1772419834', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('2465', '101', '1', '60', '0', '1923491217', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('2466', '102', '1', '60', '0', '15234368403', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('2467', '103', '1', '60', '0', '流量代理', '1507968906448');
INSERT INTO `account_active_rate` VALUES ('2468', '80', '1', '41', '0', '刘淮槟', '1507782648411');
INSERT INTO `account_active_rate` VALUES ('2469', '81', '1', '41', '0', 'shenyaolin', '1507782648411');
INSERT INTO `account_active_rate` VALUES ('2470', '82', '1', '41', '0', '1452395483', '1507782648411');
INSERT INTO `account_active_rate` VALUES ('2471', '83', '1', '41', '0', '1184164070', '1507782648411');
INSERT INTO `account_active_rate` VALUES ('2472', '84', '1', '41', '0', '1782249351', '1507782648411');
INSERT INTO `account_active_rate` VALUES ('2473', '85', '1', '41', '0', '18291797284', '1507782648411');
INSERT INTO `account_active_rate` VALUES ('2474', '86', '1', '41', '0', '745530430', '1507782648411');
INSERT INTO `account_active_rate` VALUES ('2475', '87', '1', '41', '0', '1648327136', '1507782648411');
INSERT INTO `account_active_rate` VALUES ('2476', '88', '1', '41', '0', '15291739020', '1507782648411');
INSERT INTO `account_active_rate` VALUES ('2477', '89', '1', '41', '0', 'wu159369', '1507782648411');
INSERT INTO `account_active_rate` VALUES ('2478', '90', '1', '41', '0', '2676005659', '1507782650297');
INSERT INTO `account_active_rate` VALUES ('2479', '91', '1', '41', '0', '17608410344', '1507782650297');
INSERT INTO `account_active_rate` VALUES ('2480', '92', '1', '41', '0', '18856960943', '1507782650297');
INSERT INTO `account_active_rate` VALUES ('2481', '93', '1', '41', '0', 'a1579599827', '1507782650297');
INSERT INTO `account_active_rate` VALUES ('2482', '94', '1', '41', '0', '龙龙龙', '1507782650297');
INSERT INTO `account_active_rate` VALUES ('2483', '95', '1', '41', '0', '呵呵哒', '1507782650297');
INSERT INTO `account_active_rate` VALUES ('2484', '96', '1', '41', '0', '1838969699', '1507782650297');
INSERT INTO `account_active_rate` VALUES ('2485', '97', '1', '41', '0', 'zhang2580', '1507782650297');
INSERT INTO `account_active_rate` VALUES ('2486', '98', '1', '41', '0', '250859412', '1507782650297');
INSERT INTO `account_active_rate` VALUES ('2487', '99', '1', '41', '0', '18573748125', '1507782650297');
INSERT INTO `account_active_rate` VALUES ('2488', '100', '1', '41', '0', '1772419834', '1507782652596');
INSERT INTO `account_active_rate` VALUES ('2489', '101', '1', '41', '0', '1923491217', '1507782652596');
INSERT INTO `account_active_rate` VALUES ('2490', '102', '1', '41', '0', '15234368403', '1507782652596');
INSERT INTO `account_active_rate` VALUES ('2491', '103', '1', '41', '0', '流量代理', '1507782652596');

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
  `from_account_id` int(11) DEFAULT NULL COMMENT '账户来源id',
  `record_id` bigint(20) DEFAULT NULL COMMENT '消费记录id',
  PRIMARY KEY (`id`),
  KEY `fk_ap_agency` (`account_id`),
  KEY `fk_ap_purchase` (`purchase_id`),
  KEY `fk_ap_rateDiscount` (`rate_discount_id`),
  KEY `fk_ap_record_id` (`record_id`),
  CONSTRAINT `fk_ap_account` FOREIGN KEY (`account_id`) REFERENCES `charge_account` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_ap_purchase` FOREIGN KEY (`purchase_id`) REFERENCES `purchase` (`order_id`) ON DELETE CASCADE,
  CONSTRAINT `fk_ap_record_id` FOREIGN KEY (`record_id`) REFERENCES `charge_record` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=231 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account_purchase
-- ----------------------------
INSERT INTO `account_purchase` VALUES ('29', '2', '734955636709658624', '19', '2.01', '0', '2.01', '123', '3', '系统：待充', '2', '41');
INSERT INTO `account_purchase` VALUES ('30', '1', '734955636709658624', '19', '1.995', '2', '2.01', '123', '3', '系统：待充', '2', '42');
INSERT INTO `account_purchase` VALUES ('31', '2', '734968246582644736', '19', '2.01', '0', '2.01', '123', '3', '系统：待充', '2', '43');
INSERT INTO `account_purchase` VALUES ('32', '1', '734968246582644736', '19', '1.995', '2', '2.01', '123', '3', '系统：待充', '2', '44');
INSERT INTO `account_purchase` VALUES ('33', '1', '734991771976601600', null, '2.85', '0', '2.85', 'xiao', '3', '系统：待充', null, '45');
INSERT INTO `account_purchase` VALUES ('34', '1', '734992684296441856', null, '2.85', '0', '2.85', 'xiao', '3', '系统：待充', null, '46');
INSERT INTO `account_purchase` VALUES ('35', '2', '735263809198886912', '21', '1.74', '0', '1.74', '123', '3', '系统：待充', '2', '48');
INSERT INTO `account_purchase` VALUES ('36', '1', '735263809198886912', '21', '1.71', '2', '1.74', '123', '3', '系统：待充', '2', '49');
INSERT INTO `account_purchase` VALUES ('37', '2', '735556856507797504', '21', '1.74', '0', '1.74', '123', '3', '系统：待充', '2', '50');
INSERT INTO `account_purchase` VALUES ('38', '1', '735556856507797504', '21', '1.71', '2', '1.74', '123', '3', '系统：待充', '2', '51');
INSERT INTO `account_purchase` VALUES ('39', '1', '735565336828448768', '15', '1.71', '0', '1.71', 'xiao', '3', '系统：待充', null, '54');
INSERT INTO `account_purchase` VALUES ('40', '1', '735637674362146816', '25', '0.99', '0', '0.99', 'xiao', '3', '系统：待充', null, '57');
INSERT INTO `account_purchase` VALUES ('41', '1', '735643477341114368', '25', '0.99', '0', '0.99', 'xiao', '3', '系统：待充', null, '58');
INSERT INTO `account_purchase` VALUES ('42', '10', '735691086504136704', '25', '92.4', '0', '92.4', 'hy123', '3', '系统：待充', '10', '60');
INSERT INTO `account_purchase` VALUES ('43', '1', '735691086504136704', '25', '92.4', '2', '92.4', 'hy123', '3', '系统：待充', '10', '61');
INSERT INTO `account_purchase` VALUES ('44', '32', '735696617457324032', '25', '92.4', '0', '92.4', 'wl123', '3', '系统：待充', '32', '62');
INSERT INTO `account_purchase` VALUES ('45', '1', '735696617457324032', '25', '92.4', '2', '92.4', 'wl123', '3', '系统：待充', '32', '63');
INSERT INTO `account_purchase` VALUES ('46', '32', '735696780196319232', '25', '92.4', '0', '92.4', 'wl123', '3', '系统：待充', '32', '64');
INSERT INTO `account_purchase` VALUES ('47', '1', '735696780196319232', '25', '92.4', '2', '92.4', 'wl123', '3', '系统：待充', '32', '65');
INSERT INTO `account_purchase` VALUES ('48', '32', '735701276200800256', '25', '92.4', '0', '92.4', 'wl123', '3', '系统：待充', '32', '66');
INSERT INTO `account_purchase` VALUES ('49', '1', '735701276200800256', '25', '92.4', '2', '92.4', 'wl123', '3', '系统：待充', '32', '67');
INSERT INTO `account_purchase` VALUES ('50', '39', '735918403251867648', '25', '0.99', '0', '0.99', '5257', '3', '系统：待充', '39', '72');
INSERT INTO `account_purchase` VALUES ('51', '1', '735918403251867648', '25', '0.99', '2', '0.99', '5257', '3', '系统：待充', '39', '73');
INSERT INTO `account_purchase` VALUES ('52', '39', '736056020098355200', '25', '0.99', '0', '0.99', '5257', '3', '系统：待充', '39', '76');
INSERT INTO `account_purchase` VALUES ('53', '1', '736056020098355200', '25', '0.99', '2', '0.99', '5257', '3', '系统：待充', '39', '77');
INSERT INTO `account_purchase` VALUES ('54', '39', '736063456880365568', '25', '9.9', '0', '9.9', '5257', '3', '系统：待充', '39', '80');
INSERT INTO `account_purchase` VALUES ('55', '1', '736063456880365568', '25', '9.9', '2', '9.9', '5257', '3', '系统：待充', '39', '81');
INSERT INTO `account_purchase` VALUES ('56', '2', '736283369150615552', '27', '9.9', '0', '9.9', '123', '3', '系统：待充', '2', '86');
INSERT INTO `account_purchase` VALUES ('57', '1', '736283369150615552', '27', '9.9', '2', '9.9', '123', '3', '系统：待充', '2', '87');
INSERT INTO `account_purchase` VALUES ('58', '55', '736322784392646656', '27', '23.1', '0', '23.1', '111111', '3', '系统：待充', '55', '92');
INSERT INTO `account_purchase` VALUES ('59', '1', '736322784392646656', '27', '23.1', '2', '23.1', '111111', '3', '系统：待充', '55', '93');
INSERT INTO `account_purchase` VALUES ('60', '55', '736326301064892416', '27', '21.7', '0', '21.7', '111111', '1', '系统：成功', '55', '96');
INSERT INTO `account_purchase` VALUES ('61', '1', '736326301064892416', '27', '23.1', '2', '21.7', '111111', '1', '系统：成功', '55', '97');
INSERT INTO `account_purchase` VALUES ('62', '7', '736402598193532928', '45', '15.5', '0', '15.5', 'l474705958', '1', '系统：成功', '7', '100');
INSERT INTO `account_purchase` VALUES ('63', '1', '736402598193532928', '45', '15.5', '2', '15.5', 'l474705958', '1', '系统：成功', '7', '101');
INSERT INTO `account_purchase` VALUES ('64', '39', '736437229278203904', '46', '3.1', '0', '3.1', '5257', '1', '系统：成功', '39', '150');
INSERT INTO `account_purchase` VALUES ('65', '1', '736437229278203904', '46', '3.1', '2', '3.1', '5257', '1', '系统：成功', '39', '151');
INSERT INTO `account_purchase` VALUES ('66', '7', '736450404098772992', '46', '15.5', '0', '15.5', 'l474705958', '1', '系统：成功', '7', '152');
INSERT INTO `account_purchase` VALUES ('67', '1', '736450404098772992', '46', '15.5', '2', '15.5', 'l474705958', '1', '系统：成功', '7', '153');
INSERT INTO `account_purchase` VALUES ('68', '7', '736465259857973248', '46', '21.7', '0', '21.7', 'l474705958', '1', '系统：成功', '7', '156');
INSERT INTO `account_purchase` VALUES ('69', '1', '736465259857973248', '46', '21.7', '2', '21.7', 'l474705958', '1', '系统：成功', '7', '157');
INSERT INTO `account_purchase` VALUES ('70', '7', '736465769222639616', '46', '21.7', '0', '21.7', 'l474705958', '1', '系统：成功', '7', '158');
INSERT INTO `account_purchase` VALUES ('71', '1', '736465769222639616', '46', '21.7', '2', '21.7', 'l474705958', '1', '系统：成功', '7', '159');
INSERT INTO `account_purchase` VALUES ('72', '7', '736471316961431552', '46', '40.3', '0', '40.3', 'l474705958', '1', '系统：成功', '7', '160');
INSERT INTO `account_purchase` VALUES ('73', '1', '736471316961431552', '46', '40.3', '2', '40.3', 'l474705958', '1', '系统：成功', '7', '161');
INSERT INTO `account_purchase` VALUES ('74', '7', '736474802667130880', '46', '31', '0', '31', 'l474705958', '1', '系统：成功', '7', '162');
INSERT INTO `account_purchase` VALUES ('75', '1', '736474802667130880', '46', '31', '2', '31', 'l474705958', '1', '系统：成功', '7', '163');
INSERT INTO `account_purchase` VALUES ('76', '3', '736483154348478464', '47', '1.74', '0', '1.74', '456', '0', '手动失败', '3', '166');
INSERT INTO `account_purchase` VALUES ('77', '2', '736483154348478464', '23', '1.71', '2', '1.74', '456', '0', '手动失败', '3', '167');
INSERT INTO `account_purchase` VALUES ('78', '1', '736483154348478464', '23', '1.38', '2', '1.71', '456', '0', '手动失败', '3', '168');
INSERT INTO `account_purchase` VALUES ('79', '7', '736673432812392448', '46', '15.5', '0', '15.5', 'l474705958', '1', '系统：成功', '7', '169');
INSERT INTO `account_purchase` VALUES ('80', '1', '736673432812392448', '46', '15.5', '2', '15.5', 'l474705958', '1', '系统：成功', '7', '170');
INSERT INTO `account_purchase` VALUES ('81', '7', '736709519052115968', '46', '40.3', '0', '40.3', 'l474705958', '1', '系统：成功', '7', '171');
INSERT INTO `account_purchase` VALUES ('82', '1', '736709519052115968', '46', '40.3', '2', '40.3', 'l474705958', '1', '系统：成功', '7', '172');
INSERT INTO `account_purchase` VALUES ('83', '26', '736766071347875840', '46', '21.7', '0', '21.7', 'wxx899999', '1', '系统：成功', '26', '175');
INSERT INTO `account_purchase` VALUES ('84', '1', '736766071347875840', '46', '21.7', '2', '21.7', 'wxx899999', '1', '系统：成功', '26', '176');
INSERT INTO `account_purchase` VALUES ('85', '7', '736777448577830912', '46', '15.5', '0', '15.5', 'l474705958', '1', '系统：成功', '7', '177');
INSERT INTO `account_purchase` VALUES ('86', '1', '736777448577830912', '46', '15.5', '2', '15.5', 'l474705958', '1', '系统：成功', '7', '178');
INSERT INTO `account_purchase` VALUES ('87', '2', '737026017767460864', '23', '1.71', '0', '1.71', '123', '0', '手动失败', '2', '179');
INSERT INTO `account_purchase` VALUES ('88', '1', '737026017767460864', '23', '1.38', '2', '1.71', '123', '0', '手动失败', '2', '180');
INSERT INTO `account_purchase` VALUES ('89', '7', '737078599470813184', '46', '15.5', '0', '15.5', 'l474705958', '1', '系统：成功', '7', '183');
INSERT INTO `account_purchase` VALUES ('90', '1', '737078599470813184', '46', '15.5', '2', '15.5', 'l474705958', '1', '系统：成功', '7', '184');
INSERT INTO `account_purchase` VALUES ('91', '66', '737356742119133184', '30', '50.4', '0', '50.4', '18706732390', '3', '系统：待充', '66', '189');
INSERT INTO `account_purchase` VALUES ('92', '1', '737356742119133184', '30', '50.4', '2', '50.4', '18706732390', '3', '系统：待充', '66', '190');
INSERT INTO `account_purchase` VALUES ('93', '49', '737393706335735808', '49', '32', '0', '32', '罗大大', '1', '系统：成功', '49', '191');
INSERT INTO `account_purchase` VALUES ('94', '1', '737393706335735808', '49', '31', '2', '32', '罗大大', '1', '系统：成功', '49', '192');
INSERT INTO `account_purchase` VALUES ('95', '2', '737424963589378048', '23', '1.71', '0', '1.71', '123', '0', '手动失败', '2', '193');
INSERT INTO `account_purchase` VALUES ('96', '1', '737424963589378048', '23', '1.38', '2', '1.71', '123', '0', '手动失败', '2', '194');
INSERT INTO `account_purchase` VALUES ('97', '7', '737426662303469568', '60', '15', '0', '15', 'l474705958', '3', '系统：待充', '7', '195');
INSERT INTO `account_purchase` VALUES ('98', '1', '737426662303469568', '60', '15', '2', '15', 'l474705958', '3', '系统：待充', '7', '196');
INSERT INTO `account_purchase` VALUES ('99', '7', '737435903391174656', '60', '15', '0', '15', 'l474705958', '1', '系统：成功', '7', '197');
INSERT INTO `account_purchase` VALUES ('100', '1', '737435903391174656', '60', '15', '2', '15', 'l474705958', '1', '系统：成功', '7', '198');
INSERT INTO `account_purchase` VALUES ('101', '38', '737474150049779712', '62', '1.74', '0', '1.74', '770733914', '0', '产品未配置', '38', '201');
INSERT INTO `account_purchase` VALUES ('102', '1', '737474150049779712', '62', '1.74', '2', '1.74', '770733914', '0', '产品未配置', '38', '202');
INSERT INTO `account_purchase` VALUES ('103', '38', '737474886519230464', '62', '1.74', '0', '1.74', '770733914', '3', '系统：待充', '38', '203');
INSERT INTO `account_purchase` VALUES ('104', '1', '737474886519230464', '62', '1.74', '2', '1.74', '770733914', '3', '系统：待充', '38', '204');
INSERT INTO `account_purchase` VALUES ('105', '49', '737483323927957504', '37', '34', '0', '34', '罗大大', '1', '系统：成功', '49', '207');
INSERT INTO `account_purchase` VALUES ('106', '1', '737483323927957504', '37', '32', '2', '34', '罗大大', '1', '系统：成功', '49', '208');
INSERT INTO `account_purchase` VALUES ('107', '49', '737511201176555520', '37', '34', '0', '34', '罗大大', '1', '系统：成功', '49', '211');
INSERT INTO `account_purchase` VALUES ('108', '1', '737511201176555520', '37', '32', '2', '34', '罗大大', '1', '系统：成功', '49', '212');
INSERT INTO `account_purchase` VALUES ('109', '7', '737518833211805696', '60', '15', '0', '15', 'l474705958', '1', '系统：成功', '7', '213');
INSERT INTO `account_purchase` VALUES ('110', '1', '737518833211805696', '60', '15', '2', '15', 'l474705958', '1', '系统：成功', '7', '214');
INSERT INTO `account_purchase` VALUES ('111', '70', '737565376132419584', '63', '16.5', '0', '16.5', '15111201915', '1', '系统：成功', '70', '215');
INSERT INTO `account_purchase` VALUES ('112', '1', '737565376132419584', '63', '17.4', '2', '16.5', '15111201915', '1', '系统：成功', '70', '216');
INSERT INTO `account_purchase` VALUES ('113', '70', '737574547670175744', '63', '27.5', '0', '27.5', '15111201915', '1', '系统：成功', '70', '217');
INSERT INTO `account_purchase` VALUES ('114', '1', '737574547670175744', '63', '29', '2', '27.5', '15111201915', '1', '系统：成功', '70', '218');
INSERT INTO `account_purchase` VALUES ('115', '7', '737739309150375936', '60', '21', '0', '21', 'l474705958', '3', '系统：待充', '7', '219');
INSERT INTO `account_purchase` VALUES ('116', '1', '737739309150375936', '60', '21', '2', '21', 'l474705958', '3', '系统：待充', '7', '220');
INSERT INTO `account_purchase` VALUES ('117', '70', '737754847855513600', '63', '27.5', '0', '27.5', '15111201915', '1', '系统：成功', '70', '221');
INSERT INTO `account_purchase` VALUES ('118', '1', '737754847855513600', '63', '29', '2', '27.5', '15111201915', '1', '系统：成功', '70', '222');
INSERT INTO `account_purchase` VALUES ('119', '7', '737786556068139008', '60', '21.35', '0', '21.35', 'l474705958', '1', '系统：成功', '7', '223');
INSERT INTO `account_purchase` VALUES ('120', '1', '737786556068139008', '60', '21.35', '2', '21.35', 'l474705958', '1', '系统：成功', '7', '224');
INSERT INTO `account_purchase` VALUES ('121', '70', '737915974648336384', '63', '99', '0', '99', '15111201915', '3', '系统：待充', '70', '225');
INSERT INTO `account_purchase` VALUES ('122', '1', '737915974648336384', '63', '104.4', '2', '99', '15111201915', '3', '系统：待充', '70', '226');
INSERT INTO `account_purchase` VALUES ('123', '49', '738216527706198016', '37', '20.4', '0', '20.4', '罗大大', '3', '系统：待充', '49', '227');
INSERT INTO `account_purchase` VALUES ('124', '1', '738216527706198016', '37', '19.2', '2', '20.4', '罗大大', '3', '系统：待充', '49', '228');
INSERT INTO `account_purchase` VALUES ('125', '70', '738228389365682176', '40', '22.25', '0', '22.25', '15111201915', '3', '系统：待充', '70', '229');
INSERT INTO `account_purchase` VALUES ('126', '1', '738228389365682176', '40', '22.25', '2', '22.25', '15111201915', '3', '系统：待充', '70', '230');
INSERT INTO `account_purchase` VALUES ('127', '70', '738296626942054400', '40', '22.25', '0', '22.25', '15111201915', '3', '系统：待充', '70', '231');
INSERT INTO `account_purchase` VALUES ('128', '1', '738296626942054400', '40', '22.25', '2', '22.25', '15111201915', '3', '系统：待充', '70', '232');
INSERT INTO `account_purchase` VALUES ('129', '70', '738473176706584576', '63', '27.5', '0', '27.5', '15111201915', '3', '系统：待充', '70', '233');
INSERT INTO `account_purchase` VALUES ('130', '1', '738473176706584576', '63', '29', '2', '27.5', '15111201915', '3', '系统：待充', '70', '234');
INSERT INTO `account_purchase` VALUES ('131', '49', '738501849455267840', '37', '20.4', '0', '20.4', '罗大大', '1', '系统：成功', '49', '237');
INSERT INTO `account_purchase` VALUES ('132', '1', '738501849455267840', '37', '19.2', '2', '20.4', '罗大大', '1', '系统：成功', '49', '238');
INSERT INTO `account_purchase` VALUES ('133', '49', '738606509579046912', '37', '20.4', '0', '20.4', '罗大大', '3', '系统：待充', '49', '239');
INSERT INTO `account_purchase` VALUES ('134', '1', '738606509579046912', '37', '19.2', '2', '20.4', '罗大大', '3', '系统：待充', '49', '240');
INSERT INTO `account_purchase` VALUES ('135', '7', '738641386844196864', '60', '15.25', '0', '15.25', 'l474705958', '1', '系统：成功', '7', '241');
INSERT INTO `account_purchase` VALUES ('136', '1', '738641386844196864', '60', '15.25', '2', '15.25', 'l474705958', '1', '系统：成功', '7', '242');
INSERT INTO `account_purchase` VALUES ('137', '70', '738814160170651648', '42', '22.4', '0', '22.4', '15111201915', '1', '系统：成功', '70', '243');
INSERT INTO `account_purchase` VALUES ('138', '1', '738814160170651648', '42', '22.4', '2', '22.4', '15111201915', '1', '系统：成功', '70', '244');
INSERT INTO `account_purchase` VALUES ('139', '21', '738829393446572032', '40', '13.35', '0', '13.35', '13771547176', '1', '系统：成功', '21', '247');
INSERT INTO `account_purchase` VALUES ('140', '1', '738829393446572032', '40', '13.35', '2', '13.35', '13771547176', '1', '系统：成功', '21', '248');
INSERT INTO `account_purchase` VALUES ('141', '26', '739006283474014208', '60', '15.25', '0', '15.25', 'wxx899999', '3', '系统：待充', '26', '251');
INSERT INTO `account_purchase` VALUES ('142', '1', '739006283474014208', '58', '15.25', '2', '15.25', 'wxx899999', '3', '系统：待充', '26', '252');
INSERT INTO `account_purchase` VALUES ('143', '1', '739195652445048832', '43', '2.16', '0', '2.16', 'xiao', '3', '系统：待充', '1', '269');
INSERT INTO `account_purchase` VALUES ('144', '49', '739196381788377088', '37', '34', '0', '34', '罗大大', '3', '系统：待充', '49', '270');
INSERT INTO `account_purchase` VALUES ('145', '1', '739196381788377088', '46', '32', '2', '34', '罗大大', '3', '系统：待充', '49', '271');
INSERT INTO `account_purchase` VALUES ('146', '1', '739197587633999872', '43', '21.6', '0', '21.6', 'xiao', '0', '充值失败', '1', '277');
INSERT INTO `account_purchase` VALUES ('147', '1', '739215774945644544', '43', '21.6', '0', '21.6', 'xiao', '0', '充值失败', '1', '278');
INSERT INTO `account_purchase` VALUES ('148', '1', '739301895172001792', '43', '21.6', '0', '21.6', 'xiao', '0', '手动失败', '1', '281');
INSERT INTO `account_purchase` VALUES ('152', '1', '739215774945644544', '43', '21.6', '0', '21.6', 'xiao', '0', '充值失败', '1', '304');
INSERT INTO `account_purchase` VALUES ('153', '1', '739197587633999872', '43', '21.6', '0', '21.6', 'xiao', '0', '充值失败', '1', '305');
INSERT INTO `account_purchase` VALUES ('154', '1', '739215774945644544', '43', '21.6', '0', '21.6', 'xiao', '0', '充值失败', '1', '306');
INSERT INTO `account_purchase` VALUES ('155', '1', '739215774945644544', '43', '21.6', '0', '21.6', 'xiao', '0', '充值失败', '1', '307');
INSERT INTO `account_purchase` VALUES ('156', '7', '740133278421356544', '60', '82.6', '0', '82.6', 'l474705958', '0', '手动失败', '7', '314');
INSERT INTO `account_purchase` VALUES ('157', '1', '740133278421356544', '58', '82.6', '2', '82.6', 'l474705958', '0', '手动失败', '7', '315');
INSERT INTO `account_purchase` VALUES ('158', '7', '740133248167841792', '60', '82.6', '0', '82.6', 'l474705958', '0', '手动失败', '7', '316');
INSERT INTO `account_purchase` VALUES ('159', '1', '740133248167841792', '58', '82.6', '2', '82.6', 'l474705958', '0', '手动失败', '7', '317');
INSERT INTO `account_purchase` VALUES ('160', '7', '740138955063693312', '60', '82.6', '0', '82.6', 'l474705958', '1', '手动成功', '7', '322');
INSERT INTO `account_purchase` VALUES ('161', '1', '740138955063693312', '58', '82.6', '2', '82.6', 'l474705958', '1', '手动成功', '7', '323');
INSERT INTO `account_purchase` VALUES ('162', '7', '740139056565850112', '60', '82.6', '0', '82.6', 'l474705958', '0', '手动失败', '7', '324');
INSERT INTO `account_purchase` VALUES ('163', '1', '740139056565850112', '58', '82.6', '2', '82.6', 'l474705958', '0', '手动失败', '7', '325');
INSERT INTO `account_purchase` VALUES ('164', '49', '740268791644033024', '37', '34', '0', '34', '罗大大', '0', '手动失败', '49', '328');
INSERT INTO `account_purchase` VALUES ('165', '1', '740268791644033024', '46', '32', '2', '34', '罗大大', '0', '手动失败', '49', '329');
INSERT INTO `account_purchase` VALUES ('166', '49', '740274517791739904', '37', '68', '0', '68', '罗大大', '0', '手动失败', '49', '330');
INSERT INTO `account_purchase` VALUES ('167', '1', '740274517791739904', '46', '64', '2', '68', '罗大大', '0', '手动失败', '49', '331');
INSERT INTO `account_purchase` VALUES ('168', '49', '740346861721751552', '37', '34', '0', '34', '罗大大', '0', '手动失败', '49', '332');
INSERT INTO `account_purchase` VALUES ('169', '1', '740346861721751552', '46', '32', '2', '34', '罗大大', '0', '手动失败', '49', '333');
INSERT INTO `account_purchase` VALUES ('170', '66', '740420382313418752', '40', '22.25', '0', '22.25', '18706732390', '0', '手动失败', '66', '334');
INSERT INTO `account_purchase` VALUES ('171', '1', '740420382313418752', '49', '22.25', '2', '22.25', '18706732390', '0', '手动失败', '66', '335');
INSERT INTO `account_purchase` VALUES ('172', '1', '742929196296179712', '58', '9.15', '0', '9.15', 'xiao', '2', '系统：正在充值', '1', '344');
INSERT INTO `account_purchase` VALUES ('173', '1', '742931913827684352', '58', '9.15', '0', '9.15', 'xiao', '2', '系统：正在充值', '1', '345');
INSERT INTO `account_purchase` VALUES ('174', '1', '742935019080650752', '58', '9.15', '0', '9.15', 'xiao', '0', '充值失败', '1', '346');
INSERT INTO `account_purchase` VALUES ('175', '1', '742931913827684352', '58', '9.15', '0', '9.15', 'xiao', '0', '手动失败', '1', '348');
INSERT INTO `account_purchase` VALUES ('176', '1', '742929196296179712', '58', '9.15', '0', '9.15', 'xiao', '0', '手动失败', '1', '349');
INSERT INTO `account_purchase` VALUES ('177', '49', '742952647115411456', '37', '20.4', '0', '20.4', '罗大大', '0', '扣款与成本不符', '49', '350');
INSERT INTO `account_purchase` VALUES ('178', '1', '742952647115411456', '46', '19.2', '2', '20.4', '罗大大', '0', '扣款与成本不符', '49', '351');
INSERT INTO `account_purchase` VALUES ('179', '49', '743141048422764544', '37', '20.4', '0', '20.4', '罗大大', '1', '系统：成功', '49', '354');
INSERT INTO `account_purchase` VALUES ('180', '1', '743141048422764544', '46', '19.2', '2', '20.4', '罗大大', '1', '系统：成功', '49', '355');
INSERT INTO `account_purchase` VALUES ('181', '7', '743367459439906816', '60', '54.9', '0', '54.9', 'l474705958', '1', '系统：成功', '7', '356');
INSERT INTO `account_purchase` VALUES ('182', '1', '743367459439906816', '58', '54.9', '2', '54.9', 'l474705958', '1', '系统：成功', '7', '357');
INSERT INTO `account_purchase` VALUES ('183', '7', '743516322964443136', '60', '15.25', '0', '15.25', 'l474705958', '1', '系统：成功', '7', '358');
INSERT INTO `account_purchase` VALUES ('184', '1', '743516322964443136', '58', '15.25', '2', '15.25', 'l474705958', '1', '系统：成功', '7', '359');
INSERT INTO `account_purchase` VALUES ('185', '49', '743582063717781504', '37', '34', '0', '34', '罗大大', '1', '系统：成功', '49', '360');
INSERT INTO `account_purchase` VALUES ('186', '1', '743582063717781504', '46', '32', '2', '34', '罗大大', '1', '系统：成功', '49', '361');
INSERT INTO `account_purchase` VALUES ('187', '49', '743603552697454592', '41', '32.69', '0', '32.69', '罗大大', '1', '系统：成功', '49', '362');
INSERT INTO `account_purchase` VALUES ('188', '1', '743603552697454592', '50', '32.69', '2', '32.69', '罗大大', '1', '系统：成功', '49', '363');
INSERT INTO `account_purchase` VALUES ('189', '7', '743612742484627456', '60', '39.65', '0', '39.65', 'l474705958', '1', '系统：成功', '7', '364');
INSERT INTO `account_purchase` VALUES ('190', '1', '743612742484627456', '58', '39.65', '2', '39.65', 'l474705958', '1', '系统：成功', '7', '365');
INSERT INTO `account_purchase` VALUES ('191', '7', '743690133676494848', '60', '21.35', '0', '21.35', 'l474705958', '1', '系统：成功', '7', '368');
INSERT INTO `account_purchase` VALUES ('192', '1', '743690133676494848', '58', '21.35', '2', '21.35', 'l474705958', '1', '系统：成功', '7', '369');
INSERT INTO `account_purchase` VALUES ('193', '55', '744029954060062720', '60', '21.35', '0', '21.35', '111111', '1', '系统：成功', '55', '372');
INSERT INTO `account_purchase` VALUES ('194', '1', '744029954060062720', '58', '21.35', '2', '21.35', '111111', '1', '系统：成功', '55', '373');
INSERT INTO `account_purchase` VALUES ('195', '49', '744089071126581248', '37', '47.6', '0', '47.6', '罗大大', '1', '系统：成功', '49', '374');
INSERT INTO `account_purchase` VALUES ('196', '1', '744089071126581248', '46', '44.8', '2', '47.6', '罗大大', '1', '系统：成功', '49', '375');
INSERT INTO `account_purchase` VALUES ('197', '7', '744120431207780352', '60', '54.9', '0', '54.9', 'l474705958', '1', '系统：成功', '7', '376');
INSERT INTO `account_purchase` VALUES ('198', '1', '744120431207780352', '58', '54.9', '2', '54.9', 'l474705958', '1', '系统：成功', '7', '377');
INSERT INTO `account_purchase` VALUES ('199', '7', '744281164637802496', '60', '21.35', '0', '21.35', 'l474705958', '1', '系统：成功', '7', '378');
INSERT INTO `account_purchase` VALUES ('200', '1', '744281164637802496', '58', '21.35', '2', '21.35', 'l474705958', '1', '系统：成功', '7', '379');
INSERT INTO `account_purchase` VALUES ('201', '49', '744367496085114880', '37', '47.6', '0', '47.6', '罗大大', '1', '系统：成功', '49', '382');
INSERT INTO `account_purchase` VALUES ('202', '1', '744367496085114880', '46', '44.8', '2', '47.6', '罗大大', '1', '系统：成功', '49', '383');
INSERT INTO `account_purchase` VALUES ('203', '1', '744762684209106944', '58', '8.7', '0', '8.7', 'xiao', '0', '充值失败', '1', '384');
INSERT INTO `account_purchase` VALUES ('204', '1', '744783096494166016', '58', '8.7', '0', '8.7', 'xiao', '0', '充值失败', '1', '386');
INSERT INTO `account_purchase` VALUES ('205', '2', '744783420676116480', '60', '8.7', '0', '8.7', '123', '0', '充值失败', '2', '387');
INSERT INTO `account_purchase` VALUES ('206', '1', '744783420676116480', '58', '8.7', '2', '8.7', '123', '0', '充值失败', '2', '388');
INSERT INTO `account_purchase` VALUES ('207', '2', '744783669767442432', '60', '8.7', '0', '8.7', '123', '1', '系统：成功', '2', '391');
INSERT INTO `account_purchase` VALUES ('208', '1', '744783669767442432', '58', '8.7', '2', '8.7', '123', '1', '系统：成功', '2', '392');
INSERT INTO `account_purchase` VALUES ('209', '2', '744784836631203840', '60', '8.7', '0', '8.7', '123', '0', '充值失败', '2', '394');
INSERT INTO `account_purchase` VALUES ('210', '1', '744784836631203840', '58', '8.7', '2', '8.7', '123', '0', '充值失败', '2', '395');
INSERT INTO `account_purchase` VALUES ('211', '2', '744784864061952000', '60', '14.5', '0', '14.5', '123', '1', '系统：成功', '2', '396');
INSERT INTO `account_purchase` VALUES ('212', '1', '744784864061952000', '58', '14.5', '2', '14.5', '123', '1', '系统：成功', '2', '397');
INSERT INTO `account_purchase` VALUES ('213', '96', '745084487909511168', '73', '12.5', '0', '12.5', '1838969699', '0', '请检查scope', '96', '402');
INSERT INTO `account_purchase` VALUES ('214', '1', '745084487909511168', '68', '12.5', '2', '12.5', '1838969699', '0', '请检查scope', '96', '403');
INSERT INTO `account_purchase` VALUES ('215', '96', '745084490442870784', '73', '12.5', '0', '12.5', '1838969699', '0', '请检查scope', '96', '404');
INSERT INTO `account_purchase` VALUES ('216', '1', '745084490442870784', '68', '12.5', '2', '12.5', '1838969699', '0', '请检查scope', '96', '405');
INSERT INTO `account_purchase` VALUES ('217', '96', '745084491248177152', '73', '12.5', '0', '12.5', '1838969699', '0', '请检查scope', '96', '406');
INSERT INTO `account_purchase` VALUES ('218', '1', '745084491248177152', '68', '12.5', '2', '12.5', '1838969699', '0', '请检查scope', '96', '407');
INSERT INTO `account_purchase` VALUES ('219', '96', '745084491994763264', '73', '12.5', '0', '12.5', '1838969699', '0', '请检查scope', '96', '408');
INSERT INTO `account_purchase` VALUES ('220', '1', '745084491994763264', '68', '12.5', '2', '12.5', '1838969699', '0', '请检查scope', '96', '409');
INSERT INTO `account_purchase` VALUES ('221', '96', '745084491994763264', '73', '12.5', '0', '12.5', '1838969699', '0', '请检查scope', null, '410');
INSERT INTO `account_purchase` VALUES ('222', '1', '745084491994763264', '68', '12.5', '2', '12.5', '1838969699', '0', '请检查scope', null, '411');
INSERT INTO `account_purchase` VALUES ('223', '96', '745084491248177152', '73', '12.5', '0', '12.5', '1838969699', '0', '请检查scope', null, '412');
INSERT INTO `account_purchase` VALUES ('224', '1', '745084491248177152', '68', '12.5', '2', '12.5', '1838969699', '0', '请检查scope', null, '413');
INSERT INTO `account_purchase` VALUES ('225', '96', '745084490442870784', '73', '12.5', '0', '12.5', '1838969699', '0', '请检查scope', null, '414');
INSERT INTO `account_purchase` VALUES ('226', '1', '745084490442870784', '68', '12.5', '2', '12.5', '1838969699', '0', '请检查scope', null, '415');
INSERT INTO `account_purchase` VALUES ('227', '96', '745084487909511168', '73', '12.5', '0', '12.5', '1838969699', '0', '请检查scope', null, '416');
INSERT INTO `account_purchase` VALUES ('228', '1', '745084487909511168', '68', '12.5', '2', '12.5', '1838969699', '0', '请检查scope', null, '417');
INSERT INTO `account_purchase` VALUES ('229', '1', '745096436680495104', '58', '2.7', '0', '2.7', 'xiao', '0', '充值失败', '1', '418');
INSERT INTO `account_purchase` VALUES ('230', '1', '745096436680495104', '58', '2.7', '0', '2.7', 'xiao', '0', '充值失败', null, '419');

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
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of agency_backward
-- ----------------------------
INSERT INTO `agency_backward` VALUES ('1', '0', 'xiao', 'xiao', 'xiaoqiang', '', '3004569972&123', '', '', null, '1506068581040', 'XXM4', null, '1', null);
INSERT INTO `agency_backward` VALUES ('2', '1', '123', '123', '123', '123', '1727661035', '1727661035@qq.com', '江西省永丰', null, '1505095878921', 'W6C2', '8a982a8a5e9fd1c1015e9fd1c1900000', '1', null);
INSERT INTO `agency_backward` VALUES ('3', '2', '456', '456', '123', '123', '123', '123@456', '123', null, '1505099730745', '', null, '0', null);
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
INSERT INTO `agency_backward` VALUES ('29', '1', 'zxx', 'zxx123', '张爻', '15664888254', '3004569972', '1054567997@qq.com', '', null, '1505998717563', '6M6V', null, '0', null);
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
INSERT INTO `agency_backward` VALUES ('48', '1', '罗大大', '201103', '罗志远', '18047122202', '3004569972&https://jq.qq.com/?_wv=1027&k=5LsPTwa', '27579080@qq.com', '', null, '1506063260895', 'H43Q', null, '0', null);
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
INSERT INTO `agency_backward` VALUES ('60', '1', '2630832822', 'huaidanhxj', '吴德涛', '15914190584', '2630032822', '2630032822@qq.com', '', null, '1506012779835', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('61', '48', '15754715147', '948109abc', '韩龙龙', '15754715147', '948109387', '15754715147@139.com', '', null, '1506065408546', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('62', '1', '850618', '850618', '中路', '15829179296', '1259667530', '1259667530@qq.com', '', null, '1506071571454', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('63', '14', '113', '113', '113', '113', '113', '113@QQ.COM', '', null, '1506083968855', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('64', '1', '18706732390', 'hou77833', '小白', '18706732390', '1048574954', 'www.1048574954.@com', '', null, '1506087627571', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('65', '1', '灰灰小店', '20090207d.', '陈贞辉', '13623004660', '164113922', '164113922@qq.com', '', null, '1506131856823', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('66', '1', 'adidaszxc', 'zxc515634', '啊啊啊', '', '', '', '', null, '1506149036313', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('67', '1', 'asdfghjkl', 'huaidanhxj', '林义雄', '15914190584', '2630032822', '2630032822@qq.com', '', null, '1506150395819', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('68', '1', '15111201915', '15111201915', '15111201915', '15111201915', '158261291', '374556514@qq.com', '', null, '1506150488333', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('69', '1', '1550471939', '13935419815..', '荣有旺', '13935419815', '1550471939', '1550471939@qq.com', '', null, '1506150582545', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('70', '1', '3138108592', '123456', '刘钰浩', '17638831417', '3138108592', '3138108592@qq.com', '', null, '1506151459080', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('71', '1', 'Zippo1995', '746839107lzp', '刘子鹏', '13268389392', '746839107', '746839107@qq.com', '', null, '1506152721995', 'APLX', null, '0', null);
INSERT INTO `agency_backward` VALUES ('72', '1', '3330118825', 'chenjie1346790ww', '李元芳', '15691556552', '3330118825', '3330118825@qq.com', '', null, '1506151489453', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('73', '1', '315061813', 'zl766521', '蒲小军', '18691693056', '1453701215', '1453701215@qq.com', '', null, '1506151758251', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('74', '1', 'AOK', 'yiranaini520', '胡苗苗', '18202933064', '1127737619', '1127737619@qq.com', '', null, '1506154419416', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('75', '1', '李勇', '15903421371afen', '李勇', '18822048702', '429495590', '429495590@qq.com', '', null, '1506154530055', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('76', '1', 'boca', 'hello666', '大陈', '13268215213', '944125455', '944125455@qq.com', '', null, '1506154573078', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('77', '1', '15735083175', '123456qq', '江子川', '15735083175', '2825088095', '1254822700@qq.com', '', null, '1506154607648', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('78', '1', '刘淮槟', '123456', '刘淮槟', '18595742682', '2015649127', '2015649127@qq.com', '', null, '1506160103445', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('79', '1', 'shenyaolin', 'qwerty', '申耀林', '13935563245', '1164405824', '1164405824@qq.com', '', null, '1506164128238', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('80', '1', '1452395483', 'qzl520..', '覃子龙', '18785351874', '1452395483', '1452395483@qq.com', '', null, '1506164197305', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('81', '1', '1184164070', 'fjx521', '樊济鑫', '18236193613', '1184164070', '1184164070@qq.com', '', null, '1506164658879', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('82', '1', '1782249351', 'lm1782249351', '李明', '15610362492', '1782249351', '1782249351@qq.com', '', null, '1506165109254', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('83', '1', '18291797284', 'jiying', '寄莹', '18291797284', '995859748', '995859748@qq.com', '', null, '1506166947046', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('84', '1', '745530430', 'cc2233', '孙金', '15889803060', '745530430', '745530430@qq.com', '', null, '1506248616111', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('85', '1', '1648327136', '619707', '张海静', '15349513201', '1648327136', '1648327136@qq.com', '', null, '1506265696008', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('86', '1', '15291739020', 'zl76521', '蒲小军', '15291739020', '1453701215', '1453701215@qq.com', '', null, '1506336564872', 'CTE9', null, '0', null);
INSERT INTO `agency_backward` VALUES ('87', '1', 'wu159369', 'wxb159369', '武鑫斌', '13991508532', '1796571526', '1796571526@qq.com', '', null, '1506520717000', 'wu159369', null, '0', null);
INSERT INTO `agency_backward` VALUES ('88', '1', '2676005659', 'yjf1998020600', '筱俊', '18311882425', '2676005659', '2676005659@qq.com', '', null, '1506669491807', '2676005659', null, '0', null);
INSERT INTO `agency_backward` VALUES ('89', '1', '17608410344', 'aa13575112702', '周冬鑫', '17608410344', '1814248731', '1814248731@qq.com', '', null, '1506752267915', '17608410344', null, '0', null);
INSERT INTO `agency_backward` VALUES ('90', '1', '18856960943', '1542158150', '张羽', '18856960943', '374802558', '374802558@qq.com', '', null, '1506781460372', '18856960943', null, '0', null);
INSERT INTO `agency_backward` VALUES ('91', '1', 'a1579599827', 'asd123456', '倾城', '18863516250', '1579599827', '1579599827@qq.com', '', null, '1506909889709', 'a1579599827', null, '0', null);
INSERT INTO `agency_backward` VALUES ('92', '1', '龙龙龙', '15766392806', '', '15766392806', '844068975', '', '', null, '1507299374951', '龙龙龙', null, '0', null);
INSERT INTO `agency_backward` VALUES ('93', '1', '呵呵哒', '14600685072', '万宇鑫', '13647087230', '1460685072', '1460685072@qq.com', '', null, '1507317983470', '呵呵哒', null, '0', null);
INSERT INTO `agency_backward` VALUES ('94', '1', '1838969699', '430918', '浩东', '17777059187', '1838969699', '1838969699@qq.com', '', null, '1507372727873', '1838969699', null, '0', null);
INSERT INTO `agency_backward` VALUES ('95', '1', 'zhang2580', 'sive300', '张宝平', '18292730453', '2015972481', '2015972481@qq.com', '', null, '1507458490630', 'zhang2580', null, '0', null);
INSERT INTO `agency_backward` VALUES ('96', '1', '250859412', 'e1314521', '刘飞', '18729227220', '250859412', '250859412@qq.com', '', null, '1507542439129', '250859412', null, '0', null);
INSERT INTO `agency_backward` VALUES ('97', '1', '18573748125', 'lichen357357357', '李晨阳', '18573748125', '2199681986', '2199681986@qq.com', '', null, '1507558520330', '18573748125', null, '0', null);
INSERT INTO `agency_backward` VALUES ('98', '1', '1772419834', '13516832480', '杨欣宇', '13516832480', '1772419834', '1772419834@qq.com', '', null, '1507731791311', '1772419834', null, '0', null);
INSERT INTO `agency_backward` VALUES ('99', '1', '1923491217', 'zyf52007040321', '张友福', '18225994559', '1923491217', '1923491217@qq.com', '', null, '1507640802668', '1923491217', null, '0', null);
INSERT INTO `agency_backward` VALUES ('100', '1', '15234368403', '15234368403.', '宁晓东', '15234368403', '3098943347', '3098943347@qq.com', '', null, '1507742144041', '15234368403', null, '0', null);
INSERT INTO `agency_backward` VALUES ('101', '1', '流量代理', 'xing0815000', '弓合兴', '18700388660', '260057405', 'www.260057405@qq.com', '', null, '1507783168938', 'D3QH', null, '0', null);
INSERT INTO `agency_backward` VALUES ('102', '1', 'ywjshuang', 'shuangywj', '严武军', '13570491764', '334193994', '334193994@qq.com', '', null, '1507943609099', 'ywjshuang', null, '0', null);

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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bank_account
-- ----------------------------
INSERT INTO `bank_account` VALUES ('6', '2', '建行卡', '6217002020019622232', '宁强', '2999', '2', null, '1');
INSERT INTO `bank_account` VALUES ('7', '1', '支付宝', '3271794088@qq.com', '南昌微族科技有限公司', '10001', '1', null, '1');
INSERT INTO `bank_account` VALUES ('8', '100', '支付宝', '3271794088@qq.com', '南昌微族科技有限公司', null, '1', '1', '1');
INSERT INTO `bank_account` VALUES ('9', '103', '支付宝', '3271794088@qq.com', '南昌微族科技有限公司', null, '1', '1', '1');
INSERT INTO `bank_account` VALUES ('10', '2', '支付宝', '3271794088@qq.com', '南昌微族科技有限公司', null, '1', '1', '1');
INSERT INTO `bank_account` VALUES ('11', '102', '支付宝', '3271794088@qq.com', '南昌微族科技有限公司', null, '1', '1', '1');
INSERT INTO `bank_account` VALUES ('12', '1', '微信；微信加款亲先添加我们微信账号', '微信账户：vz0523 急请拨打：17707005023 筱兵', '何兵', '1', '1', null, '1');
INSERT INTO `bank_account` VALUES ('13', '1', '招商银行：开户行：南昌分行艾溪湖支行', '6214 8379 0901 2191', '何兵', '1', '1', null, '1');
INSERT INTO `bank_account` VALUES ('14', '28', '中国银行——开户行：南昌瑶湖支行', '197734842069', '南昌微族科技有限公司', '1', '1', null, '1');
INSERT INTO `bank_account` VALUES ('15', '104', '支付宝', '3271794088@qq.com', '南昌微族科技有限公司', null, '1', '1', '1');
INSERT INTO `bank_account` VALUES ('16', '104', '微信；微信加款亲先添加我们微信账号', '微信账户：vz0523 急请拨打：17707005023 筱兵', '何兵', null, '1', '1', '1');
INSERT INTO `bank_account` VALUES ('17', '104', '招商银行：开户行：南昌分行艾溪湖支行', '6214 8379 0901 2191', '何兵', null, '1', '1', '1');
INSERT INTO `bank_account` VALUES ('18', '2', '微信；微信加款亲先添加我们微信账号', '微信账户：vz0523 急请拨打：17707005023 筱兵', '何兵', null, '1', '1', '1');
INSERT INTO `bank_account` VALUES ('19', '2', '招商银行：开户行：南昌分行艾溪湖支行', '6214 8379 0901 2191', '何兵', null, '1', '1', '1');
INSERT INTO `bank_account` VALUES ('20', '54', '中国银行——开户行：南昌瑶湖支行', '197734842069', '南昌微族科技有限公司', null, '1', '1', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of channel_channel
-- ----------------------------
INSERT INTO `channel_channel` VALUES ('30', '微族-宁夏本地', '10& 30& 70& 150& 500& 1024& 2048& 3072& 4096& 6144& 11264', '32', null, null, null, null, '0', '0', '1505784729788', '1');
INSERT INTO `channel_channel` VALUES ('46', '省漫游-微族-陕西移动', '10& 30& 70& 100& 150& 300& 500& 1024& 2048& 3072& 4096& 6144& 11264', '32', null, null, null, null, '0', '0', '1507543188842', '1');
INSERT INTO `channel_channel` VALUES ('47', '微族-黑龙江移动', '10& 30& 70& 100& 150& 300& 500& 1024& 2048& 3072& 4096& 6144& 11264', '32', null, null, null, null, '0', '0', '1506143858695', '1');
INSERT INTO `channel_channel` VALUES ('48', '微族-广东特殊包', '300', '32', null, null, null, null, '0', '0', '1505900431526', '1');
INSERT INTO `channel_channel` VALUES ('49', '省漫游-微族-内蒙古移动', '10& 30& 70& 100& 150& 300& 500& 1024& 2048& 3072& 4096& 6144& 11264', '32', null, null, null, null, '0', '0', '1506152015327', '1');
INSERT INTO `channel_channel` VALUES ('51', '微族-山东移动', '10& 30& 70& 100& 150& 300& 500& 1024& 2048& 4096& 3072& 6144& 11264', '32', null, null, null, null, '0', '0', null, '1');
INSERT INTO `channel_channel` VALUES ('52', '微族-浙江移动', '10& 30& 70& 100& 150& 300& 500& 1024& 2048& 3072& 4096& 6144& 11264', '32', null, null, null, null, '0', '0', '1506144099810', '1');
INSERT INTO `channel_channel` VALUES ('53', '微族-山西移动', '10& 30& 70& 100& 150& 300& 500& 1024& 2048& 3072& 4096& 6144& 11264', '32', null, null, null, null, '0', '0', '1505900423985', '1');
INSERT INTO `channel_channel` VALUES ('56', '省漫游-微族-安徽移动', '10& 30& 70& 100& 150& 300& 500& 1024& 2048', '32', null, null, null, null, '0', '0', '1507542534022', '1');
INSERT INTO `channel_channel` VALUES ('57', '省漫游-微族-湖南移动', '10& 30& 70& 100& 150& 300& 500& 1024& 2048& 3072& 4096& 6144& 11264', '32', null, null, null, null, '0', '0', '1506151930428', '1');
INSERT INTO `channel_channel` VALUES ('61', '省内-微族-陕西本地移动', '500& 1024& 2048& 3072& 4096& 6144& 11264& 100& 300', '32', null, null, null, null, '0', '0', '1507968920699', '1');
INSERT INTO `channel_channel` VALUES ('64', '微族-广东移动', '500& 1024& 2048& 3072& 4096& 6144& 11264', '32', null, null, null, null, '0', '1', '1506396313603', '1');
INSERT INTO `channel_channel` VALUES ('65', '微族-山西省内', '10& 30& 70& 150& 500& 1024& 2048& 3072& 4096& 6144& 11264', '32', null, null, null, null, '0', '0', null, '1');
INSERT INTO `channel_channel` VALUES ('66', '微族-河南移动', '10& 30& 70& 100& 150& 300& 500& 1024& 2048& 3072& 4096& 6144& 11264', '32', null, null, null, null, '0', '0', null, '1');
INSERT INTO `channel_channel` VALUES ('67', '微族-北京移动', '10& 70&  150&  500& 1024', '32', null, null, null, null, '0', '0', null, '1');
INSERT INTO `channel_channel` VALUES ('68', '微族-广西移动', '300& 500& 1024', '32', null, null, null, null, '0', '0', null, '1');
INSERT INTO `channel_channel` VALUES ('69', '微族-广东移动', '100', '32', null, null, null, null, '0', '0', null, '1');
INSERT INTO `channel_channel` VALUES ('70', '微族-广东移动', '10& 30& 70& 150& 500& 1024& 2048& 3072& 4096& 6144& 11264', '32', null, null, null, null, '0', '0', null, '1');
INSERT INTO `channel_channel` VALUES ('71', '微族-新疆电信', '50& 30& 100& 200& 300& 500& 1024', '32', null, null, null, null, '0', '0', null, '1');
INSERT INTO `channel_channel` VALUES ('72', '微族-吉林联通', '20& 50& 100& 200& 500', '32', null, null, null, null, '0', '0', null, '1');
INSERT INTO `channel_channel` VALUES ('73', '微族-陕西电信', '5& 30& 10& 100& 200& 300& 500& 1024', '32', null, null, null, null, '0', '0', null, '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of channel_discount
-- ----------------------------
INSERT INTO `channel_discount` VALUES ('27', '30', '29', '0.47', '省内-微族-宁夏本地', '0', '0', '1', '0');
INSERT INTO `channel_discount` VALUES ('43', '46', '26', '0.668', '省漫游-微族-陕西移动', '0', '0', '2', '0');
INSERT INTO `channel_discount` VALUES ('44', '47', '08', '0.76', '省漫游-微族-黑龙江移动', '0', '0', '2', '0');
INSERT INTO `channel_discount` VALUES ('45', '48', '19', '0.7', '省漫游-微族-广东特殊包', '0', '0', '2', '0');
INSERT INTO `channel_discount` VALUES ('46', '49', '05', '0.64', '省漫游-微族-内蒙古移动', '0', '0', '2', '0');
INSERT INTO `channel_discount` VALUES ('48', '51', '15', '0.612', '省漫游-微族-山东移动', '0', '0', '2', '0');
INSERT INTO `channel_discount` VALUES ('49', '52', '11', '0.445', '省漫游-微族-浙江移动', '0', '0', '2', '0');
INSERT INTO `channel_discount` VALUES ('50', '53', '04', '0.467', '省漫游-微族-山西移动', '0', '0', '2', '0');
INSERT INTO `channel_discount` VALUES ('53', '56', '12', '0.44', '省漫游-微族-安徽移动', '0', '0', '2', '0');
INSERT INTO `channel_discount` VALUES ('54', '57', '18', '0.782', '省漫游-微族-湖南移动', '0', '0', '2', '0');
INSERT INTO `channel_discount` VALUES ('58', '61', '26', '0.27', '省内-微族-陕西本地移动', '0', '0', '1', '0');
INSERT INTO `channel_discount` VALUES ('61', '64', '19', '0.58', '微族-广东移动', '0', '0', '2', '0');
INSERT INTO `channel_discount` VALUES ('62', '65', '04', '0.41', '微族-山西省内', '0', '0', '1', '0');
INSERT INTO `channel_discount` VALUES ('63', '66', '16', '0.72', '微族-河南移动', '0', '0', '2', '0');
INSERT INTO `channel_discount` VALUES ('64', '67', '01', '0.69', '微族-北京移动', '0', '0', '2', '0');
INSERT INTO `channel_discount` VALUES ('65', '68', '20', '0.65', '微族-广西移动', '0', '0', '2', '0');
INSERT INTO `channel_discount` VALUES ('66', '69', '19', '0.45', '微族-广东移动', '0', '0', '2', '0');
INSERT INTO `channel_discount` VALUES ('67', '70', '19', '0.7', '微族-广东移动', '0', '0', '2', '0');
INSERT INTO `channel_discount` VALUES ('68', '71', '30', '0.25', '微族-新疆电信', '2', '0', '1', '0');
INSERT INTO `channel_discount` VALUES ('69', '72', '07', '0.375', '微族-吉林联通', '1', '0', '1', '0');
INSERT INTO `channel_discount` VALUES ('70', '73', '26', '0.535', '微族-陕西电信', '2', '0', '2', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of charge_account
-- ----------------------------
INSERT INTO `charge_account` VALUES ('1', '-101326.075', null, null, '0', '1', '0', null, '1495689716779', null);
INSERT INTO `charge_account` VALUES ('2', '99', '中国银行', '123', '0', '2', '0', null, '1505095878921', '123');
INSERT INTO `charge_account` VALUES ('3', '100', null, null, '0', '3', '0', null, '1505099730745', '456');
INSERT INTO `charge_account` VALUES ('4', '0', null, null, '0', '4', '0', null, '1505389590642', 'wzkj');
INSERT INTO `charge_account` VALUES ('5', '0', null, null, '0', '5', '0', null, '1505397230874', '冰河');
INSERT INTO `charge_account` VALUES ('6', '0', '121212', '121212', '0', '6', '0', null, '1505402408521', 'jiafeng');
INSERT INTO `charge_account` VALUES ('7', '410.9', null, null, '0', '7', '0', null, '1505451449663', 'l474705958');
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
INSERT INTO `charge_account` VALUES ('21', '1.65', null, null, '0', '21', '0', null, '1505704868970', '13771547176');
INSERT INTO `charge_account` VALUES ('22', '0', null, null, '0', '22', '0', null, '1505712635147', '1');
INSERT INTO `charge_account` VALUES ('23', '0', null, null, '0', '23', '0', null, '1505719976694', '小aq');
INSERT INTO `charge_account` VALUES ('24', '0', null, null, '0', '24', '0', null, '1505720371086', '15914897978');
INSERT INTO `charge_account` VALUES ('25', '0', null, null, '0', '25', '0', null, '1505720890798', 'oushinanshen');
INSERT INTO `charge_account` VALUES ('26', '13.05', null, null, '0', '26', '0', null, '1505722102442', 'wxx899999');
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
INSERT INTO `charge_account` VALUES ('38', '13.48', '支付宝', '15766031847', '0', '37', '0', null, '1505743787277', '770733914');
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
INSERT INTO `charge_account` VALUES ('49', '172.01', null, null, '0', '48', '0', null, '1505777025121', '罗大大');
INSERT INTO `charge_account` VALUES ('50', '0', null, null, '0', '49', '0', null, '1505780699506', '109');
INSERT INTO `charge_account` VALUES ('51', '0', null, null, '0', '50', '0', null, '1505781054289', '119');
INSERT INTO `charge_account` VALUES ('52', '0', null, null, '0', '51', '0', null, '1505783246196', 'gigi77');
INSERT INTO `charge_account` VALUES ('53', '0', null, null, '0', '52', '0', null, '1505783990311', 'gigi777');
INSERT INTO `charge_account` VALUES ('54', '0', null, null, '0', '2', '1', null, '1505874476912', '123');
INSERT INTO `charge_account` VALUES ('55', '5.55', null, null, '0', '53', '0', null, '1505880444101', '111111');
INSERT INTO `charge_account` VALUES ('56', '0', null, null, '0', '54', '0', null, '1505880504457', 'dada');
INSERT INTO `charge_account` VALUES ('57', '0', null, null, '0', '55', '0', null, '1505883026363', '源肥呀');
INSERT INTO `charge_account` VALUES ('58', '0', null, null, '0', '56', '0', null, '1505956994305', '764388753');
INSERT INTO `charge_account` VALUES ('59', '0', null, null, '0', '57', '0', null, '1505957853277', '815555213');
INSERT INTO `charge_account` VALUES ('60', '0', null, null, '0', '58', '0', null, '1505983584355', '无叮咚');
INSERT INTO `charge_account` VALUES ('61', '0', null, null, '0', '59', '0', null, '1505983878309', '无厘头');
INSERT INTO `charge_account` VALUES ('62', '0', null, null, '0', '60', '0', null, '1506012779835', '2630832822');
INSERT INTO `charge_account` VALUES ('63', '0', null, null, '0', '61', '0', null, '1506065408546', '15754715147');
INSERT INTO `charge_account` VALUES ('64', '0', null, null, '0', '62', '0', null, '1506071571454', '850618');
INSERT INTO `charge_account` VALUES ('65', '0', null, null, '0', '63', '0', null, '1506083968855', '113');
INSERT INTO `charge_account` VALUES ('66', '100', null, null, '0', '64', '0', null, '1506087627571', '18706732390');
INSERT INTO `charge_account` VALUES ('67', '0', null, null, '0', '65', '0', null, '1506131856823', '灰灰小店');
INSERT INTO `charge_account` VALUES ('68', '0', null, null, '0', '66', '0', null, '1506149036313', 'adidaszxc');
INSERT INTO `charge_account` VALUES ('69', '0', null, null, '0', '67', '0', null, '1506150395819', 'asdfghjkl');
INSERT INTO `charge_account` VALUES ('70', '1935.1', null, null, '0', '68', '0', null, '1506150488333', '15111201915');
INSERT INTO `charge_account` VALUES ('71', '0', null, null, '0', '69', '0', null, '1506150582545', '1550471939');
INSERT INTO `charge_account` VALUES ('72', '0', null, null, '0', '70', '0', null, '1506151459080', '3138108592');
INSERT INTO `charge_account` VALUES ('73', '0', null, null, '0', '71', '0', null, '1506151474607', 'Zippo1995');
INSERT INTO `charge_account` VALUES ('74', '0', null, null, '0', '72', '0', null, '1506151489453', '3330118825');
INSERT INTO `charge_account` VALUES ('75', '0', null, null, '0', '73', '0', null, '1506151758251', '315061813');
INSERT INTO `charge_account` VALUES ('76', '0', null, null, '0', '74', '0', null, '1506154419416', 'AOK');
INSERT INTO `charge_account` VALUES ('77', '0', null, null, '0', '75', '0', null, '1506154530055', '李勇');
INSERT INTO `charge_account` VALUES ('78', '0', null, null, '0', '76', '0', null, '1506154573078', 'boca');
INSERT INTO `charge_account` VALUES ('79', '0', null, null, '0', '77', '0', null, '1506154607648', '15735083175');
INSERT INTO `charge_account` VALUES ('80', '0', null, null, '0', '78', '0', null, '1506160103445', '刘淮槟');
INSERT INTO `charge_account` VALUES ('81', '0', null, null, '0', '79', '0', null, '1506164128238', 'shenyaolin');
INSERT INTO `charge_account` VALUES ('82', '0', null, null, '0', '80', '0', null, '1506164197305', '1452395483');
INSERT INTO `charge_account` VALUES ('83', '0', null, null, '0', '81', '0', null, '1506164658879', '1184164070');
INSERT INTO `charge_account` VALUES ('84', '0', null, null, '0', '82', '0', null, '1506165109254', '1782249351');
INSERT INTO `charge_account` VALUES ('85', '0', null, null, '0', '83', '0', null, '1506166947046', '18291797284');
INSERT INTO `charge_account` VALUES ('86', '0', null, null, '0', '84', '0', null, '1506248616111', '745530430');
INSERT INTO `charge_account` VALUES ('87', '0', null, null, '0', '85', '0', null, '1506265696008', '1648327136');
INSERT INTO `charge_account` VALUES ('88', '0', null, null, '0', '86', '0', null, '1506336546551', '15291739020');
INSERT INTO `charge_account` VALUES ('89', '0', null, null, '0', '87', '0', null, '1506520717000', 'wu159369');
INSERT INTO `charge_account` VALUES ('90', '0', null, null, '0', '88', '0', null, '1506669491807', '2676005659');
INSERT INTO `charge_account` VALUES ('91', '0', null, null, '0', '89', '0', null, '1506752267915', '17608410344');
INSERT INTO `charge_account` VALUES ('92', '0', null, null, '0', '90', '0', null, '1506781460372', '18856960943');
INSERT INTO `charge_account` VALUES ('93', '0', null, null, '0', '91', '0', null, '1506909889709', 'a1579599827');
INSERT INTO `charge_account` VALUES ('94', '0', null, null, '0', '92', '0', null, '1507299374951', '龙龙龙');
INSERT INTO `charge_account` VALUES ('95', '0', null, null, '0', '93', '0', null, '1507317983470', '呵呵哒');
INSERT INTO `charge_account` VALUES ('96', '200', null, null, '0', '94', '0', null, '1507372727873', '1838969699');
INSERT INTO `charge_account` VALUES ('97', '0', null, null, '0', '95', '0', null, '1507458490630', 'zhang2580');
INSERT INTO `charge_account` VALUES ('98', '0', null, null, '0', '96', '0', null, '1507542439129', '250859412');
INSERT INTO `charge_account` VALUES ('99', '0', null, null, '0', '97', '0', null, '1507558520330', '18573748125');
INSERT INTO `charge_account` VALUES ('100', '0', null, null, '0', '98', '0', null, '1507638798048', '1772419834');
INSERT INTO `charge_account` VALUES ('101', '0', null, null, '0', '99', '0', null, '1507640802668', '1923491217');
INSERT INTO `charge_account` VALUES ('102', '0', null, null, '0', '100', '0', null, '1507742144041', '15234368403');
INSERT INTO `charge_account` VALUES ('103', '5', null, null, '0', '101', '0', null, '1507780843148', '流量代理');
INSERT INTO `charge_account` VALUES ('104', '0', null, null, '0', '102', '0', null, '1507943609099', 'ywjshuang');

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
  CONSTRAINT `fk_cr_account` FOREIGN KEY (`account_id`) REFERENCES `charge_account` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=420 DEFAULT CHARSET=utf8;

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
INSERT INTO `charge_record` VALUES ('177', '1505989541449', '15.5', '798.5', '783', '1', '7', '1', '736777448577830912');
INSERT INTO `charge_record` VALUES ('178', '1505989541478', '15.5', '-99477.745', '-99493.245', '1', '1', '1', '736777448577830912');
INSERT INTO `charge_record` VALUES ('179', '1506048804963', '1.71', '109.59', '107.88', '1', '2', '1', '737026017767460864');
INSERT INTO `charge_record` VALUES ('180', '1506048808155', '1.38', '-99491.535', '-99492.915', '1', '1', '1', '737026017767460864');
INSERT INTO `charge_record` VALUES ('181', '1506056244077', '500', '-99492.915', '-99992.915', '1', '1', '1', null);
INSERT INTO `charge_record` VALUES ('182', '1506056244084', '500', '0', '500', '0', '49', '1', null);
INSERT INTO `charge_record` VALUES ('183', '1506061341417', '15.5', '783', '767.5', '1', '7', '1', '737078599470813184');
INSERT INTO `charge_record` VALUES ('184', '1506061341435', '15.5', '-99977.415', '-99992.915', '1', '1', '1', '737078599470813184');
INSERT INTO `charge_record` VALUES ('185', '1506063560842', '29.1', '-99992.915', '-100022.015', '1', '1', '1', null);
INSERT INTO `charge_record` VALUES ('186', '1506063560848', '29.1', '500', '529.1', '0', '49', '1', null);
INSERT INTO `charge_record` VALUES ('187', '1506088362301', '100', '-100022.015', '-100122.015', '1', '1', '1', null);
INSERT INTO `charge_record` VALUES ('188', '1506088362307', '100', '0', '100', '0', '66', '1', null);
INSERT INTO `charge_record` VALUES ('189', '1506127655794', '50.4', '100', '49.6', '1', '66', '1', '737356742119133184');
INSERT INTO `charge_record` VALUES ('190', '1506127655818', '50.4', '-100071.615', '-100122.015', '1', '1', '1', '737356742119133184');
INSERT INTO `charge_record` VALUES ('191', '1506136468750', '32', '529.1', '497.1', '1', '49', '1', '737393706335735808');
INSERT INTO `charge_record` VALUES ('192', '1506136468769', '31', '-100090.015', '-100121.015', '1', '1', '1', '737393706335735808');
INSERT INTO `charge_record` VALUES ('193', '1506143921060', '1.71', '107.88', '106.17', '1', '2', '1', '737424963589378048');
INSERT INTO `charge_record` VALUES ('194', '1506143921073', '1.38', '-100119.305', '-100120.685', '1', '1', '1', '737424963589378048');
INSERT INTO `charge_record` VALUES ('195', '1506144326065', '15', '767.5', '752.5', '1', '7', '1', '737426662303469568');
INSERT INTO `charge_record` VALUES ('196', '1506144326078', '15', '-100105.685', '-100120.685', '1', '1', '1', '737426662303469568');
INSERT INTO `charge_record` VALUES ('197', '1506146529312', '15', '752.5', '737.5', '1', '7', '1', '737435903391174656');
INSERT INTO `charge_record` VALUES ('198', '1506146529324', '15', '-100105.685', '-100120.685', '1', '1', '1', '737435903391174656');
INSERT INTO `charge_record` VALUES ('199', '1506155550738', '10', '-100120.685', '-100130.685', '1', '1', '1', null);
INSERT INTO `charge_record` VALUES ('200', '1506155550742', '10', '0', '10', '0', '38', '1', null);
INSERT INTO `charge_record` VALUES ('201', '1506155648026', '1.74', '10', '8.26', '1', '38', '1', '737474150049779712');
INSERT INTO `charge_record` VALUES ('202', '1506155648040', '1.74', '-100128.945', '-100130.685', '1', '1', '1', '737474150049779712');
INSERT INTO `charge_record` VALUES ('203', '1506155823614', '1.74', '8.26', '6.52', '1', '38', '1', '737474886519230464');
INSERT INTO `charge_record` VALUES ('204', '1506155823623', '1.74', '-100128.945', '-100130.685', '1', '1', '1', '737474886519230464');
INSERT INTO `charge_record` VALUES ('205', '1506156185519', '3.48', '-100140.685', '-100144.165', '1', '1', '1', null);
INSERT INTO `charge_record` VALUES ('206', '1506156185523', '3.48', '6.52', '10', '0', '38', '1', null);
INSERT INTO `charge_record` VALUES ('207', '1506157835249', '34', '497.1', '463.1', '1', '49', '1', '737483323927957504');
INSERT INTO `charge_record` VALUES ('208', '1506157835258', '32', '-100110.165', '-100142.165', '1', '1', '1', '737483323927957504');
INSERT INTO `charge_record` VALUES ('209', '1506161934603', '2000', '-100147.645', '-102147.645', '1', '1', '1', null);
INSERT INTO `charge_record` VALUES ('210', '1506161934607', '2000', '0', '2000', '0', '70', '1', null);
INSERT INTO `charge_record` VALUES ('211', '1506164481703', '34', '463.1', '429.1', '1', '49', '1', '737511201176555520');
INSERT INTO `charge_record` VALUES ('212', '1506164481712', '32', '-102113.645', '-102145.645', '1', '1', '1', '737511201176555520');
INSERT INTO `charge_record` VALUES ('213', '1506166301322', '15', '737.5', '722.5', '1', '7', '1', '737518833211805696');
INSERT INTO `charge_record` VALUES ('214', '1506166301332', '15', '-102130.645', '-102145.645', '1', '1', '1', '737518833211805696');
INSERT INTO `charge_record` VALUES ('215', '1506177398019', '16.5', '2000', '1983.5', '1', '70', '1', '737565376132419584');
INSERT INTO `charge_record` VALUES ('216', '1506177398027', '17.4', '-102129.145', '-102146.545', '1', '1', '1', '737565376132419584');
INSERT INTO `charge_record` VALUES ('217', '1506179584684', '27.5', '1983.5', '1956', '1', '70', '1', '737574547670175744');
INSERT INTO `charge_record` VALUES ('218', '1506179584695', '29', '-102119.045', '-102148.045', '1', '1', '1', '737574547670175744');
INSERT INTO `charge_record` VALUES ('219', '1506218866882', '21', '722.5', '701.5', '1', '7', '1', '737739309150375936');
INSERT INTO `charge_record` VALUES ('220', '1506218866935', '21', '-102127.045', '-102148.045', '1', '1', '1', '737739309150375936');
INSERT INTO `charge_record` VALUES ('221', '1506222571598', '27.5', '1956', '1928.5', '1', '70', '1', '737754847855513600');
INSERT INTO `charge_record` VALUES ('222', '1506222571609', '29', '-102120.545', '-102149.545', '1', '1', '1', '737754847855513600');
INSERT INTO `charge_record` VALUES ('223', '1506230131425', '21.35', '701.5', '680.15', '1', '7', '1', '737786556068139008');
INSERT INTO `charge_record` VALUES ('224', '1506230131435', '21.35', '-102128.195', '-102149.545', '1', '1', '1', '737786556068139008');
INSERT INTO `charge_record` VALUES ('225', '1506260987219', '99', '1928.5', '1829.5', '1', '70', '1', '737915974648336384');
INSERT INTO `charge_record` VALUES ('226', '1506260987229', '104.4', '-102050.545', '-102154.945', '1', '1', '1', '737915974648336384');
INSERT INTO `charge_record` VALUES ('227', '1506332644652', '20.4', '429.1', '408.7', '1', '49', '1', '738216527706198016');
INSERT INTO `charge_record` VALUES ('228', '1506332644663', '19.2', '-102134.545', '-102153.745', '1', '1', '1', '738216527706198016');
INSERT INTO `charge_record` VALUES ('229', '1506335472692', '22.25', '1829.5', '1807.25', '1', '70', '1', '738228389365682176');
INSERT INTO `charge_record` VALUES ('230', '1506335472701', '22.25', '-102131.495', '-102153.745', '1', '1', '1', '738228389365682176');
INSERT INTO `charge_record` VALUES ('231', '1506351741798', '22.25', '1807.25', '1785', '1', '70', '1', '738296626942054400');
INSERT INTO `charge_record` VALUES ('232', '1506351741806', '22.25', '-102131.495', '-102153.745', '1', '1', '1', '738296626942054400');
INSERT INTO `charge_record` VALUES ('233', '1506393834542', '27.5', '1785', '1757.5', '1', '70', '1', '738473176706584576');
INSERT INTO `charge_record` VALUES ('234', '1506393834551', '29', '-102126.245', '-102155.245', '1', '1', '1', '738473176706584576');
INSERT INTO `charge_record` VALUES ('235', '1506393940777', '29', '-102155.245', '-102184.245', '1', '1', '1', null);
INSERT INTO `charge_record` VALUES ('236', '1506393940781', '29', '1757.5', '1786.5', '0', '70', '1', null);
INSERT INTO `charge_record` VALUES ('237', '1506400670658', '20.4', '408.7', '388.3', '1', '49', '1', '738501849455267840');
INSERT INTO `charge_record` VALUES ('238', '1506400670670', '19.2', '-102163.845', '-102183.045', '1', '1', '1', '738501849455267840');
INSERT INTO `charge_record` VALUES ('239', '1506425623576', '20.4', '388.3', '367.9', '1', '49', '1', '738606509579046912');
INSERT INTO `charge_record` VALUES ('240', '1506425623585', '19.2', '-102162.645', '-102181.845', '1', '1', '1', '738606509579046912');
INSERT INTO `charge_record` VALUES ('241', '1506433938964', '15.25', '680.15', '664.9', '1', '7', '1', '738641386844196864');
INSERT INTO `charge_record` VALUES ('242', '1506433938981', '15.25', '-102166.595', '-102181.845', '1', '1', '1', '738641386844196864');
INSERT INTO `charge_record` VALUES ('243', '1506475131335', '22.4', '1786.5', '1764.1', '1', '70', '1', '738814160170651648');
INSERT INTO `charge_record` VALUES ('244', '1506475131344', '22.4', '-102159.445', '-102181.845', '1', '1', '1', '738814160170651648');
INSERT INTO `charge_record` VALUES ('245', '1506477505861', '15', '-102213.245', '-102228.245', '1', '1', '1', null);
INSERT INTO `charge_record` VALUES ('246', '1506477505864', '15', '0', '15', '0', '21', '1', null);
INSERT INTO `charge_record` VALUES ('247', '1506478763231', '13.35', '15', '1.65', '1', '21', '1', '738829393446572032');
INSERT INTO `charge_record` VALUES ('248', '1506478763240', '13.35', '-102214.895', '-102228.245', '1', '1', '1', '738829393446572032');
INSERT INTO `charge_record` VALUES ('249', '1505871743000', '9.9', '106.17', '116.07', '2', '2', '1', '736283369150615552');
INSERT INTO `charge_record` VALUES ('250', '1505871743000', '9.9', '-102228.245', '-102218.345', '2', '1', '1', '736283369150615552');
INSERT INTO `charge_record` VALUES ('251', '1506520937096', '15.25', '28.3', '13.05', '1', '26', '1', '739006283474014208');
INSERT INTO `charge_record` VALUES ('252', '1506520937124', '15.25', '-102203.095', '-102218.345', '1', '1', '1', '739006283474014208');
INSERT INTO `charge_record` VALUES ('253', '1506393834000', '27.5', '1764.1', '1791.6', '2', '70', '1', '738473176706584576');
INSERT INTO `charge_record` VALUES ('254', '1506393834000', '29', '-102218.345', '-102189.345', '2', '1', '1', '738473176706584576');
INSERT INTO `charge_record` VALUES ('255', '1506351742000', '22.25', '1791.6', '1813.85', '2', '70', '1', '738296626942054400');
INSERT INTO `charge_record` VALUES ('256', '1506351742000', '22.25', '-102189.345', '-102167.095', '2', '1', '1', '738296626942054400');
INSERT INTO `charge_record` VALUES ('257', '1506335472000', '22.25', '1813.85', '1836.1', '2', '70', '1', '738228389365682176');
INSERT INTO `charge_record` VALUES ('258', '1506335472000', '22.25', '-102167.095', '-102144.845', '2', '1', '1', '738228389365682176');
INSERT INTO `charge_record` VALUES ('259', '1506260987000', '99', '1836.1', '1935.1', '2', '70', '1', '737915974648336384');
INSERT INTO `charge_record` VALUES ('260', '1506260987000', '104.4', '-102144.845', '-102040.445', '2', '1', '1', '737915974648336384');
INSERT INTO `charge_record` VALUES ('261', '1506425624000', '20.4', '367.9', '388.3', '2', '49', '1', '738606509579046912');
INSERT INTO `charge_record` VALUES ('262', '1506425624000', '19.2', '-102040.445', '-102021.245', '2', '1', '1', '738606509579046912');
INSERT INTO `charge_record` VALUES ('263', '1506332644000', '20.4', '388.3', '408.7', '2', '49', '1', '738216527706198016');
INSERT INTO `charge_record` VALUES ('264', '1506332644000', '19.2', '-102021.245', '-102002.045', '2', '1', '1', '738216527706198016');
INSERT INTO `charge_record` VALUES ('265', '1506218867000', '21', '664.9', '685.9', '2', '7', '1', '737739309150375936');
INSERT INTO `charge_record` VALUES ('266', '1506218867000', '21', '-102002.045', '-101981.045', '2', '1', '1', '737739309150375936');
INSERT INTO `charge_record` VALUES ('267', '1506155823000', '1.74', '10', '11.74', '2', '38', '1', '737474886519230464');
INSERT INTO `charge_record` VALUES ('268', '1506155823000', '1.74', '-101981.045', '-101979.305', '2', '1', '1', '737474886519230464');
INSERT INTO `charge_record` VALUES ('269', '1506566086185', '2.16', '-102040.445', '-102042.605', '1', '1', '1', '739195652445048832');
INSERT INTO `charge_record` VALUES ('270', '1506566260070', '34', '408.7', '374.7', '1', '49', '1', '739196381788377088');
INSERT INTO `charge_record` VALUES ('271', '1506566260084', '32', '-102008.605', '-102040.605', '1', '1', '1', '739196381788377088');
INSERT INTO `charge_record` VALUES ('272', '1506566086000', '2.16', '-102040.605', '-102038.445', '2', '1', '1', '739195652445048832');
INSERT INTO `charge_record` VALUES ('273', '1506144326000', '15', '685.9', '700.9', '2', '7', '1', '737426662303469568');
INSERT INTO `charge_record` VALUES ('274', '1506144326000', '15', '-102038.445', '-102023.445', '2', '1', '1', '737426662303469568');
INSERT INTO `charge_record` VALUES ('275', '1506127656000', '50.4', '49.6', '100', '2', '66', '1', '737356742119133184');
INSERT INTO `charge_record` VALUES ('276', '1506127656000', '50.4', '-102023.445', '-101973.045', '2', '1', '1', '737356742119133184');
INSERT INTO `charge_record` VALUES ('277', '1506566553503', '21.6', '-102040.605', '-102062.205', '1', '1', '1', '739197587633999872');
INSERT INTO `charge_record` VALUES ('278', '1506570883767', '21.6', '-102062.205', '-102083.805', '1', '1', '1', '739215774945644544');
INSERT INTO `charge_record` VALUES ('279', '1506155648000', '1.74', '11.74', '13.48', '2', '38', '1', '737474150049779712');
INSERT INTO `charge_record` VALUES ('280', '1506155648000', '1.74', '-102083.805', '-102082.065', '2', '1', '1', '737474150049779712');
INSERT INTO `charge_record` VALUES ('281', '1506591426057', '21.6', '-102082.065', '-102103.665', '1', '1', '1', '739301895172001792');
INSERT INTO `charge_record` VALUES ('282', '1506596775277', '21.6', '-102103.665', '-102082.065', '2', '1', '1', '739301895172001792');
INSERT INTO `charge_record` VALUES ('283', '1506596785329', '21.6', '-102082.065', '-102060.465', '2', '1', '1', '739197587633999872');
INSERT INTO `charge_record` VALUES ('284', '1506603167487', '21.6', '-102060.465', '-102038.865', '2', '1', '1', '739215774945644544');
INSERT INTO `charge_record` VALUES ('285', '1506603169680', '21.6', '-102038.865', '-102017.265', '2', '1', '1', '739197587633999872');
INSERT INTO `charge_record` VALUES ('286', '1506603178679', '21.6', '-102017.265', '-101995.665', '2', '1', '1', '739215774945644544');
INSERT INTO `charge_record` VALUES ('287', '1506603180541', '21.6', '-101995.665', '-101974.065', '2', '1', '1', '739197587633999872');
INSERT INTO `charge_record` VALUES ('288', '1506603186098', '1.71', '116.07', '117.78', '2', '2', '1', '737424963589378048');
INSERT INTO `charge_record` VALUES ('289', '1506603186098', '1.38', '-101974.065', '-101972.685', '2', '1', '1', '737424963589378048');
INSERT INTO `charge_record` VALUES ('290', '1506603189668', '1.71', '117.78', '119.49', '2', '2', '1', '737026017767460864');
INSERT INTO `charge_record` VALUES ('291', '1506603189668', '1.38', '-101972.685', '-101971.305', '2', '1', '1', '737026017767460864');
INSERT INTO `charge_record` VALUES ('292', '1506603191534', '1.74', '98.26', '100', '2', '3', '1', '736483154348478464');
INSERT INTO `charge_record` VALUES ('293', '1506603191534', '1.71', '119.49', '121.2', '2', '2', '1', '736483154348478464');
INSERT INTO `charge_record` VALUES ('294', '1506603191534', '1.38', '-101971.305', '-101969.925', '2', '1', '1', '736483154348478464');
INSERT INTO `charge_record` VALUES ('295', '1506603218514', '21.6', '-101969.925', '-101948.325', '2', '1', '1', '739215774945644544');
INSERT INTO `charge_record` VALUES ('296', '1506603220446', '21.6', '-101948.325', '-101926.725', '2', '1', '1', '739197587633999872');
INSERT INTO `charge_record` VALUES ('297', '1506651686216', '21.6', '-101926.725', '-101905.125', '2', '1', '1', '739215774945644544');
INSERT INTO `charge_record` VALUES ('298', '1506651937909', '21.6', '-101905.125', '-101883.525', '2', '1', '1', '739215774945644544');
INSERT INTO `charge_record` VALUES ('299', '1506656205924', '21.6', '-101883.525', '-101861.925', '2', '1', '1', '739215774945644544');
INSERT INTO `charge_record` VALUES ('300', '1506656209987', '21.6', '-101861.925', '-101840.325', '2', '1', '1', '739197587633999872');
INSERT INTO `charge_record` VALUES ('301', '1506668936552', '21.6', '-101840.325', '-101818.725', '2', '1', '1', '739215774945644544');
INSERT INTO `charge_record` VALUES ('304', '1506670897651', '21.6', '-101818.725', '-101797.125', '2', '1', '1', '739215774945644544');
INSERT INTO `charge_record` VALUES ('305', '1506670929657', '21.6', '-101797.125', '-101775.525', '2', '1', '1', '739197587633999872');
INSERT INTO `charge_record` VALUES ('306', '1506671029493', '21.6', '-101775.525', '-101753.925', '2', '1', '1', '739215774945644544');
INSERT INTO `charge_record` VALUES ('307', '1506671029493', '21.6', '-101753.925', '-101732.325', '2', '1', '1', '739215774945644544');
INSERT INTO `charge_record` VALUES ('308', '1506570884000', '21.6', '-101732.325', '-101710.725', '2', '1', '1', '739215774945644544');
INSERT INTO `charge_record` VALUES ('309', '1506570884000', '21.6', '-101710.725', '-101689.125', '2', '1', '1', '739215774945644544');
INSERT INTO `charge_record` VALUES ('310', '1506570884000', '21.6', '-101689.125', '-101667.525', '2', '1', '1', '739215774945644544');
INSERT INTO `charge_record` VALUES ('311', '1506570884000', '21.6', '-101667.525', '-101645.925', '2', '1', '1', '739215774945644544');
INSERT INTO `charge_record` VALUES ('312', '1506566557000', '21.6', '-101645.925', '-101624.325', '2', '1', '1', '739197587633999872');
INSERT INTO `charge_record` VALUES ('313', '1506566557000', '21.6', '-101624.325', '-101602.725', '2', '1', '1', '739197587633999872');
INSERT INTO `charge_record` VALUES ('314', '1506789633634', '82.6', '700.9', '618.3', '1', '7', '1', '740133278421356544');
INSERT INTO `charge_record` VALUES ('315', '1506789634480', '82.6', '-101520.125', '-101602.725', '1', '1', '1', '740133278421356544');
INSERT INTO `charge_record` VALUES ('316', '1506789626416', '82.6', '618.3', '535.7', '1', '7', '1', '740133248167841792');
INSERT INTO `charge_record` VALUES ('317', '1506789639765', '82.6', '-101520.125', '-101602.725', '1', '1', '1', '740133248167841792');
INSERT INTO `charge_record` VALUES ('318', '1506789874910', '82.6', '535.7', '618.3', '2', '7', '1', '740133278421356544');
INSERT INTO `charge_record` VALUES ('319', '1506789874910', '82.6', '-101602.725', '-101520.125', '2', '1', '1', '740133278421356544');
INSERT INTO `charge_record` VALUES ('320', '1506789876630', '82.6', '618.3', '700.9', '2', '7', '1', '740133248167841792');
INSERT INTO `charge_record` VALUES ('321', '1506789876630', '82.6', '-101520.125', '-101437.525', '2', '1', '1', '740133248167841792');
INSERT INTO `charge_record` VALUES ('322', '1506790987051', '82.6', '700.9', '618.3', '1', '7', '1', '740138955063693312');
INSERT INTO `charge_record` VALUES ('323', '1506790993253', '82.6', '-101354.925', '-101437.525', '1', '1', '1', '740138955063693312');
INSERT INTO `charge_record` VALUES ('324', '1506791011251', '82.6', '618.3', '535.7', '1', '7', '1', '740139056565850112');
INSERT INTO `charge_record` VALUES ('325', '1506791011728', '82.6', '-101354.925', '-101437.525', '1', '1', '1', '740139056565850112');
INSERT INTO `charge_record` VALUES ('326', '1506791311825', '82.6', '535.7', '618.3', '2', '7', '1', '740139056565850112');
INSERT INTO `charge_record` VALUES ('327', '1506791311825', '82.6', '-101437.525', '-101354.925', '2', '1', '1', '740139056565850112');
INSERT INTO `charge_record` VALUES ('328', '1506821942504', '34', '374.7', '340.7', '1', '49', '1', '740268791644033024');
INSERT INTO `charge_record` VALUES ('329', '1506821943308', '32', '-101320.925', '-101352.925', '1', '1', '1', '740268791644033024');
INSERT INTO `charge_record` VALUES ('330', '1506823307724', '68', '340.7', '272.7', '1', '49', '1', '740274517791739904');
INSERT INTO `charge_record` VALUES ('331', '1506823308282', '64', '-101284.925', '-101348.925', '1', '1', '1', '740274517791739904');
INSERT INTO `charge_record` VALUES ('332', '1506840555861', '34', '272.7', '238.7', '1', '49', '1', '740346861721751552');
INSERT INTO `charge_record` VALUES ('333', '1506840556488', '32', '-101314.925', '-101346.925', '1', '1', '1', '740346861721751552');
INSERT INTO `charge_record` VALUES ('334', '1506858084536', '22.25', '100', '77.75', '1', '66', '1', '740420382313418752');
INSERT INTO `charge_record` VALUES ('335', '1506858085127', '22.25', '-101324.675', '-101346.925', '1', '1', '1', '740420382313418752');
INSERT INTO `charge_record` VALUES ('336', '1506859589275', '22.25', '77.75', '100', '2', '66', '1', '740420382313418752');
INSERT INTO `charge_record` VALUES ('337', '1506859589275', '22.25', '-101346.925', '-101324.675', '2', '1', '1', '740420382313418752');
INSERT INTO `charge_record` VALUES ('338', '1506859593188', '34', '238.7', '272.7', '2', '49', '1', '740346861721751552');
INSERT INTO `charge_record` VALUES ('339', '1506859593188', '32', '-101324.675', '-101292.675', '2', '1', '1', '740346861721751552');
INSERT INTO `charge_record` VALUES ('340', '1506859596186', '34', '272.7', '306.7', '2', '49', '1', '740268791644033024');
INSERT INTO `charge_record` VALUES ('341', '1506859596186', '32', '-101292.675', '-101260.675', '2', '1', '1', '740268791644033024');
INSERT INTO `charge_record` VALUES ('342', '1506859606771', '68', '306.7', '374.7', '2', '49', '1', '740274517791739904');
INSERT INTO `charge_record` VALUES ('343', '1506859606771', '64', '-101260.675', '-101196.675', '2', '1', '1', '740274517791739904');
INSERT INTO `charge_record` VALUES ('344', '1507456375847', '9.15', '-101196.675', '-101205.825', '1', '1', '1', '742929196296179712');
INSERT INTO `charge_record` VALUES ('345', '1507456880777', '9.15', '-101205.825', '-101214.975', '1', '1', '1', '742931913827684352');
INSERT INTO `charge_record` VALUES ('346', '1507457636064', '9.15', '-101214.975', '-101224.125', '1', '1', '1', '742935019080650752');
INSERT INTO `charge_record` VALUES ('347', '1507457630000', '9.15', '-101224.125', '-101214.975', '2', '1', '1', '742935019080650752');
INSERT INTO `charge_record` VALUES ('348', '1507458436307', '9.15', '-101214.975', '-101205.825', '2', '1', '1', '742931913827684352');
INSERT INTO `charge_record` VALUES ('349', '1507458440213', '9.15', '-101205.825', '-101196.675', '2', '1', '1', '742929196296179712');
INSERT INTO `charge_record` VALUES ('350', '1507461823510', '20.4', '374.7', '354.3', '1', '49', '1', '742952647115411456');
INSERT INTO `charge_record` VALUES ('351', '1507461823993', '19.2', '-101176.275', '-101195.475', '1', '1', '1', '742952647115411456');
INSERT INTO `charge_record` VALUES ('352', '1507461823000', '20.4', '354.3', '374.7', '2', '49', '1', '742952647115411456');
INSERT INTO `charge_record` VALUES ('353', '1507461823000', '19.2', '-101195.475', '-101176.275', '2', '1', '1', '742952647115411456');
INSERT INTO `charge_record` VALUES ('354', '1507506741884', '20.4', '354.3', '333.9', '1', '49', '1', '743141048422764544');
INSERT INTO `charge_record` VALUES ('355', '1507506742358', '19.2', '-101155.875', '-101175.075', '1', '1', '1', '743141048422764544');
INSERT INTO `charge_record` VALUES ('356', '1507560722473', '54.9', '618.3', '563.4', '1', '7', '1', '743367459439906816');
INSERT INTO `charge_record` VALUES ('357', '1507560722817', '54.9', '-101120.175', '-101175.075', '1', '1', '1', '743367459439906816');
INSERT INTO `charge_record` VALUES ('358', '1507596214307', '15.25', '563.4', '548.15', '1', '7', '1', '743516322964443136');
INSERT INTO `charge_record` VALUES ('359', '1507596214591', '15.25', '-101159.825', '-101175.075', '1', '1', '1', '743516322964443136');
INSERT INTO `charge_record` VALUES ('360', '1507611888124', '34', '333.9', '299.9', '1', '49', '1', '743582063717781504');
INSERT INTO `charge_record` VALUES ('361', '1507611888473', '32', '-101141.075', '-101173.075', '1', '1', '1', '743582063717781504');
INSERT INTO `charge_record` VALUES ('362', '1507617011496', '32.69', '299.9', '267.21', '1', '49', '1', '743603552697454592');
INSERT INTO `charge_record` VALUES ('363', '1507617011819', '32.69', '-101140.385', '-101173.075', '1', '1', '1', '743603552697454592');
INSERT INTO `charge_record` VALUES ('364', '1507619202512', '39.65', '548.15', '508.5', '1', '7', '1', '743612742484627456');
INSERT INTO `charge_record` VALUES ('365', '1507619202869', '39.65', '-101133.425', '-101173.075', '1', '1', '1', '743612742484627456');
INSERT INTO `charge_record` VALUES ('366', '1507621782858', '200', '-101173.075', '-101373.075', '1', '1', '1', null);
INSERT INTO `charge_record` VALUES ('367', '1507621782863', '200', '0', '200', '0', '96', '1', null);
INSERT INTO `charge_record` VALUES ('368', '1507637654010', '21.35', '508.5', '487.15', '1', '7', '1', '743690133676494848');
INSERT INTO `charge_record` VALUES ('369', '1507637654288', '21.35', '-101351.725', '-101373.075', '1', '1', '1', '743690133676494848');
INSERT INTO `charge_record` VALUES ('370', '1507718519384', '20', '-101373.075', '-101393.075', '1', '1', '1', null);
INSERT INTO `charge_record` VALUES ('371', '1507718519388', '20', '6.9', '26.9', '0', '55', '1', null);
INSERT INTO `charge_record` VALUES ('372', '1507718673503', '21.35', '26.9', '5.55', '1', '55', '1', '744029954060062720');
INSERT INTO `charge_record` VALUES ('373', '1507718673840', '21.35', '-101371.725', '-101393.075', '1', '1', '1', '744029954060062720');
INSERT INTO `charge_record` VALUES ('374', '1507732768110', '47.6', '267.21', '219.61', '1', '49', '1', '744089071126581248');
INSERT INTO `charge_record` VALUES ('375', '1507732768422', '44.8', '-101345.475', '-101390.275', '1', '1', '1', '744089071126581248');
INSERT INTO `charge_record` VALUES ('376', '1507740244936', '54.9', '487.15', '432.25', '1', '7', '1', '744120431207780352');
INSERT INTO `charge_record` VALUES ('377', '1507740245206', '54.9', '-101335.375', '-101390.275', '1', '1', '1', '744120431207780352');
INSERT INTO `charge_record` VALUES ('378', '1507778566772', '21.35', '432.25', '410.9', '1', '7', '1', '744281164637802496');
INSERT INTO `charge_record` VALUES ('379', '1507778567326', '21.35', '-101368.925', '-101390.275', '1', '1', '1', '744281164637802496');
INSERT INTO `charge_record` VALUES ('380', '1507783872549', '5', '-101390.275', '-101395.275', '1', '1', '1', null);
INSERT INTO `charge_record` VALUES ('381', '1507783872553', '5', '0', '5', '0', '103', '1', null);
INSERT INTO `charge_record` VALUES ('382', '1507799149793', '47.6', '219.61', '172.01', '1', '49', '1', '744367496085114880');
INSERT INTO `charge_record` VALUES ('383', '1507799150144', '44.8', '-101347.675', '-101392.475', '1', '1', '1', '744367496085114880');
INSERT INTO `charge_record` VALUES ('384', '1507893370350', '8.7', '-101392.475', '-101401.175', '1', '1', '1', '744762684209106944');
INSERT INTO `charge_record` VALUES ('385', '1507893370000', '8.7', '-101401.175', '-101392.475', '2', '1', '1', '744762684209106944');
INSERT INTO `charge_record` VALUES ('386', '1507898236930', '8.7', '-101392.475', '-101401.175', '1', '1', '1', '744783096494166016');
INSERT INTO `charge_record` VALUES ('387', '1507898313943', '8.7', '121.2', '112.5', '1', '2', '1', '744783420676116480');
INSERT INTO `charge_record` VALUES ('388', '1507898314495', '8.7', '-101392.475', '-101401.175', '1', '1', '1', '744783420676116480');
INSERT INTO `charge_record` VALUES ('389', '1507898314000', '8.7', '112.5', '121.2', '2', '2', '1', '744783420676116480');
INSERT INTO `charge_record` VALUES ('390', '1507898314000', '8.7', '-101401.175', '-101392.475', '2', '1', '1', '744783420676116480');
INSERT INTO `charge_record` VALUES ('391', '1507898373331', '8.7', '121.2', '112.5', '1', '2', '1', '744783669767442432');
INSERT INTO `charge_record` VALUES ('392', '1507898373666', '8.7', '-101383.775', '-101392.475', '1', '1', '1', '744783669767442432');
INSERT INTO `charge_record` VALUES ('393', '1507898236000', '8.7', '-101392.475', '-101383.775', '2', '1', '1', '744783096494166016');
INSERT INTO `charge_record` VALUES ('394', '1507898651533', '8.7', '112.5', '103.8', '1', '2', '1', '744784836631203840');
INSERT INTO `charge_record` VALUES ('395', '1507898651829', '8.7', '-101375.075', '-101383.775', '1', '1', '1', '744784836631203840');
INSERT INTO `charge_record` VALUES ('396', '1507898658073', '14.5', '103.8', '89.3', '1', '2', '1', '744784864061952000');
INSERT INTO `charge_record` VALUES ('397', '1507898658354', '14.5', '-101369.275', '-101383.775', '1', '1', '1', '744784864061952000');
INSERT INTO `charge_record` VALUES ('398', '1507898651000', '8.7', '89.3', '98', '2', '2', '1', '744784836631203840');
INSERT INTO `charge_record` VALUES ('399', '1507898651000', '8.7', '-101383.775', '-101375.075', '2', '1', '1', '744784836631203840');
INSERT INTO `charge_record` VALUES ('400', '1507949397887', '1', '-101375.075', '-101376.075', '1', '1', '1', null);
INSERT INTO `charge_record` VALUES ('401', '1507949397891', '1', '98', '99', '0', '2', '1', null);
INSERT INTO `charge_record` VALUES ('402', '1507970093963', '12.5', '200', '187.5', '1', '96', '1', '745084487909511168');
INSERT INTO `charge_record` VALUES ('403', '1507970094349', '12.5', '-101363.575', '-101376.075', '1', '1', '1', '745084487909511168');
INSERT INTO `charge_record` VALUES ('404', '1507970094569', '12.5', '187.5', '175', '1', '96', '1', '745084490442870784');
INSERT INTO `charge_record` VALUES ('405', '1507970094895', '12.5', '-101363.575', '-101376.075', '1', '1', '1', '745084490442870784');
INSERT INTO `charge_record` VALUES ('406', '1507970094761', '12.5', '175', '162.5', '1', '96', '1', '745084491248177152');
INSERT INTO `charge_record` VALUES ('407', '1507970095081', '12.5', '-101363.575', '-101376.075', '1', '1', '1', '745084491248177152');
INSERT INTO `charge_record` VALUES ('408', '1507970094939', '12.5', '162.5', '150', '1', '96', '1', '745084491994763264');
INSERT INTO `charge_record` VALUES ('409', '1507970095261', '12.5', '-101363.575', '-101376.075', '1', '1', '1', '745084491994763264');
INSERT INTO `charge_record` VALUES ('410', '1507970095000', '12.5', '150', '162.5', '2', '96', '1', '745084491994763264');
INSERT INTO `charge_record` VALUES ('411', '1507970095000', '12.5', '-101376.075', '-101363.575', '2', '1', '1', '745084491994763264');
INSERT INTO `charge_record` VALUES ('412', '1507970095000', '12.5', '162.5', '175', '2', '96', '1', '745084491248177152');
INSERT INTO `charge_record` VALUES ('413', '1507970095000', '12.5', '-101363.575', '-101351.075', '2', '1', '1', '745084491248177152');
INSERT INTO `charge_record` VALUES ('414', '1507970094000', '12.5', '175', '187.5', '2', '96', '1', '745084490442870784');
INSERT INTO `charge_record` VALUES ('415', '1507970094000', '12.5', '-101351.075', '-101338.575', '2', '1', '1', '745084490442870784');
INSERT INTO `charge_record` VALUES ('416', '1507970094000', '12.5', '187.5', '200', '2', '96', '1', '745084487909511168');
INSERT INTO `charge_record` VALUES ('417', '1507970094000', '12.5', '-101338.575', '-101326.075', '2', '1', '1', '745084487909511168');
INSERT INTO `charge_record` VALUES ('418', '1507972947241', '2.7', '-101326.075', '-101328.775', '1', '1', '1', '745096436680495104');
INSERT INTO `charge_record` VALUES ('419', '1507972950000', '2.7', '-101328.775', '-101326.075', '2', '1', '1', '745096436680495104');

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
) ENGINE=InnoDB AUTO_INCREMENT=521 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of cnel_bind_pg
-- ----------------------------
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
INSERT INTO `cnel_bind_pg` VALUES ('450', '64', '48', '微族-广东移动', '30元500M');
INSERT INTO `cnel_bind_pg` VALUES ('451', '64', '49', '微族-广东移动', '50元1G');
INSERT INTO `cnel_bind_pg` VALUES ('452', '64', '50', '微族-广东移动', '70元2G');
INSERT INTO `cnel_bind_pg` VALUES ('453', '64', '51', '微族-广东移动', '100元3G');
INSERT INTO `cnel_bind_pg` VALUES ('454', '64', '52', '微族-广东移动', '130元4G');
INSERT INTO `cnel_bind_pg` VALUES ('455', '64', '53', '微族-广东移动', '180元6G');
INSERT INTO `cnel_bind_pg` VALUES ('456', '64', '54', '微族-广东移动', '280元11G');
INSERT INTO `cnel_bind_pg` VALUES ('457', '65', '66', '微族-山西省内', '3元10M省内');
INSERT INTO `cnel_bind_pg` VALUES ('458', '65', '67', '微族-山西省内', '5元30M省内');
INSERT INTO `cnel_bind_pg` VALUES ('459', '65', '68', '微族-山西省内', '10元70M省内');
INSERT INTO `cnel_bind_pg` VALUES ('460', '65', '69', '微族-山西省内', '20元150M省内');
INSERT INTO `cnel_bind_pg` VALUES ('461', '65', '70', '微族-山西省内', '30元500M省内');
INSERT INTO `cnel_bind_pg` VALUES ('462', '65', '71', '微族-山西省内', '50元1G省内');
INSERT INTO `cnel_bind_pg` VALUES ('463', '65', '72', '微族-山西省内', '70元2G省内');
INSERT INTO `cnel_bind_pg` VALUES ('464', '65', '73', '微族-山西省内', '100元3G省内');
INSERT INTO `cnel_bind_pg` VALUES ('465', '65', '74', '微族-山西省内', '130元4G省内');
INSERT INTO `cnel_bind_pg` VALUES ('466', '65', '75', '微族-山西省内', '180元6G省内');
INSERT INTO `cnel_bind_pg` VALUES ('467', '65', '76', '微族-山西省内', '280元11G省内');
INSERT INTO `cnel_bind_pg` VALUES ('468', '66', '41', '微族-河南移动', '3元10M');
INSERT INTO `cnel_bind_pg` VALUES ('469', '66', '43', '微族-河南移动', '5元30M');
INSERT INTO `cnel_bind_pg` VALUES ('470', '66', '44', '微族-河南移动', '10元70');
INSERT INTO `cnel_bind_pg` VALUES ('471', '66', '45', '微族-河南移动', '10元100M');
INSERT INTO `cnel_bind_pg` VALUES ('472', '66', '46', '微族-河南移动', '20元150M');
INSERT INTO `cnel_bind_pg` VALUES ('473', '66', '47', '微族-河南移动', '20元300');
INSERT INTO `cnel_bind_pg` VALUES ('474', '66', '48', '微族-河南移动', '30元500M');
INSERT INTO `cnel_bind_pg` VALUES ('475', '66', '49', '微族-河南移动', '50元1G');
INSERT INTO `cnel_bind_pg` VALUES ('476', '66', '50', '微族-河南移动', '70元2G');
INSERT INTO `cnel_bind_pg` VALUES ('477', '66', '51', '微族-河南移动', '100元3G');
INSERT INTO `cnel_bind_pg` VALUES ('478', '66', '52', '微族-河南移动', '130元4G');
INSERT INTO `cnel_bind_pg` VALUES ('479', '66', '53', '微族-河南移动', '180元6G');
INSERT INTO `cnel_bind_pg` VALUES ('480', '66', '54', '微族-河南移动', '280元11G');
INSERT INTO `cnel_bind_pg` VALUES ('481', '67', '41', '微族-北京移动', '3元10M');
INSERT INTO `cnel_bind_pg` VALUES ('482', '67', '44', '微族-北京移动', '10元70');
INSERT INTO `cnel_bind_pg` VALUES ('483', '67', '46', '微族-北京移动', '20元150M');
INSERT INTO `cnel_bind_pg` VALUES ('484', '67', '48', '微族-北京移动', '30元500M');
INSERT INTO `cnel_bind_pg` VALUES ('485', '67', '49', '微族-北京移动', '50元1G');
INSERT INTO `cnel_bind_pg` VALUES ('486', '68', '47', '微族-广西移动', '20元300');
INSERT INTO `cnel_bind_pg` VALUES ('487', '68', '48', '微族-广西移动', '30元500M');
INSERT INTO `cnel_bind_pg` VALUES ('488', '68', '49', '微族-广西移动', '50元1G');
INSERT INTO `cnel_bind_pg` VALUES ('489', '69', '45', '微族-广东移动', '10元100M');
INSERT INTO `cnel_bind_pg` VALUES ('490', '70', '41', '微族-广东移动', '3元10M');
INSERT INTO `cnel_bind_pg` VALUES ('491', '70', '43', '微族-广东移动', '5元30M');
INSERT INTO `cnel_bind_pg` VALUES ('492', '70', '44', '微族-广东移动', '10元70');
INSERT INTO `cnel_bind_pg` VALUES ('493', '70', '46', '微族-广东移动', '20元150M');
INSERT INTO `cnel_bind_pg` VALUES ('494', '70', '48', '微族-广东移动', '30元500M');
INSERT INTO `cnel_bind_pg` VALUES ('495', '70', '49', '微族-广东移动', '50元1G');
INSERT INTO `cnel_bind_pg` VALUES ('496', '70', '50', '微族-广东移动', '70元2G');
INSERT INTO `cnel_bind_pg` VALUES ('497', '70', '51', '微族-广东移动', '100元3G');
INSERT INTO `cnel_bind_pg` VALUES ('498', '70', '52', '微族-广东移动', '130元4G');
INSERT INTO `cnel_bind_pg` VALUES ('499', '70', '53', '微族-广东移动', '180元6G');
INSERT INTO `cnel_bind_pg` VALUES ('500', '70', '54', '微族-广东移动', '280元11G');
INSERT INTO `cnel_bind_pg` VALUES ('501', '71', '81', '微族-新疆电信', '中国电信50M');
INSERT INTO `cnel_bind_pg` VALUES ('502', '71', '82', '微族-新疆电信', '中国电信30M');
INSERT INTO `cnel_bind_pg` VALUES ('503', '71', '83', '微族-新疆电信', '中国电信100M');
INSERT INTO `cnel_bind_pg` VALUES ('504', '71', '84', '微族-新疆电信', '中国电信200M');
INSERT INTO `cnel_bind_pg` VALUES ('505', '71', '85', '微族-新疆电信', '中国电信300M');
INSERT INTO `cnel_bind_pg` VALUES ('506', '71', '86', '微族-新疆电信', '中国电信500M');
INSERT INTO `cnel_bind_pg` VALUES ('507', '71', '87', '微族-新疆电信', '中国电信1G');
INSERT INTO `cnel_bind_pg` VALUES ('508', '72', '88', '微族-吉林联通', '中国联通20M');
INSERT INTO `cnel_bind_pg` VALUES ('509', '72', '89', '微族-吉林联通', '中国联通50M');
INSERT INTO `cnel_bind_pg` VALUES ('510', '72', '90', '微族-吉林联通', '中国联通100M');
INSERT INTO `cnel_bind_pg` VALUES ('511', '72', '91', '微族-吉林联通', '中国联通200M');
INSERT INTO `cnel_bind_pg` VALUES ('512', '72', '92', '微族-吉林联通', '中国联通5000M');
INSERT INTO `cnel_bind_pg` VALUES ('513', '73', '94', '微族-陕西电信', '中国电信5M');
INSERT INTO `cnel_bind_pg` VALUES ('514', '73', '95', '微族-陕西电信', '中国电信30M');
INSERT INTO `cnel_bind_pg` VALUES ('515', '73', '97', '微族-陕西电信', '中国电信10M');
INSERT INTO `cnel_bind_pg` VALUES ('516', '73', '99', '微族-陕西电信', '中国电信100M');
INSERT INTO `cnel_bind_pg` VALUES ('517', '73', '100', '微族-陕西电信', '中国电信200M');
INSERT INTO `cnel_bind_pg` VALUES ('518', '73', '101', '微族-陕西电信', '中国电信300M');
INSERT INTO `cnel_bind_pg` VALUES ('519', '73', '102', '微族-陕西电信', '中国电信500M');
INSERT INTO `cnel_bind_pg` VALUES ('520', '73', '103', '微族-陕西电信', '中国电信1G');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company_credentials
-- ----------------------------
INSERT INTO `company_credentials` VALUES ('1', '2', null, '1', '1', null, null, null, null, '5453454534', '1', '南昌微族科技有限公司', '江西省南昌市', '何兵 17707005023', '中国银行', '360111199605236014', '4sad5sa45d453', '信息服务费', null, '54353453453', '53453453', '54353453', null, null, null, null, '1505478089907', '1505874476912');
INSERT INTO `company_credentials` VALUES ('2', '14', null, '1', '0', null, null, null, null, '', null, '', '', '', '', '', '', '信息服务费', null, '', '', '', null, null, null, null, '1505828215431', '1505891023608');
INSERT INTO `company_credentials` VALUES ('3', '37', '770733914', '1', null, '刘勇健', '15766031847', '', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1506155391880', null);

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
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exchange_platform
-- ----------------------------
INSERT INTO `exchange_platform` VALUES ('32', '河南硕郎', 'Weizu', 'http://139.224.70.161:32001/api/v1/sendOrder', 'http://139.224.70.161:32001/api/v1/sendOrder', 'http://139.224.70.161:32001/api/v1/orderState', 'http://139.224.70.161:32001/api/v1/getBalance', 'CS111111', '123456', null, '722c16de0a83e5bd2f988e3c7bc9fee8', 'http://139.224.70.161/', '', '0', '1505470864409');
INSERT INTO `exchange_platform` VALUES ('42', '行云流水', 'Lljypt', 'http://api.lljypt.com/capi/trade.charge', 'http://api.lljypt.com/capi/trade.charge', 'http://api.lljypt.com/capi/query.order', 'http://api.lljypt.com/capi/query.balance', 'cncwz', '249636', '0', 'KKIGoAFUTxoIFfC', 'http://customer.lljypt.com/a', 'merchant=10210&clientId=10000&version=V100&', '1', '1505470884956');
INSERT INTO `exchange_platform` VALUES ('43', '行云对私', 'Lljypt0', 'http://api.lljypt.com/capi/trade.charge', 'http://api.lljypt.com/capi/trade.charge', 'http://api.lljypt.com/capi/query.order', 'http://api.lljypt.com/capi/query.balance', 'cncwz', '249636', '0', 'AoYIuPLXMmpTwTw', 'http://customer.lljypt.com/a', 'merchant=10304&clientId=10000&version=V100& ', '1', '1504000740478');
INSERT INTO `exchange_platform` VALUES ('44', 'wzkj0', 'Wzkj0', 'wzkj0', 'wzkj0', 'wzkj0', 'wzkj0', '123', '123', null, '123', '123', null, '1', '1505109915512');

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
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8;

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
INSERT INTO `operator_pg_data` VALUES ('81', '50', '7', '中国电信50M', '1', '2', '中国电信', '1');
INSERT INTO `operator_pg_data` VALUES ('82', '30', '5', '中国电信30M', '1', '2', '中国电信', '1');
INSERT INTO `operator_pg_data` VALUES ('83', '100', '10', '中国电信100M', '1', '2', '中国电信', '1');
INSERT INTO `operator_pg_data` VALUES ('84', '200', '15', '中国电信200M', '1', '2', '中国电信', '1');
INSERT INTO `operator_pg_data` VALUES ('85', '300', '20', '中国电信300M', '1', '2', '中国电信', '1');
INSERT INTO `operator_pg_data` VALUES ('86', '500', '30', '中国电信500M', '1', '2', '中国电信', '1');
INSERT INTO `operator_pg_data` VALUES ('87', '1024', '50', '中国电信1G', '1', '2', '中国电信', '1');
INSERT INTO `operator_pg_data` VALUES ('88', '20', '3', '中国联通20M', '1', '1', '中国联通', '1');
INSERT INTO `operator_pg_data` VALUES ('89', '50', '6', '中国联通50M', '1', '1', '中国联通', '1');
INSERT INTO `operator_pg_data` VALUES ('90', '100', '10', '中国联通100M', '1', '1', '中国联通', '1');
INSERT INTO `operator_pg_data` VALUES ('91', '200', '15', '中国联通200M', '1', '1', '中国联通', '1');
INSERT INTO `operator_pg_data` VALUES ('92', '500', '30', '中国联通5000M', '1', '1', '中国联通', '1');
INSERT INTO `operator_pg_data` VALUES ('94', '5', '1', '中国电信5M', '1', '2', '中国电信', '2');
INSERT INTO `operator_pg_data` VALUES ('95', '30', '5', '中国电信30M', '1', '2', '中国电信', '2');
INSERT INTO `operator_pg_data` VALUES ('97', '10', '2', '中国电信10M', '1', '2', '中国电信', '2');
INSERT INTO `operator_pg_data` VALUES ('99', '100', '10', '中国电信100M', '1', '2', '中国电信', '2');
INSERT INTO `operator_pg_data` VALUES ('100', '200', '15', '中国电信200M', '1', '2', '中国电信', '2');
INSERT INTO `operator_pg_data` VALUES ('101', '300', '20', '中国电信300M', '1', '2', '中国电信', '2');
INSERT INTO `operator_pg_data` VALUES ('102', '500', '30', '中国电信500M', '1', '2', '中国电信', '2');
INSERT INTO `operator_pg_data` VALUES ('103', '1024', '50', '中国电信1G', '1', '2', '中国电信', '2');

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
) ENGINE=InnoDB AUTO_INCREMENT=278 DEFAULT CHARSET=utf8;

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
INSERT INTO `product_code` VALUES ('231', '山西省', '66', '04', null, '32', '10');
INSERT INTO `product_code` VALUES ('232', '山西省', '67', '04', null, '32', '30');
INSERT INTO `product_code` VALUES ('233', '山西省', '68', '04', null, '32', '70');
INSERT INTO `product_code` VALUES ('234', '山西省', '69', '04', null, '32', '150');
INSERT INTO `product_code` VALUES ('235', '山西省', '70', '04', null, '32', '500');
INSERT INTO `product_code` VALUES ('236', '山西省', '71', '04', null, '32', '1024');
INSERT INTO `product_code` VALUES ('237', '山西省', '72', '04', null, '32', '2048');
INSERT INTO `product_code` VALUES ('238', '山西省', '73', '04', null, '32', '3072');
INSERT INTO `product_code` VALUES ('239', '山西省', '74', '04', null, '32', '4096');
INSERT INTO `product_code` VALUES ('240', '山西省', '75', '04', null, '32', '6144');
INSERT INTO `product_code` VALUES ('241', '山西省', '76', '04', null, '32', '11264');
INSERT INTO `product_code` VALUES ('242', '广西壮族自治区', '41', '20', null, '32', '30');
INSERT INTO `product_code` VALUES ('243', '广西壮族自治区', '44', '20', null, '32', '70');
INSERT INTO `product_code` VALUES ('244', '广西壮族自治区', '45', '20', null, '32', '100');
INSERT INTO `product_code` VALUES ('245', '广西壮族自治区', '46', '20', null, '32', '150');
INSERT INTO `product_code` VALUES ('246', '广西壮族自治区', '47', '20', null, '32', '300');
INSERT INTO `product_code` VALUES ('247', '广西壮族自治区', '48', '20', null, '32', '500');
INSERT INTO `product_code` VALUES ('248', '广西壮族自治区', '49', '20', null, '32', '1024');
INSERT INTO `product_code` VALUES ('249', '广西壮族自治区', '50', '20', null, '32', '2048');
INSERT INTO `product_code` VALUES ('250', '广西壮族自治区', '51', '20', null, '32', '3072');
INSERT INTO `product_code` VALUES ('251', '广西壮族自治区', '52', '20', null, '32', '4096');
INSERT INTO `product_code` VALUES ('252', '广西壮族自治区', '53', '20', null, '32', '6144');
INSERT INTO `product_code` VALUES ('253', '广西壮族自治区', '54', '20', null, '32', '11264');
INSERT INTO `product_code` VALUES ('254', '新疆维吾尔自治区', '81', '30', null, '32', '50');
INSERT INTO `product_code` VALUES ('255', '新疆维吾尔自治区', '82', '30', null, '32', '30');
INSERT INTO `product_code` VALUES ('256', '新疆维吾尔自治区', '83', '30', null, '32', '100');
INSERT INTO `product_code` VALUES ('257', '新疆维吾尔自治区', '84', '30', null, '32', '200');
INSERT INTO `product_code` VALUES ('258', '新疆维吾尔自治区', '85', '30', null, '32', '300');
INSERT INTO `product_code` VALUES ('259', '新疆维吾尔自治区', '86', '30', null, '32', '500');
INSERT INTO `product_code` VALUES ('260', '新疆维吾尔自治区', '87', '30', null, '32', '1024');
INSERT INTO `product_code` VALUES ('261', '吉林省', '88', '07', null, '32', '20');
INSERT INTO `product_code` VALUES ('262', '吉林省', '89', '07', null, '32', '50');
INSERT INTO `product_code` VALUES ('263', '吉林省', '90', '07', null, '32', '100');
INSERT INTO `product_code` VALUES ('264', '吉林省', '91', '07', null, '32', '200');
INSERT INTO `product_code` VALUES ('265', '吉林省', '92', '07', null, '32', '500');
INSERT INTO `product_code` VALUES ('267', '陕西省', '94', '26', null, '32', '5');
INSERT INTO `product_code` VALUES ('271', '陕西省', '95', '26', null, '32', '30');
INSERT INTO `product_code` VALUES ('272', '陕西省', '97', '26', null, '32', '10');
INSERT INTO `product_code` VALUES ('273', '陕西省', '99', '26', null, '32', '100');
INSERT INTO `product_code` VALUES ('274', '陕西省', '100', '26', null, '32', '200');
INSERT INTO `product_code` VALUES ('275', '陕西省', '101', '26', null, '32', '300');
INSERT INTO `product_code` VALUES ('276', '陕西省', '102', '26', null, '32', '500');
INSERT INTO `product_code` VALUES ('277', '陕西省', '103', '26', null, '32', '1024');

-- ----------------------------
-- Table structure for `purchase`
-- ----------------------------
DROP TABLE IF EXISTS `purchase`;
CREATE TABLE `purchase` (
  `order_id` bigint(20) NOT NULL COMMENT 'è®¢å•å·',
  `order_id_api` varchar(255) DEFAULT NULL COMMENT '其他系统返回的订单id',
  `order_id_from` varchar(255) DEFAULT NULL COMMENT '下级代理商传过来的订单号',
  `account_id` int(11) DEFAULT NULL COMMENT '生成订单的代理商',
  `charge_tel` varchar(255) DEFAULT NULL COMMENT 'æ‰‹æœºå·',
  `order_amount` double DEFAULT NULL COMMENT '订单的初始价格（适用于接口充值）',
  `pg_id` int(11) DEFAULT NULL COMMENT 'æµé‡åŒ…idï¼ˆå¤–é”®ï¼‰',
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
INSERT INTO `purchase` VALUES ('736283369150615552', '20170920094223425583', null, '2', '15829898209', '9.9', '70', '1505871743736', '陕西移动', null, '0', '微族-陕西省内移动', '系统：失败', '1506497785604');
INSERT INTO `purchase` VALUES ('736322784392646656', '20170920121901386880', null, '55', '13772665275', '23.1', '72', '1505881141062', '陕西移动', null, '0', '微族-陕西省内移动', '失败', '1505905476867');
INSERT INTO `purchase` VALUES ('736326301064892416', '20170920123259330129', null, '55', '13772665275', '21.7', '72', '1505881979502', '陕西移动', null, '1', '微族-陕西省内移动', '系统：成功', '1506594773330');
INSERT INTO `purchase` VALUES ('736402598193532928', '20170920173610388982', null, '7', '15991994058', '15.5', '71', '1505900170153', '陕西移动', null, '1', '微族-陕西本地移动', '系统：成功', '1506594772954');
INSERT INTO `purchase` VALUES ('736437229278203904', '20170920195346054210', null, '39', '15829898209', '3.1', '78', '1505908426848', '陕西移动', null, '1', '微族-陕西本地移动', '系统：成功', '1506594772587');
INSERT INTO `purchase` VALUES ('736450404098772992', '20170920204608835997', null, '7', '13572191613', '15.5', '71', '1505911567970', '陕西移动', null, '1', '微族-陕西本地移动', '系统：成功', '1506594772187');
INSERT INTO `purchase` VALUES ('736465259857973248', '20170920214509680953', null, '7', '15191128003', '21.7', '72', '1505915109860', '陕西移动', null, '1', '微族-陕西本地移动', '系统：成功', '1506594771813');
INSERT INTO `purchase` VALUES ('736465769222639616', '20170920214711067496', null, '7', '18392138893', '21.7', '72', '1505915231302', '陕西移动', null, '1', '微族-陕西本地移动', '系统：成功', '1506594771434');
INSERT INTO `purchase` VALUES ('736471316961431552', '20170920220914304716', null, '7', '18392163283', '40.3', '74', '1505916553986', '陕西移动', null, '1', '微族-陕西本地移动', '系统：成功', '1506594769775');
INSERT INTO `purchase` VALUES ('736474802667130880', '20170920222305683750', null, '7', '15191258181', '31', '73', '1505917385043', '陕西移动', null, '1', '微族-陕西本地移动', '系统：成功', '1506594769411');
INSERT INTO `purchase` VALUES ('736482923628204032', null, null, '3', '15067460579', '1.74', '41', '1505919321231', '浙江移动', null, null, '微族 浙江移动', null, null);
INSERT INTO `purchase` VALUES ('736483154348478464', '20170920225616935511', null, '3', '15067460579', '1.74', '41', '1505919376239', '浙江移动', null, '0', '微族 浙江移动', '手动失败', '1506603191575');
INSERT INTO `purchase` VALUES ('736673432812392448', '20170921113222041038', null, '7', '15291660333', '15.5', '71', '1505964742160', '陕西移动', null, '1', '微族-陕西本地移动', '系统：成功', '1506594768985');
INSERT INTO `purchase` VALUES ('736709519052115968', '20170921135545877550', null, '7', '13772150177', '40.3', '74', '1505973345790', '陕西移动', null, '1', '微族-陕西本地移动', '系统：成功', '1506594768625');
INSERT INTO `purchase` VALUES ('736766071347875840', '20170921174028871424', null, '26', '15929211697', '21.7', '72', '1505986828906', '陕西移动', null, '1', '微族-陕西本地移动', '系统：成功', '1506594768235');
INSERT INTO `purchase` VALUES ('736777448577830912', '20170921182541677329', null, '7', '13992728971', '15.5', '71', '1505989541449', '陕西移动', null, '1', '微族-陕西本地移动', '系统：成功', '1506594767886');
INSERT INTO `purchase` VALUES ('736838141708603392', null, null, '37', '15291502586', '15.5', '71', '1506004011821', '陕西移动', null, null, '微族-陕西本地移动', null, null);
INSERT INTO `purchase` VALUES ('737026017767460864', '20170922105337929863', null, '2', '15067460579', '1.71', '41', '1506048804963', '浙江移动', null, '0', '微族 浙江移动', '手动失败', '1506603189688');
INSERT INTO `purchase` VALUES ('737078599470813184', '20170922142221131707', null, '7', '13891788811', '15.5', '71', '1506061341417', '陕西移动', null, '1', '微族-陕西本地移动', '系统：成功', '1506594767442');
INSERT INTO `purchase` VALUES ('737174322786865152', null, null, '14', '13670850603', '14', '47', '1506084163634', '广东移动', null, null, '微族-广东特殊包', null, null);
INSERT INTO `purchase` VALUES ('737356742119133184', '20170923084735778847', null, '66', '15934877833', '50.4', '50', '1506127655794', '陕西移动', null, '0', '微族-陕西移动', '请检查scope', '1506566469708');
INSERT INTO `purchase` VALUES ('737393706335735808', '20170923111428115839', null, '49', '15147886270', '32', '49', '1506136468750', '内蒙古移动', null, '1', '微族-内蒙古移动', '系统：成功', '1506594763028');
INSERT INTO `purchase` VALUES ('737424963589378048', '20170923131841042588', null, '2', '15067460579', '1.71', '41', '1506143921060', '浙江移动', null, '0', '微族 浙江移动', '手动失败', '1506603186118');
INSERT INTO `purchase` VALUES ('737426662303469568', '20170923132526698446', null, '7', '18700050970', '15', '71', '1506144326065', '陕西移动', null, '0', '省内-微族-陕西本地移动', 'S:终止', '1506566469001');
INSERT INTO `purchase` VALUES ('737435903391174656', '20170923140209298090', null, '7', '18700050970', '15', '71', '1506146529312', '陕西移动', null, '1', '省内-微族-陕西本地移动', '不存在指定流量包', '1506594762354');
INSERT INTO `purchase` VALUES ('737468045408079872', null, null, '38', '15766031847', '1.74', '41', '1506154192566', '广东移动', null, null, '微族-广东移动', null, null);
INSERT INTO `purchase` VALUES ('737471334707105792', null, null, '76', '18202933064', '15', '71', '1506154976796', '陕西移动', null, null, '省内-微族-陕西本地移动', null, null);
INSERT INTO `purchase` VALUES ('737473620959301632', null, null, '76', '18202933064', '15', '71', '1506155521881', '陕西移动', null, null, '省内-微族-陕西本地移动', null, null);
INSERT INTO `purchase` VALUES ('737474150049779712', '20170923163408288196', null, '38', '15766031847', '1.74', '41', '1506155648026', '广东移动', null, '0', '微族-广东移动', '产品未配置', '1506590291892');
INSERT INTO `purchase` VALUES ('737474886519230464', '20170923163703889222', null, '38', '15766031847', '1.74', '41', '1506155823614', '广东移动', null, '0', '微族-广东移动', '产品未配置', '1506565926435');
INSERT INTO `purchase` VALUES ('737483323927957504', '20170923171035642988', null, '49', '15247879649', '34', '49', '1506157835249', '内蒙古移动', null, '1', '省漫游-微族-内蒙古移动', '系统：成功', '1506594761568');
INSERT INTO `purchase` VALUES ('737499830674264064', null, null, '70', '13530806282', '38.5', '50', '1506161770764', '广东移动', null, null, '微族-广东移动', null, null);
INSERT INTO `purchase` VALUES ('737511201176555520', '20170923190121810798', null, '49', '15134847334', '34', '49', '1506164481703', '内蒙古移动', null, '1', '省漫游-微族-内蒙古移动', '系统：成功', '1506594761233');
INSERT INTO `purchase` VALUES ('737518833211805696', '20170923193141080414', null, '7', '13891427677', '15', '71', '1506166301322', '陕西移动', null, '1', '省内-微族-陕西本地移动', '系统：成功', '1506594760870');
INSERT INTO `purchase` VALUES ('737565376132419584', '20170923223638876267', null, '70', '13923215273', '16.5', '48', '1506177398019', '广东移动', null, '1', '微族-广东移动', '系统：成功', '1506594760523');
INSERT INTO `purchase` VALUES ('737574547670175744', '20170923231304298910', null, '70', '15818703334', '27.5', '49', '1506179584684', '广东移动', null, '1', '微族-广东移动', '系统：成功', '1506594758891');
INSERT INTO `purchase` VALUES ('737739309150375936', '20170924100746284932', null, '7', '13572792773', '21', '72', '1506218866882', '陕西移动', null, '0', '省内-微族-陕西本地移动', '超时订单', '1506565926160');
INSERT INTO `purchase` VALUES ('737754847855513600', '20170924110931752785', null, '70', '13431003012', '27.5', '49', '1506222571598', '广东移动', null, '1', '微族-广东移动', '系统：成功', '1506594758266');
INSERT INTO `purchase` VALUES ('737786556068139008', '20170924131531866172', null, '7', '13572792773', '21.35', '72', '1506230131425', '陕西移动', null, '1', '省内-微族-陕西本地移动', '系统：成功', '1506594757860');
INSERT INTO `purchase` VALUES ('737915974648336384', '20170924214947247251', null, '70', '13725884364', '99', '53', '1506260987219', '广东移动', null, '0', '微族-广东移动', '产品未配置', '1506527987583');
INSERT INTO `purchase` VALUES ('738216527706198016', '20170925174404487176', null, '49', '18204887875', '20.4', '48', '1506332644652', '内蒙古移动', null, '0', '省漫游-微族-内蒙古移动', '订购失败：通道维护 失败退单', '1506565873352');
INSERT INTO `purchase` VALUES ('738228389365682176', '20170925183112497617', null, '70', '15715737826', '22.25', '49', '1506335472692', '浙江移动', null, '0', '微族-浙江移动', 'S:终止', '1506527987518');
INSERT INTO `purchase` VALUES ('738296626942054400', '20170925230221924673', null, '70', '15715737826', '22.25', '49', '1506351741798', '浙江移动', null, '0', '微族-浙江移动', 'S:终止', '1506527987453');
INSERT INTO `purchase` VALUES ('738473176706584576', '20170926104354976128', null, '70', '18219149970', '27.5', '49', '1506393834542', '广东移动', null, '0', '微族-广东移动', '产品未配置', '1506527987384');
INSERT INTO `purchase` VALUES ('738501849455267840', '20170926123750765689', null, '49', '18204887875', '20.4', '48', '1506400670658', '内蒙古移动', null, '1', '省漫游-微族-内蒙古移动', '系统：成功', '1506594709776');
INSERT INTO `purchase` VALUES ('738606509579046912', '20170926193343671543', null, '49', '15049294123', '20.4', '48', '1506425623576', '内蒙古移动', null, '0', '省漫游-微族-内蒙古移动', '订购失败：', '1506565873079');
INSERT INTO `purchase` VALUES ('738641386844196864', '20170926215219022601', null, '7', '18392500248', '15.25', '71', '1506433938964', '陕西移动', null, '1', '省内-微族-陕西本地移动', '系统：成功', '1506594675817');
INSERT INTO `purchase` VALUES ('738814160170651648', '20170927091851276459', null, '70', '18856968100', '22.4', '49', '1506475131335', '安徽移动', null, '1', '微族-安徽移动', '系统：成功', '1506594675477');
INSERT INTO `purchase` VALUES ('738829393446572032', '20170927101923796423', null, '21', '15257457509', '13.35', '48', '1506478763231', '浙江移动', null, '1', '微族-浙江移动', '系统：成功', '1506594675107');
INSERT INTO `purchase` VALUES ('739006283474014208', null, null, '26', '15929211697', '15.25', '71', '1506520937096', '陕西移动', null, null, '省内-微族-陕西本地移动', null, null);
INSERT INTO `purchase` VALUES ('739195652445048832', '20170928103446600317', null, '1', '13891258899', '2.16', '41', '1506566086181', '陕西移动', null, '0', '微族-陕西移动', '产品未配置', '1506566385894');
INSERT INTO `purchase` VALUES ('739196381788377088', null, null, '49', '15847849544', '34', '49', '1506566260070', '内蒙古移动', null, null, '省漫游-微族-内蒙古移动', null, null);
INSERT INTO `purchase` VALUES ('739197587633999872', '20170928104237613618', null, '1', '15991994058', '21.6', '48', '1506566547562', '陕西移动', null, '0', '微族-陕西移动', '充值失败', '1506755887486');
INSERT INTO `purchase` VALUES ('739215774945644544', '20170928115443917081', null, '1', '15991994058', '21.6', '48', '1506570883757', '陕西移动', null, '0', '微族-陕西移动', '充值失败', '1506755887320');
INSERT INTO `purchase` VALUES ('739301895172001792', null, null, '1', '15991994058', '21.6', '48', '1506591416419', '陕西移动', '商洛', '0', '微族-陕西移动', '手动失败', '1506596775312');
INSERT INTO `purchase` VALUES ('740133248167841792', null, null, '7', '13772150177', '82.6', '76', '1506789626416', '陕西移动', '西安', '0', '省内-微族-陕西本地移动', '手动失败', '1506789876650');
INSERT INTO `purchase` VALUES ('740133278421356544', null, null, '7', '13772150177', '82.6', '76', '1506789633634', '陕西移动', '西安', '0', '省内-微族-陕西本地移动', '手动失败', '1506789874947');
INSERT INTO `purchase` VALUES ('740138955063693312', null, null, '7', '13772150177', '82.6', '76', '1506790987051', '陕西移动', '西安', '1', '省内-微族-陕西本地移动', '手动成功', '1507458498916');
INSERT INTO `purchase` VALUES ('740139056565850112', null, null, '7', '15829697841', '82.6', '76', '1506791011251', '陕西移动', '西安', '0', '省内-微族-陕西本地移动', '手动失败', '1506791311858');
INSERT INTO `purchase` VALUES ('740268791644033024', null, null, '49', '13644846608', '34', '49', '1506821942504', '内蒙古移动', '呼和浩特', '0', '省漫游-微族-内蒙古移动', '手动失败', '1506859596214');
INSERT INTO `purchase` VALUES ('740274517791739904', null, null, '49', '15047502228', '68', '51', '1506823307724', '内蒙古移动', '通辽', '0', '省漫游-微族-内蒙古移动', '手动失败', '1506859606793');
INSERT INTO `purchase` VALUES ('740346861721751552', null, null, '49', '13847150380', '34', '49', '1506840555861', '内蒙古移动', '呼和浩特', '0', '省漫游-微族-内蒙古移动', '手动失败', '1506859593217');
INSERT INTO `purchase` VALUES ('740420382313418752', null, null, '66', '15067165679', '22.25', '49', '1506858084536', '浙江移动', '杭州', '0', '微族-浙江移动', '手动失败', '1506859589318');
INSERT INTO `purchase` VALUES ('742929196296179712', null, null, '1', '15829697841', '9.15', '70', '1507456226515', '陕西移动', '西安', '0', '省内-微族-陕西本地移动', '手动失败', '1507458440231');
INSERT INTO `purchase` VALUES ('742931913827684352', null, null, '1', '15829697841', '9.15', '70', '1507456880309', '陕西移动', '西安', '0', '省内-微族-陕西本地移动', '手动失败', '1507458436340');
INSERT INTO `purchase` VALUES ('742935019080650752', '20171008181349622694', null, '1', '15829697841', '9.15', '70', '1507457618004', '陕西移动', '西安', '0', '省内-微族-陕西本地移动', '充值失败', '1507457702764');
INSERT INTO `purchase` VALUES ('742952647115411456', '20171008192343729899', null, '49', '13848645303', '20.4', '48', '1507461823510', '内蒙古移动', '集宁', '0', '省漫游-微族-内蒙古移动', '扣款与成本不符', '1507461903993');
INSERT INTO `purchase` VALUES ('743141048422764544', '20171009075221637820', null, '49', '13848645303', '20.4', '48', '1507506741884', '内蒙古移动', '集宁', '1', '省漫游-微族-内蒙古移动', '系统：成功', '1507511054799');
INSERT INTO `purchase` VALUES ('743367459439906816', '20171009225202551638', null, '7', '13572481487', '54.9', '75', '1507560722473', '陕西移动', '西安', '1', '省内-微族-陕西本地移动', '系统：成功', '1507567110009');
INSERT INTO `purchase` VALUES ('743516322964443136', '20171010084334228434', null, '7', '13679223452', '15.25', '71', '1507596214307', '陕西移动', '西安', '1', '省内-微族-陕西本地移动', '系统：成功', '1507619219120');
INSERT INTO `purchase` VALUES ('743582063717781504', '20171010130448967631', null, '49', '18704866317', '34', '49', '1507611888124', '内蒙古移动', '乌兰浩特', '1', '省漫游-微族-内蒙古移动', '系统：成功', '1507617016161');
INSERT INTO `purchase` VALUES ('743603552697454592', '20171010143011940624', null, '49', '15934006525', '32.69', '50', '1507617011496', '山西移动', '忻州', '1', '微族-山西移动', '系统：成功', '1507622200509');
INSERT INTO `purchase` VALUES ('743612742484627456', '20171010150642076063', null, '7', '18329590778', '39.65', '74', '1507619202512', '陕西移动', '铜川', '1', '省内-微族-陕西本地移动', '系统：成功', '1507619275577');
INSERT INTO `purchase` VALUES ('743690133676494848', '20171010201414694095', null, '7', '15229230370', '21.35', '72', '1507637654010', '陕西移动', '西安', '1', '省内-微族-陕西本地移动', '系统：成功', '1507638070137');
INSERT INTO `purchase` VALUES ('744029954060062720', '20171011184433097283', null, '55', '15929201495', '21.35', '72', '1507718673503', '陕西移动', '咸阳', '1', '省内-微族-陕西本地移动', '不存在指定流量包', '1507719085110');
INSERT INTO `purchase` VALUES ('744089071126581248', '20171011223928288518', null, '49', '18347177237', '47.6', '50', '1507732768110', '内蒙古移动', '呼和浩特', '1', '省漫游-微族-内蒙古移动', '系统：成功', '1507734289907');
INSERT INTO `purchase` VALUES ('744120431207780352', '20171012004405057006', null, '7', '15909256109', '54.9', '75', '1507740244936', '陕西移动', '商洛', '1', '省内-微族-陕西本地移动', '系统：成功', '1507740310602');
INSERT INTO `purchase` VALUES ('744281164637802496', '20171012112246403477', null, '7', '13891427677', '21.35', '72', '1507778566772', '陕西移动', '商洛', '1', '省内-微族-陕西本地移动', '系统：成功', '1507778650889');
INSERT INTO `purchase` VALUES ('744367496085114880', '20171012170549749526', null, '49', '13948893256', '47.6', '50', '1507799149793', '内蒙古移动', '乌兰浩特', '1', '省漫游-微族-内蒙古移动', '系统：成功', '1507799295962');
INSERT INTO `purchase` VALUES ('744762684209106944', '20171013191610241723', null, '1', '13891626924', '8.7', '70', '1507893369982', '陕西移动', '汉中', '0', '省内-微族-陕西本地移动', '充值失败', '1507893403014');
INSERT INTO `purchase` VALUES ('744783096494166016', '20171013203716141945', null, '1', '13891626924', '8.7', '70', '1507898236652', '陕西移动', '汉中', '0', '省内-微族-陕西本地移动', '充值失败', '1507898441460');
INSERT INTO `purchase` VALUES ('744783420676116480', '20171013203834692955', null, '2', '13891626924', '8.7', '70', '1507898313943', '陕西移动', '汉中', '0', '省内-微族-陕西本地移动', '充值失败', '1507898328204');
INSERT INTO `purchase` VALUES ('744783669767442432', '20171013203933773076', null, '2', '13891626924', '8.7', '70', '1507898373331', '陕西移动', '汉中', '1', '省内-微族-陕西本地移动', '系统：成功', '1507898394904');
INSERT INTO `purchase` VALUES ('744784836631203840', '20171013204411215715', null, '2', '13891626924', '8.7', '70', '1507898651533', '陕西移动', '汉中', '0', '省内-微族-陕西本地移动', '充值失败', '1507898688787');
INSERT INTO `purchase` VALUES ('744784864061952000', '20171013204418963675', null, '2', '13891626924', '14.5', '71', '1507898658073', '陕西移动', '汉中', '1', '省内-微族-陕西本地移动', '系统：成功', '1507898688730');
INSERT INTO `purchase` VALUES ('745084487909511168', '20171014163454107178', null, '96', '18139216390', '12.5', '87', '1507970093963', '新疆电信', '伊犁', '0', '微族-新疆电信', '请检查scope', '1507970098735');
INSERT INTO `purchase` VALUES ('745084490442870784', '20171014163454787633', null, '96', '18139216390', '12.5', '87', '1507970094569', '新疆电信', '伊犁', '0', '微族-新疆电信', '请检查scope', '1507970098673');
INSERT INTO `purchase` VALUES ('745084491248177152', '20171014163454111939', null, '96', '18139216390', '12.5', '87', '1507970094761', '新疆电信', '伊犁', '0', '微族-新疆电信', '请检查scope', '1507970098612');
INSERT INTO `purchase` VALUES ('745084491994763264', '20171014163454953055', null, '96', '18139216390', '12.5', '87', '1507970094939', '新疆电信', '伊犁', '0', '微族-新疆电信', '请检查scope', '1507970098531');
INSERT INTO `purchase` VALUES ('745096436680495104', '20171014172229212738', null, '1', '13891626924', '2.7', '78', '1507972934688', '陕西移动', '汉中', '0', '省内-微族-陕西本地移动', '充值失败', '1507972999481');

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
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rate_discount
-- ----------------------------
INSERT INTO `rate_discount` VALUES ('26', '0.47', null, '27', '0', '30');
INSERT INTO `rate_discount` VALUES ('29', '0.76', null, '44', '0', '47');
INSERT INTO `rate_discount` VALUES ('30', '0.668', null, '43', '0', '46');
INSERT INTO `rate_discount` VALUES ('36', '0.7', null, '45', '0', '48');
INSERT INTO `rate_discount` VALUES ('37', '0.68', null, '46', '0', '49');
INSERT INTO `rate_discount` VALUES ('39', '0.612', null, '48', '0', '51');
INSERT INTO `rate_discount` VALUES ('40', '0.445', null, '49', '0', '52');
INSERT INTO `rate_discount` VALUES ('41', '0.467', null, '50', '0', '53');
INSERT INTO `rate_discount` VALUES ('42', '0.44', null, '53', '0', '56');
INSERT INTO `rate_discount` VALUES ('43', '0.81', null, '54', '0', '57');
INSERT INTO `rate_discount` VALUES ('49', '0.68', null, '46', '0', '49');
INSERT INTO `rate_discount` VALUES ('50', '0.6900000000000001', '49', '46', '0', '49');
INSERT INTO `rate_discount` VALUES ('51', '0.5', '41', '50', '0', '53');
INSERT INTO `rate_discount` VALUES ('52', '0.8', '29', '44', '0', '47');
INSERT INTO `rate_discount` VALUES ('53', '0.5', '40', '49', '0', '52');
INSERT INTO `rate_discount` VALUES ('54', '0.484', '42', '53', '0', '56');
INSERT INTO `rate_discount` VALUES ('55', '0.7', '39', '48', '0', '51');
INSERT INTO `rate_discount` VALUES ('56', '0.8280000000000001', '43', '54', '0', '57');
INSERT INTO `rate_discount` VALUES ('57', '0.8', '36', '45', '0', '48');
INSERT INTO `rate_discount` VALUES ('58', '0.31999999999999995', '46', '58', '0', '61');
INSERT INTO `rate_discount` VALUES ('59', '0.696', '30', '43', '0', '46');
INSERT INTO `rate_discount` VALUES ('60', '0.23', null, '58', '0', '61');
INSERT INTO `rate_discount` VALUES ('63', '0.55', null, '61', '0', '64');
INSERT INTO `rate_discount` VALUES ('64', '0.41', null, '62', '0', '65');
INSERT INTO `rate_discount` VALUES ('65', '0.69', '37', '46', '0', '49');
INSERT INTO `rate_discount` VALUES ('66', '0.69', '37', '46', '0', '49');
INSERT INTO `rate_discount` VALUES ('67', '0.69', '37', '46', '0', '49');
INSERT INTO `rate_discount` VALUES ('68', '0.72', null, '63', '0', '66');
INSERT INTO `rate_discount` VALUES ('69', '0.69', null, '64', '0', '67');
INSERT INTO `rate_discount` VALUES ('70', '0.65', null, '65', '0', '68');
INSERT INTO `rate_discount` VALUES ('71', '0.45', null, '66', '0', '69');
INSERT INTO `rate_discount` VALUES ('72', '0.7', null, '67', '0', '70');
INSERT INTO `rate_discount` VALUES ('73', '0.25', null, '68', '0', '71');
INSERT INTO `rate_discount` VALUES ('74', '0.375', null, '69', '0', '72');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of transfer_record
-- ----------------------------
INSERT INTO `transfer_record` VALUES ('2', '6', '7', '1', '1', '1507949378149', '1507862957000', '1507949397895', '1', '2', '1', '6031797591584');
INSERT INTO `transfer_record` VALUES ('3', '6', '7', '1', '0', '1507950327930', '1507950312000', '1507970297132', '0', '2', '1', '6031881188532');
