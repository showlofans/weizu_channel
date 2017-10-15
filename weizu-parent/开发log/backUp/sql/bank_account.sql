/*
Navicat MySQL Data Transfer

Source Server         : home
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : rate_channel

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2017-10-13 15:27:40
*/

SET FOREIGN_KEY_CHECKS=0;
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
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bank_account
-- ----------------------------
INSERT INTO `bank_account` VALUES ('17', '28', '工商对公卡', '7541541545512154655', '宁强', '30900', '1', null, '1');
INSERT INTO `bank_account` VALUES ('18', '1', '建设银行对私卡', '364564854521545411', '宁强', '30300', '1', null, '1');
INSERT INTO `bank_account` VALUES ('19', '54', '工商对公卡', '71111111111', '李威', '1400', '2', null, '1');
INSERT INTO `bank_account` VALUES ('20', '2', '建设银行对私卡', '322222222222222222', '李威', '2700', '2', null, '1');
INSERT INTO `bank_account` VALUES ('21', '54', '工商对公卡', '7541541545512154655', '宁强', null, '1', '1', '1');
INSERT INTO `bank_account` VALUES ('22', '2', '建设银行对私卡', '364564854521545411', '宁强', null, '1', '1', '1');
