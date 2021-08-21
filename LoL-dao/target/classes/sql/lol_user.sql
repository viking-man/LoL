DROP TABLE IF EXISTS `lol_user`;
CREATE TABLE `lol_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id，自增长',
  `user_id` varchar(32) NOT NULL DEFAULT '' COMMENT '用户id',
  `user_name` varchar(50) NOT NULL DEFAULT '' COMMENT '用户名称',
  `password` varchar(32) NOT NULL DEFAULT '' COMMENT '密码',
  `nick_name` varchar(32) NOT NULL DEFAULT '' COMMENT '昵称',
  `account_type` tinyint(3) NOT NULL DEFAULT 0 COMMENT '账号类型',
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态，0:无效，1:有效',
  `env` varchar(5) NOT NULL DEFAULT '' COMMENT '数据环境',
  `creator` varchar(32) NOT NULL DEFAULT '' COMMENT '创建者',
  `modifier` varchar(32) NOT NULL DEFAULT '' COMMENT '修改者',
  `gmt_create` bigint(13) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `gmt_modified` bigint(13) NOT NULL DEFAULT '0' COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_user_id` (`user_id`),
  KEY `idx_user_name` (`user_name`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT = '用户表##';