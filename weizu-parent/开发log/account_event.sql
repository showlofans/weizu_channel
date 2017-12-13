/*
Navicat MySQL Data Transfer

Source Server         : channel-server
Source Server Version : 50626
Source Host           : 120.55.162.224:3306
Source Database       : rate_channel

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2017-12-09 08:41:30
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `account_event`
-- ----------------------------
DROP TABLE IF EXISTS `account_event`;
CREATE TABLE `account_event` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `agency_id` int(11) DEFAULT NULL COMMENT '代理商id',
  `event_type` int(11) DEFAULT NULL COMMENT '时间类型',
  `event_time` bigint(20) DEFAULT NULL COMMENT '发生时间',
  `event_location` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '事件发生地点',
  `event_ip` varchar(255) DEFAULT NULL,
  `event_state` int(11) DEFAULT NULL COMMENT '事件状态',
  `bill_type` int(11) DEFAULT NULL COMMENT '发生事件的账户类型',
  PRIMARY KEY (`id`),
  KEY `agency_fk_ae` (`agency_id`),
  CONSTRAINT `agency_fk_ae` FOREIGN KEY (`agency_id`) REFERENCES `agency_backward` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of account_event
-- ----------------------------
INSERT INTO `account_event` VALUES ('1', '2', '1', '1512725030367', '南昌', '120.55.162.224', '1', null);
INSERT INTO `account_event` VALUES ('2', '1', '1', '1512725177408', '内网IP', '127.0.0.1', '1', null);
INSERT INTO `account_event` VALUES ('3', '2', '1', '1512725350270', '内网IP', '127.0.0.1', '1', null);
INSERT INTO `account_event` VALUES ('4', '48', '1', '1512725705908', '呼和浩特市', '123.178.72.95', '1', null);
INSERT INTO `account_event` VALUES ('5', '1', '1', '1512726025654', '南昌市', '106.4.247.116', '1', null);
INSERT INTO `account_event` VALUES ('6', '48', '1', '1512726045938', '呼和浩特市', '123.178.72.95', '1', null);
INSERT INTO `account_event` VALUES ('7', '48', '1', '1512726428587', '呼和浩特市', '110.16.80.106', '1', null);
INSERT INTO `account_event` VALUES ('8', '2', '1', '1512726609698', '南昌市', '106.4.247.116', '1', null);
INSERT INTO `account_event` VALUES ('9', '48', '1', '1512727694457', '呼和浩特市', '123.178.72.95', '1', null);
INSERT INTO `account_event` VALUES ('10', '1', '1', '1512727914746', '南昌市', '106.4.247.116', '1', null);
INSERT INTO `account_event` VALUES ('11', '48', '1', '1512728006636', '呼和浩特市', '123.178.72.95', '1', null);
INSERT INTO `account_event` VALUES ('12', '48', '1', '1512728902316', '呼和浩特市', '123.178.72.95', '1', null);
INSERT INTO `account_event` VALUES ('13', '48', '1', '1512729724912', '呼和浩特市', '123.178.72.95', '1', null);
INSERT INTO `account_event` VALUES ('14', '48', '1', '1512729850688', '呼和浩特市', '123.178.72.95', '1', null);
INSERT INTO `account_event` VALUES ('15', '48', '1', '1512729858857', '呼和浩特市', '123.178.72.95', '1', null);
INSERT INTO `account_event` VALUES ('16', '48', '1', '1512729870287', '呼和浩特市', '123.178.72.95', '1', null);
INSERT INTO `account_event` VALUES ('17', '48', '1', '1512732728454', '呼和浩特市', '123.178.72.95', '1', null);
INSERT INTO `account_event` VALUES ('18', '48', '1', '1512733366119', '呼和浩特市', '110.7.6.141', '1', null);
INSERT INTO `account_event` VALUES ('19', '48', '1', '1512733752950', '呼和浩特市', '110.7.6.141', '1', null);
INSERT INTO `account_event` VALUES ('20', '48', '1', '1512733909056', '呼和浩特市', '110.7.6.141', '1', null);
INSERT INTO `account_event` VALUES ('21', '48', '1', '1512734038357', '呼和浩特市', '110.7.6.141', '1', null);
INSERT INTO `account_event` VALUES ('22', '48', '1', '1512734743022', '呼和浩特市', '110.7.6.141', '1', null);
INSERT INTO `account_event` VALUES ('23', '48', '1', '1512735465724', '呼和浩特市', '110.7.6.141', '1', null);
INSERT INTO `account_event` VALUES ('24', '48', '1', '1512735664082', '呼和浩特市', '110.7.6.141', '1', null);
INSERT INTO `account_event` VALUES ('25', '48', '1', '1512735681903', '呼和浩特市', '110.7.6.141', '1', null);
INSERT INTO `account_event` VALUES ('26', '48', '1', '1512735822267', '呼和浩特市', '110.7.6.141', '1', null);
INSERT INTO `account_event` VALUES ('27', '2', '1', '1512737229289', '南昌市', '59.52.186.163', '1', null);
INSERT INTO `account_event` VALUES ('28', '68', '1', '1512737882809', '长沙市', '223.104.130.157', '1', null);
INSERT INTO `account_event` VALUES ('29', '1', '1', '1512738808306', '南昌市', '171.34.208.92', '1', null);
INSERT INTO `account_event` VALUES ('30', '48', '1', '1512739587321', '呼和浩特市', '110.7.6.141', '1', null);
INSERT INTO `account_event` VALUES ('31', '48', '1', '1512739784590', '未找到该地区', '117.136.3.189', '1', null);
INSERT INTO `account_event` VALUES ('32', '1', '1', '1512740724850', '南昌市', '59.52.186.163', '1', null);
INSERT INTO `account_event` VALUES ('33', '64', '1', '1512741111515', '西安市', '117.136.50.20', '1', null);
INSERT INTO `account_event` VALUES ('34', '139', '1', '1512741813460', '合肥市', '117.136.101.94', '1', null);
INSERT INTO `account_event` VALUES ('35', '115', '1', '1512741875655', '晋中市', '113.25.205.200', '1', null);
INSERT INTO `account_event` VALUES ('36', '115', '1', '1512741963751', '晋中市', '113.25.205.200', '1', null);
INSERT INTO `account_event` VALUES ('37', '144', '1', '1512741980712', '西安市', '117.136.86.23', '1', null);
INSERT INTO `account_event` VALUES ('38', '144', '1', '1512742052924', '西安市', '117.136.86.23', '1', null);
INSERT INTO `account_event` VALUES ('39', '153', '1', '1512742601489', '晋中市', '113.25.205.200', '1', null);
INSERT INTO `account_event` VALUES ('40', '153', '1', '1512742601489', '晋中市', '113.25.205.200', '1', null);
INSERT INTO `account_event` VALUES ('41', '153', '1', '1512742601511', '晋中市', '113.25.205.200', '1', null);
INSERT INTO `account_event` VALUES ('42', '153', '1', '1512742655209', '晋中市', '113.25.205.200', '1', null);
INSERT INTO `account_event` VALUES ('43', '153', '1', '1512742677808', '晋中市', '113.25.205.200', '1', null);
INSERT INTO `account_event` VALUES ('44', '144', '1', '1512743085022', '西安市', '117.136.86.23', '1', null);
INSERT INTO `account_event` VALUES ('45', '144', '1', '1512743115833', '西安市', '117.136.86.23', '1', null);
INSERT INTO `account_event` VALUES ('46', '48', '1', '1512743536241', '呼和浩特市', '110.7.6.141', '1', null);
INSERT INTO `account_event` VALUES ('47', '1', '1', '1512744751388', '南昌市', '182.97.80.168', '1', null);
INSERT INTO `account_event` VALUES ('48', '144', '1', '1512746489854', '西安市', '117.136.86.23', '1', null);
INSERT INTO `account_event` VALUES ('49', '144', '1', '1512748116683', '西安市', '117.136.86.23', '1', null);
INSERT INTO `account_event` VALUES ('50', '144', '1', '1512748118693', '未找到该地区', '117.136.86.23', '1', null);
INSERT INTO `account_event` VALUES ('51', '48', '1', '1512776640227', '呼和浩特市', '36.102.243.133', '1', null);
INSERT INTO `account_event` VALUES ('52', '1', '1', '1512778600942', '南昌市', '59.52.186.163', '1', null);
INSERT INTO `account_event` VALUES ('53', '48', '1', '1512779984135', '呼和浩特市', '36.102.243.133', '1', null);
INSERT INTO `account_event` VALUES ('54', '48', '1', '1512780008601', '呼和浩特市', '36.102.243.133', '1', null);
INSERT INTO `account_event` VALUES ('55', '2', '1', '1512780013946', '内网IP', '127.0.0.1', '1', null);
