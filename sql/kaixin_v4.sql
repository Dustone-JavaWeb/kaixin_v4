# Host: localhost  (Version: 5.5.15)
# Date: 2018-12-31 21:05:26
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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='银行账号表';

#
# Data for table "bean_bank_account"
#

INSERT INTO `bean_bank_account` VALUES (1,'公共账号','CY','2222','中国工商银行',NULL,'2018-12-04 10:30:26',NULL),(2,'阿萨大','萨大  萨大','333333','中国建设银行',NULL,'2018-12-26 10:24:06',NULL),(3,NULL,NULL,NULL,NULL,NULL,'2018-12-26 10:24:33',NULL),(6,'测试账户','陈岩',NULL,NULL,NULL,'2018-12-27 10:00:08',NULL),(7,'个人账号','陈岩','12345678','中国工商银行',NULL,'2018-12-28 10:12:03',NULL),(8,NULL,NULL,NULL,NULL,NULL,'2018-12-30 15:36:46',NULL),(9,NULL,NULL,NULL,NULL,NULL,'2018-12-30 15:42:11',NULL),(10,NULL,NULL,NULL,NULL,NULL,'2018-12-30 16:00:23',NULL),(11,NULL,NULL,NULL,NULL,NULL,'2018-12-30 16:03:00',NULL),(12,NULL,NULL,NULL,NULL,NULL,'2018-12-30 16:05:01',NULL),(13,NULL,NULL,NULL,NULL,NULL,'2018-12-30 16:05:42',NULL),(14,NULL,NULL,NULL,NULL,NULL,'2018-12-30 16:07:09',NULL),(15,'个人账户','陈岩','2929292929292','中国工商银行',NULL,'2018-12-30 16:27:07',NULL),(16,NULL,NULL,NULL,NULL,NULL,'2018-12-30 20:38:04',NULL),(17,NULL,NULL,NULL,NULL,NULL,'2018-12-30 21:30:07',NULL),(18,NULL,NULL,NULL,NULL,NULL,'2018-12-30 21:30:44',NULL);

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
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='联系人表';

#
# Data for table "bean_contact"
#

INSERT INTO `bean_contact` VALUES (25,'陈岩','老板',NULL,'674462865',NULL,NULL,NULL),(26,'陈岩','老板',NULL,'674462865',NULL,NULL,NULL);

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

INSERT INTO `bean_customer` VALUES (1,'广州铠信挖掘机租赁有限公司','普通','正常','测试数据',NULL,2,'2018-12-27 09:21:08','0000-00-00 00:00:00'),(2,'中铁十三局','普通','正常','测试数据',10,1,'2018-12-27 09:22:06','2018-12-30 21:31:28'),(34,'Dustone科技有限公司','普通','正常','测试数据',8,18,'2018-12-27 16:27:10','2018-12-27 16:27:10');

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
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='机手信息表';

#
# Data for table "bean_driver"
#

INSERT INTO `bean_driver` VALUES (1,'测试数据1','123123123','21321312','312312321','空闲','普通',NULL,14,'2018-11-14 22:55:49','2018-12-30 16:07:09'),(2,'测试数据12','123123123','21321312','312312321','空闲','普通',6,16,'2018-11-14 22:57:50','2018-12-30 20:38:04'),(3,'测试数据1213','123123123','21321312','312312321','空闲','普通',NULL,NULL,'2018-11-14 22:57:50','0000-00-00 00:00:00'),(4,'测试数据1213','123123123','21321312','312312321','空闲','普通',NULL,NULL,'2018-11-14 22:57:50','0000-00-00 00:00:00'),(5,'测试数据133425','123123123','21321312','312312321','空闲','普通',NULL,NULL,'2018-11-14 22:57:50','0000-00-00 00:00:00'),(6,'测试数据321','123123123','21321312','312312321','空闲','普通',NULL,NULL,'2018-11-14 22:57:50','0000-00-00 00:00:00'),(7,'测试数234532据1','123123123','21321312','312312321','空闲','普通',NULL,NULL,'2018-11-14 22:57:50','0000-00-00 00:00:00'),(8,'测试数2543据1','123123123','21321312','312312321','空闲','普通',NULL,NULL,'2018-11-14 22:57:50','0000-00-00 00:00:00'),(9,'测试23523数据1','123123123','21321312','312312321','空闲','普通',NULL,NULL,'2018-11-14 22:57:50','0000-00-00 00:00:00'),(10,'测试43424523数据1','123123123','21321312','312312321','空闲','普通',NULL,NULL,'2018-11-14 22:57:50','0000-00-00 00:00:00'),(11,'测试数3452据1','123123123','21321312','312312321','空闲','普通',NULL,NULL,'2018-11-14 22:57:50','0000-00-00 00:00:00'),(12,'测试2452数据1','123123123','21321312','312312321','空闲','普通',NULL,NULL,'2018-11-14 22:57:50','0000-00-00 00:00:00'),(13,'测52435试数据1','123123123','21321312','312312321','空闲','普通',NULL,NULL,'2018-11-14 22:57:50','0000-00-00 00:00:00'),(14,'测试2534数据1','123123123','21321312','312312321','空闲','普通',NULL,NULL,'2018-11-14 22:57:50','0000-00-00 00:00:00'),(15,'测5435试数据1','123123123','21321312','312312321','空闲','普通',NULL,11,'2018-11-14 22:57:50','2018-12-30 16:03:00'),(16,'测试数据12','123123123','21321312','312312321','空闲','普通',NULL,12,'2018-11-14 22:58:06','2018-12-30 16:05:01'),(17,'测试数据1213','123123123','21321312','312312321','空闲','普通',NULL,NULL,'2018-11-14 22:58:06','0000-00-00 00:00:00'),(18,'测试数据1213','123123123','21321312','312312321','空闲','普通',NULL,NULL,'2018-11-14 22:58:06','0000-00-00 00:00:00'),(19,'测试数据133425','123123123','21321312','312312321','空闲','普通',NULL,NULL,'2018-11-14 22:58:06','0000-00-00 00:00:00'),(20,'测试数据321','123123123','21321312','312312321','空闲','普通',NULL,10,'2018-11-14 22:58:06','2018-12-30 16:00:23'),(21,'测试数234532据1','123123123','21321312','312312321','空闲','普通',NULL,NULL,'2018-11-14 22:58:06','0000-00-00 00:00:00'),(22,'测试数2543据1','123123123','21321312','312312321','空闲','普通',NULL,13,'2018-11-14 22:58:06','2018-12-30 16:05:42'),(23,'测试23523数据1','123123123','21321312','312312321','空闲','普通',NULL,NULL,'2018-11-14 22:58:06','0000-00-00 00:00:00'),(24,'测试43424523数据1','123123123','21321312','312312321','空闲','普通',NULL,NULL,'2018-11-14 22:58:06','0000-00-00 00:00:00'),(25,'测试数3452据1','123123123','21321312','312312321','空闲','普通',NULL,8,'2018-11-14 22:58:06','2018-12-30 15:36:46'),(26,'测试2452数据1','123123123','21321312','312312321','空闲','普通',NULL,9,'2018-11-14 22:58:06','2018-12-30 15:42:11'),(27,'李延喜','123123123','21321312','312312321','离职','普通',NULL,NULL,'2018-11-14 22:58:06','2018-11-25 10:35:33'),(28,'陈岩测试','123123123','21321312','312312321','休假','普通',NULL,NULL,'2018-11-14 22:58:06','2018-11-25 09:54:17'),(29,'陈三十','123123123','213213122121','312312321','工作','临时',NULL,6,'2018-11-14 22:58:06','2018-11-25 10:32:40'),(30,'陈岩','130480','21321312','66666666','工作','普通',NULL,1,'2018-11-14 23:04:26','0000-00-00 00:00:00'),(31,'陈岩是个大帅哥','213123123','9999999999','312313123','休假','临时',NULL,1,'2018-11-25 13:16:03','2018-11-25 13:16:03'),(32,'韩红','12345678','12345678','12345678','空闲','普通',NULL,7,'2018-12-28 10:12:03','2018-12-28 10:12:03'),(33,'陈岩','13048062053','674462865','77787777','空闲','普通',NULL,15,'2018-12-30 16:27:07','2018-12-30 16:27:07');

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='机器信息表';

#
# Data for table "bean_machine"
#

INSERT INTO `bean_machine` VALUES (1,1,'AC9001','09 30','陈岩','分歧',1321,32231,'报废',32232.00,'23421',NULL,NULL,'2018-12-01 08:59:04','0000-00-00 00:00:00','0000-00-00 00:00:00','0000-00-00 00:00:00'),(2,1,'ASD','3011','WFQEW','一次性',2342,1234123,'空闲',21313.00,'123',1,NULL,'2018-12-01 09:27:50',NULL,NULL,NULL);

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
  `brand_id` int(11) unsigned DEFAULT NULL COMMENT '品牌',
  `model` varchar(32) NOT NULL DEFAULT '' COMMENT '型号',
  `name` varchar(50) DEFAULT NULL,
  `picture` varchar(100) DEFAULT NULL COMMENT '型号照片',
  `detail` varchar(256) DEFAULT NULL COMMENT '详细描述',
  `resource_id` int(11) DEFAULT NULL COMMENT '资源ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='机器类型表';

#
# Data for table "bean_machine_type"
#

INSERT INTO `bean_machine_type` VALUES (1,1,'ASD01','小型挖掘机',NULL,'大马力',NULL),(2,1,'AAC','大型挖掘机',NULL,'为全球',NULL),(3,1,'BUZZK','测试挖掘机','','qwerwqerwqerwe rcqwecgwegewrewrecqw',NULL),(4,2,'BUZZK','测试挖掘机','','qwerqwgeryuj',NULL),(5,1,'ADSFSADF','测试挖掘机','','ewgeytjtirmenrt',NULL),(6,2,'SDFAD','测试挖掘机','','wegwgwt',NULL),(7,1,'REHTY','测试挖掘机','','',NULL),(8,1,'WEQRQWR','测试挖掘机','','',NULL),(9,1,'JTYJU','测试挖掘机','','',NULL);

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
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='后勤人员表';

#
# Data for table "bean_support"
#

INSERT INTO `bean_support` VALUES (1,'黄俊强','21121211212撒','空闲','普通',3,NULL,'2018-12-26 10:16:07','2018-12-26 10:24:33'),(2,'谢晓航','234234124阿萨大','空闲','普通',2,4,'2018-12-26 10:16:35','2018-12-26 10:24:06');

#
# Structure for table "com_customer_contact"
#

CREATE TABLE `com_customer_contact` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) unsigned DEFAULT NULL,
  `contact_id` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='bean_customer_contacts';

#
# Data for table "com_customer_contact"
#

INSERT INTO `com_customer_contact` VALUES (2,26,18),(4,34,26);

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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='公共资源表';

#
# Data for table "com_resource"
#

INSERT INTO `com_resource` VALUES (1,'ASD','trunk',NULL,0,NULL,'2018-12-30 20:16:34','2018-12-30 20:16:34'),(2,'MINI.jpg','jpg','resource/uploadFiles/机器信息/null_1/MINI.jpg',22250,1,'2018-12-30 20:16:40','2018-12-30 20:16:40'),(3,'陈岩_v3.docx','docx','resource/uploadFiles/机器信息/null_1/陈岩_v3.docx',19413,1,'2018-12-30 20:16:47','2018-12-30 20:16:47'),(4,'谢晓航','trunk',NULL,0,NULL,'2018-12-30 20:36:54','2018-12-30 20:36:54'),(5,'MINI.jpg','jpg','resource/uploadFiles/后勤信息/谢晓航_4/MINI.jpg',22250,4,'2018-12-30 20:36:58','2018-12-30 20:36:58'),(6,'测试数据12','trunk',NULL,0,NULL,'2018-12-30 20:38:04','2018-12-30 20:38:04'),(7,'陈岩_v1.docx','docx','resource/uploadFiles/机手信息/测试数据12_6/陈岩_v1.docx',17811,6,'2018-12-30 20:38:11','2018-12-30 20:38:11'),(8,'Dustone科技有限公司','trunk',NULL,0,NULL,'2018-12-30 21:30:44','2018-12-30 21:30:44'),(9,'DSC_4407.JPG','JPG','resource/uploadFiles/客户信息/Dustone科技有限公司_8/DSC_4407.JPG',78665,8,'2018-12-30 21:30:48','2018-12-30 21:30:48'),(10,'中铁十三局','trunk',NULL,0,NULL,'2018-12-30 21:31:28','2018-12-30 21:31:28'),(11,'陈岩_v3.docx','docx','resource/uploadFiles/客户信息/中铁十三局_10/陈岩_v3.docx',19413,10,'2018-12-30 21:31:20','2018-12-30 21:31:20'),(12,'陈岩_v4.docx','docx','resource/uploadFiles/客户信息/中铁十三局_10/陈岩_v4.docx',20558,10,'2018-12-30 21:31:23','2018-12-30 21:31:23');

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
  `log_mode` int(11) DEFAULT NULL COMMENT '日志状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='异常申报表';

#
# Data for table "log_error"
#


#
# Structure for table "log_maintain"
#

CREATE TABLE `log_maintain` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '维修单ID',
  `support_id` int(11) NOT NULL DEFAULT '0' COMMENT '后勤人员ID',
  `machine_id` int(11) NOT NULL DEFAULT '0' COMMENT '机器ID',
  `type` varchar(16) DEFAULT NULL COMMENT '维修类型',
  `money` double DEFAULT NULL COMMENT '维修金额',
  `details` varchar(256) DEFAULT NULL COMMENT '维修详情',
  `resource_id` int(11) DEFAULT NULL COMMENT '资源ID',
  `log_mode` int(11) DEFAULT NULL COMMENT '日志状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `start_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='维修表';

#
# Data for table "log_maintain"
#


#
# Structure for table "log_oil"
#

CREATE TABLE `log_oil` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '加油ID',
  `support_id` int(11) NOT NULL DEFAULT '0' COMMENT '后勤ID',
  `machine_id` int(11) NOT NULL DEFAULT '0' COMMENT '机器ID',
  `litre` int(11) NOT NULL DEFAULT '0' COMMENT '加油量',
  `money` int(11) NOT NULL DEFAULT '0' COMMENT '加油金额',
  `details` varchar(256) DEFAULT NULL COMMENT '详细描述',
  `resource_id` int(11) DEFAULT NULL COMMENT '资源ID',
  `log_mode` int(11) DEFAULT NULL COMMENT '日志状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "log_oil"
#


#
# Structure for table "log_transport"
#

CREATE TABLE `log_transport` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '转场单',
  `support_id` int(11) NOT NULL DEFAULT '0' COMMENT '后勤人员ID',
  `machine_id` int(11) NOT NULL DEFAULT '0' COMMENT '机器ID',
  `departure` varchar(256) DEFAULT NULL COMMENT '起点',
  `destination` varchar(256) DEFAULT NULL COMMENT '终点',
  `type` varchar(16) DEFAULT NULL COMMENT '类型',
  `money` double DEFAULT NULL COMMENT '转场金额',
  `details` varchar(256) DEFAULT NULL COMMENT '描述',
  `resource_id` int(11) DEFAULT NULL COMMENT '资源ID',
  `log_mode` int(11) DEFAULT NULL COMMENT '状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `start_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "log_transport"
#


#
# Structure for table "log_work"
#

CREATE TABLE `log_work` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '工单ID',
  `driver_id` int(11) NOT NULL DEFAULT '0' COMMENT '司机ID',
  `machine_id` int(11) NOT NULL DEFAULT '0' COMMENT '机器ID',
  `compact_id` int(11) NOT NULL DEFAULT '0' COMMENT '合约ID',
  `type` varchar(16) DEFAULT NULL COMMENT '类型',
  `money` double DEFAULT NULL COMMENT '金额',
  `details` varchar(256) DEFAULT NULL COMMENT '描述',
  `resource_id` int(11) DEFAULT NULL COMMENT '资源ID',
  `log_mode` int(11) DEFAULT NULL COMMENT '状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `start_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "log_work"
#


#
# Structure for table "service_compact"
#

CREATE TABLE `service_compact` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL,
  `customer_id` int(11) NOT NULL,
  `type` int(11) NOT NULL DEFAULT '0',
  `deposit` double NOT NULL,
  `full_amount` double NOT NULL,
  `limit_time` int(11) NOT NULL,
  `title` varchar(128) DEFAULT NULL,
  `details` varchar(256) DEFAULT NULL,
  `resource_id` int(11) DEFAULT NULL,
  `service_mode` int(11) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `start_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  KEY `COMPACT_CUSTOMER` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "service_compact"
#


#
# Structure for table "com_work_compact"
#

CREATE TABLE `com_work_compact` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `compact_id` int(11) NOT NULL,
  `work_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `COM_COMPACT` (`compact_id`),
  KEY `COM_WORK` (`work_id`),
  CONSTRAINT `COM_COMPACT` FOREIGN KEY (`compact_id`) REFERENCES `service_compact` (`id`),
  CONSTRAINT `COM_WORK` FOREIGN KEY (`work_id`) REFERENCES `log_work` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工单-合约链接表';

#
# Data for table "com_work_compact"
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "service_intention"
#


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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

#
# Data for table "sys_drawer"
#

INSERT INTO `sys_drawer` VALUES (1,'基础','folder_shared',NULL,NULL),(2,'机手管理','account_box','http://127.0.0.1:8848/font-page-suit/templates/admin/pages/driverList.html',1),(3,'客户管理','people','http://127.0.0.1:8848/font-page-suit/templates/admin/pages/customerList.html',1),(4,'机器管理','android','http://127.0.0.1:8848/font-page-suit/templates/admin/pages/machineList.html',1),(5,'机器型号管理','style','http://127.0.0.1:8848/font-page-suit/templates/admin/pages/machineTypeList.html',1),(6,'后勤管理','assignment','http://127.0.0.1:8848/font-page-suit/templates/admin/pages/supportList.html',1),(7,'日志','event_note',NULL,NULL),(8,'异常','error',NULL,7),(9,'维修单','loop',NULL,7),(10,'加油单','local_drink',NULL,7),(11,'转场单','airport_shuttle',NULL,7),(12,'工单','work',NULL,7),(13,'业务','info',NULL,NULL),(14,'合同','hourglass_full',NULL,13),(15,'客户意向','assistant_photo',NULL,13);
