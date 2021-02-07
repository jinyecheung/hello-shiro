/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 10.2.36-MariaDB : Database - hello_shiro
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hello_shiro` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hello_shiro`;

/*Table structure for table `t_sys_menu` */

DROP TABLE IF EXISTS `t_sys_menu`;

CREATE TABLE `t_sys_menu` (
  `menu_id` varchar(128) DEFAULT NULL,
  `menu_code` varchar(128) DEFAULT NULL,
  `menu_name` varchar(128) DEFAULT NULL,
  `parent_menu_id` varchar(128) DEFAULT NULL,
  `menu_type` varchar(8) DEFAULT NULL,
  `menu_url` varchar(256) DEFAULT NULL,
  `show_flag` varchar(2) DEFAULT '0',
  `delete_flag` varchar(2) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_menu` */

insert  into `t_sys_menu`(`menu_id`,`menu_code`,`menu_name`,`parent_menu_id`,`menu_type`,`menu_url`,`show_flag`,`delete_flag`) values 
('2e5e029b4c6e4b079cb7b31f49de82ca','userMenage','用户管理','','1','1','1','1'),
('4860aea9ca054a659c71bdb734cf97c0','menuManage','菜单管理','','1','1','1','1'),
('26944759f4e14f14a07ce8c0f8e77a3b','permissionManage','权限管理','','1','1','1','1'),
('0c6e2ec02b0c4b2284a9d0ec24e30d10','menuManageAdd','菜单新增','4860aea9ca054a659c71bdb734cf97c0','2','/menu/menuAdd','2','2'),
('a9bfa577aeed4a9a850c5885d9f5ccf4','menuManageUpdate','菜单修改','4860aea9ca054a659c71bdb734cf97c0','2','2','1','1'),
('3d6e45fb93ad4fcaaa70d43c1d0e489e','userMenageQuery','用户查询','2e5e029b4c6e4b079cb7b31f49de82ca','2','/user/userList','2','2'),
('92f9b0cbb1644c8094ef3ceeda3a5e45','userMenageAdd','用户新增','2e5e029b4c6e4b079cb7b31f49de82ca','2','/user/add','2','2'),
('90adde98860744f986f02a27f103b0c1','userMenageUpdate','用户修改','2e5e029b4c6e4b079cb7b31f49de82ca','2','2','2','2'),
('bddab7ab979144669808f52086153960','menuManageQuery','菜单查询','4860aea9ca054a659c71bdb734cf97c0','3','/menu/list','3','3'),
('ff1ee4b7c1b94588a8291642cfa82580','permissionManageAdd','权限新增','26944759f4e14f14a07ce8c0f8e77a3b','1','/permission/permissionAdd','1','1'),
('c537eb6c206f48d9943c1c8b6d68a22b','permissionManageQry','权限查询','26944759f4e14f14a07ce8c0f8e77a3b','1','/permission/list','1','1'),
('5e2b5e32ef124359b07af8f72390a51a','permissionManageUpd','权限修改','26944759f4e14f14a07ce8c0f8e77a3b','1','1','1','1'),
('28da59fcb48e40bd9d877c652710ec88','userMenageDelete','用户删除','2e5e029b4c6e4b079cb7b31f49de82ca','1','1','1','1');

/*Table structure for table `t_sys_permission` */

DROP TABLE IF EXISTS `t_sys_permission`;

CREATE TABLE `t_sys_permission` (
  `permission_id` varchar(64) DEFAULT NULL,
  `permission_code` varchar(128) DEFAULT NULL,
  `permission_name` varchar(64) DEFAULT NULL,
  `permission_type` varchar(5) DEFAULT NULL COMMENT '权限类型：1-功能权限，2-数据权限',
  `delete_flag` varchar(5) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_permission` */

insert  into `t_sys_permission`(`permission_id`,`permission_code`,`permission_name`,`permission_type`,`delete_flag`) values 
('20210201165128','user:add','user:add','2','0'),
('26f1f4384ea84f508349f46405cf3abc','user:update','user:update','1','0'),
('e9610e991271446e81adf68996039e8d','user:update1','user:update1','1','1'),
('f02c280fa6f945318d80c5ae013595f5','user:update2','user:update2','1','0'),
('1b7c0c993fcd439fbec9e037594dbae5','user:update3','user:update3','1','1'),
('4dc48cd1196a4bcdb6d9e0f6ddd00198',NULL,NULL,NULL,'1'),
('5f6a1385c04f43889348fdd56008b60a',NULL,NULL,NULL,'1');

/*Table structure for table `t_sys_role` */

DROP TABLE IF EXISTS `t_sys_role`;

CREATE TABLE `t_sys_role` (
  `role_id` varchar(128) DEFAULT NULL,
  `role_code` varchar(128) DEFAULT NULL,
  `role_name` varchar(128) DEFAULT NULL,
  `delete_flag` varchar(2) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_role` */

insert  into `t_sys_role`(`role_id`,`role_code`,`role_name`,`delete_flag`) values 
('20210129145942','admin','adminRole','0'),
('20210129145954','guest','guestRole','0');

/*Table structure for table `t_sys_role_rel` */

DROP TABLE IF EXISTS `t_sys_role_rel`;

CREATE TABLE `t_sys_role_rel` (
  `id` varchar(128) DEFAULT NULL,
  `role_id` varchar(128) DEFAULT NULL,
  `menu_id` varchar(128) DEFAULT NULL,
  `permission_id` varchar(128) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_role_rel` */

/*Table structure for table `t_sys_user` */

DROP TABLE IF EXISTS `t_sys_user`;

CREATE TABLE `t_sys_user` (
  `user_id` varchar(128) DEFAULT NULL,
  `user_name` varchar(128) DEFAULT NULL,
  `pass_word` varchar(128) DEFAULT NULL,
  `phone` varchar(64) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_user` */

insert  into `t_sys_user`(`user_id`,`user_name`,`pass_word`,`phone`,`email`) values 
('13123123','勤勤AK147','123456','13112332123','123'),
('13123123','勤勤AK258','111111','15131232123','456'),
('ea67980de8c04f90a19824db695936b2','AKAKAKAK','112233','13000885678','789'),
('b580e0acb247475fbfb6873f3cc13e7f','akww','123456','13909876767','098'),
('e994a263033f4122a795c1129975fe47','admin','123456','15876554564','abcd'),
('5c0dee4e-8956-404a-99a0-0857d39d4c3b','zhangjinpei','123','123','123'),
('9e1d64e5-9b18-43fc-9eb0-80240f1c2a29','zhangjinpei','','123','123'),
('68edffc6-bdd4-4296-988d-06ee57c0df9f','akwwnpd','111','123','123'),
('b9493a4e-bbf1-4024-8ee0-b57394e318ac','akwwnpd','','123','123'),
('99cf88a2-3d22-4e3a-9976-5545778c393e','akwwnpd','','123','123'),
('f74d7d3a-6e19-4f96-bd4e-ca8fc43b908a','akwwnpd','','123','123'),
('45241e31-fb1d-419e-8056-3c87094177e6','akwwnpd','','123','123'),
('87ef027d-8e77-4f85-bc45-6aa9b7befacf','akwwnpd','','123','123'),
('d36b7998-25c2-48f3-bf93-b7f383b53098','akwwnpd','222','123','123'),
('16919e1d-2aa3-4b10-89e0-c496a0483149','akwwnpd','','123','123'),
('c27ccffe-fef3-494d-849e-2cff11e1c055','akwwnpd','','123','123'),
('50c9eb75-cad8-400c-a522-3a99fa7d0c04','akwwnpd','','123','123'),
('9da3047f-5a42-4cab-8d36-c6c796ed3d9b','akwwnpd','','123','123'),
('c8bfd9ca-dbf2-49c4-8400-afef0c4b6784','akwwnpd','','123','123'),
('9a867934-9e80-4adc-b3ff-fdb1faf7648c','akwwnpd','','123','123'),
('6f18e530-c08a-4b16-bc4d-e134bf10c1b0','123','123','123123123','11111111'),
('4ca48079-4b4b-44e8-be4d-7a19829e654e','123','999','999','999'),
('e86d5879-99bd-488c-846d-04bbc7259308','123','000','123','11111111'),
('44cccac1-adeb-4574-a752-77ea84eade97','akwwnpd','888','123888','123888'),
('9e13d561-6d11-4485-a2e0-c2afe0d49087','33333','333','333','3333'),
('e2f897765b604c4593708746be8923cd','','','',''),
('230c32e37a064c2aad0c2f0458e71f95','','','','');

/*Table structure for table `t_sys_user_rel` */

DROP TABLE IF EXISTS `t_sys_user_rel`;

CREATE TABLE `t_sys_user_rel` (
  `id` varchar(128) DEFAULT NULL,
  `user_id` varchar(128) DEFAULT NULL,
  `role_id` varchar(128) DEFAULT NULL,
  `menu_id` varchar(128) DEFAULT NULL,
  `permission_id` varchar(128) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_user_rel` */

insert  into `t_sys_user_rel`(`id`,`user_id`,`role_id`,`menu_id`,`permission_id`) values 
('20210129150124','e994a263033f4122a795c1129975fe47','20210129145942',NULL,NULL),
('20210201165221','e994a263033f4122a795c1129975fe47',NULL,NULL,'20210201165128');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
