# Host: localhost  (Version: 5.5.15)
# Date: 2018-08-21 21:16:14
# Generator: MySQL-Front 5.3  (Build 4.269)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "bean_customer"
#

CREATE TABLE `bean_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `leader` varchar(32) NOT NULL,
  `person_id` varchar(32) DEFAULT NULL,
  `tel` varchar(32) DEFAULT NULL,
  `type` varchar(32) DEFAULT '意向客户',
  `status` varchar(32) DEFAULT NULL,
  `detail` varchar(256) DEFAULT NULL,
  `resource_id` int(11) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "bean_customer"
#


#
# Structure for table "bean_driver"
#

CREATE TABLE `bean_driver` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) NOT NULL,
  `tel` varchar(16) NOT NULL,
  `person_id` varchar(32) NOT NULL,
  `paper_id` varchar(32) DEFAULT NULL,
  `credit_card` varchar(32) NOT NULL,
  `status` int(3) DEFAULT '0',
  `type` varchar(16) DEFAULT '临时机手',
  `resource_id` int(11) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "bean_driver"
#


#
# Structure for table "bean_machine_type"
#

CREATE TABLE `bean_machine_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brand` varchar(32) NOT NULL,
  `model` varchar(32) NOT NULL,
  `detail` varchar(256) DEFAULT NULL,
  `resource_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "bean_machine_type"
#


#
# Structure for table "bean_machine"
#

CREATE TABLE `bean_machine` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tid` int(11) NOT NULL,
  `code` varchar(32) NOT NULL,
  `status` int(3) DEFAULT '0',
  `worktime` int(8) DEFAULT NULL,
  `xyz` varchar(64) DEFAULT NULL,
  `resource_id` int(11) DEFAULT NULL,
  `detail` varchar(256) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `birth` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  KEY `MACHINE_TYPE` (`tid`),
  CONSTRAINT `MACHINE_TYPE` FOREIGN KEY (`tid`) REFERENCES `bean_machine_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "bean_machine"
#


#
# Structure for table "bean_support"
#

CREATE TABLE `bean_support` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) NOT NULL,
  `tel` varchar(16) NOT NULL,
  `status` int(3) DEFAULT '0',
  `type` varchar(16) DEFAULT '普通后勤',
  `resource_id` int(11) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "bean_support"
#


#
# Structure for table "com_resource"
#

CREATE TABLE `com_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  `type` varchar(16) NOT NULL,
  `url` varchar(512) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "com_resource"
#


#
# Structure for table "log_error"
#

CREATE TABLE `log_error` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `driver_id` int(11) DEFAULT NULL,
  `support_id` int(11) DEFAULT NULL,
  `machine_id` int(11) DEFAULT NULL,
  `type` varchar(16) DEFAULT NULL,
  `title` varchar(128) DEFAULT NULL,
  `details` varchar(256) DEFAULT NULL,
  `resource_id` int(11) DEFAULT NULL,
  `log_mode` int(3) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "log_error"
#


#
# Structure for table "log_maintain"
#

CREATE TABLE `log_maintain` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `support_id` int(11) NOT NULL,
  `machine_id` int(11) NOT NULL,
  `type` varchar(16) DEFAULT NULL,
  `money` double NOT NULL,
  `details` varchar(256) DEFAULT NULL,
  `resource_id` int(11) DEFAULT NULL,
  `log_mode` int(3) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `start_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  KEY `MAINTAIN_SUPPORT` (`support_id`),
  KEY `MAINTAIN_MACHINE` (`machine_id`),
  CONSTRAINT `MAINTAIN_MACHINE` FOREIGN KEY (`machine_id`) REFERENCES `bean_machine` (`id`),
  CONSTRAINT `MAINTAIN_SUPPORT` FOREIGN KEY (`support_id`) REFERENCES `bean_support` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "log_maintain"
#


#
# Structure for table "log_oil"
#

CREATE TABLE `log_oil` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `support_id` int(11) NOT NULL,
  `machine_id` int(11) NOT NULL,
  `litre` int(11) NOT NULL,
  `money` int(11) NOT NULL,
  `details` varchar(256) DEFAULT NULL,
  `resource_id` int(11) DEFAULT NULL,
  `log_mode` int(3) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  KEY `OIL_SUPPORT` (`support_id`),
  KEY `OIL_MACHINE` (`machine_id`),
  CONSTRAINT `OIL_MACHINE` FOREIGN KEY (`machine_id`) REFERENCES `bean_machine` (`id`),
  CONSTRAINT `OIL_SUPPORT` FOREIGN KEY (`support_id`) REFERENCES `bean_support` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "log_oil"
#


#
# Structure for table "log_transport"
#

CREATE TABLE `log_transport` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `support_id` int(11) NOT NULL,
  `machine_id` int(11) NOT NULL,
  `departure` varchar(256) DEFAULT NULL,
  `destination` varchar(256) DEFAULT NULL,
  `type` varchar(16) DEFAULT NULL,
  `money` double NOT NULL,
  `details` varchar(256) DEFAULT NULL,
  `resource_id` int(11) DEFAULT NULL,
  `log_mode` int(3) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `start_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  KEY `TRANSPORT_SUPPORT` (`support_id`),
  KEY `TRANSPORT_MACHINE` (`machine_id`),
  CONSTRAINT `TRANSPORT_MACHINE` FOREIGN KEY (`machine_id`) REFERENCES `bean_machine` (`id`),
  CONSTRAINT `TRANSPORT_SUPPORT` FOREIGN KEY (`support_id`) REFERENCES `bean_support` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "log_transport"
#


#
# Structure for table "service_compact"
#

CREATE TABLE `service_compact` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL,
  `customer_id` int(11) NOT NULL,
  `type` varchar(16) DEFAULT '一般合同',
  `deposit` double NOT NULL,
  `full_amount` double NOT NULL,
  `limit_time` int(11) NOT NULL,
  `title` varchar(128) DEFAULT NULL,
  `details` varchar(256) DEFAULT NULL,
  `resource_id` int(11) DEFAULT NULL,
  `service_mode` int(3) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `start_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  KEY `COMPACT_CUSTOMER` (`customer_id`),
  CONSTRAINT `COMPACT_CUSTOMER` FOREIGN KEY (`customer_id`) REFERENCES `bean_customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "service_compact"
#


#
# Structure for table "log_work"
#

CREATE TABLE `log_work` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `driver_id` int(11) NOT NULL,
  `machine_id` int(11) NOT NULL,
  `compact_id` int(11) NOT NULL,
  `type` varchar(16) DEFAULT NULL,
  `money` double NOT NULL,
  `details` varchar(256) DEFAULT NULL,
  `resource_id` int(11) DEFAULT NULL,
  `log_mode` int(3) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `start_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  KEY `WORK_DRIVER` (`driver_id`),
  KEY `WORK_MACHINE` (`machine_id`),
  KEY `WORK_COMPACT` (`compact_id`),
  CONSTRAINT `WORK_COMPACT` FOREIGN KEY (`compact_id`) REFERENCES `service_compact` (`id`),
  CONSTRAINT `WORK_DRIVER` FOREIGN KEY (`driver_id`) REFERENCES `bean_driver` (`id`),
  CONSTRAINT `WORK_MACHINE` FOREIGN KEY (`machine_id`) REFERENCES `bean_machine` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "log_work"
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
  CONSTRAINT `COM_WORK` FOREIGN KEY (`work_id`) REFERENCES `log_work` (`id`),
  CONSTRAINT `COM_COMPACT` FOREIGN KEY (`compact_id`) REFERENCES `service_compact` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `service_mode` int(3) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `edit_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `start_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`),
  KEY `INTENT_CUSTOMER` (`customer_id`),
  CONSTRAINT `INTENT_CUSTOMER` FOREIGN KEY (`customer_id`) REFERENCES `bean_customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "service_intention"
#

