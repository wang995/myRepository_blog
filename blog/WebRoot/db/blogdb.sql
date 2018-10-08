/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50722
Source Host           : 127.0.0.1:3306
Source Database       : blogdb

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-10-08 13:57:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for deptools
-- ----------------------------
DROP TABLE IF EXISTS `deptools`;
CREATE TABLE `deptools` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  `size` double DEFAULT NULL,
  `download_num` int(11) DEFAULT '0',
  `remarks` varchar(255) DEFAULT NULL,
  `creatTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12413 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of deptools
-- ----------------------------
INSERT INTO `deptools` VALUES ('12412', 'tsl', '1', '65', null, '651d', '2018-10-02 14:20:29');

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `questionid` int(11) DEFAULT NULL,
  `content` varchar(500) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `creatTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `feedback_quesid` (`questionid`),
  CONSTRAINT `feedback_quesid` FOREIGN KEY (`questionid`) REFERENCES `technology` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1006 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of feedback
-- ----------------------------

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  `title` varchar(1000) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `creat_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5166 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------

-- ----------------------------
-- Table structure for personnel
-- ----------------------------
DROP TABLE IF EXISTS `personnel`;
CREATE TABLE `personnel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `creatTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of personnel
-- ----------------------------
INSERT INTO `personnel` VALUES ('4', '认识她sdfsdfsdf', '识她sdfsdfsdfsd', '2018-10-07 21:41:21');
INSERT INTO `personnel` VALUES ('6', 'sdfsd', 'fsdfsdf', '2018-10-08 10:41:58');

-- ----------------------------
-- Table structure for technology
-- ----------------------------
DROP TABLE IF EXISTS `technology`;
CREATE TABLE `technology` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(2550) DEFAULT NULL,
  `creatTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1015 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of technology
-- ----------------------------
INSERT INTO `technology` VALUES ('1013', 'sdfs', 'dfsdfsdfsd', '2018-10-07 17:17:22');
INSERT INTO `technology` VALUES ('1014', '技术1', '技术1技术1技术1技术1技术1技术1技术1技术1技术1技术1技术1技术1技术1技术1技术1技术1技术1技术1技术1技术1技术1技术1技术1技术1技术1技术1技术1技术1技术1技术1技术1技术1技术1技术1技术1技术1技术1技术1技术1', '2018-10-07 21:48:02');

-- ----------------------------
-- Table structure for websiteadvise
-- ----------------------------
DROP TABLE IF EXISTS `websiteadvise`;
CREATE TABLE `websiteadvise` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `creatTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1008 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of websiteadvise
-- ----------------------------
INSERT INTO `websiteadvise` VALUES ('1000', '第一条反馈', 'wangxl', '2018-10-02 17:02:24');
INSERT INTO `websiteadvise` VALUES ('1001', '第三条反馈', '646546', '2018-10-02 17:03:17');
INSERT INTO `websiteadvise` VALUES ('1002', '爱抚噶', '啊是否订购', '2018-10-02 23:00:00');
INSERT INTO `websiteadvise` VALUES ('1003', '暗杀干啥地方', '啊是的噶啥', '2018-10-02 23:00:16');
INSERT INTO `websiteadvise` VALUES ('1004', 'sdfsdsdf', 'sdfsdf', '2018-10-02 23:11:41');
INSERT INTO `websiteadvise` VALUES ('1005', 'd', '王晓磊s', '2018-10-05 21:35:38');
INSERT INTO `websiteadvise` VALUES ('1006', 'sdfsdf', 'sdfsdf', '2018-10-07 20:06:44');

-- ----------------------------
-- Procedure structure for out_param
-- ----------------------------
DROP PROCEDURE IF EXISTS `out_param`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `out_param`(OUT p_out int)
BEGIN
      SELECT p_out;
      SET p_out=2;
      SELECT p_out;
    END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for selectCount
-- ----------------------------
DROP PROCEDURE IF EXISTS `selectCount`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `selectCount`(OUT deptoolsNum int,OUT feedBackNum int,OUT logNum int,OUT personnelNum int,OUT technologyNum int,OUT adviseNum int)
BEGIN
	SET depToolsNum=(SELECT COUNT(*) FROM deptools);
	SET feedBackNum=(SELECT COUNT(*) FROM feedback);
	SET logNum=(SELECT COUNT(*) FROM log);
	SET personnelNum=(SELECT COUNT(*) FROM personnel);
	SET technologyNum=(SELECT COUNT(*) FROM technology);
	SET adviseNum=(SELECT COUNT(*) FROM websiteadvise);
	SELECT depToolsNum,feedBackNum,logNum,personnelNum,technologyNum,adviseNum;
END
;;
DELIMITER ;
