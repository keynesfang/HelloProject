/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.7.19 : Database - security
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`security` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `security`;

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `menuid` int(10) NOT NULL AUTO_INCREMENT,
  `menuname` varchar(20) NOT NULL,
  `menupath` varchar(100) NOT NULL DEFAULT '-',
  `menustatus` varchar(10) NOT NULL DEFAULT 'enable',
  `menutype` varchar(20) NOT NULL,
  PRIMARY KEY (`menuid`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `menu` */

insert  into `menu`(`menuid`,`menuname`,`menupath`,`menustatus`,`menutype`) values (1,'权限管理','/right','enable','system'),(2,'用户管理','/user','enable','system'),(3,'安监地图导航','/map','enable','map'),(4,'录入管理','/basic','enable','basic'),(5,'审核管理','/basic','enable','basic'),(6,'菜单管理','/safety/module/menu/menu_manage.html','enable','system'),(7,'地图导航','-','enable','map'),(8,'基础信息','-','enable','basic'),(9,'系统管理','-','enable','system');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userid` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `userpass` varchar(100) NOT NULL,
  `userright` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`userid`,`username`,`userpass`,`userright`) values (1,'admin','123123',NULL),(2,'测试员','123',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
