/*
Navicat MySQL Data Transfer

Source Server         : channel-server
Source Server Version : 50626
Source Host           : 120.55.162.224:3306
Source Database       : rate_channel

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2017-09-20 15:08:27
*/

SET FOREIGN_KEY_CHECKS=0;
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
) ENGINE=InnoDB AUTO_INCREMENT=773 DEFAULT CHARSET=utf8;

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
INSERT INTO `agency_active_rate` VALUES ('54', '13', '1', '24', '0', 'zqy95178250', '1505707914214');
INSERT INTO `agency_active_rate` VALUES ('55', '14', '1', '24', '0', 'QQ574912927', '1505707914214');
INSERT INTO `agency_active_rate` VALUES ('56', '15', '1', '24', '0', '1579599827', '1505707914214');
INSERT INTO `agency_active_rate` VALUES ('57', '17', '1', '24', '0', '789', '1505707914214');
INSERT INTO `agency_active_rate` VALUES ('58', '18', '1', '24', '0', '112', '1505707914214');
INSERT INTO `agency_active_rate` VALUES ('59', '20', '1', '24', '0', 'b2218776', '1505707914214');
INSERT INTO `agency_active_rate` VALUES ('60', '21', '1', '24', '0', '13771547176', '1505707914214');
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
INSERT INTO `agency_active_rate` VALUES ('125', '2', '1', '24', '0', '123', '1505744222093');
INSERT INTO `agency_active_rate` VALUES ('126', '4', '1', '24', '0', 'wzkj', '1505744222093');
INSERT INTO `agency_active_rate` VALUES ('127', '5', '1', '24', '0', '冰河', '1505744222093');
INSERT INTO `agency_active_rate` VALUES ('128', '6', '1', '24', '0', 'jiafeng', '1505744222093');
INSERT INTO `agency_active_rate` VALUES ('129', '7', '1', '24', '0', 'l474705958', '1505744222093');
INSERT INTO `agency_active_rate` VALUES ('130', '8', '1', '24', '0', '184066643', '1505744222093');
INSERT INTO `agency_active_rate` VALUES ('131', '9', '1', '24', '0', '2369412', '1505744222093');
INSERT INTO `agency_active_rate` VALUES ('132', '10', '1', '24', '0', 'hy123', '1505744222093');
INSERT INTO `agency_active_rate` VALUES ('133', '11', '1', '24', '0', 'zishu', '1505744222093');
INSERT INTO `agency_active_rate` VALUES ('134', '12', '1', '24', '0', 'tianjing', '1505744222093');
INSERT INTO `agency_active_rate` VALUES ('135', '22', '1', '24', '0', '1', '1505744223946');
INSERT INTO `agency_active_rate` VALUES ('136', '23', '1', '24', '0', '小aq', '1505744223946');
INSERT INTO `agency_active_rate` VALUES ('137', '24', '1', '24', '0', '15914897978', '1505744223946');
INSERT INTO `agency_active_rate` VALUES ('138', '25', '1', '24', '0', 'oushinanshen', '1505744223946');
INSERT INTO `agency_active_rate` VALUES ('139', '26', '1', '24', '0', 'wxx899999', '1505744223946');
INSERT INTO `agency_active_rate` VALUES ('140', '27', '1', '24', '0', '1464975293', '1505744223946');
INSERT INTO `agency_active_rate` VALUES ('141', '28', '1', '24', '0', 'Bear', '1505744223946');
INSERT INTO `agency_active_rate` VALUES ('142', '29', '1', '24', '0', 'zxx', '1505744223946');
INSERT INTO `agency_active_rate` VALUES ('143', '30', '1', '24', '0', 'hy123456', '1505744223946');
INSERT INTO `agency_active_rate` VALUES ('144', '31', '1', '24', '0', 'wl123', '1505744223946');
INSERT INTO `agency_active_rate` VALUES ('145', '32', '1', '24', '0', '鳯儿网店', '1505744225789');
INSERT INTO `agency_active_rate` VALUES ('146', '33', '1', '24', '0', 'ruiruima', '1505744225789');
INSERT INTO `agency_active_rate` VALUES ('147', '34', '1', '24', '0', '944581678', '1505744225789');
INSERT INTO `agency_active_rate` VALUES ('148', '35', '1', '24', '0', '2069959168', '1505744225789');
INSERT INTO `agency_active_rate` VALUES ('149', '36', '1', '24', '0', '570156062', '1505744225789');
INSERT INTO `agency_active_rate` VALUES ('150', '37', '1', '24', '0', '770733914', '1505744225789');
INSERT INTO `agency_active_rate` VALUES ('151', '38', '1', '24', '0', '5257', '1505744225789');
INSERT INTO `agency_active_rate` VALUES ('152', '39', '1', '24', '0', '18734158108', '1505744225789');
INSERT INTO `agency_active_rate` VALUES ('153', '40', '1', '24', '0', 'xhq1347574865', '1505823345499');
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
INSERT INTO `agency_active_rate` VALUES ('206', '2', '1', '27', '1', '123', '1505819420228');
INSERT INTO `agency_active_rate` VALUES ('207', '4', '1', '27', '0', 'wzkj', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('208', '5', '1', '27', '0', '冰河', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('209', '6', '1', '27', '0', 'jiafeng', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('210', '7', '1', '27', '0', 'l474705958', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('211', '8', '1', '27', '0', '184066643', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('212', '9', '1', '27', '0', '2369412', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('213', '10', '1', '27', '0', 'hy123', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('214', '11', '1', '27', '0', 'zishu', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('215', '12', '1', '27', '0', 'tianjing', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('216', '13', '1', '27', '0', 'zqy95178250', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('217', '14', '1', '27', '0', 'QQ574912927', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('218', '15', '1', '27', '0', '1579599827', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('219', '17', '1', '27', '0', '789', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('220', '18', '1', '27', '0', '112', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('221', '20', '1', '27', '0', 'b2218776', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('222', '21', '1', '27', '0', '13771547176', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('223', '22', '1', '27', '0', '1', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('224', '23', '1', '27', '0', '小aq', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('225', '24', '1', '27', '0', '15914897978', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('226', '25', '1', '27', '0', 'oushinanshen', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('227', '26', '1', '27', '0', 'wxx899999', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('228', '27', '1', '27', '0', '1464975293', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('229', '28', '1', '27', '0', 'Bear', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('230', '29', '1', '27', '0', 'zxx', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('231', '30', '1', '27', '0', 'hy123456', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('232', '31', '1', '27', '0', 'wl123', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('233', '32', '1', '27', '0', '鳯儿网店', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('234', '33', '1', '27', '0', 'ruiruima', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('235', '34', '1', '27', '0', '944581678', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('236', '35', '1', '27', '0', '2069959168', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('237', '36', '1', '27', '0', '570156062', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('238', '37', '1', '27', '0', '770733914', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('239', '38', '1', '27', '0', '5257', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('240', '39', '1', '27', '0', '18734158108', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('241', '40', '1', '27', '0', 'xhq1347574865', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('242', '41', '1', '27', '0', 'Chen', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('243', '42', '1', '27', '0', 'qq130496', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('244', '43', '1', '27', '0', 'kevinchow', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('245', '44', '1', '27', '0', '17346544413', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('246', '45', '1', '27', '0', '2480199685', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('247', '46', '1', '27', '0', 'jim145', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('248', '47', '1', '27', '0', 'bada', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('249', '48', '1', '27', '0', '罗大大', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('250', '49', '1', '27', '0', '109', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('251', '50', '1', '27', '0', '119', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('252', '51', '1', '27', '0', 'gigi77', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('253', '52', '1', '27', '0', 'gigi777', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('254', '45', '1', '26', '0', '2480199685', '1505829677290');
INSERT INTO `agency_active_rate` VALUES ('255', '46', '1', '26', '0', 'jim145', '1505829677290');
INSERT INTO `agency_active_rate` VALUES ('256', '47', '1', '26', '0', 'bada', '1505829677290');
INSERT INTO `agency_active_rate` VALUES ('257', '48', '1', '26', '0', '罗大大', '1505829677290');
INSERT INTO `agency_active_rate` VALUES ('258', '49', '1', '26', '0', '109', '1505829677290');
INSERT INTO `agency_active_rate` VALUES ('259', '50', '1', '26', '0', '119', '1505829677290');
INSERT INTO `agency_active_rate` VALUES ('260', '51', '1', '26', '0', 'gigi77', '1505829677290');
INSERT INTO `agency_active_rate` VALUES ('261', '52', '1', '26', '0', 'gigi777', '1505829677290');
INSERT INTO `agency_active_rate` VALUES ('262', '2', '1', '28', '0', '123', '1505829703960');
INSERT INTO `agency_active_rate` VALUES ('263', '4', '1', '28', '0', 'wzkj', '1505829703960');
INSERT INTO `agency_active_rate` VALUES ('264', '5', '1', '28', '0', '冰河', '1505829703960');
INSERT INTO `agency_active_rate` VALUES ('265', '6', '1', '28', '0', 'jiafeng', '1505829703960');
INSERT INTO `agency_active_rate` VALUES ('266', '7', '1', '28', '0', 'l474705958', '1505829703960');
INSERT INTO `agency_active_rate` VALUES ('267', '8', '1', '28', '0', '184066643', '1505829703960');
INSERT INTO `agency_active_rate` VALUES ('268', '9', '1', '28', '0', '2369412', '1505829703960');
INSERT INTO `agency_active_rate` VALUES ('269', '10', '1', '28', '0', 'hy123', '1505829703960');
INSERT INTO `agency_active_rate` VALUES ('270', '11', '1', '28', '0', 'zishu', '1505829703960');
INSERT INTO `agency_active_rate` VALUES ('271', '12', '1', '28', '0', 'tianjing', '1505829703960');
INSERT INTO `agency_active_rate` VALUES ('272', '13', '1', '28', '0', 'zqy95178250', '1505829706334');
INSERT INTO `agency_active_rate` VALUES ('273', '14', '1', '28', '0', 'QQ574912927', '1505829706334');
INSERT INTO `agency_active_rate` VALUES ('274', '15', '1', '28', '0', '1579599827', '1505829706334');
INSERT INTO `agency_active_rate` VALUES ('275', '17', '1', '28', '0', '789', '1505829706334');
INSERT INTO `agency_active_rate` VALUES ('276', '18', '1', '28', '0', '112', '1505829706334');
INSERT INTO `agency_active_rate` VALUES ('277', '20', '1', '28', '0', 'b2218776', '1505829706334');
INSERT INTO `agency_active_rate` VALUES ('278', '21', '1', '28', '0', '13771547176', '1505829706334');
INSERT INTO `agency_active_rate` VALUES ('279', '22', '1', '28', '0', '1', '1505829706334');
INSERT INTO `agency_active_rate` VALUES ('280', '23', '1', '28', '0', '小aq', '1505829706334');
INSERT INTO `agency_active_rate` VALUES ('281', '24', '1', '28', '0', '15914897978', '1505829706334');
INSERT INTO `agency_active_rate` VALUES ('282', '25', '1', '28', '0', 'oushinanshen', '1505829708010');
INSERT INTO `agency_active_rate` VALUES ('283', '26', '1', '28', '0', 'wxx899999', '1505829708010');
INSERT INTO `agency_active_rate` VALUES ('284', '27', '1', '28', '0', '1464975293', '1505829708010');
INSERT INTO `agency_active_rate` VALUES ('285', '28', '1', '28', '0', 'Bear', '1505829708010');
INSERT INTO `agency_active_rate` VALUES ('286', '29', '1', '28', '0', 'zxx', '1505829708010');
INSERT INTO `agency_active_rate` VALUES ('287', '30', '1', '28', '0', 'hy123456', '1505829708010');
INSERT INTO `agency_active_rate` VALUES ('288', '31', '1', '28', '0', 'wl123', '1505829708010');
INSERT INTO `agency_active_rate` VALUES ('289', '32', '1', '28', '0', '鳯儿网店', '1505829708010');
INSERT INTO `agency_active_rate` VALUES ('290', '33', '1', '28', '0', 'ruiruima', '1505829708010');
INSERT INTO `agency_active_rate` VALUES ('291', '34', '1', '28', '0', '944581678', '1505829708010');
INSERT INTO `agency_active_rate` VALUES ('292', '35', '1', '28', '0', '2069959168', '1505829709671');
INSERT INTO `agency_active_rate` VALUES ('293', '36', '1', '28', '0', '570156062', '1505829709671');
INSERT INTO `agency_active_rate` VALUES ('294', '37', '1', '28', '0', '770733914', '1505829709671');
INSERT INTO `agency_active_rate` VALUES ('295', '38', '1', '28', '0', '5257', '1505829709671');
INSERT INTO `agency_active_rate` VALUES ('296', '39', '1', '28', '0', '18734158108', '1505829709671');
INSERT INTO `agency_active_rate` VALUES ('297', '40', '1', '28', '0', 'xhq1347574865', '1505829709671');
INSERT INTO `agency_active_rate` VALUES ('298', '41', '1', '28', '0', 'Chen', '1505829709671');
INSERT INTO `agency_active_rate` VALUES ('299', '42', '1', '28', '0', 'qq130496', '1505829709671');
INSERT INTO `agency_active_rate` VALUES ('300', '43', '1', '28', '0', 'kevinchow', '1505829709671');
INSERT INTO `agency_active_rate` VALUES ('301', '44', '1', '28', '0', '17346544413', '1505829709671');
INSERT INTO `agency_active_rate` VALUES ('302', '45', '1', '28', '0', '2480199685', '1505829711374');
INSERT INTO `agency_active_rate` VALUES ('303', '46', '1', '28', '0', 'jim145', '1505829711374');
INSERT INTO `agency_active_rate` VALUES ('304', '47', '1', '28', '0', 'bada', '1505829711374');
INSERT INTO `agency_active_rate` VALUES ('305', '48', '1', '28', '0', '罗大大', '1505829711374');
INSERT INTO `agency_active_rate` VALUES ('306', '49', '1', '28', '0', '109', '1505829711374');
INSERT INTO `agency_active_rate` VALUES ('307', '50', '1', '28', '0', '119', '1505829711374');
INSERT INTO `agency_active_rate` VALUES ('308', '51', '1', '28', '0', 'gigi77', '1505829711374');
INSERT INTO `agency_active_rate` VALUES ('309', '52', '1', '28', '0', 'gigi777', '1505829711374');
INSERT INTO `agency_active_rate` VALUES ('310', '41', '1', '24', '0', 'Chen', '1505829724397');
INSERT INTO `agency_active_rate` VALUES ('311', '42', '1', '24', '0', 'qq130496', '1505829724397');
INSERT INTO `agency_active_rate` VALUES ('312', '43', '1', '24', '0', 'kevinchow', '1505829724397');
INSERT INTO `agency_active_rate` VALUES ('313', '44', '1', '24', '0', '17346544413', '1505829724397');
INSERT INTO `agency_active_rate` VALUES ('314', '45', '1', '24', '0', '2480199685', '1505829724397');
INSERT INTO `agency_active_rate` VALUES ('315', '46', '1', '24', '0', 'jim145', '1505829724397');
INSERT INTO `agency_active_rate` VALUES ('316', '47', '1', '24', '0', 'bada', '1505829724397');
INSERT INTO `agency_active_rate` VALUES ('317', '48', '1', '24', '0', '罗大大', '1505829724397');
INSERT INTO `agency_active_rate` VALUES ('318', '49', '1', '24', '0', '109', '1505829724397');
INSERT INTO `agency_active_rate` VALUES ('319', '50', '1', '24', '0', '119', '1505829724397');
INSERT INTO `agency_active_rate` VALUES ('320', '51', '1', '24', '0', 'gigi77', '1505829725892');
INSERT INTO `agency_active_rate` VALUES ('321', '52', '1', '24', '0', 'gigi777', '1505829725892');
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
INSERT INTO `agency_active_rate` VALUES ('401', '2', '1', '30', '0', '123', '1505872369456');
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
INSERT INTO `agency_active_rate` VALUES ('449', '2', '1', '31', '0', '123', '1505872393189');
INSERT INTO `agency_active_rate` VALUES ('450', '4', '1', '31', '0', 'wzkj', '1505872393189');
INSERT INTO `agency_active_rate` VALUES ('451', '5', '1', '31', '0', '冰河', '1505872393189');
INSERT INTO `agency_active_rate` VALUES ('452', '6', '1', '31', '0', 'jiafeng', '1505872393189');
INSERT INTO `agency_active_rate` VALUES ('453', '7', '1', '31', '0', 'l474705958', '1505872393189');
INSERT INTO `agency_active_rate` VALUES ('454', '8', '1', '31', '0', '184066643', '1505872393189');
INSERT INTO `agency_active_rate` VALUES ('455', '9', '1', '31', '0', '2369412', '1505872393189');
INSERT INTO `agency_active_rate` VALUES ('456', '10', '1', '31', '0', 'hy123', '1505872393189');
INSERT INTO `agency_active_rate` VALUES ('457', '11', '1', '31', '0', 'zishu', '1505872393189');
INSERT INTO `agency_active_rate` VALUES ('458', '12', '1', '31', '0', 'tianjing', '1505872393189');
INSERT INTO `agency_active_rate` VALUES ('459', '13', '1', '31', '0', 'zqy95178250', '1505872394883');
INSERT INTO `agency_active_rate` VALUES ('460', '14', '1', '31', '0', 'QQ574912927', '1505872394883');
INSERT INTO `agency_active_rate` VALUES ('461', '15', '1', '31', '0', '1579599827', '1505872394883');
INSERT INTO `agency_active_rate` VALUES ('462', '17', '1', '31', '0', '789', '1505872394883');
INSERT INTO `agency_active_rate` VALUES ('463', '18', '1', '31', '0', '112', '1505872394883');
INSERT INTO `agency_active_rate` VALUES ('464', '20', '1', '31', '0', 'b2218776', '1505872394883');
INSERT INTO `agency_active_rate` VALUES ('465', '21', '1', '31', '0', '13771547176', '1505872394883');
INSERT INTO `agency_active_rate` VALUES ('466', '22', '1', '31', '0', '1', '1505872394883');
INSERT INTO `agency_active_rate` VALUES ('467', '23', '1', '31', '0', '小aq', '1505872394883');
INSERT INTO `agency_active_rate` VALUES ('468', '24', '1', '31', '0', '15914897978', '1505872394883');
INSERT INTO `agency_active_rate` VALUES ('469', '25', '1', '31', '0', 'oushinanshen', '1505872396859');
INSERT INTO `agency_active_rate` VALUES ('470', '26', '1', '31', '0', 'wxx899999', '1505872396859');
INSERT INTO `agency_active_rate` VALUES ('471', '27', '1', '31', '0', '1464975293', '1505872396859');
INSERT INTO `agency_active_rate` VALUES ('472', '28', '1', '31', '0', 'Bear', '1505872396859');
INSERT INTO `agency_active_rate` VALUES ('473', '29', '1', '31', '0', 'zxx', '1505872396859');
INSERT INTO `agency_active_rate` VALUES ('474', '30', '1', '31', '0', 'hy123456', '1505872396859');
INSERT INTO `agency_active_rate` VALUES ('475', '31', '1', '31', '0', 'wl123', '1505872396859');
INSERT INTO `agency_active_rate` VALUES ('476', '32', '1', '31', '0', '鳯儿网店', '1505872396859');
INSERT INTO `agency_active_rate` VALUES ('477', '33', '1', '31', '0', 'ruiruima', '1505872396859');
INSERT INTO `agency_active_rate` VALUES ('478', '34', '1', '31', '0', '944581678', '1505872396859');
INSERT INTO `agency_active_rate` VALUES ('479', '35', '1', '31', '0', '2069959168', '1505872398452');
INSERT INTO `agency_active_rate` VALUES ('480', '36', '1', '31', '0', '570156062', '1505872398452');
INSERT INTO `agency_active_rate` VALUES ('481', '37', '1', '31', '0', '770733914', '1505872398452');
INSERT INTO `agency_active_rate` VALUES ('482', '38', '1', '31', '0', '5257', '1505872398452');
INSERT INTO `agency_active_rate` VALUES ('483', '39', '1', '31', '0', '18734158108', '1505872398452');
INSERT INTO `agency_active_rate` VALUES ('484', '40', '1', '31', '0', 'xhq1347574865', '1505872398452');
INSERT INTO `agency_active_rate` VALUES ('485', '41', '1', '31', '0', 'Chen', '1505872398452');
INSERT INTO `agency_active_rate` VALUES ('486', '42', '1', '31', '0', 'qq130496', '1505872398452');
INSERT INTO `agency_active_rate` VALUES ('487', '43', '1', '31', '0', 'kevinchow', '1505872398452');
INSERT INTO `agency_active_rate` VALUES ('488', '44', '1', '31', '0', '17346544413', '1505872398452');
INSERT INTO `agency_active_rate` VALUES ('489', '45', '1', '31', '0', '2480199685', '1505872400091');
INSERT INTO `agency_active_rate` VALUES ('490', '46', '1', '31', '0', 'jim145', '1505872400091');
INSERT INTO `agency_active_rate` VALUES ('491', '47', '1', '31', '0', 'bada', '1505872400091');
INSERT INTO `agency_active_rate` VALUES ('492', '48', '1', '31', '0', '罗大大', '1505872400091');
INSERT INTO `agency_active_rate` VALUES ('493', '49', '1', '31', '0', '109', '1505872400091');
INSERT INTO `agency_active_rate` VALUES ('494', '50', '1', '31', '0', '119', '1505872400091');
INSERT INTO `agency_active_rate` VALUES ('495', '51', '1', '31', '0', 'gigi77', '1505872400091');
INSERT INTO `agency_active_rate` VALUES ('496', '52', '1', '31', '0', 'gigi777', '1505872400091');
INSERT INTO `agency_active_rate` VALUES ('497', '2', '1', '32', '0', '123', '1505872419524');
INSERT INTO `agency_active_rate` VALUES ('498', '4', '1', '32', '0', 'wzkj', '1505872419524');
INSERT INTO `agency_active_rate` VALUES ('499', '5', '1', '32', '0', '冰河', '1505872419524');
INSERT INTO `agency_active_rate` VALUES ('500', '6', '1', '32', '0', 'jiafeng', '1505872419524');
INSERT INTO `agency_active_rate` VALUES ('501', '7', '1', '32', '0', 'l474705958', '1505872419524');
INSERT INTO `agency_active_rate` VALUES ('502', '8', '1', '32', '0', '184066643', '1505872419524');
INSERT INTO `agency_active_rate` VALUES ('503', '9', '1', '32', '0', '2369412', '1505872419524');
INSERT INTO `agency_active_rate` VALUES ('504', '10', '1', '32', '0', 'hy123', '1505872419524');
INSERT INTO `agency_active_rate` VALUES ('505', '11', '1', '32', '0', 'zishu', '1505872419524');
INSERT INTO `agency_active_rate` VALUES ('506', '12', '1', '32', '0', 'tianjing', '1505872419524');
INSERT INTO `agency_active_rate` VALUES ('507', '13', '1', '32', '0', 'zqy95178250', '1505872421668');
INSERT INTO `agency_active_rate` VALUES ('508', '14', '1', '32', '0', 'QQ574912927', '1505872421668');
INSERT INTO `agency_active_rate` VALUES ('509', '15', '1', '32', '0', '1579599827', '1505872421668');
INSERT INTO `agency_active_rate` VALUES ('510', '17', '1', '32', '0', '789', '1505872421668');
INSERT INTO `agency_active_rate` VALUES ('511', '18', '1', '32', '0', '112', '1505872421668');
INSERT INTO `agency_active_rate` VALUES ('512', '20', '1', '32', '0', 'b2218776', '1505872421668');
INSERT INTO `agency_active_rate` VALUES ('513', '21', '1', '32', '0', '13771547176', '1505872421668');
INSERT INTO `agency_active_rate` VALUES ('514', '22', '1', '32', '0', '1', '1505872421668');
INSERT INTO `agency_active_rate` VALUES ('515', '23', '1', '32', '0', '小aq', '1505872421668');
INSERT INTO `agency_active_rate` VALUES ('516', '24', '1', '32', '0', '15914897978', '1505872421668');
INSERT INTO `agency_active_rate` VALUES ('517', '25', '1', '32', '0', 'oushinanshen', '1505872423342');
INSERT INTO `agency_active_rate` VALUES ('518', '26', '1', '32', '0', 'wxx899999', '1505872423342');
INSERT INTO `agency_active_rate` VALUES ('519', '27', '1', '32', '0', '1464975293', '1505872423342');
INSERT INTO `agency_active_rate` VALUES ('520', '28', '1', '32', '0', 'Bear', '1505872423342');
INSERT INTO `agency_active_rate` VALUES ('521', '29', '1', '32', '0', 'zxx', '1505872423342');
INSERT INTO `agency_active_rate` VALUES ('522', '30', '1', '32', '0', 'hy123456', '1505872423342');
INSERT INTO `agency_active_rate` VALUES ('523', '31', '1', '32', '0', 'wl123', '1505872423342');
INSERT INTO `agency_active_rate` VALUES ('524', '32', '1', '32', '0', '鳯儿网店', '1505872423342');
INSERT INTO `agency_active_rate` VALUES ('525', '33', '1', '32', '0', 'ruiruima', '1505872423342');
INSERT INTO `agency_active_rate` VALUES ('526', '34', '1', '32', '0', '944581678', '1505872423342');
INSERT INTO `agency_active_rate` VALUES ('527', '35', '1', '32', '0', '2069959168', '1505872425094');
INSERT INTO `agency_active_rate` VALUES ('528', '36', '1', '32', '0', '570156062', '1505872425094');
INSERT INTO `agency_active_rate` VALUES ('529', '37', '1', '32', '0', '770733914', '1505872425094');
INSERT INTO `agency_active_rate` VALUES ('530', '38', '1', '32', '0', '5257', '1505872425094');
INSERT INTO `agency_active_rate` VALUES ('531', '39', '1', '32', '0', '18734158108', '1505872425094');
INSERT INTO `agency_active_rate` VALUES ('532', '40', '1', '32', '0', 'xhq1347574865', '1505872425094');
INSERT INTO `agency_active_rate` VALUES ('533', '41', '1', '32', '0', 'Chen', '1505872425094');
INSERT INTO `agency_active_rate` VALUES ('534', '42', '1', '32', '0', 'qq130496', '1505872425094');
INSERT INTO `agency_active_rate` VALUES ('535', '43', '1', '32', '0', 'kevinchow', '1505872425094');
INSERT INTO `agency_active_rate` VALUES ('536', '44', '1', '32', '0', '17346544413', '1505872425094');
INSERT INTO `agency_active_rate` VALUES ('537', '45', '1', '32', '0', '2480199685', '1505872426797');
INSERT INTO `agency_active_rate` VALUES ('538', '46', '1', '32', '0', 'jim145', '1505872426797');
INSERT INTO `agency_active_rate` VALUES ('539', '47', '1', '32', '0', 'bada', '1505872426797');
INSERT INTO `agency_active_rate` VALUES ('540', '48', '1', '32', '0', '罗大大', '1505872426797');
INSERT INTO `agency_active_rate` VALUES ('541', '49', '1', '32', '0', '109', '1505872426797');
INSERT INTO `agency_active_rate` VALUES ('542', '50', '1', '32', '0', '119', '1505872426797');
INSERT INTO `agency_active_rate` VALUES ('543', '51', '1', '32', '0', 'gigi77', '1505872426798');
INSERT INTO `agency_active_rate` VALUES ('544', '52', '1', '32', '0', 'gigi777', '1505872426798');
INSERT INTO `agency_active_rate` VALUES ('545', '2', '1', '33', '0', '123', '1505872443268');
INSERT INTO `agency_active_rate` VALUES ('546', '4', '1', '33', '0', 'wzkj', '1505872443268');
INSERT INTO `agency_active_rate` VALUES ('547', '5', '1', '33', '0', '冰河', '1505872443268');
INSERT INTO `agency_active_rate` VALUES ('548', '6', '1', '33', '0', 'jiafeng', '1505872443268');
INSERT INTO `agency_active_rate` VALUES ('549', '7', '1', '33', '0', 'l474705958', '1505872443268');
INSERT INTO `agency_active_rate` VALUES ('550', '8', '1', '33', '0', '184066643', '1505872443268');
INSERT INTO `agency_active_rate` VALUES ('551', '9', '1', '33', '0', '2369412', '1505872443268');
INSERT INTO `agency_active_rate` VALUES ('552', '10', '1', '33', '0', 'hy123', '1505872443268');
INSERT INTO `agency_active_rate` VALUES ('553', '11', '1', '33', '0', 'zishu', '1505872443268');
INSERT INTO `agency_active_rate` VALUES ('554', '12', '1', '33', '0', 'tianjing', '1505872443268');
INSERT INTO `agency_active_rate` VALUES ('555', '13', '1', '33', '0', 'zqy95178250', '1505872445151');
INSERT INTO `agency_active_rate` VALUES ('556', '14', '1', '33', '0', 'QQ574912927', '1505872445151');
INSERT INTO `agency_active_rate` VALUES ('557', '15', '1', '33', '0', '1579599827', '1505872445151');
INSERT INTO `agency_active_rate` VALUES ('558', '17', '1', '33', '0', '789', '1505872445151');
INSERT INTO `agency_active_rate` VALUES ('559', '18', '1', '33', '0', '112', '1505872445151');
INSERT INTO `agency_active_rate` VALUES ('560', '20', '1', '33', '0', 'b2218776', '1505872445151');
INSERT INTO `agency_active_rate` VALUES ('561', '21', '1', '33', '0', '13771547176', '1505872445151');
INSERT INTO `agency_active_rate` VALUES ('562', '22', '1', '33', '0', '1', '1505872445151');
INSERT INTO `agency_active_rate` VALUES ('563', '23', '1', '33', '0', '小aq', '1505872445151');
INSERT INTO `agency_active_rate` VALUES ('564', '24', '1', '33', '0', '15914897978', '1505872445151');
INSERT INTO `agency_active_rate` VALUES ('565', '25', '1', '33', '0', 'oushinanshen', '1505872447329');
INSERT INTO `agency_active_rate` VALUES ('566', '26', '1', '33', '0', 'wxx899999', '1505872447329');
INSERT INTO `agency_active_rate` VALUES ('567', '27', '1', '33', '0', '1464975293', '1505872447329');
INSERT INTO `agency_active_rate` VALUES ('568', '28', '1', '33', '0', 'Bear', '1505872447329');
INSERT INTO `agency_active_rate` VALUES ('569', '29', '1', '33', '0', 'zxx', '1505872447329');
INSERT INTO `agency_active_rate` VALUES ('570', '30', '1', '33', '0', 'hy123456', '1505872447329');
INSERT INTO `agency_active_rate` VALUES ('571', '31', '1', '33', '0', 'wl123', '1505872447329');
INSERT INTO `agency_active_rate` VALUES ('572', '32', '1', '33', '0', '鳯儿网店', '1505872447329');
INSERT INTO `agency_active_rate` VALUES ('573', '33', '1', '33', '0', 'ruiruima', '1505872447329');
INSERT INTO `agency_active_rate` VALUES ('574', '34', '1', '33', '0', '944581678', '1505872447329');
INSERT INTO `agency_active_rate` VALUES ('575', '35', '1', '33', '0', '2069959168', '1505872450229');
INSERT INTO `agency_active_rate` VALUES ('576', '36', '1', '33', '0', '570156062', '1505872450229');
INSERT INTO `agency_active_rate` VALUES ('577', '37', '1', '33', '0', '770733914', '1505872450229');
INSERT INTO `agency_active_rate` VALUES ('578', '38', '1', '33', '0', '5257', '1505872450229');
INSERT INTO `agency_active_rate` VALUES ('579', '39', '1', '33', '0', '18734158108', '1505872450229');
INSERT INTO `agency_active_rate` VALUES ('580', '40', '1', '33', '0', 'xhq1347574865', '1505872450229');
INSERT INTO `agency_active_rate` VALUES ('581', '41', '1', '33', '0', 'Chen', '1505872450229');
INSERT INTO `agency_active_rate` VALUES ('582', '42', '1', '33', '0', 'qq130496', '1505872450229');
INSERT INTO `agency_active_rate` VALUES ('583', '43', '1', '33', '0', 'kevinchow', '1505872450229');
INSERT INTO `agency_active_rate` VALUES ('584', '44', '1', '33', '0', '17346544413', '1505872450229');
INSERT INTO `agency_active_rate` VALUES ('585', '45', '1', '33', '0', '2480199685', '1505872451817');
INSERT INTO `agency_active_rate` VALUES ('586', '46', '1', '33', '0', 'jim145', '1505872451817');
INSERT INTO `agency_active_rate` VALUES ('587', '47', '1', '33', '0', 'bada', '1505872451817');
INSERT INTO `agency_active_rate` VALUES ('588', '48', '1', '33', '0', '罗大大', '1505872451817');
INSERT INTO `agency_active_rate` VALUES ('589', '49', '1', '33', '0', '109', '1505872451817');
INSERT INTO `agency_active_rate` VALUES ('590', '50', '1', '33', '0', '119', '1505872451817');
INSERT INTO `agency_active_rate` VALUES ('591', '51', '1', '33', '0', 'gigi77', '1505872451817');
INSERT INTO `agency_active_rate` VALUES ('592', '52', '1', '33', '0', 'gigi777', '1505872451817');
INSERT INTO `agency_active_rate` VALUES ('593', '2', '1', '34', '0', '123', '1505872472331');
INSERT INTO `agency_active_rate` VALUES ('594', '4', '1', '34', '0', 'wzkj', '1505872472331');
INSERT INTO `agency_active_rate` VALUES ('595', '5', '1', '34', '0', '冰河', '1505872472331');
INSERT INTO `agency_active_rate` VALUES ('596', '6', '1', '34', '0', 'jiafeng', '1505872472331');
INSERT INTO `agency_active_rate` VALUES ('597', '7', '1', '34', '0', 'l474705958', '1505872472331');
INSERT INTO `agency_active_rate` VALUES ('598', '8', '1', '34', '0', '184066643', '1505872472331');
INSERT INTO `agency_active_rate` VALUES ('599', '9', '1', '34', '0', '2369412', '1505872472331');
INSERT INTO `agency_active_rate` VALUES ('600', '10', '1', '34', '0', 'hy123', '1505872472331');
INSERT INTO `agency_active_rate` VALUES ('601', '11', '1', '34', '0', 'zishu', '1505872472331');
INSERT INTO `agency_active_rate` VALUES ('602', '12', '1', '34', '0', 'tianjing', '1505872472331');
INSERT INTO `agency_active_rate` VALUES ('603', '13', '1', '34', '0', 'zqy95178250', '1505872474379');
INSERT INTO `agency_active_rate` VALUES ('604', '14', '1', '34', '0', 'QQ574912927', '1505872474379');
INSERT INTO `agency_active_rate` VALUES ('605', '15', '1', '34', '0', '1579599827', '1505872474379');
INSERT INTO `agency_active_rate` VALUES ('606', '17', '1', '34', '0', '789', '1505872474379');
INSERT INTO `agency_active_rate` VALUES ('607', '18', '1', '34', '0', '112', '1505872474379');
INSERT INTO `agency_active_rate` VALUES ('608', '20', '1', '34', '0', 'b2218776', '1505872474379');
INSERT INTO `agency_active_rate` VALUES ('609', '21', '1', '34', '0', '13771547176', '1505872474379');
INSERT INTO `agency_active_rate` VALUES ('610', '22', '1', '34', '0', '1', '1505872474379');
INSERT INTO `agency_active_rate` VALUES ('611', '23', '1', '34', '0', '小aq', '1505872474379');
INSERT INTO `agency_active_rate` VALUES ('612', '24', '1', '34', '0', '15914897978', '1505872474379');
INSERT INTO `agency_active_rate` VALUES ('613', '25', '1', '34', '0', 'oushinanshen', '1505872476071');
INSERT INTO `agency_active_rate` VALUES ('614', '26', '1', '34', '0', 'wxx899999', '1505872476071');
INSERT INTO `agency_active_rate` VALUES ('615', '27', '1', '34', '0', '1464975293', '1505872476071');
INSERT INTO `agency_active_rate` VALUES ('616', '28', '1', '34', '0', 'Bear', '1505872476071');
INSERT INTO `agency_active_rate` VALUES ('617', '29', '1', '34', '0', 'zxx', '1505872476071');
INSERT INTO `agency_active_rate` VALUES ('618', '30', '1', '34', '0', 'hy123456', '1505872476071');
INSERT INTO `agency_active_rate` VALUES ('619', '31', '1', '34', '0', 'wl123', '1505872476071');
INSERT INTO `agency_active_rate` VALUES ('620', '32', '1', '34', '0', '鳯儿网店', '1505872476071');
INSERT INTO `agency_active_rate` VALUES ('621', '33', '1', '34', '0', 'ruiruima', '1505872476071');
INSERT INTO `agency_active_rate` VALUES ('622', '34', '1', '34', '0', '944581678', '1505872476071');
INSERT INTO `agency_active_rate` VALUES ('623', '35', '1', '34', '0', '2069959168', '1505872477743');
INSERT INTO `agency_active_rate` VALUES ('624', '36', '1', '34', '0', '570156062', '1505872477743');
INSERT INTO `agency_active_rate` VALUES ('625', '37', '1', '34', '0', '770733914', '1505872477743');
INSERT INTO `agency_active_rate` VALUES ('626', '38', '1', '34', '0', '5257', '1505872477743');
INSERT INTO `agency_active_rate` VALUES ('627', '39', '1', '34', '0', '18734158108', '1505872477743');
INSERT INTO `agency_active_rate` VALUES ('628', '40', '1', '34', '0', 'xhq1347574865', '1505872477743');
INSERT INTO `agency_active_rate` VALUES ('629', '41', '1', '34', '0', 'Chen', '1505872477743');
INSERT INTO `agency_active_rate` VALUES ('630', '42', '1', '34', '0', 'qq130496', '1505872477743');
INSERT INTO `agency_active_rate` VALUES ('631', '43', '1', '34', '0', 'kevinchow', '1505872477743');
INSERT INTO `agency_active_rate` VALUES ('632', '44', '1', '34', '0', '17346544413', '1505872477743');
INSERT INTO `agency_active_rate` VALUES ('633', '45', '1', '34', '0', '2480199685', '1505872479415');
INSERT INTO `agency_active_rate` VALUES ('634', '46', '1', '34', '0', 'jim145', '1505872479415');
INSERT INTO `agency_active_rate` VALUES ('635', '47', '1', '34', '0', 'bada', '1505872479415');
INSERT INTO `agency_active_rate` VALUES ('636', '48', '1', '34', '0', '罗大大', '1505872479415');
INSERT INTO `agency_active_rate` VALUES ('637', '49', '1', '34', '0', '109', '1505872479415');
INSERT INTO `agency_active_rate` VALUES ('638', '50', '1', '34', '0', '119', '1505872479415');
INSERT INTO `agency_active_rate` VALUES ('639', '51', '1', '34', '0', 'gigi77', '1505872479415');
INSERT INTO `agency_active_rate` VALUES ('640', '52', '1', '34', '0', 'gigi777', '1505872479415');
INSERT INTO `agency_active_rate` VALUES ('641', '53', '1', '27', '0', '111111', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('642', '54', '1', '27', '0', 'dada', '1505881517832');
INSERT INTO `agency_active_rate` VALUES ('643', '53', '1', '29', '0', '111111', '1505881078455');
INSERT INTO `agency_active_rate` VALUES ('644', '54', '1', '29', '0', 'dada', '1505881078455');
INSERT INTO `agency_active_rate` VALUES ('645', '53', '1', '30', '0', '111111', '1505881100716');
INSERT INTO `agency_active_rate` VALUES ('646', '54', '1', '30', '0', 'dada', '1505881100716');
INSERT INTO `agency_active_rate` VALUES ('647', '53', '1', '31', '0', '111111', '1505881123262');
INSERT INTO `agency_active_rate` VALUES ('648', '54', '1', '31', '0', 'dada', '1505881123262');
INSERT INTO `agency_active_rate` VALUES ('649', '53', '1', '32', '0', '111111', '1505881133248');
INSERT INTO `agency_active_rate` VALUES ('650', '54', '1', '32', '0', 'dada', '1505881133248');
INSERT INTO `agency_active_rate` VALUES ('651', '53', '1', '33', '0', '111111', '1505881142785');
INSERT INTO `agency_active_rate` VALUES ('652', '54', '1', '33', '0', 'dada', '1505881142785');
INSERT INTO `agency_active_rate` VALUES ('653', '53', '1', '34', '0', '111111', '1505881151422');
INSERT INTO `agency_active_rate` VALUES ('654', '54', '1', '34', '0', 'dada', '1505881151422');
INSERT INTO `agency_active_rate` VALUES ('655', '53', '1', '28', '0', '111111', '1505881171059');
INSERT INTO `agency_active_rate` VALUES ('656', '54', '1', '28', '0', 'dada', '1505881171059');
INSERT INTO `agency_active_rate` VALUES ('657', '53', '1', '24', '0', '111111', '1505881181635');
INSERT INTO `agency_active_rate` VALUES ('658', '54', '1', '24', '0', 'dada', '1505881181635');
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
INSERT INTO `agency_active_rate` VALUES ('671', '53', '1', '22', '0', '111111', '1505881247065');
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
INSERT INTO `agency_active_rate` VALUES ('720', '53', '1', '36', '0', '111111', '1505883071220');
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
INSERT INTO `agency_active_rate` VALUES ('770', '53', '1', '37', '0', '111111', '1505891013113');
INSERT INTO `agency_active_rate` VALUES ('771', '54', '1', '37', '0', 'dada', '1505891013113');
INSERT INTO `agency_active_rate` VALUES ('772', '55', '1', '37', '0', '源肥呀', '1505891013113');

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
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of agency_backward
-- ----------------------------
INSERT INTO `agency_backward` VALUES ('1', '0', 'xiao', 'xiao', 'xiaoqiang', '', '3004569972', '', '', null, '1505742388331', 'XXM4', null, '1', null);
INSERT INTO `agency_backward` VALUES ('2', '1', '123', '123', '123', '123', '1727661035', '1727661035@qq.com', '江西省永丰', null, '1505095878921', 'W6C2', null, '1', null);
INSERT INTO `agency_backward` VALUES ('3', '2', '456', '456', '123', '123', '123', '123@456', '123', null, '1505099730745', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('4', '1', 'wzkj', 'wzkj', '何兵', '17707005023', '820267814', '820267814@qq.com', '江西省南昌市高新区', null, '1505389590642', 'MMTX', null, '0', null);
INSERT INTO `agency_backward` VALUES ('5', '1', '冰河', '', '李冰超', '15009525347', '325588827', '35588827@qq.com', '宁夏石嘴山市惠农区', null, '1505397230874', '', null, '0', null);
INSERT INTO `agency_backward` VALUES ('6', '1', 'jiafeng', 'jiafeng868', 'jf', '13603997958', '37956093', '37956093@qq.com', '河南郑州', null, '1505402408521', '8XXL', null, '0', null);
INSERT INTO `agency_backward` VALUES ('7', '1', 'l474705958', 'ads321321001', '李晨', '17629105551', '474705958', '474705958@qq.com', '陕西', null, '1505451449663', 'DSL7', null, '0', null);
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
INSERT INTO `agency_backward` VALUES ('26', '1', 'wxx899999', 'wxx123456.', '卫鑫星', '13679296790', '1483710008', '1483710008@qq.com', '', null, '1505722102442', '', null, '0', null);
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
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of agency_purchase
-- ----------------------------
INSERT INTO `agency_purchase` VALUES ('29', '2', '734955636709658624', '19', '2.01', '0', '0', '2.01', '123', '1', '手动成功');
INSERT INTO `agency_purchase` VALUES ('30', '1', '734955636709658624', '19', '1.995', '0', '2', '2.01', '123', '1', '手动成功');
INSERT INTO `agency_purchase` VALUES ('31', '2', '734968246582644736', '19', '2.01', '0', '0', '2.01', '123', '1', '手动成功');
INSERT INTO `agency_purchase` VALUES ('32', '1', '734968246582644736', '19', '1.995', '0', '2', '2.01', '123', '1', '手动成功');
INSERT INTO `agency_purchase` VALUES ('33', '1', '734991771976601600', null, '2.85', '0', '0', '2.85', 'xiao', '0', '手动失败');
INSERT INTO `agency_purchase` VALUES ('34', '1', '734992684296441856', null, '2.85', '0', '0', '2.85', 'xiao', '1', '手动成功');
INSERT INTO `agency_purchase` VALUES ('35', '2', '735263809198886912', '21', '1.74', '0', '0', '1.74', '123', '1', '手动成功');
INSERT INTO `agency_purchase` VALUES ('36', '1', '735263809198886912', '21', '1.71', '0', '2', '1.74', '123', '1', '手动成功');
INSERT INTO `agency_purchase` VALUES ('37', '2', '735556856507797504', '21', '1.74', '0', '0', '1.74', '123', '0', '');
INSERT INTO `agency_purchase` VALUES ('38', '1', '735556856507797504', '21', '1.71', '0', '2', '1.74', '123', '0', '');
INSERT INTO `agency_purchase` VALUES ('39', '1', '735565336828448768', '15', '1.71', '0', '0', '1.71', 'xiao', '1', '欠费等待');
INSERT INTO `agency_purchase` VALUES ('40', '1', '735637674362146816', '25', '0.99', '0', '0', '0.99', 'xiao', '1', '欠费等待');
INSERT INTO `agency_purchase` VALUES ('41', '1', '735643477341114368', '25', '0.99', '0', '0', '0.99', 'xiao', '0', '产品未配置');
INSERT INTO `agency_purchase` VALUES ('42', '10', '735691086504136704', '25', '92.4', '0', '0', '92.4', 'hy123', '1', null);
INSERT INTO `agency_purchase` VALUES ('43', '1', '735691086504136704', '25', '92.4', '0', '2', '92.4', 'hy123', '1', '');
INSERT INTO `agency_purchase` VALUES ('44', '31', '735696617457324032', '25', '92.4', '0', '0', '92.4', 'wl123', '1', null);
INSERT INTO `agency_purchase` VALUES ('45', '1', '735696617457324032', '25', '92.4', '0', '2', '92.4', 'wl123', '1', '');
INSERT INTO `agency_purchase` VALUES ('46', '31', '735696780196319232', '25', '92.4', '0', '0', '92.4', 'wl123', '1', null);
INSERT INTO `agency_purchase` VALUES ('47', '1', '735696780196319232', '25', '92.4', '0', '2', '92.4', 'wl123', '1', '');
INSERT INTO `agency_purchase` VALUES ('48', '31', '735701276200800256', '25', '92.4', '0', '0', '92.4', 'wl123', '0', null);
INSERT INTO `agency_purchase` VALUES ('49', '1', '735701276200800256', '25', '92.4', '0', '2', '92.4', 'wl123', '0', '');
INSERT INTO `agency_purchase` VALUES ('50', '38', '735918403251867648', '25', '0.99', '0', '0', '0.99', '5257', '0', '产品未配置');
INSERT INTO `agency_purchase` VALUES ('51', '1', '735918403251867648', '25', '0.99', '0', '2', '0.99', '5257', '0', '产品未配置');
INSERT INTO `agency_purchase` VALUES ('52', '38', '736056020098355200', '25', '0.99', '0', '0', '0.99', '5257', '0', '产品未配置');
INSERT INTO `agency_purchase` VALUES ('53', '1', '736056020098355200', '25', '0.99', '0', '2', '0.99', '5257', '0', '产品未配置');
INSERT INTO `agency_purchase` VALUES ('54', '38', '736063456880365568', '25', '9.9', '0', '0', '9.9', '5257', '0', '手动失败');
INSERT INTO `agency_purchase` VALUES ('55', '1', '736063456880365568', '25', '9.9', '0', '2', '9.9', '5257', '0', '手动失败');
INSERT INTO `agency_purchase` VALUES ('56', '2', '736283369150615552', '27', '9.9', '0', '0', '9.9', '123', '0', null);
INSERT INTO `agency_purchase` VALUES ('57', '1', '736283369150615552', '27', '9.9', '0', '2', '9.9', '123', '0', '');
INSERT INTO `agency_purchase` VALUES ('58', '53', '736322784392646656', '27', '23.1', '0', '0', '23.1', '111111', '0', '失败');
INSERT INTO `agency_purchase` VALUES ('59', '1', '736322784392646656', '27', '23.1', '0', '2', '23.1', '111111', '0', '失败');
INSERT INTO `agency_purchase` VALUES ('60', '53', '736326301064892416', '27', '21.7', '0', '0', '21.7', '111111', '1', null);
INSERT INTO `agency_purchase` VALUES ('61', '1', '736326301064892416', '27', '23.1', '0', '2', '21.7', '111111', '1', '');

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
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of channel_channel
-- ----------------------------
INSERT INTO `channel_channel` VALUES ('22', '微族 浙江移动', '10& 30& 70& 100& 150& 300& 500& 1024& 2048& 3072& 4096& 6144& 11264', '32', null, null, null, null, '0', '0', null, '1');
INSERT INTO `channel_channel` VALUES ('26', '微族-湖南移动', '10& 30& 70& 100& 150& 300& 500& 1024& 2048& 3072& 4096& 6144& 11264', '32', null, null, null, null, '0', '0', null, '1');
INSERT INTO `channel_channel` VALUES ('27', '微族-河南移动', '10& 30& 70& 100& 150& 300& 500& 1024& 2048& 3072& 4096& 6144& 11264', '32', null, null, null, null, '0', '0', null, '1');
INSERT INTO `channel_channel` VALUES ('30', '微族-宁夏本地', '10& 30& 70& 150& 500& 1024& 2048& 3072& 4096& 6144& 11264', '32', null, null, null, null, '0', '0', '1505784729788', '1');
INSERT INTO `channel_channel` VALUES ('33', '微族-陕西省内移动', '500& 1024& 2048& 3072& 4096& 6144& 11264& 100& 300', '32', null, null, null, null, '0', '0', null, '1');
INSERT INTO `channel_channel` VALUES ('42', '微族-山东移动', '10& 30& 70& 100& 150& 300& 500& 1024& 2048& 4096& 3072& 6144& 11264', '32', null, null, null, null, '0', '0', null, '1');
INSERT INTO `channel_channel` VALUES ('43', '微族-浙江移动', '10& 30& 70& 100& 150& 300& 500& 1024& 2048& 3072& 4096& 6144& 11264', '32', null, null, null, null, '0', '0', null, '1');
INSERT INTO `channel_channel` VALUES ('44', '微族-安徽移动', '10& 30& 70& 100& 150& 300& 500& 1024& 2048& 3072& 4096& 6144& 11264', '32', null, null, null, null, '0', '0', null, '1');
INSERT INTO `channel_channel` VALUES ('45', '微族-山西移动', '10& 30& 70& 100& 150& 300& 500& 1024& 2048& 3072& 4096& 6144& 11264', '32', null, null, null, null, '0', '0', null, '1');
INSERT INTO `channel_channel` VALUES ('46', '微族-陕西移动', '10& 30& 70& 100& 150& 300& 500& 1024& 2048& 3072& 4096& 6144& 11264', '32', null, null, null, null, '0', '0', null, '1');
INSERT INTO `channel_channel` VALUES ('47', '微族-黑龙江移动', '10& 30& 70& 100& 150& 300& 500& 1024& 2048& 3072& 4096& 6144& 11264', '32', null, null, null, null, '0', '0', null, '1');
INSERT INTO `channel_channel` VALUES ('48', '微族-广东特殊包', '300', '32', null, null, null, null, '0', '1', '1505883077674', '1');
INSERT INTO `channel_channel` VALUES ('49', '微族-内蒙古移动', '10& 30& 70& 100& 150& 300& 500& 1024& 2048& 3072& 4096& 6144& 11264', '32', null, null, null, null, '0', '1', '1505890993347', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of channel_discount
-- ----------------------------
INSERT INTO `channel_discount` VALUES ('19', '22', '11', '0.46', '省漫游-微族 浙江移动', '0', '0', '2', '0');
INSERT INTO `channel_discount` VALUES ('23', '26', '18', '0.79', '省漫游-微族-湖南移动', '0', '0', '2', '0');
INSERT INTO `channel_discount` VALUES ('24', '27', '12', '0.79', '省漫游-微族-河南移动', '0', '0', '2', '0');
INSERT INTO `channel_discount` VALUES ('27', '30', '29', '0.47', '省内-微族-宁夏本地', '0', '0', '1', '0');
INSERT INTO `channel_discount` VALUES ('30', '33', '26', '0.33', '省内-微族-陕西省内移动', '0', '0', '1', '0');
INSERT INTO `channel_discount` VALUES ('39', '42', '15', '0.62', '省漫游-微族-山东移动', '0', '0', '2', '0');
INSERT INTO `channel_discount` VALUES ('40', '43', '11', '0.46', '省漫游-微族-浙江移动', '0', '0', '2', '0');
INSERT INTO `channel_discount` VALUES ('41', '44', '12', '0.46', '省漫游-微族-安徽移动', '0', '0', '2', '0');
INSERT INTO `channel_discount` VALUES ('42', '45', '04', '0.47', '省漫游-微族-山西移动', '0', '0', '2', '0');
INSERT INTO `channel_discount` VALUES ('43', '46', '26', '0.72', '省漫游-微族-陕西移动', '0', '0', '2', '0');
INSERT INTO `channel_discount` VALUES ('44', '47', '08', '0.76', '省漫游-微族-黑龙江移动', '0', '0', '2', '0');
INSERT INTO `channel_discount` VALUES ('45', '48', '19', '0.7', '省漫游-微族-广东特殊包', '0', '0', '2', '0');
INSERT INTO `channel_discount` VALUES ('46', '49', '05', '0.62', '省漫游-微族-内蒙古移动', '0', '0', '2', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of charge_account
-- ----------------------------
INSERT INTO `charge_account` VALUES ('1', '-99118.175', null, null, '0', '1', '0', null, '1495689716779', null);
INSERT INTO `charge_account` VALUES ('2', '90.76', '中国银行', '123', '0', '2', '0', null, '1505095878921', '123');
INSERT INTO `charge_account` VALUES ('3', '0', null, null, '0', '3', '0', null, '1505099730745', '456');
INSERT INTO `charge_account` VALUES ('4', '0', null, null, '0', '4', '0', null, '1505389590642', 'wzkj');
INSERT INTO `charge_account` VALUES ('5', '0', null, null, '0', '5', '0', null, '1505397230874', '冰河');
INSERT INTO `charge_account` VALUES ('6', '0', '121212', '121212', '0', '6', '0', null, '1505402408521', 'jiafeng');
INSERT INTO `charge_account` VALUES ('7', '0', null, null, '0', '7', '0', null, '1505451449663', 'l474705958');
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
INSERT INTO `charge_account` VALUES ('26', '0', null, null, '0', '26', '0', null, '1505722102442', 'wxx899999');
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
INSERT INTO `charge_account` VALUES ('39', '10', null, null, '0', '38', '0', null, '1505743826259', '5257');
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
INSERT INTO `charge_account` VALUES ('54', '0', null, null, '0', '2', '1', null, '1505874476912', '123');
INSERT INTO `charge_account` VALUES ('55', '8.3', null, null, '0', '53', '0', null, '1505880444101', '111111');
INSERT INTO `charge_account` VALUES ('56', '0', null, null, '0', '54', '0', null, '1505880504457', 'dada');
INSERT INTO `charge_account` VALUES ('57', '0', null, null, '0', '55', '0', null, '1505883026363', '源肥呀');

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
  PRIMARY KEY (`id`),
  KEY `fk_cr_agency` (`agency_id`),
  CONSTRAINT `fk_cr_agency` FOREIGN KEY (`agency_id`) REFERENCES `agency_backward` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of charge_record
-- ----------------------------
INSERT INTO `charge_record` VALUES ('1', '1505110515253', '3000', '-96093.26', '-99093.26', '0', '1', '1', '1', '1', null);
INSERT INTO `charge_record` VALUES ('2', '1505110515267', '3000', '0', '3000', '0', '0', '2', '2', '1', null);
INSERT INTO `charge_record` VALUES ('3', '1505120440644', '242.2', '3000', '2757.8', '0', '1', '2', '2', '1', '733132175595016192');
INSERT INTO `charge_record` VALUES ('4', '1505120440694', '238', '-98851.06', '-99089.06', '0', '1', '1', '1', '1', '733132175595016192');
INSERT INTO `charge_record` VALUES ('5', '1505459685489', '1.71', '2757.8', '2756.09', '0', '1', '2', '2', '1', '734555071601184768');
INSERT INTO `charge_record` VALUES ('6', '1505459685505', '1.68', '-99087.35', '-99089.03', '0', '1', '1', '1', '1', '734555071601184768');
INSERT INTO `charge_record` VALUES ('7', '1505459760710', '1.71', '2756.09', '2754.38', '0', '1', '2', '2', '1', '734555387096731648');
INSERT INTO `charge_record` VALUES ('8', '1505459760721', '1.68', '-99087.32', '-99089', '0', '1', '1', '1', '1', '734555387096731648');
INSERT INTO `charge_record` VALUES ('9', '1505459760000', '1.71', '2754.38', '2756.09', '0', '2', '2', '2', '1', '734555387096731648');
INSERT INTO `charge_record` VALUES ('10', '1505459760000', '1.68', '-99089', '-99087.32', '0', '2', '1', '1', '1', '734555387096731648');
INSERT INTO `charge_record` VALUES ('11', '1505459930561', '1.71', '2756.09', '2754.38', '0', '1', '2', '2', '1', '734556099503460352');
INSERT INTO `charge_record` VALUES ('12', '1505459930580', '1.68', '-99085.61', '-99087.29', '0', '1', '1', '1', '1', '734556099503460352');
INSERT INTO `charge_record` VALUES ('13', '1505460179011', '1.71', '2754.38', '2752.67', '0', '1', '2', '2', '1', '734557141578289152');
INSERT INTO `charge_record` VALUES ('14', '1505460179027', '1.68', '-99085.58', '-99087.26', '0', '1', '1', '1', '1', '734557141578289152');
INSERT INTO `charge_record` VALUES ('15', '1505460179088', '1.71', '2754.38', '2752.67', '0', '1', '2', '2', '1', '734557141901250560');
INSERT INTO `charge_record` VALUES ('16', '1505460179242', '1.68', '-99085.58', '-99087.26', '0', '1', '1', '1', '1', '734557141901250560');
INSERT INTO `charge_record` VALUES ('17', '1505460259655', '1.71', '2752.67', '2750.96', '0', '1', '2', '2', '1', '734557479823740928');
INSERT INTO `charge_record` VALUES ('18', '1505460259678', '1.68', '-99085.55', '-99087.23', '0', '1', '1', '1', '1', '734557479823740928');
INSERT INTO `charge_record` VALUES ('19', '1505460269962', '1.71', '2750.96', '2749.25', '0', '1', '2', '2', '1', '734557523054432256');
INSERT INTO `charge_record` VALUES ('20', '1505460269976', '1.68', '-99085.52', '-99087.2', '0', '1', '1', '1', '1', '734557523054432256');
INSERT INTO `charge_record` VALUES ('21', '1505460270000', '1.71', '2749.25', '2750.96', '0', '2', '2', '2', '1', '734557523054432256');
INSERT INTO `charge_record` VALUES ('22', '1505460270000', '1.68', '-99087.2', '-99085.52', '0', '2', '1', '1', '1', '734557523054432256');
INSERT INTO `charge_record` VALUES ('23', '1505460259000', '1.71', '2750.96', '2752.67', '0', '2', '2', '2', '1', '734557479823740928');
INSERT INTO `charge_record` VALUES ('24', '1505460259000', '1.68', '-99085.52', '-99083.84', '0', '2', '1', '1', '1', '734557479823740928');
INSERT INTO `charge_record` VALUES ('25', '1505460179000', '1.71', '2752.67', '2754.38', '0', '2', '2', '2', '1', '734557141901250560');
INSERT INTO `charge_record` VALUES ('26', '1505460179000', '1.68', '-99083.84', '-99082.16', '0', '2', '1', '1', '1', '734557141901250560');
INSERT INTO `charge_record` VALUES ('27', '1505460179000', '1.71', '2754.38', '2756.09', '0', '2', '2', '2', '1', '734557141578289152');
INSERT INTO `charge_record` VALUES ('28', '1505460179000', '1.68', '-99082.16', '-99080.48', '0', '2', '1', '1', '1', '734557141578289152');
INSERT INTO `charge_record` VALUES ('29', '1505464964624', '1.68', '-99080.48', '-99082.16', '0', '1', '1', '1', '1', '734577213864677376');
INSERT INTO `charge_record` VALUES ('30', '1505465141946', '1.68', '-99082.16', '-99083.84', '0', '1', '1', '1', '1', '734577957615439872');
INSERT INTO `charge_record` VALUES ('31', '1505465339220', '1.68', '-99083.84', '-99085.52', '0', '1', '1', '1', '1', '734578785042567168');
INSERT INTO `charge_record` VALUES ('32', '1505465383564', '1.74', '2756.09', '2754.35', '0', '1', '2', '2', '1', '734578971055755264');
INSERT INTO `charge_record` VALUES ('33', '1505465383579', '1.68', '-99083.78', '-99085.46', '0', '1', '1', '1', '1', '734578971055755264');
INSERT INTO `charge_record` VALUES ('34', '1505466918070', '1.74', '2754.35', '2752.61', '0', '1', '2', '2', '1', '734585407244603392');
INSERT INTO `charge_record` VALUES ('35', '1505466918597', '1.68', '-99083.72', '-99085.4', '0', '1', '1', '1', '1', '734585407244603392');
INSERT INTO `charge_record` VALUES ('36', '1505547039855', '1.995', '-99085.4', '-99087.395', '0', '1', '1', '1', '1', '734921441190875136');
INSERT INTO `charge_record` VALUES ('37', '1505547647717', '1.74', '0', '-1.74', '0', '1', '2', '2', '1', '734924011921739776');
INSERT INTO `charge_record` VALUES ('38', '1505547647735', '1.695', '-99085.655', '-99087.35', '0', '1', '1', '1', '1', '734924011921739776');
INSERT INTO `charge_record` VALUES ('39', '1505547792811', '1.74', '-1.74', '-3.48', '0', '1', '2', '2', '1', '734924620490084352');
INSERT INTO `charge_record` VALUES ('40', '1505547792823', '1.695', '-99085.61', '-99087.305', '0', '1', '1', '1', '1', '734924620490084352');
INSERT INTO `charge_record` VALUES ('41', '1505555187652', '2.01', '-3.48', '-5.49', '0', '1', '2', '2', '1', '734955636709658624');
INSERT INTO `charge_record` VALUES ('42', '1505555188174', '1.995', '-99085.295', '-99087.29', '0', '1', '1', '1', '1', '734955636709658624');
INSERT INTO `charge_record` VALUES ('43', '1505558194080', '2.01', '-5.49', '-7.5', '0', '1', '2', '2', '1', '734968246582644736');
INSERT INTO `charge_record` VALUES ('44', '1505558194117', '1.995', '-99085.28', '-99087.275', '0', '1', '1', '1', '1', '734968246582644736');
INSERT INTO `charge_record` VALUES ('45', '1505563802978', '2.85', '-99087.275', '-99090.125', '0', '1', '1', '1', '1', '734991771976601600');
INSERT INTO `charge_record` VALUES ('46', '1505564020492', '2.85', '-99090.125', '-99092.975', '0', '1', '1', '1', '1', '734992684296441856');
INSERT INTO `charge_record` VALUES ('47', '1505564437679', '2.85', '-99092.975', '-99090.125', '0', '2', '1', '1', '1', '734991771976601600');
INSERT INTO `charge_record` VALUES ('48', '1505628661701', '1.74', '-7.5', '-9.24', '0', '1', '2', '2', '1', '735263809198886912');
INSERT INTO `charge_record` VALUES ('49', '1505628661715', '1.71', '-99088.385', '-99090.095', '0', '1', '1', '1', '1', '735263809198886912');
INSERT INTO `charge_record` VALUES ('50', '1505698529623', '1.74', '-9.24', '-10.98', '0', '1', '2', '2', '1', '735556856507797504');
INSERT INTO `charge_record` VALUES ('51', '1505698530177', '1.71', '-99088.355', '-99090.065', '0', '1', '1', '1', '1', '735556856507797504');
INSERT INTO `charge_record` VALUES ('52', '1505698531000', '1.74', '-10.98', '-9.24', '0', '2', '2', '2', '1', '735556856507797504');
INSERT INTO `charge_record` VALUES ('53', '1505698531000', '1.71', '-99090.065', '-99088.355', '0', '2', '1', '1', '1', '735556856507797504');
INSERT INTO `charge_record` VALUES ('54', '1505700592385', '1.71', '-99088.355', '-99090.065', '0', '1', '1', '1', '1', '735565336828448768');
INSERT INTO `charge_record` VALUES ('55', '1505715363877', '23', '-99090.065', '-99113.065', '0', '1', '1', '1', '1', null);
INSERT INTO `charge_record` VALUES ('56', '1505715363887', '23', '0', '23', '0', '0', '10', '10', '1', null);
INSERT INTO `charge_record` VALUES ('57', '1505717798109', '0.99', '-99113.065', '-99114.055', '0', '1', '1', '1', '1', '735637674362146816');
INSERT INTO `charge_record` VALUES ('58', '1505719186588', '0.99', '-99114.055', '-99115.045', '0', '1', '1', '1', '1', '735643477341114368');
INSERT INTO `charge_record` VALUES ('59', '1505719189000', '0.99', '-99115.045', '-99114.055', '0', '2', '1', '1', '1', '735643477341114368');
INSERT INTO `charge_record` VALUES ('60', '1505730532546', '92.4', '23', '-69.4', '0', '1', '10', '10', '1', '735691086504136704');
INSERT INTO `charge_record` VALUES ('61', '1505730532607', '92.4', '-99021.655', '-99114.055', '0', '1', '1', '1', '1', '735691086504136704');
INSERT INTO `charge_record` VALUES ('62', '1505731851229', '92.4', '0', '-92.4', '0', '1', '32', '31', '1', '735696617457324032');
INSERT INTO `charge_record` VALUES ('63', '1505731851245', '92.4', '-99021.655', '-99114.055', '0', '1', '1', '1', '1', '735696617457324032');
INSERT INTO `charge_record` VALUES ('64', '1505731890031', '92.4', '-92.4', '-184.8', '0', '1', '32', '31', '1', '735696780196319232');
INSERT INTO `charge_record` VALUES ('65', '1505731890045', '92.4', '-99021.655', '-99114.055', '0', '1', '1', '1', '1', '735696780196319232');
INSERT INTO `charge_record` VALUES ('66', '1505732961962', '92.4', '-184.8', '-277.2', '0', '1', '32', '31', '1', '735701276200800256');
INSERT INTO `charge_record` VALUES ('67', '1505732961986', '92.4', '-99021.655', '-99114.055', '0', '1', '1', '1', '1', '735701276200800256');
INSERT INTO `charge_record` VALUES ('68', '1505732962000', '92.4', '-277.2', '-184.8', '0', '2', '32', '31', '1', '735701276200800256');
INSERT INTO `charge_record` VALUES ('69', '1505732962000', '92.4', '-99114.055', '-99021.655', '0', '2', '1', '1', '1', '735701276200800256');
INSERT INTO `charge_record` VALUES ('70', '1505784609680', '10', '-99021.655', '-99031.655', '0', '1', '1', '1', '1', null);
INSERT INTO `charge_record` VALUES ('71', '1505784609685', '10', '0', '10', '0', '0', '39', '38', '1', null);
INSERT INTO `charge_record` VALUES ('72', '1505784729085', '0.99', '10', '9.01', '0', '1', '39', '38', '1', '735918403251867648');
INSERT INTO `charge_record` VALUES ('73', '1505784729105', '0.99', '-99030.665', '-99031.655', '0', '1', '1', '1', '1', '735918403251867648');
INSERT INTO `charge_record` VALUES ('74', '1505784729000', '0.99', '9.01', '10', '0', '2', '39', '38', '1', '735918403251867648');
INSERT INTO `charge_record` VALUES ('75', '1505784729000', '0.99', '-99031.655', '-99030.665', '0', '2', '1', '1', '1', '735918403251867648');
INSERT INTO `charge_record` VALUES ('76', '1505817539496', '0.99', '10', '9.01', '0', '1', '39', '38', '1', '736056020098355200');
INSERT INTO `charge_record` VALUES ('77', '1505817539514', '0.99', '-99029.675', '-99030.665', '0', '1', '1', '1', '1', '736056020098355200');
INSERT INTO `charge_record` VALUES ('78', '1505817539000', '0.99', '9.01', '10', '0', '2', '39', '38', '1', '736056020098355200');
INSERT INTO `charge_record` VALUES ('79', '1505817539000', '0.99', '-99030.665', '-99029.675', '0', '2', '1', '1', '1', '736056020098355200');
INSERT INTO `charge_record` VALUES ('80', '1505819312565', '9.9', '10', '0.1', '0', '1', '39', '38', '1', '736063456880365568');
INSERT INTO `charge_record` VALUES ('81', '1505819312582', '9.9', '-99019.775', '-99029.675', '0', '1', '1', '1', '1', '736063456880365568');
INSERT INTO `charge_record` VALUES ('82', '1505819511093', '9.9', '0.1', '10', '0', '2', '39', '38', '1', '736063456880365568');
INSERT INTO `charge_record` VALUES ('83', '1505819511093', '9.9', '-99029.675', '-99019.775', '0', '2', '1', '1', '1', '736063456880365568');
INSERT INTO `charge_record` VALUES ('84', '1505871727968', '100', '-99019.775', '-99119.775', '0', '1', '1', '1', '1', null);
INSERT INTO `charge_record` VALUES ('85', '1505871727972', '100', '-9.24', '90.76', '0', '0', '2', '2', '1', null);
INSERT INTO `charge_record` VALUES ('86', '1505871743736', '9.9', '90.76', '80.86', '0', '1', '2', '2', '1', '736283369150615552');
INSERT INTO `charge_record` VALUES ('87', '1505871743747', '9.9', '-99109.875', '-99119.775', '0', '1', '1', '1', '1', '736283369150615552');
INSERT INTO `charge_record` VALUES ('88', '1505871743000', '9.9', '80.86', '90.76', '0', '2', '2', '2', '1', '736283369150615552');
INSERT INTO `charge_record` VALUES ('89', '1505871743000', '9.9', '-99119.775', '-99109.875', '0', '2', '1', '1', '1', '736283369150615552');
INSERT INTO `charge_record` VALUES ('90', '1505880699466', '30', '-99109.875', '-99139.875', '0', '1', '1', '1', '1', null);
INSERT INTO `charge_record` VALUES ('91', '1505880699469', '30', '0', '30', '0', '0', '55', '53', '1', null);
INSERT INTO `charge_record` VALUES ('92', '1505881141062', '23.1', '30', '6.9', '0', '1', '55', '53', '1', '736322784392646656');
INSERT INTO `charge_record` VALUES ('93', '1505881141074', '23.1', '-99116.775', '-99139.875', '0', '1', '1', '1', '1', '736322784392646656');
INSERT INTO `charge_record` VALUES ('94', '1505881141000', '23.1', '6.9', '30', '0', '2', '55', '53', '1', '736322784392646656');
INSERT INTO `charge_record` VALUES ('95', '1505881141000', '23.1', '-99139.875', '-99116.775', '0', '2', '1', '1', '1', '736322784392646656');
INSERT INTO `charge_record` VALUES ('96', '1505881979502', '21.7', '30', '8.3', '0', '1', '55', '53', '1', '736326301064892416');
INSERT INTO `charge_record` VALUES ('97', '1505881979553', '23.1', '-99095.075', '-99118.175', '0', '1', '1', '1', '1', '736326301064892416');

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
) ENGINE=InnoDB AUTO_INCREMENT=309 DEFAULT CHARSET=latin1;

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
INSERT INTO `cnel_bind_pg` VALUES ('113', '26', '41', '省漫游-微族-湖南移动', '3元10M');
INSERT INTO `cnel_bind_pg` VALUES ('114', '26', '43', '省漫游-微族-湖南移动', '5元30M');
INSERT INTO `cnel_bind_pg` VALUES ('115', '26', '44', '省漫游-微族-湖南移动', '10元70');
INSERT INTO `cnel_bind_pg` VALUES ('116', '26', '45', '省漫游-微族-湖南移动', '10元100M');
INSERT INTO `cnel_bind_pg` VALUES ('117', '26', '46', '省漫游-微族-湖南移动', '20元150M');
INSERT INTO `cnel_bind_pg` VALUES ('118', '26', '47', '省漫游-微族-湖南移动', '20元300');
INSERT INTO `cnel_bind_pg` VALUES ('119', '26', '48', '省漫游-微族-湖南移动', '30元500M');
INSERT INTO `cnel_bind_pg` VALUES ('120', '26', '49', '省漫游-微族-湖南移动', '50元1G');
INSERT INTO `cnel_bind_pg` VALUES ('121', '26', '50', '省漫游-微族-湖南移动', '70元2G');
INSERT INTO `cnel_bind_pg` VALUES ('122', '26', '51', '省漫游-微族-湖南移动', '100元3G');
INSERT INTO `cnel_bind_pg` VALUES ('123', '26', '52', '省漫游-微族-湖南移动', '130元4G');
INSERT INTO `cnel_bind_pg` VALUES ('124', '26', '53', '省漫游-微族-湖南移动', '180元6G');
INSERT INTO `cnel_bind_pg` VALUES ('125', '26', '54', '省漫游-微族-湖南移动', '280元11G');
INSERT INTO `cnel_bind_pg` VALUES ('126', '27', '41', '省漫游-微族-河南移动', '3元10M');
INSERT INTO `cnel_bind_pg` VALUES ('127', '27', '43', '省漫游-微族-河南移动', '5元30M');
INSERT INTO `cnel_bind_pg` VALUES ('128', '27', '44', '省漫游-微族-河南移动', '10元70');
INSERT INTO `cnel_bind_pg` VALUES ('129', '27', '45', '省漫游-微族-河南移动', '10元100M');
INSERT INTO `cnel_bind_pg` VALUES ('130', '27', '46', '省漫游-微族-河南移动', '20元150M');
INSERT INTO `cnel_bind_pg` VALUES ('131', '27', '47', '省漫游-微族-河南移动', '20元300');
INSERT INTO `cnel_bind_pg` VALUES ('132', '27', '48', '省漫游-微族-河南移动', '30元500M');
INSERT INTO `cnel_bind_pg` VALUES ('133', '27', '49', '省漫游-微族-河南移动', '50元1G');
INSERT INTO `cnel_bind_pg` VALUES ('134', '27', '50', '省漫游-微族-河南移动', '70元2G');
INSERT INTO `cnel_bind_pg` VALUES ('135', '27', '51', '省漫游-微族-河南移动', '100元3G');
INSERT INTO `cnel_bind_pg` VALUES ('136', '27', '52', '省漫游-微族-河南移动', '130元4G');
INSERT INTO `cnel_bind_pg` VALUES ('137', '27', '53', '省漫游-微族-河南移动', '180元6G');
INSERT INTO `cnel_bind_pg` VALUES ('138', '27', '54', '省漫游-微族-河南移动', '280元11G');
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
INSERT INTO `cnel_bind_pg` VALUES ('195', '33', '70', '省内-微族-陕西省内移动', '30元500M省内');
INSERT INTO `cnel_bind_pg` VALUES ('196', '33', '71', '省内-微族-陕西省内移动', '50元1G省内');
INSERT INTO `cnel_bind_pg` VALUES ('197', '33', '72', '省内-微族-陕西省内移动', '70元2G省内');
INSERT INTO `cnel_bind_pg` VALUES ('198', '33', '73', '省内-微族-陕西省内移动', '100元3G省内');
INSERT INTO `cnel_bind_pg` VALUES ('199', '33', '74', '省内-微族-陕西省内移动', '130元4G省内');
INSERT INTO `cnel_bind_pg` VALUES ('200', '33', '75', '省内-微族-陕西省内移动', '180元6G省内');
INSERT INTO `cnel_bind_pg` VALUES ('201', '33', '76', '省内-微族-陕西省内移动', '280元11G省内');
INSERT INTO `cnel_bind_pg` VALUES ('202', '33', '78', '省内-微族-陕西省内移动', '10元100M省内');
INSERT INTO `cnel_bind_pg` VALUES ('203', '33', '79', '省内-微族-陕西省内移动', '20元300M省内');
INSERT INTO `cnel_bind_pg` VALUES ('217', '42', '41', '省漫游-微族-山东移动', '3元10M');
INSERT INTO `cnel_bind_pg` VALUES ('218', '42', '43', '省漫游-微族-山东移动', '5元30M');
INSERT INTO `cnel_bind_pg` VALUES ('219', '42', '44', '省漫游-微族-山东移动', '10元70');
INSERT INTO `cnel_bind_pg` VALUES ('220', '42', '45', '省漫游-微族-山东移动', '10元100M');
INSERT INTO `cnel_bind_pg` VALUES ('221', '42', '46', '省漫游-微族-山东移动', '20元150M');
INSERT INTO `cnel_bind_pg` VALUES ('222', '42', '47', '省漫游-微族-山东移动', '20元300');
INSERT INTO `cnel_bind_pg` VALUES ('223', '42', '48', '省漫游-微族-山东移动', '30元500M');
INSERT INTO `cnel_bind_pg` VALUES ('224', '42', '49', '省漫游-微族-山东移动', '50元1G');
INSERT INTO `cnel_bind_pg` VALUES ('225', '42', '50', '省漫游-微族-山东移动', '70元2G');
INSERT INTO `cnel_bind_pg` VALUES ('226', '42', '52', '省漫游-微族-山东移动', '130元4G');
INSERT INTO `cnel_bind_pg` VALUES ('227', '42', '51', '省漫游-微族-山东移动', '100元3G');
INSERT INTO `cnel_bind_pg` VALUES ('228', '42', '53', '省漫游-微族-山东移动', '180元6G');
INSERT INTO `cnel_bind_pg` VALUES ('229', '42', '54', '省漫游-微族-山东移动', '280元11G');
INSERT INTO `cnel_bind_pg` VALUES ('230', '43', '41', '省漫游-微族-浙江移动', '3元10M');
INSERT INTO `cnel_bind_pg` VALUES ('231', '43', '43', '省漫游-微族-浙江移动', '5元30M');
INSERT INTO `cnel_bind_pg` VALUES ('232', '43', '44', '省漫游-微族-浙江移动', '10元70');
INSERT INTO `cnel_bind_pg` VALUES ('233', '43', '45', '省漫游-微族-浙江移动', '10元100M');
INSERT INTO `cnel_bind_pg` VALUES ('234', '43', '46', '省漫游-微族-浙江移动', '20元150M');
INSERT INTO `cnel_bind_pg` VALUES ('235', '43', '47', '省漫游-微族-浙江移动', '20元300');
INSERT INTO `cnel_bind_pg` VALUES ('236', '43', '48', '省漫游-微族-浙江移动', '30元500M');
INSERT INTO `cnel_bind_pg` VALUES ('237', '43', '49', '省漫游-微族-浙江移动', '50元1G');
INSERT INTO `cnel_bind_pg` VALUES ('238', '43', '50', '省漫游-微族-浙江移动', '70元2G');
INSERT INTO `cnel_bind_pg` VALUES ('239', '43', '51', '省漫游-微族-浙江移动', '100元3G');
INSERT INTO `cnel_bind_pg` VALUES ('240', '43', '52', '省漫游-微族-浙江移动', '130元4G');
INSERT INTO `cnel_bind_pg` VALUES ('241', '43', '53', '省漫游-微族-浙江移动', '180元6G');
INSERT INTO `cnel_bind_pg` VALUES ('242', '43', '54', '省漫游-微族-浙江移动', '280元11G');
INSERT INTO `cnel_bind_pg` VALUES ('243', '44', '41', '省漫游-微族-安徽移动', '3元10M');
INSERT INTO `cnel_bind_pg` VALUES ('244', '44', '43', '省漫游-微族-安徽移动', '5元30M');
INSERT INTO `cnel_bind_pg` VALUES ('245', '44', '44', '省漫游-微族-安徽移动', '10元70');
INSERT INTO `cnel_bind_pg` VALUES ('246', '44', '45', '省漫游-微族-安徽移动', '10元100M');
INSERT INTO `cnel_bind_pg` VALUES ('247', '44', '46', '省漫游-微族-安徽移动', '20元150M');
INSERT INTO `cnel_bind_pg` VALUES ('248', '44', '47', '省漫游-微族-安徽移动', '20元300');
INSERT INTO `cnel_bind_pg` VALUES ('249', '44', '48', '省漫游-微族-安徽移动', '30元500M');
INSERT INTO `cnel_bind_pg` VALUES ('250', '44', '49', '省漫游-微族-安徽移动', '50元1G');
INSERT INTO `cnel_bind_pg` VALUES ('251', '44', '50', '省漫游-微族-安徽移动', '70元2G');
INSERT INTO `cnel_bind_pg` VALUES ('252', '44', '51', '省漫游-微族-安徽移动', '100元3G');
INSERT INTO `cnel_bind_pg` VALUES ('253', '44', '52', '省漫游-微族-安徽移动', '130元4G');
INSERT INTO `cnel_bind_pg` VALUES ('254', '44', '53', '省漫游-微族-安徽移动', '180元6G');
INSERT INTO `cnel_bind_pg` VALUES ('255', '44', '54', '省漫游-微族-安徽移动', '280元11G');
INSERT INTO `cnel_bind_pg` VALUES ('256', '45', '41', '省漫游-微族-山西移动', '3元10M');
INSERT INTO `cnel_bind_pg` VALUES ('257', '45', '43', '省漫游-微族-山西移动', '5元30M');
INSERT INTO `cnel_bind_pg` VALUES ('258', '45', '44', '省漫游-微族-山西移动', '10元70');
INSERT INTO `cnel_bind_pg` VALUES ('259', '45', '45', '省漫游-微族-山西移动', '10元100M');
INSERT INTO `cnel_bind_pg` VALUES ('260', '45', '46', '省漫游-微族-山西移动', '20元150M');
INSERT INTO `cnel_bind_pg` VALUES ('261', '45', '47', '省漫游-微族-山西移动', '20元300');
INSERT INTO `cnel_bind_pg` VALUES ('262', '45', '48', '省漫游-微族-山西移动', '30元500M');
INSERT INTO `cnel_bind_pg` VALUES ('263', '45', '49', '省漫游-微族-山西移动', '50元1G');
INSERT INTO `cnel_bind_pg` VALUES ('264', '45', '50', '省漫游-微族-山西移动', '70元2G');
INSERT INTO `cnel_bind_pg` VALUES ('265', '45', '51', '省漫游-微族-山西移动', '100元3G');
INSERT INTO `cnel_bind_pg` VALUES ('266', '45', '52', '省漫游-微族-山西移动', '130元4G');
INSERT INTO `cnel_bind_pg` VALUES ('267', '45', '53', '省漫游-微族-山西移动', '180元6G');
INSERT INTO `cnel_bind_pg` VALUES ('268', '45', '54', '省漫游-微族-山西移动', '280元11G');
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
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8;

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
  `order_id_from` varchar(255) DEFAULT NULL COMMENT '下级代理商传过来的订单号',
  `agency_id` int(11) DEFAULT NULL COMMENT '生成订单的代理商',
  `charge_tel` varchar(255) DEFAULT NULL COMMENT 'æ‰‹æœºå·',
  `order_amount` double DEFAULT NULL COMMENT '订单的初始价格（适用于接口充值）',
  `pg_id` int(11) DEFAULT NULL COMMENT 'æµé‡åŒ…idï¼ˆå¤–é”®ï¼‰',
  `order_arrive_time` bigint(20) DEFAULT NULL COMMENT 'æäº¤æ—¶é—´ï¼ˆæœ¬å¹³å°èŽ·å¾—è¯¥æ•°æ®è¯·æ±‚çš„æ—¶é—´ï¼‰',
  `charge_tel_detail` varchar(255) DEFAULT NULL COMMENT 'å·ç å½’å±žï¼ˆï¼šæ±Ÿè¥¿ç§»åŠ¨ï¼‰',
  `charge_tel_city` varchar(255) DEFAULT NULL COMMENT 'å·ç å½’å±žå…·ä½“åŸŽå¸‚',
  `order_result` int(11) DEFAULT NULL COMMENT '订单状态（超级管理员）',
  `channel_name` varchar(11) DEFAULT NULL COMMENT '通道名称',
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
INSERT INTO `purchase` VALUES ('735696617457324032', '20170918185051643763', null, '31', '15029075956', '92.4', '76', '1505731851229', '陕西移动', null, '1', '河南硕郎', '正在充值', '1505731947558');
INSERT INTO `purchase` VALUES ('735696780196319232', '20170918185130878911', null, '31', '18710364039', '92.4', '76', '1505731890031', '陕西移动', null, '1', '河南硕郎', '正在充值', '1505732038387');
INSERT INTO `purchase` VALUES ('735700764608958464', null, null, '2', '18710364039', '0.99', '66', '1505732839988', '陕西移动', null, null, '河南硕郎', null, null);
INSERT INTO `purchase` VALUES ('735701276200800256', '20170918190922367883', null, '31', '18392775815', '92.4', '76', '1505732961962', '陕西移动', null, '0', '河南硕郎', '正在充值', '1505733305832');
INSERT INTO `purchase` VALUES ('735702630147297280', null, null, '2', '18392775815', '0.99', '66', '1505733284766', '陕西移动', null, null, '河南硕郎', null, null);
INSERT INTO `purchase` VALUES ('735702695658131456', null, null, '31', '15202459815', '92.4', '76', '1505733300387', '陕西移动', null, null, '河南硕郎', null, null);
INSERT INTO `purchase` VALUES ('735736701875392512', null, null, '31', '15202459815', '92.4', '76', '1505741408101', '陕西移动', null, null, '河南硕郎', null, null);
INSERT INTO `purchase` VALUES ('735736758393638912', null, null, '31', '15202459815', '33', '73', '1505741421576', '陕西移动', null, null, '河南硕郎', null, null);
INSERT INTO `purchase` VALUES ('735750781898067968', null, null, '2', '15891790092', '0.99', '66', '1505744765040', '陕西移动', null, null, '河南硕郎', null, null);
INSERT INTO `purchase` VALUES ('735918403251867648', '20170919093209013011', null, '38', '15829898209', '0.99', '66', '1505784729085', '陕西移动', null, '0', '河南硕郎', '产品未配置', '1505784735694');
INSERT INTO `purchase` VALUES ('736056020098355200', '20170919183859270499', null, '38', '15829898209', '0.99', '66', '1505817539496', '陕西移动', null, '0', '河南硕郎', '产品未配置', '1505819072245');
INSERT INTO `purchase` VALUES ('736063456880365568', '20170919190832800630', null, '38', '15829898209', '9.9', '70', '1505819312565', '陕西移动', null, '0', '河南硕郎', '手动失败', '1505819511123');
INSERT INTO `purchase` VALUES ('736124156227096576', null, null, '31', '18710364039', '92.4', '76', '1505833784417', '陕西移动', null, null, '微族-陕西省内移动', null, null);
INSERT INTO `purchase` VALUES ('736283208571686912', null, null, '2', '15829898209', '9.9', '70', '1505871705451', '陕西移动', null, null, '微族-陕西省内移动', null, null);
INSERT INTO `purchase` VALUES ('736283369150615552', '20170920094223425583', null, '2', '15829898209', '9.9', '70', '1505871743736', '陕西移动', null, '0', '微族-陕西省内移动', '正在充值', '1505871782277');
INSERT INTO `purchase` VALUES ('736322784392646656', '20170920121901386880', null, '53', '13772665275', '23.1', '72', '1505881141062', '陕西移动', null, '0', '微族-陕西省内移动', '失败', '1505881921160');
INSERT INTO `purchase` VALUES ('736326301064892416', '20170920123259330129', null, '53', '13772665275', '21.7', '72', '1505881979502', '陕西移动', null, '1', '微族-陕西省内移动', '正在充值', '1505882281372');

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
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rate_discount
-- ----------------------------
INSERT INTO `rate_discount` VALUES ('22', '0.66', null, '19', '0', '22');
INSERT INTO `rate_discount` VALUES ('23', '0.57', null, '19', '0', '22');
INSERT INTO `rate_discount` VALUES ('24', '0.79', null, '23', '0', '26');
INSERT INTO `rate_discount` VALUES ('26', '0.47', null, '27', '0', '30');
INSERT INTO `rate_discount` VALUES ('27', '0.31', null, '30', '0', '33');
INSERT INTO `rate_discount` VALUES ('28', '0.79', null, '24', '0', '27');
INSERT INTO `rate_discount` VALUES ('29', '0.76', null, '44', '0', '47');
INSERT INTO `rate_discount` VALUES ('30', '0.72', null, '43', '0', '46');
INSERT INTO `rate_discount` VALUES ('31', '0.47', null, '42', '0', '45');
INSERT INTO `rate_discount` VALUES ('32', '0.46', null, '41', '0', '44');
INSERT INTO `rate_discount` VALUES ('33', '0.46', null, '40', '0', '43');
INSERT INTO `rate_discount` VALUES ('34', '0.62', null, '39', '0', '42');
INSERT INTO `rate_discount` VALUES ('36', '0.7', null, '45', '0', '48');
INSERT INTO `rate_discount` VALUES ('37', '0.62', null, '46', '0', '49');

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
