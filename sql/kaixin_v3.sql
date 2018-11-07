# Host: localhost  (Version: 5.5.15)
# Date: 2018-10-27 08:53:35
# Generator: MySQL-Front 5.3  (Build 4.269)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "bean_customer"
#

CREATE TABLE `bean_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户标识',
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '客户公司名称',
  `leader` varchar(32) NOT NULL DEFAULT '' COMMENT '客户负责人',
  `person_id` varchar(32) DEFAULT NULL COMMENT '客户负责人身份证号码',
  `tel` varchar(32) DEFAULT NULL COMMENT '客户负责人联系电话',
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '客户类型',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '客户状态',
  `detail` varchar(256) DEFAULT NULL COMMENT '客户描述',
  `resource_id` int(11) DEFAULT NULL COMMENT '资源ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "bean_driver"
#

CREATE TABLE `bean_driver` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '机手ID',
  `name` varchar(16) NOT NULL DEFAULT '' COMMENT '机手姓名',
  `tel` varchar(16) NOT NULL DEFAULT '' COMMENT '机手联系电话',
  `person_id` varchar(32) NOT NULL DEFAULT '' COMMENT '身份证号码',
  `paper_id` varchar(32) DEFAULT NULL COMMENT '驾驶许可证号码',
  `credit_card` varchar(32) DEFAULT '' COMMENT '银行卡号码',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '机手状态',
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '机手类型',
  `resource_id` int(11) DEFAULT NULL COMMENT '资源ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "bean_machine"
#

CREATE TABLE `bean_machine` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '机器ID',
  `tid` int(11) NOT NULL DEFAULT '0' COMMENT '机器型号ID',
  `code` varchar(32) NOT NULL DEFAULT '' COMMENT '机器自编号',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '状态',
  `worktime` int(11) DEFAULT NULL COMMENT '工作时间',
  `xyz` varchar(64) DEFAULT NULL COMMENT 'GPS坐标',
  `resource_id` int(11) DEFAULT NULL COMMENT '资源ID',
  `detail` varchar(256) DEFAULT NULL COMMENT '详细备注',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `birth` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  KEY `MACHINE_TYPE` (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "bean_machine_type"
#

CREATE TABLE `bean_machine_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '机器型号ID',
  `brand` varchar(32) NOT NULL DEFAULT '' COMMENT '品牌',
  `model` varchar(32) NOT NULL DEFAULT '' COMMENT '型号',
  `detail` varchar(256) DEFAULT NULL COMMENT '详细描述',
  `resource_id` int(11) DEFAULT NULL COMMENT '资源ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "bean_support"
#

CREATE TABLE `bean_support` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '后勤ID',
  `name` varchar(16) NOT NULL DEFAULT '' COMMENT '后勤姓名',
  `tel` varchar(16) NOT NULL DEFAULT '' COMMENT '后勤电话',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '后勤状态',
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '后勤种类',
  `resource_id` int(11) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "com_resource"
#

CREATE TABLE `com_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '资源ID',
  `name` varchar(128) NOT NULL DEFAULT '' COMMENT '文件名称',
  `type` varchar(16) NOT NULL DEFAULT '' COMMENT '文件类型',
  `url` varchar(512) NOT NULL DEFAULT '' COMMENT '对应相对路径',
  `parent_id` int(11) DEFAULT NULL COMMENT '父资源ID',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "log_error"
#

CREATE TABLE `log_error` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '异常ID',
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "log_maintain"
#

CREATE TABLE `log_maintain` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '维修单ID',
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
  PRIMARY KEY (`id`),
  KEY `MAINTAIN_SUPPORT` (`support_id`),
  KEY `MAINTAIN_MACHINE` (`machine_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "log_oil"
#

CREATE TABLE `log_oil` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '加油ID',
  `support_id` int(11) NOT NULL DEFAULT '0' COMMENT '后勤ID',
  `machine_id` int(11) NOT NULL DEFAULT '0' COMMENT '机器ID',
  `litre` int(11) NOT NULL DEFAULT '0' COMMENT '加油量',
  `money` int(11) NOT NULL DEFAULT '0' COMMENT '加油金额',
  `details` varchar(256) DEFAULT NULL COMMENT '详细描述',
  `resource_id` int(11) DEFAULT NULL COMMENT '资源ID',
  `log_mode` int(11) DEFAULT NULL COMMENT '日志状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  KEY `OIL_SUPPORT` (`support_id`),
  KEY `OIL_MACHINE` (`machine_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "log_transport"
#

CREATE TABLE `log_transport` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '转场单',
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
  PRIMARY KEY (`id`),
  KEY `TRANSPORT_SUPPORT` (`support_id`),
  KEY `TRANSPORT_MACHINE` (`machine_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  PRIMARY KEY (`id`),
  KEY `WORK_DRIVER` (`driver_id`),
  KEY `WORK_MACHINE` (`machine_id`),
  KEY `WORK_COMPACT` (`compact_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
