/*
Navicat MySQL Data Transfer

Source Server         : myconn
Source Server Version : 50733
Source Host           : localhost:3306
Source Database       : community

Target Server Type    : MYSQL
Target Server Version : 50733
File Encoding         : 65001

Date: 2021-05-20 01:17:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `configure`
-- ----------------------------
DROP TABLE IF EXISTS `configure`;
CREATE TABLE `configure` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 NOT NULL,
  `price` varchar(255) CHARACTER SET utf8 NOT NULL,
  `Servicelife` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=123422 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of configure
-- ----------------------------
INSERT INTO `configure` VALUES ('123421', '配置名1', '价格', '时限');

-- ----------------------------
-- Table structure for `property1`
-- ----------------------------
DROP TABLE IF EXISTS `property1`;
CREATE TABLE `property1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dong` varchar(255) NOT NULL,
  `cheng` varchar(255) NOT NULL,
  `fang` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of property1
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_application`
-- ----------------------------
DROP TABLE IF EXISTS `tb_application`;
CREATE TABLE `tb_application` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `applicant` varchar(255) NOT NULL,
  `roomno` int(255) NOT NULL,
  `applytime` datetime NOT NULL,
  `applyprogram` varchar(255) NOT NULL,
  `applystate` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_application
-- ----------------------------
INSERT INTO `tb_application` VALUES ('1', '申请人1', '1523', '2021-05-05 13:09:07', '小区物业管理系统', '已处理');
INSERT INTO `tb_application` VALUES ('2', '申请人2', '1510', '2021-05-18 13:10:46', '学生宿舍管理系统', '未处理');
INSERT INTO `tb_application` VALUES ('3', 'fdsf', '1222', '2021-05-18 13:11:07', 'eweq', 'ewqeqw');
INSERT INTO `tb_application` VALUES ('4', 'ewqewq', '1232', '2021-05-18 13:11:20', 'ewerew', 'rerere');

-- ----------------------------
-- Table structure for `tb_arrears`
-- ----------------------------
DROP TABLE IF EXISTS `tb_arrears`;
CREATE TABLE `tb_arrears` (
  `payno` int(11) NOT NULL AUTO_INCREMENT,
  `payname` varchar(255) CHARACTER SET utf8 NOT NULL,
  `unit` varchar(255) CHARACTER SET utf8 NOT NULL,
  `total` varchar(255) CHARACTER SET utf8 NOT NULL,
  `paytype` varchar(255) CHARACTER SET utf8 NOT NULL,
  `ownername` varchar(255) CHARACTER SET utf8 NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`payno`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tb_arrears
-- ----------------------------
INSERT INTO `tb_arrears` VALUES ('1', '21432143', '想不起收费名', '1212', '21212', '生活类', '1523', '2021-05-18 13:13:11');
INSERT INTO `tb_arrears` VALUES ('2', '54354355', '乱七八糟收费名字', '343', '4343', '消费类', '1444', '2021-05-18 13:13:41');
INSERT INTO `tb_arrears` VALUES ('3', '防守打法', 'fsdf', '34', '343', 'sdfds', 'sdfsd', '2021-05-21 13:13:54');

-- ----------------------------
-- Table structure for `tb_complaint`
-- ----------------------------
DROP TABLE IF EXISTS `tb_complaint`;
CREATE TABLE `tb_complaint` (
  `complainant` varchar(255) CHARACTER SET utf8 NOT NULL,
  `roomno` int(255) NOT NULL AUTO_INCREMENT,
  `complainttime` datetime NOT NULL,
  `matter` varchar(255) CHARACTER SET utf8 NOT NULL,
  `state` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`roomno`)
) ENGINE=InnoDB AUTO_INCREMENT=3233 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tb_complaint
-- ----------------------------
INSERT INTO `tb_complaint` VALUES ('投诉人1', '1523', '2021-05-05 13:15:32', '没电', '未处理');
INSERT INTO `tb_complaint` VALUES ('投诉人2', '1555', '2021-04-25 13:15:59', '没热水，垃圾', '未处理');
INSERT INTO `tb_complaint` VALUES ('3232', '3232', '2021-05-18 13:16:27', 'rere', 'rere');

-- ----------------------------
-- Table structure for `tb_owner`
-- ----------------------------
DROP TABLE IF EXISTS `tb_owner`;
CREATE TABLE `tb_owner` (
  `roomNo` int(255) NOT NULL,
  `ownerNo` int(11) NOT NULL,
  `ownerName` varchar(255) CHARACTER SET utf8 NOT NULL,
  `ownerPhone` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`ownerNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tb_owner
-- ----------------------------
INSERT INTO `tb_owner` VALUES ('2323231', '15231', '????11', '123456789091');
INSERT INTO `tb_owner` VALUES ('1523', '232323', '业主名字1', '12345678909');

-- ----------------------------
-- Table structure for `tb_parkinglot`
-- ----------------------------
DROP TABLE IF EXISTS `tb_parkinglot`;
CREATE TABLE `tb_parkinglot` (
  `plno` int(11) NOT NULL AUTO_INCREMENT,
  `ownerno` int(255) NOT NULL,
  `pltype` varchar(255) CHARACTER SET utf8 NOT NULL,
  `plstate` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`plno`)
) ENGINE=InnoDB AUTO_INCREMENT=1212 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tb_parkinglot
-- ----------------------------
INSERT INTO `tb_parkinglot` VALUES ('121', '2121', '车位类型', '车位状态');
INSERT INTO `tb_parkinglot` VALUES ('1211', '21211', '????1', '????1');

-- ----------------------------
-- Table structure for `tb_paynote`
-- ----------------------------
DROP TABLE IF EXISTS `tb_paynote`;
CREATE TABLE `tb_paynote` (
  `pnoteno` int(11) NOT NULL AUTO_INCREMENT,
  `payname` varchar(255) CHARACTER SET utf8 NOT NULL,
  `unit` varchar(255) CHARACTER SET utf8 NOT NULL,
  `total` varchar(255) CHARACTER SET utf8 NOT NULL,
  `paytype` varchar(255) CHARACTER SET utf8 NOT NULL,
  `ownerName` varchar(255) CHARACTER SET utf8 NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`pnoteno`)
) ENGINE=InnoDB AUTO_INCREMENT=2325 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tb_paynote
-- ----------------------------
INSERT INTO `tb_paynote` VALUES ('2324', '收费项目名称', '12.2', '1213', '收费项目类型', '业主名字1', '地址1');

-- ----------------------------
-- Table structure for `tb_payservice`
-- ----------------------------
DROP TABLE IF EXISTS `tb_payservice`;
CREATE TABLE `tb_payservice` (
  `payno` int(11) NOT NULL AUTO_INCREMENT,
  `payname` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `paytype` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`payno`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tb_payservice
-- ----------------------------
INSERT INTO `tb_payservice` VALUES ('1', '收费项目编号1', '收费项目类型');

-- ----------------------------
-- Table structure for `tb_person`
-- ----------------------------
DROP TABLE IF EXISTS `tb_person`;
CREATE TABLE `tb_person` (
  `name` varchar(255) CHARACTER SET utf8 NOT NULL,
  `sex` varchar(255) CHARACTER SET utf8 NOT NULL,
  `idno` varchar(255) CHARACTER SET utf8 NOT NULL,
  `birthday` varchar(255) CHARACTER SET utf8 NOT NULL,
  `accountaddr` varchar(255) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tb_person
-- ----------------------------
INSERT INTO `tb_person` VALUES ('范德萨', '男', '123456789009876543', '2020-12-12', '真的撒旦发');

-- ----------------------------
-- Table structure for `tb_position`
-- ----------------------------
DROP TABLE IF EXISTS `tb_position`;
CREATE TABLE `tb_position` (
  `jobtitle` varchar(255) CHARACTER SET utf8 NOT NULL,
  `positionnote` varchar(255) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tb_position
-- ----------------------------
INSERT INTO `tb_position` VALUES ('职位1', '高浮雕高浮雕');
INSERT INTO `tb_position` VALUES ('2', '333');

-- ----------------------------
-- Table structure for `tb_property`
-- ----------------------------
DROP TABLE IF EXISTS `tb_property`;
CREATE TABLE `tb_property` (
  `block` varchar(255) NOT NULL,
  `building` varchar(255) NOT NULL,
  `roomNo` int(11) NOT NULL,
  `floor` varchar(255) NOT NULL,
  PRIMARY KEY (`roomNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tb_property
-- ----------------------------
INSERT INTO `tb_property` VALUES ('12', '22', '52', '15232');
INSERT INTO `tb_property` VALUES ('1', '2', '1523', '5');

-- ----------------------------
-- Table structure for `userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyName` varchar(255) NOT NULL,
  `companyAddress` varchar(255) NOT NULL,
  `companyZip` varchar(255) NOT NULL,
  `idCade` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `sex` varchar(255) NOT NULL,
  `postbox` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1', '123', '123', '123', '123', '123', '123', '123');

-- ----------------------------
-- Table structure for `userlogin`
-- ----------------------------
DROP TABLE IF EXISTS `userlogin`;
CREATE TABLE `userlogin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) CHARACTER SET utf8 NOT NULL,
  `userPwd` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of userlogin
-- ----------------------------
INSERT INTO `userlogin` VALUES ('1', '123', '123');
