# Host: localhost  (Version: 5.5.15)
# Date: 2019-02-02 20:08:07
# Generator: MySQL-Front 5.3  (Build 4.269)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "bean_bank_account"
#

CREATE TABLE `bean_bank_account` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `type` varchar(50) DEFAULT NULL COMMENT '账户类型',
  `name` varchar(50) DEFAULT NULL COMMENT '开户名',
  `number` varchar(50) DEFAULT NULL COMMENT '账号',
  `bank` varchar(100) DEFAULT NULL COMMENT '开户行',
  `detail` varchar(255) DEFAULT NULL COMMENT '描述',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='银行账号表';

#
# Data for table "bean_bank_account"
#

INSERT INTO `bean_bank_account` VALUES (1,'公共账号','CY','2222','中国工商银行',NULL,'2018-12-04 10:30:26',NULL),(2,'阿萨大','萨大  萨大','333333','中国建设银行',NULL,'2018-12-26 10:24:06',NULL),(3,NULL,NULL,NULL,NULL,NULL,'2018-12-26 10:24:33',NULL),(6,'测试账户','陈岩',NULL,NULL,NULL,'2018-12-27 10:00:08',NULL),(7,'个人账号','陈岩','12345678','中国工商银行',NULL,'2018-12-28 10:12:03',NULL),(8,NULL,NULL,NULL,NULL,NULL,'2018-12-30 15:36:46',NULL),(9,NULL,NULL,NULL,NULL,NULL,'2018-12-30 15:42:11',NULL),(10,NULL,NULL,NULL,NULL,NULL,'2018-12-30 16:00:23',NULL),(11,NULL,NULL,NULL,NULL,NULL,'2018-12-30 16:03:00',NULL),(12,NULL,NULL,NULL,NULL,NULL,'2018-12-30 16:05:01',NULL),(13,NULL,NULL,NULL,NULL,NULL,'2018-12-30 16:05:42',NULL),(14,NULL,NULL,NULL,NULL,NULL,'2018-12-30 16:07:09',NULL),(15,'个人账户','陈岩','2929292929292','中国工商银行',NULL,'2018-12-30 16:27:07',NULL),(16,NULL,NULL,NULL,NULL,NULL,'2018-12-30 20:38:04',NULL),(17,NULL,NULL,NULL,NULL,NULL,'2018-12-30 21:30:07',NULL),(18,NULL,NULL,NULL,NULL,NULL,'2018-12-30 21:30:44',NULL),(19,NULL,NULL,NULL,NULL,NULL,'2019-01-12 11:48:24',NULL),(20,NULL,NULL,NULL,NULL,NULL,'2019-01-23 20:58:32',NULL),(21,NULL,NULL,NULL,NULL,NULL,'2019-01-23 23:15:35',NULL),(22,NULL,NULL,NULL,NULL,NULL,'2019-01-28 11:25:01',NULL);

#
# Structure for table "bean_contact"
#

CREATE TABLE `bean_contact` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `role` varchar(30) DEFAULT NULL COMMENT '角色',
  `tel` varchar(50) DEFAULT NULL COMMENT '电话',
  `person_id` varchar(50) DEFAULT NULL COMMENT '身份证号码',
  `detail` varchar(255) DEFAULT NULL COMMENT '备注',
  `resource_id` int(11) DEFAULT NULL COMMENT '资源ID',
  `bank_account_id` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='联系人表';

#
# Data for table "bean_contact"
#

INSERT INTO `bean_contact` VALUES (26,'陈岩','老板娘','13048062053','674462865','测试用例',NULL,20),(28,'黄俊枪','测试工具','32141234','2314124','',NULL,21),(29,'陈岩','测试用例','12322292','12312312','十大彻底删除撒撒旦发送打法',NULL,22);

#
# Structure for table "bean_customer"
#

CREATE TABLE `bean_customer` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '客户标识',
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '客户公司名称',
  `type` varchar(11) NOT NULL DEFAULT '普通' COMMENT '客户类型',
  `status` varchar(11) NOT NULL DEFAULT '正常' COMMENT '客户状态',
  `detail` varchar(256) DEFAULT NULL COMMENT '客户描述',
  `resource_id` int(11) DEFAULT NULL COMMENT '资源ID',
  `bank_account_id` int(11) unsigned DEFAULT NULL COMMENT '银行账户信息',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='客户信息表';

#
# Data for table "bean_customer"
#

INSERT INTO `bean_customer` VALUES (1,'广州铠信挖掘机租赁有限公司','普通','正常','测试数据',NULL,2,'2018-12-27 09:21:08','0000-00-00 00:00:00'),(2,'中铁十三局','普通','正常','',10,1,'2018-12-27 09:22:06','2018-12-30 21:31:28'),(34,'Dustone科技有限公司','普通','正常','特殊用户 源自广州',8,18,'2018-12-27 16:27:10','2018-12-27 16:27:10');

#
# Structure for table "bean_driver"
#

CREATE TABLE `bean_driver` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '机手ID',
  `name` varchar(16) NOT NULL DEFAULT '' COMMENT '机手姓名',
  `tel` varchar(16) NOT NULL DEFAULT '' COMMENT '机手联系电话',
  `person_id` varchar(32) NOT NULL DEFAULT '' COMMENT '身份证号码',
  `paper_id` varchar(32) DEFAULT NULL COMMENT '驾驶许可证号码',
  `status` varchar(11) NOT NULL DEFAULT '空闲' COMMENT '机手状态',
  `type` varchar(11) NOT NULL DEFAULT '普通' COMMENT '机手类型',
  `resource_id` int(11) DEFAULT NULL COMMENT '资源ID',
  `bank_account_id` int(11) unsigned DEFAULT NULL COMMENT '银行账号信息',
  `head_pic` varchar(300) DEFAULT 'resource/staticPicResource/defaultHeadPic.jpg' COMMENT '头像地址',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='机手信息表';

#
# Data for table "bean_driver"
#

INSERT INTO `bean_driver` VALUES (1,'测试数据1','123123123','21321312','312312321','空闲','普通',NULL,14,'resource/staticPicResource/defaultHeadPic.jpg','2018-11-14 22:55:49','2018-12-30 16:07:09'),(2,'测试数据12','123123123','21321312','312312321','空闲','普通',6,16,'resource/staticPicResource/defaultHeadPic.jpg','2018-11-14 22:57:50','2018-12-30 20:38:04'),(3,'测试数据1213','123123123','21321312','312312321','空闲','普通',NULL,NULL,'resource/staticPicResource/defaultHeadPic.jpg','2018-11-14 22:57:50','0000-00-00 00:00:00'),(4,'测试数据1213','123123123','21321312','312312321','空闲','普通',NULL,NULL,'resource/staticPicResource/defaultHeadPic.jpg','2018-11-14 22:57:50','0000-00-00 00:00:00'),(5,'测试数据133425','123123123','21321312','312312321','空闲','普通',NULL,NULL,'resource/staticPicResource/defaultHeadPic.jpg','2018-11-14 22:57:50','0000-00-00 00:00:00'),(6,'测试数据321','123123123','21321312','312312321','空闲','普通',NULL,NULL,'resource/staticPicResource/defaultHeadPic.jpg','2018-11-14 22:57:50','0000-00-00 00:00:00'),(7,'测试数234532据1','123123123','21321312','312312321','空闲','普通',NULL,NULL,'resource/staticPicResource/defaultHeadPic.jpg','2018-11-14 22:57:50','0000-00-00 00:00:00'),(8,'测试数2543据1','123123123','21321312','312312321','空闲','普通',NULL,NULL,'resource/staticPicResource/defaultHeadPic.jpg','2018-11-14 22:57:50','0000-00-00 00:00:00'),(9,'测试23523数据1','123123123','21321312','312312321','空闲','普通',NULL,NULL,'resource/staticPicResource/defaultHeadPic.jpg','2018-11-14 22:57:50','0000-00-00 00:00:00'),(10,'测试43424523数据1','123123123','21321312','312312321','空闲','普通',NULL,NULL,'resource/staticPicResource/defaultHeadPic.jpg','2018-11-14 22:57:50','0000-00-00 00:00:00'),(11,'测试数3452据1','123123123','21321312','312312321','空闲','普通',NULL,NULL,'resource/staticPicResource/defaultHeadPic.jpg','2018-11-14 22:57:50','0000-00-00 00:00:00'),(12,'测试2452数据1','123123123','21321312','312312321','空闲','普通',NULL,NULL,'resource/staticPicResource/defaultHeadPic.jpg','2018-11-14 22:57:50','0000-00-00 00:00:00'),(13,'测52435试数据1','123123123','21321312','312312321','空闲','普通',NULL,NULL,'resource/staticPicResource/defaultHeadPic.jpg','2018-11-14 22:57:50','0000-00-00 00:00:00'),(14,'测试2534数据1','123123123','21321312','312312321','空闲','普通',NULL,NULL,'resource/staticPicResource/defaultHeadPic.jpg','2018-11-14 22:57:50','0000-00-00 00:00:00'),(15,'测5435试数据1','123123123','21321312','312312321','空闲','普通',NULL,11,'resource/staticPicResource/defaultHeadPic.jpg','2018-11-14 22:57:50','2018-12-30 16:03:00'),(16,'测试数据12','123123123','21321312','312312321','空闲','普通',NULL,12,'resource/staticPicResource/defaultHeadPic.jpg','2018-11-14 22:58:06','2018-12-30 16:05:01'),(17,'测试数据1213','123123123','21321312','312312321','空闲','普通',NULL,NULL,'resource/staticPicResource/defaultHeadPic.jpg','2018-11-14 22:58:06','0000-00-00 00:00:00'),(18,'测试数据1213','123123123','21321312','312312321','空闲','普通',NULL,NULL,'resource/staticPicResource/defaultHeadPic.jpg','2018-11-14 22:58:06','0000-00-00 00:00:00'),(19,'测试数据133425','123123123','21321312','312312321','离职','普通',NULL,NULL,'resource/staticPicResource/defaultHeadPic.jpg','2018-11-14 22:58:06','0000-00-00 00:00:00'),(20,'测试数据321','123123123','21321312','312312321','空闲','普通',NULL,10,'resource/staticPicResource/defaultHeadPic.jpg','2018-11-14 22:58:06','2018-12-30 16:00:23'),(21,'测试数234532据1','123123123','21321312','312312321','空闲','普通',NULL,NULL,'resource/staticPicResource/defaultHeadPic.jpg','2018-11-14 22:58:06','0000-00-00 00:00:00'),(22,'测试数2543据1','123123123','21321312','312312321','空闲','普通',NULL,13,'resource/staticPicResource/defaultHeadPic.jpg','2018-11-14 22:58:06','2018-12-30 16:05:42'),(23,'测试23523数据1','123123123','21321312','312312321','空闲','普通',NULL,NULL,'resource/staticPicResource/defaultHeadPic.jpg','2018-11-14 22:58:06','0000-00-00 00:00:00'),(24,'测试43424523数据1','123123123','21321312','312312321','空闲','普通',NULL,NULL,'resource/staticPicResource/defaultHeadPic.jpg','2018-11-14 22:58:06','0000-00-00 00:00:00'),(25,'测试数3452据1','123123123','21321312','312312321','空闲','普通',27,8,'resource/staticPicResource/defaultHeadPic.jpg','2018-11-14 22:58:06','2018-12-30 15:36:46'),(26,'测试2452数据1','123123123','21321312','312312321','空闲','普通',26,9,'resource/staticPicResource/defaultHeadPic.jpg','2018-11-14 22:58:06','2018-12-30 15:42:11'),(27,'李延喜','123123123','21321312','312312321','工作','普通',28,19,'resource/staticPicResource/defaultHeadPic.jpg','2018-11-14 22:58:06','2018-11-25 10:35:33'),(28,'陈岩测试','123123123','21321312','312312321','休假','普通',NULL,NULL,'resource/staticPicResource/defaultHeadPic.jpg','2018-11-14 22:58:06','2018-11-25 09:54:17'),(29,'陈三十','123123123','213213122121','312312321','工作','临时',18,6,'resource/headPicture/机手_29_陈三十jpg?t=0.8865694685057715','2018-11-14 22:58:06','2018-11-25 10:32:40'),(30,'陈岩','130480','21321312','66666666','工作','普通',NULL,1,'resource/staticPicResource/defaultHeadPic.jpg','2018-11-14 23:04:26','0000-00-00 00:00:00'),(31,'陈岩是个大帅哥','213123123','9999999999','312313123','休假','临时',NULL,1,'resource/headPicture/机手_31_陈岩是个大帅哥jpg?t=0.05914047188548688','2018-11-25 13:16:03','2018-11-25 13:16:03'),(32,'韩红','12345678','12345678','12345678','空闲','普通',15,7,'resource/headPicture/机手_32_韩红jpg?t=0.06896128266428869','2018-12-28 10:12:03','2018-12-28 10:12:03'),(33,'陈岩','13048062053','674462865','77787777','空闲','普通',21,15,'resource/headPicture/机手_33_陈岩JPG?t=0.2994021205555175','2018-12-30 16:27:07','2018-12-30 16:27:07');

#
# Structure for table "bean_machine"
#

CREATE TABLE `bean_machine` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '机器ID',
  `tid` int(11) NOT NULL DEFAULT '0' COMMENT '机器型号ID',
  `nameplate` varchar(50) DEFAULT NULL COMMENT '铭牌',
  `code` varchar(32) DEFAULT NULL COMMENT '机器自编号',
  `owner` varchar(20) DEFAULT NULL COMMENT '机主',
  `payway` varchar(20) DEFAULT NULL COMMENT '购买方式',
  `price` int(11) DEFAULT '0' COMMENT '参考价格',
  `m_pay` int(11) DEFAULT '0' COMMENT '月供',
  `status` varchar(11) NOT NULL DEFAULT '空闲' COMMENT '状态',
  `worktime` float(7,2) unsigned DEFAULT NULL COMMENT '工作时间',
  `xyz` varchar(64) DEFAULT NULL COMMENT 'GPS坐标',
  `resource_id` int(11) DEFAULT NULL COMMENT '资源ID',
  `detail` varchar(256) DEFAULT NULL COMMENT '详细备注',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `birth` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `dead_line` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  KEY `MACHINE_TYPE` (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='机器信息表';

#
# Data for table "bean_machine"
#

INSERT INTO `bean_machine` VALUES (1,1,'AC9001','0922','陈岩','分歧',1321,32231,'工作',32232.00,'23421',NULL,NULL,'2018-12-01 08:59:04',NULL,NULL,NULL),(2,1,'ASD','3011','WFQEW','一次性',2342,1234123,'工作',21313.00,'123',1,NULL,'2018-12-01 09:27:50',NULL,NULL,NULL),(3,3,'WW3939','0930','陈岩','130231231312',999,1024,'工作',2020.00,NULL,NULL,NULL,'2019-01-07 13:18:32',NULL,NULL,NULL),(4,8,'KA0244','02 22','陈岩','分期付款',21212,1212,'转场',12.00,NULL,NULL,NULL,'2019-01-14 10:35:55',NULL,NULL,NULL),(9,3,'AA2020',NULL,NULL,NULL,0,0,'工作',NULL,NULL,NULL,NULL,'2019-01-15 21:41:52','0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00');

#
# Structure for table "bean_machine_brand"
#

CREATE TABLE `bean_machine_brand` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '品牌名称',
  `logo` varchar(255) DEFAULT NULL COMMENT 'logo URL',
  `detail` varchar(512) DEFAULT NULL COMMENT '描述',
  `resource_id` int(11) unsigned DEFAULT NULL COMMENT '资源ID',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='机器品牌表';

#
# Data for table "bean_machine_brand"
#

INSERT INTO `bean_machine_brand` VALUES (1,'烈马','logo.jpg','烈马挖掘机',NULL),(2,'页码','logo.jpg','页码挖掘机',NULL);

#
# Structure for table "bean_machine_type"
#

CREATE TABLE `bean_machine_type` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '机器型号ID',
  `brand_name` varchar(32) DEFAULT NULL COMMENT '机器品牌',
  `model` varchar(32) NOT NULL DEFAULT '' COMMENT '型号',
  `name` varchar(50) DEFAULT NULL COMMENT '通俗名称',
  `picture` varchar(300) DEFAULT NULL COMMENT '型号照片',
  `detail` varchar(256) DEFAULT NULL COMMENT '详细描述',
  `resource_id` int(11) DEFAULT NULL COMMENT '资源ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='机器类型表';

#
# Data for table "bean_machine_type"
#

INSERT INTO `bean_machine_type` VALUES (1,NULL,'ASD01','小型挖掘机',NULL,'大马力',NULL),(2,NULL,'AAC','大型挖掘机',NULL,'为全球',NULL),(3,NULL,'BUZZK','测试挖掘机','','qwerwqerwqerwe rcqwecgwegewrewrecqw',NULL),(4,NULL,'BUZZK','测试挖掘机','','qwerqwgeryuj',NULL),(5,NULL,'ADSFSADF','测试挖掘机','','ewgeytjtirmenrt',NULL),(6,NULL,'SDFAD','测试挖掘机','','wegwgwt',NULL),(7,NULL,'REHTY','测试挖掘机','','',NULL),(8,NULL,'WEQRQWR','测试挖掘机','','',NULL),(9,NULL,'JTYJU','测试挖掘机','','',NULL);

#
# Structure for table "bean_support"
#

CREATE TABLE `bean_support` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '后勤ID',
  `name` varchar(16) NOT NULL DEFAULT '' COMMENT '后勤姓名',
  `tel` varchar(16) NOT NULL DEFAULT '' COMMENT '后勤电话',
  `status` varchar(11) DEFAULT '空闲' COMMENT '后勤状态',
  `type` varchar(11) NOT NULL DEFAULT '普通' COMMENT '后勤种类',
  `bank_account_id` int(11) unsigned DEFAULT NULL COMMENT '银行账号信息',
  `resource_id` int(11) DEFAULT NULL,
  `head_pic` varchar(200) DEFAULT NULL COMMENT '头像地址',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='后勤人员表';

#
# Data for table "bean_support"
#

INSERT INTO `bean_support` VALUES (1,'黄俊强','21121211212撒','空闲','普通',3,NULL,'resource/headPicture/后勤_1_黄俊强png?t=0.5678082652072778','2018-12-26 10:16:07','2018-12-26 10:24:33'),(2,'谢晓航','234234124阿萨大','空闲','普通',2,4,'resource/headPicture/后勤_2_谢晓航png?t=0.6656672483139767','2018-12-26 10:16:35','2018-12-26 10:24:06');

#
# Structure for table "com_compact_machine"
#

CREATE TABLE `com_compact_machine` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `compact_id` int(11) unsigned NOT NULL DEFAULT '0',
  `machine_id` int(11) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='合同-机器连接表';

#
# Data for table "com_compact_machine"
#

INSERT INTO `com_compact_machine` VALUES (1,1,1),(2,1,2),(3,1,3);

#
# Structure for table "com_compact_transport"
#

CREATE TABLE `com_compact_transport` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `compact_id` int(11) unsigned NOT NULL DEFAULT '0',
  `transport_id` int(11) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='合同-转场连接表';

#
# Data for table "com_compact_transport"
#


#
# Structure for table "com_compact_work"
#

CREATE TABLE `com_compact_work` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `compact_id` int(11) unsigned NOT NULL DEFAULT '0',
  `work_id` int(11) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='合同-工单连接表';

#
# Data for table "com_compact_work"
#


#
# Structure for table "com_customer_contact"
#

CREATE TABLE `com_customer_contact` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) unsigned DEFAULT NULL,
  `contact_id` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='客户-联系人连接表';

#
# Data for table "com_customer_contact"
#

INSERT INTO `com_customer_contact` VALUES (7,34,26),(8,34,28),(9,34,29);

#
# Structure for table "com_machine_map"
#

CREATE TABLE `com_machine_map` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `machine_id` int(11) unsigned DEFAULT NULL,
  `driver_id` int(11) unsigned DEFAULT NULL,
  `wgs_x` double DEFAULT NULL COMMENT 'wgs_84 X坐标',
  `wgs_y` double DEFAULT NULL COMMENT 'wgs_84  Y坐标',
  `gcj_x` double DEFAULT NULL COMMENT 'gcj_02 x坐标',
  `gcj_y` double DEFAULT NULL COMMENT 'gcj_02 y坐标',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`Id`),
  KEY `FK_MACHINE_MAP_MACHINE` (`machine_id`),
  CONSTRAINT `FK_MACHINE_MAP_MACHINE` FOREIGN KEY (`machine_id`) REFERENCES `bean_machine` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='挖机定位信息表';

#
# Data for table "com_machine_map"
#

INSERT INTO `com_machine_map` VALUES (1,1,30,NULL,NULL,113.280637,23.125178,'2019-01-08 11:15:25'),(2,2,31,NULL,NULL,113.049752,23.109706,'2019-01-08 11:16:10'),(3,3,29,NULL,NULL,113.036199,24.63638,'2019-01-09 16:40:00');

#
# Structure for table "com_resource"
#

CREATE TABLE `com_resource` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '资源ID',
  `name` varchar(128) DEFAULT '' COMMENT '文件名称',
  `type` varchar(16) DEFAULT '' COMMENT '文件类型',
  `url` varchar(512) DEFAULT '' COMMENT '对应相对路径',
  `size` int(11) unsigned DEFAULT '0' COMMENT '资源大小',
  `parent_id` int(11) DEFAULT NULL COMMENT '父资源ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='公共资源表';

#
# Data for table "com_resource"
#

INSERT INTO `com_resource` VALUES (1,'ASD','trunk',NULL,0,NULL,'2018-12-30 20:16:34','2018-12-30 20:16:34'),(2,'MINI.jpg','jpg','resource/uploadFiles/机器信息/null_1/MINI.jpg',22250,1,'2018-12-30 20:16:40','2018-12-30 20:16:40'),(3,'陈岩_v3.docx','docx','resource/uploadFiles/机器信息/null_1/陈岩_v3.docx',19413,1,'2018-12-30 20:16:47','2018-12-30 20:16:47'),(4,'谢晓航','trunk',NULL,0,NULL,'2018-12-30 20:36:54','2018-12-30 20:36:54'),(5,'MINI.jpg','jpg','resource/uploadFiles/后勤信息/谢晓航_4/MINI.jpg',22250,4,'2018-12-30 20:36:58','2018-12-30 20:36:58'),(6,'测试数据12','trunk',NULL,0,NULL,'2018-12-30 20:38:04','2018-12-30 20:38:04'),(7,'陈岩_v1.docx','docx','resource/uploadFiles/机手信息/测试数据12_6/陈岩_v1.docx',17811,6,'2018-12-30 20:38:11','2018-12-30 20:38:11'),(8,'Dustone科技有限公司','trunk',NULL,0,NULL,'2018-12-30 21:30:44','2018-12-30 21:30:44'),(9,'DSC_4407.JPG','JPG','resource/uploadFiles/客户信息/Dustone科技有限公司_8/DSC_4407.JPG',78665,8,'2018-12-30 21:30:48','2018-12-30 21:30:48'),(10,'中铁十三局','trunk',NULL,0,NULL,'2018-12-30 21:31:28','2018-12-30 21:31:28'),(11,'陈岩_v3.docx','docx','resource/uploadFiles/客户信息/中铁十三局_10/陈岩_v3.docx',19413,10,'2018-12-30 21:31:20','2018-12-30 21:31:20'),(12,'陈岩_v4.docx','docx','resource/uploadFiles/客户信息/中铁十三局_10/陈岩_v4.docx',20558,10,'2018-12-30 21:31:23','2018-12-30 21:31:23'),(13,NULL,'trunk',NULL,0,NULL,'2019-01-04 10:44:19','2019-01-04 10:44:19'),(14,'36013011_0322_20181115-231407.png','png','resource/uploadFiles/加油日志信息/null_13/36013011_0322_20181115-231407.png',1881304,13,'2019-01-04 10:44:30','2019-01-04 10:44:30'),(15,'韩红','trunk',NULL,0,NULL,'2019-01-05 13:52:21','2019-01-05 13:52:21'),(17,NULL,'trunk',NULL,0,NULL,'2019-01-05 14:09:14','2019-01-05 14:09:14'),(18,'陈三十','trunk',NULL,0,NULL,'2019-01-08 10:38:11','2019-01-08 10:38:11'),(19,'新建文本文档.txt','txt','resource/uploadFiles/机手信息/陈三十_18/新建文本文档.txt',0,18,'2019-01-08 10:38:15','2019-01-08 10:38:15'),(20,NULL,'trunk',NULL,0,NULL,'2019-01-11 11:30:42','2019-01-11 11:30:42'),(21,'陈岩','trunk',NULL,0,NULL,'2019-01-12 11:43:28','2019-01-12 11:43:28'),(23,'陈岩_v3.docx','docx','resource/uploadFiles/机手信息/陈岩_21/陈岩_v3.docx',19413,NULL,'2019-01-12 11:44:22','2019-01-12 11:44:22'),(26,'测试2452数据1','trunk',NULL,0,NULL,'2019-01-12 11:47:43','2019-01-12 11:47:43'),(27,'测试数3452据1','trunk',NULL,0,NULL,'2019-01-12 11:48:04','2019-01-12 11:48:04'),(28,'李延喜','trunk',NULL,0,NULL,'2019-01-12 11:48:24','2019-01-12 11:48:24'),(29,'陈岩_v2.docx','docx','resource/uploadFiles/机手信息/李延喜_28/陈岩_v2.docx',19719,28,'2019-01-12 11:48:26','2019-01-12 11:48:26'),(31,'简历_v4.docx','docx','resource/uploadFiles/机手信息/陈岩_21/陈岩_v4.docx',20558,NULL,'2019-01-12 14:59:36','2019-01-12 14:59:36'),(32,'MINI.jpg','jpg','resource/uploadFiles/机手信息/陈岩_21/MINI.jpg',22250,21,'2019-01-12 16:29:26','2019-01-12 16:29:26'),(33,'陈岩_v1.docx','docx','resource/uploadFiles/机手信息/陈岩_21/陈岩_v1.docx',17811,21,'2019-01-12 16:32:00','2019-01-12 16:32:00'),(34,'陈岩_v2.docx','docx','resource/uploadFiles/客户信息/Dustone科技有限公司_8/陈岩_v2.docx',19719,8,'2019-01-14 09:56:54','2019-01-14 09:56:54'),(35,NULL,'trunk',NULL,0,NULL,'2019-01-16 12:51:36','2019-01-16 12:51:36'),(36,'陈岩_v4.docx','docx','resource/uploadFiles/合同信息/null_35/陈岩_v4.docx',20558,35,'2019-01-16 12:51:39','2019-01-16 12:51:39');

#
# Structure for table "log_error"
#

CREATE TABLE `log_error` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '异常ID',
  `driver_id` int(11) DEFAULT NULL COMMENT '提交机手',
  `support_id` int(11) DEFAULT NULL COMMENT '后勤ID',
  `machine_id` int(11) DEFAULT NULL COMMENT '机器ID',
  `type` varchar(11) DEFAULT NULL COMMENT '异常种类',
  `title` varchar(128) DEFAULT NULL COMMENT '异常标题',
  `details` varchar(256) DEFAULT NULL COMMENT '异常描述',
  `resource_id` int(11) DEFAULT NULL COMMENT '资源ID',
  `log_mode` varchar(11) DEFAULT NULL COMMENT '日志状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='异常申报表';

#
# Data for table "log_error"
#

INSERT INTO `log_error` VALUES (1,29,2,1,'其他异常','标准故障','测试信息',17,'未审核','2019-01-05 13:50:17','2019-01-05 14:05:23');

#
# Structure for table "log_maintain"
#

CREATE TABLE `log_maintain` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '维修单ID',
  `support_id` int(11) NOT NULL DEFAULT '0' COMMENT '后勤人员ID',
  `support_name` varchar(16) DEFAULT NULL COMMENT '后勤人员姓名',
  `support_tel` varchar(16) DEFAULT NULL COMMENT '后勤人员电话',
  `machine_id` int(11) NOT NULL DEFAULT '0' COMMENT '机器ID',
  `type` varchar(16) DEFAULT NULL COMMENT '维修类型',
  `money` double(11,2) DEFAULT NULL COMMENT '维修金额',
  `details` varchar(256) DEFAULT NULL COMMENT '维修详情',
  `resource_id` int(11) DEFAULT NULL COMMENT '资源ID',
  `log_mode` varchar(11) DEFAULT NULL COMMENT '日志状态',
  `working` varchar(11) DEFAULT NULL COMMENT '执行状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `start_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='维修表';

#
# Data for table "log_maintain"
#

INSERT INTO `log_maintain` VALUES (1,1,NULL,NULL,1,'普通维修',4396.00,NULL,NULL,'已作废',NULL,'2019-01-05 15:40:17','2019-01-15 16:42:14','2019-01-15 16:42:14','2019-01-15 16:42:14'),(2,1,NULL,NULL,2,'返厂维修',999.00,NULL,NULL,'已作废',NULL,'2019-01-05 23:43:18','2019-01-05 23:43:18','2019-01-23 23:43:18','2019-01-25 23:43:18'),(10,1,'黄俊强','21121211212撒',3,'临时维修',2121.00,NULL,NULL,'已作废',NULL,'2019-01-14 23:44:05','2019-01-14 23:44:05','2019-01-14 23:44:05','2019-01-14 23:44:05'),(11,2,'谢晓航','234234124阿萨大',4,'普通维修',212121.00,NULL,NULL,'已作废',NULL,'2019-01-15 17:15:19','2019-01-15 17:15:19','2019-01-15 17:15:19','2019-01-15 17:15:19');

#
# Structure for table "log_oil"
#

CREATE TABLE `log_oil` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '加油ID',
  `support_id` int(11) DEFAULT NULL COMMENT '后勤ID',
  `machine_id` int(11) DEFAULT NULL COMMENT '机器ID',
  `litre` double(11,2) DEFAULT '0.00' COMMENT '加油量',
  `money` double(11,2) DEFAULT '0.00' COMMENT '加油金额',
  `details` varchar(256) DEFAULT NULL COMMENT '详细描述',
  `resource_id` int(11) DEFAULT NULL COMMENT '资源ID',
  `log_mode` varchar(11) DEFAULT NULL COMMENT '日志状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='加油单';

#
# Data for table "log_oil"
#

INSERT INTO `log_oil` VALUES (1,2,1,4396.00,9999.00,'专用测试数据',13,'未审核','2019-01-02 15:03:09','2019-01-04 10:44:19');

#
# Structure for table "log_transport"
#

CREATE TABLE `log_transport` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '转场单',
  `support_id` int(11) NOT NULL DEFAULT '0' COMMENT '后勤人员ID',
  `support_name` varchar(16) DEFAULT NULL COMMENT '后勤人员姓名',
  `support_tel` varchar(16) DEFAULT NULL COMMENT '后勤人员电话',
  `machine_id` int(11) NOT NULL DEFAULT '0' COMMENT '机器ID',
  `departure` varchar(256) DEFAULT NULL COMMENT '起点',
  `destination` varchar(256) DEFAULT NULL COMMENT '终点',
  `type` varchar(16) DEFAULT NULL COMMENT '类型',
  `money` double(11,2) DEFAULT NULL COMMENT '转场金额',
  `details` varchar(256) DEFAULT NULL COMMENT '描述',
  `resource_id` int(11) DEFAULT NULL COMMENT '资源ID',
  `log_mode` varchar(11) DEFAULT NULL COMMENT '状态',
  `working` varchar(11) DEFAULT NULL COMMENT '执行状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `start_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='转场单';

#
# Data for table "log_transport"
#

INSERT INTO `log_transport` VALUES (1,2,NULL,NULL,1,NULL,NULL,'客户转场',3333.00,NULL,NULL,'未审核',NULL,'2019-01-06 10:26:15','2019-01-06 10:26:15','2019-01-06 07:00:00','2019-01-06 10:26:13'),(2,2,'谢晓航','234234124阿萨大',3,NULL,NULL,'第三方转场',2121.00,NULL,NULL,'已审核',NULL,'2019-01-14 23:45:09','2019-01-14 23:45:09','2019-01-14 23:45:09','2019-01-14 23:45:09'),(3,1,'黄俊强','21121211212撒',1,NULL,NULL,'公司转场',1212.00,NULL,NULL,'已作废',NULL,'2019-01-15 20:55:23','2019-01-15 20:55:23','2019-01-15 20:55:23','2019-01-15 20:55:23'),(4,1,'黄俊强','21121211212撒',4,NULL,NULL,'第三方转场',212.00,NULL,NULL,'未审核','进行中','2019-01-16 09:38:16','2019-01-16 09:38:16','2019-01-16 09:38:16','2019-01-16 09:38:14');

#
# Structure for table "log_work"
#

CREATE TABLE `log_work` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '工单ID',
  `driver_id` int(11) NOT NULL DEFAULT '0' COMMENT '司机ID',
  `driver_name` varchar(16) DEFAULT NULL COMMENT '机手姓名',
  `driver_tel` varchar(16) DEFAULT NULL COMMENT '机手电话',
  `machine_id` int(11) NOT NULL DEFAULT '0' COMMENT '机器ID',
  `type` varchar(16) DEFAULT NULL COMMENT '类型',
  `money` double DEFAULT NULL COMMENT '金额',
  `details` varchar(256) DEFAULT NULL COMMENT '描述',
  `resource_id` int(11) DEFAULT NULL COMMENT '资源ID',
  `log_mode` varchar(11) DEFAULT NULL COMMENT '状态',
  `working` varchar(11) DEFAULT NULL COMMENT '执行状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `start_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='工单';

#
# Data for table "log_work"
#

INSERT INTO `log_work` VALUES (1,32,NULL,NULL,1,'合约工单',1212,NULL,NULL,'已审核',NULL,'2019-01-06 11:50:05','2019-01-06 11:50:05','2019-01-06 11:50:05','2019-01-06 11:50:04'),(2,33,'陈岩','13048062053',3,'合约工单',123112,NULL,NULL,'已审核',NULL,'2019-01-14 23:46:25','2019-01-14 23:46:25','2019-01-14 23:46:25','2019-01-14 23:46:25'),(3,33,'陈岩','13048062053',1,'合约工单',600,NULL,NULL,'已审核','进行中','2019-01-18 22:56:30','2019-01-18 22:56:30','2019-01-18 22:56:30','2019-01-18 22:56:30'),(4,33,'陈岩','13048062053',2,'合约工单',2000,NULL,NULL,'未审核','进行中','2019-02-02 19:40:30','2019-02-02 19:40:30','2019-02-02 00:00:00','2019-02-02 19:40:22'),(5,33,'陈岩','13048062053',9,'合约工单',32223,NULL,NULL,'未审核','进行中','2019-02-02 19:41:19','2019-02-02 19:41:19','2019-02-02 00:00:00','2019-02-02 19:41:17');

#
# Structure for table "service_compact"
#

CREATE TABLE `service_compact` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '合同ID',
  `number` varchar(11) NOT NULL DEFAULT '0' COMMENT '合同编号',
  `customer_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '关联客户信息',
  `customer_name` varchar(64) DEFAULT NULL,
  `contact_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '客户联系人信息',
  `type` varchar(11) DEFAULT NULL COMMENT '合同种类',
  `bucket` int(11) unsigned DEFAULT '0' COMMENT '挖斗数量',
  `hammer` int(11) unsigned DEFAULT '0' COMMENT '破碎锤数量',
  `limit_hour` double(11,2) unsigned DEFAULT '440.00' COMMENT '每月限制使用时间（合同内）',
  `total_hour` double(11,2) unsigned DEFAULT NULL COMMENT '实际使用时间',
  `extra_hour` double(11,2) unsigned DEFAULT NULL COMMENT '总计超出时间',
  `money_promise` double(11,2) unsigned DEFAULT NULL COMMENT '保证金',
  `money_rent` double(11,2) unsigned DEFAULT NULL COMMENT '每月租金',
  `money_total` double(11,2) unsigned DEFAULT NULL COMMENT '总金额',
  `money_delay` double(11,2) unsigned DEFAULT NULL COMMENT '违约金',
  `money_fact` double(11,2) unsigned DEFAULT NULL COMMENT '实收金额',
  `money_free` double(11,2) unsigned DEFAULT NULL COMMENT '优惠金额',
  `dest` varchar(256) DEFAULT NULL COMMENT '租用地点',
  `resource_id` int(11) unsigned DEFAULT NULL COMMENT '资源ID',
  `status` varchar(11) DEFAULT '未审核' COMMENT '合同状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `edit_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `enter_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '进场时间',
  `start_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '开工时间',
  PRIMARY KEY (`id`),
  KEY `COMPACT_CUSTOMER` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='合同';

#
# Data for table "service_compact"
#

INSERT INTO `service_compact` VALUES (1,'201901101',34,NULL,26,'月租合同',1,1,440.00,550.00,110.00,20000.00,40000.00,100000.00,1000.00,50000.00,40000.00,'广州南沙',20,'未审核','2019-01-10 10:22:49',NULL,NULL,NULL),(2,'2019011401',34,'Dustone科技有限公司',26,'临租合同',0,0,440.00,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',35,'未审核','2019-01-14 23:49:21',NULL,NULL,NULL);

#
# Structure for table "service_driver_status"
#

CREATE TABLE `service_driver_status` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `driver_id` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='机手状态表';

#
# Data for table "service_driver_status"
#


#
# Structure for table "service_intention"
#

CREATE TABLE `service_intention` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL,
  `title` varchar(128) DEFAULT NULL,
  `details` varchar(256) DEFAULT NULL,
  `resource_id` int(11) DEFAULT NULL,
  `service_mode` int(11) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `start_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  KEY `INTENT_CUSTOMER` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='意愿';

#
# Data for table "service_intention"
#


#
# Structure for table "service_machine_status"
#

CREATE TABLE `service_machine_status` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `machine_id` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '机器ID',
  `status` varchar(11) DEFAULT '空闲' COMMENT '机器状态',
  `compact_id` int(11) unsigned DEFAULT NULL,
  `work_id` int(11) unsigned DEFAULT NULL,
  `transport_id` int(11) unsigned DEFAULT NULL,
  `maintain_id` int(11) unsigned DEFAULT NULL,
  `wgs_x` double DEFAULT NULL COMMENT 'wgs_84 X坐标',
  `wgs_y` double DEFAULT NULL COMMENT 'wgs_84  Y坐标',
  `gcj_x` double DEFAULT NULL COMMENT 'gcj_02 x坐标',
  `gcj_y` double DEFAULT NULL COMMENT 'gcj_02 y坐标',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='机器状态表';

#
# Data for table "service_machine_status"
#

INSERT INTO `service_machine_status` VALUES (1,1,'工作',NULL,3,NULL,NULL,NULL,NULL,113.280637,23.125178,'2019-01-14 23:58:29'),(2,2,'工作',NULL,4,NULL,NULL,NULL,NULL,113.049752,23.109706,'2019-01-14 23:58:38'),(3,3,'空闲',2,NULL,NULL,NULL,NULL,NULL,113.036199,24.63638,'2019-01-15 17:14:16'),(4,4,'转场',NULL,NULL,4,NULL,NULL,NULL,113.036111,22.636442,'2019-01-15 21:16:49'),(5,9,'工作',NULL,5,NULL,NULL,NULL,NULL,NULL,NULL,'2019-01-15 21:41:52');

#
# Structure for table "sys_drawer"
#

CREATE TABLE `sys_drawer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `icon` varchar(128) DEFAULT NULL,
  `url` varchar(128) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='系统导航表';

#
# Data for table "sys_drawer"
#

INSERT INTO `sys_drawer` VALUES (1,'基础','folder_shared',NULL,NULL),(2,'机手管理','account_box','admin/pages/driverList',1),(3,'客户管理','people','admin/pages/customerList',1),(4,'机器管理','android','admin/pages/machineList',1),(5,'机器型号管理','style','admin/pages/machineTypeList',1),(6,'后勤管理','assignment','admin/pages/supportList',1),(7,'日志','event_note',NULL,NULL),(8,'异常','error','admin/pages/logErrorList',7),(9,'维修单','loop','admin/pages/logMaintainList',7),(10,'加油单','local_drink','admin/pages/logOilList',7),(11,'转场单','airport_shuttle','admin/pages/logTransportList',7),(12,'工单','work','admin/pages/logWorkList',7),(13,'业务','info',NULL,NULL),(14,'合同','hourglass_full','admin/pages/compactList',13),(15,'客户意向','assistant_photo',NULL,13),(16,'挖机地图','gps_fixed','admin/pages/machineMap',13),(17,'统计','show_chart',NULL,NULL);

#
# Structure for table "sys_role"
#

CREATE TABLE `sys_role` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) NOT NULL DEFAULT '' COMMENT '角色名称',
  `detail` varchar(255) DEFAULT NULL,
  `type` int(2) unsigned NOT NULL DEFAULT '1' COMMENT '角色种类  1 后台  2 微信小程序端',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色表';

#
# Data for table "sys_role"
#


#
# Structure for table "sys_role_drawer"
#

CREATE TABLE `sys_role_drawer` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) unsigned NOT NULL DEFAULT '0',
  `drawer_id` int(11) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色_导航连接表';

#
# Data for table "sys_role_drawer"
#


#
# Structure for table "sys_user"
#

CREATE TABLE `sys_user` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(100) NOT NULL DEFAULT '' COMMENT '密码（加密后）',
  `salt` varchar(100) NOT NULL DEFAULT '' COMMENT '盐',
  `nick_name` varchar(20) DEFAULT NULL COMMENT '昵称',
  `is_enabled` bit(1) NOT NULL DEFAULT b'1' COMMENT '是否启用',
  `is_locked` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否锁定',
  `login_failure_count` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '登录失败次数',
  `locked_time` timestamp NULL DEFAULT NULL COMMENT '锁定时间',
  `login_time` timestamp NULL DEFAULT NULL COMMENT '登录时间',
  `login_ip` varchar(20) DEFAULT NULL COMMENT '登录ip',
  `role_id` int(11) unsigned DEFAULT NULL COMMENT '角色',
  `link_type` varchar(20) DEFAULT NULL COMMENT '链接角色类型',
  `link_id` int(11) unsigned DEFAULT NULL COMMENT '链接角色ID',
  `avatar` varchar(200) DEFAULT NULL COMMENT '头像',
  `edit_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统用户表';

#
# Data for table "sys_user"
#

INSERT INTO `sys_user` VALUES (1,'admin','123456','',NULL,b'1',b'0',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-01-18 18:58:27');

#
# Structure for table "view_driver_status_count"
#

CREATE VIEW `view_driver_status_count` AS 
  select `bean_driver`.`status` AS `status`,count(`bean_driver`.`id`) AS `number` from `bean_driver` where (`bean_driver`.`status` <> '离职') group by `bean_driver`.`status`;

#
# Structure for table "view_machine_map"
#

CREATE VIEW `view_machine_map` AS 
  select `com_machine_map`.`Id` AS `id`,`bean_driver`.`id` AS `driver_id`,`bean_driver`.`name` AS `driver_name`,`bean_machine`.`id` AS `machine_id`,`com_compact_machine`.`compact_id` AS `compact_id`,`bean_machine`.`nameplate` AS `machine_nameplate`,`bean_machine`.`code` AS `machine_code`,`bean_machine`.`status` AS `machine_status`,`com_machine_map`.`gcj_x` AS `gcj_x`,`com_machine_map`.`gcj_y` AS `gcj_y`,`com_machine_map`.`wgs_x` AS `wgs_x`,`com_machine_map`.`wgs_y` AS `wgs_y`,`com_machine_map`.`update_time` AS `update_time` from (((`com_machine_map` left join `bean_machine` on((`com_machine_map`.`machine_id` = `bean_machine`.`id`))) left join `bean_driver` on((`com_machine_map`.`driver_id` = `bean_driver`.`id`))) left join `com_compact_machine` on((`com_machine_map`.`machine_id` = `com_compact_machine`.`machine_id`)));

#
# Structure for table "view_machine_status"
#

CREATE VIEW `view_machine_status` AS 
  select `service_machine_status`.`Id` AS `id`,`service_machine_status`.`machine_id` AS `machine_id`,`service_machine_status`.`status` AS `status`,`bean_machine`.`nameplate` AS `machine_nameplate`,`bean_machine`.`code` AS `machine_code`,`service_machine_status`.`compact_id` AS `compact_id`,`service_compact`.`type` AS `compact_type`,`service_compact`.`number` AS `compact_number`,`service_compact`.`customer_id` AS `customer_id`,`service_compact`.`customer_name` AS `customer_name`,`service_machine_status`.`work_id` AS `work_id`,`log_work`.`driver_id` AS `driver_id`,`log_work`.`driver_name` AS `driver_name`,`log_work`.`driver_tel` AS `driver_tel`,`service_machine_status`.`transport_id` AS `transport_id`,`log_transport`.`support_id` AS `transport_support_id`,`log_transport`.`support_name` AS `transport_support_name`,`log_transport`.`support_tel` AS `transport_support_tel`,`service_machine_status`.`maintain_id` AS `maintain_id`,`log_maintain`.`support_id` AS `maintain_support_id`,`log_maintain`.`support_name` AS `maintain_support_name`,`log_maintain`.`support_tel` AS `maintain_support_tel`,`service_machine_status`.`wgs_x` AS `wgs_x`,`service_machine_status`.`wgs_y` AS `wgs_y`,`service_machine_status`.`gcj_x` AS `gcj_x`,`service_machine_status`.`gcj_y` AS `gcj_y`,`service_machine_status`.`update_time` AS `update_time` from (((((`service_machine_status` left join `bean_machine` on((`service_machine_status`.`machine_id` = `bean_machine`.`id`))) left join `service_compact` on((`service_machine_status`.`compact_id` = `service_compact`.`id`))) left join `log_work` on((`service_machine_status`.`work_id` = `log_work`.`id`))) left join `log_transport` on((`service_machine_status`.`transport_id` = `log_transport`.`id`))) left join `log_maintain` on((`service_machine_status`.`maintain_id` = `log_maintain`.`id`)));

#
# Structure for table "view_machine_status_count"
#

CREATE VIEW `view_machine_status_count` AS 
  select `bean_machine`.`status` AS `status`,count(`bean_machine`.`id`) AS `number` from `bean_machine` where ((`bean_machine`.`status` <> '已出售') and (`bean_machine`.`status` <> '已报废')) group by `bean_machine`.`status`;

#
# Structure for table "view_work_count"
#

CREATE VIEW `view_work_count` AS 
  select date_format(`work`.`create_time`,'%d') AS `time`,count(`work`.`id`) AS `number` from `log_work` `work` where (date_format(`work`.`create_time`,'%Y%m') = date_format(curdate(),'%Y%m')) group by date_format(`work`.`create_time`,'%Y-%m-%d') order by NULL;

#
# Trigger "compact_customer_trigger"
#

CREATE DEFINER='kaixin'@'%' TRIGGER `compact_customer_trigger` BEFORE INSERT ON `service_compact`
  FOR EACH ROW BEGIN
     set 
         NEW.customer_name=
             (select name from bean_customer where bean_customer.id=NEW.customer_id);
END;

#
# Trigger "machine_status_trigger"
#

CREATE DEFINER='kaixin'@'%' TRIGGER `machine_status_trigger` AFTER INSERT ON `bean_machine`
  FOR EACH ROW insert into service_machine_status (machine_id) values(NEW.id);

#
# Trigger "maintain_support_trigger"
#

CREATE DEFINER='kaixin'@'%' TRIGGER `maintain_support_trigger` BEFORE INSERT ON `log_maintain`
  FOR EACH ROW BEGIN
     set 
         NEW.support_name=
             (select name from bean_support where bean_support.id=NEW.support_id);
     set 
         NEW.support_tel=
             (select tel from bean_support where bean_support.id=NEW.support_id);
END;

#
# Trigger "status_machine_trigger"
#

CREATE DEFINER='kaixin'@'%' TRIGGER `status_machine_trigger` AFTER UPDATE ON `service_machine_status`
  FOR EACH ROW BEGIN
     UPDATE bean_machine set 
            bean_machine.status=NEW.status where bean_machine.id=NEW.machine_id;
END;

#
# Trigger "transport_support_trigger"
#

CREATE DEFINER='kaixin'@'%' TRIGGER `transport_support_trigger` BEFORE INSERT ON `log_transport`
  FOR EACH ROW BEGIN
     set 
         NEW.support_name=
             (select name from bean_support where bean_support.id=NEW.support_id);
     set 
         NEW.support_tel=
             (select tel from bean_support where bean_support.id=NEW.support_id);
END;

#
# Trigger "work_driver_trigger"
#

CREATE DEFINER='kaixin'@'%' TRIGGER `work_driver_trigger` BEFORE INSERT ON `log_work`
  FOR EACH ROW BEGIN
     set 
         NEW.driver_name=
             (select name from bean_driver where bean_driver.id=NEW.driver_id);
     set 
         NEW.driver_tel=
             (select tel from bean_driver where bean_driver.id=NEW.driver_id);
END;
