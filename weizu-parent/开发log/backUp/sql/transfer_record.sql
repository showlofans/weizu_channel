/*
Navicat MySQL Data Transfer

Source Server         : home
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : rate_channel

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2017-10-13 15:28:45
*/

SET FOREIGN_KEY_CHECKS=0;
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of transfer_record
-- ----------------------------
INSERT INTO `transfer_record` VALUES ('6', '19', '17', '300', '300', '1507864652139', '1507864646000', '1507865588052', '1', '2', '1', '6031462352208');
INSERT INTO `transfer_record` VALUES ('7', '19', '17', '300', '300', '1507866339618', '1507866332000', '1507866489616', '1', '2', '1', '6031465958468');
INSERT INTO `transfer_record` VALUES ('8', '20', '18', '300', '0', '1507866853647', '1507866842000', '1507866912969', '0', '2', '1', '6031467651876');
INSERT INTO `transfer_record` VALUES ('9', '20', '18', '100', '0', '1507867291645', '1507867286000', '1507867335052', '0', '2', '1', '6031469340220');
INSERT INTO `transfer_record` VALUES ('10', '20', '18', '100', '100', '1507868764720', '1507868760000', '1507869326237', '1', '2', '1', '6031477304956');
INSERT INTO `transfer_record` VALUES ('11', '20', '18', '100', '0', '1507869935732', '1507869932000', '1507873203288', '0', '2', '1', '6031492813152');
INSERT INTO `transfer_record` VALUES ('12', '20', '18', '100', '100', '1507870551090', '1507870548000', '1507873193235', '1', '2', '1', '6031492772944');
INSERT INTO `transfer_record` VALUES ('13', '20', '18', '100', '100', '1507873767702', '1507873761000', '1507873809556', '1', '2', '1', '6031495238228');
