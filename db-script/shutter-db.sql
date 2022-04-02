/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : shutter

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 31/03/2022 17:55:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`
(
    `id`              bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '主键',
    `tenant_id`       bigint(20)   NOT NULL DEFAULT '0' COMMENT '租户主键',
    `user_id`         bigint(20)   NOT NULL DEFAULT '未登录' COMMENT '用户主键',
    `start_time`      timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '开始时间',
    `url`             varchar(128) NOT NULL COMMENT '请求地址',
    `uri`             varchar(128) NOT NULL COMMENT '请求资源',
    `method`          varchar(16)  NOT NULL COMMENT '请求方式',
    `ip`              varchar(32)  NOT NULL COMMENT '请求IP地址',
    `class_name`      varchar(256) NOT NULL COMMENT '请求类名',
    `method_name`     varchar(32)  NOT NULL COMMENT '请求方法名',
    `params`          text COMMENT '请求路径参数',
    `args`            text COMMENT '请求方法参数',
    `result`          text COMMENT '返回值',
    `error`           text COMMENT '异常',
    `exe_time`        bigint(20)   NOT NULL COMMENT '执行时间',
    `browser`         varchar(32)           DEFAULT NULL COMMENT '浏览器',
    `browser_version` varchar(32)           DEFAULT NULL COMMENT '浏览器版本',
    `platform`        varchar(32)           DEFAULT NULL COMMENT '平台',
    `os`              varchar(32)           DEFAULT NULL COMMENT '操作系统',
    `os_version`      varchar(32)           DEFAULT NULL COMMENT '操作系统版本',
    `engine`          varchar(32)           DEFAULT NULL COMMENT '引擎',
    `engine_version`  varchar(32)           DEFAULT NULL COMMENT '引擎版本',
    `module`          varchar(16)  NOT NULL COMMENT '模块名称',
    `func`            varchar(16)  NOT NULL COMMENT '功能名称',
    `remark`          varchar(32)  NOT NULL COMMENT '功能描述',
    `action`          varchar(16)  NOT NULL COMMENT '动作描述',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 11
  DEFAULT CHARSET = utf8mb4;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`
(
    `id`           bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '主键',
    `tenant_id`    bigint(20)   NOT NULL DEFAULT '0' COMMENT '租户主键',
    `account`      varchar(32)           DEFAULT NULL COMMENT '账号',
    `password`     varchar(60)           DEFAULT NULL COMMENT '密码',
    `phone_number` varchar(32)           DEFAULT NULL COMMENT '手机号',
    `email`        varchar(128)          DEFAULT NULL COMMENT '邮箱',
    `chinese_name` varchar(8)   NOT NULL DEFAULT '' COMMENT '中文名',
    `english_name` varchar(64)  NOT NULL DEFAULT '' COMMENT '英文名',
    `nick_name`    varchar(32)  NOT NULL DEFAULT '' COMMENT '昵称',
    `birthday`     date         NOT NULL DEFAULT '1990-01-01' COMMENT '生日',
    `gender`       tinyint(2)   NOT NULL DEFAULT '0' COMMENT '性别',
    `avatar`       varchar(256) NOT NULL DEFAULT '' COMMENT '头像地址',
    `status`       tinyint(2)   NOT NULL DEFAULT '1' COMMENT '状态：0=禁用；1=启用。',
    `regedit_ip`   varchar(16)  NOT NULL DEFAULT '' COMMENT '注册IP',
    `login_ip`     varchar(16)  NOT NULL DEFAULT '' COMMENT '登录IP',
    `login_time`   timestamp    NULL     DEFAULT NULL COMMENT '登录时间',
    `deleted`      tinyint(1)   NOT NULL DEFAULT '0' COMMENT '是否删除',
    `create_user`  bigint(20)            DEFAULT NULL COMMENT '创建人',
    `create_time`  timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_user`  bigint(20)            DEFAULT NULL COMMENT '修改人',
    `modify_time`  timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 7
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = DYNAMIC COMMENT ='系统用户表';

SET FOREIGN_KEY_CHECKS = 1;
